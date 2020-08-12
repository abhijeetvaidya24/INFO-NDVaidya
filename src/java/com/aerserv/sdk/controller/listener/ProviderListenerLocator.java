/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 */
package com.aerserv.sdk.controller.listener;

import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.utils.AerServLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProviderListenerLocator {
    private static final String LOG_TAG = "ProviderListenerLocator";
    private static final Map<String, ProviderListener> listeners = new ConcurrentHashMap();
    private static final Object lock = new Object();

    private ProviderListenerLocator() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ProviderListener getProviderListener(String string) {
        Object object;
        if (string == null) {
            return null;
        }
        Object object2 = object = lock;
        synchronized (object2) {
            if (!listeners.containsKey((Object)string)) {
                AerServLog.d(LOG_TAG, "Cannot find listenerId in listeners to get listener.");
                return null;
            }
            String string2 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Getting provider listener with ID ");
            stringBuilder.append(string);
            AerServLog.d(string2, stringBuilder.toString());
            String string3 = LOG_TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Getting provider listener with ID ");
            stringBuilder2.append(string);
            stringBuilder2.append(" with stack trace ");
            stringBuilder2.append(ProviderListenerLocator.stackTrace());
            AerServLog.v(string3, stringBuilder2.toString());
            return (ProviderListener)listeners.get((Object)string);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void register(String string, ProviderListener providerListener) {
        Object object;
        if (string == null) {
            AerServLog.d(LOG_TAG, "Cannot register listener because listenerId is null");
            return;
        }
        if (providerListener == null) {
            AerServLog.d(LOG_TAG, "Cannot register listener because listener is null");
            return;
        }
        Object object2 = object = lock;
        synchronized (object2) {
            String string2 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Registering provider listener with ID ");
            stringBuilder.append(string);
            AerServLog.d(string2, stringBuilder.toString());
            String string3 = LOG_TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Registering provider listener with ID ");
            stringBuilder2.append(string);
            stringBuilder2.append(" with stack trace ");
            stringBuilder2.append(ProviderListenerLocator.stackTrace());
            AerServLog.v(string3, stringBuilder2.toString());
            listeners.put((Object)string, (Object)providerListener);
            return;
        }
    }

    private static String stackTrace() {
        Exception exception = new Exception();
        StringBuilder stringBuilder = new StringBuilder("stacktrace(");
        StackTraceElement[] arrstackTraceElement = exception.getStackTrace();
        for (int i2 = 2; i2 < arrstackTraceElement.length; ++i2) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(arrstackTraceElement[i2].getClassName());
            stringBuilder2.append(".");
            stringBuilder2.append(arrstackTraceElement[i2].getMethodName());
            stringBuilder2.append(" ");
            stringBuilder2.append(arrstackTraceElement[i2].getFileName());
            stringBuilder2.append(" <");
            stringBuilder2.append(arrstackTraceElement[i2].getLineNumber());
            stringBuilder2.append(">,");
            stringBuilder.append(stringBuilder2.toString());
        }
        stringBuilder.deleteCharAt(-1 + stringBuilder.length());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append(")");
        return stringBuilder3.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void unregister(String string) {
        Object object;
        if (string == null) {
            AerServLog.d(LOG_TAG, "Cannot unregister listener because listenerId is null");
            return;
        }
        Object object2 = object = lock;
        synchronized (object2) {
            String string2 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unregistering provider listener with ID ");
            stringBuilder.append(string);
            AerServLog.d(string2, stringBuilder.toString());
            String string3 = LOG_TAG;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unregistering provider listener with ID ");
            stringBuilder2.append(string);
            stringBuilder2.append(" with stack trace ");
            stringBuilder2.append(ProviderListenerLocator.stackTrace());
            AerServLog.v(string3, stringBuilder2.toString());
            listeners.remove((Object)string);
            return;
        }
    }
}

