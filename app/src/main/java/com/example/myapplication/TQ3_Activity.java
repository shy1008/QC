package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Nullable;

public class TQ3_Activity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mainrcv;
    private FirebaseFirestore mStore = FirebaseFirestore.getInstance();


    private TQ3_Activity.MainAdapter mainAdapter;
    private List<Board> mBoardList;


    View.OnClickListener v = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Intent vv = new Intent(TQ3_Activity.this,MainActivity.class);
//            startActivity(vv);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tq3_);

        mainrcv = findViewById(R.id.main_recycler_view);

        findViewById(R.id.main_write_button).setOnClickListener(this);
        findViewById(R.id.left).setOnClickListener(v);

        mBoardList = new ArrayList<>();
        mStore.collection("board").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentChange dc : queryDocumentSnapshots.getDocumentChanges()){
                    String id = (String) dc.getDocument().getData().get("id");
                    String title = (String) dc.getDocument().getData().get("title");
//                    Date timestamp = (Date) dc.getDocument().getData().get("timestamp");
                    String contents = (String) dc.getDocument().getData().get("contents");
                    String name = (String) dc.getDocument().getData().get("name");


                    Board data = new Board(id,title, contents,name);

                    mBoardList.add(data);

                }
                mainAdapter = new TQ3_Activity.MainAdapter(mBoardList);
                mainrcv.setAdapter(mainAdapter);


            }


        });

    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this,CR_Activity.class));

    }


    private  class  MainAdapter extends  RecyclerView.Adapter<TQ3_Activity.MainAdapter.MainViewHolder> {

        private List<Board> mBoardList;

        public MainAdapter(List<Board> mBoardList) {
            this.mBoardList = mBoardList;

        }

        @NonNull
        @Override
        public TQ3_Activity.MainAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            return new TQ3_Activity.MainAdapter.MainViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main, viewGroup, false ));
        }

        @Override
        public void onBindViewHolder(@NonNull TQ3_Activity.MainAdapter.MainViewHolder mainViewHolder, int position) {
            Board data = mBoardList.get(position);
            mainViewHolder.mTitleTextView.setText(data.getTitle());
            mainViewHolder.mNameTextView.setText(data.getName());


        }

        @Override
        public int getItemCount() {
            return mBoardList.size();
        }

        class  MainViewHolder extends  RecyclerView.ViewHolder{

            private TextView mTitleTextView;
            private TextView mNameTextView;


            public MainViewHolder(@NonNull View itemView) {
                super(itemView);

                mTitleTextView = itemView.findViewById(R.id.item_title_text);
                mNameTextView = itemView.findViewById(R.id.item_name_text);

            }
        }
    }
}
