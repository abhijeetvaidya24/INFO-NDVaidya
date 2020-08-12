/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  io.presage.g
 *  io.presage.i$CamembertauCalvados
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 */
package io.presage;

import android.os.Handler;
import android.os.Looper;
import io.presage.b;
import io.presage.f;
import io.presage.g;
import io.presage.h;
import io.presage.i;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i {
    private final List<h> a = (List)new LinkedList();
    private final f b = this.b();
    private int c;
    private int d;
    private boolean e;
    private Handler f = new Handler(Looper.getMainLooper());
    private b g;

    public static final /* synthetic */ int a(i i2) {
        return i2.c;
    }

    private final void a(long l2) {
        this.f.postDelayed(new Runnable(){

            public final void run() {
                this.i();
            }
        }, l2);
    }

    public static final /* synthetic */ void a(i i2, int n2) {
        i2.c = n2;
    }

    private final f b() {
        return (f)new CamembertauCalvados(this);
    }

    public static final /* synthetic */ void b(i i2) {
        i2.c();
    }

    private final void c() {
        if (this.e()) {
            this.g();
            return;
        }
        if (this.d()) {
            this.f();
        }
    }

    public static final /* synthetic */ boolean c(i i2) {
        return i2.d();
    }

    private final boolean d() {
        return this.c == this.a.size();
    }

    public static final /* synthetic */ boolean d(i i2) {
        return i2.e;
    }

    public static final /* synthetic */ void e(i i2) {
        i2.f();
    }

    private final boolean e() {
        return this.d == 1;
    }

    private final void f() {
        this.h();
        b b2 = this.g;
        if (b2 != null) {
            b2.a();
        }
    }

    public static final /* synthetic */ void f(i i2) {
        i2.g();
    }

    private final void g() {
        this.h();
        this.e = true;
        b b2 = this.g;
        if (b2 != null) {
            b2.b();
        }
    }

    private final void h() {
        this.f.removeCallbacksAndMessages(null);
    }

    private final void i() {
        if (this.k()) {
            this.f();
            this.j();
            return;
        }
        this.l();
        b b2 = this.g;
        if (b2 != null) {
            b2.b();
        }
    }

    private final void j() {
        for (h h2 : this.a) {
            if (!(h2 instanceof g)) continue;
            h2.b();
        }
    }

    private final boolean k() {
        for (h h2 : this.a) {
            if (h2.a() || h2 instanceof g) continue;
            return false;
        }
        return true;
    }

    private final void l() {
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ((h)iterator.next()).b();
        }
    }

    public final void a() {
        this.h();
        this.l();
        this.a.clear();
        this.c = 0;
        this.e = false;
    }

    public final void a(long l2, int n2) {
        this.d = n2;
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ((h)iterator.next()).a(this.b);
        }
        this.a(l2);
    }

    public final void a(b b2) {
        this.g = b2;
    }

    public final void a(h h2) {
        this.a.add((Object)h2);
    }

}

