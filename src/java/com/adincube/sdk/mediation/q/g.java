/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.d
 *  com.mobvista.msdk.MobVistaSDK
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.q;

import android.content.Context;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.aa.c;
import com.adincube.sdk.mediation.q.b;
import com.mobvista.msdk.MobVistaSDK;

public final class g
implements c {
    private b a;

    public g(b b2) {
        this.a = b2;
    }

    @Override
    public final void a(Context context, d d2) {
        MobVistaSDK mobVistaSDK = this.a.b;
        if (mobVistaSDK == null) {
            return;
        }
        if (d2 == d.c) {
            mobVistaSDK.setUserPrivateInfoType(context, "authority_general_data", 1);
            return;
        }
        if (d2 == d.d) {
            mobVistaSDK.setUserPrivateInfoType(context, "authority_general_data", 0);
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
        return "mobvista-international-technology-limited";
    }
}

