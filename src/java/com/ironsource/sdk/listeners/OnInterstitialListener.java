/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.ironsource.sdk.listeners;

import com.ironsource.sdk.listeners.OnAdProductListener;
import org.json.JSONObject;

public interface OnInterstitialListener
extends OnAdProductListener {
    public void onInterstitialClick();

    public void onInterstitialClose();

    public void onInterstitialEventNotificationReceived(String var1, JSONObject var2);

    public void onInterstitialInitFailed(String var1);

    public void onInterstitialInitSuccess();

    public void onInterstitialLoadFailed(String var1);

    public void onInterstitialLoadSuccess();

    public void onInterstitialOpen();

    public void onInterstitialShowFailed(String var1);

    public void onInterstitialShowSuccess();
}

