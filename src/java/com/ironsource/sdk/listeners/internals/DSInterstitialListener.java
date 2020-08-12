/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.sdk.listeners.internals;

import com.ironsource.sdk.listeners.internals.DSAdProductListener;

public interface DSInterstitialListener
extends DSAdProductListener {
    public void onInterstitialLoadFailed(String var1, String var2);

    public void onInterstitialLoadSuccess(String var1);

    public void onInterstitialShowFailed(String var1, String var2);

    public void onInterstitialShowSuccess(String var1);
}

