/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.mediation.d.h
 *  java.lang.Boolean
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.d;

import android.content.Context;
import com.adincube.sdk.mediation.d.h;
import com.aerserv.sdk.AerServConfig;

public final class b {
    private h a;
    private com.adincube.sdk.h.c.b b;

    public b(h h2, com.adincube.sdk.h.c.b b2) {
        this.a = h2;
        this.b = b2;
    }

    public final AerServConfig a(Context context) {
        AerServConfig aerServConfig = new AerServConfig(context, this.a.e);
        aerServConfig.setPrecache(true);
        aerServConfig.setPreload(true);
        aerServConfig.setRefreshInterval(0);
        if (this.a.f != null) {
            aerServConfig.enableBackButton(this.a.f);
        }
        if (this.a.g != null) {
            aerServConfig.setBackButtonTimeout(this.a.g);
        }
        if (this.a.h != null) {
            aerServConfig.setUseHeaderBidding(this.a.h);
        }
        return aerServConfig;
    }
}

