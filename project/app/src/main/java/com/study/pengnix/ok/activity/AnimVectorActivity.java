package com.study.pengnix.ok.activity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.R;

public class AnimVectorActivity extends AppCompatActivity {

    private static String TAG = "Code";
    ImageView imgBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_layout_demo);
        imgBtn = findViewById(R.id.imgBtn);
    }

    public void startAnim(View view){
        Drawable drawable = imgBtn.getDrawable();
        ((Animatable) drawable).start();
    }
}
