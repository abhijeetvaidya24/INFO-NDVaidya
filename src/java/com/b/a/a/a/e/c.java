/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.b.a.a.a.e;

import android.util.Log;

public final class c {
    public static void a(String string2) {
    }

    public static void a(String string2, Exception exception) {
        if (exception != null) {
            Log.e((String)"OMIDLIB", (String)string2, (Throwable)exception);
        }
    }
}

