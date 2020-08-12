/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.tjy.as
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.aa;
import com.moat.analytics.mobile.tjy.ar;
import com.moat.analytics.mobile.tjy.as;
import com.moat.analytics.mobile.tjy.at;
import com.moat.analytics.mobile.tjy.ax;
import com.moat.analytics.mobile.tjy.base.functional.a;
import com.moat.analytics.mobile.tjy.u;

class av
implements Runnable {
    private static final long b = 90000L;
    private final aa a;
    private final String c;
    private final ax d;
    private ar e = ar.a;

    private av(String string2, aa aa2, ax ax2) {
        this.a = aa2;
        this.d = ax2;
        StringBuilder stringBuilder = new StringBuilder("https://z.moatads.com/");
        stringBuilder.append(string2);
        stringBuilder.append("/android/");
        stringBuilder.append("8ace5ca5da6b9adb3c0f055aad4a98c2aedf4bd7".substring(0, 7));
        stringBuilder.append("/status.json");
        this.c = stringBuilder.toString();
    }

    /* synthetic */ av(String string2, aa aa2, ax ax2, at at2) {
        this(string2, aa2, ax2);
    }

    static /* synthetic */ ax a(av av2) {
        return av2.d;
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

    private ar b() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c);
        stringBuilder.append("?ts=");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append("&v=1.7.10");
        String string2 = stringBuilder.toString();
        a a2 = this.a.a(string2);
        if (!a2.c()) {
            return ar.a;
        }
        u u2 = new u((String)a2.b());
        as.a((boolean)u2.a());
        as.a((int)u2.c());
        if (u2.b()) {
            return ar.b;
        }
        return ar.a;
    }

    public void run() {
        try {
            this.a();
            return;
        }
        catch (Exception exception) {
            this.e = ar.a;
            com.moat.analytics.mobile.tjy.base.exception.a.a(exception);
            return;
        }
    }
}

