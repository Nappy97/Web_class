package com.lec.a005_image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

/**
 * 폰의 저장장치에 있는 사진을 ImageView 에 띄우기
 *    1. 권한 획득
 *        - 메니페스트
 *        - '위험권한'요청  (Android 6.0 / API23 이상)
 *			  https://developer.android.com/guide/topics/security/permissions?hl=ko  (위험권한및 위험권한 목록들)
 *            https://developer.android.com/training/permissions/requesting?hl=ko#java
 *
 *            설치 앱별 '권한' 확인 가능하다 :
 *                픽셀2 폰의 경우 '앱' 아이콘 롱클릭후 App Info 확인
 *
 *    2. 이미지 경로
 *    3. Bitmap 사용하여 ImageView 에 띄우기
 */


public class MainActivity3 extends AppCompatActivity {

    ImageView ivPhoto;
    TextView tvPath;
    Button btnAction;

    private String imgPath = "/storage/emulated/0/DCIM/apple.png";

    private final int PERMISSION_REQUEST_CODE = 101;   // 권한 요청 코드값

    private final String [] RERMISSIONS = {  // 요청할 권한들을 String [] 로 준비
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        ivPhoto = findViewById(R.id.ivPhoto);
        btnAction = findViewById(R.id.btnAction);
        tvPath = findViewById(R.id.tvPath);


        // '위험권한' 획득

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M  // API23 (M 마시멜로) 이상에서만 요청 수행
                &&
                // 권한을 아직 획득하지 않은 상태라면
                ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)  {

            // 권한 요청 : 비동기로 진행됨
            ActivityCompat.requestPermissions(this,
                    RERMISSIONS,    // 요청할 위험권한(들)
                    PERMISSION_REQUEST_CODE  // 권한 요청 코드
                    );
        } else {
            // 권한을 획득한 상태
            Log.d("myapp", "권한을 가진 상태입니다");
            drawPhoto();
        }

    } // end onCreate()


    // 권한 획득 결과 처리 콜백
    // requestCode : 권한 요청 코드 값
    // permissions : 권한 요청 (들)
    // grantResults : 승인 내역 (들)
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode){
            case PERMISSION_REQUEST_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // 사용자가 권한 승인함
                    Log.d("myapp", "권한획득결과\n" + Arrays.toString(permissions) + " : " + Arrays.toString(grantResults));
                    drawPhoto();
                } else {
                    // 사용자가 권한 승인 안함
                    Log.d("myapp", "권한승인거절\n" + Arrays.toString(permissions) + " : " + Arrays.toString(grantResults));
                }

                break;

        } // end switch

    } // end onRequestPermissionsResult


    public void drawPhoto(){
        Bitmap bm = BitmapFactory.decodeFile(imgPath);
        ivPhoto.setImageBitmap(bm);
        tvPath.setText(imgPath);
    }


} // end Activity













