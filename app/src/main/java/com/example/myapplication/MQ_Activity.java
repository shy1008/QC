package com.example.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MQ_Activity extends AppCompatActivity {

//    private FirebaseFirestore mStroe = FirebaseFirestore.getInstance();
//    String [] str ={"id","2"};

    ImageView mimageView;
    TextView mTextView;
    Button mButton;
    Button left;
    private  static MediaPlayer mp;


    View.OnClickListener lt = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent leftt = new Intent(MQ_Activity.this, MainActivity.class);
            startActivity(leftt);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mq_);

//        Random random = new Random();
//        int num = random.nextInt(str.length);


        left = (Button) findViewById(R.id.left);
        mimageView=(ImageView) findViewById(R.id.imageView);
        mTextView = (TextView) findViewById(R.id.fact);
        mButton = (Button) findViewById(R.id.fact_button);

        mp = MediaPlayer.create(this,R.raw.run);
        mp.setLooping(true);
        mp.start();








        left.setOnClickListener(lt);
//        txt1.setText(num);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRandomFact();
            }
        });



    }


    public void  showRandomFact(){
        shuffleFacts();
        mimageView.setImageResource(factArray[3].getmImage());
        mTextView.setText(factArray[3].getmFact());

    }
    Facts f01 = new Facts(R.drawable.v1,"물먹는하마 - 당장 물3컵 마시기 ");
    Facts f02 = new Facts(R.drawable.v2,"악수 - 두명의 사람과 악수하기 ");
    Facts f03 = new Facts(R.drawable.v3,"박수 - 박수 5번 시작 ");
    Facts f04 = new Facts(R.drawable.v4,"팔굽혀펴기 - 팔굽혀펴기 50회 실시 (단, 한번에)");
    Facts f05 = new Facts(R.drawable.v5,"제자리뛰기 - 제자리뛰기 2분 실시 ");
    Facts f06 = new Facts(R.drawable.v6,"윙크 - 보이는 사람에게 윙크 하기 (데쓰윙크안됨)");
    Facts f07 = new Facts(R.drawable.v7,"머리돌리기 - 머리10번 돌리기");
    Facts f08 = new Facts(R.drawable.v8,"코끼리코 - 코끼리코 10회 돌기");

    Facts [] factArray = new  Facts[]{
            f01,f02,f03,f04,f05,f06,f07,f08
    };

    public void  shuffleFacts(){
        Collections.shuffle(Arrays.asList(factArray));
    }

    protected  void  onUserLeaveHint(){
        mp.pause();
        super.onUserLeaveHint();
    }
    public void  onResume(){
        mp.start();
        super.onResume();
    }
    public  void  onDestroy(){
        mp.stop();
        super.onDestroy();
    }
    public void  onBackPressed(){
        mp.stop();
        super.onBackPressed();
    }
}