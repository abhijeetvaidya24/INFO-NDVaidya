/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.mediation.o.a$1
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adincube.sdk.mediation.o;

import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;
import com.adincube.sdk.mediation.o.a;
import com.adincube.sdk.util.o;
import com.ironsource.mediationsdk.logger.IronSourceError;

public final class a {
    b a = null;
    com.adincube.sdk.mediation.a b = null;

    public a(b b2) {
        this.a = b2;
    }

    public final j a(IronSourceError ironSourceError) {
        int n2 = ironSourceError.getErrorCode();
        j.a a2 = !(n2 == 508 && ironSourceError.getErrorMessage().contains((CharSequence)"not contain") || n2 == 510 || n2 == 509) ? (n2 == 520 ? j.a.c : (n2 != 508 && n2 != 505 && n2 != 506 && n2 != 501 && n2 != 524 ? j.a.d : j.a.a)) : j.a.b;
        b b2 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ironSourceError.getErrorCode());
        stringBuilder.append(" - ");
        stringBuilder.append(ironSourceError.getErrorMessage());
        return new j(b2, a2, stringBuilder.toString());
    }

    public final void a() {
        o.a("IronSourceAdListenerHelper.onAdAvailable", this.b, new 1(this));
    }
}

