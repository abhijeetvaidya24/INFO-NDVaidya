/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  java.lang.Object
 */
package com.tappx.a.a.b;

import android.content.Context;
import android.graphics.Rect;
import com.tappx.a.a.b.h;

class ae {
    private final Context a;
    private final Rect b;
    private final Rect c;
    private final Rect d;
    private final Rect e;
    private final Rect f;
    private final Rect g;
    private final Rect h;
    private final Rect i;
    private final float j;

    ae(Context context, float f2) {
        this.a = context.getApplicationContext();
        this.j = f2;
        this.b = new Rect();
        this.c = new Rect();
        this.d = new Rect();
        this.e = new Rect();
        this.f = new Rect();
        this.g = new Rect();
        this.h = new Rect();
        this.i = new Rect();
    }

    private void a(Rect rect, Rect rect2) {
        rect2.set(h.b(rect.left, this.a), h.b(rect.top, this.a), h.b(rect.right, this.a), h.b(rect.bottom, this.a));
    }

    void a(int n2, int n3) {
        this.b.set(0, 0, n2, n3);
        this.a(this.b, this.c);
    }

    void a(int n2, int n3, int n4, int n5) {
        this.d.set(n2, n3, n4 + n2, n5 + n3);
        this.a(this.d, this.e);
    }

    void b(int n2, int n3, int n4, int n5) {
        this.f.set(n2, n3, n4 + n2, n5 + n3);
        this.a(this.f, this.g);
    }

    Rect c() {
        return this.c;
    }

    void c(int n2, int n3, int n4, int n5) {
        this.h.set(n2, n3, n4 + n2, n5 + n3);
        this.a(this.h, this.i);
    }

    Rect d() {
        return this.d;
    }

    Rect e() {
        return this.e;
    }

    Rect f() {
        return this.f;
    }

    Rect g() {
        return this.g;
    }

    Rect h() {
        return this.h;
    }

    Rect i() {
        return this.i;
    }
}

