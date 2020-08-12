/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  com.adincube.sdk.BannerView
 *  com.adincube.sdk.d.a.a.b
 *  com.adincube.sdk.d.a.h
 *  com.adincube.sdk.d.a.p
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.g.a.b
 *  com.adincube.sdk.g.b.a.a.a
 *  com.adincube.sdk.g.b.a.a.c
 *  com.adincube.sdk.g.b.a.a.d$1
 *  com.adincube.sdk.g.b.a.a.d$3
 *  com.adincube.sdk.g.b.a.a.d$4
 *  com.adincube.sdk.g.b.a.b
 *  com.adincube.sdk.g.b.a.c
 *  com.adincube.sdk.g.b.c.c
 *  com.adincube.sdk.g.b.c.c$a
 *  com.adincube.sdk.g.b.c.i
 *  com.adincube.sdk.g.b.j
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.c.d
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Throwable
 */
package com.adincube.sdk.g.b.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.adincube.sdk.BannerView;
import com.adincube.sdk.d.a.h;
import com.adincube.sdk.d.a.p;
import com.adincube.sdk.g.b.a.a;
import com.adincube.sdk.g.b.a.a.d;
import com.adincube.sdk.g.b.a.b;
import com.adincube.sdk.g.b.a.c;
import com.adincube.sdk.g.b.c.c;
import com.adincube.sdk.g.b.c.i;
import com.adincube.sdk.g.b.j;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.f;
import com.adincube.sdk.util.o;

public final class d
extends com.adincube.sdk.g.b.a.a.a {
    boolean k = false;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private boolean o = false;
    private b p = new b(){

        public final void a(boolean bl) {
            if (!bl) {
                d.this.k = true;
            }
        }

        public final void a(boolean bl, com.adincube.sdk.d.a.c c2) {
        }

        public final void b(boolean bl) {
            if (!bl) {
                d.this.k = true;
            }
        }
    };

    public d(BannerView bannerView, com.adincube.sdk.g.b.a.a.c c2, com.adincube.sdk.g.a a2, com.adincube.sdk.g.a.b b2, a a3, c c3) {
        super(bannerView, c2, a2, b2, a3, c3);
        a3.a(this.p);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void a(com.adincube.sdk.d.a.c c2, boolean bl) {
        try {
            c2.a();
            if (!bl) return;
        }
        catch (Throwable throwable) {
            com.adincube.sdk.util.a.c("BannerView.printLoadError", new Object[]{throwable});
            ErrorReportingHelper.report("BannerView.printLoadError", throwable);
            return;
        }
        this.h.b(false, c2);
    }

    static /* synthetic */ void a(d d2, boolean bl) {
        d2.c(bl);
    }

    private void c(boolean bl) {
        if (this.a == null) {
            this.l = true;
            return;
        }
        if (!this.b(bl)) {
            p p2;
            try {
                this.k();
                this.b();
                this.i.n();
                p2 = null;
            }
            catch (Throwable throwable) {
                p p3 = new p(throwable);
                ErrorReportingHelper.report("BannerViewLoadManager.load", com.adincube.sdk.h.c.b.b, this.a(), throwable);
                p2 = p3;
            }
            catch (com.adincube.sdk.d.a.c c2) {
                // empty catch block
            }
            if (p2 != null) {
                this.a((com.adincube.sdk.d.a.c)p2, true);
            }
        }
    }

    private void k() {
        if (this.a != null) {
            if (this.a.f) {
                return;
            }
            throw new com.adincube.sdk.d.a.a.b();
        }
        throw new h();
    }

    private void l() {
        new Handler(Looper.getMainLooper()).post((Runnable)new 4(this));
    }

    public final void a(int n2) {
        super.a(n2);
        if (n2 == 0 && this.m) {
            this.m = false;
            this.l();
        }
    }

    public final void b(int n2) {
        super.b(n2);
        if (n2 == 0 && this.o) {
            this.o = false;
            this.l();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final boolean b(boolean bl) {
        p p2;
        try {
            this.k();
            this.b();
            if (this.d.getWindowToken() == null) {
                this.n = true;
                return false;
            }
            if (this.c != 0) {
                this.o = true;
                return false;
            }
            if (this.b != null && this.b != 0) {
                this.m = true;
                return false;
            }
            c c2 = this.i;
            c2.a(c.a.b);
            com.adincube.sdk.h.c.d d2 = c2.m;
            if (!com.adincube.sdk.h.c.d.a((com.adincube.sdk.h.c.d)d2)) {
                if (bl) {
                    if (c2.c.c()) return true;
                }
                c2.c();
                return true;
            } else {
                ((com.adincube.sdk.g.b.c.c)d2.f).f = c2.p;
                d2.f.n();
            }
            return true;
        }
        catch (Throwable throwable) {
            p p3 = new p(throwable);
            ErrorReportingHelper.report("BannerViewLoadManager.load", com.adincube.sdk.h.c.b.b, this.a(), throwable);
            p2 = p3;
        }
        catch (com.adincube.sdk.d.a.c c3) {
            // empty catch block
        }
        if (p2 == null) return true;
        this.a((com.adincube.sdk.d.a.c)p2, true);
        return true;
    }

    public final void c() {
        if (this.l) {
            new Handler(Looper.getMainLooper()).post((Runnable)new 3(this));
        }
    }

    public final void d() {
        if (this.n) {
            this.n = false;
            this.l();
        }
    }

    public final void i() {
        p p2;
        try {
            if (this.k) {
                return;
            }
            f.a(this.d.getContext());
            if (!o.a()) {
                o.a((Runnable)new 1(this));
                return;
            }
            com.adincube.sdk.util.b.a.a();
            this.g.a(this.d.getContext());
            com.adincube.sdk.g.a.a((Context)this.d.getContext(), (boolean)true);
            if (com.adincube.sdk.util.e.a.a()) {
                com.adincube.sdk.util.a.a("Configuration changed.", new Object[0]);
                com.adincube.sdk.util.e.b.a().b();
                com.adincube.sdk.g.a.a().b();
                com.adincube.sdk.util.d.a();
                com.adincube.sdk.util.e.a.b();
            }
            this.c(false);
            p2 = null;
        }
        catch (Throwable throwable) {
            p p3 = new p(throwable);
            ErrorReportingHelper.report("BannerViewLoadManager.preLoadOrLoad", com.adincube.sdk.h.c.b.b, this.a(), throwable);
            p2 = p3;
        }
        catch (com.adincube.sdk.d.a.c c2) {
            // empty catch block
        }
        if (p2 != null) {
            this.a((com.adincube.sdk.d.a.c)p2, true);
        }
    }

}

