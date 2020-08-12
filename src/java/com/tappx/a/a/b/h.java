/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.Display
 *  android.view.WindowManager
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.tappx.a.a.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.tappx.a.a.b.a;
import com.tappx.a.a.b.aa;
import java.util.List;

public class h {
    public static float a(float f2, Context context) {
        return f2 / h.a(context);
    }

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
        aa.c("Unknown screen orientation. Defaulting to portrait.");
        return 9;
    }

    public static void a(Activity activity, a a2) {
        block6 : {
            int n2;
            block5 : {
                int n3;
                block4 : {
                    n3 = h.a(((WindowManager)activity.getSystemService("window")).getDefaultDisplay().getRotation(), activity.getResources().getConfiguration().orientation);
                    a a3 = a.b;
                    n2 = 8;
                    if (a2 != a3) break block4;
                    n2 = 9 == n3 ? 9 : 1;
                    break block5;
                }
                if (a2 != a.c) break block6;
                if (n2 != n3) {
                    n2 = 0;
                }
            }
            activity.setRequestedOrientation(n2);
        }
    }

    public static boolean a(Context context, Intent intent) {
        boolean bl;
        try {
            bl = context.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
        }
        catch (NullPointerException nullPointerException) {
            return false;
        }
        return bl ^ true;
    }

    public static int b(float f2, Context context) {
        return (int)(0.5f + h.a(f2, context));
    }

    public static float c(float f2, Context context) {
        return f2 * h.a(context);
    }

    public static int d(float f2, Context context) {
        return (int)(0.5f + h.c(f2, context));
    }

    public static float e(float f2, Context context) {
        return TypedValue.applyDimension((int)1, (float)f2, (DisplayMetrics)context.getResources().getDisplayMetrics());
    }

    public static int f(float f2, Context context) {
        return (int)(0.5f + h.e(f2, context));
    }
}

