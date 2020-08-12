/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.System
 */
package com.applovin.impl.adview;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

public class AppLovinTouchToClickListener
implements View.OnTouchListener {
    private long a;
    private float b;
    private float c;
    private final Context d;
    private final View.OnClickListener e;

    public AppLovinTouchToClickListener(Context context, View.OnClickListener onClickListener) {
        this.d = context;
        this.e = onClickListener;
    }

    private float a(float f2) {
        return f2 / this.d.getResources().getDisplayMetrics().density;
    }

    private float a(float f2, float f3, float f4, float f5) {
        float f6 = f2 - f4;
        float f7 = f3 - f5;
        return this.a((float)Math.sqrt((double)(f6 * f6 + f7 * f7)));
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int n2 = motionEvent.getAction();
        if (n2 != 0) {
            if (n2 != 1) {
                return true;
            }
            if (System.currentTimeMillis() - this.a < 1000L && this.a(this.b, this.c, motionEvent.getX(), motionEvent.getY()) < 10.0f) {
                this.e.onClick(view);
                return true;
            }
        } else {
            this.a = System.currentTimeMillis();
            this.b = motionEvent.getX();
            this.c = motionEvent.getY();
        }
        return true;
    }
}

