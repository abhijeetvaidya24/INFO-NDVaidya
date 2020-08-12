/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.adincube.sdk.g.e.c;

import com.adincube.sdk.k.b.b.d;
import java.util.List;

public final class a {
    public boolean a;
    private boolean b;

    public a(boolean bl, boolean bl2) {
        this.a = bl;
        this.b = bl2;
    }

    public final void a(com.adincube.sdk.h.a.a.a a2, com.adincube.sdk.k.a.a a3, Long l2) {
        new Object[1][0] = a3.k;
        List<String> list = a2.b("e");
        StringBuilder stringBuilder = new StringBuilder("Error-");
        stringBuilder.append(a3.k);
        this.a(stringBuilder.toString(), list, a2, l2);
    }

    public final void a(com.adincube.sdk.h.a.a.a a2, d d2, Long l2) {
        new Object[1][0] = d2.w;
        List<String> list = com.adincube.sdk.k.d.a.a(a2, d2);
        StringBuilder stringBuilder = new StringBuilder("Event-");
        stringBuilder.append(d2.w);
        this.a(stringBuilder.toString(), list, a2, l2);
    }

    /*
     * Exception decompiling
     */
    public final void a(String var1, List<String> var2, com.adincube.sdk.h.a.a.a var3, Long var4) {
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

