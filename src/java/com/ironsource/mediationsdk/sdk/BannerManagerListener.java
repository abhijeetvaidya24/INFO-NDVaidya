/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ironsource.mediationsdk.BannerSmash
 *  java.lang.Object
 */
package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.BannerSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;

public interface BannerManagerListener {
    public void onBannerAdLoadFailed(IronSourceError var1, BannerSmash var2);

    public void onBannerAdReloadFailed(IronSourceError var1, BannerSmash var2);
}

