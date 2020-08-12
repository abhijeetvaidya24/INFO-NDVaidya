/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Timer
 *  java.util.TimerTask
 */
package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.util.Timer;
import java.util.TimerTask;

public class k {
    private final j a;
    private Timer b;
    private long c;
    private long d;
    private final Runnable e;
    private long f;
    private final Object g = new Object();

    private k(j j2, Runnable runnable) {
        this.a = j2;
        this.e = runnable;
    }

    public static k a(long l2, j j2, Runnable runnable) {
        if (l2 >= 0L) {
            if (runnable != null) {
                k k2 = new k(j2, runnable);
                k2.c = System.currentTimeMillis();
                k2.d = l2;
                k2.b = new Timer();
                k2.b.schedule(k2.e(), l2);
                return k2;
            }
            throw new IllegalArgumentException("Cannot create a scheduled timer. Runnable is null.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot create a scheduled timer. Invalid fire time passed in: ");
        stringBuilder.append(l2);
        stringBuilder.append(".");
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private TimerTask e() {
        return new TimerTask(){

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Converted monitor instructions to comments
             * Lifted jumps to return sites
             */
            public void run() {
                Object object2;
                Object object;
                Throwable throwable2222;
                k.this.e.run();
                Object object3 = object = k.this.g;
                // MONITORENTER : object3
                k.this.b = null;
                // MONITOREXIT : object3
                return;
                {
                    Object object4;
                    block11 : {
                        catch (Throwable throwable2222) {
                        }
                        catch (Throwable throwable3) {}
                        {
                            if (k.this.a == null) break block11;
                            k.this.a.u().b("Timer", "Encountered error while executing timed task", throwable3);
                        }
                    }
                    Object object5 = object4 = k.this.g;
                    // MONITORENTER : object5
                    k.this.b = null;
                    // MONITOREXIT : object5
                    return;
                }
                Object object6 = object2 = k.this.g;
                // MONITORENTER : object6
                k.this.b = null;
                // MONITOREXIT : object6
                throw throwable2222;
            }
        };
    }

    public long a() {
        if (this.b != null) {
            long l2 = System.currentTimeMillis() - this.c;
            return this.d - l2;
        }
        return this.d - this.f;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void b() {
        var6_2 = var1_1 = this.g;
        // MONITORENTER : var6_2
        var3_3 = this.b;
        if (var3_3 == null) ** GOTO lbl-1000
        this.b.cancel();
        this.f = System.currentTimeMillis() - this.c;
        ** GOTO lbl12
lbl-1000: // 1 sources:
        {
            // MONITOREXIT : var6_2
            return;
lbl12: // 3 sources:
            do {
                this.b = null;
                return;
                break;
            } while (true);
            {
                catch (Throwable var5_4) {
                }
                catch (Throwable var4_5) {}
                {
                    if (this.a == null) ** GOTO lbl12
                    this.a.u().b("Timer", "Encountered error while pausing timer", var4_5);
                    ** continue;
                }
            }
            ** try [egrp 4[TRYBLOCK] [5 : 79->98)] { 
lbl23: // 1 sources:
            this.b = null;
            throw var5_4;
        }
lbl25: // 3 sources:
        catch (Throwable var2_6) {
            // MONITOREXIT : var6_2
            throw var2_6;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void c() {
        var7_2 = var1_1 = this.g;
        // MONITORENTER : var7_2
        var3_3 = this.f;
        if (var3_3 <= 0L) ** GOTO lbl-1000
        this.d -= this.f;
        if (this.d < 0L) {
            this.d = 0L;
        }
        this.b = new Timer();
        this.b.schedule(this.e(), this.d);
        this.c = System.currentTimeMillis();
        ** GOTO lbl16
lbl-1000: // 1 sources:
        {
            // MONITOREXIT : var7_2
            return;
lbl16: // 3 sources:
            do {
                this.f = 0L;
                return;
                break;
            } while (true);
            {
                catch (Throwable var6_4) {
                }
                catch (Throwable var5_5) {}
                {
                    if (this.a == null) ** GOTO lbl16
                    this.a.u().b("Timer", "Encountered error while resuming timer", var5_5);
                    ** continue;
                }
            }
            ** try [egrp 4[TRYBLOCK] [7 : 122->141)] { 
lbl27: // 1 sources:
            this.f = 0L;
            throw var6_4;
        }
lbl29: // 3 sources:
        catch (Throwable var2_6) {
            // MONITOREXIT : var7_2
            throw var2_6;
        }
    }

    /*
     * Exception decompiling
     */
    public void d() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 4[TRYBLOCK]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

}

