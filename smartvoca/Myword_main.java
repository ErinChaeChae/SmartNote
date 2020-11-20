package com.example.smartvoca;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

//현재 firebase에 추가는 되는데 원하는 것만 삭제 수정이 불가능

public class Myword_main extends AppCompatActivity {
    EditText word_input; //단어, 뜻 입력
    ListView myword_list; //보여주는 리스트뷰
    //FirebaseDatabase database = FirebaseDatabase.getInstance().getReference(); //DB관련변수
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    DatabaseReference myref = database.child("bookmark");
    //DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    //DatabaseReference myref = database.child("bookmark");
    DatabaseReference myref1 = database.child("myword1");
    DatabaseReference myref2 = database.child("myword2");
    DatabaseReference myref3 = database.child("myword3");
    DatabaseReference myref4 = database.child("myword4");
    DatabaseReference myref5 = database.child("myword5");
    private TextView foldername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // 빈 데이터 리스트 생성.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myword_main);

        final String bookmark;
        final String word1;
        final String word2;
        final String word3;
        final String word4;
        final String word5;

        foldername = findViewById(R.id.foldername);

        if (Mywordfolder.check == 1) {
            Intent intent1 = getIntent();
            bookmark = intent1.getExtras().getString("data1");
            //Mywordfolder.check = 0;
            foldername.setText(bookmark);
        } else if (Mywordfolder.check == 2) {
            Intent intent2 = getIntent();
            word1 = intent2.getExtras().getString("data2");
            //Mywordfolder.check = 0;
            foldername.setText(word1);
        } else if (Mywordfolder.check == 3) {
            Intent intent3 = getIntent();
            word2 = intent3.getExtras().getString("data3");
            //Mywordfolder.check = 0;
            foldername.setText(word2);
        } else if (Mywordfolder.check == 4) {
            Intent intent4 = getIntent();
            word3 = intent4.getExtras().getString("data4");
            //Mywordfolder.check = 0;
            foldername.setText(word3);
        } else if (Mywordfolder.check == 5) {
            Intent intent5 = getIntent();
            word4 = intent5.getExtras().getString("data5");
            //Mywordfolder.check = 0;
            foldername.setText(word4);
        } else if (Mywordfolder.check == 6) {
            Intent intent6 = getIntent();
            word5 = intent6.getExtras().getString("data6");
            //Mywordfolder.check = 0;
            foldername.setText(word5);
        } else
            System.out.print("오류");

        //변수초기화
        word_input = (EditText) findViewById(R.id.word_input);
        myword_list = (ListView) findViewById(R.id.myword_list);

        final ArrayList<String> items = new ArrayList<String>();

        // ArrayAdapter 생성. 아이템 View를 선택(single choice)가능하도록 만듦.
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);

        // listview 생성 및 adapter 지정.
        final ListView listview = (ListView) findViewById(R.id.myword_list);
        listview.setAdapter(adapter);

        if (Mywordfolder.check == 1) {
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
        }

        if (Mywordfolder.check == 2) {
            myref1.addValueEventListener(new ValueEventListener() {
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
        }
        if (Mywordfolder.check == 3) {
            myref2.addValueEventListener(new ValueEventListener() {
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
        }
        if (Mywordfolder.check == 4) {
            myref3.addValueEventListener(new ValueEventListener() {
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
        }
        if (Mywordfolder.check == 5) {
            myref4.addValueEventListener(new ValueEventListener() {
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
        }

        if (Mywordfolder.check == 6) {
            myref5.addValueEventListener(new ValueEventListener() {
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
        }

        //추가
        final Button addButton = (Button) findViewById(R.id.add);
        addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count;
                count = adapter.getCount();

                // 아이템 추가.
                String text = word_input.getText().toString().trim();
                if (text.length() != 0) {
                    items.add(text);
                    if(Mywordfolder.check == 1)
                        myref.push().setValue(text);
                    else if (Mywordfolder.check == 2)
                        myref1.push().setValue(text);
                    else if(Mywordfolder.check == 3)
                        myref2.push().setValue(text);
                    else if(Mywordfolder.check == 4)
                        myref3.push().setValue(text);
                    else if(Mywordfolder.check == 5)
                        myref4.push().setValue(text);
                    else if(Mywordfolder.check == 6)
                        myref5.push().setValue(text);
                    else
                        System.out.print("오류입니다.");

                    word_input.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });

        //수정
        final Button modifyButton = (Button) findViewById(R.id.modify);
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
        });

        //삭제
        final Button deleteButton = (Button) findViewById(R.id.delete);
        deleteButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count, checked;
                count = adapter.getCount();
                String text = word_input.getText().toString().trim();
                if (count > 0) {
                    // 현재 선택된 아이템의 position 획득.
                    checked = listview.getCheckedItemPosition();

                    if (checked > -1 && checked < count) {
                        // 아이템 삭제
                        items.remove(checked);

                        // listview 선택 초기화.
                        listview.clearChoices();

                        // listview 갱신.
                        adapter.notifyDataSetChanged();

                    }
                }
            }
        });

        //전체 데이터 삭제
        final Button btn_alldata = (Button) findViewById(R.id.btn_alldata);
        btn_alldata.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                if(Mywordfolder.check == 1)
                    myref.removeValue();
                else if (Mywordfolder.check == 2)
                    myref1.removeValue();
                else if(Mywordfolder.check == 3)
                    myref2.removeValue();
                else if(Mywordfolder.check == 4)
                    myref3.removeValue();
                else if(Mywordfolder.check == 5)
                    myref4.removeValue();
                else if(Mywordfolder.check == 6)
                    myref5.removeValue();
                else
                    System.out.print("오류입니다.");
            }
        });

        //홈으로
        final ImageButton home = (ImageButton) findViewById(R.id.home);
        home.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), Home_main.class);
                startActivity(intent);
            }
        });

        // edit버튼누르면 add, modify, delete visible설정
        final ImageButton edit = (ImageButton) findViewById(R.id.edit);
        edit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // conditionRef.setValue(word_input.getText().toString());
                if (addButton.getVisibility() == v.GONE) {
                    addButton.setVisibility(v.VISIBLE);
                    modifyButton.setVisibility(v.VISIBLE);
                    deleteButton.setVisibility(v.VISIBLE);
                    word_input.setVisibility(v.VISIBLE);
                    btn_alldata.setVisibility(v.VISIBLE);
                    myword_list.setVisibility(v.GONE);

                } else {
                    addButton.setVisibility(v.GONE);
                    modifyButton.setVisibility(v.GONE);
                    deleteButton.setVisibility(v.GONE);
                    word_input.setVisibility(v.GONE);
                    btn_alldata.setVisibility(v.GONE);
                    myword_list.setVisibility(v.VISIBLE);
                }
            }
        });
    }
}