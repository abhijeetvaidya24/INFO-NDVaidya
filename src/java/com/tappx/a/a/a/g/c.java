/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Runnable
 *  java.lang.System
 */
package com.tappx.a.a.a.g;

import android.content.Context;
import com.tappx.a.a.a.d.t;
import com.tappx.a.a.a.d.u;
import com.tappx.a.a.a.e.b;
import com.tappx.a.a.a.e.d;
import com.tappx.a.a.a.g.a;
import com.tappx.a.a.a.g.c;
import com.tappx.a.a.a.h.g;
import com.tappx.a.a.a.j.e;
import com.tappx.a.a.a.k;
import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxInterstitial;
import com.tappx.sdk.android.TappxInterstitialListener;

public class c
extends a {
    private final TappxInterstitial d;
    private final e e;
    private final u f;
    private TappxInterstitialListener g;
    private b h;
    private t i;
    private boolean j;
    private boolean k;
    private final e.a l = new e.a(this){
        final /* synthetic */ c a;
        {
            this.a = c2;
        }

        public void a() {
            c.a(this.a);
        }
    };
    private u.a m = new u.a(this){
        final /* synthetic */ c a;
        {
            this.a = c2;
        }

        public void a(b b2) {
            if (c.f(this.a) != null) {
                c.f(this.a).onInterstitialDismissed(c.g(this.a));
            }
        }

        public void a(b b2, t t2) {
            if (this.a.c) {
                return;
            }
            c.a(this.a, b2);
            c.b(this.a);
            c.a(this.a, t2);
            c.b(this.a, b2);
            boolean bl = c.c(this.a) && !c.d(this.a);
            c.e(this.a);
            if (bl) {
                this.a.g();
            }
        }

        public void a(com.tappx.a.a.a.e.h h2) {
            if (this.a.c) {
                return;
            }
            TappxAdError tappxAdError = this.a.b(h2);
            c.a(this.a, tappxAdError);
        }

        public void b(b b2) {
            if (c.f(this.a) != null) {
                c.f(this.a).onInterstitialClicked(c.g(this.a));
            }
        }
    };

    public c(TappxInterstitial tappxInterstitial, Context context) {
        super(context, com.tappx.a.a.a.e.c.b);
        this.d = tappxInterstitial;
        k k2 = k.a(context);
        this.f = k2.b();
        this.f.a(this.m);
        this.e = k2.a();
        this.e.a(this.l);
    }

    c(TappxInterstitial tappxInterstitial, Context context, g g2) {
        super(context, com.tappx.a.a.a.e.c.b, g2);
        this.d = tappxInterstitial;
        k k2 = k.a(context);
        this.f = k2.b();
        this.f.a(this.m);
        this.e = k2.a();
        this.e.a(this.l);
    }

    static /* synthetic */ t a(c c2, t t2) {
        c2.i = t2;
        return t2;
    }

    static /* synthetic */ b a(c c2, b b2) {
        c2.h = b2;
        return b2;
    }

    private void a(b b2) {
        long l2 = b2.a() - System.currentTimeMillis();
        boolean bl = l2 > 0L;
        if (bl) {
            this.e.a(l2);
            this.e.a();
            return;
        }
        this.e.b();
    }

    static /* synthetic */ void a(c c2) {
        c2.h();
    }

    static /* synthetic */ void a(c c2, TappxAdError tappxAdError) {
        c2.b(tappxAdError);
    }

    static /* synthetic */ void b(c c2) {
        c2.j();
    }

    static /* synthetic */ void b(c c2, b b2) {
        c2.a(b2);
    }

    private void b(TappxAdError tappxAdError) {
        if (this.j) {
            this.j = false;
            return;
        }
        TappxInterstitialListener tappxInterstitialListener = this.g;
        if (tappxInterstitialListener != null) {
            tappxInterstitialListener.onInterstitialLoadFailed(this.d, tappxAdError);
        }
    }

    static /* synthetic */ boolean c(c c2) {
        return c2.k;
    }

    static /* synthetic */ boolean d(c c2) {
        return c2.j;
    }

    static /* synthetic */ void e(c c2) {
        c2.k();
    }

    static /* synthetic */ TappxInterstitialListener f(c c2) {
        return c2.g;
    }

    static /* synthetic */ TappxInterstitial g(c c2) {
        return c2.d;
    }

    private void h() {
        this.e.b();
        this.i();
    }

    static /* synthetic */ void h(c c2) {
        c2.l();
    }

    private void i() {
        this.j = true;
        this.c();
    }

    private void j() {
        t t2 = this.i;
        if (t2 != null) {
            t2.e();
            this.i = null;
        }
    }

    private void k() {
        if (this.j) {
            this.j = false;
            return;
        }
        TappxInterstitialListener tappxInterstitialListener = this.g;
        if (tappxInterstitialListener != null) {
            tappxInterstitialListener.onInterstitialLoaded(this.d);
        }
    }

    private void l() {
        if (this.f()) {
            this.e.b();
            if (this.i != null) {
                TappxInterstitialListener tappxInterstitialListener = this.g;
                if (tappxInterstitialListener != null) {
                    tappxInterstitialListener.onInterstitialShown(this.d);
                }
                this.i.a();
                this.i = null;
            }
        }
    }

    @Override
    public void a(AdRequest adRequest) {
        this.j();
        this.j = false;
        super.a(adRequest);
    }

    @Override
    protected void a(TappxAdError tappxAdError) {
        if (this.j) {
            this.j = false;
            return;
        }
        TappxInterstitialListener tappxInterstitialListener = this.g;
        if (tappxInterstitialListener != null) {
            tappxInterstitialListener.onInterstitialLoadFailed(this.d, tappxAdError);
        }
    }

    public void a(TappxInterstitialListener tappxInterstitialListener) {
        this.g = tappxInterstitialListener;
    }

    public void a(boolean bl) {
        this.k = bl;
    }

    @Override
    public void b() {
        super.b();
        this.a((TappxInterstitialListener)null);
        this.h = null;
        this.j();
        this.f.c();
        this.e.b();
    }

    @Override
    protected void b(d d2) {
        this.f.a(this.a(), d2);
    }

    @Override
    protected void d() {
        super.d();
        this.f.d();
    }

    @Override
    void e() {
        this.j = false;
        super.e();
    }

    public boolean f() {
        return this.i != null;
    }

    public void g() {
        if (this.a.e()) {
            this.a.a(this.d.getContext(), null);
            this.a.a(new Runnable(this){
                final /* synthetic */ c a;
                {
                    this.a = c2;
                }

                public void run() {
                    c.h(this.a);
                }
            });
            return;
        }
        this.l();
    }
}

