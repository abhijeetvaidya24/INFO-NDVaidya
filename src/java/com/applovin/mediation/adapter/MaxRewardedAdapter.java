/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
 *  com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters
 *  java.lang.Object
 */
package com.applovin.mediation.adapter;

import android.app.Activity;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;

public interface MaxRewardedAdapter {
    public void loadRewardedAd(MaxAdapterResponseParameters var1, Activity var2, MaxRewardedAdapterListener var3);

    public void showRewardedAd(MaxAdapterResponseParameters var1, Activity var2, MaxRewardedAdapterListener var3);
}

