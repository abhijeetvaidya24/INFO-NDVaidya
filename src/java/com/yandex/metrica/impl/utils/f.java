/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.yandex.metrica.impl.bi
 *  com.yandex.metrica.impl.utils.j
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Map
 */
package com.yandex.metrica.impl.utils;

import com.yandex.metrica.impl.bi;
import com.yandex.metrica.impl.utils.j;
import java.util.Map;

public class f {
    /*
     * Exception decompiling
     */
    public String a(String var1, int var2) {
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

    public String a(String string2, int n2, String string3) {
        if (string2 != null && string2.length() > n2) {
            String string4 = string2.substring(0, n2);
            j j2 = j.f();
            Object[] arrobject = new Object[]{string3, string2, n2};
            j2.b("\"%s\"'s parameter %s size exceeded limit of %d characters", arrobject);
            return string4;
        }
        return string2;
    }

    public Map<String, String> a(Map<String, String> map, String string2, String string3, a a2, String string4) {
        if (map != null) {
            String string5 = this.a(string2, a2.b(), string4);
            String string6 = this.a(string3, a2.c(), string4);
            if (map.size() >= a2.a() && !map.containsKey((Object)string5)) {
                this.b(string5, a2.a(), string4);
                return map;
            }
            map.put((Object)string5, (Object)string6);
        }
        return map;
    }

    public boolean a(String string2, String string3) {
        return !bi.a((String)string2, (String)string3);
    }

    public byte[] a(byte[] arrby, int n2) {
        if (arrby.length > n2) {
            byte[] arrby2 = new byte[n2];
            System.arraycopy((Object)arrby, (int)0, (Object)arrby2, (int)0, (int)n2);
            arrby = arrby2;
        }
        return arrby;
    }

    public void b(String string2, int n2, String string3) {
        j j2 = j.f();
        Object[] arrobject = new Object[]{string3, n2, string2};
        j2.b("The %s has reached the limit of %d items. Item with key %s will be ignored", arrobject);
    }

    public static class a {
        private final int a;
        private final int b;
        private final int c;

        public a(int n2, int n3, int n4) {
            this.a = n2;
            this.b = n3;
            this.c = n4;
        }

        public static a d() {
            return new a(30, 50, 100);
        }

        public int a() {
            return this.a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }
    }

}

