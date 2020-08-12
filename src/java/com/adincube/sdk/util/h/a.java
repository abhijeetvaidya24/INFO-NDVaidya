/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.CountDownTimer
 *  com.adincube.sdk.b.a.a.e$a
 *  com.adincube.sdk.b.a.a.g
 *  com.adincube.sdk.b.a.a.h
 *  com.adincube.sdk.c.a
 *  com.adincube.sdk.f.a
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package com.adincube.sdk.util.h;

import android.os.CountDownTimer;
import com.adincube.sdk.b.a.a.e;
import com.adincube.sdk.b.a.a.g;
import com.adincube.sdk.b.a.a.h;
import com.adincube.sdk.util.h.a;
import com.adincube.sdk.util.j;
import com.adincube.sdk.util.o;

public final class a
extends CountDownTimer
implements e.a,
j {
    private e a;
    private com.adincube.sdk.f.a b;
    private long c;
    private boolean d = false;
    private a e;
    private boolean f = false;

    public a(e e2, com.adincube.sdk.f.a a2, long l2) {
        super(l2, 250L);
        this.a = e2;
        this.b = a2;
        this.c = l2;
        e2.a(this);
        if (e2.a() != h.f && l2 >= 0L) {
            a2.a(false);
            return;
        }
        this.a();
    }

    private void a() {
        a a2 = this;
        synchronized (a2) {
            block4 : {
                boolean bl = this.d;
                if (!bl) break block4;
                return;
            }
            this.d = true;
            this.cancel();
            o.a("SkipController.enableSkip", new Runnable(this){
                final /* synthetic */ a a;
                {
                    this.a = a2;
                }

                public final void run() {
                    if (!a.a(this.a)) {
                        a.b(this.a).a(true);
                    }
                    a.b((a)this.a).a.a(null);
                    if (a.c(this.a) != null) {
                        a.c(this.a).s();
                    }
                }
            });
            return;
        }
    }

    static /* synthetic */ boolean a(a a2) {
        return a2.f;
    }

    static /* synthetic */ com.adincube.sdk.f.a b(a a2) {
        return a2.b;
    }

    static /* synthetic */ a c(a a2) {
        return a2.e;
    }

    public final void a(e e2) {
    }

    public final void a(e e2, g g2) {
    }

    public final void a(a a2) {
        this.e = a2;
        if (a2 != null && this.d) {
            a2.s();
        }
    }

    @Override
    public final void b() {
        this.cancel();
        this.a();
    }

    public final void b(e e2) {
    }

    public final void b_() {
        this.onTick(this.c);
        this.start();
    }

    public final void onFinish() {
        this.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void onTick(long l2) {
        try {
            long l3 = this.c - this.a.o();
            if (this.a.a() != h.f && l3 > 0L) {
                this.b.a.a(Integer.valueOf((int)((int)Math.ceil((double)((float)l3 / 1000.0f)))));
                return;
            }
            this.a();
            return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("ABVASTSkippableLinearHelper.onTick()", new Object[]{throwable});
            return;
        }
    }

}

