package com.study.pengnix.ok.utils;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class CustomToast {
    private static int mDuration = 5000;//toast默认的时间

    private static Toast mToast;
    private static Handler mHandler = new Handler();
    private static Runnable r = new Runnable() {
        public void run() {
            mToast.cancel();
        }
    };

    public static void showToast(Context mContext, String text) {
        showToast(mContext, text, mDuration);
    }

    public static void showToast(Context mContext, int resId) {
        showToast(mContext, mContext.getResources().getString(resId), mDuration);
    }

    public static void showToast(Context mContext, String text, int duration) {

        mHandler.removeCallbacks(r);
        if (mToast != null)
            mToast.setText(text);
        else
            mToast = Toast.makeText(mContext, text, Toast.LENGTH_LONG);
        mHandler.postDelayed(r, duration);

        mToast.show();

    }

    public static void showToast(Context mContext, int resId, int duration) {
        showToast(mContext, mContext.getResources().getString(resId), duration);
    }

    public void test(){
//        public void onSuccess(Meta meta, CommentsBean commentsBean) {
//            if (meta.isSuccess()) {
//                List<CommentsData> list = commentsBean.getList();
//                if (list.size() > 0) {
//                    //发送评论以后页码重置为1
//                    if (page == -1) {
//                        pageNo = 1;
//                        adapter.clear();
//                    }
//                    adapter.addAll(list);
//                } else if (adapter.getCount() <= 0)
//                    easy.showEmpty();
//
//                //判断评论总数，加载完毕显示没有更多
//                int totalNum = Integer.parseInt(commentsBean.getTotalNum());
//                tvCommentNum.setText(commentsBean.getTotalNumStr());
//                if (adapter.getCount() >= totalNum) {
//                    adapter.stopMore();
//                }
//            } else {
//                easy.showError();
//            }
//        }
    }

}
