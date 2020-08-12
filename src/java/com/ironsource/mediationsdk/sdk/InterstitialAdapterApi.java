/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.ironsource.mediationsdk.sdk.InterstitialSmashListener
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.sdk;

import android.app.Activity;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import org.json.JSONObject;

public interface InterstitialAdapterApi {
    public void initInterstitial(Activity var1, String var2, String var3, JSONObject var4, InterstitialSmashListener var5);

    public boolean isInterstitialReady(JSONObject var1);

    public void loadInterstitial(JSONObject var1, InterstitialSmashListener var2);

    public void showInterstitial(JSONObject var1, InterstitialSmashListener var2);
}

