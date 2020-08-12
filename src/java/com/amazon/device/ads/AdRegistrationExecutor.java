/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.amazon.device.ads.MobileAdsLogger
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.PermissionChecker;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.UserAgentManager;
import com.amazon.device.ads.Version;

class AdRegistrationExecutor {
    private final MobileAdsInfoStore infoStore;
    private volatile boolean isInitialized = false;
    private final MobileAdsLogger logger;
    private final MobileAdsLoggerFactory loggerFactory;
    private final PermissionChecker permissionChecker;
    private final Settings settings;

    public AdRegistrationExecutor(String string) {
        this(string, MobileAdsInfoStore.getInstance(), Settings.getInstance(), new MobileAdsLoggerFactory(), new PermissionChecker());
    }

    AdRegistrationExecutor(String string, MobileAdsInfoStore mobileAdsInfoStore, Settings settings, MobileAdsLoggerFactory mobileAdsLoggerFactory, PermissionChecker permissionChecker) {
        this.infoStore = mobileAdsInfoStore;
        this.settings = settings;
        this.loggerFactory = mobileAdsLoggerFactory;
        this.logger = this.loggerFactory.createMobileAdsLogger(string);
        this.permissionChecker = permissionChecker;
    }

    public void enableLogging(boolean bl) {
        this.logger.enableLoggingWithSetterNotification(bl);
    }

    public void enableTesting(boolean bl) {
        this.settings.putTransientBoolean("testingEnabled", bl);
        this.logger.logSetterNotification("Test mode", (Object)bl);
    }

    MobileAdsLogger getLogger() {
        return this.logger;
    }

    MobileAdsLoggerFactory getLoggerFactory() {
        return this.loggerFactory;
    }

    MobileAdsInfoStore getMobileAdsInfoStore() {
        return this.infoStore;
    }

    PermissionChecker getPermissionChecker() {
        return this.permissionChecker;
    }

    Settings getSettings() {
        return this.settings;
    }

    public String getVersion() {
        return Version.getSDKVersion();
    }

    public void initializeAds(Context context) {
        if (!this.isInitialized) {
            this.infoStore.contextReceived(context);
            this.infoStore.getDeviceInfo().setUserAgentManager(new UserAgentManager());
            this.isInitialized = true;
        }
    }

    public void registerApp(Context context) {
        if (!this.permissionChecker.hasInternetPermission(context)) {
            this.logger.e("Network task cannot commence because the INTERNET permission is missing from the app's manifest.");
            return;
        }
        this.initializeAds(context);
        this.infoStore.register();
    }

    public void setAppKey(String string) throws IllegalArgumentException {
        this.infoStore.getRegistrationInfo().putAppKey(string);
    }
}

