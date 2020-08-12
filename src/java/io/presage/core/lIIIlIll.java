/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings
 *  android.provider.Settings$Global
 *  android.provider.Settings$Secure
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import io.presage.core.lIIIlIIl;

public final class lIIIlIll {
    public static boolean IIIIIIII(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            if (lIIIlIIl.IIIIIIII(context, "android.permission.REQUEST_INSTALL_PACKAGES")) {
                return context.getPackageManager().canRequestPackageInstalls();
            }
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return Settings.Secure.getInt((ContentResolver)context.getContentResolver(), (String)"install_non_market_apps", (int)0) == 1;
        }
        if (Build.VERSION.SDK_INT >= 17) {
            return Settings.Global.getInt((ContentResolver)context.getContentResolver(), (String)"install_non_market_apps", (int)0) == 1;
        }
        return Settings.Secure.getInt((ContentResolver)context.getContentResolver(), (String)"install_non_market_apps", (int)0) == 1;
    }
}

