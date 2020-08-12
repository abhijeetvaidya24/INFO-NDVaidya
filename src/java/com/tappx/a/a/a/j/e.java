/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.System
 */
package com.tappx.a.a.a.j;

import android.os.Handler;
import android.os.Looper;

public class e {
    private final Handler a;
    private final long b;
    private final long c;
    private final long d;
    private long e;
    private a f;
    private long g;
    private long h;
    private boolean i = true;
    private final Runnable j = new Runnable(){

        public void run() {
            e.this.g = 0L;
            if (e.this.f != null) {
                e.this.f.a();
            }
        }
    };

    public e(long l2, long l3, long l4) {
        this(new Handler(Looper.getMainLooper()), l2, l3, l4);
    }

    e(Handler handler, long l2, long l3, long l4) {
        this.a = handler;
        this.b = l2;
        this.c = l3;
        this.d = l4;
        this.a(this.d);
    }

    private void h() {
        this.a.removeCallbacks(this.j);
    }

    private long i() {
        return System.currentTimeMillis();
    }

    public void a() {
        if (!this.i) {
            return;
        }
        this.g = 0L;
        this.d();
    }

    public void a(long l2) {
        long l3;
        long l4 = this.b;
        if (l2 < l4) {
            l2 = l4;
        }
        if (l2 > (l3 = this.c)) {
            l2 = l3;
        }
        this.e = l2;
    }

    public void a(a a2) {
        this.f = a2;
    }

    public void a(boolean bl2) {
        this.i = bl2;
        if (!bl2) {
            this.b();
        }
    }

    public void b() {
        this.c();
        this.g = 0L;
    }

    public void c() {
        this.h();
        this.g += this.i() - this.h;
    }

    public void d() {
        if (!this.i) {
            return;
        }
        long l2 = this.e;
        long l3 = this.g;
        if (l3 > 0L && l3 < l2) {
            l2 -= l3;
        }
        this.h();
        this.a.postDelayed(this.j, l2);
        this.h = this.i();
    }

    public void e() {
        this.a(this.d);
    }

    public long f() {
        return this.e;
    }

    public boolean g() {
        return this.i;
    }

    public static interface a {
        public void a();
    }

}

