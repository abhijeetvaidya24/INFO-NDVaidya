/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.d
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.ac;

import android.content.Context;
import com.adincube.sdk.mediation.aa.c;
import com.adincube.sdk.mediation.ac.d;
import com.adincube.sdk.mediation.ac.e;

public final class i
implements c {
    private e a;

    public i(e e2) {
        this.a = e2;
    }

    @Override
    public final void a(Context context, com.adincube.sdk.h.f.d d2) {
        d d3 = this.a.a;
        if (d3 != null) {
            d3.b = d2;
            if (d3.a) {
                d3.a();
            }
        }
    }

    @Override
    public final void a(Context context, String string) {
    }

    @Override
    public final boolean a() {
        return false;
    }

    @Override
    public final String b() {
        return "vungle-inc";
    }
}

