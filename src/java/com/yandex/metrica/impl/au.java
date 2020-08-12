/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.database.Cursor
 *  com.yandex.metrica.c
 *  com.yandex.metrica.c$a
 *  com.yandex.metrica.c$a$d
 *  com.yandex.metrica.c$a$d$b
 *  com.yandex.metrica.impl.at
 *  com.yandex.metrica.impl.at$b
 *  com.yandex.metrica.impl.at$c
 *  com.yandex.metrica.impl.ob.bl
 *  com.yandex.metrica.impl.ob.t
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 */
package com.yandex.metrica.impl;

import android.database.Cursor;
import com.yandex.metrica.c;
import com.yandex.metrica.impl.at;
import com.yandex.metrica.impl.ob.bl;
import com.yandex.metrica.impl.ob.bn;
import com.yandex.metrica.impl.ob.t;
import java.util.Map;

class au
extends at {
    public au(t t2) {
        super(t2);
    }

    protected Cursor a(long l2, bl bl2) {
        return this.o.b(this.s(), bl2);
    }

    protected at.b a(long l2, c.a.d.b b2) {
        return super.a(this.t(), b2);
    }

    public String a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.a());
        stringBuilder.append(" [");
        stringBuilder.append(this.s());
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    protected boolean a(long l2) {
        return false;
    }

    protected long s() {
        return Long.MIN_VALUE;
    }

    protected long t() {
        return Long.MIN_VALUE;
    }

    /*
     * Exception decompiling
     */
    protected at.c x() {
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

    protected Cursor z() {
        return this.o.a(this.s(), (Map<String, String>)this.b);
    }
}

