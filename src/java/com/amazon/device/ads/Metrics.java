/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdMetrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.WebRequest;

class Metrics {
    private static final String LOGTAG = "Metrics";
    private static final boolean TYPED_METRIC = true;
    private static Metrics instance = new Metrics();
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
    private MetricsCollector metricsCollector = new MetricsCollector();

    Metrics() {
    }

    public static Metrics getInstance() {
        return instance;
    }

    private MobileAdsLogger getLogger() {
        return this.logger;
    }

    private void sendMetrics(final WebRequest webRequest) {
        ThreadUtils.scheduleRunnable(new Runnable(){

            public void run() {
                webRequest.enableLog(true);
                try {
                    webRequest.makeCall();
                    return;
                }
                catch (WebRequest.WebRequestException webRequestException) {
                    int n = 2.$SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus[webRequestException.getStatus().ordinal()];
                    if (n != 1) {
                        if (n != 2) {
                            if (n != 3) {
                                if (n != 4) {
                                    return;
                                }
                            } else {
                                MobileAdsLogger mobileAdsLogger = Metrics.this.getLogger();
                                Object[] arrobject = new Object[]{webRequestException.getMessage()};
                                mobileAdsLogger.e("Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s", arrobject);
                            }
                            MobileAdsLogger mobileAdsLogger = Metrics.this.getLogger();
                            Object[] arrobject = new Object[]{webRequestException.getMessage()};
                            mobileAdsLogger.e("Unable to submit metrics for ad because of unsupported character encoding, msg: %s", arrobject);
                            return;
                        }
                        MobileAdsLogger mobileAdsLogger = Metrics.this.getLogger();
                        Object[] arrobject = new Object[]{webRequestException.getMessage()};
                        mobileAdsLogger.e("Unable to submit metrics for ad due to Network Failure, msg: %s", arrobject);
                        return;
                    }
                    MobileAdsLogger mobileAdsLogger = Metrics.this.getLogger();
                    Object[] arrobject = new Object[]{webRequestException.getMessage()};
                    mobileAdsLogger.e("Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s", arrobject);
                    return;
                }
            }
        });
    }

    public MetricsCollector getMetricsCollector() {
        return this.metricsCollector;
    }

    public void submitAndResetMetrics(MetricsSubmitter metricsSubmitter) {
        this.getLogger().d("METRIC Submit and Reset");
        AdMetrics adMetrics = new AdMetrics(metricsSubmitter);
        if (adMetrics.canSubmit()) {
            MetricsCollector metricsCollector = this.metricsCollector;
            this.metricsCollector = new MetricsCollector();
            adMetrics.addGlobalMetrics(metricsCollector);
            this.sendMetrics(adMetrics.getAaxWebRequestAndResetAdMetrics());
            return;
        }
        metricsSubmitter.resetMetricsCollector();
    }

