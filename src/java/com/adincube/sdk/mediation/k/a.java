/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.facebook.ads.AdError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adincube.sdk.mediation.k;

import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;
import com.facebook.ads.AdError;

public final class a {
    b a = null;
    com.adincube.sdk.mediation.a b = null;

    public a(b b2) {
        this.a = b2;
    }

    public final void a() {
        com.adincube.sdk.mediation.a a2 = this.b;
        if (a2 != null) {
            a2.a();
        }
    }

    public final void a(j j2) {
        com.adincube.sdk.mediation.a a2 = this.b;
        if (a2 != null) {
            a2.a(j2);
        }
    }

    public final void a(AdError adError) {
        this.a(this.b(adError));
    }

    public final j b(AdError adError) {
        j.a a2;
        switch (adError.getErrorCode()) {
            default: {
                a2 = j.a.d;
                break;
            }
            case 1002: {
                a2 = j.a.a;
                break;
            }
            case 1001: {
                a2 = j.a.b;
                break;
            }
            case 1000: {
                a2 = j.a.c;
            }
        }
        b b2 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(adError.getErrorCode());
        stringBuilder.append(" - ");
        stringBuilder.append(adError.getErrorMessage());
        return new j(b2, a2, stringBuilder.toString());
    }
}

