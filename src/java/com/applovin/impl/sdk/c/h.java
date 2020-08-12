/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.HashMap
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.applovin.impl.sdk.c;

import com.applovin.impl.sdk.b.d;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    private final j a;
    private final Map<String, Long> b = new HashMap();

    public h(j j2) {
        if (j2 != null) {
            this.a = j2;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    private void e() {
        try {
            this.a.a(d.h, this.c().toString());
            return;
        }
        catch (Throwable throwable) {
            this.a.u().b("GlobalStatsManager", "Unable to save stats", throwable);
            return;
        }
    }

    public long a(g g2) {
        return this.a(g2, 1L);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    long a(g g2, long l2) {
        long l3;
        Map<String, Long> map;
        Map<String, Long> map2 = map = this.b;
        synchronized (map2) {
            Long l4 = (Long)this.b.get((Object)g2.a());
            if (l4 == null) {
                l4 = 0L;
            }
            l3 = l2 + l4;
            this.b.put((Object)g2.a(), (Object)l3);
        }
        this.e();
        return l3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        Map<String, Long> map;
        Map<String, Long> map2 = map = this.b;
        synchronized (map2) {
            this.b.clear();
        }
        this.e();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long b(g g2) {
        Map<String, Long> map;
        Map<String, Long> map2 = map = this.b;
        synchronized (map2) {
            Long l2 = (Long)this.b.get((Object)g2.a());
            if (l2 != null) return l2;
            l2 = 0L;
            return l2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        Map<String, Long> map;
        Map<String, Long> map2 = map = this.b;
        synchronized (map2) {
            Iterator iterator = g.b().iterator();
            do {
                if (!iterator.hasNext()) {
                    this.e();
                    return;
                }
                g g2 = (g)iterator.next();
                this.b.remove((Object)g2.a());
            } while (true);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(g g2, long l2) {
        Map<String, Long> map;
        Map<String, Long> map2 = map = this.b;
        synchronized (map2) {
            this.b.put((Object)g2.a(), (Object)l2);
        }
        this.e();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public JSONObject c() throws JSONException {
        Map<String, Long> map;
        Map<String, Long> map2 = map = this.b;
        synchronized (map2) {
            JSONObject jSONObject = new JSONObject();
            Iterator iterator = this.b.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry)iterator.next();
                jSONObject.put((String)entry.getKey(), entry.getValue());
            }
            return jSONObject;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(g g2) {
        Map<String, Long> map;
        Map<String, Long> map2 = map = this.b;
        synchronized (map2) {
            this.b.remove((Object)g2.a());
        }
        this.e();
    }

    /*
     * Exception decompiling
     */
    public void d() {
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
}

