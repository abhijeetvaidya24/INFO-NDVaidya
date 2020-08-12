/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.startapp.android.publish.ads.nativead;

import android.content.Context;
import com.startapp.android.publish.ads.nativead.NativeAdPreferences;
import com.startapp.android.publish.ads.nativead.a;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.h;
import com.startapp.android.publish.common.model.AdPreferences;

public class b
extends h {
    private static final long serialVersionUID = 1L;
    private NativeAdPreferences config;

    public b(Context context, NativeAdPreferences nativeAdPreferences) {
        super(context, AdPreferences.Placement.INAPP_NATIVE);
        this.config = nativeAdPreferences;
    }

    @Override
    protected void loadAds(AdPreferences adPreferences, AdEventListener adEventListener) {
        a a2 = new a(this.context, this, adPreferences, adEventListener, this.config);
        a2.c();
    }
}

