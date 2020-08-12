/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tappx.sdk.android.TappxBanner
 *  java.lang.Object
 */
package com.tappx.sdk.android;

import com.tappx.sdk.android.TappxAdError;
import com.tappx.sdk.android.TappxBanner;

public interface TappxBannerListener {
    public void onBannerClicked(TappxBanner var1);

    public void onBannerCollapsed(TappxBanner var1);

    public void onBannerExpanded(TappxBanner var1);

    public void onBannerLoadFailed(TappxBanner var1, TappxAdError var2);

    public void onBannerLoaded(TappxBanner var1);
}

