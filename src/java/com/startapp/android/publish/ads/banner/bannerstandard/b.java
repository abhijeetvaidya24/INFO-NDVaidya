/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.startapp.android.publish.ads.banner.a
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.ads.banner.bannerstandard;

import android.content.Context;
import com.startapp.android.publish.ads.banner.BannerOptions;
import com.startapp.android.publish.ads.banner.bannerstandard.a;
import com.startapp.android.publish.ads.banner.c;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.e;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.android.publish.common.model.GetAdRequest;
import com.startapp.common.a.g;

public class b
extends com.startapp.android.publish.html.a {
    private int i = 0;

    public b(Context context, e e2, int n2, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, e2, adPreferences, adEventListener, AdPreferences.Placement.INAPP_BANNER, false);
        this.i = n2;
    }

    @Override
    protected GetAdRequest a() {
        a a2 = (a)this.b;
        com.startapp.android.publish.ads.banner.a a3 = new com.startapp.android.publish.ads.banner.a();
        this.b((GetAdRequest)a3);
        a3.setWidth(a2.h());
        a3.setHeight(a2.j());
        a3.setOffset(this.i);
        a3.setAdsNumber(c.a().b().g());
        a3.a(a2.b());
        a3.a(a2.c());
        return a3;
    }

    @Override
    protected void a(Boolean bl) {
        super.a(bl);
        this.a((boolean)bl);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Html onPostExecute, result=[");
        stringBuilder.append((Object)bl);
        stringBuilder.append("]");
        g.a(4, stringBuilder.toString());
    }
}

