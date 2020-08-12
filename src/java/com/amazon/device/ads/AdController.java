/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.View$OnKeyListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.WindowManager
 *  android.webkit.WebView
 *  java.lang.Boolean
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.IllegalStateException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.Set
 *  java.util.TimerTask
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.WebView;
import com.amazon.device.ads.AAXCreative;
import com.amazon.device.ads.AdCloser;
import com.amazon.device.ads.AdContainer;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdControlCallback;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdData;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdHtmlPreprocessor;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AdSDKBridgeFactory;
import com.amazon.device.ads.AdSDKBridgeList;
import com.amazon.device.ads.AdSize;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.AdTimer;
import com.amazon.device.ads.AdUrlLoader;
import com.amazon.device.ads.AdUtils2;
import com.amazon.device.ads.AdWebViewClient;
import com.amazon.device.ads.AdWebViewClientFactory;
import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.BridgeSelector;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.Destroyable;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.PermissionChecker;
import com.amazon.device.ads.Position;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.RelativePosition;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.SDKEventListener;
import com.amazon.device.ads.Size;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.ViewUtils;
import com.amazon.device.ads.ViewabilityObserver;
import com.amazon.device.ads.ViewabilityObserverFactory;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebUtils2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

class AdController
implements Metrics.MetricsSubmitter {
    private static final String LOGTAG = "AdController";
    protected static final String MSG_PREPARE_AD_LOADING = "An ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.";
    protected static final String MSG_PREPARE_AD_READY_TO_SHOW = "An ad is ready to show. Please call showAd() to show the ad before loading another ad.";
    protected static final String MSG_PREPARE_AD_SHOWING = "An ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.";
    protected static final String MSG_SHOW_AD_ANOTHER_SHOWING = "Another ad is currently showing. Please wait for the AdListener.onAdDismissed callback of the other ad.";
    protected static final String MSG_SHOW_AD_DESTROYED = "The ad cannot be shown because it has been destroyed. Create a new Ad object to load a new ad.";
    protected static final String MSG_SHOW_AD_DISMISSED = "The ad cannot be shown because it has already been displayed to the user. Please call loadAd(AdTargetingOptions) to load a new ad.";
    protected static final String MSG_SHOW_AD_EXPIRED = "This ad has expired. Please load another ad.";
    protected static final String MSG_SHOW_AD_LOADING = "The ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad.";
    protected static final String MSG_SHOW_AD_READY_TO_LOAD = "The ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first.";
    protected static final String MSG_SHOW_AD_SHOWING = "The ad cannot be shown because it is already displayed on the screen. Please wait for the AdListener.onAdDismissed() callback and then load a new ad.";
    private Activity adActivity;
    private final AdCloser adCloser;
    private AdContainer adContainer;
    private final AdContainer.AdContainerFactory adContainerFactory;
    private AdControlAccessor adControlAccessor;
    private AdControlCallback adControlCallback;
    private AdData adData;
    private final AdHtmlPreprocessor adHtmlPreprocessor;
    private final AdSDKBridgeList adSdkBridgeList;
    private final AdSize adSize;
    private AdState adState;
    private final AdTimer adTimer;
    private final AdUrlLoader adUrlLoader;
    private final AdUtils2 adUtils;
    private int adWindowHeight;
    private int adWindowWidth;
    private final AndroidBuildInfo androidBuildInfo;
    private boolean backButtonOverridden;
    private final BridgeSelector bridgeSelector;
    private final Configuration configuration;
    private ConnectionInfo connectionInfo;
    private final Context context;
    private final DebugProperties debugProperties;
    private ViewGroup defaultParent;
    private boolean disableHardwareAccelerationRequest;
    private boolean forceDisableHardwareAcceleration;
    private final AtomicBoolean hasFinishedLoading;
    private final MobileAdsInfoStore infoStore;
    private boolean isModallyExpanded;
    private boolean isPrepared;
    private final AtomicBoolean isRendering;
    private final MobileAdsLogger logger;
    private MetricsCollector metricsCollector;
    private boolean orientationFailureMetricRecorded;
    private final PermissionChecker permissionChecker;
    private double scalingMultiplier;
    private final ArrayList<SDKEventListener> sdkEventListeners;
    private String slotID;
    private int timeout;
    private final ViewUtils viewUtils;
    private final ViewabilityObserver viewabilityObserver;
    protected final WebUtils2 webUtils;
    private boolean windowDimensionsSet;

    public AdController(Context context, AdSize adSize) {
        this(context, adSize, new WebUtils2(), new MetricsCollector(), new MobileAdsLoggerFactory(), new AdUtils2(), new Object(){

            public AdContainer createAdContainer(Context context, AdCloser adCloser) {
                return new AdContainer(context, adCloser);
            }
        }, MobileAdsInfoStore.getInstance(), new PermissionChecker(), new AndroidBuildInfo(), BridgeSelector.getInstance(), new AdSDKBridgeList(), ThreadUtils.getThreadRunner(), new WebRequest.WebRequestFactory(), null, null, null, new AdTimer(), DebugProperties.getInstance(), new ViewabilityObserverFactory(), new ViewUtils(), Configuration.getInstance());
    }

    AdController(Context context, AdSize adSize, ViewabilityObserverFactory viewabilityObserverFactory) {
        this(context, adSize, new WebUtils2(), new MetricsCollector(), new MobileAdsLoggerFactory(), new AdUtils2(), new /* invalid duplicate definition of identical inner class */, MobileAdsInfoStore.getInstance(), new PermissionChecker(), new AndroidBuildInfo(), BridgeSelector.getInstance(), new AdSDKBridgeList(), ThreadUtils.getThreadRunner(), new WebRequest.WebRequestFactory(), null, null, null, new AdTimer(), DebugProperties.getInstance(), viewabilityObserverFactory, new ViewUtils(), Configuration.getInstance());
    }

    AdController(Context context, AdSize adSize, WebUtils2 webUtils2, MetricsCollector metricsCollector, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdUtils2 adUtils2, AdContainer.AdContainerFactory adContainerFactory, MobileAdsInfoStore mobileAdsInfoStore, PermissionChecker permissionChecker, AndroidBuildInfo androidBuildInfo, BridgeSelector bridgeSelector, AdSDKBridgeList adSDKBridgeList, ThreadUtils.ThreadRunner threadRunner, AdWebViewClientFactory adWebViewClientFactory, WebRequest.WebRequestFactory webRequestFactory, AdHtmlPreprocessor adHtmlPreprocessor, AdUrlLoader adUrlLoader, AdCloser adCloser, AdTimer adTimer, DebugProperties debugProperties, ViewabilityObserverFactory viewabilityObserverFactory, ViewUtils viewUtils, Configuration configuration) {
        AdHtmlPreprocessor adHtmlPreprocessor2;
        this.timeout = 20000;
        this.sdkEventListeners = new ArrayList();
        this.adWindowHeight = 0;
        this.adWindowWidth = 0;
        this.windowDimensionsSet = false;
        this.adState = AdState.READY_TO_LOAD;
        this.scalingMultiplier = 1.0;
        this.isPrepared = false;
        this.defaultParent = null;
        this.isRendering = new AtomicBoolean(false);
        this.hasFinishedLoading = new AtomicBoolean(false);
        this.disableHardwareAccelerationRequest = false;
        this.forceDisableHardwareAcceleration = false;
        this.backButtonOverridden = false;
        this.isModallyExpanded = false;
        this.orientationFailureMetricRecorded = false;
        this.context = context;
        this.adSize = adSize;
        this.webUtils = webUtils2;
        this.metricsCollector = metricsCollector;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.adUtils = adUtils2;
        this.adContainerFactory = adContainerFactory;
        this.infoStore = mobileAdsInfoStore;
        this.permissionChecker = permissionChecker;
        this.androidBuildInfo = androidBuildInfo;
        this.bridgeSelector = bridgeSelector;
        this.adTimer = adTimer;
        this.debugProperties = debugProperties;
        this.adSdkBridgeList = adSDKBridgeList;
        this.viewUtils = viewUtils;
        this.adHtmlPreprocessor = adHtmlPreprocessor != null ? adHtmlPreprocessor : (adHtmlPreprocessor2 = new AdHtmlPreprocessor(bridgeSelector, this.adSdkBridgeList, this.getAdControlAccessor(), mobileAdsLoggerFactory, adUtils2));
        if (adUrlLoader != null) {
            this.adUrlLoader = adUrlLoader;
        } else {
            AdUrlLoader adUrlLoader2;
            AdWebViewClient adWebViewClient = adWebViewClientFactory.createAdWebViewClient(context, this.adSdkBridgeList, this.getAdControlAccessor());
            this.adUrlLoader = adUrlLoader2 = new AdUrlLoader(threadRunner, adWebViewClient, webRequestFactory, this.getAdControlAccessor(), webUtils2, mobileAdsLoggerFactory, mobileAdsInfoStore.getDeviceInfo());
        }
        this.adUrlLoader.setAdWebViewClientListener(new AdControllerAdWebViewClientListener());
        this.adCloser = adCloser != null ? adCloser : new AdCloser(this);
        this.viewabilityObserver = viewabilityObserverFactory.buildViewabilityObserver(this);
        this.configuration = configuration;
    }

    AdController(Context context, AdSize adSize, WebUtils2 webUtils2, MetricsCollector metricsCollector, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdUtils2 adUtils2, AdContainer.AdContainerFactory adContainerFactory, MobileAdsInfoStore mobileAdsInfoStore, PermissionChecker permissionChecker, AndroidBuildInfo androidBuildInfo, BridgeSelector bridgeSelector, AdSDKBridgeList adSDKBridgeList, ThreadUtils.ThreadRunner threadRunner, WebRequest.WebRequestFactory webRequestFactory, AdHtmlPreprocessor adHtmlPreprocessor, AdUrlLoader adUrlLoader, AdCloser adCloser, AdTimer adTimer, DebugProperties debugProperties, ViewabilityObserverFactory viewabilityObserverFactory, ViewUtils viewUtils, Configuration configuration) {
        AdWebViewClientFactory adWebViewClientFactory = new AdWebViewClientFactory(webUtils2, mobileAdsLoggerFactory, androidBuildInfo);
        this(context, adSize, webUtils2, metricsCollector, mobileAdsLoggerFactory, adUtils2, adContainerFactory, mobileAdsInfoStore, permissionChecker, androidBuildInfo, bridgeSelector, adSDKBridgeList, threadRunner, adWebViewClientFactory, webRequestFactory, adHtmlPreprocessor, adUrlLoader, adCloser, adTimer, debugProperties, viewabilityObserverFactory, viewUtils, configuration);
    }

    static /* synthetic */ void access$100(AdController adController) {
        adController.onAdExpired();
    }

    private void adFailedAfterTimerCheck(AdError adError) {
        if (this.getMetricsCollector() != null && !this.getMetricsCollector().isMetricsCollectorEmpty()) {
            this.adFailedAfterAdMetricsStart(adError);
            return;
        }
        this.adFailedBeforeAdMetricsStart(adError);
    }

    private void adLoaded() {
        if (!this.canBeUsed()) {
            return;
        }
        this.setAdState(AdState.LOADED);
        this.callOnAdLoaded(this.adData.getProperties());
    }

    private void addAdSDKBridge(AdSDKBridge adSDKBridge) {
        this.adSdkBridgeList.addBridge(adSDKBridge);
    }

    private void calculateScalingMultiplier() {
        if (!this.isInterstitial()) {
            float f2 = this.infoStore.getDeviceInfo().getScalingFactorAsFloat();
            int n2 = (int)(f2 * (float)this.adData.getWidth());
            int n3 = (int)(f2 * (float)this.adData.getHeight());
            this.scalingMultiplier = this.adUtils.calculateScalingMultiplier(n2, n3, this.getWindowWidth(), this.getWindowHeight());
            int n4 = this.getAdSize().getMaxWidth();
            if (n4 > 0) {
                double d2 = this.adData.getWidth();
                double d3 = this.scalingMultiplier;
                Double.isNaN((double)d2);
                double d4 = d2 * d3;
                double d5 = n4;
                if (d4 > d5) {
                    double d6 = this.adData.getWidth();
                    Double.isNaN((double)d5);
                    Double.isNaN((double)d6);
                    this.scalingMultiplier = d5 / d6;
                }
            }
            if (!this.getAdSize().canUpscale() && this.scalingMultiplier > 1.0) {
                this.scalingMultiplier = 1.0;
            }
            this.setViewDimensionsToAdDimensions();
            return;
        }
        this.scalingMultiplier = -1.0;
    }

    private void callOnAdExpired() {
        ThreadUtils.scheduleOnMainThread(new Runnable(this){
            final /* synthetic */ AdController this$0;
            {
                this.this$0 = adController;
            }

            public void run() {
                this.this$0.getAdControlCallback().onAdExpired();
                this.this$0.submitAndResetMetricsIfNecessary(true);
            }
        });
    }

    private boolean canExpireOrDraw(AdState adState) {
        AdController adController = this;
        synchronized (adController) {
            if (AdState.RENDERED.compareTo((Enum)this.getAdState()) >= 0) {
                this.setAdState(adState);
                return true;
            }
            return false;
        }
    }

    private boolean canFireImpressionPixel() {
        return true ^ this.getAdState().equals((Object)AdState.HIDDEN);
    }

    private void determineShouldForceDisableHardwareAcceleration() {
        if ((AndroidTargetUtils.isAndroidAPI(this.androidBuildInfo, 14) || AndroidTargetUtils.isAndroidAPI(this.androidBuildInfo, 15)) && this.adData.getCreativeTypes().contains((Object)AAXCreative.REQUIRES_TRANSPARENCY)) {
            this.forceDisableHardwareAcceleration = true;
            return;
        }
        this.forceDisableHardwareAcceleration = false;
    }

    private boolean isReadyToLoad(boolean bl) {
        return this.getAdControlCallback().isAdReady(bl);
    }

    private void onAdExpired() {
        if (AdState.RENDERED.compareTo((Enum)this.getAdState()) >= 0 && this.canExpireOrDraw(AdState.INVALID)) {
            this.logger.d("Ad Has Expired");
            this.callOnAdExpired();
        }
    }

    private void reset() {
        if (!this.canBeUsed()) {
            return;
        }
        this.isPrepared = false;
        this.adTimer.cancelTimer();
        this.resetMetricsCollector();
        this.orientationFailureMetricRecorded = false;
        AdContainer adContainer = this.adContainer;
        if (adContainer != null) {
            adContainer.destroy();
            this.adSdkBridgeList.clear();
            this.adContainer = null;
        }
        this.adData = null;
    }

    private boolean shouldDisableHardwareAcceleration() {
        return this.forceDisableHardwareAcceleration || this.disableHardwareAccelerationRequest;
        {
        }
    }

    private void startExpirationTimer() {
        long l2 = this.getAdData().getTimeToExpire();
        if (l2 > 0L) {
            this.adTimer.restartTimer();
            this.adTimer.scheduleTask(new TimerTask(this){
                final /* synthetic */ AdController this$0;
                {
                    this.this$0 = adController;
                }

                public void run() {
                    AdController.access$100(this.this$0);
                }
            }, l2);
        }
    }

    void accumulateAdFailureMetrics(AdError adError) {
        long l2 = System.nanoTime();
        this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l2);
        this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE, l2);
        this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_FAILURE, l2);
        if (adError != null) {
            this.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED);
            int n2 = 11.$SwitchMap$com$amazon$device$ads$AdError$ErrorCode[adError.getCode().ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 == 3) {
                        this.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED_INTERNAL_ERROR);
                    }
                } else {
                    this.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED_NETWORK_TIMEOUT);
                    if (this.isRendering.get()) {
                        this.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT);
                    } else {
                        this.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT);
                    }
                }
            } else {
                this.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_LOAD_FAILED_NO_FILL);
            }
        }
        this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER_FAILED, l2);
        if (this.getAdState().equals((Object)AdState.RENDERING)) {
            this.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_COUNTER_RENDERING_FATAL);
        }
        this.setAdditionalMetrics();
    }

    public void adFailed(AdError adError) {
        if (!this.canBeUsed()) {
            return;
        }
        if (!this.getAndSetHasFinishedLoading(true)) {
            this.adTimer.cancelTimer();
            this.adFailedAfterTimerCheck(adError);
            this.setAdState(AdState.READY_TO_LOAD);
        }
    }

    void adFailedAfterAdMetricsStart(AdError adError) {
        this.accumulateAdFailureMetrics(adError);
        this.callOnAdFailedToLoad(adError, true);
    }

    void adFailedBeforeAdMetricsStart(AdError adError) {
        this.callOnAdFailedToLoad(adError, false);
    }

    public void adHidden() {
        this.setAdState(AdState.HIDDEN);
        this.fireSDKEvent(new SDKEvent(SDKEvent.SDKEventType.HIDDEN));
    }

    public void adRendered(String string) {
        if (!this.canBeUsed()) {
            return;
        }
        this.logger.d("Ad Rendered");
        if (this.getAdState().equals((Object)AdState.RENDERING)) {
            if (!this.getAndSetHasFinishedLoading(true)) {
                this.isRendering.set(false);
                this.adTimer.cancelTimer();
                this.startExpirationTimer();
                this.setAdState(AdState.RENDERED);
                this.callOnAdRendered();
                long l2 = System.nanoTime();
                if (this.getMetricsCollector() != null) {
                    this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER, l2);
                    this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l2);
                    this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_SUCCESS, l2);
                    this.setAdditionalMetrics();
                    this.submitAndResetMetricsIfNecessary(true);
                }
                this.callPostAdRendered();
            }
        } else {
            MobileAdsLogger mobileAdsLogger = this.logger;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Ad State was not Rendering. It was ");
            stringBuilder.append((Object)this.getAdState());
            mobileAdsLogger.d(stringBuilder.toString());
        }
        this.fireSDKEvent(new SDKEvent(SDKEvent.SDKEventType.RENDERED).setParameter("url", string));
    }

    public void adShown() {
        if (!this.canBeUsed()) {
            return;
        }
        this.getMetricsCollector().stopMetric(Metrics.MetricType.AD_SHOW_LATENCY);
        this.adTimer.cancelTimer();
        if (this.canFireImpressionPixel()) {
            this.webUtils.executeWebRequestInThread(this.getAdData().getImpressionPixelUrl(), false);
        }
        this.setAdState(AdState.SHOWING);
        if (!this.areWindowDimensionsSet()) {
            this.setWindowDimensions(this.getView().getWidth(), this.getView().getHeight());
        }
        this.fireSDKEvent(new SDKEvent(SDKEvent.SDKEventType.VISIBLE));
        this.viewabilityObserver.fireViewableEvent(false);
    }

    void addJavascriptInterface(Object object, boolean bl, String string) {
        this.getAdContainer().addJavascriptInterface(object, bl, string);
    }

    public void addOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        this.adContainer.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public void addSDKEventListener(SDKEventListener sDKEventListener) {
        this.logger.d("Add SDKEventListener %s", sDKEventListener);
        this.sdkEventListeners.add((Object)sDKEventListener);
    }

    public boolean areWindowDimensionsSet() {
        return this.windowDimensionsSet;
    }

    void callOnAdEvent(AdEvent adEvent) {
        ThreadUtils.scheduleOnMainThread(new Runnable(this, adEvent){
            final /* synthetic */ AdController this$0;
            final /* synthetic */ AdEvent val$adEvent;
            {
                this.this$0 = adController;
                this.val$adEvent = adEvent;
            }

            public void run() {
                if (!this.this$0.canBeUsed()) {
                    return;
                }
                this.this$0.getAdControlCallback().onAdEvent(this.val$adEvent);
            }
        });
    }

    void callOnAdFailedToLoad(AdError adError, boolean bl) {
        ThreadUtils.scheduleOnMainThread(new Runnable(this, adError, bl){
            final /* synthetic */ AdController this$0;
            final /* synthetic */ AdError val$error;
            final /* synthetic */ boolean val$shouldSubmitMetrics;
            {
                this.this$0 = adController;
                this.val$error = adError;
                this.val$shouldSubmitMetrics = bl;
            }

            public void run() {
                this.this$0.getAdControlCallback().onAdFailed(this.val$error);
                this.this$0.submitAndResetMetricsIfNecessary(this.val$shouldSubmitMetrics);
            }
        });
    }

    void callOnAdLoaded(AdProperties adProperties) {
        ThreadUtils.scheduleOnMainThread(new Runnable(this, adProperties){
            final /* synthetic */ AdController this$0;
            final /* synthetic */ AdProperties val$adProperties;
            {
                this.this$0 = adController;
                this.val$adProperties = adProperties;
            }

            public void run() {
                if (!this.this$0.canBeUsed()) {
                    return;
                }
                this.this$0.getAdControlCallback().onAdLoaded(this.val$adProperties);
            }
        });
    }

    void callOnAdRendered() {
        ThreadUtils.scheduleOnMainThread(new Runnable(this){
            final /* synthetic */ AdController this$0;
            {
                this.this$0 = adController;
            }

            public void run() {
                if (!this.this$0.canBeUsed()) {
                    return;
                }
                this.this$0.getAdControlCallback().onAdRendered();
            }
        });
    }

    void callPostAdRendered() {
        ThreadUtils.scheduleOnMainThread(new Runnable(this){
            final /* synthetic */ AdController this$0;
            {
                this.this$0 = adController;
            }

            public void run() {
                if (!this.this$0.canBeUsed()) {
                    return;
                }
                this.this$0.getAdControlCallback().postAdRendered();
            }
        });
    }

    public boolean canBeUsed() {
        return !AdState.DESTROYED.equals((Object)this.getAdState()) && !AdState.INVALID.equals((Object)this.getAdState());
    }

    public boolean canShowViews() {
        return this.getAdContainer().canShowViews();
    }

    public void captureBackButton() {
        this.getAdContainer().listenForKey(new View.OnKeyListener(this){
            final /* synthetic */ AdController this$0;
            {
                this.this$0 = adController;
            }

            public boolean onKey(View view, int n2, android.view.KeyEvent keyEvent) {
                if (n2 == 4 && keyEvent.getRepeatCount() == 0) {
                    this.this$0.onBackButtonPress();
                    return true;
                }
                return false;
            }
        });
    }

    boolean checkDefinedActivities() {
        return this.adUtils.checkDefinedActivities(this.getContext().getApplicationContext());
    }

    public void clearSDKEventListeners() {
        this.sdkEventListeners.clear();
    }

    public boolean closeAd() {
        return this.adCloser.closeAd();
    }

    AdContainer createAdContainer() {
        return this.adContainerFactory.createAdContainer(this.context, this.adCloser);
    }

    public void deregisterViewabilityInterest() {
        this.viewabilityObserver.deregisterViewabilityInterest();
    }

    public void destroy() {
        if (!this.canBeUsed()) {
            this.logger.e("The ad cannot be destroyed because it has already been destroyed.");
            return;
        }
        this.closeAd();
        this.adState = AdState.DESTROYED;
        if (this.adContainer != null) {
            this.getAdContainer().destroy();
            this.adSdkBridgeList.clear();
            this.adContainer = null;
        }
        this.isPrepared = false;
        this.metricsCollector = null;
        this.adData = null;
    }

    public void enableNativeCloseButton(boolean bl, RelativePosition relativePosition) {
        this.getAdContainer().enableNativeCloseButton(bl, relativePosition);
    }

    public void fireAdEvent(AdEvent adEvent) {
        MobileAdsLogger mobileAdsLogger = this.logger;
        Object[] arrobject = new Object[]{adEvent.getAdEventType()};
        mobileAdsLogger.d("Firing AdEvent of type %s", arrobject);
        this.callOnAdEvent(adEvent);
    }

    public void fireSDKEvent(SDKEvent sDKEvent) {
        MobileAdsLogger mobileAdsLogger = this.logger;
        Object[] arrobject = new Object[]{sDKEvent.getEventType()};
        mobileAdsLogger.d("Firing SDK Event of type %s", arrobject);
        Iterator iterator = this.sdkEventListeners.iterator();
        while (iterator.hasNext()) {
            ((SDKEventListener)iterator.next()).onSDKEvent(sDKEvent, this.getAdControlAccessor());
        }
    }

    public void fireViewableEvent() {
        this.viewabilityObserver.fireViewableEvent(false);
    }

    protected Activity getAdActivity() {
        return this.adActivity;
    }

    AdContainer getAdContainer() {
        if (this.adContainer == null) {
            this.adContainer = this.createAdContainer();
            this.adContainer.disableHardwareAcceleration(this.shouldDisableHardwareAcceleration());
            this.adContainer.setAdWebViewClient(this.adUrlLoader.getAdWebViewClient());
        }
        return this.adContainer;
    }

    public AdControlAccessor getAdControlAccessor() {
        if (this.adControlAccessor == null) {
            this.adControlAccessor = new AdControlAccessor(this);
        }
        return this.adControlAccessor;
    }

    AdControlCallback getAdControlCallback() {
        if (this.adControlCallback == null) {
            this.adControlCallback = new DefaultAdControlCallback();
        }
        return this.adControlCallback;
    }

    public AdData getAdData() {
        return this.adData;
    }

    Position getAdPosition() {
        int n2 = this.getViewWidth();
        int n3 = this.getViewHeight();
        if (n2 == 0 && n3 == 0) {
            n2 = this.getWindowWidth();
            n3 = this.getWindowHeight();
        }
        int n4 = this.adUtils.pixelToDeviceIndependentPixel(n2);
        int n5 = this.adUtils.pixelToDeviceIndependentPixel(n3);
        int[] arrn = new int[2];
        this.getAdContainer().getViewLocationOnScreen(arrn);
        View view = this.getRootView();
        if (view == null) {
            this.logger.w("Could not find the activity's root view while determining ad position.");
            return null;
        }
        int[] arrn2 = new int[2];
        view.getLocationOnScreen(arrn2);
        int n6 = this.adUtils.pixelToDeviceIndependentPixel(arrn[0]);
        int n7 = this.adUtils.pixelToDeviceIndependentPixel(arrn[1] - arrn2[1]);
        return new Position(new Size(n4, n5), n6, n7);
    }

    public AdSize getAdSize() {
        return this.adSize;
    }

    public AdState getAdState() {
        return this.adState;
    }

    public boolean getAndResetIsPrepared() {
        boolean bl = this.isPrepared;
        this.isPrepared = false;
        return bl;
    }

    boolean getAndSetHasFinishedLoading(boolean bl) {
        return this.hasFinishedLoading.getAndSet(bl);
    }

    public ConnectionInfo getConnectionInfo() {
        return this.connectionInfo;
    }

    protected Context getContext() {
        Activity activity = this.adActivity;
        if (activity == null) {
            activity = this.context;
        }
        return activity;
    }

    public Destroyable getDestroyable() {
        return this.getAdContainer();
    }

    @Override
    public String getInstrumentationPixelUrl() {
        AdData adData = this.adData;
        if (adData != null) {
            return adData.getInstrumentationPixelUrl();
        }
        return null;
    }

    public Size getMaxExpandableSize() {
        View view = this.getRootView();
        if (view == null) {
            this.logger.w("Could not find the activity's root view while determining max expandable size.");
            return null;
        }
        int n2 = view.getWidth();
        int n3 = view.getHeight();
        return new Size(this.adUtils.pixelToDeviceIndependentPixel(n2), this.adUtils.pixelToDeviceIndependentPixel(n3));
    }

    public String getMaxSize() {
        if (!this.getAdSize().isAuto()) {
            return null;
        }
        return AdSize.getAsSizeString(this.getWindowWidth(), this.getWindowHeight());
    }

    void getMetrics(DisplayMetrics displayMetrics) {
        ((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
    }

    @Override
    public MetricsCollector getMetricsCollector() {
        return this.metricsCollector;
    }

    public View getRootView() {
        return this.getAdContainer().getRootView().findViewById(16908290);
    }

    public double getScalingMultiplier() {
        return this.scalingMultiplier;
    }

    public String getScalingMultiplierDescription() {
        if (this.getScalingMultiplier() > 1.0) {
            return "u";
        }
        if (this.getScalingMultiplier() < 1.0 && this.getScalingMultiplier() > 0.0) {
            return "d";
        }
        return "n";
    }

    Size getScreenSize() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.getMetrics(displayMetrics);
        int n2 = displayMetrics.widthPixels;
        int n3 = displayMetrics.heightPixels;
        return new Size(this.adUtils.pixelToDeviceIndependentPixel(n2), this.adUtils.pixelToDeviceIndependentPixel(n3));
    }

    public String getSlotID() {
        return this.slotID;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public View getView() {
        return this.getAdContainer();
    }

    public int getViewHeight() {
        return this.getAdContainer().getViewHeight();
    }

    ViewGroup getViewParent() {
        return (ViewGroup)this.getView().getParent();
    }

    ViewGroup getViewParentIfExpanded() {
        ViewGroup viewGroup = this.defaultParent;
        if (viewGroup != null && viewGroup != this.getView().getParent()) {
            return this.getViewParent();
        }
        return null;
    }

    public int getViewWidth() {
        return this.getAdContainer().getViewWidth();
    }

    public int getWindowHeight() {
        return this.adWindowHeight;
    }

    public int getWindowWidth() {
        return this.adWindowWidth;
    }

    public void initialize(String string) {
        if (!this.canBeUsed()) {
            return;
        }
        this.determineShouldForceDisableHardwareAcceleration();
        if (!this.initializeAdContainer()) {
            return;
        }
        this.calculateScalingMultiplier();
        for (AAXCreative aAXCreative : this.adData) {
            Set<AdSDKBridgeFactory> set = this.bridgeSelector.getBridgeFactories(aAXCreative);
            if (set == null) continue;
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                this.addAdSDKBridge(((AdSDKBridgeFactory)iterator.next()).createAdSDKBridge(this.getAdControlAccessor()));
            }
        }
        this.slotID = string;
        this.adLoaded();
    }

    boolean initializeAdContainer() {
        try {
            this.getAdContainer().initialize();
            return true;
        }
        catch (IllegalStateException illegalStateException) {
            this.adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "An unknown error occurred when attempting to create the web view."));
            this.setAdState(AdState.INVALID);
            this.logger.e("An unknown error occurred when attempting to create the web view.");
            return false;
        }
    }

    public void injectJavascript(String string, boolean bl) {
        ThreadUtils.executeOnMainThread(new Runnable(this, string, bl){
            final /* synthetic */ AdController this$0;
            final /* synthetic */ String val$javascript;
            final /* synthetic */ boolean val$preload;
            {
                this.this$0 = adController;
                this.val$javascript = string;
                this.val$preload = bl;
            }

            public void run() {
                this.this$0.getAdContainer().injectJavascript(this.val$javascript, this.val$preload);
            }
        });
    }

    public boolean isExpired() {
        AdData adData = this.adData;
        return adData != null && adData.isExpired();
    }

    boolean isInterstitial() {
        return AdSize.SizeType.INTERSTITIAL.equals((Object)this.adSize.getSizeType());
    }

    public boolean isModal() {
        return this.getAdSize().isModal() || AdState.EXPANDED.equals((Object)this.getAdState()) && this.isModallyExpanded;
        {
        }
    }

    public boolean isValid() {
        return true ^ this.getAdState().equals((Object)AdState.INVALID);
    }

    boolean isValidAppKey() {
        return this.infoStore.getRegistrationInfo().getAppKey() != null;
    }

    public boolean isViewable() {
        return this.viewabilityObserver.isViewable();
    }

    public boolean isVisible() {
        return AdState.SHOWING.equals((Object)this.getAdState()) || AdState.EXPANDED.equals((Object)this.getAdState());
        {
        }
    }

    public void loadHtml(String string, String string2) {
        this.loadHtml(string, string2, false, null);
    }

    public void loadHtml(String string, String string2, boolean bl, PreloadCallback preloadCallback) {
        this.getAdContainer().removePreviousInterfaces();
        this.clearSDKEventListeners();
        String string3 = this.adHtmlPreprocessor.preprocessHtml(string2, bl);
        this.getAdContainer().loadHtml(string, string3, bl, preloadCallback);
    }

    public void loadUrl(String string) {
        this.adUrlLoader.loadUrl(string, false, null);
    }

    public void moveViewBackToParent(ViewGroup.LayoutParams layoutParams) {
        ViewGroup viewGroup = (ViewGroup)this.getView().getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this.getView());
        }
        this.setViewDimensionsToAdDimensions();
        ViewGroup viewGroup2 = this.defaultParent;
        if (viewGroup2 != null) {
            viewGroup2.addView(this.getView(), layoutParams);
        }
        this.getAdContainer().listenForKey(null);
        this.setExpanded(false);
    }

    public void moveViewToViewGroup(ViewGroup viewGroup, ViewGroup.LayoutParams layoutParams, boolean bl) {
        ViewGroup viewGroup2 = this.getViewParent();
        if (this.defaultParent == null) {
            this.defaultParent = viewGroup2;
        }
        if (viewGroup2 != null) {
            viewGroup2.removeView(this.getView());
        }
        this.setViewDimensionsToMatchParent();
        viewGroup.addView(this.getView(), layoutParams);
        this.isModallyExpanded = bl;
        this.setExpanded(true);
        if (this.isModallyExpanded) {
            this.captureBackButton();
        }
    }

    void onAdTimedOut() {
        if (this.debugProperties.getDebugPropertyAsBoolean("debug.canTimeout", true).booleanValue() && !this.getAndSetHasFinishedLoading(true)) {
            this.adFailedAfterTimerCheck(new AdError(AdError.ErrorCode.NETWORK_TIMEOUT, "Ad Load Timed Out"));
            this.setAdState(AdState.INVALID);
        }
    }

    boolean onBackButtonPress() {
        if (this.backButtonOverridden) {
            this.fireSDKEvent(new SDKEvent(SDKEvent.SDKEventType.BACK_BUTTON_PRESSED));
            return true;
        }
        this.closeAd();
        return false;
    }

    public void onRequestError(String string) {
        this.logger.e(string);
        this.adFailed(new AdError(AdError.ErrorCode.REQUEST_ERROR, string));
    }

    public void openUrl(String string) {
        this.adUrlLoader.openUrl(string);
    }

    public void orientationChangeAttemptedWhenNotAllowed() {
        if (!this.orientationFailureMetricRecorded) {
            this.orientationFailureMetricRecorded = true;
            this.getMetricsCollector().incrementMetric(Metrics.MetricType.SET_ORIENTATION_FAILURE);
        }
    }

    public void overrideBackButton(boolean bl) {
        this.backButtonOverridden = bl;
    }

    protected boolean passesInternetPermissionCheck(Context context) {
        return this.permissionChecker.hasInternetPermission(context);
    }

    public boolean popView() {
        return this.getAdContainer().popView();
    }

    public void preloadHtml(String string, String string2, PreloadCallback preloadCallback) {
        this.loadHtml(string, string2, true, preloadCallback);
    }

    public void preloadUrl(String string, PreloadCallback preloadCallback) {
        this.adUrlLoader.loadUrl(string, true, preloadCallback);
    }

    public boolean prepareForAdLoad(long l2, boolean bl) {
        block8 : {
            boolean bl2;
            block11 : {
                block12 : {
                    block9 : {
                        block10 : {
                            if (!this.canBeUsed()) {
                                this.onRequestError("An ad could not be loaded because the view has been destroyed or was not created properly.");
                                return false;
                            }
                            if (!this.checkDefinedActivities()) {
                                this.onRequestError("Ads cannot load unless \"com.amazon.device.ads.AdActivity\" is correctly declared as an activity in AndroidManifest.xml. Consult the online documentation for more info.");
                                return false;
                            }
                            if (!this.passesInternetPermissionCheck(this.context)) {
                                this.onRequestError("Ads cannot load because the INTERNET permission is missing from the app's manifest.");
                                return false;
                            }
                            if (!this.isValidAppKey()) {
                                this.onRequestError("Can't load an ad because Application Key has not been set. Did you forget to call AdRegistration.setAppKey( ... )?");
                                return false;
                            }
                            if (!this.getAdContainer().canShowViews()) {
                                Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_FAILED_UNKNOWN_WEBVIEW_ISSUE);
                                this.onRequestError("We will be unable to create a WebView for rendering an ad due to an unknown issue with the WebView.");
                                return false;
                            }
                            if (this.isReadyToLoad(bl)) break block8;
                            if (!this.getAdState().equals((Object)AdState.RENDERED)) break block9;
                            if (!this.isExpired()) break block10;
                            bl2 = false;
                            break block11;
                        }
                        this.logger.e(MSG_PREPARE_AD_READY_TO_SHOW);
                        break block12;
                    }
                    if (this.getAdState().equals((Object)AdState.EXPANDED)) {
                        this.logger.e("An ad could not be loaded because another ad is currently expanded.");
                    } else {
                        this.logger.e(MSG_PREPARE_AD_LOADING);
                    }
                }
                bl2 = true;
            }
            if (bl2) {
                return false;
            }
        }
        this.reset();
        this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL, l2);
        this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_FAILURE, l2);
        this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_TOTAL_SUCCESS, l2);
        this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START, l2);
        this.setAdState(AdState.LOADING);
        this.isRendering.set(false);
        this.setHasFinishedLoading(false);
        this.adTimer.restartTimer();
        this.adTimer.scheduleTask(new TimerTask(this){
            final /* synthetic */ AdController this$0;
            {
                this.this$0 = adController;
            }

            public void run() {
                this.this$0.onAdTimedOut();
            }
        }, this.getTimeout());
        this.infoStore.getDeviceInfo().populateUserAgentString(this.context);
        this.isPrepared = true;
        return true;
    }

    void putUrlExecutorInAdWebViewClient(String string, AdWebViewClient.UrlExecutor urlExecutor) {
        this.adUrlLoader.putUrlExecutorInAdWebViewClient(string, urlExecutor);
    }

    public void registerViewabilityInterest() {
        this.viewabilityObserver.registerViewabilityInterest();
    }

    void reload() {
        this.getAdContainer().reload();
    }

    public void removeNativeCloseButton() {
        this.getAdContainer().removeNativeCloseButton();
    }

    public void removeOnGlobalLayoutListener(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        AdContainer adContainer = this.adContainer;
        if (adContainer == null) {
            return;
        }
        this.viewUtils.removeOnGlobalLayoutListener(adContainer.getViewTreeObserver(), onGlobalLayoutListener);
    }

    public void render() {
        if (!this.canBeUsed()) {
            return;
        }
        this.setAdState(AdState.RENDERING);
        long l2 = System.nanoTime();
        this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START, l2);
        this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LATENCY_RENDER, l2);
        this.isRendering.set(true);
        String string = this.adData.getCreative();
        this.loadHtml(this.configuration.getStringWithDefault(Configuration.ConfigOption.BASE_URL, "http://mads.amazon-adsystem.com/"), string);
    }

    public void requestDisableHardwareAcceleration(boolean bl) {
        this.disableHardwareAccelerationRequest = bl;
        AdContainer adContainer = this.adContainer;
        if (adContainer != null) {
            adContainer.disableHardwareAcceleration(this.shouldDisableHardwareAcceleration());
        }
    }

    @Override
    public void resetMetricsCollector() {
        this.metricsCollector = new MetricsCollector();
    }

    public void resetToReady() {
        if (!this.canBeUsed()) {
            return;
        }
        this.adActivity = null;
        this.isPrepared = false;
        this.adTimer.cancelTimer();
        this.resetMetricsCollector();
        this.orientationFailureMetricRecorded = false;
        this.getAdContainer().destroy();
        this.adSdkBridgeList.clear();
        this.adData = null;
        this.setAdState(AdState.READY_TO_LOAD);
    }

    void setAdActivity(Activity activity) {
        this.adActivity = activity;
    }

    public void setAdData(AdData adData) {
        this.adData = adData;
    }

    public void setAdState(AdState adState) {
        MobileAdsLogger mobileAdsLogger = this.logger;
        Object[] arrobject = new Object[]{this.adState, adState};
        mobileAdsLogger.d("Changing AdState from %s to %s", arrobject);
        this.adState = adState;
    }

    protected void setAdditionalMetrics() {
        this.adUtils.setConnectionMetrics(this.getConnectionInfo(), this.getMetricsCollector());
        if (this.getWindowHeight() == 0) {
            this.getMetricsCollector().incrementMetric(Metrics.MetricType.ADLAYOUT_HEIGHT_ZERO);
        }
        this.getMetricsCollector().setMetricString(Metrics.MetricType.VIEWPORT_SCALE, this.getScalingMultiplierDescription());
    }

    public void setAllowClicks(boolean bl) {
        this.getAdContainer().setAllowClicks(bl);
    }

    public void setCallback(AdControlCallback adControlCallback) {
        this.adControlCallback = adControlCallback;
    }

    public void setConnectionInfo(ConnectionInfo connectionInfo) {
        this.connectionInfo = connectionInfo;
    }

    public void setExpanded(boolean bl) {
        if (bl) {
            this.setAdState(AdState.EXPANDED);
            return;
        }
        this.setAdState(AdState.SHOWING);
    }

    void setHasFinishedLoading(boolean bl) {
        this.hasFinishedLoading.set(bl);
    }

    public void setTimeout(int n2) {
        this.timeout = n2;
    }

    void setViewDimensionsToAdDimensions() {
        AdData adData = this.adData;
        if (adData != null) {
            double d2 = adData.getHeight();
            double d3 = this.getScalingMultiplier();
            Double.isNaN((double)d2);
            double d4 = d2 * d3;
            double d5 = this.adUtils.getScalingFactorAsFloat();
            Double.isNaN((double)d5);
            int n2 = (int)(d4 * d5);
            if (n2 <= 0) {
                n2 = -1;
            }
            if (this.getAdSize().canUpscale()) {
                this.getAdContainer().setViewHeight(n2);
                return;
            }
            double d6 = this.adData.getWidth();
            double d7 = this.getScalingMultiplier();
            Double.isNaN((double)d6);
            double d8 = d6 * d7;
            double d9 = this.adUtils.getScalingFactorAsFloat();
            Double.isNaN((double)d9);
            int n3 = (int)(d8 * d9);
            this.getAdContainer().setViewLayoutParams(n3, n2, this.getAdSize().getGravity());
        }
    }

    public void setViewDimensionsToMatchParent() {
        this.getAdContainer().setViewLayoutParams(-1, -1, 17);
    }

    public void setWindowDimensions(int n2, int n3) {
        this.adWindowWidth = n2;
        this.adWindowHeight = n3;
        this.windowDimensionsSet = true;
    }

    public void showNativeCloseButtonImage(boolean bl) {
        this.getAdContainer().showNativeCloseButtonImage(bl);
    }

    public boolean startAdDrawing() {
        this.adTimer.cancelTimer();
        return AdState.RENDERED.equals((Object)this.getAdState()) && this.canExpireOrDraw(AdState.DRAWING);
    }

    public void stashView() {
        this.getAdContainer().stashView();
    }

    public void submitAndResetMetrics() {
        Metrics.getInstance().submitAndResetMetrics(this);
    }

    public void submitAndResetMetricsIfNecessary(boolean bl) {
        if (bl) {
            this.submitAndResetMetrics();
        }
    }

    private class AdControllerAdWebViewClientListener
    implements AdWebViewClient.AdWebViewClientListener {
        private AdControllerAdWebViewClientListener() {
        }

        @Override
        public void onLoadResource(WebView webView, String string) {
        }

        @Override
        public void onPageFinished(WebView webView, String string) {
            if (AdController.this.getAdContainer().isCurrentView((View)webView)) {
                AdController.this.adRendered(string);
            }
        }

        @Override
        public void onPageStarted(WebView webView, String string) {
        }

        @Override
        public void onReceivedError(WebView webView, int n2, String string, String string2) {
        }
    }

    class DefaultAdControlCallback
    implements AdControlCallback {
        DefaultAdControlCallback() {
        }

        @Override
        public int adClosing() {
            AdController.this.logger.d("DefaultAdControlCallback adClosing called");
            return 1;
        }

        @Override
        public boolean isAdReady(boolean bl) {
            AdController.this.logger.d("DefaultAdControlCallback isAdReady called");
            return AdController.this.getAdState().equals((Object)AdState.READY_TO_LOAD) || AdController.this.getAdState().equals((Object)AdState.SHOWING);
            {
            }
        }

        @Override
        public void onAdEvent(AdEvent adEvent) {
            AdController.this.logger.d("DefaultAdControlCallback onAdEvent called");
        }

        @Override
        public void onAdExpired() {
            AdController.this.logger.d("DefaultAdControlCallback onAdExpired called");
        }

        @Override
        public void onAdFailed(AdError adError) {
            AdController.this.logger.d("DefaultAdControlCallback onAdFailed called");
        }

        @Override
        public void onAdLoaded(AdProperties adProperties) {
            AdController.this.logger.d("DefaultAdControlCallback onAdLoaded called");
        }

        @Override
        public void onAdRendered() {
            AdController.this.logger.d("DefaultAdControlCallback onAdRendered called");
        }

        @Override
        public void postAdRendered() {
            AdController.this.logger.d("DefaultAdControlCallback postAdRendered called");
        }
    }

}

