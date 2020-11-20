package com.example.smartvoca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Home_main extends AppCompatActivity {
    public static int num = 0; //넘겨주는 변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_main);

        final ImageButton gotomyword = (ImageButton) findViewById(R.id.gotomyword);
        gotomyword.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Mywordfolder.class);
                startActivity(intent);
            }
        });

        final Button english = (Button) findViewById(R.id.english);
        //영어
        english.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), English.class);
                startActivity(intent);
            }
        });
        final Button japanese = (Button) findViewById(R.id.japanese);
        //일본어
        japanese.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent1 = new Intent(getApplicationContext(), Japanese.class);
                startActivity(intent1);
            }
        });
        final Button java = (Button) findViewById(R.id.java);
        //자바
        java.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent2 = new Intent(getApplicationContext(), Java.class);
                startActivity(intent2);
            }
        });
        final Button db = (Button) findViewById(R.id.db);
        //디비
        db.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent3 = new Intent(getApplicationContext(), Database.class);
                startActivity(intent3);
            }
        });
    }
}