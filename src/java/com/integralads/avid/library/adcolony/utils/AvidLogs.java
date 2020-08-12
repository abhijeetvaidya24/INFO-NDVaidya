/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.integralads.avid.library.adcolony.utils;

import android.text.TextUtils;
import android.util.Log;

public class AvidLogs {
    public static void e(String string) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            Log.e((String)"AVID", (String)string);
        }
    }

    public static void e(String string, Exception exception) {
        if (!TextUtils.isEmpty((CharSequence)string) || exception != null) {
            Log.e((String)"AVID", (String)string, (Throwable)exception);
        }
    }
}

