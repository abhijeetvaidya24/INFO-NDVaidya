/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

public interface RewardedVideoSmashListener {
    public void onRewardedVideoAdClicked();

    public void onRewardedVideoAdClosed();

    public void onRewardedVideoAdOpened();

    public void onRewardedVideoAdRewarded();

    public void onRewardedVideoAdShowFailed(IronSourceError var1);

    public void onRewardedVideoAdVisible();

    public void onRewardedVideoAvailabilityChanged(boolean var1);
}

