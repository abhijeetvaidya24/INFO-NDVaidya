/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapFactory$Options
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  java.lang.Deprecated
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.OutOfMemoryError
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.tappx.b.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tappx.b.a.j;
import com.tappx.b.e;
import com.tappx.b.k;
import com.tappx.b.m;
import com.tappx.b.n;
import com.tappx.b.p;
import com.tappx.b.r;
import com.tappx.b.v;

public class o
extends n<Bitmap> {
    public static final int a = 1000;
    public static final int b = 2;
    public static final float c = 2.0f;
    private static final Object j = new Object();
    private final Object d = new Object();
    private p.b<Bitmap> e;
    private final Bitmap.Config f;
    private final int g;
    private final int h;
    private final ImageView.ScaleType i;

    @Deprecated
    public o(String string, p.b<Bitmap> b2, int n2, int n3, Bitmap.Config config, p.a a2) {
        this(string, b2, n2, n3, ImageView.ScaleType.CENTER_INSIDE, config, a2);
    }

    public o(String string, p.b<Bitmap> b2, int n2, int n3, ImageView.ScaleType scaleType, Bitmap.Config config, p.a a2) {
        super(0, string, a2);
        this.a(new e(1000, 2, 2.0f));
        this.e = b2;
        this.f = config;
        this.g = n2;
        this.h = n3;
        this.i = scaleType;
    }

    static int a(int n2, int n3, int n4, int n5) {
        float f2;
        double d2 = n2;
        double d3 = n4;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        double d4 = d2 / d3;
        double d5 = n3;
        double d6 = n5;
        Double.isNaN((double)d5);
        Double.isNaN((double)d6);
        double d7 = Math.min((double)d4, (double)(d5 / d6));
        float f3 = 1.0f;
        while ((double)(f2 = 2.0f * f3) <= d7) {
            f3 = f2;
        }
        return (int)f3;
    }

    private static int a(int n2, int n3, int n4, int n5, ImageView.ScaleType scaleType) {
        if (n2 == 0 && n3 == 0) {
            return n4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            if (n2 == 0) {
                return n4;
            }
            return n2;
        }
        if (n2 == 0) {
            double d2 = n3;
            double d3 = n5;
            Double.isNaN((double)d2);
            Double.isNaN((double)d3);
            double d4 = d2 / d3;
            double d5 = n4;
            Double.isNaN((double)d5);
            return (int)(d5 * d4);
        }
        if (n3 == 0) {
            return n2;
        }
        double d6 = n5;
        double d7 = n4;
        Double.isNaN((double)d6);
        Double.isNaN((double)d7);
        double d8 = d6 / d7;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d9 = n2;
            Double.isNaN((double)d9);
            double d10 = d9 * d8;
            double d11 = n3;
            if (d10 < d11) {
                Double.isNaN((double)d11);
                n2 = (int)(d11 / d8);
            }
            return n2;
        }
        double d12 = n2;
        Double.isNaN((double)d12);
        double d13 = d12 * d8;
        double d14 = n3;
        if (d13 > d14) {
            Double.isNaN((double)d14);
            n2 = (int)(d14 / d8);
        }
        return n2;
    }

    private p<Bitmap> b(k k2) {
        Bitmap bitmap;
        byte[] arrby = k2.b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.g == 0 && this.h == 0) {
            options.inPreferredConfig = this.f;
            bitmap = BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length, (BitmapFactory.Options)options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length, (BitmapFactory.Options)options);
            int n2 = options.outWidth;
            int n3 = options.outHeight;
            int n4 = o.a(this.g, this.h, n2, n3, this.i);
            int n5 = o.a(this.h, this.g, n3, n2, this.i);
            options.inJustDecodeBounds = false;
            options.inSampleSize = o.a(n2, n3, n4, n5);
            bitmap = BitmapFactory.decodeByteArray((byte[])arrby, (int)0, (int)arrby.length, (BitmapFactory.Options)options);
            if (bitmap != null && (bitmap.getWidth() > n4 || bitmap.getHeight() > n5)) {
                Bitmap bitmap2 = Bitmap.createScaledBitmap((Bitmap)bitmap, (int)n4, (int)n5, (boolean)true);
                bitmap.recycle();
                bitmap = bitmap2;
            }
        }
        if (bitmap == null) {
            return p.a(new m(k2));
        }
        return p.a(bitmap, j.a(k2));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    protected p<Bitmap> a(k k2) {
        Object object;
        Object object2 = object = j;
        synchronized (object2) {
            try {
                try {
                    return this.b(k2);
                }
                catch (OutOfMemoryError outOfMemoryError) {
                    Object[] arrobject = new Object[]{k2.b.length, this.k()};
                    v.c("Caught OOM for %d byte image, url=%s", arrobject);
                    return p.a(new m(outOfMemoryError));
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    protected void a(Bitmap bitmap) {
        Object object;
        Object object2 = object = this.d;
        // MONITORENTER : object2
        p.b<Bitmap> b2 = this.e;
        // MONITOREXIT : object2
        if (b2 == null) return;
        b2.a(bitmap);
    }

    @Override
    public n.c e() {
        return n.c.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void n() {
        Object object;
        super.n();
        Object object2 = object = this.d;
        synchronized (object2) {
            this.e = null;
            return;
        }
    }
}

