/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.nativeAds;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;

public interface AppLovinNativeAdService {
    @Deprecated
    public boolean hasPreloadedAdForZoneId(String var1);

    @Deprecated
    public void loadNativeAds(int var1, AppLovinNativeAdLoadListener var2);

    @Deprecated
    public void loadNativeAds(int var1, String var2, AppLovinNativeAdLoadListener var3);

    public void loadNextAd(AppLovinNativeAdLoadListener var1);

    public void precacheResources(AppLovinNativeAd var1, AppLovinNativeAdPrecacheListener var2);

    @Deprecated
    public void preloadAdForZoneId(String var1);
}

