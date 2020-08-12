/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.applovin.nativeAds;

import com.applovin.nativeAds.AppLovinNativeAd;

public interface AppLovinNativeAdPrecacheListener {
    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd var1, int var2);

    public void onNativeAdImagesPrecached(AppLovinNativeAd var1);

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd var1, int var2);

    public void onNativeAdVideoPreceached(AppLovinNativeAd var1);
}

