/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Void
 *  java.util.concurrent.Executor
 */
package com.tappx.a.a.a.j;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public class f {
    private static final Handler a = new Handler(Looper.getMainLooper());

    public static /* varargs */ <P> void a(AsyncTask<P, ?, ?> asyncTask, P ... arrP) {
        if (Build.VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])arrP);
            return;
        }
        asyncTask.execute((Object[])arrP);
    }

    public static void a(Runnable runnable) {
        a.post(runnable);
    }

    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private static class b
    extends AsyncTask<Runnable, Void, Void> {
        private b() {
        }

        protected /* varargs */ Void a(Runnable ... arrrunnable) {
            if (arrrunnable == null) {
                return null;
            }
            for (int i2 = 0; i2 < arrrunnable.length; ++i2) {
                arrrunnable[i2].run();
            }
            return null;
        }

        protected /* synthetic */ Object doInBackground(Object[] arrobject) {
            return this.a((Runnable[])arrobject);
        }
    }

    public static interface c {
        public void a(Runnable var1);
    }

}

