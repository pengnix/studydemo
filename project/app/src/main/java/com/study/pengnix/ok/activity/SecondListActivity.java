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
        adapter.setEmptyView(R.layout.view_comments_empty);

        adapter.setData(datas);
        rv.setAdapter(adapter);
    }

    void setDatas(){
        for (int i = 0; i < 6; i++) {
            datas.add(new SecondaryListAdapter.DataTree<String, String>(String.valueOf(i), new
                    ArrayList<String>(){{add("sub 0"); add("sub 1"); add("sub 2");}}));
        }
        //todo 后面处理一下null的bug
//        datas.add(new SecondaryListAdapter.DataTree<String, String>(String.valueOf(6), null));
        datas.add(new SecondaryListAdapter.DataTree<String, String>(String.valueOf(11), new
                ArrayList<String>()));
        datas.add(new SecondaryListAdapter.DataTree<String, String>(String.valueOf(12), new
                ArrayList<String>()));
        datas.add(new SecondaryListAdapter.DataTree<String, String>(String.valueOf(13), new
                ArrayList<String>()));
        datas.add(new SecondaryListAdapter.DataTree<String, String>(String.valueOf(7), new
                ArrayList<String>(){{add("sub 0");}}));
        datas.add(new SecondaryListAdapter.DataTree<String, String>(String.valueOf(8), new
                ArrayList<String>(){{add("sub 0"); add("sub 1"); add("sub 2");}}));
        datas.add(new SecondaryListAdapter.DataTree<String, String>(String.valueOf(9), new
                ArrayList<String>(){{add("sub 0"); add("sub 1"); add("sub 2");}}));
    }
}
