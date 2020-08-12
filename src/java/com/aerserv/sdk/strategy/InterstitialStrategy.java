/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.aerserv.sdk.strategy;

public interface InterstitialStrategy {
    public void buildInterstitialPlayer();

    public void onDestroy();

    public void onPause();

    public void onResume();

    public void playInterstitial();

    public void registerEvents();
}

