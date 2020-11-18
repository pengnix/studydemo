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
    ImageView imgBtn,iv2,iv1;
    private boolean isTwitterChecked = false;
    private boolean isSearchBoxChecked = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vector_layout_demo);
        imgBtn = findViewById(R.id.imgBtn);
        iv2 = findViewById(R.id.iv_2);
        iv1 = findViewById(R.id.iv_1);
    }

    public void startAnim(View view){
        Drawable drawable = imgBtn.getDrawable();
        ((Animatable) drawable).start();
    }

    public void onTwitterClick(View view) {
        isTwitterChecked = !isTwitterChecked;
        final int[] stateSet = {android.R.attr.state_checked * (isTwitterChecked ? 1 : -1)};
        iv2.setImageState(stateSet, true);
    }

    public void onSearchBoxClick(View view) {
        isSearchBoxChecked = !isSearchBoxChecked;
        final int[] stateSet = {android.R.attr.state_checked * (isSearchBoxChecked ? 1 : -1)};
        iv1.setImageState(stateSet, true);
    }
}
