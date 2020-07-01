package com.study.pengnix.ok.activity;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.CircleProgressDialog;
import com.study.pengnix.ok.R;
import com.study.pengnix.ok.controller.CustomMediaController;
import com.study.pengnix.ok.view.CustomVideoView;
import com.study.pengnix.ok.view.VerifyEditText;

public class VerficationCodeActivity extends AppCompatActivity {

    private static String TAG = "Code";
    VerifyEditText tvVerify;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_demo);
        tvVerify = findViewById(R.id.et_verify);
        tvVerify.setInputCompleteListener(new VerifyEditText.inputCompleteListener() {
            @Override
            public void inputComplete(VerifyEditText et, String content) {
                Toast.makeText(getApplicationContext(),content,Toast.LENGTH_LONG).show();
            }
        });
    }

}
