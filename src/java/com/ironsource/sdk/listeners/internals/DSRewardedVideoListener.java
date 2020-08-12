/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.sdk.listeners.internals;

import com.ironsource.sdk.listeners.internals.DSAdProductListener;

public interface DSRewardedVideoListener
extends DSAdProductListener {
    public void onRVAdCredited(String var1, int var2);

    public void onRVNoMoreOffers(String var1);

    public void onRVShowFail(String var1, String var2);
}

