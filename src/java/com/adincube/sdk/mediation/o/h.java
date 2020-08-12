/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Boolean
 *  java.lang.Object
 */
package com.adincube.sdk.mediation.o;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;

public final class h
implements RewardedVideoListener {
    RewardedVideoListener a = null;
    Boolean b = null;

    @Override
    public final void onRewardedVideoAdClicked(Placement placement) {
        RewardedVideoListener rewardedVideoListener = this.a;
        if (rewardedVideoListener != null) {
            rewardedVideoListener.onRewardedVideoAdClicked(placement);
        }
    }

    @Override
    public final void onRewardedVideoAdClosed() {
        RewardedVideoListener rewardedVideoListener = this.a;
        if (rewardedVideoListener != null) {
            rewardedVideoListener.onRewardedVideoAdClosed();
        }
    }

    @Override
    public final void onRewardedVideoAdOpened() {
        RewardedVideoListener rewardedVideoListener = this.a;
        if (rewardedVideoListener != null) {
            rewardedVideoListener.onRewardedVideoAdOpened();
        }
    }

    @Override
    public final void onRewardedVideoAdRewarded(Placement placement) {
        RewardedVideoListener rewardedVideoListener = this.a;
        if (rewardedVideoListener != null) {
            rewardedVideoListener.onRewardedVideoAdRewarded(placement);
        }
    }

    @Override
    public final void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        RewardedVideoListener rewardedVideoListener = this.a;
        if (rewardedVideoListener != null) {
            rewardedVideoListener.onRewardedVideoAdShowFailed(ironSourceError);
        }
    }

    @Override
    public final void onRewardedVideoAvailabilityChanged(boolean bl) {
        this.b = bl;
        RewardedVideoListener rewardedVideoListener = this.a;
        if (rewardedVideoListener != null) {
            rewardedVideoListener.onRewardedVideoAvailabilityChanged(bl);
        }
    }
}

