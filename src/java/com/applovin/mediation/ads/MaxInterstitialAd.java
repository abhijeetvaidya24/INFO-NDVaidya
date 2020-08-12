/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  com.applovin.impl.mediation.ads.MaxInterstitialImpl
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.impl.mediation.ads.MaxInterstitialImpl;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdk;

public class MaxInterstitialAd {
    private final MaxInterstitialImpl a;

    public MaxInterstitialAd(String string2, Activity activity) {
        this(string2, AppLovinSdk.getInstance((Context)activity), activity);
    }

    public MaxInterstitialAd(String string2, AppLovinSdk appLovinSdk, Activity activity) {
        if (string2 != null) {
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                if (activity != null) {
                    if (appLovinSdk != null) {
                        this.a = new MaxInterstitialImpl(string2, appLovinSdk, activity);
                        return;
                    }
                    throw new IllegalArgumentException("No sdk specified");
                }
                throw new IllegalArgumentException("No activity specified");
            }
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    public void destroy() {
        this.a.destroy();
    }

    public boolean isReady() {
        return this.a.isReady();
    }

    public void loadAd() {
        this.a.loadAd();
    }

    public void setExtraParameter(String string2, String string3) {
        this.a.setExtraParameter(string2, string3);
    }

    public void setListener(MaxAdListener maxAdListener) {
        this.a.setListener(maxAdListener);
    }

    public void showAd() {
        this.a.showAd();
    }
}

