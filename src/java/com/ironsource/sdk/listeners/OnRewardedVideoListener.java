/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.ironsource.sdk.listeners;

import com.ironsource.sdk.data.AdUnitsReady;
import com.ironsource.sdk.listeners.OnAdProductListener;
import org.json.JSONObject;

public interface OnRewardedVideoListener
extends OnAdProductListener {
    public void onRVAdClicked();

    public void onRVAdClosed();

    public void onRVAdCredited(int var1);

    public void onRVAdOpened();

    public void onRVEventNotificationReceived(String var1, JSONObject var2);

    public void onRVInitFail(String var1);

    public void onRVInitSuccess(AdUnitsReady var1);

    public void onRVNoMoreOffers();

    public void onRVShowFail(String var1);
}

