package com.study.pengnix.ok.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.R;
import com.study.pengnix.ok.view.SectorView;

public class ValueAnimActivity extends AppCompatActivity {

    private static String TAG = "Code";
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_anim_layout_demo);
        imageView = findViewById(R.id.value_anim_pic);
        findViewById(R.id.tween_btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnim1();
            }
        });
    }

    public void startAnim1(){
        ValueAnimator animator = ValueAnimator.ofFloat(0, 360);
        animator.setDuration(1000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float value = (float)valueAnimator.getAnimatedValue();
                imageView.setRotationY(value);
            }
        });
        animator.start();
    }

    ObjectAnimator anim4;


    public void startAnim4(View view) {
        final SectorView sectorView = (SectorView)findViewById(R.id.sector_view);
        anim4 = ObjectAnimator.ofFloat(sectorView, "fraction", 0, 1);
        anim4.setDuration(4000);
        anim4.setRepeatCount(ValueAnimator.INFINITE);
        anim4.setRepeatMode(ValueAnimator.RESTART);
        anim4.start();
    }
}
