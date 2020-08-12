/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.PermissionChecker;
import com.amazon.device.ads.ResponseReader;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebRequest;

class ViewabilityJavascriptFetcher {
    private static final String CDN_URL = "https://dwxjayoxbnyrr.cloudfront.net/amazon-ads.viewablejs";
    private static final String LOGTAG = "ViewabilityJavascriptFetcher";
    private static ViewabilityJavascriptFetcher instance = new ViewabilityJavascriptFetcher();
    private final Configuration configuration;
    private int currentJSVersion;
    private final DebugProperties debugProperties;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLogger logger;
    private final Metrics metrics;
    private final PermissionChecker permissionChecker;
    private final Settings settings;
    private final ThreadUtils.ThreadRunner threadRunner;
    private final WebRequest.WebRequestFactory webRequestFactory;

    protected ViewabilityJavascriptFetcher() {
        this(new MobileAdsLoggerFactory(), new PermissionChecker(), DebugProperties.getInstance(), Settings.getInstance(), new WebRequest.WebRequestFactory(), Metrics.getInstance(), ThreadUtils.getThreadRunner(), MobileAdsInfoStore.getInstance(), Configuration.getInstance());
    }

    ViewabilityJavascriptFetcher(MobileAdsLoggerFactory mobileAdsLoggerFactory, PermissionChecker permissionChecker, DebugProperties debugProperties, Settings settings, WebRequest.WebRequestFactory webRequestFactory, Metrics metrics, ThreadUtils.ThreadRunner threadRunner, MobileAdsInfoStore mobileAdsInfoStore, Configuration configuration) {
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.permissionChecker = permissionChecker;
        this.debugProperties = debugProperties;
        this.settings = settings;
        this.webRequestFactory = webRequestFactory;
        this.metrics = metrics;
        this.threadRunner = threadRunner;
        this.infoStore = mobileAdsInfoStore;
        this.configuration = configuration;
    }

    public static final ViewabilityJavascriptFetcher getInstance() {
        return instance;
    }

    private void onFetchFailure() {
        this.metrics.getMetricsCollector().incrementMetric(Metrics.MetricType.CDN_JAVASCRIPT_DOWNLOAD_FAILED);
        this.logger.w("Viewability Javascript fetch failed");
    }

    private boolean shouldFetch() {
        this.currentJSVersion = this.configuration.getInt(Configuration.ConfigOption.VIEWABLE_JS_VERSION_CONFIG);
        if (this.settings.getInt("viewableJSVersionStored", -1) < this.currentJSVersion) {
            return true;
        }
        return StringUtils.isNullOrEmpty(this.settings.getString("viewableJSSettingsNameAmazonAdSDK", null));
    }

    protected void beginFetch() {
        this.threadRunner.execute(new Runnable(){

            public void run() {
                ViewabilityJavascriptFetcher.this.fetchJavascriptFromURLOnBackgroundThread();
            }
        }, ThreadUtils.ExecutionStyle.SCHEDULE, ThreadUtils.ExecutionThread.BACKGROUND_THREAD);
    }

    protected WebRequest createWebRequest() {
        WebRequest webRequest = this.webRequestFactory.createWebRequest();
        webRequest.setExternalLogTag(LOGTAG);
        webRequest.enableLog(true);
        webRequest.setUrlString(this.configuration.getStringWithDefault(Configuration.ConfigOption.VIEWABLE_JAVASCRIPT_URL, CDN_URL));
        webRequest.setMetricsCollector(this.metrics.getMetricsCollector());
        webRequest.setServiceCallLatencyMetric(Metrics.MetricType.CDN_JAVASCRIPT_DOWLOAD_LATENCY);
        webRequest.setUseSecure(this.debugProperties.getDebugPropertyAsBoolean("debug.aaxConfigUseSecure", true));
        return webRequest;
    }

    public void fetchJavascript() {
        if (this.shouldFetch()) {
            this.beginFetch();
        }
    }

    public void fetchJavascriptFromURLOnBackgroundThread() {
        WebRequest.WebResponse webResponse;
        this.logger.d("In ViewabilityJavascriptFetcher background thread");
        if (!this.permissionChecker.hasInternetPermission(this.infoStore.getApplicationContext())) {
            this.logger.e("Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
            this.onFetchFailure();
            return;
        }
        WebRequest webRequest = this.createWebRequest();
        if (webRequest == null) {
            this.onFetchFailure();
            return;
        }
        try {
            webResponse = webRequest.makeCall();
        }
        catch (WebRequest.WebRequestException webRequestException) {
            this.onFetchFailure();
            return;
        }
        String string = webResponse.getResponseReader().readAsString();
        this.settings.putString("viewableJSSettingsNameAmazonAdSDK", string);
        this.settings.putInt("viewableJSVersionStored", this.currentJSVersion);
        this.logger.d("Viewability Javascript fetched and saved");
    }

}

