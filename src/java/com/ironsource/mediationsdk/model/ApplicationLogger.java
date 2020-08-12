/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.model;

public class ApplicationLogger {
    private int mConsole;
    private int mPublisher;
    private int mServer;

    public ApplicationLogger() {
    }

    public ApplicationLogger(int n2, int n3, int n4) {
        this.mServer = n2;
        this.mPublisher = n3;
        this.mConsole = n4;
    }

    public int getConsoleLoggerLevel() {
        return this.mConsole;
    }

    public int getPublisherLoggerLevel() {
        return this.mPublisher;
    }
}

