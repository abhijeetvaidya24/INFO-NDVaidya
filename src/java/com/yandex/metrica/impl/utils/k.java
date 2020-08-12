/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.yandex.metrica.impl.ob.cc
 *  java.lang.Object
 *  java.lang.System
 */
package com.yandex.metrica.impl.utils;

import android.content.Context;
import com.yandex.metrica.impl.ob.bp;
import com.yandex.metrica.impl.ob.bq;
import com.yandex.metrica.impl.ob.cc;

public class k {
    private volatile long a;
    private cc b;

    private k() {
    }

    /* synthetic */ k(byte by) {
        this();
    }

    public static k a() {
        return a.a;
    }

    public void a(long l2) {
        k k2 = this;
        synchronized (k2) {
            this.a = (l2 - System.currentTimeMillis()) / 1000L;
            if (this.b != null) {
                this.b.a(this.a);
                this.b.h();
            }
            return;
        }
    }

    public void a(Context context) {
        k k2 = this;
        synchronized (k2) {
            if (context != null) {
                this.b = new cc(bp.a(context).b());
                this.a = this.b.c(0);
            }
            return;
        }
    }

    public long b() {
        k k2 = this;
        synchronized (k2) {
            long l2 = this.a;
            return l2;
        }
    }

    private static class a {
        static k a = new k(0);
    }

}

