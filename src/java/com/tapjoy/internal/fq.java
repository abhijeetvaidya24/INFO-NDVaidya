/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  java.lang.Object
 *  java.lang.String
 *  java.util.LinkedHashMap
 *  java.util.Map
 */
package com.tapjoy.internal;

import android.app.Activity;
import android.app.Application;
import com.tapjoy.internal.cx;
import com.tapjoy.internal.d;
import com.tapjoy.internal.fw;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.gb;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gp;
import java.util.LinkedHashMap;
import java.util.Map;

public final class fq {
    public static void a() {
        gc gc2 = gc.a();
        if (gc2.b("startSession") && gc2.e()) {
            fw.b(null);
        }
    }

    public static void a(Activity activity) {
        gc gc2 = gc.a();
        if (fz.a((Object)activity, "onActivityStart: The given activity was null")) {
            fz.c("onActivityStart");
            d.a(activity.getApplication());
            d.b(activity);
            if (gc2.b("onActivityStart") && gc2.e()) {
                fw.b(activity);
            }
        }
    }

    /*
     * Exception decompiling
     */
    public static void a(String var0, String var1, String var2, String var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl87 : ALOAD : trying to set 1 previously set to 0
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

    public static void a(String string2, String string3, String string4, String string5, long l2) {
        gc gc2 = gc.a();
        if (gc2.c("trackEvent") && fz.a((Object)string3, "trackEvent: name was null")) {
            long l3 = l2 LCMP 0L;
            LinkedHashMap linkedHashMap = null;
            if (l3 != false) {
                linkedHashMap = cx.b();
                linkedHashMap.put((Object)"value", (Object)l2);
            }
            gc2.g.a(string2, string3, string4, string5, (Map)linkedHashMap);
            fz.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", new Object[]{string2, string3, string4, string5, linkedHashMap});
        }
    }

    public static void a(String string2, String string3, String string4, String string5, String string6, long l2, String string7, long l3, String string8, long l4) {
        gc gc2 = gc.a();
        if (gc2.c("trackEvent") && fz.a((Object)string3, "trackEvent: name was null")) {
            LinkedHashMap linkedHashMap = cx.b();
            if (string6 != null && l2 != 0L) {
                linkedHashMap.put((Object)string6, (Object)l2);
            }
            if (string7 != null && l3 != 0L) {
                linkedHashMap.put((Object)string7, (Object)l3);
            }
            if (string8 != null && l4 != 0L) {
                linkedHashMap.put((Object)string8, (Object)l4);
            }
            if (linkedHashMap.isEmpty()) {
                linkedHashMap = null;
            }
            gc2.g.a(string2, string3, string4, string5, (Map)linkedHashMap);
            fz.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", new Object[]{string2, string3, string4, string5, linkedHashMap});
        }
    }

    public static void b() {
        gc gc2 = gc.a();
        if (gc2.b("endSession")) {
            gc2.h.a();
        }
    }

    public static void b(Activity activity) {
        gc gc2 = gc.a();
        if (fz.a((Object)activity, "onActivityStop: The given activity was null")) {
            fz.c("onActivityStop");
            d.c(activity);
            if (gc2.b("onActivityStop") && !d.b()) {
                gc2.h.a();
            }
        }
    }
}

