/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.text.TextUtils
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.lang.reflect.Method
 *  java.util.concurrent.atomic.AtomicBoolean
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.eventsmodule.EventData;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSourceObject;
import com.ironsource.mediationsdk.events.RewardedVideoEventsManager;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.model.Configurations;
import com.ironsource.mediationsdk.model.OfferwallConfigurations;
import com.ironsource.mediationsdk.model.OfferwallPlacement;
import com.ironsource.mediationsdk.model.ProviderSettings;
import com.ironsource.mediationsdk.model.ProviderSettingsHolder;
import com.ironsource.mediationsdk.sdk.InternalOfferwallListener;
import com.ironsource.mediationsdk.sdk.OfferwallAdapterApi;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.ServerResponseWrapper;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

class OfferwallManager
implements InternalOfferwallListener {
    private final String TAG = this.getClass().getName();
    private Activity mActivity;
    private OfferwallAdapterApi mAdapter;
    private AtomicBoolean mAtomicShouldPerformInit = new AtomicBoolean(true);
    private String mCurrentPlacementName;
    private AtomicBoolean mIsOfferwallAvailable = new AtomicBoolean(false);
    private InternalOfferwallListener mListenersWrapper;
    private IronSourceLoggerManager mLoggerManager = IronSourceLoggerManager.getLogger();
    private ProviderSettings mProviderSettings;
    private ServerResponseWrapper mServerResponseWrapper;

    OfferwallManager() {
    }

    private void reportInitFail(IronSourceError ironSourceError) {
        OfferwallManager offerwallManager = this;
        synchronized (offerwallManager) {
            if (this.mIsOfferwallAvailable != null) {
                this.mIsOfferwallAvailable.set(false);
            }
            if (this.mAtomicShouldPerformInit != null) {
                this.mAtomicShouldPerformInit.set(true);
            }
            if (this.mListenersWrapper != null) {
                this.mListenersWrapper.onOfferwallAvailable(false, ironSourceError);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setCustomParams(AbstractAdapter abstractAdapter) {
        try {
            Boolean bl;
            String string;
            String string2;
            Integer n2 = IronSourceObject.getInstance().getAge();
            if (n2 != null) {
                abstractAdapter.setAge(n2);
            }
            if ((string = IronSourceObject.getInstance().getGender()) != null) {
                abstractAdapter.setGender(string);
            }
            if ((string2 = IronSourceObject.getInstance().getMediationSegment()) != null) {
                abstractAdapter.setMediationSegment(string2);
            }
            if ((bl = IronSourceObject.getInstance().getConsent()) == null) return;
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_API;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Offerwall | setConsent(consent:");
            stringBuilder.append((Object)bl);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            abstractAdapter.setConsent(bl);
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

    private AbstractAdapter startOfferwallAdapter() {
        IronSourceObject ironSourceObject;
        AbstractAdapter abstractAdapter;
        block4 : {
            try {
                ironSourceObject = IronSourceObject.getInstance();
                abstractAdapter = ironSourceObject.getExistingAdapter("SupersonicAds");
                if (abstractAdapter != null) break block4;
            }
            catch (Throwable throwable) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.API, "SupersonicAds initialization failed - please verify that required dependencies are in you build path.", 2);
                IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.TAG);
                stringBuilder.append(":startOfferwallAdapter");
                ironSourceLoggerManager.logException(ironSourceTag, stringBuilder.toString(), throwable);
                return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("com.ironsource.adapters.");
            stringBuilder.append("SupersonicAds".toLowerCase());
            stringBuilder.append(".");
            stringBuilder.append("SupersonicAds");
            stringBuilder.append("Adapter");
            Class class_ = Class.forName((String)stringBuilder.toString());
            abstractAdapter = (AbstractAdapter)class_.getMethod("startAdapter", new Class[]{String.class}).invoke((Object)class_, new Object[]{"SupersonicAds"});
            if (abstractAdapter != null) break block4;
            return null;
        }
        ironSourceObject.addOWAdapter(abstractAdapter);
        return abstractAdapter;
    }

    public void getOfferwallCredits() {
        OfferwallAdapterApi offerwallAdapterApi = this.mAdapter;
        if (offerwallAdapterApi != null) {
            offerwallAdapterApi.getOfferwallCredits();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void initOfferwall(Activity activity, String string, String string2) {
        OfferwallManager offerwallManager = this;
        synchronized (offerwallManager) {
            IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.TAG);
            stringBuilder.append(":initOfferwall(appKey: ");
            stringBuilder.append(string);
            stringBuilder.append(", userId: ");
            stringBuilder.append(string2);
            stringBuilder.append(")");
            ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
            this.mActivity = activity;
            this.mServerResponseWrapper = IronSourceObject.getInstance().getCurrentServerResponse();
            if (this.mServerResponseWrapper == null) {
                this.reportInitFail(ErrorBuilder.buildInitFailedError("Please check configurations for Offerwall adapters", "Offerwall"));
                return;
            }
            this.mProviderSettings = this.mServerResponseWrapper.getProviderSettingsHolder().getProviderSettings("SupersonicAds");
            if (this.mProviderSettings == null) {
                this.reportInitFail(ErrorBuilder.buildInitFailedError("Please check configurations for Offerwall adapters", "Offerwall"));
                return;
            }
            AbstractAdapter abstractAdapter = this.startOfferwallAdapter();
            if (abstractAdapter == null) {
                this.reportInitFail(ErrorBuilder.buildInitFailedError("Please check configurations for Offerwall adapters", "Offerwall"));
                return;
            }
            this.setCustomParams(abstractAdapter);
            abstractAdapter.setLogListener(this.mLoggerManager);
            this.mAdapter = (OfferwallAdapterApi)((Object)abstractAdapter);
            this.mAdapter.setInternalOfferwallListener(this);
            this.mAdapter.initOfferwall(activity, string, string2, this.mProviderSettings.getRewardedVideoSettings());
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isOfferwallAvailable() {
        OfferwallManager offerwallManager = this;
        synchronized (offerwallManager) {
            AtomicBoolean atomicBoolean = this.mIsOfferwallAvailable;
            boolean bl = false;
            if (atomicBoolean == null) return bl;
            return this.mIsOfferwallAvailable.get();
        }
    }

    @Override
    public void onGetOfferwallCreditsFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onGetOfferwallCreditsFailed(");
        stringBuilder.append((Object)ironSourceError);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onGetOfferwallCreditsFailed(ironSourceError);
        }
    }

    @Override
    public boolean onOfferwallAdCredited(int n2, int n3, boolean bl) {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallAdCredited()", 1);
        InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
        if (internalOfferwallListener != null) {
            return internalOfferwallListener.onOfferwallAdCredited(n2, n3, bl);
        }
        return false;
    }

    @Override
    public void onOfferwallAvailable(boolean bl) {
        this.onOfferwallAvailable(bl, null);
    }

    @Override
    public void onOfferwallAvailable(boolean bl, IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onOfferwallAvailable(isAvailable: ");
        stringBuilder.append(bl);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        if (bl) {
            this.mIsOfferwallAvailable.set(true);
            InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
            if (internalOfferwallListener != null) {
                internalOfferwallListener.onOfferwallAvailable(true);
                return;
            }
        } else {
            this.reportInitFail(ironSourceError);
        }
    }

    @Override
    public void onOfferwallClosed() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallClosed()", 1);
        InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallClosed();
        }
    }

    @Override
    public void onOfferwallOpened() {
        this.mLoggerManager.log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "onOfferwallOpened()", 1);
        JSONObject jSONObject = IronSourceUtils.getMediationAdditionalData(false);
        try {
            if (!TextUtils.isEmpty((CharSequence)this.mCurrentPlacementName)) {
                jSONObject.put("placement", (Object)this.mCurrentPlacementName);
            }
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        EventData eventData = new EventData(305, jSONObject);
        RewardedVideoEventsManager.getInstance().log(eventData);
        InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallOpened();
        }
    }

    @Override
    public void onOfferwallShowFailed(IronSourceError ironSourceError) {
        IronSourceLoggerManager ironSourceLoggerManager = this.mLoggerManager;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onOfferwallShowFailed(");
        stringBuilder.append((Object)ironSourceError);
        stringBuilder.append(")");
        ironSourceLoggerManager.log(ironSourceTag, stringBuilder.toString(), 1);
        InternalOfferwallListener internalOfferwallListener = this.mListenersWrapper;
        if (internalOfferwallListener != null) {
            internalOfferwallListener.onOfferwallShowFailed(ironSourceError);
        }
    }

    public void setInternalOfferwallListener(InternalOfferwallListener internalOfferwallListener) {
        this.mListenersWrapper = internalOfferwallListener;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void showOfferwall(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OWManager:showOfferwall(");
        stringBuilder.append(string);
        stringBuilder.append(")");
        String string2 = stringBuilder.toString();
        try {
            if (!IronSourceUtils.isNetworkConnected((Context)this.mActivity)) {
                this.mListenersWrapper.onOfferwallShowFailed(ErrorBuilder.buildNoInternetConnectionShowFailError("Offerwall"));
                return;
            }
            this.mCurrentPlacementName = string;
            OfferwallPlacement offerwallPlacement = this.mServerResponseWrapper.getConfigurations().getOfferwallConfigurations().getOfferwallPlacement(string);
            if (offerwallPlacement == null) {
                this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Placement is not valid, please make sure you are using the right placements, using the default placement.", 3);
                offerwallPlacement = this.mServerResponseWrapper.getConfigurations().getOfferwallConfigurations().getDefaultOfferwallPlacement();
                if (offerwallPlacement == null) {
                    this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, "Default placement was not found, please make sure you are using the right placements.", 3);
                    return;
                }
            }
            this.mLoggerManager.log(IronSourceLogger.IronSourceTag.INTERNAL, string2, 1);
            if (this.mIsOfferwallAvailable == null) return;
            if (!this.mIsOfferwallAvailable.get()) return;
            if (this.mAdapter == null) return;
            this.mAdapter.showOfferwall(String.valueOf((int)offerwallPlacement.getPlacementId()), this.mProviderSettings.getRewardedVideoSettings());
            return;
        }
        catch (Exception exception) {
            this.mLoggerManager.logException(IronSourceLogger.IronSourceTag.INTERNAL, string2, exception);
        }
    }
}

