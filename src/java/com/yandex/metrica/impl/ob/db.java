/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.yandex.metrica.impl.ob.dc
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.Map
 */
package com.yandex.metrica.impl.ob;

import android.text.TextUtils;
import com.yandex.metrica.impl.ob.dc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class db {
    public static final Map<String, String> a = Collections.unmodifiableMap((Map)new HashMap<String, String>(){
        {
            this.put((Object)"20799a27-fa80-4b36-b2db-0f8141f24180", (Object)"13");
            this.put((Object)"01528cc0-dd34-494d-9218-24af1317e1ee", (Object)"17233");
            this.put((Object)"4e610cd2-753f-4bfc-9b05-772ce8905c5e", (Object)"21952");
            this.put((Object)"67bb016b-be40-4c08-a190-96a3f3b503d3", (Object)"22675");
            this.put((Object)"e4250327-8d3c-4d35-b9e8-3c1720a64b91", (Object)"22678");
            this.put((Object)"6c5f504e-8928-47b5-bfb5-73af8d8bf4b4", (Object)"30404");
            this.put((Object)"7d962ba4-a392-449a-a02d-6c5be5613928", (Object)"30407");
        }
    });
    private dc b;

    public db(dc dc2) {
        this.b = dc2;
    }

    public void a() {
        if (this.f()) {
            this.g();
            this.h();
        }
    }

    void a(String string2) {
        if (string2 != null) {
            this.b(string2);
            this.g();
        }
    }

    public void b() {
        String string2 = this.d();
        boolean bl2 = !TextUtils.isEmpty((CharSequence)string2) && "DONE".equals(this.b.g().get((Object)dc.f((String)string2)));
        if (bl2) {
            this.a(string2);
        }
    }

    void b(String string2) {
        this.b.d(string2);
    }

    public void c() {
        this.a(this.e());
    }

    String d() {
        return (String)a.get((Object)this.b.j());
    }

    /*
     * Exception decompiling
     */
    String e() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl28 : ALOAD : trying to set 1 previously set to 0
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

    boolean f() {
        return this.b.a(null) != null;
    }

    void g() {
        this.b.a();
    }

    void h() {
        this.b.b();
    }

}

