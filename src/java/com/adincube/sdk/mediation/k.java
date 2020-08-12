/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.mediation.n.a
 *  com.adincube.sdk.mediation.n.b
 *  com.adincube.sdk.mediation.v.a
 *  com.adincube.sdk.mediation.v.b
 *  java.lang.Class
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation;

import com.adincube.sdk.mediation.a;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;

public class k {
    public b a = null;
    public String b = null;
    public a c = null;
    private com.adincube.sdk.mediation.n.b d;
    private com.adincube.sdk.mediation.v.b e;

    public k(b b2) {
        this.a = b2;
    }

    public final void a() {
        a a2 = this.c;
        if (a2 != null) {
            a2.a();
        }
    }

    public final void a(j j2) {
        a a2 = this.c;
        if (a2 != null) {
            a2.a(j2);
        }
    }

    public final void a(com.adincube.sdk.mediation.n.b b2) {
        if (this.e == null) {
            this.d = b2;
            return;
        }
        throw new IllegalStateException("Cannot set interstitial event listener when rewarded event listener has been set.");
    }

    public final void b() {
        com.adincube.sdk.mediation.v.b b2;
        com.adincube.sdk.mediation.n.b b3 = this.d;
        if (b3 != null) {
            b3.r();
        }
        if ((b2 = this.e) != null) {
            b2.s();
        }
    }

    public final void b(j j2) {
        com.adincube.sdk.mediation.v.b b2;
        com.adincube.sdk.mediation.n.b b3 = this.d;
        if (b3 != null) {
            b3.a((com.adincube.sdk.mediation.n.a)this.a, j2);
        }
        if ((b2 = this.e) != null) {
            b2.a((com.adincube.sdk.mediation.v.a)this.a, j2);
        }
    }

    public final void c() {
        com.adincube.sdk.mediation.v.b b2 = this.e;
        if (b2 != null) {
            b2.t();
        }
    }

    public final void d() {
        com.adincube.sdk.mediation.v.b b2;
        com.adincube.sdk.mediation.n.b b3 = this.d;
        if (b3 != null) {
            b3.a((com.adincube.sdk.mediation.n.a)this.a);
        }
        if ((b2 = this.e) != null) {
            b2.a((com.adincube.sdk.mediation.v.a)this.a);
        }
    }

    public final void e() {
        com.adincube.sdk.mediation.v.b b2;
        com.adincube.sdk.mediation.n.b b3 = this.d;
        if (b3 != null) {
            b3.d(this.a);
        }
        if ((b2 = this.e) != null) {
            b2.d(this.a);
        }
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null && this.getClass() == object.getClass()) {
            k k2 = (k)object;
            return this.a.equals((Object)k2.a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

