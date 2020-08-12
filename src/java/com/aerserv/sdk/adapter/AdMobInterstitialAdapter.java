/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.provider.Settings
 *  android.provider.Settings$Secure
 *  android.text.TextUtils
 *  com.google.android.gms.ads.AdListener
 *  com.google.android.gms.ads.AdRequest
 *  com.google.android.gms.ads.AdRequest$Builder
 *  com.google.android.gms.ads.InterstitialAd
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.math.BigInteger
 *  java.security.MessageDigest
 *  java.security.NoSuchAlgorithmException
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import com.aerserv.sdk.adapter.AdMobInterstitialAdapter;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdMobInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "AdMobInterstitialAdapter";
    private static final Map<Integer, Boolean> adLoadedFailedDueToConectionErrorMap;
    private static final Map<Integer, Boolean> adLoadedMap;
    private static final Map<Integer, Boolean> adShownMap;
    private static final Map<MultiKey, AdMobInterstitialAdapter> instanceMap;
    private AdListenerImp adListener = null;
    private InterstitialAd interstitialAd = null;

    static {
        instanceMap = new HashMap();
        adLoadedMap = new ConcurrentHashMap();
        adShownMap = new ConcurrentHashMap();
        adLoadedFailedDueToConectionErrorMap = new ConcurrentHashMap();
    }

    static /* synthetic */ InterstitialAd access$000(AdMobInterstitialAdapter adMobInterstitialAdapter) {
        return adMobInterstitialAdapter.interstitialAd;
    }

    static /* synthetic */ InterstitialAd access$002(AdMobInterstitialAdapter adMobInterstitialAdapter, InterstitialAd interstitialAd) {
        adMobInterstitialAdapter.interstitialAd = interstitialAd;
        return interstitialAd;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        Map<MultiKey, AdMobInterstitialAdapter> map;
        if (!ReflectionUtils.canFindClass("com.google.android.gms.ads.InterstitialAd")) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because AdMob SDK was not included, or Proguard was not configured properly");
            return null;
        }
        Map<MultiKey, AdMobInterstitialAdapter> map2 = map = instanceMap;
        synchronized (map2) {
            String string2 = jSONObject.optString("AdMobAdUnitID", jSONObject.optString("adUnitId"));
            if (TextUtils.isEmpty((CharSequence)string2)) {
                AerServLog.i(LOG_TAG, "Cannot get instance of adapter because AdMob ad unit ID is empty");
                return null;
            }
            MultiKey multiKey = new MultiKey(string, string2);
            AdMobInterstitialAdapter adMobInterstitialAdapter = (AdMobInterstitialAdapter)instanceMap.get((Object)multiKey);
            if (adMobInterstitialAdapter == null) {
                adMobInterstitialAdapter = new AdMobInterstitialAdapter();
                instanceMap.put((Object)multiKey, (Object)adMobInterstitialAdapter);
            }
            return adMobInterstitialAdapter;
        }
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
    }

    @Override
    public void cleanup(Activity activity) {
        this.adListener = null;
        if (this.interstitialAd != null) {
            if (activity != null) {
                activity.runOnUiThread(new Runnable(this){
                    final /* synthetic */ AdMobInterstitialAdapter this$0;
                    {
                        this.this$0 = adMobInterstitialAdapter;
                    }

                    public void run() {
                        try {
                            if (AdMobInterstitialAdapter.access$000(this.this$0) != null) {
                                AdMobInterstitialAdapter.access$000(this.this$0).setAdListener(null);
                                AdMobInterstitialAdapter.access$002(this.this$0, null);
                                return;
                            }
                        }
                        catch (java.lang.Exception exception) {
                            AerServLog.i(AdMobInterstitialAdapter.access$200(), exception.getMessage());
                        }
                    }
                });
            } else {
                this.interstitialAd = null;
            }
        }
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        return this.interstitialAd != null && Boolean.TRUE.equals(adLoadedMap.get((Object)this.hashCode())) && adShownMap.get((Object)this.hashCode()) == null;
    }

    @Override
    public boolean hasPartnerAdLoadFailedDueToConnectionError() {
        return Boolean.TRUE.equals(adLoadedFailedDueToConectionErrorMap.get((Object)this.hashCode()));
    }

    @Override
    public Boolean hasPartnerAdLoaded(boolean bl) {
        return (Boolean)adLoadedMap.get((Object)this.hashCode());
    }

    @Override
    public Boolean hasPartnerAdShown(boolean bl) {
        return (Boolean)adShownMap.get((Object)this.hashCode());
    }

    @Override
    public void loadPartnerAd(Activity activity, JSONObject jSONObject, boolean bl, boolean bl2) {
        adLoadedMap.remove((Object)this.hashCode());
        adShownMap.remove((Object)this.hashCode());
        adLoadedFailedDueToConectionErrorMap.put((Object)this.hashCode(), (Object)Boolean.FALSE);
        String string = this.makeUpperCaseMD5AndroidId(activity);
        String string2 = jSONObject.optString("AdMobAdUnitID", jSONObject.optString("adUnitId"));
        if (TextUtils.isEmpty((CharSequence)string2)) {
            adLoadedMap.put((Object)this.hashCode(), (Object)Boolean.FALSE);
            return;
        }
        this.adListener = new AdListenerImp(this.hashCode());
        this.interstitialAd = new InterstitialAd((Context)activity);
        this.interstitialAd.setAdUnitId(string2);
        this.interstitialAd.setAdListener((AdListener)this.adListener);
        AdRequest adRequest = bl2 ? new AdRequest.Builder().addTestDevice(string).build() : new AdRequest.Builder().build();
        activity.runOnUiThread(new Runnable(this, adRequest){
            final /* synthetic */ AdMobInterstitialAdapter this$0;
            final /* synthetic */ AdRequest val$adRequest;
            {
                this.this$0 = adMobInterstitialAdapter;
                this.val$adRequest = adRequest;
            }

            public void run() {
                if (AdMobInterstitialAdapter.access$000(this.this$0) == null) {
                    AdMobInterstitialAdapter.access$100().put((Object)this.hashCode(), (Object)Boolean.FALSE);
                    return;
                }
                AdMobInterstitialAdapter.access$000(this.this$0).loadAd(this.val$adRequest);
            }
        });
    }

    protected String makeUpperCaseMD5AndroidId(Activity activity) {
        MessageDigest messageDigest;
        String string = Settings.Secure.getString((ContentResolver)activity.getContentResolver(), (String)"android_id");
        try {
            messageDigest = MessageDigest.getInstance((String)"MD5");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            messageDigest = null;
        }
        messageDigest.reset();
        messageDigest.update(string.getBytes());
        return new BigInteger(1, messageDigest.digest()).toString(16).toUpperCase();
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        adShownMap.remove((Object)this.hashCode());
        this.adListener.setAdapterListener(adapterListener);
        activity.runOnUiThread(new Runnable(this){
            final /* synthetic */ AdMobInterstitialAdapter this$0;
            {
                this.this$0 = adMobInterstitialAdapter;
            }

            public void run() {
                if (AdMobInterstitialAdapter.access$000(this.this$0) != null && AdMobInterstitialAdapter.access$000(this.this$0).isLoaded()) {
                    AdMobInterstitialAdapter.access$000(this.this$0).show();
                    return;
                }
                AerServLog.d(AdMobInterstitialAdapter.access$200(), "Cannot show ad because interstitialAd object is null");
                AdMobInterstitialAdapter.access$400().put((Object)this.hashCode(), (Object)Boolean.FALSE);
                AdMobInterstitialAdapter.access$100().remove((Object)this.hashCode());
                AdMobInterstitialAdapter.access$300().put((Object)this.hashCode(), (Object)Boolean.FALSE);
            }
        });
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }

    private static class AdListenerImp
    extends AdListener {
        private final int instanceHashcode;
        private AdapterListener listener;

        AdListenerImp(int n2) {
            this.instanceHashcode = n2;
        }

        public void onAdClosed() {
            AerServLog.v(LOG_TAG, "AdMob onAdClosed()");
            AdapterListener adapterListener = this.listener;
            if (adapterListener != null) {
                adapterListener.onAdDismissed();
            }
        }

        public void onAdFailedToLoad(int n2) {
            String string;
            if (n2 != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        string = n2 != 3 ? "Unknown" : "No fill";
                    } else {
                        adLoadedFailedDueToConectionErrorMap.put((Object)this.instanceHashcode, (Object)Boolean.TRUE);
                        string = "Network error";
                    }
                } else {
                    adLoadedFailedDueToConectionErrorMap.put((Object)this.instanceHashcode, (Object)Boolean.TRUE);
                    string = "Invalid request";
                }
            } else {
                adLoadedFailedDueToConectionErrorMap.put((Object)this.instanceHashcode, (Object)Boolean.TRUE);
                string = "Internal error";
            }
            String string2 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AdMob onAdFailedToLoad(): ");
            stringBuilder.append(string);
            AerServLog.d(string2, stringBuilder.toString());
            adLoadedMap.put((Object)this.instanceHashcode, (Object)Boolean.FALSE);
        }

        public void onAdLeftApplication() {
            AerServLog.v(LOG_TAG, "AdMob onAdLeftApplication()");
            AdapterListener adapterListener = this.listener;
            if (adapterListener != null) {
                adapterListener.onAdClicked();
            }
        }

        public void onAdLoaded() {
            AerServLog.v(LOG_TAG, "AdMob onAdLoaded()");
            adLoadedMap.put((Object)this.instanceHashcode, (Object)Boolean.TRUE);
        }

        public void onAdOpened() {
            AerServLog.v(LOG_TAG, "AdMob onAdOpened()");
            adShownMap.put((Object)this.instanceHashcode, (Object)Boolean.TRUE);
            AdapterListener adapterListener = this.listener;
            if (adapterListener != null) {
                adapterListener.onAdImpression();
            }
        }

        public void setAdapterListener(AdapterListener adapterListener) {
            this.listener = adapterListener;
        }
    }

}

