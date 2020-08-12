/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.HashSet
 *  java.util.Set
 *  java.util.logging.Handler
 *  java.util.logging.Level
 *  java.util.logging.LogManager
 *  java.util.logging.LogRecord
 *  java.util.logging.Logger
 */
package com.tappx.a.a.a.c;

import android.util.Log;
import com.tappx.a.a.a.h;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class a {
    private static final String a = "com.tappx";
    private static final String b = "tappx_v3.1.2";
    private static final Logger c = Logger.getLogger((String)"com.tappx");
    private static final b d = new b();
    private static final String e = "Tappx Error: ";
    private static boolean f;
    private static long g;
    private static Set<a> h;
    private static h i;

    static {
        c.setLevel(Level.ALL);
        c.addHandler((Handler)d);
        LogManager.getLogManager().addLogger(c);
        f = false;
    }

    public static void a() {
        g = System.currentTimeMillis();
    }

    public static void a(a a2) {
        Set<a> set = h;
        if (set != null) {
            set.remove((Object)a2);
        }
    }

    public static void a(String string2) {
        if (string2 == null) {
            i = null;
            return;
        }
        i = new h(string2);
    }

    public static /* varargs */ void a(String string2, Object ... arrobject) {
        a.a(Level.FINE, string2, arrobject);
    }

    private static /* varargs */ void a(Level level, String string2, Object ... arrobject) {
        try {
            c.log(level, String.format((String)string2, (Object[])arrobject));
        }
        catch (Exception exception) {}
    }

    public static void a(boolean bl2) {
        f = bl2;
    }

    public static void b(a a2) {
        if (h == null) {
            h = new HashSet();
        }
        h.add((Object)a2);
    }

    public static /* varargs */ void b(String string2, Object ... arrobject) {
        Level level = Level.SEVERE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(e);
        stringBuilder.append(string2);
        a.a(level, stringBuilder.toString(), arrobject);
    }

    public static /* varargs */ void c(String string2, Object ... arrobject) {
        a.a(Level.WARNING, string2, arrobject);
    }

    public static /* varargs */ void d(String string2, Object ... arrobject) {
        if (f) {
            long l2 = System.currentTimeMillis() - g;
            g = System.currentTimeMillis();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("(+");
            stringBuilder.append(l2);
            stringBuilder.append(" ms) ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            a.f(string2, arrobject);
        }
        try {
            String string3 = String.format((String)string2, (Object[])arrobject);
            a.a(Level.FINE, string3, new Object[0]);
        }
        catch (Exception exception) {}
    }

    public static /* varargs */ void e(String string2, Object ... arrobject) {
        h h2 = i;
        if (h2 == null) {
            return;
        }
        a.d(h2.c(string2), arrobject);
    }

    private static void f(String string2, Object[] arrobject) {
        Set<a> set = h;
        if (set == null) {
            return;
        }
        for (a a2 : set) {
            if (a2 == null) continue;
            a2.a(String.format((String)string2, (Object[])arrobject));
        }
    }

    public static interface a {
        public void a(String var1);
    }

    private static final class b
    extends Handler {
        private b() {
        }

        public void close() {
        }

        public void flush() {
        }

        public void publish(LogRecord logRecord) {
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
            Log.println((int)2, (String)a.b, (String)string2);
        }
    }

}

