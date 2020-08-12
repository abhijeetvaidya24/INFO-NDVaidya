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
package com.appsgeyser.multiTabApp.controllers;

import android.content.Context;
import android.content.SharedPreferences;

public class FirstLaunchController {
    private final SharedPreferences preferences;

    public FirstLaunchController(Context context) {
        this.preferences = context.getSharedPreferences("com.appsgeyser.multiTabApp.controllers.FirstLaunchController", 0);
    }

    public boolean isFirstLaunch() {
        return this.preferences.getBoolean("com.appsgeyser.multiTabApp.controllers.FirstLaunchController.isFirstLaunch", true);
    }

    public void wasTheFirstLaunch() {
        SharedPreferences.Editor editor = this.preferences.edit();
        editor.putBoolean("com.appsgeyser.multiTabApp.controllers.FirstLaunchController.isFirstLaunch", false);
        editor.apply();
    }
}

