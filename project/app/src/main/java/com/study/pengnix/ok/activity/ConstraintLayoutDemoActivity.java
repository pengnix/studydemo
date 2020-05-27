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

public class ConstraintLayoutDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraintlayout_demo);
    }

    private void loadData(){
    }
}
