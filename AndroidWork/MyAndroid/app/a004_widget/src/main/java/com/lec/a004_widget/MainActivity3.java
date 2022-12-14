package com.lec.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox cb1, cb2, cb3, cb4;
    TextView tvResult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        cb1 = findViewById(R.id.cb1);
        cb2 = findViewById(R.id.cb2);
        cb3 = findViewById(R.id.cb3);
        cb4 = findViewById(R.id.cb4);

        Button btnComplete = findViewById(R.id.btnComplete);
        TextView tvResult = findViewById(R.id.tvResult);
        tvResult2 = findViewById(R.id.tvResult2);

        // 버튼을 클릭하면 체크된 내용들만 출력하기
        btnComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = "";
                if(cb1.isChecked()) result += cb1.getText();
                if(cb2.isChecked()) result += cb2.getText();
                if(cb3.isChecked()) result += cb3.getText();
                if(cb4.isChecked()) result += cb4.getText();
                tvResult.setText("선택결과: " + result);
            }
        });

        // Checkbox 의 '상태'가 변경될때마다 호출되는 리스너
        cb1.setOnCheckedChangeListener(this);
        cb2.setOnCheckedChangeListener(this);
        cb3.setOnCheckedChangeListener(this);
        cb4.setOnCheckedChangeListener(this);

    } // end onCreate

    // CheckBox 의 '상태'가 변할때마다 호출되는 메소드
    // isChecked : true <- check 상태,  false <- uncheck 상태
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
        int count = 0;
        if(cb1.isChecked()) count++;
        if(cb2.isChecked()) count++;
        if(cb3.isChecked()) count++;
        if(cb4.isChecked()) count++;
        tvResult2.setText(count + "개 선택");
    }
} // end Activity












