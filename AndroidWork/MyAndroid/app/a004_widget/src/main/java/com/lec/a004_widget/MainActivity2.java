package com.lec.a004_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    EditText op1, op2;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        tvResult = findViewById(R.id.tvResult);

        Button btnPlus = findViewById(R.id.btnPlus);
        Button btnMinus = findViewById(R.id.btnMinus);
        Button btnMul = findViewById(R.id.btnMul);
        Button btnDiv = findViewById(R.id.btnDiv);

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String oper1 = op1.getText().toString();
                String oper2 = op2.getText().toString();

                int a = 0, b = 0;

                try{
                    a = Integer.parseInt(oper1);
                } catch(NumberFormatException e){

                }
                try{
                    b = Integer.parseInt(oper2);
                } catch(NumberFormatException e){

                }

                tvResult.setText((a + b) + "");  // 반드시 문자열이어야 한다!
//                tvResult.setText((a + b));  // 정수값인 경우 문자열 resource id 값으로 찾습니다.
            }
        });

    }


}





