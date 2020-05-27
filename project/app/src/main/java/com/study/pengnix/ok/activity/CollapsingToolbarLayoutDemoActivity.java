package com.study.pengnix.ok.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.study.pengnix.ok.R;
import com.study.pengnix.ok.adapter.ColorBlockAdapter;
import com.study.pengnix.ok.bean.ColorBlock;

import java.util.ArrayList;
import java.util.List;

public class CollapsingToolbarLayoutDemoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ColorBlockAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapsingtoolbar_layout_demo);
        recyclerView = findViewById(R.id.coordinatorLayout_demo_recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        loadData();
    }

    private void loadData(){
        List list = new ArrayList<ColorBlock>();
        for(int i =0;i<20;i++){
            list.add(new ColorBlock(String.valueOf(i)));
        }
        adapter = new ColorBlockAdapter(list);
        recyclerView.setAdapter(adapter);
    }
}
