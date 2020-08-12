/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import com.tappx.a.a.a.b.i;
import com.tappx.a.a.a.d.a;
import com.tappx.a.a.a.d.ag;
import com.tappx.a.a.a.d.ah;
import com.tappx.a.a.a.e.c;
import com.tappx.a.a.a.e.d;
import com.tappx.a.a.a.e.h;
import com.tappx.a.a.a.j;
import com.tappx.a.a.a.o;
import com.tappx.sdk.android.AdRequest;

public class ah
implements ag {
    private final i a;
    private final a b;
    private final com.tappx.a.a.a.f.a c;
    private ag.a d;
    private i.b e;

    public ah(i i2, a a2, com.tappx.a.a.a.f.a a3) {
        this.a = i2;
        this.b = a2;
        this.c = a3;
    }

    private void a(i.a a2) {
        this.b(a2);
    }

    private void b(i.a a2) {
        int n2 = 3.a[a2.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        this.a(h.g);
                        return;
                    }
                    this.a(h.f);
                    return;
                }
                this.a(h.a);
                return;
            }
            this.a(h.b);
            return;
        }
        this.a(h.c);
    }

    private void b(d d2) {
        if (d2.b()) {
            this.a(h.a);
            return;
        }
        this.a(d2);
    }

    @Override
    public void a() {
        this.b();
    }

    @Override
    public void a(ag.a a2) {
        this.d = a2;
    }

    protected void a(d d2) {
        this.e = null;
        ag.a a2 = this.d;
        if (a2 != null) {
            a2.a(d2);
        }
    }

    protected void a(h h2) {
        this.e = null;
        ag.a a2 = this.d;
        if (a2 != null) {
            a2.a(h2);
        }
    }

    @Override
    public void a(String string, String string2, c c2, AdRequest adRequest) {
        this.b();
        com.tappx.a.a.a.e.i i2 = this.b.a(string, c2, string2, adRequest);
        this.e = this.a.a(i2, new o<d>(){

            @Override
            public void a(d d2) {
                ah.this.b(d2);
            }
        }, new j<i.a>(){

            @Override
            public void a(i.a a2) {
                ah.this.a(a2);
            }
        });
        this.c.a();
    }

    void b() {
        i.b b2 = this.e;
        if (b2 != null) {
            this.a.a(b2);
            this.e = null;
        }
    }

}

