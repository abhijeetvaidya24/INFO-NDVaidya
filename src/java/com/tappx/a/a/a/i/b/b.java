/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.concurrent.Executor
 */
package com.tappx.a.a.a.i.b;

import android.os.AsyncTask;
import java.util.concurrent.Executor;

class b {
    private static volatile boolean a;
    private static final Object b;

    static {
        b = new Object();
    }

    public static void b(Runnable runnable) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(runnable);
    }
}

