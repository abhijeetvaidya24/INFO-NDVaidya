/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.File
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AppInfo;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.SISRegistration;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.UserAgentManager;
import java.io.File;

class MobileAdsInfoStore {
    private static MobileAdsInfoStore instance = new MobileAdsInfoStore(Settings.getInstance(), DebugProperties.getInstance());
    private AppInfo appInfo;
    protected Context applicationContext;
    private boolean contextReceived;
    private final DebugProperties debugProperties;
    private DeviceInfo deviceInfo;
    private File filesDirectory;
    private boolean isAppDisabled = false;
    private boolean isRegistered;
    private long noRetryTtlExpiresMillis;
    private int noRetryTtlMillis;
    private RegistrationInfo registrationInfo;
    private final Settings settings;
    private SISRegistration sisRegistration;

    protected MobileAdsInfoStore(Settings settings, DebugProperties debugProperties) {
        this.settings = settings;
        this.debugProperties = debugProperties;
        this.registrationInfo = new RegistrationInfo();
    }

    public static MobileAdsInfoStore getInstance() {
        return instance;
    }

    static void setMobileAdsInfoStore(MobileAdsInfoStore mobileAdsInfoStore) {
        instance = mobileAdsInfoStore;
    }

    public void contextReceived(Context context) {
        MobileAdsInfoStore mobileAdsInfoStore = this;
        synchronized (mobileAdsInfoStore) {
            if (!this.contextReceived) {
                this.contextReceived = true;
                this.setApplicationContextFromContext(context);
                this.setFilesDirectory(context);
                this.settings.contextReceived(context);
                this.createAppInfo(context);
                this.deviceInfo = this.createDeviceInfo(context);
                this.createSISRegistration();
            }
            return;
        }
    }

    protected void createAppInfo(Context context) {
        this.appInfo = new AppInfo(context);
    }

    protected DeviceInfo createDeviceInfo(Context context) {
        return new DeviceInfo(context, new UserAgentManager());
    }

    protected void createSISRegistration() {
        this.sisRegistration = new SISRegistration();
    }

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    public Context getApplicationContext() {
        return this.applicationContext;
    }

    public DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public File getFilesDir() {
        return this.filesDirectory;
    }

    public boolean getIsAppDisabled() {
        return this.isAppDisabled;
    }

    public int getNoRetryTtlRemainingMillis() {
        if (this.noRetryTtlMillis != 0) {
            long l2;
            if (this.noRetryTtlExpiresMillis == 0L) {
                return 0;
            }
            long l3 = System.currentTimeMillis();
            if (l3 >= (l2 = this.noRetryTtlExpiresMillis)) {
                this.noRetryTtlMillis = 0;
                this.noRetryTtlExpiresMillis = 0L;
                return 0;
            }
            return (int)(l2 - l3);
        }
        return 0;
    }

    public RegistrationInfo getRegistrationInfo() {
        return this.registrationInfo;
    }

    public SISRegistration getSISRegistration() {
        return this.sisRegistration;
    }

    public boolean isContextReceived() {
        return this.contextReceived;
    }

    public boolean isRegistered() {
        return this.isRegistered;
    }

    public void register() {
        this.getSISRegistration().registerApp();
        this.isRegistered = true;
    }

    protected void setApplicationContextFromContext(Context context) {
        this.applicationContext = context.getApplicationContext();
    }

    protected void setFilesDirectory(Context context) {
        this.filesDirectory = context.getFilesDir();
    }

    public void setIsAppDisabled(boolean bl) {
        this.isAppDisabled = bl;
    }

    public void setNoRetryTtl(int n) {
        int n2 = this.debugProperties.getDebugPropertyAsInteger("debug.noRetryTTLMax", 300000);
        if (n2 < n) {
            n = n2;
        }
        if (n == 0) {
            this.noRetryTtlMillis = 0;
            this.noRetryTtlExpiresMillis = 0L;
            return;
        }
        this.noRetryTtlMillis = n * 1000;
        this.noRetryTtlExpiresMillis = System.currentTimeMillis() + (long)this.noRetryTtlMillis;
    }
}

