/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.location.Location
 *  android.location.LocationManager
 *  android.text.TextUtils
 *  com.rhythmone.ad.sdk.RhythmEventListener
 *  com.rhythmone.ad.sdk.RhythmOneAd
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.location.Location;
import android.location.LocationManager;
import android.text.TextUtils;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.adapter.RhythmOneSdkInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.rhythmone.ad.sdk.RhythmEventListener;
import com.rhythmone.ad.sdk.RhythmOneAd;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class RhythmOneSdkInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "RhythmOneSdkInterstitialAdapter";
    private static final Map<MultiKey, RhythmOneSdkInterstitialAdapter> instanceMap = new HashMap();
    private static Location location = null;
    private Activity activity = null;
    private Boolean adLoaded = null;
    private boolean adLoadedFailedDueToConectionError = false;
    private Boolean adShown = null;
    private String appId = null;
    private AdapterListener listener = null;
    private RhythmEventListener rhythmEventListener = null;
    private RhythmOneAd rhythmOneAd = null;

    private RhythmOneSdkInterstitialAdapter(String string) {
        this.appId = string;
    }

    static /* synthetic */ Boolean access$002(RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter, Boolean bl) {
        rhythmOneSdkInterstitialAdapter.adLoaded = bl;
        return bl;
    }

    static /* synthetic */ Boolean access$100(RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter) {
        return rhythmOneSdkInterstitialAdapter.adShown;
    }

    static /* synthetic */ Boolean access$102(RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter, Boolean bl) {
        rhythmOneSdkInterstitialAdapter.adShown = bl;
        return bl;
    }

    static /* synthetic */ boolean access$202(RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter, boolean bl) {
        rhythmOneSdkInterstitialAdapter.adLoadedFailedDueToConectionError = bl;
        return bl;
    }

    static /* synthetic */ String access$300(RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter) {
        return rhythmOneSdkInterstitialAdapter.appId;
    }

    static /* synthetic */ Location access$400() {
        return location;
    }

    static /* synthetic */ RhythmEventListener access$500(RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter) {
        return rhythmOneSdkInterstitialAdapter.rhythmEventListener;
    }

    static /* synthetic */ RhythmEventListener access$502(RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter, RhythmEventListener rhythmEventListener) {
        rhythmOneSdkInterstitialAdapter.rhythmEventListener = rhythmEventListener;
        return rhythmEventListener;
    }

    static /* synthetic */ String access$600() {
        return LOG_TAG;
    }

    static /* synthetic */ AdapterListener access$700(RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter) {
        return rhythmOneSdkInterstitialAdapter.listener;
    }

    static /* synthetic */ RhythmOneAd access$800(RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter) {
        return rhythmOneSdkInterstitialAdapter.rhythmOneAd;
    }

    static /* synthetic */ RhythmOneAd access$802(RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter, RhythmOneAd rhythmOneAd) {
        rhythmOneSdkInterstitialAdapter.rhythmOneAd = rhythmOneAd;
        return rhythmOneAd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        Map<MultiKey, RhythmOneSdkInterstitialAdapter> map;
        if (!ReflectionUtils.canFindClass("com.rhythmone.ad.sdk.RhythmOneAd")) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because Rhythm One SDK was not included, or Proguard was not configured properly");
            return null;
        }
        Map<MultiKey, RhythmOneSdkInterstitialAdapter> map2 = map = instanceMap;
        synchronized (map2) {
            String string2 = jSONObject.optString("appId", jSONObject.optString("RhythmOneAppId"));
            if (TextUtils.isEmpty((CharSequence)string2)) {
                AerServLog.i(LOG_TAG, "Cannot get instance of adapter because Rhythm One app ID is empty");
                return null;
            }
            MultiKey multiKey = new MultiKey(string, string2);
            RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter = (RhythmOneSdkInterstitialAdapter)instanceMap.get((Object)multiKey);
            if (rhythmOneSdkInterstitialAdapter == null) {
                rhythmOneSdkInterstitialAdapter = new RhythmOneSdkInterstitialAdapter(string2);
                instanceMap.put((Object)multiKey, (Object)rhythmOneSdkInterstitialAdapter);
            }
            return rhythmOneSdkInterstitialAdapter;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Location getLocation(Activity activity) {
        Location location = null;
        LocationManager locationManager = (LocationManager)activity.getSystemService("location");
        location = locationManager.getLastKnownLocation("network");
        if (location != null) return location;
        location = locationManager.getLastKnownLocation("gps");
        if (location != null) return location;
        try {
            return locationManager.getLastKnownLocation("passive");
        }
        catch (Exception exception) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error getting location: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.i(string, stringBuilder.toString());
        }
        return location;
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
        location = RhythmOneSdkInterstitialAdapter.getLocation(activity);
    }

    @Override
    public void cleanup(Activity activity) {
        if (activity == null) {
            return;
        }
        activity.runOnUiThread(new Runnable(this){
            final /* synthetic */ RhythmOneSdkInterstitialAdapter this$0;
            {
                this.this$0 = rhythmOneSdkInterstitialAdapter;
            }

            public void run() {
                if (RhythmOneSdkInterstitialAdapter.access$800(this.this$0) != null) {
                    RhythmOneSdkInterstitialAdapter.access$800(this.this$0).stopAd();
                    RhythmOneSdkInterstitialAdapter.access$800(this.this$0).removeRhythmEventListeners();
                    RhythmOneSdkInterstitialAdapter.access$802(this.this$0, null);
                }
            }
        });
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        return this.rhythmOneAd != null && Boolean.TRUE.equals((Object)this.adLoaded) && this.adShown == null;
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
        activity.runOnUiThread(new Runnable(this, bl, jSONObject, activity){
            final /* synthetic */ RhythmOneSdkInterstitialAdapter this$0;
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ JSONObject val$credentials;
            final /* synthetic */ boolean val$rewardedAd;
            {
                this.this$0 = rhythmOneSdkInterstitialAdapter;
                this.val$rewardedAd = bl;
                this.val$credentials = jSONObject;
                this.val$activity = activity;
            }

            public void run() {
                if (this.this$0.hasAd(this.val$rewardedAd)) {
                    return;
                }
                RhythmOneSdkInterstitialAdapter.access$002(this.this$0, null);
                RhythmOneSdkInterstitialAdapter.access$102(this.this$0, null);
                RhythmOneSdkInterstitialAdapter rhythmOneSdkInterstitialAdapter = this.this$0;
                int n2 = 0;
                RhythmOneSdkInterstitialAdapter.access$202(rhythmOneSdkInterstitialAdapter, false);
                HashMap hashMap = new HashMap();
                hashMap.put((Object)"appId", (Object)RhythmOneSdkInterstitialAdapter.access$300(this.this$0));
                JSONObject jSONObject = this.val$credentials;
                hashMap.put((Object)"placement", (Object)jSONObject.optString("placement", jSONObject.optString("RhythmOnePlacement", "screenchange")));
                JSONObject jSONObject2 = this.val$credentials;
                hashMap.put((Object)"fullscreen", (Object)jSONObject2.optString("fullscreen", jSONObject2.optString("RhythmOneFullscreen", "true")));
                JSONObject jSONObject3 = this.val$credentials;
                hashMap.put((Object)"mediaType", (Object)jSONObject3.optString("mediaType", jSONObject3.optString("RhythmOneMediaType", "all")));
                JSONObject jSONObject4 = this.val$credentials;
                hashMap.put((Object)"skipButtonVisible", (Object)jSONObject4.optString("skipButtonVisible", jSONObject4.optString("RhythmOneSkipButtonVisible", "true")));
                if (RhythmOneSdkInterstitialAdapter.access$400() != null) {
                    hashMap.put((Object)"lat", (Object)java.lang.Double.toString((double)RhythmOneSdkInterstitialAdapter.access$400().getLatitude()));
                    hashMap.put((Object)"lon", (Object)java.lang.Double.toString((double)RhythmOneSdkInterstitialAdapter.access$400().getLongitude()));
                }
                RhythmOneSdkInterstitialAdapter.access$502(this.this$0, new RhythmEventListener(this){
                    final /* synthetic */ 1 this$1;
                    {
                        this.this$1 = var1_1;
                    }

                    public void onEvent(com.rhythmone.ad.sdk.RhythmEvent rhythmEvent, HashMap<String, String> hashMap) {
                        int n2 = com.aerserv.sdk.adapter.RhythmOneSdkInterstitialAdapter$4.$SwitchMap$com$rhythmone$ad$sdk$RhythmEvent[rhythmEvent.ordinal()];
                        Boolean bl = true;
                        switch (n2) {
                            default: {
                                return;
                            }
                            case 7: {
                                AerServLog.v(RhythmOneSdkInterstitialAdapter.access$600(), "Rhythm One AdStopped");
                                if (RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0) == null) break;
                                RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0).onAdDismissed();
                                return;
                            }
                            case 6: {
                                AerServLog.v(RhythmOneSdkInterstitialAdapter.access$600(), "Rhythm One AdClickThru");
                                if (RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0) == null) break;
                                RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0).onAdClicked();
                                return;
                            }
                            case 5: {
                                AerServLog.v(RhythmOneSdkInterstitialAdapter.access$600(), "Rhythm One AdVideoComplete");
                                if (RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0) == null) break;
                                RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0).onVideoComplete();
                                return;
                            }
                            case 4: {
                                AerServLog.v(RhythmOneSdkInterstitialAdapter.access$600(), "Rhythm One AdVideoStart");
                                if (RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0) == null) break;
                                RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0).onVideoStart();
                                return;
                            }
                            case 3: {
                                AerServLog.v(RhythmOneSdkInterstitialAdapter.access$600(), "Rhythm One AdImpression");
                                RhythmOneSdkInterstitialAdapter.access$102(this.this$1.this$0, bl);
                                if (RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0) == null) break;
                                RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0).onAdImpression();
                                return;
                            }
                            case 2: {
                                String string = hashMap == null ? "Unknown" : (String)hashMap.get((Object)"errorCode");
                                String string2 = RhythmOneSdkInterstitialAdapter.access$600();
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Rhythm One AdError: ");
                                stringBuilder.append(string);
                                AerServLog.v(string2, stringBuilder.toString());
                                if ("AD_ALREADY_EXISTS".equals((Object)string)) {
                                    RhythmOneSdkInterstitialAdapter.access$002(this.this$1.this$0, bl);
                                } else {
                                    if ("NETWORK_ERROR".equals((Object)string) || "AD_REQUEST_TIMEOUT_ERROR".equals((Object)string) || "AD_LOADED_TIMEOUT_ERROR".equals((Object)string)) {
                                        RhythmOneSdkInterstitialAdapter.access$202(this.this$1.this$0, true);
                                    }
                                    RhythmOneSdkInterstitialAdapter.access$002(this.this$1.this$0, false);
                                }
                                if (!Boolean.TRUE.equals((Object)RhythmOneSdkInterstitialAdapter.access$100(this.this$1.this$0)) || RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0) == null) break;
                                RhythmOneSdkInterstitialAdapter.access$700(this.this$1.this$0).onAdDismissed();
                                return;
                            }
                            case 1: {
                                AerServLog.v(RhythmOneSdkInterstitialAdapter.access$600(), "Rhythm One AdLoaded");
                                RhythmOneSdkInterstitialAdapter.access$002(this.this$1.this$0, bl);
                            }
                        }
                    }
                });
                RhythmOneSdkInterstitialAdapter.access$802(this.this$0, new RhythmOneAd((android.content.Context)this.val$activity));
                com.rhythmone.ad.sdk.RhythmEvent[] arrrhythmEvent = com.rhythmone.ad.sdk.RhythmEvent.values();
                int n3 = arrrhythmEvent.length;
                while (n2 < n3) {
                    com.rhythmone.ad.sdk.RhythmEvent rhythmEvent = arrrhythmEvent[n2];
                    RhythmOneSdkInterstitialAdapter.access$800(this.this$0).addRhythmEventListener(rhythmEvent, RhythmOneSdkInterstitialAdapter.access$500(this.this$0));
                    ++n2;
                }
                RhythmOneSdkInterstitialAdapter.access$800(this.this$0).initAd(hashMap);
            }
        });
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.adShown = null;
        this.listener = adapterListener;
        this.activity = activity;
        activity.runOnUiThread(new Runnable(this){
            final /* synthetic */ RhythmOneSdkInterstitialAdapter this$0;
            {
                this.this$0 = rhythmOneSdkInterstitialAdapter;
            }

            public void run() {
                RhythmOneSdkInterstitialAdapter.access$800(this.this$0).startAd();
            }
        });
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }
}

