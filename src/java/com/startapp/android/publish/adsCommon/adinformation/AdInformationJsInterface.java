/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.JavascriptInterface
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.startapp.android.publish.adsCommon.adinformation;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class AdInformationJsInterface {
    private Runnable acceptCallback = null;
    private Context context = null;
    private Runnable declineCallback = null;
    private Runnable privacyPolicyCallback = null;
    private boolean processed = false;

    public AdInformationJsInterface(Context context, Runnable runnable, Runnable runnable2, Runnable runnable3) {
        this.context = context;
        this.acceptCallback = runnable;
        this.declineCallback = runnable2;
        this.privacyPolicyCallback = runnable3;
    }

    @JavascriptInterface
    public void accept() {
        if (this.processed) {
            return;
        }
        this.processed = true;
        this.acceptCallback.run();
    }

    @JavascriptInterface
    public void decline() {
        if (this.processed) {
            return;
        }
        this.processed = true;
        this.declineCallback.run();
    }

    @JavascriptInterface
    public void fullPrivacyPolicy() {
        if (this.processed) {
            return;
        }
        this.processed = true;
        this.privacyPolicyCallback.run();
    }

    /*
     * Exception decompiling
     */
    @JavascriptInterface
    public String getAppId() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl19.1 : ACONST_NULL : trying to set 0 previously set to 1
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

