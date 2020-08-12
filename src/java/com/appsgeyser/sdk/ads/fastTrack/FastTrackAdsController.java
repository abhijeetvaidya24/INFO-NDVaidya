/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Log
 *  android.view.ViewGroup
 *  com.appsgeyser.sdk.InternalEntryPoint
 *  com.appsgeyser.sdk.ads.fastTrack.FastTrackAdsController$
 *  com.appsgeyser.sdk.ads.fastTrack.FastTrackAdsController$$Lambda
 *  com.appsgeyser.sdk.ads.fastTrack.FastTrackAdsController$$Lambda$1
 *  com.appsgeyser.sdk.ads.fastTrack.FastTrackAdsController$$Lambda$2
 *  com.appsgeyser.sdk.ads.fastTrack.FastTrackAdsController$$Lambda$3
 *  com.appsgeyser.sdk.ads.fastTrack.FastTrackAdsController$$Lambda$4
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdinCubeAdapter
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdmobAdapter
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackDisabledAdapter
 *  com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter
 *  com.appsgeyser.sdk.inapp.InAppPurchaseController
 *  java.lang.Class
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  rx.Subscription
 *  rx.functions.Action1
 *  rx.subjects.BehaviorSubject
 */
package com.appsgeyser.sdk.ads.fastTrack;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import com.appsgeyser.sdk.InternalEntryPoint;
import com.appsgeyser.sdk.ads.fastTrack.FastTrackAdsController$;
import com.appsgeyser.sdk.ads.fastTrack.FastTrackAdsController$$Lambda$5;
import com.appsgeyser.sdk.ads.fastTrack.FastTrackSdkModel;
import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdinCubeAdapter;
import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackAdmobAdapter;
import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackBaseAdapter;
import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackDisabledAdapter;
import com.appsgeyser.sdk.ads.fastTrack.adapters.FastTrackMopubAdapter;
import com.appsgeyser.sdk.configuration.models.ConfigPhp;
import com.appsgeyser.sdk.inapp.InAppPurchaseController;
import com.appsgeyser.sdk.ui.AppsgeyserProgressDialog;
import rx.Subscription;
import rx.functions.Action1;
import rx.subjects.BehaviorSubject;

public class FastTrackAdsController {
    private static FastTrackAdsController instance;
    private FastTrackBaseAdapter adsAdapter;
    private BehaviorSubject<BannerViewPlacementWrapper> bannerViewPlacementPublishSubject = BehaviorSubject.create();
    private BehaviorSubject<ContextConfigWrapper> consentPendingBlocker = BehaviorSubject.create();
    private BehaviorSubject<FastTrackBaseAdapter.FullscreenListener> fullscreenListenerPublishSubject = BehaviorSubject.create();
    private String fullscreenPendingLoadTag;
    private String fullscreenPendingPlacementTag;
    private boolean fullscreenPendingUseFrequencyTimer;
    private boolean isActive;
    private BehaviorSubject<Integer> nativeAdsPublishSubject = BehaviorSubject.create();

    private FastTrackAdsController() {
    }

    static /* synthetic */ void access$lambda$0(FastTrackAdsController fastTrackAdsController, ContextConfigWrapper contextConfigWrapper) {
        fastTrackAdsController.init(contextConfigWrapper);
    }

