/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.ironsource.sdk.listeners.OnInterstitialListener
 *  com.ironsource.sdk.listeners.OnRewardedVideoListener
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.ironsource.sdk;

import android.app.Activity;
import com.ironsource.sdk.listeners.OnInterstitialListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.OnRewardedVideoListener;
import java.util.Map;
import org.json.JSONObject;

public interface SSAPublisher {
    public void getOfferWallCredits(String var1, String var2, OnOfferWallListener var3);

    public void initInterstitial(String var1, String var2, String var3, Map<String, String> var4, OnInterstitialListener var5);

    public void initOfferWall(String var1, String var2, Map<String, String> var3, OnOfferWallListener var4);

    public void initRewardedVideo(String var1, String var2, String var3, Map<String, String> var4, OnRewardedVideoListener var5);

    public boolean isInterstitialAdAvailable(String var1);

    public void loadInterstitial(JSONObject var1);

    public void onPause(Activity var1);

    public void onResume(Activity var1);

    public void setMediationState(String var1, String var2, int var3);

    public void showInterstitial(JSONObject var1);

    public void showOfferWall(Map<String, String> var1);

    public void showRewardedVideo(JSONObject var1);

    public void updateConsentInfo(JSONObject var1);
}

