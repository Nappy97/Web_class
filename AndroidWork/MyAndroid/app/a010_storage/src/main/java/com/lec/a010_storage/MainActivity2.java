package com.lec.a010_storage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 외부 메모리 (External Memory 혹은 Shared storage)
 *      사용자 영역 에 저장 ( sdcard 같은 외장 메모리를 의미하는게 아니다)
 *      메모리가 장착(mount)되어 있어야 사용 가능
 *      모든 앱에서 접근 가능 (공유 가능)
 *
 * 외부 메모리에 파일 읽기/쓰기
 *      1. 외부 메모리 장치가 있는지 확인해야한다 :  getExternalStorageState()
 *      2-1 AndroidManifest.xml 외부메모리 저장권한을 선언해야 함  (API 23 이전 버젼)
 *              WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE
 *      2-2 API 23+ (마시멜로): 새로운 권한 획득 방법 사용.
 *          Run-time 에 onRequestPermissionsResult() 사용 해야 한다!!!
 *          https://developer.android.com/training/permissions/requesting.html
 *
 *     3. 읽기/쓰기 경로를 지정한다
 */


// Galaxy Nexus 의 경우
// /storage/emulated/0/Pictures 에 저장?

public class MainActivity2 extends AppCompatActivity {

    EditText etInput;
    Button btnSave, btnRead;
    TextView tvResult;

    // permission 관련 문자열들
    final String [] PERMISSIONS = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
    final int REQUEST_CODE = 100;
    
    String state;   // 외부 저장소 상태 정보를 담을 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etInput = findViewById(R.id.etInput);
        btnRead = findViewById(R.id.btnRead);
        btnSave = findViewById(R.id.btnSave);
        tvResult = findViewById(R.id.tvResult);

        // '위험권한' 획득
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M &&
            checkSelfPermission(String.valueOf(PERMISSIONS)) == PackageManager.PERMISSION_DENIED){
            requestPermissions(PERMISSIONS, REQUEST_CODE);   // 권한 요청하기
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkExternalStorage()) return;   // 외부 저장장치 사용하지 못하면 리턴

                String data = etInput.getText().toString();

                try {
                    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    File f = new File(path, "external.txt");
                    FileWriter writer = new FileWriter(f, false);
                    PrintWriter out = new PrintWriter(writer);
                    out.println(data);
                    out.close();
                    tvResult.setText("저장완료");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!checkExternalStorage()) return;

                try{
                    StringBuffer data = new StringBuffer();
                    File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    File f = new File(path, "external.txt");

                    BufferedReader reader = new BufferedReader(new FileReader(f));

                    String str = reader.readLine();
                    while(str != null){
                        data.append(str + "\n");
                        str = reader.readLine();
                    }
                    tvResult.setText(data);
                    reader.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    } // end onCreate()

    // 외부 메모리 상태 확인 메소드
    private boolean checkExternalStorage() {
        state = Environment.getExternalStorageState();
        String msg = "";

        // 외부메모리 상태
        if(Environment.MEDIA_MOUNTED.equals(state)){  // "mounted"
            // 읽기, 쓰기 모두 가능
            msg = "외부저장장치 읽기 쓰기 모두 가능:" + state;
            Log.d("myapp", msg);
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            return true;
        } else if(Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)){ // "mounted_ro"
            // 읽기 전용
            msg = "외부저장장치 읽기만 가능:" + state;
            Log.d("myapp", msg);
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            return false;
        } else {
            // 읽기 쓰기 모두 안됨
            msg = "외부저장장치 읽기쓰기 모두 불가:" + state;
            Log.d("myapp", msg);
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            return false;
        }
    }

    // 권한쵝득 결과가 오면 실행되는 메소드


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch(requestCode){
            case REQUEST_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    // 권한 승인
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    // 권한 거부
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();

                    // 권한이 없으면 더이상 진행못하도록 액티비티를 종료하는 등의 처리가 필요할수도 있다;
                    // onDestroy();
                }
                return;
        } // end switch
    }
}



















