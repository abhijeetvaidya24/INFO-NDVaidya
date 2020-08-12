/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.my.target.ads.InterstitialAd
 *  com.my.target.ads.InterstitialAd$InterstitialAdListener
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.content.Context;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.adapter.MyTargetSdkInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.CommonUtils;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.my.target.ads.InterstitialAd;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class MyTargetSdkInterstitialAdapter
extends Adapter {
    private static final String LOG_TAG = "MyTargetSdkInterstitialAdapter";
    private static final Map<MultiKey, MyTargetSdkInterstitialAdapter> instanceMap = new HashMap();
    private Boolean adLoaded = null;
    private Boolean adShown = null;
    private InterstitialAd interstitialAd = null;
    private AdapterListener listener = null;

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ Boolean access$102(MyTargetSdkInterstitialAdapter myTargetSdkInterstitialAdapter, Boolean bl) {
        myTargetSdkInterstitialAdapter.adLoaded = bl;
        return bl;
    }

    static /* synthetic */ AdapterListener access$200(MyTargetSdkInterstitialAdapter myTargetSdkInterstitialAdapter) {
        return myTargetSdkInterstitialAdapter.listener;
    }

    static /* synthetic */ Boolean access$302(MyTargetSdkInterstitialAdapter myTargetSdkInterstitialAdapter, Boolean bl) {
        myTargetSdkInterstitialAdapter.adShown = bl;
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Adapter getInstance(String string, JSONObject jSONObject) {
        Map<MultiKey, MyTargetSdkInterstitialAdapter> map;
        if (!ReflectionUtils.canFindClass("com.my.target.ads.InterstitialAd")) {
            AerServLog.i(LOG_TAG, "Cannot get instance of adapter because MyTarget SDK was not included, or Proguard was not configured properly");
            return null;
        }
        Map<MultiKey, MyTargetSdkInterstitialAdapter> map2 = map = instanceMap;
        synchronized (map2) {
            int n2 = CommonUtils.getInt(jSONObject, 0, "MyTargetSlotId", "slotId");
            if (n2 == 0) {
                AerServLog.i(LOG_TAG, "Cannot get instance of adater because MyTarget slot ID cannot be read");
                return null;
            }
            Object[] arrobject = new Object[]{string, n2};
            MultiKey multiKey = new MultiKey(arrobject);
            MyTargetSdkInterstitialAdapter myTargetSdkInterstitialAdapter = (MyTargetSdkInterstitialAdapter)instanceMap.get((Object)multiKey);
            if (myTargetSdkInterstitialAdapter == null) {
                myTargetSdkInterstitialAdapter = new MyTargetSdkInterstitialAdapter();
                instanceMap.put((Object)multiKey, (Object)myTargetSdkInterstitialAdapter);
            }
            return myTargetSdkInterstitialAdapter;
        }
    }

    public static void initPartnerSdk(Activity activity, JSONArray jSONArray) {
    }

    @Override
    public void cleanup(Activity activity) {
        this.interstitialAd = null;
        this.listener = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        return this.interstitialAd != null && Boolean.TRUE.equals((Object)this.adLoaded) && this.adShown == null;
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
        this.adShown = null;
        int n2 = CommonUtils.getInt(jSONObject, 0, "MyTargetSlotId", "slotId");
        if (n2 == 0) {
            AerServLog.i(LOG_TAG, "Cannot load MyTarget ad because slot ID cannot be read");
            this.adLoaded = false;
            return;
        }
        this.interstitialAd = new InterstitialAd(n2, (Context)activity);
        this.interstitialAd.setListener(new InterstitialAd.InterstitialAdListener(this){
            final /* synthetic */ MyTargetSdkInterstitialAdapter this$0;
            {
                this.this$0 = myTargetSdkInterstitialAdapter;
            }

            public void onClick(InterstitialAd interstitialAd) {
                AerServLog.v(MyTargetSdkInterstitialAdapter.access$000(), "MyTarget onClick()");
                if (MyTargetSdkInterstitialAdapter.access$200(this.this$0) != null) {
                    MyTargetSdkInterstitialAdapter.access$200(this.this$0).onAdClicked();
                }
            }

            public void onDismiss(InterstitialAd interstitialAd) {
                AerServLog.v(MyTargetSdkInterstitialAdapter.access$000(), "MyTarget onDismiss()");
                if (MyTargetSdkInterstitialAdapter.access$200(this.this$0) != null) {
                    MyTargetSdkInterstitialAdapter.access$200(this.this$0).onAdDismissed();
                }
            }

            public void onDisplay(InterstitialAd interstitialAd) {
                AerServLog.v(MyTargetSdkInterstitialAdapter.access$000(), "MyTarget onDisplay()");
                MyTargetSdkInterstitialAdapter.access$302(this.this$0, true);
                if (MyTargetSdkInterstitialAdapter.access$200(this.this$0) != null) {
                    MyTargetSdkInterstitialAdapter.access$200(this.this$0).onAdImpression();
                }
            }

            public void onLoad(InterstitialAd interstitialAd) {
                AerServLog.v(MyTargetSdkInterstitialAdapter.access$000(), "MyTarget onLoad()");
                MyTargetSdkInterstitialAdapter.access$102(this.this$0, true);
            }

            public void onNoAd(String string, InterstitialAd interstitialAd) {
                String string2 = MyTargetSdkInterstitialAdapter.access$000();
                java.lang.StringBuilder stringBuilder = new java.lang.StringBuilder();
                stringBuilder.append("MyTarget onNoAd(): ");
                stringBuilder.append(string);
                AerServLog.d(string2, stringBuilder.toString());
                MyTargetSdkInterstitialAdapter.access$102(this.this$0, false);
            }

            public void onVideoCompleted(InterstitialAd interstitialAd) {
                AerServLog.v(MyTargetSdkInterstitialAdapter.access$000(), "MyTarget onVideoCompleted()");
                if (MyTargetSdkInterstitialAdapter.access$200(this.this$0) != null) {
                    MyTargetSdkInterstitialAdapter.access$200(this.this$0).onVideoComplete();
                }
            }
        });
        this.interstitialAd.load();
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.adShown = null;
        this.listener = adapterListener;
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.show();
            return;
        }
        AerServLog.d(LOG_TAG, "Cannot show ad because interstitialAd object is null");
        this.adShown = false;
        this.adLoaded = null;
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }
}

