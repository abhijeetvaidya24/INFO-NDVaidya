/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.widget.RelativeLayout
 */
package com.appsgeyser.multiTabApp.ui.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class TransparentPanel
extends RelativeLayout {
    private Paint borderPaint;
    private Paint innerPaint;

    public TransparentPanel(Context context) {
        super(context);
        this.init();
    }

    public TransparentPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init();
    }

    private void init() {
        this.innerPaint = new Paint();
        this.innerPaint.setARGB(225, 75, 75, 75);
        this.innerPaint.setAntiAlias(true);
        this.borderPaint = new Paint();
        this.borderPaint.setARGB(255, 160, 160, 160);
        this.borderPaint.setAntiAlias(true);
        this.borderPaint.setStyle(Paint.Style.STROKE);
        this.borderPaint.setStrokeWidth(2.0f);
    }

    protected void dispatchDraw(Canvas canvas) {
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, (float)this.getMeasuredWidth(), (float)this.getMeasuredHeight());
        canvas.drawRoundRect(rectF, 10.0f, 10.0f, this.innerPaint);
        canvas.drawRoundRect(rectF, 10.0f, 10.0f, this.borderPaint);
        super.dispatchDraw(canvas);
    }

    public void setBorderPaint(Paint paint) {
        this.borderPaint = paint;
    }

    public void setInnerPaint(Paint paint) {
        this.innerPaint = paint;
    }
}

