/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 */
package com.applovin.impl.adview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.applovin.impl.adview.g;
import com.applovin.impl.sdk.j;

@SuppressLint(value={"ViewConstructor"})
public final class v
extends g {
    private static final Paint d = new Paint(1);
    private static final Paint e = new Paint(1);
    private static final Paint f = new Paint(1);
    private float c = 1.0f;

    public v(j j2, Context context) {
        super(j2, context);
        d.setColor(-1);
        e.setColor(-16777216);
        f.setColor(-1);
        f.setStyle(Paint.Style.STROKE);
    }

    @Override
    public void a(int n2) {
        this.setViewScale((float)n2 / 30.0f);
    }

    protected float getCenter() {
        return this.getSize() / 2.0f;
    }

    protected float getCrossOffset() {
        return 10.0f * this.c;
    }

    protected float getInnerCircleOffset() {
        return 2.0f * this.c;
    }

    protected float getInnerCircleRadius() {
        return this.getCenter() - this.getInnerCircleOffset();
    }

    protected float getSize() {
        return 30.0f * this.c;
    }

    protected float getStrokeWidth() {
        return 3.0f * this.c;
    }

    @Override
    public g.a getStyle() {
        return g.a.a;
    }

    @Override
    public float getViewScale() {
        return this.c;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.getCenter();
        canvas.drawCircle(f2, f2, f2, d);
        canvas.drawCircle(f2, f2, this.getInnerCircleRadius(), e);
        float f3 = this.getCrossOffset();
        float f4 = this.getSize() - f3;
        f.setStrokeWidth(this.getStrokeWidth());
        canvas.drawLine(f3, f3, f4, f4, f);
        canvas.drawLine(f3, f4, f4, f3, f);
    }

    @Override
    public void setViewScale(float f2) {
        this.c = f2;
    }
}

