package com.study.pengnix.ok.activity;

import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.study.pengnix.ok.R;
import com.study.pengnix.ok.view.SearchView;

/**
 * <p>write the description
 *
 * @author renjialiang
 * @version [版本号]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
public class DrawPathActivity extends AppCompatActivity {

    private SearchView searchView;
    private LottieAnimationView lav_show;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_path);
        searchView = (SearchView)findViewById(R.id.searchview);
        test();
    }

    public void test(){
        lav_show = (LottieAnimationView) findViewById(R.id.animation_view);
        //设置动画文件
        lav_show.setAnimation("loadAnim.json");
        //执行动画
        lav_show.playAnimation();
    }

    public void startSearchView(View view) {
        searchView.startAnim();
    }
}