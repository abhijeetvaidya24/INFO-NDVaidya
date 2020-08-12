/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.d
 *  com.startapp.android.publish.adsCommon.StartAppSDK
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.adincube.sdk.mediation.x;

import android.content.Context;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.aa.c;
import com.startapp.android.publish.adsCommon.StartAppSDK;

public final class f
implements c {
    @Override
    public final void a(Context context, d d2) {
        if (d2 == d.c) {
            StartAppSDK.setUserConsent((Context)context, (String)"EULA", (long)System.currentTimeMillis(), (boolean)true);
            return;
        }
        if (d2 == d.d) {
            StartAppSDK.setUserConsent((Context)context, (String)"EULA", (long)System.currentTimeMillis(), (boolean)false);
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
        return null;
    }
}

