/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.startapp.android.publish.ads.splash.b
 *  java.lang.Boolean
 */
package com.startapp.android.publish.ads.splash;

import android.content.Context;
import com.startapp.android.publish.ads.splash.b;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.common.model.AdPreferences;

public class a
extends com.startapp.android.publish.html.a {
    public a(Context context, b b2, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, (Ad)b2, adPreferences, adEventListener, AdPreferences.Placement.INAPP_SPLASH, true);
    }

    @Override
    protected void a(Boolean bl) {
        super.a(bl);
        this.a((boolean)bl);
    }
}

