/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.sdk.utils;

import android.util.Log;
import com.ironsource.sdk.data.SSAEnums;

public class Logger {
    private static boolean enableLogging;

    public static void d(String string, String string2) {
        if (enableLogging) {
            Log.d((String)string, (String)string2);
        }
    }

    public static void e(String string, String string2) {
        if (enableLogging) {
            Log.e((String)string, (String)string2);
        }
    }

    public static void enableLogging(int n2) {
        if (SSAEnums.DebugMode.MODE_0.getValue() == n2) {
            enableLogging = false;
            return;
        }
        enableLogging = true;
    }

    public static void i(String string, String string2) {
        if (enableLogging) {
            Log.i((String)string, (String)string2);
        }
    }
}

