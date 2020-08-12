/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Bundle
 *  android.os.StrictMode
 *  android.os.StrictMode$ThreadPolicy
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.Window
 *  com.applovin.impl.sdk.AppLovinAdBase
 *  com.applovin.impl.sdk.AppLovinAdServiceImpl
 *  com.applovin.impl.sdk.ad.g
 *  com.applovin.impl.sdk.ad.h
 *  com.applovin.impl.sdk.m
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.reflect.Field
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.e;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.h;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.t;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public abstract class m {
    public static double a(long l2) {
        double d2 = l2;
        Double.isNaN((double)d2);
        return d2 / 1000.0;
    }

    public static float a(float f2) {
        return f2 * 1000.0f;
    }

    public static int a(JSONObject jSONObject) {
        int n2 = g.a(jSONObject, "video_completion_percent", -1, null);
        if (n2 >= 0 && n2 <= 100) {
            return n2;
        }
        return 95;
    }

    public static long a(com.applovin.impl.sdk.j j2) {
        long l2 = j2.a(b.eZ);
        long l3 = j2.a(b.fa);
        long l4 = System.currentTimeMillis();
        if (l2 > 0L && l3 > 0L) {
            l4 += l2 - l3;
        }
        return l4;
    }

    public static Activity a(View view, com.applovin.impl.sdk.j j2) {
        if (view == null) {
            return null;
        }
        for (int i2 = 0; i2 < 1000; ++i2) {
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity)context;
                }
                ViewParent viewParent = view.getParent();
                if (viewParent instanceof View) {
                    view = (View)viewParent;
                    continue;
                }
                return null;
            }
            catch (Throwable throwable) {
                j2.u().b("Utils", "Encountered error while retrieving activity from view", throwable);
                break;
            }
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    public static Bitmap a(Context var0, int var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl90 : ACONST_NULL : trying to set 0 previously set to 1
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

    /*
     * Exception decompiling
     */
    public static Bitmap a(File var0, int var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl121 : ALOAD : trying to set 1 previously set to 0
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

    public static View a(Context context, View view) {
        View view2 = m.f(context);
        if (view2 != null) {
            return view2;
        }
        return m.a(view);
    }

    public static View a(View view) {
        if (view == null) {
            return null;
        }
        View view2 = view.getRootView();
        if (view2 == null) {
            return null;
        }
        View view3 = view2.findViewById(16908290);
        if (view3 != null) {
            view2 = view3;
        }
        return view2;
    }

    public static d a(JSONObject jSONObject, com.applovin.impl.sdk.j j2) {
        return d.a(AppLovinAdSize.fromString(g.a(jSONObject, "ad_size", null, j2)), AppLovinAdType.fromString(g.a(jSONObject, "ad_type", null, j2)), g.a(jSONObject, "zone_id", null, j2), j2);
    }

    public static com.applovin.impl.sdk.j a(AppLovinSdk appLovinSdk) {
        try {
            Field field = appLovinSdk.getClass().getDeclaredField("mSdkImpl");
            field.setAccessible(true);
            com.applovin.impl.sdk.j j2 = (com.applovin.impl.sdk.j)field.get((Object)appLovinSdk);
            return j2;
        }
        catch (Throwable throwable) {
            throw new IllegalStateException("Internal error - unable to retrieve SDK implementation...");
        }
    }

    public static String a(Context context) {
        Bundle bundle = m.d(context);
        if (bundle != null) {
            String string2 = bundle.getString("applovin.sdk.key");
            if (string2 != null) {
                return string2;
            }
            return "";
        }
        return null;
    }

    public static String a(String string2) {
        if (string2 != null && string2.length() > 4) {
            return string2.substring(string2.length() - 4);
        }
        return "NOKEY";
    }

    public static String a(String string2, String string3) {
        if (string2 == null) {
            string2 = "";
        }
        return string3.replace((CharSequence)"{PLACEMENT}", (CharSequence)j.e(string2));
    }

    public static String a(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry entry : map.entrySet()) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("&");
                }
                stringBuilder.append(entry.getKey());
                stringBuilder.append('=');
                stringBuilder.append(entry.getValue());
            }
            return stringBuilder.toString();
        }
        return "";
    }

    public static Field a(Class class_, String string2) {
        try {
            Field field = class_.getDeclaredField(string2);
            return field;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            Class class_2 = class_.getSuperclass();
            if (class_2 == null) {
                return null;
            }
            return m.a(class_2, string2);
        }
    }

    public static List<a> a(String string2, JSONObject jSONObject, String string3, String string4, com.applovin.impl.sdk.j j2) {
        return m.a(string2, jSONObject, string3, null, string4, j2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static List<a> a(String string2, JSONObject jSONObject, String string3, String string4, String string5, com.applovin.impl.sdk.j j2) {
        JSONObject jSONObject2 = g.a(jSONObject, string2, new JSONObject(), j2);
        ArrayList arrayList = new ArrayList(1 + jSONObject2.length());
        if (j.b(string5)) {
            arrayList.add((Object)new a(string5, null));
        }
        if (jSONObject2.length() > 0) {
            if (string4 == null) {
                string4 = "";
            }
            Iterator iterator = jSONObject2.keys();
            while (iterator.hasNext()) {
                try {
                    String string6 = (String)iterator.next();
                    if (TextUtils.isEmpty((CharSequence)string6)) continue;
                    String string7 = jSONObject2.optString(string6);
                    boolean bl = TextUtils.isEmpty((CharSequence)string7);
                    if (!bl) {
                        string7 = string7.replace((CharSequence)"{CLCODE}", (CharSequence)string3).replace((CharSequence)"{EVENT_ID}", (CharSequence)string4);
                    }
                    arrayList.add((Object)new a(string6.replace((CharSequence)"{CLCODE}", (CharSequence)string3).replace((CharSequence)"{EVENT_ID}", (CharSequence)string4), string7));
                }
                catch (Throwable throwable) {
                    j2.u().b("Utils", "Failed to create and add postback url.", throwable);
                }
            }
        }
        return arrayList;
    }

    public static void a(AppLovinAdLoadListener appLovinAdLoadListener, d d2, int n2, com.applovin.impl.sdk.j j2) {
        if (appLovinAdLoadListener != null) {
            try {
                if (appLovinAdLoadListener instanceof com.applovin.impl.sdk.m) {
                    ((com.applovin.impl.sdk.m)appLovinAdLoadListener).a(d2, n2);
                    return;
                }
                appLovinAdLoadListener.failedToReceiveAd(n2);
                return;
            }
            catch (Throwable throwable) {
                j2.u().b("Utils", "Unable process a failure to receive an ad", throwable);
            }
        }
    }

    public static void a(String string2, Boolean bl, Map<String, String> map) {
        if (bl.booleanValue()) {
            map.put((Object)string2, (Object)Boolean.toString((boolean)true));
        }
    }

    public static void a(String string2, String string3, Map<String, String> map) {
        if (!TextUtils.isEmpty((CharSequence)string3)) {
            map.put((Object)string2, (Object)string3);
        }
    }

    public static boolean a() {
        Context context = com.applovin.impl.sdk.j.x();
        boolean bl = false;
        if (context != null) {
            Bundle bundle = m.d(context);
            bl = false;
            if (bundle != null) {
                boolean bl2 = bundle.containsKey("applovin.sdk.verbose_logging");
                bl = false;
                if (bl2) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    public static boolean a(long l2, long l3) {
        return (l2 & l3) != 0L;
    }

    public static boolean a(Context context, Uri uri, com.applovin.impl.sdk.j j2) {
        boolean bl;
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            j2.Q().b();
            context.startActivity(intent);
            bl = true;
        }
        catch (Throwable throwable) {
            p p2 = j2.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to open \"");
            stringBuilder.append((Object)uri);
            stringBuilder.append("\".");
            p2.b("Utils", stringBuilder.toString(), throwable);
            bl = false;
        }
        if (!bl) {
            j2.Q().c();
        }
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(View view, Activity activity) {
        View view2;
        if (activity == null) return false;
        if (view == null) {
            return false;
        }
        Window window = activity.getWindow();
        if (window != null) {
            view2 = window.getDecorView();
            do {
                return m.a(view, view2);
                break;
            } while (true);
        }
        View view3 = activity.findViewById(16908290);
        if (view3 == null) return false;
        view2 = view3.getRootView();
        return m.a(view, view2);
    }

    public static boolean a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup)view2;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); ++i2) {
                if (!m.a(view, viewGroup.getChildAt(i2))) continue;
                return true;
            }
        }
        return false;
    }

    public static boolean a(com.applovin.impl.sdk.ad.g g2, Context context, com.applovin.impl.sdk.j j2) {
        StrictMode.ThreadPolicy threadPolicy = StrictMode.allowThreadDiskReads();
        boolean bl = g2 != null && (g2.b() || g2.e() == null || j2.N().a(g2.e().getLastPathSegment(), context));
        StrictMode.setThreadPolicy((StrictMode.ThreadPolicy)threadPolicy);
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean a(AppLovinAd appLovinAd, com.applovin.impl.sdk.j j2) {
        block4 : {
            p p2;
            String string2;
            block3 : {
                block2 : {
                    if (appLovinAd != null) break block2;
                    p2 = j2.u();
                    string2 = "Failing ad display - ad is null.";
                    break block3;
                }
                if (f.a(j2.w(), j2) || j2.a(b.dQ).booleanValue()) break block4;
                p2 = j2.u();
                string2 = "Failing ad display due to no internet connection.";
            }
            p2.e("AppLovinSdk", string2);
            return false;
        }
        return true;
    }

    public static boolean a(String string2, List<String> list) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (!string2.startsWith((String)iterator.next())) continue;
            return true;
        }
        return false;
    }

    public static long b(float f2) {
        return m.c(m.a(f2));
    }

    public static MaxAdFormat b(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return null;
        }
        if (string2.equalsIgnoreCase("banner")) {
            return MaxAdFormat.BANNER;
        }
        if (string2.equalsIgnoreCase("mrec")) {
            return MaxAdFormat.MREC;
        }
        if (!string2.equalsIgnoreCase("leaderboard") && !string2.equalsIgnoreCase("leader")) {
            if (!string2.equalsIgnoreCase("interstitial") && !string2.equalsIgnoreCase("inter")) {
                if (!string2.equalsIgnoreCase("rewarded") && !string2.equalsIgnoreCase("reward")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unknown format: ");
                    stringBuilder.append(string2);
                    throw new IllegalArgumentException(stringBuilder.toString());
                }
                return MaxAdFormat.REWARDED;
            }
            return MaxAdFormat.INTERSTITIAL;
        }
        return MaxAdFormat.LEADER;
    }

    public static AppLovinAd b(AppLovinAd appLovinAd, com.applovin.impl.sdk.j j2) {
        if (appLovinAd instanceof h) {
            h h2 = (h)appLovinAd;
            AppLovinAd appLovinAd2 = j2.n().dequeueAd(h2.getAdZone());
            p p2 = j2.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Dequeued ad for dummy ad: ");
            stringBuilder.append((Object)appLovinAd2);
            p2.a("Utils", stringBuilder.toString());
            if (appLovinAd2 != null) {
                h2.a(appLovinAd2);
                ((AppLovinAdBase)appLovinAd2).setDummyAd(h2);
                return appLovinAd2;
            }
            if (j2.a(b.cd).booleanValue()) {
                return h2.a();
            }
            appLovinAd = null;
        }
        return appLovinAd;
    }

    public static boolean b(Context context) {
        if (context == null) {
            context = com.applovin.impl.sdk.j.x();
        }
        boolean bl = false;
        if (context != null) {
            Bundle bundle = m.d(context);
            bl = false;
            if (bundle != null) {
                boolean bl2 = bundle.getBoolean("applovin.sdk.test_ads", false);
                bl = false;
                if (bl2) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    private static long c(float f2) {
        return Math.round((float)f2);
    }

    public static String c(String string2) {
        Uri uri = Uri.parse((String)string2);
        return new Uri.Builder().scheme(uri.getScheme()).authority(uri.getAuthority()).path(uri.getPath()).build().toString();
    }

    public static boolean c(Context context) {
        if (context == null) {
            context = com.applovin.impl.sdk.j.x();
        }
        boolean bl = false;
        if (context != null) {
            Bundle bundle = m.d(context);
            bl = false;
            if (bundle != null) {
                boolean bl2 = bundle.getBoolean("applovin.sdk.verbose_logging", false);
                bl = false;
                if (bl2) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    public static Bundle d(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo((String)context.getPackageName(), (int)128).metaData;
            return bundle;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e((String)"Utils", (String)"Unable to retrieve application metadata", (Throwable)nameNotFoundException);
            return null;
        }
    }

    public static int e(Context context) {
        Configuration configuration;
        Resources resources;
        if (context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null) {
            return configuration.orientation;
        }
        return 0;
    }

    public static View f(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        return ((Activity)context).getWindow().getDecorView().findViewById(16908290);
    }
}

