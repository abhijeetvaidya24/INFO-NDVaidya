/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ironsource.mediationsdk.RewardedVideoSmash
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.RewardedVideoSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;

public interface RewardedVideoManagerListener {
    public void onRewardedVideoAdClicked(RewardedVideoSmash var1);

    public void onRewardedVideoAdClosed(RewardedVideoSmash var1);

    public void onRewardedVideoAdOpened(RewardedVideoSmash var1);

    public void onRewardedVideoAdRewarded(RewardedVideoSmash var1);

    public void onRewardedVideoAdShowFailed(IronSourceError var1, RewardedVideoSmash var2);

    public void onRewardedVideoAdVisible(RewardedVideoSmash var1);

    public void onRewardedVideoAvailabilityChanged(boolean var1, RewardedVideoSmash var2);
}

