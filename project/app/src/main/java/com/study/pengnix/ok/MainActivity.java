package com.study.pengnix.ok;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.study.pengnix.ok.activity.CollapsingToolbarLayoutDemoActivity;
import com.study.pengnix.ok.activity.ConstraintLayoutDemoActivity;
import com.study.pengnix.ok.activity.CoordinatorLayoutDemoActivity;
import com.study.pengnix.ok.activity.MediaPlayerActivity;
import com.study.pengnix.ok.activity.SecondListActivity;
import com.study.pengnix.ok.activity.VerficationCodeActivity;
import com.study.pengnix.ok.activity.VideoActivity;
import com.study.pengnix.ok.activity.VideoShowAfterDownloadActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.jump2_coordinator_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_collapsing_toolbar_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_constraint_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_video_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_video_download_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_second_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_code_layout_demo).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()){
            case R.id.jump2_coordinator_layout_demo:
                intent = new Intent(MainActivity.this, CoordinatorLayoutDemoActivity.class);
                break;
            case R.id.jump2_collapsing_toolbar_layout_demo:
                intent = new Intent(MainActivity.this, CollapsingToolbarLayoutDemoActivity.class);
            case R.id.jump2_constraint_layout_demo:
                intent = new Intent(MainActivity.this, ConstraintLayoutDemoActivity.class);
            case R.id.jump2_video_layout_demo:
                intent = new Intent(MainActivity.this, VideoActivity.class);
            case R.id.jump2_video_download_layout_demo:
                intent = new Intent(MainActivity.this, VideoShowAfterDownloadActivity.class);
            case R.id.jump2_second_layout_demo:
                intent = new Intent(MainActivity.this, SecondListActivity.class);
            case R.id.jump2_code_layout_demo:
                intent = new Intent(MainActivity.this, VerficationCodeActivity.class);
        }
        startActivity(intent);
    }
}
