/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  java.lang.Object
 */
package com.yandex.metrica.impl;

import android.os.SystemClock;

class q {
    private long a = SystemClock.elapsedRealtime() - 2000000L;
    private boolean b = true;

    q() {
    }

    boolean a() {
        boolean bl2 = this.b;
        this.b = false;
        long l2 = SystemClock.elapsedRealtime() - this.a;
        return bl2 && l2 > 1000L;
    }

    void b() {
        this.b = true;
        this.a = SystemClock.elapsedRealtime();
    }

    boolean c() {
        return this.b;
    }
}

