package com.lec.a006_widget2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ProgressBar pb1, pb2, pb3;

    int value = 0;   // 막대 프로그레스 바의 현재 진행값 저장
    int add = 10;    // 증가량

    int value2 = 0;
    int add2 = 1;

    // 별도의 작업 Thread에서 화면을 그리기 위함
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb1 = findViewById(R.id.pb1);
        pb2 = findViewById(R.id.pb2);
        ToggleButton b1 = findViewById(R.id.toggleButton);
        Button b2 = findViewById(R.id.button1);

        pb3 = findViewById(R.id.progressBar3);

        // 토글 버튼의 상태 변화시 호출되는 리스너
        b1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isPressed) {
                if(isPressed){
                    pb1.setVisibility(View.INVISIBLE);
                } else {
                    pb1.setVisibility(View.VISIBLE);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value += add;

                if(value > 100 || value < 0){
                    add = -add;
                }

                pb2.setProgress(value);
            }
        });

        // 앱 시작시 Thread 를 시작하여 ProgressBar 증가시키기
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    value2 += add2;

                    if(value2 > 100 || value2 < 0){
                        add2 = -add2;
                    }

                    // 프로그레스 값 세팅
                    // 별도의 Thread 에서
                    // 메인 UI 에 접근하려면 반.드.시 Handler 사용해야 함
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            pb3.setProgress(value2);
                        }
                    });

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t.start();

    } // end onCreate()
} // end Activity