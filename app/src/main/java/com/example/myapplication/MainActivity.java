package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button open;
    Button close;
    Button logout;
    TextView id2;
    Button mbtn;
    Button tbtn;
    Button cbtn;
    DrawerLayout dlayout;

    ImageView kaka;
    ImageView face;
    ImageView instar;



    View.OnClickListener o = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dlayout.openDrawer(Gravity.LEFT);
        }
    };
    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dlayout.closeDrawer(Gravity.LEFT);
        }
    };

    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences preferences = getSharedPreferences("a",0);
            preferences.edit().clear().commit();

            Intent m = new Intent(MainActivity.this,Login_Activity.class);
            startActivity(m);
            finish();
        }
    };

    View.OnClickListener mb = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent main = new Intent(MainActivity.this,MQ_Activity.class);
//            startActivityForResult(main,10);
            Toast.makeText(getApplicationContext(),"준비중입니다",Toast.LENGTH_LONG).show();
        }
    };
    View.OnClickListener tb = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent together = new Intent(MainActivity.this,TQ3_Activity.class);
            startActivity(together);
        }
    };
    View.OnClickListener cb = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent challenge = new Intent(MainActivity.this,CR_Activity.class);
            startActivityForResult(challenge,20);
        }
    };

    View.OnClickListener v = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentiii = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kakaocorp.com/service/KakaoTalk"));
            startActivity(intentiii);
        }
    };

    View.OnClickListener vv = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentiiii = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"));
            startActivity(intentiiii);
        }
    };

    View.OnClickListener vvv = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intentiiiii = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/"));
            startActivity(intentiiiii);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String str1 = intent.getStringExtra("id");
        id2 = (TextView) findViewById(R.id.id2);
        id2.setText(str1);

        dlayout = (DrawerLayout)findViewById(R.id.dlayout);
        open = (Button)findViewById(R.id.open);
        close = (Button)findViewById(R.id.close);
        logout = (Button)findViewById(R.id.logout);
        kaka = (ImageView) findViewById(R.id.kakao);
        face = (ImageView) findViewById(R.id.face);
        instar = (ImageView) findViewById(R.id.instar);

        open.setOnClickListener(o);
        close.setOnClickListener(c);
        logout.setOnClickListener(l);

        mbtn = findViewById(R.id.mbtn);
        tbtn = findViewById(R.id.tbtn);
        cbtn = findViewById(R.id.cbtn);

        mbtn.setOnClickListener(mb);
        tbtn.setOnClickListener(tb);
        cbtn.setOnClickListener(cb);
        kaka.setOnClickListener(v);
        face.setOnClickListener(vv);
        instar.setOnClickListener(vvv);



    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.e("tag","onStart");
    }
}
