/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  java.lang.Class
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 */
package com.ironsource.mediationsdk.events;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ironsource.mediationsdk.logger.ThreadExceptionHandler;

public class SuperLooper
extends Thread {
    private static SuperLooper mInstance;
    private SupersonicSdkThread mSdkThread = new SupersonicSdkThread(this.getClass().getSimpleName());

    private SuperLooper() {
        this.mSdkThread.start();
        this.mSdkThread.prepareHandler();
    }

    public static SuperLooper getLooper() {
        Class<SuperLooper> class_ = SuperLooper.class;
        synchronized (SuperLooper.class) {
            if (mInstance == null) {
                mInstance = new SuperLooper();
            }
            SuperLooper superLooper = mInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return superLooper;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void post(Runnable runnable) {
        SuperLooper superLooper = this;
        synchronized (superLooper) {
            SupersonicSdkThread supersonicSdkThread = this.mSdkThread;
            if (supersonicSdkThread == null) {
                return;
            }
            Handler handler = this.mSdkThread.getCallbackHandler();
            if (handler != null) {
                handler.post(runnable);
            }
            return;
        }
    }

    private class SupersonicSdkThread
    extends HandlerThread {
        private Handler mHandler;

        SupersonicSdkThread(String string) {
            super(string);
            this.setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new ThreadExceptionHandler());
        }

        Handler getCallbackHandler() {
            return this.mHandler;
        }

        void prepareHandler() {
            this.mHandler = new Handler(this.getLooper());
        }
    }

}

