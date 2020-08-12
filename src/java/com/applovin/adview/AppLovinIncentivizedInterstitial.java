/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  com.applovin.impl.sdk.a.a
 *  com.applovin.impl.sdk.e.l
 *  com.applovin.sdk.AppLovinAd
 *  com.applovin.sdk.AppLovinAdClickListener
 *  com.applovin.sdk.AppLovinAdDisplayListener
 *  com.applovin.sdk.AppLovinAdLoadListener
 *  com.applovin.sdk.AppLovinAdRewardListener
 *  com.applovin.sdk.AppLovinAdVideoPlaybackListener
 *  com.applovin.sdk.AppLovinSdk
 *  java.lang.Deprecated
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.adview;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.a.a;
import com.applovin.impl.sdk.e.l;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinIncentivizedInterstitial {
    private final a a;

    public AppLovinIncentivizedInterstitial(Context context) {
        this(AppLovinSdk.getInstance((Context)context));
    }

    public AppLovinIncentivizedInterstitial(AppLovinSdk appLovinSdk) {
        this(null, appLovinSdk);
    }

    public AppLovinIncentivizedInterstitial(String string, AppLovinSdk appLovinSdk) {
        if (appLovinSdk != null) {
            this.a = this.createIncentivizedAdController(string, appLovinSdk);
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public static AppLovinIncentivizedInterstitial create(Context context) {
        return AppLovinIncentivizedInterstitial.create(AppLovinSdk.getInstance((Context)context));
    }

    public static AppLovinIncentivizedInterstitial create(AppLovinSdk appLovinSdk) {
        return AppLovinIncentivizedInterstitial.create(null, appLovinSdk);
    }

    public static AppLovinIncentivizedInterstitial create(String string, AppLovinSdk appLovinSdk) {
        return new AppLovinIncentivizedInterstitial(string, appLovinSdk);
    }

    protected a createIncentivizedAdController(String string, AppLovinSdk appLovinSdk) {
        return new a(string, appLovinSdk);
    }

    public void dismiss() {
        this.a.c();
    }

    public String getUserIdentifier() {
        return l.a();
    }

    public String getZoneId() {
        return this.a.b();
    }

    public boolean isAdReadyToDisplay() {
        return this.a.a();
    }

    public void preload(AppLovinAdLoadListener appLovinAdLoadListener) {
        if (appLovinAdLoadListener == null) {
            Log.i((String)"AppLovinIncentivizedInterstitial", (String)"AppLovinAdLoadListener was null when preloading incentivized interstitials; using a listener is highly recommended.");
        }
        this.a.a(appLovinAdLoadListener);
    }

    public void setUserIdentifier(String string) {
        l.a((String)string);
    }

    public void show(Context context) {
        this.show(context, null, null);
    }

    public void show(Context context, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.show(context, appLovinAdRewardListener, null);
    }

    public void show(Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.show(context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, null);
    }

    public void show(Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.show(context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, null);
    }

    public void show(Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.show(context, null, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    @Deprecated
    public void show(Context context, String string, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.a.a(null, context, string, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void show(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.a.a(appLovinAd, context, null, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }
}

