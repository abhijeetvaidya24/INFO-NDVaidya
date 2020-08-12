/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MetricsCollector$MetricHitIncrement
 *  com.amazon.device.ads.MetricsCollector$MetricHitStartTime
 *  com.amazon.device.ads.MetricsCollector$MetricHitStopTime
 *  com.amazon.device.ads.MetricsCollector$MetricHitString
 *  com.amazon.device.ads.MetricsCollector$MetricHitTotalTime
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.Vector
 *  org.json.JSONObject
 */
package com.amazon.device.ads;

import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.Version;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import org.json.JSONObject;

class AdMetrics {
    public static final String LOGTAG = "AdMetrics";
    private MetricsCollector globalMetrics;
    private final MobileAdsLogger logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
    private final MobileAdsInfoStore mobileAdsInfoStore;
    private final Metrics.MetricsSubmitter submitter;
    private final WebRequest.WebRequestFactory webRequestFactory = new WebRequest.WebRequestFactory();

    public AdMetrics(Metrics.MetricsSubmitter metricsSubmitter) {
        this(metricsSubmitter, MobileAdsInfoStore.getInstance());
    }

    AdMetrics(Metrics.MetricsSubmitter metricsSubmitter, MobileAdsInfoStore mobileAdsInfoStore) {
        this.submitter = metricsSubmitter;
        this.mobileAdsInfoStore = mobileAdsInfoStore;
    }

    protected static void addMetricsToJSON(JSONObject jSONObject, MetricsCollector metricsCollector) {
        if (metricsCollector == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        String string = metricsCollector.getAdTypeMetricTag();
        if (string != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("_");
            string = stringBuilder.toString();
        }
        for (MetricsCollector.MetricHit metricHit : (MetricsCollector.MetricHit[])metricsCollector.getMetricHits().toArray((Object[])new MetricsCollector.MetricHit[metricsCollector.getMetricHits().size()])) {
            String string2 = metricHit.metric.getAaxName();
            if (string != null && metricHit.metric.isAdTypeSpecific()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
            }
            if (metricHit instanceof MetricsCollector.MetricHitStartTime) {
                MetricsCollector.MetricHitStartTime metricHitStartTime = metricHit;
                hashMap.put((Object)metricHit.metric, (Object)metricHitStartTime.startTime);
                continue;
            }
            if (metricHit instanceof MetricsCollector.MetricHitStopTime) {
                MetricsCollector.MetricHitStopTime metricHitStopTime = metricHit;
                Long l2 = (Long)hashMap.remove((Object)metricHit.metric);
                if (l2 == null) continue;
                JSONUtils.put(jSONObject, string2, JSONUtils.getLongFromJSON(jSONObject, string2, 0L) + metricHitStopTime.stopTime - l2);
                continue;
            }
            if (metricHit instanceof MetricsCollector.MetricHitTotalTime) {
                JSONUtils.put(jSONObject, string2, (metricHit).totalTime);
                continue;
            }
            if (metricHit instanceof MetricsCollector.MetricHitIncrement) {
                MetricsCollector.MetricHitIncrement metricHitIncrement = metricHit;
                Integer n = (Integer)hashMap2.get((Object)metricHit.metric);
                int n2 = n == null ? metricHitIncrement.increment : n + metricHitIncrement.increment;
                Integer n3 = n2;
                hashMap2.put((Object)metricHit.metric, (Object)n3);
                continue;
            }
            if (!(metricHit instanceof MetricsCollector.MetricHitString)) continue;
            JSONUtils.put(jSONObject, string2, (metricHit).text);
        }
        for (Map.Entry entry : hashMap2.entrySet()) {
            String string3 = ((Metrics.MetricType)((Object)entry.getKey())).getAaxName();
            if (string != null && ((Metrics.MetricType)((Object)entry.getKey())).isAdTypeSpecific()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(string3);
                string3 = stringBuilder.toString();
            }
            JSONUtils.put(jSONObject, string3, (Integer)entry.getValue());
        }
    }

    private String getAaxUrlAndResetAdMetrics() {
        String string = WebUtils.getURLEncodedString(this.getAaxJson());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.submitter.getInstrumentationPixelUrl());
        stringBuilder.append(string);
        String string2 = stringBuilder.toString();
        this.submitter.resetMetricsCollector();
        return string2;
    }

    public void addGlobalMetrics(MetricsCollector metricsCollector) {
        this.globalMetrics = metricsCollector;
    }

    public boolean canSubmit() {
        String string = this.submitter.getInstrumentationPixelUrl();
        if (string != null) {
            if (string.equals((Object)"")) {
                return false;
            }
            if (this.mobileAdsInfoStore.getRegistrationInfo().getAppKey() == null) {
                this.logger.d("Not submitting metrics because the AppKey is not set.");
                return false;
            }
            return true;
        }
        return false;
    }

    protected String getAaxJson() {
        JSONObject jSONObject = new JSONObject();
        JSONUtils.put(jSONObject, "c", "msdk");
        JSONUtils.put(jSONObject, "v", Version.getRawSDKVersion());
        AdMetrics.addMetricsToJSON(jSONObject, this.submitter.getMetricsCollector());
        AdMetrics.addMetricsToJSON(jSONObject, this.globalMetrics);
        String string = jSONObject.toString();
        return string.substring(1, string.length() - 1);
    }

    public WebRequest getAaxWebRequestAndResetAdMetrics() {
        WebRequest webRequest = this.webRequestFactory.createWebRequest();
        webRequest.setUrlString(this.getAaxUrlAndResetAdMetrics());
        return webRequest;
    }
}

