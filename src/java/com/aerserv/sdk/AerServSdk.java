/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  java.lang.ClassCastException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 */
package com.aerserv.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import com.aerserv.sdk.AerServSettings;

public class AerServSdk {
    private static final String GDPR_HAS_CONSENT_KEY = "GDPRConsent";
    private static final String GDPR_VERSION_KEY = "GDPRVersion";
    private static final String LOG_TAG = "AerServSdk";
    private static final String SHARED_PREFERENCE_KEY = "AerServ";

    public static boolean getGdprConsentFlag(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_KEY, 0);
        try {
            boolean bl = sharedPreferences.getBoolean(GDPR_HAS_CONSENT_KEY, false);
            return bl;
        }
        catch (ClassCastException classCastException) {
            return false;
        }
    }

    public static void init(final Activity activity, final String string) {
        if (!AerServSettings.isInitDone()) {
            new Thread(new Runnable(){

                public void run() {
                    AerServSettings.init(activity, string, null);
                }
            }).start();
        }
    }

    public static void setGdprConsentFlag(Context context, boolean bl) {
        context.getApplicationContext().getSharedPreferences(SHARED_PREFERENCE_KEY, 0).edit().clear().putBoolean(GDPR_HAS_CONSENT_KEY, bl).apply();
    }

}

