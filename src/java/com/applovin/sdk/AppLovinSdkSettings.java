/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 */
package com.applovin.sdk;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.e.m;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashMap;
import java.util.Map;

public class AppLovinSdkSettings {
    private boolean a;
    private boolean b;
    private long c;
    private String d;
    private String e;
    private boolean f;
    private final Map<String, Object> localSettings = new HashMap();

    public AppLovinSdkSettings() {
        this(null);
    }

    public AppLovinSdkSettings(Context context) {
        this.b = m.c(context);
        this.a = m.b(context);
        this.c = -1L;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AppLovinAdSize.INTERSTITIAL.getLabel());
        stringBuilder.append(",");
        stringBuilder.append(AppLovinAdSize.BANNER.getLabel());
        stringBuilder.append(",");
        stringBuilder.append(AppLovinAdSize.MREC.getLabel());
        this.d = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(AppLovinAdType.INCENTIVIZED.getLabel());
        stringBuilder2.append(",");
        stringBuilder2.append(AppLovinAdType.REGULAR.getLabel());
        stringBuilder2.append(",");
        stringBuilder2.append(AppLovinAdType.NATIVE.getLabel());
        this.e = stringBuilder2.toString();
    }

    @Deprecated
    public String getAutoPreloadSizes() {
        return this.d;
    }

    @Deprecated
    public String getAutoPreloadTypes() {
        return this.e;
    }

    public long getBannerAdRefreshSeconds() {
        return this.c;
    }

    public boolean isMuted() {
        return this.f;
    }

    public boolean isTestAdsEnabled() {
        return this.a;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.b;
    }

    @Deprecated
    public void setAutoPreloadSizes(String string2) {
        this.d = string2;
    }

    @Deprecated
    public void setAutoPreloadTypes(String string2) {
        this.e = string2;
    }

    public void setBannerAdRefreshSeconds(long l2) {
        this.c = l2;
    }

    public void setMuted(boolean bl) {
        this.f = bl;
    }

    public void setTestAdsEnabled(boolean bl) {
        this.a = bl;
    }

    public void setVerboseLogging(boolean bl) {
        if (m.a()) {
            Log.e((String)"AppLovinSdkSettings", (String)"Ignoring setting of verbose logging - it is configured from Android manifest already or AppLovinSdkSettings was initialized without a context.");
            return;
        }
        this.b = bl;
    }
}

