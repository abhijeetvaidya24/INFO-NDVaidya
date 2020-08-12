/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.SystemClock
 *  com.tapjoy.internal.dx
 *  com.tapjoy.internal.dy
 *  com.tapjoy.internal.dy$a
 *  com.tapjoy.internal.ea
 *  com.tapjoy.internal.ea$a
 *  com.tapjoy.internal.eb
 *  com.tapjoy.internal.ec
 *  com.tapjoy.internal.ed
 *  com.tapjoy.internal.ee
 *  com.tapjoy.internal.eg
 *  com.tapjoy.internal.eg$a
 *  com.tapjoy.internal.ek
 *  com.tapjoy.internal.ek$a
 *  com.tapjoy.internal.k
 *  com.tapjoy.internal.m
 *  com.tapjoy.internal.n
 *  com.tapjoy.internal.q
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.List
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tapjoy.internal.dx;
import com.tapjoy.internal.dy;
import com.tapjoy.internal.ea;
import com.tapjoy.internal.eb;
import com.tapjoy.internal.ec;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.ee;
import com.tapjoy.internal.eg;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.gf;
import com.tapjoy.internal.gm;
import com.tapjoy.internal.k;
import com.tapjoy.internal.m;
import com.tapjoy.internal.n;
import com.tapjoy.internal.q;
import com.tapjoy.internal.y;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class gb {
    final gf a;
    final ga b;
    long c;
    private int d = 1;
    private final ea.a e = new ea.a();

    gb(gf gf2, ga ga2) {
        this.a = gf2;
        this.b = ga2;
    }

    public final dy.a a(eb eb2, String string2) {
        ee ee2 = this.a.b();
        dy.a a2 = new dy.a();
        a2.g = gf.a;
        a2.c = eb2;
        a2.d = string2;
        if (y.c()) {
            a2.e = y.b();
            a2.f = System.currentTimeMillis();
        } else {
            a2.e = System.currentTimeMillis();
            a2.h = SystemClock.elapsedRealtime();
        }
        a2.j = ee2.d;
        a2.k = ee2.e;
        a2.l = ee2.f;
        return a2;
    }

    /*
     * Exception decompiling
     */
    public final void a(dy.a var1) {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(String string2, String string3, double d2, String string4, String string5, String string6) {
        gf gf2;
        gf gf3 = gf2 = this.a;
        synchronized (gf3) {
            double d3;
            SharedPreferences.Editor editor = gf2.c.a();
            boolean bl2 = string3.equals((Object)gf2.c.l.a());
            int n2 = 1;
            if (bl2) {
                gf2.c.m.a(editor, n2 += gf2.c.m.b());
                d3 = d2 + gf2.c.n.a();
                gf2.c.n.a(editor, d3);
                editor.commit();
            } else {
                gf2.c.l.a(editor, string3);
                gf2.c.m.a(editor, n2);
                gf2.c.n.a(editor, d2);
                gf2.c.o.a(editor);
                gf2.c.p.a(editor);
                editor.commit();
                gf2.b.l = string3;
                gf2.b.o = null;
                gf2.b.p = null;
                d3 = d2;
            }
            gf2.b.m = n2;
            gf2.b.n = d3;
        }
        dy.a a2 = this.a(eb.APP, "purchase");
        eg.a a3 = new eg.a();
        a3.c = string2;
        if (string3 != null) {
            a3.f = string3;
        }
        a3.e = d2;
        if (string6 != null) {
            a3.m = string6;
        }
        if (string4 != null) {
            a3.o = string4;
        }
        if (string5 != null) {
            a3.p = string5;
        }
        a2.p = a3.b();
        this.a(a2);
        gf gf4 = this.a;
        long l2 = a2.e;
        gf gf5 = gf4;
        synchronized (gf5) {
            SharedPreferences.Editor editor = gf4.c.a();
            gf4.c.o.a(editor, l2);
            gf4.c.p.a(editor, d2);
            editor.commit();
            gf4.b.o = l2;
            gf4.b.p = d2;
            return;
        }
    }

    public final void a(String string2, String string3, int n2, long l2, long l3, Map map) {
        dy.a a2 = this.a(eb.USAGES, string2);
        a2.x = string3;
        a2.y = n2;
        a2.z = l2;
        a2.A = l3;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a2.w.add((Object)new ec((String)entry.getKey(), (Long)entry.getValue()));
            }
        }
        this.a(a2);
    }

    public final void a(String string2, String string3, String string4, String string5, Map map) {
        dy.a a2 = this.a(eb.CUSTOM, string3);
        a2.t = string2;
        a2.u = string4;
        a2.v = string5;
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                a2.w.add((Object)new ec((String)entry.getKey(), (Long)entry.getValue()));
            }
        }
        this.a(a2);
    }
}

