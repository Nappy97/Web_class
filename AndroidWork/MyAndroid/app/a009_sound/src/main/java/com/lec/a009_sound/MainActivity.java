package com.lec.a009_sound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/** 음향: SoundPool
 *      짧은 음향 리소스(들)을 SoundPool 에 등록(load)하고, 원할때마다 재생(play)
 *
 *  res/raw 폴더 만들고  음향 리소스 추가하기
 */

public class MainActivity extends AppCompatActivity {

    private SoundPool sp;

    // 음향 리소스 id
    private final int [] SOUND_RES = {R.raw.gun, R.raw.gun2, R.raw.gun3};

    // 음향 id 값(들)
    int [] soundId = new int[SOUND_RES.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlay1 = findViewById(R.id.btnPlay);
        Button btnPlay2 = findViewById(R.id.btnPlay2);
        Button btnPlay3 = findViewById(R.id.btnPlay3);

        sp = new SoundPool.Builder().setMaxStreams(10).build();

        // SoundPool 에 음향 리소스들을 load
        for(int i = 0; i < SOUND_RES.length; i++){
            soundId[i] = sp.load(this,   // 현재 화면의 제어권자
                    SOUND_RES[i], // 음향 리소스
                    1  // 재생시 우선순위
                    );
        }

        btnPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 음향 재생
                sp.play(soundId[0],   // SoundPool 에 준비된 sound id
                        1,  // 왼쪽 볼륨 float 0.0 ~ 1.0
                        1,  // 오른쪽 볼륨
                        0,  // 우선순위
                        0,  // 반복회수 int -1: 무한반복,  0: 반복안함
                        1f  // 재생속도  float   0.5 (절반속도)   2.0 (2배속)
                );
            }
        });

        btnPlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 음향 재생
                sp.play(soundId[1],   // SoundPool 에 준비된 sound id
                        1,  // 왼쪽 볼륨 float 0.0 ~ 1.0
                        0,  // 오른쪽 볼륨
                        0,  // 우선순위
                        2,  // 반복회수 int -1: 무한반복,  0: 반복안함
                        2f  // 재생속도  float   0.5 (절반속도)   2.0 (2배속)
                );
            }
        });
        btnPlay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 음향 재생
                sp.play(soundId[2],   // SoundPool 에 준비된 sound id
                        9,  // 왼쪽 볼륨 float 0.0 ~ 1.0
                        1,  // 오른쪽 볼륨
                        0,  // 우선순위
                        -1,  // 반복회수 int -1: 무한반복,  0: 반복안함
                        0.5f  // 재생속도  float   0.5 (절반속도)   2.0 (2배속)
                );

                // sp.stop(id) : 특정 음향 재생중단
            }
        });

    } // end onCreate()
}








