package com.lec.a008_recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    PhonebookAdapter adapter;   // Adapter 객체
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        // RecyclerView를 사용하기 위해 LayoutManager 를 지정해주어야 한다
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

//        layoutManager = new GridLayoutManager(this, 2);

        rv.setLayoutManager(layoutManager);

        // Adapter 객체 생성
        adapter = new PhonebookAdapter();
        // 샘플 데이터로 초기화
        initAdapter(adapter);

        rv.setAdapter(adapter);   // RecyclerView 에 Adapter 장착


        // INSERT 버튼 -> 맨 앞에 item 추가
        // APPEND 버튼 -> 맨 뒤에 item 추가
        Button btnInsert = findViewById(R.id.btnInsert);
        Button btnAppend = findViewById(R.id.btnAppend);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idx = D.next();
                // 리스트 맨 앞에 추가
                adapter.addItem(0, new Phonebook(D.FACEID[idx], D.NAME[idx], D.PHONE[idx], D.EMAIL[idx]));
                adapter.notifyDataSetChanged();   // 데이터 변경한 사실을 Adapter 에 알림 -> 뷰를 업데이트
            }
        });

        btnAppend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idx = D.next();
                // 리스트 맨 뒤에 추가
                adapter.addItem(new Phonebook(D.FACEID[idx], D.NAME[idx], D.PHONE[idx], D.EMAIL[idx]));
                adapter.notifyDataSetChanged();
            }
        });


    } // end onCreate()

    // 샘플데이터 가져오기
    protected void initAdapter(PhonebookAdapter adapter){
        // 일단 몇개만 생성
        for(int i = 0; i < 10; i++){
            int idx = D.next();
            adapter.addItem(new Phonebook(D.FACEID[idx], D.NAME[idx], D.PHONE[idx], D.EMAIL[idx]));
        }
    } // end initAdapter()


}










