/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.applovin.mediation.adapter.listeners;

import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;

public interface MaxInterstitialAdapterListener
extends MaxAdapterListener {
    public void onInterstitialAdClicked();

    public void onInterstitialAdDisplayFailed(MaxAdapterError var1);

    public void onInterstitialAdDisplayed();

    public void onInterstitialAdHidden();

    public void onInterstitialAdLoadFailed(MaxAdapterError var1);

    public void onInterstitialAdLoaded();
}

