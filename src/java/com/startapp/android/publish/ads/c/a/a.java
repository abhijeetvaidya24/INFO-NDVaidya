/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.startapp.android.publish.ads.c.a.b
 *  java.lang.Boolean
 */
package com.startapp.android.publish.ads.c.a;

import android.content.Context;
import com.startapp.android.publish.ads.c.a.b;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.android.publish.common.model.GetAdRequest;

public class a
extends com.startapp.android.publish.html.a {
    public a(Context context, b b2, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, (Ad)b2, adPreferences, adEventListener, AdPreferences.Placement.INAPP_OFFER_WALL, true);
    }

    @Override
    protected GetAdRequest a() {
        GetAdRequest getAdRequest = super.a();
        if (getAdRequest == null) {
            return null;
        }
        getAdRequest.setAdsNumber(com.startapp.android.publish.adsCommon.b.a().g());
        return getAdRequest;
    }

    @Override
    protected void a(Boolean bl) {
        super.a(bl);
        this.a((boolean)bl);
    }
}

