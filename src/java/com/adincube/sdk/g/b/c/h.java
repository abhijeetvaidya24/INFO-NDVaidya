/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.adincube.sdk.g.b.c;

import com.adincube.sdk.g.b.c.e;
import com.adincube.sdk.h.f.a;
import com.adincube.sdk.h.f.b;

public class h {
    e b = e.a;
    public com.adincube.sdk.h.c.e c;
    public com.adincube.sdk.h.f.e d = null;
    public a e = null;
    public Long f = null;
    public Long g = null;

    public h(com.adincube.sdk.h.c.e e2) {
        this.c = e2;
    }

    public final void a(e e2) {
        if (e2 == e.b) {
            this.f = System.currentTimeMillis();
        }
        if (e2 == e.c) {
            this.g = System.currentTimeMillis();
        }
        this.b = e2;
    }

    public final boolean b() {
        return this.b == e.c;
    }

    public final boolean c() {
        return this.b == e.b;
    }

    public final boolean d() {
        return this.b == e.a || this.b == e.h || this.b == e.g;
        {
        }
    }

    public final e e() {
        if (this.c.c()) {
            return e.k;
        }
        return this.b;
    }

    public final b f() {
        com.adincube.sdk.h.f.e e2 = this.d;
        if (e2 != null) {
            return new b(e2);
        }
        a a2 = this.e;
        if (a2 != null) {
            return new b(a2);
        }
        return null;
    }

    public String toString() {
        e e2 = this.b;
        if (e2 != null) {
            return e2.toString();
        }
        return super.toString();
    }
}

