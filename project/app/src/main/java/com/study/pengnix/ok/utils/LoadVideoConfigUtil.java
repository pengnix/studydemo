package com.study.pengnix.ok.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.study.pengnix.ok.bean.VideoConfigBean;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

public class LoadVideoConfigUtil {
    public static final String getVideoConfig() {
        Gson gson=new Gson();
        final HttpHandler httpHandler = new HttpHandler();
        final String jsonStr = httpHandler.makeServiceCall("https://yunbanktest.bankcomm.com:7099/hpbc_uat_web/homeParam/home_param.json");

        VideoConfigBean result = gson.fromJson(jsonStr, VideoConfigBean.class);
        Log.v("1111","1111");
        return jsonStr;
    }
}
