/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AmazonFireServicesAdapter;
import com.amazon.device.ads.GooglePlayServicesAdapter;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.ReflectionUtils;
import com.amazon.device.ads.Settings;

class GooglePlayServices {
    private static final String GPS_AVAILABLE_SETTING = "gps-available";
    private static final String LOGTAG = "GooglePlayServices";
    private final MobileAdsLogger logger;
    private final ReflectionUtils reflectionUtils;

    public GooglePlayServices() {
        this(new MobileAdsLoggerFactory(), new ReflectionUtils());
    }

    GooglePlayServices(MobileAdsLoggerFactory mobileAdsLoggerFactory, ReflectionUtils reflectionUtils) {
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.reflectionUtils = reflectionUtils;
    }

    private boolean isGPSAvailable() {
        return Settings.getInstance().getBoolean(GPS_AVAILABLE_SETTING, true);
    }

    private boolean isGPSAvailableSet() {
        return Settings.getInstance().containsKey(GPS_AVAILABLE_SETTING);
    }

    private boolean isGoogleAdvertisingClassAvailable() {
        return this.reflectionUtils.isClassAvailable("com.google.android.gms.ads.identifier.AdvertisingIdClient");
    }

    private void setGooglePlayServicesAvailable(boolean bl) {
        Settings.getInstance().putTransientBoolean(GPS_AVAILABLE_SETTING, bl);
    }

    protected AmazonFireServicesAdapter createAmazonFireServiceAdapter() {
        return AmazonFireServicesAdapter.newAdapter();
    }

    protected GooglePlayServicesAdapter createGooglePlayServicesAdapter() {
        return new GooglePlayServicesAdapter();
    }

    public AdvertisingInfo getAdvertisingIdentifierInfo() {
        AdvertisingInfo advertisingInfo;
        AdvertisingInfo advertisingInfo2;
        GooglePlayServicesAdapter googlePlayServicesAdapter;
        if (!this.isGPSAvailable()) {
            this.logger.v("The Google Play Services Advertising Identifier feature is not available.");
            return AdvertisingInfo.createNotAvailable();
        }
        if (!this.isGPSAvailableSet() && !this.isGoogleAdvertisingClassAvailable()) {
            this.logger.v("The Google Play Services Advertising Identifier feature is not available.");
            this.setGooglePlayServicesAvailable(false);
            return AdvertisingInfo.createNotAvailable();
        }
        if (this.isGoogleAdvertisingClassAvailable() && (googlePlayServicesAdapter = this.createGooglePlayServicesAdapter()) != null && (advertisingInfo2 = googlePlayServicesAdapter.getAdvertisingIdentifierInfo()) != null && advertisingInfo2.getAdvertisingIdentifier() != null && !advertisingInfo2.getAdvertisingIdentifier().isEmpty()) {
            this.setGooglePlayServicesAvailable(advertisingInfo2.isGPSAvailable());
            return advertisingInfo2;
        }
        AmazonFireServicesAdapter amazonFireServicesAdapter = this.createAmazonFireServiceAdapter();
        if (amazonFireServicesAdapter != null && (advertisingInfo = amazonFireServicesAdapter.getAdvertisingIdentifierInfo()) != null && advertisingInfo.getAdvertisingIdentifier() != null && !advertisingInfo.getAdvertisingIdentifier().isEmpty()) {
            this.setGooglePlayServicesAvailable(advertisingInfo.isGPSAvailable());
            return advertisingInfo;
        }
        this.logger.v("Advertising Identifier feature is not available.");
        this.setGooglePlayServicesAvailable(false);
        return AdvertisingInfo.createNotAvailable();
    }

    static class AdvertisingInfo {
        private String advertisingIdentifier;
        private boolean gpsAvailable = true;
        private boolean limitAdTrackingEnabled;

        protected AdvertisingInfo() {
        }

        static AdvertisingInfo createNotAvailable() {
            return new AdvertisingInfo().setGPSAvailable(false);
        }

        private AdvertisingInfo setGPSAvailable(boolean bl) {
            this.gpsAvailable = bl;
            return this;
        }

        String getAdvertisingIdentifier() {
            return this.advertisingIdentifier;
        }

        boolean hasAdvertisingIdentifier() {
            return this.getAdvertisingIdentifier() != null;
        }

        boolean isGPSAvailable() {
            return this.gpsAvailable;
        }

        boolean isLimitAdTrackingEnabled() {
            return this.limitAdTrackingEnabled;
        }

        AdvertisingInfo setAdvertisingIdentifier(String string) {
            this.advertisingIdentifier = string;
            return this;
        }

        AdvertisingInfo setLimitAdTrackingEnabled(boolean bl) {
            this.limitAdTrackingEnabled = bl;
            return this;
        }
    }

}

