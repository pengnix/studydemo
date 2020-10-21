package com.study.pengnix.ok.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.R;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TweenActivity extends AppCompatActivity {

    private static String TAG = "Code";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_layout_demo);
        findViewById(R.id.tween_btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnim1();
            }
        });
    }

    public void startAnim1(){
        Log.v("goodman","111111");
        LinearLayout layout = findViewById(R.id.layout_1);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.tween_1);
        layout.startAnimation(animation);
    }
}
