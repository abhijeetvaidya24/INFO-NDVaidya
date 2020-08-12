/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.applovin.mediation;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxReward;

public interface MaxRewardedAdListener
extends MaxAdListener {
    public void onRewardedVideoCompleted(MaxAd var1);

    public void onRewardedVideoStarted(MaxAd var1);

    public void onUserRewarded(MaxAd var1, MaxReward var2);
}

