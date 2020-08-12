/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.tapjoy.internal;

import android.os.SystemClock;
import com.tapjoy.internal.fn;

public final class y {
    private static String a = "pool.ntp.org";
    private static long b = 20000L;
    private static volatile boolean c;
    private static volatile String d;
    private static volatile long e;
    private static volatile long f;
    private static volatile long g;
    private static volatile long h;
    private static volatile long i;

    static {
        long l2 = SystemClock.elapsedRealtime();
        y.a(false, "System", System.currentTimeMillis(), l2, Long.MAX_VALUE);
    }

    public static long a(long l2) {
        return l2 + h;
    }

    private static void a(boolean bl2, String string2, long l2, long l3, long l4) {
        Class<y> class_ = y.class;
        synchronized (y.class) {
            c = bl2;
            d = string2;
            e = l2;
            f = l3;
            g = l4;
            h = e - f;
            i = SystemClock.elapsedRealtime() + h - System.currentTimeMillis();
            // ** MonitorExit[var9_5] (shouldn't be in output)
            return;
        }
    }

    public static boolean a() {
        fn fn2 = new fn();
        String string2 = a;
        long l2 = b;
        if (fn2.a(string2, (int)l2)) {
            y.a(true, "SNTP", fn2.a, fn2.b, fn2.c / 2L);
            return true;
        }
        return false;
    }

    public static long b() {
        return SystemClock.elapsedRealtime() + h;
    }

    public static boolean c() {
        return c;
    }
}

