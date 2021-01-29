package com.study.pengnix.ok.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.study.pengnix.ok.R;
import com.study.pengnix.ok.utils.LoadVideoConfigUtil;
import com.study.pengnix.ok.utils.Utils;
import com.study.pengnix.ok.view.IjkVideoView;
import com.tencent.liteav.demo.superplayer.SuperPlayerModel;
import com.tencent.liteav.demo.superplayer.SuperPlayerView;

import io.microshow.rxffmpeg.player.RxFFmpegPlayerView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class VideoRxffActivity2 extends AppCompatActivity {

    private static String TAG = "VideoActivity";
    private static String url = "http://jtyh-vod.homecdn.com/butelvod/d039207a-e61e-483d-b37d-7676831e3e2d.m3u8";
    SuperPlayerView mSuperPlayerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_rx2);
        init();
    }

    void init(){
        mSuperPlayerView = findViewById(R.id.gogogo1);
        SuperPlayerModel model = new SuperPlayerModel();

        model.url = url;

        mSuperPlayerView.playWithModel(model);
    }

}
