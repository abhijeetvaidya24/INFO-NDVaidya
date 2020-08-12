/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalFocusChangeListener
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.view.ViewTreeObserver$OnWindowFocusChangeListener
 *  com.amazon.device.ads.AdContainer
 *  com.amazon.device.ads.AdController
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.concurrent.atomic.AtomicBoolean
 *  java.util.concurrent.atomic.AtomicInteger
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.view.ViewTreeObserver;
import com.amazon.device.ads.AdContainer;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AmazonOnGlobalFocusChangeListenerFactory;
import com.amazon.device.ads.AmazonOnGlobalLayoutListenerFactory;
import com.amazon.device.ads.AmazonOnScrollChangedListenerFactory;
import com.amazon.device.ads.AmazonOnWindowFocusChangeListenerFactory;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.ViewUtils;
import com.amazon.device.ads.ViewabilityChecker;
import com.amazon.device.ads.ViewabilityCheckerFactory;
import com.amazon.device.ads.ViewabilityInfo;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

class ViewabilityObserver {
    public static final String IS_VIEWABLE_KEY = "IS_VIEWABLE";
    private static final String LOGTAG = "ViewabilityObserver";
    private static long VIEWABLE_INTERVAL = 200L;
    public static final String VIEWABLE_PARAMS_KEY = "VIEWABLE_PARAMS";
    private final AdController adController;
    private final Configuration configuration;
    private final DebugProperties debugProperties;
    private boolean firedOnlyOnce = false;
    private final AtomicBoolean isScrollListenerAdded;
    private long lastTimeViewableEventFired = 0L;
    private final MobileAdsLogger logger;
    private boolean observersAdded = false;
    private final ViewTreeObserver.OnGlobalFocusChangeListener onGlobalFocusChangeListener;
    private final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
    private ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener;
    private ViewTreeObserver viewTreeObserver;
    private final ViewUtils viewUtils;
    private final ViewabilityChecker viewabilityChecker;
    private final AtomicInteger viewabilityInterestCount;

    public ViewabilityObserver(AdController adController) {
        this(adController, new ViewabilityCheckerFactory(), new MobileAdsLoggerFactory(), new AmazonOnGlobalFocusChangeListenerFactory(), new AmazonOnGlobalLayoutListenerFactory(), new AmazonOnScrollChangedListenerFactory(), new AmazonOnWindowFocusChangeListenerFactory(), new AtomicInteger(0), new AtomicBoolean(false), new ViewUtils(), DebugProperties.getInstance(), Configuration.getInstance());
    }

    ViewabilityObserver(AdController adController, ViewabilityCheckerFactory viewabilityCheckerFactory, MobileAdsLoggerFactory mobileAdsLoggerFactory, AmazonOnGlobalFocusChangeListenerFactory amazonOnGlobalFocusChangeListenerFactory, AmazonOnGlobalLayoutListenerFactory amazonOnGlobalLayoutListenerFactory, AmazonOnScrollChangedListenerFactory amazonOnScrollChangedListenerFactory, AmazonOnWindowFocusChangeListenerFactory amazonOnWindowFocusChangeListenerFactory, AtomicInteger atomicInteger, AtomicBoolean atomicBoolean, ViewUtils viewUtils, DebugProperties debugProperties, Configuration configuration) {
        this.adController = adController;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.viewabilityChecker = viewabilityCheckerFactory.buildViewabilityChecker(this.adController);
        this.onGlobalFocusChangeListener = amazonOnGlobalFocusChangeListenerFactory.buildAmazonOnGlobalFocusChangedListener(this);
        this.onGlobalLayoutListener = amazonOnGlobalLayoutListenerFactory.buildAmazonOnGlobalLayoutListener(this);
        this.onScrollChangedListener = amazonOnScrollChangedListenerFactory.buildAmazonOnScrollChangedListenerFactory(this);
        if (AndroidTargetUtils.isAtLeastAndroidAPI(18)) {
            this.onWindowFocusChangeListener = amazonOnWindowFocusChangeListenerFactory.buildOnWindowFocusChangeListener(this);
        }
        this.viewabilityInterestCount = atomicInteger;
        this.isScrollListenerAdded = atomicBoolean;
        this.viewUtils = viewUtils;
        this.debugProperties = debugProperties;
        this.configuration = configuration;
        VIEWABLE_INTERVAL = this.debugProperties.getDebugPropertyAsLong("debug.viewableInterval", this.configuration.getLongWithDefault(Configuration.ConfigOption.VIEWABLE_INTERVAL, 200L));
        MobileAdsLogger mobileAdsLogger = this.logger;
        Object[] arrobject = new Object[]{VIEWABLE_INTERVAL};
        mobileAdsLogger.d("Viewable Interval is: %d", arrobject);
    }

