/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.h.f.d
 *  com.unity3d.ads.metadata.MetaData
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.mediation.z;

import android.content.Context;
import com.adincube.sdk.h.f.d;
import com.adincube.sdk.mediation.aa.c;
import com.unity3d.ads.metadata.MetaData;

public final class i
implements c {
    @Override
    public final void a(Context context, d d2) {
        if (d2 == d.c) {
            MetaData metaData = new MetaData(context);
            metaData.set("gdpr.consent", (Object)true);
            metaData.commit();
            return;
        }
        if (d2 == d.d) {
            MetaData metaData = new MetaData(context);
            metaData.set("gdpr.consent", (Object)false);
            metaData.commit();
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
        return "unity-technologies";
    }
}

