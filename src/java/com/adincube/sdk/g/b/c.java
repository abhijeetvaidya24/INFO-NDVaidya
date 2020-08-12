/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.NativeAdOptions
 *  com.adincube.sdk.d.a.i
 *  com.adincube.sdk.d.a.n
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.g.b.c$6
 *  com.adincube.sdk.g.b.e
 *  com.adincube.sdk.g.b.e.a.a
 *  com.adincube.sdk.g.b.e.b.b
 *  com.adincube.sdk.g.b.g
 *  com.adincube.sdk.g.b.h
 *  com.adincube.sdk.g.b.j
 *  com.adincube.sdk.g.b.j$a
 *  com.adincube.sdk.g.b.j$b
 *  com.adincube.sdk.h.b.b
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.c.d
 *  com.adincube.sdk.h.c.e
 *  com.adincube.sdk.h.f.a
 *  com.adincube.sdk.j.b
 *  com.adincube.sdk.j.b$a
 *  com.adincube.sdk.j.j
 *  com.adincube.sdk.j.j$a
 *  com.adincube.sdk.j.j$b
 *  com.adincube.sdk.j.j$c
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.adincube.sdk.g.b;

import com.adincube.sdk.NativeAdOptions;
import com.adincube.sdk.d.a.i;
import com.adincube.sdk.d.a.n;
import com.adincube.sdk.g.a;
import com.adincube.sdk.g.b.c;
import com.adincube.sdk.g.b.e;
import com.adincube.sdk.g.b.e.b.b;
import com.adincube.sdk.g.b.g;
import com.adincube.sdk.g.b.h;
import com.adincube.sdk.g.b.j;
import com.adincube.sdk.h.c.d;
import com.adincube.sdk.j.b;
import com.adincube.sdk.j.j;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class c
implements j {
    private static j.a q = new j.a(){

        public final com.adincube.sdk.j.j a() {
            return new com.adincube.sdk.j.j();
        }
    };
    private a a;
    private j.a b;
    private e c;
    private h d;
    private g e;
    private com.adincube.sdk.g.g.d f;
    private com.adincube.sdk.h.c.b g;
    private com.adincube.sdk.h.c.a h;
    private com.adincube.sdk.j.j i = null;
    private Object j = new Object();
    private com.adincube.sdk.d.a.c k = null;
    private j.b l;
    private final b.a m = new b.a(){

        public final void a(com.adincube.sdk.j.b b2) {
            c.this.a((com.adincube.sdk.j.j)null);
            n n2 = new n();
            c.a(c.this, (com.adincube.sdk.d.a.c)n2);
            c.this.l.a(((com.adincube.sdk.j.j)b2).c.booleanValue(), (com.adincube.sdk.d.a.c)n2);
        }
    };
    private final j.c n = new j.c(){

        public final void a(d d2) {
            c.a(c.this, null);
            c.this.a((com.adincube.sdk.j.j)null);
            e e2 = c.this.c;
            com.adincube.sdk.h.c.a a2 = c.this.h;
            e2.e.a(a2, d2);
            c.this.l.c(d2);
        }
    };
    private final j.a o = new j.a(){

        public final void a(com.adincube.sdk.h.b.b b2) {
            c.d((c)c.this).f.a(b2);
            c.this.a.a(b2);
        }
    };
    private final j.b p = new j.b(){

        public final void a() {
            c.this.a((com.adincube.sdk.j.j)null);
            i i2 = new i();
            i2.a();
            c.a(c.this, (com.adincube.sdk.d.a.c)i2);
        }

        /*
         * Enabled aggressive block sorting
         */
        public final void a(com.adincube.sdk.j.j j2) {
            d d2;
            e e2 = c.this.c;
            e2.b = 1 + e2.b;
            e e3 = c.this.c;
            if (j2.c != false) return;
            if (e3.b < e3.c) return;
            boolean bl = true;
            if (!bl) return;
            c.this.a();
            e e4 = c.this.c;
            com.adincube.sdk.h.c.a a2 = c.this.h;
            j.a a3 = c.this.o;
            j.b b2 = c.this.l;
            new Object[1][0] = e4.c;
            com.adincube.sdk.h.b.b b3 = e4.d.a(false, false);
            if (b3 == null) {
                b3 = e4.f.a();
                if (b3 == null) {
                    b3 = e.a();
                }
                b3.c = true;
                if (a3 != null) {
                    a3.a(b3);
                }
            }
            if ((d2 = e4.e.a(a2)) == null) {
                d2 = new d();
                d2.a = e4.a;
                d2.c = 300;
                d2.b = false;
                com.adincube.sdk.h.c.e e5 = new com.adincube.sdk.h.c.e("AppLovin");
                e5.d = System.currentTimeMillis();
                d2.d.add((Object)e5);
            }
            d2.g = true;
            d2.e = System.currentTimeMillis();
            Iterator iterator = d2.d.iterator();
            while (iterator.hasNext()) {
                com.adincube.sdk.h.c.e e6 = (com.adincube.sdk.h.c.e)iterator.next();
                if (!"RTB".equals((Object)e6.a) && b3.a(e6.a) != null) continue;
                iterator.remove();
            }
            if (b2 == null) return;
            b2.c(d2);
        }

        public final void a(String string) {
            c.this.a((com.adincube.sdk.j.j)null);
            com.adincube.sdk.d.a.c c2 = new com.adincube.sdk.d.a.c(string);
            c2.a();
            c.a(c.this, c2);
        }
    };

    public c(com.adincube.sdk.h.c.b b2, a a2, e e2, g g2, h h2, com.adincube.sdk.g.g.d d2) {
        this(b2, q, a2, e2, g2, h2, d2);
    }

    private c(com.adincube.sdk.h.c.b b2, j.a a2, a a3, e e2, g g2, h h2, com.adincube.sdk.g.g.d d2) {
        this.g = b2;
        this.a = a3;
        this.d = h2;
        this.f = d2;
        this.c = e2;
        this.e = g2;
        this.b = a2;
    }

    static /* synthetic */ void a(c c2, com.adincube.sdk.d.a.c c3) {
        c2.k = c3;
    }

    private void a(com.adincube.sdk.j.j j2) {
        com.adincube.sdk.j.j j3 = this.i;
        if (j3 != null) {
            j3.o = null;
            j3.p = null;
            j3.q = null;
        }
        this.i = j2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a() {
        com.adincube.sdk.j.j j2 = this.i;
        if (j2 != null) {
            com.adincube.sdk.j.j j3 = j2;
            synchronized (j3) {
                if (!j2.h) {
                    j2.h = true;
                }
            }
        }
        this.c.b = 0;
        this.a((com.adincube.sdk.j.j)null);
        this.k = null;
    }

    public final void a(j.b b2) {
        this.l = b2;
    }

    public final void a(com.adincube.sdk.h.c.a a2) {
        this.h = a2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean a(boolean bl, String string, NativeAdOptions nativeAdOptions) {
        Object object;
        Object object2 = object = this.j;
        synchronized (object2) {
            com.adincube.sdk.j.j j2 = this.i;
            boolean bl2 = j2 == null || j2.f() || j2.e() >= 4;
            if (!bl2) {
                StringBuilder stringBuilder = new StringBuilder("Already requesting server for next network order of type ");
                stringBuilder.append(this.g.e);
                stringBuilder.append(". Ignoring.");
                return false;
            }
            new StringBuilder("Requesting server for next network order of type ").append(this.g.e);
            this.a();
            com.adincube.sdk.j.j j3 = this.b.a();
            j3.a = this.g;
            j3.b = this.h;
            j3.n = this.f.b();
            j3.c = bl;
            j3.j = string;
            j3.k = nativeAdOptions;
            j3.l = this.d.a;
            j3.m = this.e.a(this.g);
            j3.o = this.n;
            j3.p = this.o;
            j3.q = this.p;
            j3.a(this.m);
            com.adincube.sdk.h.c.b b2 = this.g;
            int n2 = 6.a[b2.ordinal()] != 1 ? 3 : 10;
            j3.a(n2);
            j3.k();
            this.a(j3);
            return true;
        }
    }

    public final boolean b() {
        com.adincube.sdk.j.j j2 = this.i;
        return j2 != null && !j2.f();
    }

    public final boolean c() {
        return this.k != null;
    }

    public final com.adincube.sdk.d.a.c d() {
        return this.k;
    }

}

