/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  com.ironsource.mediationsdk.AbstractAdapter
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.TimerTask
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.ProviderSettings;
import java.util.TimerTask;

public abstract class AbstractSmash {
    final String MAX_ADS_PER_DAY_KEY = "maxAdsPerDay";
    final String MAX_ADS_PER_ITERATION_KEY = "maxAdsPerIteration";
    final String MAX_ADS_PER_SESSION_KEY = "maxAdsPerSession";
    AbstractAdapter mAdapter;
    ProviderSettings mAdapterConfigs;
    TimerTask mInitTimerTask;
    String mInstanceName;
    boolean mIsInForeground;
    boolean mIsMultipleInstances;
    int mIterationShowCounter;
    TimerTask mLoadTimerTask;
    IronSourceLoggerManager mLoggerManager;
    int mMaxAdsPerDay;
    int mMaxAdsPerIteration;
    int mMaxAdsPerSession;
    MEDIATION_STATE mMediationState;
    String mName;
    String mNameForReflection;
    int mProviderPriority;
    int mSessionShowCounter;
    String mSpId;

    AbstractSmash(ProviderSettings providerSettings) {
        this.mNameForReflection = providerSettings.getProviderTypeForReflection();
        this.mInstanceName = providerSettings.getProviderInstanceName();
        this.mIsMultipleInstances = providerSettings.isMultipleInstances();
        this.mAdapterConfigs = providerSettings;
        this.mSpId = providerSettings.getSubProviderId();
        this.mIterationShowCounter = 0;
        this.mSessionShowCounter = 0;
        this.mMediationState = MEDIATION_STATE.NOT_INITIATED;
        this.mLoggerManager = IronSourceLoggerManager.getLogger();
        this.mIsInForeground = true;
        if (this.mIsMultipleInstances) {
            this.mName = this.mNameForReflection;
            return;
        }
        this.mName = providerSettings.getProviderName();
    }

    abstract void completeIteration();

    protected abstract String getAdUnitString();

    public AbstractAdapter getAdapter() {
        return this.mAdapter;
    }

    String getInstanceName() {
        return this.mInstanceName;
    }

    public int getMaxAdsPerDay() {
        return this.mMaxAdsPerDay;
    }

    int getMaxAdsPerIteration() {
        return this.mMaxAdsPerIteration;
    }

    int getMaxAdsPerSession() {
        return this.mMaxAdsPerSession;
    }

    MEDIATION_STATE getMediationState() {
        return this.mMediationState;
    }

    public String getName() {
        return this.mName;
    }

    String getNameForReflection() {
        return this.mNameForReflection;
    }

    public int getProviderPriority() {
        return this.mProviderPriority;
    }

    public String getSubProviderId() {
        return this.mSpId;
    }

    boolean isCappedPerDay() {
        return this.mMediationState == MEDIATION_STATE.CAPPED_PER_DAY;
    }

    boolean isCappedPerSession() {
        return this.mSessionShowCounter >= this.mMaxAdsPerSession;
    }

    boolean isExhausted() {
        return this.mIterationShowCounter >= this.mMaxAdsPerIteration;
    }

    boolean isMediationAvailable() {
        return !this.isExhausted() && !this.isCappedPerSession() && !this.isCappedPerDay();
    }

    public void onPause(Activity activity) {
        AbstractAdapter abstractAdapter = this.mAdapter;
        if (abstractAdapter != null) {
            abstractAdapter.onPause(activity);
        }
        this.mIsInForeground = false;
    }

    public void onResume(Activity activity) {
        AbstractAdapter abstractAdapter = this.mAdapter;
        if (abstractAdapter != null) {
            abstractAdapter.onResume(activity);
        }
        this.mIsInForeground = true;
    }

    void preShow() {
        this.mIterationShowCounter = 1 + this.mIterationShowCounter;
        this.mSessionShowCounter = 1 + this.mSessionShowCounter;
        if (this.isCappedPerSession()) {
            this.setMediationState(MEDIATION_STATE.CAPPED_PER_SESSION);
            return;
        }
        if (this.isExhausted()) {
            this.setMediationState(MEDIATION_STATE.EXHAUSTED);
        }
    }

    void setAdapterForSmash(AbstractAdapter abstractAdapter) {
        this.mAdapter = abstractAdapter;
    }

