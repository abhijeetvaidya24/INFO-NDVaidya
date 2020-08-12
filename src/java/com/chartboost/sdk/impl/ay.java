/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package com.chartboost.sdk.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.chartboost.sdk.Libraries.h;

public class ay
extends ImageView {
    protected TextView a = null;
    private h b = null;

    public ay(Context context) {
        super(context);
    }

    protected void a(Canvas canvas) {
        TextView textView = this.a;
        if (textView != null) {
            textView.layout(0, 0, canvas.getWidth(), canvas.getHeight());
            this.a.setEnabled(this.isEnabled());
            this.a.setSelected(this.isSelected());
            if (this.isFocused()) {
                this.a.requestFocus();
            } else {
                this.a.clearFocus();
            }
            this.a.setPressed(this.isPressed());
            this.a.draw(canvas);
        }
    }

    public void a(h h2) {
        if (h2 != null && h2.d()) {
            if (this.b == h2) {
                return;
            }
            this.b = h2;
            this.setImageDrawable((Drawable)new BitmapDrawable(h2.e()));
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a(canvas);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.b = null;
        this.setImageDrawable((Drawable)new BitmapDrawable(bitmap));
    }
}

