/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.tappx.a.a.a.b.a;

import com.tappx.a.a.a.b.a.a;
import com.tappx.a.a.a.b.a.b;
import com.tappx.a.a.a.b.a.d;
import com.tappx.a.a.a.b.a.e;
import com.tappx.a.a.a.b.a.g;
import com.tappx.a.a.a.b.a.h;
import com.tappx.a.a.a.b.a.j;
import com.tappx.b.k;
import com.tappx.b.n;
import com.tappx.b.p;
import com.tappx.b.r;
import com.tappx.b.u;
import java.util.Map;

final class j<T>
extends n<T> {
    private final e<T> a;

    public j(e<T> e2) {
        super(j.a(e2.a()), e2.b(), new p.a(){

            @Override
            public void a(u u2) {
                b b2;
                g.a a2 = e.this.V();
                if (a2 == null) {
                    return;
                }
                if (u2 instanceof a) {
                    b2 = ((a)u2).a();
                } else {
                    Map<String, String> map = u2.a != null ? u2.a.c : null;
                    int n2 = u2.a != null ? u2.a.a : -1;
                    b2 = j.d(u2) ? new b(b.a.a, map, n2) : new b(b.a.b, map, n2);
                }
                a2.a(b2);
            }
        });
        this.a = e2;
        this.a((T)e2);
        this.a(e2.Y());
    }

    private static int a(e.a a2) {
        switch (2.a[a2.ordinal()]) {
            default: {
                return 0;
            }
            case 6: {
                return 2;
            }
            case 5: {
                return 7;
            }
            case 4: {
                return 5;
            }
            case 3: {
                return 4;
            }
            case 2: {
                return 3;
            }
            case 1: 
        }
        return 1;
    }

    private n.c a(e.b b2) {
        int n2 = 2.b[b2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return n.c.b;
                }
                return n.c.d;
            }
            return n.c.c;
        }
        return n.c.a;
    }

    private static boolean d(u u2) {
        k k2 = u2.a;
        if (k2 == null) {
            return false;
        }
        int n2 = k2.a;
        boolean bl = false;
        if (n2 >= 500) {
            int n3 = k2.a;
            bl = false;
            if (n3 <= 599) {
                bl = true;
            }
        }
        return bl;
    }

    @Override
    protected p<T> a(k k2) {
        e<T> e2 = this.a;
        d d2 = new d(k2.a, k2.c, k2.b, k2.f);
        g<T> g2 = e2.a(d2);
        if (g2.a()) {
            return p.a(g2.a, com.tappx.b.a.j.a(k2));
        }
        return p.a(new a(g2.b));
    }

    @Override
    void a(e<T> e2) {
        h h2 = e2.X();
        if (h2 != null) {
            this.b(h2.d());
            this.a(new com.tappx.b.e(h2.b(), h2.c(), h2.a()));
        }
    }

    @Override
    protected void a(T t2) {
        this.a.a(t2);
    }

    @Override
    public byte[] a() {
        return this.a.c();
    }

    @Override
    public byte[] b() {
        return this.a();
    }

    @Override
    public Map<String, String> c() {
        return this.a.d();
    }

    @Override
    public n.c e() {
        return this.a(this.a.Z());
    }

}

