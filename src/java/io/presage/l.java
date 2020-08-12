/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  co.ogury.crashreport.CrashReport
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage;

import android.content.Context;
import co.ogury.crashreport.CrashReport;
import io.presage.BrillatSavarin;
import io.presage.j;

public final class l {
    /*
     * Exception decompiling
     */
    public static final j a(Context var0, BrillatSavarin var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl22 : ACONST_NULL : trying to set 0 previously set to 1
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

    public static final void a(j j2, BrillatSavarin brillatSavarin) {
        int n2 = ((CharSequence)brillatSavarin.g()).length();
        boolean bl2 = true;
        boolean bl3 = n2 > 0;
        String string = bl3 ? brillatSavarin.g() : "http://ads-test.st.ogury.com/";
        String string2 = string;
        if (((CharSequence)brillatSavarin.b()).length() <= 0) {
            bl2 = false;
        }
        String string3 = bl2 ? brillatSavarin.b() : "The ad contains no ad_content";
        j2.loadDataWithBaseURL(string2, string3, "text/html", "UTF-8", null);
    }

    public static final void a(j j2, String string) {
        try {
            StringBuilder stringBuilder = new StringBuilder("javascript:");
            stringBuilder.append(string);
            j2.loadUrl(stringBuilder.toString());
            return;
        }
        catch (Exception exception) {
            CrashReport.logException((Exception)exception);
            return;
        }
    }
}

