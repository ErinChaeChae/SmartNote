package com.example.smartvoca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Japanese extends AppCompatActivity {
    public static int num1 = 0; //넘겨주는 변수
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_japanese);

        final ImageButton esearch = (ImageButton) findViewById(R.id.esearch);
        esearch.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), search.class);
                num1 = 2;
                startActivityForResult(intent, 2);

            }
        });
    }
}