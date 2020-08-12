/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Locale
 *  org.json.JSONObject
 */
package com.adincube.sdk.h.c;

import com.adincube.sdk.mediation.b;
import com.adincube.sdk.mediation.f;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import java.util.Locale;
import org.json.JSONObject;

public final class e {
    public String a;
    String b;
    public JSONObject c;
    public long d;
    public com.adincube.sdk.mediation.e e;
    public b f;

    e() {
    }

    public e(String string) {
        this.a = string;
        this.b = null;
    }

    /*
     * Exception decompiling
     */
    public final JSONObject a() {
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

    public final String b() {
        String string = this.b;
        if (string != null) {
            return string;
        }
        return this.a;
    }

    public final boolean c() {
        b b2;
        block6 : {
            block5 : {
                b2 = this.f;
                if (b2 == null) {
                    return false;
                }
                try {
                    if (b2.b() != null) break block5;
                    return false;
                }
                catch (Throwable throwable) {
                    Object[] arrobject = new Object[]{this.a};
                    a.c("Error caught when reading config for network '%s'. Mediation will continue.", arrobject);
                    ErrorReportingHelper.report("NetworkOrderElement.isCacheExpired", this.a, null, throwable);
                    return true;
                }
            }
            Long l2 = b2.b().a();
            if (l2 != null) break block6;
            return false;
        }
        long l3 = System.currentTimeMillis();
        long l4 = b2.b().a();
        long l5 = this.d;
        if (l3 >= l5) {
            return l3 > l5 + l4;
        }
        return true;
    }

    public final String toString() {
        if (this.c != null) {
            Locale locale = Locale.US;
            Object[] arrobject = new Object[]{this.a, this.c.toString()};
            return String.format((Locale)locale, (String)"%s %s", (Object[])arrobject);
        }
        return this.a;
    }
}

