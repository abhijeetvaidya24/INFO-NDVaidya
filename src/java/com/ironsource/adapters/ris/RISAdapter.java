/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.concurrent.CopyOnWriteArrayList
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.adapters.ris;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.adapters.ris.RISAdapter;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedInterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.SessionDepthManager;
import com.ironsource.sdk.SSAPublisher;
import com.ironsource.sdk.data.AdUnitsReady;
import com.ironsource.sdk.listeners.OnRewardedVideoListener;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class RISAdapter
extends AbstractAdapter
implements OnRewardedVideoListener {
    private final String AD_VISIBLE_EVENT_NAME = "impressions";
    private final String DYNAMIC_CONTROLLER_CONFIG = "controllerConfig";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private boolean hasAdAvailable = false;
    private boolean mConsent;
    private boolean mDidReportInitStatus = false;
    private boolean mDidSetConsent;
    private SSAPublisher mSSAPublisher;

    private RISAdapter(String string) {
        super(string);
    }

    static /* synthetic */ SSAPublisher access$002(RISAdapter rISAdapter, SSAPublisher sSAPublisher) {
        rISAdapter.mSSAPublisher = sSAPublisher;
        return sSAPublisher;
    }

    static /* synthetic */ boolean access$100(RISAdapter rISAdapter) {
        return rISAdapter.mDidSetConsent;
    }

    static /* synthetic */ boolean access$200(RISAdapter rISAdapter) {
        return rISAdapter.mConsent;
    }

    static /* synthetic */ void access$300(RISAdapter rISAdapter, boolean bl) {
        rISAdapter.applyConsent(bl);
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

    public static RISAdapter startAdapter(String string) {
        return new RISAdapter(string);
    }

    @Override
    public void fetchRewardedVideo(JSONObject jSONObject) {
    }

    @Override
    public String getCoreSDKVersion() {
        return SDKUtils.getSDKVersion();
    }

    @Override
    public String getVersion() {
        return IronSourceUtils.getSDKVersion();
    }

    @Override
    public void initInterstitial(Activity activity, String string, String string2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        SDKUtils.setControllerUrl(jSONObject.optString("controllerUrl"));
        if (this.isAdaptersDebugEnabled()) {
            SDKUtils.setDebugMode(3);
        } else {
            SDKUtils.setDebugMode(jSONObject.optInt("debugMode", 0));
        }
        SDKUtils.setControllerConfig(jSONObject.optString("controllerConfig", ""));
        activity.runOnUiThread(new Runnable(this, activity, string, string2){
            final /* synthetic */ RISAdapter this$0;
            final /* synthetic */ Activity val$activity;
            final /* synthetic */ String val$appKey;
            final /* synthetic */ String val$userId;
            {
                this.this$0 = rISAdapter;
                this.val$activity = activity;
                this.val$appKey = string;
                this.val$userId = string2;
            }

            public void run() {
                try {
                    RISAdapter.access$002(this.this$0, com.ironsource.sdk.SSAFactory.getPublisherInstance(this.val$activity));
                    if (RISAdapter.access$100(this.this$0)) {
                        RISAdapter.access$300(this.this$0, RISAdapter.access$200(this.this$0));
                    }
                    com.ironsource.sdk.SSAFactory.getPublisherInstance(this.val$activity).initRewardedVideo(this.val$appKey, this.val$userId, this.this$0.getProviderName(), (java.util.Map<String, String>)new java.util.HashMap(), this.this$0);
                    return;
                }
                catch (java.lang.Exception exception) {
                    this.this$0.onRVInitFail(exception.getMessage());
                    return;
                }
            }
        });
    }

    @Override
    public void initRewardedVideo(Activity activity, String string, String string2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
    }

    @Override
    public boolean isInterstitialReady(JSONObject jSONObject) {
        return this.hasAdAvailable;
    }

    @Override
    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        return false;
    }

    @Override
    public void loadInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        if (this.hasAdAvailable) {
            for (InterstitialSmashListener interstitialSmashListener2 : this.mAllInterstitialSmashes) {
                if (interstitialSmashListener2 == null) continue;
                interstitialSmashListener2.onInterstitialAdReady();
            }
        } else {
            for (InterstitialSmashListener interstitialSmashListener3 : this.mAllInterstitialSmashes) {
                if (interstitialSmashListener3 == null) continue;
                interstitialSmashListener3.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("No Ads to Load"));
            }
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
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(":onRVAdClicked()");
        this.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdClicked();
        }
    }

    @Override
    public void onRVAdClosed() {
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(":onRVAdClosed()");
        this.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdClosed();
        }
    }

    @Override
    public void onRVAdCredited(int n2) {
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(":onRVAdCredited()");
        this.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mRewardedInterstitial != null) {
            this.mRewardedInterstitial.onInterstitialAdRewarded();
        }
    }

    @Override
    public void onRVAdOpened() {
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(":onRVAdOpened()");
        this.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdShowSucceeded();
            this.mActiveInterstitialSmash.onInterstitialAdOpened();
        }
    }

    @Override
    public void onRVEventNotificationReceived(String string, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(" :onRISEventNotificationReceived: ");
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
    public void onRVInitFail(String string) {
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(":onRVInitFail()");
        this.log(ironSourceTag, stringBuilder.toString(), 1);
        this.hasAdAvailable = false;
        if (!this.mDidReportInitStatus) {
            this.mDidReportInitStatus = true;
            for (InterstitialSmashListener interstitialSmashListener : this.mAllInterstitialSmashes) {
                if (interstitialSmashListener == null) continue;
                interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(string, "Interstitial"));
            }
        }
    }

    @Override
    public void onRVInitSuccess(AdUnitsReady adUnitsReady) {
        int n2;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(":onRVInitSuccess()");
        this.log(ironSourceTag, stringBuilder.toString(), 1);
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
        this.hasAdAvailable = bl;
        if (!this.mDidReportInitStatus) {
            this.mDidReportInitStatus = true;
            for (InterstitialSmashListener interstitialSmashListener : this.mAllInterstitialSmashes) {
                if (interstitialSmashListener == null) continue;
                interstitialSmashListener.onInterstitialInitSuccess();
            }
        }
    }

    @Override
    public void onRVNoMoreOffers() {
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(":onRVNoMoreOffers()");
        this.log(ironSourceTag, stringBuilder.toString(), 1);
        if (!this.mDidReportInitStatus) {
            this.mDidReportInitStatus = true;
            for (InterstitialSmashListener interstitialSmashListener : this.mAllInterstitialSmashes) {
                if (interstitialSmashListener == null) continue;
                interstitialSmashListener.onInterstitialInitSuccess();
            }
        }
    }

    @Override
    public void onRVShowFail(String string) {
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getProviderName());
        stringBuilder.append(":onRVShowFail()");
        this.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdShowFailed(new IronSourceError(509, "Show Failed"));
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
    protected void setConsent(boolean bl) {
        this.mConsent = bl;
        this.mDidSetConsent = true;
        this.applyConsent(bl);
    }

    @Override
    protected void setMediationState(AbstractSmash.MEDIATION_STATE mEDIATION_STATE, String string) {
        if (this.mSSAPublisher != null) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(" :setMediationState(RIS:(rewardedvideo)):");
            stringBuilder.append(string);
            stringBuilder.append(" , ");
            stringBuilder.append(this.getProviderName());
            stringBuilder.append(" , ");
            stringBuilder.append(mEDIATION_STATE.getValue());
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mSSAPublisher.setMediationState("rewardedvideo", this.getProviderName(), mEDIATION_STATE.getValue());
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
            this.mSSAPublisher.showRewardedVideo(jSONObject2);
            return;
        }
        if (this.mActiveInterstitialSmash != null) {
            this.mActiveInterstitialSmash.onInterstitialAdShowFailed(new IronSourceError(509, "Please call init before calling showRewardedVideo"));
        }
    }

    @Override
    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
    }
}

