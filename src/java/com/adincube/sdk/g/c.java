/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.j.c
 *  com.adincube.sdk.j.g
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.adincube.sdk.g;

import com.adincube.sdk.h.a.e;
import com.adincube.sdk.h.c.a;
import com.adincube.sdk.h.c.d;
import com.adincube.sdk.h.c.g;
import com.adincube.sdk.h.f.b;
import com.adincube.sdk.mediation.i;
import org.json.JSONObject;

public final class c {
    public com.adincube.sdk.h.c.b a;
    public a b;

    public c(com.adincube.sdk.h.c.b b2) {
        this.a = b2;
    }

    public final void a(d d2, com.adincube.sdk.mediation.b b2, b b3, JSONObject jSONObject) {
        this.a(d2.b, d2.g, b2, b3, jSONObject);
    }

    public final void a(com.adincube.sdk.mediation.b b2, boolean bl) {
        if (!b2.a(g.b)) {
            String string = b2.f().f();
            new Object[1][0] = string;
            com.adincube.sdk.j.c c2 = new com.adincube.sdk.j.c();
            c2.a = this.a;
            c2.b = this.b;
            c2.c = bl;
            c2.j = string;
            c2.k = null;
            c2.k();
        }
    }

    public final void a(boolean bl, boolean bl2, com.adincube.sdk.mediation.b b2, b b3, JSONObject jSONObject) {
        if (!b2.a(g.a)) {
            String string = b2.f().f();
            new Object[1][0] = string;
            com.adincube.sdk.j.g g2 = new com.adincube.sdk.j.g();
            g2.a = this.a;
            g2.b = this.b;
            g2.c = bl;
            g2.o = bl2;
            g2.j = string;
            g2.m = jSONObject;
            g2.l = b3;
            g2.k = null;
            g2.n = true;
            g2.k();
        }
    }
}

