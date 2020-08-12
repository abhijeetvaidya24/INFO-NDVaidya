/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.ResolveInfo
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.os.StrictMode$ThreadPolicy$Builder
 *  android.view.Display
 *  android.view.WindowManager
 *  com.applovin.adview.AppLovinInterstitialActivity
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.applovin.impl.sdk.e;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.os.Build;
import android.os.StrictMode;
import android.view.Display;
import android.view.WindowManager;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.impl.sdk.e.m;

public class e {
    public static Point a(Context context) {
        Point point;
        point = new Point();
        point.x = 480;
        point.y = 320;
        try {
            ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getSize(point);
        }
        catch (Throwable throwable) {}
        return point;
    }

    public static void a() {
        try {
            StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)new StrictMode.ThreadPolicy.Builder().permitAll().build());
        }
        catch (Throwable throwable) {}
    }

    public static boolean a(Class<?> class_, Context context) {
        Intent intent = new Intent(context, class_);
        ResolveInfo resolveInfo = context.getPackageManager().resolveActivity(intent, 0);
        boolean bl = false;
        if (resolveInfo != null) {
            bl = true;
        }
        return bl;
    }

    public static boolean a(String string2, Context context) {
        return context.checkCallingOrSelfPermission(string2) == 0;
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 14;
    }

    public static boolean b(Context context) {
        try {
            ComponentName componentName = new ComponentName(context, AppLovinInterstitialActivity.class.getCanonicalName());
            boolean bl = m.a(context.getPackageManager().getActivityInfo((ComponentName)componentName, (int)0).configChanges, 1024L);
            return bl;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static boolean c(Context context) {
        try {
            ComponentName componentName = new ComponentName(context, AppLovinInterstitialActivity.class.getCanonicalName());
            boolean bl = m.a(context.getPackageManager().getActivityInfo((ComponentName)componentName, (int)0).configChanges, 128L);
            return bl;
        }
        catch (Throwable throwable) {
            return false;
        }
    }

    public static boolean d() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 19;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean h() {
        return Build.VERSION.SDK_INT >= 24;
    }
}

