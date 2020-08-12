/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.applovin.sdk;

import com.applovin.sdk.AppLovinAd;

public interface AppLovinAdLoadListener {
    public void adReceived(AppLovinAd var1);

    public void failedToReceiveAd(int var1);
}

