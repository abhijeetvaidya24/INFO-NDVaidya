/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  com.unity3d.ads.IUnityAdsListener
 *  com.unity3d.ads.UnityAds
 *  com.unity3d.ads.UnityAds$FinishState
 *  com.unity3d.ads.UnityAds$UnityAdsError
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.text.TextUtils;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class UnityInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "UnityInterstitialAdapter";
    private static String gameId;
    private static final Map<String, UnityInterstitialAdapter> instanceMap;
    private Boolean adShown = null;
    private String zoneId = null;

    static {
        instanceMap = new HashMap();
    }

    private UnityInterstitialAdapter(String string) {
        this.zoneId = string;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        Map<String, UnityInterstitialAdapter> map;
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because the adapter needs Android Ice Cream Sandwich or later");
            return null;
        }
        if (!ReflectionUtils.canFindClass("com.unity3d.ads.UnityAds")) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because Unity SDK was not included, or Proguard was not configured properly");
            return null;
        }
        String string2 = jSONObject.optString("unityGameId", jSONObject.optString("UnityGameId"));
        if (TextUtils.isEmpty((CharSequence)string2)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of UnityAdapter because game ID is empty");
            return null;
        }
        if (!string2.equals((Object)gameId)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of UnityAdapter because game ID is different than the one used in initialization");
            return null;
        }
        String string3 = jSONObject.optString("zoneId", jSONObject.optString("UnityZoneId"));
        if (TextUtils.isEmpty((CharSequence)string3)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of UnityAdapter because zone ID is empty");
            return null;
        }
        Map<String, UnityInterstitialAdapter> map2 = map = instanceMap;
        synchronized (map2) {
            if (instanceMap.get((Object)string3) != null) return (Adapter)instanceMap.get((Object)string3);
            instanceMap.put((Object)string3, (Object)new UnityInterstitialAdapter(string3));
            return (Adapter)instanceMap.get((Object)string3);
        }
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot not initialize Unity SDK because the adapter needs Android Ice Cream Sandwich or later");
            return;
        }
        if (!ReflectionUtils.canFindClass("com.unity3d.ads.UnityAds")) {
            AerServLog.i(LOG_TAG, "Cannot initialize Unity SDK because its libraries were not included, or Proguard was not configured properly");
            return;
        }
        if (jSONArray != null && jSONArray.length() >= 1) {
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                JSONObject jSONObject = jSONArray.optJSONObject(i2);
                if (jSONObject == null) {
                    AerServLog.i(LOG_TAG, "Cannot initialize Unity because credentials object is null.  Skipping to next set of credentials");
                    continue;
                }
                String string = jSONObject.optString("unityGameId", jSONObject.optString("UnityGameId"));
                if (string == null) {
                    AerServLog.i(LOG_TAG, "Game ID used to initialize Unity is empty.  Skipping to next set of credentials.");
                    continue;
                }
                gameId = string;
                IUnityAdsListener iUnityAdsListener = new IUnityAdsListener(){

                    public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String string) {
                    }

                    public void onUnityAdsFinish(String string, UnityAds.FinishState finishState) {
                    }

                    public void onUnityAdsReady(String string) {
                    }

                    public void onUnityAdsStart(String string) {
                    }
                };
                if (jSONObject.optBoolean("testMode", false)) {
                    UnityAds.initialize((Activity)activity, (String)gameId, (IUnityAdsListener)iUnityAdsListener, (boolean)true);
                    return;
                }
                UnityAds.initialize((Activity)activity, (String)gameId, (IUnityAdsListener)iUnityAdsListener);
                break;
            }
            return;
        }
        AerServLog.i(LOG_TAG, "Cannot initialize Unity SDK because credentials list is empty");
    }

    @Override
    public void cleanup(Activity activity) {
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        return UnityAds.isReady((String)this.zoneId);
    }

    @Override
    public boolean hasPartnerAdLoadFailedDueToConnectionError() {
        return false;
    }

    @Override
    public Boolean hasPartnerAdLoaded(boolean bl) {
        if (UnityAds.isInitialized() && UnityAds.isReady((String)this.zoneId)) {
            return true;
        }
        return null;
    }

    @Override
    public Boolean hasPartnerAdShown(boolean bl) {
        return this.adShown;
    }

    @Override
    public void loadPartnerAd(Activity activity, JSONObject jSONObject, boolean bl, boolean bl2) {
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, final AdapterListener adapterListener) {
        this.adShown = null;
        if (!UnityAds.isReady((String)this.zoneId)) {
            AerServLog.i(LOG_TAG, "Cannot show Unity ad because it is not ready");
            this.adShown = false;
            return;
        }
        UnityAds.setListener((IUnityAdsListener)new IUnityAdsListener(){

            public void onUnityAdsError(UnityAds.UnityAdsError unityAdsError, String string) {
                String string2 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unity onUnityAdsError(): error=");
                stringBuilder.append((Object)unityAdsError);
                stringBuilder.append(", reason=");
                stringBuilder.append(string);
                AerServLog.v(string2, stringBuilder.toString());
                UnityInterstitialAdapter.this.adShown = false;
            }

            public void onUnityAdsFinish(String string, UnityAds.FinishState finishState) {
                AerServLog.v(LOG_TAG, "Unity onUnityAdsFinish()");
                if (adapterListener != null) {
                    if (finishState == UnityAds.FinishState.COMPLETED) {
                        adapterListener.onVideoComplete();
                    }
                    adapterListener.onAdDismissed();
                }
            }

            public void onUnityAdsReady(String string) {
                AerServLog.v(LOG_TAG, "Unity onUnityAdsReady()");
            }

            public void onUnityAdsStart(String string) {
                AerServLog.v(LOG_TAG, "Unity onUnityAdsStart()");
                UnityInterstitialAdapter.this.adShown = true;
                AdapterListener adapterListener2 = adapterListener;
                if (adapterListener2 != null) {
                    adapterListener2.onAdImpression();
                    adapterListener.onVideoStart();
                }
            }
        });
        UnityAds.show((Activity)activity, (String)this.zoneId);
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }

}