    static final class MetricType
    extends Enum<MetricType> {
        private static final /* synthetic */ MetricType[] $VALUES;
        public static final /* enum */ MetricType AAX_CONFIG_DOWNLOAD_FAILED;
        public static final /* enum */ MetricType AAX_CONFIG_DOWNLOAD_LATENCY;
        public static final /* enum */ MetricType AAX_LATENCY_GET_AD;
        public static final /* enum */ MetricType ADLAYOUT_HEIGHT_ZERO;
        public static final /* enum */ MetricType AD_ASPECT_RATIO_LESS_THAN_SCREEN_ASPECT_RATIO;
        public static final /* enum */ MetricType AD_COUNTER_AUTO_AD_SIZE;
        public static final /* enum */ MetricType AD_COUNTER_FAILED_DUE_TO_NO_RETRY;
        public static final /* enum */ MetricType AD_COUNTER_IDENTIFIED_DEVICE;
        public static final /* enum */ MetricType AD_COUNTER_PARENT_VIEW_MISSING;
        public static final /* enum */ MetricType AD_COUNTER_RENDERING_FATAL;
        public static final /* enum */ MetricType AD_COUNTER_RESHOWN;
        public static final /* enum */ MetricType AD_EXPIRED_BEFORE_SHOWING;
        public static final /* enum */ MetricType AD_FAILED_INVALID_AUTO_AD_SIZE;
        public static final /* enum */ MetricType AD_FAILED_LAYOUT_NOT_RUN;
        public static final /* enum */ MetricType AD_FAILED_NULL_LAYOUT_PARAMS;
        public static final /* enum */ MetricType AD_FAILED_UNKNOWN_WEBVIEW_ISSUE;
        public static final /* enum */ MetricType AD_IS_INTERSTITIAL;
        public static final /* enum */ MetricType AD_LATENCY_RENDER;
        public static final /* enum */ MetricType AD_LATENCY_RENDER_FAILED;
        public static final /* enum */ MetricType AD_LATENCY_TOTAL;
        public static final /* enum */ MetricType AD_LATENCY_TOTAL_FAILURE;
        public static final /* enum */ MetricType AD_LATENCY_TOTAL_SUCCESS;
        public static final /* enum */ MetricType AD_LAYOUT_INITIALIZATION;
        public static final /* enum */ MetricType AD_LOADED_TO_AD_SHOW_TIME;
        public static final /* enum */ MetricType AD_LOAD_FAILED;
        public static final /* enum */ MetricType AD_LOAD_FAILED_INTERNAL_ERROR;
        public static final /* enum */ MetricType AD_LOAD_FAILED_NETWORK_TIMEOUT;
        public static final /* enum */ MetricType AD_LOAD_FAILED_NO_FILL;
        public static final /* enum */ MetricType AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT;
        public static final /* enum */ MetricType AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT;
        public static final /* enum */ MetricType AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END;
        public static final /* enum */ MetricType AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL;
        public static final /* enum */ MetricType AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP;
        public static final /* enum */ MetricType AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START;
        public static final /* enum */ MetricType AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP;
        public static final /* enum */ MetricType AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE;
        public static final /* enum */ MetricType AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START;
        public static final /* enum */ MetricType AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START;
        public static final /* enum */ MetricType AD_NO_RETRY_TTL_RECEIVED;
        public static final /* enum */ MetricType AD_SHOW_DURATION;
        public static final /* enum */ MetricType AD_SHOW_LATENCY;
        public static final /* enum */ MetricType APP_INFO_LABEL_INDEX_OUT_OF_BOUNDS;
        public static final /* enum */ MetricType ASSETS_CREATED_LATENCY;
        public static final /* enum */ MetricType ASSETS_ENSURED_LATENCY;
        public static final /* enum */ MetricType ASSETS_FAILED;
        public static final /* enum */ MetricType CARRIER_NAME;
        public static final /* enum */ MetricType CDN_JAVASCRIPT_DOWLOAD_LATENCY;
        public static final /* enum */ MetricType CDN_JAVASCRIPT_DOWNLOAD_FAILED;
        public static final /* enum */ MetricType CONFIG_DOWNLOAD_ERROR;
        public static final /* enum */ MetricType CONFIG_DOWNLOAD_LATENCY;
        public static final /* enum */ MetricType CONFIG_PARSE_ERROR;
        public static final /* enum */ MetricType CONNECTION_TYPE;
        public static final /* enum */ MetricType CUSTOM_RENDER_HANDLED;
        public static final /* enum */ MetricType EXPIRED_AD_CALL;
        public static final /* enum */ MetricType INTERSTITIAL_AD_ACTIVITY_FAILED;
        public static final /* enum */ MetricType RENDER_REQUIREMENT_CHECK_FAILURE;
        public static final /* enum */ MetricType SET_ORIENTATION_FAILURE;
        public static final /* enum */ MetricType SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED;
        public static final /* enum */ MetricType SIS_LATENCY_REGISTER;
        public static final /* enum */ MetricType SIS_LATENCY_REGISTER_EVENT;
        public static final /* enum */ MetricType SIS_LATENCY_UPDATE_DEVICE_INFO;
        public static final /* enum */ MetricType TLS_ENABLED;
        public static final /* enum */ MetricType VIEWPORT_SCALE;
        public static final /* enum */ MetricType WIFI_PRESENT;
        private final String aaxName;
        private final boolean isAdTypeSpecific;

        static {
            AD_LATENCY_TOTAL = new MetricType("tl", true);
            AD_LATENCY_TOTAL_SUCCESS = new MetricType("tsl", true);
            AD_LATENCY_TOTAL_FAILURE = new MetricType("tfl", true);
            AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START = new MetricType("llfsl", true);
            AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP = new MetricType("lfsul");
            AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START = new MetricType("lfsasl");
            AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END = new MetricType("laefel");
            AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP = new MetricType("lffsul");
            AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START = new MetricType("lffsrsl", true);
            AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE = new MetricType("lffsfl", true);
            AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL = new MetricType("lcaul");
            ASSETS_CREATED_LATENCY = new MetricType("lacl");
            ASSETS_ENSURED_LATENCY = new MetricType("lael");
            ASSETS_FAILED = new MetricType("af");
            AD_LOADED_TO_AD_SHOW_TIME = new MetricType("alast");
            AD_SHOW_LATENCY = new MetricType("lsa");
            AD_SHOW_DURATION = new MetricType("sd", true);
            AD_LAYOUT_INITIALIZATION = new MetricType("ali");
            AAX_LATENCY_GET_AD = new MetricType("al");
            AD_LOAD_FAILED = new MetricType("lf");
            AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT = new MetricType("lfat");
            AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT = new MetricType("lfpt", true);
            AD_LOAD_FAILED_NO_FILL = new MetricType("lfnf");
            AD_LOAD_FAILED_NETWORK_TIMEOUT = new MetricType("lfnt");
            AD_LOAD_FAILED_INTERNAL_ERROR = new MetricType("lfie");
            AD_COUNTER_IDENTIFIED_DEVICE = new MetricType("id");
            AD_COUNTER_RENDERING_FATAL = new MetricType("rf", true);
            AD_LATENCY_RENDER = new MetricType("rl", true);
            AD_LATENCY_RENDER_FAILED = new MetricType("rlf", true);
            AD_COUNTER_FAILED_DUE_TO_NO_RETRY = new MetricType("nrtf");
            AD_NO_RETRY_TTL_RECEIVED = new MetricType("nrtr");
            AD_COUNTER_AUTO_AD_SIZE = new MetricType("aas");
            AD_COUNTER_PARENT_VIEW_MISSING = new MetricType("pvm");
            ADLAYOUT_HEIGHT_ZERO = new MetricType("ahz");
            VIEWPORT_SCALE = new MetricType("vs");
            AD_COUNTER_RESHOWN = new MetricType("rs", true);
            AD_FAILED_UNKNOWN_WEBVIEW_ISSUE = new MetricType("fuwi");
            AD_FAILED_NULL_LAYOUT_PARAMS = new MetricType("fnlp");
            AD_FAILED_LAYOUT_NOT_RUN = new MetricType("flnr");
            AD_FAILED_INVALID_AUTO_AD_SIZE = new MetricType("faas");
            SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED = new MetricType("sid");
            SIS_LATENCY_REGISTER = new MetricType("srl");
            SIS_LATENCY_UPDATE_DEVICE_INFO = new MetricType("sul");
            SIS_LATENCY_REGISTER_EVENT = new MetricType("srel");
            CONFIG_DOWNLOAD_ERROR = new MetricType("cde");
            CONFIG_DOWNLOAD_LATENCY = new MetricType("cdt");
            CONFIG_PARSE_ERROR = new MetricType("cpe");
            AAX_CONFIG_DOWNLOAD_LATENCY = new MetricType("acl");
            AAX_CONFIG_DOWNLOAD_FAILED = new MetricType("acf");
            CUSTOM_RENDER_HANDLED = new MetricType("crh");
            TLS_ENABLED = new MetricType("tls");
            WIFI_PRESENT = new MetricType("wifi");
            CARRIER_NAME = new MetricType("car");
            CONNECTION_TYPE = new MetricType("ct");
            AD_IS_INTERSTITIAL = new MetricType("i");
            INTERSTITIAL_AD_ACTIVITY_FAILED = new MetricType("iaaf");
            RENDER_REQUIREMENT_CHECK_FAILURE = new MetricType("rrcfc", true);
            EXPIRED_AD_CALL = new MetricType("eac", true);
            AD_ASPECT_RATIO_LESS_THAN_SCREEN_ASPECT_RATIO = new MetricType("rarfc", true);
            SET_ORIENTATION_FAILURE = new MetricType("rsofc", true);
            AD_EXPIRED_BEFORE_SHOWING = new MetricType("aebs", true);
            CDN_JAVASCRIPT_DOWLOAD_LATENCY = new MetricType("cjdl");
            CDN_JAVASCRIPT_DOWNLOAD_FAILED = new MetricType("cjdf");
            APP_INFO_LABEL_INDEX_OUT_OF_BOUNDS = new MetricType("ailioob");
            MetricType[] arrmetricType = new MetricType[]{AD_LATENCY_TOTAL, AD_LATENCY_TOTAL_SUCCESS, AD_LATENCY_TOTAL_FAILURE, AD_LOAD_LATENCY_LOADAD_TO_FETCH_THREAD_REQUEST_START, AD_LOAD_LATENCY_FETCH_THREAD_SPIN_UP, AD_LOAD_LATENCY_FETCH_THREAD_START_TO_AAX_GET_AD_START, AD_LOAD_LATENCY_AAX_GET_AD_END_TO_FETCH_THREAD_END, AD_LOAD_LATENCY_FINALIZE_FETCH_SPIN_UP, AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_RENDER_START, AD_LOAD_LATENCY_FINALIZE_FETCH_START_TO_FAILURE, AD_LOAD_LATENCY_CREATE_AAX_GET_AD_URL, ASSETS_CREATED_LATENCY, ASSETS_ENSURED_LATENCY, ASSETS_FAILED, AD_LOADED_TO_AD_SHOW_TIME, AD_SHOW_LATENCY, AD_SHOW_DURATION, AD_LAYOUT_INITIALIZATION, AAX_LATENCY_GET_AD, AD_LOAD_FAILED, AD_LOAD_FAILED_ON_AAX_CALL_TIMEOUT, AD_LOAD_FAILED_ON_PRERENDERING_TIMEOUT, AD_LOAD_FAILED_NO_FILL, AD_LOAD_FAILED_NETWORK_TIMEOUT, AD_LOAD_FAILED_INTERNAL_ERROR, AD_COUNTER_IDENTIFIED_DEVICE, AD_COUNTER_RENDERING_FATAL, AD_LATENCY_RENDER, AD_LATENCY_RENDER_FAILED, AD_COUNTER_FAILED_DUE_TO_NO_RETRY, AD_NO_RETRY_TTL_RECEIVED, AD_COUNTER_AUTO_AD_SIZE, AD_COUNTER_PARENT_VIEW_MISSING, ADLAYOUT_HEIGHT_ZERO, VIEWPORT_SCALE, AD_COUNTER_RESHOWN, AD_FAILED_UNKNOWN_WEBVIEW_ISSUE, AD_FAILED_NULL_LAYOUT_PARAMS, AD_FAILED_LAYOUT_NOT_RUN, AD_FAILED_INVALID_AUTO_AD_SIZE, SIS_COUNTER_IDENTIFIED_DEVICE_CHANGED, SIS_LATENCY_REGISTER, SIS_LATENCY_UPDATE_DEVICE_INFO, SIS_LATENCY_REGISTER_EVENT, CONFIG_DOWNLOAD_ERROR, CONFIG_DOWNLOAD_LATENCY, CONFIG_PARSE_ERROR, AAX_CONFIG_DOWNLOAD_LATENCY, AAX_CONFIG_DOWNLOAD_FAILED, CUSTOM_RENDER_HANDLED, TLS_ENABLED, WIFI_PRESENT, CARRIER_NAME, CONNECTION_TYPE, AD_IS_INTERSTITIAL, INTERSTITIAL_AD_ACTIVITY_FAILED, RENDER_REQUIREMENT_CHECK_FAILURE, EXPIRED_AD_CALL, AD_ASPECT_RATIO_LESS_THAN_SCREEN_ASPECT_RATIO, SET_ORIENTATION_FAILURE, AD_EXPIRED_BEFORE_SHOWING, CDN_JAVASCRIPT_DOWLOAD_LATENCY, CDN_JAVASCRIPT_DOWNLOAD_FAILED, APP_INFO_LABEL_INDEX_OUT_OF_BOUNDS};
            $VALUES = arrmetricType;
        }

        private MetricType(String string2) {
            this(string2, false);
        }

        private MetricType(String string2, boolean bl) {
            this.aaxName = string2;
            this.isAdTypeSpecific = bl;
        }

        public static MetricType valueOf(String string) {
            return (MetricType)Enum.valueOf(MetricType.class, (String)string);
        }

        public static MetricType[] values() {
            return (MetricType[])$VALUES.clone();
        }

        public String getAaxName() {
            return this.aaxName;
        }

        public boolean isAdTypeSpecific() {
            return this.isAdTypeSpecific;
        }
    }

    static interface MetricsSubmitter {
        public String getInstrumentationPixelUrl();

        public MetricsCollector getMetricsCollector();

        public void resetMetricsCollector();
    }

}

