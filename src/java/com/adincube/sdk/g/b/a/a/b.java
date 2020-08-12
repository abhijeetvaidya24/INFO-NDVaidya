/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.CountDownTimer
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  com.adincube.sdk.BannerView
 *  com.adincube.sdk.d.a.p
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.g.a.b
 *  com.adincube.sdk.g.b.a.a.a
 *  com.adincube.sdk.g.b.a.a.b$1
 *  com.adincube.sdk.g.b.a.a.b$3$1
 *  com.adincube.sdk.g.b.a.a.c
 *  com.adincube.sdk.g.b.a.b
 *  com.adincube.sdk.g.b.a.c
 *  com.adincube.sdk.g.h.a
 *  com.adincube.sdk.g.h.a$b
 *  com.adincube.sdk.h.b.b
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.c.c
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.g.b.a.a;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.adincube.sdk.BannerView;
import com.adincube.sdk.d.a.p;
import com.adincube.sdk.g.b.a.a;
import com.adincube.sdk.g.b.a.a.b;
import com.adincube.sdk.g.b.a.c;
import com.adincube.sdk.g.h.a;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a.a;
import com.adincube.sdk.util.o;
import com.adincube.sdk.util.t;

public final class b
extends com.adincube.sdk.g.b.a.a.a {
    com.adincube.sdk.g.h.a k = null;
    boolean l = false;
    boolean m = false;
    boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private long s = 0L;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private com.adincube.sdk.util.a.a w = null;
    private com.adincube.sdk.g.b.a.b x = new com.adincube.sdk.g.b.a.b(){

        public final void a(boolean bl) {
        }

        public final void a(boolean bl, com.adincube.sdk.d.a.c c2) {
            if (!bl) {
                return;
            }
            if ("NO_INTERNET".equals((Object)c2.a)) {
                b.this.j();
            }
        }

        public final void b(boolean bl) {
            if (bl) {
                b.a(b.this);
            }
        }
    };
    private final a.a y = new a.a(){

        @Override
        public final void a() {
            try {
                o.a("BannerView#OnAutoRefreshTimerFinishedListener.onAutoRefreshFinished", (Runnable)new 1(this));
                return;
            }
            catch (Throwable throwable) {
                new Object[1][0] = throwable;
                ErrorReportingHelper.report("BannerView#OnAutoRefreshTimerFinishedListener.onAutoRefreshFinished", com.adincube.sdk.h.c.b.b, b.this.i.b(), true, throwable);
                return;
            }
        }
    };
    private final a.b z = new a.b(){

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        public final void a(View view, boolean bl) {
            try {
                if (view != b.this.d) {
                    return;
                }
                if (!bl) return;
            }
            catch (Throwable throwable) {
                com.adincube.sdk.util.a.c("BannerViewAutoRefreshManager#VisibilityChangeListener.onVisibilityChanged", new Object[]{throwable});
                ErrorReportingHelper.report("BannerViewAutoRefreshManager#VisibilityChangeListener.onVisibilityChanged", com.adincube.sdk.h.c.b.b, throwable);
                return;
            }
            b.this.k.a((View)b.this.d);
            if (b.this.l) {
                b.this.l = false;
                b.this.j();
            }
            if (b.this.m) {
                b.this.m = false;
                b.c(b.this);
            }
            if (!b.this.n) return;
            b.this.n = false;
            b.a(b.this);
        }
    };

    public b(BannerView bannerView, com.adincube.sdk.g.b.a.a.c c2, com.adincube.sdk.g.a a2, com.adincube.sdk.g.a.b b2, com.adincube.sdk.g.h.a a3, a a4, c c3) {
        super(bannerView, c2, a2, b2, a4, c3);
        this.k = a3;
        this.k.a(this.z);
        a4.a(this.x);
    }

    static /* synthetic */ void a(b b2) {
        p p2;
        com.adincube.sdk.h.b.b b3 = b2.f.a(true, true);
        try {
            if (b2.i.n) {
                return;
            }
            if (b2.c != 0) {
                b2.t = true;
                return;
            }
            if (b2.d.getVisibility() != 0) {
                b2.u = true;
                return;
            }
            if (!b2.a(b3)) {
                b2.n = true;
                b2.k.a((View)b2.d, b3.F);
                return;
            }
            b2.b();
            b2.d.removeAllViewsInLayout();
            View view = b2.i.p();
            b2.d.addView(view, 0, (ViewGroup.LayoutParams)b2.a(view));
            b2.j = b2.i.r;
            b2.h.b(true);
            b2.s = -1L;
            if (t.a(b2.d.getContext()) && b2.c == 0) {
                b2.j();
            } else {
                b2.p = true;
            }
            p2 = null;
        }
        catch (Throwable throwable) {
            p p3 = new p(throwable);
            ErrorReportingHelper.report("BannerView.show", com.adincube.sdk.h.c.b.b, throwable);
            p2 = p3;
        }
        catch (com.adincube.sdk.d.a.c c2) {
            // empty catch block
        }
        if (p2 != null) {
            b2.e.a(Integer.valueOf((int)8), true);
            b2.a((com.adincube.sdk.d.a.c)p2);
        }
    }

    private boolean a(com.adincube.sdk.h.b.b b2) {
        Double d2 = b2.F;
        if (d2 <= 0.1) {
            return true;
        }
        return com.adincube.sdk.g.h.a.b((View)this.d, (double)d2);
    }

    static /* synthetic */ void c(b b2) {
        try {
            com.adincube.sdk.h.b.b b3 = b2.f.a(true, true);
            if (b2.i.n) {
                return;
            }
            if (!b2.a(b3)) {
                b2.m = true;
                b2.k.a((View)b2.d, b3.F);
                return;
            }
            b2.i.c();
            return;
        }
        catch (Throwable throwable) {
            new Object[1][0] = throwable;
            ErrorReportingHelper.report("BannerView#OnAutoRefreshTimerFinishedListener.onAutoRefreshFinished", com.adincube.sdk.h.c.b.b, b2.i.b(), true, throwable);
        }
        catch (com.adincube.sdk.d.a.c c2) {}
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void j() {
        com.adincube.sdk.h.b.b b2 = this.f.a(true, true);
        if (!this.v) {
            return;
        }
        if (this.d.getWindowToken() == null) {
            this.r = true;
            return;
        }
        if (!t.a(this.d.getContext())) {
            this.o = true;
            return;
        }
        if (this.c != 0) {
            this.p = true;
            return;
        }
        if (this.d.getVisibility() != 0) {
            this.q = true;
            return;
        }
        if (this.s == -1L && !this.a(b2)) {
            this.l = true;
            this.k.a((View)this.d, b2.F);
            return;
        }
        long l2 = this.s;
        if (l2 <= 0L) {
            l2 = this.f.a((boolean)true, (boolean)true).E;
        }
        if (l2 > 0L) {
            new Object[1][0] = l2;
            com.adincube.sdk.util.a.a a2 = new com.adincube.sdk.util.a.a(this.a, l2);
            a2.b = this.y;
            a2.start();
            b b3 = this;
            synchronized (b3) {
                this.w = a2;
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void k() {
        com.adincube.sdk.util.a.a a2 = this.w;
        if (a2 == null) {
            return;
        }
        this.s = a2.a;
        new Object[1][0] = this.s;
        a2.b = null;
        a2.cancel();
        b b2 = this;
        synchronized (b2) {
            if (a2 == this.w) {
                this.w = null;
            }
            return;
        }
    }

    private void l() {
        new Handler(Looper.getMainLooper()).post((Runnable)new 1(this));
    }

    public final void a(int n2) {
        super.a(n2);
        if (n2 == 0) {
            if (this.q) {
                this.q = false;
                this.j();
            }
            if (this.u) {
                this.u = false;
                this.l();
                return;
            }
        } else {
            this.k();
            this.j();
        }
    }

    public final void a(boolean bl) {
        if (!bl) {
            this.k();
            this.j();
            return;
        }
        if (this.o) {
            this.o = false;
            this.j();
        }
    }

    public final void b(int n2) {
        super.b(n2);
        if (n2 == 0) {
            if (this.p) {
                this.p = false;
                this.j();
            }
            if (this.t) {
                this.t = false;
                this.l();
                return;
            }
        } else {
            this.k();
            this.j();
        }
    }

    public final void d() {
        if (this.r) {
            this.r = false;
            this.j();
        }
    }

    public final void f() {
        this.k();
        this.j();
    }

    public final void g() {
        this.k.a((View)this.d);
        this.k.b(this.z);
        this.k();
    }

    public final void i() {
        this.s = -1L;
        this.v = true;
        this.j();
    }

}

