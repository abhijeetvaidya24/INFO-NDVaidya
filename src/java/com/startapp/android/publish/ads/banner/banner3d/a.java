/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.startapp.android.publish.ads.banner.banner3d;

import android.content.Context;
import com.startapp.android.publish.ads.banner.banner3d.c;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.adsCommon.h;
import com.startapp.android.publish.common.model.AdPreferences;

public class a
extends h {
    private static final long serialVersionUID = 1L;
    private boolean fixedSize;
    private int offset;

    public a(Context context, int n2) {
        super(context, AdPreferences.Placement.INAPP_BANNER);
        this.offset = n2;
    }

    public int a() {
        return this.offset;
    }

    public void a(boolean bl) {
        this.fixedSize = bl;
    }

    public boolean b() {
        return this.fixedSize;
    }

    @Override
    protected void loadAds(AdPreferences adPreferences, AdEventListener adEventListener) {
        c c2 = new c(this.context, this, this.offset, adPreferences, adEventListener);
        c2.c();
        this.offset = 1 + this.offset;
    }
}

