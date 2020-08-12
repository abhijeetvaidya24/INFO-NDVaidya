/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.adapter;

public interface AdapterListener {
    public void onAdClicked();

    public void onAdDismissed();

    public void onAdImpression();

    public void onRewarded(String var1, Double var2);

    public void onVideoComplete();

    public void onVideoStart();
}

