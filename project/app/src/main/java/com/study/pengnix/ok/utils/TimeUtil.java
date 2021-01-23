package com.study.pengnix.ok.utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static final int getServerTimestamp() {
        final HttpHandler httpHandler = new HttpHandler();
//        final String jsonStr = httpHandler.makeServiceCall("http://quan.suning.com/getSysTime.do");
        final String jsonStr = httpHandler.makeServiceCall("https://yunbanktest.bankcomm.com:7099/hpbc_uat_web/homeParam/home_param.json");


        if (jsonStr != null) {
            try {
                final JSONObject json = new JSONObject(jsonStr);
                if (json.has("sysTime2")) {
                    final String date = json.getString("sysTime2");
                    return dateToTimestamp(date);
                }
            } catch (JSONException e) {
                // e.printStackTrace();
            }
        }

        // 未能获取远程时间，将获取本地时间，根据需要修改.

        return Integer.valueOf(new Date().getTime()/1000+"");
    }


    public static final int dateToTimestamp(String time) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        final Date date;
        try {
            date = dateFormat.parse(time);
        } catch (ParseException e) {
            return 0;
        }
        return Integer.valueOf(date.getTime()/1000+"");
    }
}
