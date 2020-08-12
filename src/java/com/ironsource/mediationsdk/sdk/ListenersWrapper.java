/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk.sdk;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.InternalOfferwallListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.ListenersWrapper;
import com.ironsource.mediationsdk.sdk.OfferwallListener;
import com.ironsource.mediationsdk.sdk.RewardedInterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class ListenersWrapper
implements ISDemandOnlyInterstitialListener,
ISDemandOnlyRewardedVideoListener,
InternalOfferwallListener,
InterstitialListener,
RewardedInterstitialListener,
RewardedVideoListener,
SegmentListener {
    private CallbackHandlerThread mCallbackHandlerThread = new Thread(){
        private Handler mCallbackHandler;

        public Handler getCallbackHandler() {
            return this.mCallbackHandler;
        }

        public void run() {
            Looper.prepare();
            this.mCallbackHandler = new Handler();
            Looper.loop();
        }
    };
    private ISDemandOnlyInterstitialListener mISDemandOnlyInterstitialListener;
    private ISDemandOnlyRewardedVideoListener mISDemandOnlyRewardedVideoListener;
    private InterstitialListener mInterstitialListener;
    private OfferwallListener mOfferwallListener;
    private RewardedInterstitialListener mRewardedInterstitialListener;
    private RewardedVideoListener mRewardedVideoListener;
    private SegmentListener mSegementListener;

    public ListenersWrapper() {
        this.mCallbackHandlerThread.start();
    }

    static /* synthetic */ SegmentListener access$100(ListenersWrapper listenersWrapper) {
        return listenersWrapper.mSegementListener;
    }

    static /* synthetic */ RewardedVideoListener access$200(ListenersWrapper listenersWrapper) {
        return listenersWrapper.mRewardedVideoListener;
    }

    static /* synthetic */ InterstitialListener access$300(ListenersWrapper listenersWrapper) {
        return listenersWrapper.mInterstitialListener;
    }

    static /* synthetic */ RewardedInterstitialListener access$400(ListenersWrapper listenersWrapper) {
        return listenersWrapper.mRewardedInterstitialListener;
    }

    static /* synthetic */ OfferwallListener access$500(ListenersWrapper listenersWrapper) {
        return listenersWrapper.mOfferwallListener;
    }

    static /* synthetic */ ISDemandOnlyRewardedVideoListener access$600(ListenersWrapper listenersWrapper) {
        return listenersWrapper.mISDemandOnlyRewardedVideoListener;
    }

    static /* synthetic */ ISDemandOnlyInterstitialListener access$700(ListenersWrapper listenersWrapper) {
        return listenersWrapper.mISDemandOnlyInterstitialListener;
    }

    private boolean canSendCallback(Object object) {
        return object != null && this.mCallbackHandlerThread != null;
    }

    private void sendCallback(Runnable runnable) {
        CallbackHandlerThread callbackHandlerThread = this.mCallbackHandlerThread;
        if (callbackHandlerThread == null) {
            return;
        }
        Handler handler = callbackHandlerThread.getCallbackHandler();
        if (handler != null) {
            handler.post(runnable);
        }
    }

    @Override
    public void onGetOfferwallCreditsFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onGetOfferwallCreditsFailed(");
        stringBuilder.append((Object)ironSourceError);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mOfferwallListener)) {
            this.sendCallback(new Runnable(this, ironSourceError){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ IronSourceError val$error;
                {
                    this.this$0 = listenersWrapper;
                    this.val$error = ironSourceError;
                }

                public void run() {
                    ListenersWrapper.access$500(this.this$0).onGetOfferwallCreditsFailed(this.val$error);
                }
            });
        }
    }

    @Override
    public void onInterstitialAdClicked() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClicked()", 1);
        if (this.canSendCallback(this.mInterstitialListener)) {
            this.sendCallback(new Runnable(this){
                final /* synthetic */ ListenersWrapper this$0;
                {
                    this.this$0 = listenersWrapper;
                }

                public void run() {
                    ListenersWrapper.access$300(this.this$0).onInterstitialAdClicked();
                }
            });
        }
    }

    @Override
    public void onInterstitialAdClicked(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInterstitialAdClicked(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyInterstitialListener)) {
            this.sendCallback(new Runnable(this, string){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                }

                public void run() {
                    ListenersWrapper.access$700(this.this$0).onInterstitialAdClicked(this.val$instanceId);
                }
            });
        }
    }

    @Override
    public void onInterstitialAdClosed() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdClosed()", 1);
        if (this.canSendCallback(this.mInterstitialListener)) {
            this.sendCallback(new Runnable(this){
                final /* synthetic */ ListenersWrapper this$0;
                {
                    this.this$0 = listenersWrapper;
                }

                public void run() {
                    ListenersWrapper.access$300(this.this$0).onInterstitialAdClosed();
                }
            });
        }
    }

    @Override
    public void onInterstitialAdClosed(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInterstitialAdClosed(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyInterstitialListener)) {
            this.sendCallback(new Runnable(this, string){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                }

                public void run() {
                    ListenersWrapper.access$700(this.this$0).onInterstitialAdClosed(this.val$instanceId);
                }
            });
        }
    }

    @Override
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInterstitialAdLoadFailed(");
        stringBuilder.append((Object)ironSourceError);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mInterstitialListener)) {
            this.sendCallback(new Runnable(this, ironSourceError){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ IronSourceError val$error;
                {
                    this.this$0 = listenersWrapper;
                    this.val$error = ironSourceError;
                }

                public void run() {
                    ListenersWrapper.access$300(this.this$0).onInterstitialAdLoadFailed(this.val$error);
                }
            });
        }
    }

    @Override
    public void onInterstitialAdLoadFailed(String string, IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInterstitialAdLoadFailed(");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append((Object)ironSourceError);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyInterstitialListener)) {
            this.sendCallback(new Runnable(this, string, ironSourceError){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ IronSourceError val$error;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                    this.val$error = ironSourceError;
                }

                public void run() {
                    ListenersWrapper.access$700(this.this$0).onInterstitialAdLoadFailed(this.val$instanceId, this.val$error);
                }
            });
        }
    }

    @Override
    public void onInterstitialAdOpened() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdOpened()", 1);
        if (this.canSendCallback(this.mInterstitialListener)) {
            this.sendCallback(new Runnable(this){
                final /* synthetic */ ListenersWrapper this$0;
                {
                    this.this$0 = listenersWrapper;
                }

                public void run() {
                    ListenersWrapper.access$300(this.this$0).onInterstitialAdOpened();
                }
            });
        }
    }

    @Override
    public void onInterstitialAdOpened(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInterstitialAdOpened(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyInterstitialListener)) {
            this.sendCallback(new Runnable(this, string){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                }

                public void run() {
                    ListenersWrapper.access$700(this.this$0).onInterstitialAdOpened(this.val$instanceId);
                }
            });
        }
    }

    @Override
    public void onInterstitialAdReady() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdReady()", 1);
        if (this.canSendCallback(this.mInterstitialListener)) {
            this.sendCallback(new Runnable(this){
                final /* synthetic */ ListenersWrapper this$0;
                {
                    this.this$0 = listenersWrapper;
                }

                public void run() {
                    ListenersWrapper.access$300(this.this$0).onInterstitialAdReady();
                }
            });
        }
    }

    @Override
    public void onInterstitialAdReady(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInterstitialAdReady(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyInterstitialListener)) {
            this.sendCallback(new Runnable(this, string){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                }

                public void run() {
                    ListenersWrapper.access$700(this.this$0).onInterstitialAdReady(this.val$instanceId);
                }
            });
        }
    }

    @Override
    public void onInterstitialAdRewarded() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdRewarded()", 1);
        if (this.canSendCallback(this.mRewardedInterstitialListener)) {
            this.sendCallback(new Runnable(this){
                final /* synthetic */ ListenersWrapper this$0;
                {
                    this.this$0 = listenersWrapper;
                }

                public void run() {
                    ListenersWrapper.access$400(this.this$0).onInterstitialAdRewarded();
                }
            });
        }
    }

    @Override
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInterstitialAdShowFailed(");
        stringBuilder.append((Object)ironSourceError);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(false);
        try {
            if (ironSourceError.getErrorCode() == 524) {
                jSONObject.put("reason", 1);
            }
            jSONObject.put("errorCode", ironSourceError.getErrorCode());
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        EventData eventData = new EventData(29, jSONObject);
        InterstitialEventsManager.getInstance().log(eventData);
        if (this.canSendCallback(this.mInterstitialListener)) {
            this.sendCallback(new Runnable(this, ironSourceError){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ IronSourceError val$error;
                {
                    this.this$0 = listenersWrapper;
                    this.val$error = ironSourceError;
                }

                public void run() {
                    ListenersWrapper.access$300(this.this$0).onInterstitialAdShowFailed(this.val$error);
                }
            });
        }
    }

    @Override
    public void onInterstitialAdShowFailed(String string, IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInterstitialAdShowFailed(");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append((Object)ironSourceError);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(true);
        try {
            if (ironSourceError.getErrorCode() == 524) {
                jSONObject.put("reason", 1);
            }
            jSONObject.put("errorCode", ironSourceError.getErrorCode());
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        EventData eventData = new EventData(29, jSONObject);
        InterstitialEventsManager.getInstance().log(eventData);
        if (this.canSendCallback(this.mISDemandOnlyInterstitialListener)) {
            this.sendCallback(new Runnable(this, string, ironSourceError){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ IronSourceError val$error;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                    this.val$error = ironSourceError;
                }

                public void run() {
                    ListenersWrapper.access$700(this.this$0).onInterstitialAdShowFailed(this.val$instanceId, this.val$error);
                }
            });
        }
    }

    @Override
    public void onInterstitialAdShowSucceeded() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onInterstitialAdShowSucceeded()", 1);
        if (this.canSendCallback(this.mInterstitialListener)) {
            this.sendCallback(new Runnable(this){
                final /* synthetic */ ListenersWrapper this$0;
                {
                    this.this$0 = listenersWrapper;
                }

                public void run() {
                    ListenersWrapper.access$300(this.this$0).onInterstitialAdShowSucceeded();
                }
            });
        }
    }

    @Override
    public void onInterstitialAdShowSucceeded(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInterstitialAdShowSucceeded(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyInterstitialListener)) {
            this.sendCallback(new Runnable(this, string){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                }

                public void run() {
                    ListenersWrapper.access$700(this.this$0).onInterstitialAdShowSucceeded(this.val$instanceId);
                }
            });
        }
    }

    @Override
    public boolean onOfferwallAdCredited(int n2, int n3, boolean bl) {
        OfferwallListener offerwallListener = this.mOfferwallListener;
        boolean bl2 = offerwallListener != null ? offerwallListener.onOfferwallAdCredited(n2, n3, bl) : false;
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onOfferwallAdCredited(credits:");
        stringBuilder.append(n2);
        stringBuilder.append(", ");
        stringBuilder.append("totalCredits:");
        stringBuilder.append(n3);
        stringBuilder.append(", ");
        stringBuilder.append("totalCreditsFlag:");
        stringBuilder.append(bl);
        stringBuilder.append("):");
        stringBuilder.append(bl2);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        return bl2;
    }

    @Override
    public void onOfferwallAvailable(boolean bl) {
        this.onOfferwallAvailable(bl, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onOfferwallAvailable(boolean bl, IronSourceError ironSourceError) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onOfferwallAvailable(isAvailable: ");
        stringBuilder.append(bl);
        stringBuilder.append(")");
        String string = stringBuilder.toString();
        if (ironSourceError != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(", error: ");
            stringBuilder2.append(ironSourceError.getErrorMessage());
            string = stringBuilder2.toString();
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, string, 1);
        JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(false);
        try {
            jSONObject.put("status", (Object)String.valueOf((boolean)bl));
            if (ironSourceError != null) {
                jSONObject.put("errorCode", ironSourceError.getErrorCode());
            }
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        EventData eventData = new EventData(302, jSONObject);
        RewardedVideoEventsManager.getInstance().log(eventData);
        if (this.canSendCallback(this.mOfferwallListener)) {
            this.sendCallback(new Runnable(this, bl){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ boolean val$isAvailable;
                {
                    this.this$0 = listenersWrapper;
                    this.val$isAvailable = bl;
                }

                public void run() {
                    ListenersWrapper.access$500(this.this$0).onOfferwallAvailable(this.val$isAvailable);
                }
            });
        }
    }

    @Override
    public void onOfferwallClosed() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallClosed()", 1);
        if (this.canSendCallback(this.mOfferwallListener)) {
            this.sendCallback(new Runnable(this){
                final /* synthetic */ ListenersWrapper this$0;
                {
                    this.this$0 = listenersWrapper;
                }

                public void run() {
                    ListenersWrapper.access$500(this.this$0).onOfferwallClosed();
                }
            });
        }
    }

    @Override
    public void onOfferwallOpened() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onOfferwallOpened()", 1);
        if (this.canSendCallback(this.mOfferwallListener)) {
            this.sendCallback(new Runnable(this){
                final /* synthetic */ ListenersWrapper this$0;
                {
                    this.this$0 = listenersWrapper;
                }

                public void run() {
                    ListenersWrapper.access$500(this.this$0).onOfferwallOpened();
                }
            });
        }
    }

    @Override
    public void onOfferwallShowFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onOfferwallShowFailed(");
        stringBuilder.append((Object)ironSourceError);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mOfferwallListener)) {
            this.sendCallback(new Runnable(this, ironSourceError){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ IronSourceError val$error;
                {
                    this.this$0 = listenersWrapper;
                    this.val$error = ironSourceError;
                }

                public void run() {
                    ListenersWrapper.access$500(this.this$0).onOfferwallShowFailed(this.val$error);
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAdClicked(Placement placement) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRewardedVideoAdClicked(");
        stringBuilder.append(placement.getPlacementName());
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mRewardedVideoListener)) {
            this.sendCallback(new Runnable(this, placement){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ Placement val$placement;
                {
                    this.this$0 = listenersWrapper;
                    this.val$placement = placement;
                }

                public void run() {
                    ListenersWrapper.access$200(this.this$0).onRewardedVideoAdClicked(this.val$placement);
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAdClicked(String string, Placement placement) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRewardedVideoAdClicked(");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(placement.getPlacementName());
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyRewardedVideoListener)) {
            this.sendCallback(new Runnable(this, string, placement){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ String val$instanceId;
                final /* synthetic */ Placement val$placement;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                    this.val$placement = placement;
                }

                public void run() {
                    ListenersWrapper.access$600(this.this$0).onRewardedVideoAdClicked(this.val$instanceId, this.val$placement);
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAdClosed() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClosed()", 1);
        if (this.canSendCallback(this.mRewardedVideoListener)) {
            this.sendCallback(new Runnable(this){
                final /* synthetic */ ListenersWrapper this$0;
                {
                    this.this$0 = listenersWrapper;
                }

                public void run() {
                    ListenersWrapper.access$200(this.this$0).onRewardedVideoAdClosed();
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAdClosed(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRewardedVideoAdClosed(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyRewardedVideoListener)) {
            this.sendCallback(new Runnable(this, string){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                }

                public void run() {
                    ListenersWrapper.access$600(this.this$0).onRewardedVideoAdClosed(this.val$instanceId);
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAdOpened() {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdOpened()", 1);
        if (this.canSendCallback(this.mRewardedVideoListener)) {
            this.sendCallback(new Runnable(this){
                final /* synthetic */ ListenersWrapper this$0;
                {
                    this.this$0 = listenersWrapper;
                }

                public void run() {
                    ListenersWrapper.access$200(this.this$0).onRewardedVideoAdOpened();
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAdOpened(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRewardedVideoAdOpened(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyRewardedVideoListener)) {
            this.sendCallback(new Runnable(this, string){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                }

                public void run() {
                    ListenersWrapper.access$600(this.this$0).onRewardedVideoAdOpened(this.val$instanceId);
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAdRewarded(Placement placement) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRewardedVideoAdRewarded(");
        stringBuilder.append(placement.toString());
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mRewardedVideoListener)) {
            this.sendCallback(new Runnable(this, placement){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ Placement val$placement;
                {
                    this.this$0 = listenersWrapper;
                    this.val$placement = placement;
                }

                public void run() {
                    ListenersWrapper.access$200(this.this$0).onRewardedVideoAdRewarded(this.val$placement);
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAdRewarded(String string, Placement placement) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRewardedVideoAdRewarded(");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(placement.toString());
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyRewardedVideoListener)) {
            this.sendCallback(new Runnable(this, string, placement){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ String val$instanceId;
                final /* synthetic */ Placement val$placement;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                    this.val$placement = placement;
                }

                public void run() {
                    ListenersWrapper.access$600(this.this$0).onRewardedVideoAdRewarded(this.val$instanceId, this.val$placement);
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRewardedVideoAdShowFailed(");
        stringBuilder.append(ironSourceError.toString());
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(false);
        try {
            jSONObject.put("status", (Object)"false");
            if (ironSourceError.getErrorCode() == 524) {
                jSONObject.put("reason", 1);
            }
            jSONObject.put("errorCode", ironSourceError.getErrorCode());
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        EventData eventData = new EventData(17, jSONObject);
        RewardedVideoEventsManager.getInstance().log(eventData);
        if (this.canSendCallback(this.mRewardedVideoListener)) {
            this.sendCallback(new Runnable(this, ironSourceError){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ IronSourceError val$error;
                {
                    this.this$0 = listenersWrapper;
                    this.val$error = ironSourceError;
                }

                public void run() {
                    ListenersWrapper.access$200(this.this$0).onRewardedVideoAdShowFailed(this.val$error);
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAdShowFailed(String string, IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRewardedVideoAdShowFailed(");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(ironSourceError.toString());
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(true);
        try {
            jSONObject.put("status", (Object)"false");
            if (ironSourceError.getErrorCode() == 524) {
                jSONObject.put("reason", 1);
            }
            jSONObject.put("errorCode", ironSourceError.getErrorCode());
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        EventData eventData = new EventData(17, jSONObject);
        RewardedVideoEventsManager.getInstance().log(eventData);
        if (this.canSendCallback(this.mISDemandOnlyRewardedVideoListener)) {
            this.sendCallback(new Runnable(this, string, ironSourceError){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ IronSourceError val$error;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                    this.val$error = ironSourceError;
                }

                public void run() {
                    ListenersWrapper.access$600(this.this$0).onRewardedVideoAdShowFailed(this.val$instanceId, this.val$error);
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAvailabilityChanged(String string, boolean bl) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRewardedVideoAvailabilityChanged(");
        stringBuilder.append(string);
        stringBuilder.append(", ");
        stringBuilder.append(bl);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mISDemandOnlyRewardedVideoListener)) {
            this.sendCallback(new Runnable(this, string, bl){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ boolean val$available;
                final /* synthetic */ String val$instanceId;
                {
                    this.this$0 = listenersWrapper;
                    this.val$instanceId = string;
                    this.val$available = bl;
                }

                public void run() {
                    ListenersWrapper.access$600(this.this$0).onRewardedVideoAvailabilityChanged(this.val$instanceId, this.val$available);
                }
            });
        }
    }

    @Override
    public void onRewardedVideoAvailabilityChanged(boolean bl) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onRewardedVideoAvailabilityChanged(available:");
        stringBuilder.append(bl);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(false);
        try {
            jSONObject.put("status", (Object)String.valueOf((boolean)bl));
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        EventData eventData = new EventData(7, jSONObject);
        RewardedVideoEventsManager.getInstance().log(eventData);
        if (this.canSendCallback(this.mRewardedVideoListener)) {
            this.sendCallback(new Runnable(this, bl){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ boolean val$available;
                {
                    this.this$0 = listenersWrapper;
                    this.val$available = bl;
                }

                public void run() {
                    ListenersWrapper.access$200(this.this$0).onRewardedVideoAvailabilityChanged(this.val$available);
                }
            });
        }
    }

    @Override
    public void onSegmentReceived(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSegmentReceived(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.canSendCallback(this.mSegementListener)) {
            this.sendCallback(new Runnable(this, string){
                final /* synthetic */ ListenersWrapper this$0;
                final /* synthetic */ String val$segment;
                {
                    this.this$0 = listenersWrapper;
                    this.val$segment = string;
                }

                public void run() {
                    if (this.val$segment != null) {
                        ListenersWrapper.access$100(this.this$0).onSegmentReceived(this.val$segment);
                        return;
                    }
                    ListenersWrapper.access$100(this.this$0).onSegmentReceived("");
                }
            });
        }
    }

    public void setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        this.mISDemandOnlyInterstitialListener = iSDemandOnlyInterstitialListener;
    }

    public void setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        this.mISDemandOnlyRewardedVideoListener = iSDemandOnlyRewardedVideoListener;
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        this.mInterstitialListener = interstitialListener;
    }

    public void setOfferwallListener(OfferwallListener offerwallListener) {
        this.mOfferwallListener = offerwallListener;
    }

    public void setRewardedInterstitialListener(RewardedInterstitialListener rewardedInterstitialListener) {
        this.mRewardedInterstitialListener = rewardedInterstitialListener;
    }

    public void setRewardedVideoListener(RewardedVideoListener rewardedVideoListener) {
        this.mRewardedVideoListener = rewardedVideoListener;
    }

    public void setSegmentListener(SegmentListener segmentListener) {
        this.mSegementListener = segmentListener;
    }

}

