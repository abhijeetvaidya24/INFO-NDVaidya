/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdSDKBridgeList;
import com.amazon.device.ads.AdWebViewClient;
import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.WebUtils2;

class AdWebViewClientFactory {
    private final AndroidBuildInfo androidBuildInfo;
    private final MobileAdsLoggerFactory loggerFactory;
    private final WebUtils2 webUtils;

    public AdWebViewClientFactory(WebUtils2 webUtils2, MobileAdsLoggerFactory mobileAdsLoggerFactory, AndroidBuildInfo androidBuildInfo) {
        this.webUtils = webUtils2;
        this.loggerFactory = mobileAdsLoggerFactory;
        this.androidBuildInfo = androidBuildInfo;
    }

    public AdWebViewClient createAdWebViewClient(Context context, AdSDKBridgeList adSDKBridgeList, AdControlAccessor adControlAccessor) {
        AdWebViewClient adWebViewClient = new AdWebViewClient(context, adSDKBridgeList, adControlAccessor, this.webUtils, this.loggerFactory, this.androidBuildInfo);
        return adWebViewClient;
    }
}

