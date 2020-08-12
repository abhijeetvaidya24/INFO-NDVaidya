/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  io.presage.EcirdelAubrac
 *  io.presage.common.PresageSdk$CamembertauCalvados
 *  io.presage.common.PresageSdk$CamembertdeNormandie
 *  io.presage.common.PresageSdk$EcirdelAubrac
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.List
 */
package io.presage.common;

import android.content.Context;
import android.util.Log;
import io.presage.AbbayedeTamie;
import io.presage.BurratadesPouilles;
import io.presage.EcirdelAubrac;
import io.presage.MoelleuxduRevard;
import io.presage.cc;
import io.presage.cd;
import io.presage.cl;
import io.presage.common.PresageSdk;
import io.presage.common.PresageSdkInitCallback;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class PresageSdk {
    public static final PresageSdk a = new PresageSdk();
    private static int b;
    private static List<PresageSdkInitCallback> c;

    static {
        List list = Collections.synchronizedList((List)((List)new LinkedList()));
        cl.a((Object)list, "Collections.synchronizedList(LinkedList())");
        c = list;
    }

    private PresageSdk() {
    }

    public static final /* synthetic */ void a(int n2) {
        b = n2;
    }

    public static final /* synthetic */ void a(Context context) {
        PresageSdk.init(context);
    }

    public static boolean a() {
        return b == 2;
    }

    public static boolean b() {
        return b == 1;
    }

    private static boolean b(Context context) {
        return !PresageSdk.b() && !MoelleuxduRevard.a(context);
    }

    public static final /* synthetic */ void c() {
        PresageSdk.g();
    }

    public static final /* synthetic */ void d() {
        PresageSdk.f();
    }

    private static boolean e() {
        return b == 0;
    }

    private static void f() {
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            ((PresageSdkInitCallback)iterator.next()).onSdkInitialized();
        }
        c.clear();
    }

    private static void g() {
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            ((PresageSdkInitCallback)iterator.next()).onSdkInitFailed();
        }
        c.clear();
    }

    public static final String getAdsSdkVersion() {
        return "3.0.36-moat";
    }

    /*
     * Exception decompiling
     */
    private static void init(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl58 : RETURN : trying to set 0 previously set to 1
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

    public static final void init(Context context, String string2) {
        BurratadesPouilles.a(context);
        if (b != 0) {
            return;
        }
        b = 2;
        CharSequence charSequence = string2;
        boolean bl2 = charSequence == null || charSequence.length() == 0;
        if (!bl2) {
            EcirdelAubrac.CamembertauCalvados.a((cc)new CamembertauCalvados(context, string2)).a((cd)CamembertdeNormandie.a).a((cc)EcirdelAubrac.a);
            return;
        }
        Log.e((String)"Presage", (String)"PresageSdk.init() error", (Throwable)((Throwable)new IllegalArgumentException("The api key is null empty. Please provide a valid api key")));
        b = 0;
    }

    public final void addSdkInitCallback(PresageSdkInitCallback presageSdkInitCallback) {
        if (PresageSdk.b()) {
            presageSdkInitCallback.onSdkInitialized();
            return;
        }
        if (PresageSdk.a()) {
            c.add((Object)presageSdkInitCallback);
            return;
        }
        if (PresageSdk.e()) {
            presageSdkInitCallback.onSdkNotInitialized();
        }
    }
}

