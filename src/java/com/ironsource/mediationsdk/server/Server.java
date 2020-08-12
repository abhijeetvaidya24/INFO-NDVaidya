/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.lang.Thread$UncaughtExceptionHandler
 *  java.lang.Throwable
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.server;

import android.util.Log;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.ThreadExceptionHandler;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import org.json.JSONObject;

public class Server {
    public static void callAsyncRequestURL(final String string, final boolean bl2, final int n2) {
        Thread thread = new Thread(new Runnable(){

            public void run() {
                Server.callRequestURL(string, bl2, n2);
            }
        }, "callAsyncRequestURL");
        thread.setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)new ThreadExceptionHandler());
        thread.start();
    }

    private static void callRequestURL(String string, boolean bl2, int n2) {
        try {
            new JSONObject(HttpFunctions.getStringFromURL(ServerURL.getRequestURL(string, bl2, n2)));
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NETWORK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("callRequestURL(reqUrl:");
            stringBuilder.append(string);
            stringBuilder.append(", ");
            stringBuilder.append("hit:");
            stringBuilder.append(bl2);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            return;
        }
        catch (Throwable throwable) {
            StringBuilder stringBuilder = new StringBuilder("callRequestURL(reqUrl:");
            if (string == null) {
                stringBuilder.append("null");
            } else {
                stringBuilder.append(string);
            }
            stringBuilder.append(", hit:");
            stringBuilder.append(bl2);
            stringBuilder.append(")");
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NETWORK;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append(", e:");
            stringBuilder2.append(Log.getStackTraceString((Throwable)throwable));
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder2.toString(), 0);
            return;
        }
    }

}

