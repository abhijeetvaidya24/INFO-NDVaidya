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
package com.integralads.avid.library.mopub;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import com.integralads.avid.library.mopub.AvidBridge;
import com.integralads.avid.library.mopub.AvidLoader;
import com.integralads.avid.library.mopub.DownloadAvidTask;
import java.util.concurrent.Executor;

public class AvidLoader
implements DownloadAvidTask.DownloadAvidTaskListener {
    private static AvidLoader avidLoader = new AvidLoader();
    private DownloadAvidTask activeTask;
    private final Runnable avidDownloadRunnable = new Runnable(this){
        final /* synthetic */ AvidLoader this$0;
        {
            this.this$0 = avidLoader;
        }

        public void run() {
            if (AvidLoader.access$200(this.this$0) != null && com.integralads.avid.library.mopub.utils.NetworkUtils.isNetworkAvailable(AvidLoader.access$200(this.this$0))) {
                AvidLoader.access$300(this.this$0);
                return;
            }
            AvidLoader.access$400(this.this$0);
        }
    };
    private Context context;
    private AvidLoaderListener listener;
    private TaskExecutor taskExecutor = new Object(){

        public void executeTask(DownloadAvidTask downloadAvidTask) {
            if (Build.VERSION.SDK_INT >= 11) {
                AvidLoader.this.activeTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new String[]{"https://mobile-static.adsafeprotected.com/avid-v2.js"});
                return;
            }
            AvidLoader.this.activeTask.execute((Object[])new String[]{"https://mobile-static.adsafeprotected.com/avid-v2.js"});
        }
    };
    private TaskRepeater taskRepeater;

    static /* synthetic */ Context access$200(AvidLoader avidLoader) {
        return avidLoader.context;
    }

    static /* synthetic */ void access$300(AvidLoader avidLoader) {
        avidLoader.loadAvidJSFromUrl();
    }

    static /* synthetic */ void access$400(AvidLoader avidLoader) {
        avidLoader.repeatLoading();
    }

    public static AvidLoader getInstance() {
        return avidLoader;
    }

    private void loadAvidJSFromUrl() {
        if (!AvidBridge.isAvidJsReady() && this.activeTask == null) {
            this.activeTask = new DownloadAvidTask();
            this.activeTask.setListener(this);
            this.taskExecutor.executeTask(this.activeTask);
        }
    }

    private void repeatLoading() {
        TaskRepeater taskRepeater = this.taskRepeater;
        if (taskRepeater != null) {
            taskRepeater.repeatLoading();
        }
    }

    @Override
    public void failedToLoadAvid() {
        this.activeTask = null;
        this.repeatLoading();
    }

    public AvidLoaderListener getListener() {
        return this.listener;
    }

    @Override
    public void onLoadAvid(String string) {
        this.activeTask = null;
        AvidBridge.setAvidJs(string);
        AvidLoaderListener avidLoaderListener = this.listener;
        if (avidLoaderListener != null) {
            avidLoaderListener.onAvidLoaded();
        }
    }

    public void registerAvidLoader(Context context) {
        this.context = context;
        this.taskRepeater = new Object(){
            private Handler handler = new Handler();

            public void cleanup() {
                this.handler.removeCallbacks(AvidLoader.this.avidDownloadRunnable);
            }

            public void repeatLoading() {
                this.handler.postDelayed(AvidLoader.this.avidDownloadRunnable, 2000L);
            }
        };
        this.loadAvidJSFromUrl();
    }

    public void setListener(AvidLoaderListener avidLoaderListener) {
        this.listener = avidLoaderListener;
    }

    public void unregisterAvidLoader() {
        TaskRepeater taskRepeater = this.taskRepeater;
        if (taskRepeater != null) {
            taskRepeater.cleanup();
            this.taskRepeater = null;
        }
        this.listener = null;
        this.context = null;
    }

}

