/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.text.TextPaint
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adincube.sdk.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.adincube.sdk.util.b.i;

public final class a
extends Drawable {
    private static final float a = (float)Math.sqrt((double)2.0);
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private Integer h = null;
    private String i = null;
    private Paint j = null;
    private Paint k = null;
    private Paint l = null;
    private TextPaint m = null;
    private int n;
    private int o;
    private int p;
    private int q;

    public a(Context context) {
        this.b = i.a(context, 17.0f);
        this.c = i.a(context, 8.5f);
        this.d = i.a(context, 3.0f);
        this.f = i.a(context, 3.0f);
        this.e = i.a(context, 1.0f);
        this.g = (int)TypedValue.applyDimension((int)2, (float)16.0f, (DisplayMetrics)context.getResources().getDisplayMetrics());
        this.o = i.a(context, 5.3333335f);
        this.p = i.a(context, 4.6666665f);
        this.n = i.a(context, 5.3333335f);
        this.q = i.a(context, 4.6666665f);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(-16777216);
        paint.setAlpha(168);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(0.0f);
        this.j = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setColor(-1);
        paint2.setStrokeWidth((float)this.f);
        paint2.setAntiAlias(true);
        this.k = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setColor(-1);
        paint3.setStrokeWidth((float)this.d);
        paint3.setStrokeCap(Paint.Cap.ROUND);
        paint3.setAntiAlias(true);
        this.l = paint3;
        TextPaint textPaint = new TextPaint();
        textPaint.setColor(-1);
        textPaint.setTypeface(Typeface.DEFAULT);
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
        this.m = textPaint;
    }

    private void a(String string, TextPaint textPaint, int n2, int n3, int n4) {
        String string2 = this.i;
        if (string2 != null && string2.length() == string.length()) {
            return;
        }
        this.i = "9";
        for (int i2 = 1; i2 < string.length(); ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.i);
            stringBuilder.append("9");
            this.i = stringBuilder.toString();
        }
        Rect rect = new Rect();
        do {
            textPaint.setTextSize((float)n2);
            String string3 = this.i;
            textPaint.getTextBounds(string3, 0, string3.length(), rect);
        } while (--n2 > 0 && (rect.width() > n3 || rect.height() > n4));
    }

    public final void a(Integer n2) {
        Integer n3;
        if (this.h == null && n2 != null || (n3 = this.h) != null && !n3.equals((Object)n2)) {
            this.h = n2;
            this.invalidateSelf();
        }
    }

    public final boolean a() {
        if (this.getState() == null) {
            return false;
        }
        for (int i2 = 0; i2 < this.getState().length; ++i2) {
            if (this.getState()[i2] != 16842910) continue;
            return true;
        }
        return false;
    }

    public final void draw(Canvas canvas) {
        canvas.drawCircle((float)this.getBounds().width() / 2.0f, (float)this.getBounds().height() / 2.0f, (float)this.getBounds().width() / 2.0f, this.j);
        canvas.drawCircle((float)this.getBounds().width() / 2.0f, (float)this.getBounds().height() / 2.0f, (float)(this.getBounds().width() - this.f) / 2.0f - (float)this.e, this.k);
        if (this.a()) {
            float f2 = 2.0f * ((float)this.c / a);
            canvas.save();
            float f3 = this.getBounds().centerX();
            float f4 = f2 / 2.0f;
            canvas.translate(f3 - f4, (float)this.getBounds().centerY() - f4);
            canvas.drawLine(0.0f, 0.0f, f2, f2, this.l);
            canvas.translate(f2, 0.0f);
            canvas.drawLine(0.0f, 0.0f, -f2, f2, this.l);
            canvas.restore();
            return;
        }
        Integer n2 = this.h;
        String string = n2 != null ? n2.toString() : "...";
        int n3 = this.getIntrinsicWidth() - this.o - this.n;
        int n4 = this.getIntrinsicHeight() - this.p - this.q;
        Rect rect = new Rect();
        TextPaint textPaint = this.m;
        int n5 = this.g;
        this.a(string, textPaint, n5, n3, n4);
        float f5 = (this.m.descent() - this.m.ascent()) / 2.0f - this.m.descent();
        this.m.getTextBounds(string, 0, string.length(), rect);
        canvas.translate((float)(this.o + n3 / 2), f5 + (float)(this.p + n4 / 2));
        canvas.drawText(string, 0.0f, 0.0f, (Paint)this.m);
    }

    public final int getIntrinsicHeight() {
        return 2 * this.b;
    }

    public final int getIntrinsicWidth() {
        return 2 * this.b;
    }

    public final int getOpacity() {
        return -3;
    }

    public final void setAlpha(int n2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }
}

