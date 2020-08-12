/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.presage.interstitial;

public interface PresageInterstitialCallback {
    public void onAdAvailable();

    public void onAdClosed();

    public void onAdDisplayed();

    public void onAdError(int var1);

    public void onAdLoaded();

    public void onAdNotAvailable();

    public void onAdNotLoaded();
}

