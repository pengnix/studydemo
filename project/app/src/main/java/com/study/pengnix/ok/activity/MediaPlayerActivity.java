package com.study.pengnix.ok.activity;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.study.pengnix.ok.R;

public class MediaPlayerActivity extends Activity implements View.OnClickListener {
    private TextView btnplay, btnstop, btnpause;
    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    private int position;
//    private String url1 = "http://yunbanktest.bankcomm.com/hpbc_uat_web/video/20200603/a.mp4";
    private String url1 = "http://yunbanktest.bankcomm.com/hpbc_uat_web/video/20200531/1080_1920_20200531_4e3ead82-aaad-4226-8fe0-c33cde31b4f11.mp4";
    private String url2 = "rtsp://184.72.239.149/vod/mp4:BigBuckBunny_115k.mov";
    private String url3 = "http://42.96.249.166/live/388.m3u8";
    private String url4 = "http://61.129.89.191/ThroughTrain/download.html?id=4035&flag=-org-"; //音频url

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);
        btnplay = this.findViewById(R.id.btnplay);
        btnstop = this.findViewById(R.id.btnstop);
        btnpause = this.findViewById(R.id.btnpause);

        btnstop.setOnClickListener(this);
        btnplay.setOnClickListener(this);
        btnpause.setOnClickListener(this);

        mediaPlayer = new MediaPlayer();
        surfaceView = (SurfaceView) this.findViewById(R.id.surfaceView);

        // 设置SurfaceView自己不管理的缓冲区
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
            }

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if (position > 0) {
                    try {
                        // 开始播放
                        play();
                        // 并直接从指定位置开始播放
                        mediaPlayer.seekTo(position);
                        position = 0;
                    } catch (Exception e) {
                    }
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnplay:
                play();
                break;

            case R.id.btnpause:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                } else {
                    mediaPlayer.start();
                }
                break;

            case R.id.btnstop:
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                break;
            default:
                break;
        }

    }

    @Override
    protected void onPause() {
        // 先判断是否正在播放
        if (mediaPlayer.isPlaying()) {
            // 如果正在播放我们就先保存这个播放位置
            position = mediaPlayer.getCurrentPosition();
            mediaPlayer.stop();
        }
        super.onPause();
    }

    private void play() {
        try {
            mediaPlayer.reset();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            // 设置需要播放的视频
            Uri uri = Uri.parse(url1);
            mediaPlayer.setDataSource(getApplicationContext(), uri);
            // 把视频画面输出到SurfaceView
            mediaPlayer.setDisplay(surfaceView.getHolder());
            mediaPlayer.prepare();
            // 播放
            mediaPlayer.start();
            Toast.makeText(this, "开始播放！", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
        }
    }
}
