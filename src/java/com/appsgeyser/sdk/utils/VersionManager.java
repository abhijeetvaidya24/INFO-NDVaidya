/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.appsgeyser.sdk.configuration.PreferencesCoder;

public class VersionManager {
    public static int getCurrentVersion(Context context) {
        try {
            int n2 = context.getPackageManager().getPackageInfo((String)context.getPackageName(), (int)0).versionCode;
            return n2;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return -1;
        }
    }

    public static int getPreviousVersion(Context context) {
        return new PreferencesCoder(context).getPrefInt("app_version_prefix", -1);
    }

    public static void updateVersion(Context context, int n2) {
        new PreferencesCoder(context).savePrefInt("app_version_prefix", n2);
    }
}

