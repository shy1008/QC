package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TQ_Activity extends AppCompatActivity {
    Button left;
    ListView list;
    EditText edt10;
    Button addbtn;
    Button delbtn;

    List<String> list2;
    ArrayAdapter array;

    View.OnClickListener a10  = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            list2.add(edt10.getText().toString());
            array.notifyDataSetChanged();
        }
    };

    View.OnClickListener d10 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (list2.size() > 0) {
                list2.remove(list2.size()-1);
                array.notifyDataSetChanged();
            }
        }
    };


    View.OnClickListener lt = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent leftt = new Intent(TQ_Activity.this,MainActivity.class);
//            startActivity(leftt);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tq_);


        left = (Button) findViewById(R.id.left);
        list= (ListView) findViewById(R.id.list);
        edt10=(EditText) findViewById(R.id.edt10);
        addbtn =(Button) findViewById(R.id.addbtn);
        delbtn = (Button) findViewById(R.id.delbtn);

        list2 = new ArrayList<>();
        list2.add("하루 물 10잔 마시기");
        list2.add("아침 6시 기상하기");
        list2.add("하루에 3번 칭찬하기");
        list2.add("푸쉬업 100회 하기");

        array = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list2);
        list.setAdapter(array);

        addbtn.setOnClickListener(a10);
        delbtn.setOnClickListener(d10);


        left.setOnClickListener(lt);
    }
}
