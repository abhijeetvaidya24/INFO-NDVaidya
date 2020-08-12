/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.ironsource.mediationsdk.logger;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

public class ConsoleLogger
extends IronSourceLogger {
    private ConsoleLogger() {
        super("console");
    }

    public ConsoleLogger(int n2) {
        super("console", n2);
    }

    @Override
    public void log(IronSourceLogger.IronSourceTag ironSourceTag, String string, int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("");
                    stringBuilder.append((Object)ironSourceTag);
                    Log.e((String)stringBuilder.toString(), (String)string);
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("");
                stringBuilder.append((Object)ironSourceTag);
                Log.w((String)stringBuilder.toString(), (String)string);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append((Object)ironSourceTag);
            Log.i((String)stringBuilder.toString(), (String)string);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append((Object)ironSourceTag);
        Log.v((String)stringBuilder.toString(), (String)string);
    }

    @Override
    public void logException(IronSourceLogger.IronSourceTag ironSourceTag, String string, Throwable throwable) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(":stacktrace[");
        stringBuilder.append(Log.getStackTraceString((Throwable)throwable));
        stringBuilder.append("]");
        this.log(ironSourceTag, stringBuilder.toString(), 3);
    }
}

