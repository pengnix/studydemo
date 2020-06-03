package com.study.pengnix.ok.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.VideoView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.R;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;
    private static String TAG = "VideoActivity";
    private static String url = "http://yunbanktest.bankcomm.com/hpbc_uat_web/video/20200531/1080_1920_20200531_4e3ead82-aaad-4226-8fe0-c33cde31b4f11.mp4";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_demo);
        videoView = findViewById(R.id.album_video);
        videoView.setVisibility(View.VISIBLE);
        videoView.setVideoPath(url);
        videoView.start();
//                    progressDialog.show();
        videoView.setOnInfoListener((mediaPlayer, i, i1) -> {
            if(i == MediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START){
//                            progressDialog.dismiss();
            }
            Log.i(TAG,"listener = " + i);
            return true;
        });
    }


}
