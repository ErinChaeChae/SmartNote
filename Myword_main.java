package com.example.smartvoca;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Myword_main extends AppCompatActivity {
    EditText word_input; //단어, 뜻 입력
    ListView myword_list; //보여주는 리스트뷰
    private FirebaseDatabase database; //DB관련변수
    private DatabaseReference myref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 빈 데이터 리스트 생성.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myword_main);
        //변수초기화
        word_input = (EditText) findViewById(R.id.word_input);
        myword_list = (ListView)findViewById(R.id.myword_list);
        //DB관련 변수 초기화
        database = FirebaseDatabase.getInstance();
        myref = database.getReference("message");

        final ArrayList<String> items = new ArrayList<String>();
        // ArrayAdapter 생성. 아이템 View를 선택(single choice)가능하도록 만듦.
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);

        // listview 생성 및 adapter 지정.
        final ListView listview = (ListView) findViewById(R.id.myword_list);
        listview.setAdapter(adapter);

        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // 데이터를 읽어올 때 모든 데이터를 읽어오기때문에 List 를 초기화해주는 작업이 필요하다.
                adapter.clear();
                for (DataSnapshot messageData : snapshot.getChildren()) {
                    String msg = messageData.getValue().toString();
                    adapter.add(msg);
                }
                // notifyDataSetChanged를 안해주면 ListView 갱신이 안됨
                adapter.notifyDataSetChanged();
                // ListView 의 위치를 마지막으로 보내주기 위함
                listview.setSelection(adapter.getCount() - 1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //추가
        final Button addButton = (Button)findViewById(R.id.add) ;
        addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count;
                count = adapter.getCount();

                // 아이템 추가.
                String text = word_input.getText().toString().trim();
                if(text.length() != 0) {
                    items.add(text);
                    myref.push().setValue(text); //임의로 중복되지 않는 키 생성해서 저장
                    word_input.setText(""); //입력하는 곳 빈칸으로 만들어주기
                    // listview 갱신
                    adapter.notifyDataSetChanged();
                }
            }
        }) ;

        //수정
        final Button modifyButton = (Button)findViewById(R.id.modify) ;
        modifyButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count, checked;
                count = adapter.getCount();
                String text = word_input.getText().toString();

                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = listview.getCheckedItemPosition();
                    if (checked > -1 && checked < count) {
                        items.set(checked, text);
                        word_input.setText("");
                        // listview 갱신
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }) ;

        //삭제
        final Button deleteButton = (Button)findViewById(R.id.delete) ;
        deleteButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count, checked ;
                count = adapter.getCount() ;

                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = listview.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        // 아이템 삭제
                        items.remove(checked) ;
                        //myref.setValue(null);
                        // listview 선택 초기화.
                        listview.clearChoices();

                        // listview 갱신.
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        }) ;

        // edit버튼누르면 add, modify, delete visible설정
        final ImageButton edit = (ImageButton) findViewById(R.id.edit);
        edit.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(addButton.getVisibility() == v.GONE){
                    addButton.setVisibility(v.VISIBLE);
                    modifyButton.setVisibility(v.VISIBLE);
                    deleteButton.setVisibility(v.VISIBLE);
                    word_input.setVisibility(v.VISIBLE);
                    myword_list.setVisibility(v.GONE);

                }else{
                    addButton.setVisibility(v.GONE);
                    modifyButton.setVisibility(v.GONE);
                    deleteButton.setVisibility(v.GONE);
                    word_input.setVisibility(v.GONE);
                    myword_list.setVisibility(v.VISIBLE);
                }
            }
        });
    }
}