/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.content.res.Resources
 *  android.hardware.display.DisplayManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.Display
 *  java.lang.Double
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.util.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;

public final class j {
    public static int a(Context context, int n2) {
        if (n2 <= 0) {
            return n2;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round((float)((float)n2 / displayMetrics.density));
    }

    @SuppressLint(value={"NewApi"})
    public static DisplayMetrics a(Context context) {
        if (Build.VERSION.SDK_INT >= 17) {
            Display display = ((DisplayManager)context.getSystemService("display")).getDisplay(0);
            if (display != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getRealMetrics(displayMetrics);
                return displayMetrics;
            }
            return null;
        }
        return context.getResources().getDisplayMetrics();
    }

    public static double b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        double d2 = displayMetrics.widthPixels;
        double d3 = displayMetrics.density;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        return d2 / d3;
    }

    public static int b(Context context, int n2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return Math.round((float)TypedValue.applyDimension((int)1, (float)n2, (DisplayMetrics)displayMetrics));
    }

    public static double c(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        double d2 = displayMetrics.heightPixels;
        double d3 = displayMetrics.density;
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        return d2 / d3;
    }

    public static float d(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }
}

