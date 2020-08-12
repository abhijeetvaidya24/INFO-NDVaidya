/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.util.Log
 *  com.ironsource.mediationsdk.InterstitialSmash
 *  com.ironsource.mediationsdk.sdk.ListenersWrapper
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.CopyOnWriteArrayList
 *  java.util.concurrent.CopyOnWriteArraySet
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AbstractAdUnitManager;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.CallbackThrotteler;
import com.ironsource.mediationsdk.InterstitialSmash;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.InterstitialManagerListener;
import com.ironsource.mediationsdk.sdk.ListenersWrapper;
import com.ironsource.mediationsdk.sdk.RewardedInterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedInterstitialManagerListener;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.DailyCappingListener;
import com.ironsource.mediationsdk.utils.DailyCappingManager;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

class InterstitialManager
extends AbstractAdUnitManager
implements MediationInitializer.OnMediationInitializationListener,
InterstitialManagerListener,
RewardedInterstitialManagerListener,
DailyCappingListener {
    private final String TAG = this.getClass().getName();
    private CallbackThrotteler mCallbackThrotteler = new CallbackThrotteler();
    private InterstitialPlacement mCurrentPlacement;
    private boolean mDidCallLoadInterstitial = false;
    private boolean mDidFinishToInitInterstitial;
    private ISDemandOnlyInterstitialListener mISDemandOnlyInterstitialListener;
    private Map<String, InterstitialSmash> mInstanceIdToSmashMap = new ConcurrentHashMap();
    private CopyOnWriteArraySet<String> mInstancesToLoad = new CopyOnWriteArraySet();
    private ListenersWrapper mInterstitialListenersWrapper;
    private boolean mIsLoadInterstitialInProgress = false;
    private RewardedInterstitialListener mRewardedInterstitialListenerWrapper;
    private boolean mShouldSendAdReadyEvent = false;

    InterstitialManager() {
        this.mDailyCappingManager = new DailyCappingManager("interstitial", this);
    }

    private void changeStateToInitiated() {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            try {
                for (AbstractSmash abstractSmash : this.mSmashArray) {
                    if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE && abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.LOAD_PENDING && abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) continue;
                    abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private void changeStateToInitiatedForInstanceId(String string) {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            try {
                for (AbstractSmash abstractSmash : this.mSmashArray) {
                    if (!abstractSmash.getSubProviderId().equals((Object)string) || abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE && abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.LOAD_PENDING && abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE) continue;
                    abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
                    break;
                }
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private void completeAdapterShow(AbstractSmash abstractSmash) {
        if (!abstractSmash.isMediationAvailable()) {
            this.startNextAdapter();
            this.completeIterationRound();
            return;
        }
        abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
    }

    private void completeIterationRound() {
        if (this.isIterationRoundComplete()) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Reset Iteration", 0);
            for (AbstractSmash abstractSmash : this.mSmashArray) {
                if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.EXHAUSTED) continue;
                abstractSmash.completeIteration();
            }
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "End of Reset Iteration", 0);
        }
    }

    private boolean isIterationRoundComplete() {
        for (AbstractSmash abstractSmash : this.mSmashArray) {
            if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.NOT_INITIATED && abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.INIT_PENDING && abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.INITIATED && abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.LOAD_PENDING && abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE) continue;
            return false;
        }
        return true;
    }

    private void loadAdapterAndSendEvent(InterstitialSmash interstitialSmash) {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            if (this.mIsInISDemandOnlyMode) {
                this.logMediationEvent(22, null);
            }
            this.logProviderEvent(22, (AbstractSmash)interstitialSmash, null);
            interstitialSmash.loadInterstitial();
            return;
        }
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
                    stringBuilder.append("InterstitialManager logMediationEvent ");
                    stringBuilder.append(Log.getStackTraceString((Throwable)exception));
                    ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 3);
                    break;
                }
                continue;
            }
        }
        EventData eventData = new EventData(n2, jSONObject);
        InterstitialEventsManager.getInstance().log(eventData);
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
                    stringBuilder.append("InterstitialManager logProviderEvent ");
                    stringBuilder.append(Log.getStackTraceString((Throwable)exception));
                    ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 3);
                    break;
                }
                continue;
            }
        }
        EventData eventData = new EventData(n2, jSONObject);
        InterstitialEventsManager.getInstance().log(eventData);
    }

    private void sendShowChanceEvent(AbstractSmash abstractSmash, String string, boolean bl) {
        Object[][] arrobject = new Object[2][];
        arrobject[0] = new Object[]{"placement", string};
        Object[] arrobject2 = new Object[2];
        arrobject2[0] = "status";
        String string2 = bl ? "true" : "false";
        arrobject2[1] = string2;
        arrobject[1] = arrobject2;
        this.logProviderEvent(219, abstractSmash, arrobject);
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
    private AbstractAdapter startAdapter(InterstitialSmash interstitialSmash) {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            AbstractAdapter abstractAdapter;
            block7 : {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.TAG);
                stringBuilder.append(":startAdapter(");
                stringBuilder.append(interstitialSmash.getName());
                stringBuilder.append(")");
                ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
                try {
                    abstractAdapter = this.getLoadedAdapterOrFetchByReflection((AbstractSmash)interstitialSmash);
                    if (abstractAdapter != null) break block7;
                }
                catch (Throwable throwable) {
                    ironSourceLoggerManager = this.mLoggerManager;
                    ironSourceTag = IronSourceLogger.IronSourceTag.API;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(this.TAG);
                    stringBuilder.append(":startAdapter(");
                    stringBuilder.append(interstitialSmash.getName());
                    stringBuilder.append(")");
                    ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), throwable);
                    interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(interstitialSmash.getName());
                    stringBuilder2.append(" initialization failed - please verify that required dependencies are in you build path.");
                    IronSourceError ironSourceError = ErrorBuilder.buildInitFailedError(stringBuilder2.toString(), "Interstitial");
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, ironSourceError.toString(), 2);
                    return null;
                }
                return null;
            }
            IronSourceObject.getInstance().addToISAdaptersList(abstractAdapter);
            abstractAdapter.setLogListener(this.mLoggerManager);
            interstitialSmash.setAdapterForSmash(abstractAdapter);
            interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_PENDING);
            if (this.mRewardedInterstitialListenerWrapper != null) {
                interstitialSmash.setRewardedInterstitialManagerListener((RewardedInterstitialManagerListener)this);
            }
            this.setCustomParams((AbstractSmash)interstitialSmash);
            interstitialSmash.initInterstitial(this.mActivity, this.mAppKey, this.mUserId);
            return abstractAdapter;
        }
    }

    private AbstractAdapter startNextAdapter() {
        AbstractAdapter abstractAdapter = null;
        int n2 = 0;
        for (int i2 = 0; i2 < this.mSmashArray.size() && abstractAdapter == null; ++i2) {
            if (((AbstractSmash)this.mSmashArray.get(i2)).getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE && ((AbstractSmash)this.mSmashArray.get(i2)).getMediationState() != AbstractSmash.MEDIATION_STATE.INITIATED && ((AbstractSmash)this.mSmashArray.get(i2)).getMediationState() != AbstractSmash.MEDIATION_STATE.INIT_PENDING && ((AbstractSmash)this.mSmashArray.get(i2)).getMediationState() != AbstractSmash.MEDIATION_STATE.LOAD_PENDING) {
                if (((AbstractSmash)this.mSmashArray.get(i2)).getMediationState() != AbstractSmash.MEDIATION_STATE.NOT_INITIATED || (abstractAdapter = this.startAdapter((InterstitialSmash)this.mSmashArray.get(i2))) != null) continue;
                ((AbstractSmash)this.mSmashArray.get(i2)).setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
                continue;
            }
            if (++n2 < this.mSmartLoadAmount) continue;
            return abstractAdapter;
        }
        return abstractAdapter;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void initInterstitial(Activity activity, String string, String string2) {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":initInterstitial(appKey: ");
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
                    if (this.startAdapter((InterstitialSmash)abstractSmash) == null) {
                        abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INIT_FAILED);
                    }
                    this.mInstanceIdToSmashMap.put((Object)abstractSmash.getSubProviderId(), (Object)((InterstitialSmash)abstractSmash));
                }
                return;
            }
            this.mDailyCappingManager.setContext((Context)this.mActivity);
            Iterator iterator = this.mSmashArray.iterator();
            int n2 = 0;
            while (iterator.hasNext()) {
                AbstractSmash abstractSmash = (AbstractSmash)iterator.next();
                if (this.mDailyCappingManager.shouldSendCapReleasedEvent(abstractSmash)) {
                    this.logProviderEvent(250, abstractSmash, new Object[][]{{"status", "false"}});
                }
                if (!this.mDailyCappingManager.isCapped(abstractSmash)) continue;
                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                ++n2;
            }
            int n3 = this.mSmashArray.size();
            int n4 = 0;
            if (n2 == n3) {
                this.mDidFinishToInitInterstitial = true;
            }
            while (n4 < this.mSmartLoadAmount) {
                AbstractAdapter abstractAdapter = this.startNextAdapter();
                if (abstractAdapter == null) {
                    return;
                }
                ++n4;
            }
            return;
        }
    }

    public boolean isInterstitialReady() {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            block5 : {
                boolean bl;
                if (!this.mShouldTrackNetworkState || this.mActivity == null || (bl = IronSourceUtils.isNetworkConnected((Context)this.mActivity))) break block5;
                return false;
            }
            try {
                for (AbstractSmash abstractSmash : this.mSmashArray) {
                    boolean bl;
                    if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE || !(bl = ((InterstitialSmash)abstractSmash).isInterstitialReady())) continue;
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

    public boolean isInterstitialReady(String string) {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            boolean bl;
            block6 : {
                boolean bl2;
                if (!this.mShouldTrackNetworkState || this.mActivity == null || (bl2 = IronSourceUtils.isNetworkConnected((Context)this.mActivity))) break block6;
                return false;
            }
            try {
                for (AbstractSmash abstractSmash : this.mSmashArray) {
                    if (!abstractSmash.getSubProviderId().equals((Object)string)) continue;
                    AbstractSmash.MEDIATION_STATE mEDIATION_STATE = abstractSmash.getMediationState();
                    AbstractSmash.MEDIATION_STATE mEDIATION_STATE2 = AbstractSmash.MEDIATION_STATE.AVAILABLE;
                    bl = false;
                    if (mEDIATION_STATE != mEDIATION_STATE2) break block7;
                }
            }
            catch (Throwable throwable) {}
            {
                throw throwable;
            }
            {
                block7 : {
                    AbstractSmash abstractSmash;
                    boolean bl3 = ((InterstitialSmash)abstractSmash).isInterstitialReady();
                    bl = false;
                    if (!bl3) break block7;
                    bl = true;
                }
                return bl;
            }
            return false;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    public void loadInterstitial() {
        var19_1 = this;
        synchronized (var19_1) {
            block17 : {
                block18 : {
                    block15 : {
                        block16 : {
                            if (this.mIsLoadInterstitialInProgress || this.mCallbackThrotteler.hasPendingInvocation()) break block15;
                            var9_2 = MediationInitializer.getInstance().getCurrentInitStatus();
                            if (var9_2 == MediationInitializer.EInitStatus.NOT_INIT) {
                                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadInterstitial()", 3);
                                return;
                            }
                            if (var9_2 == MediationInitializer.EInitStatus.INIT_IN_PROGRESS) {
                                if (MediationInitializer.getInstance().isInProgressMoreThan15Secs()) {
                                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                                    this.mCallbackThrotteler.onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                                } else {
                                    this.logMediationEvent(22, null);
                                    this.mDidCallLoadInterstitial = true;
                                    this.mShouldSendAdReadyEvent = true;
                                }
                                return;
                            }
                            if (var9_2 == MediationInitializer.EInitStatus.INIT_FAILED) {
                                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                                this.mCallbackThrotteler.onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
                                return;
                            }
                            if (this.mSmashArray.size() == 0) {
                                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "the server response does not contain interstitial data", 3);
                                this.mCallbackThrotteler.onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", "Interstitial"));
                                return;
                            }
                            this.logMediationEvent(22, null);
                            this.mShouldSendAdReadyEvent = true;
                            this.changeStateToInitiated();
                            var10_3 = new AbstractSmash.MEDIATION_STATE[]{AbstractSmash.MEDIATION_STATE.INITIATED};
                            if (this.smashesCount(var10_3) != 0) ** GOTO lbl45
                            var15_4 = this.mDidFinishToInitInterstitial;
                            if (var15_4) break block16;
                            return;
                        }
                        var16_5 = ErrorBuilder.buildGenericError("no ads to load");
                        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, var16_5.getErrorMessage(), 1);
                        this.mCallbackThrotteler.onInterstitialAdLoadFailed(var16_5);
                        var17_6 = new Object[1][];
                        var18_7 = new Object[]{"errorCode", var16_5.getErrorCode()};
                        var17_6[0] = var18_7;
                        this.logMediationEvent(227, var17_6);
                        this.mShouldSendAdReadyEvent = false;
                        return;
lbl45: // 1 sources:
                        this.mDidCallLoadInterstitial = true;
                        this.mIsLoadInterstitialInProgress = true;
                        var11_8 = this.mSmashArray.iterator();
                        var12_9 = 0;
                        while (var11_8.hasNext()) {
                            var13_10 = (AbstractSmash)var11_8.next();
                            if (var13_10.getMediationState() != AbstractSmash.MEDIATION_STATE.INITIATED) continue;
                            var13_10.setMediationState(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
                            this.loadAdapterAndSendEvent((InterstitialSmash)var13_10);
                        }
                        {
                            ++var12_9;
                            var14_11 = this.mSmartLoadAmount;
                            if (var12_9 < var14_11) continue;
                            return;
                            break;
                        }
                    }
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Load Interstitial is already in progress", 1);
                    return;
                    catch (Throwable var8_12) {
                        break block17;
                    }
                    catch (Exception var1_13) {
                        var1_13.printStackTrace();
                        var2_14 = new StringBuilder();
                        var2_14.append("loadInterstitial exception ");
                        var2_14.append(var1_13.getMessage());
                        var5_15 = ErrorBuilder.buildLoadFailedError(var2_14.toString());
                        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, var5_15.getErrorMessage(), 3);
                        this.mCallbackThrotteler.onInterstitialAdLoadFailed(var5_15);
                        if (!this.mShouldSendAdReadyEvent) break block18;
                        this.mShouldSendAdReadyEvent = false;
                        var6_16 = new Object[1][];
                        var7_17 = new Object[]{"errorCode", var5_15.getErrorCode()};
                        var6_16[0] = var7_17;
                        this.logMediationEvent(227, var6_16);
                    }
                }
                return;
            }
        }
        throw var8_12;
    }

    /*
     * Exception decompiling
     */
    public void loadInterstitial(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl186 : ALOAD : trying to set 1 previously set to 0
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:203)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1489)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:308)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:182)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.f.c(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.g.p(Method.java:396)
        // org.benf.cfr.reader.entities.d.e(ClassFile.java:890)
        // org.benf.cfr.reader.entities.d.b(ClassFile.java:792)
        // org.benf.cfr.reader.b.a(Driver.java:128)
        // org.benf.cfr.reader.a.a(CfrDriverImpl.java:63)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.decompileWithCFR(JavaExtractionWorker.kt:61)
        // com.njlabs.showjava.decompilers.JavaExtractionWorker.doWork(JavaExtractionWorker.kt:130)
        // com.njlabs.showjava.decompilers.BaseDecompiler.withAttempt(BaseDecompiler.kt:108)
        // com.njlabs.showjava.workers.DecompilerWorker$b.run(DecompilerWorker.kt:118)
        // java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        // java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        // java.lang.Thread.run(Thread.java:919)
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void onDailyCapReleased() {
        if (this.mSmashArray != null) {
            for (AbstractSmash abstractSmash : this.mSmashArray) {
                if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY) continue;
                this.logProviderEvent(250, abstractSmash, new Object[][]{{"status", "false"}});
                if (abstractSmash.isCappedPerSession()) {
                    abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION);
                    continue;
                }
                if (abstractSmash.isExhausted()) {
                    abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.EXHAUSTED);
                    continue;
                }
                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.INITIATED);
            }
        }
    }

    @Override
    public void onInitFailed(String string) {
        if (this.mIsInISDemandOnlyMode) {
            for (String string2 : this.mInstancesToLoad) {
                this.mCallbackThrotteler.onInterstitialAdLoadFailed(string2, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            }
            this.mInstancesToLoad.clear();
            return;
        }
        if (this.mDidCallLoadInterstitial) {
            this.mCallbackThrotteler.onInterstitialAdLoadFailed(ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            this.mDidCallLoadInterstitial = false;
            this.mIsLoadInterstitialInProgress = false;
        }
    }

    @Override
    public void onInitSuccess(List<IronSource.AD_UNIT> list, boolean bl) {
    }

    @Override
    public void onInterstitialAdClicked(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(interstitialSmash.getInstanceName());
        stringBuilder.append(":onInterstitialAdClicked()");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        this.logProviderEvent(28, (AbstractSmash)interstitialSmash, null);
        if (this.mIsInISDemandOnlyMode) {
            this.mISDemandOnlyInterstitialListener.onInterstitialAdClicked(interstitialSmash.getSubProviderId());
            return;
        }
        this.mInterstitialListenersWrapper.onInterstitialAdClicked();
    }

    @Override
    public void onInterstitialAdClosed(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(interstitialSmash.getInstanceName());
        stringBuilder.append(":onInterstitialAdClosed()");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        this.logProviderEvent(26, (AbstractSmash)interstitialSmash, null);
        if (this.mIsInISDemandOnlyMode) {
            this.mISDemandOnlyInterstitialListener.onInterstitialAdClosed(interstitialSmash.getSubProviderId());
            return;
        }
        this.mInterstitialListenersWrapper.onInterstitialAdClosed();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError, InterstitialSmash interstitialSmash) {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(interstitialSmash.getInstanceName());
            stringBuilder.append(":onInterstitialAdLoadFailed(");
            stringBuilder.append((Object)ironSourceError);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            Object[][] arrobject = new Object[1][];
            Object[] arrobject2 = new Object[]{"errorCode", ironSourceError.getErrorCode()};
            arrobject[0] = arrobject2;
            this.logProviderEvent(227, (AbstractSmash)interstitialSmash, arrobject);
            if (this.mIsInISDemandOnlyMode) {
                this.mCallbackThrotteler.onInterstitialAdLoadFailed(interstitialSmash.getSubProviderId(), ironSourceError);
                Object[][] arrobject3 = new Object[1][];
                Object[] arrobject4 = new Object[]{"errorCode", ironSourceError.getErrorCode()};
                arrobject3[0] = arrobject4;
                this.logMediationEvent(227, arrobject3);
                return;
            } else {
                interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.NOT_AVAILABLE);
                AbstractSmash.MEDIATION_STATE[] arrmEDIATION_STATE = new AbstractSmash.MEDIATION_STATE[]{AbstractSmash.MEDIATION_STATE.AVAILABLE, AbstractSmash.MEDIATION_STATE.LOAD_PENDING};
                int n2 = this.smashesCount(arrmEDIATION_STATE);
                int n3 = this.mSmartLoadAmount;
                if (n2 >= n3) {
                    return;
                }
                for (AbstractSmash abstractSmash : this.mSmashArray) {
                    if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.INITIATED) continue;
                    abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
                    this.loadAdapterAndSendEvent((InterstitialSmash)abstractSmash);
                    return;
                }
                AbstractAdapter abstractAdapter = this.startNextAdapter();
                if (abstractAdapter != null) {
                    return;
                }
                if (!this.mDidCallLoadInterstitial) return;
                if (n2 != 0) return;
                this.completeIterationRound();
                this.mIsLoadInterstitialInProgress = false;
                this.mCallbackThrotteler.onInterstitialAdLoadFailed(ironSourceError);
                Object[][] arrobject5 = new Object[1][];
                Object[] arrobject6 = new Object[]{"errorCode", ironSourceError.getErrorCode()};
                arrobject5[0] = arrobject6;
                this.logMediationEvent(227, arrobject5);
            }
            return;
        }
    }

    @Override
    public void onInterstitialAdOpened(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(interstitialSmash.getInstanceName());
        stringBuilder.append(":onInterstitialAdOpened()");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        this.logProviderEvent(25, (AbstractSmash)interstitialSmash, null);
        if (this.mIsInISDemandOnlyMode) {
            this.mISDemandOnlyInterstitialListener.onInterstitialAdOpened(interstitialSmash.getSubProviderId());
            return;
        }
        this.mInterstitialListenersWrapper.onInterstitialAdOpened();
    }

    @Override
    public void onInterstitialAdReady(InterstitialSmash interstitialSmash) {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(interstitialSmash.getInstanceName());
            stringBuilder.append(":onInterstitialAdReady()");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.logProviderEvent(27, (AbstractSmash)interstitialSmash, new Object[][]{{"status", "true"}});
            if (this.mIsInISDemandOnlyMode) {
                interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.AVAILABLE);
                this.mISDemandOnlyInterstitialListener.onInterstitialAdReady(interstitialSmash.getSubProviderId());
                this.logMediationEvent(27, new Object[][]{{"status", "true"}});
            } else {
                interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.AVAILABLE);
                this.mIsLoadInterstitialInProgress = false;
                if (this.mShouldSendAdReadyEvent) {
                    this.mShouldSendAdReadyEvent = false;
                    this.mInterstitialListenersWrapper.onInterstitialAdReady();
                    this.logMediationEvent(27, new Object[][]{{"status", "true"}});
                }
            }
            return;
        }
    }

    @Override
    public void onInterstitialAdRewarded(InterstitialSmash interstitialSmash) {
        this.logProviderEvent(290, (AbstractSmash)interstitialSmash, null);
        RewardedInterstitialListener rewardedInterstitialListener = this.mRewardedInterstitialListenerWrapper;
        if (rewardedInterstitialListener != null) {
            rewardedInterstitialListener.onInterstitialAdRewarded();
        }
    }

    @Override
    public void onInterstitialAdShowFailed(IronSourceError ironSourceError, InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(interstitialSmash.getInstanceName());
        stringBuilder.append(":onInterstitialAdShowFailed(");
        stringBuilder.append((Object)ironSourceError);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mIsInISDemandOnlyMode) {
            this.mISDemandOnlyInterstitialListener.onInterstitialAdShowFailed(interstitialSmash.getSubProviderId(), ironSourceError);
            return;
        }
        this.completeAdapterShow((AbstractSmash)interstitialSmash);
        Iterator iterator = this.mSmashArray.iterator();
        while (iterator.hasNext()) {
            if (((AbstractSmash)iterator.next()).getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE) continue;
            this.mDidCallLoadInterstitial = true;
            this.showInterstitial(this.mCurrentPlacement.getPlacementName());
            return;
        }
        this.mInterstitialListenersWrapper.onInterstitialAdShowFailed(ironSourceError);
    }

    @Override
    public void onInterstitialAdShowSucceeded(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(interstitialSmash.getInstanceName());
        stringBuilder.append(":onInterstitialAdShowSucceeded()");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (this.mIsInISDemandOnlyMode) {
            this.mISDemandOnlyInterstitialListener.onInterstitialAdShowSucceeded(interstitialSmash.getSubProviderId());
            return;
        }
        boolean bl = false;
        for (AbstractSmash abstractSmash : this.mSmashArray) {
            if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE) continue;
            this.completeAdapterShow(abstractSmash);
            bl = true;
        }
        if (!(bl || interstitialSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.CAPPED_PER_SESSION && interstitialSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.EXHAUSTED && interstitialSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY)) {
            this.completeIterationRound();
        }
        this.changeStateToInitiated();
        this.mInterstitialListenersWrapper.onInterstitialAdShowSucceeded();
    }

    @Override
    public void onInterstitialAdVisible(InterstitialSmash interstitialSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(interstitialSmash.getInstanceName());
        stringBuilder.append(":onInterstitialAdVisible()");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        Object[][] arrobject = new Object[1][];
        Object[] arrobject2 = new Object[]{"placement", this.mCurrentPlacement.getPlacementName()};
        arrobject[0] = arrobject2;
        this.logProviderEvent(31, (AbstractSmash)interstitialSmash, arrobject);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onInterstitialInitFailed(IronSourceError ironSourceError, InterstitialSmash interstitialSmash) {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            try {
                try {
                    IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(interstitialSmash.getInstanceName());
                    stringBuilder.append(":onInterstitialInitFailed(");
                    stringBuilder.append((Object)ironSourceError);
                    stringBuilder.append(")");
                    ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
                    if (this.mIsInISDemandOnlyMode) {
                        String string = interstitialSmash.getSubProviderId();
                        if (this.mInstancesToLoad.contains((Object)string)) {
                            this.mInstancesToLoad.remove((Object)string);
                            this.mCallbackThrotteler.onInterstitialAdLoadFailed(string, ErrorBuilder.buildGenericError("no ads to show"));
                            Object[][] arrobject = new Object[1][];
                            Object[] arrobject2 = new Object[]{"errorCode", 510};
                            arrobject[0] = arrobject2;
                            this.logMediationEvent(227, arrobject);
                            Object[][] arrobject3 = new Object[1][];
                            Object[] arrobject4 = new Object[]{"errorCode", 510};
                            arrobject3[0] = arrobject4;
                            this.logProviderEvent(227, (AbstractSmash)interstitialSmash, arrobject3);
                        }
                    } else {
                        AbstractSmash.MEDIATION_STATE[] arrmEDIATION_STATE = new AbstractSmash.MEDIATION_STATE[]{AbstractSmash.MEDIATION_STATE.INIT_FAILED};
                        if (this.smashesCount(arrmEDIATION_STATE) >= this.mSmashArray.size()) {
                            IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
                            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.NATIVE;
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Smart Loading - initialization failed - no adapters are initiated and no more left to init, error: ");
                            stringBuilder2.append(ironSourceError.getErrorMessage());
                            ironSourceLoggerManager2.log(ironSourceTag2, stringBuilder2.toString(), 2);
                            if (this.mDidCallLoadInterstitial) {
                                this.mCallbackThrotteler.onInterstitialAdLoadFailed(ErrorBuilder.buildGenericError("no ads to show"));
                                Object[][] arrobject = new Object[1][];
                                Object[] arrobject5 = new Object[]{"errorCode", 510};
                                arrobject[0] = arrobject5;
                                this.logMediationEvent(227, arrobject);
                                this.mShouldSendAdReadyEvent = false;
                            }
                            this.mDidFinishToInitInterstitial = true;
                        } else {
                            this.startNextAdapter();
                            this.completeIterationRound();
                        }
                    }
                }
                catch (Exception exception) {
                    IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onInterstitialInitFailed(error:");
                    stringBuilder.append((Object)ironSourceError);
                    stringBuilder.append(", ");
                    stringBuilder.append("provider:");
                    stringBuilder.append(interstitialSmash.getName());
                    stringBuilder.append(")");
                    ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), exception);
                }
                return;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    @Override
    public void onInterstitialInitSuccess(InterstitialSmash interstitialSmash) {
        InterstitialManager interstitialManager = this;
        synchronized (interstitialManager) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(interstitialSmash.getInstanceName());
            stringBuilder.append(" :onInterstitialInitSuccess()");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mDidFinishToInitInterstitial = true;
            if (this.mIsInISDemandOnlyMode) {
                String string = interstitialSmash.getSubProviderId();
                if (this.mInstancesToLoad.contains((Object)string)) {
                    this.mInstancesToLoad.remove((Object)string);
                    this.loadInterstitial(string);
                }
            } else if (this.mDidCallLoadInterstitial) {
                AbstractSmash.MEDIATION_STATE[] arrmEDIATION_STATE = new AbstractSmash.MEDIATION_STATE[]{AbstractSmash.MEDIATION_STATE.AVAILABLE, AbstractSmash.MEDIATION_STATE.LOAD_PENDING};
                if (this.smashesCount(arrmEDIATION_STATE) < this.mSmartLoadAmount) {
                    interstitialSmash.setMediationState(AbstractSmash.MEDIATION_STATE.LOAD_PENDING);
                    this.loadAdapterAndSendEvent(interstitialSmash);
                }
            }
            return;
        }
    }

    @Override
    public void onStillInProgressAfter15Secs() {
        if (this.mIsInISDemandOnlyMode) {
            for (String string : this.mInstancesToLoad) {
                this.mCallbackThrotteler.onInterstitialAdLoadFailed(string, ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial"));
            }
            this.mInstancesToLoad.clear();
            return;
        }
        if (this.mDidCallLoadInterstitial) {
            IronSourceError ironSourceError = ErrorBuilder.buildInitFailedError("init() had failed", "Interstitial");
            this.mCallbackThrotteler.onInterstitialAdLoadFailed(ironSourceError);
            this.mDidCallLoadInterstitial = false;
            this.mIsLoadInterstitialInProgress = false;
            if (this.mShouldSendAdReadyEvent) {
                Object[][] arrobject = new Object[1][];
                Object[] arrobject2 = new Object[]{"errorCode", ironSourceError.getErrorCode()};
                arrobject[0] = arrobject2;
                this.logMediationEvent(227, arrobject);
                this.mShouldSendAdReadyEvent = false;
            }
        }
    }

    void setCurrentPlacement(InterstitialPlacement interstitialPlacement) {
        this.mCurrentPlacement = interstitialPlacement;
    }

    public void setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        this.mISDemandOnlyInterstitialListener = iSDemandOnlyInterstitialListener;
        this.mCallbackThrotteler.setISDemandOnlyInterstitialListener(iSDemandOnlyInterstitialListener);
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        this.mInterstitialListenersWrapper = (ListenersWrapper)interstitialListener;
        this.mCallbackThrotteler.setInterstitialListener(interstitialListener);
    }

    public void setRewardedInterstitialListener(RewardedInterstitialListener rewardedInterstitialListener) {
        this.mRewardedInterstitialListenerWrapper = rewardedInterstitialListener;
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
    }

    public void showInterstitial(String string) {
        if (this.mShouldTrackNetworkState && this.mActivity != null && !IronSourceUtils.isNetworkConnected((Context)this.mActivity)) {
            this.mInterstitialListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildNoInternetConnectionShowFailError("Interstitial"));
            return;
        }
        if (!this.mDidCallLoadInterstitial) {
            this.mInterstitialListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", "showInterstitial failed - You need to load interstitial before showing it"));
            return;
        }
        for (int i2 = 0; i2 < this.mSmashArray.size(); ++i2) {
            AbstractSmash abstractSmash = (AbstractSmash)this.mSmashArray.get(i2);
            if (abstractSmash.getMediationState() != AbstractSmash.MEDIATION_STATE.AVAILABLE) continue;
            CappingManager.incrementShowCounter((Context)this.mActivity, this.mCurrentPlacement);
            this.logProviderEvent(23, abstractSmash, new Object[][]{{"placement", string}});
            this.sendShowChanceEvents(abstractSmash, i2, string);
            ((InterstitialSmash)abstractSmash).showInterstitial();
            this.mDailyCappingManager.increaseShowCounter(abstractSmash);
            if (this.mDailyCappingManager.isCapped(abstractSmash)) {
                abstractSmash.setMediationState(AbstractSmash.MEDIATION_STATE.CAPPED_PER_DAY);
                this.logProviderEvent(250, abstractSmash, new Object[][]{{"status", "true"}});
            }
            this.mDidCallLoadInterstitial = false;
            if (!abstractSmash.isMediationAvailable()) {
                this.startNextAdapter();
            }
            return;
        }
        this.mInterstitialListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", "showInterstitial failed - No adapters ready to show"));
    }

    public void showInterstitial(String string, String string2) {
        if (this.mShouldTrackNetworkState && this.mActivity != null && !IronSourceUtils.isNetworkConnected((Context)this.mActivity)) {
            this.mISDemandOnlyInterstitialListener.onInterstitialAdShowFailed(string, ErrorBuilder.buildNoInternetConnectionShowFailError("Interstitial"));
            return;
        }
        boolean bl = false;
        for (int i2 = 0; i2 < this.mSmashArray.size(); ++i2) {
            AbstractSmash abstractSmash = (AbstractSmash)this.mSmashArray.get(i2);
            if (!abstractSmash.getSubProviderId().equals((Object)string)) continue;
            if (abstractSmash.getMediationState() == AbstractSmash.MEDIATION_STATE.AVAILABLE) {
                CappingManager.incrementShowCounter((Context)this.mActivity, this.mCurrentPlacement);
                this.logProviderEvent(23, abstractSmash, new Object[][]{{"placement", string2}});
                this.sendShowChanceEvents(abstractSmash, i2, string2);
                ((InterstitialSmash)abstractSmash).showInterstitial();
                this.changeStateToInitiatedForInstanceId(string);
                return;
            }
            bl = true;
        }
        if (!bl) {
            this.mISDemandOnlyInterstitialListener.onInterstitialAdShowFailed(string, ErrorBuilder.buildNonExistentInstanceError("no ads to show"));
            return;
        }
        this.mISDemandOnlyInterstitialListener.onInterstitialAdShowFailed(string, ErrorBuilder.buildShowFailedError("Interstitial", "no ads to show"));
    }
}

