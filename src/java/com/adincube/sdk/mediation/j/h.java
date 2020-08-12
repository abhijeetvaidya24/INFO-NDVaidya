/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.adincube.sdk.h.b
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.j.f
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.doubleclick.PublisherAdRequest
 *  com.google.android.gms.ads.doubleclick.PublisherAdRequest$Builder
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 */
package com.adincube.sdk.mediation.j;

import android.os.Bundle;
import com.adincube.sdk.h.b;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.j.f;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import java.util.Date;

public final class h {
    g a;
    private f b;

    public h(f f2) {
        this.b = f2;
    }

    public final PublisherAdRequest a() {
        PublisherAdRequest.Builder builder = new PublisherAdRequest.Builder();
        g g2 = this.a;
        if (g2 != null) {
            if (g2.a != null) {
                int n2 = 1.a[this.a.a.ordinal()];
                int n3 = n2 != 1 ? (n2 != 2 ? 0 : 2) : 1;
                builder.setGender(n3);
            }
            if (this.a.d != null) {
                builder.setBirthday(this.a.a());
            }
        }
        if (this.b.k.booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("is_designed_for_families", true);
            builder = builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle).setIsDesignedForFamilies(true);
        }
        if (this.b.l.booleanValue()) {
            builder = builder.tagForChildDirectedTreatment(true);
        }
        return builder.build();
    }

}

