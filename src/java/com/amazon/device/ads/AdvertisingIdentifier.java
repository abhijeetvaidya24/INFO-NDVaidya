/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.GooglePlayServices;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ThreadUtils;

class AdvertisingIdentifier {
    private static final String GPS_ADVERTISING_IDENTIFIER_SETTING = "gpsAdId";
    private static final String LOGTAG = "AdvertisingIdentifier";
    private static final String TRANSITION_MIGRATE = "migrate";
    private static final String TRANSITION_RESET = "reset";
    private static final String TRANSITION_REVERT = "revert";
    private static final String TRANSITION_SETTING = "adIdTransistion";
    private final DebugProperties debugProperties;
    private GooglePlayServices.AdvertisingInfo gpsAdvertisingInfo;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLogger logger;
    private final Settings settings;
    private boolean shouldSetCurrentAdvertisingIdentifier = true;

    public AdvertisingIdentifier() {
        this(Settings.getInstance(), MobileAdsInfoStore.getInstance(), new MobileAdsLoggerFactory(), DebugProperties.getInstance());
    }

    AdvertisingIdentifier(Settings settings, MobileAdsInfoStore mobileAdsInfoStore, MobileAdsLoggerFactory mobileAdsLoggerFactory, DebugProperties debugProperties) {
        this.settings = settings;
        this.infoStore = mobileAdsInfoStore;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.debugProperties = debugProperties;
    }

    private void determineTransition() {
        String string = this.isTransitionMigrated() ? TRANSITION_MIGRATE : (this.isTransitionReset() ? TRANSITION_RESET : (this.isTransitionReverted() ? TRANSITION_REVERT : null));
        if (string != null) {
            this.setTransition(string);
            return;
        }
        this.logger.d("No transition detected.");
    }

    private String getCurrentGPSAID() {
        return this.settings.getString(GPS_ADVERTISING_IDENTIFIER_SETTING, "");
    }

    private boolean hasCurrentGPSAID() {
        return true ^ StringUtils.isNullOrEmpty(this.getCurrentGPSAID());
    }

    private boolean isTransitionMigrated() {
        return this.infoStore.getRegistrationInfo().hasAdId() && RegistrationInfo.isAdIdOriginatedFromNonAdvertisingIdentifier() && !this.hasCurrentGPSAID() && this.getGPSAdvertisingInfo().hasAdvertisingIdentifier();
    }

    private boolean isTransitionReset() {
        return this.hasCurrentGPSAID() && this.getGPSAdvertisingInfo().hasAdvertisingIdentifier() && !this.getCurrentGPSAID().equals((Object)this.getGPSAdvertisingInfo().getAdvertisingIdentifier());
    }

    private boolean isTransitionReverted() {
        return this.hasCurrentGPSAID() && !this.getGPSAdvertisingInfo().hasAdvertisingIdentifier();
    }

    private void setCurrentGPSAID(String string) {
        this.settings.putString(GPS_ADVERTISING_IDENTIFIER_SETTING, string);
    }

    private void setTransition(String string) {
        this.logger.d("Transition: %s", new Object[]{string});
        this.settings.putString(TRANSITION_SETTING, string);
    }

    protected void fetchGooglePlayServicesAdvertisingIdentifierInfo() {
        this.gpsAdvertisingInfo = new GooglePlayServices().getAdvertisingIdentifierInfo();
    }

    Info getAdvertisingIdentifierInfo() {
        RegistrationInfo registrationInfo;
        if (ThreadUtils.isOnMainThread()) {
            this.logger.e("You must obtain the advertising indentifier information on a background thread.");
            return new Info(this.debugProperties).setCanDo(false);
        }
        this.fetchGooglePlayServicesAdvertisingIdentifierInfo();
        if (this.shouldSetCurrentAdvertisingIdentifier) {
            this.determineTransition();
        }
        Info info = new Info(this.debugProperties);
        if (this.getGPSAdvertisingInfo().hasAdvertisingIdentifier()) {
            info.setAdvertisingIdentifier(this.getGPSAdvertisingInfo().getAdvertisingIdentifier());
            info.setLimitAdTrackingEnabled(this.getGPSAdvertisingInfo().isLimitAdTrackingEnabled());
            if (this.shouldSetCurrentAdvertisingIdentifier) {
                this.setCurrentGPSAID(this.getGPSAdvertisingInfo().getAdvertisingIdentifier());
            }
        }
        if ((registrationInfo = this.infoStore.getRegistrationInfo()).isAdIdCurrent(info)) {
            info.setSISDeviceIdentifier(registrationInfo.getAdId());
            return info;
        }
        registrationInfo.requestNewSISDeviceIdentifier();
        return info;
    }

    String getAndClearTransition() {
        String string = this.settings.getString(TRANSITION_SETTING, null);
        this.settings.remove(TRANSITION_SETTING);
        return string;
    }

    protected GooglePlayServices.AdvertisingInfo getGPSAdvertisingInfo() {
        return this.gpsAdvertisingInfo;
    }

    AdvertisingIdentifier setShouldSetCurrentAdvertisingIdentifier(boolean bl) {
        this.shouldSetCurrentAdvertisingIdentifier = bl;
        return this;
    }

    static class Info {
        private String advertisingIdentifier;
        private boolean canDo;
        private final DebugProperties debugProperties;
        private boolean limitAdTrackingEnabled;
        private String sisDeviceIdentifier;

        private Info(DebugProperties debugProperties) {
            this.debugProperties = debugProperties;
            this.canDo = true;
        }

        private Info setAdvertisingIdentifier(String string) {
            this.advertisingIdentifier = string;
            return this;
        }

        private Info setCanDo(boolean bl) {
            this.canDo = bl;
            return this;
        }

        private Info setLimitAdTrackingEnabled(boolean bl) {
            this.limitAdTrackingEnabled = bl;
            return this;
        }

        boolean canDo() {
            return this.canDo;
        }

        String getAdvertisingIdentifier() {
            return this.debugProperties.getDebugPropertyAsString("debug.idfa", this.advertisingIdentifier);
        }

        String getSISDeviceIdentifier() {
            return this.debugProperties.getDebugPropertyAsString("debug.adid", this.sisDeviceIdentifier);
        }

        boolean hasAdvertisingIdentifier() {
            return true ^ StringUtils.isNullOrEmpty(this.getAdvertisingIdentifier());
        }

        boolean hasSISDeviceIdentifier() {
            return this.getSISDeviceIdentifier() != null;
        }

        boolean isLimitAdTrackingEnabled() {
            return this.debugProperties.getDebugPropertyAsBoolean("debug.optOut", this.limitAdTrackingEnabled);
        }

        Info setSISDeviceIdentifier(String string) {
            this.sisDeviceIdentifier = string;
            return this;
        }
    }

}

