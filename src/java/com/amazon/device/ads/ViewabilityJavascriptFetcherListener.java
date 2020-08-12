/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ViewabilityJavascriptFetcher;

class ViewabilityJavascriptFetcherListener
implements Configuration.ConfigurationListener {
    private static final String LOGTAG = "ViewabilityJavascriptFetcherListener";
    private final MobileAdsLogger logger;
    private ViewabilityJavascriptFetcher viewabilityJavascriptFetcher;

    ViewabilityJavascriptFetcherListener() {
        this(new ViewabilityJavascriptFetcher(), new MobileAdsLoggerFactory());
    }

    ViewabilityJavascriptFetcherListener(ViewabilityJavascriptFetcher viewabilityJavascriptFetcher, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.viewabilityJavascriptFetcher = viewabilityJavascriptFetcher;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
    }

    @Override
    public void onConfigurationFailure() {
        this.logger.w("Configuration fetching failed so Viewability Javascript fetch will not proceed.");
    }

    @Override
    public void onConfigurationReady() {
        this.viewabilityJavascriptFetcher.fetchJavascript();
    }
}

