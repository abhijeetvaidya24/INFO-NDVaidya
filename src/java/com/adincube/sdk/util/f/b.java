/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.h.a.e
 *  com.adincube.sdk.mediation.w.f
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.System
 */
package com.adincube.sdk.util.f;

import com.adincube.sdk.h.a.e;
import com.adincube.sdk.mediation.w.f;

public final class b {
    public e a = null;
    public a b = null;
    private long c;
    private Long d = null;
    private Long e = null;

    public final void a() {
        this.d = System.currentTimeMillis();
    }

    public final void a(f f2) {
        this.c = f2.k;
    }

    public final boolean b() {
        long l2;
        if (this.d == null) {
            return false;
        }
        long l3 = System.currentTimeMillis();
        long l4 = l3 - this.d;
        if (l4 > (l2 = this.c)) {
            return true;
        }
        new Object[1][0] = l2 - (l3 - this.d);
        return false;
    }

    public final boolean c() {
        Long l2 = this.e;
        if (l2 == null) {
            return true;
        }
        if (l2 > System.currentTimeMillis()) {
            return false;
        }
        return System.currentTimeMillis() - this.e > 1000L;
    }

    public final void d() {
        this.e = System.currentTimeMillis();
    }

    public final void e() {
        this.b.a(this.a);
    }

    public static interface a {
        public void a(e var1);
    }

}

