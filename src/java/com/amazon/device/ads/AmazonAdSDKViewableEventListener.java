/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AmazonAdSDKViewableEventListener;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.SDKEvent;
import com.amazon.device.ads.SDKEventListener;

class AmazonAdSDKViewableEventListener
implements SDKEventListener {
    private static final String LOGTAG = "AmazonAdSDKViewableEventListener";
    private final MobileAdsLogger logger;

    public AmazonAdSDKViewableEventListener() {
        this(new MobileAdsLoggerFactory());
    }

    AmazonAdSDKViewableEventListener(MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
    }

    public void handleViewableEvent(AdControlAccessor adControlAccessor, SDKEvent sDKEvent) {
        String string = sDKEvent.getParameter("VIEWABLE_PARAMS");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("viewableBridge.viewabilityChange('");
        stringBuilder.append(string);
        stringBuilder.append("');");
        adControlAccessor.injectJavascript(stringBuilder.toString());
    }

    @Override
    public void onSDKEvent(SDKEvent sDKEvent, AdControlAccessor adControlAccessor) {
        this.logger.d(sDKEvent.getEventType().toString());
        if (1.$SwitchMap$com$amazon$device$ads$SDKEvent$SDKEventType[sDKEvent.getEventType().ordinal()] != 1) {
            return;
        }
        this.handleViewableEvent(adControlAccessor, sDKEvent);
    }
}

