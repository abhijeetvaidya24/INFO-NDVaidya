/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 */
package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

public class ThreadExceptionHandler
implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable throwable) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Thread name =");
        stringBuilder.append(thread.getName());
        ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), throwable);
    }
}

