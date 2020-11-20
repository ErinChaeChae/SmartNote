package com.example.smartvoca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

//plus button 누르면 folder에 있는거 하나 보이게 바꾼 뒤에,
// 만약 버튼 1이 보이는 상태이면 2를 만들어주고 2에 해당하는 값을 main에 전달해서
// 그 main에 있는 child 중에서 해당하는 숫자에 값들을 보여주는걸로 구현하자
// 즉, 추가 삭제 수정 부분을 여러개 만들어야 한다는 소리임
// if (받아온 값 == 1) 이면 bookmark 다음 myword1,2,3,4이렇게 ㅇㅋ?
public class Mywordfolder extends AppCompatActivity {
    private ImageButton plusButton;
    private String bookmark;
    private String str1;
    private String str2;
    private String str3;
    private String str4;
    private String str5;
    public static int check = 0; //넘겨주는 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywordfolder);
        final Button bookmarkButton = (Button) findViewById(R.id.bookmarkbutton);
        final Button myword1 = (Button) findViewById(R.id.btn_myword1);
        final Button myword2 = (Button) findViewById(R.id.btn_myword2);
        final Button myword3 = (Button) findViewById(R.id.btn_myword3);
        final Button myword4 = (Button) findViewById(R.id.btn_myword4);
        final Button myword5 = (Button) findViewById(R.id.btn_myword5);


        //폴더 추가 버튼 누르면 보여주게 하는 방식으로 구현
        plusButton = findViewById(R.id.btn_plusword);  //시작버튼
        plusButton.setOnClickListener(new Button.OnClickListener() {
            int x;

            public void onClick(View v) {
                plusButton.setOnClickListener(new Button.OnClickListener() {
                    public void onClick(View v) {
                        x = x + 1;
                        if (myword2.getVisibility() == v.GONE) {
                            myword2.setVisibility(v.VISIBLE);
                        }
                        if (x == 2) {
                            myword3.setVisibility(v.VISIBLE);
                        }
                        if (x == 3) {
                            myword4.setVisibility(v.VISIBLE);
                        }
                        if (x == 4) {
                            myword5.setVisibility(v.VISIBLE);
                        }
                    }
                });
            }
        });

        //Home 버튼 클릭시
        final ImageButton home = (ImageButton) findViewById(R.id.home);
        home.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Home_main.class);
                startActivity(intent);
            }
        });

        //bookmark 클릭시
        bookmarkButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent1 = new Intent(getApplicationContext(), Myword_main.class);
                intent1.putExtra("data1", "북마크 단어모음");
                check = 1;
                intent1.putExtra("bookmark", bookmark);
                startActivityForResult(intent1, 1);
            }
        });

        //myword1 클릭시
        myword1.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent2 = new Intent(getApplicationContext(), Myword_main.class);
                intent2.putExtra("data2", "내 단어장1");
                check = 2;
                startActivityForResult(intent2, 2);
            }
        });

        //myword2 클릭시
        myword2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent3 = new Intent(getApplicationContext(), Myword_main.class);
                intent3.putExtra("data3", "내 단어장2");
                check = 3;
                startActivityForResult(intent3, 3);
            }
        });
        //myword3 클릭시
        myword3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent4 = new Intent(getApplicationContext(), Myword_main.class);
                intent4.putExtra("data4", "내 단어장3");
                check = 4;
                startActivityForResult(intent4, 4);
            }
        });
        //myword4 클릭시
        myword4.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent5 = new Intent(getApplicationContext(), Myword_main.class);
                intent5.putExtra("data5", "내 단어장4");
                check = 5;
                startActivityForResult(intent5, 5);
            }
        });
        //myword5 클릭시
        myword5.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent6 = new Intent(getApplicationContext(), Myword_main.class);
                intent6.putExtra("data6", "내 단어장5");
                check = 6;
                startActivityForResult(intent6, 6);
            }
        });
    }
}
