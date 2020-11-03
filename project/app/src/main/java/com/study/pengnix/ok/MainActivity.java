package com.study.pengnix.ok;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.study.pengnix.ok.activity.CollapsingToolbarLayoutDemoActivity;
import com.study.pengnix.ok.activity.ConstraintLayoutDemoActivity;
import com.study.pengnix.ok.activity.CoordinatorLayoutDemoActivity;
import com.study.pengnix.ok.activity.EditTextActivity;
import com.study.pengnix.ok.activity.FrameAnimActivity;
import com.study.pengnix.ok.activity.MediaPlayerActivity;
import com.study.pengnix.ok.activity.PathAnimActivity;
import com.study.pengnix.ok.activity.SecondListActivity;
import com.study.pengnix.ok.activity.ThreadActivity;
import com.study.pengnix.ok.activity.TweenActivity;
import com.study.pengnix.ok.activity.ValueAnimActivity;
import com.study.pengnix.ok.activity.VerficationCodeActivity;
import com.study.pengnix.ok.activity.VerficationCodeActivity2;
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
        findViewById(R.id.jump2_code2_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_edit_text_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_thread_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_tween_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_value_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_path_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_frame_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_activity_layout_demo).setOnClickListener(this);
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
                break;
            case R.id.jump2_constraint_layout_demo:
                intent = new Intent(MainActivity.this, ConstraintLayoutDemoActivity.class);
                break;
            case R.id.jump2_video_layout_demo:
                intent = new Intent(MainActivity.this, VideoActivity.class);
                break;
            case R.id.jump2_video_download_layout_demo:
                intent = new Intent(MainActivity.this, VideoShowAfterDownloadActivity.class);
                break;
            case R.id.jump2_second_layout_demo:
                intent = new Intent(MainActivity.this, SecondListActivity.class);
                break;
            case R.id.jump2_code_layout_demo:
                intent = new Intent(MainActivity.this, VerficationCodeActivity.class);
                break;
            case R.id.jump2_code2_layout_demo:
                intent = new Intent(MainActivity.this, VerficationCodeActivity2.class);
                break;
            case R.id.jump2_edit_text_layout_demo:
                intent = new Intent(MainActivity.this, EditTextActivity.class);
                break;
            case R.id.jump2_thread_layout_demo:
                intent = new Intent(MainActivity.this, ThreadActivity.class);
                break;
            case R.id.jump2_tween_layout_demo:
                intent = new Intent(MainActivity.this, TweenActivity.class);
                break;
            case R.id.jump2_value_layout_demo:
                intent = new Intent(MainActivity.this, ValueAnimActivity.class);
                break;
            case R.id.jump2_path_layout_demo:
                intent = new Intent(MainActivity.this, PathAnimActivity.class);
                break;
            case R.id.jump2_frame_layout_demo:
                intent = new Intent(MainActivity.this, FrameAnimActivity.class);
                break;
            case R.id.jump2_activity_layout_demo:
                intent = new Intent(MainActivity.this, FrameAnimActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_left_out);
                return;
        }
        startActivity(intent);
    }
}
