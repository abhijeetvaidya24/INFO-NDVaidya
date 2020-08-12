/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.applovin.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.Map;

public interface AppLovinAdRewardListener {
    public void userDeclinedToViewAd(AppLovinAd var1);

    public void userOverQuota(AppLovinAd var1, Map<String, String> var2);

    public void userRewardRejected(AppLovinAd var1, Map<String, String> var2);

    public void userRewardVerified(AppLovinAd var1, Map<String, String> var2);

    public void validationRequestFailed(AppLovinAd var1, int var2);
}

