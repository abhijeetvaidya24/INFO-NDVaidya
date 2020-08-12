/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.WebUtils;

class RegistrationInfo {
    private static final String ADID_ORIGIN_PREF_NAME = "amzn-ad-id-origin";
    private static final String ADID_PREF_NAME = "amzn-ad-id";
    private static final String NEW_SIS_DID_REQUESTED_SETTING = "newSISDIDRequested";
    private static final String NON_ADVERTISING_IDENTIFIER_ORIGIN = "non-advertising-identifier";
    private static final String THIRD_PARTY_APP_NAME = "app";
    private String appKey;
    private String appName = "app";

    public static boolean isAdIdOriginatedFromNonAdvertisingIdentifier() {
        String string = Settings.getInstance().getString(ADID_ORIGIN_PREF_NAME, null);
        return string == null || NON_ADVERTISING_IDENTIFIER_ORIGIN.equals((Object)string);
        {
        }
    }

    protected static void setOrigin(AdvertisingIdentifier.Info info) {
        if (info.hasAdvertisingIdentifier()) {
            Settings.getInstance().putStringWithNoFlush(ADID_ORIGIN_PREF_NAME, info.getAdvertisingIdentifier());
            return;
        }
        Settings.getInstance().putStringWithNoFlush(ADID_ORIGIN_PREF_NAME, NON_ADVERTISING_IDENTIFIER_ORIGIN);
    }

    public String getAdId() {
        return DebugProperties.getInstance().getDebugPropertyAsString("debug.adid", Settings.getInstance().getString(ADID_PREF_NAME, null));
    }

    public String getAppKey() {
        return DebugProperties.getInstance().getDebugPropertyAsString("debug.appid", this.appKey);
    }

    public String getAppName() {
        return this.appName;
    }

    public boolean hasAdId() {
        return true ^ StringUtils.isNullOrEmpty(this.getAdId());
    }

    public boolean isAdIdCurrent(AdvertisingIdentifier.Info info) {
        boolean bl = RegistrationInfo.isAdIdOriginatedFromNonAdvertisingIdentifier();
        if (info.hasAdvertisingIdentifier()) {
            if (bl) {
                return false;
            }
            String string = Settings.getInstance().getString(ADID_ORIGIN_PREF_NAME, null);
            return info.getAdvertisingIdentifier().equals((Object)string);
        }
        return bl;
    }

    public boolean isRegisteredWithSIS() {
        return this.hasAdId();
    }

    public void putAdId(String string, AdvertisingIdentifier.Info info) {
        Settings settings = Settings.getInstance();
        settings.putStringWithNoFlush(ADID_PREF_NAME, string);
        RegistrationInfo.setOrigin(info);
        settings.putBooleanWithNoFlush(NEW_SIS_DID_REQUESTED_SETTING, false);
        settings.flush();
    }

    public void putAppKey(String string) {
        if (string != null && string.length() != 0) {
            this.appKey = WebUtils.getURLEncodedString(string);
            return;
        }
        throw new IllegalArgumentException("Application Key must not be null or empty.");
    }

    public void putAppName(String string) {
        this.appName = WebUtils.getURLEncodedString(string);
    }

    public void requestNewSISDeviceIdentifier() {
        Settings.getInstance().putBoolean(NEW_SIS_DID_REQUESTED_SETTING, true);
    }

    public boolean shouldGetNewSISDeviceIdentifer() {
        return Settings.getInstance().getBoolean(NEW_SIS_DID_REQUESTED_SETTING, false);
    }

    public boolean shouldGetNewSISRegistration() {
        return true ^ this.isRegisteredWithSIS();
    }
}

