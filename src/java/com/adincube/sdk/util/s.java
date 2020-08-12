/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.os.Bundle
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.adincube.sdk.util.a;

public final class s {
    private static Integer a;

    public static String a(Context context) {
        Integer n2 = s.b(context);
        if (n2 != null) {
            return n2.toString();
        }
        return null;
    }

    public static Integer b(Context context) {
        if (a == null) {
            a = s.c(context);
        }
        return a;
    }

    private static Integer c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null && applicationInfo.metaData.containsKey("com.google.android.gms.version")) {
                Integer n2 = applicationInfo.metaData.getInt("com.google.android.gms.version");
                return n2;
            }
        }
        catch (Throwable throwable) {
            a.c("PlayServicesHelper.doGetGooglePlayServicesVersion", new Object[]{throwable});
        }
        return null;
    }
}

