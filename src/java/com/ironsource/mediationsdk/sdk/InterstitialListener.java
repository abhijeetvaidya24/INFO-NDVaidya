/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

public interface InterstitialListener {
    public void onInterstitialAdClicked();

    public void onInterstitialAdClosed();

    public void onInterstitialAdLoadFailed(IronSourceError var1);

    public void onInterstitialAdOpened();

    public void onInterstitialAdReady();

    public void onInterstitialAdShowFailed(IronSourceError var1);

    public void onInterstitialAdShowSucceeded();
}

