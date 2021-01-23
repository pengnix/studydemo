package com.study.pengnix.ok.activity;

import android.app.Dialog;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.study.pengnix.ok.R;
import com.study.pengnix.ok.utils.LoadVideoConfigUtil;
import com.study.pengnix.ok.utils.TimeUtil;
import com.study.pengnix.ok.utils.Utils;

import io.microshow.rxffmpeg.player.RxFFmpegPlayerView;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class VideoRxffActivity extends AppCompatActivity {

    private RxFFmpegPlayerView mPlayerView;
    private static String TAG = "VideoActivity";
    private static String url = "http://jtyh-vod.homecdn.com/butelvod/9d3ac1e9-dc16-4a13-9dc5-394079a9b2cd.mp4";
    SlidingUpPanelLayout slidingLayout;
    TextView main_content;

    Dialog mDialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_rx);
        slidingLayout = findViewById(R.id.sliding_layout);
        main_content = findViewById(R.id.tv1);
        main_content.setClickable(true);
        main_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                        int time = TimeUtil.getServerTimestamp();
//                        main_content.setText(""+time);


                        Observable.create(new ObservableOnSubscribe<Integer>() {
                            @Override
                            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                                String result = LoadVideoConfigUtil.getVideoConfig();//PhotoUtils.saveFile(getBaseContext(), uri);
                                emitter.onNext(1);
                                emitter.onComplete();
                            }
                        }).subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Observer<Integer>() {
                                    @Override
                                    public void onSubscribe(Disposable d) {
                                    }

                                    @Override
                                    public void onNext(Integer s) {
//                                        main_content.setText(""+s);
                                        main_content.setText(Utils.formatViewsNumber(1480000));
//                        filePath = s;
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                    }

                                    @Override
                                    public void onComplete() {
                                    }
                                });



            }
        });
        slidingLayout.setFadeOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                slidingLayout.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
            }
        });

        slidingLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {
                if(newState == SlidingUpPanelLayout.PanelState.EXPANDED){

                } else if(newState == SlidingUpPanelLayout.PanelState.COLLAPSED){

                }
                Log.v("PanelStateChanged","newState = " + newState);
            }
        });
    }

}
