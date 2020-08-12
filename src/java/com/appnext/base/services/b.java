/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  com.appnext.base.a.b.c
 *  com.appnext.base.a.c.c
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient
 *  com.google.android.gms.ads.identifier.AdvertisingIdClient$Info
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.appnext.base.services;

import android.content.Context;
import android.os.Bundle;
import com.appnext.base.a.c.c;
import com.appnext.base.b.e;
import com.appnext.base.b.i;
import com.appnext.base.operations.a;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public final class b {
    /*
     * Exception decompiling
     */
    private static void b(a.a var0) {
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

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(Context context, String string2, String string3, Bundle bundle, Object object, a.a a2) {
        boolean bl;
        try {
            i.aQ().init(context.getApplicationContext());
            e.init(context.getApplicationContext());
            AdvertisingIdClient.Info info = AdvertisingIdClient.getAdvertisingIdInfo((Context)context.getApplicationContext());
            bl = info != null && info.isLimitAdTrackingEnabled();
        }
        catch (Throwable throwable) {
            b.b(a2);
            return;
        }
        if (bl) {
            i.aQ().putBoolean("lat", true);
            b.b(a2);
            return;
        }
        com.appnext.base.a.b.c c2 = com.appnext.base.a.a.X().ab().t(string2);
        if (c2 == null) {
            b.b(a2);
            return;
        }
        com.appnext.base.operations.b.aI().a(c2.getKey(), c2, bundle, object, a2);
    }
}

