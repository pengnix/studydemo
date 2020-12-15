package com.study.pengnix.ok.utils;

import android.graphics.BitmapFactory;

public class BitmapUtil {
    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // 计算原始图像的高度和宽度
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        //判定，当原始图像的高和宽大于所需高度和宽度时
        if (height > reqHeight || width > reqWidth) {
            final int heightRatio = Math.round((float) height / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            //算出长宽比后去比例小的作为inSamplesize，保障最后imageview的dimension比request的大
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;

            //计算原始图片总像素
            final float totalPixels = width * height;
            // Anything more than 2x the requested pixels we'll sample down further

            //所需总像素*2,长和宽的根号2倍
            final float totalReqPixelsCap =
                    reqWidth * reqHeight * 2;

            //如果遇到很长，或者是很宽的图片时，这个算法比较有用
            while (totalPixels / (inSampleSize * inSampleSize) > totalReqPixelsCap) {

                inSampleSize++;
            }
        }
        return inSampleSize;
    }
}
