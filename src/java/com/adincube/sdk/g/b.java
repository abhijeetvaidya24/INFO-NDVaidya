/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.j.f
 *  com.adincube.sdk.j.i
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.adincube.sdk.g;

import com.adincube.sdk.g.a;
import com.adincube.sdk.g.b.c.e;
import com.adincube.sdk.g.b.c.h;
import com.adincube.sdk.g.b.c.i;
import com.adincube.sdk.g.c;
import com.adincube.sdk.h.c.d;
import com.adincube.sdk.j.f;
import com.adincube.sdk.util.v;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private a a;
    private c b;
    private v c;

    public b(a a2, c c2) {
        this.a = a2;
        this.b = c2;
        this.c = v.a();
    }

    public final void a(com.adincube.sdk.h.b.c c2, d d2) {
        if (this.c.a(this.a.a(true, true), com.adincube.sdk.h.e.b, c2)) {
            c c3 = this.b;
            new Object[1][0] = c3.a;
            f f2 = new f();
            f2.a = c3.a;
            f2.b = c3.b;
            f2.c = d2.b;
            f2.j = c2;
            f2.k();
        }
        this.c.a(com.adincube.sdk.h.e.b, c2);
    }

    public final void b(com.adincube.sdk.h.b.c c2, d d2) {
        if (this.c.a(this.a.a(true, true), com.adincube.sdk.h.e.a, c2)) {
            HashMap hashMap;
            c c3 = this.b;
            new Object[1][0] = c3.a;
            com.adincube.sdk.j.i i2 = new com.adincube.sdk.j.i();
            i2.a = c3.a;
            i2.b = c3.b;
            i2.j = c2;
            i2.k = d2;
            i2.c = d2.b;
            if (d2.f != null) {
                hashMap = d2.f.o();
            } else {
                HashMap hashMap2 = new HashMap();
                for (com.adincube.sdk.h.c.e e2 : d2.d) {
                    h h2 = new h(e2);
                    h2.a(e.a);
                    hashMap2.put((Object)e2.a, (Object)h2);
                }
                hashMap = hashMap2;
            }
            i2.l = hashMap;
            i2.k();
        }
        this.c.a(com.adincube.sdk.h.e.a, c2);
    }
}

