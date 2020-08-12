/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.mopub.mobileads.MoPubErrorCode
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adincube.sdk.mediation.r;

import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;
import com.mopub.mobileads.MoPubErrorCode;

public final class a {
    com.adincube.sdk.mediation.a a = null;
    private b b = null;

    public a(b b2) {
        this.b = b2;
    }

    public final j a(MoPubErrorCode moPubErrorCode) {
        j.a a2 = j.a.d;
        switch (1.a[moPubErrorCode.ordinal()]) {
            default: {
                break;
            }
            case 15: 
            case 16: 
            case 17: {
                a2 = j.a.c;
                break;
            }
            case 4: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: 
            case 10: 
            case 11: 
            case 12: 
            case 13: 
            case 14: {
                a2 = j.a.d;
                break;
            }
            case 1: 
            case 2: {
                a2 = j.a.b;
            }
            case 3: 
        }
        b b2 = this.b;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(moPubErrorCode.name());
        stringBuilder.append(" - ");
        stringBuilder.append(moPubErrorCode.toString());
        return new j(b2, a2, stringBuilder.toString());
    }

    public final void a() {
        com.adincube.sdk.mediation.a a2 = this.a;
        if (a2 != null) {
            a2.a();
        }
    }

    public final void b(MoPubErrorCode moPubErrorCode) {
        j j2 = this.a(moPubErrorCode);
        com.adincube.sdk.mediation.a a2 = this.a;
        if (a2 != null) {
            a2.a(j2);
        }
    }

}

