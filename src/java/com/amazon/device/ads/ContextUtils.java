/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  java.lang.Object
 */
package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;

class ContextUtils {
    ContextUtils() {
    }

    public static Activity getContextAsActivity(Context context) {
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity)context;
            }
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }
}

