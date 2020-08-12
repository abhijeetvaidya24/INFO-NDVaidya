/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 */
package com.aerserv.sdk.utils;

import android.os.Build;

public class VersionUtils {
    public static boolean checkVersion(int n2) {
        return Build.VERSION.SDK_INT >= n2;
    }
}

