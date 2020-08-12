/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.appnext.base.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class g {
    private static g fr;
    private static Context mContext;
    private Handler fs;
    private Handler ft;
    private HandlerThread fu;

    public g() {
        try {
            this.fs = new Handler(Looper.getMainLooper());
            this.fu = new HandlerThread("ExecutesManagerWorkerThread");
            this.fu.start();
            this.ft = new Handler(this.fu.getLooper());
        }
        catch (Throwable throwable) {}
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static g aN() {
        if (fr != null) return fr;
        Class<g> class_ = g.class;
        synchronized (g.class) {
            if (fr != null) return fr;
            fr = new g();
            // ** MonitorExit[var1] (shouldn't be in output)
            return fr;
        }
    }

    public final void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            this.fs.post(runnable);
        }
        catch (Throwable throwable) {}
    }

    public final void a(Runnable runnable, long l2) {
        if (runnable == null) {
            return;
        }
        try {
            this.fs.postDelayed(runnable, l2);
        }
        catch (Throwable throwable) {}
    }

    public final void b(Runnable runnable) {
        try {
            this.ft.post(runnable);
        }
        catch (Throwable throwable) {}
    }

    public final void b(Runnable runnable, long l2) {
        if (runnable == null) {
            return;
        }
        try {
            this.ft.postDelayed(runnable, l2);
        }
        catch (Throwable throwable) {}
    }

    protected void finalize() {
        try {
            this.ft.removeCallbacks(null);
            this.fu.quit();
            super.finalize();
            return;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return;
        }
    }
}

