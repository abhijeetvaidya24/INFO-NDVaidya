/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.PowerManager
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.util;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

public final class t {
    public static boolean a(Context context) {
        PowerManager powerManager = (PowerManager)context.getSystemService("power");
        if (Build.VERSION.SDK_INT >= 21) {
            return powerManager.isInteractive();
        }
        return powerManager.isScreenOn();
    }
}

