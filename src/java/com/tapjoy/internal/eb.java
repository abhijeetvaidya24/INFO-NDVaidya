/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.eb$a
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dn;
import com.tapjoy.internal.dq;
import com.tapjoy.internal.eb;

/*
 * Exception performing whole class analysis.
 */
public final class eb
extends Enum
implements dq {
    public static final dn ADAPTER;
    public static final /* enum */ eb APP;
    public static final /* enum */ eb CAMPAIGN;
    public static final /* enum */ eb CUSTOM;
    public static final /* enum */ eb USAGES;
    private static final /* synthetic */ eb[] b;
    private final int a;

    static {
        APP = new eb("APP", 0, 0);
        CAMPAIGN = new eb("CAMPAIGN", 1, 1);
        CUSTOM = new eb("CUSTOM", 2, 2);
        USAGES = new eb("USAGES", 3, 3);
        eb[] arreb = new eb[]{APP, CAMPAIGN, CUSTOM, USAGES};
        b = arreb;
        ADAPTER = new /* Unavailable Anonymous Inner Class!! */;
    }

    /*
     * Exception decompiling
     */
    private eb() {
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

    public static eb a(int n2) {
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        return null;
                    }
                    return USAGES;
                }
                return CUSTOM;
            }
            return CAMPAIGN;
        }
        return APP;
    }

    public static eb valueOf(String string) {
        return (eb)Enum.valueOf(eb.class, (String)string);
    }

    public static eb[] values() {
        return (eb[])b.clone();
    }

    @Override
    public final int a() {
        return this.a;
    }
}

