/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.utils.task;

import com.aerserv.sdk.utils.task.TaskStatus;

public class TaskResult<T> {
    private String message;
    private TaskStatus taskStatus;
    private T value;

    public TaskResult(TaskStatus taskStatus, T t2, String string) {
        this.taskStatus = taskStatus;
        this.value = t2;
        this.message = string;
    }

    public static <T> TaskResult<T> canceled() {
        return new TaskResult<Object>(TaskStatus.CANCELED, null, "Task canceled");
    }

    public static <T> TaskResult<T> error(String string) {
        return new TaskResult<Object>(TaskStatus.ERROR, null, string);
    }

    public static <T> TaskResult<T> failed(String string) {
        return new TaskResult<Object>(TaskStatus.FAILED, null, string);
    }

    public static <T> TaskResult<T> ok(T t2) {
        return new TaskResult<T>(TaskStatus.OK, t2, null);
    }

    public static <T> TaskResult<T> timedOut() {
        return new TaskResult<Object>(TaskStatus.TIMED_OUT, null, "Task timed out");
    }

    public String getMessage() {
        return this.message;
    }

    public TaskStatus getTaskStatus() {
        return this.taskStatus;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isOk() {
        return this.getTaskStatus() == TaskStatus.OK;
    }
}

