/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Thread
 *  java.lang.Throwable
 *  java.util.Iterator
 *  java.util.List
 *  java.util.WeakHashMap
 *  java.util.concurrent.BlockingQueue
 *  java.util.concurrent.ConcurrentHashMap
 *  java.util.concurrent.CopyOnWriteArrayList
 *  java.util.concurrent.LinkedBlockingQueue
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.i;
import com.yandex.metrica.impl.ob.k;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class g {
    private final Thread a = new Thread(new Runnable(){

        /*
         * Exception decompiling
         */
        public void run() {
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
    }, "Bus Dispatcher");
    private volatile boolean b = true;
    private final BlockingQueue<a> c = new LinkedBlockingQueue();
    private ConcurrentHashMap<Class, CopyOnWriteArrayList<k<? extends i>>> d = new ConcurrentHashMap();
    private WeakHashMap<Object, CopyOnWriteArrayList<c>> e = new WeakHashMap();
    private ConcurrentHashMap<Class, i> f = new ConcurrentHashMap();

    g() {
        this.a.start();
    }

    public static final g a() {
        return b.a;
    }

    static /* synthetic */ boolean a(g g2) {
        return g2.b;
    }

    static /* synthetic */ BlockingQueue b(g g2) {
        return g2.c;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(i i2) {
        g g2 = this;
        synchronized (g2) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList)this.d.get((Object)i2.getClass());
            if (copyOnWriteArrayList == null) return;
            Iterator iterator = copyOnWriteArrayList.iterator();
            while (iterator.hasNext()) {
                this.a(i2, (k)iterator.next());
            }
            return;
        }
    }

    void a(i i2, k<? extends i> k2) {
        this.c.add((Object)new a(i2, k2, 0));
    }

    public void a(Class<? extends i> class_) {
        g g2 = this;
        synchronized (g2) {
            this.f.remove(class_);
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(Object object) {
        g g2 = this;
        synchronized (g2) {
            List list = (List)this.e.remove(object);
            if (list == null) return;
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ((c)iterator.next()).a();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Object object, Class class_, k<? extends i> k2) {
        g g2 = this;
        synchronized (g2) {
            CopyOnWriteArrayList copyOnWriteArrayList = (CopyOnWriteArrayList)this.d.get((Object)class_);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList();
                this.d.put((Object)class_, (Object)copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(k2);
            CopyOnWriteArrayList copyOnWriteArrayList2 = (CopyOnWriteArrayList)this.e.get(object);
            if (copyOnWriteArrayList2 == null) {
                copyOnWriteArrayList2 = new CopyOnWriteArrayList();
                this.e.put(object, (Object)copyOnWriteArrayList2);
            }
            copyOnWriteArrayList2.add((Object)new c(copyOnWriteArrayList, k2, 0));
            i i2 = (i)this.f.get((Object)class_);
            if (i2 != null) {
                this.a(i2, k2);
            }
            return;
        }
    }

    public void b(i i2) {
        g g2 = this;
        synchronized (g2) {
            this.a(i2);
            this.f.put((Object)i2.getClass(), (Object)i2);
            return;
        }
    }

    private static class a {
        private final i a;
        private final k<? extends i> b;

        private a(i i2, k<? extends i> k2) {
            this.a = i2;
            this.b = k2;
        }

        /* synthetic */ a(i i2, k k2, byte by) {
            this(i2, k2);
        }

        /*
         * Exception decompiling
         */
        void a() {
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
    }

    private static final class b {
        private static final g a = new g();
    }

    private static class c {
        final CopyOnWriteArrayList<k<? extends i>> a;
        final k<? extends i> b;

        private c(CopyOnWriteArrayList<k<? extends i>> copyOnWriteArrayList, k<? extends i> k2) {
            this.a = copyOnWriteArrayList;
            this.b = k2;
        }

        /* synthetic */ c(CopyOnWriteArrayList copyOnWriteArrayList, k k2, byte by) {
            this((CopyOnWriteArrayList<k<? extends i>>)copyOnWriteArrayList, k2);
        }

        protected void a() {
            this.a.remove(this.b);
        }

        protected void finalize() throws Throwable {
            super.finalize();
            this.a();
        }
    }

}

