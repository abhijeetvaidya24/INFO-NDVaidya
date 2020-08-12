/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.WindowManager
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.amazon.device.ads.DefaultAdListener
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Locale
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.ScheduledThreadPoolExecutor
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdControlCallback;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdControllerFactory;
import com.amazon.device.ads.AdData;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdListener;
import com.amazon.device.ads.AdListenerExecutor;
import com.amazon.device.ads.AdListenerExecutorFactory;
import com.amazon.device.ads.AdLoadStarter;
import com.amazon.device.ads.AdProperties;
import com.amazon.device.ads.AdRegistration;
import com.amazon.device.ads.AdRegistrationExecutor;
import com.amazon.device.ads.AdSize;
import com.amazon.device.ads.AdSlot;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.ContextUtils;
import com.amazon.device.ads.DefaultAdListener;
import com.amazon.device.ads.Destroyable;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.NumberUtils;
import com.amazon.device.ads.ParameterMap;
import com.amazon.device.ads.ThreadUtils;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint(value={"InlinedApi"})
public class AdLayout
extends FrameLayout
implements Ad {
    private static final String CONTENT_DESCRIPTION_AD_LAYOUT = "adLayoutObject";
    public static final int DEFAULT_TIMEOUT = 20000;
    static final String LAYOUT_NOT_RUN_ERR_MSG = "Can't load an ad because the view size cannot be determined.";
    static final String LAYOUT_PARAMS_NULL_ERR_MSG = "Can't load an ad because layout parameters are blank. Use setLayoutParams() to specify dimensions for this AdLayout.";
    static final String LOADING_IN_PROGRESS_LOG_MSG = "Can't load an ad because an ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.";
    static final String LOADING_OR_LOADED_LOG_MSG = "Can't load an ad because an ad is currently loading or already loaded. Please wait for the ad to finish loading or showing before loading another ad.";
    private static final String LOGTAG = "AdLayout";
    private static ScheduledThreadPoolExecutor threadPool = new ScheduledThreadPoolExecutor(1);
    private View activityRootView = null;
    private AdController adController;
    private final AdControllerFactory adControllerFactory;
    private AdListenerExecutor adListenerExecutor;
    private final AdListenerExecutorFactory adListenerExecutorFactory;
    private final AdLoadStarter adLoadStarter;
    private final AdRegistrationExecutor adRegistration;
    private AdSize adSize;
    private AdTargetingOptions adTargetingOptions = null;
    private boolean attached = false;
    private boolean autoShow = true;
    private final Context context;
    private Destroyable currentDestroyable;
    private View currentView;
    private boolean hasRegisterBroadcastReciever = false;
    private boolean isDestroyed = false;
    private boolean isInForeground;
    private boolean isInitialized = false;
    private boolean isParentViewMissingAtLoadTime = false;
    private int lastVisibility = 8;
    private final MobileAdsLogger logger;
    private final MobileAdsLoggerFactory loggerFactory;
    private AtomicBoolean needsToLoadAdOnLayout = new AtomicBoolean(false);
    private final AtomicBoolean previousAdExpired = new AtomicBoolean(false);
    private AdProperties properties;
    private BroadcastReceiver screenStateReceiver;
    private boolean shouldDisableWebViewHardwareAcceleration;

    static {
        threadPool.setKeepAliveTime(60L, TimeUnit.SECONDS);
    }

    public AdLayout(Context context) {
        this(context, AdSize.SIZE_AUTO);
    }

    public AdLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, new MobileAdsLoggerFactory(), new AdControllerFactory(), AdRegistration.getAmazonAdRegistrationExecutor(), new AdLoadStarter());
    }

    public AdLayout(Context context, AttributeSet attributeSet, int n2) {
        this(context, attributeSet, n2, new MobileAdsLoggerFactory(), new AdControllerFactory(), AdRegistration.getAmazonAdRegistrationExecutor(), new AdLoadStarter());
    }

    AdLayout(Context context, AttributeSet attributeSet, int n2, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdControllerFactory adControllerFactory, AdRegistrationExecutor adRegistrationExecutor, AdLoadStarter adLoadStarter) {
        this(context, attributeSet, n2, mobileAdsLoggerFactory, new AdListenerExecutorFactory(mobileAdsLoggerFactory), adControllerFactory, adRegistrationExecutor, adLoadStarter);
    }

    AdLayout(Context context, AttributeSet attributeSet, int n2, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdListenerExecutorFactory adListenerExecutorFactory, AdControllerFactory adControllerFactory, AdRegistrationExecutor adRegistrationExecutor, AdLoadStarter adLoadStarter) {
        super(context, attributeSet, n2);
        this.context = context;
        this.adSize = this.determineAdSize(attributeSet);
        this.loggerFactory = mobileAdsLoggerFactory;
        this.logger = this.loggerFactory.createMobileAdsLogger(LOGTAG);
        this.adListenerExecutorFactory = adListenerExecutorFactory;
        this.adControllerFactory = adControllerFactory;
        this.adRegistration = adRegistrationExecutor;
        this.adLoadStarter = adLoadStarter;
    }

    AdLayout(Context context, AttributeSet attributeSet, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdControllerFactory adControllerFactory, AdRegistrationExecutor adRegistrationExecutor, AdLoadStarter adLoadStarter) {
        this(context, attributeSet, mobileAdsLoggerFactory, new AdListenerExecutorFactory(mobileAdsLoggerFactory), adControllerFactory, adRegistrationExecutor, adLoadStarter);
    }

    AdLayout(Context context, AttributeSet attributeSet, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdListenerExecutorFactory adListenerExecutorFactory, AdControllerFactory adControllerFactory, AdRegistrationExecutor adRegistrationExecutor, AdLoadStarter adLoadStarter) {
        super(context, attributeSet);
        this.context = context;
        this.adSize = this.determineAdSize(attributeSet);
        this.loggerFactory = mobileAdsLoggerFactory;
        this.logger = this.loggerFactory.createMobileAdsLogger(LOGTAG);
        this.adListenerExecutorFactory = adListenerExecutorFactory;
        this.adControllerFactory = adControllerFactory;
        this.adRegistration = adRegistrationExecutor;
        this.adLoadStarter = adLoadStarter;
    }

    public AdLayout(Context context, AdSize adSize) {
        this(context, adSize, new MobileAdsLoggerFactory(), new AdControllerFactory(), AdRegistration.getAmazonAdRegistrationExecutor(), new AdLoadStarter());
    }

    AdLayout(Context context, AdSize adSize, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdControllerFactory adControllerFactory, AdRegistrationExecutor adRegistrationExecutor, AdLoadStarter adLoadStarter) {
        this(context, adSize, mobileAdsLoggerFactory, new AdListenerExecutorFactory(mobileAdsLoggerFactory), adControllerFactory, adRegistrationExecutor, adLoadStarter);
    }

    AdLayout(Context context, AdSize adSize, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdListenerExecutorFactory adListenerExecutorFactory, AdControllerFactory adControllerFactory, AdRegistrationExecutor adRegistrationExecutor, AdLoadStarter adLoadStarter) {
        super(context);
        this.context = context;
        this.adSize = adSize;
        this.loggerFactory = mobileAdsLoggerFactory;
        this.logger = this.loggerFactory.createMobileAdsLogger(LOGTAG);
        this.adListenerExecutorFactory = adListenerExecutorFactory;
        this.adControllerFactory = adControllerFactory;
        this.adRegistration = adRegistrationExecutor;
        this.adLoadStarter = adLoadStarter;
    }

    static /* synthetic */ boolean access$000(AdLayout adLayout) {
        return adLayout.isInForeground;
    }

    private void collapseAd() {
        if (this.getAdController().getAdState().equals((Object)AdState.EXPANDED)) {
            ThreadUtils.scheduleOnMainThread(new Runnable(this){
                final /* synthetic */ AdLayout this$0;
                {
                    this.this$0 = adLayout;
                }

                public void run() {
                    if (AdLayout.access$100(this.this$0).getAdState().equals((Object)((Object)AdState.EXPANDED))) {
                        AdLayout.access$100(this.this$0).closeAd();
                    }
                }
            });
        }
    }

    private AdController createAdController(AdSize adSize, Context context) {
        return this.adControllerFactory.buildAdController(context, adSize);
    }

    private AdSize determineAdSize(AttributeSet attributeSet) {
        String string = AdLayout.getAttributeValue(attributeSet, "http://schemas.android.com/apk/lib/com.amazon.device.ads", "adSize");
        if (string == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("http://schemas.android.com/apk/res/");
            stringBuilder.append(this.context.getPackageName());
            string = AdLayout.getAttributeValue(attributeSet, stringBuilder.toString(), "adSize");
            if (string != null) {
                this.logger.forceLog(MobileAdsLogger.Level.WARN, "DEPRECATED - Please use the XML namespace \"http://schemas.android.com/apk/lib/com.amazon.device.ads\" for specifying AdLayout properties.", new Object[0]);
                if (string.toLowerCase(Locale.US).equals((Object)"custom")) {
                    this.logger.forceLog(MobileAdsLogger.Level.ERROR, "Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size.", new Object[0]);
                    throw new IllegalArgumentException("Using \"custom\" or \"CUSTOM\" for the \"adSize\" property is no longer supported. Please specifiy a size or remove the property to use Auto Ad Size.");
                }
            }
        }
        return AdLayout.parseAdSize(string);
    }

    private void fireViewableEvent() {
        AdController adController = this.adController;
        if (adController != null) {
            adController.fireViewableEvent();
        }
    }

    private AdController getAdController() {
        this.initializeIfNecessary();
        if (this.adController == null) {
            this.initializeAdController();
        }
        return this.adController;
    }

    private static String getAttributeValue(AttributeSet attributeSet, String string, String string2) {
        return attributeSet.getAttributeValue(string, string2);
    }

    private void initializeAdController() {
        if (this.adController == null) {
            AdSize adSize = this.adSize;
            if (adSize == null) {
                adSize = AdSize.SIZE_AUTO;
            }
            this.setAdController(this.createAdController(adSize, this.context));
            this.adController.requestDisableHardwareAcceleration(this.shouldDisableWebViewHardwareAcceleration);
        }
    }

    private boolean isReadyToLoad() {
        return AdState.READY_TO_LOAD.equals((Object)this.getAdController().getAdState()) || AdState.SHOWING.equals((Object)this.getAdController().getAdState());
        {
        }
    }

    private boolean isReadyToShow() {
        return this.getAdController().getAdState().equals((Object)AdState.RENDERED);
    }

    private boolean loadAdWhenParentViewMissing() {
        if (this.getLayoutParams() == null) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_FAILED_NULL_LAYOUT_PARAMS);
            this.onRequestError(LAYOUT_PARAMS_NULL_ERR_MSG);
            return false;
        }
        if (AndroidTargetUtils.isAtLeastAndroidAPI(11)) {
            this.setActivityRootView();
            if (this.isActivityRootViewNull()) {
                this.onRequestError("Ad load failed because root view could not be obtained from the activity.");
                return false;
            }
            if (this.isActivityRootViewLayoutRequested()) {
                this.logger.d("Activity root view layout is requested.");
                this.deferAdLoadToLayoutEvent();
                this.setOnLayoutChangeListenerForRoot();
                return false;
            }
            this.setFloatingWindowDimensions();
            return true;
        }
        this.setFloatingWindowDimensions();
        return true;
    }

    private void onRequestError(String string) {
        this.getAdController().onRequestError(string);
    }

    private static AdSize parseAdSize(String string) {
        AdSize adSize = AdSize.SIZE_AUTO;
        if (string != null) {
            String string2 = string.toLowerCase(Locale.US);
            if (string2.equals((Object)"autonoscale")) {
                return AdSize.SIZE_AUTO_NO_SCALE;
            }
            if (!string2.equals((Object)"auto")) {
                int n2;
                String[] arrstring = string2.split("x");
                int n3 = arrstring.length;
                int n4 = 0;
                if (n3 == 2) {
                    n2 = NumberUtils.parseInt(arrstring[0], 0);
                    n4 = NumberUtils.parseInt(arrstring[1], 0);
                } else {
                    n2 = 0;
                }
                adSize = new AdSize(n2, n4);
            }
        }
        return adSize;
    }

    private void registerScreenStateBroadcastReceiver() {
        if (this.hasRegisterBroadcastReciever) {
            return;
        }
        this.hasRegisterBroadcastReciever = true;
        this.screenStateReceiver = new BroadcastReceiver(this){
            final /* synthetic */ AdLayout this$0;
            {
                this.this$0 = adLayout;
            }

            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals((Object)"android.intent.action.SCREEN_OFF") && AdLayout.access$000(this.this$0)) {
                    AdLayout.access$100(this.this$0).closeAd();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.context.getApplicationContext().registerReceiver(this.screenStateReceiver, intentFilter);
    }

    private void setAdController(AdController adController) {
        this.adController = adController;
        this.adController.setCallback(this.createAdControlCallback());
    }

    private void setWindowDimensions() {
        int n2 = this.resolveLayoutParam(true);
        int n3 = this.resolveLayoutParam(false);
        if (n2 > 0 || n3 > 0) {
            this.getAdController().setWindowDimensions(n2, n3);
        }
    }

    private void startAdLoadUponLayout() {
        AdTargetingOptions adTargetingOptions = this.adTargetingOptions;
        AdSlot adSlot = new AdSlot(this.getAdController(), adTargetingOptions).setDeferredLoad(true);
        this.adLoadStarter.loadAds(this.getAdController().getTimeout(), adTargetingOptions, adSlot);
        if (!this.getAndResetIsPrepared()) {
            this.onRequestError("Could not load ad on layout.");
        }
    }

    private void unregisterScreenStateBroadcastReceiver() {
        if (this.hasRegisterBroadcastReciever) {
            this.hasRegisterBroadcastReciever = false;
            this.context.getApplicationContext().unregisterReceiver(this.screenStateReceiver);
        }
    }

    void adFailed(AdError adError) {
        this.getAdController().adFailed(adError);
    }

    void adShown() {
        this.getAdController().adShown();
    }

    void bypassAdRenderingProcess() {
        this.getAdController().setAdState(AdState.RENDERING);
        this.getAdController().adRendered("custom-render");
    }

    AdControlCallback createAdControlCallback() {
        return new AdLayoutAdControlCallback();
    }

    void deferAdLoadToLayoutEvent() {
        this.setNeedsToLoadAdOnLayout(true);
        this.scheduleTaskForCheckingIfLayoutHasRun();
    }

    public void destroy() {
        if (!this.isInitialized()) {
            return;
        }
        this.logger.d("Destroying the AdLayout");
        this.isDestroyed = true;
        this.unregisterScreenStateBroadcastReceiver();
        this.getAdController().destroy();
    }

    public void disableAutoShow() {
        this.autoShow = false;
    }

    public void enableAutoShow() {
        this.autoShow = true;
    }

    void failLoadIfLayoutHasNotRun() {
        if (this.getAndSetNeedsToLoadAdOnLayout(false)) {
            Metrics.getInstance().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_FAILED_LAYOUT_NOT_RUN);
            this.onRequestError(LAYOUT_NOT_RUN_ERR_MSG);
        }
    }

    int getActivityRootViewDimension(boolean bl) {
        if (bl) {
            return this.activityRootView.getWidth();
        }
        return this.activityRootView.getHeight();
    }

    AdData getAdData() {
        return this.getAdController().getAdData();
    }

    AdListenerExecutor getAdListenerExecutor() {
        return this.adListenerExecutor;
    }

    public AdSize getAdSize() {
        AdController adController = this.getAdController();
        if (adController == null) {
            return null;
        }
        return adController.getAdSize();
    }

    boolean getAndResetIsPrepared() {
        return this.getAdController().getAndResetIsPrepared();
    }

    boolean getAndSetNeedsToLoadAdOnLayout(boolean bl) {
        return this.needsToLoadAdOnLayout.getAndSet(bl);
    }

    MobileAdsLogger getLogger() {
        return this.logger;
    }

    boolean getNeedsToLoadAdOnLayout() {
        return this.needsToLoadAdOnLayout.get();
    }

    int getRawScreenDimension(boolean bl) {
        WindowManager windowManager = (WindowManager)this.context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        if (bl) {
            return displayMetrics.widthPixels;
        }
        return displayMetrics.heightPixels;
    }

    @Override
    public int getTimeout() {
        if (this.getAdController() == null) {
            return -1;
        }
        return this.getAdController().getTimeout();
    }

    void initializeIfNecessary() {
        if (this.isInitialized()) {
            return;
        }
        long l2 = System.nanoTime();
        this.logger.d("Initializing AdLayout.");
        this.adRegistration.initializeAds(this.context);
        this.setContentDescription((CharSequence)CONTENT_DESCRIPTION_AD_LAYOUT);
        if (this.isInEditMode()) {
            TextView textView = new TextView(this.context);
            textView.setText((CharSequence)LOGTAG);
            textView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
            textView.setGravity(17);
            this.addView((View)textView);
            this.isInitialized = true;
            return;
        }
        boolean bl = this.getVisibility() == 0;
        this.isInForeground = bl;
        this.setHorizontalScrollBarEnabled(false);
        this.setVerticalScrollBarEnabled(false);
        this.isInitialized = true;
        if (this.adListenerExecutor == null) {
            this.setListener(null);
        }
        this.initializeAdController();
        if (this.isWebViewDatabaseNull()) {
            this.logger.forceLog(MobileAdsLogger.Level.ERROR, "Disabling ads. Local cache file is inaccessible so ads will fail if we try to create a WebView. Details of this Android bug found at: http://code.google.com/p/android/issues/detail?id=10789", new Object[0]);
            this.isInitialized = false;
            return;
        }
        this.adController.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LAYOUT_INITIALIZATION, l2);
        this.adController.getMetricsCollector().stopMetric(Metrics.MetricType.AD_LAYOUT_INITIALIZATION);
    }

    boolean isActivityRootViewLayoutRequested() {
        return this.activityRootView.isLayoutRequested();
    }

    boolean isActivityRootViewNull() {
        return this.activityRootView == null;
    }

    public boolean isAdLoading() {
        return this.isLoading();
    }

    boolean isInitialized() {
        return this.isInitialized;
    }

    @Override
    public boolean isLoading() {
        if (this.getAdController() == null) {
            return false;
        }
        return this.getAdController().getAdState().equals((Object)AdState.LOADING);
    }

    boolean isParentViewMissingAtLoadTime() {
        return this.isParentViewMissingAtLoadTime;
    }

    public boolean isShowing() {
        return this.getAdController().getAdState().equals((Object)AdState.SHOWING);
    }

    boolean isWebViewDatabaseNull() {
        return true ^ this.getAdController().canShowViews();
    }

    @Override
    public boolean loadAd() {
        return this.loadAd(new AdTargetingOptions());
    }

    @Override
    public boolean loadAd(AdTargetingOptions adTargetingOptions) {
        if (adTargetingOptions == null) {
            adTargetingOptions = new AdTargetingOptions();
        }
        this.adTargetingOptions = adTargetingOptions;
        if (this.getNeedsToLoadAdOnLayout()) {
            this.logger.e(LOADING_IN_PROGRESS_LOG_MSG);
            return false;
        }
        this.initializeIfNecessary();
        if (!this.isInitialized()) {
            this.logger.e("The ad could not be initialized properly.");
            return false;
        }
        if (!this.isReadyToLoad()) {
            int n2 = 4.$SwitchMap$com$amazon$device$ads$AdState[this.getAdController().getAdState().ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        this.logger.e(LOADING_OR_LOADED_LOG_MSG);
                        return false;
                    }
                    this.logger.e("An ad could not be loaded because another ad is currently expanded.");
                    return false;
                }
                this.logger.e("An ad could not be loaded because the AdLayout has been destroyed.");
                return false;
            }
            if (this.getAdController().isExpired()) {
                this.getAdController().setAdState(AdState.READY_TO_LOAD);
                this.getAdController().resetToReady();
                return this.loadAd(adTargetingOptions);
            }
            this.logger.e("An ad could not be loaded because of an unknown issue with the web views.");
            return false;
        }
        if (this.getAdController().getAdState().equals((Object)AdState.SHOWING)) {
            this.getAdController().getMetricsCollector().stopMetric(Metrics.MetricType.AD_SHOW_DURATION);
        }
        this.previousAdExpired.set(false);
        AdLoadStarter adLoadStarter = this.adLoadStarter;
        int n3 = this.getAdController().getTimeout();
        AdSlot[] arradSlot = new AdSlot[]{new AdSlot(this.getAdController(), adTargetingOptions)};
        adLoadStarter.loadAds(n3, adTargetingOptions, arradSlot);
        if (this.getNeedsToLoadAdOnLayout()) {
            return true;
        }
        return this.getAndResetIsPrepared();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.isInEditMode()) {
            return;
        }
        this.attached = true;
        this.registerScreenStateBroadcastReceiver();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attached = false;
        this.unregisterScreenStateBroadcastReceiver();
    }

    protected void onLayout(boolean bl, int n2, int n3, int n4, int n5) {
        if (this.isDestroyed) {
            return;
        }
        int n6 = n4 - n2;
        int n7 = n5 - n3;
        super.onLayout(bl, n2, n3, n4, n5);
        if (this.isInEditMode()) {
            return;
        }
        this.getAdController().setWindowDimensions(n6, n7);
        if (this.getAndSetNeedsToLoadAdOnLayout(false)) {
            this.startAdLoadUponLayout();
        }
    }

    protected void onWindowVisibilityChanged(int n2) {
        if (this.attached && this.lastVisibility != n2) {
            if (n2 != 0) {
                this.isInForeground = false;
                this.collapseAd();
                this.unregisterScreenStateBroadcastReceiver();
                return;
            }
            if (n2 == 0) {
                this.isInForeground = true;
            }
        }
    }

    boolean prepareAd(boolean bl) {
        if (bl) {
            this.logger.d("Skipping ad layout preparation steps because the layout is already prepared.");
            return true;
        }
        if (!this.isReadyToLoad()) {
            return false;
        }
        if (this.getNeedsToLoadAdOnLayout()) {
            this.logger.e(LOADING_IN_PROGRESS_LOG_MSG);
            return false;
        }
        if (this.getAdSize().isAuto()) {
            this.logger.d("Ad size to be determined automatically.");
        }
        this.setIsParentViewMissingAtLoadTime();
        if (this.getAdSize().isAuto() && this.getAdController().areWindowDimensionsSet()) {
            return true;
        }
        if (this.isLayoutRequested() && this.getAdSize().isAuto() && !this.isParentViewMissingAtLoadTime()) {
            this.deferAdLoadToLayoutEvent();
            return false;
        }
        if (this.isParentViewMissingAtLoadTime()) {
            this.logger.d("The ad's parent view is missing at load time.");
            return this.loadAdWhenParentViewMissing();
        }
        this.setWindowDimensions();
        return true;
    }

    int resolveLayoutParam(boolean bl) {
        int n2 = bl ? this.getLayoutParams().width : this.getLayoutParams().height;
        if (n2 == -1) {
            if (this.isActivityRootViewNull()) {
                return this.getRawScreenDimension(bl);
            }
            return this.getActivityRootViewDimension(bl);
        }
        if (n2 == -2) {
            return 0;
        }
        return n2;
    }

    void scheduleTaskForCheckingIfLayoutHasRun() {
        Runnable runnable = new Runnable(this){
            final /* synthetic */ AdLayout this$0;
            {
                this.this$0 = adLayout;
            }

            public void run() {
                this.this$0.failLoadIfLayoutHasNotRun();
            }
        };
        threadPool.schedule(runnable, (long)this.getTimeout(), TimeUnit.MILLISECONDS);
    }

    void setActivityRootView() {
        Activity activity = ContextUtils.getContextAsActivity(this.context);
        if (activity == null) {
            this.logger.e("unable to set activity root view because the context did not contain an activity");
            return;
        }
        this.activityRootView = activity.getWindow().getDecorView().findViewById(16908290).getRootView();
    }

    void setFloatingWindowDimensions() {
        if (this.getLayoutParams().width == -1 || this.getLayoutParams().height == -1) {
            this.logger.d("The requested ad will scale based on the screen's dimensions because at least one AdLayout dimension is set to MATCH_PARENT but the AdLayout is currently missing a fixed-size parent view.");
        }
        this.setWindowDimensions();
    }

    void setIsParentViewMissingAtLoadTime() {
        boolean bl = this.getParent() == null;
        this.isParentViewMissingAtLoadTime = bl;
    }

    void setIsParentViewMissingAtLoadTime(boolean bl) {
        this.isParentViewMissingAtLoadTime = bl;
    }

    @Override
    public void setListener(AdListener adListener) {
        if (adListener == null) {
            adListener = new DefaultAdListener(LOGTAG);
        }
        this.adListenerExecutor = this.adListenerExecutorFactory.createAdListenerExecutor(adListener);
    }

    void setMaxWidth(int n2) {
        if (this.adController != null) {
            this.logger.w("The maximum width cannot be changed because this ad has already been initialized. Max width should be set immediately after construction of the Ad object.");
            return;
        }
        this.adSize = this.adSize.newMaxWidth(n2);
    }

    void setNeedsToLoadAdOnLayout(boolean bl) {
        this.needsToLoadAdOnLayout.set(bl);
    }

    void setOnLayoutChangeListenerForRoot() {
        OnLayoutChangeListenerUtil.setOnLayoutChangeListenerForRoot(this);
    }

    void setShouldDisableWebViewHardwareAcceleration(boolean bl) {
        this.shouldDisableWebViewHardwareAcceleration = bl;
        AdController adController = this.adController;
        if (adController != null) {
            adController.requestDisableHardwareAcceleration(this.shouldDisableWebViewHardwareAcceleration);
        }
    }

    @Override
    public void setTimeout(int n2) {
        AdController adController = this.getAdController();
        if (adController != null) {
            adController.setTimeout(n2);
        }
    }

    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        this.fireViewableEvent();
    }

    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        this.fireViewableEvent();
    }

    public void setX(float f2) {
        super.setX(f2);
        this.fireViewableEvent();
    }

    public void setY(float f2) {
        super.setY(f2);
        this.fireViewableEvent();
    }

    boolean shouldDisableWebViewHardwareAcceleration() {
        return this.shouldDisableWebViewHardwareAcceleration;
    }

    public boolean showAd() {
        if (this.previousAdExpired.get()) {
            this.logger.w("This banner ad has expired. Please load another ad.");
            return false;
        }
        if (this.isReadyToShow()) {
            if (this.getAdController().isExpired()) {
                this.logger.w("This banner ad has expired. Please load another ad.");
                return false;
            }
            if (this.getAdController().startAdDrawing()) {
                Destroyable destroyable;
                if (!this.autoShow) {
                    this.getAdController().getMetricsCollector().stopMetric(Metrics.MetricType.AD_LOADED_TO_AD_SHOW_TIME);
                }
                this.getAdController().getMetricsCollector().startMetric(Metrics.MetricType.AD_SHOW_LATENCY);
                View view = this.currentView;
                if (view != null) {
                    this.removeView(view);
                }
                if ((destroyable = this.currentDestroyable) != null) {
                    destroyable.destroy();
                }
                this.currentView = this.getAdController().getView();
                this.currentDestroyable = this.getAdController().getDestroyable();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
                this.addView(this.currentView, (ViewGroup.LayoutParams)layoutParams);
                this.getAdController().getMetricsCollector().startMetric(Metrics.MetricType.AD_SHOW_DURATION);
                this.adShown();
                return true;
            }
            this.logger.w("Banner ad could not be shown.");
            return false;
        }
        if (this.isLoading()) {
            this.logger.w("The banner ad cannot be shown because it is still loading.");
            return false;
        }
        if (this.isShowing()) {
            this.logger.w("The banner ad cannot be shown because it is already showing.");
            return false;
        }
        if (this.isReadyToLoad()) {
            this.logger.w("The banner ad cannot be shown because it has not loaded successfully.");
            return false;
        }
        this.logger.w("A banner ad is not ready to show.");
        return false;
    }

    class AdLayoutAdControlCallback
    implements AdControlCallback {
        AdLayoutAdControlCallback() {
        }

        @Override
        public int adClosing() {
            if (AdLayout.this.getAdController().getAdState().equals((Object)AdState.EXPANDED)) {
                return 0;
            }
            return 2;
        }

        boolean handleAdEvent(AdEvent adEvent) {
            int n2 = 4.$SwitchMap$com$amazon$device$ads$AdEvent$AdEventType[adEvent.getAdEventType().ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return false;
                    }
                    Rect rect = (Rect)adEvent.getParameters().getParameter("positionOnScreen");
                    AdLayout.this.getAdListenerExecutor().onAdResized(AdLayout.this, rect);
                    return true;
                }
                AdLayout.this.getAdListenerExecutor().onAdCollapsed(AdLayout.this);
                return true;
            }
            AdLayout.this.getAdListenerExecutor().onAdExpanded(AdLayout.this);
            return true;
        }

        @Override
        public boolean isAdReady(boolean bl) {
            return AdLayout.this.prepareAd(bl);
        }

        @Override
        public void onAdEvent(AdEvent adEvent) {
            this.handleAdEvent(adEvent);
        }

        @Override
        public void onAdExpired() {
            AdLayout.this.getAdController().getMetricsCollector().incrementMetric(Metrics.MetricType.AD_EXPIRED_BEFORE_SHOWING);
            AdLayout.this.previousAdExpired.set(true);
            AdLayout.this.adController = null;
            AdLayout.this.getAdListenerExecutor().onAdExpired(AdLayout.this);
        }

        @Override
        public void onAdFailed(AdError adError) {
            if (AdError.ErrorCode.NETWORK_TIMEOUT.equals((Object)adError.getCode())) {
                AdLayout.this.adController = null;
            }
            AdLayout.this.getAdListenerExecutor().onAdFailedToLoad(AdLayout.this, adError);
        }

        @Override
        public void onAdLoaded(AdProperties adProperties) {
            AdLayout.this.properties = adProperties;
            AdLayout.this.getAdController().render();
        }

        @SuppressLint(value={"InlinedApi"})
        @Override
        public void onAdRendered() {
            if (AdLayout.this.autoShow) {
                if (AdLayout.this.showAd()) {
                    AdListenerExecutor adListenerExecutor = AdLayout.this.getAdListenerExecutor();
                    AdLayout adLayout = AdLayout.this;
                    adListenerExecutor.onAdLoaded(adLayout, adLayout.properties);
                    return;
                }
            } else {
                AdLayout.this.getAdController().getMetricsCollector().startMetric(Metrics.MetricType.AD_LOADED_TO_AD_SHOW_TIME);
                AdLayout.this.logger.d("Ad is ready to show. Please call showAd to display it.");
                AdListenerExecutor adListenerExecutor = AdLayout.this.getAdListenerExecutor();
                AdLayout adLayout = AdLayout.this;
                adListenerExecutor.onAdLoaded(adLayout, adLayout.properties);
            }
        }

        @Override
        public void postAdRendered() {
        }
    }

}

