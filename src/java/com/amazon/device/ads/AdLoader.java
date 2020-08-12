/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MetricsCollector$CompositeMetricsCollector
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdRequest;
import com.amazon.device.ads.AdSlot;
import com.amazon.device.ads.Assets;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ResponseReader;
import com.amazon.device.ads.SystemTime;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis.
 */
class AdLoader {
    public static final int AD_FAILED = -1;
    public static final int AD_LOAD_DEFERRED = 1;
    public static final int AD_READY_TO_LOAD = 0;
    public static final String DISABLED_APP_SERVER_MESSAGE = "DISABLED_APP";
    private static final String LOGTAG = "AdLoader";
    private final AdRequest adRequest;
    private final Assets assets;
    private MetricsCollector.CompositeMetricsCollector compositeMetricsCollector;
    private final DebugProperties debugProperties;
    private AdError error;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLogger logger;
    private final Map<Integer, AdSlot> slots;
    private final SystemTime systemTime;
    private final ThreadUtils.ThreadRunner threadRunner;
    private int timeout;

    public AdLoader(AdRequest adRequest, Map<Integer, AdSlot> map) {
        this(adRequest, map, ThreadUtils.getThreadRunner(), new SystemTime(), Assets.getInstance(), MobileAdsInfoStore.getInstance(), new MobileAdsLoggerFactory(), DebugProperties.getInstance());
    }

    AdLoader(AdRequest adRequest, Map<Integer, AdSlot> map, ThreadUtils.ThreadRunner threadRunner, SystemTime systemTime, Assets assets, MobileAdsInfoStore mobileAdsInfoStore, MobileAdsLoggerFactory mobileAdsLoggerFactory, DebugProperties debugProperties) {
        this.timeout = 20000;
        this.error = null;
        this.compositeMetricsCollector = null;
        this.adRequest = adRequest;
        this.slots = map;
        this.threadRunner = threadRunner;
        this.systemTime = systemTime;
        this.assets = assets;
        this.infoStore = mobileAdsInfoStore;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.debugProperties = debugProperties;
    }

    private void beginFinalizeFetchAd() {
        this.threadRunner.execute(new Runnable(){

            public void run() {
                AdLoader.this.finalizeFetchAd();
            }
        }, ThreadUtils.ExecutionStyle.SCHEDULE, ThreadUtils.ExecutionThread.MAIN_THREAD);
    }

