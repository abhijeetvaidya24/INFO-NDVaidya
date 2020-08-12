/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.content.Context
 *  android.text.TextUtils
 *  com.millennialmedia.AppInfo
 *  com.millennialmedia.InterstitialAd
 *  com.millennialmedia.InterstitialAd$InterstitialAdMetadata
 *  com.millennialmedia.InterstitialAd$InterstitialListener
 *  com.millennialmedia.MMException
 *  com.millennialmedia.MMSDK
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
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.adapter.MillennialInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.millennialmedia.AppInfo;
import com.millennialmedia.InterstitialAd;
import com.millennialmedia.MMException;
import com.millennialmedia.MMSDK;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class MillennialInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "MillennialInterstitialAdapter";
    private static final Map<MultiKey, MillennialInterstitialAdapter> instanceMap = new HashMap();
    private static String siteId;
    private Boolean adLoaded = null;
    private Boolean adShown = null;
    private InterstitialAd interstitialAd = null;
    private AdapterListener listener = null;
    private String placementId;

    private MillennialInterstitialAdapter(String string) {
        this.placementId = string;
    }

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ Boolean access$102(MillennialInterstitialAdapter millennialInterstitialAdapter, Boolean bl) {
        millennialInterstitialAdapter.adLoaded = bl;
        return bl;
    }

    static /* synthetic */ Boolean access$202(MillennialInterstitialAdapter millennialInterstitialAdapter, Boolean bl) {
        millennialInterstitialAdapter.adShown = bl;
        return bl;
    }

    static /* synthetic */ AdapterListener access$300(MillennialInterstitialAdapter millennialInterstitialAdapter) {
        return millennialInterstitialAdapter.listener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        Map<MultiKey, MillennialInterstitialAdapter> map;
        if (!ReflectionUtils.canFindClass("com.millennialmedia.MMSDK")) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because Millennial Media SDK was not included, or Proguard was not configured properly");
            return null;
        }
        String string2 = jSONObject.optString("placementId");
        if (TextUtils.isEmpty((CharSequence)string2)) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because placement ID is empty");
            return null;
        }
        Map<MultiKey, MillennialInterstitialAdapter> map2 = map = instanceMap;
        synchronized (map2) {
            MultiKey multiKey = new MultiKey(string, string2);
            MillennialInterstitialAdapter millennialInterstitialAdapter = (MillennialInterstitialAdapter)instanceMap.get((Object)multiKey);
            if (millennialInterstitialAdapter == null) {
                millennialInterstitialAdapter = new MillennialInterstitialAdapter(string2);
                instanceMap.put((Object)multiKey, (Object)millennialInterstitialAdapter);
            }
            return millennialInterstitialAdapter;
        }
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
        if (!ReflectionUtils.canFindClass("com.millennialmedia.MMSDK")) {
            AerServLog.i(LOG_TAG, "Cannot initialize Millennial Media SDK because its libraries were not included, or Proguard was not configured properly");
            return;
        }
        if (!MMSDK.isInitialized()) {
            try {
                MMSDK.initialize((Application)activity.getApplication());
                return;
            }
            catch (MMException mMException) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot not initialize Millennial Media SDK because an exception occurred when calling initalize(): ");
                stringBuilder.append(mMException.getMessage());
                AerServLog.i(string, stringBuilder.toString());
            }
        }
    }

    @Override
    public void cleanup(Activity activity) {
        this.interstitialAd = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        InterstitialAd interstitialAd = this.interstitialAd;
        return interstitialAd != null && !interstitialAd.hasExpired() && this.interstitialAd.isReady() && Boolean.TRUE.equals((Object)this.adLoaded) && this.adShown == null;
    }

    @Override
    public boolean hasPartnerAdLoadFailedDueToConnectionError() {
        return false;
    }

    @Override
    public Boolean hasPartnerAdLoaded(boolean bl) {
        if (!MMSDK.isInitialized()) {
            return null;
        }
        return this.adLoaded;
    }

    @Override
    public Boolean hasPartnerAdShown(boolean bl) {
        return this.adShown;
    }

    @Override
    public void loadPartnerAd(Activity activity, JSONObject jSONObject, boolean bl, boolean bl2) {
        InterstitialAd.InterstitialListener interstitialListener;
        String string;
        block5 : {
            this.adLoaded = null;
            this.adShown = null;
            Boolean bl3 = false;
            if (jSONObject == null) {
                AerServLog.i(LOG_TAG, "Could not load Millennial Media ad because credentials is null");
                this.adLoaded = bl3;
                return;
            }
            try {
                interstitialListener = new InterstitialAd.InterstitialListener(this){
                    final /* synthetic */ MillennialInterstitialAdapter this$0;
                    {
                        this.this$0 = millennialInterstitialAdapter;
                    }

                    public void onAdLeftApplication(InterstitialAd interstitialAd) {
                        AerServLog.v(MillennialInterstitialAdapter.access$000(), "Millennial Media onAdLeftApplication()");
                    }

                    public void onClicked(InterstitialAd interstitialAd) {
                        AerServLog.v(MillennialInterstitialAdapter.access$000(), "Millennial Media onClicked()");
                        if (MillennialInterstitialAdapter.access$300(this.this$0) != null) {
                            MillennialInterstitialAdapter.access$300(this.this$0).onAdClicked();
                        }
                    }

                    public void onClosed(InterstitialAd interstitialAd) {
                        AerServLog.v(MillennialInterstitialAdapter.access$000(), "Millennial Media onClosed()");
                        if (MillennialInterstitialAdapter.access$300(this.this$0) != null) {
                            MillennialInterstitialAdapter.access$300(this.this$0).onAdDismissed();
                        }
                    }

                    public void onExpired(InterstitialAd interstitialAd) {
                        AerServLog.v(MillennialInterstitialAdapter.access$000(), "Millennial Media onExpired()");
                    }

                    public void onLoadFailed(InterstitialAd interstitialAd, com.millennialmedia.InterstitialAd$InterstitialErrorStatus interstitialErrorStatus) {
                        String string = MillennialInterstitialAdapter.access$000();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Millennial Media onLoadFailed(): ");
                        stringBuilder.append(interstitialErrorStatus.getDescription());
                        AerServLog.v(string, stringBuilder.toString());
                        MillennialInterstitialAdapter.access$102(this.this$0, false);
                    }

                    public void onLoaded(InterstitialAd interstitialAd) {
                        AerServLog.v(MillennialInterstitialAdapter.access$000(), "Millennial Media onLoaded()");
                        MillennialInterstitialAdapter.access$102(this.this$0, true);
                    }

                    public void onShowFailed(InterstitialAd interstitialAd, com.millennialmedia.InterstitialAd$InterstitialErrorStatus interstitialErrorStatus) {
                        AerServLog.v(MillennialInterstitialAdapter.access$000(), "Millennial Media onShowFailed()");
                        MillennialInterstitialAdapter.access$202(this.this$0, false);
                    }

                    public void onShown(InterstitialAd interstitialAd) {
                        AerServLog.v(MillennialInterstitialAdapter.access$000(), "Millennial Media onShown()");
                        MillennialInterstitialAdapter.access$202(this.this$0, true);
                        if (MillennialInterstitialAdapter.access$300(this.this$0) != null) {
                            MillennialInterstitialAdapter.access$300(this.this$0).onAdImpression();
                        }
                    }
                };
                string = jSONObject.optString("supportedOrientations");
                if (!TextUtils.isEmpty((CharSequence)string)) break block5;
                string = "portrait,landscape";
            }
            catch (MMException mMException) {
                String string2 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception occurred loading ad: ");
                stringBuilder.append(mMException.getMessage());
                AerServLog.i(string2, stringBuilder.toString());
                this.adLoaded = bl3;
                return;
            }
        }
        InterstitialAd.InterstitialAdMetadata interstitialAdMetadata = new InterstitialAd.InterstitialAdMetadata();
        interstitialAdMetadata.setSupportedOrientations(string);
        siteId = jSONObject.optString("siteId");
        if (!TextUtils.isEmpty((CharSequence)siteId)) {
            AppInfo appInfo = new AppInfo();
            appInfo.setSiteId(siteId);
            MMSDK.setAppInfo((AppInfo)appInfo);
        }
        this.interstitialAd = InterstitialAd.createInstance((String)this.placementId);
        this.interstitialAd.setListener(interstitialListener);
        this.interstitialAd.load((Context)activity, interstitialAdMetadata);
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.adShown = null;
        this.listener = adapterListener;
        InterstitialAd interstitialAd = this.interstitialAd;
        Boolean bl2 = false;
        if (interstitialAd == null) {
            AerServLog.i(LOG_TAG, "Cannot show Millennial Media ad because InterstitialAd object is null");
            this.adShown = bl2;
            return;
        }
        if (interstitialAd.hasExpired()) {
            AerServLog.i(LOG_TAG, "Cannot show Millennial Media ad because it already expired");
            this.adShown = bl2;
            return;
        }
        if (!this.interstitialAd.isReady()) {
            AerServLog.i(LOG_TAG, "Cannot show Millennial Media ad because it is not ready");
            this.adShown = bl2;
            return;
        }
        try {
            this.interstitialAd.show((Context)activity);
            return;
        }
        catch (MMException mMException) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception trying to show Millennial Media ad: ");
            stringBuilder.append(mMException.getMessage());
            AerServLog.d(string, stringBuilder.toString());
            this.adShown = bl2;
            return;
        }
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }
}

