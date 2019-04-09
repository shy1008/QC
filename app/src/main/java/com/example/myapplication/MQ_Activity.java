package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MQ_Activity extends AppCompatActivity {
    Button left;
    TextView txt1;
    TextView txt2;


    View.OnClickListener lt = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent leftt = new Intent(MQ_Activity.this, MainActivity.class);
//            startActivity(leftt);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mq_);


        left = (Button) findViewById(R.id.left);
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);


        left.setOnClickListener(lt);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            String result1 = data.getStringExtra("data1");
            String result2 = data.getStringExtra("data2");
            txt1.setText(result1);
            txt2.setText(result2);
        } else if (requestCode == 100){
            Log.e("!!!", "onActivityResult: 에러다");

        }

    }
}