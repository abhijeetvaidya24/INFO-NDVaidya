/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.impl.sdk.ad;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;

public final class i
implements AppLovinAd {
    public String a() {
        return "<html><head></head><body></body></html>";
    }

    @Override
    public long getAdIdNumber() {
        return 0L;
    }

    @Override
    public String getAdValue(String string) {
        return null;
    }

    @Override
    public AppLovinAdSize getSize() {
        return AppLovinAdSize.BANNER;
    }

    @Override
    public AppLovinAdType getType() {
        return AppLovinAdType.REGULAR;
    }

    @Override
    public String getZoneId() {
        return null;
    }

    @Override
    public boolean isVideoAd() {
        return false;
    }
}