    private WebRequest getAdRequest() throws AdFetchException {
        this.getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL);
        WebRequest webRequest = this.adRequest.getWebRequest();
        this.getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL);
        return webRequest;
    }

    private MetricsCollector getCompositeMetricsCollector() {
        if (this.compositeMetricsCollector == null) {
            ArrayList arrayList = new ArrayList();
            Iterator iterator = this.slots.entrySet().iterator();
            while (iterator.hasNext()) {
                arrayList.add((Object)((AdSlot)((Map.Entry)iterator.next()).getValue()).getMetricsCollector());
            }
            this.compositeMetricsCollector = new /* Unavailable Anonymous Inner Class!! */;
        }
        return this.compositeMetricsCollector;
    }

    /*
     * Exception decompiling
     */
    private void parseResponse(JSONObject var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl270 : ILOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    private void setErrorForAllSlots(AdError adError) {
        Iterator iterator = this.slots.values().iterator();
        while (iterator.hasNext()) {
            ((AdSlot)iterator.next()).setAdError(adError);
        }
    }

    public void beginFetchAd() {
        this.getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START);
        this.getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP);
        this.startFetchAdThread();
    }

    protected void fetchAd() {
        WebRequest.WebResponse webResponse;
        this.getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP);
        this.getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START);
        if (!this.assets.ensureAssetsCreated()) {
            this.error = new AdError(AdError.ErrorCode.REQUEST_ERROR, "Unable to create the assets needed to display ads");
            this.logger.e("Unable to create the assets needed to display ads");
            this.setErrorForAllSlots(this.error);
            return;
        }
        try {
            webResponse = this.fetchResponseFromNetwork();
        }
        catch (AdFetchException adFetchException) {
            this.error = adFetchException.getAdError();
            this.logger.e(adFetchException.getAdError().getMessage());
            this.setErrorForAllSlots(this.error);
            return;
        }
        if (!webResponse.isHttpStatusCodeOK()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(webResponse.getHttpStatusCode());
            stringBuilder.append(" - ");
            stringBuilder.append(webResponse.getHttpStatus());
            String string = stringBuilder.toString();
            this.error = new AdError(AdError.ErrorCode.NETWORK_ERROR, string);
            this.logger.e(string);
            this.setErrorForAllSlots(this.error);
            return;
        }
        JSONObject jSONObject = webResponse.getResponseReader().readAsJSON();
        if (jSONObject == null) {
            this.error = new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Unable to parse response");
            this.logger.e("Unable to parse response");
            this.setErrorForAllSlots(this.error);
            return;
        }
        this.parseResponse(jSONObject);
        this.getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END);
        this.getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP);
    }

    protected WebRequest.WebResponse fetchResponseFromNetwork() throws AdFetchException {
        WebRequest.WebResponse webResponse;
        WebRequest webRequest = this.getAdRequest();
        webRequest.setMetricsCollector(this.getCompositeMetricsCollector());
        webRequest.setServiceCallLatencyMetric(Metrics.MetricType.AAX_LATENCY_GET_AD);
        webRequest.setTimeout(this.timeout);
        webRequest.setDisconnectEnabled(false);
        this.getCompositeMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START);
        this.getCompositeMetricsCollector().incrementMetric(Metrics.MetricType.TLS_ENABLED);
        try {
            webResponse = webRequest.makeCall();
        }
        catch (WebRequest.WebRequestException webRequestException) {
            AdError adError = webRequestException.getStatus() != WebRequest.WebRequestStatus.NETWORK_FAILURE ? (webRequestException.getStatus() == WebRequest.WebRequestStatus.NETWORK_TIMEOUT ? new AdError(AdError.ErrorCode.NETWORK_TIMEOUT, "Connection to Ad Server timed out") : new AdError(AdError.ErrorCode.INTERNAL_ERROR, webRequestException.getMessage())) : new AdError(AdError.ErrorCode.NETWORK_ERROR, "Could not contact Ad Server");
            throw new AdFetchException(adError);
        }
        this.getCompositeMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END);
        return webResponse;
    }

    protected void finalizeFetchAd() {
        Iterator iterator = this.slots.entrySet().iterator();
        while (iterator.hasNext()) {
            AdSlot adSlot = (AdSlot)((Map.Entry)iterator.next()).getValue();
            if (!adSlot.canBeUsed()) {
                this.logger.w("Ad object was destroyed before ad fetching could be finalized. Ad fetching has been aborted.");
                continue;
            }
            adSlot.getMetricsCollector().stopMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP);
            if (!adSlot.isFetched()) {
                adSlot.getMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE);
                if (adSlot.getAdError() != null) {
                    adSlot.adFailed(adSlot.getAdError());
                    continue;
                }
                adSlot.adFailed(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "Unknown error occurred."));
                continue;
            }
            adSlot.getMetricsCollector().startMetric(Metrics.MetricType.AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START);
            adSlot.initializeAd();
        }
    }

    protected AdError getAdError(JSONObject jSONObject) {
        int n = this.retrieveNoRetryTtlSeconds(jSONObject);
        this.infoStore.setNoRetryTtl(n);
        String string = JSONUtils.getStringFromJSON(jSONObject, "errorMessage", "No Ad Received");
        this.infoStore.setIsAppDisabled(string.equalsIgnoreCase(DISABLED_APP_SERVER_MESSAGE));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Server Message: ");
        stringBuilder.append(string);
        String string2 = stringBuilder.toString();
        if (n > 0) {
            this.getCompositeMetricsCollector().publishMetricInMilliseconds(Metrics.MetricType.AD_NO_RETRY_TTL_RECEIVED, n * 1000);
        }
        if (n > 0 && !this.infoStore.getIsAppDisabled()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string2);
            stringBuilder2.append(". Try again in ");
            stringBuilder2.append(n);
            stringBuilder2.append(" seconds");
            String string3 = stringBuilder2.toString();
            return new AdError(AdError.ErrorCode.NO_FILL, string3);
        }
        if (string.equals((Object)"no results")) {
            return new AdError(AdError.ErrorCode.NO_FILL, string2);
        }
        return new AdError(AdError.ErrorCode.INTERNAL_ERROR, string2);
    }

    protected int retrieveNoRetryTtlSeconds(JSONObject jSONObject) {
        int n = JSONUtils.getIntegerFromJSON(jSONObject, "noretryTTL", 0);
        return this.debugProperties.getDebugPropertyAsInteger("debug.noRetryTTL", n);
    }

    public void setTimeout(int n) {
        this.timeout = n;
    }

    protected void startFetchAdThread() {
        this.threadRunner.execute(new Runnable(){

            public void run() {
                AdLoader.this.fetchAd();
                AdLoader.this.beginFinalizeFetchAd();
            }
        }, ThreadUtils.ExecutionStyle.SCHEDULE, ThreadUtils.ExecutionThread.BACKGROUND_THREAD);
    }

    protected class AdFetchException
    extends Exception {
        private static final long serialVersionUID = 1L;
        private final AdError adError;

        public AdFetchException(AdError adError) {
            this.adError = adError;
        }

        public AdFetchException(AdError adError, Throwable throwable) {
            super(throwable);
            this.adError = adError;
        }

        public AdError getAdError() {
            return this.adError;
        }
    }

    protected static class AdLoaderFactory {
        protected AdLoaderFactory() {
        }

        public AdLoader createAdLoader(AdRequest adRequest, Map<Integer, AdSlot> map) {
            return new AdLoader(adRequest, map);
        }
    }

}

