package com.android.floatbutton;

import android.view.WindowManager;
import android.app.Application;

public class FloatApplication  extends Application {
    private WindowManager.LayoutParams windowParams = new WindowManager.LayoutParams();

    public WindowManager.LayoutParams getWindowParams() {
        return windowParams;
    }
}
