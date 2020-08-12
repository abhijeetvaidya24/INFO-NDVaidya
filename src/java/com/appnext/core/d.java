/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.telephony.TelephonyManager
 *  android.util.Pair
 *  com.appnext.core.AppnextAd
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Locale
 *  java.util.Random
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.appnext.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.Pair;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.b;
import com.appnext.core.f;
import com.appnext.core.g;
import com.appnext.core.j;
import com.appnext.core.l;
import com.appnext.core.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d {
    private static final int fS = 50;
    protected final int fT = 0;
    protected final int fU = 1;
    protected final int fV = 2;
    protected final int fW = 3;
    private final HashMap<b, com.appnext.core.a> fX = new HashMap();

    protected static boolean Q(String string2) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(string2);
        }
        catch (Throwable throwable) {
            return true;
        }
        return jSONObject.has("rnd");
    }

    private long a(Ad ad, String string2) {
        return Long.valueOf((String)this.c(ad).get(string2));
    }

    private static AppnextAd a(AppnextAd appnextAd, AppnextAd appnextAd2) {
        if (appnextAd.getRevenueType().equals((Object)appnextAd2.getRevenueType())) {
            if (Float.parseFloat((String)appnextAd.getRevenueRate()) < Float.parseFloat((String)appnextAd2.getRevenueRate())) {
                return appnextAd2;
            }
            return appnextAd;
        }
        if (appnextAd.getRevenueType().equals((Object)"cpc")) {
            return appnextAd;
        }
        return appnextAd2;
    }

    static /* synthetic */ String a(d d2, Context context, Ad ad, String string2, ArrayList arrayList) {
        StringBuilder stringBuilder = new StringBuilder("https://global.appnext.com/offerWallApi.aspx?ext=t&pimp=1&igroup=sdk&m=1&osid=100&s2s=1&type=json&id=");
        stringBuilder.append(string2);
        stringBuilder.append("&cnt=50");
        stringBuilder.append("&tid=");
        String string3 = ad != null ? ad.getTID() : "301";
        stringBuilder.append(string3);
        stringBuilder.append("&vid=");
        String string4 = ad != null ? ad.getVID() : "2.5.0.472";
        stringBuilder.append(string4);
        stringBuilder.append("&cat=");
        String string5 = "";
        String string6 = ad != null ? ad.getCategories() : string5;
        stringBuilder.append(string6);
        stringBuilder.append("&pbk=");
        String string7 = ad != null ? ad.getPostback() : string5;
        stringBuilder.append(string7);
        stringBuilder.append("&did=");
        stringBuilder.append(f.b(context, Boolean.parseBoolean((String)d2.c(ad).get("didPrivacy"))));
        stringBuilder.append("&devn=");
        stringBuilder.append(f.bc());
        stringBuilder.append("&dosv=");
        stringBuilder.append(Build.VERSION.SDK_INT);
        stringBuilder.append("&dct=");
        stringBuilder.append(f.aa(f.o(context)));
        stringBuilder.append("&lang=");
        stringBuilder.append(Locale.getDefault().getLanguage());
        stringBuilder.append("&dcc=");
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String string8 = telephonyManager.getSimOperator();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string8.substring(0, 3));
            stringBuilder2.append("_");
            stringBuilder2.append(string8.substring(3));
            string5 = stringBuilder2.toString();
        }
        stringBuilder.append(string5);
        stringBuilder.append("&dds=0");
        stringBuilder.append("&packageId=");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("&g=");
        stringBuilder.append(d.j(context));
        stringBuilder.append("&rnd=");
        stringBuilder.append(new Random().nextInt());
        return stringBuilder.toString();
    }

    static /* synthetic */ HashMap a(d d2) {
        return d2.fX;
    }

    static /* synthetic */ void a(d d2, Context context, Ad ad, String string2, a a2, boolean bl) {
        d2.b(context, ad, string2, a2, bl);
    }

    protected static boolean a(String string2, String string3) {
        return j.bh().o(string2, string3);
    }

    protected static int aT() {
        return 8000;
    }

    private static AppnextAd b(ArrayList<AppnextAd> arrayList, AppnextAd appnextAd) {
        for (AppnextAd appnextAd2 : arrayList) {
            if (!appnextAd2.getAdPackage().equals((Object)appnextAd.getAdPackage())) continue;
            return appnextAd2;
        }
        return null;
    }

    private String b(Context context, Ad ad, String string2, ArrayList<Pair<String, String>> arrayList) {
        StringBuilder stringBuilder = new StringBuilder("https://global.appnext.com/offerWallApi.aspx?ext=t&pimp=1&igroup=sdk&m=1&osid=100&s2s=1&type=json&id=");
        stringBuilder.append(string2);
        stringBuilder.append("&cnt=50");
        stringBuilder.append("&tid=");
        String string3 = ad != null ? ad.getTID() : "301";
        stringBuilder.append(string3);
        stringBuilder.append("&vid=");
        String string4 = ad != null ? ad.getVID() : "2.5.0.472";
        stringBuilder.append(string4);
        stringBuilder.append("&cat=");
        String string5 = "";
        String string6 = ad != null ? ad.getCategories() : string5;
        stringBuilder.append(string6);
        stringBuilder.append("&pbk=");
        String string7 = ad != null ? ad.getPostback() : string5;
        stringBuilder.append(string7);
        stringBuilder.append("&did=");
        stringBuilder.append(f.b(context, Boolean.parseBoolean((String)this.c(ad).get("didPrivacy"))));
        stringBuilder.append("&devn=");
        stringBuilder.append(f.bc());
        stringBuilder.append("&dosv=");
        stringBuilder.append(Build.VERSION.SDK_INT);
        stringBuilder.append("&dct=");
        stringBuilder.append(f.aa(f.o(context)));
        stringBuilder.append("&lang=");
        stringBuilder.append(Locale.getDefault().getLanguage());
        stringBuilder.append("&dcc=");
        TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService("phone");
        if (telephonyManager.getSimState() == 5) {
            String string8 = telephonyManager.getSimOperator();
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string8.substring(0, 3));
            stringBuilder2.append("_");
            stringBuilder2.append(string8.substring(3));
            string5 = stringBuilder2.toString();
        }
        stringBuilder.append(string5);
        stringBuilder.append("&dds=0");
        stringBuilder.append("&packageId=");
        stringBuilder.append(context.getPackageName());
        stringBuilder.append("&g=");
        stringBuilder.append(d.j(context));
        stringBuilder.append("&rnd=");
        stringBuilder.append(new Random().nextInt());
        return stringBuilder.toString();
    }

    private void b(final Context context, final Ad ad, final String string2, final a a2, final boolean bl) {
        Thread thread = new Thread(){

            /*
             * Exception decompiling
             */
            public final void run() {
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
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        };
        thread.start();
    }

    public static String d(AppnextAd appnextAd) {
        return appnextAd.getAdJSON();
    }

    /*
     * Exception decompiling
     */
    @SuppressLint(value={"MissingPermission"})
    protected static int j(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl21.1 : ICONST_2 : trying to set 1 previously set to 0
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

    public static g parseAd(String string2) {
        AppnextAd appnextAd;
        block4 : {
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(string2);
                appnextAd = (AppnextAd)l.a(AppnextAd.class, jSONObject);
                if (appnextAd == null) break block4;
            }
            catch (Throwable throwable) {
                return null;
            }
            appnextAd.setAdJSON(jSONObject.toString());
            if (jSONObject.has("sid")) {
                appnextAd.setSession(jSONObject.getString("sid"));
            }
            if (!appnextAd.getStoreRating().equals((Object)"")) break block4;
            appnextAd.setStoreRating("0");
        }
        return appnextAd;
    }

    protected abstract int a(Context var1, g var2);

    protected abstract String a(Context var1, Ad var2, String var3, ArrayList<Pair<String, String>> var4);

    protected String a(ArrayList<AppnextAd> arrayList) {
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator iterator = arrayList.iterator();
            while (iterator.hasNext()) {
                jSONArray.put((Object)new JSONObject(((AppnextAd)iterator.next()).getAdJSON()));
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("apps", (Object)jSONArray);
            String string2 = jSONObject.toString().replace((CharSequence)"\u2028", (CharSequence)"\\u2028").replace((CharSequence)"\u2029", (CharSequence)"\\u2029");
            return string2;
        }
        catch (Throwable throwable) {
            return "";
        }
    }

    /*
     * Exception decompiling
     */
    protected final ArrayList<? extends g> a(Context var1, Ad var2, String var3, int var4) throws JSONException {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl121.1 : IINC : trying to set 1 previously set to 0
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

    protected abstract void a(Context var1, Ad var2, com.appnext.core.a var3) throws Exception;

    public final void a(Context context, Ad ad, String string2, a a2) {
        this.a(context, ad, string2, a2, true);
    }

    public final void a(final Context context, final Ad ad, final String string2, final a a2, final boolean bl) {
        Runnable runnable = new Runnable(){

            /*
             * Exception decompiling
             */
            public final void run() {
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
                // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
                // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        };
        new Thread(runnable).start();
    }

    protected final void a(Ad ad, com.appnext.core.a a2) {
        this.fX.put((Object)new b(ad), (Object)a2);
    }

    protected abstract void a(Ad var1, String var2, String var3);

    protected void a(String string2, Ad ad) {
        j.bh().n(string2, ad.getPlacementID());
    }

    protected abstract <T> void a(String var1, Ad var2, T var3);

    protected final void a(String string2, String string3, Ad ad) {
        this.a(string2, string3, ad, 2);
    }

    protected final void a(final String string2, final String string3, final Ad ad, final int n2) {
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable runnable = new Runnable(){

            public final void run() {
                com.appnext.core.a a2 = d.this.k(ad);
                if (a2 != null) {
                    if (a2.getAds() == null) {
                        a2.d(new ArrayList());
                    } else {
                        a2.d(a2.getAds());
                    }
                    a2.setState(n2);
                    a2.P(string2);
                    d d2 = d.this;
                    Ad ad2 = ad;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append(" ");
                    stringBuilder.append(string3);
                    d2.a(ad2, stringBuilder.toString(), a2.getPlacementID());
                }
            }
        };
        handler.post(runnable);
    }

    protected abstract boolean a(Context var1, Ad var2, ArrayList<?> var3);

    /*
     * Exception decompiling
     */
    protected boolean a(Ad var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl13.1 : ICONST_0 : trying to set 1 previously set to 0
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

    protected final HashMap<b, com.appnext.core.a> aU() {
        return this.fX;
    }

    protected final void b(String string2, Ad ad) {
        this.a(string2, "", ad);
    }

    protected abstract p c(Ad var1);

    public final void c(Context context, Ad ad, String string2) {
        this.fX.remove((Object)new b(ad));
        this.b(context, ad, string2, null, true);
    }

    protected final boolean h(Ad ad) {
        return this.fX != null && this.k(ad) != null && this.k(ad).getState() == 2 && this.k(ad).getAds() != null;
    }

    protected final boolean i(Ad ad) {
        if (this.j(ad) == 0L) {
            return this.fX != null && this.k(ad) != null && this.k(ad).getAds().size() == 0 && 60000L + this.k(ad).aS() > System.currentTimeMillis();
        }
        return this.fX != null && this.k(ad) != null && this.k(ad).aS() + this.j(ad) > System.currentTimeMillis();
    }

    protected final long j(Ad ad) {
        long l2;
        try {
            if (this.c(ad).get("_cachingRequest") == null) {
                return 60000L * this.a(ad, "ads_caching_time_minutes");
            }
            l2 = this.a(ad, "_cachingRequest");
        }
        catch (Throwable throwable) {
            return 60000L * this.a(ad, "ads_caching_time_minutes");
        }
        return l2 * 1000L;
    }

    protected final com.appnext.core.a k(Ad ad) {
        return (com.appnext.core.a)this.fX.get((Object)new b(ad));
    }

    public final String l(Ad ad) {
        return this.k(ad).A();
    }

    protected void l(String string2) {
        j.bh().ac(string2);
    }

    public static interface a {
        public <T> void a(T var1);

        public void error(String var1);
    }

}

