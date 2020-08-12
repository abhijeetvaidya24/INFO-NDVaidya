/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.d
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.aa;

import android.content.Context;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.aa.c;

public final class b
implements c {
    public d a;
    private String b;

    public b(String string) {
        this.b = string;
    }

    @Override
    public final void a(Context context, d d2) {
        this.a = d2;
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
        return this.b;
    }
}

