/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  com.tapjoy.internal.j
 *  com.tapjoy.internal.k
 *  com.tapjoy.internal.m
 *  com.tapjoy.internal.n
 *  com.tapjoy.internal.q
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.internal.j;
import com.tapjoy.internal.k;
import com.tapjoy.internal.m;
import com.tapjoy.internal.n;
import com.tapjoy.internal.p;
import com.tapjoy.internal.q;

public final class gm {
    public final q A;
    public final j B;
    final j C;
    final q D;
    final Context a;
    final SharedPreferences b;
    final q c;
    final q d;
    final m e;
    final m f;
    final q g;
    final m h;
    final n i;
    final n j;
    final n k;
    final q l;
    final m m;
    final k n;
    final n o;
    final k p;
    final q q;
    final q r;
    final m s;
    final m t;
    final q u;
    final q v;
    final q w;
    final q x;
    final q y;
    final q z;

    private gm(Context context) {
        Context context2;
        this.a = context2 = context.getApplicationContext();
        this.b = context2.getSharedPreferences("fiverocks", 0);
        this.c = new q(this.b, "sdk");
        this.d = new q(this.b, "ir");
        this.e = new m(this.b, "fql", 0);
        this.f = new m(this.b, "fq", 0);
        this.g = new q(this.b, "push");
        this.h = new m(this.b, "ss", 0);
        this.i = new n(this.b, "std");
        this.j = new n(this.b, "slt");
        this.k = new n(this.b, "sld");
        this.l = new q(this.b, "ptc");
        this.m = new m(this.b, "pc", 0);
        this.n = new k(this.b, "ptp");
        this.o = new n(this.b, "lpt");
        this.p = new k(this.b, "plp");
        this.q = new q(this.b, "adv");
        this.r = new q(this.b, "ui");
        this.s = new m(this.b, "ul", -1);
        this.t = new m(this.b, "uf", -1);
        this.u = new q(this.b, "uv1");
        this.v = new q(this.b, "uv2");
        this.w = new q(this.b, "uv3");
        this.x = new q(this.b, "uv4");
        this.y = new q(this.b, "uv5");
        this.z = new q(this.b, "utags");
        this.A = new q(this.b, "idfa");
        this.B = new j(this.b, "idfa.optout");
        this.C = new j(this.b, "push.optout");
        this.D = new q(this.b, "appId");
    }

    public static gm a(Context context) {
        return new gm(context);
    }

    final SharedPreferences.Editor a() {
        return this.b.edit();
    }

    public final void a(boolean bl2) {
        p.a(this.b, "gcm.onServer", bl2);
    }

    /*
     * Exception decompiling
     */
    public final String b() {
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

