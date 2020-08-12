/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.g.e.a.a
 *  com.adincube.sdk.g.e.a.a$a
 *  com.adincube.sdk.g.e.c.a
 *  com.adincube.sdk.h.a.a.a
 *  com.adincube.sdk.h.a.a.b
 *  java.lang.Object
 *  java.util.ArrayList
 *  java.util.Collection
 */
package com.adincube.sdk.g.e.a;

import com.adincube.sdk.g.e.a.a;
import com.adincube.sdk.h.a.a.b;
import com.adincube.sdk.h.a.e;
import java.util.ArrayList;
import java.util.Collection;

public final class c
extends a {
    private com.adincube.sdk.g.e.c.a b = new com.adincube.sdk.g.e.c.a(false, false);

    private void a(e e2, com.adincube.sdk.h.a.a.a a2) {
        e2.a(a2);
        this.a.a();
    }

    public final void a(e e2) {
        b b2 = b.a;
        ArrayList arrayList = new ArrayList();
        for (com.adincube.sdk.h.a.a.a a2 : e2.g()) {
            if (a2.b != b2 || !a2.c || !a2.d()) continue;
            arrayList.add((Object)a2);
        }
        com.adincube.sdk.h.a.a.a a3 = !arrayList.isEmpty() ? (com.adincube.sdk.h.a.a.a)arrayList.get(0) : null;
        this.c(a3);
    }

    public final boolean b(e e2) {
        com.adincube.sdk.h.a.a.a a2 = com.adincube.sdk.util.c.a(e2, b.b);
        if (a2 == null) {
            return false;
        }
        return c.a((com.adincube.sdk.h.a.a.a)a2);
    }

    /*
     * Exception decompiling
     */
    public final void c(com.adincube.sdk.h.a.a.a var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[TRYBLOCK]], but top level block is 10[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

