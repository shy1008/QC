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
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button open;
    Button close;
    Button logout;
    TextView login_id;
    Button main_btn;
    Button together_btn;
    Button challenge_btn;
    DrawerLayout d_layout;
    LinearLayout left_layout;

    ImageView kaka;
    ImageView face;
    ImageView instar;



    View.OnClickListener o = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            d_layout.openDrawer(Gravity.LEFT);
        }
    };
    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            d_layout.closeDrawer(Gravity.LEFT);
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
            Intent main = new Intent(MainActivity.this,MQ_Activity.class);
            startActivity(main);
//            Toast.makeText(getApplicationContext(),"준비중입니다",Toast.LENGTH_LONG).show();
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

    View.OnClickListener qc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent qcc = new Intent(Intent.ACTION_VIEW,Uri.parse("https://github.com/shy1008/QC"));
            startActivity(qcc);
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String str1 = intent.getStringExtra("id");
        login_id = (TextView) findViewById(R.id.login_id);
        login_id.setText(str1);

        left_layout = (LinearLayout)findViewById(R.id.left_layout);
        d_layout = (DrawerLayout)findViewById(R.id.d_layout);
        open = (Button)findViewById(R.id.open);
        close = (Button)findViewById(R.id.close);
        logout = (Button)findViewById(R.id.logout);
        kaka = (ImageView) findViewById(R.id.kakao);
        face = (ImageView) findViewById(R.id.face);
        instar = (ImageView) findViewById(R.id.instar);

        open.setOnClickListener(o);
        close.setOnClickListener(c);
        logout.setOnClickListener(l);

        main_btn = findViewById(R.id.main_btn);
        together_btn = findViewById(R.id.together_btn);
        challenge_btn = findViewById(R.id.challenge_btn);

        main_btn.setOnClickListener(mb);
        together_btn.setOnClickListener(tb);
        challenge_btn.setOnClickListener(cb);
        kaka.setOnClickListener(v);
        face.setOnClickListener(vv);
        instar.setOnClickListener(vvv);

        left_layout.setOnClickListener(qc);



    }


    @Override
    protected void onStart() {
        super.onStart();

        Log.e("tag","onStart");
    }
}
