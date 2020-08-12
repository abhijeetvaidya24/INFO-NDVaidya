/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.util.e;

import android.content.Context;
import android.content.SharedPreferences;

public final class c {
    public static String a(Context context, String string) {
        return context.getSharedPreferences("AIC-prefs", 0).getString(string, null);
    }

    public static void a(Context context, String string, String string2) {
        SharedPreferences.Editor editor = context.getSharedPreferences("AIC-prefs", 0).edit();
        editor.putString(string, string2);
        editor.apply();
    }

    public static void b(Context context, String string) {
        SharedPreferences.Editor editor = context.getSharedPreferences("AIC-prefs", 0).edit();
        editor.remove(string);
        editor.apply();
    }
}

