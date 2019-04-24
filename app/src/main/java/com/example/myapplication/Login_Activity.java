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
    Button loginbtn;
    EditText login_et;
    InputMethodManager imm;
    LinearLayout login_layout;
//    EditText pw;

    View.OnClickListener login = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            SharedPreferences sp = getSharedPreferences("a",0);
            SharedPreferences.Editor edit = sp.edit();
            edit.putString("id",login_et.getText().toString());
//            비밀번호
//            edit.putString("pw",pw.getText().toString());
            edit.commit();


            Intent i_login = new Intent(Login_Activity.this,MainActivity.class);
            i_login.putExtra("id",login_et.getText().toString());
//            비밀번호
//            ii.putExtra("pw",pw.getText().toString());
            startActivity(i_login);
            finish();
        }
    };



    View.OnClickListener hideboard = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            hideKeyboard();
            switch (v.getId())
            {
                case R.id.login_layout :
                    break;
            }
        }

        private void hideKeyboard() {
            imm.hideSoftInputFromWindow(login_et.getWindowToken(), 0);
        }
    };





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
         imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        login_layout = findViewById(R.id.login_layout);

        login_et = (EditText) findViewById(R.id.login_et);
//        pw = (EditText) findViewById(R.id.pw1);
        loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(login);
        login_layout.setOnClickListener(hideboard);






    }
}
