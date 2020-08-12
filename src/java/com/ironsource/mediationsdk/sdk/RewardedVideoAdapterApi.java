/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.sdk;

import android.app.Activity;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import org.json.JSONObject;

public interface RewardedVideoAdapterApi {
    public void fetchRewardedVideo(JSONObject var1);

    public void initRewardedVideo(Activity var1, String var2, String var3, JSONObject var4, RewardedVideoSmashListener var5);

    public boolean isRewardedVideoAvailable(JSONObject var1);

    public void showRewardedVideo(JSONObject var1, RewardedVideoSmashListener var2);
}

