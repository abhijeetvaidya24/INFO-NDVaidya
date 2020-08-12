/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.Executors
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 */
package com.tapjoy.internal;

import com.tapjoy.internal.y;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class gq {
    public static final ScheduledExecutorService a = Executors.newScheduledThreadPool((int)1);
    public static final CountDownLatch b = new CountDownLatch(1);
    public static final CountDownLatch c;
    private static final Runnable d;
    private static String e;
    private static boolean f;

    static {
        d = new Runnable(){

            public final void run() {
                if (y.c()) {
                    gq.b.countDown();
                    return;
                }
                if (y.a()) {
                    gq.b.countDown();
                    return;
                }
                gq.a.schedule((Runnable)this, 300L, TimeUnit.SECONDS);
            }
        };
        c = new CountDownLatch(1);
    }

    public static void a() {
        a.execute(d);
    }

    public static void a(String string2, boolean bl2) {
        e = string2;
        f = bl2;
        c.countDown();
    }

    public static String b() {
        return e;
    }

    public static boolean c() {
        return f;
    }

}

