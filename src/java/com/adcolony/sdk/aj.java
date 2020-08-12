/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.ScheduledExecutorService
 *  java.util.concurrent.TimeUnit
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.adcolony.sdk;

import android.content.Context;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.a;
import com.adcolony.sdk.l;
import com.adcolony.sdk.n;
import com.adcolony.sdk.s;
import com.adcolony.sdk.v;
import com.adcolony.sdk.w;
import com.adcolony.sdk.x;
import com.adcolony.sdk.z;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class aj {
    x c;
    ScheduledExecutorService d;
    List<z> e;
    List<z> f;
    HashMap<String, Object> g;
    private v h;
    private v i;

    aj(x x2, ScheduledExecutorService scheduledExecutorService, HashMap<String, Object> hashMap) {
        this.c = x2;
        this.d = scheduledExecutorService;
        this.g = hashMap;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.h = new v("adcolony_android", "3.3.7", "Production");
        this.i = new v("adcolony_fatal_reports", "3.3.7", "Production");
    }

    private JSONObject c(z z2) throws JSONException {
        aj aj2 = this;
        synchronized (aj2) {
            JSONObject jSONObject = new JSONObject(this.g);
            jSONObject.put("environment", (Object)z2.f().d());
            jSONObject.put("level", (Object)z2.b());
            jSONObject.put("message", (Object)z2.d());
            jSONObject.put("clientTimestamp", (Object)z2.e());
            JSONObject jSONObject2 = a.a().d().getMediationInfo();
            JSONObject jSONObject3 = a.a().d().getPluginInfo();
            double d2 = a.a().m().a(a.c());
            jSONObject.put("mediation_network", (Object)w.b(jSONObject2, "name"));
            jSONObject.put("mediation_network_version", (Object)w.b(jSONObject2, "version"));
            jSONObject.put("plugin", (Object)w.b(jSONObject3, "name"));
            jSONObject.put("plugin_version", (Object)w.b(jSONObject3, "version"));
            jSONObject.put("batteryInfo", d2);
            if (z2 instanceof s) {
                jSONObject = w.a(jSONObject, ((s)z2).a());
                jSONObject.put("platform", (Object)"android");
            }
            return jSONObject;
        }
    }

    String a(v v2, List<z> list) throws IOException, JSONException {
        String string = a.a().c.c();
        String string2 = this.g.get((Object)"advertiserId") != null ? (String)this.g.get((Object)"advertiserId") : "unknown";
        if (string != null && string.length() > 0 && !string.equals((Object)string2)) {
            this.g.put((Object)"advertiserId", (Object)string);
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("index", (Object)v2.b());
        jSONObject.put("environment", (Object)v2.d());
        jSONObject.put("version", (Object)v2.c());
        JSONArray jSONArray = new JSONArray();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            jSONArray.put((Object)this.c((z)iterator.next()));
        }
        jSONObject.put("logs", (Object)jSONArray);
        return jSONObject.toString();
    }

    /*
     * Exception decompiling
     */
    void a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl51 : ALOAD : trying to set 1 previously set to 0
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
    void a(long var1, TimeUnit var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl31 : ALOAD : trying to set 1 previously set to 0
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
    void a(z var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl29 : ALOAD : trying to set 1 previously set to 0
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

    void a(String string) {
        aj aj2 = this;
        synchronized (aj2) {
            this.g.put((Object)"controllerVersion", (Object)string);
            return;
        }
    }

    /*
     * Exception decompiling
     */
    void b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl50.1 : ALOAD : trying to set 1 previously set to 0
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

    void b(String string) {
        aj aj2 = this;
        synchronized (aj2) {
            this.g.put((Object)"sessionId", (Object)string);
            return;
        }
    }

    void c(String string) {
        aj aj2 = this;
        synchronized (aj2) {
            this.a(new z.a().a(3).a(this.h).a(string).a());
            return;
        }
    }

    void d(String string) {
        aj aj2 = this;
        synchronized (aj2) {
            this.a(new z.a().a(2).a(this.h).a(string).a());
            return;
        }
    }

    void e(String string) {
        aj aj2 = this;
        synchronized (aj2) {
            this.a(new z.a().a(1).a(this.h).a(string).a());
            return;
        }
    }

    void f(String string) {
        aj aj2 = this;
        synchronized (aj2) {
            this.a(new z.a().a(0).a(this.h).a(string).a());
            return;
        }
    }

}

