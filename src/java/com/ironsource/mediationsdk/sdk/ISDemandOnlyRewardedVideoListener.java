/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;

public interface ISDemandOnlyRewardedVideoListener {
    public void onRewardedVideoAdClicked(String var1, Placement var2);

    public void onRewardedVideoAdClosed(String var1);

    public void onRewardedVideoAdOpened(String var1);

    public void onRewardedVideoAdRewarded(String var1, Placement var2);

    public void onRewardedVideoAdShowFailed(String var1, IronSourceError var2);

    public void onRewardedVideoAvailabilityChanged(String var1, boolean var2);
}

