/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.CountDownTimer
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.config.ConfigValidationResult;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ApplicationConfigurations;
import com.ironsource.mediationsdk.model.Configurations;
import com.ironsource.mediationsdk.model.ServerSegmetData;
import com.ironsource.mediationsdk.sdk.GeneralProperties;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.ServerResponseWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

class MediationInitializer
implements NetworkStateReceiver.NetworkStateReceiverListener {
    private static MediationInitializer sInstance;
    private final String GENERAL_PROPERTIES_APP_KEY = "appKey";
    private final String GENERAL_PROPERTIES_USER_ID = "userId";
    private final String TAG = this.getClass().getSimpleName();
    private InitRunnable initRunnable = new InitRunnable(){

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void run() {
            try {
                IronSourceObject ironSourceObject = IronSourceObject.getInstance();
                boolean bl = MediationInitializer.this.validateUserId(MediationInitializer.this.mUserId).isValid();
                if (bl) {
                    MediationInitializer.this.mUserIdType = "userGenerated";
                } else {
                    MediationInitializer.this.mUserId = ironSourceObject.getAdvertiserId((Context)MediationInitializer.this.mActivity);
                    if (!TextUtils.isEmpty((CharSequence)MediationInitializer.this.mUserId)) {
                        MediationInitializer.this.mUserIdType = "GAID";
                    } else {
                        MediationInitializer.this.mUserId = DeviceStatus.getOrGenerateOnceUniqueIdentifier((Context)MediationInitializer.this.mActivity);
                        if (!TextUtils.isEmpty((CharSequence)MediationInitializer.this.mUserId)) {
                            MediationInitializer.this.mUserIdType = "UUID";
                        } else {
                            MediationInitializer.this.mUserId = "";
                        }
                    }
                    ironSourceObject.setIronSourceUserId(MediationInitializer.this.mUserId);
                }
                GeneralProperties.getProperties().putKey("userIdType", MediationInitializer.this.mUserIdType);
                if (!TextUtils.isEmpty((CharSequence)MediationInitializer.this.mUserId)) {
                    GeneralProperties.getProperties().putKey("userId", MediationInitializer.this.mUserId);
                }
                if (!TextUtils.isEmpty((CharSequence)MediationInitializer.this.mAppKey)) {
                    GeneralProperties.getProperties().putKey("appKey", MediationInitializer.this.mAppKey);
                }
                MediationInitializer.this.mServerResponseWrapper = ironSourceObject.getServerResponse((Context)MediationInitializer.this.mActivity, MediationInitializer.this.mUserId, this.listener);
                if (MediationInitializer.this.mServerResponseWrapper != null) {
                    MediationInitializer.this.mHandler.removeCallbacks((Runnable)this);
                    if (MediationInitializer.this.mServerResponseWrapper.isValidResponse()) {
                        MediationInitializer.this.setInitStatus(EInitStatus.INITIATED);
                        if (MediationInitializer.this.mServerResponseWrapper.getConfigurations().getApplicationConfigurations().getIntegration()) {
                            IntegrationHelper.validateIntegration(MediationInitializer.this.mActivity);
                        }
                        List<IronSource.AD_UNIT> list = MediationInitializer.this.mServerResponseWrapper.getInitiatedAdUnits();
                        Iterator iterator = MediationInitializer.this.mOnMediationInitializationListeners.iterator();
                        while (iterator.hasNext()) {
                            (iterator.next()).onInitSuccess(list, MediationInitializer.this.wasInitRevived());
                        }
                        if (MediationInitializer.this.mSegmentListener == null) return;
                        ServerSegmetData serverSegmetData = MediationInitializer.this.mServerResponseWrapper.getConfigurations().getApplicationConfigurations().getSegmetData();
                        if (serverSegmetData != null) {
                            MediationInitializer.this.mSegmentListener.onSegmentReceived(serverSegmetData.getSegmentName());
                            return;
                        }
                        MediationInitializer.this.mSegmentListener.onSegmentReceived("");
                        return;
                    }
                    if (MediationInitializer.this.mDidReportInitialAvailability) return;
                    MediationInitializer.this.setInitStatus(EInitStatus.INIT_FAILED);
                    MediationInitializer.this.mDidReportInitialAvailability = true;
                    Iterator iterator = MediationInitializer.this.mOnMediationInitializationListeners.iterator();
                    while (iterator.hasNext()) {
                        (iterator.next()).onInitFailed("serverResponseIsNotValid");
                    }
                    return;
                }
                if (MediationInitializer.this.mRetryCounter == 3) {
                    MediationInitializer.this.mIsInProgressMoreThan15Secs = true;
                    Iterator iterator = MediationInitializer.this.mOnMediationInitializationListeners.iterator();
                    while (iterator.hasNext()) {
                        (iterator.next()).onStillInProgressAfter15Secs();
                    }
                }
                if (this.isRecoverable && MediationInitializer.this.mRetryCounter < MediationInitializer.this.mRetryLimit) {
                    MediationInitializer.this.mIsRevived = true;
                    MediationInitializer.this.mHandler.postDelayed((Runnable)this, (long)(1000 * MediationInitializer.this.mRetryDelay));
                    if (MediationInitializer.this.mRetryCounter < MediationInitializer.this.mRetryGrowLimit) {
                        MediationInitializer.this.mRetryDelay = 2 * MediationInitializer.this.mRetryDelay;
                    }
                }
                if (!(this.isRecoverable && MediationInitializer.this.mRetryCounter != MediationInitializer.this.mRetryAvailabilityLimit || MediationInitializer.this.mDidReportInitialAvailability)) {
                    MediationInitializer.this.mDidReportInitialAvailability = true;
                    if (TextUtils.isEmpty((CharSequence)this.reason)) {
                        this.reason = "noServerResponse";
                    }
                    Iterator iterator = MediationInitializer.this.mOnMediationInitializationListeners.iterator();
                    while (iterator.hasNext()) {
                        (iterator.next()).onInitFailed(this.reason);
                    }
                    MediationInitializer.this.setInitStatus(EInitStatus.INIT_FAILED);
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No server response", 1);
                }
                MediationInitializer.access$1208(MediationInitializer.this);
                return;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    };
    private Activity mActivity;
    private String mAppKey;
    private AtomicBoolean mAtomicShouldPerformInit;
    private CountDownTimer mCountDownTimer;
    private boolean mDidReportInitialAvailability = false;
    private Handler mHandler;
    private HandlerThread mHandlerThread = new HandlerThread("IronSourceInitiatorHandler");
    private EInitStatus mInitStatus = EInitStatus.NOT_INIT;
    private boolean mIsInProgressMoreThan15Secs;
    private boolean mIsRevived;
    private boolean mListenForInit = false;
    private NetworkStateReceiver mNetworkStateReceiver;
    private List<OnMediationInitializationListener> mOnMediationInitializationListeners = new ArrayList();
    private int mRetryAvailabilityLimit;
    private int mRetryCounter;
    private int mRetryDelay;
    private int mRetryGrowLimit;
    private int mRetryLimit;
    private SegmentListener mSegmentListener;
    private ServerResponseWrapper mServerResponseWrapper;
    private String mUserId;
    private String mUserIdType;

    private MediationInitializer() {
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mRetryDelay = 1;
        this.mRetryCounter = 0;
        this.mRetryLimit = 62;
        this.mRetryGrowLimit = 12;
        this.mRetryAvailabilityLimit = 5;
        this.mAtomicShouldPerformInit = new AtomicBoolean(true);
        this.mIsRevived = false;
        this.mIsInProgressMoreThan15Secs = false;
    }

    static /* synthetic */ int access$1208(MediationInitializer mediationInitializer) {
        int n2 = mediationInitializer.mRetryCounter;
        mediationInitializer.mRetryCounter = n2 + 1;
        return n2;
    }

    static /* synthetic */ CountDownTimer access$1902(MediationInitializer mediationInitializer, CountDownTimer countDownTimer) {
        mediationInitializer.mCountDownTimer = countDownTimer;
        return countDownTimer;
    }

    public static MediationInitializer getInstance() {
        Class<MediationInitializer> class_ = MediationInitializer.class;
        synchronized (MediationInitializer.class) {
            if (sInstance == null) {
                sInstance = new MediationInitializer();
            }
            MediationInitializer mediationInitializer = sInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return mediationInitializer;
        }
    }

    private void setInitStatus(EInitStatus eInitStatus) {
        MediationInitializer mediationInitializer = this;
        synchronized (mediationInitializer) {
            IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("setInitStatus(old status: ");
            stringBuilder.append((Object)this.mInitStatus);
            stringBuilder.append(", new status: ");
            stringBuilder.append((Object)eInitStatus);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
            this.mInitStatus = eInitStatus;
            return;
        }
    }

    private boolean validateLength(String string, int n2, int n3) {
        if (string == null) {
            return false;
        }
        int n4 = string.length();
        boolean bl = false;
        if (n4 >= n2) {
            int n5 = string.length();
            bl = false;
            if (n5 <= n3) {
                bl = true;
            }
        }
        return bl;
    }

    private ConfigValidationResult validateUserId(String string) {
        ConfigValidationResult configValidationResult = new ConfigValidationResult();
        if (string != null) {
            if (!this.validateLength(string, 1, 64)) {
                configValidationResult.setInvalid(ErrorBuilder.buildInvalidCredentialsError("userId", string, null));
                return configValidationResult;
            }
        } else {
            configValidationResult.setInvalid(ErrorBuilder.buildInvalidCredentialsError("userId", string, "it's missing"));
        }
        return configValidationResult;
    }

    private boolean wasInitRevived() {
        return this.mIsRevived;
    }

    public void addMediationInitializationListener(OnMediationInitializationListener onMediationInitializationListener) {
        if (onMediationInitializationListener == null) {
            return;
        }
        this.mOnMediationInitializationListeners.add((Object)onMediationInitializationListener);
    }

    public EInitStatus getCurrentInitStatus() {
        MediationInitializer mediationInitializer = this;
        synchronized (mediationInitializer) {
            EInitStatus eInitStatus = this.mInitStatus;
            return eInitStatus;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* varargs */ void init(Activity activity, String string, String string2, IronSource.AD_UNIT ... arraD_UNIT) {
        MediationInitializer mediationInitializer = this;
        synchronized (mediationInitializer) {
            try {
                try {
                    if (this.mAtomicShouldPerformInit != null && this.mAtomicShouldPerformInit.compareAndSet(true, false)) {
                        this.setInitStatus(EInitStatus.INIT_IN_PROGRESS);
                        this.mActivity = activity;
                        this.mUserId = string2;
                        this.mAppKey = string;
                        if (IronSourceUtils.isNetworkConnected((Context)activity)) {
                            this.mHandler.post((Runnable)this.initRunnable);
                        } else {
                            this.mListenForInit = true;
                            if (this.mNetworkStateReceiver == null) {
                                this.mNetworkStateReceiver = new NetworkStateReceiver((Context)activity, this);
                            }
                            activity.getApplicationContext().registerReceiver((BroadcastReceiver)this.mNetworkStateReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                            new Handler(Looper.getMainLooper()).post(new Runnable(this){
                                final /* synthetic */ MediationInitializer this$0;
                                {
                                    this.this$0 = mediationInitializer;
                                }

                                public void run() {
                                    MediationInitializer mediationInitializer = this.this$0;
                                    CountDownTimer countDownTimer = new CountDownTimer(this, 60000L, 15000L){
                                        final /* synthetic */ 2 this$1;
                                        {
                                            this.this$1 = var1_1;
                                            super(l2, l3);
                                        }

                                        public void onFinish() {
                                            if (!MediationInitializer.access$1100(this.this$1.this$0)) {
                                                MediationInitializer.access$1102(this.this$1.this$0, true);
                                                Iterator iterator = MediationInitializer.access$800(this.this$1.this$0).iterator();
                                                while (iterator.hasNext()) {
                                                    (iterator.next()).onInitFailed("noInternetConnection");
                                                }
                                                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No internet connection", 1);
                                            }
                                        }

                                        public void onTick(long l2) {
                                            if (l2 <= 45000L) {
                                                MediationInitializer.access$1302(this.this$1.this$0, true);
                                                Iterator iterator = MediationInitializer.access$800(this.this$1.this$0).iterator();
                                                while (iterator.hasNext()) {
                                                    (iterator.next()).onStillInProgressAfter15Secs();
                                                }
                                            }
                                        }
                                    };
                                    MediationInitializer.access$1902(mediationInitializer, countDownTimer.start());
                                }
                            });
                        }
                    } else {
                        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
                        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(this.TAG);
                        stringBuilder.append(": Multiple calls to init are not allowed");
                        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 2);
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                return;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    public boolean isInProgressMoreThan15Secs() {
        MediationInitializer mediationInitializer = this;
        synchronized (mediationInitializer) {
            boolean bl = this.mIsInProgressMoreThan15Secs;
            return bl;
        }
    }

    @Override
    public void onNetworkAvailabilityChanged(boolean bl) {
        if (this.mListenForInit && bl) {
            CountDownTimer countDownTimer = this.mCountDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.mListenForInit = false;
            this.mIsRevived = true;
            this.mHandler.post((Runnable)this.initRunnable);
        }
    }

    void setSegmentListener(SegmentListener segmentListener) {
        this.mSegmentListener = segmentListener;
    }

}

