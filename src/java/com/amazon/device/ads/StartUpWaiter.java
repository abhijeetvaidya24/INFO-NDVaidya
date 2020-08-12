/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.amazon.device.ads;

import android.util.SparseArray;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StartUpWaiter;
import com.amazon.device.ads.ThreadUtils;

abstract class StartUpWaiter
implements Configuration.ConfigurationListener,
Settings.SettingsListener {
    static final int CALLBACK_ON_MAIN_THREAD = 0;
    static final int DEFAULT = 1;
    private static final SparseArray<ThreadUtils.RunnableExecutor> executors = new SparseArray();
    private int callbackType = 1;
    private final Configuration configuration;
    private final Settings settings;

    static {
        StartUpWaiter.putRunnableExecutor(0, new ThreadUtils.RunnableExecutor(){

            public void execute(Runnable runnable) {
                new android.os.Handler(android.os.Looper.getMainLooper()).post(runnable);
            }
        });
        StartUpWaiter.putRunnableExecutor(1, new ThreadUtils.RunnableExecutor(){
            private static final int keepAliveTimeSeconds = 30;
            private static final int maxNumberThreads = 3;
            private static final int numberThreads = 1;
            private final java.util.concurrent.ExecutorService executorService;
            {
                java.util.concurrent.ThreadPoolExecutor threadPoolExecutor = new java.util.concurrent.ThreadPoolExecutor(1, 3, 30L, java.util.concurrent.TimeUnit.SECONDS, (java.util.concurrent.BlockingQueue)new java.util.concurrent.LinkedBlockingQueue());
                this.executorService = threadPoolExecutor;
            }

            public void execute(Runnable runnable) {
                this.executorService.submit(runnable);
            }
        });
    }

    public StartUpWaiter(Settings settings, Configuration configuration) {
        this.settings = settings;
        this.configuration = configuration;
    }

    static ThreadUtils.RunnableExecutor getExecutor(int n2) {
        SparseArray<ThreadUtils.RunnableExecutor> sparseArray = executors;
        return (ThreadUtils.RunnableExecutor)sparseArray.get(n2, sparseArray.get(1));
    }

    private void onFinished(Runnable runnable) {
        StartUpWaiter.getExecutor(this.callbackType).execute(runnable);
    }

    static void putRunnableExecutor(int n2, ThreadUtils.RunnableExecutor runnableExecutor) {
        if (runnableExecutor == null) {
            executors.remove(n2);
            return;
        }
        executors.put(n2, (Object)runnableExecutor);
    }

    Configuration getConfiguration() {
        return this.configuration;
    }

    Settings getSettings() {
        return this.settings;
    }

    @Override
    public void onConfigurationFailure() {
        this.onFinished(new Runnable(this){
            final /* synthetic */ StartUpWaiter this$0;
            {
                this.this$0 = startUpWaiter;
            }

            public void run() {
                this.this$0.startUpFailed();
            }
        });
    }

    @Override
    public void onConfigurationReady() {
        this.onFinished(new Runnable(this){
            final /* synthetic */ StartUpWaiter this$0;
            {
                this.this$0 = startUpWaiter;
            }

            public void run() {
                this.this$0.startUpReady();
            }
        });
    }

    @Override
    public void settingsLoaded() {
        this.configuration.queueConfigurationListener(this);
    }

    public void start() {
        this.settings.listenForSettings(this);
    }

    public void startAndCallbackOnMainThread() {
        this.callbackType = 0;
        this.start();
    }

    protected abstract void startUpFailed();

    protected abstract void startUpReady();
}

