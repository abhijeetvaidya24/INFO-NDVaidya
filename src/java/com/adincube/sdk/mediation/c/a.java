/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.c;

import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.j;

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

    public final void a(int n2) {
        if (this.b != null) {
            j.a a2 = j.a.d;
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 == 3) {
                            a2 = j.a.b;
                        }
                    } else {
                        a2 = j.a.c;
                    }
                } else {
                    a2 = j.a.a;
                }
            } else {
                a2 = j.a.d;
            }
            this.a(new j(this.a, a2, Integer.toString((int)n2)));
        }
    }

    public final void a(j j2) {
        com.adincube.sdk.mediation.a a2 = this.b;
        if (a2 != null) {
            a2.a(j2);
        }
    }
}

