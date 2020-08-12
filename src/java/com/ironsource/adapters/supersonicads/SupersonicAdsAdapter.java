/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.concurrent.CopyOnWriteArrayList
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.adapters.supersonicads;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.adapters.supersonicads.SupersonicAdsAdapter;
import com.ironsource.adapters.supersonicads.SupersonicConfig;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.InternalOfferwallListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.OfferwallAdapterApi;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import com.ironsource.sdk.SSAPublisher;
import com.ironsource.sdk.data.AdUnitsReady;
import com.ironsource.sdk.listeners.OnInterstitialListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.OnRewardedVideoListener;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class SupersonicAdsAdapter
extends AbstractAdapter
implements OfferwallAdapterApi,
OnInterstitialListener,
OnOfferWallListener,
OnRewardedVideoListener {
    private static final String VERSION = "6.7.10";
    private final String AD_VISIBLE_EVENT_NAME = "impressions";
    private final String APPLICATION_PRIVATE_KEY = "privateKey";
    private final String APPLICATION_USER_AGE_GROUP = "applicationUserAgeGroup";
    private final String APPLICATION_USER_GENDER = "applicationUserGender";
    private final String CAMPAIGN_ID = "campaignId";
    private final String CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String CUSTOM_PARAM_PREFIX = "custom_";
    private final String CUSTOM_SEGMENT = "custom_Segment";
    private final String DYNAMIC_CONTROLLER_CONFIG = "controllerConfig";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String ITEM_COUNT = "itemCount";
    private final String ITEM_NAME = "itemName";
    private final String ITEM_SIGNATURE = "itemSignature";
    private final String LANGUAGE = "language";
    private final String MAX_VIDEO_LENGTH = "maxVideoLength";
    private final String OW_PLACEMENT_ID = "placementId";
    private final String SDK_PLUGIN_TYPE = "SDKPluginType";
    private final String TIMESTAMP = "timestamp";
    private boolean mConsent;
    private boolean mDidSetConsent;
    private boolean mDidSetInitParams = false;
    private boolean mIsRVAvailable = false;
    private String mMediationSegment;
    private InternalOfferwallListener mOfferwallListener;
    private SSAPublisher mSSAPublisher;
    private String mUserAgeGroup;
    private String mUserGender;

    private SupersonicAdsAdapter(String string) {
        super(string);
    }

    static /* synthetic */ SSAPublisher access$000(SupersonicAdsAdapter supersonicAdsAdapter) {
        return supersonicAdsAdapter.mSSAPublisher;
    }

    static /* synthetic */ SSAPublisher access$002(SupersonicAdsAdapter supersonicAdsAdapter, SSAPublisher sSAPublisher) {
        supersonicAdsAdapter.mSSAPublisher = sSAPublisher;
        return sSAPublisher;
    }

    static /* synthetic */ HashMap access$100(SupersonicAdsAdapter supersonicAdsAdapter, JSONObject jSONObject) {
        return supersonicAdsAdapter.getRewardedVideoExtraParams(jSONObject);
    }

    static /* synthetic */ boolean access$200(SupersonicAdsAdapter supersonicAdsAdapter) {
        return supersonicAdsAdapter.mDidSetConsent;
    }

    static /* synthetic */ boolean access$300(SupersonicAdsAdapter supersonicAdsAdapter) {
        return supersonicAdsAdapter.mConsent;
    }

    static /* synthetic */ void access$400(SupersonicAdsAdapter supersonicAdsAdapter, boolean bl) {
        supersonicAdsAdapter.applyConsent(bl);
    }

    static /* synthetic */ HashMap access$500(SupersonicAdsAdapter supersonicAdsAdapter) {
        return supersonicAdsAdapter.getInterstitialExtraParams();
    }

    static /* synthetic */ HashMap access$600(SupersonicAdsAdapter supersonicAdsAdapter, JSONObject jSONObject) {
        return supersonicAdsAdapter.getOfferwallExtraParams(jSONObject);
    }

    static /* synthetic */ InternalOfferwallListener access$700(SupersonicAdsAdapter supersonicAdsAdapter) {
        return supersonicAdsAdapter.mOfferwallListener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void addItemNameCountSignature(HashMap<String, String> hashMap, JSONObject jSONObject) {
        String string;
        boolean bl;
        int n2;
        String string2;
        block5 : {
            try {
                string2 = jSONObject.optString("itemName");
                n2 = jSONObject.optInt("itemCount", -1);
                string = jSONObject.optString("privateKey");
                bl = true;
                if (TextUtils.isEmpty((CharSequence)string2)) {
                    bl = false;
                } else {
                    hashMap.put((Object)"itemName", (Object)string2);
                }
                if (!TextUtils.isEmpty((CharSequence)string)) break block5;
                bl = false;
            }
            catch (Exception exception) {
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.ADAPTER_API, " addItemNameCountSignature", exception);
                return;
            }
        }
        if (n2 == -1) {
            return;
        }
        hashMap.put((Object)"itemCount", (Object)String.valueOf((int)n2));
        if (!bl) return;
        int n3 = IronSourceUtils.getCurrentTimestamp();
        hashMap.put((Object)"timestamp", (Object)String.valueOf((int)n3));
        hashMap.put((Object)"itemSignature", (Object)this.createItemSig(n3, string2, n2, string));
    }

    private void applyConsent(boolean bl) {
        if (this.mSSAPublisher == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gdprConsentStatus", (Object)String.valueOf((boolean)bl));
            jSONObject.put("demandSourceName", (Object)this.getProviderName());
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        this.mSSAPublisher.updateConsentInfo(jSONObject);
    }

    private String createItemSig(int n2, String string, int n3, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n2);
        stringBuilder.append(string);
        stringBuilder.append(n3);
        stringBuilder.append(string2);
        return IronSourceUtils.getMD5(stringBuilder.toString());
    }

    private String createMinimumOfferCommissionSig(double d2, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d2);
        stringBuilder.append(string);
        return IronSourceUtils.getMD5(stringBuilder.toString());
    }

    private String createUserCreationDateSig(String string, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        return IronSourceUtils.getMD5(stringBuilder.toString());
    }

    private HashMap<String, String> getGenenralExtraParams() {
        String string;
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty((CharSequence)this.mUserAgeGroup)) {
            hashMap.put((Object)"applicationUserAgeGroup", (Object)this.mUserAgeGroup);
        }
        if (!TextUtils.isEmpty((CharSequence)this.mUserGender)) {
            hashMap.put((Object)"applicationUserGender", (Object)this.mUserGender);
        }
        if (!TextUtils.isEmpty((CharSequence)(string = this.getPluginType()))) {
            hashMap.put((Object)"SDKPluginType", (Object)string);
        }
        return hashMap;
    }

    public static IntegrationData getIntegrationData(Activity activity) {
        IntegrationData integrationData = new IntegrationData("SupersonicAds", VERSION);
        integrationData.activities = new String[]{"com.ironsource.sdk.controller.ControllerActivity", "com.ironsource.sdk.controller.InterstitialActivity", "com.ironsource.sdk.controller.OpenUrlActivity"};
        return integrationData;
    }

    private HashMap<String, String> getInterstitialExtraParams() {
        return this.getGenenralExtraParams();
    }

    private HashMap<String, String> getOfferwallExtraParams(JSONObject jSONObject) {
        HashMap<String, String> hashMap = this.getGenenralExtraParams();
        String string = jSONObject.optString("language");
        if (!TextUtils.isEmpty((CharSequence)string)) {
            hashMap.put((Object)"language", (Object)string);
        }
        hashMap.put((Object)"useClientSideCallbacks", (Object)String.valueOf((boolean)SupersonicConfig.getConfigObj().getClientSideCallbacks()));
        Map<String, String> map = SupersonicConfig.getConfigObj().getOfferwallCustomParams();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        this.addItemNameCountSignature(hashMap, jSONObject);
        return hashMap;
    }

    private HashMap<String, String> getRewardedVideoExtraParams(JSONObject jSONObject) {
        String string;
        String string2;
        HashMap<String, String> hashMap = this.getGenenralExtraParams();
        String string3 = jSONObject.optString("language");
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            hashMap.put((Object)"language", (Object)string3);
        }
        if (!TextUtils.isEmpty((CharSequence)(string = jSONObject.optString("maxVideoLength")))) {
            hashMap.put((Object)"maxVideoLength", (Object)string);
        }
        if (!TextUtils.isEmpty((CharSequence)(string2 = jSONObject.optString("campaignId")))) {
            hashMap.put((Object)"campaignId", (Object)string2);
        }
        if (!TextUtils.isEmpty((CharSequence)this.mMediationSegment)) {
            hashMap.put((Object)"custom_Segment", (Object)this.mMediationSegment);
        }
        this.addItemNameCountSignature(hashMap, jSONObject);
        Map<String, String> map = SupersonicConfig.getConfigObj().getRewardedVideoCustomParams();
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    private void setParamsBeforeInit(JSONObject jSONObject) {
        SupersonicAdsAdapter supersonicAdsAdapter = this;
        synchronized (supersonicAdsAdapter) {
            this.mDidSetInitParams = true;
            SDKUtils.setControllerUrl(jSONObject.optString("controllerUrl"));
            if (this.isAdaptersDebugEnabled()) {
                SDKUtils.setDebugMode(3);
            } else {
                SDKUtils.setDebugMode(jSONObject.optInt("debugMode", 0));
            }
            SDKUtils.setControllerConfig(jSONObject.optString("controllerConfig", ""));
            return;
        }
    }

    public static SupersonicAdsAdapter startAdapter(String string) {
        return new SupersonicAdsAdapter(string);
    }

    @Override
    public void fetchRewardedVideo(JSONObject jSONObject) {
    }

    @Override
    public String getCoreSDKVersion() {
        return SDKUtils.getSDKVersion();
    }

    @Override
    public void getOfferwallCredits() {
        if (this.mSSAPublisher != null) {
            String string = IronSourceObject.getInstance().getIronSourceAppKey();
            String string2 = IronSourceObject.getInstance().getIronSourceUserId();
            this.mSSAPublisher.getOfferWallCredits(string, string2, this);
            return;
        }
        this.log(IronSourceLogger.IronSourceTag.NATIVE, "Please call init before calling getOfferwallCredits", 2);
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public void initInterstitial(Activity activity, String string, String string2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        if (!this.mDidSetInitParams) {
            this.setParamsBeforeInit(jSONObject);
        }
        activity.runOnUiThread(new Runnable(this, activity, string, string2){
            final /* synthetic */ SupersonicAdsAdapter this$0;
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ String val$appKey;
            final /* synthetic */ String val$userId;
            {
                this.this$0 = supersonicAdsAdapter;
                this.val$activity = activity;
                this.val$appKey = string;
                this.val$userId = string2;
            }

            public void run() {
                try {
                    SupersonicAdsAdapter.access$002(this.this$0, com.ironsource.sdk.SSAFactory.getPublisherInstance(this.val$activity));
                    HashMap hashMap = SupersonicAdsAdapter.access$500(this.this$0);
                    if (SupersonicAdsAdapter.access$200(this.this$0)) {
                        SupersonicAdsAdapter.access$400(this.this$0, SupersonicAdsAdapter.access$300(this.this$0));
                    }
                    SupersonicAdsAdapter.access$000(this.this$0).initInterstitial(this.val$appKey, this.val$userId, this.this$0.getProviderName(), (Map<String, String>)hashMap, this.this$0);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    this.this$0.onInterstitialInitFailed(exception.getMessage());
                    return;
                }
            }
        });
    }

    @Override
    public void initOfferwall(Activity activity, String string, String string2, JSONObject jSONObject) {
        if (!this.mDidSetInitParams) {
            this.setParamsBeforeInit(jSONObject);
        }
        Runnable runnable = new Runnable(this, jSONObject, activity, string, string2){
            final /* synthetic */ SupersonicAdsAdapter this$0;
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ String val$appKey;
            final /* synthetic */ JSONObject val$config;
            final /* synthetic */ String val$userId;
            {
                this.this$0 = supersonicAdsAdapter;
                this.val$config = jSONObject;
                this.val$activity = activity;
                this.val$appKey = string;
                this.val$userId = string2;
            }

            public void run() {
                try {
                    HashMap hashMap = SupersonicAdsAdapter.access$600(this.this$0, this.val$config);
                    SupersonicAdsAdapter.access$002(this.this$0, com.ironsource.sdk.SSAFactory.getPublisherInstance(this.val$activity));
                    if (SupersonicAdsAdapter.access$200(this.this$0)) {
                        SupersonicAdsAdapter.access$400(this.this$0, SupersonicAdsAdapter.access$300(this.this$0));
                    }
                    SupersonicAdsAdapter.access$000(this.this$0).initOfferWall(this.val$appKey, this.val$userId, (Map<String, String>)hashMap, this.this$0);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.this$0.getProviderName());
                    stringBuilder.append(":initOfferwall(userId:");
                    stringBuilder.append(this.val$userId);
                    stringBuilder.append(")");
                    ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), exception);
                    InternalOfferwallListener internalOfferwallListener = SupersonicAdsAdapter.access$700(this.this$0);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Adapter initialization failure - ");
                    stringBuilder2.append(this.this$0.getProviderName());
                    stringBuilder2.append(" - ");
                    stringBuilder2.append(exception.getMessage());
                    internalOfferwallListener.onOfferwallAvailable(false, ErrorBuilder.buildInitFailedError(stringBuilder2.toString(), "Offerwall"));
                    return;
                }
            }
        };
        activity.runOnUiThread(runnable);
    }

    @Override
    public void initRewardedVideo(Activity activity, String string, String string2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        if (!this.mDidSetInitParams) {
            this.setParamsBeforeInit(jSONObject);
        }
        Runnable runnable = new Runnable(this, activity, jSONObject, string, string2){
            final /* synthetic */ SupersonicAdsAdapter this$0;
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ String val$appKey;
            final /* synthetic */ JSONObject val$config;
            final /* synthetic */ String val$userId;
            {
                this.this$0 = supersonicAdsAdapter;
                this.val$activity = activity;
                this.val$config = jSONObject;
                this.val$appKey = string;
                this.val$userId = string2;
            }

            public void run() {
                try {
                    SupersonicAdsAdapter.access$002(this.this$0, com.ironsource.sdk.SSAFactory.getPublisherInstance(this.val$activity));
                    HashMap hashMap = SupersonicAdsAdapter.access$100(this.this$0, this.val$config);
                    if (SupersonicAdsAdapter.access$200(this.this$0)) {
                        SupersonicAdsAdapter.access$400(this.this$0, SupersonicAdsAdapter.access$300(this.this$0));
                    }
                    SupersonicAdsAdapter.access$000(this.this$0).initRewardedVideo(this.val$appKey, this.val$userId, this.this$0.getProviderName(), (Map<String, String>)hashMap, this.this$0);
                    return;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    this.this$0.onRVInitFail("initRewardedVideo");
                    return;
                }
            }
        };
        activity.runOnUiThread(runnable);
    }

    @Override
    public boolean isInterstitialReady(JSONObject jSONObject) {
        SSAPublisher sSAPublisher = this.mSSAPublisher;
        return sSAPublisher != null && sSAPublisher.isInterstitialAdAvailable(this.getProviderName());
    }

    public boolean isOfferwallAvailable() {
        return true;
    }

    @Override
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        SupersonicAdsAdapter supersonicAdsAdapter = this;
        synchronized (supersonicAdsAdapter) {
            boolean bl = this.mIsRVAvailable;
            return bl;
        }
    }

    @Override
    public void loadInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        if (this.mSSAPublisher != null) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("demandSourceName", (Object)this.getProviderName());
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            this.mSSAPublisher.loadInterstitial(jSONObject2);
            return;
        }
        this.log(IronSourceLogger.IronSourceTag.NATIVE, "Please call initInterstitial before calling loadInterstitial", 2);
        for (InterstitialSmashListener interstitialSmashListener2 : this.mAllInterstitialSmashes) {
            if (interstitialSmashListener2 == null) continue;
            interstitialSmashListener2.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Load was called before Init"));
        }
    }

    @Override
    public void onGetOWCreditsFailed(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onGetOWCreditsFailed ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mOfferwallListener != null) {
            IronSourceError ironSourceError = ErrorBuilder.buildGenericError(string);
            this.mOfferwallListener.onGetOfferwallCreditsFailed(ironSourceError);
        }
    }

    @Override
    public void onInterstitialClick() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onInterstitialAdClicked ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdClicked();
        }
    }

    @Override
    public void onInterstitialClose() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onInterstitialAdClosed ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdClosed();
        }
    }

    @Override
    public void onInterstitialEventNotificationReceived(String string, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(" :onInterstitialEventNotificationReceived: ");
            stringBuilder.append(string);
            stringBuilder.append(" extData: ");
            stringBuilder.append(jSONObject.toString());
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            if (!TextUtils.isEmpty((CharSequence)string) && "impressions".equals((Object)string) && this.mActiveInterstitialSmash != null) {
                this.mActiveInterstitialSmash.onInterstitialAdVisible();
            }
        }
    }

    @Override
    public void onInterstitialInitFailed(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onInterstitialInitFailed ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        for (InterstitialSmashListener interstitialSmashListener : this.mAllInterstitialSmashes) {
            if (interstitialSmashListener == null) continue;
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(string, "Interstitial"));
        }
    }

    @Override
    public void onInterstitialInitSuccess() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onInterstitialInitSuccess ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        for (InterstitialSmashListener interstitialSmashListener : this.mAllInterstitialSmashes) {
            if (interstitialSmashListener == null) continue;
            interstitialSmashListener.onInterstitialInitSuccess();
        }
    }

    @Override
    public void onInterstitialLoadFailed(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onInterstitialAdLoadFailed ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        for (InterstitialSmashListener interstitialSmashListener : this.mAllInterstitialSmashes) {
            if (interstitialSmashListener == null) continue;
            interstitialSmashListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError(string));
        }
    }

    @Override
    public void onInterstitialLoadSuccess() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onInterstitialLoadSuccess ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        for (InterstitialSmashListener interstitialSmashListener : this.mAllInterstitialSmashes) {
            if (interstitialSmashListener == null) continue;
            interstitialSmashListener.onInterstitialAdReady();
        }
    }

    @Override
    public void onInterstitialOpen() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onInterstitialAdOpened ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdOpened();
        }
    }

    @Override
    public void onInterstitialShowFailed(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onInterstitialAdShowFailed ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", string));
        }
    }

    @Override
    public void onInterstitialShowSuccess() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onInterstitialAdShowSucceeded ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdShowSucceeded();
        }
    }

    @Override
    public void onOWAdClosed() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onOWAdClosed ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        InternalOfferwallListener internalOfferwallListener = this.mOfferwallListener;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallClosed();
        }
    }

    @Override
    public boolean onOWAdCredited(int n2, int n3, boolean bl) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onOWAdCredited ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        InternalOfferwallListener internalOfferwallListener = this.mOfferwallListener;
        return internalOfferwallListener != null && internalOfferwallListener.onOfferwallAdCredited(n2, n3, bl);
    }

    @Override
    public void onOWGeneric(String string, String string2) {
    }

    @Override
    public void onOWShowFail(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onOWShowFail ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mOfferwallListener != null) {
            IronSourceError ironSourceError = ErrorBuilder.buildGenericError(string);
            this.mOfferwallListener.onOfferwallShowFailed(ironSourceError);
        }
    }

    @Override
    public void onOWShowSuccess(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(":onOWShowSuccess()");
            this.log(ironSourceTag, stringBuilder.toString(), 1);
        } else {
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(":onOWShowSuccess(placementId:");
            stringBuilder.append(string);
            stringBuilder.append(")");
            this.log(ironSourceTag, stringBuilder.toString(), 1);
        }
        InternalOfferwallListener internalOfferwallListener = this.mOfferwallListener;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallOpened();
        }
    }

    @Override
    public void onOfferwallEventNotificationReceived(String string, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(" :onOfferwallEventNotificationReceived ");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        }
    }

    @Override
    public void onOfferwallInitFail(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onOfferwallInitFail ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mOfferwallListener != null) {
            IronSourceError ironSourceError = ErrorBuilder.buildGenericError(string);
            this.mOfferwallListener.onOfferwallAvailable(false, ironSourceError);
        }
    }

    @Override
    public void onOfferwallInitSuccess() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onOfferwallInitSuccess ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        InternalOfferwallListener internalOfferwallListener = this.mOfferwallListener;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallAvailable(true);
        }
    }

    @Override
    public void onPause(Activity activity) {
        SSAPublisher sSAPublisher = this.mSSAPublisher;
        if (sSAPublisher != null) {
            sSAPublisher.onPause(activity);
        }
    }

    @Override
    public void onRVAdClicked() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onRVAdClicked ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdClicked();
        }
    }

    @Override
    public void onRVAdClosed() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onRVAdClosed ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdClosed();
        }
    }

    @Override
    public void onRVAdCredited(int n2) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onRVAdCredited ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdRewarded();
        }
    }

    @Override
    public void onRVAdOpened() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onRVAdOpened ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdOpened();
        }
    }

    @Override
    public void onRVEventNotificationReceived(String string, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(" :onRVEventNotificationReceived: ");
            stringBuilder.append(string);
            stringBuilder.append(" extData: ");
            stringBuilder.append(jSONObject.toString());
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        }
        if (!TextUtils.isEmpty((CharSequence)string) && "impressions".equals((Object)string) && this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdVisible();
        }
    }

    @Override
    public void onRVInitFail(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onRVInitFail ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        for (RewardedVideoSmashListener rewardedVideoSmashListener : this.mAllRewardedVideoSmashes) {
            if (rewardedVideoSmashListener == null) continue;
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    @Override
    public void onRVInitSuccess(AdUnitsReady adUnitsReady) {
        int n2;
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onRVInitSuccess ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        try {
            n2 = Integer.parseInt((String)adUnitsReady.getNumOfAdUnits());
        }
        catch (NumberFormatException numberFormatException) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "onRVInitSuccess:parseInt()", numberFormatException);
            n2 = 0;
        }
        boolean bl = false;
        if (n2 > 0) {
            bl = true;
        }
        this.mIsRVAvailable = bl;
        for (RewardedVideoSmashListener rewardedVideoSmashListener : this.mAllRewardedVideoSmashes) {
            if (rewardedVideoSmashListener == null) continue;
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(bl);
        }
    }

    @Override
    public void onRVNoMoreOffers() {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onRVNoMoreOffers ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        this.mIsRVAvailable = false;
        for (RewardedVideoSmashListener rewardedVideoSmashListener : this.mAllRewardedVideoSmashes) {
            if (rewardedVideoSmashListener == null) continue;
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    @Override
    public void onRVShowFail(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(" :onRVShowFail ");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdShowFailed(new IronSourceError(509, string));
        }
    }

    @Override
    public void onResume(Activity activity) {
        SSAPublisher sSAPublisher = this.mSSAPublisher;
        if (sSAPublisher != null) {
            sSAPublisher.onResume(activity);
        }
    }

    @Override
    public void setAge(int n2) {
        if (n2 >= 13 && n2 <= 17) {
            this.mUserAgeGroup = "1";
            return;
        }
        if (n2 >= 18 && n2 <= 20) {
            this.mUserAgeGroup = "2";
            return;
        }
        if (n2 >= 21 && n2 <= 24) {
            this.mUserAgeGroup = "3";
            return;
        }
        if (n2 >= 25 && n2 <= 34) {
            this.mUserAgeGroup = "4";
            return;
        }
        if (n2 >= 35 && n2 <= 44) {
            this.mUserAgeGroup = "5";
            return;
        }
        if (n2 >= 45 && n2 <= 54) {
            this.mUserAgeGroup = "6";
            return;
        }
        if (n2 >= 55 && n2 <= 64) {
            this.mUserAgeGroup = "7";
            return;
        }
        if (n2 > 65 && n2 <= 120) {
            this.mUserAgeGroup = "8";
            return;
        }
        this.mUserAgeGroup = "0";
    }

    @Override
    protected void setConsent(boolean bl) {
        this.mDidSetConsent = true;
        this.mConsent = bl;
        this.applyConsent(bl);
    }

    @Override
    public void setGender(String string) {
        this.mUserGender = string;
    }

    @Override
    public void setInternalOfferwallListener(InternalOfferwallListener internalOfferwallListener) {
        this.mOfferwallListener = internalOfferwallListener;
    }

    @Override
    public void setMediationSegment(String string) {
        this.mMediationSegment = string;
    }

    @Override
    protected void setMediationState(AbstractSmash.MEDIATION_STATE mEDIATION_STATE, String string) {
        if (this.mSSAPublisher != null) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(" :setMediationState(");
            stringBuilder.append(string);
            stringBuilder.append(" , ");
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(" , ");
            stringBuilder.append(mEDIATION_STATE.getValue());
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mSSAPublisher.setMediationState(string, this.getProviderName(), mEDIATION_STATE.getValue());
        }
    }

    @Override
    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        this.mActiveInterstitialSmash = interstitialSmashListener;
        if (this.mSSAPublisher != null) {
            int n2 = SessionDepthManager.getInstance().getSessionDepth(2);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("demandSourceName", (Object)this.getProviderName());
                jSONObject2.put("sessionDepth", n2);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            this.mSSAPublisher.showInterstitial(jSONObject2);
            return;
        }
        this.log(IronSourceLogger.IronSourceTag.NATIVE, "Please call loadInterstitial before calling showInterstitial", 2);
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
        }
    }

    @Override
    public void showOfferwall(String string, JSONObject jSONObject) {
        SSAPublisher sSAPublisher;
        HashMap<String, String> hashMap = this.getOfferwallExtraParams(jSONObject);
        if (hashMap != null) {
            hashMap.put((Object)"placementId", (Object)string);
        }
        if ((sSAPublisher = this.mSSAPublisher) != null) {
            sSAPublisher.showOfferWall((Map<String, String>)hashMap);
            return;
        }
        this.log(IronSourceLogger.IronSourceTag.NATIVE, "Please call init before calling showOfferwall", 2);
    }

    @Override
    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        this.mActiveRewardedVideoSmash = rewardedVideoSmashListener;
        if (this.mSSAPublisher != null) {
            int n2 = SessionDepthManager.getInstance().getSessionDepth(1);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("demandSourceName", (Object)this.getProviderName());
                jSONObject2.put("sessionDepth", n2);
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            this.mSSAPublisher.showRewardedVideo(jSONObject2);
            return;
        }
        this.mIsRVAvailable = false;
        if (this.mActiveRewardedVideoSmash != null) {
            this.mActiveRewardedVideoSmash.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Rewarded Video"));
        }
        for (RewardedVideoSmashListener rewardedVideoSmashListener2 : this.mAllRewardedVideoSmashes) {
            if (rewardedVideoSmashListener2 == null) continue;
            rewardedVideoSmashListener2.onRewardedVideoAvailabilityChanged(false);
        }
    }
}

