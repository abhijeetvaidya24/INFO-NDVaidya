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
import com.ironsource.mediationsdk.RewardedVideoSmash;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class RewardedVideoSmash
extends AbstractSmash
implements RewardedVideoSmashListener {
    private final String REQUEST_URL_KEY = "requestUrl";
    private String mRequestUrl;
    private JSONObject mRewardedVideoAdapterConfigs;
    private RewardedVideoManagerListener mRewardedVideoManagerListener;
    private int mTimeout;

    RewardedVideoSmash(ProviderSettings providerSettings, int n2) {
        super(providerSettings);
        this.mRewardedVideoAdapterConfigs = providerSettings.getRewardedVideoSettings();
        this.mMaxAdsPerIteration = this.mRewardedVideoAdapterConfigs.optInt("maxAdsPerIteration", 99);
        this.mMaxAdsPerSession = this.mRewardedVideoAdapterConfigs.optInt("maxAdsPerSession", 99);
        this.mMaxAdsPerDay = this.mRewardedVideoAdapterConfigs.optInt("maxAdsPerDay", 99);
        this.mRequestUrl = this.mRewardedVideoAdapterConfigs.optString("requestUrl");
        this.mTimeout = n2;
    }

    static /* synthetic */ RewardedVideoManagerListener access$000(RewardedVideoSmash rewardedVideoSmash) {
        return rewardedVideoSmash.mRewardedVideoManagerListener;
    }

    @Override
    void completeIteration() {
        this.mIterationShowCounter = 0;
        AbstractSmash.MEDIATION_STATE mEDIATION_STATE = this.isRewardedVideoAvailable() ? AbstractSmash.MEDIATION_STATE.AVAILABLE : AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE;
        this.setMediationState(mEDIATION_STATE);
    }

    public void fetchRewardedVideo() {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getInstanceName());
            stringBuilder.append(":fetchRewardedVideo()");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mAdapter.fetchRewardedVideo(this.mRewardedVideoAdapterConfigs);
        }
    }

    @Override
    protected String getAdUnitString() {
        return "rewardedvideo";
    }

    String getRequestUrl() {
        return this.mRequestUrl;
    }

    public void initRewardedVideo(Activity activity, String string, String string2) {
        this.startInitTimer();
        if (this.mAdapter != null) {
            this.mAdapter.addRewardedVideoListener(this);
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getInstanceName());
            stringBuilder.append(":initRewardedVideo()");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mAdapter.initRewardedVideo(activity, string, string2, this.mRewardedVideoAdapterConfigs, (RewardedVideoSmashListener)this);
        }
    }

    public boolean isRewardedVideoAvailable() {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getInstanceName());
            stringBuilder.append(":isRewardedVideoAvailable()");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            return this.mAdapter.isRewardedVideoAvailable(this.mRewardedVideoAdapterConfigs);
        }
        return false;
    }

    @Override
    public void onRewardedVideoAdClicked() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdClicked(this);
        }
    }

    @Override
    public void onRewardedVideoAdClosed() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdClosed(this);
        }
        this.fetchRewardedVideo();
    }

    @Override
    public void onRewardedVideoAdOpened() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdOpened(this);
        }
    }

    @Override
    public void onRewardedVideoAdRewarded() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdRewarded(this);
        }
    }

    @Override
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdShowFailed(ironSourceError, this);
        }
    }

    @Override
    public void onRewardedVideoAdVisible() {
        RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
        if (rewardedVideoManagerListener != null) {
            rewardedVideoManagerListener.onRewardedVideoAdVisible(this);
        }
    }

    @Override
    public void onRewardedVideoAvailabilityChanged(boolean bl) {
        this.stopInitTimer();
        if (this.isMediationAvailable() && (bl && this.mMediationState != AbstractSmash.MEDIATION_STATE.AVAILABLE || !bl && this.mMediationState != AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE)) {
            AbstractSmash.MEDIATION_STATE mEDIATION_STATE = bl ? AbstractSmash.MEDIATION_STATE.AVAILABLE : AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE;
            this.setMediationState(mEDIATION_STATE);
            RewardedVideoManagerListener rewardedVideoManagerListener = this.mRewardedVideoManagerListener;
            if (rewardedVideoManagerListener != null) {
                rewardedVideoManagerListener.onRewardedVideoAvailabilityChanged(bl, this);
            }
        }
    }

    public void setRewardedVideoManagerListener(RewardedVideoManagerListener rewardedVideoManagerListener) {
        this.mRewardedVideoManagerListener = rewardedVideoManagerListener;
    }

    public void showRewardedVideo() {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getInstanceName());
            stringBuilder.append(":showRewardedVideo()");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.preShow();
            this.mAdapter.showRewardedVideo(this.mRewardedVideoAdapterConfigs, (RewardedVideoSmashListener)this);
        }
    }

    @Override
    void startInitTimer() {
        try {
            this.mInitTimerTask = new TimerTask(this){
                final /* synthetic */ RewardedVideoSmash this$0;
                {
                    this.this$0 = rewardedVideoSmash;
                }

                public void run() {
                    if (RewardedVideoSmash.access$000(this.this$0) != null) {
                        IronSourceLoggerManager ironSourceLoggerManager = this.this$0.mLoggerManager;
                        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Timeout for ");
                        stringBuilder.append(this.this$0.getInstanceName());
                        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
                        this.this$0.setMediationState(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                        RewardedVideoSmash.access$000(this.this$0).onRewardedVideoAvailabilityChanged(false, this.this$0);
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
    }
}

