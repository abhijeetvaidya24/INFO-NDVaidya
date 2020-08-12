/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.aer.ao
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.an;
import com.moat.analytics.mobile.aer.ao;
import com.moat.analytics.mobile.aer.ap;
import com.moat.analytics.mobile.aer.at;
import com.moat.analytics.mobile.aer.base.exception.a;
import com.moat.analytics.mobile.aer.w;

class ar
implements Runnable {
    private static final long b = 90000L;
    private final w a;
    private final String c;
    private final at d;
    private an e = an.a;

    private ar(String string, w w2, at at2) {
        this.a = w2;
        this.d = at2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://z.moatads.com/");
        stringBuilder.append(string);
        stringBuilder.append("/android/");
        stringBuilder.append("481942b5989dff650ea9b6e20f5b140729ba4512".substring(0, 7));
        stringBuilder.append("/status.json");
        this.c = stringBuilder.toString();
    }

    /* synthetic */ ar(String string, w w2, at at2, ap ap2) {
        this(string, w2, at2);
    }

    static /* synthetic */ at a(ar ar2) {
        return ar2.d;
    }

    /*
     * Exception decompiling
     */
    private void a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl3 : INVOKESTATIC : trying to set 1 previously set to 0
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

    private an b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append("?ts=");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("&v=");
        stringBuilder.append("1.7.5");
        String string = stringBuilder.toString();
        com.moat.analytics.mobile.aer.base.functional.a<String> a2 = this.a.a(string);
        if (!a2.c()) {
            return an.a;
        }
        String string2 = a2.b().trim();
        if ("481942b5989dff650ea9b6e20f5b140729ba4512".equals((Object)string2)) {
            ao.a((boolean)true);
        }
        if (!string2.isEmpty() && !"481942b5989dff650ea9b6e20f5b140729ba4512".equals((Object)string2)) {
            return an.a;
        }
        return an.b;
    }

    public void run() {
        try {
            this.a();
            return;
        }
        catch (Exception exception) {
            this.e = an.a;
            a.a(exception);
            return;
        }
    }
}

