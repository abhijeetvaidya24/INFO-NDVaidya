/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 */
package com.adincube.sdk.g.b.c;

import com.adincube.sdk.h.c.e;
import com.adincube.sdk.mediation.b;
import com.adincube.sdk.util.a;

public final class o {
    e a;
    long b = 0L;
    long c = 0L;

    public o(e e2, long l2) {
        this.a = e2;
        this.b = System.currentTimeMillis();
        this.c = l2;
    }

    public final boolean a() {
        try {
            boolean bl = this.a.f.d();
            return bl;
        }
        catch (Throwable throwable) {
            Object[] arrobject = new Object[]{this.a.b(), throwable};
            a.c("Cannot check if network '%s' has been properly loaded. Mediation will continue", arrobject);
            return false;
        }
    }
}

