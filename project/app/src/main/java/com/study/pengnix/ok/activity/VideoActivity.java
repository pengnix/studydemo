package com.study.pengnix.ok.activity;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.CircleProgressDialog;
import com.study.pengnix.ok.R;
import com.study.pengnix.ok.controller.CustomMediaController;
import com.study.pengnix.ok.download.DownLoadObserver;
import com.study.pengnix.ok.download.DownloadManager;
import com.study.pengnix.ok.download.DownloadTask;
import com.study.pengnix.ok.view.CustomVideoView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.disposables.Disposable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class VideoActivity extends AppCompatActivity {

    private CustomVideoView videoView;
    CustomMediaController mediaController ;
    private static String TAG = "VideoActivity";
    private static String url = "http://yunbanktest.bankcomm.com/hpbc_uat_web/video/20200531/1080_1920_20200531_4e3ead82-aaad-4226-8fe0-c33cde31b4f11.mp4";
//    private static String url = "http://yunbanktest.bankcomm.com/hpbc_uat_web/video/20200603/a.mp4";

    Dialog mDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_demo);

        mDialog = CircleProgressDialog.createLoadingDialog(this);
        mDialog.setCancelable(true);//允许返回
//        mDialog.show();//显示
        videoView = findViewById(R.id.album_video);
        mediaController = new CustomMediaController(VideoActivity.this);
        videoView.setVideoPath(url);
        videoView.setVisibility(View.VISIBLE);
        videoView.setMediaController(mediaController);
        mediaController.setVisibility(View.VISIBLE);
        videoView.setOnInfoListener((mediaPlayer, i, i1) -> {
            if (i == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
                mDialog.dismiss();
                mediaController.show();
            }
            Log.i(TAG, "listener = " + i);
            return true;
        });
        videoView.start();
        mDialog.show();
        fench();
    }

    private void fench(){

    }

}
