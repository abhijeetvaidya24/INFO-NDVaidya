/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.ironsource.mediationsdk.logger;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.LogListener;

public class PublisherLogger
extends IronSourceLogger {
    private LogListener mLogListener;

    private PublisherLogger() {
        super("publisher");
    }

    public PublisherLogger(LogListener logListener, int n2) {
        super("publisher", n2);
        this.mLogListener = logListener;
    }

    @Override
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String string, int n2) {
        PublisherLogger publisherLogger = this;
        synchronized (publisherLogger) {
            if (this.mLogListener != null && string != null) {
                this.mLogListener.onLog(ironSourceTag, string, n2);
            }
            return;
        }
    }

    @Override
    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String string, Throwable throwable) {
        if (throwable != null) {
            this.log(ironSourceTag, throwable.getMessage(), 3);
        }
    }

    public void setLogListener(LogListener logListener) {
        this.mLogListener = logListener;
    }
}

