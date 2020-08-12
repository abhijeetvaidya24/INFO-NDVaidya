/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  com.aerserv.sdk.controller.AdManager$1
 *  com.aerserv.sdk.controller.AdManager$10
 *  com.aerserv.sdk.controller.AdManager$2
 *  com.aerserv.sdk.controller.AdManager$3
 *  com.aerserv.sdk.controller.AdManager$4
 *  com.aerserv.sdk.controller.AdManager$5
 *  com.aerserv.sdk.controller.AdManager$6
 *  com.aerserv.sdk.controller.AdManager$7
 *  com.aerserv.sdk.controller.AdManager$8
 *  com.aerserv.sdk.controller.command.ShowProviderAdCommand
 *  com.aerserv.sdk.model.ad.ThirdPartyProviderAd
 *  com.aerserv.sdk.model.ad.VASTProviderAd
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Thread
 *  java.util.Collection
 *  java.util.LinkedList
 *  java.util.List
 *  java.util.Map
 *  java.util.Queue
 *  java.util.Set
 *  java.util.UUID
 *  java.util.concurrent.ConcurrentLinkedQueue
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.aerserv.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.aerserv.sdk.AerServAdType;
import com.aerserv.sdk.AerServConfig;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.AerServEventListener;
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.RequestType;
import com.aerserv.sdk.adapter.AdapterAdRefresher;
import com.aerserv.sdk.adapter.SimultaneousAdLoader;
import com.aerserv.sdk.adapter.ThirdPartyProvider;
import com.aerserv.sdk.analytics.AerServAnalytics;
import com.aerserv.sdk.controller.AdManager;
import com.aerserv.sdk.controller.command.ShowProviderAdCommand;
import com.aerserv.sdk.controller.listener.AdFactoryListener;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.ExecutePlacementListener;
import com.aerserv.sdk.controller.listener.FetchAdListener;
import com.aerserv.sdk.controller.listener.FetchAsplcListener;
import com.aerserv.sdk.controller.listener.FetchPlacementListener;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.controller.listener.ProviderListenerLocator;
import com.aerserv.sdk.controller.listener.SaveShowListener;
import com.aerserv.sdk.controller.listener.ShowListener;
import com.aerserv.sdk.dao.VideoFileCache;
import com.aerserv.sdk.factory.AdFactory;
import com.aerserv.sdk.model.Asplc;
import com.aerserv.sdk.model.Placement;
import com.aerserv.sdk.model.ad.AdType;
import com.aerserv.sdk.model.ad.ProviderAd;
import com.aerserv.sdk.model.ad.ThirdPartyProviderAd;
import com.aerserv.sdk.model.ad.VASTProviderAd;
import com.aerserv.sdk.model.vast.Vpaid;
import com.aerserv.sdk.proxy.FetchAsplcProxy;
import com.aerserv.sdk.proxy.PlacementProxy;
import com.aerserv.sdk.proxy.SybokProxy;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MoatUtils;
import com.aerserv.sdk.utils.SDKEventHelper;
import com.aerserv.sdk.utils.UrlBuilder;
import com.aerserv.sdk.utils.VASTUtils;
import com.aerserv.sdk.utils.VastErrorHandler;
import com.aerserv.sdk.utils.VerySimpleTimer;
import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdManager {
    public static final String CONTROLLER_ID_KEY = "controllerId";
    private static AtomicBoolean cacheInitialized = new AtomicBoolean(false);
    private static final String failedMessage = "No ad available for this request.";
    private String LOG_TAG = AdManager.class.getSimpleName();
    private ProviderAd ad;
    private AdFactoryListener adFactoryListener = new 3(this);
    private volatile boolean adLoaded = false;
    private AerServAdType aerServAdType;
    private Queue<Asplc> asplcQueueForStep3Req;
    private List<Asplc> asplcs;
    private Integer backButtonTimeout;
    private Context context;
    private final String controllerId = UUID.randomUUID().toString();
    private ExecutePlacementListener executePlacementListener;
    private FetchAdListener fetchAdListener = new 2(this);
    private boolean fireShowAttemptEvent = false;
    private volatile boolean hasBegunLoading = false;
    private volatile boolean hasBegunShowing = false;
    private boolean hasFetchPlacementFailed = false;
    private boolean hasFetchPlacementTimedOut = false;
    private boolean hasShowAttemptEventFired = false;
    private boolean isBackButtonEnabled;
    private boolean isDebug;
    private List<String> keyWords;
    private Placement placement;
    private String platformId;
    private String plc;
    private volatile boolean precache;
    private volatile boolean preload;
    private Map<String, String> pubKeys;
    private String rid;
    private String timeoutMessage;
    private List<Integer> unknownAsplcIds;
    private boolean useHeaderBidding;
    private String userId;
    private String viewId;

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public AdManager(AerServConfig aerServConfig, AerServAdType aerServAdType, ExecutePlacementListener executePlacementListener, SaveShowListener saveShowListener, String string) {
        if (aerServConfig == null) throw new IllegalArgumentException("Cannot instantiate AdManager with null config");
        if (aerServAdType == null) throw new IllegalArgumentException("Cannot instantiate AdManager with null facadeType");
        if (executePlacementListener == null) throw new IllegalArgumentException("Cannot instantiate AdManager with null executePlacementListener");
        try {
            String string2 = this.LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("AdManager constructed controllerId: ");
            stringBuilder.append(this.controllerId);
            AerServLog.d(string2, stringBuilder.toString());
            this.context = aerServConfig.getContext();
            this.plc = aerServConfig.getPlc();
            AerServSettings.init((Activity)this.context, null, this.plc);
            executePlacementListener.onAdManagerCreated(this.controllerId);
            VastErrorHandler.newRequest();
            if (!cacheInitialized.getAndSet(true)) {
                VideoFileCache.clearCache(this.context);
            }
            UrlBuilder.buildUserAgent(this.context);
            this.aerServAdType = aerServAdType;
            this.executePlacementListener = executePlacementListener;
            this.viewId = string;
            this.isDebug = AerServConfig.isDebug();
            this.keyWords = aerServConfig.getKeywords();
            this.pubKeys = aerServConfig.getPubKeys();
            this.preload = aerServConfig.isPreload();
            this.precache = aerServConfig.isPrecache();
            AerServEventListenerLocator.createAndRegister(this.controllerId, aerServConfig.getEventListener());
            ProviderListenerLocator.register(this.controllerId, this.getProviderListener());
            this.userId = aerServConfig.getUserId();
            this.platformId = AerServConfig.getPlatformId();
            this.isBackButtonEnabled = aerServConfig.isBackButtonEnabled();
            this.backButtonTimeout = aerServConfig.getBackButtonTimeout();
            this.useHeaderBidding = aerServConfig.getUseHeaderBidding();
            AerServEventListenerLocator.register(this.controllerId, (AerServEventListener)new 4(this));
            if (this.preload) {
                this.fireShowAttemptEvent = true;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("The ad took longer than ");
            stringBuilder2.append(TimeUnit.MILLISECONDS.toSeconds((long)AerServSettings.getLoadAdTimeout()));
            stringBuilder2.append(" second(s) to load.");
            this.timeoutMessage = stringBuilder2.toString();
            saveShowListener.onSaveShow((ShowListener)new 5(this));
            AerServAnalytics.getInstance().newRequest(aerServConfig.getPlc(), this.controllerId, this.preload);
            AdapterAdRefresher.init();
            if (!aerServConfig.isPreload()) return;
            AerServLog.d(this.LOG_TAG, "Preload is set, so execute the placement now");
            this.executePlacement(RequestType.PRELOAD);
            return;
        }
        catch (Exception exception) {
            AerServLog.e(this.LOG_TAG, "Exception caught in constructor", exception);
        }
    }

    static /* synthetic */ ExecutePlacementListener access$000(AdManager adManager) {
        return adManager.executePlacementListener;
    }

    static /* synthetic */ void access$1100(AdManager adManager, Map map, Map map2) {
        adManager.mergeEvents((Map<AerServEvent, List<String>>)map, (Map<AerServEvent, List<String>>)map2);
    }

    static /* synthetic */ boolean access$1200(AdManager adManager) {
        return adManager.preload;
    }

    static /* synthetic */ boolean access$1202(AdManager adManager, boolean bl) {
        adManager.preload = bl;
        return bl;
    }

    static /* synthetic */ void access$1300(AdManager adManager, RequestType requestType) {
        adManager.showAd(requestType);
    }

    static /* synthetic */ boolean access$1400(AdManager adManager) {
        return adManager.hasBegunLoading;
    }

    static /* synthetic */ boolean access$1500(AdManager adManager) {
        return adManager.hasFetchPlacementFailed;
    }

    static /* synthetic */ boolean access$1502(AdManager adManager, boolean bl) {
        adManager.hasFetchPlacementFailed = bl;
        return bl;
    }

    static /* synthetic */ List access$1602(AdManager adManager, List list) {
        adManager.asplcs = list;
        return list;
    }

    static /* synthetic */ List access$1702(AdManager adManager, List list) {
        adManager.unknownAsplcIds = list;
        return list;
    }

    static /* synthetic */ FetchAdListener access$1800(AdManager adManager) {
        return adManager.fetchAdListener;
    }

    static /* synthetic */ ProviderAd access$202(AdManager adManager, ProviderAd providerAd) {
        adManager.ad = providerAd;
        return providerAd;
    }

    static /* synthetic */ String access$402(AdManager adManager, String string) {
        adManager.rid = string;
        return string;
    }

    static /* synthetic */ void access$600(AdManager adManager, Activity activity) {
        adManager.cleanup(activity);
    }

    static /* synthetic */ Placement access$702(AdManager adManager, Placement placement) {
        adManager.placement = placement;
        return placement;
    }

    static /* synthetic */ void access$800(AdManager adManager) {
        adManager.executeFallback();
    }

    static /* synthetic */ boolean access$900(AdManager adManager) {
        return adManager.adLoaded;
    }

    static /* synthetic */ boolean access$902(AdManager adManager, boolean bl) {
        adManager.adLoaded = bl;
        return bl;
    }

    private void buildAd() {
        Placement placement = this.placement;
        if (placement != null) {
            AdFactory.buildAd(placement, this.adFactoryListener);
            return;
        }
        throw new IllegalStateException("buildAd called while placement is still null");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void cleanup(Activity activity) {
        String string = this.LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Clean up. controllerId: ");
        stringBuilder.append(this.controllerId);
        AerServLog.d(string, stringBuilder.toString());
        ThirdPartyProvider.cleanupInstance(activity, this.controllerId);
        AerServEventListenerLocator.unregister(this.controllerId);
        ProviderListenerLocator.unregister(this.controllerId);
        this.context = null;
        this.executePlacementListener = null;
        this.aerServAdType = null;
        this.placement = null;
        this.keyWords = null;
        this.pubKeys = null;
        this.backButtonTimeout = null;
        this.asplcs = null;
        this.unknownAsplcIds = null;
        this.rid = null;
        this.asplcQueueForStep3Req = null;
        this.fetchAdListener = null;
        this.adFactoryListener = null;
        AerServAnalytics.getInstance().sendToServer();
        if (activity == null) return;
        try {
            activity.runOnUiThread(new Runnable(){

                public void run() {
                    MoatUtils.cleanup(AdManager.this.controllerId);
                }
            });
            return;
        }
        catch (Exception exception) {
            AerServLog.e(this.LOG_TAG, "Failed to clean up", exception);
        }
    }

    private void executeFallback() {
        if (this.hasFetchPlacementTimedOut) {
            AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.AD_FAILED, this.timeoutMessage);
            ProviderAd providerAd = this.ad;
            if (providerAd != null && providerAd.getAdType().equals((Object)AdType.THIRD_PARTY)) {
                SDKEventHelper.sendEvent((ThirdPartyProviderAd)this.ad, "36", this.plc, this.rid);
                return;
            }
            Placement placement = this.placement;
            if (placement != null) {
                SDKEventHelper.sendEvent(placement.getSdkBaseEventUrl(), "AerMarket", this.rid, "36", this.plc);
            }
            return;
        }
        AerServLog.d(this.LOG_TAG, "Trying to execute fallback");
        Placement placement = this.placement.getNextFallback();
        if (placement == null) {
            AerServLog.d(this.LOG_TAG, "No more fallbacks");
            AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.AD_FAILED, failedMessage);
            ProviderListener providerListener = ProviderListenerLocator.getProviderListener(this.controllerId);
            if (providerListener != null) {
                providerListener.onProviderFinished();
                return;
            }
        } else {
            AdFactory.buildAd(placement, (AdFactoryListener)new 8(this, placement));
        }
    }

    private void executeStep1And2(RequestType requestType) {
        AerServLog.d(this.LOG_TAG, "step1: start");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        7 var3_3 = new 7(this, countDownLatch);
        FetchAsplcProxy fetchAsplcProxy = new FetchAsplcProxy();
        Context context = this.context;
        String string = this.plc;
        List<String> list = this.keyWords;
        String string2 = this.rid;
        Map<String, String> map = this.pubKeys;
        String string3 = this.userId;
        boolean bl = this.preload;
        boolean bl2 = this.precache;
        String string4 = this.platformId;
        boolean bl3 = this.useHeaderBidding;
        boolean bl4 = requestType == RequestType.BANNER_REFRESH;
        fetchAsplcProxy.fetchAdapterList(context, string, (FetchAsplcListener)var3_3, list, string2, string, map, string3, bl, bl2, string4, bl3, bl4, this.viewId, AerServSettings.getStep1Timeout());
        try {
            countDownLatch.await((long)AerServSettings.getStep1Timeout(), TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        if (countDownLatch.getCount() > 0L || fetchAsplcProxy.getStatusCode() == 10001) {
            fetchAsplcProxy.cancel();
            AerServLog.w(this.LOG_TAG, "step1: server call time out");
            SybokProxy.sendTimeoutLogSybok(this.context, this.rid, 1, AerServSettings.getStep1Timeout(), this.plc);
        }
        int n2 = "wifi".equals((Object)UrlBuilder.getNetwork(this.context)) ? Asplc.getWifiLimit() : Asplc.getCellularLimit();
        int n3 = n2;
        AdapterAdRefresher.checkAllAdapters(this.plc, this.asplcs, this.unknownAsplcIds);
        List<Asplc> list2 = this.asplcs;
        if (list2 != null && !list2.isEmpty()) {
            if (this.aerServAdType != AerServAdType.INTERSTITIAL) {
                this.asplcQueueForStep3Req = new LinkedList(this.asplcs);
                AerServLog.d(this.LOG_TAG, "step2: not interstitial. skip");
                return;
            }
            if (n3 == 0) {
                this.asplcQueueForStep3Req = new LinkedList(this.asplcs);
                AerServLog.d(this.LOG_TAG, "step2: limit is 0. skip");
                return;
            }
            if (!AerServSettings.isInitDone()) {
                this.asplcQueueForStep3Req = new LinkedList(this.asplcs);
                AerServLog.d(this.LOG_TAG, "step2: pre-init has not done or failed. skip");
                return;
            }
            this.asplcQueueForStep3Req = new ConcurrentLinkedQueue();
            AerServLog.d(this.LOG_TAG, "step2: start");
            SimultaneousAdLoader.getDynamicPrices(this.context, this.asplcQueueForStep3Req, this.asplcs, n3, this.rid, this.plc, this.controllerId, AerServSettings.getStep2Timeout(), this.isDebug);
            return;
        }
        AerServLog.d(this.LOG_TAG, "step2: no valid asplc list. skip");
    }

    private ProviderListener getProviderListener() {
        return new 1(this);
    }

    private void mergeEvents(Map<AerServEvent, List<String>> map, Map<AerServEvent, List<String>> map2) {
        for (AerServEvent aerServEvent : map2.keySet()) {
            if (map.get((Object)aerServEvent) == null) {
                map.put((Object)aerServEvent, map2.get((Object)aerServEvent));
                continue;
            }
            ((List)map.get((Object)aerServEvent)).addAll((Collection)map2.get((Object)aerServEvent));
        }
    }

    private void showAd(RequestType requestType) {
        ProviderAd providerAd;
        if (this.hasFetchPlacementTimedOut) {
            AerServLog.i(this.LOG_TAG, "This ad has timed out");
            AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.AD_FAILED, this.timeoutMessage);
            ProviderAd providerAd2 = this.ad;
            if (providerAd2 != null && providerAd2.getAdType().equals((Object)AdType.THIRD_PARTY)) {
                SDKEventHelper.sendEvent((ThirdPartyProviderAd)this.ad, "36", this.plc, this.rid);
                return;
            }
            Placement placement = this.placement;
            if (placement != null) {
                SDKEventHelper.sendEvent(placement.getSdkBaseEventUrl(), "AerMarket", this.rid, "36", this.plc);
            }
            return;
        }
        if (!this.preload && !(this.ad instanceof ThirdPartyProviderAd)) {
            VerySimpleTimer verySimpleTimer = new VerySimpleTimer(new Runnable(){

                public void run() {
                    AerServEventListenerLocator.fireEvent(AdManager.this.controllerId, AerServEvent.INTERNAL_AD_FAILED_TO_RENDER);
                    AerServEventListenerLocator.fireEvent(AdManager.this.controllerId, AerServEvent.AD_FAILED, "Timed out trying to show ad");
                    AerServLog.w(AdManager.this.LOG_TAG, "step4: time out");
                    if (AdManager.this.ad != null && AdManager.this.ad.getAdType().equals((Object)AdType.THIRD_PARTY)) {
                        SDKEventHelper.sendEvent((ThirdPartyProviderAd)AdManager.this.ad, "36", AdManager.this.plc, AdManager.this.rid);
                        return;
                    }
                    if (AdManager.this.placement != null) {
                        SDKEventHelper.sendEvent(AdManager.this.placement.getSdkBaseEventUrl(), "AerMarket", AdManager.this.rid, "36", AdManager.this.plc);
                        SybokProxy.sendTimeoutLogSybok(AdManager.this.rid, 4, AerServSettings.getStep4ShowAdTimeout(null), AdManager.this.plc);
                    }
                }
            }, AerServSettings.getStep4ShowAdTimeout(null));
            verySimpleTimer.start();
            AerServEventListenerLocator.register(this.controllerId, (AerServEventListener)new 10(this, verySimpleTimer));
        }
        this.adLoaded = true;
        final ProviderListener providerListener = this.getProviderListener();
        if (this.preload && (providerAd = this.ad) != null && !providerAd.getIsShowAdCommandRequiredOnPreload()) {
            ProviderAd providerAd3;
            ProviderAd providerAd4 = this.ad;
            boolean bl = providerAd4 instanceof VASTProviderAd;
            boolean bl2 = false;
            if (bl) {
                VASTProviderAd vASTProviderAd = (VASTProviderAd)providerAd4;
                Vpaid vpaid = vASTProviderAd.getVpaid();
                bl2 = false;
                if (vpaid != null) {
                    bl2 = true;
                }
                if (this.aerServAdType == AerServAdType.BANNER && VASTUtils.mustShowCompanionAds(vASTProviderAd)) {
                    AerServLog.d(this.LOG_TAG, "Required companion ad detected, but banners cannot display them.  Failing over.");
                    providerListener.onProviderFailShow();
                    return;
                }
            }
            if ((providerAd3 = this.ad) != null && providerAd3.getAdType() == AdType.VAST && this.precache && !bl2) {
                AerServLog.d(this.LOG_TAG, "Preloading found a VAST ad so find a media file URL for precaching");
                final String string = VASTUtils.getFirstVideoUrl((VASTProviderAd)this.ad);
                if (this.context.getExternalFilesDir(null) != null && this.context.getExternalFilesDir(null).length() != 0L) {
                    if (string != null) {
                        String string2 = this.LOG_TAG;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("VAST media file URL found, attempt to cache ");
                        stringBuilder.append(string);
                        AerServLog.d(string2, stringBuilder.toString());
                        new Thread(new Runnable(){

                            public void run() {
                                try {
                                    VideoFileCache.cacheVideo(AdManager.this.context, string, AdManager.this.controllerId);
                                    return;
                                }
                                catch (Exception exception) {
                                    AerServLog.d(AdManager.this.LOG_TAG, "Could not cache VAST media file from URL");
                                    providerListener.onProviderFailShow();
                                    return;
                                }
                            }
                        }).start();
                        return;
                    }
                    AerServLog.d(this.LOG_TAG, "Found no VAST media file URL");
                    providerListener.onProviderFailShow();
                    return;
                }
                AerServLog.d(this.LOG_TAG, "Found no media to cache to.");
                return;
            }
            AerServLog.d(this.LOG_TAG, "Preload is still on so fire PRELOAD_READY and return from showAd");
            AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.PRELOAD_READY);
            return;
        }
        if (this.hasBegunShowing) {
            AerServLog.d(this.LOG_TAG, "This ad has already begun to be shown so return from showAd");
            return;
        }
        ProviderAd providerAd5 = this.ad;
        if (providerAd5 != null && !providerAd5.getIsShowAdCommandRequiredOnPreload() && this.preload) {
            this.hasBegunShowing = true;
        }
        if (this.fireShowAttemptEvent && !(this.ad instanceof ThirdPartyProviderAd) && !this.hasShowAttemptEventFired) {
            AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.INTERNAL_SHOW_ATTEMPTED);
            this.hasShowAttemptEventFired = true;
        }
        ShowProviderAdCommand showProviderAdCommand = new ShowProviderAdCommand(this.context, this.ad, providerListener, this.aerServAdType, this.viewId, this.controllerId, this.isDebug, this.preload, Long.valueOf((long)AerServSettings.getStep4ShowAdTimeout(null)), this.isBackButtonEnabled, this.backButtonTimeout, this.plc, requestType, this.rid);
        showProviderAdCommand.execute();
    }

    public void executePlacement(RequestType requestType) {
        this.hasBegunLoading = true;
        this.executeStep1And2(requestType);
        String string = Asplc.getStep3CallInputString(this.asplcQueueForStep3Req, this.unknownAsplcIds, this.rid);
        String string2 = this.LOG_TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("asplcs status for step3: ");
        stringBuilder.append(string);
        AerServLog.d(string2, stringBuilder.toString());
        AerServLog.d(this.LOG_TAG, "step3: start");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        6 var8_6 = new 6(this, countDownLatch);
        PlacementProxy placementProxy = new PlacementProxy();
        Context context = this.context;
        String string3 = this.plc;
        List<String> list = this.keyWords;
        String string4 = this.rid;
        Map<String, String> map = this.pubKeys;
        String string5 = this.userId;
        boolean bl = this.preload;
        boolean bl2 = this.precache;
        String string6 = this.platformId;
        boolean bl3 = this.useHeaderBidding;
        boolean bl4 = requestType == RequestType.BANNER_REFRESH;
        placementProxy.fetchPlacement(context, string3, (FetchPlacementListener)var8_6, list, string4, string3, map, string5, bl, bl2, string6, bl3, bl4, this.viewId, AerServSettings.getStep3Timeout(), TextUtils.isEmpty((CharSequence)this.rid), string);
        try {
            countDownLatch.await((long)AerServSettings.getStep3Timeout(), TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        if (countDownLatch.getCount() > 0L || placementProxy.getStatusCode() == 10001) {
            placementProxy.cancel();
            AerServLog.w(this.LOG_TAG, "step3: server call time out");
            SybokProxy.sendTimeoutLogSybok(this.context, this.rid, 3, AerServSettings.getStep3Timeout(), this.plc);
            AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.AD_FAILED, this.timeoutMessage);
            this.hasFetchPlacementTimedOut = true;
            this.hasFetchPlacementFailed = true;
        }
        if (!this.hasFetchPlacementFailed) {
            MoatUtils.setEnabled(this.controllerId, this.placement.isMoatEnabled());
            MoatUtils.parseAndSetAdIdentifiers(this.controllerId, this.plc, this.placement.getAdMarkup());
            Map<AerServEvent, List<String>> map2 = this.placement.getTrackingEvents();
            this.mergeEvents(map2, this.placement.getMetricsEvents());
            AerServEventListenerLocator.registerEventUrls(this.controllerId, map2);
            this.buildAd();
            return;
        }
        this.cleanup((Activity)this.context);
    }

}

