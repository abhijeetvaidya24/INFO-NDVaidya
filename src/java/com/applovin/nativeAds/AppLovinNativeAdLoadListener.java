/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.util.List
 */
package com.applovin.nativeAds;

import com.applovin.nativeAds.AppLovinNativeAd;
import java.util.List;

public interface AppLovinNativeAdLoadListener {
    public void onNativeAdsFailedToLoad(int var1);

    public void onNativeAdsLoaded(List<AppLovinNativeAd> var1);
}

