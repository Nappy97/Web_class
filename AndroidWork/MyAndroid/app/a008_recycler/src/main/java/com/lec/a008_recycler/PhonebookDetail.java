package com.lec.a008_recycler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PhonebookDetail extends AppCompatActivity {

    ImageView ivPhoto;
    TextView tvName, tvPhone, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook_detail);

        ivPhoto = findViewById(R.id.ivPhoto);
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);

        // 넘겨온 Phonebook 데이터 받기
        Intent intent = getIntent();
        Phonebook pb = (Phonebook)intent.getSerializableExtra("pb");

        ivPhoto.setImageResource(pb.getPhoto());
        tvName.setText(pb.getName());
        tvEmail.setText(pb.getEmail());
        tvPhone.setText(pb.getPhone());
        
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();   // 현재 액티비티 종료,,  이전 화면(리스트)로 돌아가기       
            }
        });


    } // end onCreate()
    
}











