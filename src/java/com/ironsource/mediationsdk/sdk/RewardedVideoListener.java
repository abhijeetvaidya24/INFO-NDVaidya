/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;

public interface RewardedVideoListener {
    public void onRewardedVideoAdClicked(Placement var1);

    public void onRewardedVideoAdClosed();

    public void onRewardedVideoAdOpened();

    public void onRewardedVideoAdRewarded(Placement var1);

    public void onRewardedVideoAdShowFailed(IronSourceError var1);

    public void onRewardedVideoAvailabilityChanged(boolean var1);
}

