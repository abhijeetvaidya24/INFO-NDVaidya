/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Boolean
 */
package com.startapp.android.publish.ads.b;

import android.content.Context;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.e;
import com.startapp.android.publish.common.model.AdPreferences;

public class a
extends com.startapp.android.publish.html.a {
    public a(Context context, e e2, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, e2, adPreferences, adEventListener, AdPreferences.Placement.INAPP_OVERLAY, true);
    }

    @Override
    protected void a(Boolean bl) {
        super.a(bl);
        this.a((boolean)bl);
    }
}

