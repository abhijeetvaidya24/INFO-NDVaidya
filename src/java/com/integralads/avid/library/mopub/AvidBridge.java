/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub;

import android.text.TextUtils;

public class AvidBridge {
    public static final String APP_STATE_ACTIVE = "active";
    public static final String APP_STATE_INACTIVE = "inactive";
    private static String avidJS;

    public static void cleanUpAvidJS() {
        avidJS = null;
    }

    public static String getAvidJs() {
        return avidJS;
    }

    public static boolean isAvidJsReady() {
        return true ^ TextUtils.isEmpty((CharSequence)avidJS);
    }

    public static void setAvidJs(String string) {
        avidJS = string;
    }
}

