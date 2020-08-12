/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.FrameLayout
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tappx.a.a.a.c.a;
import com.tappx.a.a.b.k;
import com.tappx.a.a.b.s;
import com.tappx.a.a.b.u;

public class m
implements k {
    private k.b a;
    private final Context b;
    private u c;
    private u.a d = new u.a(){

        @Override
        public void a() {
            a.e("ZJVkXnYZGc0zgB3S4AsbuD81KHR8Nkg8UponZZuzRBk", new Object[0]);
            if (m.this.a != null) {
                m.this.a.a();
            }
        }

        @Override
        public void a(View view) {
            a.e("v5lNHAiXCIZ1hAylTNDUIT+qLa9pGoGxoSFqUJi0Wwg", new Object[0]);
            if (m.this.a != null) {
                m.this.a.a(view);
            }
        }

        @Override
        public void b() {
            if (m.this.a != null) {
                m.this.a.b();
            }
        }

        @Override
        public void c() {
            if (m.this.a != null) {
                m.this.a.c();
            }
        }

        @Override
        public void d() {
            if (m.this.a != null) {
                m.this.a.d();
            }
        }
    };
    private u.d e = new u.d(){

        @Override
        public void a(boolean bl) {
            if (m.this.a != null) {
                m.this.a.a(bl);
            }
        }
    };

    m(Context context) {
        this.b = context;
    }

    @Override
    public View a(s s2, String string, k.a a2) {
        a.e("3ZJsjFJl8424bBJ0FHBsPsvg6JPdFtnXjH4FLENWtoY", new Object[0]);
        this.c = new u(this.b, s2);
        this.c.a(this.d);
        this.c.a(string);
        this.c.a(this.e);
        return this.c.h();
    }

    @Override
    public void a() {
        u u2 = this.c;
        if (u2 != null) {
            u2.a((u.a)null);
            this.c.d();
        }
    }

    @Override
    public void a(k.b b2) {
        this.a = b2;
    }

    @Override
    public void a(boolean bl) {
        u u2 = this.c;
        if (u2 != null) {
            u2.a(bl);
        }
    }

    @Override
    public void b() {
        u u2 = this.c;
        if (u2 != null) {
            u2.c();
        }
    }

}

