/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.applovin.mediation.adapter.listeners;

import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.listeners.MaxAdapterListener;

public interface MaxRewardedAdapterListener
extends MaxAdapterListener {
    public void onRewardedAdClicked();

    public void onRewardedAdDisplayFailed(MaxAdapterError var1);

    public void onRewardedAdDisplayed();

    public void onRewardedAdHidden();

    public void onRewardedAdLoadFailed(MaxAdapterError var1);

    public void onRewardedAdLoaded();

    public void onRewardedAdVideoCompleted();

    public void onRewardedAdVideoStarted();

    public void onUserRewarded(MaxReward var1);
}

