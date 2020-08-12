/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.AdController
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdData;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdSize;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.MetricsCollector;

class AdSlot {
    private final String KEY_SLOT_ID = "slotId";
    private final AdController adController;
    private AdError adError;
    private final AdTargetingOptions adOptions;
    private boolean deferredLoad = false;
    private final String slotID;
    private int slotNumber;

    AdSlot(AdController adController, AdTargetingOptions adTargetingOptions) {
        this.adController = adController;
        if (adTargetingOptions == null) {
            this.adOptions = new AdTargetingOptions();
            this.slotID = null;
            return;
        }
        this.adOptions = adTargetingOptions;
        this.slotID = this.adOptions.getAdvancedOption("slotId");
    }

    void adFailed(AdError adError) {
        this.adController.adFailed(adError);
    }

    boolean canBeUsed() {
        return this.adController.canBeUsed();
    }

    AdError getAdError() {
        return this.adError;
    }

    public AdTargetingOptions getAdTargetingOptions() {
        return this.adOptions;
    }

    String getMaxSize() {
        return this.adController.getMaxSize();
    }

    MetricsCollector getMetricsCollector() {
        return this.adController.getMetricsCollector();
    }

    public AdSize getRequestedAdSize() {
        return this.adController.getAdSize();
    }

    int getSlotNumber() {
        return this.slotNumber;
    }

    void initializeAd() {
        this.adController.initialize(this.slotID);
    }

    boolean isFetched() {
        return this.adController.getAdData() != null && this.adController.getAdData().getIsFetched();
    }

    boolean isValid() {
        return this.adController.isValid();
    }

    boolean prepareForAdLoad(long l2) {
        return this.adController.prepareForAdLoad(l2, this.deferredLoad);
    }

    void setAdData(AdData adData) {
        this.adController.setAdData(adData);
    }

    void setAdError(AdError adError) {
        this.adError = adError;
    }

    void setConnectionInfo(ConnectionInfo connectionInfo) {
        this.adController.setConnectionInfo(connectionInfo);
    }

    public AdSlot setDeferredLoad(boolean bl) {
        this.deferredLoad = bl;
        return this;
    }

    void setSlotNumber(int n) {
        this.slotNumber = n;
    }
}

