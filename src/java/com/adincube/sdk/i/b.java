/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.CountDownTimer
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package com.adincube.sdk.i;

import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import com.adincube.sdk.i.e;
import com.adincube.sdk.mediation.w.f;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;

public final class b
extends CountDownTimer {
    e a;
    public boolean b = false;
    private f c;
    private com.adincube.sdk.f.a d;

    private b(f f2, com.adincube.sdk.f.a a2, e e2) {
        super(f2.l.longValue(), 500L);
        this.c = f2;
        this.d = a2;
        this.a = e2;
    }

    public static b a(f f2, com.adincube.sdk.f.a a2, e e2) {
        return new b(f2, a2, e2);
    }

    private void a() {
        if (!this.b) {
            this.b = true;
            this.d.a(true);
        }
    }

    public final void onFinish() {
        try {
            this.a();
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("MRAIDCloseTimer.onFinish()", com.adincube.sdk.h.c.b.a, throwable);
            a.c("MRAIDCloseTimer.onFinish()", new Object[]{throwable});
            return;
        }
    }

    public final void onTick(long l2) {
        try {
            if (this.c.m != null && this.c.l - l2 >= this.c.m && this.a.a(true)) {
                this.a();
                new Handler(Looper.getMainLooper()).post(new Runnable(){

                    public final void run() {
                        try {
                            b.this.cancel();
                            return;
                        }
                        catch (Throwable throwable) {
                            ErrorReportingHelper.report("MRAIDCloseTimer.stopTimer()", com.adincube.sdk.h.c.b.a, throwable);
                            a.c("MRAIDCloseTimer.stopTimer()", new Object[]{throwable});
                            return;
                        }
                    }
                });
            }
            return;
        }
        catch (Throwable throwable) {
            ErrorReportingHelper.report("MRAIDCloseTimer.onTick()", com.adincube.sdk.h.c.b.a, throwable);
            a.c("MRAIDCloseTimer.onFinish()", new Object[]{throwable});
            return;
        }
    }

}

