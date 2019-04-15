package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CR_Activity extends AppCompatActivity  {

    private FirebaseFirestore mStroe = FirebaseFirestore.getInstance();


    Button left;
    private EditText chname;
    private EditText chtext;
    private  String id;
    InputMethodManager imm;
    LinearLayout ll2;

    View.OnClickListener lplp = new View.OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            hideKeyboard();
            switch (v.getId())
            {
                case R.id.ll3:
                    break;
            }
        }

        private void hideKeyboard() {
            imm.hideSoftInputFromWindow(chtext.getWindowToken(), 0);
            imm.hideSoftInputFromWindow(chname.getWindowToken(), 0);
        }
        };





    View.OnClickListener p;

    {
        p = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                id = mStroe.collection("board").document().getId();


                Map<String, Object> post = new HashMap<>();
                post.put("id", id);
                post.put("title", chname.getText().toString());
//            post.put("timestamp", D);
                post.put("content", null);
                post.put("name", chtext.getText().toString());


                mStroe.collection("board").document(id).set(post)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(CR_Activity.this, "업로드성공", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CR_Activity.this, "업로드 실패", Toast.LENGTH_SHORT).show();
                    }
                });


            }
        };
    }

    View.OnClickListener lt = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent leftt = new Intent(CR_Activity.this, TQ3_Activity.class);
//            startActivity(leftt);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cr_);


        left = (Button) findViewById(R.id.left);
        chname = (EditText) findViewById(R.id.chname);
        chtext = (EditText) findViewById(R.id.chtext);
        imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        ll2= findViewById(R.id.ll3);
        ll2.setOnClickListener(lplp);

        findViewById(R.id.res).setOnClickListener(p);
        left.setOnClickListener(lt);



    }




}
