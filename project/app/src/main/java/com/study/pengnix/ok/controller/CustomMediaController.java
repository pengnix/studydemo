package com.study.pengnix.ok.controller;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.MediaController;

public class CustomMediaController extends MediaController {
    public CustomMediaController(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMediaController(Context context, boolean useFastForward) {
        super(context, useFastForward);
    }

    public CustomMediaController(Context context) {
        super(context);
    }

    @Override
    public void hide() {
        super.show();
    }
}
