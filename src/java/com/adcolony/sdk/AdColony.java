/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Looper
 *  java.io.File
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.text.SimpleDateFormat
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Date
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.ExecutorService
 *  java.util.concurrent.Executors
 *  java.util.concurrent.RejectedExecutionException
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import com.adcolony.sdk.AdColonyAdOptions;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonyCustomMessageListener;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.adcolony.sdk.AdColonyRewardListener;
import com.adcolony.sdk.AdColonyZone;
import com.adcolony.sdk.a;
import com.adcolony.sdk.aa;
import com.adcolony.sdk.ad;
import com.adcolony.sdk.ae;
import com.adcolony.sdk.ag;
import com.adcolony.sdk.ah;
import com.adcolony.sdk.ai;
import com.adcolony.sdk.ap;
import com.adcolony.sdk.au;
import com.adcolony.sdk.aw;
import com.adcolony.sdk.b;
import com.adcolony.sdk.d;
import com.adcolony.sdk.l;
import com.adcolony.sdk.n;
import com.adcolony.sdk.w;
import com.adcolony.sdk.y;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import org.json.JSONArray;
import org.json.JSONObject;

public class AdColony {
    static ExecutorService a = Executors.newSingleThreadExecutor();

    static void a(Context context, AdColonyAppOptions adColonyAppOptions) {
        if (adColonyAppOptions != null) {
            if (context == null) {
                return;
            }
            String string = au.b(context);
            String string2 = au.b();
            int n2 = au.c();
            String string3 = a.a().c.h();
            String string4 = a.a().o().a() ? "wifi" : (a.a().o().b() ? "mobile" : "none");
            HashMap hashMap = new HashMap();
            hashMap.put((Object)"sessionId", (Object)"unknown");
            hashMap.put((Object)"advertiserId", (Object)"unknown");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Locale.getDefault().getDisplayLanguage());
            stringBuilder.append(" (");
            stringBuilder.append(Locale.getDefault().getDisplayCountry());
            stringBuilder.append(")");
            hashMap.put((Object)"countryLocale", (Object)stringBuilder.toString());
            hashMap.put((Object)"countryLocalShort", (Object)a.a().c.u());
            hashMap.put((Object)"manufacturer", (Object)a.a().c.w());
            hashMap.put((Object)"model", (Object)a.a().c.x());
            hashMap.put((Object)"osVersion", (Object)a.a().c.y());
            hashMap.put((Object)"carrierName", (Object)string3);
            hashMap.put((Object)"networkType", (Object)string4);
            hashMap.put((Object)"platform", (Object)"android");
            hashMap.put((Object)"appName", (Object)string);
            hashMap.put((Object)"appVersion", (Object)string2);
            hashMap.put((Object)"appBuildNumber", (Object)n2);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(adColonyAppOptions.a());
            hashMap.put((Object)"appId", (Object)stringBuilder2.toString());
            hashMap.put((Object)"apiLevel", (Object)Build.VERSION.SDK_INT);
            hashMap.put((Object)"sdkVersion", (Object)a.a().c.D());
            hashMap.put((Object)"controllerVersion", (Object)"unknown");
            hashMap.put((Object)"zoneIds", (Object)adColonyAppOptions.c());
            JSONObject jSONObject = adColonyAppOptions.getMediationInfo();
            JSONObject jSONObject2 = adColonyAppOptions.getPluginInfo();
            if (!w.b(jSONObject, "mediation_network").equals((Object)"")) {
                hashMap.put((Object)"mediationNetwork", (Object)w.b(jSONObject, "mediation_network"));
                hashMap.put((Object)"mediationNetworkVersion", (Object)w.b(jSONObject, "mediation_network_version"));
            }
            if (!w.b(jSONObject2, "plugin").equals((Object)"")) {
                hashMap.put((Object)"plugin", (Object)w.b(jSONObject2, "plugin"));
                hashMap.put((Object)"pluginVersion", (Object)w.b(jSONObject2, "plugin_version"));
            }
            aa.a((HashMap<String, Object>)hashMap);
        }
    }

    /*
     * Exception decompiling
     */
    static boolean a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl8 : ALOAD_1 : trying to set 1 previously set to 0
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

    private static /* varargs */ boolean a(Context context, AdColonyAppOptions adColonyAppOptions, String string, String ... arrstring) {
        if (ai.a(0, null)) {
            new y.a().a("Cannot configure AdColony; configuration mechanism requires 5 ").a("seconds between attempts.").a(y.e);
            return false;
        }
        if (context == null) {
            context = a.c();
        }
        if (context == null) {
            new y.a().a("Ignoring call to AdColony.configure() as the provided Activity or ").a("Application context is null and we do not currently hold a ").a("reference to either for our use.").a(y.e);
            return false;
        }
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        if (adColonyAppOptions == null) {
            adColonyAppOptions = new AdColonyAppOptions();
        }
        if (a.b() && !w.d(a.a().d().d(), "reconfigurable")) {
            l l2 = a.a();
            if (!l2.d().a().equals((Object)string)) {
                new y.a().a("Ignoring call to AdColony.configure() as the app id does not ").a("match what was used during the initial configuration.").a(y.e);
                return false;
            }
            if (au.a(arrstring, l2.d().b())) {
                new y.a().a("Ignoring call to AdColony.configure() as the same zone ids ").a("were used during the previous configuration.").a(y.e);
                return false;
            }
        }
        adColonyAppOptions.a(string);
        adColonyAppOptions.a(arrstring);
        adColonyAppOptions.f();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS", Locale.US);
        long l3 = System.currentTimeMillis();
        String string2 = simpleDateFormat.format(new Date(l3));
        boolean bl = true;
        for (int i2 = 0; i2 < arrstring.length; ++i2) {
            if (arrstring[i2] == null || arrstring[i2].equals((Object)"")) continue;
            bl = false;
        }
        if (!string.equals((Object)"") && !bl) {
            a.a = true;
            if (Build.VERSION.SDK_INT < 14) {
                new y.a().a("The minimum API level for the AdColony SDK is 14.").a(y.e);
                a.a(context, adColonyAppOptions, true);
            } else {
                a.a(context, adColonyAppOptions, false);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a.a().n().c());
            stringBuilder.append("/adc3/AppInfo");
            String string3 = stringBuilder.toString();
            JSONObject jSONObject = w.a();
            if (new File(string3).exists()) {
                jSONObject = w.c(string3);
            }
            JSONObject jSONObject2 = w.a();
            if (w.b(jSONObject, "appId").equals((Object)string)) {
                w.a(jSONObject2, "zoneIds", w.a(w.g(jSONObject, "zoneIds"), arrstring, true));
                w.a(jSONObject2, "appId", string);
            } else {
                w.a(jSONObject2, "zoneIds", w.a(arrstring));
                w.a(jSONObject2, "appId", string);
            }
            w.h(jSONObject2, string3);
            y.a a2 = new y.a().a("Configure: Total Time (ms): ");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(System.currentTimeMillis() - l3);
            y.a a3 = a2.a(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(" and started at ");
            stringBuilder3.append(string2);
            a3.a(stringBuilder3.toString()).a(y.f);
            return true;
        }
        new y.a().a("AdColony.configure() called with an empty app or zone id String.").a(y.g);
        return false;
    }

    static boolean a(final AdColonyInterstitialListener adColonyInterstitialListener, final String string) {
        if (adColonyInterstitialListener != null && a.d()) {
            au.a(new Runnable(){

                public void run() {
                    AdColonyZone adColonyZone = (AdColonyZone)a.a().f().get((Object)string);
                    if (adColonyZone == null) {
                        adColonyZone = new AdColonyZone(string);
                    }
                    adColonyInterstitialListener.onRequestNotFilled(adColonyZone);
                }
            });
        }
        return false;
    }

    public static boolean addCustomMessageListener(AdColonyCustomMessageListener adColonyCustomMessageListener, final String string) {
        if (!a.e()) {
            new y.a().a("Ignoring call to AdColony.addCustomMessageListener as AdColony ").a("has not yet been configured.").a(y.e);
            return false;
        }
        if (!au.d(string)) {
            new y.a().a("Ignoring call to AdColony.addCustomMessageListener.").a(y.e);
            return false;
        }
        try {
            a.a().z().put((Object)string, (Object)adColonyCustomMessageListener);
            a.execute(new Runnable(){

                public void run() {
                    AdColony.a();
                    JSONObject jSONObject = w.a();
                    w.a(jSONObject, "type", string);
                    new ad("CustomMessage.register", 1, jSONObject).b();
                }
            });
            return true;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            return false;
        }
    }

    static void b() {
        new y.a().a("The AdColony API is not available while AdColony is disabled.").a(y.g);
    }

    public static /* varargs */ boolean configure(Activity activity, AdColonyAppOptions adColonyAppOptions, String string, String ... arrstring) {
        return AdColony.a((Context)activity, adColonyAppOptions, string, arrstring);
    }

    public static /* varargs */ boolean configure(Activity activity, String string, String ... arrstring) {
        return AdColony.a((Context)activity, null, string, arrstring);
    }

    public static boolean disable() {
        if (!a.e()) {
            return false;
        }
        Context context = a.c();
        if (context != null && context instanceof b) {
            ((Activity)context).finish();
        }
        final l l2 = a.a();
        Iterator iterator = l2.l().c().values().iterator();
        while (iterator.hasNext()) {
            au.a(new Runnable((AdColonyInterstitial)iterator.next()){
                final /* synthetic */ AdColonyInterstitial a;
                {
                    this.a = adColonyInterstitial;
                }

                public void run() {
                    AdColonyInterstitialListener adColonyInterstitialListener = this.a.getListener();
                    this.a.a(true);
                    if (adColonyInterstitialListener != null) {
                        adColonyInterstitialListener.onExpiring(this.a);
                    }
                }
            });
        }
        au.a(new Runnable(){

            public void run() {
                ArrayList arrayList = new ArrayList();
                Iterator iterator = l2.p().c().iterator();
                while (iterator.hasNext()) {
                    arrayList.add((Object)((ag)iterator.next()));
                }
                for (ag ag2 : arrayList) {
                    aw aw2;
                    l2.a(ag2.a());
                    if (!(ag2 instanceof aw) || (aw2 = (aw)ag2).h()) continue;
                    aw2.loadUrl("about:blank");
                    aw2.clearCache(true);
                    aw2.removeAllViews();
                    aw2.a(true);
                }
            }
        });
        a.a().a(true);
        return true;
    }

    public static AdColonyAppOptions getAppOptions() {
        if (!a.e()) {
            return null;
        }
        return a.a().d();
    }

    public static boolean removeCustomMessageListener(final String string) {
        if (!a.e()) {
            new y.a().a("Ignoring call to AdColony.removeCustomMessageListener as AdColony").a(" has not yet been configured.").a(y.e);
            return false;
        }
        a.a().z().remove((Object)string);
        a.execute(new Runnable(){

            public void run() {
                AdColony.a();
                JSONObject jSONObject = w.a();
                w.a(jSONObject, "type", string);
                new ad("CustomMessage.unregister", 1, jSONObject).b();
            }
        });
        return true;
    }

    public static boolean removeRewardListener() {
        if (!a.e()) {
            new y.a().a("Ignoring call to AdColony.removeRewardListener() as AdColony has ").a("not yet been configured.").a(y.e);
            return false;
        }
        a.a().a((AdColonyRewardListener)null);
        return true;
    }

    public static boolean requestInterstitial(String string, AdColonyInterstitialListener adColonyInterstitialListener) {
        return AdColony.requestInterstitial(string, adColonyInterstitialListener, null);
    }

    public static boolean requestInterstitial(final String string, final AdColonyInterstitialListener adColonyInterstitialListener, final AdColonyAdOptions adColonyAdOptions) {
        if (!a.e()) {
            new y.a().a("Ignoring call to AdColony.requestInterstitial as AdColony has not").a(" yet been configured.").a(y.e);
            adColonyInterstitialListener.onRequestNotFilled(new AdColonyZone(string));
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString("zone_id", string);
        if (ai.a(1, bundle)) {
            AdColonyZone adColonyZone = (AdColonyZone)a.a().f().get((Object)string);
            if (adColonyZone == null) {
                adColonyZone = new AdColonyZone(string);
                y.a a2 = new y.a().a("Zone info for ");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string);
                stringBuilder.append(" doesn't exist in hashmap");
                a2.a(stringBuilder.toString()).a(y.b);
            }
            adColonyInterstitialListener.onRequestNotFilled(adColonyZone);
            return false;
        }
        Runnable runnable = new Runnable(){

            public void run() {
                l l2 = a.a();
                if (!l2.g() && !l2.h()) {
                    if (!AdColony.a() && a.d()) {
                        AdColony.a(adColonyInterstitialListener, string);
                        return;
                    }
                    final AdColonyZone adColonyZone = (AdColonyZone)l2.f().get((Object)string);
                    if (adColonyZone == null) {
                        adColonyZone = new AdColonyZone(string);
                        y.a a2 = new y.a().a("Zone info for ");
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(string);
                        stringBuilder.append(" doesn't exist in hashmap");
                        a2.a(stringBuilder.toString()).a(y.b);
                    }
                    if (adColonyZone.getZoneType() != 2) {
                        l2.l().a(string, adColonyInterstitialListener, adColonyAdOptions);
                        return;
                    }
                    au.a(new Runnable(){

                        public void run() {
                            adColonyInterstitialListener.onRequestNotFilled(adColonyZone);
                        }
                    });
                    return;
                }
                AdColony.b();
                AdColony.a(adColonyInterstitialListener, string);
            }

        };
        try {
            a.execute(runnable);
            return true;
        }
        catch (RejectedExecutionException rejectedExecutionException) {
            AdColony.a(adColonyInterstitialListener, string);
            return false;
        }
    }

    public static boolean setRewardListener(AdColonyRewardListener adColonyRewardListener) {
        if (!a.e()) {
            new y.a().a("Ignoring call to AdColony.setRewardListener() as AdColony has not").a(" yet been configured.").a(y.e);
            return false;
        }
        a.a().a(adColonyRewardListener);
        return true;
    }

}

