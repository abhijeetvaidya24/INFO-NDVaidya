/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  java.lang.Exception
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Timer
 *  java.util.TimerTask
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.InterstitialSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.InterstitialManagerListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedInterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedInterstitialManagerListener;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class InterstitialSmash
extends AbstractSmash
implements InterstitialSmashListener,
RewardedInterstitialListener {
    private JSONObject mInterstitialAdapterConfigs;
    private InterstitialManagerListener mInterstitialManagerListener;
    private RewardedInterstitialManagerListener mRewardedInterstitialManagerListener;
    private int mTimeout;

    InterstitialSmash(ProviderSettings providerSettings, int n2) {
        super(providerSettings);
        this.mInterstitialAdapterConfigs = providerSettings.getInterstitialSettings();
        this.mMaxAdsPerIteration = this.mInterstitialAdapterConfigs.optInt("maxAdsPerIteration", 99);
        this.mMaxAdsPerSession = this.mInterstitialAdapterConfigs.optInt("maxAdsPerSession", 99);
        this.mMaxAdsPerDay = this.mInterstitialAdapterConfigs.optInt("maxAdsPerDay", 99);
        this.mIsMultipleInstances = providerSettings.isMultipleInstances();
        this.mSpId = providerSettings.getSubProviderId();
        this.mTimeout = n2;
    }

    static /* synthetic */ InterstitialManagerListener access$000(InterstitialSmash interstitialSmash) {
        return interstitialSmash.mInterstitialManagerListener;
    }

    @Override
    void completeIteration() {
        this.mIterationShowCounter = 0;
        this.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
    }

    @Override
    protected String getAdUnitString() {
        return "interstitial";
    }

    public void initInterstitial(Activity activity, String string, String string2) {
        this.startInitTimer();
        if (this.mAdapter != null) {
            this.mAdapter.addInterstitialListener(this);
            if (this.mRewardedInterstitialManagerListener != null) {
                this.mAdapter.setRewardedInterstitialListener(this);
            }
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getInstanceName());
            stringBuilder.append(":initInterstitial()");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mAdapter.initInterstitial(activity, string, string2, this.mInterstitialAdapterConfigs, (InterstitialSmashListener)this);
        }
    }

    public boolean isInterstitialReady() {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getInstanceName());
            stringBuilder.append(":isInterstitialReady()");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            return this.mAdapter.isInterstitialReady(this.mInterstitialAdapterConfigs);
        }
        return false;
    }

    public void loadInterstitial() {
        this.startLoadTimer();
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getInstanceName());
            stringBuilder.append(":loadInterstitial()");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mAdapter.loadInterstitial(this.mInterstitialAdapterConfigs, (InterstitialSmashListener)this);
        }
    }

    @Override
    public void onInterstitialAdClicked() {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdClicked(this);
        }
    }

    @Override
    public void onInterstitialAdClosed() {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdClosed(this);
        }
    }

    @Override
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        InterstitialManagerListener interstitialManagerListener;
        this.stopLoadTimer();
        if (this.mMediationState == AbstractSmash.MEDIATION_STATE.LOAD_PENDING && (interstitialManagerListener = this.mInterstitialManagerListener) != null) {
            interstitialManagerListener.onInterstitialAdLoadFailed(ironSourceError, this);
        }
    }

    @Override
    public void onInterstitialAdOpened() {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdOpened(this);
        }
    }

    @Override
    public void onInterstitialAdReady() {
        InterstitialManagerListener interstitialManagerListener;
        this.stopLoadTimer();
        if (this.mMediationState == AbstractSmash.MEDIATION_STATE.LOAD_PENDING && (interstitialManagerListener = this.mInterstitialManagerListener) != null) {
            interstitialManagerListener.onInterstitialAdReady(this);
        }
    }

    @Override
    public void onInterstitialAdRewarded() {
        RewardedInterstitialManagerListener rewardedInterstitialManagerListener = this.mRewardedInterstitialManagerListener;
        if (rewardedInterstitialManagerListener != null) {
            rewardedInterstitialManagerListener.onInterstitialAdRewarded(this);
        }
    }

    @Override
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdShowFailed(ironSourceError, this);
        }
    }

    @Override
    public void onInterstitialAdShowSucceeded() {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdShowSucceeded(this);
        }
    }

    @Override
    public void onInterstitialAdVisible() {
        InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
        if (interstitialManagerListener != null) {
            interstitialManagerListener.onInterstitialAdVisible(this);
        }
    }

    @Override
    public void onInterstitialInitFailed(IronSourceError ironSourceError) {
        this.stopInitTimer();
        if (this.mMediationState == AbstractSmash.MEDIATION_STATE.INIT_PENDING) {
            this.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
            InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
            if (interstitialManagerListener != null) {
                interstitialManagerListener.onInterstitialInitFailed(ironSourceError, this);
            }
        }
    }

    @Override
    public void onInterstitialInitSuccess() {
        this.stopInitTimer();
        if (this.mMediationState == AbstractSmash.MEDIATION_STATE.INIT_PENDING) {
            this.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
            InterstitialManagerListener interstitialManagerListener = this.mInterstitialManagerListener;
            if (interstitialManagerListener != null) {
                interstitialManagerListener.onInterstitialInitSuccess(this);
            }
        }
    }

    public void setInterstitialManagerListener(InterstitialManagerListener interstitialManagerListener) {
        this.mInterstitialManagerListener = interstitialManagerListener;
    }

    public void setRewardedInterstitialManagerListener(RewardedInterstitialManagerListener rewardedInterstitialManagerListener) {
        this.mRewardedInterstitialManagerListener = rewardedInterstitialManagerListener;
    }

    public void showInterstitial() {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getInstanceName());
            stringBuilder.append(":showInterstitial()");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.preShow();
            this.mAdapter.showInterstitial(this.mInterstitialAdapterConfigs, (InterstitialSmashListener)this);
        }
    }

    @Override
    void startInitTimer() {
        try {
            this.mInitTimerTask = new TimerTask(this){
                final /* synthetic */ InterstitialSmash this$0;
                {
                    this.this$0 = interstitialSmash;
                }

                public void run() {
                    if (this.this$0.mMediationState == AbstractSmash.MEDIATION_STATE.INIT_PENDING && InterstitialSmash.access$000(this.this$0) != null) {
                        this.this$0.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
                        InterstitialSmash.access$000(this.this$0).onInterstitialInitFailed(com.ironsource.mediationsdk.utils.ErrorBuilder.buildInitFailedError("Timeout", "Interstitial"), this.this$0);
                    }
                }
            };
            Timer timer = new Timer();
            if (this.mInitTimerTask != null) {
                timer.schedule(this.mInitTimerTask, (long)(1000 * this.mTimeout));
                return;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    void startLoadTimer() {
        try {
            this.mLoadTimerTask = new TimerTask(this){
                final /* synthetic */ InterstitialSmash this$0;
                {
                    this.this$0 = interstitialSmash;
                }

                public void run() {
                    if (this.this$0.mMediationState == AbstractSmash.MEDIATION_STATE.LOAD_PENDING && InterstitialSmash.access$000(this.this$0) != null) {
                        this.this$0.setMediationState(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                        InterstitialSmash.access$000(this.this$0).onInterstitialAdLoadFailed(com.ironsource.mediationsdk.utils.ErrorBuilder.buildLoadFailedError("Timeout"), this.this$0);
                    }
                }
            };
            Timer timer = new Timer();
            if (this.mLoadTimerTask != null) {
                timer.schedule(this.mLoadTimerTask, (long)(1000 * this.mTimeout));
                return;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

