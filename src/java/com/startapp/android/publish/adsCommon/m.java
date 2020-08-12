/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.util.Log
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  com.startapp.android.publish.ads.b.e
 *  com.startapp.android.publish.adsCommon.BaseRequest
 *  com.startapp.android.publish.adsCommon.StartAppAd
 *  com.startapp.android.publish.adsCommon.activities.FullScreenActivity
 *  com.startapp.android.publish.adsCommon.f.b
 *  com.startapp.android.publish.adsCommon.j
 *  com.startapp.android.publish.adsCommon.m$1
 *  com.startapp.android.publish.common.metaData.MetaDataRequest
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassNotFoundException
 *  java.lang.Deprecated
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.reflect.Field
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.TreeMap
 */
package com.startapp.android.publish.adsCommon;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.startapp.android.publish.ads.splash.SplashConfig;
import com.startapp.android.publish.adsCommon.AdsConstants;
import com.startapp.android.publish.adsCommon.BaseRequest;
import com.startapp.android.publish.adsCommon.SDKAdPreferences;
import com.startapp.android.publish.adsCommon.StartAppAd;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.a.e;
import com.startapp.android.publish.adsCommon.activities.FullScreenActivity;
import com.startapp.android.publish.adsCommon.b;
import com.startapp.android.publish.adsCommon.c;
import com.startapp.android.publish.adsCommon.f;
import com.startapp.android.publish.adsCommon.f.d;
import com.startapp.android.publish.adsCommon.g;
import com.startapp.android.publish.adsCommon.j;
import com.startapp.android.publish.adsCommon.k;
import com.startapp.android.publish.adsCommon.l;
import com.startapp.android.publish.adsCommon.m;
import com.startapp.android.publish.cache.ACMConfig;
import com.startapp.android.publish.common.metaData.MetaData;
import com.startapp.android.publish.common.metaData.MetaDataRequest;
import com.startapp.android.publish.common.model.AdPreferences;
import com.startapp.common.Constants;
import com.startapp.common.g;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class m {
    private ServiceConnection A;
    private SDKAdPreferences a;
    private boolean b = i.a(512L);
    private boolean c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private long g;
    private Application h = null;
    private HashMap<Integer, Integer> i = new HashMap();
    private Object j;
    private Activity k;
    private boolean l = false;
    private String m;
    private boolean n = false;
    private boolean o = true;
    private boolean p = false;
    private boolean q = false;
    private Map<String, String> r;
    private Bundle s = null;
    private com.startapp.android.publish.cache.c t = null;
    private boolean u;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private g y = null;
    private boolean z = false;

    private m() {
    }

    public static m a() {
        return a.a;
    }

    @TargetApi(value=14)
    public static Object a(Application application) {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks(){

            public void onActivityCreated(Activity activity, Bundle bundle) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onActivityCreated [");
                stringBuilder.append(activity.getClass().getName());
                stringBuilder.append(", ");
                stringBuilder.append((Object)bundle);
                stringBuilder.append("]");
                com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder.toString());
                m.a().a(activity, bundle);
                if (i.a(2L)) {
                    f.a().a(activity, bundle);
                }
            }

            public void onActivityDestroyed(Activity activity) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onActivityDestroyed [");
                stringBuilder.append(activity.getClass().getName());
                stringBuilder.append("]");
                com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder.toString());
                m.a().e(activity);
            }

            public void onActivityPaused(Activity activity) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onActivityPaused [");
                stringBuilder.append(activity.getClass().getName());
                stringBuilder.append("]");
                com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder.toString());
                m.a().c(activity);
            }

            public void onActivityResumed(Activity activity) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onActivityResumed [");
                stringBuilder.append(activity.getClass().getName());
                stringBuilder.append("]");
                com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder.toString());
                m.a().b(activity);
            }

            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onActivitySaveInstanceState [");
                stringBuilder.append(activity.getClass().getName());
                stringBuilder.append("]");
                com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder.toString());
                m.a().b(activity, bundle);
            }

            public void onActivityStarted(Activity activity) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onActivityStarted [");
                stringBuilder.append(activity.getClass().getName());
                stringBuilder.append("]");
                com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder.toString());
                m.a().a(activity);
            }

            public void onActivityStopped(Activity activity) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onActivityStopped [");
                stringBuilder.append(activity.getClass().getName());
                stringBuilder.append("]");
                com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder.toString());
                m.a().d(activity);
            }
        };
        application.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        return activityLifecycleCallbacks;
    }

    @TargetApi(value=14)
    public static void a(Application application, Object object) {
        application.unregisterActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)object);
    }

    private void a(final Context context, long l2) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable(){

            public void run() {
                try {
                    WebView webView = new WebView(context);
                    k.b(context, "User-Agent", webView.getSettings().getUserAgentString());
                    return;
                }
                catch (Exception exception) {
                    com.startapp.android.publish.adsCommon.f.f.a(context, d.b, "NetworkUtils.saveUserAgent - Webview failed", exception.getMessage(), "");
                    return;
                }
            }
        }, l2);
    }

    private void a(Context context, AdPreferences adPreferences) {
        if (this.h() && !b.a().y()) {
            this.t = com.startapp.android.publish.cache.a.a().a(context, adPreferences);
        }
    }

    private void a(Context context, boolean bl) {
        this.g(false);
        this.f(false);
        if (com.startapp.common.a.c.b() && i.a(2L)) {
            this.g(bl);
            this.f(true);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Return Ads: [");
            stringBuilder.append(bl);
            stringBuilder.append("]");
            com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder.toString());
            return;
        }
        com.startapp.common.a.g.a("StartAppSDKInternal", 6, "Cannot activate return interstitials, cache to disk, ttl reload - api lower than 14");
    }

    static /* synthetic */ void a(m m2, Context context, long l2) {
        m2.a(context, l2);
    }

    /*
     * Exception decompiling
     */
    private static boolean a(Context var0, Intent var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl51 : ICONST_0 : trying to set 1 previously set to 0
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

    static /* synthetic */ boolean a(m m2) {
        return m2.z;
    }

    static /* synthetic */ boolean a(m m2, boolean bl) {
        m2.z = bl;
        return bl;
    }

    private void b(Context context, String string, String string2) {
        boolean bl;
        boolean bl2 = k.a(context, string2, false);
        if (bl2 != (bl = com.startapp.common.a.c.a(context, string))) {
            k.b(context, string2, bl);
            this.a(context, string, System.currentTimeMillis(), bl, false);
        }
    }

    private void b(Context context, boolean bl) {
        k.b(context, "chromeTabs", bl);
    }

    private static boolean c(String string) {
        try {
            Class.forName((String)string);
            return true;
        }
        catch (ClassNotFoundException | Exception throwable) {
            return false;
        }
    }

    private static String d(String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".StartAppConstants");
            String string2 = (String)Class.forName((String)stringBuilder.toString()).getField("WRAPPER_VERSION").get(null);
            return string2;
        }
        catch (Exception exception) {
            return "0";
        }
    }

    private void f(Activity activity) {
        this.d = true;
        this.p((Context)activity);
        if (com.startapp.common.c.a() != null) {
            com.startapp.common.c.a().b((Context)activity);
        }
    }

    private void f(boolean bl) {
        this.c = bl;
    }

    private void g(Activity activity) {
        g g2;
        if (MetaData.getInstance().canShowAd() && this.h() && !b.a().y() && !i.a() && !this.c() && this.q() && (g2 = (this.y = com.startapp.android.publish.cache.a.a().a(this.t))) != null && g2.isReady()) {
            com.startapp.android.publish.adsCommon.a.f f2 = b.a().F().a(AdPreferences.Placement.INAPP_RETURN, null);
            if (f2.a()) {
                if (this.y.a(null)) {
                    com.startapp.android.publish.adsCommon.a.b.a().a(new com.startapp.android.publish.adsCommon.a.a(AdPreferences.Placement.INAPP_RETURN, null));
                }
            } else {
                c.a((Context)activity, ((com.startapp.android.publish.ads.b.e)this.y).l(), null, f2.c());
                if (Constants.a().booleanValue()) {
                    com.startapp.common.a.i.a().a((Context)activity, f2.b());
                }
            }
        }
        if (com.startapp.common.c.a() != null) {
            com.startapp.common.c.a().a((Context)activity);
        }
        if (this.r()) {
            this.a((Context)activity, MetaDataRequest.a.b);
        }
    }

    private void g(boolean bl) {
        this.u = bl;
    }

    private void j(Context context) {
        Boolean bl = false;
        k.b(context, "periodicInfoEventPaused", bl);
        k.b(context, "periodicMetadataPaused", bl);
        1 var3_3 = new 1(this, context);
        if (MetaData.getInstance().isReady()) {
            var3_3.a();
            return;
        }
        MetaData.getInstance().addMetaDataListener((com.startapp.android.publish.common.metaData.d)var3_3);
    }

    private void k(Context context) {
        MetaData.init(context);
        if (!i.a()) {
            b.a(context);
            if (i.a(16L) || i.a(32L)) {
                com.startapp.android.publish.ads.banner.c.a(context);
            }
            if (i.a(8L)) {
                com.startapp.android.publish.ads.splash.f.a(context);
            }
            if (this.b) {
                com.startapp.android.publish.cache.d.a(context);
            }
            if (i.e()) {
                com.startapp.android.publish.adsCommon.adinformation.a.a(context);
            }
        }
    }

    private void l(Context context) {
        Integer n2 = k.a(context, "shared_prefs_app_version_id", -1);
        int n3 = com.startapp.common.a.c.d(context);
        if (n2 > 0 && n3 > n2) {
            this.q = true;
        }
        k.b(context, "shared_prefs_app_version_id", n3);
    }

    private void m(Context context) {
        if (!this.q && com.startapp.android.publish.cache.d.a().b().isLocalCache()) {
            if (this.c) {
                com.startapp.android.publish.cache.a.a().a(context);
            }
        } else {
            com.startapp.common.a.g.a("StartAppSDKInternal", 3, "App version changed or disabled in meta - deleting existing cache");
            com.startapp.android.publish.cache.a.a().b(context);
        }
        this.p(context);
        com.startapp.android.publish.cache.a.a().c(context);
    }

    private void n(final Context context) {
        com.startapp.common.a.g.a("StartAppSDKInternal", 3, "Sending Download Event");
        com.startapp.common.g.a(g.a.a, new Runnable(){

            public void run() {
                try {
                    j j2 = new j(context);
                    AdPreferences adPreferences = new AdPreferences();
                    i.a(context, adPreferences);
                    j2.fillApplicationDetails(context, adPreferences);
                    com.startapp.android.publish.adsCommon.k.a.a(context, AdsConstants.a(AdsConstants.ServiceApiType.DOWNLOAD), (BaseRequest)j2, null);
                    return;
                }
                catch (Exception exception) {
                    com.startapp.common.a.g.a(6, "Error occured while sending download event", exception);
                    com.startapp.android.publish.adsCommon.f.f.a(context, d.b, "StartAppSDKInternal.sendDownloadEvent", exception.getMessage(), "");
                    return;
                }
            }
        });
    }

    private void o(Context context) {
        k.a(context, "sharedPrefsWrappers", this.r);
    }

    private void p(Context context) {
        this.a(context, new AdPreferences());
    }

    public static boolean p() {
        return m.a().a("Unity") != null;
    }

    private static void q(Context context) {
        TreeMap treeMap = new TreeMap();
        if (m.u()) {
            treeMap.put((Object)"Cordova", (Object)i.b());
        }
        if (m.s()) {
            treeMap.put((Object)"AdMob", (Object)m.d("com.startapp.android.mediation.admob"));
        }
        if (m.t()) {
            treeMap.put((Object)"MoPub", (Object)m.d("com.mopub.mobileads"));
        }
        if (m.v() && !m.a().o().containsKey((Object)"B4A")) {
            treeMap.put((Object)"MoPub", (Object)"0");
        }
        if (!treeMap.isEmpty()) {
            k.a(context, "sharedPrefsWrappers", (Map<String, String>)treeMap);
        }
    }

    private boolean q() {
        return System.currentTimeMillis() - this.g > b.a().x();
    }

    private void r(final Context context) {
        com.startapp.common.g.a(g.a.a, new Runnable(){

            public void run() {
                block4 : {
                    String string;
                    if (Build.VERSION.SDK_INT >= 18 && (string = m.s(context)) != null) {
                        m.this.A = new ServiceConnection(){

                            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                                m.this.b(context, true);
                                context.unbindService(m.this.A);
                            }

                            public void onServiceDisconnected(ComponentName componentName) {
                            }
                        };
                        try {
                            Intent intent = new Intent("android.support.customtabs.action.CustomTabsService");
                            intent.setPackage(string);
                            if (!context.bindService(intent, m.this.A, 33)) {
                                m.this.b(context, false);
                                return;
                            }
                            break block4;
                        }
                        catch (Exception exception) {
                            com.startapp.common.a.g.a("StartAppSDKInternal", 6, "failed to check checkChromeTabsSupport", exception);
                            m.this.b(context, false);
                            return;
                        }
                    }
                    m.this.b(context, false);
                }
            }

        });
    }

    private boolean r() {
        return System.currentTimeMillis() - this.g > MetaData.getInstance().getSessionMaxBackgroundTime();
    }

    /*
     * Exception decompiling
     */
    private static String s(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl109 : ACONST_NULL : trying to set 1 previously set to 0
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

    private static boolean s() {
        return m.c("com.startapp.android.mediation.admob.StartAppCustomEvent");
    }

    private static boolean t() {
        return m.c("com.mopub.mobileads.StartAppCustomEventInterstitial");
    }

    private static boolean u() {
        return m.c("org.apache.cordova.CordovaPlugin");
    }

    private static boolean v() {
        return m.c("anywheresoftware.b4a.BA");
    }

    public String a(String string) {
        Map<String, String> map = this.r;
        if (map == null) {
            return null;
        }
        return (String)map.get((Object)string);
    }

    public void a(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityStarted [");
        stringBuilder.append(activity.getClass().getName());
        stringBuilder.append("]");
        com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder.toString());
        if (!(!i.a(8L) || b.a().z() || this.w || this.b("MoPub") || this.b("AdMob") || this.x || !activity.getClass().getName().equals((Object)this.m) || this.i() || this.i.size() != 0)) {
            StartAppAd.showSplash((Activity)activity, (Bundle)this.s, (SplashConfig)new SplashConfig(), (AdPreferences)new AdPreferences(), null, (boolean)false);
        }
        this.x = true;
        if (this.d) {
            this.g(activity);
        }
        this.f = false;
        this.d = false;
        if ((Integer)this.i.get((Object)activity.hashCode()) == null) {
            Integer n2 = 1 + new Integer(0);
            this.i.put((Object)activity.hashCode(), (Object)n2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Activity Added:[");
            stringBuilder2.append(activity.getClass().getName());
            stringBuilder2.append("]");
            com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder2.toString());
            return;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Activity [");
        stringBuilder3.append(activity.getClass().getName());
        stringBuilder3.append("] already exists");
        com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder3.toString());
    }

    public void a(Activity activity, Bundle bundle) {
        if (bundle == null && this.m != null && activity.getClass().getName().equals((Object)this.m)) {
            this.l = false;
        }
        this.s = bundle;
    }

    void a(Context context) {
        k.b(context, "periodicInfoEventPaused", true);
        com.startapp.android.publish.adsCommon.Utils.b.a(786564404);
    }

    protected void a(Context context, MetaDataRequest.a a2) {
        com.startapp.android.publish.adsCommon.Utils.g.d().a(context, a2);
    }

    protected void a(Context context, String string, long l2, boolean bl, boolean bl2) {
        if (!TextUtils.isEmpty((CharSequence)string)) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "1";
            String string3 = bl ? string2 : "0";
            stringBuilder.append(string3);
            String string4 = bl2 ? "M" : "A";
            stringBuilder.append(string4);
            String string5 = stringBuilder.toString();
            com.startapp.android.publish.adsCommon.f.f.a(context, d.j, string, string5, "");
            if (string.toLowerCase().equals((Object)"pas")) {
                if (!bl) {
                    string2 = "0";
                }
                k.b(context, "USER_CONSENT_PERSONALIZED_ADS_SERVING", string2);
                com.startapp.android.publish.adsCommon.Utils.g.d().a(context, MetaDataRequest.a.f);
                return;
            }
        } else {
            com.startapp.common.a.g.a("StartAppSDKInternal", 6, "setUserConsent: empty consentType");
        }
    }

    public void a(Context context, String string, String string2) {
        if (this.r == null) {
            this.r = new TreeMap();
        }
        this.r.put((Object)string, (Object)string2);
        this.o(context);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected void a(Context var1_1, String var2_2, String var3_3, SDKAdPreferences var4_4, boolean var5_5) {
        var7_6 = i.a(2L);
        if (var7_6 && !i.a(var1_1, FullScreenActivity.class)) {
            Log.w((String)"StartAppSDKInternal", (String)"FullScreenActivity is missing from AndroidManifest.xml");
        }
        if (var1_1 instanceof Activity) {
            this.m = var1_1.getClass().getName();
        }
        var1_1 = var1_1.getApplicationContext();
        {
            catch (Exception var6_12) {
                com.startapp.android.publish.adsCommon.f.f.a(var1_1, d.b, "StartAppSDKInternal.intialize - unexpected error occurd", var6_12.getMessage(), "");
                return;
            }
        }
        try {
            com.startapp.android.publish.adsCommon.e.a.a(var1_1);
            ** GOTO lbl17
        }
        catch (Exception var8_7) {
            com.startapp.android.publish.adsCommon.f.f.a(var1_1, d.b, "init AdsExceptionHandler", var8_7.getMessage(), "");
lbl17: // 2 sources:
            var9_8 = i.f(var1_1) == false;
            this.b(var9_8);
            m.q(var1_1);
            l.a(var1_1);
            if (!this.l) {
                com.startapp.common.c.c(var1_1);
                com.startapp.android.publish.adsCommon.Utils.b.a(var1_1);
                this.k(var1_1);
                this.l = true;
                var10_9 = new StringBuilder();
                var10_9.append("Initialize StartAppSDK with DevID:[");
                var10_9.append(var2_2);
                var10_9.append("], AppID:[");
                var10_9.append(var3_3);
                var10_9.append("]");
                com.startapp.common.a.g.a("StartAppSDKInternal", 3, var10_9.toString());
                i.a(var1_1, var2_2, var3_3);
                this.a = var4_4;
                com.startapp.common.a.e.b(var1_1, "shared_prefs_sdk_ad_prefs", var4_4);
                com.startapp.common.d.a.b(var1_1);
                var16_10 = k.a(var1_1, "shared_prefs_first_init", true);
                var17_11 = new StringBuilder();
                var17_11.append("First Initialization: [");
                var17_11.append(var16_10);
                var17_11.append("]");
                com.startapp.common.a.g.a("StartAppSDKInternal", 3, var17_11.toString());
                if (var16_10) {
                    this.n(var1_1);
                    k.b(var1_1, "totalSessions", 0);
                    k.b(var1_1, "firstSessionTime", System.currentTimeMillis());
                    k.b(var1_1, "shared_prefs_first_init", false);
                }
                this.a(var1_1, MetaDataRequest.a.a);
                this.l(var1_1);
                this.a(var1_1, var5_5);
                if (this.b) {
                    this.m(var1_1);
                }
                this.r(var1_1);
            }
            this.j(var1_1);
            this.f(var1_1);
            return;
        }
    }

    public void a(boolean bl) {
        this.p = bl;
    }

    public boolean a(AdPreferences.Placement placement) {
        if (this.c) {
            if (this.f) {
                return false;
            }
            if (this.d) {
                AdPreferences.Placement placement2 = AdPreferences.Placement.INAPP_RETURN;
                boolean bl = false;
                if (placement == placement2) {
                    boolean bl2 = com.startapp.android.publish.cache.d.a().b().shouldReturnAdLoadInBg();
                    bl = false;
                    if (bl2) {
                        bl = true;
                    }
                }
                return bl;
            }
            return true;
        }
        return false;
    }

    public void b() {
        this.n = true;
        this.e = true;
    }

    public void b(Activity activity) {
        if (this.b && this.e) {
            this.e = false;
            com.startapp.android.publish.cache.a.a().b();
        }
        if (this.n) {
            this.n = false;
            l.c(activity.getApplicationContext());
        }
        this.k = activity;
    }

    public void b(Activity activity, Bundle bundle) {
    }

    void b(Context context) {
        k.b(context, "periodicMetadataPaused", true);
        com.startapp.android.publish.adsCommon.Utils.b.a(586482792);
    }

    public void b(boolean bl) {
        this.o = bl;
    }

    public boolean b(String string) {
        return this.a(string) != null;
    }

    public void c(Activity activity) {
        this.g = System.currentTimeMillis();
        this.k = null;
    }

    void c(Context context) {
        k.b(context, "periodicInfoEventPaused", false);
        com.startapp.android.publish.adsCommon.Utils.b.a(context, (long)k.a(context, "periodicInfoEventTriggerTime", com.startapp.android.publish.adsCommon.Utils.b.b(context)));
    }

    public void c(boolean bl) {
        this.v = bl;
    }

    public boolean c() {
        return this.p;
    }

    public void d(Activity activity) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onActivityStopped [");
        stringBuilder.append(activity.getClass().getName());
        stringBuilder.append("]");
        com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder.toString());
        Integer n2 = (Integer)this.i.get((Object)activity.hashCode());
        if (n2 != null) {
            Integer n3 = n2 - 1;
            if (n3 == 0) {
                this.i.remove((Object)activity.hashCode());
            } else {
                this.i.put((Object)activity.hashCode(), (Object)n3);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Activity removed:[");
            stringBuilder2.append(activity.getClass().getName());
            stringBuilder2.append("]");
            com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder2.toString());
            if (this.i.size() == 0) {
                if (!this.f) {
                    this.f(activity);
                }
                if (this.b) {
                    com.startapp.android.publish.cache.a.a().a(activity.getApplicationContext(), this.f);
                    this.e = true;
                    return;
                }
            }
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Activity hadn't been found:[");
            stringBuilder3.append(activity.getClass().getName());
            stringBuilder3.append("]");
            com.startapp.common.a.g.a("StartAppSDKInternal", 3, stringBuilder3.toString());
        }
    }

    void d(Context context) {
        k.b(context, "periodicMetadataPaused", false);
        com.startapp.android.publish.adsCommon.Utils.b.a(context, k.a(context, "periodicMetadataTriggerTime", com.startapp.android.publish.adsCommon.Utils.b.a()));
    }

    public void d(boolean bl) {
        this.w = bl ^ true;
        if (!bl) {
            com.startapp.android.publish.cache.a.a().a(AdPreferences.Placement.INAPP_SPLASH);
        }
    }

    public boolean d() {
        return this.o;
    }

    public void e(Activity activity) {
        if (activity.getClass().getName().equals((Object)this.m)) {
            this.x = false;
        }
        if (this.i.size() == 0) {
            this.d = false;
        }
    }

    void e(Context context) {
        com.startapp.android.publish.adsCommon.f.c c2 = new com.startapp.android.publish.adsCommon.f.c(context, false);
        c2.c().c(AdsConstants.j);
        c2.a();
        if (this.e()) {
            com.startapp.android.publish.adsCommon.f.f.a(context, d.d, "packagingType", AdsConstants.j, "");
        }
    }

    protected void e(boolean bl) {
        boolean bl2 = bl && com.startapp.common.a.c.b();
        this.g(bl2);
        if (!bl2) {
            com.startapp.android.publish.cache.a.a().a(AdPreferences.Placement.INAPP_RETURN);
        }
    }

    public boolean e() {
        return this.q;
    }

    /*
     * Exception decompiling
     */
    public void f(Context var1) {
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

    public boolean f() {
        Activity activity = this.k;
        if (activity != null) {
            return activity.isTaskRoot();
        }
        return true;
    }

    public SDKAdPreferences g(Context context) {
        if (this.a == null) {
            SDKAdPreferences sDKAdPreferences = com.startapp.common.a.e.a(context, "shared_prefs_sdk_ad_prefs", SDKAdPreferences.class);
            this.a = sDKAdPreferences == null ? new SDKAdPreferences() : sDKAdPreferences;
        }
        return this.a;
    }

    public String g() {
        return this.m;
    }

    public void h(Context context) {
        this.b(context, "android.permission.ACCESS_FINE_LOCATION", "USER_CONSENT_FINE_LOCATION");
        this.b(context, "android.permission.ACCESS_COARSE_LOCATION", "USER_CONSENT_COARSE_LOCATION");
    }

    public boolean h() {
        return this.u;
    }

    public boolean i() {
        return this.v;
    }

    @Deprecated
    public void j() {
        this.d(false);
    }

    public boolean k() {
        return true ^ this.w;
    }

    public boolean l() {
        return this.c && !this.d && !this.f;
    }

    public void m() {
        this.d = false;
        this.f = true;
    }

    public boolean n() {
        return this.c && this.d;
    }

    public Map<String, String> o() {
        return this.r;
    }

    private static class a {
        private static final m a = new m();
    }

}

