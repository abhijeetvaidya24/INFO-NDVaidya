/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.telephony.TelephonyManager
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.utils;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class DeviceInfo {
    public static Point getScreenSize(Context context) {
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
            return point;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new Point(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    public static boolean isPhone(Context context) {
        return ((TelephonyManager)context.getSystemService("phone")).getPhoneType() != 0;
    }
}

