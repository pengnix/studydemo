package com.study.pengnix.ok.activity;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.R;

import io.microshow.rxffmpeg.player.RxFFmpegPlayerView;

public class VideoRxffActivity extends AppCompatActivity {

    private RxFFmpegPlayerView mPlayerView;
    private static String TAG = "VideoActivity";
    private static String url = "http://jtyh-vod.homecdn.com/butelvod/9d3ac1e9-dc16-4a13-9dc5-394079a9b2cd.mp4";

    Dialog mDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_rx);
    }

}
