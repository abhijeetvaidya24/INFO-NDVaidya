/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.tappx.b.a.d
 *  com.tappx.b.a.e
 *  com.tappx.b.a.h
 *  java.io.File
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.b.a;

import android.content.Context;
import com.tappx.b.a.d;
import com.tappx.b.a.e;
import com.tappx.b.a.l;
import com.tappx.b.b;
import com.tappx.b.h;
import com.tappx.b.o;
import java.io.File;

public class x {
    private static final String a = "volley";

    public static o a(Context context) {
        return x.a(context, (d)null);
    }

    /*
     * Exception decompiling
     */
    public static o a(Context var0, d var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl46 : NEW : trying to set 1 previously set to 0
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

    @Deprecated
    public static o a(Context context, l l2) {
        if (l2 == null) {
            return x.a(context, (d)null);
        }
        return x.a(context, (h)new e(l2));
    }

    private static o a(Context context, h h2) {
        o o2 = new o((b)new com.tappx.b.a.h(new File(context.getCacheDir(), a)), h2);
        o2.a();
        return o2;
    }
}

