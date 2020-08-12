/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdTargetingOptions;

public interface Ad {
    public int getTimeout();

    public boolean isLoading();

    public boolean loadAd();

    public boolean loadAd(AdTargetingOptions var1);

    public void setListener(AdListener var1);

    public void setTimeout(int var1);
}

