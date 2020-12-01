package com.study.pengnix.ok;

import android.app.Application;
import android.os.StrictMode;

import io.microshow.rxffmpeg.RxFFmpegInvoke;

public class DemoApp extends Application {

    boolean DEVELOPER_MODE = false;

    @Override
    public void onCreate() {
        initStrictMode();
        super.onCreate();
        new Thread(new Runnable() {
            @Override
            public void run() {
                initSDKs();
            }
        }).start();
    }

    void initSDKs() {
        RxFFmpegInvoke.getInstance().setDebug(true);
    }

    void initStrictMode() {
        if (DEVELOPER_MODE) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
//                    .detectDiskReads()
//                    .detectDiskWrites()
//                    .detectNetwork()
                    .detectAll()// or .detectAll() for all detectable problems
                    .penaltyLog()
                    .penaltyDialog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }
    }
}
