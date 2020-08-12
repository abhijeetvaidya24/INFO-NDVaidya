/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Class
 *  java.lang.Object
 */
package com.adincube.sdk.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;

public final class f {
    private static Activity a;
    private static Context b;

    public static Context a() {
        return b;
    }

    public static void a(Context context) {
        Class<f> class_ = f.class;
        synchronized (f.class) {
            if (context != null) {
                if (context instanceof Activity) {
                    a = (Activity)context;
                }
                if (b == null) {
                    b = context.getApplicationContext();
                }
            }
            return;
        }
    }

    public static boolean a(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return activity.isDestroyed();
        }
        return false;
    }

    public static Activity b() {
        return a;
    }

    public static boolean b(Activity activity) {
        if (activity == null) {
            return false;
        }
        return activity.isFinishing();
    }

    public static boolean c(Activity activity) {
        return f.b(activity) || f.a(activity);
        {
        }
    }
}

