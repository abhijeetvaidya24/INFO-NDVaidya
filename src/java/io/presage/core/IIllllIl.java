/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.core.IIIlllIl
 *  io.presage.core.IIlIIIII
 *  io.presage.core.IIllllll
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage.core;

import android.content.Context;
import io.presage.core.IIIlllIl;
import io.presage.core.IIlIIIII;
import io.presage.core.IIllllll;
import io.presage.core.lIIIlIlI;
import java.io.File;

public class IIllllIl
extends IIllllll {
    private static final String IIIIIlll = lIIIlIlI.IIlIlllI.IIIIIIII;

    public IIllllIl(Context context, int n2, long l2, long l3) {
        super(context, n2, l2, l3);
    }

    protected final IIlIIIII IIIIIIII(long l2, int n2, String string, String string2, int n3, long l3, long l4) {
        IIIlllIl iIIlllIl = new IIIlllIl(l2, n2, string, string2, n3, l3, l4);
        return iIIlllIl;
    }

    /*
     * Exception decompiling
     */
    protected final String IIIIIIIl(String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl61.1 : ACONST_NULL : trying to set 0 previously set to 1
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

    public final int IIIIIIlI() {
        return 10;
    }

    protected final Object IIIIIIll() {
        return IIllllIl.class;
    }

    protected final File IIIIlIlI() {
        return new File(IIIIIlll);
    }
}

