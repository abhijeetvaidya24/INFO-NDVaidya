/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AdError
 *  com.amazon.device.ads.AdError$ErrorCode
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adincube.sdk.mediation.e;

import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;
import com.amazon.device.ads.AdError;

public final class a {
    com.adincube.sdk.mediation.a a = null;
    private b b = null;

    public a(b b2) {
        this.b = b2;
    }

    public final void a() {
        com.adincube.sdk.mediation.a a2 = this.a;
        if (a2 != null) {
            a2.a();
        }
    }

    public final void a(AdError adError) {
        if (this.a != null) {
            j.a a2 = j.a.d;
            int n2 = 1.a[adError.getCode().ordinal()];
            if (n2 != 1 && n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        if (n2 == 5) {
                            a2 = j.a.d;
                        }
                    } else {
                        a2 = j.a.a;
                    }
                } else {
                    a2 = j.a.b;
                }
            } else {
                a2 = j.a.c;
            }
            b b2 = this.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((Object)adError.getCode());
            stringBuilder.append(": ");
            stringBuilder.append(adError.getMessage());
            j j2 = new j(b2, a2, stringBuilder.toString());
            this.a.a(j2);
        }
    }

}

