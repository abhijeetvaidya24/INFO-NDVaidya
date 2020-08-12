/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
 *  com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
 *  java.lang.Object
 */
package com.applovin.mediation.adapter;

import android.app.Activity;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;

public interface MaxInterstitialAdapter {
    public void loadInterstitialAd(MaxAdapterResponseParameters var1, Activity var2, MaxInterstitialAdapterListener var3);

    public void showInterstitialAd(MaxAdapterResponseParameters var1, Activity var2, MaxInterstitialAdapterListener var3);
}

