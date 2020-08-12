/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.SystemClock
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.tappx.a.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tappx.a.a.a.a.a;

public class j {
    private static final long a = 200L;
    private final Handler b = new Handler(Looper.getMainLooper());
    private int c = -1;
    private long d;
    private a e;
    private final Runnable f = new Runnable(){

        public void run() {
            int n2 = (int)Math.floor((double)((float)(j.this.d - j.this.b()) / 1000.0f));
            if (n2 > 0) {
                j.this.b.removeCallbacks(j.this.f);
                j.this.b.postDelayed(j.this.f, 200L);
            }
            if (n2 == j.this.c) {
                return;
            }
            j.this.c = n2;
            if (j.this.e != null) {
                j.this.e.a(n2);
            }
        }
    };

    public void a(long l2) {
        if (l2 > a.a.k) {
            l2 = a.a.k;
        }
        this.d = l2 + this.b();
        this.f.run();
    }

    public void a(a a2) {
        this.e = a2;
    }

    public boolean a() {
        return this.d == 0L || this.b() > this.d;
        {
        }
    }

    long b() {
        return SystemClock.elapsedRealtime();
    }

    public static interface a {
        public void a(int var1);
    }

}

