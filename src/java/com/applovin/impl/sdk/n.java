/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  java.io.ByteArrayOutputStream
 *  java.io.File
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.net.MalformedURLException
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Iterator
 *  java.util.List
 *  java.util.concurrent.TimeUnit
 */
package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import com.applovin.impl.sdk.b.b;
import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.c.g;
import com.applovin.impl.sdk.c.h;
import com.applovin.impl.sdk.e.e;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.p;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class n {
    private final String a = "FileManager";
    private final com.applovin.impl.sdk.j b;
    private final p c;
    private final Object d;

    n(com.applovin.impl.sdk.j j2) {
        this.b = j2;
        this.c = j2.u();
        this.d = new Object();
    }

    private long a(long l2) {
        return l2 / 0x100000L;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void a(long l2, Context context) {
        String string2;
        p p2;
        long l3 = this.c();
        if (l3 == -1L) {
            p2 = this.c;
            string2 = "Cache has no maximum size set; skipping drop...";
        } else {
            if (this.a(l2) > l3) {
                this.c.a("FileManager", "Cache has exceeded maximum size; dropping...");
                this.g(context);
                this.b.D().a(g.f);
                return;
            }
            p2 = this.c;
            string2 = "Cache is present but under size limit; not dropping...";
        }
        p2.a("FileManager", string2);
    }

    private boolean a() {
        return this.b.a(b.bq);
    }

    private long b() {
        long l2 = this.b.a(b.br);
        if (l2 >= 0L && this.a()) {
            return l2;
        }
        return -1L;
    }

    /*
     * Exception decompiling
     */
    private boolean b(ByteArrayOutputStream var1, File var2) {
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
    private boolean b(File file) {
        Object object;
        p p2 = this.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Removing file ");
        stringBuilder.append(file.getName());
        stringBuilder.append(" from filesystem...");
        p2.a("FileManager", stringBuilder.toString());
        Object object2 = object = this.d;
        synchronized (object2) {
            try {
                try {
                    return file.delete();
                }
                catch (Exception exception) {
                    p p3 = this.c;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Failed to remove file ");
                    stringBuilder2.append(file.getName());
                    stringBuilder2.append(" from filesystem!");
                    p3.b("FileManager", stringBuilder2.toString(), exception);
                    return false;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    private int c() {
        int n2 = this.b.a(b.bs);
        if (n2 >= 0 && this.a()) {
            return n2;
        }
        return -1;
    }

    private boolean d(Context context) {
        if (e.a("android.permission.WRITE_EXTERNAL_STORAGE", context)) {
            return true;
        }
        if (e.e() && !this.b.a(b.bv).booleanValue()) {
            return true;
        }
        this.b.u().c("FileManager", "Application lacks required WRITE_EXTERNAL_STORAGE manifest permission.");
        return false;
    }

    private File e(Context context) {
        if (this.d(context)) {
            return new File(context.getExternalFilesDir(null), "al");
        }
        return new File(context.getCacheDir(), "al");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private long f(Context context) {
        Object object;
        long l2 = this.b();
        boolean bl = l2 != -1L;
        long l3 = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        Object object2 = object = this.d;
        synchronized (object2) {
            Iterator iterator = this.a(context).iterator();
            long l4 = 0L;
            while (iterator.hasNext()) {
                boolean bl2;
                File file = (File)iterator.next();
                if (bl && l3 - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) > l2) {
                    p p2 = this.c;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("File ");
                    stringBuilder.append(file.getName());
                    stringBuilder.append(" has expired, removing...");
                    p2.a("FileManager", stringBuilder.toString());
                    this.b(file);
                    bl2 = true;
                } else {
                    bl2 = false;
                }
                if (bl2) {
                    this.b.D().a(g.e);
                    continue;
                }
                l4 += file.length();
            }
            return l4;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g(Context context) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            Iterator iterator = this.a(context).iterator();
            while (iterator.hasNext()) {
                this.b((File)iterator.next());
            }
            return;
        }
    }

    /*
     * Exception decompiling
     */
    public ByteArrayOutputStream a(File var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl64 : ALOAD : trying to set 0 previously set to 1
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
    public ByteArrayOutputStream a(String var1, List<String> var2, boolean var3) {
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
    public File a(String string2, Context context, boolean bl) {
        Object object;
        if (!j.b(string2)) {
            this.b.u().a("FileManager", "Nothing to look up, skipping...");
            return null;
        }
        p p2 = this.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Looking up cached resource: ");
        stringBuilder.append(string2);
        p2.a("FileManager", stringBuilder.toString());
        if (!this.d(context) && !bl) {
            return null;
        }
        if (string2.contains((CharSequence)"icon")) {
            string2 = string2.replace((CharSequence)"/", (CharSequence)"_").replace((CharSequence)".", (CharSequence)"_");
        }
        Object object2 = object = this.d;
        synchronized (object2) {
            File file = this.e(context);
            File file2 = new File(file, string2);
            try {
                file.mkdirs();
                return file2;
            }
            catch (Exception exception) {
                return null;
            }
        }
    }

    public String a(Context context, String string2, String string3, List<String> list, boolean bl, com.applovin.impl.sdk.c.e e2) throws MalformedURLException {
        return this.a(context, string2, string3, list, bl, false, e2);
    }

    public String a(Context context, String string2, String string3, List<String> list, boolean bl, boolean bl2, com.applovin.impl.sdk.c.e e2) throws MalformedURLException {
        File file;
        String string4;
        if (!j.b(string2)) {
            this.b.u().a("FileManager", "Nothing to cache, skipping...");
            return null;
        }
        String string5 = Uri.parse((String)string2).getLastPathSegment();
        if (j.b(string5) && j.b(string3)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(string5);
            string5 = stringBuilder.toString();
        }
        if (this.a(file = this.a(string4 = string5, context, false), string2, list, bl, e2)) {
            p p2 = this.c;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Caching succeeded for file ");
            stringBuilder.append(string4);
            p2.a("FileManager", stringBuilder.toString());
            if (bl2) {
                string4 = Uri.fromFile((File)file).toString();
            }
            return string4;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List<File> a(Context context) {
        Object object;
        File file = this.e(context);
        if (!file.isDirectory()) return new ArrayList(0);
        Object object2 = object = this.d;
        synchronized (object2) {
            return Arrays.asList((Object[])file.listFiles());
        }
    }

    public boolean a(ByteArrayOutputStream byteArrayOutputStream, File file) {
        if (file == null) {
            return false;
        }
        p p2 = this.c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Caching ");
        stringBuilder.append(file.getAbsolutePath());
        stringBuilder.append("...");
        p2.a("FileManager", stringBuilder.toString());
        if (byteArrayOutputStream != null && byteArrayOutputStream.size() > 0) {
            if (!this.b(byteArrayOutputStream, file)) {
                p p3 = this.c;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Unable to cache ");
                stringBuilder2.append(file.getAbsolutePath());
                p3.d("FileManager", stringBuilder2.toString());
                return false;
            }
            p p4 = this.c;
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Caching completed for ");
            stringBuilder3.append((Object)file);
            p4.a("FileManager", stringBuilder3.toString());
            return true;
        }
        p p5 = this.c;
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append("No data for ");
        stringBuilder4.append(file.getAbsolutePath());
        p5.c("FileManager", stringBuilder4.toString());
        return false;
    }

    public boolean a(File file, String string2, List<String> list, com.applovin.impl.sdk.c.e e2) {
        return this.a(file, string2, list, true, e2);
    }

    public boolean a(File file, String string2, List<String> list, boolean bl, com.applovin.impl.sdk.c.e e2) {
        if (file != null && file.exists() && !file.isDirectory()) {
            p p2 = this.b.u();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("File exists for ");
            stringBuilder.append(string2);
            p2.a("FileManager", stringBuilder.toString());
            if (e2 != null) {
                e2.b(file.length());
            }
            return true;
        }
        ByteArrayOutputStream byteArrayOutputStream = this.a(string2, list, bl);
        if (e2 != null && byteArrayOutputStream != null) {
            e2.a(byteArrayOutputStream.size());
        }
        return this.a(byteArrayOutputStream, file);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(String string2, Context context) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            return this.b(string2, context, false);
        }
    }

    public boolean b(Context context) {
        if (this.b.a(b.bw).booleanValue()) {
            File file;
            block4 : {
                this.a(".nomedia", context, false);
                file = new File(this.e(context), ".nomedia");
                if (!file.exists()) break block4;
                return true;
            }
            try {
                p p2 = this.b.u();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Dropping .nomedia file at ");
                stringBuilder.append(file.getAbsolutePath());
                p2.a("FileManager", stringBuilder.toString());
                boolean bl = file.createNewFile();
                return bl;
            }
            catch (Exception exception) {
                this.b.u().a("FileManager", "Failed to create nomedia file", exception);
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    boolean b(String string2, Context context, boolean bl) {
        Object object;
        Object object2 = object = this.d;
        synchronized (object2) {
            File file = this.a(string2, context, bl);
            if (file == null) return false;
            if (!file.exists()) return false;
            if (file.isDirectory()) return false;
            return true;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void c(Context context) {
        try {
            Object object;
            if (!this.a()) return;
            if (!this.b.c()) {
                this.c.d("FileManager", "Cannot empty file cache after SDK has completed initialization and ad loads are in progress!");
                return;
            }
            this.c.a("FileManager", "Compacting cache...");
            Object object2 = object = this.d;
            // MONITORENTER : object2
        }
        catch (Exception exception) {
            this.c.b("FileManager", "Caught exception while compacting cache!", exception);
            this.b.v().a(b.bq, false);
            this.b.v().a();
        }
        this.a(this.f(context), context);
        // MONITOREXIT : object2
        return;
    }
}

