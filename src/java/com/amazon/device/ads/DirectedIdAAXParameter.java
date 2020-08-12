/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AAXParameter;
import com.amazon.device.ads.AAXParameterGroupParameter;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.DirectedIdRetriever;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.Settings;

class DirectedIdAAXParameter
extends AAXParameterGroupParameter {
    private final Configuration configuration;
    private final DirectedIdRetriever directedIdRetriever;

    DirectedIdAAXParameter() {
        this(DebugProperties.getInstance(), new MobileAdsLoggerFactory(), Configuration.getInstance(), Settings.getInstance().getObject("directedIdRetriever", null, DirectedIdRetriever.class));
    }

    DirectedIdAAXParameter(DebugProperties debugProperties, MobileAdsLoggerFactory mobileAdsLoggerFactory, Configuration configuration, DirectedIdRetriever directedIdRetriever) {
        super(debugProperties, "directedId", "debug.directedId", mobileAdsLoggerFactory);
        this.configuration = configuration;
        this.directedIdRetriever = directedIdRetriever;
    }

    @Override
    protected String getDerivedValue(AAXParameter.ParameterData parameterData) {
        DirectedIdRetriever directedIdRetriever;
        if (this.configuration.getBoolean(Configuration.ConfigOption.WHITELISTED_CUSTOMER) && (directedIdRetriever = this.directedIdRetriever) != null) {
            return directedIdRetriever.getDirectedId();
        }
        return null;
    }
}

