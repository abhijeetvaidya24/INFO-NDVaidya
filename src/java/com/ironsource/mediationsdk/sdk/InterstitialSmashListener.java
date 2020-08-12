/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialListener;

public interface InterstitialSmashListener
extends InterstitialListener {
    public void onInterstitialAdVisible();

    public void onInterstitialInitFailed(IronSourceError var1);

    public void onInterstitialInitSuccess();
}

