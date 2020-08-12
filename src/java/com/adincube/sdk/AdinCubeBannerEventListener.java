/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk;

import com.adincube.sdk.BannerView;

public interface AdinCubeBannerEventListener {
    public void onAdClicked(BannerView var1);

    public void onAdLoaded(BannerView var1);

    public void onAdShown(BannerView var1);

    public void onError(BannerView var1, String var2);

    public void onLoadError(BannerView var1, String var2);
}