    public void setAge(int n2) {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getName());
            stringBuilder.append(":setAge(age:");
            stringBuilder.append(n2);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mAdapter.setAge(n2);
        }
    }

    void setConsent(boolean bl2) {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getName());
            stringBuilder.append(" | ");
            stringBuilder.append(this.getAdUnitString());
            stringBuilder.append("| setConsent(consent:");
            stringBuilder.append(bl2);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mAdapter.setConsent(bl2);
        }
    }

    public void setGender(String string) {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getName());
            stringBuilder.append(":setGender(gender:");
            stringBuilder.append(string);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mAdapter.setGender(string);
        }
    }

    public void setMediationSegment(String string) {
        if (this.mAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.getName());
            stringBuilder.append(":setMediationSegment(segment:");
            stringBuilder.append(string);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mAdapter.setMediationSegment(string);
        }
    }

    void setMediationState(MEDIATION_STATE mEDIATION_STATE) {
        AbstractSmash abstractSmash = this;
        synchronized (abstractSmash) {
            block5 : {
                MEDIATION_STATE mEDIATION_STATE2 = this.mMediationState;
                if (mEDIATION_STATE2 != mEDIATION_STATE) break block5;
                return;
            }
            this.mMediationState = mEDIATION_STATE;
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Smart Loading - ");
            stringBuilder.append(this.getInstanceName());
            stringBuilder.append(" state changed to ");
            stringBuilder.append(mEDIATION_STATE.toString());
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
            if (this.mAdapter != null && (mEDIATION_STATE == MEDIATION_STATE.CAPPED_PER_SESSION || mEDIATION_STATE == MEDIATION_STATE.CAPPED_PER_DAY)) {
                this.mAdapter.setMediationState(mEDIATION_STATE, this.getAdUnitString());
            }
            return;
        }
    }

    void setPluginData(String string, String string2) {
        AbstractAdapter abstractAdapter = this.mAdapter;
        if (abstractAdapter != null) {
            abstractAdapter.setPluginData(string, string2);
        }
    }

    void setProviderPriority(int n2) {
        this.mProviderPriority = n2;
    }

    abstract void startInitTimer();

    abstract void startLoadTimer();

    void stopInitTimer() {
        try {
            if (this.mInitTimerTask != null) {
                this.mInitTimerTask.cancel();
                this.mInitTimerTask = null;
                return;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    void stopLoadTimer() {
        try {
            if (this.mLoadTimerTask != null) {
                this.mLoadTimerTask.cancel();
                this.mLoadTimerTask = null;
                return;
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static final class MEDIATION_STATE
    extends Enum<MEDIATION_STATE> {
        private static final /* synthetic */ MEDIATION_STATE[] $VALUES;
        public static final /* enum */ MEDIATION_STATE AVAILABLE;
        public static final /* enum */ MEDIATION_STATE CAPPED_PER_DAY;
        public static final /* enum */ MEDIATION_STATE CAPPED_PER_SESSION;
        public static final /* enum */ MEDIATION_STATE EXHAUSTED;
        public static final /* enum */ MEDIATION_STATE INITIATED;
        public static final /* enum */ MEDIATION_STATE INIT_FAILED;
        public static final /* enum */ MEDIATION_STATE INIT_PENDING;
        public static final /* enum */ MEDIATION_STATE LOAD_PENDING;
        public static final /* enum */ MEDIATION_STATE NOT_AVAILABLE;
        public static final /* enum */ MEDIATION_STATE NOT_INITIATED;
        private int mValue;

        static {
            NOT_INITIATED = new MEDIATION_STATE(0);
            INIT_FAILED = new MEDIATION_STATE(1);
            INITIATED = new MEDIATION_STATE(2);
            AVAILABLE = new MEDIATION_STATE(3);
            NOT_AVAILABLE = new MEDIATION_STATE(4);
            EXHAUSTED = new MEDIATION_STATE(5);
            CAPPED_PER_SESSION = new MEDIATION_STATE(6);
            INIT_PENDING = new MEDIATION_STATE(7);
            LOAD_PENDING = new MEDIATION_STATE(8);
            CAPPED_PER_DAY = new MEDIATION_STATE(9);
            MEDIATION_STATE[] arrmEDIATION_STATE = new MEDIATION_STATE[]{NOT_INITIATED, INIT_FAILED, INITIATED, AVAILABLE, NOT_AVAILABLE, EXHAUSTED, CAPPED_PER_SESSION, INIT_PENDING, LOAD_PENDING, CAPPED_PER_DAY};
            $VALUES = arrmEDIATION_STATE;
        }

        private MEDIATION_STATE(int n3) {
            this.mValue = n3;
        }

        public static MEDIATION_STATE valueOf(String string) {
            return (MEDIATION_STATE)Enum.valueOf(MEDIATION_STATE.class, (String)string);
        }

        public static MEDIATION_STATE[] values() {
            return (MEDIATION_STATE[])$VALUES.clone();
        }

        public int getValue() {
            return this.mValue;
        }
    }

}

