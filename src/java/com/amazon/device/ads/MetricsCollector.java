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
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Vector
 */
package com.amazon.device.ads;

import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.NumberUtils;
import java.util.Vector;

/*
 * Exception performing whole class analysis.
 */
class MetricsCollector {
    private static final String LOGTAG = "MetricsCollector";
    private String adTypeMetricTag;
    private final MobileAdsLogger logger;
    protected Vector<MetricHit> metricHits;

    public MetricsCollector() {
        this.logger = new MobileAdsLoggerFactory().createMobileAdsLogger(LOGTAG);
        this.metricHits = new Vector(60);
    }

    public String getAdTypeMetricTag() {
        return this.adTypeMetricTag;
    }

    public Vector<MetricHit> getMetricHits() {
        return this.metricHits;
    }

    public void incrementMetric(Metrics.MetricType metricType) {
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("METRIC Increment ");
        stringBuilder.append(metricType.toString());
        mobileAdsLogger.d(stringBuilder.toString());
        this.metricHits.add((Object)new /* Unavailable Anonymous Inner Class!! */);
    }

    public boolean isMetricsCollectorEmpty() {
        return this.metricHits.isEmpty();
    }

    public void publishMetricInMilliseconds(Metrics.MetricType metricType, long l2) {
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("METRIC Publish ");
        stringBuilder.append(metricType.toString());
        mobileAdsLogger.d(stringBuilder.toString());
        this.metricHits.add((Object)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void publishMetricInMillisecondsFromNanoseconds(Metrics.MetricType metricType, long l2) {
        this.publishMetricInMilliseconds(metricType, NumberUtils.convertToMillisecondsFromNanoseconds(l2));
    }

    public void setAdTypeMetricTag(String string) {
        this.adTypeMetricTag = string;
    }

    public void setMetricString(Metrics.MetricType metricType, String string) {
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("METRIC Set ");
        stringBuilder.append(metricType.toString());
        stringBuilder.append(": ");
        stringBuilder.append(string);
        mobileAdsLogger.d(stringBuilder.toString());
        this.metricHits.add((Object)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void startMetric(Metrics.MetricType metricType) {
        this.startMetricInMillisecondsFromNanoseconds(metricType, System.nanoTime());
    }

    public void startMetricInMillisecondsFromNanoseconds(Metrics.MetricType metricType, long l2) {
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("METRIC Start ");
        stringBuilder.append(metricType.toString());
        mobileAdsLogger.d(stringBuilder.toString());
        long l3 = NumberUtils.convertToMillisecondsFromNanoseconds(l2);
        this.metricHits.add((Object)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void stopMetric(Metrics.MetricType metricType) {
        this.stopMetricInMillisecondsFromNanoseconds(metricType, System.nanoTime());
    }

    public void stopMetricInMillisecondsFromNanoseconds(Metrics.MetricType metricType, long l2) {
        MobileAdsLogger mobileAdsLogger = this.logger;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("METRIC Stop ");
        stringBuilder.append(metricType.toString());
        mobileAdsLogger.d(stringBuilder.toString());
        long l3 = NumberUtils.convertToMillisecondsFromNanoseconds(l2);
        this.metricHits.add((Object)new /* Unavailable Anonymous Inner Class!! */);
    }

    static class MetricHit {
        public final Metrics.MetricType metric;

        public MetricHit(Metrics.MetricType metricType) {
            this.metric = metricType;
        }
    }

}

