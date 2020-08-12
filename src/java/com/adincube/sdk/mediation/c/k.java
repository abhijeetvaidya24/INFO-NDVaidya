/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.adincube.sdk.h.b
 *  com.adincube.sdk.h.g
 *  com.adincube.sdk.mediation.c.i
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 */
package com.adincube.sdk.mediation.c;

import android.os.Bundle;
import com.adincube.sdk.h.b;
import com.adincube.sdk.h.g;
import com.adincube.sdk.mediation.c.i;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;
import java.util.Date;

public final class k {
    g a;
    private i b;
    private boolean c;

    public k(i i2) {
        this.b = i2;
        this.c = false;
    }

    public final k a(Boolean bl) {
        this.c = bl;
        return this;
    }

    public final AdRequest a() {
        g g2;
        AdRequest.Builder builder = new AdRequest.Builder();
        Bundle bundle = new Bundle();
        if (this.c) {
            bundle.putString("npa", "1");
        }
        if (!this.c && (g2 = this.a) != null) {
            if (g2.a != null) {
                int n2 = 1.a[this.a.a.ordinal()];
                int n3 = n2 != 1 ? (n2 != 2 ? 0 : 2) : 1;
                builder.setGender(n3);
            }
            if (this.a.d != null) {
                builder.setBirthday(this.a.a());
            }
        }
        if (this.b.l.booleanValue()) {
            bundle.putBoolean("is_designed_for_families", true);
            builder.setIsDesignedForFamilies(true);
        }
        if (this.b.m.booleanValue()) {
            builder.tagForChildDirectedTreatment(true);
        }
        if (this.b.n.booleanValue()) {
            bundle.putBoolean("tag_for_under_age_of_consent", true);
        }
        if (this.b.q != null) {
            bundle.putString("max_ad_content_rating", this.b.q);
        }
        if (!bundle.isEmpty()) {
            builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        }
        return builder.build();
    }

}