    public static FastTrackAdsController getInstance() {
        Class<FastTrackAdsController> class_ = FastTrackAdsController.class;
        synchronized (FastTrackAdsController.class) {
            if (instance == null) {
                instance = new FastTrackAdsController();
            }
            FastTrackAdsController fastTrackAdsController = instance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return fastTrackAdsController;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private void init(ContextConfigWrapper var1_1) {
        block10 : {
            block8 : {
                block9 : {
                    var2_2 = var1_1.getConfigPhp().getActiveAdsSDK();
                    var3_3 = var2_2.getName();
                    var4_4 = var3_3.hashCode();
                    if (var4_4 == -1938894275) break block8;
                    if (var4_4 == -963943683) break block9;
                    if (var4_4 != -261021665 || !var3_3.equals((Object)"mopubSdk")) ** GOTO lbl-1000
                    var5_5 = 1;
                    break block10;
                }
                if (!var3_3.equals((Object)"admobSdk")) ** GOTO lbl-1000
                var5_5 = 0;
                break block10;
            }
            if (var3_3.equals((Object)"adincubeSdk")) {
                var5_5 = 2;
            } else lbl-1000: // 3 sources:
            {
                var5_5 = -1;
            }
        }
        if (var5_5 != 0) {
            if (var5_5 != 1) {
                if (var5_5 != 2) {
                    var12_6 = new StringBuilder();
                    var12_6.append("Unknown adsAdapter: ");
                    var12_6.append(var2_2.getName());
                    var12_6.append(" . Disabling ads controller.");
                    Log.d((String)"fastTrackTag", (String)var12_6.toString());
                    this.adsAdapter = new FastTrackDisabledAdapter(var2_2, var1_1.getContext());
                } else {
                    Log.d((String)"fastTrackTag", (String)"initializing adinCube adsAdapter");
                    this.adsAdapter = new FastTrackAdinCubeAdapter(var2_2, var1_1.getContext());
                }
            } else {
                Log.d((String)"fastTrackTag", (String)"initializing mopub adsAdapter");
                this.adsAdapter = new FastTrackMopubAdapter(var2_2, var1_1.getContext());
            }
        } else {
            Log.d((String)"fastTrackTag", (String)"initializing admob adsAdapter");
            this.adsAdapter = new FastTrackAdmobAdapter(var2_2, var1_1.getContext());
        }
        this.adsAdapter.loadFullscreen();
        this.fullscreenListenerPublishSubject.subscribe($Lambda$2.lambdaFactory$((FastTrackAdsController)this));
        this.bannerViewPlacementPublishSubject.subscribe($Lambda$3.lambdaFactory$((FastTrackAdsController)this));
        this.nativeAdsPublishSubject.subscribe($Lambda$4.lambdaFactory$((FastTrackAdsController)this));
        this.adsAdapter.loadRewardedVideo();
        this.isActive = true;
        var10_7 = this.fullscreenPendingLoadTag;
        if (var10_7 == null) return;
        this.showFullscreen(var10_7, var1_1.getContext(), this.fullscreenPendingPlacementTag, this.fullscreenPendingUseFrequencyTimer);
    }

    static /* synthetic */ void lambda$init$0(FastTrackAdsController fastTrackAdsController, FastTrackBaseAdapter.FullscreenListener fullscreenListener) {
        fastTrackAdsController.adsAdapter.setFullscreenListener(fullscreenListener);
    }

    static /* synthetic */ void lambda$init$1(FastTrackAdsController fastTrackAdsController, BannerViewPlacementWrapper bannerViewPlacementWrapper) {
        fastTrackAdsController.adsAdapter.initBannerView(bannerViewPlacementWrapper.getBannerViewContainer(), bannerViewPlacementWrapper.getPlacementTag());
    }

    static /* synthetic */ void lambda$init$2(FastTrackAdsController fastTrackAdsController, Integer n2) {
        fastTrackAdsController.adsAdapter.loadNativeAds(n2);
    }

    static /* synthetic */ void lambda$showFullscreen$3(FastTrackAdsController fastTrackAdsController, String string2, String string3, boolean bl) {
        fastTrackAdsController.adsAdapter.showFullscreen(string2, string3, bl);
        Log.d((String)"fastTrackTag", (String)"attempt to show fullscreen");
    }

    public void consentRequestProcessFinished() {
        this.consentPendingBlocker.subscribe($Lambda$1.lambdaFactory$((FastTrackAdsController)this));
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void onPause() {
        FastTrackBaseAdapter fastTrackBaseAdapter = this.adsAdapter;
        if (fastTrackBaseAdapter != null) {
            fastTrackBaseAdapter.onPause();
        }
    }

    public void onResume(Context context) {
        FastTrackBaseAdapter fastTrackBaseAdapter = this.adsAdapter;
        if (fastTrackBaseAdapter != null) {
            fastTrackBaseAdapter.onResume(context);
        }
    }

    public void requestInit(ConfigPhp configPhp, Context context) {
        this.consentPendingBlocker.onNext((Object)new ContextConfigWrapper(configPhp, context));
    }

    public void setBannerViewContainer(ViewGroup viewGroup, String string2) {
        if (!InAppPurchaseController.getInstance().isDisableAdsPurchased()) {
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
                this.bannerViewPlacementPublishSubject.onNext((Object)new BannerViewPlacementWrapper(viewGroup, string2));
                return;
            }
        } else {
            Log.d((String)"fastTrackTag", (String)"bannerView attach cancelled, ads disabled by in app purchase");
        }
    }

    public void setFullscreenListener(FastTrackBaseAdapter.FullscreenListener fullscreenListener) {
        if (fullscreenListener != null) {
            this.fullscreenListenerPublishSubject.onNext((Object)fullscreenListener);
        }
    }

    public void showFullscreen(String string2, Context context, String string3, boolean bl) {
        if (!InAppPurchaseController.getInstance().isDisableAdsPurchased()) {
            if (this.isActive && !InternalEntryPoint.getInstance().isConsentRequestProcessActive()) {
                if (context != null) {
                    this.adsAdapter.setContext(context);
                    this.adsAdapter.setProgressDialog(new AppsgeyserProgressDialog(context));
                }
                new Handler(this.adsAdapter.getContext().getMainLooper()).postDelayed(FastTrackAdsController$$Lambda$5.lambdaFactory$(this, string2, string3, bl), 1000L);
                this.fullscreenPendingLoadTag = null;
                this.fullscreenPendingPlacementTag = null;
                this.fullscreenPendingUseFrequencyTimer = bl;
                return;
            }
            this.fullscreenPendingLoadTag = string2;
            this.fullscreenPendingPlacementTag = string3;
            this.fullscreenPendingUseFrequencyTimer = bl;
            Log.d((String)"fastTrackTag", (String)"fasttrack controller not activated");
            return;
        }
        if (this.adsAdapter.getFullscreenListener() != null) {
            this.adsAdapter.getFullscreenListener().onFailedToShow();
        }
        Log.d((String)"fastTrackTag", (String)"fullscreen request cancelled, ads disabled by in app purchase");
    }

    public void showPendingFullscreen(Context context) {
        String string2 = this.fullscreenPendingLoadTag;
        if (string2 != null) {
            this.showFullscreen(string2, context, this.fullscreenPendingPlacementTag, this.fullscreenPendingUseFrequencyTimer);
        }
    }

    public void showRewardedVideo(FastTrackBaseAdapter.RewardedVideoListener rewardedVideoListener, String string2) {
        if (!InAppPurchaseController.getInstance().isDisableAdsPurchased()) {
            if (rewardedVideoListener != null) {
                if (this.isActive) {
                    this.adsAdapter.showRewardedVideo(rewardedVideoListener, string2);
                    Log.d((String)"fastTrackTag", (String)"attempt to show rewardedVideo");
                    return;
                }
                rewardedVideoListener.onVideoDeactivated();
                Log.d((String)"fastTrackTag", (String)"fasttrack controller not activated");
                return;
            }
        } else {
            if (rewardedVideoListener != null) {
                rewardedVideoListener.onVideoDeactivated();
            }
            Log.d((String)"fastTrackTag", (String)"rewarded request cancelled, ads disabled by in app purchase");
        }
    }

    private class BannerViewPlacementWrapper {
        ViewGroup bannerViewContainer;
        String placementTag;

        BannerViewPlacementWrapper(ViewGroup viewGroup, String string2) {
            this.bannerViewContainer = viewGroup;
            this.placementTag = string2;
        }

        ViewGroup getBannerViewContainer() {
            return this.bannerViewContainer;
        }

        String getPlacementTag() {
            return this.placementTag;
        }
    }

    private class ContextConfigWrapper {
        ConfigPhp configPhp;
        Context context;

        ContextConfigWrapper(ConfigPhp configPhp, Context context) {
            this.configPhp = configPhp;
            this.context = context;
        }

        ConfigPhp getConfigPhp() {
            return this.configPhp;
        }

        Context getContext() {
            return this.context;
        }
    }

}

