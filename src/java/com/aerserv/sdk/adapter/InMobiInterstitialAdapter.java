/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  com.inmobi.ads.InMobiInterstitial
 *  com.inmobi.ads.InMobiInterstitial$InterstitialAdListener2
 *  com.inmobi.sdk.InMobiSdk
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
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
import com.aerserv.sdk.adapter.InMobiInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.sdk.InMobiSdk;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class InMobiInterstitialAdapter
extends Adapter {
    private static final String ACCOUNT_ID = "accountId";
    private static final String LOG_TAG = "InMobiInterstitialAdapter";
    private static final String PLACEMENT_ID = "placementId";
    private static final Map<MultiKey, InMobiInterstitialAdapter> instanceMap = new HashMap();
    private Boolean adLoaded = null;
    private boolean adLoadedFailedDueToConectionError = false;
    private Boolean adShown = null;
    private AdapterListener adapterListener;
    private Boolean isRewarded = false;
    private InMobiInterstitial mInterstitialAd;
    private final MultiKey multiKey;

    public InMobiInterstitialAdapter(MultiKey multiKey) {
        this.multiKey = multiKey;
    }

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ boolean access$102(InMobiInterstitialAdapter inMobiInterstitialAdapter, boolean bl) {
        inMobiInterstitialAdapter.adLoadedFailedDueToConectionError = bl;
        return bl;
    }

    static /* synthetic */ Boolean access$202(InMobiInterstitialAdapter inMobiInterstitialAdapter, Boolean bl) {
        inMobiInterstitialAdapter.adLoaded = bl;
        return bl;
    }

    static /* synthetic */ AdapterListener access$300(InMobiInterstitialAdapter inMobiInterstitialAdapter) {
        return inMobiInterstitialAdapter.adapterListener;
    }

    static /* synthetic */ Boolean access$402(InMobiInterstitialAdapter inMobiInterstitialAdapter, Boolean bl) {
        inMobiInterstitialAdapter.adShown = bl;
        return bl;
    }

    static /* synthetic */ InMobiInterstitial access$500(InMobiInterstitialAdapter inMobiInterstitialAdapter) {
        return inMobiInterstitialAdapter.mInterstitialAd;
    }

    private static boolean checkDependencies() {
        if (!ReflectionUtils.canFindClass("com.inmobi.ads.InMobiInterstitial")) {
            AerServLog.i(LOG_TAG, "Cannot use InMobi adapter because InMobi SDK was not included, or Proguard was not configured properly");
            return false;
        }
        return true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        if (!InMobiInterstitialAdapter.checkDependencies()) {
            AerServLog.i(LOG_TAG, "Failed to get instance for InMobi SDK.");
            return null;
        }
        String string2 = jSONObject.optString(PLACEMENT_ID);
        if (!TextUtils.isEmpty((CharSequence)string2) && !TextUtils.isEmpty((CharSequence)string2)) {
            Map<MultiKey, InMobiInterstitialAdapter> map;
            Map<MultiKey, InMobiInterstitialAdapter> map2 = map = instanceMap;
            synchronized (map2) {
                MultiKey multiKey = new MultiKey(string2);
                InMobiInterstitialAdapter inMobiInterstitialAdapter = (InMobiInterstitialAdapter)instanceMap.get((Object)multiKey);
                if (inMobiInterstitialAdapter == null) {
                    inMobiInterstitialAdapter = new InMobiInterstitialAdapter(multiKey);
                    instanceMap.put((Object)multiKey, (Object)inMobiInterstitialAdapter);
                }
                AerServLog.v(LOG_TAG, "Successfully retrieved an instance of InMobi adapter.");
                return inMobiInterstitialAdapter;
            }
        }
        AerServLog.i(LOG_TAG, "Cannot get instance of adapter because placement id is empty.");
        return null;
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
        if (!InMobiInterstitialAdapter.checkDependencies()) {
            AerServLog.v(LOG_TAG, "Failed to initialize InMobi adapter because InMobi SDK was not included, or Proguard was not configured properly");
            return;
        }
        if (jSONArray != null && jSONArray.length() >= 1) {
            JSONObject jSONObject = jSONArray.optJSONObject(0);
            if (jSONObject != null && !TextUtils.isEmpty((CharSequence)jSONObject.optString(ACCOUNT_ID))) {
                AerServLog.v(LOG_TAG, "Initializing InMobi SDK");
                InMobiSdk.init((Context)activity, (String)jSONObject.optString(ACCOUNT_ID));
                return;
            }
            AerServLog.v(LOG_TAG, "Could not initialize InMobi SDK because accountId is empty");
            return;
        }
        AerServLog.v(LOG_TAG, "Could not initialize InMobi SDK because credentials list is empty");
    }

    @Override
    public void cleanup(Activity activity) {
        this.mInterstitialAd = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        InMobiInterstitial inMobiInterstitial = this.mInterstitialAd;
        return inMobiInterstitial != null && inMobiInterstitial.isReady();
    }

    @Override
    public boolean hasPartnerAdLoadFailedDueToConnectionError() {
        return this.adLoadedFailedDueToConectionError;
    }

    @Override
    public Boolean hasPartnerAdLoaded(boolean bl) {
        Boolean bl2 = this.adLoaded;
        if (bl2 != null) {
            if (bl2.booleanValue()) {
                boolean bl3 = this.hasAd(bl);
                Boolean bl4 = null;
                if (bl3) {
                    bl4 = Boolean.TRUE;
                }
                return bl4;
            }
            return Boolean.FALSE;
        }
        return null;
    }

    @Override
    public Boolean hasPartnerAdShown(boolean bl) {
        return this.adShown;
    }

    @Override
    public void loadPartnerAd(Activity activity, JSONObject jSONObject, boolean bl, boolean bl2) {
        AerServLog.v(LOG_TAG, "Loading InMobi ad");
        this.adLoaded = null;
        this.adShown = null;
        this.isRewarded = bl;
        this.adLoadedFailedDueToConectionError = false;
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"tp", (Object)"c_aerserv");
        hashMap.put((Object)"tp_Ver", (Object)"3.1.1");
        String string = jSONObject.optString(PLACEMENT_ID);
        if (TextUtils.isEmpty((CharSequence)string)) {
            this.adLoaded = false;
            return;
        }
        this.mInterstitialAd = new InMobiInterstitial(activity, Long.parseLong((String)string), new InMobiInterstitial.InterstitialAdListener2(this){
            final /* synthetic */ InMobiInterstitialAdapter this$0;
            {
                this.this$0 = inMobiInterstitialAdapter;
            }

            public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {
                AerServLog.v(InMobiInterstitialAdapter.access$000(), "InMobi ad dismissed");
                if (InMobiInterstitialAdapter.access$300(this.this$0) != null) {
                    InMobiInterstitialAdapter.access$300(this.this$0).onAdDismissed();
                }
            }

            public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {
                AerServLog.v(InMobiInterstitialAdapter.access$000(), "InMobi ad display failed");
            }

            public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {
                AerServLog.v(InMobiInterstitialAdapter.access$000(), "InMobi ad displayed");
                InMobiInterstitialAdapter.access$402(this.this$0, true);
                if (InMobiInterstitialAdapter.access$300(this.this$0) != null) {
                    InMobiInterstitialAdapter.access$300(this.this$0).onAdImpression();
                }
            }

            public void onAdInteraction(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
                AerServLog.v(InMobiInterstitialAdapter.access$000(), "InMobi ad clicked");
                if (InMobiInterstitialAdapter.access$300(this.this$0) != null) {
                    InMobiInterstitialAdapter.access$300(this.this$0).onAdClicked();
                }
            }

            public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, com.inmobi.ads.InMobiAdRequestStatus inMobiAdRequestStatus) {
                String string = InMobiInterstitialAdapter.access$000();
                java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                stringBuilder.append("InMobi ad failed to load : ");
                stringBuilder.append(inMobiAdRequestStatus.getMessage());
                AerServLog.v(string, stringBuilder.toString());
                if (inMobiAdRequestStatus.getStatusCode() == com.inmobi.ads.InMobiAdRequestStatus$StatusCode.NETWORK_UNREACHABLE || inMobiAdRequestStatus.getStatusCode() == com.inmobi.ads.InMobiAdRequestStatus$StatusCode.REQUEST_TIMED_OUT) {
                    InMobiInterstitialAdapter.access$102(this.this$0, true);
                }
                InMobiInterstitialAdapter.access$202(this.this$0, false);
            }

            public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
                AerServLog.v(InMobiInterstitialAdapter.access$000(), "InMobi ad loaded");
                InMobiInterstitialAdapter.access$202(this.this$0, true);
            }

            public void onAdReceived(InMobiInterstitial inMobiInterstitial) {
            }

            public void onAdRewardActionCompleted(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {
                AerServLog.v(InMobiInterstitialAdapter.access$000(), "InMobi ad: Reward action completed");
                (java.util.Map$Entry)map.entrySet().iterator().next();
                if (InMobiInterstitialAdapter.access$300(this.this$0) != null) {
                    InMobiInterstitialAdapter.access$300(this.this$0).onRewarded("", 0.0);
                }
            }

            public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {
                AerServLog.v(InMobiInterstitialAdapter.access$000(), "InMobi ad will display");
            }

            public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {
                AerServLog.v(InMobiInterstitialAdapter.access$000(), "InMobi ad : User left application");
            }
        });
        activity.runOnUiThread(new Runnable(this, hashMap){
            final /* synthetic */ InMobiInterstitialAdapter this$0;
            final /* synthetic */ HashMap val$paramMap;
            {
                this.this$0 = inMobiInterstitialAdapter;
                this.val$paramMap = hashMap;
            }

            public void run() {
                InMobiInterstitialAdapter.access$500(this.this$0).setExtras((Map)this.val$paramMap);
                InMobiInterstitialAdapter.access$500(this.this$0).load();
            }
        });
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.adapterListener = adapterListener;
        AerServLog.v(LOG_TAG, "Trying to show InMobi Ad");
        activity.runOnUiThread(new Runnable(this){
            final /* synthetic */ InMobiInterstitialAdapter this$0;
            {
                this.this$0 = inMobiInterstitialAdapter;
            }

            public void run() {
                if (InMobiInterstitialAdapter.access$500(this.this$0) != null && InMobiInterstitialAdapter.access$500(this.this$0).isReady()) {
                    AerServLog.v(InMobiInterstitialAdapter.access$000(), "Showing InMobi Ad");
                    InMobiInterstitialAdapter.access$500(this.this$0).show();
                    return;
                }
                AerServLog.v(InMobiInterstitialAdapter.access$000(), "InMobi Ad was not ready to be shown");
            }
        });
    }

    @Override
    public boolean supportsRewardedCallback() {
        return true;
    }
}

