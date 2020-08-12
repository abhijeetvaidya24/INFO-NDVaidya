/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

public final class fn {
    public long a;
    public long b;
    public long c;

    private static long a(byte[] arrby, int n2) {
        int n3 = arrby[n2];
        int n4 = arrby[n2 + 1];
        int n5 = arrby[n2 + 2];
        int n6 = arrby[n2 + 3];
        if ((n3 & 128) == 128) {
            n3 = 128 + (n3 & 127);
        }
        if ((n4 & 128) == 128) {
            n4 = 128 + (n4 & 127);
        }
        if ((n5 & 128) == 128) {
            n5 = 128 + (n5 & 127);
        }
        if ((n6 & 128) == 128) {
            n6 = 128 + (n6 & 127);
        }
        return ((long)n3 << 24) + ((long)n4 << 16) + ((long)n5 << 8) + (long)n6;
    }

    private static long b(byte[] arrby, int n2) {
        long l2 = fn.a(arrby, n2);
        long l3 = fn.a(arrby, n2 + 4);
        return 1000L * (l2 - 2208988800L) + l3 * 1000L / 0x100000000L;
    }

    /*
     * Exception decompiling
     */
    public final boolean a(String var1, int var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl225 : ALOAD : trying to set 1 previously set to 0
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

