package com.study.pengnix.ok.activity;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.R;

public class FrameAnimActivity extends AppCompatActivity {

    private static String TAG = "Code";
    ImageView oval;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_anim_layout_demo);
        oval = (ImageView) findViewById(R.id.oval);
    }
    public void startAnim(View view) {
        ImageView image = (ImageView) findViewById(R.id.path_line);
        image.setImageResource(R.drawable.animation_list);
        AnimationDrawable anim = (AnimationDrawable) image.getDrawable();
        anim.start();
    }

    public void startAnim2(View view) {
        Animator animator1 = ViewAnimationUtils.createCircularReveal(oval, oval.getWidth() / 2, oval.getHeight() / 2, oval.getWidth(), 0);
        animator1.setDuration(2000);
        animator1.start();
    }
}
