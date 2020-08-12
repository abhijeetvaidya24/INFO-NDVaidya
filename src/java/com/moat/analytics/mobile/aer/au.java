/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.aer.av
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.util.LinkedList
 */
package com.moat.analytics.mobile.aer;

import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.am;
import com.moat.analytics.mobile.aer.an;
import com.moat.analytics.mobile.aer.av;
import com.moat.analytics.mobile.aer.aw;
import com.moat.analytics.mobile.aer.ax;
import com.moat.analytics.mobile.aer.ay;
import com.moat.analytics.mobile.aer.base.exception.a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;

class au<T>
implements InvocationHandler {
    private static final Object[] a = new Object[0];
    private final al b;
    private final aw<T> c;
    private final ay<T> d;
    private final LinkedList<au<T>> e;
    private final LinkedList<au<T>> f;
    private boolean g;
    private T h;

    au(al al2, aw<T> aw2, ay<T> ay2) {
        com.moat.analytics.mobile.aer.base.asserts.a.a(al2);
        com.moat.analytics.mobile.aer.base.asserts.a.a(aw2);
        com.moat.analytics.mobile.aer.base.asserts.a.a(ay2);
        this.b = al2;
        this.c = aw2;
        this.d = ay2;
        al2.a((am)new av(this));
        this.e = new LinkedList();
        this.f = new LinkedList();
    }

    static <T> T a(al al2, aw<T> aw2, ay<T> ay2) {
        Class<T> class_ = ay2.a();
        ClassLoader classLoader = class_.getClassLoader();
        au<T> au2 = new au<T>(al2, aw2, ay2);
        return (T)Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])new Class[]{class_}, au2);
    }

    private Object a(Method method) {
        try {
            if (Boolean.TYPE.equals((Object)method.getReturnType())) {
                Boolean bl2 = true;
                return bl2;
            }
        }
        catch (Exception exception) {
            a.a(exception);
        }
        return null;
    }

    private Object a(Method method, Object[] arrobject) {
        if (Object.class.equals((Object)method.getDeclaringClass())) {
            String string = method.getName();
            Class<T> class_ = this.d.a();
            if ("getClass".equals((Object)string)) {
                return class_;
            }
            if ("toString".equals((Object)string)) {
                Object object = method.invoke((Object)this, arrobject);
                String string2 = au.class.getName();
                String string3 = class_.getName();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(object);
                stringBuilder.append("");
                return stringBuilder.toString().replace((CharSequence)string2, (CharSequence)string3);
            }
            return method.invoke((Object)this, arrobject);
        }
        if (this.g && this.h == null) {
            this.c();
            return this.a(method);
        }
        if (this.b.a() == an.b) {
            this.b();
            T t2 = this.h;
            if (t2 != null) {
                return method.invoke(t2, arrobject);
            }
        }
        if (!(this.b.a() != an.a || this.g && this.h == null)) {
            this.b(method, arrobject);
        }
        return this.a(method);
    }

    static /* synthetic */ void a(au au2) {
        au2.b();
    }

    static /* synthetic */ Object[] a() {
        return a;
    }

    /*
     * Exception decompiling
     */
    private void b() {
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
     */
    private void b(Method method, Object[] arrobject) {
        ax ax2;
        LinkedList<au<T>> linkedList;
        if (this.e.size() < 5) {
            linkedList = this.e;
            ax2 = new ax(this, method, arrobject, null);
        } else {
            if (this.f.size() >= 10) {
                this.f.removeFirst();
            }
            linkedList = this.f;
            ax2 = new ax(this, method, arrobject, null);
        }
        linkedList.add((Object)ax2);
    }

    static /* synthetic */ boolean b(au au2) {
        return au2.g;
    }

    private void c() {
        this.e.clear();
        this.f.clear();
    }

    public Object invoke(Object object, Method method, Object[] arrobject) {
        try {
            Object object2 = this.a(method, arrobject);
            return object2;
        }
        catch (Exception exception) {
            a.a(exception);
            return this.a(method);
        }
    }
}

