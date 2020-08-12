/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.chartboost.sdk.i
 *  com.chartboost.sdk.impl.o
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collections
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.chartboost.sdk.Model;

import android.os.Build;
import com.chartboost.sdk.Libraries.b;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
    public final boolean A;
    public final int B;
    public final boolean C;
    public final int D;
    public final boolean E;
    public final String F;
    public final String G;
    public final String H;
    public final String I;
    public final boolean J;
    public final boolean K;
    public final boolean L;
    public final String a;
    public final boolean b;
    public final boolean c;
    public final List<String> d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final long s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final List<String> x;
    public final boolean y;
    public final boolean z;

    public e(JSONObject jSONObject) {
        boolean bl;
        JSONObject jSONObject2;
        boolean bl2;
        this.a = jSONObject.optString("configVariant");
        this.b = jSONObject.optBoolean("prefetchDisable");
        this.c = jSONObject.optBoolean("publisherDisable");
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = jSONObject.optJSONArray("invalidateFolderList");
        if (jSONArray != null) {
            int n2 = jSONArray.length();
            for (int i2 = 0; i2 < n2; ++i2) {
                String string2 = jSONArray.optString(i2);
                if (string2.isEmpty()) continue;
                arrayList.add((Object)string2);
            }
        }
        this.d = Collections.unmodifiableList((List)arrayList);
        JSONObject jSONObject3 = jSONObject.optJSONObject("native");
        if (jSONObject3 == null) {
            jSONObject3 = new JSONObject();
        }
        this.e = jSONObject3.optBoolean("enabled", true);
        this.f = jSONObject3.optBoolean("inplayEnabled", true);
        this.g = jSONObject3.optBoolean("interstitialEnabled", true);
        this.h = jSONObject3.optBoolean("lockOrientation");
        this.i = jSONObject3.optInt("prefetchSession", 3);
        this.j = jSONObject3.optBoolean("rewardVideoEnabled", true);
        JSONObject jSONObject4 = jSONObject.optJSONObject("trackingLevels");
        if (jSONObject4 == null) {
            jSONObject4 = new JSONObject();
        }
        this.k = jSONObject4.optBoolean("critical", true);
        this.r = jSONObject4.optBoolean("includeStackTrace", true);
        this.l = jSONObject4.optBoolean("error");
        this.m = jSONObject4.optBoolean("debug");
        this.n = jSONObject4.optBoolean("session");
        this.o = jSONObject4.optBoolean("system");
        this.p = jSONObject4.optBoolean("timing");
        this.q = jSONObject4.optBoolean("user");
        this.s = jSONObject.optLong("getAdRetryBaseMs", b.b);
        this.t = jSONObject.optInt("getAdRetryMaxBackoffExponent", 5);
        JSONObject jSONObject5 = jSONObject.optJSONObject("webview");
        if (jSONObject5 == null) {
            jSONObject5 = new JSONObject();
        }
        boolean bl3 = !"Amazon".equalsIgnoreCase(Build.MANUFACTURER) || Build.VERSION.SDK_INT >= 21;
        this.u = jSONObject5.optInt("cacheMaxBytes", 104857600);
        int n3 = 10;
        int n4 = jSONObject5.optInt("cacheMaxUnits", n3);
        if (n4 > 0) {
            n3 = n4;
        }
        this.v = n3;
        this.w = (int)TimeUnit.SECONDS.toDays((long)jSONObject5.optInt("cacheTTLs", b.a));
        ArrayList arrayList2 = new ArrayList();
        JSONArray jSONArray2 = jSONObject5.optJSONArray("directories");
        if (jSONArray2 != null) {
            int n5 = jSONArray2.length();
            for (int i3 = 0; i3 < n5; ++i3) {
                String string3 = jSONArray2.optString(i3);
                if (string3.isEmpty()) continue;
                arrayList2.add((Object)string3);
            }
        }
        this.x = Collections.unmodifiableList((List)arrayList2);
        boolean bl4 = bl3 && jSONObject5.optBoolean("enabled", e.a());
        this.y = bl4;
        this.z = jSONObject5.optBoolean("inplayEnabled", true);
        this.A = jSONObject5.optBoolean("interstitialEnabled", true);
        int n6 = jSONObject5.optInt("invalidatePendingImpression", 3);
        if (n6 <= 0) {
            n6 = 3;
        }
        this.B = n6;
        this.C = jSONObject5.optBoolean("lockOrientation", true);
        this.D = jSONObject5.optInt("prefetchSession", 3);
        this.E = jSONObject5.optBoolean("rewardVideoEnabled", true);
        this.F = jSONObject5.optString("version", "v2");
        Object[] arrobject = new Object[]{"webview", this.F, "/interstitial/get"};
        this.G = String.format((String)"%s/%s%s", (Object[])arrobject);
        Object[] arrobject2 = new Object[]{"webview", this.F, "prefetch"};
        this.H = String.format((String)"%s/%s/%s", (Object[])arrobject2);
        Object[] arrobject3 = new Object[]{"webview", this.F, "/reward/get"};
        this.I = String.format((String)"%s/%s%s", (Object[])arrobject3);
        ArrayList arrayList3 = new ArrayList();
        boolean bl5 = true ^ i.x;
        boolean bl6 = true ^ i.x;
        JSONObject jSONObject6 = jSONObject.optJSONObject("certificationProviders");
        if (jSONObject6 != null && (jSONObject2 = jSONObject6.optJSONObject("moat")) != null) {
            arrayList3.add((Object)"moat");
            bl2 = jSONObject2.optBoolean("loggingEnabled", false);
            bl5 = jSONObject2.optBoolean("locationEnabled", true ^ i.x);
            bl = jSONObject2.optBoolean("idfaCollectionEnabled", true ^ i.x);
        } else {
            bl = bl6;
            bl2 = false;
        }
        this.J = bl2;
        this.K = bl5;
        this.L = bl;
        o.a((List)arrayList3);
    }

    /*
     * Exception decompiling
     */
    private static boolean a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl71.1 : ICONST_0 : trying to set 0 previously set to 1
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
}

