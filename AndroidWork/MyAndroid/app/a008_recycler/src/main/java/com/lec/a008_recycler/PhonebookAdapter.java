package com.lec.a008_recycler;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

// Adapter 객체 정의
// 데이터(Phonebook) 를 받아서 각 Item 별로 View 를 생성하는 역할
public class PhonebookAdapter extends RecyclerView.Adapter<PhonebookAdapter.ViewHolder> {

    // Adapter는 리스트에서 다룰 데이터가 필요하다
    // Adapter가 데이터에 연결되어야 하는 것은 사실이나, 데이터를 Adapter를 직접 다룰지
    // 아니면 별도의 데이터 관리는 따로 하는 구조로 만들지는 선택의 몫
    // 본 예제에서는 Adapter 안에 직접 데이터를 다루어보겠습니다
    List<Phonebook> items = new ArrayList<>();

    static PhonebookAdapter adapter;

    public PhonebookAdapter(){
        PhonebookAdapter.adapter = this;
    }

    // onCreateViewHolder() : ViewHolder 가 생성될때 호출됨
    // 각 item 을 위해 정의한 레이아웃(ex:XML) 으로 View 객체를 만들어 줍니다.
    // 이들 View객체를 새로 만들 ViewHolder 에 담아 리턴.
    //
    //  'View  타입' 을 위한 정수값이 매개변수로 넘겨진 --> viewType
    //    이를 통해 아이템별로 View를 다양하게 표현 가능.  (ListView 에는 없던 개선점)
    //    예를들면, 각각의 'View 타입' 별로 따로따로 XML레이아웃을 달리 하여 보여줄수 있는 겁니다.
    //    * 그러나, 일반적으로는 한가지만 운용함.*
    //
    //  매개변수로 전달된 ViewGroup 객체는 각 아이템을 위한 객체
    //  이로부터 Context 객체를 뽑아내어 Layout inflation 을 해야 한다.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // 주어진 ViewGroup 으로부터 LayoutInflater 추출
        LayoutInflater inf = LayoutInflater.from(parent.getContext());

        // 준비된 레이아웃(XML) 으로부터 View 를 만들어 viewGroup 에 붙이고
        // 만들은 View를 리턴한다.
        View itemView = inf.inflate(R.layout.item, parent, false);

        // 위에서 만들어진 새로운 View를  ViewHolder 에 담아 리턴
        return new ViewHolder(itemView);
    }

    // onBindViewHolder() : ViewHolder 가 '재사용' 될때 호출됨
    // View 객체는 그대로 기존것을 사용 (이것이 재사용!) 하고 데이터만 바꾸어 주면 됨.
    //  이전에 이미 만들어진. 재활용할수 있는 ViewHolder 객체  와
    //  리스트 상에 몇번째 데이터인지에 대한 정보 (position) 가 넘어온다
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Phonebook item = items.get(position);
        holder.setItem(item);
    }

    // getItemCount() : 어댑터에서 다루는 현시점 아이템(데이터)의 개수
    //   Selection Widget 에서 수시로 getItemCount() 를 호출하여 뷰를 업데이트
    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        // ViewHolder 에 담긴 각각의 view 들을 담을 변수
        ImageView ivPhoto;
        TextView tvName, tvPhone, tvEmail;

        // ViewHolde 에 담긴 View 이벤트
        ImageButton btnDelItem;
        Switch swOnOff;

       // 생성자 반드시 생성
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // View 객체들 가져오기
            ivPhoto = itemView.findViewById(R.id.ivPhoto);
            tvName = itemView.findViewById(R.id.tvName);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvEmail = itemView.findViewById(R.id.tvEmail);

            itemView.setOnClickListener(view -> {
                int position = getAdapterPosition();   // 이 리스너가 장착된 item의 리스트 상의 position 값
//                Toast.makeText(view.getContext(), "position:" + position, Toast.LENGTH_LONG).show();

                // 아이템을 클릭하면 해당 세부정보 액티비티로 전환
                Intent intent = new Intent(view.getContext(), PhonebookDetail.class);
                intent.putExtra("pb", adapter.getItem(position));

                view.getContext().startActivity(intent);
            });

            // ViewHolder 에 담긴 View 이벤트
            btnDelItem = itemView.findViewById(R.id.btnDelItem);
            swOnOff = itemView.findViewById(R.id.swOnOff);

            // switch 누르면 전화번호, 이메일 토글하기
            swOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if(isChecked){
                        tvPhone.setVisibility(View.INVISIBLE);
                        tvEmail.setVisibility(View.INVISIBLE);
                    } else {
                        tvPhone.setVisibility(View.VISIBLE);
                        tvEmail.setVisibility(View.VISIBLE);
                    }
                }
            });

            // 삭제 버튼 누르면 item 삭제 시키기
            btnDelItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // position 정보 필요하다
                    // getAdapterPosition() 사용
//                    Toast.makeText(view.getContext(), "close:" + getAdapterPosition(), Toast.LENGTH_LONG).show();

                    adapter.removeItem(getAdapterPosition());

                    adapter.notifyDataSetChanged();
                }
            });

        } // end

        // 데이터를 받아서 필드 세팅
        public void setItem(Phonebook item){
            ivPhoto.setImageResource(item.getPhoto());
            tvName.setText(item.getName());
            tvPhone.setText(item.getPhone());
            tvEmail.setText(item.getEmail());
        }

    } // end ViewHolder

    // 데이터를 다루기 위한 메소드들
    // ArrayList 의 메소드들 사용
    public void addItem(Phonebook item) {
        items.add(item);
    }
    public void addItem(int position, Phonebook item) {
        items.add(position, item);
    }
    public void setItems(ArrayList<Phonebook> items) {
        this.items = items;
    }
    public Phonebook getItem(int position) {
        return items.get(position);
    }
    public void setItem(int position, Phonebook item) {
        items.set(position, item);
    }
    public void removeItem(int position){ items.remove(position); }


} // end Adapter












