/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.sdk.AppLovinAd
 *  com.applovin.sdk.AppLovinAdClickListener
 *  com.applovin.sdk.AppLovinAdDisplayListener
 *  com.applovin.sdk.AppLovinAdLoadListener
 *  com.applovin.sdk.AppLovinAdVideoPlaybackListener
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

public interface AppLovinInterstitialAdDialog {
    public void dismiss();

    public boolean isAdReadyToDisplay();

    public boolean isShowing();

    public void setAdClickListener(AppLovinAdClickListener var1);

    public void setAdDisplayListener(AppLovinAdDisplayListener var1);

    public void setAdLoadListener(AppLovinAdLoadListener var1);

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener var1);

    public void show();

    @Deprecated
    public void show(String var1);

    public void showAndRender(AppLovinAd var1);

    @Deprecated
    public void showAndRender(AppLovinAd var1, String var2);
}

