/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  com.tapjoy.internal.x$1
 *  java.lang.Class
 *  java.lang.Object
 */
package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;
import com.tapjoy.internal.bf;
import com.tapjoy.internal.x;

public final class x {
    private static Handler a;

    public static Handler a() {
        Class<x> class_ = x.class;
        synchronized (x.class) {
            if (a == null) {
                a = new Handler(Looper.getMainLooper());
            }
            Handler handler = a;
            // ** MonitorExit[var2] (shouldn't be in output)
            return handler;
        }
    }

    public static bf a(Handler handler) {
        return new 1(handler);
    }
}

