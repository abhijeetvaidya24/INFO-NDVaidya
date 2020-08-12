/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  com.applovin.sdk.AppLovinAd
 *  com.applovin.sdk.AppLovinAdClickListener
 *  com.applovin.sdk.AppLovinAdDisplayListener
 *  com.applovin.sdk.AppLovinAdLoadListener
 *  com.applovin.sdk.AppLovinAdSize
 *  com.applovin.sdk.AppLovinAdVideoPlaybackListener
 *  com.applovin.sdk.AppLovinSdk
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.adview;

import android.content.Context;
import android.util.AttributeSet;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

@Deprecated
public interface AdViewController {
    public void contractAd();

    public void destroy();

    public void expandAd();

    public AppLovinAdSize getSize();

    public String getZoneId();

    public void initializeAdView(AppLovinAdView var1, Context var2, AppLovinAdSize var3, String var4, AppLovinSdk var5, AttributeSet var6);

    public boolean isAdReadyToDisplay();

    public boolean isAutoDestroy();

    public void loadNextAd();

    public void onDetachedFromWindow();

    public void onVisibilityChanged(int var1);

    public void pause();

    public void renderAd(AppLovinAd var1);

    @Deprecated
    public void renderAd(AppLovinAd var1, String var2);

    public void resume();

    public void setAdClickListener(AppLovinAdClickListener var1);

    public void setAdDisplayListener(AppLovinAdDisplayListener var1);

    public void setAdLoadListener(AppLovinAdLoadListener var1);

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener var1);

    public void setAdViewEventListener(AppLovinAdViewEventListener var1);

    public void setAutoDestroy(boolean var1);
}

