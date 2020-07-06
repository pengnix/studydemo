package com.study.pengnix.ok.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatEditText;

import java.lang.reflect.Field;

public class EditTextCustomNew extends AppCompatEditText {

    private Boolean hasCustomBg = false;
    private Paint mPaint;// 画笔
    // 下划线属性
    private int  mClickColor = 0;
    private int  mUnClickColor = 0;
    private int mColor= 0;
    private float mSpacing = 0f;
    private float mHeight = 0f;

    private Drawable mNormalBG;
    private Drawable mFocusBG;

    public EditTextCustomNew(Context context) {
        super(context);
        initView();
    }

    public EditTextCustomNew(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public EditTextCustomNew(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    void initView(){
        mPaint = new Paint();
    }

    /**
     * 设置是否有自定义的Drawable的背景
     *
     * @param hasCustomBg 是否有自定义的背景
     */
    void setHasCustomBG(Boolean hasCustomBg) {
        this.hasCustomBg = hasCustomBg;
    }

    /**
     * 设置自定义的光标
     *
     * @param ResId 资源id
     */
    void setCursor(int ResId) {
        try {
            // 1. 通过反射 获取光标属性
            Field f = TextView.class.getDeclaredField("mCursorDrawableRes");
            f.setAccessible(true);
            // 2. 传入资源ID
            f.set(this, ResId);
//            f.set(this, ResId);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e ) {
            e.printStackTrace();
        }

    }

    /**
     * 设置下划线的属性并绘制
     *
     * @param clickColor   点击时的颜色
     * @param unClickColor 没有点击时的颜色
     * @param spacing      下划线的间隔
     * @param height       下划线的高度
     */
    void setUnderline(int clickColor, int unClickColor, float spacing, float height) {
        setBackground(null);
//        background = null;
        mClickColor = clickColor;
        mUnClickColor = unClickColor;
        mSpacing = spacing;
        mHeight = height;
        mColor = mUnClickColor;
        invalidate();
    }

    /**
     * 设置聚焦时的背景和和非聚焦时的背景
     *
     * @param boxBgNormal 未聚焦的背景
     * @param boxBgFocus  聚焦时的背景
     */
    void setBackGround(Drawable boxBgNormal,Drawable boxBgFocus ) {
        mNormalBG = boxBgNormal;
        mFocusBG = boxBgFocus;
        setBackground(mNormalBG);
//        background = mNormalBG;
    }

    @Override
    public void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (!hasCustomBg) {
            setFocus(focused);
        } else {
            setBg(focused);
        };
    }

    void setFocus(Boolean isFocus) {
        mColor = isFocus? mClickColor : mUnClickColor;
        invalidate();
    }

    void setBg(Boolean isFocus) {
        setBackground((isFocus? mFocusBG : mNormalBG));
//        background = (isFocus? mFocusBG : mNormalBG);

    }

    @Override
    public void  onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.color = mColor;
        mPaint.setColor(mColor);
        Log.d("test", "Height = $measuredHeight Width =$measuredWidth");
        // 通过画矩形的方式去控制下划线的宽度高度等 如果下划线高度只有1的话 会过细导致颜色不清晰，因此默认会加1px的高度
        if (!hasCustomBg) {
            canvas.drawRect(
                    0f, this.getMeasuredHeight() + mSpacing, (this.getMeasuredWidth() + this.getScrollX()),
                    this.getMeasuredHeight() + mSpacing + mHeight, mPaint
            );
        }
    }
}
