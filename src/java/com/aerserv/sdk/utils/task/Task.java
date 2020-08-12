/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.aerserv.sdk.utils.task;

import com.aerserv.sdk.utils.task.TaskListener;
import com.aerserv.sdk.utils.task.TaskResult;

public interface Task<P, R> {
    public boolean cancel();

    public /* varargs */ void run(P ... var1);

    public TaskResult<R> waitForResult();

    public Task<P, R> withListener(TaskListener<R> var1);

    public Task<P, R> withTimeout(long var1);
}

