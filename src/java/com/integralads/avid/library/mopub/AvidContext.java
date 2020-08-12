/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub;

import android.content.Context;

public class AvidContext {
    private static final AvidContext instance = new AvidContext();
    private String bundleId;

    public static AvidContext getInstance() {
        return instance;
    }

    public String getAvidReleaseDate() {
        return "13-Jun-17";
    }

    public String getAvidVersion() {
        return "3.6.4";
    }

    public String getBundleId() {
        return this.bundleId;
    }

    public String getPartnerName() {
        return "mopub";
    }

    public void init(Context context) {
        if (this.bundleId == null) {
            this.bundleId = context.getApplicationContext().getPackageName();
        }
    }
}

