/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  com.startapp.android.publish.ads.splash.b
 *  java.io.Serializable
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.ads.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.a;
import com.startapp.android.publish.adsCommon.activities.AppWallActivity;
import com.startapp.android.publish.adsCommon.activities.FullScreenActivity;
import com.startapp.android.publish.adsCommon.activities.OverlayActivity;
import com.startapp.android.publish.adsCommon.adListeners.AdDisplayListener;
import com.startapp.android.publish.adsCommon.b;
import com.startapp.android.publish.adsCommon.e;
import com.startapp.android.publish.adsCommon.g;
import com.startapp.android.publish.adsCommon.n;
import com.startapp.android.publish.common.model.AdPreferences;
import java.io.Serializable;

public abstract class c
extends e
implements g {
    private static final long serialVersionUID = 1L;

    public c(Context context, AdPreferences.Placement placement) {
        super(context, placement);
    }

    private boolean d() {
        return this.n() != 0 && this.n() != this.context.getResources().getConfiguration().orientation;
    }

    private Class<?> f(String string) {
        if (this.g(string)) {
            return FullScreenActivity.class;
        }
        return i.a(this.getContext(), OverlayActivity.class, AppWallActivity.class);
    }

    private boolean g(String string) {
        return (this.d() || this.a() || this.r() || string.equals((Object)"back")) && i.a(this.getContext(), FullScreenActivity.class);
    }

    protected boolean a() {
        return false;
    }

    @Override
    public boolean a(String string) {
        String string2 = com.startapp.android.publish.adsCommon.c.b();
        if (this.a() && b.a().H().a().equals((Object)n.a.a) && string2.equals((Object)"back")) {
            this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.VIDEO_BACK);
            return false;
        }
        if (!AdsConstants.OVERRIDE_NETWORK.booleanValue()) {
            this.setState(Ad.AdState.UN_INITIALIZED);
        }
        if (this.f() == null) {
            this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.INTERNAL_ERROR);
            return false;
        }
        if (this.hasAdCacheTtlPassed()) {
            this.setNotDisplayedReason(AdDisplayListener.NotDisplayedReason.AD_EXPIRED);
            return false;
        }
        boolean bl = this.activityExtra != null ? this.activityExtra.a() : false;
        Intent intent = new Intent(this.context, this.f(string2));
        intent.putExtra("fileUrl", "exit.html");
        String[] arrstring = this.l();
        String string3 = com.startapp.android.publish.adsCommon.c.a();
        for (int i2 = 0; i2 < arrstring.length; ++i2) {
            if (arrstring[i2] == null || "".equals((Object)arrstring[i2])) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(arrstring[i2]);
            stringBuilder.append(string3);
            arrstring[i2] = stringBuilder.toString();
        }
        intent.putExtra("tracking", arrstring);
        intent.putExtra("trackingClickUrl", this.m());
        intent.putExtra("packageNames", this.o());
        intent.putExtra("htmlUuid", this.g());
        intent.putExtra("smartRedirect", this.smartRedirect);
        intent.putExtra("browserEnabled", this.k());
        intent.putExtra("placement", this.placement.getIndex());
        intent.putExtra("adInfoOverride", (Serializable)this.getAdInfoOverride());
        intent.putExtra("ad", (Serializable)this);
        intent.putExtra("videoAd", this.a());
        intent.putExtra("fullscreen", bl);
        intent.putExtra("orientation", this.b());
        intent.putExtra("adTag", string);
        intent.putExtra("lastLoadTime", (Serializable)this.getLastLoadTime());
        intent.putExtra("adCacheTtl", (Serializable)this.getAdCacheTtl());
        intent.putExtra("closingUrl", this.i());
        if (this.p() != null) {
            intent.putExtra("delayImpressionSeconds", (Serializable)this.p());
        }
        intent.putExtra("sendRedirectHops", (Serializable)this.q());
        intent.putExtra("mraidAd", this.r());
        if (this.r()) {
            intent.putExtra("activityShouldLockOrientation", false);
        }
        if (i.a(8L) && this instanceof com.startapp.android.publish.ads.splash.b) {
            intent.putExtra("isSplash", true);
        }
        intent.putExtra("position", string2);
        intent.addFlags(343932928);
        this.context.startActivity(intent);
        return true;
    }

    @Override
    public String a_() {
        return super.a_();
    }

    protected int b() {
        if (this.n() == 0) {
            return this.context.getResources().getConfiguration().orientation;
        }
        return this.n();
    }

    @Override
    public Long getAdCacheTtl() {
        return super.getAdCacheTtl();
    }

    @Override
    public Long getLastLoadTime() {
        return super.getLastLoadTime();
    }

    @Override
    public boolean getVideoCancelCallBack() {
        return super.getVideoCancelCallBack();
    }

    @Override
    public boolean hasAdCacheTtlPassed() {
        return super.hasAdCacheTtlPassed();
    }

    @Override
    public void setVideoCancelCallBack(boolean bl) {
        super.setVideoCancelCallBack(bl);
    }
}

