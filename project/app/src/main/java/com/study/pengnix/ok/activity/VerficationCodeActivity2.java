package com.study.pengnix.ok.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.study.pengnix.ok.R;
import com.study.pengnix.ok.view.VerificationCodeInputView;
import com.study.pengnix.ok.view.VerifyEditText;

public class VerficationCodeActivity2 extends AppCompatActivity {

    private static String TAG = "Code";
    VerificationCodeInputView tvVerify;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code2_demo);
        tvVerify = findViewById(R.id.et_verify);
        tvVerify.setOnCompleteListener(new VerificationCodeInputView.CompleteListener() {
            @Override
            public void onComplete(String content) {
                Toast.makeText(getApplicationContext(),content,Toast.LENGTH_LONG).show();
            }
        });
//        tvVerify.setInputCompleteListener(new VerifyEditText.inputCompleteListener() {
//            @Override
//            public void inputComplete(VerifyEditText et, String content) {
//                Toast.makeText(getApplicationContext(),content,Toast.LENGTH_LONG).show();
//            }
//        });
    }

}
