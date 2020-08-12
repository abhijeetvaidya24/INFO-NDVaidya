/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class VersionManager {
    public static int getCurrentVersion(Context context) {
        try {
            int n2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode;
            return n2;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            return -1;
        }
    }

    public static int getPreviousVersion(Context context) {
        try {
            int n2 = context.getSharedPreferences("AppsgeyserPrefs", 0).getInt("app_version_prefix", -1);
            return n2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return -1;
        }
    }
}

