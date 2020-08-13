package com.study.pengnix.ok;

import android.app.Application;

import io.microshow.rxffmpeg.RxFFmpegInvoke;

public class DemoApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initSDKs();
    }

    void initSDKs(){
        RxFFmpegInvoke.getInstance().setDebug(true);
    }
}
