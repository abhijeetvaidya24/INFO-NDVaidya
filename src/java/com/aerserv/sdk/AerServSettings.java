/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  com.aerserv.sdk.AerServSettings$2
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.IllegalStateException
 *  java.lang.Integer
 *  java.lang.InterruptedException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.lang.reflect.Method
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.UUID
 *  java.util.concurrent.CountDownLatch
 *  java.util.concurrent.Executor
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.aerserv.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.aerserv.sdk.AerServSettings;
import com.aerserv.sdk.adapter.AdapterAdRefresher;
import com.aerserv.sdk.adapter.AdapterFactory;
import com.aerserv.sdk.http.HttpPostTask;
import com.aerserv.sdk.http.HttpTaskListener;
import com.aerserv.sdk.model.Asplc;
import com.aerserv.sdk.proxy.PreInitProxy;
import com.aerserv.sdk.proxy.SybokProxy;
import com.aerserv.sdk.utils.AerServLog;
import com.aerserv.sdk.utils.CommonUtils;
import com.aerserv.sdk.utils.ReflectionUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AerServSettings {
    private static final String ADVERTISING_ID_KEY = "adId";
    private static final String APPS_KEYS = "apps";
    private static final String BUNDLE_ID_KEY = "bundleId";
    private static final int CONFIG_READY = 2;
    public static final String CONFIG_SERVER_URL = "https://ads.aerserv.com/as/sdk/configure/";
    private static final String GET_DEVICE_INFO_KEY = "update";
    private static final String HTTP_TIMEOUT_KEY = "requestTimeout";
    private static final int INIT_ADAPTER = 3;
    private static final int INIT_DONE = 4;
    private static final String INSTALLED_KEY = "installed";
    private static final int LOADING = 1;
    private static final String LOG_TAG = "AerServSettings";
    private static final int NOT_INIT = 0;
    private static final int PRE_INIT_TIMEOUT_DEFAULT = 5000;
    private static AtomicInteger RETRY_COUNTDOWN;
    private static AtomicInteger STATE;
    private static final int STEP1_TIMEOUT_DEFAULT = 3000;
    private static final int STEP2_TIMEOUT_DEFAULT = 6000;
    private static final int STEP3_TIMEOUT_DEFAULT = 11000;
    private static final int STEP4_TIMEOUT_DEFAULT = 8000;
    private static final String UNINSTALLED_KEY = "uninstalled";
    private static final String UPDATE_SERVER_URL = "https://dmp.aerserv.com/update";
    private static final String VPAID_KEY = "vpaid";
    private static String applicationId;
    private static Boolean centralLoggingEnabled;
    private static Integer centralLoggingLineCount;
    private static Boolean centralLoggingSendStackTrace;
    private static JSONObject configJson;
    private static int httpTimeout = 6000;
    private static Boolean isAnalyticsEnabled;
    private static final String sessionId;
    private static String siteId;
    private static Integer step1Timeout;
    private static Integer step2Timeout;
    private static Integer step3Timeout;
    private static Integer step4Timeout;

    static {
        sessionId = UUID.randomUUID().toString();
        RETRY_COUNTDOWN = new AtomicInteger(1);
        STATE = new AtomicInteger(0);
    }

    static /* synthetic */ JSONObject access$300() {
        return configJson;
    }

    static /* synthetic */ JSONObject access$302(JSONObject jSONObject) {
        configJson = jSONObject;
        return jSONObject;
    }

    static /* synthetic */ AtomicInteger access$400() {
        return STATE;
    }

    static /* synthetic */ void access$500() {
        AerServSettings.parseConfigJson();
    }

    static /* synthetic */ void access$600(Activity activity) {
        AerServSettings.initAdapters(activity);
    }

    static /* synthetic */ void access$700(Activity activity) {
        AerServSettings.setApplicationId(activity);
    }

    static /* synthetic */ void access$800(Activity activity) {
        AerServSettings.getDeviceInfo(activity);
    }

    private static /* varargs */ void checkDependency(String ... arrstring) {
        for (String string : arrstring) {
            if (ReflectionUtils.canFindClass(string)) {
                continue;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Could not find library: ");
            stringBuilder.append(string);
            stringBuilder.append(".");
            throw new IllegalStateException(stringBuilder.toString());
        }
    }

    public static String getApplicationId() {
        return applicationId;
    }

    public static boolean getCentralLoggingEnabled() {
        Boolean bl = centralLoggingEnabled;
        if (bl != null) {
            return bl;
        }
        return true;
    }

    public static int getCentralLoggingLineCount() {
        Integer n2 = centralLoggingLineCount;
        if (n2 != null) {
            return n2;
        }
        return 500;
    }

    public static boolean getCentralLoggingSendStackTrace() {
        Boolean bl = centralLoggingSendStackTrace;
        if (bl != null) {
            return bl;
        }
        return true;
    }

    private static void getDeviceInfo(final Activity activity) {
        final JSONArray jSONArray = configJson.optJSONArray(GET_DEVICE_INFO_KEY);
        if (jSONArray != null && jSONArray.length() != 0) {
            new Thread(new Runnable(){

                private JSONObject getBundleInfo(PackageInfo packageInfo) throws JSONException {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(AerServSettings.BUNDLE_ID_KEY, (Object)packageInfo.applicationInfo.packageName);
                    return jSONObject;
                }

                private JSONObject getDeviceInfo(JSONObject jSONObject) throws JSONException {
                    AerServLog.v(LOG_TAG, "Getting device information.");
                    JSONArray jSONArray2 = new JSONArray();
                    for (PackageInfo packageInfo : this.getPackages()) {
                        if ((1 & packageInfo.applicationInfo.flags) != 0) continue;
                        jSONArray2.put((Object)this.getBundleInfo(packageInfo));
                    }
                    jSONObject.put(AerServSettings.INSTALLED_KEY, (Object)jSONArray2);
                    return jSONObject;
                }

                private List<PackageInfo> getPackages() {
                    return activity.getPackageManager().getInstalledPackages(0);
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public void run() {
                    HashSet hashSet;
                    int n2;
                    JSONObject jSONObject;
                    String string;
                    try {
                        AerServSettings.checkDependency(new String[]{"com.google.android.gms.ads.identifier.AdvertisingIdClient", "com.google.android.gms.ads.identifier.AdvertisingIdClient$Info"});
                        AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo((Context)activity);
                        if (info.isLimitAdTrackingEnabled()) {
                            AerServLog.v(LOG_TAG, "Updating information is disabled.");
                            return;
                        }
                        string = info.getId();
                        jSONObject = new JSONObject();
                        hashSet = new HashSet();
                        n2 = 0;
                    }
                    catch (Exception exception) {
                        AerServLog.i(LOG_TAG, "Error getting device information.", exception);
                        return;
                    }
                    do {
                        if (n2 < jSONArray.length()) {
                            String string2 = jSONArray.isNull(n2) ? null : jSONArray.optString(n2);
                            if (!TextUtils.isEmpty(string2) && !hashSet.contains((Object)string2)) {
                                hashSet.add((Object)string2);
                                if (string2.equals((Object)AerServSettings.APPS_KEYS)) {
                                    AerServLog.v(LOG_TAG, "Updating device informations for apps.");
                                    JSONObject jSONObject2 = new JSONObject();
                                    this.getDeviceInfo(jSONObject2);
                                    jSONObject.put(AerServSettings.APPS_KEYS, (Object)jSONObject2);
                                } else {
                                    String string3 = LOG_TAG;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Unsupported field to update: ");
                                    stringBuilder.append(string2);
                                    AerServLog.i(string3, stringBuilder.toString());
                                }
                            }
                        } else {
                            if (jSONObject.length() <= 0) return;
                            {
                                jSONObject.put(AerServSettings.ADVERTISING_ID_KEY, (Object)string);
                                new HttpPostTask(AerServSettings.UPDATE_SERVER_URL, jSONObject.toString(), httpTimeout).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, (Object[])new Void[0]);
                                return;
                            }
                        }
                        ++n2;
                    } while (true);
                }
            }).start();
            return;
        }
        AerServLog.v(LOG_TAG, "No device info fields to update.");
    }

    public static int getHttpTimeout() {
        return httpTimeout;
    }

    public static int getInitTimeout() {
        return 5000;
    }

    public static int getLoadAdTimeout() {
        return Math.max((int)1000, (int)(AerServSettings.getStep1Timeout() + AerServSettings.getStep2Timeout() + AerServSettings.getStep3Timeout()));
    }

    public static int getLoadAdTimeout(String string) {
        AerServSettings.readConfig(string);
        return AerServSettings.getLoadAdTimeout();
    }

    public static String getSessionId() {
        return sessionId;
    }

    public static String getSiteId() {
        return siteId;
    }

    public static int getStep1Timeout() {
        Integer n2 = step1Timeout;
        int n3 = n2 != null ? n2 : 3000;
        return Math.max((int)1000, (int)n3);
    }

    public static int getStep2Timeout() {
        Integer n2 = step2Timeout;
        int n3 = n2 != null ? n2 : 6000;
        return Math.max((int)1000, (int)n3);
    }

    public static int getStep3Timeout() {
        Integer n2 = step3Timeout;
        int n3 = n2 != null ? n2 : 11000;
        return Math.max((int)1000, (int)n3);
    }

    public static int getStep4ShowAdTimeout(Long l2) {
        int n2 = l2 != null ? l2.intValue() : AerServSettings.getStep4Timeout();
        return Math.max((int)1000, (int)n2);
    }

    public static int getStep4Timeout() {
        Integer n2 = step4Timeout;
        int n3 = n2 != null ? n2 : 8000;
        return Math.max((int)1000, (int)n3);
    }

    public static JSONObject getVpaidConfig() {
        return configJson.optJSONObject(VPAID_KEY);
    }

    public static void init(Activity activity, String string, String string2) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            siteId = string;
        }
        if (!AerServSettings.isInitDone()) {
            if (STATE.get() == 2 && configJson.length() == 0) {
                return;
            }
            if (STATE.compareAndSet(0, 1)) {
                AerServSettings.start(activity, string, string2);
                return;
            }
            if (activity != null && STATE.compareAndSet(2, 3)) {
                AerServSettings.initAdapters(activity);
                AerServSettings.setApplicationId(activity);
                AerServSettings.getDeviceInfo(activity);
                STATE.compareAndSet(3, 4);
                AerServLog.d(LOG_TAG, "pre-init: done");
                return;
            }
            long l2 = System.currentTimeMillis();
            while (!(System.currentTimeMillis() - l2 >= 5000L || AerServSettings.isInitDone() || STATE.get() == 2 && configJson.length() == 0)) {
                CommonUtils.sleepInMillisSeconds(100L);
            }
        }
    }

    private static boolean initAdapterClassByName(final Activity activity, final String string, final JSONArray jSONArray) {
        Method method;
        block3 : {
            try {
                method = Class.forName((String)AdapterFactory.getAdapterClassName(string)).getMethod("initPartnerSdk", new Class[]{Activity.class, JSONArray.class});
                if ("Chartboost".equals((Object)string) || "Vungle".equals((Object)string) || "AdColony".equals((Object)string) || "AppLovin".equals((Object)string)) break block3;
                method.invoke(null, new Object[]{activity, jSONArray});
                return true;
            }
            catch (Throwable throwable) {
                String string2 = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("pre-init: Exception initializing ");
                stringBuilder.append(string);
                stringBuilder.append(" SDK: ");
                stringBuilder.append(throwable.getMessage());
                AerServLog.e(string2, stringBuilder.toString());
                return false;
            }
        }
        new Thread(new Runnable(){

            public void run() {
                try {
                    Method method2 = method;
                    Object[] arrobject = new Object[]{activity, jSONArray};
                    method2.invoke(null, arrobject);
                    return;
                }
                catch (Throwable throwable) {
                    String string2 = LOG_TAG;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("pre-init: Exception initializing ");
                    stringBuilder.append(string);
                    stringBuilder.append(" SDK: ");
                    stringBuilder.append(throwable.getMessage());
                    AerServLog.e(string2, stringBuilder.toString());
                    return;
                }
            }
        }).start();
        return true;
    }

    public static boolean initAdapterClassByName(Activity activity, String string, JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object)jSONObject);
        return AerServSettings.initAdapterClassByName(activity, string, jSONArray);
    }

    private static void initAdapters(Activity activity) {
        JSONObject jSONObject = configJson.optJSONObject("adapterConfigurationLists");
        if (jSONObject == null) {
            AerServLog.w(LOG_TAG, "pre-init: Cannot initialize adapters because adapterConfigurationLists is missing in config response");
            return;
        }
        Iterator iterator = jSONObject.keys();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            AerServSettings.initAdapterClassByName(activity, string, jSONObject.optJSONArray(string));
        }
    }

    public static boolean isAnalyticsEnabled(String string) {
        AerServSettings.readConfig(string);
        Boolean bl = isAnalyticsEnabled;
        if (bl != null) {
            return bl;
        }
        return false;
    }

    public static boolean isAnalyticsEventEnabled(String string, String string2, String string3) {
        JSONArray jSONArray;
        AerServSettings.readConfig(string);
        if (!AerServSettings.isAnalyticsEnabled(string)) {
            return false;
        }
        JSONObject jSONObject = configJson.optJSONObject("analytics");
        if (jSONObject != null && (jSONArray = jSONObject.optJSONArray("disabledEvents")) != null) {
            for (int i2 = 0; i2 < jSONArray.length(); ++i2) {
                JSONObject jSONObject2 = jSONArray.optJSONObject(i2);
                String string4 = jSONObject2.optString("category", "");
                String string5 = jSONObject2.optString("action", "");
                if (!string4.equals((Object)string2) || !string5.equals((Object)string3)) continue;
                return false;
            }
        }
        return true;
    }

    public static boolean isInitDone() {
        return STATE.get() == 4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void parseConfigJson() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (configJson.has("analytics") && (jSONObject2 = configJson.optJSONObject("analytics")) != null) {
            try {
                isAnalyticsEnabled = jSONObject2.getBoolean("enabled");
            }
            catch (JSONException jSONException) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("pre-init: Error reading analytics enabled setting: ");
                stringBuilder.append(jSONException.getMessage());
                AerServLog.w(string, stringBuilder.toString());
            }
        }
        if ((jSONObject = configJson.optJSONObject("centralLogging")) != null) {
            try {
                centralLoggingEnabled = jSONObject.getBoolean("enabled");
            }
            catch (JSONException jSONException) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("pre-init: Error reading Central Logging enabled setting: ");
                stringBuilder.append(jSONException.getMessage());
                AerServLog.w(string, stringBuilder.toString());
            }
            try {
                centralLoggingLineCount = jSONObject.getInt("lineCount");
            }
            catch (JSONException jSONException) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("pre-init: Error reading Central Logging line count setting: ");
                stringBuilder.append(jSONException.getMessage());
                AerServLog.w(string, stringBuilder.toString());
            }
            try {
                centralLoggingSendStackTrace = jSONObject.getBoolean("sendStackTrace");
            }
            catch (JSONException jSONException) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("pre-init: Error reading Central Logging send stack trace setting: ");
                stringBuilder.append(jSONException.getMessage());
                AerServLog.w(string, stringBuilder.toString());
            }
        }
        if (configJson.has("timeouts")) {
            try {
                JSONObject jSONObject3 = configJson.getJSONObject("timeouts");
                step1Timeout = jSONObject3.optInt("step1", 3000);
                step2Timeout = jSONObject3.optInt("step2", 6000);
                step3Timeout = jSONObject3.optInt("step3", 11000);
                step4Timeout = jSONObject3.optInt("step4", 8000);
            }
            catch (JSONException jSONException) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("pre-init: Error reading timeouts: ");
                stringBuilder.append(jSONException.getMessage());
                AerServLog.w(string, stringBuilder.toString());
            }
        }
        if (configJson.has(HTTP_TIMEOUT_KEY)) {
            httpTimeout = Math.min((int)step3Timeout, (int)configJson.optInt(HTTP_TIMEOUT_KEY, httpTimeout));
        }
        try {
            JSONObject jSONObject4 = configJson.optJSONObject("adapterConfigurationLists");
            if (jSONObject4 != null) {
                Iterator iterator = jSONObject4.keys();
                while (iterator.hasNext()) {
                    int n2;
                    JSONArray jSONArray = jSONObject4.optJSONArray((String)iterator.next());
                    if (jSONArray == null) continue;
                    for (int i2 = 0; i2 < (n2 = jSONArray.length()); ++i2) {
                        try {
                            Asplc.putAsplc(jSONArray.getJSONObject(i2));
                            continue;
                        }
                        catch (JSONException jSONException) {
                            String string = LOG_TAG;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("pre-init: Exception initializing asplc: ");
                            stringBuilder.append(jSONException.getMessage());
                            AerServLog.w(string, stringBuilder.toString());
                        }
                    }
                }
            }
        }
        catch (Throwable throwable) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("pre-init: Exception initializing asplc ");
            stringBuilder.append(throwable.getMessage());
            AerServLog.e(string, stringBuilder.toString());
        }
        if (configJson.has("ad")) {
            try {
                JSONObject jSONObject5 = configJson.getJSONObject("ad");
                if (jSONObject5.has("refreshEnabled")) {
                    AdapterAdRefresher.setEnableFlag(jSONObject5.getBoolean("refreshEnabled"));
                }
                if (jSONObject5.has("adCacheExpiration")) {
                    AdapterAdRefresher.setSleepTimeInMilliseconds(jSONObject5.getLong("adCacheExpiration"));
                }
            }
            catch (JSONException jSONException) {
                String string = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("pre-init: Error reading ad: ");
                stringBuilder.append(jSONException.getMessage());
                AerServLog.w(string, stringBuilder.toString());
            }
        }
        Asplc.setLimit(configJson);
    }

    public static JSONObject readConfig(String string) {
        if (!TextUtils.isEmpty((CharSequence)siteId)) {
            // empty if block
        }
        if (STATE.compareAndSet(0, 1)) {
            AerServLog.d(LOG_TAG, "pre-init: start pre-init from old entry point");
            AerServSettings.start(null, null, string);
        }
        return configJson;
    }

    private static void setApplicationId(Activity activity) {
        try {
            applicationId = activity.getPackageManager().getPackageInfo((String)activity.getPackageName(), (int)0).packageName;
            return;
        }
        catch (Exception exception) {
            String string = LOG_TAG;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("pre-init: Exception setting applicatioon ID: ");
            stringBuilder.append(exception.getMessage());
            AerServLog.i(string, stringBuilder.toString());
            return;
        }
    }

    private static void start(Activity activity, String string, String string2) {
        AerServLog.d(LOG_TAG, "pre-init: start");
        System.setProperty((String)"http.keepAlive", (String)"false");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        int[] arrn = new int[]{0};
        PreInitProxy preInitProxy = new PreInitProxy();
        preInitProxy.fetchConfig(string, string2, (HttpTaskListener)new 2(arrn, activity, countDownLatch));
        try {
            countDownLatch.await((long)AerServSettings.getInitTimeout(), TimeUnit.MILLISECONDS);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        if (countDownLatch.getCount() > 0L || arrn[0] == 10001) {
            preInitProxy.cancel();
            AerServLog.w(LOG_TAG, "pre-init: server call time is up. Need to continue executing.");
            SybokProxy.sendTimeoutLogSybok((Context)activity, "", 0, 5000, string2);
        }
        if ((countDownLatch.getCount() > 0L || arrn[0] == 10001 || arrn[0] == 0) && configJson == null) {
            int n2 = RETRY_COUNTDOWN.get();
            if (n2 == 0) {
                if (STATE.compareAndSet(1, 2)) {
                    configJson = new JSONObject();
                    return;
                }
            } else if (RETRY_COUNTDOWN.compareAndSet(n2, n2 - 1)) {
                STATE.compareAndSet(1, 0);
            }
        }
    }

}

