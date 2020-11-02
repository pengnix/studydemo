package com.study.pengnix.ok.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.R;

public class FrameAnimActivity extends AppCompatActivity {

    private static String TAG = "Code";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim_layout_demo);
    }
    public void startAnim(View view) {
        ImageView image = (ImageView) findViewById(R.id.path_line);
        image.setImageResource(R.drawable.animation_list);
        AnimationDrawable anim = (AnimationDrawable) image.getDrawable();
        anim.start();
    }
}
