/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.aerserv.sdk.utils.task;

import com.aerserv.sdk.utils.task.TaskResult;

public interface TaskListener<R> {
    public void onTaskResult(TaskResult<R> var1);
}

