/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  java.lang.Object
 */
package com.integralads.avid.library.adcolony.utils;

import android.os.Build;
import android.view.View;

public class AvidViewUtil {
    public static boolean isViewVisible(View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            double d2 = (double)view.getAlpha() DCMPL 0.0;
            boolean bl2 = false;
            if (d2 > 0) {
                bl2 = true;
            }
            return bl2;
        }
        return true;
    }
}

