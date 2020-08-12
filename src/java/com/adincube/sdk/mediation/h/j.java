/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.d
 *  com.avocarrot.sdk.Avocarrot
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.h;

import android.content.Context;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.aa.c;
import com.avocarrot.sdk.Avocarrot;

public final class j
implements c {
    @Override
    public final void a(Context context, d d2) {
        if (d2 == d.c) {
            Avocarrot.hasConsent((Boolean)true);
        }
        if (d2 == d.d || d2 == d.a) {
            Avocarrot.hasConsent((Boolean)false);
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
        return "glispa-gmbh";
    }
}

