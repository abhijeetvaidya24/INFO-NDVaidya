/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.chartboost.sdk.Libraries;

import android.util.Log;

public final class CBLogging {
    public static Level a = Level.INTEGRATION;

    public static void a(String string2, String string3) {
        if (a == Level.ALL) {
            Log.d((String)string2, (String)string3);
        }
    }

    public static void a(String string2, String string3, Throwable throwable) {
        if (a == Level.ALL) {
            Log.e((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void b(String string2, String string3) {
        if (a == Level.ALL) {
            Log.e((String)string2, (String)string3);
        }
    }

    public static void b(String string2, String string3, Throwable throwable) {
        if (a == Level.ALL) {
            Log.v((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void c(String string2, String string3) {
        if (a == Level.ALL) {
            Log.v((String)string2, (String)string3);
        }
    }

    public static void c(String string2, String string3, Throwable throwable) {
        if (a == Level.ALL) {
            Log.w((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public static void d(String string2, String string3) {
        if (a == Level.ALL) {
            Log.w((String)string2, (String)string3);
        }
    }

    public static void e(String string2, String string3) {
        if (a == Level.ALL) {
            Log.i((String)string2, (String)string3);
        }
    }

    public static final class Level
    extends Enum<Level> {
        public static final /* enum */ Level ALL;
        public static final /* enum */ Level INTEGRATION;
        public static final /* enum */ Level NONE;
        private static final /* synthetic */ Level[] a;

        static {
            NONE = new Level();
            INTEGRATION = new Level();
            ALL = new Level();
            Level[] arrlevel = new Level[]{NONE, INTEGRATION, ALL};
            a = arrlevel;
        }

        public static Level valueOf(String string2) {
            return (Level)Enum.valueOf(Level.class, (String)string2);
        }

        public static Level[] values() {
            return (Level[])a.clone();
        }
    }

}

