package com.lec.a006_widget2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    RatingBar rb;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        rb = findViewById(R.id.ratingBar);
        tv = findViewById(R.id.tvResult);

        // RatingBar 의 값이 변할때 호출되는 메소드
        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean fromUser) {
                tv.setText("rating: " + v);
            }
        });

    }  // end onCreate
} // activity















