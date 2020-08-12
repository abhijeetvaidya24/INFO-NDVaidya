/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Process
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.Display
 *  android.view.WindowManager
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.j;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Process;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

public class c {
    private static float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    static int a(int n2, int n3) {
        if (1 == n3) {
            if (n2 != 1 && n2 != 2) {
                return 1;
            }
            return 9;
        }
        if (2 == n3) {
            if (n2 != 2 && n2 != 3) {
                return 0;
            }
            return 8;
        }
        return 9;
    }

    public static int a(Activity activity) {
        return c.a(activity.getWindowManager().getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
    }

    public static int a(Context context, float f2) {
        return (int)(0.5f + TypedValue.applyDimension((int)1, (float)f2, (DisplayMetrics)context.getResources().getDisplayMetrics()));
    }

    public static boolean a(Context context, String string2) {
        return context.checkPermission(string2, Process.myPid(), Process.myUid()) == 0;
    }

    public static int b(Context context, float f2) {
        return (int)(0.5f + f2 / c.a(context));
    }
}

