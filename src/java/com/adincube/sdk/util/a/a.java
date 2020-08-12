/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.CountDownTimer
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.c.c
 *  java.lang.Object
 *  java.lang.Throwable
 */
package com.adincube.sdk.util.a;

import android.os.CountDownTimer;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.h.c.c;
import com.adincube.sdk.util.ErrorReportingHelper;

public final class a
extends CountDownTimer {
    public long a;
    public a b = null;
    private c c = null;

    public a(c c2, long l2) {
        super(l2, 1000L);
        this.c = c2;
        this.a = l2;
    }

    public final void onFinish() {
        try {
            this.a = 0L;
            if (this.b != null) {
                this.b.a();
            }
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("BannerAutoRefreshTimer.onFinish", new Object[]{throwable});
            ErrorReportingHelper.report("BannerAutoRefreshTimer.onFinish", b.b, this.c.i, true, throwable);
            return;
        }
    }

    public final void onTick(long l2) {
        this.a = l2;
    }

    public static interface a {
        public void a();
    }

}

