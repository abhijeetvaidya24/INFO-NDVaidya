/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.text.TextUtils
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.concurrent.CopyOnWriteArrayList
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AbstractAdUnitManager;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.RewardedVideoSmash;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener;
import com.ironsource.mediationsdk.server.Server;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.DailyCappingListener;
import com.ironsource.mediationsdk.utils.DailyCappingManager;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class RewardedVideoManager
extends AbstractAdUnitManager
implements NetworkStateReceiver.NetworkStateReceiverListener,
RewardedVideoManagerListener,
DailyCappingListener {
    private final int CAPPED_PER_DAY_REASON = 6;
    private final int CAPPED_PER_SESSION_REASON = 2;
    private final String TAG = this.getClass().getSimpleName();
    private Placement mCurrentPlacement;
    private ISDemandOnlyRewardedVideoListener mISDemandOnlyListenersWrapper;
    private boolean mIsUltraEventsEnabled = false;
    private RewardedVideoListener mListenersWrapper;
    private NetworkStateReceiver mNetworkStateReceiver;
    private boolean mPauseSmartLoadDueToNetworkUnavailability = false;
    private List<AbstractSmash.MEDIATION_STATE> mStatesToIgnore;

    RewardedVideoManager() {
        AbstractSmash.MEDIATION_STATE[] arrmEDIATION_STATE = new AbstractSmash.MEDIATION_STATE[]{AbstractSmash.MEDIATION_STATE.INIT_FAILED, AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, AbstractSmash.MEDIATION_STATE.EXHAUSTED, AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY};
        this.mStatesToIgnore = Arrays.asList((Object[])arrmEDIATION_STATE);
        this.mDailyCappingManager = new DailyCappingManager("rewarded_video", this);
    }

    private void completeAdapterCap() {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            block6 : {
                AbstractAdapter abstractAdapter = this.loadNextAdapter();
                if (abstractAdapter == null) break block6;
                return;
            }
            AbstractSmash.MEDIATION_STATE[] arrmEDIATION_STATE = new AbstractSmash.MEDIATION_STATE[]{AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE, AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION, AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY};
            if (this.smashesCount(arrmEDIATION_STATE) < this.mSmashArray.size()) {
                this.completeIterationRound();
                return;
            }
            if (this.shouldNotifyAvailabilityChanged(false)) {
                this.notifyAvailabilityChange();
            }
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void completeIterationRound() {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            if (!this.isIterationRoundComplete()) return;
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Reset Iteration", 0);
            Iterator iterator = this.mSmashArray.iterator();
            boolean bl = false;
            block5 : do {
                while (iterator.hasNext()) {
                    AbstractSmash abstractSmash = (AbstractSmash)iterator.next();
                    if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.EXHAUSTED) {
                        abstractSmash.completeIteration();
                    }
                    if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE) continue;
                    bl = true;
                    continue block5;
                }
                break;
            } while (true);
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "End of Reset Iteration", 0);
            if (!this.shouldNotifyAvailabilityChanged(bl)) return;
            {
                this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState);
            }
            return;
        }
    }

    private void createAndSendShowCheckAvailabilityEvent(AbstractSmash abstractSmash, String string, boolean bl) {
        Object[][] arrobject = new Object[2][];
        arrobject[0] = new Object[]{"placement", string};
        Object[] arrobject2 = new Object[2];
        arrobject2[0] = "status";
        String string2 = bl ? "true" : "false";
        arrobject2[1] = string2;
        arrobject[1] = arrobject2;
        this.logProviderEvent(19, abstractSmash, arrobject);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean hasAvailableSmash() {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            AbstractSmash.MEDIATION_STATE mEDIATION_STATE;
            boolean bl;
            AbstractSmash.MEDIATION_STATE mEDIATION_STATE2;
            Iterator iterator = this.mSmashArray.iterator();
            do {
                boolean bl2 = iterator.hasNext();
                bl = false;
                if (!bl2) return bl;
            } while ((mEDIATION_STATE = ((AbstractSmash)iterator.next()).getMediationState()) != (mEDIATION_STATE2 = AbstractSmash.MEDIATION_STATE.AVAILABLE));
            bl = true;
            return bl;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean isAllLoaded() {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            AbstractSmash.MEDIATION_STATE mEDIATION_STATE;
            AbstractSmash.MEDIATION_STATE mEDIATION_STATE2;
            boolean bl = true;
            Iterator iterator = this.mSmashArray.iterator();
            do {
                if (!iterator.hasNext()) return bl;
            } while ((mEDIATION_STATE2 = ((AbstractSmash)iterator.next()).getMediationState()) != (mEDIATION_STATE = AbstractSmash.MEDIATION_STATE.NOT_INITIATED));
            return false;
        }
    }

    private boolean isBackFillAvailable() {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            if (this.getBackfillSmash() != null) {
                boolean bl = ((RewardedVideoSmash)this.getBackfillSmash()).isRewardedVideoAvailable();
                return bl;
            }
            return false;
        }
    }

    private boolean isIterationRoundComplete() {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            try {
                for (AbstractSmash abstractSmash : this.mSmashArray) {
                    AbstractSmash.MEDIATION_STATE mEDIATION_STATE;
                    AbstractSmash.MEDIATION_STATE mEDIATION_STATE2;
                    if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.NOT_INITIATED && abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.INITIATED && (mEDIATION_STATE2 = abstractSmash.getMediationState()) != (mEDIATION_STATE = AbstractSmash.MEDIATION_STATE.AVAILABLE)) continue;
                }
            }
            catch (Throwable throwable) {}
            {
                throw throwable;
            }
            return false;
            return true;
        }
    }

    private AbstractAdapter loadNextAdapter() {
        AbstractAdapter abstractAdapter = null;
        int n2 = 0;
        for (int i2 = 0; i2 < this.mSmashArray.size() && abstractAdapter == null; ++i2) {
            if (((AbstractSmash)this.mSmashArray.get(i2)).getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE && ((AbstractSmash)this.mSmashArray.get(i2)).getMediationState() != AbstractSmash.MEDIATION_STATE.INITIATED) {
                if (((AbstractSmash)this.mSmashArray.get(i2)).getMediationState() != AbstractSmash.MEDIATION_STATE.NOT_INITIATED || (abstractAdapter = this.startAdapter((RewardedVideoSmash)this.mSmashArray.get(i2))) != null) continue;
                ((AbstractSmash)this.mSmashArray.get(i2)).setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
                continue;
            }
            if (++n2 < this.mSmartLoadAmount) continue;
            return abstractAdapter;
        }
        return abstractAdapter;
    }

    private void logMediationEvent(int n2, Object[][] arrobject) {
        JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(this.mIsInISDemandOnlyMode);
        if (arrobject != null) {
            int n3 = arrobject.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                try {
                    Object[] arrobject2 = arrobject[i2];
                    jSONObject.put(arrobject2[0].toString(), arrobject2[1]);
                }
                catch (Exception exception) {
                    IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("RewardedVideoManager logMediationEvent ");
                    stringBuilder.append(Log.getStackTraceString((Throwable)exception));
                    ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 3);
                    break;
                }
                continue;
            }
        }
        EventData eventData = new EventData(n2, jSONObject);
        RewardedVideoEventsManager.getInstance().log(eventData);
    }

    private void logProviderEvent(int n2, AbstractSmash abstractSmash, Object[][] arrobject) {
        JSONObject jSONObject = IronSourceUtils.getProviderAdditionalData(abstractSmash, this.mIsInISDemandOnlyMode);
        if (arrobject != null) {
            int n3 = arrobject.length;
            for (int i2 = 0; i2 < n3; ++i2) {
                try {
                    Object[] arrobject2 = arrobject[i2];
                    jSONObject.put(arrobject2[0].toString(), arrobject2[1]);
                }
                catch (Exception exception) {
                    IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("RewardedVideoManager logProviderEvent ");
                    stringBuilder.append(Log.getStackTraceString((Throwable)exception));
                    ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 3);
                    break;
                }
                continue;
            }
        }
        EventData eventData = new EventData(n2, jSONObject);
        RewardedVideoEventsManager.getInstance().log(eventData);
    }

    private void notifyAvailabilityChange() {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            if (this.getBackfillSmash() != null && !this.mBackFillInitStarted) {
                this.mBackFillInitStarted = true;
                if (this.startAdapter((RewardedVideoSmash)this.getBackfillSmash()) == null) {
                    this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState);
                }
            } else if (this.isBackFillAvailable()) {
                if (this.shouldNotifyAvailabilityChanged(true)) {
                    this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState);
                }
            } else {
                this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void notifyIsAdAvailableForStatistics() {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            boolean bl;
            block6 : {
                Iterator iterator = this.mSmashArray.iterator();
                while (iterator.hasNext()) {
                    if (((AbstractSmash)iterator.next()).getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE) continue;
                    bl = true;
                    break block6;
                }
                bl = false;
            }
            Object[][] arrobject = new Object[1][];
            Object[] arrobject2 = new Object[]{"status", String.valueOf((boolean)bl)};
            arrobject[0] = arrobject2;
            this.logMediationEvent(3, arrobject);
            for (AbstractSmash abstractSmash : this.mSmashArray) {
                if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                    this.logProviderEvent(3, abstractSmash, new Object[][]{{"status", "true"}});
                    continue;
                }
                if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE && abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.INITIATED) continue;
                this.logProviderEvent(3, abstractSmash, new Object[][]{{"status", "false"}});
            }
            if (this.getBackfillSmash() == null) return;
            if (this.getBackfillSmash().getAdapter() == null) return;
            AbstractSmash abstractSmash = this.getBackfillSmash();
            Object[][] arrobject3 = new Object[1][];
            Object[] arrobject4 = new Object[2];
            arrobject4[0] = "status";
            String string = this.isBackFillAvailable() ? "true" : "false";
            arrobject4[1] = string;
            arrobject3[0] = arrobject4;
            this.logProviderEvent(3, abstractSmash, arrobject3);
            return;
        }
    }

    private void reportFalseImpressionsOnHigherPriority(int n2, int n3) {
        for (int i2 = 0; i2 < n2 && i2 < this.mSmashArray.size(); ++i2) {
            if (this.mStatesToIgnore.contains((Object)((AbstractSmash)this.mSmashArray.get(i2)).getMediationState())) continue;
            this.reportImpression(((RewardedVideoSmash)this.mSmashArray.get(i2)).getRequestUrl(), false, n3);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void reportImpression(String string, boolean bl, int n2) {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            String string2 = "";
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(string);
                string2 = stringBuilder.toString();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string2);
                stringBuilder2.append("&sdkVersion=");
                stringBuilder2.append(IronSourceUtils.getSDKVersion());
                string2 = stringBuilder2.toString();
                Server.callAsyncRequestURL(string2, bl, n2);
                return;
            }
            catch (Throwable throwable) {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NETWORK;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("reportImpression:(providerURL:");
                stringBuilder.append(string2);
                stringBuilder.append(", ");
                stringBuilder.append("hit:");
                stringBuilder.append(bl);
                stringBuilder.append(")");
                ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), throwable);
                return;
            }
            finally {
            }
        }
    }

    private void sendShowChanceEvent(AbstractSmash abstractSmash, String string, boolean bl) {
        Object[][] arrobject = new Object[2][];
        arrobject[0] = new Object[]{"placement", string};
        Object[] arrobject2 = new Object[2];
        arrobject2[0] = "status";
        String string2 = bl ? "true" : "false";
        arrobject2[1] = string2;
        arrobject[1] = arrobject2;
        this.logProviderEvent(119, abstractSmash, arrobject);
    }

    private void sendShowChanceEvents(AbstractSmash abstractSmash, int n2, String string) {
        this.sendShowChanceEvent(abstractSmash, string, true);
        if (!this.mIsInISDemandOnlyMode) {
            for (int i2 = 0; i2 < this.mSmashArray.size() && i2 < n2; ++i2) {
                AbstractSmash abstractSmash2 = (AbstractSmash)this.mSmashArray.get(i2);
                if (abstractSmash2.getMediationState() != AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) continue;
                this.sendShowChanceEvent(abstractSmash2, string, false);
            }
        }
    }

    private void sendShowCheckAvailabilityEvents(String string) {
        for (int i2 = 0; i2 < this.mSmashArray.size(); ++i2) {
            if (((AbstractSmash)this.mSmashArray.get(i2)).getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                this.createAndSendShowCheckAvailabilityEvent((AbstractSmash)this.mSmashArray.get(i2), string, true);
                continue;
            }
            if (((AbstractSmash)this.mSmashArray.get(i2)).getMediationState() != AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) continue;
            this.createAndSendShowCheckAvailabilityEvent((AbstractSmash)this.mSmashArray.get(i2), string, false);
        }
        if (this.getBackfillSmash() != null && this.getBackfillSmash().getAdapter() != null) {
            this.createAndSendShowCheckAvailabilityEvent(this.getBackfillSmash(), string, this.isBackFillAvailable());
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean shouldNotifyAvailabilityChanged(boolean bl) {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            Boolean bl2 = this.mLastMediationAvailabilityState;
            boolean bl3 = true;
            if (bl2 == null) {
                if (bl) {
                    this.mLastMediationAvailabilityState = bl3;
                } else {
                    if (this.isBackFillAvailable()) return false;
                    if (!this.isAllLoaded()) return false;
                    this.mLastMediationAvailabilityState = false;
                }
            } else if (bl && !this.mLastMediationAvailabilityState.booleanValue()) {
                this.mLastMediationAvailabilityState = bl3;
            } else {
                if (bl) return false;
                if (this.mLastMediationAvailabilityState == false) return false;
                if (this.hasAvailableSmash()) return false;
                if (this.isBackFillAvailable()) return false;
                this.mLastMediationAvailabilityState = false;
            }
            return bl3;
        }
    }

    private boolean shouldNotifyNetworkAvailabilityChanged(boolean bl) {
        if (this.mLastMediationAvailabilityState == null) {
            return false;
        }
        if (bl && !this.mLastMediationAvailabilityState.booleanValue() && this.hasAvailableSmash()) {
            this.mLastMediationAvailabilityState = true;
            return true;
        }
        if (!bl && this.mLastMediationAvailabilityState.booleanValue()) {
            this.mLastMediationAvailabilityState = false;
            return true;
        }
        return false;
    }

    private void showAdapter(AbstractSmash abstractSmash, int n2) {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            CappingManager.incrementShowCounter((Context)this.mActivity, this.mCurrentPlacement);
            this.mDailyCappingManager.increaseShowCounter(abstractSmash);
            if (this.mIsUltraEventsEnabled) {
                this.reportImpression(((RewardedVideoSmash)abstractSmash).getRequestUrl(), true, this.mCurrentPlacement.getPlacementId());
                this.reportFalseImpressionsOnHigherPriority(n2, this.mCurrentPlacement.getPlacementId());
            }
            Object[][] arrobject = new Object[1][];
            Object[] arrobject2 = new Object[]{"placement", this.mCurrentPlacement.getPlacementName()};
            arrobject[0] = arrobject2;
            this.logProviderEvent(2, abstractSmash, arrobject);
            this.sendShowChanceEvents(abstractSmash, n2, this.mCurrentPlacement.getPlacementName());
            ((RewardedVideoSmash)abstractSmash).showRewardedVideo();
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private /* varargs */ int smashesCount(AbstractSmash.MEDIATION_STATE ... var1_1) {
        var11_3 = var2_2 = this.mSmashArray;
        // MONITORENTER : var11_3
        var4_4 = this.mSmashArray.iterator();
        var5_5 = 0;
lbl6: // 2 sources:
        do {
            if (!var4_4.hasNext()) {
                // MONITOREXIT : var11_3
                return var5_5;
            }
            var6_6 = (AbstractSmash)var4_4.next();
            var7_7 = var1_1.length;
            var8_8 = var5_5;
            break;
        } while (true);
        for (var9_9 = 0; var9_9 < var7_7; ++var9_9) {
            var10_10 = var1_1[var9_9];
            if (var6_6.getMediationState() != var10_10) continue;
            ++var8_8;
        }
        var5_5 = var8_8;
        ** while (true)
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private AbstractAdapter startAdapter(RewardedVideoSmash rewardedVideoSmash) {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            AbstractAdapter abstractAdapter;
            block7 : {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.TAG);
                stringBuilder.append(":startAdapter(");
                stringBuilder.append(rewardedVideoSmash.getInstanceName());
                stringBuilder.append(")");
                ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
                try {
                    abstractAdapter = this.getLoadedAdapterOrFetchByReflection(rewardedVideoSmash);
                    if (abstractAdapter != null) break block7;
                }
                catch (Throwable throwable) {
                    ironSourceLoggerManager = this.mLoggerManager;
                    ironSourceTag = IronSourceLogger.IronSourceTag.API;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(this.TAG);
                    stringBuilder.append(":startAdapter(");
                    stringBuilder.append(rewardedVideoSmash.getName());
                    stringBuilder.append(")");
                    ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), throwable);
                    rewardedVideoSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
                    if (this.shouldNotifyAvailabilityChanged(false)) {
                        this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState);
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(rewardedVideoSmash.getName());
                    stringBuilder2.append(" initialization failed - please verify that required dependencies are in you build path.");
                    IronSourceError ironSourceError = ErrorBuilder.buildInitFailedError(stringBuilder2.toString(), "Rewarded Video");
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, ironSourceError.toString(), 2);
                    return null;
                }
                return null;
            }
            IronSourceObject.getInstance().addToRVAdaptersList(abstractAdapter);
            abstractAdapter.setLogListener(this.mLoggerManager);
            rewardedVideoSmash.setAdapterForSmash(abstractAdapter);
            rewardedVideoSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
            this.setCustomParams(rewardedVideoSmash);
            rewardedVideoSmash.initRewardedVideo(this.mActivity, this.mAppKey, this.mUserId);
            return abstractAdapter;
        }
    }

    @Override
    protected void disablePremiumForCurrentSession() {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            try {
                super.disablePremiumForCurrentSession();
                for (AbstractSmash abstractSmash : this.mSmashArray) {
                    if (!abstractSmash.equals((Object)this.getPremiumSmash())) continue;
                    abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                    this.loadNextAdapter();
                    break;
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void initRewardedVideo(Activity activity, String string, String string2) {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":initRewardedVideo(appKey: ");
            stringBuilder.append(string);
            stringBuilder.append(", userId: ");
            stringBuilder.append(string2);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mAppKey = string;
            this.mUserId = string2;
            this.mActivity = activity;
            if (this.mIsInISDemandOnlyMode) {
                this.mSmartLoadAmount = this.mSmashArray.size();
                Iterator iterator = this.mSmashArray.iterator();
                while (iterator.hasNext()) {
                    AbstractSmash abstractSmash = (AbstractSmash)iterator.next();
                    if (this.startAdapter((RewardedVideoSmash)abstractSmash) != null) continue;
                    abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
                }
                return;
            }
            this.mDailyCappingManager.setContext((Context)this.mActivity);
            Iterator iterator = this.mSmashArray.iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                AbstractSmash abstractSmash = (AbstractSmash)iterator.next();
                if (this.mDailyCappingManager.shouldSendCapReleasedEvent(abstractSmash)) {
                    this.logProviderEvent(150, abstractSmash, new Object[][]{{"status", "false"}});
                }
                if (!this.mDailyCappingManager.isCapped(abstractSmash)) continue;
                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                ++n2;
            }
            int n3 = this.mSmashArray.size();
            int n4 = 0;
            if (n2 == n3) {
                this.mListenersWrapper.onRewardedVideoAvailabilityChanged(false);
                return;
            }
            while (n4 < this.mSmartLoadAmount) {
                if (n4 >= this.mSmashArray.size()) return;
                AbstractAdapter abstractAdapter = this.loadNextAdapter();
                if (abstractAdapter == null) {
                    return;
                }
                ++n4;
            }
            return;
        }
    }

    public boolean isRewardedVideoAvailable() {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            block5 : {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.TAG);
                stringBuilder.append(":isRewardedVideoAvailable()");
                ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
                boolean bl = this.mPauseSmartLoadDueToNetworkUnavailability;
                if (!bl) break block5;
                return false;
            }
            try {
                for (AbstractSmash abstractSmash : this.mSmashArray) {
                    boolean bl;
                    if (!abstractSmash.isMediationAvailable() || !(bl = ((RewardedVideoSmash)abstractSmash).isRewardedVideoAvailable())) continue;
                }
            }
            catch (Throwable throwable) {}
            {
                throw throwable;
            }
            return true;
            return false;
        }
    }

    public boolean isRewardedVideoAvailable(String string) {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            block5 : {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.TAG);
                stringBuilder.append(":isRewardedVideoAvailable(instanceId: ");
                stringBuilder.append(string);
                stringBuilder.append(")");
                ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
                boolean bl = this.mPauseSmartLoadDueToNetworkUnavailability;
                if (!bl) break block5;
                return false;
            }
            try {
                for (AbstractSmash abstractSmash : this.mSmashArray) {
                    if (!abstractSmash.getSubProviderId().equals((Object)string)) continue;
                    boolean bl = ((RewardedVideoSmash)abstractSmash).isRewardedVideoAvailable();
                    return bl;
                }
            }
            catch (Throwable throwable) {}
            {
                throw throwable;
            }
            return false;
        }
    }

    @Override
    public void onDailyCapReleased() {
        Iterator iterator = this.mSmashArray.iterator();
        boolean bl = false;
        while (iterator.hasNext()) {
            AbstractSmash abstractSmash = (AbstractSmash)iterator.next();
            if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) continue;
            this.logProviderEvent(150, abstractSmash, new Object[][]{{"status", "false"}});
            abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
            if (!((RewardedVideoSmash)abstractSmash).isRewardedVideoAvailable() || !abstractSmash.isMediationAvailable()) continue;
            abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.AVAILABLE);
            bl = true;
        }
        if (bl && this.shouldNotifyAvailabilityChanged(true)) {
            this.mListenersWrapper.onRewardedVideoAvailabilityChanged(true);
        }
    }

    @Override
    public void onNetworkAvailabilityChanged(boolean bl) {
        if (this.mShouldTrackNetworkState) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Network Availability Changed To: ");
            stringBuilder.append(bl);
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
            if (this.shouldNotifyNetworkAvailabilityChanged(bl)) {
                this.mPauseSmartLoadDueToNetworkUnavailability = bl ^ true;
                this.mListenersWrapper.onRewardedVideoAvailabilityChanged(bl);
            }
        }
    }

    @Override
    public void onRewardedVideoAdClicked(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rewardedVideoSmash.getInstanceName());
        stringBuilder.append(":onRewardedVideoAdClicked()");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        Object[][] arrobject = new Object[1][];
        Object[] arrobject2 = new Object[]{"placement", this.mCurrentPlacement.getPlacementName()};
        arrobject[0] = arrobject2;
        this.logProviderEvent(128, rewardedVideoSmash, arrobject);
        if (this.mIsInISDemandOnlyMode) {
            this.mISDemandOnlyListenersWrapper.onRewardedVideoAdClicked(rewardedVideoSmash.getSubProviderId(), this.mCurrentPlacement);
            return;
        }
        this.mListenersWrapper.onRewardedVideoAdClicked(this.mCurrentPlacement);
    }

    @Override
    public void onRewardedVideoAdClosed(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rewardedVideoSmash.getInstanceName());
        stringBuilder.append(":onRewardedVideoAdClosed()");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        this.logProviderEvent(6, rewardedVideoSmash, null);
        this.notifyIsAdAvailableForStatistics();
        if (this.mIsInISDemandOnlyMode) {
            this.mISDemandOnlyListenersWrapper.onRewardedVideoAdClosed(rewardedVideoSmash.getSubProviderId());
            return;
        }
        this.mListenersWrapper.onRewardedVideoAdClosed();
        for (AbstractSmash abstractSmash : this.mSmashArray) {
            if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) continue;
            try {
                if (abstractSmash.getInstanceName().equals((Object)rewardedVideoSmash.getInstanceName())) continue;
                IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.INTERNAL;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(abstractSmash.getInstanceName());
                stringBuilder2.append(":reload smash");
                ironSourceLoggerManager2.log(ironSourceTag2, stringBuilder2.toString(), 1);
                ((RewardedVideoSmash)abstractSmash).fetchRewardedVideo();
            }
            catch (Throwable throwable) {
                IronSourceLoggerManager ironSourceLoggerManager3 = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag3 = IronSourceLogger.IronSourceTag.NATIVE;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(abstractSmash.getInstanceName());
                stringBuilder3.append(" Failed to call fetchVideo(), ");
                stringBuilder3.append(throwable.getLocalizedMessage());
                ironSourceLoggerManager3.log(ironSourceTag3, stringBuilder3.toString(), 1);
            }
        }
    }

    @Override
    public void onRewardedVideoAdOpened(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rewardedVideoSmash.getInstanceName());
        stringBuilder.append(":onRewardedVideoAdOpened()");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        this.logProviderEvent(5, rewardedVideoSmash, null);
        if (this.mIsInISDemandOnlyMode) {
            this.mISDemandOnlyListenersWrapper.onRewardedVideoAdOpened(rewardedVideoSmash.getSubProviderId());
            return;
        }
        this.mListenersWrapper.onRewardedVideoAdOpened();
    }

    @Override
    public void onRewardedVideoAdRewarded(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rewardedVideoSmash.getInstanceName());
        stringBuilder.append(":onRewardedVideoAdRewarded()");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        JSONObject jSONObject = IronSourceUtils.getProviderAdditionalData(rewardedVideoSmash, this.mIsInISDemandOnlyMode);
        try {
            jSONObject.put("placement", (Object)this.mCurrentPlacement.getPlacementName());
            jSONObject.put("rewardName", (Object)this.mCurrentPlacement.getRewardName());
            jSONObject.put("rewardAmount", this.mCurrentPlacement.getRewardAmount());
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        EventData eventData = new EventData(10, jSONObject);
        if (!TextUtils.isEmpty((CharSequence)this.mAppKey)) {
            Map<String, String> map;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(Long.toString((long)eventData.getTimeStamp()));
            stringBuilder2.append(this.mAppKey);
            stringBuilder2.append(rewardedVideoSmash.getName());
            eventData.addToAdditionalData("transId", IronSourceUtils.getTransId(stringBuilder2.toString()));
            if (!TextUtils.isEmpty((CharSequence)IronSourceObject.getInstance().getDynamicUserId())) {
                eventData.addToAdditionalData("dynamicUserId", IronSourceObject.getInstance().getDynamicUserId());
            }
            if ((map = IronSourceObject.getInstance().getRvServerParams()) != null) {
                for (String string : map.keySet()) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("custom_");
                    stringBuilder3.append(string);
                    eventData.addToAdditionalData(stringBuilder3.toString(), map.get((Object)string));
                }
            }
        }
        RewardedVideoEventsManager.getInstance().log(eventData);
        if (this.mIsInISDemandOnlyMode) {
            this.mISDemandOnlyListenersWrapper.onRewardedVideoAdRewarded(rewardedVideoSmash.getSubProviderId(), this.mCurrentPlacement);
            return;
        }
        this.mListenersWrapper.onRewardedVideoAdRewarded(this.mCurrentPlacement);
    }

    @Override
    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rewardedVideoSmash.getInstanceName());
        stringBuilder.append(":onRewardedVideoAdShowFailed(");
        stringBuilder.append((Object)ironSourceError);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mIsInISDemandOnlyMode) {
            this.mISDemandOnlyListenersWrapper.onRewardedVideoAdShowFailed(rewardedVideoSmash.getSubProviderId(), ironSourceError);
            return;
        }
        this.mListenersWrapper.onRewardedVideoAdShowFailed(ironSourceError);
    }

    @Override
    public void onRewardedVideoAdVisible(RewardedVideoSmash rewardedVideoSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(rewardedVideoSmash.getInstanceName());
        stringBuilder.append(":onRewardedVideoAdVisible()");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        Object[][] arrobject = new Object[1][];
        Object[] arrobject2 = new Object[]{"placement", this.mCurrentPlacement.getPlacementName()};
        arrobject[0] = arrobject2;
        this.logProviderEvent(11, rewardedVideoSmash, arrobject);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public void onRewardedVideoAvailabilityChanged(boolean bl, RewardedVideoSmash rewardedVideoSmash) {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            boolean bl2 = this.mPauseSmartLoadDueToNetworkUnavailability;
            if (bl2) return;
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(rewardedVideoSmash.getInstanceName());
            stringBuilder.append(":onRewardedVideoAvailabilityChanged(available:");
            stringBuilder.append(bl);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            Object[][] arrobject = new Object[1][];
            Object[] arrobject2 = new Object[]{"status", String.valueOf((boolean)bl)};
            arrobject[0] = arrobject2;
            this.logProviderEvent(7, rewardedVideoSmash, arrobject);
            if (this.mIsInISDemandOnlyMode) {
                this.mISDemandOnlyListenersWrapper.onRewardedVideoAvailabilityChanged(rewardedVideoSmash.getSubProviderId(), bl);
                if (!this.shouldNotifyAvailabilityChanged(bl)) return;
                Object[][] arrobject3 = new Object[1][];
                Object[] arrobject4 = new Object[]{"status", String.valueOf((boolean)bl)};
                arrobject3[0] = arrobject4;
                this.logMediationEvent(7, arrobject3);
                return;
            }
            if (rewardedVideoSmash.equals((Object)this.getBackfillSmash())) {
                if (!this.shouldNotifyAvailabilityChanged(bl)) return;
                {
                    this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState);
                }
                return;
            }
            if (rewardedVideoSmash.equals((Object)this.getPremiumSmash())) {
                IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(rewardedVideoSmash.getInstanceName());
                stringBuilder2.append(" is a Premium adapter, canShowPremium: ");
                stringBuilder2.append(this.canShowPremium());
                ironSourceLoggerManager2.log(ironSourceTag2, stringBuilder2.toString(), 1);
                if (!this.canShowPremium()) {
                    rewardedVideoSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                    if (!this.shouldNotifyAvailabilityChanged(false)) return;
                    {
                        this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState);
                    }
                    return;
                }
            }
            if (!rewardedVideoSmash.isMediationAvailable() || this.mDailyCappingManager.isCapped(rewardedVideoSmash)) return;
            if (bl) {
                if (!this.shouldNotifyAvailabilityChanged(true)) return;
                this.mListenersWrapper.onRewardedVideoAvailabilityChanged(this.mLastMediationAvailabilityState);
                return;
            }
            if (this.shouldNotifyAvailabilityChanged(false)) {
                this.notifyAvailabilityChange();
            }
            this.loadNextAdapter();
            this.completeIterationRound();
            return;
            finally {
            }
        }
    }

    void setCurrentPlacement(Placement placement) {
        this.mCurrentPlacement = placement;
    }

    public void setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        this.mISDemandOnlyListenersWrapper = iSDemandOnlyRewardedVideoListener;
    }

    void setIsUltraEventsEnabled(boolean bl) {
        this.mIsUltraEventsEnabled = bl;
    }

    public void setRewardedVideoListener(RewardedVideoListener rewardedVideoListener) {
        this.mListenersWrapper = rewardedVideoListener;
    }

    @Override
    void shouldTrackNetworkState(Context context, boolean bl) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.TAG);
        stringBuilder.append(" Should Track Network State: ");
        stringBuilder.append(bl);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
        this.mShouldTrackNetworkState = bl;
        if (this.mShouldTrackNetworkState) {
            if (this.mNetworkStateReceiver == null) {
                this.mNetworkStateReceiver = new NetworkStateReceiver(context, this);
            }
            context.registerReceiver((BroadcastReceiver)this.mNetworkStateReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            return;
        }
        NetworkStateReceiver networkStateReceiver = this.mNetworkStateReceiver;
        if (networkStateReceiver != null) {
            context.unregisterReceiver((BroadcastReceiver)networkStateReceiver);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void showRewardedVideo(String var1_1) {
        block16 : {
            var25_2 = this;
            // MONITORENTER : var25_2
            var3_3 = this.mLoggerManager;
            var4_4 = IronSourceLogger.IronSourceTag.API;
            var5_5 = new StringBuilder();
            var5_5.append(this.TAG);
            var5_5.append(":showRewardedVideo(placementName: ");
            var5_5.append(var1_1);
            var5_5.append(")");
            var3_3.log(var4_4, var5_5.toString(), 1);
            if (!IronSourceUtils.isNetworkConnected((Context)this.mActivity)) {
                this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoInternetConnectionShowFailError("Rewarded Video"));
                // MONITOREXIT : var25_2
                return;
            }
            this.sendShowCheckAvailabilityEvents(var1_1);
            var10_6 = 0;
            var11_7 = 0;
            var12_8 = 0;
lbl20: // 2 sources:
            do {
                if (var10_6 < this.mSmashArray.size()) {
                    var13_9 = (AbstractSmash)this.mSmashArray.get(var10_6);
                    if (var13_9.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                        if (((RewardedVideoSmash)var13_9).isRewardedVideoAvailable()) {
                            this.showAdapter(var13_9, var10_6);
                            if (this.mCanShowPremium && !var13_9.equals((Object)this.getPremiumSmash())) {
                                this.disablePremiumForCurrentSession();
                            }
                            if (var13_9.isCappedPerSession()) {
                                var13_9.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                                var23_14 = new Object[2][];
                                var23_14[0] = new Object[]{"status", "false"};
                                var24_15 = new Object[]{"reason", 2};
                                var23_14[1] = var24_15;
                                this.logProviderEvent(7, var13_9, var23_14);
                                this.completeAdapterCap();
                                return;
                            }
                            if (this.mDailyCappingManager.isCapped(var13_9)) {
                                var13_9.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                                var21_16 = new Object[2][];
                                var21_16[0] = new Object[]{"status", "false"};
                                var22_17 = new Object[]{"reason", 6};
                                var21_16[1] = var22_17;
                                this.logProviderEvent(7, var13_9, var21_16);
                                this.logProviderEvent(150, var13_9, new Object[][]{{"status", "true"}});
                                this.completeAdapterCap();
                                return;
                            }
                            if (var13_9.isExhausted()) {
                                this.loadNextAdapter();
                                this.completeIterationRound();
                            }
                            // MONITOREXIT : var25_2
                            return;
                        }
                        this.onRewardedVideoAvailabilityChanged(false, (RewardedVideoSmash)var13_9);
                        var14_10 = new Exception("FailedToShowVideoException");
                        var15_11 = this.mLoggerManager;
                        var16_12 = IronSourceLogger.IronSourceTag.INTERNAL;
                        var17_13 = new StringBuilder();
                        var17_13.append(var13_9.getInstanceName());
                        var17_13.append(" Failed to show video");
                        var15_11.logException(var16_12, var17_13.toString(), var14_10);
                        break block16;
                    }
                    if (var13_9.getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION || var13_9.getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) break;
                    if (var13_9.getMediationState() == AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) {
                        ++var12_8;
                    }
                    break block16;
                }
                if (this.isBackFillAvailable()) {
                    this.showAdapter(this.getBackfillSmash(), this.mSmashArray.size());
                    return;
                }
                if (var11_7 + var12_8 == this.mSmashArray.size()) {
                    this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Rewarded Video"));
                }
                // MONITOREXIT : var25_2
                return;
                break;
            } while (true);
            ++var11_7;
        }
        ++var10_6;
        ** while (true)
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void showRewardedVideo(String string, String string2) {
        RewardedVideoManager rewardedVideoManager = this;
        synchronized (rewardedVideoManager) {
            boolean bl;
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":showRewardedVideo(instanceId: ");
            stringBuilder.append(string);
            stringBuilder.append(", placementName: ");
            stringBuilder.append(string2);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            if (!IronSourceUtils.isNetworkConnected((Context)this.mActivity)) {
                this.mISDemandOnlyListenersWrapper.onRewardedVideoAdShowFailed(string, ErrorBuilder.buildNoInternetConnectionShowFailError("Rewarded Video"));
                return;
            }
            this.sendShowCheckAvailabilityEvents(string2);
            int n2 = 0;
            do {
                int n3 = this.mSmashArray.size();
                bl = false;
                if (n2 >= n3) break;
                AbstractSmash abstractSmash = (AbstractSmash)this.mSmashArray.get(n2);
                if (abstractSmash.getSubProviderId().equals((Object)string)) {
                    if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                        if (((RewardedVideoSmash)abstractSmash).isRewardedVideoAvailable()) {
                            CappingManager.incrementShowCounter((Context)this.mActivity, this.mCurrentPlacement);
                            Object[][] arrobject = new Object[1][];
                            Object[] arrobject2 = new Object[]{"placement", this.mCurrentPlacement.getPlacementName()};
                            arrobject[0] = arrobject2;
                            this.logProviderEvent(2, abstractSmash, arrobject);
                            this.sendShowChanceEvents(abstractSmash, n2, this.mCurrentPlacement.getPlacementName());
                            ((RewardedVideoSmash)abstractSmash).showRewardedVideo();
                            if (abstractSmash.isCappedPerSession()) {
                                Object[][] arrobject3 = new Object[2][];
                                arrobject3[0] = new Object[]{"status", "false"};
                                Object[] arrobject4 = new Object[]{"reason", 2};
                                arrobject3[1] = arrobject4;
                                this.logProviderEvent(7, abstractSmash, arrobject3);
                                this.onRewardedVideoAvailabilityChanged(false, (RewardedVideoSmash)abstractSmash);
                            } else {
                                if (!this.mDailyCappingManager.isCapped(abstractSmash)) return;
                                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                                this.logProviderEvent(150, abstractSmash, new Object[][]{{"status", "true"}});
                                this.onRewardedVideoAvailabilityChanged(false, (RewardedVideoSmash)abstractSmash);
                            }
                        } else {
                            this.onRewardedVideoAvailabilityChanged(false, (RewardedVideoSmash)abstractSmash);
                            Exception exception = new Exception("FailedToShowVideoException");
                            IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
                            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.INTERNAL;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(abstractSmash.getInstanceName());
                            stringBuilder2.append(" Failed to show video");
                            ironSourceLoggerManager2.logException(ironSourceTag2, stringBuilder2.toString(), exception);
                        }
                        return;
                    }
                    if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION) {
                        this.mListenersWrapper.onRewardedVideoAdShowFailed(new IronSourceError(526, "Instance has reached its cap per session"));
                        return;
                    }
                    bl = true;
                    break;
                }
                ++n2;
            } while (true);
            if (!bl) {
                this.mISDemandOnlyListenersWrapper.onRewardedVideoAdShowFailed(string, ErrorBuilder.buildNonExistentInstanceError("Rewarded Video"));
            } else {
                this.mISDemandOnlyListenersWrapper.onRewardedVideoAdShowFailed(string, ErrorBuilder.buildNoAdsToShowError("Rewarded Video"));
            }
            return;
        }
    }
}

