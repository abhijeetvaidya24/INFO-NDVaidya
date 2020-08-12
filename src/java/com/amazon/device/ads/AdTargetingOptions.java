/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Map
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AndroidBuildInfo;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.StringUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class AdTargetingOptions {
    private static final boolean DEFAULT_DISPLAY_ENABLED = true;
    private static final long DEFAULT_FLOOR_PRICE = 0L;
    private static final boolean DEFAULT_GEOTARGETING_ENABLED = false;
    private static final String LOGTAG = "AdTargetingOptions";
    private final Map<String, String> advanced;
    private boolean displayEnabled = true;
    private boolean enableGeoTargeting = false;
    private long floorPrice = 0L;
    private final HashSet<String> internalPublisherKeywords;
    private final MobileAdsLogger logger;
    private boolean videoEnabled;
    private final boolean videoEnabledSettable;

    public AdTargetingOptions() {
        this(new AndroidBuildInfo(), new MobileAdsLoggerFactory());
    }

    AdTargetingOptions(AndroidBuildInfo androidBuildInfo, MobileAdsLoggerFactory mobileAdsLoggerFactory) {
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.advanced = new HashMap();
        this.videoEnabled = this.videoEnabledSettable = AdTargetingOptions.isVideoEnabledSettable(androidBuildInfo);
        this.internalPublisherKeywords = new HashSet();
    }

    private static boolean isVideoEnabledSettable(AndroidBuildInfo androidBuildInfo) {
        return AndroidTargetUtils.isAtLeastAndroidAPI(androidBuildInfo, 14);
    }

    AdTargetingOptions addInternalPublisherKeyword(String string) {
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            this.internalPublisherKeywords.add((Object)string);
        }
        return this;
    }

    public boolean containsAdvancedOption(String string) {
        return this.advanced.containsKey((Object)string);
    }

    AdTargetingOptions copy() {
        AdTargetingOptions adTargetingOptions = new AdTargetingOptions().enableGeoLocation(this.enableGeoTargeting).setFloorPrice(this.floorPrice).enableDisplayAds(this.displayEnabled);
        if (this.videoEnabledSettable) {
            adTargetingOptions.enableVideoAds(this.videoEnabled);
        }
        adTargetingOptions.advanced.putAll(this.advanced);
        adTargetingOptions.internalPublisherKeywords.addAll(this.internalPublisherKeywords);
        return adTargetingOptions;
    }

    AdTargetingOptions enableDisplayAds(boolean bl) {
        this.displayEnabled = bl;
        return this;
    }

    public AdTargetingOptions enableGeoLocation(boolean bl) {
        this.enableGeoTargeting = bl;
        return this;
    }

    AdTargetingOptions enableVideoAds(boolean bl) {
        if (!this.videoEnabledSettable) {
            this.logger.w("Video is not allowed to be changed as this device does not support video.");
            return this;
        }
        this.videoEnabled = bl;
        return this;
    }

    public String getAdvancedOption(String string) {
        return (String)this.advanced.get((Object)string);
    }

    public int getAge() {
        this.logger.d("getAge API has been deprecated.");
        return Integer.MIN_VALUE;
    }

    HashMap<String, String> getCopyOfAdvancedOptions() {
        return new HashMap(this.advanced);
    }

    public long getFloorPrice() {
        return this.floorPrice;
    }

    HashSet<String> getInternalPublisherKeywords() {
        return this.internalPublisherKeywords;
    }

    boolean hasFloorPrice() {
        return this.floorPrice > 0L;
    }

    boolean isDisplayAdsEnabled() {
        return this.displayEnabled;
    }

    public boolean isGeoLocationEnabled() {
        return this.enableGeoTargeting;
    }

    boolean isVideoAdsEnabled() {
        return this.videoEnabled;
    }

    boolean isVideoEnabledSettable() {
        return this.videoEnabledSettable;
    }

    public AdTargetingOptions setAdvancedOption(String string, String string2) {
        if (!StringUtils.isNullOrWhiteSpace(string)) {
            if (string2 != null) {
                this.advanced.put((Object)string, (Object)string2);
                return this;
            }
            this.advanced.remove((Object)string);
            return this;
        }
        throw new IllegalArgumentException("Option Key must not be null or empty string");
    }

    public AdTargetingOptions setAge(int n) {
        this.logger.d("setAge API has been deprecated.");
        return this;
    }

    public AdTargetingOptions setFloorPrice(long l2) {
        this.floorPrice = l2;
        return this;
    }
}

