/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  com.aerserv.sdk.adapter.AppLovinInterstitialAdapter
 *  com.aerserv.sdk.adapter.ThirdPartyProvider$1
 *  com.aerserv.sdk.adapter.ThirdPartyProvider$2
 *  com.aerserv.sdk.adapter.ThirdPartyProvider$3
 *  com.aerserv.sdk.adapter.ThirdPartyProvider$DefaultAdapterListener
 *  com.aerserv.sdk.adapter.task.LoadAdTask
 *  com.aerserv.sdk.adapter.task.ShowAdTask
 *  java.lang.Boolean
 *  java.lang.Exception
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Void
 *  java.math.BigDecimal
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Queue
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.aerserv.sdk.adapter;

import android.app.Activity;
import android.content.Context;
import com.aerserv.sdk.AerServEvent;
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.AerServTransactionInformation;
import com.aerserv.sdk.AerServVirtualCurrency;
import com.aerserv.sdk.adapter.Adapter;
import com.aerserv.sdk.adapter.AdapterAdRefresher;
import com.aerserv.sdk.adapter.AdapterFactory;
import com.aerserv.sdk.adapter.AdapterListener;
import com.aerserv.sdk.adapter.AppLovinInterstitialAdapter;
import com.aerserv.sdk.adapter.ThirdPartyProvider;
import com.aerserv.sdk.adapter.task.LoadAdTask;
import com.aerserv.sdk.adapter.task.ShowAdTask;
import com.aerserv.sdk.controller.listener.AerServEventListenerLocator;
import com.aerserv.sdk.controller.listener.FetchAdapterDynamicPriceListener;
import com.aerserv.sdk.controller.listener.ProviderListener;
import com.aerserv.sdk.controller.listener.ProviderListenerLocator;
import com.aerserv.sdk.model.Asplc;
import com.aerserv.sdk.notification.NotificationCenter;
import com.aerserv.sdk.notification.NotificationListener;
import com.aerserv.sdk.notification.NotificationType;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.MultiKey;
import com.aerserv.sdk.utils.SDKEventHelper;
import com.aerserv.sdk.utils.task.Task;
import com.aerserv.sdk.utils.task.TaskListener;
import com.aerserv.sdk.utils.task.TaskResult;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis.
 */
public class ThirdPartyProvider {
    private static final String LOG_TAG = "ThirdPartyProvider";
    private static final Map<MultiKey, ThirdPartyProvider> instanceMap;
    private static final Map<Adapter, LoadAdTask> loadAdTaskMap;
    private static final Map<Adapter, String> ownerMap;
    private static long showTimeout;
    private Adapter adapter;
    private Asplc asplc;
    private String controllerId;
    private JSONObject credentials;
    private boolean hasShowAttemptEventFired;
    private final boolean isDebug;
    private Boolean isPreload;
    private AdapterListener listener;
    private String logTag;
    private String plc;
    private Boolean rewardedAd;
    private boolean showAttempted;

    static {
        instanceMap = new HashMap();
        loadAdTaskMap = new HashMap();
        ownerMap = new HashMap();
        showTimeout = AerServSettings.getStep4Timeout();
        1 var0 = new 1();
        NotificationCenter.addListener(NotificationType.AD_REQUESTED_FOR_PLC, (NotificationListener)var0);
        NotificationCenter.addListener(NotificationType.SHOW_ATTEMPTED_FOR_PLC, (NotificationListener)var0);
    }

    private ThirdPartyProvider(Asplc asplc, String string, String string2, JSONObject jSONObject, Adapter adapter, boolean bl) {
        this.listener = null;
        this.showAttempted = false;
        this.isPreload = null;
        this.hasShowAttemptEventFired = false;
        this.asplc = asplc;
        this.plc = string;
        this.controllerId = string2;
        this.credentials = jSONObject;
        this.rewardedAd = asplc.hasVcEnabled();
        this.isDebug = bl;
        this.logTag = this.getLogTag(asplc.getAdapterName(), string, string2, asplc.getAsplcId());
        this.adapter = adapter;
    }

    static /* synthetic */ String access$000() {
        return LOG_TAG;
    }

