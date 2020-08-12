/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.tappx.a.a.a.d.s$1
 *  com.tappx.a.a.a.d.t
 *  com.tappx.a.a.a.e.f
 *  com.tappx.a.a.b.a
 *  com.tappx.a.a.b.a.e
 *  com.tappx.a.a.b.b
 *  com.tappx.sdk.a.a
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import com.tappx.a.a.a.d.s;
import com.tappx.a.a.a.d.t;
import com.tappx.a.a.a.e.a;
import com.tappx.a.a.a.e.f;
import com.tappx.a.a.b.a.d;
import com.tappx.a.a.b.a.e;
import com.tappx.a.a.b.b;

public class s {
    private final Context a;
    private t.b b;
    private e c;
    private f d;
    private t e;
    private d.a f = new 1(this);

    public s(Context context) {
        this.a = context;
    }

    static /* synthetic */ t a(s s2) {
        return s2.e;
    }

    private com.tappx.a.a.b.a a(int n2) {
        if (n2 != 1) {
            if (n2 != 2) {
                return com.tappx.a.a.b.a.a;
            }
            return com.tappx.a.a.b.a.c;
        }
        return com.tappx.a.a.b.a.b;
    }

    static /* synthetic */ t.b b(s s2) {
        return s2.b;
    }

    public void a() {
        e e2 = this.c;
        if (e2 != null) {
            e2.a();
        }
    }

    public void a(f f2, t.b b2, t t2) {
        this.d = f2;
        this.b = b2;
        this.e = t2;
        this.c = new e();
        this.c.a(this.f);
        b b3 = com.tappx.a.a.a.j.a.a(f2.e());
        com.tappx.sdk.a.a a2 = new com.tappx.sdk.a.a().a(f2.l()).a(f2.m()).b(f2.k()).c(f2.i()).c(f2.j()).b(f2.n()).a(this.a(f2.g())).a(b3);
        this.c.a(this.a, f2.h(), a2);
    }

    public void b() {
        e e2 = this.c;
        if (e2 != null) {
            e2.b();
        }
    }
}

