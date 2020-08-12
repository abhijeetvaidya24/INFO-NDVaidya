/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Object
 */
package com.tapjoy.internal;

import android.app.Activity;

public abstract class fw {
    protected static fw a;

    public static void b(Activity activity) {
        fw fw2 = a;
        if (fw2 != null) {
            fw2.a(activity);
        }
    }

    public abstract void a(Activity var1);
}

