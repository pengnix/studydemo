package com.study.pengnix.ok.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.pengnix.ok.R;
import com.study.pengnix.ok.adapter.CommentRecyclerAdapter;
import com.study.pengnix.ok.adapter.RvDividerItemDecoration;
import com.study.pengnix.ok.adapter.SecondaryListAdapter;

import java.util.ArrayList;
import java.util.List;

public class SecondListActivity extends AppCompatActivity {

    private List<SecondaryListAdapter.DataTree<String, String>> datas = new ArrayList<>();
    RecyclerView rv;
    CommentRecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_list_layout);
        rv = (RecyclerView) findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setHasFixedSize(true);
        rv.addItemDecoration(new RvDividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        setDatas();
        adapter = new CommentRecyclerAdapter(this);

        adapter.setData(datas);
        rv.setAdapter(adapter);
    }

    void setDatas(){
        for (int i = 0; i < 10; i++) {

            datas.add(new SecondaryListAdapter.DataTree<String, String>(String.valueOf(i), new
                    ArrayList<String>(){{add("sub 0"); add("sub 1"); add("sub 2");}}));

        }
    }
}
