package com.lec.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // onCreate() 는 액티비티가 생성된 직후 호출되는 메소드

    // setContentView() 는 이 액티비티의 화면(content view)를
    // 무엇으로 채울지 지정합니다.
    // 예제에서는 기본적으로 리소스(R) 의 activity_main2.xml 레이아웃 파일을
    // 액티비티의 content view 로 세팅합니다

    TextView tvTitle;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeText1(View v){
        ((Button)v).setText("클릭했습니다");
    }
}