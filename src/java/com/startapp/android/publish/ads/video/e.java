/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Integer
 *  java.lang.String
 */
package com.startapp.android.publish.ads.video;

import android.content.Context;
import com.startapp.android.publish.ads.b.c;
import com.startapp.android.publish.ads.splash.SplashConfig;
import com.startapp.android.publish.ads.video.VideoAdDetails;
import com.startapp.android.publish.ads.video.b;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;
import com.startapp.android.publish.common.model.AdPreferences;

public class e
extends c {
    private static final long serialVersionUID = 1L;
    private VideoAdDetails videoAdDetails = null;

    public e(Context context) {
        super(context, AdPreferences.Placement.INAPP_OVERLAY);
    }

    private void f(String string) {
        if (string != null) {
            this.videoAdDetails = com.startapp.common.c.b.a(string, VideoAdDetails.class);
        }
    }

    public void a(com.startapp.android.publish.ads.video.c.a.e e2, boolean bl) {
        if (e2 != null) {
            this.videoAdDetails = new VideoAdDetails(e2, bl);
            com.startapp.android.publish.ads.video.c.a.a.b b2 = e2.g();
            if (b2 != null) {
                if (b2.d() > b2.e()) {
                    this.a(SplashConfig.Orientation.LANDSCAPE);
                    return;
                }
                this.a(SplashConfig.Orientation.PORTRAIT);
            }
        }
    }

    @Override
    protected boolean a() {
        return this.videoAdDetails != null;
    }

    @Override
    public void b(String string) {
        super.b(string);
        this.f(this.a(string, "@videoJson@"));
    }

    public VideoAdDetails d() {
        return this.videoAdDetails;
    }

    public void e() {
        this.videoAdDetails = null;
    }

    @Override
    protected void loadAds(AdPreferences adPreferences, AdEventListener adEventListener) {
        new b(this.context, this, adPreferences, adEventListener).c();
    }
}

