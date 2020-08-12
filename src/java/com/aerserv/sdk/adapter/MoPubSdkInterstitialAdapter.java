/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  com.mopub.mobileads.MoPubErrorCode
 *  com.mopub.mobileads.MoPubInterstitial
 *  com.mopub.mobileads.MoPubInterstitial$InterstitialAdListener
 *  java.lang.Boolean
 *  java.lang.CharSequence
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
import android.text.TextUtils;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.adapter.MoPubSdkInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class MoPubSdkInterstitialAdapter
extends Adapter
implements MoPubInterstitial.InterstitialAdListener {
    private static final String AD_UNIT_ID = "adUnit";
    private static final String LOG_TAG = "MoPubSdkInterstitialAdapter";
    private static final String MOPUB_AD_UNIT_ID = "MoPubAdUnit";
    private static final Map<MultiKey, MoPubSdkInterstitialAdapter> instanceMap = new HashMap();
    private Boolean adLoaded = null;
    private Boolean adShown = null;
    private AdapterListener adapterListener = null;
    private MoPubInterstitial moPubInterstitial = null;
    private MultiKey multiKey = null;

    private MoPubSdkInterstitialAdapter(MultiKey multiKey) {
        this.multiKey = multiKey;
    }

    static /* synthetic */ MoPubInterstitial access$000(MoPubSdkInterstitialAdapter moPubSdkInterstitialAdapter) {
        return moPubSdkInterstitialAdapter.moPubInterstitial;
    }

    static /* synthetic */ MoPubInterstitial access$002(MoPubSdkInterstitialAdapter moPubSdkInterstitialAdapter, MoPubInterstitial moPubInterstitial) {
        moPubSdkInterstitialAdapter.moPubInterstitial = moPubInterstitial;
        return moPubInterstitial;
    }

    static /* synthetic */ String access$100() {
        return LOG_TAG;
    }

    static /* synthetic */ Boolean access$202(MoPubSdkInterstitialAdapter moPubSdkInterstitialAdapter, Boolean bl) {
        moPubSdkInterstitialAdapter.adLoaded = bl;
        return bl;
    }

    private static boolean checkDependencies() {
        if (!VersionUtils.checkVersion(16)) {
            AerServLog.i(LOG_TAG, "Cannot use MoPub adapter because the adapter needs Jelly Bean or later");
            return false;
        }
        if (!ReflectionUtils.canFindClass("com.mopub.mobileads.MoPubInterstitial")) {
            AerServLog.i(LOG_TAG, "Cannot use MoPub adapter because MoPub SDK was not included, or Proguard was not configured properly");
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
        Map<MultiKey, MoPubSdkInterstitialAdapter> map;
        if (!MoPubSdkInterstitialAdapter.checkDependencies()) {
            AerServLog.i(LOG_TAG, "Failed to get instance for MoPub SDK.");
            return null;
        }
        String string2 = jSONObject.optString(AD_UNIT_ID, jSONObject.optString(MOPUB_AD_UNIT_ID));
        if (TextUtils.isEmpty((CharSequence)string2)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because ad unit ID is empty.");
            return null;
        }
        Map<MultiKey, MoPubSdkInterstitialAdapter> map2 = map = instanceMap;
        synchronized (map2) {
            MultiKey multiKey = new MultiKey(string, string2);
            MoPubSdkInterstitialAdapter moPubSdkInterstitialAdapter = (MoPubSdkInterstitialAdapter)instanceMap.get((Object)multiKey);
            if (moPubSdkInterstitialAdapter == null) {
                moPubSdkInterstitialAdapter = new MoPubSdkInterstitialAdapter(multiKey);
                instanceMap.put((Object)multiKey, (Object)moPubSdkInterstitialAdapter);
            }
            AerServLog.v(LOG_TAG, "Successfully retrieved an instance of MoPub adapter.");
            return moPubSdkInterstitialAdapter;
        }
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
    }

    @Override
    public void cleanup(Activity activity) {
        AerServLog.v(LOG_TAG, "MoPub ad destroyed.");
        if (this.moPubInterstitial != null) {
            if (activity != null) {
                activity.runOnUiThread(new Runnable(this){
                    final /* synthetic */ MoPubSdkInterstitialAdapter this$0;
                    {
                        this.this$0 = moPubSdkInterstitialAdapter;
                    }

                    public void run() {
                        if (MoPubSdkInterstitialAdapter.access$000(this.this$0) != null) {
                            try {
                                MoPubSdkInterstitialAdapter.access$000(this.this$0).destroy();
                            }
                            catch (java.lang.Exception exception) {
                                AerServLog.i(MoPubSdkInterstitialAdapter.access$100(), exception.getMessage());
                            }
                            MoPubSdkInterstitialAdapter.access$002(this.this$0, null);
                        }
                    }
                });
            } else {
                this.moPubInterstitial = null;
            }
        }
        this.adapterListener = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        AerServLog.v(LOG_TAG, "Checking if partner has ad.");
        MoPubInterstitial moPubInterstitial = this.moPubInterstitial;
        return moPubInterstitial != null && moPubInterstitial.isReady();
    }

    @Override
    public boolean hasPartnerAdLoadFailedDueToConnectionError() {
        return false;
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
        AerServLog.v(LOG_TAG, "Loading MoPub interstitial ad.");
        this.adLoaded = null;
        this.adShown = null;
        activity.runOnUiThread(new Runnable(this, activity, jSONObject.optString(AD_UNIT_ID, jSONObject.optString(MOPUB_AD_UNIT_ID))){
            final /* synthetic */ MoPubSdkInterstitialAdapter this$0;
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ String val$adUnitId;
            {
                this.this$0 = moPubSdkInterstitialAdapter;
                this.val$activity = activity;
                this.val$adUnitId = string;
            }

            public void run() {
                try {
                    if (MoPubSdkInterstitialAdapter.access$000(this.this$0) == null) {
                        AerServLog.v(MoPubSdkInterstitialAdapter.access$100(), "MoPub ad was created.");
                        MoPubSdkInterstitialAdapter.access$002(this.this$0, new MoPubInterstitial(this.val$activity, this.val$adUnitId));
                        MoPubSdkInterstitialAdapter.access$000(this.this$0).setInterstitialAdListener((MoPubInterstitial.InterstitialAdListener)this.this$0);
                    }
                    AerServLog.v(MoPubSdkInterstitialAdapter.access$100(), "Trying to load MoPub interstitial Ad.");
                    MoPubSdkInterstitialAdapter.access$000(this.this$0).load();
                    return;
                }
                catch (java.lang.Exception exception) {
                    AerServLog.i(MoPubSdkInterstitialAdapter.access$100(), "Error creating MoPub interstitial.", exception);
                    MoPubSdkInterstitialAdapter.access$202(this.this$0, false);
                    return;
                }
            }
        });
    }

    public void onInterstitialClicked(MoPubInterstitial moPubInterstitial) {
        AerServLog.v(LOG_TAG, "MoPub ad clicked");
        AdapterListener adapterListener = this.adapterListener;
        if (adapterListener != null) {
            adapterListener.onAdClicked();
        }
    }

    public void onInterstitialDismissed(MoPubInterstitial moPubInterstitial) {
        AerServLog.v(LOG_TAG, "MoPub ad dismissed");
        AdapterListener adapterListener = this.adapterListener;
        if (adapterListener != null) {
            adapterListener.onAdDismissed();
        }
    }

    public void onInterstitialFailed(MoPubInterstitial moPubInterstitial, MoPubErrorCode moPubErrorCode) {
        Boolean bl;
        String string = LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MoPub ad failed: ");
        stringBuilder.append(moPubErrorCode.toString());
        AerServLog.v(string, stringBuilder.toString());
        this.adLoaded = bl = Boolean.valueOf((boolean)false);
        this.adShown = bl;
    }

    public void onInterstitialLoaded(MoPubInterstitial moPubInterstitial) {
        AerServLog.v(LOG_TAG, "MoPub ad loaded");
        this.adLoaded = true;
    }

    public void onInterstitialShown(MoPubInterstitial moPubInterstitial) {
        AerServLog.v(LOG_TAG, "MoPub ad shown");
        AdapterListener adapterListener = this.adapterListener;
        if (adapterListener != null) {
            adapterListener.onAdImpression();
        }
        this.adShown = true;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void removeInstance() {
        Map<MultiKey, MoPubSdkInterstitialAdapter> map;
        Map<MultiKey, MoPubSdkInterstitialAdapter> map2 = map = instanceMap;
        synchronized (map2) {
            if (instanceMap.containsKey((Object)this.multiKey)) {
                instanceMap.remove((Object)this.multiKey);
            }
            return;
        }
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        AerServLog.v(LOG_TAG, "Trying to show MoPub ad.");
        this.adapterListener = adapterListener;
        MoPubInterstitial moPubInterstitial = this.moPubInterstitial;
        if (moPubInterstitial != null && moPubInterstitial.isReady()) {
            AerServLog.v(LOG_TAG, "Showing MoPub interstitial ad.");
            this.moPubInterstitial.show();
            return;
        }
        AerServLog.i(LOG_TAG, "MoPub interstitial ad was not ready to show.");
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }
}

