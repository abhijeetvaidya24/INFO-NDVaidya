/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.sdk;

import android.util.Log;

public class Logger {
    public static void DebugLog(String string2) {
        Log.d((String)"*** AppsgeyserSDK Debug", (String)string2);
    }

    static void ErrorLog(String string2) {
        Log.e((String)"AppsgeyserSDK", (String)string2);
    }
}

