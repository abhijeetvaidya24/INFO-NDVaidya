/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.util.DisplayMetrics
 *  android.widget.LinearLayout
 *  java.lang.Math
 */
package com.chartboost.sdk.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

public class aa
extends LinearLayout {
    private final Paint a;
    private final float b = 1.0f;
    private int c = 0;

    public aa(Context context) {
        super(context);
        int n2 = Math.round((float)(5.0f * context.getResources().getDisplayMetrics().density));
        this.setPadding(n2, n2, n2, n2);
        this.setBaselineAligned(false);
        this.a = new Paint();
        this.a.setStyle(Paint.Style.FILL);
    }

    public void a(int n2) {
        this.a.setColor(n2);
        this.invalidate();
    }

    public void b(int n2) {
        this.c = n2;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.getContext().getResources().getDisplayMetrics().density;
        if ((1 & this.c) > 0) {
            canvas.drawRect(0.0f, 0.0f, (float)canvas.getWidth(), f2 * 1.0f, this.a);
        }
        if ((2 & this.c) > 0) {
            canvas.drawRect((float)canvas.getWidth() - f2 * 1.0f, 0.0f, (float)canvas.getWidth(), (float)canvas.getHeight(), this.a);
        }
        if ((4 & this.c) > 0) {
            canvas.drawRect(0.0f, (float)canvas.getHeight() - f2 * 1.0f, (float)canvas.getWidth(), (float)canvas.getHeight(), this.a);
        }
        if ((8 & this.c) > 0) {
            canvas.drawRect(0.0f, 0.0f, f2 * 1.0f, (float)canvas.getHeight(), this.a);
        }
    }
}