    @TargetApi(value=18)
    private void addObserversIfNeeded() {
        if (this.viewTreeObserver == null || !this.isViewTreeObserverAlive() || this.hasViewTreeObserverChanged()) {
            this.viewTreeObserver = this.adController.getAdContainer().getViewTreeObserver();
            this.observersAdded = false;
            this.isScrollListenerAdded.set(false);
            this.firedOnlyOnce = false;
            this.lastTimeViewableEventFired = 0L;
        }
        if (this.viewTreeObserver != null && this.isViewTreeObserverAlive()) {
            if (this.observersAdded) {
                return;
            }
            this.viewTreeObserver.addOnGlobalLayoutListener(this.onGlobalLayoutListener);
            this.viewTreeObserver.addOnGlobalFocusChangeListener(this.onGlobalFocusChangeListener);
            if (AndroidTargetUtils.isAtLeastAndroidAPI(18)) {
                this.viewTreeObserver.addOnWindowFocusChangeListener(this.onWindowFocusChangeListener);
            }
            if (AndroidTargetUtils.isAtLeastAndroidAPI(16)) {
                this.addOnScrollChangedListenerIfNeeded();
            }
            this.observersAdded = true;
            this.fireViewableEvent(false);
        }
    }

    private boolean hasViewTreeObserverChanged() {
        ViewTreeObserver viewTreeObserver = this.adController.getAdContainer().getViewTreeObserver();
        return this.viewTreeObserver != viewTreeObserver;
    }

    private boolean isViewTreeObserverAlive() {
        if (!this.viewTreeObserver.isAlive()) {
            this.logger.w("Root view tree observer is not alive");
            return false;
        }
        return true;
    }

    @TargetApi(value=18)
    private void removeObservers() {
        ViewTreeObserver viewTreeObserver = this.viewTreeObserver;
        if (viewTreeObserver == null) {
            this.logger.w("Root view tree observer is null");
            return;
        }
        if (!this.viewUtils.removeOnGlobalLayoutListener(viewTreeObserver, this.onGlobalLayoutListener)) {
            this.logger.w("Root view tree observer is not alive");
            return;
        }
        this.viewTreeObserver.removeOnScrollChangedListener(this.onScrollChangedListener);
        this.viewTreeObserver.removeOnGlobalFocusChangeListener(this.onGlobalFocusChangeListener);
        if (AndroidTargetUtils.isAtLeastAndroidAPI(18)) {
            this.viewTreeObserver.removeOnWindowFocusChangeListener(this.onWindowFocusChangeListener);
        }
        this.observersAdded = false;
        this.isScrollListenerAdded.set(false);
    }

    protected void addOnScrollChangedListenerIfNeeded() {
        if (!this.isScrollListenerAdded.get()) {
            ViewTreeObserver viewTreeObserver = this.viewTreeObserver;
            if (viewTreeObserver == null || !viewTreeObserver.isAlive() || this.hasViewTreeObserverChanged()) {
                this.viewTreeObserver = this.adController.getAdContainer().getViewTreeObserver();
            }
            this.viewTreeObserver.addOnScrollChangedListener(this.onScrollChangedListener);
            this.isScrollListenerAdded.set(true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void deregisterViewabilityInterest() {
        ViewabilityObserver viewabilityObserver = this;
        synchronized (viewabilityObserver) {
            int n = this.viewabilityInterestCount.decrementAndGet();
            if (n < 0) {
                this.logger.w("No Viewability Interest was previously registered. Ignoring request to deregister.");
                this.viewabilityInterestCount.incrementAndGet();
                return;
            }
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{n};
            mobileAdsLogger.d("Viewability Interest Deregistered. Current number of objects interested in viewability: %d", arrobject);
            if (n == 0) {
                this.removeObservers();
            }
            return;
        }
    }

    public void fireViewableEvent(boolean bl) {
        long l2 = System.currentTimeMillis();
        if (bl && l2 - this.lastTimeViewableEventFired < VIEWABLE_INTERVAL) {
            return;
        }
        this.lastTimeViewableEventFired = l2;
        ViewabilityInfo viewabilityInfo = this.viewabilityChecker.getViewabilityInfo();
        if (viewabilityInfo == null) {
            this.logger.w("Viewable info is null");
            return;
        }
        JSONObject jSONObject = viewabilityInfo.getJsonObject();
        boolean bl2 = viewabilityInfo.isAdOnScreen();
        SDKEvent sDKEvent = new SDKEvent(SDKEvent.SDKEventType.VIEWABLE);
        sDKEvent.setParameter(VIEWABLE_PARAMS_KEY, jSONObject.toString());
        String string = bl2 ? "true" : " false";
        sDKEvent.setParameter(IS_VIEWABLE_KEY, string);
        if (!bl2) {
            if (!this.firedOnlyOnce) {
                this.adController.fireSDKEvent(sDKEvent);
                this.firedOnlyOnce = true;
                return;
            }
        } else {
            this.adController.fireSDKEvent(sDKEvent);
            this.firedOnlyOnce = false;
        }
    }

    public boolean isViewable() {
        ViewabilityInfo viewabilityInfo = this.viewabilityChecker.getViewabilityInfo();
        if (viewabilityInfo == null) {
            this.logger.w("Viewable info is null");
            return false;
        }
        return viewabilityInfo.isAdOnScreen();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerViewabilityInterest() {
        int n = this.viewabilityInterestCount.incrementAndGet();
        MobileAdsLogger mobileAdsLogger = this.logger;
        Object[] arrobject = new Object[]{n};
        mobileAdsLogger.d("Viewability Interest Registered. Current number of objects interested in viewability: %d", arrobject);
        ViewabilityObserver viewabilityObserver = this;
        synchronized (viewabilityObserver) {
            this.addObserversIfNeeded();
            return;
        }
    }
}

