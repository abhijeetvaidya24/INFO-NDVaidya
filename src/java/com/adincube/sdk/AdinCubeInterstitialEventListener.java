/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk;

public interface AdinCubeInterstitialEventListener {
    public void onAdCached();

    public void onAdClicked();

    public void onAdHidden();

    public void onAdShown();

    public void onError(String var1);
}

