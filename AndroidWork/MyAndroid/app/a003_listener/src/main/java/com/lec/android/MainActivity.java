package com.lec.android;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    LinearLayout ll;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);

        tv = findViewById(R.id.tv1);
        ll = findViewById(R.id.ll);
        et = findViewById(R.id.et);

        // 방법1: 익명클래스
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "안녕하세요", Toast.LENGTH_SHORT).show();
            }
        });

        // 방법2: Lambda-Expression 사용
        btn2.setOnClickListener(view -> {
            Log.d("myapp", "버튼2 눌렸습니다");
            tv.setText("버튼2 가 클릭 되었습니다");
            tv.setBackgroundColor(Color.YELLOW);
        });

        // 다양한 이벤트에 대한 리스너 등록가능
        btn2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Log.d("myapp", "버튼2가 롱클릭 되었습니다");
                tv.setText("버튼2가 롱클릭 되었습니다");
                tv.setBackgroundColor(Color.CYAN);
//                return false;    // false 리턴하면 click 이벤트까지 발생
                return true;
            }
        });

        btn3.setOnClickListener(view -> {
            Log.d("myapp", "버튼3가 클릭되었습니다.");
            ll.setBackgroundColor(Color.rgb(164, 198, 57));
            tv.setText("버튼 3가 클릭되었습니다");
        });

        btn3.setOnLongClickListener(view -> {
            Log.d("myapp", "버튼3가 롱클릭 되었습니다");
            tv.setText("버튼3가 롱클릭 되었습니다");
            tv.setTextColor(Color.parseColor("#FF0000"));
            return true;
        });
        
        // 방법3: implement 한 클래스 사용

        Button btnA = findViewById(R.id.btnA);
        Button btnB = findViewById(R.id.btnB);
        Button btnC = findViewById(R.id.btnC);
        Button btnD = findViewById(R.id.btnD);
        Button btnE = findViewById(R.id.btnE);
        Button btnF = findViewById(R.id.btnF);

        class MyListener implements View.OnClickListener{

            String name;
            public MyListener(String name){this.name = name;}

                // CTRL + O : override
            @Override
            public void onClick(View view) {  // click 이벤트 발생한 View 객체가 매개변수로 넘어온다.
                String tag = (String)view.getTag();
                String text = (String)((Button)view).getText();
                String message = name + "버튼" + text + "이 클릭[" + tag + "]";
                Log.d("myapp", message);
                tv.setText(message);
                et.setText(et.getText().append(name));

            }
        }

        btnA.setOnClickListener(new MyListener("안녕1"));
        btnB.setOnClickListener(new MyListener("안녕2"));
        btnC.setOnClickListener(new MyListener("안녕3"));
        btnD.setOnClickListener(new MyListener("안녕4"));
        btnE.setOnClickListener(new MyListener("안녕5"));
        btnF.setOnClickListener(new MyListener("안녕6"));
    }
} // end Activyt








