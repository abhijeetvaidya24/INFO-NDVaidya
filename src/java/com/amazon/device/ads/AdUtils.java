/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashSet
 */
package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.MetricsCollector;
import com.amazon.device.ads.MobileAdsInfoStore;
import java.util.Collection;
import java.util.HashSet;

class AdUtils {
    public static final String REQUIRED_ACTIVITY = "com.amazon.device.ads.AdActivity";
    private static AdUtilsExecutor executor = new AdUtilsExecutor();

    private AdUtils() {
    }

    public static double calculateScalingMultiplier(int n, int n2, int n3, int n4) {
        return executor.calculateScalingMultiplier(n, n2, n3, n4);
    }

    static boolean checkDefinedActivities(Context context) {
        return executor.checkDefinedActivities(context);
    }

    public static int deviceIndependentPixelToPixel(int n) {
        return executor.deviceIndependentPixelToPixel(n);
    }

    public static float getScalingFactorAsFloat() {
        return executor.getScalingFactorAsFloat();
    }

    public static double getViewportInitialScale(double d2) {
        return executor.getViewportInitialScale(d2);
    }

    public static int pixelToDeviceIndependentPixel(int n) {
        return executor.pixelToDeviceIndependentPixel(n);
    }

    static void setConnectionMetrics(ConnectionInfo connectionInfo, MetricsCollector metricsCollector) {
        executor.setConnectionMetrics(connectionInfo, metricsCollector);
    }

    static class AdUtilsExecutor {
        private boolean hasRequiredActivities = false;
        private final HashSet<String> requiredActivities = new HashSet();

        AdUtilsExecutor() {
            this.requiredActivities.add((Object)AdUtils.REQUIRED_ACTIVITY);
        }

        double calculateScalingMultiplier(int n, int n2, int n3, int n4) {
            double d2 = n3;
            double d3 = n;
            Double.isNaN((double)d2);
            Double.isNaN((double)d3);
            double d4 = d2 / d3;
            double d5 = n4;
            double d6 = n2;
            Double.isNaN((double)d5);
            Double.isNaN((double)d6);
            double d7 = d5 / d6;
            if (!(d7 < d4) && d4 != 0.0 || d7 == 0.0) {
                d7 = d4;
            }
            if (d7 == 0.0) {
                d7 = 1.0;
            }
            return d7;
        }

        boolean checkDefinedActivities(Context context) {
            if (this.hasRequiredActivities) {
                return true;
            }
            HashSet hashSet = new HashSet();
            String string = context.getPackageCodePath();
            ActivityInfo[] arractivityInfo = context.getPackageManager().getPackageArchiveInfo((String)string, (int)1).activities;
            int n = arractivityInfo.length;
            for (int i2 = 0; i2 < n; ++i2) {
                hashSet.add((Object)arractivityInfo[i2].name);
            }
            try {
                boolean bl = this.hasRequiredActivities = hashSet.containsAll(this.requiredActivities);
                return bl;
            }
            catch (Exception exception) {
                this.hasRequiredActivities = true;
                return true;
            }
        }

        int deviceIndependentPixelToPixel(int n) {
            float f2 = n == -1 ? (float)n : (float)n * this.getScalingFactorAsFloat();
            return (int)f2;
        }

        float getScalingFactorAsFloat() {
            return MobileAdsInfoStore.getInstance().getDeviceInfo().getScalingFactorAsFloat();
        }

        double getViewportInitialScale(double d2) {
            if (AndroidTargetUtils.isAtLeastAndroidAPI(19)) {
                d2 = 1.0;
            }
            return d2;
        }

        int pixelToDeviceIndependentPixel(int n) {
            return (int)((float)n / this.getScalingFactorAsFloat());
        }

        void setConnectionMetrics(ConnectionInfo connectionInfo, MetricsCollector metricsCollector) {
            DeviceInfo deviceInfo;
            if (connectionInfo != null) {
                if (connectionInfo.isWiFi()) {
                    metricsCollector.incrementMetric(Metrics.MetricType.WIFI_PRESENT);
                } else {
                    metricsCollector.setMetricString(Metrics.MetricType.CONNECTION_TYPE, connectionInfo.getConnectionType());
                }
            }
            if ((deviceInfo = MobileAdsInfoStore.getInstance().getDeviceInfo()).getCarrier() != null) {
                metricsCollector.setMetricString(Metrics.MetricType.CARRIER_NAME, deviceInfo.getCarrier());
            }
        }
    }

}

