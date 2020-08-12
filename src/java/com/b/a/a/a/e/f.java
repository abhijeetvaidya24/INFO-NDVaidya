/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewParent
 *  java.lang.Object
 */
package com.b.a.a.a.e;

import android.os.Build;
import android.view.View;
import android.view.ViewParent;

public final class f {
    public static float a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            return view.getZ();
        }
        return 0.0f;
    }

    public static View b(View view) {
        ViewParent viewParent = view.getParent();
        if (viewParent instanceof View) {
            return (View)viewParent;
        }
        return null;
    }

    public static boolean c(View view) {
        if (Build.VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) {
            return false;
        }
        if (!view.isShown()) {
            return false;
        }
        while (view != null) {
            if (view.getAlpha() == 0.0f) {
                return false;
            }
            view = f.b(view);
        }
        return true;
    }

    public static boolean d(View view) {
        if (Build.VERSION.SDK_INT >= 19 && !view.isAttachedToWindow()) {
            return false;
        }
        if (view.getVisibility() != 0) {
            return false;
        }
        return view.getAlpha() != 0.0f;
    }
}

