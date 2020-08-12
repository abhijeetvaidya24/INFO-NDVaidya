/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  com.tremorvideo.sdk.android.videoad.TremorAdStateListener
 *  com.tremorvideo.sdk.android.videoad.TremorVideo
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.text.TextUtils;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.adapter.TremorInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.tremorvideo.sdk.android.videoad.TremorAdStateListener;
import com.tremorvideo.sdk.android.videoad.TremorVideo;
import org.json.JSONArray;
import org.json.JSONObject;

public class TremorInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "TremorInterstitialAdapter";
    private static String initializedAppId;
    private static TremorInterstitialAdapter instance;
    private static final Object lock;
    private Boolean adLoaded = null;
    private Boolean adShown = null;
    private AdapterListener listener = null;

    static {
        lock = new Object();
    }

    private TremorInterstitialAdapter() {
        TremorVideo.setAdStateListener((TremorAdStateListener)new TremorAdStateListener(this){
            final /* synthetic */ TremorInterstitialAdapter this$0;
            {
                this.this$0 = tremorInterstitialAdapter;
            }

            public void adClickThru() {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor adClickThru()");
                if (TremorInterstitialAdapter.access$300(this.this$0) != null) {
                    TremorInterstitialAdapter.access$300(this.this$0).onAdClicked();
                }
            }

            public void adComplete(boolean bl, int n2) {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor adComplete()");
                if (bl) {
                    TremorInterstitialAdapter.access$202(this.this$0, true);
                    if (TremorInterstitialAdapter.access$300(this.this$0) != null) {
                        TremorInterstitialAdapter.access$300(this.this$0).onAdDismissed();
                        return;
                    }
                } else {
                    TremorInterstitialAdapter.access$202(this.this$0, false);
                    String string = n2 == 0 ? "No ad was available at the time" : (n2 < 0 ? "An ad was returned but an error occurred tyring to show it" : "");
                    String string2 = TremorInterstitialAdapter.access$100();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Tremor ad failed: ");
                    stringBuilder.append(string);
                    AerServLog.d(string2, stringBuilder.toString());
                }
            }

            public void adImpression() {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor adImpression()");
                if (TremorInterstitialAdapter.access$300(this.this$0) != null) {
                    TremorInterstitialAdapter.access$300(this.this$0).onAdImpression();
                }
            }

            public void adReady(boolean bl) {
                String string = TremorInterstitialAdapter.access$100();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Tremor adReady() called ");
                stringBuilder.append(bl);
                AerServLog.v(string, stringBuilder.toString());
                TremorInterstitialAdapter.access$402(this.this$0, true);
            }

            public void adSkipped() {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor headSkippedllo()");
            }

            public void adStart() {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor adStart()");
            }

            public void adVideoComplete(int n2) {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor adVideoComplete()");
                if (TremorInterstitialAdapter.access$300(this.this$0) != null) {
                    TremorInterstitialAdapter.access$300(this.this$0).onVideoComplete();
                }
            }

            public void adVideoFirstQuartile(int n2) {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor adVideoFirstQuartile()");
            }

            public void adVideoMidPoint(int n2) {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor adVideoMidPoint()");
            }

            public void adVideoStart(int n2) {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor adVideoStart()");
                if (TremorInterstitialAdapter.access$300(this.this$0) != null) {
                    TremorInterstitialAdapter.access$300(this.this$0).onVideoStart();
                }
            }

            public void adVideoThirdQuartile(int n2) {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor adVideoThirdQuartile()");
            }

            public void leftApp() {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor leftApp()");
            }

            public void sdkDestroyed() {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor sdkDestroyed()");
            }

            public void sdkInitialized() {
                AerServLog.v(TremorInterstitialAdapter.access$100(), "Tremor sdkInitialized()");
            }
        });
    }

    static /* synthetic */ String access$000() {
        return initializedAppId;
    }

    static /* synthetic */ String access$100() {
        return LOG_TAG;
    }

    static /* synthetic */ Boolean access$202(TremorInterstitialAdapter tremorInterstitialAdapter, Boolean bl) {
        tremorInterstitialAdapter.adShown = bl;
        return bl;
    }

    static /* synthetic */ AdapterListener access$300(TremorInterstitialAdapter tremorInterstitialAdapter) {
        return tremorInterstitialAdapter.listener;
    }

    static /* synthetic */ Boolean access$402(TremorInterstitialAdapter tremorInterstitialAdapter, Boolean bl) {
        tremorInterstitialAdapter.adLoaded = bl;
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        Object object;
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because the adapter needs Android Ice Cream Sandwich or later");
            return null;
        }
        if (!ReflectionUtils.canFindClass("com.tremorvideo.sdk.android.videoad.TremorVideo")) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because Tremor SDK was not included, or Proguard was not configured properly");
            return null;
        }
        String string2 = jSONObject.optString("appId");
        if (TextUtils.isEmpty((CharSequence)string2)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of TremorAdapter because app ID is empty");
            return null;
        }
        if (!string2.equals((Object)initializedAppId)) {
            AerServLog.i(LOG_TAG, "The Tremor app ID used to initialize SDK is different than the requested.  Cannot continue.");
            return null;
        }
        Object object2 = object = lock;
        synchronized (object2) {
            if (instance != null) return instance;
            instance = new TremorInterstitialAdapter();
            return instance;
        }
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
        if (!VersionUtils.checkVersion(14)) {
            AerServLog.i(LOG_TAG, "Cannot not initialize Tremor SDK because the adapter needs Android Ice Cream Sandwich or later");
            return;
        }
        if (!ReflectionUtils.canFindClass("com.tremorvideo.sdk.android.videoad.TremorVideo")) {
            AerServLog.i(LOG_TAG, "Cannot initialize Tremor SDK because its libraries were not included, or Proguard was not configured properly");
            return;
        }
        if (jSONArray != null && jSONArray.length() >= 1) {
            JSONObject jSONObject = jSONArray.optJSONObject(0);
            if (jSONObject != null && !TextUtils.isEmpty((CharSequence)jSONObject.optString("appId"))) {
                initializedAppId = jSONObject.optString("appId");
                activity.runOnUiThread(new Runnable(activity){
                    final /* synthetic */ Activity val$activity;
                    {
                        this.val$activity = activity;
                    }

                    public void run() {
                        try {
                            TremorVideo.initialize((android.content.Context)this.val$activity, (String)TremorInterstitialAdapter.access$000());
                            return;
                        }
                        catch (java.lang.Throwable throwable) {
                            String string = TremorInterstitialAdapter.access$100();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Cannot initalize Tremor adapter: ");
                            stringBuilder.append(throwable.getMessage());
                            AerServLog.w(string, stringBuilder.toString());
                            return;
                        }
                    }
                });
                return;
            }
            AerServLog.i(LOG_TAG, "Could not initialize Tremor SDK because appId is empty");
            return;
        }
        AerServLog.i(LOG_TAG, "Could not initialize Tremor SDK because credentials list is empty");
    }

    @Override
    public void cleanup(Activity activity) {
        TremorVideo.stop();
        this.listener = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        return TremorVideo.isAdReady();
    }

    @Override
    public boolean hasPartnerAdLoadFailedDueToConnectionError() {
        return false;
    }

    @Override
    public Boolean hasPartnerAdLoaded(boolean bl) {
        Boolean bl2;
        if (TremorVideo.isInitialized() && (bl2 = this.adLoaded) != null) {
            if (bl2.booleanValue()) {
                boolean bl3 = TremorVideo.isAdReady();
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
        this.adLoaded = null;
        this.adShown = null;
        try {
            TremorVideo.loadAd();
            return;
        }
        catch (Exception exception) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception loading Tremor ad: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.d(string, stringBuilder.toString());
            this.adLoaded = false;
            return;
        }
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.adShown = null;
        this.listener = adapterListener;
        try {
            if (TremorVideo.showAd((Activity)activity, (int)1)) {
                return;
            }
            AerServLog.d(LOG_TAG, "Tremor ad failed to show: No Ad Ready.");
            this.adShown = false;
            return;
        }
        catch (Exception exception) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception showing Tremor ad: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string, stringBuilder.toString());
            this.adShown = false;
            return;
        }
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }
}

