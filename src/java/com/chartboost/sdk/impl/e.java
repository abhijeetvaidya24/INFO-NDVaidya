/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.os.Handler
 *  com.chartboost.sdk.Tracking.a
 *  com.chartboost.sdk.impl.aj
 *  com.chartboost.sdk.impl.am
 *  com.chartboost.sdk.impl.d
 *  com.chartboost.sdk.impl.e$1
 *  com.chartboost.sdk.impl.e$2
 *  com.chartboost.sdk.impl.g
 *  java.io.File
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Collection
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  java.util.SortedSet
 *  java.util.TreeSet
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.ScheduledFuture
 *  java.util.concurrent.TimeUnit
 *  java.util.concurrent.atomic.AtomicInteger
 *  java.util.concurrent.atomic.AtomicReference
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import android.os.Handler;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Model.b;
import com.chartboost.sdk.c;
import com.chartboost.sdk.i;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.ah;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.aj;
import com.chartboost.sdk.impl.ak;
import com.chartboost.sdk.impl.al;
import com.chartboost.sdk.impl.am;
import com.chartboost.sdk.impl.ap;
import com.chartboost.sdk.impl.c;
import com.chartboost.sdk.impl.d;
import com.chartboost.sdk.impl.e;
import com.chartboost.sdk.impl.f;
import com.chartboost.sdk.impl.g;
import com.chartboost.sdk.impl.h;
import com.chartboost.sdk.impl.l;
import com.chartboost.sdk.impl.n;
import com.chartboost.sdk.impl.o;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {
    private final long A = TimeUnit.SECONDS.toNanos(1L);
    private final String[] B = new String[]{"ASKED_TO_CACHE", "ASKED_TO_SHOW", "REQUESTING_TO_CACHE", "REQUESTING_TO_SHOW", "DOWNLOADING_TO_CACHE", "DOWNLOADING_TO_SHOW", "READY", "ASKING_UI_TO_SHOW_AD", "DONE"};
    final ScheduledExecutorService a;
    public final com.chartboost.sdk.Libraries.f b;
    final com.chartboost.sdk.Libraries.i c;
    final Handler d;
    final com.chartboost.sdk.c e;
    final c f;
    int g = 0;
    final Map<String, f> h;
    final SortedSet<f> i;
    final SortedSet<f> j;
    ScheduledFuture<?> k;
    private final l l;
    private final ah m;
    private final ai n;
    private final ap o;
    private final AtomicReference<com.chartboost.sdk.Model.e> p;
    private final SharedPreferences q;
    private final com.chartboost.sdk.Tracking.a r;
    private final ak s;
    private final com.chartboost.sdk.d t;
    private final al u;
    private int v;
    private boolean w;
    private final Map<String, Long> x;
    private final Map<String, Integer> y;
    private final long z = TimeUnit.SECONDS.toNanos(5L);

    public e(c c2, ScheduledExecutorService scheduledExecutorService, l l2, com.chartboost.sdk.Libraries.f f2, ah ah2, ai ai2, ap ap2, AtomicReference<com.chartboost.sdk.Model.e> atomicReference, SharedPreferences sharedPreferences, com.chartboost.sdk.Libraries.i i2, com.chartboost.sdk.Tracking.a a2, Handler handler, com.chartboost.sdk.c c3, ak ak2, com.chartboost.sdk.d d2, al al2) {
        this.a = scheduledExecutorService;
        this.l = l2;
        this.b = f2;
        this.m = ah2;
        this.n = ai2;
        this.o = ap2;
        this.p = atomicReference;
        this.q = sharedPreferences;
        this.c = i2;
        this.r = a2;
        this.d = handler;
        this.e = c3;
        this.s = ak2;
        this.t = d2;
        this.u = al2;
        this.f = c2;
        this.v = 1;
        this.h = new HashMap();
        this.j = new TreeSet();
        this.i = new TreeSet();
        this.x = new HashMap();
        this.y = new HashMap();
        this.w = false;
    }

    private com.chartboost.sdk.Model.c a(f f2, String string) {
        com.chartboost.sdk.Model.c c2 = new com.chartboost.sdk.Model.c(f2.d, (com.chartboost.sdk.Model.d)new d(this, f2), this.b, this.m, this.o, this.q, this.r, this.d, this.e, this.s, this.t, this.u, this.f, f2.b, string);
        return c2;
    }

    private String a(com.chartboost.sdk.Model.a a2, File file) {
        if (a2.r == null) {
            CBLogging.b("AdUnitManager", "AdUnit does not have a template body");
            return null;
        }
        File file2 = a2.r.a(file);
        HashMap hashMap = new HashMap();
        hashMap.putAll(a2.d);
        hashMap.put((Object)"{% certification_providers %}", (Object)o.a(a2.s));
        for (Map.Entry entry : a2.c.entrySet()) {
            hashMap.put(entry.getKey(), (Object)((b)entry.getValue()).b);
        }
        try {
            String string = n.a(file2, (Map<String, String>)hashMap);
            return string;
        }
        catch (Exception exception) {
            com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"loadTemplateHtml", (Exception)exception);
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(f f2, int n2, String string) {
        try {
            aj aj2;
            com.chartboost.sdk.Model.e e2 = (com.chartboost.sdk.Model.e)this.p.get();
            boolean bl = this.f.a == 2;
            boolean bl2 = e2.y && !bl;
            long l2 = this.c.b();
            1 var10_8 = new 1(this, f2, l2, bl, bl2);
            int n3 = f2.c;
            boolean bl3 = n3 == 2;
            if (bl) {
                String string2 = this.f.d;
                ap ap2 = this.o;
                com.chartboost.sdk.Tracking.a a2 = this.r;
                aj2 = new aj(string2, ap2, a2, n2, (aj.a)var10_8);
                aj2.l = true;
                aj2.a("location", (Object)f2.b);
                aj2.a("cache", (Object)bl3);
                aj2.a("raw", (Object)true);
                f2.e = 0;
            } else if (bl2) {
                String string3 = this.f.e;
                Object[] arrobject = new Object[]{e2.F};
                String string4 = String.format((String)string3, (Object[])arrobject);
                ap ap3 = this.o;
                com.chartboost.sdk.Tracking.a a3 = this.r;
                aj2 = new am(string4, ap3, a3, n2, (aj.a)var10_8);
                aj2.a("cache_assets", (Object)this.b.c(), 0);
                aj2.a("location", (Object)f2.b, 0);
                aj2.a("cache", (Object)bl3, 0);
                aj2.l = true;
                f2.e = 1;
            } else {
                String string5 = this.f.d;
                ap ap4 = this.o;
                com.chartboost.sdk.Tracking.a a4 = this.r;
                aj2 = new aj(string5, ap4, a4, n2, (aj.a)var10_8);
                aj2.a("local-videos", (Object)this.b.b());
                aj2.l = true;
                aj2.a("location", (Object)f2.b);
                aj2.a("cache", (Object)bl3);
                f2.e = 0;
            }
            aj2.j = 1;
            this.g = 2;
            this.m.a(aj2);
            this.r.a(this.f.a(f2.e), string, f2.b);
            return;
        }
        catch (Exception exception) {
            com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"sendAdGetRequest", (Exception)exception);
            this.a(f2, new CBError(CBError.a.a, "error sending ad-get request"));
            return;
        }
    }

    private boolean a(com.chartboost.sdk.Model.a a2) {
        File file = this.b.d().a;
        for (b b2 : a2.c.values()) {
            if (b2.a(file).exists()) continue;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Asset does not exist: ");
            stringBuilder.append(b2.b);
            CBLogging.b("AdUnitManager", stringBuilder.toString());
            return false;
        }
        return true;
    }

    private boolean a(SortedSet<f> sortedSet, int n2, int n3, int n4, String string) {
        Iterator iterator = sortedSet.iterator();
        while (iterator.hasNext()) {
            f f2 = (f)iterator.next();
            if (f2.c == n2 && f2.d == null) {
                if (this.e(f2.b)) continue;
                if (!this.f.g(f2.b)) {
                    f2.c = 8;
                    this.h.remove((Object)f2.b);
                    iterator.remove();
                    continue;
                }
                f2.c = n3;
                iterator.remove();
                this.a(f2, n4, string);
                return true;
            }
            iterator.remove();
        }
        return false;
    }

    private void b(f f2, CBError.CBImpressionError cBImpressionError) {
        String string;
        int n2;
        String[] arrstring;
        Handler handler = this.d;
        c c2 = this.f;
        c2.getClass();
        handler.post((Runnable)c2.new c.a(4, f2.b, cBImpressionError));
        if (cBImpressionError == CBError.CBImpressionError.NO_AD_FOUND) {
            return;
        }
        String string2 = f2.d != null ? f2.d.f : null;
        String string3 = f2.c != 0 && f2.c != 2 && f2.c != 4 ? "show" : "cache";
        String string4 = string3;
        int n3 = f2.d != null ? f2.d.b : f2.e;
        Integer n4 = n3;
        String string5 = null;
        if (n4 != null) {
            string5 = n4 == 0 ? "native" : "web";
        }
        String string6 = string5;
        if (f2.c >= 0 && (n2 = f2.c) < (arrstring = this.B).length) {
            string = arrstring[f2.c];
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown state: ");
            stringBuilder.append(f2.c);
            string = stringBuilder.toString();
        }
        String string7 = string;
        this.r.a(this.f.b, string4, string6, cBImpressionError.toString(), string2, f2.b, string7);
    }

    private void b(f f2, String string) {
        String string2;
        String[] arrstring;
        int n2;
        if (!((com.chartboost.sdk.Model.e)this.p.get()).p) {
            return;
        }
        String string3 = f2.d != null ? f2.d.f : null;
        String string4 = f2.c != 0 && f2.c != 2 && f2.c != 4 ? "show" : "cache";
        String string5 = string4;
        Integer n3 = f2.d != null ? Integer.valueOf((int)f2.d.b) : f2.e;
        String string6 = null;
        if (n3 != null) {
            string6 = n3 == 0 ? "native" : "web";
        }
        String string7 = string6;
        if (f2.c >= 0 && (n2 = f2.c) < (arrstring = this.B).length) {
            string2 = arrstring[f2.c];
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown state: ");
            stringBuilder.append(f2.c);
            string2 = stringBuilder.toString();
        }
        e.a[] arra = new e.a[]{com.chartboost.sdk.Libraries.e.a("adGetRequestSubmitToCallbackMs", (Object)f2.p), com.chartboost.sdk.Libraries.e.a("downloadRequestToCompletionMs", (Object)f2.n), com.chartboost.sdk.Libraries.e.a("downloadAccumulatedProcessingMs", (Object)f2.o), com.chartboost.sdk.Libraries.e.a("adGetRequestGetResponseCodeMs", (Object)f2.q), com.chartboost.sdk.Libraries.e.a("adGetRequestReadDataMs", (Object)f2.r), com.chartboost.sdk.Libraries.e.a("cacheRequestToReadyMs", (Object)f2.k), com.chartboost.sdk.Libraries.e.a("showRequestToReadyMs", (Object)f2.l), com.chartboost.sdk.Libraries.e.a("showRequestToShownMs", (Object)f2.m), com.chartboost.sdk.Libraries.e.a("adId", (Object)string3), com.chartboost.sdk.Libraries.e.a("location", (Object)f2.b), com.chartboost.sdk.Libraries.e.a("state", (Object)string2)};
        JSONObject jSONObject = com.chartboost.sdk.Libraries.e.a(arra);
        this.r.a(string, this.f.b, string5, string7, null, null, jSONObject, false);
    }

    private void c() {
        Long l2;
        ScheduledFuture<?> scheduledFuture;
        int n2 = this.g;
        int n3 = 1;
        if (n2 == n3) {
            long l3 = this.c.b();
            Iterator iterator = this.x.entrySet().iterator();
            l2 = null;
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                String string = (String)entry.getKey();
                if ((f)this.h.get((Object)string) == null) continue;
                long l4 = (Long)entry.getValue();
                long l5 = Math.max((long)this.z, (long)(l4 - l3));
                if (l2 != null && l5 >= l2) continue;
                l2 = l5;
            }
        } else {
            l2 = null;
        }
        if (l2 != null && this.k != null) {
            if (Math.abs((long)(l2 - this.k.getDelay(TimeUnit.NANOSECONDS))) > TimeUnit.SECONDS.toNanos(5L)) {
                n3 = 0;
            }
            if (n3 != 0) {
                return;
            }
        }
        if ((scheduledFuture = this.k) != null) {
            scheduledFuture.cancel(false);
            this.k = null;
        }
        if (l2 != null) {
            ScheduledExecutorService scheduledExecutorService = this.a;
            a a2 = new a(2, null, null, null);
            this.k = scheduledExecutorService.schedule((Runnable)a2, l2.longValue(), TimeUnit.NANOSECONDS);
        }
    }

    private void c(f f2) {
        if (f2.d != null) {
            if (f2.c != 5 && f2.c != 4) {
                return;
            }
            int n2 = f2.c == 5 ? 1 : 2;
            if (f2.g <= n2) {
                return;
            }
            2 var3_3 = new 2(this, f2);
            f2.g = n2;
            this.l.a(n2, f2.d.c, new AtomicInteger(), (h)com.chartboost.sdk.g.a().a(var3_3));
        }
    }

    private void d() {
        long l2 = this.c.b();
        Iterator iterator = this.x.values().iterator();
        while (iterator.hasNext()) {
            if (l2 - (Long)iterator.next() < 0L) continue;
            iterator.remove();
        }
    }

    private void d(f f2) {
        int n2 = f2.c;
        long l2 = this.c.b();
        if (f2.h != null) {
            f2.k = (int)TimeUnit.NANOSECONDS.toMillis(l2 - f2.h);
        }
        if (f2.i != null) {
            f2.l = (int)TimeUnit.NANOSECONDS.toMillis(l2 - f2.i);
        }
        this.b(f2, "ad-unit-cached");
        f2.c = 6;
        if (f2.f) {
            Handler handler = this.d;
            c c2 = this.f;
            c2.getClass();
            handler.post((Runnable)c2.new c.a(0, f2.b, null));
        }
        if (n2 == 5) {
            this.h(f2);
        }
    }

    private void e(f f2) {
        this.b(f2, CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
        this.f(f2);
        this.g(f2);
    }

    private boolean e() {
        if (this.f.a != 0) {
            return false;
        }
        if (i.u) {
            return false;
        }
        int n2 = this.q.getInt("cbPrefSessionCount", 0);
        boolean bl = false;
        if (n2 == 1) {
            bl = true;
        }
        return bl;
    }

    private boolean e(String string) {
        return this.x.containsKey((Object)string);
    }

    private void f(f f2) {
        this.h.remove((Object)f2.b);
        f2.c = 8;
        f2.d = null;
    }

    private void g(f f2) {
        com.chartboost.sdk.Model.e e2 = (com.chartboost.sdk.Model.e)this.p.get();
        long l2 = e2.s;
        int n2 = e2.t;
        Integer n3 = (Integer)this.y.get((Object)f2.b);
        if (n3 == null) {
            n3 = 0;
        }
        Integer n4 = Math.min((int)n3, (int)n2);
        this.y.put((Object)f2.b, (Object)(1 + n4));
        long l3 = TimeUnit.MILLISECONDS.toNanos(l2 << n4);
        this.x.put((Object)f2.b, (Object)(l3 + this.c.b()));
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h(f f2) {
        CBError.CBImpressionError cBImpressionError;
        com.chartboost.sdk.Model.c c2;
        block14 : {
            File file;
            com.chartboost.sdk.Model.a a2;
            block13 : {
                block12 : {
                    if (!this.n.b()) {
                        Handler handler = this.d;
                        c c3 = this.f;
                        c3.getClass();
                        handler.post((Runnable)c3.new c.a(4, f2.b, CBError.CBImpressionError.INTERNET_UNAVAILABLE_AT_SHOW));
                        return;
                    }
                    c2 = null;
                    try {
                        a2 = f2.d;
                        file = this.b.d().a;
                        int n2 = a2.b;
                        if (n2 != 0 || !this.f.g && !a2.p.equals((Object)"video")) break block12;
                        cBImpressionError = this.a(a2.a);
                        if (cBImpressionError != null) {
                            CBLogging.b("AdUnitManager", "Video media unavailable for the impression");
                        }
                        break block13;
                    }
                    catch (Exception exception) {
                        com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"showReady", (Exception)exception);
                        cBImpressionError = CBError.CBImpressionError.INTERNAL;
                        break block14;
                    }
                }
                cBImpressionError = null;
            }
            if (cBImpressionError == null) {
                for (b b2 : a2.c.values()) {
                    if (b2.a(file).exists()) continue;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Asset does not exist: ");
                    stringBuilder.append(b2.b);
                    CBLogging.b("AdUnitManager", stringBuilder.toString());
                    cBImpressionError = CBError.CBImpressionError.ASSET_MISSING;
                }
            }
            c2 = null;
            if (cBImpressionError == null) {
                String string;
                if (a2.b == 1) {
                    string = this.a(a2, file);
                    if (string == null) {
                        cBImpressionError = CBError.CBImpressionError.ERROR_LOADING_WEB_VIEW;
                    }
                } else {
                    string = null;
                }
                c2 = null;
                if (cBImpressionError == null) {
                    c2 = this.a(f2, string);
                }
            }
        }
        if (cBImpressionError == null) {
            f2.c = 7;
            com.chartboost.sdk.c c4 = this.e;
            c4.getClass();
            Runnable runnable = new Runnable(10){
                public final int a;
                android.app.Activity b = null;
                boolean c = false;
                public com.chartboost.sdk.Model.c d = null;
                {
                    this.a = n2;
                }

                /*
                 * Exception decompiling
                 */
                public void run() {
                    // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
                    // org.benf.cfr.reader.util.ConfusedCFRException: Extractable last case doesn't follow previous
                    // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:478)
                    // org.benf.cfr.reader.b.a.a.b.as.a(SwitchReplacer.java:328)
                    // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:462)
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
            runnable.d = c2;
            f2.j = this.c.b();
            this.d.post(runnable);
            return;
        }
        this.b(f2, cBImpressionError);
        this.f(f2);
    }

    private void i(f f2) {
        g g2 = new g(this, f2.b);
        aj aj2 = new aj(this.f.f, this.o, this.r, 2, (aj.a)g2);
        aj2.j = 1;
        aj2.a("cached", (Object)"0");
        String string = f2.d.f;
        if (!string.isEmpty()) {
            aj2.a("ad_id", (Object)string);
        }
        aj2.a("location", (Object)f2.b);
        this.m.a(aj2);
        this.r.b(this.f.a(f2.d.b), f2.b, string);
    }

    CBError.CBImpressionError a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return CBError.CBImpressionError.INVALID_RESPONSE;
        }
        JSONObject jSONObject2 = jSONObject.optJSONObject("assets");
        if (jSONObject2 == null) {
            return CBError.CBImpressionError.INVALID_RESPONSE;
        }
        String string = CBUtility.a(CBUtility.a()) ? "video-portrait" : "video-landscape";
        JSONObject jSONObject3 = jSONObject2.optJSONObject(string);
        if (jSONObject3 == null) {
            return CBError.CBImpressionError.VIDEO_UNAVAILABLE_FOR_CURRENT_ORIENTATION;
        }
        String string2 = jSONObject3.optString("id");
        if (string2.isEmpty()) {
            return CBError.CBImpressionError.VIDEO_ID_MISSING;
        }
        if (new File(this.b.d().g, string2).exists()) {
            return null;
        }
        return CBError.CBImpressionError.VIDEO_UNAVAILABLE;
    }

    public com.chartboost.sdk.Model.a a(String string) {
        e e2 = this;
        synchronized (e2) {
            block5 : {
                f f2 = (f)this.h.get((Object)string);
                if (f2 == null) break block5;
                if (f2.c != 6 && f2.c != 7) break block5;
                com.chartboost.sdk.Model.a a2 = f2.d;
                return a2;
            }
            return null;
            finally {
            }
        }
    }

    void a() {
        if (this.g == 0) {
            this.g = 1;
            this.b();
        }
    }

    void a(f f2) {
        if (f2.c == 7) {
            f2.c = 6;
            f2.j = null;
            f2.i = null;
            f2.m = null;
        }
    }

    void a(f f2, CBError.CBImpressionError cBImpressionError) {
        this.b(f2, cBImpressionError);
        if (f2.c == 7) {
            if (cBImpressionError == CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE) {
                f2.c = 6;
                f2.j = null;
                f2.i = null;
                f2.m = null;
                return;
            }
            this.g(f2);
            this.f(f2);
            this.b();
        }
    }

    void a(f f2, CBError cBError) {
        e e2 = this;
        synchronized (e2) {
            block4 : {
                int n2 = this.g;
                if (n2 != 0) break block4;
                return;
            }
            this.g = 1;
            this.b(f2, cBError.c());
            this.f(f2);
            this.g(f2);
            this.b();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(f f2, com.chartboost.sdk.Model.a a2) {
        e e2 = this;
        synchronized (e2) {
            this.g = 1;
            int n2 = f2.c == 2 ? 4 : 5;
            f2.c = n2;
            f2.d = a2;
            this.c(f2);
            this.b();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void a(f f2, boolean bl, int n2, int n3) {
        e e2 = this;
        synchronized (e2) {
            if (f2.c == 4 || f2.c == 5) {
                f2.n = n2;
                f2.o = n3;
                if (bl) {
                    this.d(f2);
                } else {
                    this.e(f2);
                }
            }
            this.b();
            return;
        }
    }

    void b() {
        if (!this.w) {
            try {
                this.w = true;
                this.d();
                if (this.g == 1 && !this.a(this.j, 1, 3, 1, "show")) {
                    this.a(this.i, 0, 2, 2, "cache");
                }
                this.c();
                return;
            }
            finally {
                this.w = false;
            }
        }
    }

    void b(f f2) {
        if (f2.c == 7) {
            if (f2.i != null && f2.m == null) {
                f2.m = (int)TimeUnit.NANOSECONDS.toMillis(this.c.b() - f2.i);
            }
            this.b(f2, "ad-unit-shown");
            this.y.remove((Object)f2.b);
            Handler handler = this.d;
            c c2 = this.f;
            c2.getClass();
            handler.post((Runnable)c2.new c.a(5, f2.b, null));
            this.i(f2);
            this.f(f2);
            this.b();
        }
    }

    void b(String string) {
        if (this.e()) {
            c c2 = this.f;
            c2.getClass();
            c.a a2 = c2.new c.a(4, string, CBError.CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED);
            this.d.postDelayed((Runnable)a2, this.A);
            return;
        }
        f f2 = (f)this.h.get((Object)string);
        if (f2 != null && f2.c == 6 && !this.a(f2.d)) {
            this.h.remove((Object)string);
            f2 = null;
        }
        if (f2 == null) {
            int n2 = this.v;
            this.v = n2 + 1;
            f2 = new f(n2, string, 0);
            this.h.put((Object)string, (Object)f2);
            this.i.add((Object)f2);
        }
        f2.f = true;
        if (f2.h == null) {
            f2.h = this.c.b();
        }
        switch (f2.c) {
            default: {
                break;
            }
            case 6: 
            case 7: {
                Handler handler = this.d;
                c c3 = this.f;
                c3.getClass();
                handler.post((Runnable)c3.new c.a(0, string, null));
            }
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: 
        }
        this.b();
    }

    void c(String string) {
        if (this.e()) {
            c c2 = this.f;
            c2.getClass();
            c.a a2 = c2.new c.a(4, string, CBError.CBImpressionError.FIRST_SESSION_INTERSTITIALS_DISABLED);
            this.d.postDelayed((Runnable)a2, this.A);
            return;
        }
        f f2 = (f)this.h.get((Object)string);
        if (f2 == null) {
            int n2 = this.v;
            this.v = n2 + 1;
            f2 = new f(n2, string, 1);
            this.h.put((Object)string, (Object)f2);
            this.j.add((Object)f2);
        }
        if (f2.i == null) {
            f2.i = this.c.b();
        }
        switch (f2.c) {
            default: {
                break;
            }
            case 6: {
                this.h(f2);
                break;
            }
            case 4: {
                f2.c = 5;
                this.c(f2);
                break;
            }
            case 2: {
                f2.c = 3;
                break;
            }
            case 0: {
                this.i.remove((Object)f2);
                this.j.add((Object)f2);
                f2.c = 1;
            }
            case 1: 
            case 3: 
            case 5: 
            case 7: 
        }
        this.b();
    }

    void d(String string) {
        f f2 = (f)this.h.get((Object)string);
        if (f2 != null && f2.c == 6) {
            this.f(f2);
            this.b();
        }
    }

    public class a
    implements Runnable {
        final int a;
        final String b;
        final f c;
        final CBError.CBImpressionError d;

        public a(int n2, String string, f f2, CBError.CBImpressionError cBImpressionError) {
            this.a = n2;
            this.b = string;
            this.c = f2;
            this.d = cBImpressionError;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public void run() {
            try {
                var5_2 = var2_1 = e.this;
                synchronized (var5_2) {
                    var4_3 = this.a;
                    if (var4_3 == 0) break block15;
                }
            }
            catch (Exception var1_4) {
                com.chartboost.sdk.Tracking.a.a((Class)this.getClass(), (String)"run", (Exception)var1_4);
                return;
            }
            {
                block16 : {
                    block15 : {
                        switch (var4_3) {
                            case 8: {
                                e.this.d(this.b);
                                ** break;
                            }
                            case 7: {
                                e.this.a(this.c);
                                ** break;
                            }
                            case 6: {
                                e.this.a(this.c, this.d);
                                ** break;
                            }
                            case 5: {
                                e.this.b(this.c);
                                ** break;
                            }
                            case 4: {
                                e.this.c(this.b);
                                ** break;
                            }
                            case 3: {
                                e.this.b(this.b);
                                ** break;
                            }
                            case 2: {
                                e.this.k = null;
                                e.this.b();
                                ** break;
                            }
                        }
                        ** break;
lbl33: // 8 sources:
                        break block16;
                    }
                    e.this.a();
                }
                return;
            }
        }
    }

}

