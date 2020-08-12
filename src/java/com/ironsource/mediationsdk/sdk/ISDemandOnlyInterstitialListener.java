/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

public interface ISDemandOnlyInterstitialListener {
    public void onInterstitialAdClicked(String var1);

    public void onInterstitialAdClosed(String var1);

    public void onInterstitialAdLoadFailed(String var1, IronSourceError var2);

    public void onInterstitialAdOpened(String var1);

    public void onInterstitialAdReady(String var1);

    public void onInterstitialAdShowFailed(String var1, IronSourceError var2);

    public void onInterstitialAdShowSucceeded(String var1);
}

