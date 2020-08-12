/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.w;

import com.adincube.sdk.mediation.a;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;
import com.adincube.sdk.util.m;

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

    public final void a(Exception exception) {
        if (this.a != null) {
            j j2 = new j(this.b, j.a.d, m.a(exception));
            this.a.a(j2);
        }
    }
}

