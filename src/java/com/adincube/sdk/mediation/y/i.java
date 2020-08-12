/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.d
 *  com.tapjoy.Tapjoy
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.y;

import android.content.Context;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.aa.c;
import com.tapjoy.Tapjoy;

public final class i
implements c {
    @Override
    public final void a(Context context, d d2) {
        if (d2 == d.e) {
            Tapjoy.subjectToGDPR((boolean)false);
            return;
        }
        if (d2 == d.c) {
            Tapjoy.subjectToGDPR((boolean)true);
            Tapjoy.setUserConsent((String)"1");
            return;
        }
        if (d2 == d.d || d2 == d.a) {
            Tapjoy.subjectToGDPR((boolean)true);
            Tapjoy.setUserConsent((String)"0");
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
        return "tapjoy-inc";
    }
}

