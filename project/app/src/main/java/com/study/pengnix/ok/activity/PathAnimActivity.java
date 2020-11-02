package com.study.pengnix.ok.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.R;
import com.study.pengnix.ok.view.SectorView;

public class PathAnimActivity extends AppCompatActivity {

    private static String TAG = "Code";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_anim_layout_demo);
        iv = (ImageView)findViewById(R.id.path_line);
        screenWidth = getResources().getDisplayMetrics().widthPixels;
        screenHeight = getResources().getDisplayMetrics().heightPixels;
    }


    private ImageView iv;

    private int screenWidth;

    private int screenHeight;

    public void startAnim5(View view) {
        Path path = new Path();
        path.moveTo(100, 100);
        path.quadTo(screenWidth - 300, 200, screenWidth - 100, screenHeight - 600);

        ObjectAnimator animator = ObjectAnimator.ofFloat(iv, View.X, View.Y, path);
        animator.setInterpolator(new OvershootInterpolator());
        animator.setDuration(2000);
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();

//        CommonAnimator.animatePath(iv, path).duration(2000).delay(0).repeat(1, ValueAnimator.REVERSE).fastOutSlowIn().start();
    }
}
