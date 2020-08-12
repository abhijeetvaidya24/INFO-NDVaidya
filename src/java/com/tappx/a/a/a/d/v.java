/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.util.List
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import com.tappx.a.a.a.d.af;
import com.tappx.a.a.a.d.t;
import com.tappx.a.a.a.d.u;
import com.tappx.a.a.a.e.b;
import com.tappx.a.a.a.e.d;
import com.tappx.a.a.a.e.h;
import java.util.List;

public class v
extends af
implements u {
    private u.a a;
    private final List<t.a> b;
    private t c;
    private t d;
    private a e;
    private a f;

    public v(List<t.a> list) {
        this.b = list;
    }

    private a a(t t2) {
        return new t.b(t2){
            private final t b;
            {
                this.b = t2;
            }

            private boolean g() {
                return this != v.this.e;
            }

            private boolean h() {
                return this != v.this.f;
            }

            @Override
            public void a() {
            }

            @Override
            public void a(t t2) {
                if (this.g()) {
                    return;
                }
                v.this.f();
                v.this.c = null;
                v.this.e = null;
                v.this.b();
                v.this.f = this;
                v.this.d = this.e();
                v.this.a.a(this.f(), this.e());
            }

            @Override
            public void a(h h2) {
                if (this.g()) {
                    return;
                }
                v.this.e();
            }

            @Override
            public void b() {
                v.this.a.b(this.f());
            }

            @Override
            public void c() {
            }

            @Override
            public void d() {
                if (this.h()) {
                    return;
                }
                v.this.a.a(this.f());
            }

            public t e() {
                return this.b;
            }

            public b f() {
                return this.b.d();
            }
        };
    }

    @Override
    protected void a() {
        t t2 = this.c;
        if (t2 != null) {
            t2.e();
            this.c = null;
            this.e = null;
        }
    }

    @Override
    public void a(u.a a2) {
        this.a = a2;
    }

    @Override
    protected void a(h h2) {
        u.a a2 = this.a;
        if (a2 != null) {
            a2.a(h2);
        }
    }

    @Override
    protected boolean a(Context context, b b2) {
        for (t.a a2 : this.b) {
            if (!a2.a(b2)) continue;
            this.c = a2.a();
            this.e = this.a(this.c);
            this.c.b(context, this.e, b2);
            return true;
        }
        return false;
    }

    @Override
    protected void b() {
        t t2 = this.d;
        if (t2 != null) {
            t2.e();
            this.d = null;
            this.f = null;
        }
    }

}

