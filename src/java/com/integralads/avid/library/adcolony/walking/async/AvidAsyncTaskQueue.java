/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.util.ArrayDeque
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.LinkedBlockingQueue
 *  java.util.concurrent.ThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 */
package com.integralads.avid.library.adcolony.walking.async;

import com.integralads.avid.library.adcolony.walking.async.AvidAsyncTask;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AvidAsyncTaskQueue
implements AvidAsyncTask.AvidAsyncTaskListener {
    private final BlockingQueue<Runnable> b = new LinkedBlockingQueue();
    private final ThreadPoolExecutor c;
    private final ArrayDeque<AvidAsyncTask> d = new ArrayDeque();
    private AvidAsyncTask e = null;

    public AvidAsyncTaskQueue() {
        ThreadPoolExecutor threadPoolExecutor;
        this.c = threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.b);
    }

    private void c() {
        this.e = (AvidAsyncTask)((Object)this.d.poll());
        AvidAsyncTask avidAsyncTask = this.e;
        if (avidAsyncTask != null) {
            avidAsyncTask.start(this.c);
        }
    }

    @Override
    public void onTaskCompleted(AvidAsyncTask avidAsyncTask) {
        this.e = null;
        this.c();
    }

    public void submitTask(AvidAsyncTask avidAsyncTask) {
        avidAsyncTask.setListener(this);
        this.d.add((Object)avidAsyncTask);
        if (this.e == null) {
            this.c();
        }
    }
}

