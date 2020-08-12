/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AdUtils;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.MetricsCollector;

class AdUtils2 {
    private final AdUtilsStatic adUtilsAdapter = new AdUtilsStatic();

    AdUtils2() {
    }

    public double calculateScalingMultiplier(int n, int n2, int n3, int n4) {
        return this.adUtilsAdapter.calculateScalingMultiplier(n, n2, n3, n4);
    }

    public boolean checkDefinedActivities(Context context) {
        return this.adUtilsAdapter.checkDefinedActivities(context);
    }

    public int deviceIndependentPixelToPixel(int n) {
        return this.adUtilsAdapter.deviceIndependentPixelToPixel(n);
    }

    public float getScalingFactorAsFloat() {
        return this.adUtilsAdapter.getScalingFactorAsFloat();
    }

    public double getViewportInitialScale(double d2) {
        return this.adUtilsAdapter.getViewportInitialScale(d2);
    }

    public int pixelToDeviceIndependentPixel(int n) {
        return this.adUtilsAdapter.pixelToDeviceIndependentPixel(n);
    }

    public void setConnectionMetrics(ConnectionInfo connectionInfo, MetricsCollector metricsCollector) {
        this.adUtilsAdapter.setConnectionMetrics(connectionInfo, metricsCollector);
    }

    private static class AdUtilsStatic {
        private AdUtilsStatic() {
        }

        double calculateScalingMultiplier(int n, int n2, int n3, int n4) {
            return AdUtils.calculateScalingMultiplier(n, n2, n3, n4);
        }

        boolean checkDefinedActivities(Context context) {
            return AdUtils.checkDefinedActivities(context);
        }

        int deviceIndependentPixelToPixel(int n) {
            return AdUtils.deviceIndependentPixelToPixel(n);
        }

        float getScalingFactorAsFloat() {
            return AdUtils.getScalingFactorAsFloat();
        }

        double getViewportInitialScale(double d2) {
            return AdUtils.getViewportInitialScale(d2);
        }

        int pixelToDeviceIndependentPixel(int n) {
            return AdUtils.pixelToDeviceIndependentPixel(n);
        }

        void setConnectionMetrics(ConnectionInfo connectionInfo, MetricsCollector metricsCollector) {
            AdUtils.setConnectionMetrics(connectionInfo, metricsCollector);
        }
    }

}

