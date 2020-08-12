/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.utils.task;

public final class TaskStatus
extends Enum<TaskStatus> {
    private static final /* synthetic */ TaskStatus[] $VALUES;
    public static final /* enum */ TaskStatus CANCELED;
    public static final /* enum */ TaskStatus ERROR;
    public static final /* enum */ TaskStatus FAILED;
    public static final /* enum */ TaskStatus OK;
    public static final /* enum */ TaskStatus TIMED_OUT;

    static {
        OK = new TaskStatus();
        FAILED = new TaskStatus();
        TIMED_OUT = new TaskStatus();
        CANCELED = new TaskStatus();
        ERROR = new TaskStatus();
        TaskStatus[] arrtaskStatus = new TaskStatus[]{OK, FAILED, TIMED_OUT, CANCELED, ERROR};
        $VALUES = arrtaskStatus;
    }

    public static TaskStatus valueOf(String string) {
        return (TaskStatus)Enum.valueOf(TaskStatus.class, (String)string);
    }

    public static TaskStatus[] values() {
        return (TaskStatus[])$VALUES.clone();
    }
}

