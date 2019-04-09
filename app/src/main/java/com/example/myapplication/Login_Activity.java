package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class Login_Activity extends AppCompatActivity {
    Button loginb;
    EditText id;
    InputMethodManager imm;
    LinearLayout ll;
//    EditText pw;

    View.OnClickListener lb = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sp = getSharedPreferences("a",0);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("id",id.getText().toString());
//            비밀번호
//            edit.putString("pw",pw.getText().toString());
            edit.commit();


            Intent ii = new Intent(Login_Activity.this,MainActivity.class);
            ii.putExtra("id",id.getText().toString());
//            비밀번호
//            ii.putExtra("pw",pw.getText().toString());
            startActivity(ii);
            finish();
        }
    };



    View.OnClickListener lplp = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            hideKeyboard();
            switch (v.getId())
            {
                case R.id.ll :
                    break;
            }
        }

        private void hideKeyboard() {
            imm.hideSoftInputFromWindow(id.getWindowToken(), 0);
        }
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
         imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
         ll = findViewById(R.id.ll);

        id = (EditText) findViewById(R.id.id1);
//        pw = (EditText) findViewById(R.id.pw1);
        loginb = (Button) findViewById(R.id.loginb);
        loginb.setOnClickListener(lb);
        ll.setOnClickListener(lplp);






    }
}
