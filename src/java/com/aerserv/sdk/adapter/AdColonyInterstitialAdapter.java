/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  com.adcolony.sdk.AdColony
 *  com.adcolony.sdk.AdColonyAdOptions
 *  com.adcolony.sdk.AdColonyInterstitial
 *  com.adcolony.sdk.AdColonyInterstitialListener
 *  com.adcolony.sdk.AdColonyReward
 *  com.adcolony.sdk.AdColonyRewardListener
 *  com.adcolony.sdk.AdColonyZone
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.text.TextUtils;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyReward;
import com.adcolony.sdk.AdColonyRewardListener;
import com.adcolony.sdk.AdColonyZone;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.aerserv.sdk.utils.VersionUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdColonyInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "AdColonyInterstitialAdapter";
    private static String appId;
    private static final Map<String, AdColonyInterstitialAdapter> instanceMap;
    private AdColonyInterstitial adColonyInterstitial = null;
    private AdColonyInterstitialListener adColonyInterstitialListener = new AdColonyInterstitialListener(){

        public void onClosed(AdColonyInterstitial adColonyInterstitial) {
            AerServLog.v(LOG_TAG, "AdColony onClosed()");
            if (AdColonyInterstitialAdapter.this.listener != null) {
                AdColonyInterstitialAdapter.this.listener.onVideoComplete();
                AdColonyInterstitialAdapter.this.listener.onAdDismissed();
            }
        }

        public void onOpened(AdColonyInterstitial adColonyInterstitial) {
            AerServLog.v(LOG_TAG, "AdColony onOpened()");
            AdColonyInterstitialAdapter.this.adShown = true;
            if (AdColonyInterstitialAdapter.this.listener != null) {
                AdColonyInterstitialAdapter.this.listener.onAdImpression();
                AdColonyInterstitialAdapter.this.listener.onVideoStart();
            }
        }

        public void onRequestFilled(AdColonyInterstitial adColonyInterstitial) {
            AerServLog.d(LOG_TAG, "AdColony onRequestFilled()");
            AdColonyInterstitialAdapter.this.adColonyInterstitial = adColonyInterstitial;
            AdColonyInterstitialAdapter.this.adLoaded = true;
        }

        public void onRequestNotFilled(AdColonyZone adColonyZone) {
            AerServLog.d(LOG_TAG, "AdColony onRequestNotFilled()");
            AdColonyInterstitialAdapter.this.adLoaded = false;
        }
    };
    private AdColonyRewardListener adColonyRewardListener = new AdColonyRewardListener(){

        public void onReward(AdColonyReward adColonyReward) {
            AerServLog.v(LOG_TAG, "AdColony onReward()");
            if (AdColonyInterstitialAdapter.this.listener != null) {
                AdColonyInterstitialAdapter.this.listener.onRewarded(adColonyReward.getRewardName(), (double)adColonyReward.getRewardAmount());
            }
        }
    };
    private Boolean adLoaded = null;
    private Boolean adShown = null;
    private AdapterListener listener = null;
    private String zoneId = null;

    static {
        instanceMap = new HashMap();
    }

    private AdColonyInterstitialAdapter(String string) {
        this.zoneId = string;
    }

    public static Adapter getInstance(String string, JSONObject jSONObject) {
        String string2;
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because the adapter needs Android Ice Cream Sandwich or later");
            return null;
        }
        if (!ReflectionUtils.canFindClass("com.adcolony.sdk.AdColony")) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because AdColony SDK was not included, or Proguard was not configured properly");
            return null;
        }
        String string3 = jSONObject.optString("appId", jSONObject.optString("AdColonyAppID"));
        if (TextUtils.isEmpty((CharSequence)string3)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because app ID is empty");
            return null;
        }
        if (!string3.equals((Object)appId)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because app ID is not the one used in initialization");
            return null;
        }
        JSONArray jSONArray = jSONObject.optJSONArray("zoneIds");
        if (jSONArray == null) {
            jSONArray = jSONObject.optJSONArray("AdColonyZoneIDs");
        }
        if (TextUtils.isEmpty((CharSequence)(string2 = jSONArray != null && jSONArray.length() > 0 ? jSONArray.optString(0) : ""))) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because zone ID is empty");
            return null;
        }
        if (instanceMap.get((Object)string2) == null) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because zone ID is not the one used initialization");
            return null;
        }
        return (Adapter)instanceMap.get((Object)string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot not initialize AdColony SDK because the adapter needs Android Ice Cream Sandwich or later");
            return;
        }
        if (!ReflectionUtils.canFindClass("com.adcolony.sdk.AdColony")) {
            AerServLog.i(LOG_TAG, "Cannot initialize AdColony SDK because its libraries were not included, or Proguard was not configured properly");
            return;
        }
        if (jSONArray == null || jSONArray.length() < 1) {
            AerServLog.i(LOG_TAG, "Cannot initialize AdColony SDK because credentials list is empty");
            return;
        }
        int n2 = 0;
        do {
            block17 : {
                JSONArray jSONArray2;
                block18 : {
                    if (n2 < jSONArray.length()) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(n2);
                            String string = jSONObject.optString("appId", jSONObject.optString("AdColonyAppID"));
                            if (TextUtils.isEmpty((CharSequence)string)) {
                                AerServLog.i(LOG_TAG, "App ID used to initialize AdColony is empty.  Skipping to next set of credentials.");
                                break block17;
                            }
                            if (appId == null) {
                                appId = string;
                            } else if (!appId.equals((Object)string)) {
                                AerServLog.i(LOG_TAG, "Cannot initialize AdColony using two different app IDs.  Skipping to next set of credentials.");
                                break block17;
                            }
                            jSONArray2 = jSONObject.optJSONArray("zoneIds");
                            if (jSONArray2 == null) {
                                jSONArray2 = jSONObject.optJSONArray("AdColonyZoneIDs");
                            }
                            break block18;
                        }
                        catch (JSONException jSONException) {
                            String string = LOG_TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Error reading credentials: ");
                            stringBuilder.append(jSONException.getMessage());
                            stringBuilder.append(".  Skipping to next set of credentials.");
                            AerServLog.i(string, stringBuilder.toString());
                            break block17;
                        }
                    }
                    if (TextUtils.isEmpty((CharSequence)appId)) {
                        AerServLog.i(LOG_TAG, "Cannot initialize AdColony SDK because app ID is empty");
                        return;
                    }
                    if (instanceMap.size() == 0) {
                        AerServLog.i(LOG_TAG, "Cannot initialize AdColony SDK because zone ID list is empty");
                        return;
                    }
                    Object[] arrobject = new String[instanceMap.keySet().size()];
                    String[] arrstring = (String[])instanceMap.keySet().toArray(arrobject);
                    AdColony.configure((Activity)activity, (String)appId, (String[])arrstring);
                    return;
                }
                if (jSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArray2.length(); ++i2) {
                        String string = jSONArray2.optString(i2);
                        if (TextUtils.isEmpty((CharSequence)string)) {
                            AerServLog.i(LOG_TAG, "Cannot initialize AdColony with empty zone.  Skipping to next set of credentials.");
                            continue;
                        }
                        instanceMap.put((Object)string, (Object)new AdColonyInterstitialAdapter(string));
                    }
                }
            }
            ++n2;
        } while (true);
    }

    private void loadIntersitialAd() {
        if (!AdColony.requestInterstitial((String)this.zoneId, (AdColonyInterstitialListener)this.adColonyInterstitialListener)) {
            AerServLog.i(LOG_TAG, "AdColony.requestInterstitial() returned false");
            this.adLoaded = false;
        }
    }

    private void loadRewardedAd() {
        AdColony.setRewardListener((AdColonyRewardListener)this.adColonyRewardListener);
        AdColonyAdOptions adColonyAdOptions = new AdColonyAdOptions().enableConfirmationDialog(false).enableResultsDialog(false);
        if (!AdColony.requestInterstitial((String)this.zoneId, (AdColonyInterstitialListener)this.adColonyInterstitialListener, (AdColonyAdOptions)adColonyAdOptions)) {
            AerServLog.i(LOG_TAG, "AdColony.requestInterstitial() returned false");
            this.adLoaded = false;
        }
    }

    @Override
    public void cleanup(Activity activity) {
        AdColonyInterstitial adColonyInterstitial = this.adColonyInterstitial;
        if (adColonyInterstitial != null) {
            adColonyInterstitial.cancel();
            this.adColonyInterstitial = null;
        }
        AdColony.removeRewardListener();
        this.listener = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        AdColonyInterstitial adColonyInterstitial = this.adColonyInterstitial;
        if (adColonyInterstitial == null) {
            return false;
        }
        if (adColonyInterstitial.isExpired()) {
            AerServLog.v(LOG_TAG, "AdColony ad is no longer available because it has expired");
            return false;
        }
        return true;
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
        this.adLoaded = null;
        if (bl) {
            this.loadRewardedAd();
            return;
        }
        this.loadIntersitialAd();
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.adShown = null;
        AdColonyInterstitial adColonyInterstitial = this.adColonyInterstitial;
        Boolean bl2 = false;
        if (adColonyInterstitial == null) {
            AerServLog.i(LOG_TAG, "Cannot show AdColony ad because adColonyInterstitial is null");
            this.adShown = bl2;
            return;
        }
        if (adColonyInterstitial.isExpired()) {
            AerServLog.i(LOG_TAG, "Cannot show AdColony ad because ad has expired");
            this.adShown = bl2;
            return;
        }
        this.listener = adapterListener;
        if (!this.adColonyInterstitial.show()) {
            this.adShown = bl2;
        }
    }

    @Override
    public boolean supportsRewardedCallback() {
        return true;
    }

}

