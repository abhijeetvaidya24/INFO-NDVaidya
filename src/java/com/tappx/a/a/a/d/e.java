/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  java.lang.Object
 *  java.lang.ref.WeakReference
 *  java.util.List
 */
package com.tappx.a.a.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tappx.a.a.a.d.af;
import com.tappx.a.a.a.d.c;
import com.tappx.a.a.a.d.d;
import com.tappx.a.a.a.d.e;
import com.tappx.a.a.a.e.b;
import com.tappx.a.a.a.e.h;
import java.lang.ref.WeakReference;
import java.util.List;

public class e
extends af
implements d {
    private d.a a;
    private final List<c.a> b;
    private c c;
    private c d;
    private a e;
    private a f;

    public e(List<c.a> list) {
        this.b = list;
    }

    private a a(c c2) {
        return new c.b(c2){
            private final c b;
            private WeakReference<View> c;
            {
                this.b = c2;
            }

            private boolean h() {
                return this != e.this.e;
            }

            private boolean i() {
                return this != e.this.f;
            }

            @Override
            public void a() {
                if (this.i()) {
                    return;
                }
                e.this.a.a(this.f());
            }

            @Override
            public void a(View view) {
                if (this.h()) {
                    return;
                }
                e.this.f();
                e.this.c = null;
                e.this.e = null;
                e.this.b();
                this.c = new WeakReference((Object)view);
                e.this.f = this;
                e.this.d = this.e();
                e.this.a.a(this.f(), view);
            }

            @Override
            public void a(h h2) {
                if (this.h()) {
                    return;
                }
                e.this.e();
            }

            @Override
            public void b() {
                if (this.i()) {
                    return;
                }
                e.this.a.b(this.f());
            }

            @Override
            public void c() {
                if (this.i()) {
                    return;
                }
                e.this.a.c(this.f());
            }

            @Override
            public void d() {
                if (this.i()) {
                    // empty if block
                }
            }

            public c e() {
                return this.b;
            }

            public b f() {
                return this.b.e();
            }

            protected View g() {
                WeakReference<View> weakReference = this.c;
                if (weakReference != null) {
                    return (View)weakReference.get();
                }
                return null;
            }
        };
    }

    private void a(View view) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof ViewGroup) {
            ((ViewGroup)viewParent).removeView(view);
        }
    }

    @Override
    protected void a() {
        c c2 = this.c;
        if (c2 != null) {
            c2.d();
            this.c = null;
            this.e = null;
        }
    }

    @Override
    public void a(d.a a2) {
        this.a = a2;
    }

    @Override
    protected void a(h h2) {
        d.a a2 = this.a;
        if (a2 != null) {
            a2.a(h2);
        }
    }

    @Override
    protected boolean a(Context context, b b2) {
        for (c.a a2 : this.b) {
            if (!a2.a(b2)) continue;
            this.c = a2.a();
            this.e = this.a(this.c);
            this.c.a(context, this.e, b2);
            return true;
        }
        return false;
    }

    @Override
    protected void b() {
        if (this.d != null) {
            View view = this.f.g();
            if (view != null) {
                this.a(view);
            }
            this.d.d();
            this.d = null;
            this.f = null;
        }
    }

}

