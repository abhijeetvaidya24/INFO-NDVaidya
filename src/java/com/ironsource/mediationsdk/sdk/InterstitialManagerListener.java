/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ironsource.mediationsdk.InterstitialSmash
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.InterstitialSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;

public interface InterstitialManagerListener {
    public void onInterstitialAdClicked(InterstitialSmash var1);

    public void onInterstitialAdClosed(InterstitialSmash var1);

    public void onInterstitialAdLoadFailed(IronSourceError var1, InterstitialSmash var2);

    public void onInterstitialAdOpened(InterstitialSmash var1);

    public void onInterstitialAdReady(InterstitialSmash var1);

    public void onInterstitialAdShowFailed(IronSourceError var1, InterstitialSmash var2);

    public void onInterstitialAdShowSucceeded(InterstitialSmash var1);

    public void onInterstitialAdVisible(InterstitialSmash var1);

    public void onInterstitialInitFailed(IronSourceError var1, InterstitialSmash var2);

    public void onInterstitialInitSuccess(InterstitialSmash var1);
}

