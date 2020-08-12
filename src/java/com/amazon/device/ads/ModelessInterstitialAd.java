/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  com.amazon.device.ads.DefaultAdListener
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.amazon.device.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.device.ads.Ad;
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
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ModelessInterstitialAd;
import com.amazon.device.ads.Position;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.Size;
import java.util.concurrent.atomic.AtomicBoolean;

public class ModelessInterstitialAd
implements Ad {
    private static final String LOGTAG = "ModelessInterstitialAd";
    private static final int MIN_PIXELS = 380;
    private static final double MIN_SCREEN_COVERAGE_PERCENTAGE = 0.75;
    private static final String PUBLISHER_KEYWORD = "modeless-interstitial";
    private AdController adController;
    private final AdControllerFactory adControllerFactory;
    private AdListenerExecutor adListenerExecutor;
    private final AdListenerExecutorFactory adListenerExecutorFactory;
    private final AdLoadStarter adLoadStarter;
    private AdProperties adProperties;
    private final AdRegistrationExecutor amazonAdRegistration;
    private final Context context;
    private final ViewGroup hostedViewGroup;
    private final MobileAdsLogger logger;
    private final MobileAdsLoggerFactory loggerFactory;
    private MetricsCollector metricsCollector;
    private final AtomicBoolean previousAdExpired = new AtomicBoolean(false);
    private int timeout;

    public ModelessInterstitialAd(ViewGroup viewGroup) {
        this(viewGroup, AdRegistration.getAmazonAdRegistrationExecutor(), new AdControllerFactory(), new MobileAdsLoggerFactory(), new AdLoadStarter());
    }

    ModelessInterstitialAd(ViewGroup viewGroup, AdRegistrationExecutor adRegistrationExecutor, AdControllerFactory adControllerFactory, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdListenerExecutorFactory adListenerExecutorFactory, AdLoadStarter adLoadStarter) {
        if (viewGroup != null) {
            this.hostedViewGroup = viewGroup;
            this.context = this.hostedViewGroup.getContext();
            this.amazonAdRegistration = adRegistrationExecutor;
            this.adControllerFactory = adControllerFactory;
            this.loggerFactory = mobileAdsLoggerFactory;
            this.logger = this.loggerFactory.createMobileAdsLogger(LOGTAG);
            this.adListenerExecutorFactory = adListenerExecutorFactory;
            this.adLoadStarter = adLoadStarter;
            this.initialize();
            return;
        }
        throw new IllegalArgumentException("The hostedViewGroup must not be null.");
    }

    ModelessInterstitialAd(ViewGroup viewGroup, AdRegistrationExecutor adRegistrationExecutor, AdControllerFactory adControllerFactory, MobileAdsLoggerFactory mobileAdsLoggerFactory, AdLoadStarter adLoadStarter) {
        this(viewGroup, adRegistrationExecutor, adControllerFactory, mobileAdsLoggerFactory, new AdListenerExecutorFactory(mobileAdsLoggerFactory), adLoadStarter);
    }

    private void buildAdController() {
        this.adController = this.adControllerFactory.buildAdController(this.context, AdSize.SIZE_MODELESS_INTERSTITIAL);
        this.adController.setCallback(new ModelessInterstitialAdControlCallback());
        this.metricsCollector = this.adController.getMetricsCollector();
        this.metricsCollector.setAdTypeMetricTag(AdProperties.AdType.MODELESS_INTERSTITIAL.getAdTypeMetricTag());
        this.metricsCollector.incrementMetric(Metrics.MetricType.AD_IS_INTERSTITIAL);
    }

    private void checkIfAdAspectRatioLessThanScreenAspectRatio(Size size, Size size2) {
        float f2 = size.getWidth();
        float f3 = size.getHeight();
        float f4 = size2.getWidth();
        float f5 = size2.getHeight();
        boolean bl = true;
        if (!(f2 <= f3 ? f2 / f3 < f4 / f5 : f3 / f2 < f5 / f4)) {
            bl = false;
        }
        if (bl) {
            this.metricsCollector.incrementMetric(Metrics.MetricType.AD_ASPECT_RATIO_LESS_THAN_SCREEN_ASPECT_RATIO);
            this.logger.w("For an optimal ad experience, the aspect ratio of the ModelessInterstitialAd should be greater than or equal to the aspect ratio of the screen.");
        }
    }

    private boolean doesAdSizeHaveOneSideWithAtLeastMinPixels(Size size) {
        if (size.getHeight() < 380) {
            if (size.getWidth() >= 380) {
                return true;
            }
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{size.getHeight(), size.getWidth(), 380};
            mobileAdsLogger.e("This ModelessInterstitialAd cannot fire impression pixels or receive clicks because the height %d and width %d does not meet the requirement of one side being at least %d device independent pixels.", arrobject);
            return false;
        }
        return true;
    }

    private boolean doesAdSizeMeetRequiredScreenPercentage(Size size, Size size2) {
        double d2 = size.getHeight();
        double d3 = size.getWidth();
        Double.isNaN((double)d2);
        Double.isNaN((double)d3);
        double d4 = d2 * d3;
        double d5 = size2.getHeight();
        double d6 = size2.getWidth();
        Double.isNaN((double)d5);
        Double.isNaN((double)d6);
        double d7 = d4 / (d5 * d6);
        if (d7 >= 0.75) {
            return true;
        }
        MobileAdsLogger mobileAdsLogger = this.logger;
        Object[] arrobject = new Object[]{d7 * 100.0, 75};
        mobileAdsLogger.e("This ModelessInterstitialAd cannot fire impression pixels or receive clicks because it has a screen coverage percentage of %f which does not meet the requirement of covering at least %d percent.", arrobject);
        return false;
    }

    private void initialize() {
        this.amazonAdRegistration.initializeAds(this.context.getApplicationContext());
        this.setListener(null);
        this.buildAdController();
    }

    private boolean isAdOnScreen(Position position, Size size) {
        if (position.getX() >= 0 && position.getX() + position.getSize().getWidth() <= size.getWidth() && position.getY() >= 0 && position.getY() + position.getSize().getHeight() <= size.getHeight()) {
            return true;
        }
        this.logger.e("This ModelessInterstitialAd cannot fire impression pixels or receive clicks because it does not meet the requirement of being fully on screen.");
        return false;
    }

    private boolean isReadyToLoad() {
        AdState adState = this.adController.getAdState();
        return this.adController.isExpired() || adState.equals((Object)AdState.READY_TO_LOAD) || adState.equals((Object)AdState.HIDDEN);
        {
        }
    }

    private void onAdExpired() {
        this.metricsCollector.incrementMetric(Metrics.MetricType.AD_EXPIRED_BEFORE_SHOWING);
        this.previousAdExpired.set(true);
        this.buildAdController();
        this.adListenerExecutor.onAdExpired(this);
    }

    private void onAdFailedToLoadOrRender(AdError adError) {
        if (adError.getCode().equals((Object)AdError.ErrorCode.NETWORK_TIMEOUT)) {
            this.submitMetrics();
            this.buildAdController();
        }
        this.adListenerExecutor.onAdFailedToLoad(this, adError);
    }

    private void onAdFetched(AdProperties adProperties) {
        this.adProperties = adProperties;
        this.adController.render();
    }

    private void onAdRenderMetricsRecorded() {
        this.metricsCollector.startMetric(Metrics.MetricType.AD_LOADED_TO_AD_SHOW_TIME);
        this.adController.fireSDKEvent(new SDKEvent(SDKEvent.SDKEventType.PLACED));
    }

    private void onAdRendered() {
        this.hostedViewGroup.addView(this.adController.getView());
        this.setRenderedViewClickable(false);
        this.adListenerExecutor.onAdLoaded(this, this.adProperties);
    }

    private void setRenderedViewClickable(boolean bl) {
        this.adController.setAllowClicks(bl);
    }

    private void submitMetrics() {
        if (!this.adController.getMetricsCollector().isMetricsCollectorEmpty()) {
            this.adController.submitAndResetMetrics();
        }
    }

    public void adHidden() {
        AdState adState = this.adController.getAdState();
        if (adState.equals((Object)AdState.HIDDEN)) {
            this.logger.d("The ad is already hidden from view.");
            return;
        }
        if (adState.equals((Object)AdState.SHOWING)) {
            this.adController.getMetricsCollector().stopMetric(Metrics.MetricType.AD_SHOW_DURATION);
            this.setRenderedViewClickable(false);
            this.adController.adHidden();
            return;
        }
        this.logger.w("The ad must be shown before it can be hidden.");
    }

    public boolean adShown() {
        AdState adState = this.adController.getAdState();
        if (!(this.previousAdExpired.get() || !adState.equals((Object)AdState.HIDDEN) && this.adController.isExpired())) {
            Position position;
            if (adState.equals((Object)AdState.LOADING)) {
                this.logger.w("The adShown call failed because the ad cannot be shown until it has completed loading.");
                return false;
            }
            if (adState.equals((Object)AdState.SHOWING)) {
                this.logger.w("The adShown call failed because adShown was previously called on this ad.");
                return false;
            }
            if (!adState.equals((Object)AdState.RENDERED) && !adState.equals((Object)AdState.HIDDEN)) {
                this.logger.w("The adShown call failed because the ad is not in a state to be shown. The ad is currently in the %s state.", new Object[]{adState});
                return false;
            }
            if (adState.equals((Object)AdState.RENDERED)) {
                this.metricsCollector.stopMetric(Metrics.MetricType.AD_LOADED_TO_AD_SHOW_TIME);
            }
            if ((position = this.adController.getAdPosition()) != null) {
                Size size = position.getSize();
                Size size2 = this.adController.getScreenSize();
                if (this.doesAdSizeHaveOneSideWithAtLeastMinPixels(size) && this.isAdOnScreen(position, size2) && this.doesAdSizeMeetRequiredScreenPercentage(size, size2)) {
                    this.checkIfAdAspectRatioLessThanScreenAspectRatio(size, size2);
                    if (this.adController.getAdState().equals((Object)AdState.HIDDEN)) {
                        this.metricsCollector.incrementMetric(Metrics.MetricType.AD_COUNTER_RESHOWN);
                    }
                    this.setRenderedViewClickable(true);
                    this.adController.adShown();
                    this.metricsCollector.startMetric(Metrics.MetricType.AD_SHOW_DURATION);
                    return true;
                }
                this.metricsCollector.incrementMetric(Metrics.MetricType.RENDER_REQUIREMENT_CHECK_FAILURE);
                return false;
            }
        } else {
            this.logger.e("The ad is unable to be shown because it has expired.");
            this.metricsCollector.stopMetric(Metrics.MetricType.AD_LOADED_TO_AD_SHOW_TIME);
            this.metricsCollector.incrementMetric(Metrics.MetricType.EXPIRED_AD_CALL);
        }
        return false;
    }

    public void destroy() {
        this.logger.d("Destroying the Modeless Interstitial Ad");
        if (this.adController.getAdState().equals((Object)AdState.SHOWING)) {
            this.adHidden();
        }
        this.submitMetrics();
        this.adController.destroy();
    }

    @Override
    public int getTimeout() {
        return this.timeout;
    }

    @Override
    public boolean isLoading() {
        AdState adState = this.adController.getAdState();
        return adState.equals((Object)AdState.LOADING) || adState.equals((Object)AdState.LOADED) || adState.equals((Object)AdState.RENDERING);
        {
        }
    }

    public boolean isReady() {
        return this.adController.getAdState().equals((Object)AdState.RENDERED) && !this.adController.isExpired();
    }

    @Override
    public boolean loadAd() {
        return this.loadAd(null);
    }

    @Override
    public boolean loadAd(AdTargetingOptions adTargetingOptions) {
        if (!this.isReadyToLoad()) {
            switch (1.$SwitchMap$com$amazon$device$ads$AdState[this.adController.getAdState().ordinal()]) {
                default: {
                    break;
                }
                case 6: {
                    this.logger.e("The modeless interstitial ad has been destroyed. Please create a new ModelessInterstitialAd.");
                    break;
                }
                case 5: {
                    if (this.adController.isExpired()) {
                        this.adController.resetToReady();
                        return this.loadAd(adTargetingOptions);
                    }
                    this.logger.e("The modeless interstitial ad could not be loaded because of an unknown issue with the web views.");
                    break;
                }
                case 4: {
                    this.logger.w("The modeless interstitial ad has already been loaded. Please call adShown once the ad is shown.");
                    break;
                }
                case 1: 
                case 2: 
                case 3: {
                    this.logger.w("The modeless interstitial ad is already loading. Please wait for the loading operation to complete.");
                }
            }
            this.metricsCollector.incrementMetric(Metrics.MetricType.AD_LOAD_FAILED);
            return false;
        }
        this.previousAdExpired.set(false);
        AdTargetingOptions adTargetingOptions2 = adTargetingOptions == null ? new AdTargetingOptions() : adTargetingOptions.copy();
        adTargetingOptions2.addInternalPublisherKeyword(PUBLISHER_KEYWORD);
        this.submitMetrics();
        AdLoadStarter adLoadStarter = this.adLoadStarter;
        int n2 = this.timeout;
        AdSlot[] arradSlot = new AdSlot[]{new AdSlot(this.adController, adTargetingOptions2)};
        adLoadStarter.loadAds(n2, adTargetingOptions2, arradSlot);
        return this.adController.getAndResetIsPrepared();
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

    private class ModelessInterstitialAdControlCallback
    implements AdControlCallback {
        private ModelessInterstitialAdControlCallback() {
        }

        @Override
        public int adClosing() {
            return 2;
        }

        @Override
        public boolean isAdReady(boolean bl) {
            return ModelessInterstitialAd.this.isReadyToLoad();
        }

        @Override
        public void onAdEvent(AdEvent adEvent) {
        }

        @Override
        public void onAdExpired() {
            ModelessInterstitialAd.this.onAdExpired();
        }

        @Override
        public void onAdFailed(AdError adError) {
            ModelessInterstitialAd.this.onAdFailedToLoadOrRender(adError);
        }

        @Override
        public void onAdLoaded(AdProperties adProperties) {
            ModelessInterstitialAd.this.onAdFetched(adProperties);
        }

        @Override
        public void onAdRendered() {
            ModelessInterstitialAd.this.onAdRendered();
        }

        @Override
        public void postAdRendered() {
            ModelessInterstitialAd.this.onAdRenderMetricsRecorded();
        }
    }

}

