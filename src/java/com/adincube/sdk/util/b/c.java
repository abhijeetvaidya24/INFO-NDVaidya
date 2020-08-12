/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Display
 *  android.view.WindowManager
 *  com.adincube.sdk.h.d
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.util.b;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.adincube.sdk.h.d;

public final class c {
    public static boolean a(Context context) {
        int n2 = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (n2 != 0 && n2 != 1) {
            return n2 == 2 || n2 == 3;
        }
        return false;
    }

}

