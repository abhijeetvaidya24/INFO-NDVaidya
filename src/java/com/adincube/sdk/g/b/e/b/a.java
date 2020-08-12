/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.adincube.sdk.g.b.e.b.b
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.c.d
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONObject
 */
package com.adincube.sdk.g.b.e.b;

import android.content.Context;
import com.adincube.sdk.g.b.e.b.b;
import com.adincube.sdk.h.c.d;
import com.adincube.sdk.util.e;
import com.adincube.sdk.util.f;
import com.adincube.sdk.util.n;
import org.json.JSONObject;

public final class a
implements b {
    private com.adincube.sdk.h.c.b a;
    private String b;

    public a(com.adincube.sdk.h.c.b b2) {
        this(b2, "no");
    }

    public a(com.adincube.sdk.h.c.b b2, String string) {
        this.a = b2;
        this.b = string;
    }

    private String b(com.adincube.sdk.h.c.a a2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.b);
        stringBuilder.append("-");
        stringBuilder.append(this.a.g);
        String string = stringBuilder.toString();
        if (a2 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append("_");
            stringBuilder2.append(a2.e);
            string = stringBuilder2.toString();
        }
        return string;
    }

    /*
     * Exception decompiling
     */
    public final d a(com.adincube.sdk.h.c.a var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl34 : ALOAD : trying to set 1 previously set to 0
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(com.adincube.sdk.h.c.a a2, d d2) {
        a a3 = this;
        synchronized (a3) {
            boolean bl;
            if (d2 != null && (bl = d2.g)) {
                return;
            }
            Context context = f.a();
            if (d2 != null) {
                String string = e.d(d2.a().toString());
                n.a(context, this.b(a2), string);
                return;
            }
            n.b(context, this.b(a2));
            return;
        }
    }
}

