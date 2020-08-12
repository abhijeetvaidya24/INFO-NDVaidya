/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  java.lang.CharSequence
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.impl.adview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class e
extends View {
    private static final int s = Color.rgb((int)66, (int)145, (int)241);
    private static final int t = Color.rgb((int)66, (int)145, (int)241);
    private static final int u = Color.rgb((int)66, (int)145, (int)241);
    protected Paint a;
    protected Paint b;
    private Paint c;
    private Paint d;
    private RectF e = new RectF();
    private float f;
    private int g;
    private int h;
    private int i = 0;
    private int j;
    private int k;
    private float l;
    private int m;
    private String n = "";
    private String o = "";
    private float p;
    private String q = "";
    private float r;
    private final float v = a.b(this.getResources(), 4.0f);
    private final float w = a.a(this.getResources(), 14.0f);
    private final float x = a.a(this.getResources(), 18.0f);
    private final int y = (int)a.b(this.getResources(), 100.0f);

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context context, AttributeSet attributeSet, int n2) {
        super(context, attributeSet, n2);
        this.b();
        this.a();
    }

    private int a(int n2) {
        int n3 = View.MeasureSpec.getMode((int)n2);
        int n4 = View.MeasureSpec.getSize((int)n2);
        if (n3 == 1073741824) {
            return n4;
        }
        int n5 = this.y;
        if (n3 == Integer.MIN_VALUE) {
            return Math.min((int)n5, (int)n4);
        }
        return n5;
    }

    private float getProgressAngle() {
        return 360.0f * ((float)this.getProgress() / (float)this.j);
    }

    protected void a() {
        this.a = new TextPaint();
        this.a.setColor(this.g);
        this.a.setTextSize(this.f);
        this.a.setAntiAlias(true);
        this.b = new TextPaint();
        this.b.setColor(this.h);
        this.b.setTextSize(this.p);
        this.b.setAntiAlias(true);
        this.c = new Paint();
        this.c.setColor(this.k);
        this.c.setStyle(Paint.Style.STROKE);
        this.c.setAntiAlias(true);
        this.c.setStrokeWidth(this.l);
        this.d = new Paint();
        this.d.setColor(this.m);
        this.d.setAntiAlias(true);
    }

    protected void b() {
        this.k = s;
        this.g = t;
        this.f = this.w;
        this.setMax(100);
        this.setProgress(0);
        this.l = this.v;
        this.m = 0;
        this.p = this.x;
        this.h = u;
    }

    public int getFinishedStrokeColor() {
        return this.k;
    }

    public float getFinishedStrokeWidth() {
        return this.l;
    }

    public int getInnerBackgroundColor() {
        return this.m;
    }

    public String getInnerBottomText() {
        return this.q;
    }

    public int getInnerBottomTextColor() {
        return this.h;
    }

    public float getInnerBottomTextSize() {
        return this.p;
    }

    public int getMax() {
        return this.j;
    }

    public String getPrefixText() {
        return this.n;
    }

    public int getProgress() {
        return this.i;
    }

    public String getSuffixText() {
        return this.o;
    }

    public int getTextColor() {
        return this.g;
    }

    public float getTextSize() {
        return this.f;
    }

    public void invalidate() {
        this.a();
        super.invalidate();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.l;
        this.e.set(f2, f2, (float)this.getWidth() - f2, (float)this.getHeight() - f2);
        float f3 = this.getWidth();
        float f4 = this.l;
        float f5 = (f4 + (f3 - f4)) / 2.0f;
        canvas.drawCircle((float)this.getWidth() / 2.0f, (float)this.getHeight() / 2.0f, f5, this.d);
        canvas.drawArc(this.e, 270.0f, -this.getProgressAngle(), false, this.c);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.n);
        stringBuilder.append(this.i);
        stringBuilder.append(this.o);
        String string = stringBuilder.toString();
        if (!TextUtils.isEmpty((CharSequence)string)) {
            float f6 = this.a.descent() + this.a.ascent();
            canvas.drawText(string, ((float)this.getWidth() - this.a.measureText(string)) / 2.0f, ((float)this.getWidth() - f6) / 2.0f, this.a);
        }
        if (!TextUtils.isEmpty((CharSequence)this.getInnerBottomText())) {
            this.b.setTextSize(this.p);
            float f7 = (float)this.getHeight() - this.r - (this.a.descent() + this.a.ascent()) / 2.0f;
            canvas.drawText(this.getInnerBottomText(), ((float)this.getWidth() - this.b.measureText(this.getInnerBottomText())) / 2.0f, f7, this.b);
        }
    }

    protected void onMeasure(int n2, int n3) {
        this.setMeasuredDimension(this.a(n2), this.a(n3));
        this.r = this.getHeight() - 3 * this.getHeight() / 4;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle)parcelable;
            this.g = bundle.getInt("text_color");
            this.f = bundle.getFloat("text_size");
            this.p = bundle.getFloat("inner_bottom_text_size");
            this.q = bundle.getString("inner_bottom_text");
            this.h = bundle.getInt("inner_bottom_text_color");
            this.k = bundle.getInt("finished_stroke_color");
            this.l = bundle.getFloat("finished_stroke_width");
            this.m = bundle.getInt("inner_background_color");
            this.a();
            this.setMax(bundle.getInt("max"));
            this.setProgress(bundle.getInt("progress"));
            this.n = bundle.getString("prefix");
            this.o = bundle.getString("suffix");
            super.onRestoreInstanceState(bundle.getParcelable("saved_instance"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("saved_instance", super.onSaveInstanceState());
        bundle.putInt("text_color", this.getTextColor());
        bundle.putFloat("text_size", this.getTextSize());
        bundle.putFloat("inner_bottom_text_size", this.getInnerBottomTextSize());
        bundle.putFloat("inner_bottom_text_color", (float)this.getInnerBottomTextColor());
        bundle.putString("inner_bottom_text", this.getInnerBottomText());
        bundle.putInt("inner_bottom_text_color", this.getInnerBottomTextColor());
        bundle.putInt("finished_stroke_color", this.getFinishedStrokeColor());
        bundle.putInt("max", this.getMax());
        bundle.putInt("progress", this.getProgress());
        bundle.putString("suffix", this.getSuffixText());
        bundle.putString("prefix", this.getPrefixText());
        bundle.putFloat("finished_stroke_width", this.getFinishedStrokeWidth());
        bundle.putInt("inner_background_color", this.getInnerBackgroundColor());
        return bundle;
    }

    public void setFinishedStrokeColor(int n2) {
        this.k = n2;
        this.invalidate();
    }

    public void setFinishedStrokeWidth(float f2) {
        this.l = f2;
        this.invalidate();
    }

    public void setInnerBackgroundColor(int n2) {
        this.m = n2;
        this.invalidate();
    }

    public void setInnerBottomText(String string) {
        this.q = string;
        this.invalidate();
    }

    public void setInnerBottomTextColor(int n2) {
        this.h = n2;
        this.invalidate();
    }

    public void setInnerBottomTextSize(float f2) {
        this.p = f2;
        this.invalidate();
    }

    public void setMax(int n2) {
        if (n2 > 0) {
            this.j = n2;
            this.invalidate();
        }
    }

    public void setPrefixText(String string) {
        this.n = string;
        this.invalidate();
    }

    public void setProgress(int n2) {
        this.i = n2;
        if (this.i > this.getMax()) {
            this.i %= this.getMax();
        }
        this.invalidate();
    }

    public void setSuffixText(String string) {
        this.o = string;
        this.invalidate();
    }

    public void setTextColor(int n2) {
        this.g = n2;
        this.invalidate();
    }

    public void setTextSize(float f2) {
        this.f = f2;
        this.invalidate();
    }

    private static class a {
        static /* synthetic */ float a(Resources resources, float f2) {
            return a.d(resources, f2);
        }

        static /* synthetic */ float b(Resources resources, float f2) {
            return a.c(resources, f2);
        }

        private static float c(Resources resources, float f2) {
            return 0.5f + f2 * resources.getDisplayMetrics().density;
        }

        private static float d(Resources resources, float f2) {
            return f2 * resources.getDisplayMetrics().scaledDensity;
        }
    }

}

