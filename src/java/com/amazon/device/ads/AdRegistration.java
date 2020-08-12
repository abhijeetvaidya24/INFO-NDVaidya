/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AdRegistrationExecutor;

public class AdRegistration {
    private static final String LOGTAG = "AdRegistration";
    private static final AdRegistrationExecutor amazonAdRegistration = new AdRegistrationExecutor(LOGTAG);

    private AdRegistration() {
    }

    public static final void enableLogging(boolean bl) {
        amazonAdRegistration.enableLogging(bl);
    }

    public static final void enableTesting(boolean bl) {
        amazonAdRegistration.enableTesting(bl);
    }

    static AdRegistrationExecutor getAmazonAdRegistrationExecutor() {
        return amazonAdRegistration;
    }

    public static final String getVersion() {
        return amazonAdRegistration.getVersion();
    }

    public static final void registerApp(Context context) {
        amazonAdRegistration.registerApp(context);
    }

    public static final void setAppKey(String string) throws IllegalArgumentException {
        amazonAdRegistration.setAppKey(string);
    }
}

