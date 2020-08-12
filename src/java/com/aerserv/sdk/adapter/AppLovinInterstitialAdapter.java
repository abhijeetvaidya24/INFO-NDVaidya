/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Iterable
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
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
import com.aerserv.sdk.adapter.AppLovinInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class AppLovinInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "AppLovinInterstitialAdapter";
    private static AppLovinSdk appLovinSdk;
    private static AppLovinInterstitialAdapter instance;
    private static String sdkKey;
    private Boolean adLoaded = null;
    private boolean adLoadedFailedDueToConectionError = false;
    private Boolean adShown = null;
    private AppLovinAdClickListener appLovinAdClickListener = new AppLovinAdClickListener(){

        @Override
        public void adClicked(AppLovinAd appLovinAd) {
            AerServLog.v(LOG_TAG, "AppLovin adClicked()");
            if (AppLovinInterstitialAdapter.this.listener != null) {
                AppLovinInterstitialAdapter.this.listener.onAdClicked();
            }
        }
    };
    private AppLovinAdDisplayListener appLovinAdDisplayListener = new AppLovinAdDisplayListener(){

        @Override
        public void adDisplayed(AppLovinAd appLovinAd) {
            AerServLog.v(LOG_TAG, "AppLovin adDisplayed()");
            AppLovinInterstitialAdapter.this.adShown = true;
            if (AppLovinInterstitialAdapter.this.listener != null) {
                AppLovinInterstitialAdapter.this.listener.onAdImpression();
            }
        }

        @Override
        public void adHidden(AppLovinAd appLovinAd) {
            AerServLog.v(LOG_TAG, "AppLovin adHidden()");
            if (AppLovinInterstitialAdapter.this.listener != null) {
                AppLovinInterstitialAdapter.this.listener.onAdDismissed();
            }
        }
    };
    private AppLovinAdLoadListener appLovinAdLoadListener = new AppLovinAdLoadListener(){

        @Override
        public void adReceived(AppLovinAd appLovinAd) {
            AerServLog.v(LOG_TAG, "AppLovin adReceived()");
            AppLovinInterstitialAdapter.this.adLoaded = true;
        }

        @Override
        public void failedToReceiveAd(int n2) {
            String string;
            AppLovinInterstitialAdapter.this.adLoaded = false;
            if (n2 != -103) {
                if (n2 != -102) {
                    string = n2 != -6 ? (n2 != -1 ? (n2 != 204 ? "Unknown" : "No fill") : "Unspecified error") : "Unable to render ad";
                } else {
                    AppLovinInterstitialAdapter.this.adLoadedFailedDueToConectionError = true;
                    string = "Fetch ad timeout";
                }
            } else {
                AppLovinInterstitialAdapter.this.adLoadedFailedDueToConectionError = true;
                string = "No network";
            }
            String string2 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AppLovin failedToReceiveAd(): ");
            stringBuilder.append(string);
            AerServLog.d(string2, stringBuilder.toString());
        }
    };
    private AppLovinAdRewardListener appLovinAdRewardListener = new AppLovinAdRewardListener(){

        @Override
        public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
            AerServLog.v(LOG_TAG, "AppLovin userDeclinedToViewAd()");
        }

        public void userOverQuota(AppLovinAd appLovinAd, Map map) {
            AerServLog.v(LOG_TAG, "AppLovin userOverQuota()");
        }

        public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
            AerServLog.v(LOG_TAG, "AppLovin userRewardRejected()");
        }

        public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
            AerServLog.v(LOG_TAG, "AppLovin userRewardVerified()");
        }

        @Override
        public void validationRequestFailed(AppLovinAd appLovinAd, int n2) {
            AerServLog.v(LOG_TAG, "AppLovin validationRequestFailed()");
        }
    };
    AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener = new AppLovinAdVideoPlaybackListener(){

        @Override
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            AerServLog.v(LOG_TAG, "AppLovin videoPlaybackBegan()");
            AppLovinInterstitialAdapter.this.adShown = true;
            if (AppLovinInterstitialAdapter.this.listener != null) {
                AppLovinInterstitialAdapter.this.listener.onVideoStart();
            }
        }

        @Override
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d2, boolean bl) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AppLovin videoPlaybackEnded(), percent viewed ");
            stringBuilder.append(d2);
            stringBuilder.append(", fullyWatched ");
            stringBuilder.append(bl);
            AerServLog.v(string, stringBuilder.toString());
            if (AppLovinInterstitialAdapter.this.listener != null) {
                if (bl) {
                    AppLovinInterstitialAdapter.this.listener.onVideoComplete();
                }
                if (AppLovinInterstitialAdapter.this.isRewardedAd) {
                    AppLovinInterstitialAdapter.this.listener.onRewarded("", 0.0);
                }
                AppLovinInterstitialAdapter.this.listener.onAdDismissed();
            }
        }
    };
    private AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = null;
    private AppLovinInterstitialAdDialog appLovinInterstitialAdDialog = null;
    private boolean isRewardedAd = false;
    private AdapterListener listener = null;

    private AppLovinInterstitialAdapter(Activity activity) {
        this.appLovinInterstitialAdDialog = AppLovinInterstitialAd.create(appLovinSdk, (Context)activity);
        this.appLovinInterstitialAdDialog.setAdLoadListener(this.appLovinAdLoadListener);
        this.appLovinInterstitialAdDialog.setAdDisplayListener(this.appLovinAdDisplayListener);
        this.appLovinInterstitialAdDialog.setAdVideoPlaybackListener(this.appLovinAdVideoPlaybackListener);
        this.appLovinInterstitialAdDialog.setAdClickListener(this.appLovinAdClickListener);
        this.appLovinIncentivizedInterstitial = AppLovinIncentivizedInterstitial.create(appLovinSdk);
    }

    static /* synthetic */ AppLovinSdk access$600() {
        return appLovinSdk;
    }

    static /* synthetic */ AppLovinSdk access$602(AppLovinSdk appLovinSdk) {
        AppLovinInterstitialAdapter.appLovinSdk = appLovinSdk;
        return appLovinSdk;
    }

    static /* synthetic */ String access$700() {
        return sdkKey;
    }

    static /* synthetic */ AppLovinInterstitialAdapter access$802(AppLovinInterstitialAdapter appLovinInterstitialAdapter) {
        instance = appLovinInterstitialAdapter;
        return appLovinInterstitialAdapter;
    }

    public static Adapter getInstance(String string, JSONObject jSONObject) {
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because the adapter needs Android Ice Cream Sandwich or later");
            return null;
        }
        if (!ReflectionUtils.canFindClass("com.applovin.sdk.AppLovinSdk")) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because AppLovin SDK was not included, or Proguard was not configured properly");
            return null;
        }
        return instance;
    }

    private Boolean hasInterstitialAdLoaded() {
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialog = this.appLovinInterstitialAdDialog;
        if (appLovinInterstitialAdDialog != null && appLovinInterstitialAdDialog.isAdReadyToDisplay()) {
            this.adLoaded = true;
        }
        return this.adLoaded;
    }

    private Boolean hasRewardedAdLoaded() {
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = this.appLovinIncentivizedInterstitial;
        if (appLovinIncentivizedInterstitial != null && appLovinIncentivizedInterstitial.isAdReadyToDisplay()) {
            this.adLoaded = true;
        }
        return this.adLoaded;
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot not initialize AppLovin SDK because the adapter needs Android Ice Cream Sandwich or later");
            return;
        }
        if (!ReflectionUtils.canFindClass("com.applovin.sdk.AppLovinSdk")) {
            AerServLog.i(LOG_TAG, "Cannot initialize AppLovin SDK because its libraries were not included, or Proguard was not configured properly");
            return;
        }
        if (jSONArray != null && jSONArray.length() >= 1) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            boolean bl = false;
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                JSONArray jSONArray2;
                JSONObject jSONObject = jSONArray.optJSONObject(i2);
                if (jSONObject == null) {
                    AerServLog.i(LOG_TAG, "Cannot initialize AppLovin because credentials object is null.  Skipping to next set of credentials");
                    continue;
                }
                String string = jSONObject.optString("key", jSONObject.optString("AppLovinSdkKey"));
                if (TextUtils.isEmpty((CharSequence)string)) {
                    AerServLog.i(LOG_TAG, "SDK key used to initialize AppLovin is empty.  Skipping to next set of credentials.");
                    continue;
                }
                String string2 = sdkKey;
                if (string2 == null) {
                    sdkKey = string;
                } else if (!string2.equals((Object)string)) {
                    AerServLog.i(LOG_TAG, "Cannot initialize AppLovin using two different SDK keys.  Skipping to next set of credentials.");
                    continue;
                }
                JSONArray jSONArray3 = jSONObject.optJSONArray("preloadSizes");
                if (jSONArray3 != null) {
                    for (int i3 = 0; i3 < jSONArray3.length(); ++i3) {
                        if (TextUtils.isEmpty((CharSequence)jSONArray3.optString(i3))) continue;
                        hashSet.add((Object)jSONArray3.optString(i3));
                    }
                }
                if ((jSONArray2 = jSONObject.optJSONArray("preloadTypes")) != null) {
                    for (int i4 = 0; i4 < jSONArray2.length(); ++i4) {
                        if (TextUtils.isEmpty((CharSequence)jSONArray2.optString(i4))) continue;
                        hashSet2.add((Object)jSONArray2.optString(i4));
                    }
                }
                if (!bl && !jSONObject.optBoolean("verboseLogging", bl)) {
                    bl = false;
                    continue;
                }
                bl = true;
            }
            if (hashSet.isEmpty()) {
                hashSet.add((Object)"BANNER");
                hashSet.add((Object)"INTER");
            }
            if (hashSet2.isEmpty()) {
                hashSet2.add((Object)"REGULAR");
                hashSet2.add((Object)"VIDEOA");
            }
            AppLovinSdkSettings appLovinSdkSettings = new AppLovinSdkSettings();
            appLovinSdkSettings.setAutoPreloadSizes(TextUtils.join((CharSequence)",", (Iterable)hashSet));
            appLovinSdkSettings.setAutoPreloadTypes(TextUtils.join((CharSequence)",", (Iterable)hashSet2));
            appLovinSdkSettings.setBannerAdRefreshSeconds(-100L);
            if (bl) {
                appLovinSdkSettings.setVerboseLogging(true);
            }
            activity.runOnUiThread(new Runnable(appLovinSdkSettings, activity){
                final /* synthetic */ Activity val$activity;
                final /* synthetic */ AppLovinSdkSettings val$appLovinSdkSettings;
                {
                    this.val$appLovinSdkSettings = appLovinSdkSettings;
                    this.val$activity = activity;
                }

                public void run() {
                    AppLovinInterstitialAdapter.access$602(AppLovinSdk.getInstance(AppLovinInterstitialAdapter.access$700(), this.val$appLovinSdkSettings, (Context)this.val$activity));
                    AppLovinInterstitialAdapter.access$600().initializeSdk();
                    AppLovinInterstitialAdapter.access$802(new AppLovinInterstitialAdapter(this.val$activity));
                }
            });
            return;
        }
        AerServLog.i(LOG_TAG, "Could not initialize AppLovin SDK because credentials list is empty");
    }

    private void loadRewardedAd() {
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = this.appLovinIncentivizedInterstitial;
        if (appLovinIncentivizedInterstitial != null) {
            appLovinIncentivizedInterstitial.preload(this.appLovinAdLoadListener);
        }
    }

    private void showInterstitailAd() {
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialog = this.appLovinInterstitialAdDialog;
        Boolean bl = false;
        if (appLovinInterstitialAdDialog == null) {
            AerServLog.i(LOG_TAG, "Cannot show AppLovin interstitial ad because appLovinInterstitialAdDialog is null");
            this.adShown = bl;
            return;
        }
        if (!appLovinInterstitialAdDialog.isAdReadyToDisplay()) {
            AerServLog.i(LOG_TAG, "Cannot show AppLovin interstitial ad because appLovinInterstitialAdDialog is not ready");
            this.adShown = bl;
            return;
        }
        this.appLovinInterstitialAdDialog.show();
    }

    private void showRewardedAd(Activity activity) {
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = this.appLovinIncentivizedInterstitial;
        Boolean bl = false;
        if (appLovinIncentivizedInterstitial == null) {
            AerServLog.i(LOG_TAG, "Cannot show AppLovin rewarded ad because appLovinIncentivizedInterstitial is null");
            this.adShown = bl;
            return;
        }
        if (!appLovinIncentivizedInterstitial.isAdReadyToDisplay()) {
            AerServLog.i(LOG_TAG, "Cannot show AppLovin rewarded ad because appLovinIncentivizedInterstitial is not ready");
            this.adShown = bl;
            return;
        }
        this.appLovinIncentivizedInterstitial.show((Context)activity, this.appLovinAdRewardListener, this.appLovinAdVideoPlaybackListener, this.appLovinAdDisplayListener, this.appLovinAdClickListener);
    }

    @Override
    public void cleanup(Activity activity) {
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial;
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialog = this.appLovinInterstitialAdDialog;
        if (appLovinInterstitialAdDialog != null) {
            try {
                if (appLovinInterstitialAdDialog.isShowing()) {
                    this.appLovinInterstitialAdDialog.dismiss();
                }
            }
            catch (Exception exception) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception cleaning up AppLovinInterstitialAdDialog: ");
                stringBuilder.append(exception.getMessage());
                AerServLog.w(string, stringBuilder.toString());
            }
        }
        if ((appLovinIncentivizedInterstitial = this.appLovinIncentivizedInterstitial) != null && this.isRewardedAd) {
            try {
                appLovinIncentivizedInterstitial.dismiss();
            }
            catch (Exception exception) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception cleaning up AppLovinIncentivizedInterstitial: ");
                stringBuilder.append(exception.getMessage());
                AerServLog.w(string, stringBuilder.toString());
            }
        }
        this.listener = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        if (bl) {
            return this.hasRewardedAd();
        }
        return this.hasInterstitialAd();
    }

    public boolean hasInterstitialAd() {
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialog = this.appLovinInterstitialAdDialog;
        return appLovinInterstitialAdDialog != null && appLovinInterstitialAdDialog.isAdReadyToDisplay();
    }

    @Override
    public boolean hasPartnerAdLoadFailedDueToConnectionError() {
        return this.adLoadedFailedDueToConectionError;
    }

    @Override
    public Boolean hasPartnerAdLoaded(boolean bl) {
        if (bl) {
            return this.hasRewardedAdLoaded();
        }
        return this.hasInterstitialAdLoaded();
    }

    @Override
    public Boolean hasPartnerAdShown(boolean bl) {
        return this.adShown;
    }

    public boolean hasRewardedAd() {
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = this.appLovinIncentivizedInterstitial;
        return appLovinIncentivizedInterstitial != null && appLovinIncentivizedInterstitial.isAdReadyToDisplay();
    }

    @Override
    public void loadPartnerAd(Activity activity, JSONObject jSONObject, boolean bl, boolean bl2) {
        this.isRewardedAd = bl;
        this.adLoaded = null;
        this.adLoadedFailedDueToConectionError = false;
        if (bl) {
            this.loadRewardedAd();
        }
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.isRewardedAd = bl;
        this.adShown = null;
        this.listener = adapterListener;
        if (bl) {
            this.showRewardedAd(activity);
            return;
        }
        this.showInterstitailAd();
    }

    @Override
    public boolean supportsRewardedCallback() {
        return true;
    }

}