    static /* synthetic */ void access$100(String string) {
        ThirdPartyProvider.unreserveAdaptersByPlc(string);
    }

    static /* synthetic */ long access$1000() {
        return showTimeout;
    }

    static /* synthetic */ Map access$200() {
        return instanceMap;
    }

    static /* synthetic */ String access$300(ThirdPartyProvider thirdPartyProvider) {
        return thirdPartyProvider.logTag;
    }

    static /* synthetic */ Adapter access$400(ThirdPartyProvider thirdPartyProvider) {
        return thirdPartyProvider.adapter;
    }

    static /* synthetic */ String access$500(ThirdPartyProvider thirdPartyProvider) {
        return thirdPartyProvider.plc;
    }

    static /* synthetic */ Boolean access$600(ThirdPartyProvider thirdPartyProvider) {
        return thirdPartyProvider.rewardedAd;
    }

    static /* synthetic */ Asplc access$700(ThirdPartyProvider thirdPartyProvider) {
        return thirdPartyProvider.asplc;
    }

    static /* synthetic */ boolean access$800(ThirdPartyProvider thirdPartyProvider) {
        return thirdPartyProvider.isDebug;
    }

    static /* synthetic */ Map access$900() {
        return ownerMap;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void cleanupInstance(Activity activity, String string) {
        Map<MultiKey, ThirdPartyProvider> map;
        Map<MultiKey, ThirdPartyProvider> map2 = map = instanceMap;
        synchronized (map2) {
            ArrayList arrayList = new ArrayList();
            for (MultiKey multiKey : instanceMap.keySet()) {
                if (!multiKey.hasKey(string)) continue;
                arrayList.add((Object)multiKey);
            }
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                MultiKey multiKey = (MultiKey)iterator.next();
                ThirdPartyProvider thirdPartyProvider = (ThirdPartyProvider)instanceMap.get((Object)multiKey);
                if (thirdPartyProvider == null || thirdPartyProvider.hasAd()) continue;
                thirdPartyProvider.cleanup(activity);
                instanceMap.remove((Object)multiKey);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected static final void finishLoadingAdTask(Adapter adapter) {
        Map<MultiKey, ThirdPartyProvider> map;
        Map<MultiKey, ThirdPartyProvider> map2 = map = instanceMap;
        synchronized (map2) {
            loadAdTaskMap.remove((Object)adapter);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ThirdPartyProvider getInstance(Asplc asplc, String string, String string2, String string3, JSONObject jSONObject, boolean bl) {
        Map<MultiKey, ThirdPartyProvider> map;
        String string4 = string.replaceFirst("AS", "");
        Adapter adapter = AdapterFactory.getAdapter(string4, string2, jSONObject);
        if (adapter == null) {
            String string5 = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot get instance of ThirdPartyProvider ");
            stringBuilder.append(string4);
            stringBuilder.append(" the adapter for the given credentials cannot be found");
            AerServLog.i(string5, stringBuilder.toString());
            return null;
        }
        MultiKey multiKey = new MultiKey(string4, string2, string3, adapter);
        Map<MultiKey, ThirdPartyProvider> map2 = map = instanceMap;
        synchronized (map2) {
            ThirdPartyProvider thirdPartyProvider = (ThirdPartyProvider)instanceMap.get((Object)multiKey);
            if (thirdPartyProvider != null) return thirdPartyProvider;
            ThirdPartyProvider thirdPartyProvider2 = new ThirdPartyProvider(asplc, string2, string3, jSONObject, adapter, bl);
            instanceMap.put((Object)multiKey, (Object)thirdPartyProvider2);
            return thirdPartyProvider2;
        }
    }

    private String getLogTag(String string, String string2, String string3, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ThirdPartyProvider.class.getSimpleName());
        stringBuilder.append(" ");
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append("plc: ");
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        stringBuilder.append("asplcId: ");
        stringBuilder.append(n2);
        stringBuilder.append(" ");
        stringBuilder.append("controllerId: ");
        stringBuilder.append(string3.substring(0, 5));
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected static boolean isAdapterLoadingAd(Adapter adapter) {
        Map<MultiKey, ThirdPartyProvider> map;
        Map<MultiKey, ThirdPartyProvider> map2 = map = instanceMap;
        synchronized (map2) {
            LoadAdTask loadAdTask = (LoadAdTask)loadAdTaskMap.get((Object)adapter);
            if (loadAdTask == null) return false;
            if (!loadAdTask.isRunning()) return false;
            return true;
        }
    }

    private void onReserveAdFailed(String string) {
        ProviderListener providerListener = ProviderListenerLocator.getProviderListener(string);
        if (providerListener != null) {
            providerListener.onProviderFailure();
        }
    }

    private void onReserveAdSucceeded(Context context) {
        if (this.controllerId != null) {
            if (this.isPreload.booleanValue()) {
                AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.PRELOAD_READY);
            } else {
                this.showAd(context);
            }
        }
        AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.LOAD_TRANSACTION, this.asplc.getVc().getAerServTransactionInformation());
        if (this.asplc.getVc() != null && this.asplc.getVc().isEnabled()) {
            AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.VC_READY, this.asplc.getVc());
        }
    }

    private void onShowAdFailed(Activity activity) {
        ProviderListener providerListener = ProviderListenerLocator.getProviderListener(this.controllerId);
        if (providerListener != null) {
            providerListener.onProviderFailShow();
        }
        ThirdPartyProvider.unreserveAdapter(this.adapter);
        this.cleanup(activity);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static final boolean reserveAdapter(Adapter adapter, String string) {
        Map<MultiKey, ThirdPartyProvider> map;
        Map<MultiKey, ThirdPartyProvider> map2 = map = instanceMap;
        synchronized (map2) {
            if (loadAdTaskMap.get((Object)adapter) != null) {
                return false;
            }
            if (ownerMap.get((Object)adapter) != null) return ((String)ownerMap.get((Object)adapter)).equals((Object)string);
            ownerMap.put((Object)adapter, (Object)string);
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected static final boolean startLoadingAdTask(Adapter adapter, String string, Asplc asplc, Activity activity, JSONObject jSONObject, Boolean bl, Boolean bl2, TaskListener<Void> taskListener, long l2) {
        Map<MultiKey, ThirdPartyProvider> map;
        Map<MultiKey, ThirdPartyProvider> map2 = map = instanceMap;
        synchronized (map2) {
            if (ownerMap.get((Object)adapter) != null) {
                return false;
            }
            boolean bl3 = adapter instanceof AppLovinInterstitialAdapter;
            if (!bl3) {
                try {
                    adapter.cleanup(activity);
                }
                catch (Exception exception) {
                    String string2 = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Exception cleaning up mediated ad: ");
                    stringBuilder.append(exception.getMessage());
                    AerServLog.w(string2, stringBuilder.toString());
                }
            }
            asplc.setDynamicPrice(BigDecimal.ZERO);
            LoadAdTask loadAdTask = (LoadAdTask)loadAdTaskMap.get((Object)adapter);
            if (loadAdTask != null && loadAdTask.isRunning()) {
                AerServLog.v(string, "No need to load ad because loadAdTask is running already");
                return false;
            }
            LoadAdTask loadAdTask2 = new LoadAdTask(activity, asplc.getAdapterName(), adapter, jSONObject, bl.booleanValue(), bl2.booleanValue());
            loadAdTask2.withListener(taskListener);
            loadAdTaskMap.put((Object)adapter, (Object)loadAdTask2);
            loadAdTask2.withTimeout(l2).run((P[])new Void[0]);
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void unreserveAdapter(Adapter adapter) {
        Map<MultiKey, ThirdPartyProvider> map;
        Map<MultiKey, ThirdPartyProvider> map2 = map = instanceMap;
        synchronized (map2) {
            ownerMap.remove((Object)adapter);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void unreserveAdaptersByPlc(String string) {
        Map<MultiKey, ThirdPartyProvider> map;
        Map<MultiKey, ThirdPartyProvider> map2 = map = instanceMap;
        synchronized (map2) {
            ArrayList arrayList = new ArrayList();
            for (Adapter adapter : ownerMap.keySet()) {
                if (!((String)ownerMap.get((Object)adapter)).equals((Object)string)) continue;
                arrayList.add((Object)adapter);
            }
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                Adapter adapter = (Adapter)iterator.next();
                ownerMap.remove((Object)adapter);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void cleanup(Activity activity) {
        Adapter adapter;
        if (this.controllerId != null) {
            Map<MultiKey, ThirdPartyProvider> map;
            Map<MultiKey, ThirdPartyProvider> map2 = map = instanceMap;
            synchronized (map2) {
                ArrayList arrayList = new ArrayList();
                for (MultiKey multiKey : instanceMap.keySet()) {
                    if (!multiKey.hasKey(this.controllerId)) continue;
                    arrayList.add((Object)multiKey);
                }
                for (MultiKey multiKey : arrayList) {
                    instanceMap.remove((Object)multiKey);
                }
            }
        }
        if ((adapter = this.adapter) != null) {
            try {
                adapter.cleanup(activity);
                if (this.adapter != null && !AdapterAdRefresher.containsAdapter(this.adapter)) {
                    this.adapter.removeInstance();
                }
            }
            catch (Exception exception) {
                String string = this.logTag;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Exception cleaning up mediated ad: ");
                stringBuilder.append(exception.getMessage());
                AerServLog.w(string, stringBuilder.toString());
                return;
            }
        }
        this.controllerId = null;
        this.credentials = null;
        this.adapter = null;
        this.listener = null;
        this.isPreload = null;
        this.asplc = null;
    }

    public Adapter getAdapter() {
        return this.adapter;
    }

    public boolean hasAd() {
        Adapter adapter = this.adapter;
        return adapter != null && adapter.hasAd(this.rewardedAd);
    }

    public boolean hasAd(boolean bl) {
        Adapter adapter = this.adapter;
        return adapter != null && adapter.hasAd(bl);
    }

    public void loadAd(Context context, Queue<Asplc> queue, FetchAdapterDynamicPriceListener fetchAdapterDynamicPriceListener, long l2) {
        try {
            2 var21_15;
            AerServLog.v(this.logTag, "Trying to load ad");
            if (!(context instanceof Activity)) {
                AerServLog.i(this.logTag, "Cannot load ad because context is not of type Activity");
                return;
            }
            if (this.adapter == null) {
                AerServLog.i(this.logTag, "Cannot load ad because the adapter for the given credentials cannot be found");
                return;
            }
            String string = this.asplc.getSdkEventUrl();
            String string2 = this.asplc.getRid();
            String string3 = this.asplc.getAdapterName();
            Adapter adapter = this.adapter;
            String string4 = this.logTag;
            Asplc asplc = this.asplc;
            Activity activity = (Activity)context;
            JSONObject jSONObject = this.credentials;
            Boolean bl = this.rewardedAd;
            Boolean bl2 = this.isDebug;
            if (ThirdPartyProvider.startLoadingAdTask(adapter, string4, asplc, activity, jSONObject, bl, bl2, (TaskListener<Void>)(var21_15 = new 2(this, string, string3, string2, context, queue, fetchAdapterDynamicPriceListener)), l2)) {
                SDKEventHelper.sendEvent(string, string3, string2, "12", this.plc);
            }
            return;
        }
        catch (Exception exception) {
            String string = this.logTag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception loading mediated ad: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string, stringBuilder.toString());
            return;
        }
    }

    public void reserveAd(Context context, boolean bl) {
        this.isPreload = bl;
        try {
            AerServLog.v(this.logTag, "Trying to reserve ad");
            if (this.adapter == null) {
                AerServLog.i(this.logTag, "Cannot reserve ad because the adapter for given credentials cannot be found");
                this.onReserveAdFailed(this.controllerId);
                return;
            }
            if (ThirdPartyProvider.isAdapterLoadingAd(this.adapter)) {
                AerServLog.v(this.logTag, "Ad is still being loaded.  Waiting before reserving.");
                ((LoadAdTask)loadAdTaskMap.get((Object)this.adapter)).waitForResult();
            }
            if (!ThirdPartyProvider.reserveAdapter(this.adapter, this.plc)) {
                String string = this.logTag;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cannot reserve ad because it is currently owned by plc: ");
                stringBuilder.append((String)ownerMap.get((Object)this.adapter));
                AerServLog.d(string, stringBuilder.toString());
                this.onReserveAdFailed(this.controllerId);
                return;
            }
            if (!this.adapter.hasAd(this.rewardedAd)) {
                AerServLog.d(this.logTag, "Cannot reserve ad because it is no longer available");
                ThirdPartyProvider.unreserveAdapter(this.adapter);
                this.onReserveAdFailed(this.controllerId);
                return;
            }
            if (this.adapter.CASAdManuallyLoadedFlag(true)) {
                String string = this.asplc.getSdkEventUrl();
                String string2 = this.asplc.getRid();
                String string3 = this.asplc.getAdapterName();
                String string4 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string3);
                stringBuilder.append(" ");
                stringBuilder.append(this.asplc.getAsplcId());
                stringBuilder.append(" This cached ad was loaded either without our knowledge, or was loaded after timeout. Send another pair of events");
                AerServLog.d(string4, stringBuilder.toString());
                SDKEventHelper.sendEvent(string, string3, string2, "12", this.plc);
                SDKEventHelper.sendEvent(string, string3, string2, "34", this.plc);
                AdapterAdRefresher.addAdapter(this.adapter, (Activity)context, this.asplc, this.plc, this.rewardedAd, this.isDebug);
            }
            AerServLog.v(this.logTag, "Ad reserved");
            this.onReserveAdSucceeded(context);
            return;
        }
        catch (Exception exception) {
            String string = this.logTag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception reserving mediated ad: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string, stringBuilder.toString());
            return;
        }
    }

    public void setAsplc(Asplc asplc) {
        this.asplc = asplc;
    }

    public void showAd(Context context) {
        if (this.isPreload == null) {
            AerServLog.i(this.logTag, "Cannot show ad because it has not been loaded");
            return;
        }
        if (ProviderListenerLocator.getProviderListener(this.controllerId) == null) {
            AerServLog.i(this.logTag, "Cannot show ad because it has already been shown");
            return;
        }
        try {
            AerServLog.v(this.logTag, "step4: Trying to show ad");
            if (this.isPreload.booleanValue() && !this.hasShowAttemptEventFired) {
                AerServEventListenerLocator.fireEvent(this.controllerId, AerServEvent.INTERNAL_SHOW_ATTEMPTED);
                this.hasShowAttemptEventFired = true;
            }
            if (!(context instanceof Activity)) {
                AerServLog.i(this.logTag, "Cannot show ad because context is not of type Activity");
                this.onShowAdFailed(null);
                return;
            }
            if (this.showAttempted) {
                AerServLog.i(this.logTag, "Cannot show ad because it has already been shown");
                this.onShowAdFailed((Activity)context);
                return;
            }
            this.showAttempted = true;
            if (this.adapter == null) {
                AerServLog.i(this.logTag, "Cannot show ad because the adapter for given credentials cannot be found");
                this.onShowAdFailed((Activity)context);
                return;
            }
            if (!this.adapter.hasAd(this.rewardedAd)) {
                AerServLog.d(this.logTag, "Cannot show ad because it is no longer available");
                this.onShowAdFailed((Activity)context);
                return;
            }
            AerServLog.v(this.logTag, "step4: begin to show ad");
            this.asplc.getAsplcId();
            String string = this.asplc.getSdkEventUrl();
            String string2 = this.asplc.getRid();
            String string3 = this.asplc.getAdapterName();
            DefaultAdapterListener defaultAdapterListener = new /* Unavailable Anonymous Inner Class!! */;
            this.listener = defaultAdapterListener;
            ShowAdTask showAdTask = new ShowAdTask((Activity)context, string3, this.adapter, this.rewardedAd.booleanValue(), this.listener);
            showAdTask.withListener((TaskListener)new 3(this, string2, string, string3));
            showAdTask.withTimeout(showTimeout).run((P[])new Void[0]);
            return;
        }
        catch (Exception exception) {
            String string = this.logTag;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Exception showing mediated ad: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.w(string, stringBuilder.toString());
            return;
        }
    }

}

