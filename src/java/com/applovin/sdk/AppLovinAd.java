/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.sdk;

import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;

public interface AppLovinAd {
    public long getAdIdNumber();

    public String getAdValue(String var1);

    public AppLovinAdSize getSize();

    public AppLovinAdType getType();

    public String getZoneId();

    public boolean isVideoAd();
}

