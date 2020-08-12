/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 *  java.lang.Object
 */
package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.sdk.g;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinPrivacySettings {
    public static boolean hasUserConsent(Context context) {
        Boolean bl = g.a(context);
        if (bl != null) {
            return bl;
        }
        return false;
    }

    public static boolean isAgeRestrictedUser(Context context) {
        Boolean bl = g.b(context);
        if (bl != null) {
            return bl;
        }
        return false;
    }

    public static void setHasUserConsent(boolean bl, Context context) {
        if (g.a(bl, context)) {
            AppLovinSdk.reinitializeAll(bl);
        }
    }

    public static void setIsAgeRestrictedUser(boolean bl, Context context) {
        if (g.b(bl, context)) {
            AppLovinSdk.reinitializeAll();
        }
    }
}

