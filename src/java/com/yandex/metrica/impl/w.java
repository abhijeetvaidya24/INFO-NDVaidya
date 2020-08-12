/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.SystemClock
 *  com.yandex.metrica.CounterConfiguration
 *  com.yandex.metrica.impl.aw
 *  com.yandex.metrica.impl.b
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.yandex.metrica.impl;

import android.os.Handler;
import android.os.SystemClock;
import com.yandex.metrica.CounterConfiguration;
import com.yandex.metrica.impl.aw;
import com.yandex.metrica.impl.b;
import com.yandex.metrica.impl.x;

class w {
    private final Handler a;
    private final b b;
    private final x c;

    w(Handler handler, b b2) {
        this.a = handler;
        this.b = b2;
        this.c = new x(handler, b2);
    }

    private static String a(b b2) {
        return b2.d().b().j();
    }

    static void a(Handler handler, b b2, Runnable runnable) {
        w.b(handler, b2, runnable);
        handler.postAtTime(runnable, (Object)w.a(b2), SystemClock.uptimeMillis() + (long)(500 * b2.d().b().d()));
    }

    private static void b(Handler handler, b b2, Runnable runnable) {
        handler.removeCallbacks(runnable, (Object)w.a(b2));
    }

    void a() {
        w.b(this.a, this.b, this.c);
    }

    void b() {
        w.a(this.a, this.b, this.c);
    }
}

