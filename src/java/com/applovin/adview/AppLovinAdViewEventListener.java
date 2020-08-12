/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.sdk.AppLovinAd
 *  java.lang.Object
 */
package com.applovin.adview;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.sdk.AppLovinAd;

public interface AppLovinAdViewEventListener {
    public void adClosedFullscreen(AppLovinAd var1, AppLovinAdView var2);

    public void adFailedToDisplay(AppLovinAd var1, AppLovinAdView var2, AppLovinAdViewDisplayErrorCode var3);

    public void adLeftApplication(AppLovinAd var1, AppLovinAdView var2);

    public void adOpenedFullscreen(AppLovinAd var1, AppLovinAdView var2);
}

