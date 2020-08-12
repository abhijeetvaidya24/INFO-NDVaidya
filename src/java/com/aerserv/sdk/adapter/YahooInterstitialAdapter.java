/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  com.flurry.android.FlurryAgent
 *  com.flurry.android.FlurryAgent$Builder
 *  com.flurry.android.ads.FlurryAdInterstitial
 *  com.flurry.android.ads.FlurryAdInterstitialListener
 *  com.flurry.android.ads.FlurryAdTargeting
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
import android.content.Context;
import android.text.TextUtils;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.adapter.YahooInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.flurry.android.FlurryAgent;
import com.flurry.android.ads.FlurryAdInterstitial;
import com.flurry.android.ads.FlurryAdInterstitialListener;
import com.flurry.android.ads.FlurryAdTargeting;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class YahooInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "YahooInterstitialAdapter";
    private static final String SERVER_AD_SPACE = "adSpace";
    private static final String SERVER_API_KEY = "apiKey";
    private static final String SERVER_INIT_API_KEY = "apiKey";
    private static final String YAHOO_SERVER_AD_SPACE = "YahooAdSpace";
    private static final String YAHOO_SERVER_API_KEY = "YahooApiKey";
    private static String apiKey;
    private static final Map<MultiKey, YahooInterstitialAdapter> instanceMap;
    private Activity activity = null;
    private Boolean adLoaded = null;
    private boolean adLoadedFailedDueToConectionError = false;
    private Boolean adShown = null;
    private String adSpace = null;
    private AdapterListener adapterListener = null;
    private FlurryAdInterstitial flurryAdInterstitial = null;
    private FlurryAdInterstitialListener flurryAdInterstitialListener = new FlurryAdInterstitialListener(this){
        final /* synthetic */ YahooInterstitialAdapter this$0;
        {
            this.this$0 = yahooInterstitialAdapter;
        }

        public void onAppExit(FlurryAdInterstitial flurryAdInterstitial) {
            AerServLog.v(YahooInterstitialAdapter.access$000(), "Flurry ad exited.");
        }

        public void onClicked(FlurryAdInterstitial flurryAdInterstitial) {
            AerServLog.v(YahooInterstitialAdapter.access$000(), "Flurry ad clicked.");
            if (YahooInterstitialAdapter.access$200(this.this$0) != null) {
                YahooInterstitialAdapter.access$200(this.this$0).onAdClicked();
            }
        }

        public void onClose(FlurryAdInterstitial flurryAdInterstitial) {
            AerServLog.v(YahooInterstitialAdapter.access$000(), "Flurry ad closed.");
            if (YahooInterstitialAdapter.access$200(this.this$0) != null) {
                YahooInterstitialAdapter.access$200(this.this$0).onAdDismissed();
            }
        }

        public void onDisplay(FlurryAdInterstitial flurryAdInterstitial) {
            AerServLog.v(YahooInterstitialAdapter.access$000(), "Flurry ad displayed.");
            if (YahooInterstitialAdapter.access$200(this.this$0) != null) {
                YahooInterstitialAdapter.access$200(this.this$0).onAdImpression();
            }
            YahooInterstitialAdapter.access$302(this.this$0, true);
        }

        public void onError(FlurryAdInterstitial flurryAdInterstitial, com.flurry.android.ads.FlurryAdErrorType flurryAdErrorType, int n2) {
            String string;
            block12 : {
                block8 : {
                    block9 : {
                        block10 : {
                            block11 : {
                                if (n2 == 1) break block8;
                                if (n2 == 2) break block9;
                                if (n2 == 3) break block10;
                                if (n2 == 4) break block11;
                                switch (n2) {
                                    default: {
                                        YahooInterstitialAdapter.access$502(this.this$0, true);
                                        string = "Unknown error";
                                        break block12;
                                    }
                                    case 22: {
                                        string = "Device locked";
                                        break block12;
                                    }
                                    case 21: {
                                        YahooInterstitialAdapter.access$502(this.this$0, true);
                                        string = "Incorrect class for ad space";
                                        break block12;
                                    }
                                    case 20: {
                                        string = "Ad was unfilled";
                                        break block12;
                                    }
                                    case 19: {
                                        YahooInterstitialAdapter.access$502(this.this$0, true);
                                        string = "No view group";
                                        break block12;
                                    }
                                    case 18: {
                                        YahooInterstitialAdapter.access$502(this.this$0, true);
                                        string = "Wrong orientation";
                                        break block12;
                                    }
                                    case 17: {
                                        AerServLog.i(YahooInterstitialAdapter.access$000(), "Flurry ad not ready.");
                                        YahooInterstitialAdapter.access$502(this.this$0, true);
                                        return;
                                    }
                                }
                            }
                            YahooInterstitialAdapter.access$502(this.this$0, true);
                            string = "Invalid ad unit";
                            break block12;
                        }
                        YahooInterstitialAdapter.access$502(this.this$0, true);
                        string = "No context";
                        break block12;
                    }
                    YahooInterstitialAdapter.access$502(this.this$0, true);
                    string = "Missing ad controller";
                    break block12;
                }
                YahooInterstitialAdapter.access$502(this.this$0, true);
                string = "No network connectivity";
            }
            YahooInterstitialAdapter.access$102(this.this$0, false);
            YahooInterstitialAdapter.access$302(this.this$0, false);
            String string2 = YahooInterstitialAdapter.access$000();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Flurry ad failed with type ");
            stringBuilder.append(flurryAdErrorType.name());
            stringBuilder.append(" and error code ");
            stringBuilder.append(string);
            AerServLog.i(string2, stringBuilder.toString());
            YahooInterstitialAdapter.access$600(this.this$0);
        }

        public void onFetched(FlurryAdInterstitial flurryAdInterstitial) {
            AerServLog.v(YahooInterstitialAdapter.access$000(), "Flurry ad Loaded.");
            YahooInterstitialAdapter.access$102(this.this$0, true);
        }

        public void onRendered(FlurryAdInterstitial flurryAdInterstitial) {
            AerServLog.v(YahooInterstitialAdapter.access$000(), "Flurry ad rendered.");
        }

        public void onVideoCompleted(FlurryAdInterstitial flurryAdInterstitial) {
            AerServLog.v(YahooInterstitialAdapter.access$000(), "Flurry ad video completed.");
            if (!YahooInterstitialAdapter.access$400(this.this$0)) {
                YahooInterstitialAdapter.access$402(this.this$0, true);
                if (YahooInterstitialAdapter.access$200(this.this$0) != null) {
                    YahooInterstitialAdapter.access$200(this.this$0).onVideoComplete();
                }
            }
        }
    };
    private MultiKey key = null;
    private boolean videoCompletedFired = false;

    static {
        instanceMap = new HashMap();
        apiKey = null;
    }

    private YahooInterstitialAdapter(MultiKey multiKey, String string) {
        this.adSpace = string;
        this.key = multiKey;
    }

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ Boolean access$102(YahooInterstitialAdapter yahooInterstitialAdapter, Boolean bl) {
        yahooInterstitialAdapter.adLoaded = bl;
        return bl;
    }

    static /* synthetic */ AdapterListener access$200(YahooInterstitialAdapter yahooInterstitialAdapter) {
        return yahooInterstitialAdapter.adapterListener;
    }

    static /* synthetic */ Boolean access$302(YahooInterstitialAdapter yahooInterstitialAdapter, Boolean bl) {
        yahooInterstitialAdapter.adShown = bl;
        return bl;
    }

    static /* synthetic */ boolean access$400(YahooInterstitialAdapter yahooInterstitialAdapter) {
        return yahooInterstitialAdapter.videoCompletedFired;
    }

    static /* synthetic */ boolean access$402(YahooInterstitialAdapter yahooInterstitialAdapter, boolean bl) {
        yahooInterstitialAdapter.videoCompletedFired = bl;
        return bl;
    }

    static /* synthetic */ boolean access$502(YahooInterstitialAdapter yahooInterstitialAdapter, boolean bl) {
        yahooInterstitialAdapter.adLoadedFailedDueToConectionError = bl;
        return bl;
    }

    static /* synthetic */ void access$600(YahooInterstitialAdapter yahooInterstitialAdapter) {
        yahooInterstitialAdapter.cleanupFlurryAd();
    }

    private static boolean checkDependencies() {
        if (!VersionUtils.checkVersion(10)) {
            AerServLog.i(LOG_TAG, "Yahoo SDK requires minimum version of Gingerbread MR1.");
            return false;
        }
        if (!ReflectionUtils.canFindClass("com.flurry.android.ads.FlurryAdInterstitial")) {
            AerServLog.i(LOG_TAG, "Missing Yahoo SDK libraries, or proguard was configured incorrectly.");
            return false;
        }
        return true;
    }

    private void cleanupFlurryAd() {
        if (!VersionUtils.checkVersion(14)) {
            FlurryAgent.onEndSession((Context)this.activity);
        }
        if (this.flurryAdInterstitial != null) {
            AerServLog.v(LOG_TAG, "Destroying old flurry ad.");
            this.flurryAdInterstitial.destroy();
            this.flurryAdInterstitial = null;
            this.activity = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        if (!YahooInterstitialAdapter.checkDependencies()) {
            AerServLog.i(LOG_TAG, "Failed to retrieve adapter for Yahoo SDK.");
            return null;
        }
        String string2 = jSONObject.optString(SERVER_AD_SPACE, jSONObject.optString(YAHOO_SERVER_AD_SPACE));
        String string3 = jSONObject.optString("apiKey", jSONObject.optString(YAHOO_SERVER_API_KEY));
        if (!TextUtils.isEmpty((CharSequence)string2) && !TextUtils.isEmpty((CharSequence)string3)) {
            Map<MultiKey, YahooInterstitialAdapter> map;
            String string4 = apiKey;
            if (string4 != null && !string3.equals((Object)string4)) {
                AerServLog.i(LOG_TAG, "Cannot retrieve adapter for Yahoo SDK. API key is different from initialization.");
                return null;
            }
            Map<MultiKey, YahooInterstitialAdapter> map2 = map = instanceMap;
            synchronized (map2) {
                MultiKey multiKey = new MultiKey(string, string2);
                YahooInterstitialAdapter yahooInterstitialAdapter = (YahooInterstitialAdapter)instanceMap.get((Object)multiKey);
                if (yahooInterstitialAdapter == null) {
                    yahooInterstitialAdapter = new YahooInterstitialAdapter(multiKey, string2);
                    instanceMap.put((Object)multiKey, (Object)yahooInterstitialAdapter);
                }
                AerServLog.v(LOG_TAG, "Successfully retrieved adapter for Yahoo SDK.");
                return yahooInterstitialAdapter;
            }
        }
        AerServLog.i(LOG_TAG, "Cannot retrieve adapter for Yahoo SDK. Missing ad space or api key.");
        return null;
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
        if (!YahooInterstitialAdapter.checkDependencies()) {
            AerServLog.i(LOG_TAG, "Failed to initialize Yahoo SDK, missing dependencies.");
            return;
        }
        if (jSONArray != null && jSONArray.length() >= 1) {
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                JSONObject jSONObject = jSONArray.optJSONObject(i2);
                if (jSONObject == null || TextUtils.isEmpty((CharSequence)jSONObject.toString()) || TextUtils.isEmpty((CharSequence)jSONObject.optString("apiKey", jSONObject.optString(YAHOO_SERVER_API_KEY)))) continue;
                AerServLog.v(LOG_TAG, "Retrieved API Key.");
                YahooInterstitialAdapter.initializeYahooInterstitialAdapter(activity, jSONObject.optString("apiKey", jSONObject.optString(YAHOO_SERVER_API_KEY)));
                AerServLog.v(LOG_TAG, "Successfully initialized interstitial adapter for Yahoo.");
                return;
            }
            AerServLog.i(LOG_TAG, "Failed to initialize interstitial adapter for Yahoo.");
            return;
        }
        AerServLog.i(LOG_TAG, "Failed to initialize Yahoo SDK, missing credentials.");
    }

    private static void initializeYahooInterstitialAdapter(Activity activity, String string) {
        AerServLog.v(LOG_TAG, "Initializing Yahoo Interstitial Adapter.");
        if (apiKey != null) {
            AerServLog.i(LOG_TAG, "Initialized Yahoo Interstitial Adapter already.");
            return;
        }
        apiKey = string;
        if (VersionUtils.checkVersion(14)) {
            new FlurryAgent.Builder().build((Context)activity, string);
            return;
        }
        FlurryAgent.init((Context)activity, (String)string);
    }

    @Override
    public void cleanup(Activity activity) {
        this.cleanupFlurryAd();
        this.adapterListener = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        FlurryAdInterstitial flurryAdInterstitial = this.flurryAdInterstitial;
        return flurryAdInterstitial != null && flurryAdInterstitial.isReady();
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    @Override
    public void loadPartnerAd(Activity activity, JSONObject jSONObject, boolean bl, boolean bl2) {
        Map<MultiKey, YahooInterstitialAdapter> map;
        String string = jSONObject.optString("apiKey", jSONObject.optString(YAHOO_SERVER_API_KEY));
        Map<MultiKey, YahooInterstitialAdapter> map2 = map = instanceMap;
        // MONITORENTER : map2
        if (apiKey == null) {
            YahooInterstitialAdapter.initializeYahooInterstitialAdapter(activity, string);
        }
        // MONITOREXIT : map2
        if (!string.equals((Object)apiKey)) {
            Map<MultiKey, YahooInterstitialAdapter> map3;
            AerServLog.i(LOG_TAG, "Cannot retrieve adapter for Yahoo SDK since the api key was different from initialization. Removing self from map.");
            Map<MultiKey, YahooInterstitialAdapter> map4 = map3 = instanceMap;
            // MONITORENTER : map4
            if (instanceMap.containsKey((Object)this.key)) {
                instanceMap.remove((Object)this.key);
            }
            // MONITOREXIT : map4
            this.adLoaded = false;
            return;
        }
        this.adLoaded = null;
        this.adShown = null;
        this.adLoadedFailedDueToConectionError = false;
        this.videoCompletedFired = false;
        this.activity = activity;
        if (this.flurryAdInterstitial != null) {
            AerServLog.i(LOG_TAG, "Cleaning up flurry ad.");
            this.cleanupFlurryAd();
        }
        AerServLog.v(LOG_TAG, "Creating new flurry ad.");
        this.flurryAdInterstitial = new FlurryAdInterstitial((Context)activity, this.adSpace);
        this.flurryAdInterstitial.setListener(this.flurryAdInterstitialListener);
        if (!VersionUtils.checkVersion(14)) {
            FlurryAgent.onStartSession((Context)activity, (String)string);
        }
        FlurryAdTargeting flurryAdTargeting = new FlurryAdTargeting();
        flurryAdTargeting.setEnableTestAds(bl2);
        String string2 = LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TestMode is set to: ");
        stringBuilder.append(flurryAdTargeting.getEnableTestAds());
        AerServLog.v(string2, stringBuilder.toString());
        this.flurryAdInterstitial.setTargeting(flurryAdTargeting);
        this.flurryAdInterstitial.fetchAd();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void removeInstance() {
        Map<MultiKey, YahooInterstitialAdapter> map;
        Map<MultiKey, YahooInterstitialAdapter> map2 = map = instanceMap;
        synchronized (map2) {
            if (instanceMap.containsKey((Object)this.key)) {
                instanceMap.remove((Object)this.key);
            }
            return;
        }
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.adapterListener = adapterListener;
        FlurryAdInterstitial flurryAdInterstitial = this.flurryAdInterstitial;
        if (flurryAdInterstitial != null && flurryAdInterstitial.isReady()) {
            this.flurryAdInterstitial.displayAd();
            return;
        }
        AerServLog.i(LOG_TAG, "Flurry ad was not ready.");
        this.adShown = false;
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }
}

