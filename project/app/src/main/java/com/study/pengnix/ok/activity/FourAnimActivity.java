package com.study.pengnix.ok.activity;

import android.animation.Animator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.R;

public class FourAnimActivity extends AppCompatActivity {

    private static String TAG = "Code";
    Button btnExplode,btnSlide,btnFade,btnShare;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_layout_demo);
        btnExplode = findViewById(R.id.btn_explode);
        btnSlide = findViewById(R.id.btn_slide);
        btnFade = findViewById(R.id.btn_fade);
        btnShare = findViewById(R.id.btn_share);
        btnExplode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                explore();
            }
        });
        btnSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slide();
            }
        });
        btnFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fade();
            }
        });
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                share();
            }
        });
    }

    void explore(){
        Intent intent = new Intent(this, CActivity.class);
        intent.putExtra("flag", 0);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    void slide(){
        Intent intent = new Intent(this, CActivity.class);
        intent.putExtra("flag", 1);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    void fade(){
        Intent intent = new Intent(this, CActivity.class);
        intent.putExtra("flag", 2);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    void share(){
        View fab = findViewById(R.id.fab_button);
        View txName = findViewById(R.id.tx_user_name);
        Intent intent = new Intent(this, CActivity.class);
        intent.putExtra("flag", 3);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this,
                Pair.create(btnShare, "share"),
                Pair.create(fab, "fab"),
                Pair.create(txName, "user_name"))
                .toBundle());
    }
}
