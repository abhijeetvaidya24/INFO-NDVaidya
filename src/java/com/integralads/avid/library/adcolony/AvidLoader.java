/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.Executor
 */
package com.integralads.avid.library.adcolony;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import com.integralads.avid.library.adcolony.AvidBridge;
import com.integralads.avid.library.adcolony.AvidLoader;
import com.integralads.avid.library.adcolony.DownloadAvidTask;
import java.util.concurrent.Executor;

public class AvidLoader
implements DownloadAvidTask.DownloadAvidTaskListener {
    private static AvidLoader c = new AvidLoader();
    private AvidLoaderListener d;
    private DownloadAvidTask e;
    private Context f;
    private TaskExecutor g = new Object(){

        public void executeTask(DownloadAvidTask downloadAvidTask) {
            if (Build.VERSION.SDK_INT >= 11) {
                AvidLoader.this.e.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new String[]{"https://mobile-static.adsafeprotected.com/avid-v2.js"});
                return;
            }
            AvidLoader.this.e.execute((Object[])new String[]{"https://mobile-static.adsafeprotected.com/avid-v2.js"});
        }
    };
    private TaskRepeater h;
    private final Runnable i = new Runnable(this){
        final /* synthetic */ AvidLoader a;
        {
            this.a = avidLoader;
        }

        public void run() {
            if (AvidLoader.d(this.a) != null && com.integralads.avid.library.adcolony.utils.NetworkUtils.isNetworkAvailable(AvidLoader.d(this.a))) {
                AvidLoader.e(this.a);
                return;
            }
            AvidLoader.f(this.a);
        }
    };

    private void c() {
        if (!AvidBridge.isAvidJsReady() && this.e == null) {
            this.e = new DownloadAvidTask();
            this.e.setListener(this);
            this.g.executeTask(this.e);
        }
    }

    static /* synthetic */ Context d(AvidLoader avidLoader) {
        return avidLoader.f;
    }

    private void d() {
        TaskRepeater taskRepeater = this.h;
        if (taskRepeater != null) {
            taskRepeater.repeatLoading();
        }
    }

    static /* synthetic */ void e(AvidLoader avidLoader) {
        avidLoader.c();
    }

    static /* synthetic */ void f(AvidLoader avidLoader) {
        avidLoader.d();
    }

    public static AvidLoader getInstance() {
        return c;
    }

    @Override
    public void failedToLoadAvid() {
        this.e = null;
        this.d();
    }

    @Override
    public void onLoadAvid(String string) {
        this.e = null;
        AvidBridge.setAvidJs(string);
        AvidLoaderListener avidLoaderListener = this.d;
        if (avidLoaderListener != null) {
            avidLoaderListener.onAvidLoaded();
        }
    }

    public void registerAvidLoader(Context context) {
        this.f = context;
        this.h = new Object(){
            private Handler b = new Handler();

            public void cleanup() {
                this.b.removeCallbacks(AvidLoader.this.i);
            }

            public void repeatLoading() {
                this.b.postDelayed(AvidLoader.this.i, 2000L);
            }
        };
        this.c();
    }

    public void setListener(AvidLoaderListener avidLoaderListener) {
        this.d = avidLoaderListener;
    }

    public void unregisterAvidLoader() {
        TaskRepeater taskRepeater = this.h;
        if (taskRepeater != null) {
            taskRepeater.cleanup();
            this.h = null;
        }
        this.d = null;
        this.f = null;
    }

}

