/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony;

import android.content.Context;

public class AvidContext {
    private static final AvidContext a = new AvidContext();
    private String b;

    public static AvidContext getInstance() {
        return a;
    }

    public String getAvidVersion() {
        return "3.6.7";
    }

    public String getBundleId() {
        return this.b;
    }

    public String getPartnerName() {
        return "adcolony";
    }

    public void init(Context context) {
        if (this.b == null) {
            this.b = context.getApplicationContext().getPackageName();
        }
    }
}

