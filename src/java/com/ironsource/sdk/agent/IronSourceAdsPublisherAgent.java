/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.MutableContextWrapper
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.StackTraceElement
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.sdk.agent;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ironsource.sdk.SSAPublisher;
import com.ironsource.sdk.agent.IronSourceAdsPublisherAgent;
import com.ironsource.sdk.controller.DemandSourceManager;
import com.ironsource.sdk.controller.IronSourceWebView;
import com.ironsource.sdk.data.AdUnitsReady;
import com.ironsource.sdk.data.DemandSource;
import com.ironsource.sdk.data.SSAEnums;
import com.ironsource.sdk.data.SSASession;
import com.ironsource.sdk.listeners.OnAdProductListener;
import com.ironsource.sdk.listeners.OnInterstitialListener;
import com.ironsource.sdk.listeners.OnOfferWallListener;
import com.ironsource.sdk.listeners.OnRewardedVideoListener;
import com.ironsource.sdk.listeners.internals.DSAdProductListener;
import com.ironsource.sdk.listeners.internals.DSInterstitialListener;
import com.ironsource.sdk.listeners.internals.DSRewardedVideoListener;
import com.ironsource.sdk.utils.IronSourceAsyncHttpRequestTask;
import com.ironsource.sdk.utils.IronSourceSharedPrefHelper;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class IronSourceAdsPublisherAgent
implements SSAPublisher,
DSAdProductListener,
DSInterstitialListener,
DSRewardedVideoListener {
    private static MutableContextWrapper mutableContextWrapper;
    private static IronSourceAdsPublisherAgent sInstance;
    private DemandSourceManager mDemandSourceManager;
    private SSASession session;
    private IronSourceWebView wvc;

    private IronSourceAdsPublisherAgent(Activity activity, int n2) throws Exception {
        IronSourceSharedPrefHelper.getSupersonicPrefHelper((Context)activity);
        this.mDemandSourceManager = new DemandSourceManager();
        Logger.enableLogging(SDKUtils.getDebugMode());
        Logger.i("IronSourceAdsPublisherAgent", "C'tor");
        mutableContextWrapper = new MutableContextWrapper((Context)activity);
        activity.runOnUiThread(new Runnable(this, activity){
            final /* synthetic */ IronSourceAdsPublisherAgent this$0;
            final /* synthetic */ Activity val$activity;
            {
                this.this$0 = ironSourceAdsPublisherAgent;
                this.val$activity = activity;
            }

            public void run() {
                IronSourceAdsPublisherAgent.access$002(this.this$0, new IronSourceWebView((Context)IronSourceAdsPublisherAgent.access$100(), IronSourceAdsPublisherAgent.access$200(this.this$0)));
                IronSourceAdsPublisherAgent.access$000(this.this$0).addMoatJSInterface(new com.ironsource.sdk.controller.MOATJSAdapter(this.val$activity.getApplication()));
                IronSourceAdsPublisherAgent.access$000(this.this$0).addPermissionsJSInterface(new com.ironsource.sdk.controller.PermissionsJSAdapter(this.val$activity.getApplicationContext()));
                IronSourceAdsPublisherAgent.access$000(this.this$0).registerConnectionReceiver((Context)this.val$activity);
                IronSourceAdsPublisherAgent.access$000(this.this$0).setDebugMode(SDKUtils.getDebugMode());
                IronSourceAdsPublisherAgent.access$000(this.this$0).downloadController();
            }
        });
        this.startSession((Context)activity);
    }

    static /* synthetic */ IronSourceWebView access$000(IronSourceAdsPublisherAgent ironSourceAdsPublisherAgent) {
        return ironSourceAdsPublisherAgent.wvc;
    }

    static /* synthetic */ IronSourceWebView access$002(IronSourceAdsPublisherAgent ironSourceAdsPublisherAgent, IronSourceWebView ironSourceWebView) {
        ironSourceAdsPublisherAgent.wvc = ironSourceWebView;
        return ironSourceWebView;
    }

    static /* synthetic */ MutableContextWrapper access$100() {
        return mutableContextWrapper;
    }

    static /* synthetic */ DemandSourceManager access$200(IronSourceAdsPublisherAgent ironSourceAdsPublisherAgent) {
        return ironSourceAdsPublisherAgent.mDemandSourceManager;
    }

    private void endSession() {
        SSASession sSASession = this.session;
        if (sSASession != null) {
            sSASession.endSession();
            IronSourceSharedPrefHelper.getSupersonicPrefHelper().addSession(this.session);
            this.session = null;
        }
    }

    private OnInterstitialListener getAdProductListenerAsISListener(DemandSource demandSource) {
        if (demandSource == null) {
            return null;
        }
        return (OnInterstitialListener)demandSource.getListener();
    }

    private OnRewardedVideoListener getAdProductListenerAsRVListener(DemandSource demandSource) {
        if (demandSource == null) {
            return null;
        }
        return (OnRewardedVideoListener)demandSource.getListener();
    }

    public static IronSourceAdsPublisherAgent getInstance(Activity activity) throws Exception {
        Class<IronSourceAdsPublisherAgent> class_ = IronSourceAdsPublisherAgent.class;
        synchronized (IronSourceAdsPublisherAgent.class) {
            IronSourceAdsPublisherAgent ironSourceAdsPublisherAgent = IronSourceAdsPublisherAgent.getInstance(activity, 0);
            // ** MonitorExit[var3_1] (shouldn't be in output)
            return ironSourceAdsPublisherAgent;
        }
    }

    public static IronSourceAdsPublisherAgent getInstance(Activity activity, int n2) throws Exception {
        Class<IronSourceAdsPublisherAgent> class_ = IronSourceAdsPublisherAgent.class;
        synchronized (IronSourceAdsPublisherAgent.class) {
            Logger.i("IronSourceAdsPublisherAgent", "getInstance()");
            if (sInstance == null) {
                sInstance = new IronSourceAdsPublisherAgent(activity, n2);
            } else {
                mutableContextWrapper.setBaseContext((Context)activity);
            }
            IronSourceAdsPublisherAgent ironSourceAdsPublisherAgent = sInstance;
            // ** MonitorExit[var4_2] (shouldn't be in output)
            return ironSourceAdsPublisherAgent;
        }
    }

    private void startSession(Context context) {
        this.session = new SSASession(context, SSASession.SessionType.launched);
    }

    public DemandSource getDemandSourceByName(SSAEnums.ProductType productType, String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        return this.mDemandSourceManager.getDemandSourceByName(productType, string);
    }

    @Override
    public void getOfferWallCredits(String string, String string2, OnOfferWallListener onOfferWallListener) {
        this.wvc.getOfferWallCredits(string, string2, onOfferWallListener);
    }

    public IronSourceWebView getWebViewController() {
        return this.wvc;
    }

    @Override
    public void initInterstitial(String string, String string2, String string3, Map<String, String> map, OnInterstitialListener onInterstitialListener) {
        DemandSource demandSource = this.mDemandSourceManager.createDemandSource(SSAEnums.ProductType.Interstitial, string3, map, onInterstitialListener);
        this.wvc.initInterstitial(string, string2, demandSource, this);
    }

    @Override
    public void initOfferWall(String string, String string2, Map<String, String> map, OnOfferWallListener onOfferWallListener) {
        this.wvc.initOfferWall(string, string2, map, onOfferWallListener);
    }

    @Override
    public void initRewardedVideo(String string, String string2, String string3, Map<String, String> map, OnRewardedVideoListener onRewardedVideoListener) {
        DemandSource demandSource = this.mDemandSourceManager.createDemandSource(SSAEnums.ProductType.RewardedVideo, string3, map, onRewardedVideoListener);
        this.wvc.initRewardedVideo(string, string2, demandSource, this);
    }

    @Override
    public boolean isInterstitialAdAvailable(String string) {
        return this.wvc.isInterstitialAdAvailable(string);
    }

    @Override
    public void loadInterstitial(JSONObject jSONObject) {
        String string = jSONObject != null ? jSONObject.optString("demandSourceName") : null;
        this.wvc.loadInterstitial(string);
    }

    @Override
    public void onAdProductClick(SSAEnums.ProductType productType, String string) {
        DemandSource demandSource = this.getDemandSourceByName(productType, string);
        if (demandSource != null) {
            OnInterstitialListener onInterstitialListener;
            if (productType == SSAEnums.ProductType.RewardedVideo) {
                OnRewardedVideoListener onRewardedVideoListener = this.getAdProductListenerAsRVListener(demandSource);
                if (onRewardedVideoListener != null) {
                    onRewardedVideoListener.onRVAdClicked();
                    return;
                }
            } else if (productType == SSAEnums.ProductType.Interstitial && (onInterstitialListener = this.getAdProductListenerAsISListener(demandSource)) != null) {
                onInterstitialListener.onInterstitialClick();
            }
        }
    }

    @Override
    public void onAdProductClose(SSAEnums.ProductType productType, String string) {
        DemandSource demandSource = this.getDemandSourceByName(productType, string);
        if (demandSource != null) {
            OnInterstitialListener onInterstitialListener;
            if (productType == SSAEnums.ProductType.RewardedVideo) {
                OnRewardedVideoListener onRewardedVideoListener = this.getAdProductListenerAsRVListener(demandSource);
                if (onRewardedVideoListener != null) {
                    onRewardedVideoListener.onRVAdClosed();
                    return;
                }
            } else if (productType == SSAEnums.ProductType.Interstitial && (onInterstitialListener = this.getAdProductListenerAsISListener(demandSource)) != null) {
                onInterstitialListener.onInterstitialClose();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onAdProductEventNotificationReceived(SSAEnums.ProductType productType, String string, String string2, JSONObject jSONObject) {
        DemandSource demandSource = this.getDemandSourceByName(productType, string);
        if (demandSource == null) return;
        try {
            SSAEnums.ProductType productType2 = SSAEnums.ProductType.Interstitial;
            if (productType == productType2) {
                OnInterstitialListener onInterstitialListener = this.getAdProductListenerAsISListener(demandSource);
                if (onInterstitialListener == null) return;
                jSONObject.put("demandSourceName", (Object)string);
                onInterstitialListener.onInterstitialEventNotificationReceived(string2, jSONObject);
                return;
            }
            if (productType != SSAEnums.ProductType.RewardedVideo) return;
            OnRewardedVideoListener onRewardedVideoListener = this.getAdProductListenerAsRVListener(demandSource);
            if (onRewardedVideoListener == null) return;
            jSONObject.put("demandSourceName", (Object)string);
            onRewardedVideoListener.onRVEventNotificationReceived(string2, jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
    }

    @Override
    public void onAdProductInitFailed(SSAEnums.ProductType productType, String string, String string2) {
        DemandSource demandSource = this.getDemandSourceByName(productType, string);
        if (demandSource != null) {
            OnInterstitialListener onInterstitialListener;
            demandSource.setDemandSourceInitState(3);
            if (productType == SSAEnums.ProductType.RewardedVideo) {
                OnRewardedVideoListener onRewardedVideoListener = this.getAdProductListenerAsRVListener(demandSource);
                if (onRewardedVideoListener != null) {
                    onRewardedVideoListener.onRVInitFail(string2);
                    return;
                }
            } else if (productType == SSAEnums.ProductType.Interstitial && (onInterstitialListener = this.getAdProductListenerAsISListener(demandSource)) != null) {
                onInterstitialListener.onInterstitialInitFailed(string2);
            }
        }
    }

    @Override
    public void onAdProductInitSuccess(SSAEnums.ProductType productType, String string, AdUnitsReady adUnitsReady) {
        DemandSource demandSource = this.getDemandSourceByName(productType, string);
        if (demandSource != null) {
            OnInterstitialListener onInterstitialListener;
            demandSource.setDemandSourceInitState(2);
            if (productType == SSAEnums.ProductType.RewardedVideo) {
                OnRewardedVideoListener onRewardedVideoListener = this.getAdProductListenerAsRVListener(demandSource);
                if (onRewardedVideoListener != null) {
                    onRewardedVideoListener.onRVInitSuccess(adUnitsReady);
                    return;
                }
            } else if (productType == SSAEnums.ProductType.Interstitial && (onInterstitialListener = this.getAdProductListenerAsISListener(demandSource)) != null) {
                onInterstitialListener.onInterstitialInitSuccess();
            }
        }
    }

    @Override
    public void onAdProductOpen(SSAEnums.ProductType productType, String string) {
        DemandSource demandSource = this.getDemandSourceByName(productType, string);
        if (demandSource != null) {
            OnRewardedVideoListener onRewardedVideoListener;
            if (productType == SSAEnums.ProductType.Interstitial) {
                OnInterstitialListener onInterstitialListener = this.getAdProductListenerAsISListener(demandSource);
                if (onInterstitialListener != null) {
                    onInterstitialListener.onInterstitialOpen();
                    return;
                }
            } else if (productType == SSAEnums.ProductType.RewardedVideo && (onRewardedVideoListener = this.getAdProductListenerAsRVListener(demandSource)) != null) {
                onRewardedVideoListener.onRVAdOpened();
            }
        }
    }

    @Override
    public void onInterstitialLoadFailed(String string, String string2) {
        OnInterstitialListener onInterstitialListener;
        DemandSource demandSource = this.getDemandSourceByName(SSAEnums.ProductType.Interstitial, string);
        if (demandSource != null && (onInterstitialListener = this.getAdProductListenerAsISListener(demandSource)) != null) {
            onInterstitialListener.onInterstitialLoadFailed(string2);
        }
    }

    @Override
    public void onInterstitialLoadSuccess(String string) {
        OnInterstitialListener onInterstitialListener;
        DemandSource demandSource = this.getDemandSourceByName(SSAEnums.ProductType.Interstitial, string);
        if (demandSource != null && (onInterstitialListener = this.getAdProductListenerAsISListener(demandSource)) != null) {
            onInterstitialListener.onInterstitialLoadSuccess();
        }
    }

    @Override
    public void onInterstitialShowFailed(String string, String string2) {
        OnInterstitialListener onInterstitialListener;
        DemandSource demandSource = this.getDemandSourceByName(SSAEnums.ProductType.Interstitial, string);
        if (demandSource != null && (onInterstitialListener = this.getAdProductListenerAsISListener(demandSource)) != null) {
            onInterstitialListener.onInterstitialShowFailed(string2);
        }
    }

    @Override
    public void onInterstitialShowSuccess(String string) {
        OnInterstitialListener onInterstitialListener;
        DemandSource demandSource = this.getDemandSourceByName(SSAEnums.ProductType.Interstitial, string);
        if (demandSource != null && (onInterstitialListener = this.getAdProductListenerAsISListener(demandSource)) != null) {
            onInterstitialListener.onInterstitialShowSuccess();
        }
    }

    @Override
    public void onPause(Activity activity) {
        try {
            this.wvc.enterBackground();
            this.wvc.unregisterConnectionReceiver((Context)activity);
            this.endSession();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            IronSourceAsyncHttpRequestTask ironSourceAsyncHttpRequestTask = new IronSourceAsyncHttpRequestTask();
            Object[] arrobject = new String[1];
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("https://www.supersonicads.com/mobile/sdk5/log?method=");
            stringBuilder.append(exception.getStackTrace()[0].getMethodName());
            arrobject[0] = stringBuilder.toString();
            ironSourceAsyncHttpRequestTask.execute(arrobject);
            return;
        }
    }

    @Override
    public void onRVAdCredited(String string, int n2) {
        OnRewardedVideoListener onRewardedVideoListener;
        DemandSource demandSource = this.getDemandSourceByName(SSAEnums.ProductType.RewardedVideo, string);
        if (demandSource != null && (onRewardedVideoListener = this.getAdProductListenerAsRVListener(demandSource)) != null) {
            onRewardedVideoListener.onRVAdCredited(n2);
        }
    }

    @Override
    public void onRVNoMoreOffers(String string) {
        OnRewardedVideoListener onRewardedVideoListener;
        DemandSource demandSource = this.getDemandSourceByName(SSAEnums.ProductType.RewardedVideo, string);
        if (demandSource != null && (onRewardedVideoListener = this.getAdProductListenerAsRVListener(demandSource)) != null) {
            onRewardedVideoListener.onRVNoMoreOffers();
        }
    }

    @Override
    public void onRVShowFail(String string, String string2) {
        OnRewardedVideoListener onRewardedVideoListener;
        DemandSource demandSource = this.getDemandSourceByName(SSAEnums.ProductType.RewardedVideo, string);
        if (demandSource != null && (onRewardedVideoListener = this.getAdProductListenerAsRVListener(demandSource)) != null) {
            onRewardedVideoListener.onRVShowFail(string2);
        }
    }

    @Override
    public void onResume(Activity activity) {
        mutableContextWrapper.setBaseContext((Context)activity);
        this.wvc.enterForeground();
        this.wvc.registerConnectionReceiver((Context)activity);
        if (this.session == null) {
            this.resumeSession((Context)activity);
        }
    }

    public void resumeSession(Context context) {
        this.session = new SSASession(context, SSASession.SessionType.backFromBG);
    }

    @Override
    public void setMediationState(String string, String string2, int n2) {
        SSAEnums.ProductType productType;
        DemandSource demandSource;
        if (!TextUtils.isEmpty((CharSequence)string) && !TextUtils.isEmpty((CharSequence)string2) && (productType = SDKUtils.getProductType(string)) != null && (demandSource = this.mDemandSourceManager.getDemandSourceByName(productType, string2)) != null) {
            demandSource.setMediationState(n2);
        }
    }

    @Override
    public void showInterstitial(JSONObject jSONObject) {
        this.wvc.showInterstitial(jSONObject);
    }

    @Override
    public void showOfferWall(Map<String, String> map) {
        this.wvc.showOfferWall(map);
    }

    @Override
    public void showRewardedVideo(JSONObject jSONObject) {
        this.wvc.showRewardedVideo(jSONObject);
    }

    @Override
    public void updateConsentInfo(JSONObject jSONObject) {
        IronSourceWebView ironSourceWebView = this.wvc;
        if (ironSourceWebView != null) {
            ironSourceWebView.updateConsentInfo(jSONObject);
        }
    }
}

