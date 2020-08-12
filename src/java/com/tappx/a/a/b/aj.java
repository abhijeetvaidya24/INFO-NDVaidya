/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.List
 */
package com.tappx.a.a.b;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class aj {
    /*
     * Exception decompiling
     */
    public static /* varargs */ Method a(Class<?> var0, String var1, Class<?> ... var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl1 : ALOAD_0 : trying to set 1 previously set to 0
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

    public static class a {
        private final Object a;
        private final String b;
        private Class<?> c;
        private List<Class<?>> d;
        private List<Object> e;
        private boolean f;
        private boolean g;

        public a(Object object, String string2) {
            this.a = object;
            this.b = string2;
            this.d = new ArrayList();
            this.e = new ArrayList();
            Class class_ = object != null ? object.getClass() : null;
            this.c = class_;
        }

        public a a() {
            this.f = true;
            return this;
        }

        public a a(Class<?> class_) {
            this.g = true;
            this.c = class_;
            return this;
        }

        public <T> a a(Class<T> class_, T t2) {
            this.d.add(class_);
            this.e.add(t2);
            return this;
        }

        public Object b() {
            Object[] arrobject = new Class[this.d.size()];
            Class[] arrclass = (Class[])this.d.toArray(arrobject);
            Method method = aj.a(this.c, this.b, arrclass);
            if (this.f) {
                method.setAccessible(true);
            }
            Object[] arrobject2 = this.e.toArray();
            if (this.g) {
                return method.invoke(null, arrobject2);
            }
            return method.invoke(this.a, arrobject2);
        }
    }

}

