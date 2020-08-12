/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.amazon.device.ads.DefaultAdListener
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.System
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.Ad;
import com.amazon.device.ads.AdActivity;
import com.amazon.device.ads.AdControlCallback;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdControllerFactory;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdEvent;
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
import com.amazon.device.ads.DefaultAdListener;
import com.amazon.device.ads.IntentBuilder;
import com.amazon.device.ads.IntentBuilderFactory;
import com.amazon.device.ads.InterstitialAd;
import com.amazon.device.ads.InterstitialAdActivityAdapter;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.RelativePosition;
import com.amazon.device.ads.ThreadUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class InterstitialAd
implements Ad {
    protected static final String ACTION_INTERSTITIAL_DISMISSED = "dismissed";
    protected static final String ACTION_INTERSTITIAL_FINISHED_LOADING = "finished";
    protected static final String BROADCAST_ACTION = "action";
    protected static final String BROADCAST_CREATIVE = "creative";
    protected static final String BROADCAST_INTENT = "amazon.mobile.ads.interstitial";
    protected static final String BROADCAST_UNIQUE_IDENTIFIER_KEY = "uniqueIdentifier";
    private static final String LOGTAG = "InterstitialAd";
    protected static final String MSG_PREPARE_AD_DESTROYED = "This interstitial ad has been destroyed and can no longer be used. Create a new InterstitialAd object to load a new ad.";
    protected static final String MSG_PREPARE_AD_LOADING = "An interstitial ad is currently loading. Please wait for the ad to finish loading and showing before loading another ad.";
    protected static final String MSG_PREPARE_AD_READY_TO_SHOW = "An interstitial ad is ready to show. Please call showAd() to show the ad before loading another ad.";
    protected static final String MSG_PREPARE_AD_SHOWING = "An interstitial ad is currently showing. Please wait for the user to dismiss the ad before loading an ad.";
    protected static final String MSG_SHOW_AD_ANOTHER_SHOWING = "Another interstitial ad is currently showing. Please wait for the InterstitialAdListener.onAdDismissed callback of the other ad.";
    protected static final String MSG_SHOW_AD_DESTROYED = "The interstitial ad cannot be shown because it has been destroyed. Create a new InterstitialAd object to load a new ad.";
    protected static final String MSG_SHOW_AD_DISMISSED = "The interstitial ad cannot be shown because it has already been displayed to the user. Please call loadAd(AdTargetingOptions) to load a new ad.";
    protected static final String MSG_SHOW_AD_EXPIRED = "This interstitial ad has expired. Please load another ad.";
    protected static final String MSG_SHOW_AD_LOADING = "The interstitial ad cannot be shown because it is still loading. Please wait for the AdListener.onAdLoaded() callback before showing the ad.";
    protected static final String MSG_SHOW_AD_READY_TO_LOAD = "The interstitial ad cannot be shown because it has not loaded successfully. Please call loadAd(AdTargetingOptions) to load an ad first.";
    protected static final String MSG_SHOW_AD_SHOWING = "The interstitial ad cannot be shown because it is already displayed on the screen. Please wait for the InterstitialAdListener.onAdDismissed() callback and then load a new ad.";
    private static final AtomicBoolean isAdShowing = new AtomicBoolean(false);
    private AdController adController;
    private final AdControllerFactory adControllerFactory;
    private AdListenerExecutor adListenerExecutor;
    private final AdListenerExecutorFactory adListenerExecutorFactory;
    private final AdLoadStarter adLoadStarter;
    private final AdRegistrationExecutor adRegistration;
    private final Context context;
    private final IntentBuilderFactory intentBuilderFactory;
    private boolean isInitialized = false;
    private boolean isThisAdShowing = false;
    private final MobileAdsLogger logger;
    private final MobileAdsLoggerFactory loggerFactory;
    private final AtomicBoolean previousAdExpired = new AtomicBoolean(false);
    private int timeout = 20000;

    public InterstitialAd(Context context) {
        this(context, new MobileAdsLoggerFactory(), new AdControllerFactory(), new IntentBuilderFactory(), AdRegistration.getAmazonAdRegistrationExecutor(), new AdLoadStarter());
    }

    InterstitialAd(Context context, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdControllerFactory adControllerFactory, IntentBuilderFactory intentBuilderFactory, AdRegistrationExecutor adRegistrationExecutor, AdLoadStarter adLoadStarter) {
        this(context, mobileAdsLoggerFactory, new AdListenerExecutorFactory(mobileAdsLoggerFactory), adControllerFactory, intentBuilderFactory, adRegistrationExecutor, adLoadStarter);
    }

    InterstitialAd(Context context, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdListenerExecutorFactory adListenerExecutorFactory, AdControllerFactory adControllerFactory, IntentBuilderFactory intentBuilderFactory, AdRegistrationExecutor adRegistrationExecutor, AdLoadStarter adLoadStarter) {
        if (context != null) {
            this.context = context;
            this.loggerFactory = mobileAdsLoggerFactory;
            this.logger = this.loggerFactory.createMobileAdsLogger(LOGTAG);
            this.adListenerExecutorFactory = adListenerExecutorFactory;
            this.adControllerFactory = adControllerFactory;
            this.intentBuilderFactory = intentBuilderFactory;
            this.adRegistration = adRegistrationExecutor;
            this.adLoadStarter = adLoadStarter;
            return;
        }
        throw new IllegalArgumentException("InterstitialAd requires a non-null Context");
    }

    static /* synthetic */ void access$000(InterstitialAd interstitialAd, AdProperties adProperties) {
        interstitialAd.callOnAdLoaded(adProperties);
    }

    private void callOnAdLoaded(AdProperties adProperties) {
        this.adListenerExecutor.onAdLoaded(this, adProperties);
    }

    private void clearCachedAdController() {
        AdControllerFactory.removeCachedAdController();
    }

    private AdController getAdController() {
        this.initializeIfNecessary();
        if (this.adController == null) {
            this.initializeAdController();
        }
        return this.adController;
    }

    private MetricsCollector getMetricsCollector() {
        return this.getAdController().getMetricsCollector();
    }

    private void initializeAdController() {
        this.setAdController(this.createAdController(this.context));
    }

    private void initializeIfNecessary() {
        if (this.isInitialized()) {
            return;
        }
        this.isInitialized = true;
        this.adRegistration.initializeAds(this.context.getApplicationContext());
        if (this.adListenerExecutor == null) {
            this.setListener(null);
        }
        this.initializeAdController();
        this.setAdditionalMetrics();
    }

    public static boolean isAdShowing() {
        return isAdShowing.get();
    }

    private boolean isInitialized() {
        return this.isInitialized;
    }

    static void resetIsAdShowing() {
        isAdShowing.set(false);
    }

    private void setAdController(AdController adController) {
        this.adController = adController;
        adController.setCallback(this.constructAdControlCallback());
    }

    private void setAdditionalMetrics() {
        this.getMetricsCollector().setAdTypeMetricTag(AdProperties.AdType.INTERSTITIAL.getAdTypeMetricTag());
        this.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_IS_INTERSTITIAL);
    }

    void callOnAdDismissed() {
        this.adListenerExecutor.onAdDismissed(this);
    }

    void callOnAdDismissedOnMainThread() {
        ThreadUtils.executeOnMainThread(new Runnable(this){
            final /* synthetic */ InterstitialAd this$0;
            {
                this.this$0 = interstitialAd;
            }

            public void run() {
                this.this$0.callOnAdDismissed();
                this.this$0.submitAndResetMetrics();
            }
        });
    }

    void callOnAdExpired() {
        this.adListenerExecutor.onAdExpired(this);
    }

    void callOnAdExpiredOnMainThread() {
        ThreadUtils.executeOnMainThread(new Runnable(this){
            final /* synthetic */ InterstitialAd this$0;
            {
                this.this$0 = interstitialAd;
            }

            public void run() {
                this.this$0.callOnAdExpired();
            }
        });
    }

    void callOnAdFailedOnMainThread(AdError adError) {
        ThreadUtils.executeOnMainThread(new Runnable(this, adError){
            final /* synthetic */ InterstitialAd this$0;
            final /* synthetic */ AdError val$error;
            {
                this.this$0 = interstitialAd;
                this.val$error = adError;
            }

            public void run() {
                this.this$0.callOnAdFailedToLoad(this.val$error);
            }
        });
    }

    void callOnAdFailedToLoad(AdError adError) {
        this.adListenerExecutor.onAdFailedToLoad(this, adError);
    }

    void callOnAdLoadedOnMainThread(AdProperties adProperties) {
        ThreadUtils.executeOnMainThread(new Runnable(this, adProperties){
            final /* synthetic */ InterstitialAd this$0;
            final /* synthetic */ AdProperties val$adProperties;
            {
                this.this$0 = interstitialAd;
                this.val$adProperties = adProperties;
            }

            public void run() {
                InterstitialAd.access$000(this.this$0, this.val$adProperties);
            }
        });
    }

    AdControlCallback constructAdControlCallback() {
        return new InterstitialAdControlCallback();
    }

    AdController createAdController(Context context) {
        return this.adControllerFactory.buildAdController(context, AdSize.SIZE_INTERSTITIAL);
    }

    boolean didAdActivityFail() {
        boolean bl = this.isThisAdShowing && !isAdShowing.get();
        if (bl) {
            this.getMetricsCollector().incrementMetric(Metrics.MetricType.INTERSTITIAL_AD_ACTIVITY_FAILED);
            this.getAdController().closeAd();
        }
        return bl;
    }

    @Override
    public int getTimeout() {
        return this.timeout;
    }

    void handleDismissed() {
        this.getMetricsCollector().stopMetric(Metrics.MetricType.AD_SHOW_DURATION);
        AdControllerFactory.removeCachedAdController();
        isAdShowing.set(false);
        this.isThisAdShowing = false;
        this.callOnAdDismissedOnMainThread();
    }

    @Override
    public boolean isLoading() {
        return this.getAdController().getAdState().equals((Object)AdState.LOADING) || this.getAdController().getAdState().equals((Object)AdState.LOADED) || this.getAdController().getAdState().equals((Object)AdState.RENDERING);
        {
        }
    }

    public boolean isReady() {
        return this.isReadyToShow() && !this.getAdController().isExpired();
    }

    boolean isReadyToLoad() {
        return this.getAdController().getAdState().equals((Object)AdState.READY_TO_LOAD);
    }

    boolean isReadyToShow() {
        return this.getAdController().getAdState().equals((Object)AdState.RENDERED);
    }

    public boolean isShowing() {
        return this.getAdController().getAdState().equals((Object)AdState.SHOWING);
    }

    @Override
    public boolean loadAd() {
        return this.loadAd(null);
    }

    @Override
    public boolean loadAd(AdTargetingOptions adTargetingOptions) {
        this.didAdActivityFail();
        if (!this.isReadyToLoad()) {
            int n2 = 5.$SwitchMap$com$amazon$device$ads$AdState[this.getAdController().getAdState().ordinal()];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 != 4) {
                            this.logger.w(MSG_PREPARE_AD_LOADING);
                            return false;
                        }
                        this.logger.e("An interstitial ad could not be loaded because the view has been destroyed.");
                        return false;
                    }
                    if (this.getAdController().isExpired()) {
                        this.getAdController().resetToReady();
                        return this.loadAd(adTargetingOptions);
                    }
                    this.logger.e("An interstitial ad could not be loaded because of an unknown issue with the web views.");
                    return false;
                }
                this.logger.w(MSG_PREPARE_AD_SHOWING);
                return false;
            }
            this.logger.w(MSG_PREPARE_AD_READY_TO_SHOW);
            return false;
        }
        this.previousAdExpired.set(false);
        AdLoadStarter adLoadStarter = this.adLoadStarter;
        int n3 = this.getTimeout();
        AdSlot[] arradSlot = new AdSlot[]{new AdSlot(this.getAdController(), adTargetingOptions)};
        adLoadStarter.loadAds(n3, adTargetingOptions, arradSlot);
        return this.getAdController().getAndResetIsPrepared();
    }

    @Override
    public void setListener(AdListener adListener) {
        if (adListener == null) {
            adListener = new DefaultAdListener(LOGTAG);
        }
        this.adListenerExecutor = this.adListenerExecutorFactory.createAdListenerExecutor(adListener);
    }

    @Override
    public void setTimeout(int n2) {
        this.timeout = n2;
    }

    public boolean showAd() {
        if (this.didAdActivityFail()) {
            this.logger.e("The ad could not be shown because it previously failed to show. Please load a new ad.");
            return false;
        }
        if (this.previousAdExpired.get()) {
            this.logger.w(MSG_SHOW_AD_EXPIRED);
            return false;
        }
        long l2 = System.nanoTime();
        if (this.isReadyToShow()) {
            if (this.getAdController().isExpired()) {
                this.logger.w(MSG_SHOW_AD_EXPIRED);
                return false;
            }
            if (isAdShowing.getAndSet(true)) {
                this.logger.w(MSG_SHOW_AD_ANOTHER_SHOWING);
                return false;
            }
            if (this.getAdController().startAdDrawing()) {
                this.isThisAdShowing = true;
                this.getMetricsCollector().stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_LOADED_TO_AD_SHOW_TIME, l2);
                this.getMetricsCollector().startMetricInMillisecondsFromNanoseconds(Metrics.MetricType.AD_SHOW_DURATION, l2);
                AdControllerFactory.cacheAdController(this.getAdController());
                this.getMetricsCollector().startMetric(Metrics.MetricType.AD_SHOW_LATENCY);
                boolean bl = this.showAdInActivity();
                if (!bl) {
                    this.clearCachedAdController();
                    this.getAdController().resetToReady();
                    isAdShowing.set(false);
                    this.isThisAdShowing = false;
                    this.getMetricsCollector().stopMetric(Metrics.MetricType.AD_LATENCY_RENDER_FAILED);
                }
                return bl;
            }
            this.logger.w("Interstitial ad could not be shown.");
            return false;
        }
        if (this.isReadyToLoad()) {
            this.logger.w(MSG_SHOW_AD_READY_TO_LOAD);
            return false;
        }
        if (this.isLoading()) {
            this.logger.w(MSG_SHOW_AD_LOADING);
            return false;
        }
        if (this.isShowing()) {
            this.logger.w(MSG_SHOW_AD_SHOWING);
            return false;
        }
        this.logger.w("An interstitial ad is not ready to show.");
        return false;
    }

    boolean showAdInActivity() {
        boolean bl = this.intentBuilderFactory.createIntentBuilder().withClass(AdActivity.class).withContext(this.context.getApplicationContext()).withExtra("adapter", InterstitialAdActivityAdapter.class.getName()).fireIntent();
        if (!bl) {
            this.logger.e("Failed to show the interstitial ad because AdActivity could not be found.");
        }
        return bl;
    }

    void submitAndResetMetrics() {
        if (this.getMetricsCollector() != null && !this.getMetricsCollector().isMetricsCollectorEmpty()) {
            this.setAdditionalMetrics();
            this.getAdController().submitAndResetMetricsIfNecessary(true);
        }
    }

    class InterstitialAdControlCallback
    implements AdControlCallback {
        private AdProperties adProperties;

        InterstitialAdControlCallback() {
        }

        @Override
        public int adClosing() {
            InterstitialAd.this.handleDismissed();
            return 1;
        }

        @Override
        public boolean isAdReady(boolean bl) {
            return InterstitialAd.this.isReadyToLoad();
        }

        @Override
        public void onAdEvent(AdEvent adEvent) {
        }

        @Override
        public void onAdExpired() {
            InterstitialAd.this.getMetricsCollector().incrementMetric(Metrics.MetricType.AD_EXPIRED_BEFORE_SHOWING);
            InterstitialAd.this.previousAdExpired.set(true);
            InterstitialAd.this.adController = null;
            InterstitialAd.this.callOnAdExpiredOnMainThread();
        }

        @Override
        public void onAdFailed(AdError adError) {
            if (AdError.ErrorCode.NETWORK_TIMEOUT.equals((Object)adError.getCode())) {
                InterstitialAd.this.adController = null;
            }
            InterstitialAd.this.callOnAdFailedOnMainThread(adError);
        }

        @Override
        public void onAdLoaded(AdProperties adProperties) {
            this.adProperties = adProperties;
            InterstitialAd.this.setAdditionalMetrics();
            InterstitialAd.this.getAdController().enableNativeCloseButton(true, RelativePosition.TOP_RIGHT);
            InterstitialAd.this.getAdController().render();
        }

        @Override
        public void onAdRendered() {
            InterstitialAd.this.callOnAdLoadedOnMainThread(this.adProperties);
        }

        @Override
        public void postAdRendered() {
            InterstitialAd.this.getMetricsCollector().startMetric(Metrics.MetricType.AD_LOADED_TO_AD_SHOW_TIME);
        }
    }

}

