/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Pair
 *  com.ironsource.mediationsdk.InterstitialSmash
 *  com.ironsource.mediationsdk.OfferwallManager
 *  com.ironsource.mediationsdk.sdk.ListenersWrapper
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  java.util.UUID
 *  java.util.Vector
 *  java.util.concurrent.CopyOnWriteArrayList
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.environment.DeviceStatus;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AbstractSmash;
import com.ironsource.mediationsdk.BannerCallbackThrottler;
import com.ironsource.mediationsdk.BannerManager;
import com.ironsource.mediationsdk.EBannerSize;
import com.ironsource.mediationsdk.InterstitialManager;
import com.ironsource.mediationsdk.InterstitialSmash;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.MediationInitializer;
import com.ironsource.mediationsdk.OfferwallManager;
import com.ironsource.mediationsdk.RewardedVideoManager;
import com.ironsource.mediationsdk.RewardedVideoSmash;
import com.ironsource.mediationsdk.config.ConfigValidationResult;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.events.SuperLooper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.logger.PublisherLogger;
import com.ironsource.mediationsdk.model.ApplicationConfigurations;
import com.ironsource.mediationsdk.model.ApplicationEvents;
import com.ironsource.mediationsdk.model.ApplicationLogger;
import com.ironsource.mediationsdk.model.BannerConfigurations;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.model.Configurations;
import com.ironsource.mediationsdk.model.InterstitialConfigurations;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.OfferwallConfigurations;
import com.ironsource.mediationsdk.model.OfferwallPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.ProviderOrder;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.model.ProviderSettingsHolder;
import com.ironsource.mediationsdk.model.RewardedVideoConfigurations;
import com.ironsource.mediationsdk.model.ServerSegmetData;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.sdk.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.InternalOfferwallListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.InterstitialManagerListener;
import com.ironsource.mediationsdk.sdk.ListenersWrapper;
import com.ironsource.mediationsdk.sdk.OfferwallListener;
import com.ironsource.mediationsdk.sdk.RewardedInterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManagerListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.server.HttpFunctions;
import com.ironsource.mediationsdk.server.ServerURL;
import com.ironsource.mediationsdk.utils.CappingManager;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.GeneralPropertiesWorker;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.ServerResponseWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceObject
implements MediationInitializer.OnMediationInitializationListener {
    private static IronSourceObject sInstance;
    private final String KEY_INIT_COUNTER = "sessionDepth";
    private final String TAG = this.getClass().getName();
    private Activity mActivity;
    private Set<IronSource.AD_UNIT> mAdUnitsToInitialize;
    private String mAppKey = null;
    private AtomicBoolean mAtomicIsFirstInit;
    private ArrayList<AbstractAdapter> mBannerAdaptersList;
    private BannerManager mBannerManager;
    private IronSourceBannerLayout mBnLayoutToLoad;
    private String mBnPlacementToLoad;
    private Boolean mConsent = null;
    private ServerResponseWrapper mCurrentServerResponse = null;
    private ArrayList<IronSource.AD_UNIT> mDemandOnlyAdUnits;
    private boolean mDidInitBanner;
    private boolean mDidInitInterstitial;
    private String mDynamicUserId = null;
    private AtomicBoolean mEventManagersInit;
    private int mInitCounter;
    private boolean mInitSucceeded = false;
    private List<IronSource.AD_UNIT> mInitiatedAdUnits;
    private ArrayList<AbstractAdapter> mInterstitialAdaptersList;
    private InterstitialManager mInterstitialManager;
    private IronSourceSegment mIronSegment;
    private boolean mIsBnLoadBeforeInitCompleted;
    private ListenersWrapper mListenersWrapper;
    private IronSourceLoggerManager mLoggerManager;
    private String mMediationType = null;
    private AbstractAdapter mOfferwallAdapter;
    private OfferwallManager mOfferwallManager;
    private PublisherLogger mPublisherLogger;
    private Set<IronSource.AD_UNIT> mRequestedAdUnits;
    private ArrayList<AbstractAdapter> mRewardedVideoAdaptersList;
    private RewardedVideoManager mRewardedVideoManager;
    private Map<String, String> mRvServerParams = null;
    private String mSegment = null;
    private final Object mServerResponseLocker = new Object();
    private String mSessionId = null;
    private boolean mShouldSendGetInstanceEvent = true;
    private Integer mUserAge = null;
    private String mUserGender = null;
    private String mUserId = null;

    private IronSourceObject() {
        this.initializeManagers();
        this.mEventManagersInit = new AtomicBoolean();
        this.mDemandOnlyAdUnits = new ArrayList();
        this.mRewardedVideoAdaptersList = new ArrayList();
        this.mInterstitialAdaptersList = new ArrayList();
        this.mBannerAdaptersList = new ArrayList();
        this.mAdUnitsToInitialize = new HashSet();
        this.mRequestedAdUnits = new HashSet();
        this.mAtomicIsFirstInit = new AtomicBoolean(true);
        this.mInitCounter = 0;
        this.mDidInitInterstitial = false;
        this.mDidInitBanner = false;
        this.mSessionId = UUID.randomUUID().toString();
        this.mIsBnLoadBeforeInitCompleted = false;
        this.mBnPlacementToLoad = null;
    }

    /*
     * Exception decompiling
     */
    private /* varargs */ void attachAdUnits(boolean var1_1, IronSource.AD_UNIT ... var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [17[UNCONDITIONALDOLOOP]], but top level block is 6[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private ServerResponseWrapper connectAndGetServerResponse(Context context, String string, IResponseListener iResponseListener) {
        ServerResponseWrapper serverResponseWrapper;
        void var4_14;
        block9 : {
            if (!IronSourceUtils.isNetworkConnected(context)) {
                return null;
            }
            String string2 = this.getAdvertiserId(context);
            if (TextUtils.isEmpty((CharSequence)string2)) {
                string2 = DeviceStatus.getOrGenerateOnceUniqueIdentifier(context);
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 1);
            }
            String string3 = string2;
            Vector<Pair<String, String>> vector = this.mIronSegment != null ? this.mIronSegment.getSegmentData() : null;
            String string4 = this.getMediationType();
            String string5 = HttpFunctions.getStringFromURL(ServerURL.getCPVProvidersURL(context, this.getIronSourceAppKey(), string, string3, string4, vector), iResponseListener);
            if (string5 == null) {
                return null;
            }
            if (IronSourceUtils.getSerr() == 1) {
                String string6 = new JSONObject(string5).optString("response", null);
                if (TextUtils.isEmpty((CharSequence)string6)) {
                    return null;
                }
                string5 = IronSourceAES.decode("C38FB23A402222A0C17D34A92F971D1F", string6);
            }
            serverResponseWrapper = new ServerResponseWrapper(context, this.getIronSourceAppKey(), string, string5);
            try {
                boolean bl = serverResponseWrapper.isValidResponse();
                if (bl) return serverResponseWrapper;
                return null;
            }
            catch (Exception exception) {}
            break block9;
            catch (Exception exception) {
                serverResponseWrapper = null;
            }
        }
        var4_14.printStackTrace();
        return serverResponseWrapper;
    }

    private BannerPlacement getBannerPlacement(String string) {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getDefaultBannerPlacement();
        }
        BannerPlacement bannerPlacement = this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getBannerPlacement(string);
        if (bannerPlacement != null) {
            return bannerPlacement;
        }
        return this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getDefaultBannerPlacement();
    }

    /*
     * Exception decompiling
     */
    private ServerResponseWrapper getCachedResponse(Context var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl14 : ALOAD : trying to set 1 previously set to 0
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

    public static IronSourceObject getInstance() {
        Class<IronSourceObject> class_ = IronSourceObject.class;
        synchronized (IronSourceObject.class) {
            if (sInstance == null) {
                sInstance = new IronSourceObject();
            }
            IronSourceObject ironSourceObject = sInstance;
            // ** MonitorExit[var2] (shouldn't be in output)
            return ironSourceObject;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private CappingManager.ECappingStatus getInterstitialCappingStatus(String string) {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        if (serverResponseWrapper == null) return CappingManager.ECappingStatus.NOT_CAPPED;
        if (serverResponseWrapper.getConfigurations() == null) return CappingManager.ECappingStatus.NOT_CAPPED;
        if (this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations() == null) {
            return CappingManager.ECappingStatus.NOT_CAPPED;
        }
        InterstitialPlacement interstitialPlacement = null;
        try {
            interstitialPlacement = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getInterstitialPlacement(string);
            if (interstitialPlacement == null && (interstitialPlacement = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getDefaultInterstitialPlacement()) == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (interstitialPlacement != null) return CappingManager.isPlacementCapped((Context)this.mActivity, interstitialPlacement);
        return CappingManager.ECappingStatus.NOT_CAPPED;
    }

    private InterstitialPlacement getInterstitialPlacementToShowWithEvent(String string) {
        InterstitialPlacement interstitialPlacement = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getInterstitialPlacement(string);
        if (interstitialPlacement == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            interstitialPlacement = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getDefaultInterstitialPlacement();
            if (interstitialPlacement == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        CappingManager.ECappingStatus eCappingStatus = this.getInterstitialCappingStatus(interstitialPlacement.getPlacementName());
        String string2 = this.getCappingMessage(interstitialPlacement.getPlacementName(), eCappingStatus);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
            this.mListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildCappedPerPlacementError("Interstitial", string2));
            return null;
        }
        return interstitialPlacement;
    }

    private Placement getPlacementToShowWithEvent(String string) {
        Placement placement = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoPlacement(string);
        if (placement == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
            placement = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getDefaultRewardedVideoPlacement();
            if (placement == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                return null;
            }
        }
        CappingManager.ECappingStatus eCappingStatus = CappingManager.isPlacementCapped((Context)this.mActivity, placement);
        String string2 = this.getCappingMessage(placement.getPlacementName(), eCappingStatus);
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
            this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildCappedPerPlacementError("Rewarded Video", string2));
            return null;
        }
        return placement;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private CappingManager.ECappingStatus getRewardedVideoCappingStatus(String string) {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        if (serverResponseWrapper == null) return CappingManager.ECappingStatus.NOT_CAPPED;
        if (serverResponseWrapper.getConfigurations() == null) return CappingManager.ECappingStatus.NOT_CAPPED;
        if (this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations() == null) {
            return CappingManager.ECappingStatus.NOT_CAPPED;
        }
        Placement placement = null;
        try {
            placement = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoPlacement(string);
            if (placement == null && (placement = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getDefaultRewardedVideoPlacement()) == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found", 3);
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        if (placement != null) return CappingManager.isPlacementCapped((Context)this.mActivity, placement);
        return CappingManager.ECappingStatus.NOT_CAPPED;
    }

    private void initializeEventsSettings(ServerResponseWrapper serverResponseWrapper, Context context) {
        boolean bl = this.isRewardedVideoConfigurationsReady() ? serverResponseWrapper.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations().isEventsEnabled() : false;
        boolean bl2 = this.isInterstitialConfigurationsReady() ? serverResponseWrapper.getConfigurations().getInterstitialConfigurations().getInterstitialEventsConfigurations().isEventsEnabled() : false;
        boolean bl3 = this.isBannerConfigurationsReady() ? serverResponseWrapper.getConfigurations().getBannerConfigurations().getBannerEventsConfigurations().isEventsEnabled() : false;
        if (bl) {
            RewardedVideoEventsManager.getInstance().setFormatterType(serverResponseWrapper.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations().getEventsType(), context);
            RewardedVideoEventsManager.getInstance().setEventsUrl(serverResponseWrapper.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations().getEventsURL(), context);
            RewardedVideoEventsManager.getInstance().setMaxNumberOfEvents(serverResponseWrapper.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations().getMaxNumberOfEvents());
            RewardedVideoEventsManager.getInstance().setMaxEventsPerBatch(serverResponseWrapper.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations().getMaxEventsPerBatch());
            RewardedVideoEventsManager.getInstance().setBackupThreshold(serverResponseWrapper.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations().getEventsBackupThreshold());
            RewardedVideoEventsManager.getInstance().setOptOutEvents(serverResponseWrapper.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations().getOptOutEvents(), context);
            RewardedVideoEventsManager.getInstance().setServerSegmentData(serverResponseWrapper.getConfigurations().getApplicationConfigurations().getSegmetData());
        } else {
            RewardedVideoEventsManager.getInstance().setIsEventsEnabled(false);
        }
        if (bl2) {
            InterstitialEventsManager.getInstance().setFormatterType(serverResponseWrapper.getConfigurations().getInterstitialConfigurations().getInterstitialEventsConfigurations().getEventsType(), context);
            InterstitialEventsManager.getInstance().setEventsUrl(serverResponseWrapper.getConfigurations().getInterstitialConfigurations().getInterstitialEventsConfigurations().getEventsURL(), context);
            InterstitialEventsManager.getInstance().setMaxNumberOfEvents(serverResponseWrapper.getConfigurations().getInterstitialConfigurations().getInterstitialEventsConfigurations().getMaxNumberOfEvents());
            InterstitialEventsManager.getInstance().setMaxEventsPerBatch(serverResponseWrapper.getConfigurations().getInterstitialConfigurations().getInterstitialEventsConfigurations().getMaxEventsPerBatch());
            InterstitialEventsManager.getInstance().setBackupThreshold(serverResponseWrapper.getConfigurations().getInterstitialConfigurations().getInterstitialEventsConfigurations().getEventsBackupThreshold());
            InterstitialEventsManager.getInstance().setOptOutEvents(serverResponseWrapper.getConfigurations().getInterstitialConfigurations().getInterstitialEventsConfigurations().getOptOutEvents(), context);
            InterstitialEventsManager.getInstance().setServerSegmentData(serverResponseWrapper.getConfigurations().getApplicationConfigurations().getSegmetData());
            return;
        }
        if (bl3) {
            ApplicationEvents applicationEvents = serverResponseWrapper.getConfigurations().getBannerConfigurations().getBannerEventsConfigurations();
            InterstitialEventsManager.getInstance().setFormatterType(applicationEvents.getEventsType(), context);
            InterstitialEventsManager.getInstance().setEventsUrl(applicationEvents.getEventsURL(), context);
            InterstitialEventsManager.getInstance().setMaxNumberOfEvents(applicationEvents.getMaxNumberOfEvents());
            InterstitialEventsManager.getInstance().setMaxEventsPerBatch(applicationEvents.getMaxEventsPerBatch());
            InterstitialEventsManager.getInstance().setBackupThreshold(applicationEvents.getEventsBackupThreshold());
            InterstitialEventsManager.getInstance().setOptOutEvents(applicationEvents.getOptOutEvents(), context);
            InterstitialEventsManager.getInstance().setServerSegmentData(serverResponseWrapper.getConfigurations().getApplicationConfigurations().getSegmetData());
            return;
        }
        InterstitialEventsManager.getInstance().setIsEventsEnabled(false);
    }

    private void initializeLoggerManager(ServerResponseWrapper serverResponseWrapper) {
        this.mPublisherLogger.setDebugLevel(serverResponseWrapper.getConfigurations().getApplicationConfigurations().getLoggerConfigurations().getPublisherLoggerLevel());
        this.mLoggerManager.setLoggerDebugLevel("console", serverResponseWrapper.getConfigurations().getApplicationConfigurations().getLoggerConfigurations().getConsoleLoggerLevel());
    }

    private void initializeManagers() {
        this.mLoggerManager = IronSourceLoggerManager.getLogger(0);
        this.mPublisherLogger = new PublisherLogger(null, 1);
        this.mLoggerManager.addLogger(this.mPublisherLogger);
        this.mListenersWrapper = new ListenersWrapper();
        this.mRewardedVideoManager = new RewardedVideoManager();
        this.mRewardedVideoManager.setRewardedVideoListener((RewardedVideoListener)this.mListenersWrapper);
        this.mRewardedVideoManager.setISDemandOnlyRewardedVideoListener((ISDemandOnlyRewardedVideoListener)this.mListenersWrapper);
        this.mInterstitialManager = new InterstitialManager();
        this.mInterstitialManager.setInterstitialListener((InterstitialListener)this.mListenersWrapper);
        this.mInterstitialManager.setRewardedInterstitialListener((RewardedInterstitialListener)this.mListenersWrapper);
        this.mInterstitialManager.setISDemandOnlyInterstitialListener((ISDemandOnlyInterstitialListener)this.mListenersWrapper);
        this.mOfferwallManager = new OfferwallManager();
        this.mOfferwallManager.setInternalOfferwallListener((InternalOfferwallListener)this.mListenersWrapper);
        this.mBannerManager = new BannerManager();
    }

    private void initializeSettingsFromServerResponse(ServerResponseWrapper serverResponseWrapper, Context context) {
        this.initializeLoggerManager(serverResponseWrapper);
        this.initializeEventsSettings(serverResponseWrapper, context);
    }

    private boolean isBannerConfigurationsReady() {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        return serverResponseWrapper != null && serverResponseWrapper.getConfigurations() != null && this.mCurrentServerResponse.getConfigurations().getBannerConfigurations() != null;
    }

    private boolean isInterstitialConfigurationsReady() {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        return serverResponseWrapper != null && serverResponseWrapper.getConfigurations() != null && this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations() != null;
    }

    private boolean isOfferwallConfigurationsReady() {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        return serverResponseWrapper != null && serverResponseWrapper.getConfigurations() != null && this.mCurrentServerResponse.getConfigurations().getOfferwallConfigurations() != null;
    }

    private boolean isRewardedVideoConfigurationsReady() {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        return serverResponseWrapper != null && serverResponseWrapper.getConfigurations() != null && this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations() != null;
    }

    private void notifyPublisherAboutInitFailed(IronSource.AD_UNIT aD_UNIT, boolean bl) {
        int n2 = 1.$SwitchMap$com$ironsource$mediationsdk$IronSource$AD_UNIT[aD_UNIT.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        return;
                    }
                    if (this.mIsBnLoadBeforeInitCompleted) {
                        this.mIsBnLoadBeforeInitCompleted = false;
                        BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(this.mBnLayoutToLoad, new IronSourceError(602, "Init had failed"));
                        this.mBnLayoutToLoad = null;
                        this.mBnPlacementToLoad = null;
                        return;
                    }
                } else if (bl || this.isOfferwallConfigurationsReady() || this.mRequestedAdUnits.contains((Object)aD_UNIT)) {
                    this.mListenersWrapper.onOfferwallAvailable(false);
                    return;
                }
            }
        } else if (bl || this.isRewardedVideoConfigurationsReady() || this.mRequestedAdUnits.contains((Object)aD_UNIT)) {
            this.mListenersWrapper.onRewardedVideoAvailabilityChanged(false);
        }
    }

    private void prepareEventManagers(Activity activity) {
        AtomicBoolean atomicBoolean = this.mEventManagersInit;
        if (atomicBoolean != null && atomicBoolean.compareAndSet(false, true)) {
            SuperLooper.getLooper().post(new GeneralPropertiesWorker(activity.getApplicationContext()));
            InterstitialEventsManager.getInstance().start(activity.getApplicationContext(), this.mIronSegment);
            RewardedVideoEventsManager.getInstance().start(activity.getApplicationContext(), this.mIronSegment);
        }
    }

    private void sendIsCappedEvent(String string, boolean bl) {
        boolean bl2;
        InterstitialManager interstitialManager;
        if (!bl) {
            return;
        }
        if (string.equals((Object)"Interstitial") && (interstitialManager = this.mInterstitialManager) != null) {
            bl2 = interstitialManager.mIsInISDemandOnlyMode;
        } else {
            boolean bl3 = string.equals((Object)"Rewarded Video");
            bl2 = false;
            if (bl3) {
                RewardedVideoManager rewardedVideoManager = this.mRewardedVideoManager;
                bl2 = false;
                if (rewardedVideoManager != null) {
                    bl2 = rewardedVideoManager.mIsInISDemandOnlyMode;
                }
            }
        }
        JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(bl2);
        try {
            jSONObject.put("reason", 1);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        if ("Interstitial".equals((Object)string)) {
            EventData eventData = new EventData(34, jSONObject);
            InterstitialEventsManager.getInstance().log(eventData);
            return;
        }
        if ("Rewarded Video".equals((Object)string)) {
            EventData eventData = new EventData(20, jSONObject);
            RewardedVideoEventsManager.getInstance().log(eventData);
        }
    }

    private void startAdUnit(IronSource.AD_UNIT aD_UNIT) {
        int n2 = 1.$SwitchMap$com$ironsource$mediationsdk$IronSource$AD_UNIT[aD_UNIT.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    if (n2 != 4) {
                        return;
                    }
                    this.startBanner();
                    return;
                }
                this.mOfferwallManager.initOfferwall(this.mActivity, this.getIronSourceAppKey(), this.getIronSourceUserId());
                return;
            }
            this.startInterstitial();
            return;
        }
        this.startRewardedVideo();
    }

    private void startBanner() {
        long l2 = this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getBannerAdaptersSmartLoadTimeout();
        int n2 = this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getBannerRefreshInterval();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.mCurrentServerResponse.getProviderOrder().getBannerProviderOrder().size(); ++i2) {
            ProviderSettings providerSettings;
            String string = (String)this.mCurrentServerResponse.getProviderOrder().getBannerProviderOrder().get(i2);
            if (TextUtils.isEmpty((CharSequence)string) || (providerSettings = this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(string)) == null) continue;
            arrayList.add((Object)providerSettings);
        }
        this.mBannerManager.initBannerManager((List<ProviderSettings>)arrayList, this.mActivity, this.getIronSourceAppKey(), this.getIronSourceUserId(), l2, n2);
        if (this.mIsBnLoadBeforeInitCompleted) {
            this.mIsBnLoadBeforeInitCompleted = false;
            this.loadBanner(this.mBnLayoutToLoad, this.mBnPlacementToLoad);
            this.mBnLayoutToLoad = null;
            this.mBnPlacementToLoad = null;
        }
    }

    private void startInterstitial() {
        this.mInterstitialManager.mIsInISDemandOnlyMode = this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.INTERSTITIAL);
        if (this.mInterstitialManager.mIsInISDemandOnlyMode) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Interstitial started in Demand Only mode", 0);
        }
        int n2 = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getInterstitialAdaptersSmartLoadTimeout();
        for (int i2 = 0; i2 < this.mCurrentServerResponse.getProviderOrder().getInterstitialProviderOrder().size(); ++i2) {
            ProviderSettings providerSettings;
            InterstitialSmash interstitialSmash;
            String string = (String)this.mCurrentServerResponse.getProviderOrder().getInterstitialProviderOrder().get(i2);
            if (TextUtils.isEmpty((CharSequence)string) || (providerSettings = this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(string)) == null || !this.validateSmash((AbstractSmash)(interstitialSmash = new InterstitialSmash(providerSettings, n2)))) continue;
            interstitialSmash.setInterstitialManagerListener((InterstitialManagerListener)this.mInterstitialManager);
            interstitialSmash.setProviderPriority(i2 + 1);
            this.mInterstitialManager.addSmashToArray((AbstractSmash)interstitialSmash);
        }
        if (this.mInterstitialManager.mSmashArray.size() > 0) {
            int n3 = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getInterstitialAdaptersSmartLoadAmount();
            this.mInterstitialManager.setSmartLoadAmount(n3);
            this.mInterstitialManager.initInterstitial(this.mActivity, this.getIronSourceAppKey(), this.getIronSourceUserId());
            return;
        }
        this.notifyPublisherAboutInitFailed(IronSource.AD_UNIT.INTERSTITIAL, false);
    }

    private void startRewardedVideo() {
        this.mRewardedVideoManager.mIsInISDemandOnlyMode = this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.REWARDED_VIDEO);
        if (this.mRewardedVideoManager.mIsInISDemandOnlyMode) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Rewarded Video started in Demand Only mode", 0);
        }
        int n2 = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoAdaptersSmartLoadTimeout();
        for (int i2 = 0; i2 < this.mCurrentServerResponse.getProviderOrder().getRewardedVideoProviderOrder().size(); ++i2) {
            ProviderSettings providerSettings;
            RewardedVideoSmash rewardedVideoSmash;
            String string = (String)this.mCurrentServerResponse.getProviderOrder().getRewardedVideoProviderOrder().get(i2);
            if (TextUtils.isEmpty((CharSequence)string) || (providerSettings = this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(string)) == null || !this.validateSmash(rewardedVideoSmash = new RewardedVideoSmash(providerSettings, n2))) continue;
            rewardedVideoSmash.setRewardedVideoManagerListener(this.mRewardedVideoManager);
            rewardedVideoSmash.setProviderPriority(i2 + 1);
            this.mRewardedVideoManager.addSmashToArray(rewardedVideoSmash);
        }
        if (this.mRewardedVideoManager.mSmashArray.size() > 0) {
            String string;
            RewardedVideoSmash rewardedVideoSmash;
            ProviderSettings providerSettings;
            ProviderSettings providerSettings2;
            RewardedVideoSmash rewardedVideoSmash2;
            boolean bl = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoEventsConfigurations().isUltraEventsEnabled();
            this.mRewardedVideoManager.setIsUltraEventsEnabled(bl);
            int n3 = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoAdaptersSmartLoadAmount();
            this.mRewardedVideoManager.setSmartLoadAmount(n3);
            String string2 = this.mCurrentServerResponse.getRVBackFillProvider();
            if (!TextUtils.isEmpty((CharSequence)string2) && (providerSettings2 = this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(string2)) != null && this.validateSmash(rewardedVideoSmash = new RewardedVideoSmash(providerSettings2, n2))) {
                rewardedVideoSmash.setRewardedVideoManagerListener(this.mRewardedVideoManager);
                this.mRewardedVideoManager.setBackfillSmash(rewardedVideoSmash);
            }
            if (!TextUtils.isEmpty((CharSequence)(string = this.mCurrentServerResponse.getRVPremiumProvider())) && (providerSettings = this.mCurrentServerResponse.getProviderSettingsHolder().getProviderSettings(string)) != null && this.validateSmash(rewardedVideoSmash2 = new RewardedVideoSmash(providerSettings, n2))) {
                rewardedVideoSmash2.setRewardedVideoManagerListener(this.mRewardedVideoManager);
                this.mRewardedVideoManager.setPremiumSmash(rewardedVideoSmash2);
            }
            this.mRewardedVideoManager.initRewardedVideo(this.mActivity, this.getIronSourceAppKey(), this.getIronSourceUserId());
            return;
        }
        this.notifyPublisherAboutInitFailed(IronSource.AD_UNIT.REWARDED_VIDEO, false);
    }

    /*
     * Exception decompiling
     */
    private void validateAge(int var1, ConfigValidationResult var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl20 : RETURN : trying to set 0 previously set to 1
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

    private boolean validateAlphanumeric(String string) {
        if (string == null) {
            return false;
        }
        return string.matches("^[a-zA-Z0-9]*$");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private ConfigValidationResult validateAppKey(String string) {
        ConfigValidationResult configValidationResult = new ConfigValidationResult();
        if (string != null) {
            if (this.validateLength(string, 5, 10)) {
                if (this.validateAlphanumeric(string)) return configValidationResult;
                configValidationResult.setInvalid(ErrorBuilder.buildInvalidCredentialsError("appKey", string, "should contain only english characters and numbers"));
                return configValidationResult;
            }
            configValidationResult.setInvalid(ErrorBuilder.buildInvalidCredentialsError("appKey", string, "length should be between 5-10 characters"));
            return configValidationResult;
        }
        configValidationResult.setInvalid(new IronSourceError(506, "Init Fail - appKey is missing"));
        return configValidationResult;
    }

    private void validateDynamicUserId(String string, ConfigValidationResult configValidationResult) {
        if (!this.validateLength(string, 1, 128)) {
            configValidationResult.setInvalid(ErrorBuilder.buildInvalidKeyValueError("dynamicUserId", "SupersonicAds", "dynamicUserId is invalid, should be between 1-128 chars in length."));
        }
    }

    /*
     * Exception decompiling
     */
    private void validateGender(String var1, ConfigValidationResult var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl32 : RETURN : trying to set 1 previously set to 0
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

    private boolean validateLength(String string, int n2, int n3) {
        return string != null && string.length() >= n2 && string.length() <= n3;
    }

    /*
     * Exception decompiling
     */
    private void validateSegment(String var1, ConfigValidationResult var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl20 : RETURN : trying to set 1 previously set to 0
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

    private boolean validateSmash(AbstractSmash abstractSmash) {
        return abstractSmash.getMaxAdsPerIteration() >= 1 && abstractSmash.getMaxAdsPerSession() >= 1;
    }

    void addOWAdapter(AbstractAdapter abstractAdapter) {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            this.mOfferwallAdapter = abstractAdapter;
            return;
        }
    }

    void addToBannerAdaptersList(AbstractAdapter abstractAdapter) {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            if (this.mBannerAdaptersList != null && abstractAdapter != null && !this.mBannerAdaptersList.contains((Object)abstractAdapter)) {
                this.mBannerAdaptersList.add((Object)abstractAdapter);
            }
            return;
        }
    }

    void addToISAdaptersList(AbstractAdapter abstractAdapter) {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            if (this.mInterstitialAdaptersList != null && abstractAdapter != null && !this.mInterstitialAdaptersList.contains((Object)abstractAdapter)) {
                this.mInterstitialAdaptersList.add((Object)abstractAdapter);
            }
            return;
        }
    }

    void addToRVAdaptersList(AbstractAdapter abstractAdapter) {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            if (this.mRewardedVideoAdaptersList != null && abstractAdapter != null && !this.mRewardedVideoAdaptersList.contains((Object)abstractAdapter)) {
                this.mRewardedVideoAdaptersList.add((Object)abstractAdapter);
            }
            return;
        }
    }

    public void clearRewardedVideoServerParameters() {
        this.mRvServerParams = null;
    }

    public IronSourceBannerLayout createBanner(Activity activity, EBannerSize eBannerSize) {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "createBanner()", 1);
        if (activity == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "createBanner() : Activity cannot be null", 3);
            return null;
        }
        return this.mBannerManager.createBanner(activity, eBannerSize);
    }

    public void destroyBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            this.mBannerManager.destroyBanner(ironSourceBannerLayout);
            return;
        }
        catch (Throwable throwable) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "destroyBanner()", throwable);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public String getAdvertiserId(Context var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl17.1 : LDC_W : trying to set 1 previously set to 0
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

    public Integer getAge() {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            Integer n2 = this.mUserAge;
            return n2;
        }
    }

    HashSet<String> getAllSettingsForProvider(String string, String string2) {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        if (serverResponseWrapper == null) {
            return new HashSet();
        }
        return serverResponseWrapper.getProviderSettingsHolder().getProviderSettingsByReflectionName(string, string2);
    }

    String getCappingMessage(String string, CappingManager.ECappingStatus eCappingStatus) {
        if (eCappingStatus == null) {
            return null;
        }
        int n2 = 1.$SwitchMap$com$ironsource$mediationsdk$utils$CappingManager$ECappingStatus[eCappingStatus.ordinal()];
        if (n2 != 1) {
            if (n2 != 2) {
                if (n2 != 3) {
                    return null;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Placement ");
                stringBuilder.append(string);
                stringBuilder.append(" has reached its limit as defined per pace");
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Placement ");
            stringBuilder.append(string);
            stringBuilder.append(" has reached its capping limit");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Placement ");
        stringBuilder.append(string);
        stringBuilder.append(" is capped by disabled delivery");
        return stringBuilder.toString();
    }

    Boolean getConsent() {
        return this.mConsent;
    }

    ServerResponseWrapper getCurrentServerResponse() {
        return this.mCurrentServerResponse;
    }

    String getDynamicUserId() {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            String string = this.mDynamicUserId;
            return string;
        }
    }

    /*
     * Exception decompiling
     */
    AbstractAdapter getExistingAdapter(String var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 8[WHILELOOP]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    public String getGender() {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            String string = this.mUserGender;
            return string;
        }
    }

    public InterstitialPlacement getInterstitialPlacementInfo(String string) {
        InterstitialPlacement interstitialPlacement;
        interstitialPlacement = null;
        try {
            interstitialPlacement = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getInterstitialPlacement(string);
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getPlacementInfo(placement: ");
            stringBuilder.append(string);
            stringBuilder.append("):");
            stringBuilder.append((Object)interstitialPlacement);
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        }
        catch (Exception exception) {}
        return interstitialPlacement;
    }

    public String getIronSourceAppKey() {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            String string = this.mAppKey;
            return string;
        }
    }

    public String getIronSourceUserId() {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            String string = this.mUserId;
            return string;
        }
    }

    String getMediationSegment() {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            String string = this.mSegment;
            return string;
        }
    }

    public String getMediationType() {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            String string = this.mMediationType;
            return string;
        }
    }

    public void getOfferwallCredits() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "getOfferwallCredits()", 1);
        try {
            this.mOfferwallManager.getOfferwallCredits();
            return;
        }
        catch (Throwable throwable) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "getOfferwallCredits()", throwable);
            return;
        }
    }

    public Placement getRewardedVideoPlacementInfo(String string) {
        Placement placement;
        placement = null;
        try {
            placement = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getRewardedVideoPlacement(string);
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getPlacementInfo(placement: ");
            stringBuilder.append(string);
            stringBuilder.append("):");
            stringBuilder.append((Object)placement);
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        }
        catch (Exception exception) {}
        return placement;
    }

    Map<String, String> getRvServerParams() {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            Map<String, String> map = this.mRvServerParams;
            return map;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    ServerResponseWrapper getServerResponse(Context context, String string, IResponseListener iResponseListener) {
        Object object;
        Object object2 = object = this.mServerResponseLocker;
        synchronized (object2) {
            if (this.mCurrentServerResponse != null) {
                return new ServerResponseWrapper(this.mCurrentServerResponse);
            }
            ServerResponseWrapper serverResponseWrapper = this.connectAndGetServerResponse(context, string, iResponseListener);
            if (serverResponseWrapper == null || !serverResponseWrapper.isValidResponse()) {
                serverResponseWrapper = this.getCachedResponse(context, string);
            }
            if (serverResponseWrapper != null) {
                this.mCurrentServerResponse = serverResponseWrapper;
                IronSourceUtils.saveLastResponse(context, serverResponseWrapper.toString());
                this.initializeSettingsFromServerResponse(this.mCurrentServerResponse, context);
            }
            InterstitialEventsManager.getInstance().setHasServerResponse(true);
            RewardedVideoEventsManager.getInstance().setHasServerResponse(true);
            return serverResponseWrapper;
        }
    }

    public String getSessionId() {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            String string = this.mSessionId;
            return string;
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
    public /* varargs */ void init(Activity var1_1, String var2_2, boolean var3_3, IronSource.AD_UNIT ... var4_4) {
        block21 : {
            block20 : {
                block18 : {
                    block19 : {
                        var31_5 = this;
                        // MONITORENTER : var31_5
                        if (this.mAtomicIsFirstInit == null || !this.mAtomicIsFirstInit.compareAndSet(true, false)) break block18;
                        if (var4_4 == null || var4_4.length == 0) break block19;
                        var26_6 = var4_4.length;
                        break block20;
                    }
                    var6_9 = IronSource.AD_UNIT.values();
                    var7_10 = var6_9.length;
                    break block21;
                }
                if (var4_4 != null) {
                    this.attachAdUnits(var3_3, var4_4);
                    return;
                }
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Multiple calls to init without ad units are not allowed", 3);
                // MONITOREXIT : var31_5
                return;
            }
            for (var27_7 = 0; var27_7 < var26_6; ++var27_7) {
                var28_8 = var4_4[var27_7];
                this.mAdUnitsToInitialize.add((Object)var28_8);
                this.mRequestedAdUnits.add((Object)var28_8);
                if (var28_8.equals((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
                    this.mDidInitInterstitial = true;
                }
                if (!var28_8.equals((Object)IronSource.AD_UNIT.BANNER)) continue;
                this.mDidInitBanner = true;
            }
            ** GOTO lbl38
        }
        for (var8_11 = 0; var8_11 < var7_10; ++var8_11) {
            var9_12 = var6_9[var8_11];
            this.mAdUnitsToInitialize.add((Object)var9_12);
        }
        this.mDidInitInterstitial = true;
        this.mDidInitBanner = true;
lbl38: // 2 sources:
        var11_13 = this.mLoggerManager;
        var12_14 = IronSourceLogger.IronSourceTag.API;
        var13_15 = new StringBuilder();
        var13_15.append("init(appKey:");
        var13_15.append(var2_2);
        var13_15.append(")");
        var11_13.log(var12_14, var13_15.toString(), 1);
        if (var1_1 == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Init Fail - provided activity is null", 2);
            // MONITOREXIT : var31_5
            return;
        }
        this.mActivity = var1_1;
        this.prepareEventManagers(var1_1);
        var17_16 = this.validateAppKey(var2_2);
        if (!var17_16.isValid()) ** GOTO lbl60
        this.mAppKey = var2_2;
        if (!this.mShouldSendGetInstanceEvent) break block17;
        var18_17 = IronSourceUtils.getMediationAdditionalData(var3_3);
        if (var4_4 == null) ** GOTO lbl71
        try {
            block22 : {
                var23_18 = var4_4.length;
                break block22;
lbl60: // 1 sources:
                if (this.mAdUnitsToInitialize.contains((Object)IronSource.AD_UNIT.REWARDED_VIDEO)) {
                    this.mListenersWrapper.onRewardedVideoAvailabilityChanged(false);
                }
                if (this.mAdUnitsToInitialize.contains((Object)IronSource.AD_UNIT.OFFERWALL)) {
                    this.mListenersWrapper.onOfferwallAvailable(false, var17_16.getIronSourceError());
                }
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, var17_16.getIronSourceError().toString(), 1);
                // MONITOREXIT : var31_5
                return;
            }
            for (var24_19 = 0; var24_19 < var23_18; ++var24_19) {
                var18_17.put(var4_4[var24_19].toString(), true);
            }
lbl71: // 2 sources:
            this.mInitCounter = var21_20 = 1 + this.mInitCounter;
            var18_17.put("sessionDepth", var21_20);
        }
        catch (Exception var19_21) {
            var19_21.printStackTrace();
        }
        {
            block17 : {
                var20_22 = new EventData(14, var18_17);
                RewardedVideoEventsManager.getInstance().log(var20_22);
                this.mShouldSendGetInstanceEvent = false;
            }
            if (this.mAdUnitsToInitialize.contains((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
                MediationInitializer.getInstance().addMediationInitializationListener(this.mInterstitialManager);
            }
            MediationInitializer.getInstance().addMediationInitializationListener(this);
            MediationInitializer.getInstance().init(var1_1, var2_2, this.mUserId, var4_4);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public /* varargs */ void initISDemandOnly(Activity activity, String string, IronSource.AD_UNIT ... arraD_UNIT) {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            ArrayList arrayList = new ArrayList();
            if (arraD_UNIT == null) return;
            int n2 = arraD_UNIT.length;
            int n3 = 0;
            do {
                if (n3 >= n2) {
                    if (arrayList.size() <= 0) return;
                    this.init(activity, string, true, (IronSource.AD_UNIT[])arrayList.toArray((Object[])new IronSource.AD_UNIT[arrayList.size()]));
                    return;
                }
                IronSource.AD_UNIT aD_UNIT = arraD_UNIT[n3];
                if (!aD_UNIT.equals((Object)IronSource.AD_UNIT.BANNER) && !aD_UNIT.equals((Object)IronSource.AD_UNIT.OFFERWALL)) {
                    if (aD_UNIT.equals((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
                        this.mDidInitInterstitial = true;
                    }
                    arrayList.add((Object)aD_UNIT);
                    if (!this.mDemandOnlyAdUnits.contains((Object)aD_UNIT)) {
                        this.mDemandOnlyAdUnits.add((Object)aD_UNIT);
                        if (aD_UNIT.equals((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
                            this.mInterstitialManager.mIsInISDemandOnlyMode = true;
                        }
                    }
                } else {
                    IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append((Object)aD_UNIT);
                    stringBuilder.append(" ad unit cannot be initialized in demand only mode");
                    ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 3);
                }
                ++n3;
            } while (true);
        }
    }

    public void initInterstitial(Activity activity, String string, String string2) {
    }

    public void initOfferwall(Activity activity, String string, String string2) {
    }

    public void initRewardedVideo(Activity activity, String string, String string2) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean isBannerPlacementCapped(String string) {
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        if (serverResponseWrapper != null && serverResponseWrapper.getConfigurations() != null) {
            if (this.mCurrentServerResponse.getConfigurations().getBannerConfigurations() == null) {
                return false;
            }
            BannerPlacement bannerPlacement = null;
            try {
                bannerPlacement = this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getBannerPlacement(string);
                if (bannerPlacement == null && (bannerPlacement = this.mCurrentServerResponse.getConfigurations().getBannerConfigurations().getDefaultBannerPlacement()) == null) {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Banner default placement was not found", 3);
                    return false;
                }
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            if (bannerPlacement == null) {
                return false;
            }
            return CappingManager.isBnPlacementCapped((Context)this.mActivity, bannerPlacement.getPlacementName());
        }
        return false;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean isISDemandOnlyInterstitialReady(String string) {
        Throwable throwable;
        boolean bl;
        block7 : {
            if (!this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in mediation mode. Use isInterstitialReady instead", 3);
                return false;
            }
            bl = this.mInterstitialManager.isInterstitialReady(string);
            try {
                JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(true);
                try {
                    jSONObject.put("status", (Object)String.valueOf((boolean)bl));
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
                EventData eventData = new EventData(30, jSONObject);
                InterstitialEventsManager.getInstance().log(eventData);
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("isISDemandOnlyInterstitialReady(instanceId: ");
                stringBuilder.append(string);
                stringBuilder.append("):");
                stringBuilder.append(bl);
                ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
                return bl;
            }
            catch (Throwable throwable2) {}
            break block7;
            catch (Throwable throwable3) {
                throwable = throwable3;
                bl = false;
            }
        }
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isISDemandOnlyInterstitialReady(instanceId: ");
        stringBuilder.append(string);
        stringBuilder.append("):");
        stringBuilder.append(bl);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.API;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("isISDemandOnlyInterstitialReady(instanceId: ");
        stringBuilder2.append(string);
        stringBuilder2.append(")");
        ironSourceLoggerManager2.logException(ironSourceTag2, stringBuilder2.toString(), throwable);
        return false;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean isISDemandOnlyRewardedVideoAvailable(String string) {
        Throwable throwable;
        boolean bl;
        block7 : {
            if (!this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.REWARDED_VIDEO)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in mediation mode. Use isRewardedVideoAvailable instead", 3);
                return false;
            }
            bl = this.mRewardedVideoManager.isRewardedVideoAvailable(string);
            try {
                JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(true);
                try {
                    jSONObject.put("status", (Object)String.valueOf((boolean)bl));
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
                EventData eventData = new EventData(18, jSONObject);
                RewardedVideoEventsManager.getInstance().log(eventData);
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("isISDemandOnlyRewardedVideoAvailable():");
                stringBuilder.append(bl);
                ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
                return bl;
            }
            catch (Throwable throwable2) {}
            break block7;
            catch (Throwable throwable3) {
                throwable = throwable3;
                bl = false;
            }
        }
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isISDemandOnlyRewardedVideoAvailable():");
        stringBuilder.append(bl);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "isISDemandOnlyRewardedVideoAvailable()", throwable);
        return false;
    }

    boolean isInterstitialPlacementCapped(String string) {
        int n2;
        CappingManager.ECappingStatus eCappingStatus = this.getInterstitialCappingStatus(string);
        int n3 = 1;
        if (eCappingStatus == null || (n2 = 1.$SwitchMap$com$ironsource$mediationsdk$utils$CappingManager$ECappingStatus[eCappingStatus.ordinal()]) != n3 && n2 != 2 && n2 != 3) {
            n3 = 0;
        }
        this.sendIsCappedEvent("Interstitial", (boolean)n3);
        return (boolean)n3;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean isInterstitialReady() {
        Throwable throwable;
        boolean bl;
        block7 : {
            if (this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use isISDemandOnlyInterstitialReady instead", 3);
                return false;
            }
            bl = this.mInterstitialManager.isInterstitialReady();
            try {
                JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(false);
                try {
                    jSONObject.put("status", (Object)String.valueOf((boolean)bl));
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
                EventData eventData = new EventData(30, jSONObject);
                InterstitialEventsManager.getInstance().log(eventData);
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("isInterstitialReady():");
                stringBuilder.append(bl);
                ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
                return bl;
            }
            catch (Throwable throwable2) {}
            break block7;
            catch (Throwable throwable3) {
                throwable = throwable3;
                bl = false;
            }
        }
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isInterstitialReady():");
        stringBuilder.append(bl);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "isInterstitialReady()", throwable);
        return false;
    }

    /*
     * Exception decompiling
     */
    public boolean isOfferwallAvailable() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Underrun type stack
        // org.benf.cfr.reader.b.a.c.e.a(StackSim.java:35)
        // org.benf.cfr.reader.b.b.af.a(OperationFactoryPop.java:20)
        // org.benf.cfr.reader.b.b.e.a(JVMInstr.java:315)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:195)
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean isRewardedVideoAvailable() {
        Throwable throwable;
        boolean bl;
        block7 : {
            if (this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.REWARDED_VIDEO)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use isISDemandOnlyRewardedVideoAvailable instead", 3);
                return false;
            }
            bl = this.mRewardedVideoManager.isRewardedVideoAvailable();
            try {
                JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(false);
                try {
                    jSONObject.put("status", (Object)String.valueOf((boolean)bl));
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
                EventData eventData = new EventData(18, jSONObject);
                RewardedVideoEventsManager.getInstance().log(eventData);
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("isRewardedVideoAvailable():");
                stringBuilder.append(bl);
                ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
                return bl;
            }
            catch (Throwable throwable2) {}
            break block7;
            catch (Throwable throwable3) {
                throwable = throwable3;
                bl = false;
            }
        }
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("isRewardedVideoAvailable():");
        stringBuilder.append(bl);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "isRewardedVideoAvailable()", throwable);
        return false;
    }

    boolean isRewardedVideoPlacementCapped(String string) {
        int n2;
        CappingManager.ECappingStatus eCappingStatus = this.getRewardedVideoCappingStatus(string);
        int n3 = 1;
        if (eCappingStatus == null || (n2 = 1.$SwitchMap$com$ironsource$mediationsdk$utils$CappingManager$ECappingStatus[eCappingStatus.ordinal()]) != n3 && n2 != 2 && n2 != 3) {
            n3 = 0;
        }
        this.sendIsCappedEvent("Rewarded Video", (boolean)n3);
        return (boolean)n3;
    }

    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        this.loadBanner(ironSourceBannerLayout, "");
    }

    public void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, String string) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loadBanner(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (ironSourceBannerLayout == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "loadBanner can't be called with a null parameter", 1);
            return;
        }
        if (!this.mDidInitBanner) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadBanner()", 3);
            return;
        }
        MediationInitializer.EInitStatus eInitStatus = MediationInitializer.getInstance().getCurrentInitStatus();
        if (eInitStatus == MediationInitializer.EInitStatus.INIT_FAILED) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
            BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(ironSourceBannerLayout, new IronSourceError(600, "Init had failed"));
            return;
        }
        if (eInitStatus == MediationInitializer.EInitStatus.INIT_IN_PROGRESS) {
            if (MediationInitializer.getInstance().isInProgressMoreThan15Secs()) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(ironSourceBannerLayout, new IronSourceError(601, "Init had failed"));
                return;
            }
            this.mBnLayoutToLoad = ironSourceBannerLayout;
            this.mIsBnLoadBeforeInitCompleted = true;
            this.mBnPlacementToLoad = string;
            return;
        }
        ServerResponseWrapper serverResponseWrapper = this.mCurrentServerResponse;
        if (serverResponseWrapper != null && serverResponseWrapper.getConfigurations() != null && this.mCurrentServerResponse.getConfigurations().getBannerConfigurations() != null) {
            this.mBannerManager.loadBanner(ironSourceBannerLayout, this.getBannerPlacement(string));
            return;
        }
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "No banner configurations found", 3);
        BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(ironSourceBannerLayout, new IronSourceError(615, "No banner configurations found"));
    }

    public void loadISDemandOnlyInterstitial(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loadISDemandOnlyInterstitial(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        String string2 = stringBuilder.toString();
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
        try {
            if (!this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in mediation mode. Use loadInterstitial instead", 3);
                return;
            }
            if (!this.mDidInitInterstitial) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadInterstitial()", 3);
                return;
            }
            this.mInterstitialManager.loadInterstitial(string);
            return;
        }
        catch (Throwable throwable) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, string2, throwable);
            return;
        }
    }

    public void loadInterstitial() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", 1);
        try {
            if (this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", 3);
                return;
            }
            if (!this.mDidInitInterstitial) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadInterstitial()", 3);
                return;
            }
            this.mInterstitialManager.loadInterstitial();
            return;
        }
        catch (Throwable throwable) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", throwable);
            return;
        }
    }

    @Override
    public void onInitFailed(String string) {
        try {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onInitFailed(reason:");
            stringBuilder.append(string);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            if (this.mListenersWrapper != null) {
                Iterator iterator = this.mAdUnitsToInitialize.iterator();
                while (iterator.hasNext()) {
                    this.notifyPublisherAboutInitFailed((IronSource.AD_UNIT)((Object)iterator.next()), true);
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void onInitSuccess(List<IronSource.AD_UNIT> list, boolean bl) {
        int n2;
        IronSource.AD_UNIT[] arraD_UNIT;
        try {
            this.mInitiatedAdUnits = list;
            this.mInitSucceeded = true;
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "onInitSuccess()", 1);
            if (bl) {
                JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(false);
                try {
                    jSONObject.put("revived", true);
                }
                catch (JSONException jSONException) {
                    jSONException.printStackTrace();
                }
                EventData eventData = new EventData(114, jSONObject);
                RewardedVideoEventsManager.getInstance().log(eventData);
            }
            InterstitialEventsManager.getInstance().triggerEventsSend();
            RewardedVideoEventsManager.getInstance().triggerEventsSend();
            arraD_UNIT = IronSource.AD_UNIT.values();
            n2 = arraD_UNIT.length;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            IronSource.AD_UNIT aD_UNIT = arraD_UNIT[i2];
            if (!this.mAdUnitsToInitialize.contains((Object)aD_UNIT)) continue;
            if (list.contains((Object)aD_UNIT)) {
                this.startAdUnit(aD_UNIT);
                continue;
            }
            this.notifyPublisherAboutInitFailed(aD_UNIT, false);
        }
    }

    public void onPause(Activity activity) {
        try {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "onPause()", 1);
            if (this.mRewardedVideoManager != null) {
                this.mRewardedVideoManager.onPause(activity);
            }
            if (this.mInterstitialManager != null) {
                this.mInterstitialManager.onPause(activity);
            }
            if (this.mBannerManager != null) {
                this.mBannerManager.onPause(activity);
                return;
            }
        }
        catch (Throwable throwable) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "onPause()", throwable);
        }
    }

    public void onResume(Activity activity) {
        try {
            this.mActivity = activity;
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "onResume()", 1);
            if (this.mRewardedVideoManager != null) {
                this.mRewardedVideoManager.onResume(activity);
            }
            if (this.mInterstitialManager != null) {
                this.mInterstitialManager.onResume(activity);
            }
            if (this.mBannerManager != null) {
                this.mBannerManager.onResume(activity);
                return;
            }
        }
        catch (Throwable throwable) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "onResume()", throwable);
        }
    }

    @Override
    public void onStillInProgressAfter15Secs() {
        if (this.mIsBnLoadBeforeInitCompleted) {
            this.mIsBnLoadBeforeInitCompleted = false;
            BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(this.mBnLayoutToLoad, new IronSourceError(603, "init had failed"));
            this.mBnLayoutToLoad = null;
            this.mBnPlacementToLoad = null;
        }
    }

    public void removeInterstitialListener() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "removeInterstitialListener()", 1);
        this.mListenersWrapper.setInterstitialListener(null);
    }

    public void removeOfferwallListener() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "removeOfferwallListener()", 1);
        this.mListenersWrapper.setOfferwallListener(null);
    }

    public void removeRewardedVideoListener() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "removeRewardedVideoListener()", 1);
        this.mListenersWrapper.setRewardedVideoListener(null);
    }

    public void setAdaptersDebug(boolean bl) {
        IronSourceLoggerManager.getLogger().setAdaptersDebug(bl);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setAge(int n2) {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            try {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.TAG);
                    stringBuilder.append(":setAge(age:");
                    stringBuilder.append(n2);
                    stringBuilder.append(")");
                    String string = stringBuilder.toString();
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string, 1);
                    ConfigValidationResult configValidationResult = new ConfigValidationResult();
                    this.validateAge(n2, configValidationResult);
                    if (configValidationResult.isValid()) {
                        this.mUserAge = n2;
                    } else {
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, configValidationResult.getIronSourceError().toString(), 2);
                    }
                }
                catch (Exception exception) {
                    IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.TAG);
                    stringBuilder.append(":setAge(age:");
                    stringBuilder.append(n2);
                    stringBuilder.append(")");
                    ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), exception);
                }
                return;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    public void setConsent(boolean bl) {
        BannerManager bannerManager;
        InterstitialManager interstitialManager;
        this.mConsent = bl;
        IronSourceLoggerManager ironSourceLoggerManager = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setConsent : ");
        stringBuilder.append(bl);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        RewardedVideoManager rewardedVideoManager = this.mRewardedVideoManager;
        if (rewardedVideoManager != null) {
            rewardedVideoManager.setConsent(bl);
        }
        if ((interstitialManager = this.mInterstitialManager) != null) {
            interstitialManager.setConsent(bl);
        }
        if ((bannerManager = this.mBannerManager) != null) {
            bannerManager.setConsent(bl);
        }
        if (this.mOfferwallAdapter != null) {
            IronSourceLoggerManager ironSourceLoggerManager2 = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag2 = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Offerwall | setConsent(consent:");
            stringBuilder2.append(bl);
            stringBuilder2.append(")");
            ironSourceLoggerManager2.log(ironSourceTag2, stringBuilder2.toString(), 1);
            this.mOfferwallAdapter.setConsent(bl);
        }
        int n2 = 40;
        if (!bl) {
            n2 = 41;
        }
        EventData eventData = new EventData(n2, IronSourceUtils.getMediationAdditionalData(false));
        RewardedVideoEventsManager.getInstance().log(eventData);
    }

    public boolean setDynamicUserId(String string) {
        ConfigValidationResult configValidationResult;
        block3 : {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.TAG);
                stringBuilder.append(":setDynamicUserId(dynamicUserId:");
                stringBuilder.append(string);
                stringBuilder.append(")");
                String string2 = stringBuilder.toString();
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
                configValidationResult = new ConfigValidationResult();
                this.validateDynamicUserId(string, configValidationResult);
                if (!configValidationResult.isValid()) break block3;
                this.mDynamicUserId = string;
                return true;
            }
            catch (Exception exception) {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.TAG);
                stringBuilder.append(":setDynamicUserId(dynamicUserId:");
                stringBuilder.append(string);
                stringBuilder.append(")");
                ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), exception);
                return false;
            }
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, configValidationResult.getIronSourceError().toString(), 2);
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setGender(String string) {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            try {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.TAG);
                    stringBuilder.append(":setGender(gender:");
                    stringBuilder.append(string);
                    stringBuilder.append(")");
                    String string2 = stringBuilder.toString();
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
                    ConfigValidationResult configValidationResult = new ConfigValidationResult();
                    this.validateGender(string, configValidationResult);
                    if (configValidationResult.isValid()) {
                        this.mUserGender = string;
                    } else {
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, configValidationResult.getIronSourceError().toString(), 2);
                    }
                }
                catch (Exception exception) {
                    IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                    IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(this.TAG);
                    stringBuilder.append(":setGender(gender:");
                    stringBuilder.append(string);
                    stringBuilder.append(")");
                    ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), exception);
                }
                return;
            }
            catch (Throwable throwable2) {}
            throw throwable2;
        }
    }

    public void setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        if (iSDemandOnlyInterstitialListener == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener:null)", 1);
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener)", 1);
        }
        this.mListenersWrapper.setISDemandOnlyInterstitialListener(iSDemandOnlyInterstitialListener);
    }

    void setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        if (iSDemandOnlyRewardedVideoListener == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener:null)", 1);
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener)", 1);
        }
        this.mListenersWrapper.setISDemandOnlyRewardedVideoListener(iSDemandOnlyRewardedVideoListener);
    }

    public void setInterstitialListener(InterstitialListener interstitialListener) {
        if (interstitialListener == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setInterstitialListener(ISListener:null)", 1);
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setInterstitialListener(ISListener)", 1);
        }
        this.mListenersWrapper.setInterstitialListener(interstitialListener);
    }

    void setIronSourceUserId(String string) {
        IronSourceObject ironSourceObject = this;
        synchronized (ironSourceObject) {
            this.mUserId = string;
            return;
        }
    }

    public void setLogListener(LogListener logListener) {
        if (logListener == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setLogListener(LogListener:null)", 1);
            return;
        }
        this.mPublisherLogger.setLogListener(logListener);
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setLogListener(LogListener:");
        stringBuilder.append(logListener.getClass().getSimpleName());
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
    }

    public void setMediationSegment(String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":setMediationSegment(segment:");
            stringBuilder.append(string);
            stringBuilder.append(")");
            String string2 = stringBuilder.toString();
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
            ConfigValidationResult configValidationResult = new ConfigValidationResult();
            this.validateSegment(string, configValidationResult);
            if (configValidationResult.isValid()) {
                this.mSegment = string;
                return;
            }
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, configValidationResult.getIronSourceError().toString(), 2);
            return;
        }
        catch (Exception exception) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":setMediationSegment(segment:");
            stringBuilder.append(string);
            stringBuilder.append(")");
            ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), exception);
            return;
        }
    }

    public void setMediationType(String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":setMediationType(mediationType:");
            stringBuilder.append(string);
            stringBuilder.append(")");
            String string2 = stringBuilder.toString();
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, string2, 1);
            if (this.validateLength(string, 1, 64) && this.validateAlphanumeric(string)) {
                this.mMediationType = string;
                return;
            }
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, " mediationType value is invalid - should be alphanumeric and 1-64 chars in length", 1);
            return;
        }
        catch (Exception exception) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":setMediationType(mediationType:");
            stringBuilder.append(string);
            stringBuilder.append(")");
            ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), exception);
            return;
        }
    }

    public void setOfferwallListener(OfferwallListener offerwallListener) {
        if (offerwallListener == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setOfferwallListener(OWListener:null)", 1);
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setOfferwallListener(OWListener)", 1);
        }
        this.mListenersWrapper.setOfferwallListener(offerwallListener);
    }

    public void setRewardedInterstitialListener(RewardedInterstitialListener rewardedInterstitialListener) {
        this.mListenersWrapper.setRewardedInterstitialListener(rewardedInterstitialListener);
    }

    public void setRewardedVideoListener(RewardedVideoListener rewardedVideoListener) {
        if (rewardedVideoListener == null) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setRewardedVideoListener(RVListener:null)", 1);
        } else {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "setRewardedVideoListener(RVListener)", 1);
        }
        this.mListenersWrapper.setRewardedVideoListener(rewardedVideoListener);
    }

    public void setRewardedVideoServerParameters(Map<String, String> map) {
        if (map != null) {
            try {
                if (map.size() == 0) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.TAG);
                stringBuilder.append(":setRewardedVideoServerParameters(params:");
                stringBuilder.append(map.toString());
                stringBuilder.append(")");
                String string = stringBuilder.toString();
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string, 1);
                this.mRvServerParams = new HashMap(map);
                return;
            }
            catch (Exception exception) {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.TAG);
                stringBuilder.append(":setRewardedVideoServerParameters(params:");
                stringBuilder.append(map.toString());
                stringBuilder.append(")");
                ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), exception);
            }
        }
    }

    public void setSegment(IronSourceSegment ironSourceSegment) {
        if (MediationInitializer.getInstance().getCurrentInitStatus() != MediationInitializer.EInitStatus.INIT_IN_PROGRESS && MediationInitializer.getInstance().getCurrentInitStatus() != MediationInitializer.EInitStatus.INITIATED) {
            this.mIronSegment = ironSourceSegment;
            return;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Segments must be set prior to Init. Setting a segment after the init will be ignored", 0);
    }

    void setSegmentListener(SegmentListener segmentListener) {
        ListenersWrapper listenersWrapper = this.mListenersWrapper;
        if (listenersWrapper != null) {
            listenersWrapper.setSegmentListener(segmentListener);
            MediationInitializer.getInstance().setSegmentListener((SegmentListener)this.mListenersWrapper);
        }
    }

    public void shouldTrackNetworkState(Context context, boolean bl) {
        InterstitialManager interstitialManager;
        RewardedVideoManager rewardedVideoManager = this.mRewardedVideoManager;
        if (rewardedVideoManager != null) {
            rewardedVideoManager.shouldTrackNetworkState(context, bl);
        }
        if ((interstitialManager = this.mInterstitialManager) != null) {
            interstitialManager.shouldTrackNetworkState(context, bl);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void showISDemandOnlyInterstitial(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showISDemandOnlyInterstitial(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        String string2 = stringBuilder.toString();
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
        if (!this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in mediation mode. Use showInterstitial instead", 3);
            return;
        }
        if (!this.isInterstitialConfigurationsReady()) {
            this.mListenersWrapper.onInterstitialAdShowFailed(string, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
            return;
        }
        InterstitialPlacement interstitialPlacement = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getDefaultInterstitialPlacement();
        if (interstitialPlacement == null) return;
        try {
            this.showISDemandOnlyInterstitial(string, interstitialPlacement.getPlacementName());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, string2, exception);
            this.mListenersWrapper.onInterstitialAdShowFailed(string, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void showISDemandOnlyInterstitial(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showISDemandOnlyInterstitial(");
        stringBuilder.append(string);
        String string3 = ")";
        if (string2 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" , ");
            stringBuilder2.append(string2);
            stringBuilder2.append(string3);
            string3 = stringBuilder2.toString();
        }
        stringBuilder.append(string3);
        String string4 = stringBuilder.toString();
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string4, 1);
        try {
            if (!this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in mediation mode. Use showInterstitial instead", 3);
                return;
            }
            if (!this.isInterstitialConfigurationsReady()) {
                this.mListenersWrapper.onInterstitialAdShowFailed(string, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
                return;
            }
            InterstitialPlacement interstitialPlacement = this.getInterstitialPlacementToShowWithEvent(string2);
            if (interstitialPlacement == null) return;
            JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(true);
            try {
                jSONObject.put("placement", (Object)interstitialPlacement.getPlacementName());
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            EventData eventData = new EventData(23, jSONObject);
            InterstitialEventsManager.getInstance().log(eventData);
            this.mInterstitialManager.setCurrentPlacement(interstitialPlacement);
            this.mInterstitialManager.showInterstitial(string, interstitialPlacement.getPlacementName());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, string4, exception);
            this.mListenersWrapper.onInterstitialAdShowFailed(string, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void showISDemandOnlyRewardedVideo(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showISDemandOnlyRewardedVideo(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        String string2 = stringBuilder.toString();
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
        if (!this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.REWARDED_VIDEO)) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in mediation mode. Use showRewardedVideo instead", 3);
            return;
        }
        if (!this.isRewardedVideoConfigurationsReady()) {
            this.mListenersWrapper.onRewardedVideoAdShowFailed(string, ErrorBuilder.buildInitFailedError("showISDemandOnlyRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", "Rewarded Video"));
            return;
        }
        Placement placement = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getDefaultRewardedVideoPlacement();
        if (placement == null) return;
        try {
            this.showISDemandOnlyRewardedVideo(string, placement.getPlacementName());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, string2, exception);
            this.mListenersWrapper.onRewardedVideoAdShowFailed(string, ErrorBuilder.buildInitFailedError("showISDemandOnlyRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", "Rewarded Video"));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void showISDemandOnlyRewardedVideo(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showISDemandOnlyRewardedVideo(");
        stringBuilder.append(string);
        String string3 = ")";
        if (string2 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" , ");
            stringBuilder2.append(string2);
            stringBuilder2.append(string3);
            string3 = stringBuilder2.toString();
        }
        stringBuilder.append(string3);
        String string4 = stringBuilder.toString();
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string4, 1);
        try {
            if (!this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.REWARDED_VIDEO)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in mediation mode. Use showRewardedVideo instead", 3);
                return;
            }
            if (!this.isRewardedVideoConfigurationsReady()) {
                this.mListenersWrapper.onRewardedVideoAdShowFailed(string, ErrorBuilder.buildInitFailedError("showISDemandOnlyRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", "Rewarded Video"));
                return;
            }
            Placement placement = this.getPlacementToShowWithEvent(string2);
            if (placement == null) return;
            JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(true);
            try {
                jSONObject.put("placement", (Object)placement.getPlacementName());
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            EventData eventData = new EventData(2, jSONObject);
            RewardedVideoEventsManager.getInstance().log(eventData);
            this.mRewardedVideoManager.setCurrentPlacement(placement);
            this.mRewardedVideoManager.showRewardedVideo(string, placement.getPlacementName());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, string4, exception);
            this.mListenersWrapper.onRewardedVideoAdShowFailed(string, ErrorBuilder.buildInitFailedError("showISDemandOnlyRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", "Rewarded Video"));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void showInterstitial() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "showInterstitial()", 1);
        if (this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
            return;
        }
        if (!this.isInterstitialConfigurationsReady()) {
            this.mListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
            return;
        }
        InterstitialPlacement interstitialPlacement = this.mCurrentServerResponse.getConfigurations().getInterstitialConfigurations().getDefaultInterstitialPlacement();
        if (interstitialPlacement == null) return;
        try {
            this.showInterstitial(interstitialPlacement.getPlacementName());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "showInterstitial()", exception);
            this.mListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void showInterstitial(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showInterstitial(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        String string2 = stringBuilder.toString();
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
        try {
            if (this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.INTERSTITIAL)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use showISDemandOnlyInterstitial instead", 3);
                return;
            }
            if (!this.isInterstitialConfigurationsReady()) {
                this.mListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
                return;
            }
            InterstitialPlacement interstitialPlacement = this.getInterstitialPlacementToShowWithEvent(string);
            if (interstitialPlacement == null) return;
            JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(false);
            try {
                jSONObject.put("placement", (Object)interstitialPlacement.getPlacementName());
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            EventData eventData = new EventData(23, jSONObject);
            InterstitialEventsManager.getInstance().log(eventData);
            this.mInterstitialManager.setCurrentPlacement(interstitialPlacement);
            this.mInterstitialManager.showInterstitial(interstitialPlacement.getPlacementName());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, string2, exception);
            this.mListenersWrapper.onInterstitialAdShowFailed(ErrorBuilder.buildInitFailedError("showInterstitial can't be called before the Interstitial ad unit initialization completed successfully", "Interstitial"));
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void showOfferwall() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "showOfferwall()", 1);
        if (!this.isOfferwallConfigurationsReady()) {
            this.mListenersWrapper.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", "Offerwall"));
            return;
        }
        OfferwallPlacement offerwallPlacement = this.mCurrentServerResponse.getConfigurations().getOfferwallConfigurations().getDefaultOfferwallPlacement();
        if (offerwallPlacement == null) return;
        try {
            this.showOfferwall(offerwallPlacement.getPlacementName());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "showOfferwall()", exception);
            this.mListenersWrapper.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", "Offerwall"));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void showOfferwall(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showOfferwall(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        String string2 = stringBuilder.toString();
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
        try {
            if (!this.isOfferwallConfigurationsReady()) {
                this.mListenersWrapper.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", "Offerwall"));
                return;
            }
            OfferwallPlacement offerwallPlacement = this.mCurrentServerResponse.getConfigurations().getOfferwallConfigurations().getOfferwallPlacement(string);
            if (offerwallPlacement == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
                offerwallPlacement = this.mCurrentServerResponse.getConfigurations().getOfferwallConfigurations().getDefaultOfferwallPlacement();
                if (offerwallPlacement == null) {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Default placement was not found, please make sure you are using the right placements.", 3);
                    return;
                }
            }
            this.mOfferwallManager.showOfferwall(offerwallPlacement.getPlacementName());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, string2, exception);
            this.mListenersWrapper.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", "Offerwall"));
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void showRewardedVideo() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "showRewardedVideo()", 1);
        if (this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.REWARDED_VIDEO)) {
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
            return;
        }
        if (!this.isRewardedVideoConfigurationsReady()) {
            this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", "Rewarded Video"));
            return;
        }
        Placement placement = this.mCurrentServerResponse.getConfigurations().getRewardedVideoConfigurations().getDefaultRewardedVideoPlacement();
        if (placement == null) return;
        try {
            this.showRewardedVideo(placement.getPlacementName());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, "showRewardedVideo()", exception);
            this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", "Rewarded Video"));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void showRewardedVideo(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showRewardedVideo(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        String string2 = stringBuilder.toString();
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, string2, 1);
        try {
            if (this.mDemandOnlyAdUnits.contains((Object)IronSource.AD_UNIT.REWARDED_VIDEO)) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use showISDemandOnlyRewardedVideo instead", 3);
                return;
            }
            if (!this.isRewardedVideoConfigurationsReady()) {
                this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", "Rewarded Video"));
                return;
            }
            Placement placement = this.getPlacementToShowWithEvent(string);
            if (placement == null) return;
            JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(false);
            try {
                jSONObject.put("placement", (Object)placement.getPlacementName());
            }
            catch (JSONException jSONException) {
                jSONException.printStackTrace();
            }
            EventData eventData = new EventData(2, jSONObject);
            RewardedVideoEventsManager.getInstance().log(eventData);
            this.mRewardedVideoManager.setCurrentPlacement(placement);
            this.mRewardedVideoManager.showRewardedVideo(placement.getPlacementName());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.API, string2, exception);
            this.mListenersWrapper.onRewardedVideoAdShowFailed(ErrorBuilder.buildInitFailedError("showRewardedVideo can't be called before the Rewarded Video ad unit initialization completed successfully", "Rewarded Video"));
        }
    }

}

