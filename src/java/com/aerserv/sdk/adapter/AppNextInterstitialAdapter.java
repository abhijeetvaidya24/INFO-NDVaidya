/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  com.appnext.ads.fullscreen.FullScreenVideo
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Float
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigDecimal
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
import com.aerserv.sdk.adapter.ISupportDynamicPrice;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.appnext.ads.fullscreen.FullScreenVideo;
import com.appnext.ads.fullscreen.Video;
import com.appnext.ads.interstitial.Interstitial;
import com.appnext.base.Appnext;
import com.appnext.core.Ad;
import com.appnext.core.ECPM;
import com.appnext.core.callbacks.OnAdClicked;
import com.appnext.core.callbacks.OnAdClosed;
import com.appnext.core.callbacks.OnAdError;
import com.appnext.core.callbacks.OnAdLoaded;
import com.appnext.core.callbacks.OnAdOpened;
import com.appnext.core.callbacks.OnECPMLoaded;
import com.appnext.core.callbacks.OnVideoEnded;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppNextInterstitialAdapter
extends Adapter
implements ISupportDynamicPrice {
    private static final String AD_TYPE = "adType";
    private static final String AD_TYPE_FULLSCREEN_VIDEO = "fullscreenVideo";
    private static final String AD_TYPE_INTERSTITIAL = "interstitial";
    private static final String APPNEXT_AD_TYPE = "AppNextAdType";
    private static final String APPNEXT_PLACEMENT_ID = "AppNextPlacementId";
    private static final String LOG_TAG = "AppNextInterstitialAdapter";
    private static final String PLACEMENT_ID = "placementId";
    private static final Map<MultiKey, AppNextInterstitialAdapter> instanceMap = new HashMap();
    private static final Object mapLock = new Object();
    private Boolean adLoaded = null;
    private Boolean adShown = null;
    private AdapterListener adapterListener = null;
    private Ad appNextAd = null;
    private BigDecimal dynamicPrice = BigDecimal.ZERO;
    private MultiKey key = null;

    private AppNextInterstitialAdapter(MultiKey multiKey) {
        this.key = multiKey;
    }

    private static boolean checkDependencies() {
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot not initialize AppNext SDK because the adapter needs Android Ice Cream Sandwich or later");
            return false;
        }
        if (!ReflectionUtils.canFindClass("com.appnext.ads.interstitial.Interstitial")) {
            AerServLog.i(LOG_TAG, "Cannot initialize AppNext SDK because missing library, or Proguard was configured incorrectly.");
            return false;
        }
        if (ReflectionUtils.canFindClass("com.google.android.gms.location.LocationServices") && ReflectionUtils.canFindClass("com.google.android.gms.common.api.ResultCallback")) {
            return true;
        }
        AerServLog.i(LOG_TAG, "Cannot initialize AppNext SDK because missing library, or Proguard was configured incorrectly.");
        return false;
    }

    private Ad getAd(Activity activity, String string, final String string2) {
        block6 : {
            Object object;
            block5 : {
                block4 : {
                    if (!string2.equals((Object)AD_TYPE_FULLSCREEN_VIDEO)) break block4;
                    AerServLog.v(LOG_TAG, "Creating new fullscreen video.");
                    object = new FullScreenVideo((Context)activity, string);
                    break block5;
                }
                if (!string2.equals((Object)AD_TYPE_INTERSTITIAL)) break block6;
                AerServLog.v(LOG_TAG, "Creating new interstitial.");
                object = new Interstitial((Context)activity, string);
            }
            ((Ad)object).setOnAdLoadedCallback(new OnAdLoaded(){

                public void adLoaded(String string) {
                    String string2 = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("AppNext ad loaded ");
                    stringBuilder.append(string);
                    AerServLog.v(string2, stringBuilder.toString());
                    AppNextInterstitialAdapter.this.adLoaded = true;
                }
            });
            ((Ad)object).setOnAdOpenedCallback(new OnAdOpened(){

                @Override
                public void adOpened() {
                    AerServLog.v(LOG_TAG, "AppNext ad opened.");
                    if (AppNextInterstitialAdapter.this.adapterListener != null) {
                        if (string2.equals((Object)AppNextInterstitialAdapter.AD_TYPE_FULLSCREEN_VIDEO)) {
                            AppNextInterstitialAdapter.this.adapterListener.onVideoStart();
                        }
                        AppNextInterstitialAdapter.this.adapterListener.onAdImpression();
                    }
                    AppNextInterstitialAdapter.this.adShown = true;
                }
            });
            ((Ad)object).setOnAdClickedCallback(new OnAdClicked(){

                @Override
                public void adClicked() {
                    AerServLog.v(LOG_TAG, "AppNext ad clicked.");
                    if (AppNextInterstitialAdapter.this.adapterListener != null) {
                        AppNextInterstitialAdapter.this.adapterListener.onAdClicked();
                    }
                }
            });
            ((Ad)object).setOnAdClosedCallback(new OnAdClosed(){

                @Override
                public void onAdClosed() {
                    AerServLog.v(LOG_TAG, "AppNext ad closed.");
                    if (AppNextInterstitialAdapter.this.adapterListener != null) {
                        AppNextInterstitialAdapter.this.adapterListener.onAdDismissed();
                    }
                }
            });
            ((Ad)object).setOnAdErrorCallback(new OnAdError(){

                @Override
                public void adError(String string) {
                    String string2 = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("AppNext ad error. ");
                    stringBuilder.append(string);
                    AerServLog.v(string2, stringBuilder.toString());
                    if (!string.equals((Object)"Ad Not Ready")) {
                        AppNextInterstitialAdapter.this.adLoaded = false;
                        AppNextInterstitialAdapter.this.adShown = false;
                    }
                }
            });
            if (string2.equals((Object)AD_TYPE_FULLSCREEN_VIDEO)) {
                ((Video)object).setOnVideoEndedCallback(new OnVideoEnded(){

                    @Override
                    public void videoEnded() {
                        AerServLog.v(LOG_TAG, "AppNext video ended.");
                        if (AppNextInterstitialAdapter.this.adapterListener != null) {
                            AppNextInterstitialAdapter.this.adapterListener.onVideoComplete();
                        }
                    }
                });
            }
            return object;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        String string2 = jSONObject.optString(PLACEMENT_ID, jSONObject.optString(APPNEXT_PLACEMENT_ID));
        String string3 = jSONObject.optString(AD_TYPE, jSONObject.optString(APPNEXT_AD_TYPE));
        if (!TextUtils.isEmpty((CharSequence)string2) && !TextUtils.isEmpty((CharSequence)string3)) {
            Object object;
            if (!AppNextInterstitialAdapter.checkDependencies()) {
                AerServLog.i(LOG_TAG, "Failed to obtain AppNext adapter.");
                return null;
            }
            Object object2 = object = mapLock;
            synchronized (object2) {
                MultiKey multiKey = new MultiKey(string2, string3);
                AppNextInterstitialAdapter appNextInterstitialAdapter = (AppNextInterstitialAdapter)instanceMap.get((Object)multiKey);
                if (appNextInterstitialAdapter == null) {
                    AerServLog.v(LOG_TAG, "Creating new AppNext adapter.");
                    appNextInterstitialAdapter = new AppNextInterstitialAdapter(multiKey);
                    instanceMap.put((Object)multiKey, (Object)appNextInterstitialAdapter);
                }
                AerServLog.v(LOG_TAG, "Successfully obtained AppNext adapter.");
                return appNextInterstitialAdapter;
            }
        }
        AerServLog.i(LOG_TAG, "Cannot load AppNext SDK because placement ID or ad type is empty.");
        return null;
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
        if (activity == null) {
            AerServLog.w(LOG_TAG, "AppNext requires an activity to initialize.");
            return;
        }
        if (!AppNextInterstitialAdapter.checkDependencies()) {
            AerServLog.w(LOG_TAG, "Failed to initialize AppNext SDK.");
            return;
        }
        AerServLog.v(LOG_TAG, "Initializing AppNext SDK.");
        Appnext.init((Context)activity);
    }

    @Override
    public void cleanup(Activity activity) {
        AerServLog.v(LOG_TAG, "Cleaning up AppNext adapter.");
        Ad ad = this.appNextAd;
        if (ad != null) {
            ad.destroy();
            this.appNextAd = null;
        }
        this.adapterListener = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public BigDecimal getDynamicPrice() {
        return this.dynamicPrice;
    }

    @Override
    public boolean hasAd(boolean bl) {
        Ad ad = this.appNextAd;
        if (ad != null) {
            return ad.isAdLoaded();
        }
        return false;
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
        AerServLog.v(LOG_TAG, "Trying to load AppNext ad.");
        this.adLoaded = null;
        Boolean bl3 = false;
        if (activity == null) {
            AerServLog.i(LOG_TAG, "Cannot initialize AppNext SDK because activity is null");
            this.adLoaded = bl3;
            return;
        }
        String string = jSONObject.optString(PLACEMENT_ID, jSONObject.optString(APPNEXT_PLACEMENT_ID));
        String string2 = jSONObject.optString(AD_TYPE, jSONObject.optString(APPNEXT_AD_TYPE));
        if (this.appNextAd == null) {
            AerServLog.v(LOG_TAG, "Creating new AppNext ad.");
            this.appNextAd = this.getAd(activity, string, string2);
            if (this.appNextAd == null) {
                String string3 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Could not create new AppNext ad. Ad type unsupported: ");
                stringBuilder.append(string2);
                AerServLog.i(string3, stringBuilder.toString());
                this.adLoaded = bl3;
                return;
            }
        }
        AerServLog.v(LOG_TAG, "Loading AppNext ad.");
        this.appNextAd.getECPM(new OnECPMLoaded(){

            @Override
            public void ecpm(ECPM eCPM) {
                float f2 = eCPM.getEcpm();
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AppNext ecpm: ");
                stringBuilder.append(f2);
                AerServLog.d(string, stringBuilder.toString());
                if (f2 > 0.0f) {
                    AppNextInterstitialAdapter.this.setDynamicPrice(new BigDecimal(Float.toString((float)f2)));
                }
                if (AppNextInterstitialAdapter.this.appNextAd != null) {
                    AppNextInterstitialAdapter.this.appNextAd.loadAd();
                }
            }

            @Override
            public void error(String string) {
                String string2 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AppNext failed to get ecpm: ");
                stringBuilder.append(string);
                AerServLog.d(string2, stringBuilder.toString());
                if (AppNextInterstitialAdapter.this.appNextAd != null) {
                    AppNextInterstitialAdapter.this.appNextAd.loadAd();
                }
            }
        });
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void removeInstance() {
        Object object;
        Object object2 = object = mapLock;
        synchronized (object2) {
            if (instanceMap.containsKey((Object)this.key)) {
                instanceMap.remove((Object)this.key);
            }
            return;
        }
    }

    @Override
    public void setDynamicPrice(BigDecimal bigDecimal) {
        this.dynamicPrice = bigDecimal;
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        AerServLog.v(LOG_TAG, "Trying to show AppNext ad.");
        this.adShown = null;
        this.adapterListener = adapterListener;
        Ad ad = this.appNextAd;
        if (ad != null && ad.isAdLoaded()) {
            this.appNextAd.showAd();
            return;
        }
        AerServLog.i(LOG_TAG, "AppNext ad is not ready.");
        this.adShown = false;
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }

}

