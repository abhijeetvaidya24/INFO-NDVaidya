/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.CountDownTimer
 *  android.os.Handler
 *  android.os.Looper
 *  com.adincube.sdk.h.a.e
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.i.e
 *  com.adincube.sdk.mediation.w.f
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package com.adincube.sdk.util.f.a;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.h.c.c;
import com.adincube.sdk.mediation.w.f;
import com.adincube.sdk.util.ErrorReportingHelper;

public final class b {
    c a = null;
    long b;
    a c = null;
    public com.adincube.sdk.i.e d = null;
    public b e = null;
    private e f = null;
    private boolean g = false;

    public b(e e2, c c2, f f2, com.adincube.sdk.i.e e3) {
        this.f = e2;
        this.a = c2;
        this.d = e3;
        this.b = f2.o;
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            public final void run() {
                try {
                    new Object[1][0] = b.this.b;
                    b.this.c = new a(b.this.b);
                    b.this.c.start();
                    return;
                }
                catch (Throwable throwable) {
                    com.adincube.sdk.util.a.c("MRAIDBannerImpressionHelper.startImpressionTimer", new Object[]{throwable});
                    return;
                }
            }
        });
    }

    public final void a() {
        new Handler(Looper.getMainLooper()).post(new Runnable(){

            public final void run() {
                try {
                    if (b.this.c != null) {
                        b.this.c.cancel();
                        b.this.c = null;
                    }
                    return;
                }
                catch (Throwable throwable) {
                    com.adincube.sdk.util.a.c("MRAIDBannerImpressionHelper.stopImpressionTimer", new Object[]{throwable});
                    return;
                }
            }
        });
    }

    public final boolean a(boolean bl) {
        b b2 = this;
        synchronized (b2) {
            if (!this.g) {
                this.g = true;
                this.e.a(this.f, bl);
                return true;
            }
            return false;
        }
    }

    private final class a
    extends CountDownTimer {
        public a(long l2) {
            super(l2, 250L);
        }

        public final void onFinish() {
            try {
                boolean bl = b.this.d.a(true);
                b.this.a(bl);
                return;
            }
            catch (Throwable throwable) {
                new Object[1][0] = throwable;
                ErrorReportingHelper.report("MRAIDBannerImpressionHelper#ImpressionTimer.onFinish", com.adincube.sdk.h.c.b.b, b.this.a.i, throwable);
                return;
            }
        }

        public final void onTick(long l2) {
        }
    }

    public static interface b {
        public void a(e var1, Boolean var2);
    }

}

