/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AAXParameterGroupParameter;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLoggerFactory;

class SHA1UDIDAAXParameter
extends AAXParameterGroupParameter {
    private MobileAdsInfoStore mobileAdsInfoStore;

    SHA1UDIDAAXParameter() {
        this(DebugProperties.getInstance(), new MobileAdsLoggerFactory(), MobileAdsInfoStore.getInstance());
    }

    SHA1UDIDAAXParameter(DebugProperties debugProperties, MobileAdsLoggerFactory mobileAdsLoggerFactory, MobileAdsInfoStore mobileAdsInfoStore) {
        super(debugProperties, "sha1_udid", "debug.sha1udid", mobileAdsLoggerFactory);
        this.mobileAdsInfoStore = mobileAdsInfoStore;
    }

    @Override
    protected String getDerivedValue(AAXParameter.ParameterData parameterData) {
        return this.mobileAdsInfoStore.getDeviceInfo().getUdidSha1();
    }
}

