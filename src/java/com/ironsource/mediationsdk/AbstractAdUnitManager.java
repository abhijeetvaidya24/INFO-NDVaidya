/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  com.ironsource.mediationsdk.AbstractAdapter
 *  com.ironsource.mediationsdk.IronSourceObject
 *  com.ironsource.mediationsdk.logger.IronSourceLoggerManager
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 *  java.util.Iterator
 *  java.util.concurrent.CopyOnWriteArrayList
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.DailyCappingManager;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

abstract class AbstractAdUnitManager {
    final String KEY_PLACEMENT = "placement";
    final String KEY_PROVIDER_PRIORITY = "providerPriority";
    final String KEY_REASON = "reason";
    final String KEY_REWARD_AMOUNT = "rewardAmount";
    final String KEY_REWARD_NAME = "rewardName";
    final String KEY_STATUS = "status";
    Activity mActivity;
    String mAppKey;
    boolean mBackFillInitStarted;
    private AbstractSmash mBackfillSmash;
    boolean mCanShowPremium = true;
    DailyCappingManager mDailyCappingManager = null;
    boolean mIsInISDemandOnlyMode = false;
    Boolean mLastMediationAvailabilityState;
    IronSourceLoggerManager mLoggerManager = IronSourceLoggerManager.getLogger();
    private AbstractSmash mPremiumSmash;
    boolean mShouldTrackNetworkState = false;
    int mSmartLoadAmount;
    final CopyOnWriteArrayList<AbstractSmash> mSmashArray = new CopyOnWriteArrayList();
    String mUserId;

    AbstractAdUnitManager() {
    }

    void addSmashToArray(AbstractSmash abstractSmash) {
        this.mSmashArray.add((Object)abstractSmash);
        DailyCappingManager dailyCappingManager = this.mDailyCappingManager;
        if (dailyCappingManager != null) {
            dailyCappingManager.addSmash(abstractSmash);
        }
    }

    boolean canShowPremium() {
        AbstractAdUnitManager abstractAdUnitManager = this;
        synchronized (abstractAdUnitManager) {
            boolean bl2 = this.mCanShowPremium;
            return bl2;
        }
    }

    void disablePremiumForCurrentSession() {
        AbstractAdUnitManager abstractAdUnitManager = this;
        synchronized (abstractAdUnitManager) {
            this.mCanShowPremium = false;
            return;
        }
    }

    AbstractSmash getBackfillSmash() {
        return this.mBackfillSmash;
    }

    AbstractAdapter getLoadedAdapterOrFetchByReflection(AbstractSmash abstractSmash) {
        AbstractAdUnitManager abstractAdUnitManager = this;
        synchronized (abstractAdUnitManager) {
            try {
                AbstractAdapter abstractAdapter = IronSourceObject.getInstance().getExistingAdapter(abstractSmash.getName());
                if (abstractAdapter == null) {
                    IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("loading ");
                    stringBuilder.append(abstractSmash.getName());
                    stringBuilder.append(" with reflection");
                    ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("com.ironsource.adapters.");
                    stringBuilder2.append(abstractSmash.getNameForReflection().toLowerCase());
                    stringBuilder2.append(".");
                    stringBuilder2.append(abstractSmash.getNameForReflection());
                    stringBuilder2.append("Adapter");
                    Class class_ = Class.forName((String)stringBuilder2.toString());
                    Method method = class_.getMethod("startAdapter", new Class[]{String.class});
                    Object[] arrobject = new Object[]{abstractSmash.getName()};
                    abstractAdapter = (AbstractAdapter)method.invoke((Object)class_, arrobject);
                } else {
                    IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("using previously loaded ");
                    stringBuilder.append(abstractSmash.getName());
                    ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
                }
                return abstractAdapter;
            }
            catch (Exception exception) {
                return null;
            }
            finally {
            }
        }
    }

    AbstractSmash getPremiumSmash() {
        return this.mPremiumSmash;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onPause(Activity activity) {
        CopyOnWriteArrayList<AbstractSmash> copyOnWriteArrayList;
        CopyOnWriteArrayList<AbstractSmash> copyOnWriteArrayList2 = copyOnWriteArrayList = this.mSmashArray;
        synchronized (copyOnWriteArrayList2) {
            if (this.mSmashArray == null) return;
            Iterator iterator = this.mSmashArray.iterator();
            while (iterator.hasNext()) {
                ((AbstractSmash)iterator.next()).onPause(activity);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onResume(Activity activity) {
        CopyOnWriteArrayList<AbstractSmash> copyOnWriteArrayList;
        if (activity != null) {
            this.mActivity = activity;
        }
        CopyOnWriteArrayList<AbstractSmash> copyOnWriteArrayList2 = copyOnWriteArrayList = this.mSmashArray;
        synchronized (copyOnWriteArrayList2) {
            if (this.mSmashArray == null) return;
            Iterator iterator = this.mSmashArray.iterator();
            while (iterator.hasNext()) {
                ((AbstractSmash)iterator.next()).onResume(activity);
            }
            return;
        }
    }

    void setBackfillSmash(AbstractSmash abstractSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(abstractSmash.getInstanceName());
        stringBuilder.append(" is set as backfill");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
        this.mBackfillSmash = abstractSmash;
    }

    void setConsent(boolean bl2) {
        for (AbstractSmash abstractSmash : this.mSmashArray) {
            if (abstractSmash == null) continue;
            abstractSmash.setConsent(bl2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void setCustomParams(AbstractSmash abstractSmash) {
        try {
            String string;
            String string2;
            Boolean bl2;
            String string3;
            Integer n2 = IronSourceObject.getInstance().getAge();
            if (n2 != null) {
                abstractSmash.setAge(n2);
            }
            if (!TextUtils.isEmpty((CharSequence)(string2 = IronSourceObject.getInstance().getGender()))) {
                abstractSmash.setGender(string2);
            }
            if (!TextUtils.isEmpty((CharSequence)(string3 = IronSourceObject.getInstance().getMediationSegment()))) {
                abstractSmash.setMediationSegment(string3);
            }
            if (!TextUtils.isEmpty((CharSequence)(string = ConfigFile.getConfigFile().getPluginType()))) {
                abstractSmash.setPluginData(string, ConfigFile.getConfigFile().getPluginFrameworkVersion());
            }
            if ((bl2 = IronSourceObject.getInstance().getConsent()) == null) return;
            abstractSmash.setConsent(bl2);
            return;
        }
        catch (Exception exception) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(":setCustomParams():");
            stringBuilder.append(exception.toString());
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 3);
        }
    }

    void setPremiumSmash(AbstractSmash abstractSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(abstractSmash.getInstanceName());
        stringBuilder.append(" is set as premium");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
        this.mPremiumSmash = abstractSmash;
    }

    void setSmartLoadAmount(int n2) {
        this.mSmartLoadAmount = n2;
    }

    abstract void shouldTrackNetworkState(Context var1, boolean var2);
}

