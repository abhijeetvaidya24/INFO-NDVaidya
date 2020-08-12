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
package com.appsgeyser.sdk.configuration;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesCoder {
    private final SharedPreferences prefsSettings;

    public PreferencesCoder(Context context) {
        this.prefsSettings = context.getSharedPreferences("AppsgeyserPrefs", 0);
    }

    public boolean getPrefBoolean(String string2, boolean bl) {
        return this.prefsSettings.getBoolean(string2, bl);
    }

    public int getPrefInt(String string2, int n2) {
        return this.prefsSettings.getInt(string2, n2);
    }

    public long getPrefLong(String string2, long l2) {
        return this.prefsSettings.getLong(string2, l2);
    }

    public String getPrefString(String string2, String string3) {
        return this.prefsSettings.getString(string2, string3);
    }

    public void savePrefBoolean(String string2, boolean bl) {
        SharedPreferences.Editor editor = this.prefsSettings.edit();
        editor.putBoolean(string2, bl);
        editor.commit();
    }

    public void savePrefInt(String string2, int n2) {
        SharedPreferences.Editor editor = this.prefsSettings.edit();
        editor.putInt(string2, n2);
        editor.commit();
    }

    public void savePrefLong(String string2, long l2) {
        SharedPreferences.Editor editor = this.prefsSettings.edit();
        editor.putLong(string2, l2);
        editor.commit();
    }

    public void savePrefString(String string2, String string3) {
        SharedPreferences.Editor editor = this.prefsSettings.edit();
        editor.putString(string2, string3);
        editor.commit();
    }
}

