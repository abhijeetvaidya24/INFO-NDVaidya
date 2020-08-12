/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.TJError
 *  com.tapjoy.TJPlacement
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adincube.sdk.mediation.y;

import com.adincube.sdk.mediation.a;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;

public final class g {
    a a = null;
    private b b = null;

    public g(b b2) {
        this.b = b2;
    }

    public final void a() {
        a a2 = this.a;
        if (a2 != null) {
            a2.a();
        }
    }

    public final void a(TJError tJError) {
        if (this.a != null) {
            b b2 = this.b;
            j.a a2 = j.a.d;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tJError.code);
            stringBuilder.append(" ");
            stringBuilder.append(tJError.message);
            j j2 = new j(b2, a2, stringBuilder.toString());
            this.a.a(j2);
        }
    }

    public final void a(TJPlacement tJPlacement) {
        if (!tJPlacement.isContentAvailable() && this.a != null) {
            j j2 = new j(this.b, j.a.b);
            this.a.a(j2);
        }
    }
}

