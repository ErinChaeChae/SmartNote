package com.example.smartvoca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class ResultActivity extends AppCompatActivity {
    private TextView tv_result;
    private ImageView iv_profile;
    private Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //ResultActivity에서 시작버튼 클릭시 화면전환이벤트
        //현재는 내 단어장메인으로 가지만 나중에 메인화면 받아와야함
        btn_start = findViewById(R.id.btn_start);  //시작버튼
        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Home_main.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        String nickname = intent.getStringExtra("nickname"); //보내는 쪽이랑 받는 쪽 "여기"일치시켜주자
        String photourl = intent.getStringExtra("photourl"); //보내는 쪽이랑 받는 쪽 일치시켜주자

        tv_result = findViewById(R.id.tv_result);
        tv_result.setText(nickname); //닉네임 텍스트를 텍스트뷰에 세팅한것

        iv_profile = findViewById(R.id.iv_profile);
        Glide.with(this).load(photourl).into(iv_profile); //가져온 프로필을 이미지 뷰에 세팅

    }
}