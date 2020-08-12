/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package com.applovin.sdk;

import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdUpdateListener;
import java.util.List;

public interface AppLovinAdService {
    public static final String URI_AD_SERVICE = "/adservice";
    @Deprecated
    public static final String URI_API_SERVICE = "/api";
    public static final String URI_CLOSE_AD = "/adservice/close_ad";
    public static final String URI_CONTRACT_AD = "/adservice/contract_ad";
    public static final String URI_EXPAND_AD = "/adservice/expand_ad";
    @Deprecated
    public static final String URI_LAUNCH_APP = "/launch";
    @Deprecated
    public static final String URI_NEXT_AD = "/adservice/next_ad";

    @Deprecated
    public void addAdUpdateListener(AppLovinAdUpdateListener var1);

    public void addAdUpdateListener(AppLovinAdUpdateListener var1, AppLovinAdSize var2);

    public String getBidToken();

    @Deprecated
    public boolean hasPreloadedAd(AppLovinAdSize var1);

    @Deprecated
    public boolean hasPreloadedAdForZoneId(String var1);

    public void loadNextAd(AppLovinAdSize var1, AppLovinAdLoadListener var2);

    public void loadNextAdForAdToken(String var1, AppLovinAdLoadListener var2);

    public void loadNextAdForZoneId(String var1, AppLovinAdLoadListener var2);

    public void loadNextAdForZoneIds(List<String> var1, AppLovinAdLoadListener var2);

    @Deprecated
    public void preloadAd(AppLovinAdSize var1);

    @Deprecated
    public void preloadAdForZoneId(String var1);

    public void removeAdUpdateListener(AppLovinAdUpdateListener var1, AppLovinAdSize var2);
}

