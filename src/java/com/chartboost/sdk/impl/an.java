/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.chartboost.sdk.Tracking.a
 *  java.io.IOException
 *  java.lang.Class
 *  java.lang.Comparable
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.net.SocketTimeoutException
 *  java.util.concurrent.Executor
 *  java.util.concurrent.atomic.AtomicInteger
 */
package com.chartboost.sdk.impl;

import android.os.Handler;
import com.chartboost.sdk.Libraries.i;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.a;
import com.chartboost.sdk.impl.ad;
import com.chartboost.sdk.impl.af;
import com.chartboost.sdk.impl.ag;
import com.chartboost.sdk.impl.ai;
import com.chartboost.sdk.impl.ao;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public class an<T>
implements Comparable<an>,
Runnable {
    public final ad<T> a;
    private final Executor b;
    private final ao c;
    private final ai d;
    private final i e;
    private final Handler f;
    private af<T> g;
    private ag h;

    an(Executor executor, ao ao2, ai ai2, i i2, Handler handler, ad<T> ad2) {
        this.b = executor;
        this.c = ao2;
        this.d = ai2;
        this.e = i2;
        this.f = handler;
        this.a = ad2;
    }

    private ag a(ad<T> ad2) throws IOException {
        int n2 = 10000;
        int n3 = 0;
        do {
            try {
                ag ag2 = this.a(ad2, n2);
                return ag2;
            }
            catch (SocketTimeoutException socketTimeoutException) {
                if (n3 < 1) {
                    n2 *= 2;
                    ++n3;
                    continue;
                }
                throw socketTimeoutException;
            }
            break;
        } while (true);
    }

    /*
     * Exception decompiling
     */
    private ag a(ad<T> var1, int var2) throws IOException {
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

    private static boolean a(int n2) {
        boolean bl = 100 <= n2 && n2 < 200;
        return !bl && n2 != 204 && n2 != 304;
    }

    public int a(an an2) {
        return this.a.d - an2.a.d;
    }

    public /* synthetic */ int compareTo(Object object) {
        return this.a((an)object);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void run() {
        block20 : {
            var1_1 = this.g;
            if (var1_1 != null) {
                try {
                    if (var1_1.b == null) {
                        this.a.a(this.g.a, this.h);
                        return;
                    }
                    this.a.a(this.g.b, this.h);
                    return;
                }
                catch (Exception var16_2) {
                    a.a((Class)this.getClass(), (String)"deliver result", (Exception)var16_2);
                    return;
                }
            }
            if (!this.a.e.compareAndSet(0, 1)) {
                return;
            }
            var2_3 = this.e.b();
            if (this.d.b()) {
                this.h = this.a(this.a);
                var11_4 = this.h.a;
                if (var11_4 >= 200 && var11_4 < 300) {
                    this.g = this.a.a(this.h);
                } else {
                    var12_5 = CBError.a.e;
                    var13_6 = new StringBuilder();
                    var13_6.append("Failure due to HTTP status code ");
                    var13_6.append(var11_4);
                    this.g = af.a(new CBError(var12_5, var13_6.toString()));
                }
                break block20;
            }
            this.g = af.a(new CBError(CBError.a.b, "Internet Unavailable"));
        }
        this.a.g = this.e.b() - var2_3;
        var10_7 = this.a.j;
        if (var10_7 == 0) ** GOTO lbl43
        if (var10_7 != 1) {
            return;
        }
        ** GOTO lbl47
        {
            block21 : {
                catch (Throwable var7_8) {
                }
                catch (Throwable var4_9) {}
                {
                    this.g = af.a(new CBError(CBError.a.e, var4_9.toString()));
                }
                this.a.g = this.e.b() - var2_3;
                var5_10 = this.a.j;
                if (var5_10 != 0) break block21;
lbl43: // 2 sources:
                this.f.post((Runnable)this);
                return;
            }
            if (var5_10 != 1) return;
lbl47: // 2 sources:
            this.b.execute((Runnable)this);
            return;
        }
        this.a.g = this.e.b() - var2_3;
        var8_11 = this.a.j;
        if (var8_11 == 0) {
            this.f.post((Runnable)this);
            throw var7_8;
        }
        if (var8_11 != 1) {
            throw var7_8;
        }
        this.b.execute((Runnable)this);
        throw var7_8;
    }
}

