package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Intro extends AppCompatActivity {
    String str1;
    String str2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Handler hadle = new Handler();
        hadle.postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences sp = getSharedPreferences("a",MODE_PRIVATE);
                str1 = sp.getString("id","noid");
//                str2 = sp.getString("pw","nopw");

                if (str1 == "noid"){
                    Intent i1 = new Intent(Intro.this,Login_Activity.class);
                    startActivity(i1);
                    finish();
                }else{
                    Intent i2 = new Intent(Intro.this,MainActivity.class);
                    startActivity(i2);
                    finish();
                }

            }
        },2000);







    }
}
