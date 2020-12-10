package com.study.pengnix.ok;

import android.content.Intent;
import android.os.Bundle;
import com.study.pengnix.ok.activity.*;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

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
        findViewById(R.id.jump2_four_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_vector_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_progress_layout_demo).setOnClickListener(this);
        findViewById(R.id.jump2_search_layout_demo).setOnClickListener(this);
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
            case R.id.jump2_four_layout_demo:
                intent = new Intent(MainActivity.this, FourAnimActivity.class);
                break;
            case R.id.jump2_vector_layout_demo:
                intent = new Intent(MainActivity.this, AnimVectorActivity.class);
                break;
            case R.id.jump2_progress_layout_demo:
                intent = new Intent(MainActivity.this, CustomSVGActivity2.class);
                break;
            case R.id.jump2_search_layout_demo:
                intent = new Intent(MainActivity.this, DrawPathActivity.class);
                break;
        }
        startActivity(intent);
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        Log.v("onTrimMemory","level="+level);
    }
}
