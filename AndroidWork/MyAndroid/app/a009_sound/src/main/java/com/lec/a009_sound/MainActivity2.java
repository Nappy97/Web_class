package com.lec.a009_sound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

// MediaPlayer : 음악 재생
public class MainActivity2 extends AppCompatActivity {

    MediaPlayer mp;   // 음악 재생을 위한 객체

    private ImageView btnPlay;
    private ImageView btnPause;
    private ImageView btnResume;
    private ImageView btnStop;
    SeekBar sb; // 음악 재생위치를 나타내는 시크바

    int pos;   // 현재 재생 시점
    boolean isTracking = false;

    class MyThread extends Thread{
        @Override
        public void run() {   // 쓰레드가 시작되면 콜백되는 메서드
            // 씨크바 막대기 조금씩 움직이기 (노래 끝날 때까지 반복)

            try {
                while(mp.isPlaying()){
                    pos = mp.getCurrentPosition();
                    if(!isTracking){
                        sb.setProgress(pos);   // -> onProgressChanged() 가 호출된다.
                    }
                }
            } catch (IllegalStateException e){

            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnPlay = findViewById(R.id.btnPlay);
        btnPause = findViewById(R.id.btnPause);
        btnResume = findViewById(R.id.btnResume);
        btnStop = findViewById(R.id.btnStop);
        sb = findViewById(R.id.sb);



        btnPlay.setVisibility(View.VISIBLE);
        btnPause.setVisibility(View.INVISIBLE);
        btnResume.setVisibility(View.INVISIBLE);
        btnStop.setVisibility(View.INVISIBLE);

        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            // SeekBar 드래그 시작되면
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                isTracking = true;
            }

            // SeekBar 값 변경될때마다 호출
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // 음악이 끝까지 연주 완료되었다면
                if(seekBar.getMax() == progress && !fromUser){
                    btnPlay.setVisibility(View.VISIBLE);
                    btnStop.setVisibility(View.INVISIBLE);
                    btnPause.setVisibility(View.INVISIBLE);
                    btnResume.setVisibility(View.INVISIBLE);

                    // 연주 종료
                    if(mp != null) mp.stop();
                }
            }

            // SeekBar 드래그 마치면
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                pos = seekBar.getProgress();

                if(mp != null) mp.seekTo(pos);

                isTracking = false;
            }
        });


        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // MediaPlayer 객체 초기화, 재생
                mp = MediaPlayer.create(
                        getApplicationContext(),  // 현재 화면의 제어권자
                        R.raw.chacha);     // 재생할 음악 리소스
                mp.setLooping(false);      // true: 무한반복

                mp.start();  // 음악 재생 시작

                int duration = mp.getDuration();     // 노래의 재생시간 (ms)
                sb.setMax(duration);   // Seekbar 의 최대범위를 노래의 재생시간으로 설정
                new MyThread().start();    // 씨크바 그려줄 쓰레드 시작

                btnPlay.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.VISIBLE);

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 음악 종료
                pos = 0;

                if(mp != null){
                    mp.stop();   // 재생중지
                    mp.seekTo(0);  // 현재 재생위치를 곡의 최초지점으로.
                    mp.release();   // 자원해제
                    mp = null;
                }

                btnPlay.setVisibility(View.VISIBLE);
                btnPause.setVisibility(View.INVISIBLE);
                btnResume.setVisibility(View.INVISIBLE);
                btnStop.setVisibility(View.INVISIBLE);

                sb.setProgress(0);
            }
        });

        // 일시정지
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = mp.getCurrentPosition();  // 현재 재생중이던 위치 저장
                mp.pause();   // 일시 정지
                btnPause.setVisibility(View.INVISIBLE);
                btnResume.setVisibility(View.VISIBLE);
            }
        });

        // 멈춘 지점부터 재시작
        btnResume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.seekTo(pos);   // 일시정지 했었던 시점으로 이동
                mp.start();

                btnResume.setVisibility(View.INVISIBLE);
                btnPause.setVisibility(View.VISIBLE);
                new MyThread().start(); // 쓰레드 시작
            }
        });


    } // end onCreate()

    @Override
    protected void onPause() {
        super.onPause();

        if(mp != null){
            mp.release();  // 자원해제
        }

        btnPlay.setVisibility(View.VISIBLE);
        btnStop.setVisibility(View.INVISIBLE);
        btnPause.setVisibility(View.INVISIBLE);
        btnResume.setVisibility(View.INVISIBLE);

    }
} // end Activity()








