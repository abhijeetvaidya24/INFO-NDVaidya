/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.util.concurrent.Executor
 */
package com.tappx.a.a.b;

import android.os.AsyncTask;
import android.os.Build;
import java.util.concurrent.Executor;

class al {
    public static /* varargs */ <P> void a(AsyncTask<P, ?, ?> asyncTask, P ... arrP) {
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])arrP);
            return;
        }
        asyncTask.execute((Object[])arrP);
    }

    public static boolean a(int n2, int n3) {
        return (n2 & n3) != 0;
    }
}

