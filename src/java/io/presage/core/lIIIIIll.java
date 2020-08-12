/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.KeyguardManager
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.PowerManager
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.WindowManager
 *  io.presage.core.lIIIlIlI
 *  io.presage.core.lIIIlIlI$IIIlIIlI
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package io.presage.core;

import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import io.presage.core.IIIlIIII;
import io.presage.core.lIIIlIlI;

public final class lIIIIIll {
    private static final String IIIIIIII = lIIIlIlI.IIIlIIlI.IIIIIIII;
    private static final String IIIIIIIl = lIIIlIlI.IIIlIIlI.IIIIIIIl;
    private static final String IIIIIIlI = lIIIlIlI.IIIlIIlI.IIIIIIlI;

    public static IIIlIIII IIIIIIII(Context context) {
        String string2 = Build.BRAND;
        String string3 = Build.MANUFACTURER;
        String string4 = Build.MODEL;
        String string5 = Build.VERSION.RELEASE;
        int n2 = Build.VERSION.SDK_INT;
        String string6 = System.getProperty((String)IIIIIIII);
        WindowManager windowManager = (WindowManager)context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        IIIlIIII iIIlIIII = new IIIlIIII(string2, string3, string4, string5, n2, string6, new IIIlIIII.IIIIIIII(displayMetrics.density, Math.min((int)point.x, (int)point.y), Math.max((int)point.x, (int)point.y)), new IIIlIIII.IIIIIIIl(System.getProperty((String)IIIIIIIl), System.getProperty((String)IIIIIIlI)));
        return iIIlIIII;
    }

    public static boolean IIIIIIIl(Context context) {
        return !lIIIIIll.IIIIIIll(context);
    }

    public static boolean IIIIIIlI(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager)context.getSystemService("keyguard");
        if (Build.VERSION.SDK_INT >= 16) {
            return lIIIIIll.IIIIIIll(context) && !keyguardManager.isKeyguardLocked();
        }
        return lIIIIIll.IIIIIIll(context) && !keyguardManager.inKeyguardRestrictedInputMode();
    }

    private static boolean IIIIIIll(Context context) {
        PowerManager powerManager = (PowerManager)context.getSystemService("power");
        if (Build.VERSION.SDK_INT >= 20) {
            return powerManager.isInteractive();
        }
        return powerManager.isScreenOn();
    }
}

