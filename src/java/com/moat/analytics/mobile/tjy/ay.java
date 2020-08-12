/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.tjy.az
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.ClassLoader
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.InvocationHandler
 *  java.lang.reflect.Method
 *  java.lang.reflect.Proxy
 *  java.util.LinkedList
 */
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.aq;
import com.moat.analytics.mobile.tjy.ar;
import com.moat.analytics.mobile.tjy.az;
import com.moat.analytics.mobile.tjy.ba;
import com.moat.analytics.mobile.tjy.base.asserts.a;
import com.moat.analytics.mobile.tjy.bb;
import com.moat.analytics.mobile.tjy.bc;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;

class ay
implements InvocationHandler {
    private static final Object[] a = new Object[0];
    private final ap b;
    private final ba c;
    private final bc d;
    private final LinkedList e;
    private final LinkedList f;
    private boolean g;
    private Object h;

    ay(ap ap2, ba ba2, bc bc2) {
        a.a(ap2);
        a.a(ba2);
        a.a(bc2);
        this.b = ap2;
        this.c = ba2;
        this.d = bc2;
        ap2.a((aq)new az(this));
        this.e = new LinkedList();
        this.f = new LinkedList();
    }

    static Object a(ap ap2, ba ba2, bc bc2) {
        Class class_ = bc2.a();
        ClassLoader classLoader = class_.getClassLoader();
        ay ay2 = new ay(ap2, ba2, bc2);
        return Proxy.newProxyInstance((ClassLoader)classLoader, (Class[])new Class[]{class_}, (InvocationHandler)ay2);
    }

    private Object a(Method method) {
        try {
            if (Boolean.TYPE.equals((Object)method.getReturnType())) {
                Boolean bl2 = true;
                return bl2;
            }
        }
        catch (Exception exception) {
            com.moat.analytics.mobile.tjy.base.exception.a.a(exception);
        }
        return null;
    }

    private Object a(Method method, Object[] arrobject) {
        if (Object.class.equals((Object)method.getDeclaringClass())) {
            String string2 = method.getName();
            Class class_ = this.d.a();
            if ("getClass".equals((Object)string2)) {
                return class_;
            }
            if ("toString".equals((Object)string2)) {
                Object object = method.invoke((Object)this, arrobject);
                String string3 = ay.class.getName();
                String string4 = class_.getName();
                return String.valueOf((Object)object).replace((CharSequence)string3, (CharSequence)string4);
            }
            return method.invoke((Object)this, arrobject);
        }
        if (this.g && this.h == null) {
            this.c();
            return this.a(method);
        }
        if (this.b.a() == ar.b) {
            this.b();
            Object object = this.h;
            if (object != null) {
                return method.invoke(object, arrobject);
            }
        }
        if (!(this.b.a() != ar.a || this.g && this.h == null)) {
            this.b(method, arrobject);
        }
        return this.a(method);
    }

    static /* synthetic */ void a(ay ay2) {
        ay2.b();
    }

    static /* synthetic */ Object[] a() {
        return a;
    }

    /*
     * Exception decompiling
     */
    private void b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl47 : ALOAD : trying to set 1 previously set to 0
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
     */
    private void b(Method method, Object[] arrobject) {
        bb bb2;
        LinkedList linkedList;
        if (this.e.size() < 5) {
            linkedList = this.e;
            bb2 = new bb(this, method, arrobject, null);
        } else {
            if (this.f.size() >= 10) {
                this.f.removeFirst();
            }
            linkedList = this.f;
            bb2 = new bb(this, method, arrobject, null);
        }
        linkedList.add((Object)bb2);
    }

    static /* synthetic */ boolean b(ay ay2) {
        return ay2.g;
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
            com.moat.analytics.mobile.tjy.base.exception.a.a(exception);
            return this.a(method);
        }
    }
}

