/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.LocalServerSocket
 *  android.text.TextUtils
 *  com.yandex.metrica.YandexMetrica
 *  com.yandex.metrica.impl.bk
 *  java.io.File
 *  java.io.IOException
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONException
 */
package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.LocalServerSocket;
import android.text.TextUtils;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.impl.bk;
import com.yandex.metrica.impl.ob.ch;
import com.yandex.metrica.impl.ob.cj;
import com.yandex.metrica.impl.ob.ck;
import com.yandex.metrica.impl.r;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class ci {
    private final Object a = new Object();
    private final a b = new a(this, 0);
    private final ck c = new ck(this);
    private ch d;

    private ci() {
    }

    /* synthetic */ ci(byte by) {
        this();
    }

    /*
     * Exception decompiling
     */
    private ch a(Context var1, String var2, File var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl27.1 : ACONST_NULL : trying to set 1 previously set to 0
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

    public static ci a() {
        return b.a;
    }

    static /* synthetic */ void a(ci ci2, Context context, String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            YandexMetrica.getReporter((Context)context, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("saving_empty_device_id", (Map)new c(context, string2));
            return;
        }
        ci2.d(context, string2);
    }

    /*
     * Exception decompiling
     */
    public static String g(Context var0, String var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl20 : ALOAD : trying to set 1 previously set to 0
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
     * Exception decompiling
     */
    private ch h(Context var1, String var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl43.1 : ACONST_NULL : trying to set 0 previously set to 1
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
    private String i(Context context, String string2) {
        Object object;
        Object object2 = object = this.a;
        synchronized (object2) {
            if (this.c() != null) {
                return this.c().c();
            }
            ch ch2 = this.a(context, context.getPackageName());
            if (ch2 == null) {
                return this.b().a(context, string2);
            }
            if (this.e()) {
                ch ch3 = this.b(context, context.getPackageName());
                if (!ch2.a(ch3)) return this.b().a(context, ch2.c());
                if (!ch3.e()) return this.b().a(context, ch2.c());
                this.d = ch2;
                return ch3.c();
            }
            if (!ch2.e()) return this.b().a(context, ch2.c());
            this.d = ch2;
            return ch2.c();
        }
    }

    ch a(Context context, String string2) {
        return this.a(context, string2, context.getFileStreamPath("credentials.dat"));
    }

    public String a(Context context) {
        return this.i(context, null);
    }

    ch b(Context context, String string2) {
        return this.a(context, string2, new File(context.getNoBackupFilesDir(), "credentials.dat"));
    }

    a b() {
        return this.b;
    }

    ch c() {
        return this.d;
    }

    public String c(Context context, String string2) {
        return this.i(context, string2);
    }

    public String d() {
        ch ch2 = this.c();
        if (ch2 == null) {
            return null;
        }
        return ch2.c();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    void d(Context context, String string2) {
        Object object;
        try {
            Object object2;
            Object object3 = object2 = this.a;
            // MONITORENTER : object3
        }
        catch (JSONException jSONException) {
            return;
        }
        this.d = new ch(string2, new cj(context), System.currentTimeMillis());
        String string3 = this.d.a();
        if (this.e()) {
            this.e(context, string3);
        }
        Object object4 = object = this.a;
        // MONITORENTER : object4
        r.a(context, "credentials.dat", string3);
        // MONITOREXIT : object4
        // MONITOREXIT : object3
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    void e(Context context, String string2) {
        Object object;
        Object object2 = object = this.a;
        synchronized (object2) {
            r.b(context, "credentials.dat", string2);
            return;
        }
    }

    boolean e() {
        return bk.a((int)21);
    }

    ck f() {
        return this.c;
    }

    /*
     * Exception decompiling
     */
    String f(Context var1, String var2) {
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

    static class a {
        ci a;
        private LocalServerSocket b;

        private a(ci ci2) {
            this.a = ci2;
        }

        /* synthetic */ a(ci ci2, byte by) {
            this(ci2);
        }

        ci a() {
            return this.a;
        }

        /*
         * Exception decompiling
         */
        public String a(Context var1, String var2) {
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
            // org.benf.cfr.reader.entities.d.c(ClassFile.java:773)
            // org.benf.cfr.reader.entities.d.e(ClassFile.java:870)
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

        String a(Context context, String string2, String string3) {
            if (TextUtils.isEmpty((CharSequence)string2)) {
                if (TextUtils.isEmpty((CharSequence)string3)) {
                    return null;
                }
                ci.a(this.a(), context, string3);
                return string3;
            }
            if (string2.equals((Object)string3)) {
                ci.a(this.a(), context, string2);
                YandexMetrica.getReporter((Context)context, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("update_snapshot", (Map)new c(context, string3, string2));
                return string2;
            }
            if (TextUtils.isEmpty((CharSequence)string3)) {
                ci.a(this.a(), context, string2);
                YandexMetrica.getReporter((Context)context, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("wtf_situation. App has id and elector hasn't", (Map)new c(context, string3, string2));
                return string2;
            }
            ci.a(this.a(), context, string3);
            YandexMetrica.getReporter((Context)context, (String)"20799a27-fa80-4b36-b2db-0f8141f24180").reportEvent("overlapping_device_id", (Map)new c(context, string3, string2));
            return string3;
        }

        boolean b() {
            try {
                this.b = new LocalServerSocket("com.yandex.metrica.synchronization.deviceid");
                return true;
            }
            catch (IOException iOException) {
                return false;
            }
        }
    }

    private static class b {
        private static final ci a = new ci(0);
    }

    private static class c
    extends HashMap<String, Object> {
        public c(Context context, String string2) {
            String string3 = context.getPackageName();
            this.put((Object)"passed_id", (Object)string2);
            this.put((Object)"package_name", (Object)string3);
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(string3, 0);
                this.put((Object)"version_code", (Object)packageInfo.versionCode);
                this.put((Object)"version_name", (Object)packageInfo.versionName);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        }

        public c(Context context, String string2, String string3) {
            this(context, string2);
            this.put((Object)"stored_device_id", (Object)string3);
        }
    }

}

