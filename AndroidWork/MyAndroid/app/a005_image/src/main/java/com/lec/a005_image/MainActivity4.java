package com.lec.a005_image;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *  인터넷 상의 이미지 보여주기
 *      1. 권한을 획득한다 (인터넷에 접근할수 있는 권한을 획득한다)  - 메니페스트 파일
 *      2. Thread 에서 웹의 이미지를 받아온다 - honeycomb(3.0) 버젼 부터 바뀜
 *      3. 외부쓰레드에서 메인 UI에 접근하려면 Handler 를 사용해야 한다.
 *
 *
 *
 */
public class MainActivity4 extends AppCompatActivity {

    Handler handler = new Handler();   // 외부 쓰레드 에서 메인 UI 그림을 그릴때

    // 이미지 url 은 반드시 https:// 이어야 한다
    String imgUrl = "https://developer.android.com/studio/images/studio-icon-stable.png";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    final ImageView iv1 = findViewById(R.id.iv1);
                    final TextView tvUrl = findViewById(R.id.tvUrl);

                    // Bitmap <- InputStream <- URL <- "url"
                    URL url = new URL(imgUrl);
                    InputStream is = url.openStream();
                    final Bitmap bm = BitmapFactory.decodeStream(is);


                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // 외부쓰레드에서 메인UI 에 접근할때는
                            // 반드시 Handler 객체 사용.
                            iv1.setImageBitmap(bm);
                            tvUrl.setText(imgUrl);
                        }
                    });

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

    }
}