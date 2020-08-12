/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.res.Resources
 *  android.util.DisplayMetrics
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.CopyOnWriteArrayList
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialAdapterApi;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedInterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoAdapterApi;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

public abstract class AbstractAdapter
implements InterstitialAdapterApi,
RewardedVideoAdapterApi {
    protected BannerSmashListener mActiveBannerSmash;
    protected InterstitialSmashListener mActiveInterstitialSmash;
    protected RewardedVideoSmashListener mActiveRewardedVideoSmash;
    protected CopyOnWriteArrayList<BannerSmashListener> mAllBannerSmashes;
    protected CopyOnWriteArrayList<InterstitialSmashListener> mAllInterstitialSmashes = new CopyOnWriteArrayList();
    protected CopyOnWriteArrayList<RewardedVideoSmashListener> mAllRewardedVideoSmashes = new CopyOnWriteArrayList();
    protected ConcurrentHashMap<String, BannerSmashListener> mBannerPlacementToListenerMap = new ConcurrentHashMap();
    protected ConcurrentHashMap<String, InterstitialSmashListener> mInterstitialPlacementToListenerMap = new ConcurrentHashMap();
    private IronSourceLoggerManager mLoggerManager = IronSourceLoggerManager.getLogger();
    private String mPluginFrameworkVersion;
    private String mPluginType;
    private String mProviderName;
    protected RewardedInterstitialListener mRewardedInterstitial;
    protected ConcurrentHashMap<String, RewardedVideoSmashListener> mRewardedVideoPlacementToListenerMap = new ConcurrentHashMap();

    public AbstractAdapter(String string) {
        this.mProviderName = string;
    }

    protected void addBannerListener(BannerSmashListener bannerSmashListener) {
    }

    public void addInterstitialListener(InterstitialSmashListener interstitialSmashListener) {
        this.mAllInterstitialSmashes.add((Object)interstitialSmashListener);
    }

    public void addRewardedVideoListener(RewardedVideoSmashListener rewardedVideoSmashListener) {
        this.mAllRewardedVideoSmashes.add((Object)rewardedVideoSmashListener);
    }

    public void destroyBanner(JSONObject jSONObject) {
    }

    public abstract String getCoreSDKVersion();

    protected String getDynamicUserId() {
        return IronSourceObject.getInstance().getDynamicUserId();
    }

    public String getPluginFrameworkVersion() {
        return this.mPluginFrameworkVersion;
    }

    public String getPluginType() {
        return this.mPluginType;
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    protected int getScreenWidthDp(Activity activity) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        return (int)((float)displayMetrics.widthPixels / displayMetrics.density);
    }

    protected int getScreenWidthPixels(Activity activity) {
        return activity.getResources().getDisplayMetrics().widthPixels;
    }

    public abstract String getVersion();

    public void initBanners(Activity activity, String string, String string2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
    }

    protected boolean isAdaptersDebugEnabled() {
        return this.mLoggerManager.isDebugEnabled();
    }

    protected boolean isLargeScreen(Activity activity) {
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        return (float)displayMetrics.heightPixels / displayMetrics.density > 720.0f;
    }

    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
    }

    protected void log(IronSourceLogger.IronSourceTag ironSourceTag, String string, int n2) {
        this.mLoggerManager.onLog(ironSourceTag, string, n2);
    }

    public void onPause(Activity activity) {
    }

    public void onResume(Activity activity) {
    }

    public void reloadBanner(JSONObject jSONObject) {
    }

    protected void removeBannerListener(BannerSmashListener bannerSmashListener) {
    }

    public void removeInterstitialListener(InterstitialSmashListener interstitialSmashListener) {
        this.mAllInterstitialSmashes.remove((Object)interstitialSmashListener);
    }

    public void removeRewardedVideoListener(RewardedVideoSmashListener rewardedVideoSmashListener) {
        this.mAllRewardedVideoSmashes.remove((Object)rewardedVideoSmashListener);
    }

    public void setAge(int n2) {
    }

    protected void setConsent(boolean bl) {
    }

    public void setGender(String string) {
    }

    public void setLogListener(LogListener logListener) {
    }

    public void setMediationSegment(String string) {
    }

    protected void setMediationState(AbstractSmash.MEDIATION_STATE mEDIATION_STATE, String string) {
    }

    void setPluginData(String string, String string2) {
        this.mPluginType = string;
        this.mPluginFrameworkVersion = string2;
    }

    public void setRewardedInterstitialListener(RewardedInterstitialListener rewardedInterstitialListener) {
        this.mRewardedInterstitial = rewardedInterstitialListener;
    }
}

