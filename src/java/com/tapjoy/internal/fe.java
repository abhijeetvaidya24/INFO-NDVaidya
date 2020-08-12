/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  com.tapjoy.internal.fe$2
 *  com.tapjoy.internal.fe$b
 *  java.lang.Boolean
 *  java.lang.Enum
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Hashtable
 *  java.util.LinkedList
 *  java.util.Observable
 *  java.util.Observer
 *  java.util.concurrent.locks.Condition
 *  java.util.concurrent.locks.ReentrantLock
 */
package com.tapjoy.internal;

import android.app.Application;
import android.content.Context;
import com.tapjoy.TJConnectListener;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.eq;
import com.tapjoy.internal.ev;
import com.tapjoy.internal.fe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public abstract class fe {
    private final ReentrantLock a = new ReentrantLock();
    volatile int b = c.a;
    b c;
    long d = 1000L;
    a e;
    private final Condition f = this.a.newCondition();
    private final LinkedList g = new LinkedList();
    private a h;

    static /* synthetic */ void a(fe fe2, boolean bl2) {
        fe2.a(bl2);
    }

    final a a() {
        this.a.lock();
        try {
            if (this.h != null) {
                this.e = this.h;
                this.h = null;
            }
            a a2 = this.e;
            return a2;
        }
        finally {
            this.a.unlock();
        }
    }

    final void a(int n2) {
        this.a.lock();
        try {
            this.b = n2;
            return;
        }
        finally {
            this.a.unlock();
        }
    }

    final void a(boolean bl2) {
        ArrayList arrayList;
        block5 : {
            this.a.lock();
            int n2 = this.g.size();
            if (n2 != 0) break block5;
            this.a.unlock();
            return;
        }
        try {
            arrayList = new ArrayList((Collection)this.g);
            this.g.clear();
        }
        catch (Throwable throwable) {
            this.a.unlock();
            throw throwable;
        }
        this.a.unlock();
        for (TJConnectListener tJConnectListener : arrayList) {
            if (bl2) {
                tJConnectListener.onConnectSuccess();
                continue;
            }
            tJConnectListener.onConnectFailure();
        }
        return;
    }

    /*
     * Exception decompiling
     */
    final boolean a(long var1) {
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

    public abstract boolean a(Context var1, String var2, Hashtable var3, TJConnectListener var4);

    final void b() {
        this.a.lock();
        try {
            this.d = 1000L;
            this.f.signal();
            return;
        }
        finally {
            this.a.unlock();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final boolean b(Context var1_1, String var2_2, Hashtable var3_3, TJConnectListener var4_4) {
        this.a.lock();
        if (var4_4 == null) ** GOTO lbl5
        try {
            block7 : {
                block8 : {
                    block9 : {
                        this.g.addLast(eq.a(var4_4, TJConnectListener.class));
lbl5: // 2 sources:
                        var5_5 = new a(var1_1, var2_2, var3_3);
                        var7_6 = 3.a[this.b - 1];
                        if (var7_6 == 1) ** GOTO lbl30
                        if (var7_6 == 2) break block7;
                        if (var7_6 == 3 || var7_6 == 4) break block8;
                        if (var7_6 == 5) break block9;
                        this.a(c.a);
                        ** GOTO lbl28
                    }
                    this.h = var5_5;
                    this.b();
                    return true;
                }
                this.h = var5_5;
                return true;
            }
            this.e = var5_5;
            ev.b.addObserver(new Observer(this){
                final /* synthetic */ fe a;
                {
                    this.a = fe2;
                }

                public final void update(Observable observable, Object object) {
                    ev.b.deleteObserver((Observer)this);
                    if (!Boolean.valueOf((boolean)Boolean.TRUE.equals(object)).booleanValue() && this.a.e != null && this.a.e.a != null) {
                        fe fe2 = this.a;
                        fe2.c = new /* Unavailable Anonymous Inner Class!! */;
                        this.a.c.e();
                    }
                }
            });
            if (this.a(var5_5.a, var5_5.b, var5_5.c, (TJConnectListener)new 2(this))) {
                var8_7 = c.b;
                this.a(var8_7);
                return true;
            } else {
                this.g.clear();
lbl28: // 2 sources:
                this.a.unlock();
                return false;
lbl30: // 1 sources:
                this.a(true);
            }
            return true;
        }
        finally {
            this.a.unlock();
        }
    }

    final class a {
        public final Context a;
        public final String b;
        public final Hashtable c;

        public a(Context context, String string2, Hashtable hashtable) {
            Context context2 = context != null ? (context instanceof Application ? context : context.getApplicationContext()) : null;
            if (context2 == null) {
                context2 = context;
            }
            this.a = context2;
            this.b = string2;
            this.c = hashtable;
        }
    }

    static final class c
    extends Enum {
        public static final /* enum */ int a = 1;
        public static final /* enum */ int b = 2;
        public static final /* enum */ int c = 3;
        public static final /* enum */ int d = 4;
        public static final /* enum */ int e = 5;
        private static final /* synthetic */ int[] f;

        static {
            int[] arrn = new int[]{a, b, c, d, e};
            f = arrn;
        }

        public static int[] a() {
            return (int[])f.clone();
        }
    }

}

