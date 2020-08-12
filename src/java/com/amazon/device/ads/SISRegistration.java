/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.amazon.device.ads.MobileAdsLogger
 *  com.amazon.device.ads.SISDeviceRequest
 *  com.amazon.device.ads.SISRegisterEventRequest
 *  com.amazon.device.ads.SISRegistration$2
 *  com.amazon.device.ads.SISRegistration$RegisterEventsSISRequestorCallback
 *  com.amazon.device.ads.ThreadUtils$SingleThreadScheduler
 *  java.lang.Boolean
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONArray
 */
package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.AppEventRegistrationHandler;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.MobileAdsInfoStore;
import com.amazon.device.ads.MobileAdsLogger;
import com.amazon.device.ads.MobileAdsLoggerFactory;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.SISDeviceRequest;
import com.amazon.device.ads.SISRegisterEventRequest;
import com.amazon.device.ads.SISRegistration;
import com.amazon.device.ads.SISRequest;
import com.amazon.device.ads.SISRequestor;
import com.amazon.device.ads.SISRequestorCallback;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.SystemTime;
import com.amazon.device.ads.ThreadUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

/*
 * Exception performing whole class analysis.
 */
class SISRegistration {
    protected static final long DEFAULT_SIS_CHECKIN_INTERVAL = 86400000L;
    private static final String LOGTAG = "SISRegistration";
    private static final String SIS_LAST_CHECKIN_PREF_NAME = "amzn-ad-sis-last-checkin";
    private static final ThreadUtils.SingleThreadScheduler singleThreadScheduler;
    private final AdvertisingIdentifier advertisingIdentifier;
    private final AppEventRegistrationHandler appEventRegistrationHandler;
    private final Configuration configuration;
    private final DebugProperties debugProperties;
    private final ThreadUtils.RunnableExecutor executor;
    private final MobileAdsInfoStore infoStore;
    private final MobileAdsLogger logger;
    private final Settings settings;
    private final SISRequest.SISRequestFactory sisRequestFactory;
    private final SISRequestor.SISRequestorFactory sisRequestorFactory;
    private final SystemTime systemTime;
    private final ThreadUtils.ThreadVerify threadVerify;

    static {
        singleThreadScheduler = new /* Unavailable Anonymous Inner Class!! */;
    }

    public SISRegistration() {
        this(new SISRequest.SISRequestFactory(), new SISRequestor.SISRequestorFactory(), new AdvertisingIdentifier(), MobileAdsInfoStore.getInstance(), Configuration.getInstance(), Settings.getInstance(), AppEventRegistrationHandler.getInstance(), new SystemTime(), (ThreadUtils.RunnableExecutor)singleThreadScheduler, new ThreadUtils.ThreadVerify(), new MobileAdsLoggerFactory(), DebugProperties.getInstance());
    }

    SISRegistration(SISRequest.SISRequestFactory sISRequestFactory, SISRequestor.SISRequestorFactory sISRequestorFactory, AdvertisingIdentifier advertisingIdentifier, MobileAdsInfoStore mobileAdsInfoStore, Configuration configuration, Settings settings, AppEventRegistrationHandler appEventRegistrationHandler, SystemTime systemTime, ThreadUtils.RunnableExecutor runnableExecutor, ThreadUtils.ThreadVerify threadVerify, MobileAdsLoggerFactory mobileAdsLoggerFactory, DebugProperties debugProperties) {
        this.sisRequestFactory = sISRequestFactory;
        this.sisRequestorFactory = sISRequestorFactory;
        this.advertisingIdentifier = advertisingIdentifier;
        this.infoStore = mobileAdsInfoStore;
        this.configuration = configuration;
        this.settings = settings;
        this.appEventRegistrationHandler = appEventRegistrationHandler;
        this.systemTime = systemTime;
        this.executor = runnableExecutor;
        this.threadVerify = threadVerify;
        this.logger = mobileAdsLoggerFactory.createMobileAdsLogger(LOGTAG);
        this.debugProperties = debugProperties;
    }

    static /* synthetic */ MobileAdsLogger access$000(SISRegistration sISRegistration) {
        return sISRegistration.getLogger();
    }

    private MobileAdsLogger getLogger() {
        return this.logger;
    }

