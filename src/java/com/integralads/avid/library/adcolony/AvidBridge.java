/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony;

import android.text.TextUtils;

public class AvidBridge {
    private static String a;

    public static String getAvidJs() {
        return a;
    }

    public static boolean isAvidJsReady() {
        return true ^ TextUtils.isEmpty((CharSequence)a);
    }

    public static void setAvidJs(String string) {
        a = string;
    }
}

