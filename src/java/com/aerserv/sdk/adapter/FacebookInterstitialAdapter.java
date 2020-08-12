/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  com.aerserv.sdk.adapter.FacebookInterstitialAdapter$1
 *  com.facebook.ads.AdSettings
 *  com.facebook.ads.InterstitialAd
 *  com.facebook.ads.InterstitialAdListener
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.UUID
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.adapter.FacebookInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.facebook.ads.AdSettings;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class FacebookInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "FacebookInterstitialAdapter";
    private static final Map<MultiKey, FacebookInterstitialAdapter> instanceMap = new HashMap();
    private Boolean adLoaded = null;
    private boolean adLoadedFailedDueToConectionError = false;
    private Boolean adShown = null;
    private InterstitialAd interstitialAd = null;
    private AdapterListener listener = null;
    private String placementId;

    private FacebookInterstitialAdapter(String string) {
        this.placementId = string;
    }

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ Boolean access$102(FacebookInterstitialAdapter facebookInterstitialAdapter, Boolean bl) {
        facebookInterstitialAdapter.adShown = bl;
        return bl;
    }

    static /* synthetic */ AdapterListener access$200(FacebookInterstitialAdapter facebookInterstitialAdapter) {
        return facebookInterstitialAdapter.listener;
    }

    static /* synthetic */ boolean access$302(FacebookInterstitialAdapter facebookInterstitialAdapter, boolean bl) {
        facebookInterstitialAdapter.adLoadedFailedDueToConectionError = bl;
        return bl;
    }

    static /* synthetic */ Boolean access$402(FacebookInterstitialAdapter facebookInterstitialAdapter, Boolean bl) {
        facebookInterstitialAdapter.adLoaded = bl;
        return bl;
    }

    static /* synthetic */ InterstitialAd access$500(FacebookInterstitialAdapter facebookInterstitialAdapter) {
        return facebookInterstitialAdapter.interstitialAd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        Map<MultiKey, FacebookInterstitialAdapter> map;
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because the adapter needs Android Ice Cream Sandwich or later");
            return null;
        }
        if (!ReflectionUtils.canFindClass("com.facebook.ads.InterstitialAd")) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because Facebook SDK was not included, or Proguard was not configured properly");
            return null;
        }
        Map<MultiKey, FacebookInterstitialAdapter> map2 = map = instanceMap;
        synchronized (map2) {
            String string2 = jSONObject.optString("placementId", jSONObject.optString("FacebookPlacementId"));
            if (TextUtils.isEmpty((CharSequence)string2)) {
                AerServLog.i(LOG_TAG, "Cannot get instance of adapter because Facebook placement ID is empty");
                return null;
            }
            MultiKey multiKey = new MultiKey(string, string2);
            FacebookInterstitialAdapter facebookInterstitialAdapter = (FacebookInterstitialAdapter)instanceMap.get((Object)multiKey);
            if (facebookInterstitialAdapter == null) {
                facebookInterstitialAdapter = new FacebookInterstitialAdapter(string2);
                instanceMap.put((Object)multiKey, (Object)facebookInterstitialAdapter);
            }
            return facebookInterstitialAdapter;
        }
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
    }

    @Override
    public void cleanup(Activity activity) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
            this.interstitialAd = null;
        }
        this.listener = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        InterstitialAd interstitialAd = this.interstitialAd;
        return interstitialAd != null && interstitialAd.isAdLoaded() && Boolean.TRUE.equals((Object)this.adLoaded) && this.adShown == null;
    }

    @Override
    public boolean hasPartnerAdLoadFailedDueToConnectionError() {
        return this.adLoadedFailedDueToConectionError;
    }

    @Override
    public Boolean hasPartnerAdLoaded(boolean bl) {
        return this.adLoaded;
    }

    @Override
    public Boolean hasPartnerAdShown(boolean bl) {
        return this.adShown;
    }

    @Override
    public void loadPartnerAd(Activity activity, JSONObject jSONObject, boolean bl, boolean bl2) {
        this.adLoaded = null;
        this.adShown = null;
        this.adLoadedFailedDueToConectionError = false;
        this.interstitialAd = new InterstitialAd((Context)activity, this.placementId);
        this.interstitialAd.setAdListener((InterstitialAdListener)new 1(this));
        if (bl2) {
            SharedPreferences sharedPreferences = activity.getBaseContext().getSharedPreferences("FBAdPrefs", 0);
            String string = sharedPreferences.getString("deviceIdHash", (String)null);
            if (string != null) {
                String string2 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Debug is enabled, adding the deviceId ");
                stringBuilder.append(string);
                stringBuilder.append(" as a test device.");
                AerServLog.v(string2, stringBuilder.toString());
                AdSettings.addTestDevice((String)string);
            } else {
                String string3 = jSONObject.optString("testDeviceId", jSONObject.optString("FacebookTestDeviceId", UUID.randomUUID().toString()));
                String string4 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Debug is enabled, but can't find the deviceIdHash, let's use ours ");
                stringBuilder.append(string3);
                AerServLog.v(string4, stringBuilder.toString());
                sharedPreferences.edit().putString("deviceIdHash", string3).apply();
                AdSettings.addTestDevice((String)string3);
            }
        } else {
            AdSettings.clearTestDevices();
        }
        activity.runOnUiThread(new Runnable(this){
            final /* synthetic */ FacebookInterstitialAdapter this$0;
            {
                this.this$0 = facebookInterstitialAdapter;
            }

            public void run() {
                if (FacebookInterstitialAdapter.access$500(this.this$0) != null) {
                    FacebookInterstitialAdapter.access$500(this.this$0).loadAd();
                    return;
                }
                FacebookInterstitialAdapter.access$402(this.this$0, false);
                AerServLog.i(FacebookInterstitialAdapter.access$000(), "Could not load Facebook ad because interstialAd object is null");
            }
        });
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.adShown = null;
        this.listener = adapterListener;
        activity.runOnUiThread(new Runnable(this){
            final /* synthetic */ FacebookInterstitialAdapter this$0;
            {
                this.this$0 = facebookInterstitialAdapter;
            }

            public void run() {
                if (FacebookInterstitialAdapter.access$500(this.this$0) != null && FacebookInterstitialAdapter.access$500(this.this$0).isAdLoaded()) {
                    FacebookInterstitialAdapter.access$500(this.this$0).show();
                    return;
                }
                FacebookInterstitialAdapter.access$102(this.this$0, false);
                FacebookInterstitialAdapter.access$402(this.this$0, null);
                FacebookInterstitialAdapter.access$302(this.this$0, false);
            }
        });
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }
}

