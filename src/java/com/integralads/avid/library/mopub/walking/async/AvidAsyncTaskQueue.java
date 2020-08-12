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
package com.integralads.avid.library.mopub.walking.async;

import com.integralads.avid.library.mopub.walking.async.AvidAsyncTask;
import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AvidAsyncTaskQueue
implements AvidAsyncTask.AvidAsyncTaskListener {
    private AvidAsyncTask currentTask = null;
    private final ArrayDeque<AvidAsyncTask> pendingTasks = new ArrayDeque();
    private final ThreadPoolExecutor threadPoolExecutor;
    private final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue();

    public AvidAsyncTaskQueue() {
        ThreadPoolExecutor threadPoolExecutor;
        this.threadPoolExecutor = threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.workQueue);
    }

    private void executeNextTask() {
        this.currentTask = (AvidAsyncTask)((Object)this.pendingTasks.poll());
        AvidAsyncTask avidAsyncTask = this.currentTask;
        if (avidAsyncTask != null) {
            avidAsyncTask.start(this.threadPoolExecutor);
        }
    }

    @Override
    public void onTaskCompleted(AvidAsyncTask avidAsyncTask) {
        this.currentTask = null;
        this.executeNextTask();
    }

    public void submitTask(AvidAsyncTask avidAsyncTask) {
        avidAsyncTask.setListener(this);
        this.pendingTasks.add((Object)avidAsyncTask);
        if (this.currentTask == null) {
            this.executeNextTask();
        }
    }
}

