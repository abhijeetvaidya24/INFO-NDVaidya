/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.CountDownTimer
 *  com.adincube.sdk.b.a.a.e$a
 *  com.adincube.sdk.b.a.a.g
 *  com.adincube.sdk.f.a
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Throwable
 */
package com.adincube.sdk.b.a;

import android.os.CountDownTimer;
import com.adincube.sdk.b.a.a.e;
import com.adincube.sdk.b.a.a.g;
import com.adincube.sdk.util.j;

public final class a
extends CountDownTimer
implements e$a,
j {
    private com.adincube.sdk.f.a a;
    private e b;
    private long c;
    private long d = 0L;
    private Long e;

    public a(e e2, com.adincube.sdk.f.a a2, long l2) {
        super(Integer.MAX_VALUE, 1000L);
        this.a = a2;
        this.b = e2;
        this.c = l2;
        this.b.a(this);
    }

    public final void a(e e2) {
        this.cancel();
    }

    public final void a(e e2, g g2) {
        this.cancel();
    }

    public final boolean a() {
        if (this.e == null) {
            return false;
        }
        if (!this.b.n()) {
            return false;
        }
        return this.e > this.c;
    }

    @Override
    public final void b() {
        this.cancel();
    }

    public final void b(e e2) {
    }

    public final void b_() {
        this.start();
    }

    public final void onFinish() {
    }

    public final void onTick(long l2) {
        try {
            if (this.b.n()) {
                this.e = Math.abs((long)(this.b.o() - 1000L - this.d));
                if (this.a()) {
                    new Object[1][0] = this.e;
                    this.a.a(true);
                }
            }
            this.d = this.b.o();
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("StuckMediaPlayerDetector.onTick()", new Object[]{throwable});
            return;
        }
    }
}

