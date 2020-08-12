/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.amazon.device.ads;

import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdProperties;

public interface AdListener {
    public void onAdCollapsed(Ad var1);

    public void onAdDismissed(Ad var1);

    public void onAdExpanded(Ad var1);

    public void onAdFailedToLoad(Ad var1, AdError var2);

    public void onAdLoaded(Ad var1, AdProperties var2);
}

