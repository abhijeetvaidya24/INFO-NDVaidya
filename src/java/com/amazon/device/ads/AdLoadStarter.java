/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  com.amazon.device.ads.AdLoadStarter$1
 *  com.amazon.device.ads.MobileAdsLogger
 *  com.amazon.device.ads.ViewabilityJavascriptFetcherListener
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 */
package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import com.amazon.device.ads.AdError;
import com.amazon.device.ads.AdLoadStarter;
import com.amazon.device.ads.AdLoader;
import com.amazon.device.ads.AdRequest;
import com.amazon.device.ads.AdSlot;
import com.amazon.device.ads.AdTargetingOptions;
import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.PermissionChecker;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.SystemTime;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.ViewabilityJavascriptFetcherListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class AdLoadStarter {
    private static final String LOGTAG = "AdLoadStarter";
    private final AdLoader.AdLoaderFactory adLoaderFactory;
    private final AdRequest.AdRequestBuilder adRequestBuilder;
    private final AdvertisingIdentifier advertisingIdentifier;
    private final Configuration configuration;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLogger logger;
    private final PermissionChecker permissionChecker;
    private final Settings settings;
    private final SystemTime systemTime;
    private final ThreadUtils.ThreadRunner threadRunner;
    private final ViewabilityJavascriptFetcherListener viewabilityJavascriptFetcherListener;

    public AdLoadStarter() {
        this(new AdLoader.AdLoaderFactory(), new AdvertisingIdentifier(), ThreadUtils.getThreadRunner(), MobileAdsInfoStore.getInstance(), Settings.getInstance(), Configuration.getInstance(), new MobileAdsLoggerFactory(), new SystemTime(), new AdRequest.AdRequestBuilder(), new PermissionChecker(), new ViewabilityJavascriptFetcherListener());
    }

    AdLoadStarter(AdLoader.AdLoaderFactory adLoaderFactory, AdvertisingIdentifier advertisingIdentifier, ThreadUtils.ThreadRunner threadRunner, MobileAdsInfoStore mobileAdsInfoStore, Settings settings, Configuration configuration, MobileAdsLoggerFactory mobileAdsLoggerFactory, SystemTime systemTime, AdRequest.AdRequestBuilder adRequestBuilder, PermissionChecker permissionChecker, ViewabilityJavascriptFetcherListener viewabilityJavascriptFetcherListener) {
        this.adLoaderFactory = adLoaderFactory;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.advertisingIdentifier = advertisingIdentifier;
        this.infoStore = mobileAdsInfoStore;
        this.settings = settings;
        this.configuration = configuration;
        this.threadRunner = threadRunner;
        this.systemTime = systemTime;
        this.adRequestBuilder = adRequestBuilder;
        this.permissionChecker = permissionChecker;
        this.viewabilityJavascriptFetcherListener = viewabilityJavascriptFetcherListener;
    }

    static /* synthetic */ MobileAdsInfoStore access$000(AdLoadStarter adLoadStarter) {
        return adLoadStarter.infoStore;
    }

    static /* synthetic */ void access$100(AdLoadStarter adLoadStarter, int n, AdTargetingOptions adTargetingOptions, List list) {
        adLoadStarter.beginFetchAds(n, adTargetingOptions, (List<AdSlot>)list);
    }

    static /* synthetic */ void access$200(AdLoadStarter adLoadStarter, AdError adError, List list) {
        adLoadStarter.failAds(adError, (List<AdSlot>)list);
    }

    static /* synthetic */ ThreadUtils.ThreadRunner access$300(AdLoadStarter adLoadStarter) {
        return adLoadStarter.threadRunner;
    }

    @SuppressLint(value={"UseSparseArrays"})
    private void beginFetchAds(int n, AdTargetingOptions adTargetingOptions, List<AdSlot> list) {
        AdvertisingIdentifier.Info info = this.advertisingIdentifier.getAdvertisingIdentifierInfo();
        if (!info.canDo()) {
            this.failAds(new AdError(AdError.ErrorCode.INTERNAL_ERROR, "An internal request was not made on a background thread."), list);
            return;
        }
        if (adTargetingOptions == null) {
            adTargetingOptions = new AdTargetingOptions();
        }
        AdRequest adRequest = this.adRequestBuilder.withAdTargetingOptions(adTargetingOptions).withAdvertisingIdentifierInfo(info).build();
        HashMap hashMap = new HashMap();
        Iterator iterator = list.iterator();
        int n2 = 1;
        while (iterator.hasNext()) {
            AdSlot adSlot = (AdSlot)iterator.next();
            if (!adSlot.isValid()) continue;
            adSlot.setSlotNumber(n2);
            hashMap.put((Object)n2, (Object)adSlot);
            adRequest.putSlot(adSlot);
            ++n2;
        }
        if (hashMap.size() > 0) {
            AdLoader adLoader = this.adLoaderFactory.createAdLoader(adRequest, (Map<Integer, AdSlot>)hashMap);
            adLoader.setTimeout(n);
            adLoader.beginFetchAd();
        }
    }

    private void failAds(AdError adError, List<AdSlot> list) {
        Iterator iterator = list.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            AdSlot adSlot = (AdSlot)iterator.next();
            if (adSlot.getSlotNumber() == -1) continue;
            adSlot.adFailed(adError);
            ++n;
        }
        if (n > 0) {
            MobileAdsLogger mobileAdsLogger = this.logger;
            Object[] arrobject = new Object[]{adError.getMessage(), adError.getCode()};
            mobileAdsLogger.e("%s; code: %s", arrobject);
        }
    }

    private boolean isNoRetry(AdSlot[] arradSlot) {
        int n = this.infoStore.getNoRetryTtlRemainingMillis();
        if (n > 0) {
            AdError.ErrorCode errorCode;
            String string;
            int n2 = n / 1000;
            if (this.infoStore.getIsAppDisabled()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SDK Message: ");
                stringBuilder.append("DISABLED_APP");
                string = stringBuilder.toString();
                errorCode = AdError.ErrorCode.INTERNAL_ERROR;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("SDK Message: ");
                stringBuilder.append("no results. Try again in ");
                stringBuilder.append(n2);
                stringBuilder.append(" seconds.");
                string = stringBuilder.toString();
                errorCode = AdError.ErrorCode.NO_FILL;
            }
            this.failAds(new AdError(errorCode, string), (List<AdSlot>)new ArrayList((Collection)Arrays.asList((Object[])arradSlot)));
            return true;
        }
        return false;
    }

    public /* varargs */ void loadAds(int n, AdTargetingOptions adTargetingOptions, AdSlot ... arradSlot) {
        if (this.isNoRetry(arradSlot)) {
            return;
        }
        if (adTargetingOptions != null && adTargetingOptions.isGeoLocationEnabled() && !this.permissionChecker.hasLocationPermission(this.infoStore.getApplicationContext())) {
            this.logger.w("Geolocation for ad targeting has been disabled. To enable geolocation, add at least one of the following permissions to the app manifest: 1. ACCESS_FINE_LOCATION; 2. ACCESS_COARSE_LOCATION.");
        }
        long l2 = this.systemTime.nanoTime();
        ArrayList arrayList = new ArrayList();
        for (AdSlot adSlot : arradSlot) {
            if (!adSlot.prepareForAdLoad(l2)) continue;
            arrayList.add((Object)adSlot);
        }
        this.configuration.queueConfigurationListener((Configuration.ConfigurationListener)this.viewabilityJavascriptFetcherListener);
        1 var9_9 = new 1(this, this.settings, this.configuration, n, adTargetingOptions, arrayList);
        var9_9.start();
    }
}

