/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AAXParameterGroupParameter;
import com.amazon.device.ads.AdRequest;
import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.MobileAdsLoggerFactory;

class AdvertisingIdentifierAAXParameter
extends AAXParameterGroupParameter {
    AdvertisingIdentifierAAXParameter() {
        this(DebugProperties.getInstance(), new MobileAdsLoggerFactory());
    }

    AdvertisingIdentifierAAXParameter(DebugProperties debugProperties, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        super(debugProperties, "idfa", "debug.idfa", mobileAdsLoggerFactory);
    }

    @Override
    protected String getDerivedValue(AAXParameter.ParameterData parameterData) {
        return parameterData.getAdRequest().getAdvertisingIdentifierInfo().getAdvertisingIdentifier();
    }
}

