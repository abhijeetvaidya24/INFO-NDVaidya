/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.usage.UsageStatsManager
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build;

public final class lIIlIIII {
    public static int IIIIIIII(Context context) {
        UsageStatsManager usageStatsManager;
        if (Build.VERSION.SDK_INT >= 21 && (usageStatsManager = (UsageStatsManager)context.getSystemService("usagestats")) != null && Build.VERSION.SDK_INT >= 28) {
            return usageStatsManager.getAppStandbyBucket();
        }
        return 0;
    }
}

