/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdProperties;

interface AdControlCallback {
    public static final int CLOSE_EVENT_ONLY = 0;
    public static final int CLOSE_FULL = 1;
    public static final int NO_CLOSE = 2;

    public int adClosing();

    public boolean isAdReady(boolean var1);

    public void onAdEvent(AdEvent var1);

    public void onAdExpired();

    public void onAdFailed(AdError var1);

    public void onAdLoaded(AdProperties var1);

    public void onAdRendered();

    public void postAdRendered();
}

