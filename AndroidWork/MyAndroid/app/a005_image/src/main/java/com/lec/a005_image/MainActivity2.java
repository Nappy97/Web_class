package com.lec.a005_image;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageView iv1 = findViewById(R.id.iv1);
        ImageView iv2 = findViewById(R.id.iv2);
        ImageView iv3 = findViewById(R.id.iv3);

        // 방법1: 이미지 resource 로 세팅하는 방법
        iv1.setImageResource(R.drawable.a2);


        // 방법2: Drawable 객체를 이용
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.a3);
        iv2.setImageDrawable(drawable);

        // 방법3: Bitmap 객체를 이용
        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.a4);
        iv3.setImageBitmap(bm);
    }


}



