/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  com.applovin.impl.sdk.AppLovinAdServiceImpl
 *  com.applovin.impl.sdk.NativeAdServiceImpl
 *  com.applovin.impl.sdk.VariableServiceImpl
 *  com.applovin.impl.sdk.network.PostbackServiceImpl
 *  com.applovin.sdk.AppLovinSdk$a
 *  java.lang.Boolean
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Map
 */
package com.applovin.sdk;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.NativeAdServiceImpl;
import com.applovin.impl.sdk.VariableServiceImpl;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.p;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinEventService;
import com.applovin.sdk.AppLovinPostbackService;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinUserService;
import com.applovin.sdk.AppLovinVariableService;
import java.util.HashMap;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public final class AppLovinSdk {
    private static final String TAG = "AppLovinSdk";
    public static final String VERSION = "9.2.1";
    public static final int VERSION_CODE = 90201;
    private static AppLovinSdk[] sdkInstances;
    private static final Object sdkInstancesLock;
    private final j mSdkImpl;

    static {
        sdkInstances = new AppLovinSdk[0];
        sdkInstancesLock = new Object();
    }

    private AppLovinSdk(j j2) {
        if (j2 != null) {
            this.mSdkImpl = j2;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public static AppLovinSdk getInstance(Context context) {
        return AppLovinSdk.getInstance((AppLovinSdkSettings)new /* Unavailable Anonymous Inner Class!! */, context);
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context != null) {
            return AppLovinSdk.getInstance(m.a(context), appLovinSdkSettings, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AppLovinSdk getInstance(String string2, AppLovinSdkSettings appLovinSdkSettings, Context context) {
        Object object;
        if (appLovinSdkSettings == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("No userSettings specified");
            throw illegalArgumentException;
        }
        if (context == null) throw new IllegalArgumentException("No context specified");
        Object object2 = object = sdkInstancesLock;
        synchronized (object2) {
            AppLovinSdk appLovinSdk;
            if (sdkInstances.length == 1 && sdkInstances[0].getSdkKey().equals((Object)string2)) {
                return sdkInstances[0];
            }
            for (AppLovinSdk appLovinSdk2 : sdkInstances) {
                if (!appLovinSdk2.getSdkKey().equals((Object)string2)) continue;
                return appLovinSdk2;
            }
            try {
                j j2 = new j();
                j2.a(string2, appLovinSdkSettings, context);
                appLovinSdk = new AppLovinSdk(j2);
                j2.a(appLovinSdk);
            }
            catch (Throwable throwable) {
                Log.e((String)TAG, (String)"Failed to build AppLovin SDK. Try cleaning application data and starting the application again.", (Throwable)throwable);
                throw new RuntimeException("Unable to build AppLovin SDK");
            }
            AppLovinSdk[] arrappLovinSdk = new AppLovinSdk[1 + sdkInstances.length];
            System.arraycopy((Object)sdkInstances, (int)0, (Object)arrappLovinSdk, (int)0, (int)sdkInstances.length);
            arrappLovinSdk[AppLovinSdk.sdkInstances.length] = appLovinSdk;
            sdkInstances = arrappLovinSdk;
            return appLovinSdk;
        }
    }

    public static void initializeSdk(Context context) {
        AppLovinSdk.initializeSdk(context, null);
    }

    public static void initializeSdk(Context context, SdkInitializationListener sdkInitializationListener) {
        if (context != null) {
            AppLovinSdk appLovinSdk = AppLovinSdk.getInstance(context);
            if (appLovinSdk != null) {
                appLovinSdk.initializeSdk(sdkInitializationListener);
                return;
            }
            Log.e((String)TAG, (String)"Unable to initialize AppLovin SDK: SDK object not created");
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    static void reinitializeAll() {
        AppLovinSdk.reinitializeAll(null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void reinitializeAll(Boolean bl) {
        Object object;
        Object object2 = object = sdkInstancesLock;
        synchronized (object2) {
            AppLovinSdk[] arrappLovinSdk = sdkInstances;
            int n2 = arrappLovinSdk.length;
            int n3 = 0;
            while (n3 < n2) {
                AppLovinSdk appLovinSdk = arrappLovinSdk[n3];
                appLovinSdk.mSdkImpl.b();
                if (bl != null && bl.booleanValue()) {
                    HashMap hashMap = new HashMap(1);
                    hashMap.put((Object)"value", (Object)bl.toString());
                    appLovinSdk.getEventService().trackEvent("huc", (Map<String, String>)hashMap);
                }
                ++n3;
            }
            return;
        }
    }

    public AppLovinAdService getAdService() {
        return this.mSdkImpl.n();
    }

    Context getApplicationContext() {
        return this.mSdkImpl.w();
    }

    public AppLovinEventService getEventService() {
        return this.mSdkImpl.p();
    }

    public p getLogger() {
        return this.mSdkImpl.u();
    }

    public String getMediationProvider() {
        return this.mSdkImpl.m();
    }

    public AppLovinNativeAdService getNativeAdService() {
        return this.mSdkImpl.o();
    }

    public AppLovinPostbackService getPostbackService() {
        return this.mSdkImpl.J();
    }

    public String getSdkKey() {
        return this.mSdkImpl.s();
    }

    public AppLovinSdkSettings getSettings() {
        return this.mSdkImpl.l();
    }

    public String getUserIdentifier() {
        return this.mSdkImpl.k();
    }

    public AppLovinUserService getUserService() {
        return this.mSdkImpl.q();
    }

    public AppLovinVariableService getVariableService() {
        return this.mSdkImpl.r();
    }

    public boolean hasCriticalErrors() {
        return this.mSdkImpl.t();
    }

    public void initializeSdk() {
    }

    public void initializeSdk(SdkInitializationListener sdkInitializationListener) {
        this.mSdkImpl.a(sdkInitializationListener);
    }

    public boolean isEnabled() {
        return this.mSdkImpl.d();
    }

    public void setMediationProvider(String string2) {
        this.mSdkImpl.c(string2);
    }

    public void setPluginVersion(String string2) {
        this.mSdkImpl.a(string2);
    }

    public void setUserIdentifier(String string2) {
        this.mSdkImpl.b(string2);
    }

    public static interface SdkInitializationListener {
        public void onSdkInitialized(AppLovinSdkConfiguration var1);
    }

}

