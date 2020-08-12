/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.base.b;

import android.annotation.SuppressLint;
import android.content.Context;

public final class e {
    @SuppressLint(value={"StaticFieldLeak"})
    private static Context fp;

    private e() {
    }

    public static Context getContext() {
        return fp;
    }

    public static String getPackageName() {
        return fp.getPackageName();
    }

    public static void init(Context context) {
        if (context != null) {
            fp = context.getApplicationContext();
            return;
        }
        throw new IllegalArgumentException("context shouldn't be null");
    }
}

