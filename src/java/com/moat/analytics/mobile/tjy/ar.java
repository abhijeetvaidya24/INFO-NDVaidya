/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.tjy;

public final class ar
extends Enum {
    public static final /* enum */ ar a = new ar("OFF", 0);
    public static final /* enum */ ar b = new ar("ON", 1);
    private static final /* synthetic */ ar[] c;

    static {
        ar[] arrar = new ar[]{a, b};
        c = arrar;
    }

    /*
     * Exception decompiling
     */
    private ar() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException
        // org.benf.cfr.reader.b.a.f.g.a(VariableFactory.java:53)
        // org.benf.cfr.reader.b.a.a.g.b(Op02WithProcessedDataAndRefs.java:911)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:959)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:56)
        // org.benf.cfr.reader.b.a.a.g$3.a(Op02WithProcessedDataAndRefs.java:2010)
        // org.benf.cfr.reader.b.a.a.g$3.a(Op02WithProcessedDataAndRefs.java:2007)
        // org.benf.cfr.reader.util.d.a.d(AbstractGraphVisitorFI.java:60)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:2019)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:340)
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

    public static ar valueOf(String string2) {
        return (ar)Enum.valueOf(ar.class, (String)string2);
    }

    public static ar[] values() {
        return (ar[])c.clone();
    }
}

