package com.lec.a006_widget2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    TextView tvResult;
    SeekBar seekBar;


    boolean isTracking = false;

    int value = 0;
    int add = 2;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tvResult = findViewById(R.id.tvResult);
        seekBar = findViewById(R.id.seekBar);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // 값의 변화가 생겼을때 콜백
            // progress : 진행값   0 ~ max
            // fromUer : 사용자에 의한 진행값 변화인 경우 true
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvResult.setText("onProgressChanged:" + progress + "(" + fromUser + ")");
            }

            // tracking 시작할때 호출
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "트래킹시작", Toast.LENGTH_SHORT).show();
                isTracking = true;
            }

            // tracking 끝날때 호출
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getApplicationContext(), "트래킹종료", Toast.LENGTH_SHORT).show();
                isTracking = false;
            }
        });

        // 앱시작시 Thread 로 SeekBar 증가시키기
        new Thread(new Runnable() {
            @Override
            public void run() {
                int max = seekBar.getMax();
                while(true){
                    if(!isTracking){  // tracking 중이 아닐때만 SeekBar 이동
                        value = seekBar.getProgress() + add;

                        if(value > max || value < 0){
                            add = -add;
                        }

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                seekBar.setProgress(value);
                            }
                        });

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();


    } // end onCreate()
} // end Activity






















