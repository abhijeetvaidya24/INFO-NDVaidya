/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.tappx.a.a.a.d;

import android.os.Handler;
import android.os.Looper;

public class ad {
    private final Handler a;
    private a b;
    private final Runnable c = new Runnable(){

        public void run() {
            if (ad.this.b != null) {
                ad.this.b.f();
            }
        }
    };

    public ad() {
        this(new Handler(Looper.getMainLooper()));
    }

    ad(Handler handler) {
        this.a = handler;
    }

    private void b() {
        this.a.removeCallbacks(this.c);
    }

    public void a() {
        this.b();
    }

    public void a(long l2) {
        this.b();
        this.a.postDelayed(this.c, l2);
    }

    public void a(a a2) {
        this.b = a2;
    }

    public static interface a {
        public void f();
    }

}

