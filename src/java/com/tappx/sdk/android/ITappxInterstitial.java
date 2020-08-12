/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package com.tappx.sdk.android;

import android.content.Context;
import com.tappx.sdk.android.AdRequest;
import com.tappx.sdk.android.TappxInterstitialListener;

public interface ITappxInterstitial {
    public void destroy();

    public Context getContext();

    public boolean isReady();

    public void loadAd();

    public void loadAd(AdRequest var1);

    public void setAutoShowWhenReady(boolean var1);

    public void setListener(TappxInterstitialListener var1);

    public void show();
}