    private void putLastSISCheckin(long l2) {
        this.settings.putLong(SIS_LAST_CHECKIN_PREF_NAME, l2);
    }

    protected boolean canRegister(long l2) {
        boolean bl;
        block3 : {
            block2 : {
                RegistrationInfo registrationInfo = this.infoStore.getRegistrationInfo();
                if (this.exceededCheckinInterval(l2) || registrationInfo.shouldGetNewSISDeviceIdentifer() || registrationInfo.shouldGetNewSISRegistration()) break block2;
                boolean bl2 = this.debugProperties.getDebugPropertyAsBoolean("debug.shouldRegisterSIS", false);
                bl = false;
                if (!bl2) break block3;
            }
            bl = true;
        }
        return bl;
    }

    protected boolean exceededCheckinInterval(long l2) {
        return l2 - this.getLastSISCheckin() > this.debugProperties.getDebugPropertyAsLong("debug.sisCheckinInterval", 86400000L);
    }

    protected long getLastSISCheckin() {
        return this.settings.getLong(SIS_LAST_CHECKIN_PREF_NAME, 0L);
    }

    protected void register(AdvertisingIdentifier advertisingIdentifier) {
        SISDeviceRequest sISDeviceRequest = this.sisRequestFactory.createDeviceRequest(SISRequest.SISDeviceRequestType.GENERATE_DID, advertisingIdentifier);
        RegisterEventsSISRequestorCallback registerEventsSISRequestorCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.sisRequestorFactory.createSISRequestor((SISRequestorCallback)registerEventsSISRequestorCallback, new SISRequest[]{sISDeviceRequest}).startCallSIS();
    }

    public void registerApp() {
        Runnable runnable = new Runnable(){

            public void run() {
                SISRegistration.this.waitForConfigurationThenBeginRegistration();
            }
        };
        this.executor.execute(runnable);
    }

    void registerAppWorker() {
        long l2 = this.systemTime.currentTimeMillis();
        if (this.advertisingIdentifier.getAdvertisingIdentifierInfo().canDo() && this.canRegister(l2)) {
            this.putLastSISCheckin(l2);
            if (this.shouldUpdateDeviceInfo()) {
                this.updateDeviceInfo(this.advertisingIdentifier);
                return;
            }
            this.register(this.advertisingIdentifier);
        }
    }

    protected void registerEvents() {
        JSONArray jSONArray;
        if (this.threadVerify.isOnMainThread()) {
            this.getLogger().e("Registering events must be done on a background thread.");
            return;
        }
        AdvertisingIdentifier.Info info = this.advertisingIdentifier.getAdvertisingIdentifierInfo();
        if (info.hasSISDeviceIdentifier() && (jSONArray = this.appEventRegistrationHandler.getAppEventsJSONArray()) != null) {
            SISRegisterEventRequest sISRegisterEventRequest = this.sisRequestFactory.createRegisterEventRequest(info, jSONArray);
            this.sisRequestorFactory.createSISRequestor(new SISRequest[]{sISRegisterEventRequest}).startCallSIS();
        }
    }

    protected boolean shouldUpdateDeviceInfo() {
        return this.infoStore.getRegistrationInfo().isRegisteredWithSIS();
    }

    protected void updateDeviceInfo(AdvertisingIdentifier advertisingIdentifier) {
        SISDeviceRequest sISDeviceRequest = this.sisRequestFactory.createDeviceRequest(SISRequest.SISDeviceRequestType.UPDATE_DEVICE_INFO, advertisingIdentifier);
        RegisterEventsSISRequestorCallback registerEventsSISRequestorCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.sisRequestorFactory.createSISRequestor((SISRequestorCallback)registerEventsSISRequestorCallback, new SISRequest[]{sISDeviceRequest}).startCallSIS();
    }

    void waitForConfigurationThenBeginRegistration() {
        AtomicBoolean atomicBoolean;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        atomicBoolean = new AtomicBoolean(false);
        this.configuration.queueConfigurationListener((Configuration.ConfigurationListener)new 2(this, atomicBoolean, countDownLatch));
        try {
            countDownLatch.await();
        }
        catch (InterruptedException interruptedException) {}
        if (atomicBoolean.get()) {
            this.registerAppWorker();
        }
    }

}

