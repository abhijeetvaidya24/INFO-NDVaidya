/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.os.Handler
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.List
 */
package com.ogury.consent.manager;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.ConsentException;
import com.ogury.consent.manager.util.consent.rtf1;
import com.ogury.consent.manager.vieww10800;
import java.util.List;

public final class ansicpg1252 {
    public static final ansicpg1252 a = new ansicpg1252();
    private static final Handler b = new Handler();

    private ansicpg1252() {
    }

    public static Handler a() {
        return b;
    }

    /*
     * Exception decompiling
     */
    public static void a(Context var0, rtf1 var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl40 : ALOAD : trying to set 1 previously set to 0
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

    public static final /* synthetic */ void a(ansicpg1252 ansicpg12522, boolean bl2, rtf1 rtf12, long l2) {
        ansicpg1252.a(bl2, rtf12, 20000L);
    }

    private static void a(rtf1 rtf12, String string2) {
        com.ogury.consent.manager.util.consent.ansi.a(null);
        rtf12.a(new ConsentException(string2, ""));
    }

    private static void a(final boolean bl2, final rtf1 rtf12, long l2) {
        b.postDelayed(new Runnable(){

            public final void run() {
                if (!bl2) {
                    ansicpg1252.a(rtf12, "timeout-error");
                }
            }
        }, l2);
    }

    public static final /* synthetic */ boolean a(ansicpg1252 ansicpg12522, Context context) {
        vieww10800 vieww108002;
        Object object = context.getSystemService("activity");
        if (object != null) {
            List list = ((ActivityManager)object).getRunningAppProcesses();
            if (list == null) {
                return false;
            }
            String string2 = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                if (runningAppProcessInfo.importance != 100 || !tx6480.a((Object)runningAppProcessInfo.processName, (Object)string2)) continue;
                return false;
            }
            return true;
        }
        vieww108002 = new vieww10800("null cannot be cast to non-null type android.app.ActivityManager");
        throw vieww108002;
    }

}

