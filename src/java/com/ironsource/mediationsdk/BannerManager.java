/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.util.Log
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Timer
 *  java.util.TimerTask
 *  java.util.concurrent.CopyOnWriteArrayList
 *  java.util.regex.Pattern
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import android.util.Log;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.BannerCallbackThrottler;
import com.ironsource.mediationsdk.BannerManager;
import com.ironsource.mediationsdk.BannerSmash;
import com.ironsource.mediationsdk.EBannerSize;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.events.InterstitialEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.model.BannerPlacement;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.sdk.BannerManagerListener;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class BannerManager
implements BannerManagerListener {
    private BannerSmash mActiveSmash;
    private Activity mActivity;
    private String mAppKey;
    private BannerPlacement mCurrentPlacement;
    private IronSourceBannerLayout mIronsourceBanner;
    private Boolean mIsInForeground = true;
    private Timer mIterationTimer;
    private IronSourceLoggerManager mLoggerManager = IronSourceLoggerManager.getLogger();
    private long mReloadInterval;
    private Timer mReloadTimer;
    private final CopyOnWriteArrayList<BannerSmash> mSmashArray = new CopyOnWriteArrayList();
    private BANNER_STATE mState = BANNER_STATE.NOT_INITIATED;
    private String mUserId;

    static /* synthetic */ boolean access$100(BannerManager bannerManager) {
        return bannerManager.loadNextSmash();
    }

    private void callbackLog(String string, BannerSmash bannerSmash) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BannerManager ");
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(bannerSmash.getName());
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
    }

    private void debugLog(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BannerManager ");
        stringBuilder.append(string);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 0);
    }

    private void errorLog(String string) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BannerManager ");
        stringBuilder.append(string);
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 3);
    }

    private AbstractAdapter getLoadedAdapterOrFetchByReflection(String string, String string2) {
        block4 : {
            AbstractAdapter abstractAdapter;
            try {
                abstractAdapter = IronSourceObject.getInstance().getExistingAdapter(string);
                if (abstractAdapter == null) break block4;
            }
            catch (Exception exception) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("getLoadedAdapterOrFetchByReflection ");
                stringBuilder.append(exception.getMessage());
                this.errorLog(stringBuilder.toString());
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("using previously loaded ");
            stringBuilder.append(string);
            this.debugLog(stringBuilder.toString());
            return abstractAdapter;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("loading ");
        stringBuilder.append(string);
        stringBuilder.append(" with reflection");
        this.debugLog(stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("com.ironsource.adapters.");
        stringBuilder2.append(string2.toLowerCase());
        stringBuilder2.append(".");
        stringBuilder2.append(string2);
        stringBuilder2.append("Adapter");
        Class class_ = Class.forName((String)stringBuilder2.toString());
        AbstractAdapter abstractAdapter = (AbstractAdapter)class_.getMethod("startAdapter", new Class[]{String.class}).invoke((Object)class_, new Object[]{string});
        return abstractAdapter;
    }

    private boolean isValidBannerVersion(String string) {
        String[] arrstring;
        block6 : {
            block5 : {
                try {
                    arrstring = string.split(Pattern.quote((String)"."));
                    if (arrstring == null) break block5;
                }
                catch (Exception exception) {
                    return false;
                }
                if (arrstring.length >= 2) break block5;
                return false;
            }
            if (Integer.parseInt((String)arrstring[0]) >= 4) break block6;
            return false;
        }
        int n2 = Integer.parseInt((String)arrstring[1]);
        return n2 >= 2;
    }

    private AbstractAdapter loadAdapter(ProviderSettings providerSettings) {
        AbstractAdapter abstractAdapter;
        block3 : {
            String string = providerSettings.getProviderInstanceName();
            String string2 = providerSettings.isMultipleInstances() ? providerSettings.getProviderTypeForReflection() : providerSettings.getProviderName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("loadAdapter(");
            stringBuilder.append(string);
            stringBuilder.append(")");
            this.debugLog(stringBuilder.toString());
            try {
                abstractAdapter = this.getLoadedAdapterOrFetchByReflection(string, string2);
                if (abstractAdapter != null) break block3;
                return null;
            }
            catch (Throwable throwable) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("loadAdapter(");
                stringBuilder2.append(string);
                stringBuilder2.append(") ");
                stringBuilder2.append(throwable.getMessage());
                this.errorLog(stringBuilder2.toString());
                return null;
            }
        }
        IronSourceObject.getInstance().addToBannerAdaptersList(abstractAdapter);
        abstractAdapter.setLogListener(this.mLoggerManager);
        return abstractAdapter;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean loadNextSmash() {
        CopyOnWriteArrayList<BannerSmash> copyOnWriteArrayList;
        CopyOnWriteArrayList<BannerSmash> copyOnWriteArrayList2 = copyOnWriteArrayList = this.mSmashArray;
        synchronized (copyOnWriteArrayList2) {
            BannerSmash bannerSmash;
            Iterator iterator = this.mSmashArray.iterator();
            do {
                if (!iterator.hasNext()) return false;
            } while (!(bannerSmash = (BannerSmash)iterator.next()).isReadyToLoad() || this.mActiveSmash == bannerSmash);
            this.sendProviderEvent(3002, bannerSmash);
            bannerSmash.loadBanner(this.mIronsourceBanner, this.mActivity, this.mAppKey, this.mUserId);
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void resetIteration() {
        CopyOnWriteArrayList<BannerSmash> copyOnWriteArrayList;
        CopyOnWriteArrayList<BannerSmash> copyOnWriteArrayList2 = copyOnWriteArrayList = this.mSmashArray;
        synchronized (copyOnWriteArrayList2) {
            Iterator iterator = this.mSmashArray.iterator();
            while (iterator.hasNext()) {
                ((BannerSmash)iterator.next()).setReadyToLoad(true);
            }
            return;
        }
    }

    private void sendMediationEvent(int n2) {
        this.sendMediationEvent(n2, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendMediationEvent(int n2, Object[][] arrobject) {
        JSONObject jSONObject;
        block5 : {
            int n3;
            jSONObject = IronSourceUtils.getMediationAdditionalData(false);
            try {
                if (this.mIronsourceBanner != null) {
                    jSONObject.put("bannerAdSize", this.mIronsourceBanner.getSize().getValue());
                }
                if (this.mCurrentPlacement != null) {
                    jSONObject.put("placement", (Object)this.mCurrentPlacement.getPlacementName());
                }
                if (arrobject == null) break block5;
                n3 = arrobject.length;
            }
            catch (Exception exception) {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sendMediationEvent ");
                stringBuilder.append(Log.getStackTraceString((Throwable)exception));
                ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 3);
                break block5;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                Object[] arrobject2 = arrobject[i2];
                jSONObject.put(arrobject2[0].toString(), arrobject2[1]);
            }
        }
        EventData eventData = new EventData(n2, jSONObject);
        InterstitialEventsManager.getInstance().log(eventData);
    }

    private void sendProviderEvent(int n2, BannerSmash bannerSmash) {
        this.sendProviderEvent(n2, bannerSmash, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void sendProviderEvent(int n2, BannerSmash bannerSmash, Object[][] arrobject) {
        JSONObject jSONObject;
        block5 : {
            int n3;
            jSONObject = IronSourceUtils.getProviderAdditionalData(bannerSmash);
            try {
                if (this.mIronsourceBanner != null) {
                    jSONObject.put("bannerAdSize", this.mIronsourceBanner.getSize().getValue());
                }
                if (this.mCurrentPlacement != null) {
                    jSONObject.put("placement", (Object)this.mCurrentPlacement.getPlacementName());
                }
                if (arrobject == null) break block5;
                n3 = arrobject.length;
            }
            catch (Exception exception) {
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sendProviderEvent ");
                stringBuilder.append(Log.getStackTraceString((Throwable)exception));
                ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 3);
                break block5;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                Object[] arrobject2 = arrobject[i2];
                jSONObject.put(arrobject2[0].toString(), arrobject2[1]);
            }
        }
        EventData eventData = new EventData(n2, jSONObject);
        InterstitialEventsManager.getInstance().log(eventData);
    }

    private void setState(BANNER_STATE bANNER_STATE) {
        this.mState = bANNER_STATE;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("state=");
        stringBuilder.append(bANNER_STATE.name());
        this.debugLog(stringBuilder.toString());
    }

    private void startIterationTimer() {
        try {
            this.stopIterationTimer();
            this.mIterationTimer = new Timer();
            this.mIterationTimer.schedule(new TimerTask(this){
                final /* synthetic */ BannerManager this$0;
                {
                    this.this$0 = bannerManager;
                }

                public void run() {
                    BannerManager.access$100(this.this$0);
                }
            }, 1000L * this.mReloadInterval);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return;
        }
    }

    private void stopIterationTimer() {
        Timer timer = this.mIterationTimer;
        if (timer != null) {
            timer.cancel();
            this.mIterationTimer = null;
        }
    }

    private void stopReloadTimer() {
        Timer timer = this.mReloadTimer;
        if (timer != null) {
            timer.cancel();
            this.mReloadTimer = null;
        }
    }

    public IronSourceBannerLayout createBanner(Activity activity, EBannerSize eBannerSize) {
        BannerManager bannerManager = this;
        synchronized (bannerManager) {
            IronSourceBannerLayout ironSourceBannerLayout = new IronSourceBannerLayout(activity, eBannerSize, this);
            return ironSourceBannerLayout;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void destroyBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        BannerManager bannerManager = this;
        synchronized (bannerManager) {
            if (ironSourceBannerLayout == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "destroyBanner banner cannot be null", 3);
                return;
            }
            if (ironSourceBannerLayout.isDestroyed()) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "Banner is already destroyed and can't be used anymore. Please create a new one using IronSource.createBanner API", 3);
                return;
            }
            this.sendMediationEvent(3100);
            this.stopReloadTimer();
            this.stopIterationTimer();
            ironSourceBannerLayout.destroyBanner();
            this.mIronsourceBanner = null;
            this.mCurrentPlacement = null;
            if (this.mActiveSmash != null) {
                this.sendProviderEvent(3305, this.mActiveSmash);
                this.mActiveSmash.destroyBanner();
                this.mActiveSmash = null;
            }
            this.setState(BANNER_STATE.READY_TO_LOAD);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void initBannerManager(List<ProviderSettings> list, Activity activity, String string, String string2, long l2, int n2) {
        BannerManager bannerManager = this;
        synchronized (bannerManager) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("initBannerManager(appKey: ");
            stringBuilder.append(string);
            stringBuilder.append(", userId: ");
            stringBuilder.append(string2);
            stringBuilder.append(")");
            this.debugLog(stringBuilder.toString());
            this.mAppKey = string;
            this.mUserId = string2;
            this.mActivity = activity;
            this.mReloadInterval = n2;
            int n3 = 0;
            do {
                if (n3 >= list.size()) {
                    this.mCurrentPlacement = null;
                    this.setState(BANNER_STATE.READY_TO_LOAD);
                    return;
                }
                ProviderSettings providerSettings = (ProviderSettings)list.get(n3);
                AbstractAdapter abstractAdapter = this.loadAdapter(providerSettings);
                if (abstractAdapter != null && this.isValidBannerVersion(abstractAdapter.getVersion())) {
                    BannerSmash bannerSmash = new BannerSmash(this, providerSettings, abstractAdapter, l2, n3 + 1);
                    this.mSmashArray.add((Object)bannerSmash);
                } else {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(providerSettings.getProviderInstanceName());
                    stringBuilder2.append(" can't load adapter or wrong version");
                    this.debugLog(stringBuilder2.toString());
                }
                ++n3;
            } while (true);
        }
    }

    /*
     * Exception decompiling
     */
    public void loadBanner(IronSourceBannerLayout var1_1, BannerPlacement var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
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

    @Override
    public void onBannerAdLoadFailed(IronSourceError ironSourceError, BannerSmash bannerSmash) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onBannerAdLoadFailed ");
        stringBuilder.append(ironSourceError.getErrorMessage());
        this.callbackLog(stringBuilder.toString(), bannerSmash);
        if (this.mState != BANNER_STATE.FIRST_LOAD_IN_PROGRESS && this.mState != BANNER_STATE.LOAD_IN_PROGRESS) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("onBannerAdLoadFailed ");
            stringBuilder2.append(bannerSmash.getName());
            stringBuilder2.append(" wrong state=");
            stringBuilder2.append(this.mState.name());
            this.debugLog(stringBuilder2.toString());
            return;
        }
        Object[][] arrobject = new Object[1][];
        Object[] arrobject2 = new Object[]{"errorCode", ironSourceError.getErrorCode()};
        arrobject[0] = arrobject2;
        this.sendProviderEvent(3300, bannerSmash, arrobject);
        if (this.loadNextSmash()) {
            return;
        }
        if (this.mState == BANNER_STATE.FIRST_LOAD_IN_PROGRESS) {
            BannerCallbackThrottler.getInstance().sendBannerAdLoadFailed(this.mIronsourceBanner, new IronSourceError(606, "No ads to show"));
            Object[][] arrobject3 = new Object[1][];
            Object[] arrobject4 = new Object[]{"errorCode", 606};
            arrobject3[0] = arrobject4;
            this.sendMediationEvent(3111, arrobject3);
            this.setState(BANNER_STATE.READY_TO_LOAD);
            return;
        }
        this.sendMediationEvent(3201);
        this.resetIteration();
        this.startIterationTimer();
    }

    @Override
    public void onBannerAdReloadFailed(IronSourceError ironSourceError, BannerSmash bannerSmash) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onBannerAdReloadFailed ");
        stringBuilder.append(ironSourceError.getErrorMessage());
        this.callbackLog(stringBuilder.toString(), bannerSmash);
        if (this.mState != BANNER_STATE.RELOAD_IN_PROGRESS) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("onBannerAdReloadFailed ");
            stringBuilder2.append(bannerSmash.getName());
            stringBuilder2.append(" wrong state=");
            stringBuilder2.append(this.mState.name());
            this.debugLog(stringBuilder2.toString());
            return;
        }
        Object[][] arrobject = new Object[1][];
        Object[] arrobject2 = new Object[]{"errorCode", ironSourceError.getErrorCode()};
        arrobject[0] = arrobject2;
        this.sendProviderEvent(3301, bannerSmash, arrobject);
        this.setState(BANNER_STATE.LOAD_IN_PROGRESS);
        if (!this.loadNextSmash()) {
            this.sendMediationEvent(3201);
            this.resetIteration();
            this.startIterationTimer();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onPause(Activity activity) {
        CopyOnWriteArrayList<BannerSmash> copyOnWriteArrayList;
        CopyOnWriteArrayList<BannerSmash> copyOnWriteArrayList2 = copyOnWriteArrayList = this.mSmashArray;
        synchronized (copyOnWriteArrayList2) {
            this.mIsInForeground = false;
            Iterator iterator = this.mSmashArray.iterator();
            while (iterator.hasNext()) {
                ((BannerSmash)iterator.next()).onPause(activity);
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
        CopyOnWriteArrayList<BannerSmash> copyOnWriteArrayList;
        CopyOnWriteArrayList<BannerSmash> copyOnWriteArrayList2 = copyOnWriteArrayList = this.mSmashArray;
        synchronized (copyOnWriteArrayList2) {
            this.mIsInForeground = true;
            Iterator iterator = this.mSmashArray.iterator();
            while (iterator.hasNext()) {
                ((BannerSmash)iterator.next()).onResume(activity);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void setConsent(boolean bl) {
        CopyOnWriteArrayList<BannerSmash> copyOnWriteArrayList;
        BannerManager bannerManager = this;
        // MONITORENTER : bannerManager
        CopyOnWriteArrayList<BannerSmash> copyOnWriteArrayList2 = copyOnWriteArrayList = this.mSmashArray;
        // MONITORENTER : copyOnWriteArrayList2
        Iterator iterator = this.mSmashArray.iterator();
        do {
            if (!iterator.hasNext()) {
                // MONITOREXIT : copyOnWriteArrayList2
                // MONITOREXIT : bannerManager
                return;
            }
            ((BannerSmash)iterator.next()).setConsent(bl);
        } while (true);
    }

}

