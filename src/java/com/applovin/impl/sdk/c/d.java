/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.applovin.impl.sdk.AppLovinAdBase
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.applovin.impl.sdk.c;

import android.app.Activity;
import android.content.Context;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.c.c;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.j;
import com.applovin.sdk.AppLovinAd;

public class d {
    private final AppLovinAdBase a;
    private final long b;
    private final c c;
    private final h d;
    private final j e;
    private final Object f = new Object();
    private long g;
    private long h;
    private long i;
    private long j;
    private boolean k;

    public d(AppLovinAd appLovinAd, j j2) {
        if (appLovinAd != null) {
            if (j2 != null) {
                this.c = j2.P();
                this.d = j2.D();
                this.e = j2;
                if (appLovinAd instanceof AppLovinAdBase) {
                    this.a = (AppLovinAdBase)appLovinAd;
                    this.b = this.a.getCreatedAtMillis();
                    this.c.a(b.a, this.a.getSource().ordinal(), this.a);
                    return;
                }
                this.a = null;
                this.b = 0L;
                return;
            }
            throw new IllegalArgumentException("No sdk specified");
        }
        throw new IllegalArgumentException("No ad specified");
    }

    public static void a(long l2, AppLovinAdBase appLovinAdBase, j j2) {
        if (appLovinAdBase != null && j2 != null) {
            j2.P().a(b.b, l2, appLovinAdBase);
        }
    }

    public static void a(AppLovinAdBase appLovinAdBase, j j2) {
        if (appLovinAdBase != null && j2 != null) {
            long l2 = appLovinAdBase.getFetchLatencyMillis();
            j2.P().a(b.c, l2, appLovinAdBase);
            long l3 = appLovinAdBase.getFetchResponseSize();
            j2.P().a(b.d, l3, appLovinAdBase);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(b b2) {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            if (this.g > 0L) {
                long l2 = System.currentTimeMillis() - this.g;
                this.c.a(b2, l2, this.a);
            }
            return;
        }
    }

    public static void a(e e2, AppLovinAdBase appLovinAdBase, j j2) {
        if (appLovinAdBase != null && j2 != null && e2 != null) {
            j2.P().a(b.e, e2.c(), appLovinAdBase);
            j2.P().a(b.f, e2.d(), appLovinAdBase);
            j2.P().a(b.v, e2.g(), appLovinAdBase);
            j2.P().a(b.w, e2.h(), appLovinAdBase);
            c c2 = j2.P();
            b b2 = b.z;
            long l2 = e2.b() ? 1L : 0L;
            c2.a(b2, l2, appLovinAdBase);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Object object;
        long l2 = this.d.a(g.b);
        this.c.a(b.j, l2, this.a);
        long l3 = this.d.a(g.d);
        this.c.a(b.i, l3, this.a);
        Object object2 = object = this.f;
        synchronized (object2) {
            long l4 = this.b;
            long l5 = 0L;
            if (l4 > l5) {
                this.g = System.currentTimeMillis();
                long l6 = this.g - this.e.z();
                this.c.a(b.h, l6, this.a);
                long l7 = this.g - this.b;
                this.c.a(b.g, l7, this.a);
                long l8 = f.a(this.e.w(), this.e) ? 1L : l5;
                this.c.a(b.p, l8, this.a);
                Activity activity = this.e.S().a();
                if (com.applovin.impl.sdk.e.e.h() && activity != null && activity.isInMultiWindowMode()) {
                    l5 = 1L;
                }
                this.c.a(b.A, l5, this.a);
            }
            return;
        }
    }

    public void a(long l2) {
        this.c.a(b.r, l2, this.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            if (this.h < 1L) {
                this.h = System.currentTimeMillis();
                if (this.g > 0L) {
                    long l2 = this.h - this.g;
                    this.c.a(b.m, l2, this.a);
                }
            }
            return;
        }
    }

    public void b(long l2) {
        this.c.a(b.q, l2, this.a);
    }

    public void c() {
        this.a(b.k);
    }

    public void c(long l2) {
        this.c.a(b.s, l2, this.a);
    }

    public void d() {
        this.a(b.n);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void d(long l2) {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            if (this.i < 1L) {
                this.i = l2;
                this.c.a(b.t, l2, this.a);
            }
            return;
        }
    }

    public void e() {
        this.a(b.o);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void e(long l2) {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            if (!this.k) {
                this.k = true;
                this.c.a(b.x, l2, this.a);
            }
            return;
        }
    }

    public void f() {
        this.a(b.l);
    }

    public void g() {
        this.c.a(b.u, 1L, this.a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h() {
        Object object;
        Object object2 = object = this.f;
        synchronized (object2) {
            if (this.j < 1L) {
                this.j = System.currentTimeMillis();
                if (this.g > 0L) {
                    long l2 = this.j - this.g;
                    this.c.a(b.y, l2, this.a);
                }
            }
            return;
        }
    }
}

