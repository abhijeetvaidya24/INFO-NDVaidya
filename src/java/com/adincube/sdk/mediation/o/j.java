/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.d
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.o;

import android.content.Context;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.aa.c;
import com.ironsource.mediationsdk.IronSource;

public final class j
implements c {
    @Override
    public final void a(Context context, d d2) {
        if (d2 == d.c) {
            IronSource.setConsent(true);
            return;
        }
        if (d2 == d.d) {
            IronSource.setConsent(false);
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
        return "ironsource-ltd";
    }
}

