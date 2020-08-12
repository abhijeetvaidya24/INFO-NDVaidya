/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.view.View
 */
package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public final class hq
extends View {
    public boolean a = false;
    private Bitmap b = null;
    private Rect c = null;
    private Rect d = null;
    private Rect e = null;
    private Rect f = new Rect();

    public hq(Context context) {
        super(context);
    }

    final void a() {
        if (this.a) {
            this.e = this.c;
            return;
        }
        this.e = this.d;
    }

    public final void onDraw(Canvas canvas) {
        if (this.e == null) {
            return;
        }
        if (this.b == null) {
            return;
        }
        this.getDrawingRect(this.f);
        canvas.drawBitmap(this.b, this.e, this.f, null);
    }

    public final void setImageBitmap(Bitmap bitmap) {
        this.b = bitmap;
        int n2 = this.b.getWidth();
        int n3 = this.b.getHeight();
        int n4 = n2 / 2;
        this.d = new Rect(0, 0, n4, n3);
        this.c = new Rect(n4, 0, n2, n3);
        this.a();
    }
}

