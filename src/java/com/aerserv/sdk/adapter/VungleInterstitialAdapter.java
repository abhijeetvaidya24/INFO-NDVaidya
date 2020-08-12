/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  com.vungle.publisher.AdConfig
 *  com.vungle.publisher.VungleAdEventListener
 *  com.vungle.publisher.VungleInitListener
 *  com.vungle.publisher.VunglePub
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.adapter.VungleInterstitialAdapter;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.CommonUtils;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.aerserv.sdk.utils.VersionUtils;
import com.vungle.publisher.AdConfig;
import com.vungle.publisher.VungleAdEventListener;
import com.vungle.publisher.VungleInitListener;
import com.vungle.publisher.VunglePub;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VungleInterstitialAdapter
extends Adapter {
    private static volatile boolean INIT_FAILED = false;
    private static final String LOG_TAG = "VungleInterstitialAdapter";
    private static final Map<MultiKey, VungleInterstitialAdapter> instanceMap;
    private static AtomicBoolean vungleAdManuallyLoadedFlag;
    private static final VunglePub vunglePub;
    private Boolean adLoaded = null;
    private Boolean adShown = null;
    private String placement = null;
    private VungleAdEventListener vungleDefaultListener = null;

    static {
        vunglePub = VunglePub.getInstance();
        INIT_FAILED = false;
        instanceMap = new HashMap();
        vungleAdManuallyLoadedFlag = new AtomicBoolean();
    }

    private VungleInterstitialAdapter(String string) {
        this.placement = string;
    }

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ boolean access$102(boolean bl) {
        INIT_FAILED = bl;
        return bl;
    }

    static /* synthetic */ Boolean access$202(VungleInterstitialAdapter vungleInterstitialAdapter, Boolean bl) {
        vungleInterstitialAdapter.adShown = bl;
        return bl;
    }

    static /* synthetic */ Boolean access$302(VungleInterstitialAdapter vungleInterstitialAdapter, Boolean bl) {
        vungleInterstitialAdapter.adLoaded = bl;
        return bl;
    }

    public static Adapter getInstance(String string, JSONObject jSONObject) {
        String string2;
        block12 : {
            if (INIT_FAILED) {
                AerServLog.i(LOG_TAG, "Vungle: not initialized. skip");
                return null;
            }
            if (!VersionUtils.checkVersion(14)) {
                AerServLog.i(LOG_TAG, "Vungle: Cannot not initialize Vungle SDK because the adapter needs Android Ice Cream Sandwich or later");
                return null;
            }
            if (!ReflectionUtils.canFindClass("com.vungle.publisher.VunglePub")) {
                AerServLog.i(LOG_TAG, "Vungle: Cannot initialize Vungle SDK because its libraries were not included, or Proguard was not configured properly");
                return null;
            }
            if (jSONObject.has("placementIds")) {
                block11 : {
                    try {
                        JSONArray jSONArray = jSONObject.getJSONArray("placementIds");
                        if (jSONArray.length() <= 0) break block11;
                        string2 = jSONArray.optString(0);
                        break block12;
                    }
                    catch (JSONException jSONException) {
                        String string3 = LOG_TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Vungle: Error reading credentials ");
                        stringBuilder.append(jSONException.getMessage());
                        AerServLog.w(string3, stringBuilder.toString());
                    }
                }
                string2 = null;
            } else {
                string2 = jSONObject.optString("placementId");
            }
        }
        if (TextUtils.isEmpty((CharSequence)string2)) {
            AerServLog.i(LOG_TAG, "Vungle: Cannot get instance because placement Id is empty.");
            return null;
        }
        String string4 = jSONObject.optString("appId");
        if (TextUtils.isEmpty((CharSequence)string4)) {
            AerServLog.i(LOG_TAG, "Vungle: Cannot get instance because app ID is empty");
            return null;
        }
        long l2 = -500 + AerServSettings.getStep3Timeout();
        while (!vunglePub.isInitialized() && (l2 -= 100L) > 0L) {
            CommonUtils.sleepInMillisSeconds(100L);
        }
        if (!vunglePub.isInitialized()) {
            AerServLog.w(LOG_TAG, "Vungle: not initialized yet. skip");
            return null;
        }
        return (Adapter)instanceMap.get((Object)new MultiKey(string2, string4));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static void initPartnerSdk(Activity var0, JSONArray var1_1) {
        if (var1_1 == null || var1_1.length() < 1) {
            AerServLog.i(VungleInterstitialAdapter.LOG_TAG, "Could not initialize Vungle SDK because credentials list is empty");
            return;
        }
        var2_2 = new ArrayList();
        var3_3 = null;
        var4_4 = 0;
        do {
            block22 : {
                block24 : {
                    block23 : {
                        block25 : {
                            if (var4_4 >= var1_1.length()) ** GOTO lbl16
                            var11_10 = var1_1.getJSONObject(var4_4);
                            var12_11 = var11_10.optString("appId");
                            if (TextUtils.isEmpty((CharSequence)var12_11)) {
                                AerServLog.i(VungleInterstitialAdapter.LOG_TAG, "Vungle: App ID is empty. skip.");
                                break block22;
                            }
                            break block25;
lbl16: // 1 sources:
                            if (TextUtils.isEmpty(var3_3)) {
                                AerServLog.w(VungleInterstitialAdapter.LOG_TAG, "Vungle: Cannot initialize because app ID is empty");
                                return;
                            }
                            if (VungleInterstitialAdapter.instanceMap.size() == 0) {
                                AerServLog.w(VungleInterstitialAdapter.LOG_TAG, "Vungle: Cannot initialize because placement list is empty");
                                return;
                            }
                            VungleInterstitialAdapter.vunglePub.init((Context)var0, var3_3, (String[])var2_2.toArray((Object[])new String[var2_2.size()]), new VungleInitListener(){

                                public void onFailure(java.lang.Throwable throwable) {
                                    VungleInterstitialAdapter.access$102(true);
                                    String string = VungleInterstitialAdapter.access$000();
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Vungle: init failed: ");
                                    stringBuilder.append(throwable.getLocalizedMessage());
                                    AerServLog.w(string, stringBuilder.toString());
                                }

                                public void onSuccess() {
                                    AerServLog.d(VungleInterstitialAdapter.access$000(), "Vungle: init success.");
                                }
                            });
                            return;
                        }
                        if (var3_3 == null) {
                            var3_3 = var12_11;
                            break block23;
                        }
                        if (var3_3.equals((Object)var12_11)) break block23;
                        AerServLog.i(VungleInterstitialAdapter.LOG_TAG, "Vungle: 2 different App IDs. skip.");
                    }
                    try {
                        if (!var11_10.has("placementIds")) ** GOTO lbl-1000
                        var24_18 = var11_10.getJSONArray("placementIds");
                        break block24;
                    }
                    catch (JSONException var13_12) {
                        try {
                            var14_13 = VungleInterstitialAdapter.LOG_TAG;
                            var15_14 = new StringBuilder();
                            var15_14.append("Vungle: Error reading credentials ");
                            var15_14.append(var13_12.getMessage());
                            AerServLog.i(var14_13, var15_14.toString());
                            break block22;
                        }
                        catch (JSONException var5_7) {
                            var6_8 = VungleInterstitialAdapter.LOG_TAG;
                            var7_9 = new StringBuilder();
                            var7_9.append("Vungle: Error reading credentials: ");
                            var7_9.append(var5_7.getMessage());
                            var7_9.append(".  Skipping to next set of credentials.");
                            AerServLog.i(var6_8, var7_9.toString());
                        }
                    }
lbl-1000: // 1 sources:
                    {
                        var18_15 = var11_10.optString("placementId");
                        if (TextUtils.isEmpty((CharSequence)var18_15)) {
                            AerServLog.i(VungleInterstitialAdapter.LOG_TAG, "Vungle: placementId is empty. skip.");
                            break block22;
                        }
                        var19_16 = new MultiKey(new Object[]{var18_15, var3_3});
                        var33_6 = var20_17 = VungleInterstitialAdapter.instanceMap;
                        // MONITORENTER : var33_6
                    }
                    if (!VungleInterstitialAdapter.instanceMap.containsKey((Object)var19_16)) {
                        VungleInterstitialAdapter.instanceMap.put((Object)var19_16, (Object)new VungleInterstitialAdapter(var18_15));
                        var2_2.add((Object)var18_15);
                    }
                    // MONITOREXIT : var33_6
                    break block22;
                    break block22;
                }
                for (var25_19 = 0; var25_19 < var24_18.length(); ++var25_19) {
                    var26_20 = var24_18.optString(var25_19);
                    var27_21 = new MultiKey(new Object[]{var26_20, var3_3});
                    var32_5 = var28_22 = VungleInterstitialAdapter.instanceMap;
                    // MONITORENTER : var32_5
                    if (!VungleInterstitialAdapter.instanceMap.containsKey((Object)var27_21)) {
                        VungleInterstitialAdapter.instanceMap.put((Object)var27_21, (Object)new VungleInterstitialAdapter(var26_20));
                        var2_2.add((Object)var26_20);
                    }
                    // MONITOREXIT : var32_5
                }
            }
            ++var4_4;
        } while (true);
    }

    @Override
    public boolean CASAdManuallyLoadedFlag(boolean bl) {
        return vungleAdManuallyLoadedFlag.compareAndSet(bl ^ true, bl);
    }

    @Override
    public void cleanup(Activity activity) {
        VungleAdEventListener vungleAdEventListener = this.vungleDefaultListener;
        if (vungleAdEventListener != null) {
            vunglePub.removeEventListeners(new VungleAdEventListener[]{vungleAdEventListener});
        }
        this.vungleDefaultListener = null;
        this.CASAdManuallyLoadedFlag(false);
    }

    @Override
    public boolean hasAd(boolean bl) {
        return vunglePub.isInitialized() && vunglePub.isAdPlayable(this.placement);
    }

    @Override
    public boolean hasPartnerAdLoadFailedDueToConnectionError() {
        return false;
    }

    @Override
    public Boolean hasPartnerAdLoaded(boolean bl) {
        if (this.adLoaded == null && vunglePub.isInitialized() && vunglePub.isAdPlayable(this.placement)) {
            this.adLoaded = true;
        }
        return this.adLoaded;
    }

    @Override
    public Boolean hasPartnerAdShown(boolean bl) {
        return this.adShown;
    }

    @Override
    public void loadPartnerAd(Activity activity, JSONObject jSONObject, boolean bl, boolean bl2) {
        this.adLoaded = null;
        this.adShown = false;
        if (vunglePub.isInitialized()) {
            vunglePub.loadAd(this.placement);
        }
    }

    @Override
    public void showPartnerAd(Activity activity, boolean bl, AdapterListener adapterListener) {
        this.adShown = null;
        if (vunglePub.isInitialized() && vunglePub.isAdPlayable(this.placement)) {
            this.vungleDefaultListener = new VungleAdEventListener(this, adapterListener){
                final /* synthetic */ VungleInterstitialAdapter this$0;
                final /* synthetic */ AdapterListener val$listener;
                {
                    this.this$0 = vungleInterstitialAdapter;
                    this.val$listener = adapterListener;
                }

                public void onAdAvailabilityUpdate(String string, boolean bl) {
                    String string2 = VungleInterstitialAdapter.access$000();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Vungle ");
                    stringBuilder.append(string);
                    stringBuilder.append(" ad playable changed to ");
                    stringBuilder.append(bl);
                    AerServLog.v(string2, stringBuilder.toString());
                    VungleInterstitialAdapter.access$302(this.this$0, bl);
                }

                public void onAdEnd(String string, boolean bl, boolean bl2) {
                    String string2 = VungleInterstitialAdapter.access$000();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Vungle onAdEnd() ");
                    stringBuilder.append(string);
                    stringBuilder.append(" ,wasSuccessfulView: ");
                    stringBuilder.append(bl);
                    stringBuilder.append(" ,wasCallToActionClicked: ");
                    stringBuilder.append(bl2);
                    AerServLog.v(string2, stringBuilder.toString());
                    AdapterListener adapterListener = this.val$listener;
                    if (adapterListener != null) {
                        if (bl2) {
                            adapterListener.onAdClicked();
                        }
                        if (bl) {
                            this.val$listener.onVideoComplete();
                        }
                        try {
                            java.lang.Thread.sleep((long)200L);
                        }
                        catch (java.lang.InterruptedException interruptedException) {
                            interruptedException.printStackTrace();
                        }
                        this.val$listener.onAdDismissed();
                    }
                }

                public void onAdStart(String string) {
                    String string2 = VungleInterstitialAdapter.access$000();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Vungle onAdStart(): ");
                    stringBuilder.append(string);
                    AerServLog.v(string2, stringBuilder.toString());
                    VungleInterstitialAdapter.access$202(this.this$0, true);
                    AdapterListener adapterListener = this.val$listener;
                    if (adapterListener != null) {
                        adapterListener.onAdImpression();
                        this.val$listener.onVideoStart();
                    }
                }

                public void onUnableToPlayAd(String string, String string2) {
                    String string3 = VungleInterstitialAdapter.access$000();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Vungle onUnableToPlayAd: ");
                    stringBuilder.append(string);
                    stringBuilder.append(" ,reason: ");
                    stringBuilder.append(string2);
                    AerServLog.v(string3, stringBuilder.toString());
                    VungleInterstitialAdapter.access$302(this.this$0, false);
                }
            };
            VunglePub vunglePub = VungleInterstitialAdapter.vunglePub;
            VungleAdEventListener[] arrvungleAdEventListener = new VungleAdEventListener[]{this.vungleDefaultListener};
            vunglePub.clearAndSetEventListeners(arrvungleAdEventListener);
            VungleInterstitialAdapter.vunglePub.playAd(this.placement, null);
            return;
        }
        AerServLog.i(LOG_TAG, "Vungle isAdPlayable() is false.  Cannot show ad.");
        this.adShown = false;
    }

    @Override
    public boolean supportsRewardedCallback() {
        return false;
    }
}

