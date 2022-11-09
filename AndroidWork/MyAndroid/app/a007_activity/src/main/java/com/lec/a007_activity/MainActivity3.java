package com.lec.a007_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    EditText et1, et2;
    Button btnStart;
    TextView tvResult;

    private final int REQUEST_CODE_CALC = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btnStart = findViewById(R.id.btnStart);
        tvResult = findViewById(R.id.tvResult);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt(et1.getText().toString());
                int b = Integer.parseInt(et2.getText().toString());

                Intent intent = new Intent(getApplicationContext(), CalcActivity.class);
                intent.putExtra("num1", a);
                intent.putExtra("num2", b);

//                startActivity(intent);   // 일반 액티비티 전환

                // 값을 돌려받기 위한 화면전환
                startActivityForResult(intent, REQUEST_CODE_CALC);
            }
        });

    } // end onCreate()

    // startActivityForResult() 로 넘어갔단 화면으로부터 결과값을 돌려 받을때 호출
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if(resultCode == RESULT_OK){   // 호출받은 쪽에서 전달해준 code 값.  RESULT_OK <- 정상적으로 처리되었다는 뜻.
            switch (requestCode){
            case REQUEST_CODE_CALC:    // 호출할때 설정한 code 값
                int a = data.getIntExtra("plus", 0);
                int b = data.getIntExtra("minus", 0);

                tvResult.setText(requestCode + "] 받아온값: " + a + " : " + b);
                break;
                
            }
        } else {
            // 정상적인 처리 결과가 아니 경우..
        }

    }
}





















