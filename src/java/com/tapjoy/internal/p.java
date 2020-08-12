/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.SharedPreferences;

public final class p {
    public static boolean a(SharedPreferences sharedPreferences, String string2, int n2) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(string2, n2);
        return editor.commit();
    }

    public static boolean a(SharedPreferences sharedPreferences, String string2, String string3) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(string2, string3);
        return editor.commit();
    }

    public static boolean a(SharedPreferences sharedPreferences, String string2, boolean bl2) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(string2, bl2);
        return editor.commit();
    }
}

