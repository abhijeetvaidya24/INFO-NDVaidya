/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.chartboost.sdk;

import com.chartboost.sdk.Model.CBError;

public interface a {
    public void didCacheInPlay(String var1);

    public void didCacheInterstitial(String var1);

    public void didCacheRewardedVideo(String var1);

    public void didClickInterstitial(String var1);

    public void didClickRewardedVideo(String var1);

    public void didCloseInterstitial(String var1);

    public void didCloseRewardedVideo(String var1);

    public void didCompleteRewardedVideo(String var1, int var2);

    public void didDismissInterstitial(String var1);

    public void didDismissRewardedVideo(String var1);

    public void didDisplayInterstitial(String var1);

    public void didDisplayRewardedVideo(String var1);

    public void didFailToLoadInPlay(String var1, CBError.CBImpressionError var2);

    public void didFailToLoadInterstitial(String var1, CBError.CBImpressionError var2);

    public void didFailToLoadMoreApps(String var1, CBError.CBImpressionError var2);

    public void didFailToLoadRewardedVideo(String var1, CBError.CBImpressionError var2);

    public void didFailToRecordClick(String var1, CBError.CBClickError var2);

    public void didInitialize();

    public boolean shouldDisplayInterstitial(String var1);

    public boolean shouldDisplayRewardedVideo(String var1);

    public boolean shouldRequestInterstitial(String var1);

    public void willDisplayInterstitial(String var1);

    public void willDisplayVideo(String var1);
}

