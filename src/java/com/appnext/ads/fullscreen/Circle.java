/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.View
 *  com.appnext.core.f
 */
package com.appnext.ads.fullscreen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.appnext.core.f;

public class Circle
extends View {
    private static final int au = 180;
    private Paint av;
    private RectF aw;
    private float ax;

    public Circle(Context context) {
        super(context);
        this.init(context);
    }

    public Circle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(context);
    }

    private static int a(Context context, float f2) {
        return f.a((Context)context, (float)f2);
    }

    private void init(Context context) {
        float f2 = f.a((Context)context, (float)5.0f);
        this.av = new Paint();
        this.av.setAntiAlias(true);
        this.av.setStyle(Paint.Style.STROKE);
        this.av.setStrokeWidth(f2);
        this.av.setColor(-1);
        this.av.setShadowLayer(2.0f, 2.0f, 2.0f, Color.argb((int)128, (int)0, (int)0, (int)0));
        this.setLayerType(1, this.av);
        this.aw = new RectF(f2, f2, f2 + (float)f.a((Context)context, (float)20.0f), f2 + (float)f.a((Context)context, (float)20.0f));
        this.ax = 360.0f;
    }

    public float getAngle() {
        return this.ax;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(this.aw, 180.0f, this.ax, false, this.av);
    }

    public void setAngle(float f2) {
        this.ax = f2;
    }
}

