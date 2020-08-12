/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.view.View
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 */
package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import java.lang.reflect.Method;

public abstract class bb
extends View {
    private Bitmap a = null;
    private Canvas b = null;

    public bb(Context context) {
        super(context);
        this.a(context);
    }

    private void a(Context context) {
        try {
            Class class_ = this.getClass();
            Class[] arrclass = new Class[]{Integer.TYPE, Paint.class};
            Method method = class_.getMethod("setLayerType", arrclass);
            Object[] arrobject = new Object[]{1, null};
            method.invoke((Object)this, arrobject);
        }
        catch (Exception exception) {}
    }

    private boolean b(Canvas canvas) {
        try {
            boolean bl = (Boolean)Canvas.class.getMethod("isHardwareAccelerated", new Class[0]).invoke((Object)canvas, new Object[0]);
            return bl;
        }
        catch (Exception exception) {
            return false;
        }
    }

    protected abstract void a(Canvas var1);

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.a;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.a.recycle();
        }
        this.a = null;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected final void onDraw(Canvas canvas) {
        boolean bl;
        Canvas canvas2;
        block5 : {
            block4 : {
                bl = this.b(canvas);
                if (!bl) break block4;
                Bitmap bitmap = this.a;
                if (bitmap == null || bitmap.getWidth() != canvas.getWidth() || this.a.getHeight() != canvas.getHeight()) {
                    Bitmap bitmap2 = this.a;
                    if (bitmap2 != null && !bitmap2.isRecycled()) {
                        this.a.recycle();
                    }
                    this.a = Bitmap.createBitmap((int)canvas.getWidth(), (int)canvas.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
                    this.b = new Canvas(this.a);
                }
                this.a.eraseColor(0);
                Canvas canvas3 = this.b;
                canvas2 = canvas;
                canvas = canvas3;
                break block5;
                catch (Throwable throwable) {
                    return;
                }
            }
            canvas2 = null;
        }
        this.a(canvas);
        if (!bl) return;
        canvas2.drawBitmap(this.a, 0.0f, 0.0f, null);
    }
}

