/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.util.Log
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.logging.Filter
 *  java.util.logging.Handler
 *  java.util.logging.Level
 *  java.util.logging.LogManager
 *  java.util.logging.LogRecord
 *  java.util.logging.Logger
 */
package com.tappx.a.a.b;

import android.annotation.SuppressLint;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Filter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class aa {
    public static final String a = "com.tappx.mraid";
    private static final boolean b = true;
    private static final String c = "TappxMraid";
    private static final Logger d = Logger.getLogger((String)"com.tappx.mraid");
    private static final a e = new a();

    static {
        d.setUseParentHandlers(false);
        d.setLevel(Level.ALL);
        e.setLevel(Level.FINE);
        e.setFilter(new Filter(){

            public boolean isLoggable(LogRecord logRecord) {
                return true;
            }
        });
        LogManager.getLogManager().addLogger(d);
        aa.a(d, e);
    }

    private aa() {
    }

    public static void a(String string2) {
        aa.a(string2, null);
    }

    public static void a(String string2, Throwable throwable) {
        d.log(Level.FINEST, string2, throwable);
    }

    private static void a(Logger logger, Handler handler) {
        Handler[] arrhandler = logger.getHandlers();
        int n2 = arrhandler.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (!arrhandler[i2].equals((Object)handler)) continue;
            return;
        }
        logger.addHandler(handler);
    }

    public static void b(String string2) {
        aa.b(string2, null);
    }

    public static void b(String string2, Throwable throwable) {
        d.log(Level.FINE, string2, throwable);
    }

    public static void c(String string2) {
        aa.c(string2, null);
    }

    public static void c(String string2, Throwable throwable) {
        d.log(Level.CONFIG, string2, throwable);
    }

    public static void d(String string2) {
        aa.d(string2, null);
    }

    public static void d(String string2, Throwable throwable) {
        d.log(Level.INFO, string2, throwable);
    }

    public static void e(String string2) {
        aa.e(string2, null);
    }

    public static void e(String string2, Throwable throwable) {
        d.log(Level.WARNING, string2, throwable);
    }

    public static void f(String string2) {
        aa.f(string2, null);
    }

    public static void f(String string2, Throwable throwable) {
        d.log(Level.SEVERE, string2, throwable);
    }

    private static final class a
    extends Handler {
        private static final Map<Level, Integer> a = new HashMap(7);

        static {
            Map<Level, Integer> map = a;
            Level level = Level.FINEST;
            Integer n2 = 2;
            map.put((Object)level, (Object)n2);
            a.put((Object)Level.FINER, (Object)n2);
            a.put((Object)Level.FINE, (Object)n2);
            a.put((Object)Level.CONFIG, (Object)3);
            a.put((Object)Level.INFO, (Object)4);
            a.put((Object)Level.WARNING, (Object)5);
            a.put((Object)Level.SEVERE, (Object)6);
        }

        private a() {
        }

        public void close() {
        }

        public void flush() {
        }

        @SuppressLint(value={"LogTagMismatch"})
        public void publish(LogRecord logRecord) {
            if (this.isLoggable(logRecord)) {
                int n2 = a.containsKey((Object)logRecord.getLevel()) ? (Integer)a.get((Object)logRecord.getLevel()) : 2;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(logRecord.getMessage());
                stringBuilder.append("\n");
                String string2 = stringBuilder.toString();
                Throwable throwable = logRecord.getThrown();
                if (throwable != null) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(string2);
                    stringBuilder2.append(Log.getStackTraceString((Throwable)throwable));
                    string2 = stringBuilder2.toString();
                }
                Log.println((int)n2, (String)aa.c, (String)string2);
            }
        }
    }

}

