package com.lec.a005_image;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// 안드로이드 의 모~든 리소스 (Resource) 로 사용하는 파일 들은
// 파일명 규칙
// - 대문자 불가!
// - 숫자 시작 불가!
// - 공백, 특수문자 불가!
// - 특수문자는 _ 만 가능.
public class MainActivity extends AppCompatActivity {

    int [] imageId = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6};
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = findViewById(R.id.iv1);

        // 특정 이미지 로 세팅
        iv.setImageResource(R.drawable.a3);

        iv.setOnClickListener(new MyListener());

    } // end onCreate()

    class MyListener implements View.OnClickListener{

        int i = 0;
        int length = imageId.length;
        TextView tvResult = findViewById(R.id.tvResult);

        @Override
        public void onClick(View view) {
            iv.setImageResource(imageId[i]);
            tvResult.setText("이미지뷰: " + i);

            i += 1;
            if(i == imageId.length) i = 0;
        }
    }



} // end Activity










