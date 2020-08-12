/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Timer
 *  java.util.TimerTask
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.BannerSmash;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.BannerManagerListener;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public class BannerSmash
implements BannerSmashListener {
    private AbstractAdapter mAdapter;
    private ProviderSettings mAdapterConfigs;
    private IronSourceBannerLayout mBannerLayout;
    private boolean mIsReadyToLoad;
    private BannerManagerListener mListener;
    private long mLoadTimeoutMilisecs;
    private String mName;
    private int mProviderPriority;
    private BANNER_SMASH_STATE mState = BANNER_SMASH_STATE.NO_INIT;
    private Timer mTimer;

    BannerSmash(BannerManagerListener bannerManagerListener, ProviderSettings providerSettings, AbstractAdapter abstractAdapter, long l2, int n2) {
        this.mProviderPriority = n2;
        this.mListener = bannerManagerListener;
        this.mAdapter = abstractAdapter;
        this.mAdapterConfigs = providerSettings;
        this.mLoadTimeoutMilisecs = l2;
        this.mAdapter.addBannerListener(this);
        if (providerSettings.isMultipleInstances()) {
            this.mName = providerSettings.getProviderTypeForReflection();
            return;
        }
        this.mName = providerSettings.getProviderName();
    }

    static /* synthetic */ BANNER_SMASH_STATE access$000(BannerSmash bannerSmash) {
        return bannerSmash.mState;
    }

    static /* synthetic */ void access$100(BannerSmash bannerSmash, String string) {
        bannerSmash.log(string);
    }

    static /* synthetic */ BannerManagerListener access$200(BannerSmash bannerSmash) {
        return bannerSmash.mListener;
    }

    static /* synthetic */ void access$300(BannerSmash bannerSmash, BANNER_SMASH_STATE bANNER_SMASH_STATE) {
        bannerSmash.setState(bANNER_SMASH_STATE);
    }

    private void log(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BannerSmash ");
        stringBuilder.append(this.getName());
        stringBuilder.append(" ");
        stringBuilder.append(string);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setCustomParams() {
        if (this.mAdapter == null) {
            return;
        }
        try {
            String string;
            String string2;
            String string3;
            Boolean bl;
            Integer n2 = IronSourceObject.getInstance().getAge();
            if (n2 != null) {
                this.mAdapter.setAge(n2);
            }
            if (!TextUtils.isEmpty((CharSequence)(string3 = IronSourceObject.getInstance().getGender()))) {
                this.mAdapter.setGender(string3);
            }
            if (!TextUtils.isEmpty((CharSequence)(string2 = IronSourceObject.getInstance().getMediationSegment()))) {
                this.mAdapter.setMediationSegment(string2);
            }
            if (!TextUtils.isEmpty((CharSequence)(string = ConfigFile.getConfigFile().getPluginType()))) {
                this.mAdapter.setPluginData(string, ConfigFile.getConfigFile().getPluginFrameworkVersion());
            }
            if ((bl = IronSourceObject.getInstance().getConsent()) == null) return;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setConsent(");
            stringBuilder.append((Object)bl);
            stringBuilder.append(")");
            this.log(stringBuilder.toString());
            this.mAdapter.setConsent(bl);
            return;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(":setCustomParams():");
            stringBuilder.append(exception.toString());
            this.log(stringBuilder.toString());
        }
    }

    private void setState(BANNER_SMASH_STATE bANNER_SMASH_STATE) {
        this.mState = bANNER_SMASH_STATE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state=");
        stringBuilder.append(bANNER_SMASH_STATE.name());
        this.log(stringBuilder.toString());
    }

    private void startLoadTimer() {
        try {
            this.stopLoadTimer();
            this.mTimer = new Timer();
            this.mTimer.schedule(new TimerTask(this){
                final /* synthetic */ BannerSmash this$0;
                {
                    this.this$0 = bannerSmash;
                }

                public void run() {
                    if (BannerSmash.access$000(this.this$0) == BANNER_SMASH_STATE.INIT_IN_PROGRESS) {
                        BannerSmash.access$100(this.this$0, "init timed out");
                        BannerSmash.access$200(this.this$0).onBannerAdLoadFailed(new IronSourceError(607, "Timed out"), this.this$0);
                    } else if (BannerSmash.access$000(this.this$0) == BANNER_SMASH_STATE.LOAD_IN_PROGRESS) {
                        BannerSmash.access$100(this.this$0, "load timed out");
                        BannerSmash.access$200(this.this$0).onBannerAdLoadFailed(new IronSourceError(608, "Timed out"), this.this$0);
                    } else if (BannerSmash.access$000(this.this$0) == BANNER_SMASH_STATE.LOADED) {
                        BannerSmash.access$100(this.this$0, "reload timed out");
                        BannerSmash.access$200(this.this$0).onBannerAdReloadFailed(new IronSourceError(609, "Timed out"), this.this$0);
                    }
                    BannerSmash.access$300(this.this$0, BANNER_SMASH_STATE.LOAD_FAILED);
                }
            }, this.mLoadTimeoutMilisecs);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private void stopLoadTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
            this.mTimer = null;
        }
    }

    public void destroyBanner() {
        this.log("destroyBanner()");
        AbstractAdapter abstractAdapter = this.mAdapter;
        if (abstractAdapter == null) {
            this.log("destroyBanner() mAdapter == null");
            return;
        }
        abstractAdapter.destroyBanner(this.mAdapterConfigs.getBannerSettings());
        this.setState(BANNER_SMASH_STATE.DESTROYED);
    }

    public AbstractAdapter getAdapter() {
        return this.mAdapter;
    }

    public String getName() {
        return this.mName;
    }

    public int getProviderPriority() {
        return this.mProviderPriority;
    }

    public String getSubProviderId() {
        return this.mAdapterConfigs.getSubProviderId();
    }

    public boolean isReadyToLoad() {
        return this.mIsReadyToLoad;
    }

    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, Activity activity, String string, String string2) {
        this.log("loadBanner()");
        this.mIsReadyToLoad = false;
        if (ironSourceBannerLayout == null) {
            this.mListener.onBannerAdLoadFailed(new IronSourceError(610, "banner==null"), this);
            return;
        }
        if (this.mAdapter == null) {
            this.mListener.onBannerAdLoadFailed(new IronSourceError(611, "adapter==null"), this);
            return;
        }
        this.mBannerLayout = ironSourceBannerLayout;
        this.startLoadTimer();
        if (this.mState == BANNER_SMASH_STATE.NO_INIT) {
            this.setState(BANNER_SMASH_STATE.INIT_IN_PROGRESS);
            this.setCustomParams();
            this.mAdapter.initBanners(activity, string, string2, this.mAdapterConfigs.getBannerSettings(), this);
            return;
        }
        this.setState(BANNER_SMASH_STATE.LOAD_IN_PROGRESS);
        this.mAdapter.loadBanner(ironSourceBannerLayout, this.mAdapterConfigs.getBannerSettings(), this);
    }

    public void onPause(Activity activity) {
        AbstractAdapter abstractAdapter = this.mAdapter;
        if (abstractAdapter != null) {
            abstractAdapter.onPause(activity);
        }
    }

    public void onResume(Activity activity) {
        AbstractAdapter abstractAdapter = this.mAdapter;
        if (abstractAdapter != null) {
            abstractAdapter.onResume(activity);
        }
    }

    public void setConsent(boolean bl) {
        if (this.mAdapter != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setConsent(");
            stringBuilder.append(bl);
            stringBuilder.append(")");
            this.log(stringBuilder.toString());
            this.mAdapter.setConsent(bl);
        }
    }

    public void setReadyToLoad(boolean bl) {
        this.mIsReadyToLoad = bl;
    }

}

