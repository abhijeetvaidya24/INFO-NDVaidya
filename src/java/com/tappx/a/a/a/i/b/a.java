/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.preference.PreferenceManager
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.i.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

class a {
    private static SharedPreferences a(Context context) {
        return PreferenceManager.getDefaultSharedPreferences((Context)context);
    }

    public static String a(Context context, String string2, String string3) {
        return a.a(context).getString(string2, string3).trim();
    }

    public static void b(Context context, String string2, String string3) {
        SharedPreferences.Editor editor = a.a(context).edit();
        editor.putString(string2, string3);
        editor.apply();
    }
}

