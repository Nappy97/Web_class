package com.lec.a007_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // 화면 (layout) 이 없는 Activity

        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);

        intent.putExtra("plus", num1 + num2);
        intent.putExtra("minus", num1 - num2);

        setResult(RESULT_OK, intent);    // 호출한 화면으로 값을 되돌려 주기
               // ↑ resultCode 값


        finish();
    }


}















