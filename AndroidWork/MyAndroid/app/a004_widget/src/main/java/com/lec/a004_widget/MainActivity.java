package com.lec.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv = findViewById(R.id.tv);

        // 포커스 변화
        et1.setOnFocusChangeListener(new View.OnFocusChangeListener() {

            // 포커스가 변화되었을때 호출되는 메소드
            // hasFocus: true -> focus, false -> blur
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if(hasFocus){
                    // 포커스 되면 배경색 변경
                    ((EditText)view).setBackgroundColor(Color.YELLOW);
                } else {
                    // 포커스를 잃으면 배경색 투명
                    ((EditText)view).setBackgroundColor(Color.parseColor("#00000000"));
                }
            }
        });

        et1.setOnKeyListener(new View.OnKeyListener() {

            // 자판 키보드가 눌렸을때 동작하는 함수
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                tv.setText(((EditText)view).getText().toString());
                return false;
            }
        });

        // 값의 입력 완료되었을때
        et1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                tv.setText("완료");
                return false;
            }
        });

    } // end onCreate
}