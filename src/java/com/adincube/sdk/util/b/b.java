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
package com.adincube.sdk.util.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public final class b {
    public static int a(Context context) {
        try {
            int n2 = b.c((Context)context).versionCode;
            return n2;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return 0;
        }
    }

    public static String b(Context context) {
        try {
            String string = b.c((Context)context).versionName;
            return string;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return null;
        }
    }

    private static PackageInfo c(Context context) {
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
    }
}

