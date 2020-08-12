/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.sdk.android;

import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.TappxBannerListener;

public interface ITappxBanner {
    public void destroy();

    public void loadAd();

    public void loadAd(AdRequest var1);

    public void setAppKey(String var1);

    public void setEnableAutoRefresh(boolean var1);

    public void setListener(TappxBannerListener var1);

    public void setRefreshTimeSeconds(int var1);
}

