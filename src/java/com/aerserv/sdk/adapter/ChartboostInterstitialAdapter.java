/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.text.TextUtils
 *  com.aerserv.sdk.adapter.ChartboostInterstitialAdapter$2
 *  com.chartboost.sdk.ChartboostDelegate
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import com.aerserv.sdk.adapter.AbstractActivityLifecycleCallbacks;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.adapter.ChartboostInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.ChartboostDelegate;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChartboostInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "ChartboostInterstitialAdapter";
    private static String appId;
    private static String appSignature;
    private static boolean initialized;
    private static final Map<String, ChartboostInterstitialAdapter> instanceMap;
    private boolean adImpressionFired = false;
    private Boolean interstitialAdLoaded = null;
    private Boolean interstitialShown = null;
    private AdapterListener listener = null;
    private String location;
    private Boolean rewardedAdLoaded = null;
    private Boolean rewardedAdShown = null;

    static {
        instanceMap = new HashMap();
        appId = null;
        appSignature = null;
        initialized = false;
    }

    private ChartboostInterstitialAdapter(String string) {
        this.location = string;
    }

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ Map access$100() {
        return instanceMap;
    }

    static /* synthetic */ Boolean access$202(ChartboostInterstitialAdapter chartboostInterstitialAdapter, Boolean bl) {
        chartboostInterstitialAdapter.interstitialAdLoaded = bl;
        return bl;
    }

    static /* synthetic */ AdapterListener access$300(String string) {
        return ChartboostInterstitialAdapter.getListener(string);
    }

    static /* synthetic */ boolean access$400(String string) {
        return ChartboostInterstitialAdapter.getAdImpressionFired(string);
    }

    static /* synthetic */ void access$500(String string) {
        ChartboostInterstitialAdapter.setAdImpressionFired(string);
    }

    static /* synthetic */ Boolean access$602(ChartboostInterstitialAdapter chartboostInterstitialAdapter, Boolean bl) {
        chartboostInterstitialAdapter.rewardedAdLoaded = bl;
        return bl;
    }

    static /* synthetic */ boolean access$702(boolean bl) {
        initialized = bl;
        return bl;
    }

    private static boolean getAdImpressionFired(String string) {
        ChartboostInterstitialAdapter chartboostInterstitialAdapter = (ChartboostInterstitialAdapter)instanceMap.get((Object)string);
        if (chartboostInterstitialAdapter == null) {
            return true;
        }
        return chartboostInterstitialAdapter.adImpressionFired;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because the adapter needs Android Ice Cream Sandwich or later");
            return null;
        }
        if (!ReflectionUtils.canFindClass("com.chartboost.sdk.Chartboost")) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because Chartoost SDK was not included, or Proguard was not configured properly");
            return null;
        }
        if (jSONObject.optString("appId", jSONObject.optString("ChartboostAppId", "")).equals((Object)appId) && jSONObject.optString("signature", jSONObject.optString("ChartboostAppSignature", "")).equals((Object)appSignature)) {
            Map<String, ChartboostInterstitialAdapter> map;
            String string2 = jSONObject.optString("ChartboostLocation", jSONObject.optString("location"));
            if (TextUtils.isEmpty((CharSequence)string2)) {
                string2 = "Default";
            }
            Map<String, ChartboostInterstitialAdapter> map2 = map = instanceMap;
            synchronized (map2) {
                if (instanceMap.get((Object)string2) != null) return (Adapter)instanceMap.get((Object)string2);
                instanceMap.put((Object)string2, (Object)new ChartboostInterstitialAdapter(string2));
                return (Adapter)instanceMap.get((Object)string2);
            }
        }
        AerServLog.i(LOG_TAG, "Cannot get instance of adapter because Chartboost app ID or app signature used to initialize SDK is different than the ones in request.");
        return null;
    }

    private static AdapterListener getListener(String string) {
        ChartboostInterstitialAdapter chartboostInterstitialAdapter = (ChartboostInterstitialAdapter)instanceMap.get((Object)string);
        if (chartboostInterstitialAdapter == null) {
            return null;
        }
        return chartboostInterstitialAdapter.listener;
    }

    public static void initPartnerSdk(final Activity activity, JSONArray jSONArray) {
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot not initialize Chartboost SDK because the adapter needs Android Ice Cream Sandwich or later");
            return;
        }
        if (!ReflectionUtils.canFindClass("com.chartboost.sdk.Chartboost")) {
            AerServLog.i(LOG_TAG, "Cannot initialize Chartboost SDK because its libraries were not included, or Proguard was not configured properly");
            return;
        }
        if (jSONArray != null && jSONArray.length() >= 1) {
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    String string = jSONObject.optString("appId", jSONObject.optString("ChartboostAppId", ""));
                    if (TextUtils.isEmpty((CharSequence)string)) {
                        AerServLog.i(LOG_TAG, "App ID used to initialize Chartboost is empty.  Skipping to next set of credentials.");
                        continue;
                    }
                    String string2 = jSONObject.optString("signature", jSONObject.optString("ChartboostAppSignature", ""));
                    if (TextUtils.isEmpty((CharSequence)string2)) {
                        AerServLog.i(LOG_TAG, "App signature used to initialize Chartboost is empty.  Skipping to next set of credentials.");
                        continue;
                    }
                    appId = string;
                    appSignature = string2;
                    break;
                }
                catch (JSONException jSONException) {
                    String string = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Error reading credentials: ");
                    stringBuilder.append(jSONException.getMessage());
                    stringBuilder.append(".  Skipping to next set of credentials.");
                    AerServLog.i(string, stringBuilder.toString());
                }
            }
            if (!TextUtils.isEmpty((CharSequence)appId) && !TextUtils.isEmpty((CharSequence)appSignature)) {
                activity.getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new AbstractActivityLifecycleCallbacks(){

                    @Override
                    public void onActivityDestroyed(Activity activity2) {
                        if (activity2.getClass().getName().equals((Object)activity.getClass().getName())) {
                            Chartboost.onDestroy(activity2);
                        }
                    }

                    @Override
                    public void onActivityPaused(Activity activity2) {
                        if (activity2.getClass().getName().equals((Object)activity.getClass().getName())) {
                            Chartboost.onPause(activity2);
                        }
                    }

                    @Override
                    public void onActivityResumed(Activity activity2) {
                        if (activity2.getClass().getName().equals((Object)activity.getClass().getName())) {
                            Chartboost.onResume(activity2);
                        }
                    }

                    @Override
                    public void onActivityStarted(Activity activity2) {
                        if (activity2.getClass().getName().equals((Object)activity.getClass().getName())) {
                            Chartboost.onStart(activity2);
                        }
                    }

                    @Override
                    public void onActivityStopped(Activity activity2) {
                        if (activity2.getClass().getName().equals((Object)activity.getClass().getName())) {
                            Chartboost.onStop(activity2);
                        }
                    }
                });
                Chartboost.startWithAppId(activity, appId, appSignature);
                Chartboost.setDelegate((ChartboostDelegate)new 2());
                try {
                    Thread.sleep((long)1000L);
                }
                catch (Exception exception) {}
                Chartboost.onCreate(activity);
                Chartboost.onStart(activity);
                Chartboost.onResume(activity);
                return;
            }
            AerServLog.i(LOG_TAG, "Cannot initialize Chartboost SDK because app ID or app signature is empty.");
            return;
        }
        AerServLog.i(LOG_TAG, "Cannot initialize Chartboost SDK because credentials list is empty");
    }

    private static void resetAdImpressionFired(String string) {
        ChartboostInterstitialAdapter chartboostInterstitialAdapter = (ChartboostInterstitialAdapter)instanceMap.get((Object)string);
        if (chartboostInterstitialAdapter != null) {
            chartboostInterstitialAdapter.adImpressionFired = false;
        }
    }

    private static void setAdImpressionFired(String string) {
        ChartboostInterstitialAdapter chartboostInterstitialAdapter = (ChartboostInterstitialAdapter)instanceMap.get((Object)string);
        if (chartboostInterstitialAdapter != null) {
            chartboostInterstitialAdapter.adImpressionFired = true;
        }
    }

    private void showInterstitialAd() {
        this.interstitialShown = null;
        this.adImpressionFired = false;
        if (Chartboost.hasInterstitial(this.location)) {
            Chartboost.showInterstitial(this.location);
            return;
        }
        this.interstitialShown = false;
    }

    private void showRewardedAd() {
        this.rewardedAdShown = null;
        if (Chartboost.hasRewardedVideo(this.location)) {
            Chartboost.showRewardedVideo(this.location);
            return;
        }
        this.rewardedAdShown = false;
    }

    @Override
    public void cleanup(Activity activity) {
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        if (bl) {
            return Chartboost.hasRewardedVideo(this.location);
        }
        return Chartboost.hasInterstitial(this.location);
    }

    @Override
    public boolean hasPartnerAdLoadFailedDueToConnectionError() {
        return false;
    }

    @Override
    public Boolean hasPartnerAdLoaded(boolean bl) {
        if (!initialized) {
            return null;
        }
        if (bl) {
            return this.rewardedAdLoaded;
        }
        return this.interstitialAdLoaded;
    }

    @Override
    public Boolean hasPartnerAdShown(boolean bl) {
        if (bl) {
            return this.rewardedAdShown;
        }
        return this.interstitialShown;
    }

    @Override
    public void loadPartnerAd(Activity activity, JSONObject jSONObject, boolean bl, boolean bl2) {
        if (bl) {
            this.rewardedAdLoaded = null;
            Chartboost.cacheRewardedVideo(this.location);
            return;
        }
        this.interstitialAdLoaded = null;
        Chartboost.cacheInterstitial(this.location);
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.listener = adapterListener;
        ChartboostInterstitialAdapter.resetAdImpressionFired(this.location);
        if (bl) {
            this.showRewardedAd();
            return;
        }
        this.showInterstitialAd();
    }

    @Override
    public boolean supportsRewardedCallback() {
        return true;
    }

}

