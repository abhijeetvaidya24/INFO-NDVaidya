/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tappx.sdk.android.TappxInterstitial
 *  java.lang.Object
 */
package com.tappx.sdk.android;

import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxInterstitial;

public interface TappxInterstitialListener {
    public void onInterstitialClicked(TappxInterstitial var1);

    public void onInterstitialDismissed(TappxInterstitial var1);

    public void onInterstitialLoadFailed(TappxInterstitial var1, TappxAdError var2);

    public void onInterstitialLoaded(TappxInterstitial var1);

    public void onInterstitialShown(TappxInterstitial var1);
}

