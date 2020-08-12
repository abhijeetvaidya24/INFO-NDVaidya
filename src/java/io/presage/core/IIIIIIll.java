/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  io.presage.core.IIIIIIll$1
 *  io.presage.core.IIlIIllI
 *  io.presage.core.IIlIlIII
 *  io.presage.core.IIlIlIlI$1
 *  io.presage.core.IlIlllII
 *  io.presage.core.IlllIllI
 *  io.presage.core.lIIIlIlI
 *  io.presage.core.lIIIlIlI$IIIlllII
 *  io.presage.core.lIIIllII
 *  io.presage.core.lIIlIIll
 *  io.presage.core.lIIlIIll$IIIIIIII
 *  io.presage.core.lIIlIIll$IIIIIIIl
 *  io.presage.core.lIlIlIll
 *  java.io.File
 *  java.io.IOException
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Set
 *  java.util.concurrent.atomic.AtomicBoolean
 */
package io.presage.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import io.presage.core.IIIIIIlI;
import io.presage.core.IIIIIIll;
import io.presage.core.IIlIIIll;
import io.presage.core.IIlIIlII;
import io.presage.core.IIlIIllI;
import io.presage.core.IIlIlIII;
import io.presage.core.IIlIlIIl;
import io.presage.core.IIlIlIlI;
import io.presage.core.IIlIlIll;
import io.presage.core.IIlIllII;
import io.presage.core.IlIllIII;
import io.presage.core.IlIlllII;
import io.presage.core.IlIlllIl;
import io.presage.core.IlIlllll;
import io.presage.core.IllIllII;
import io.presage.core.IllIlllI;
import io.presage.core.IlllIllI;
import io.presage.core.IlllIlll;
import io.presage.core.IllllllI;
import io.presage.core.lIIIlIlI;
import io.presage.core.lIIIllII;
import io.presage.core.lIIlIIll;
import io.presage.core.lIlIlIll;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class IIIIIIll {
    private static IIIIIIll IIIIIlII;
    final Context IIIIIIII;
    AtomicBoolean IIIIIIIl;
    IIlIIlII IIIIIIlI;
    IIIIIIlI IIIIIIll;
    private IIIIIIII IIIIIlIl;
    private IlIlllII IIIIIllI;
    private IIlIlIlI IIIIIlll;

    private IIIIIIll(Context context) {
        this.IIIIIIII = context.getApplicationContext();
        this.IIIIIIIl = new AtomicBoolean(false);
    }

    public static IIIIIIll IIIIIIII(Context context) {
        if (IIIIIlII == null) {
            IIIIIlII = new IIIIIIll(context);
        }
        return IIIIIlII;
    }

    private void IIIIIIII(Exception exception) {
        this.IIIIIIII(exception, 1);
    }

    /*
     * Exception decompiling
     */
    public final void IIIIIIII() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 16[CATCHBLOCK]
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

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public final void IIIIIIII(IIIIIIlI iIIIIIlI, IIIIIIII iIIIIIII) {
        if (iIIIIIlI == null) {
            this.IIIIIIII((Exception)new NullPointerException());
        }
        if (this.IIIIIIIl.get()) return;
        this.IIIIIIIl.set(true);
        IllllllI.IIIIIIII(1001, lIIIlIlI.IIIlllII.IIIIIIII);
        this.IIIIIlIl = iIIIIIII;
        this.IIIIIIll = iIIIIIlI;
        this.IIIIIIlI = new IIlIIlII();
        this.IIIIIlll = new IIlIlIlI(this.IIIIIIII, new File(this.IIIIIIll.IIIIlIII.getFilesDir(), IIIIIIlI.IIIIIIII), new File(this.IIIIIIll.IIIIlIII.getFilesDir(), IIIIIIlI.IIIIIIIl));
        boolean bl2 = this.IIIIIIIl.get();
        if (!bl2) return;
        {
            catch (Exception exception) {
                this.IIIIIIII(exception);
                return;
            }
        }
        try {
            lIIlIIll lIIlIIll2 = new lIIlIIll(this.IIIIIIII);
            IIlIIllI iIlIIllI = this.IIIIIIlI.IIIIIIll;
            lIIlIIll2.IIIIIIII = new 1(this);
            try {
                new lIIlIIll.IIIIIIII(lIIlIIll2, 0).IIIIIIII(iIlIIllI, false, (Object[])new Void[0]);
                return;
            }
            catch (IIlIIIll iIlIIIll) {
                lIIlIIll2.IIIIIIII((Exception)iIlIIIll, 0);
                return;
            }
        }
        catch (Exception exception) {
            this.IIIIIIII(exception);
            return;
        }
    }

    final void IIIIIIII(Exception exception, int n2) {
        IlIlllll.IIIIIIII(exception, n2);
        this.IIIIIIIl();
    }

    final void IIIIIIIl() {
        this.IIIIIIII();
        IIIIIIII iIIIIIII = this.IIIIIlIl;
        if (iIIIIIII != null) {
            iIIIIIII.IIIIIIII();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    final void IIIIIIlI() {
        block25 : {
            Handler handler;
            Object object;
            if (!this.IIIIIIIl.get()) {
                return;
            }
            if (this.IIIIIIll.IIIIlllI == null) {
                this.IIIIIIII(new IllIlllI());
                return;
            }
            if (this.IIIIIIll.IIIIlllI.IIIIIIlI && this.IIIIIIll.IIIIlllI.IIIIIlIl) {
                handler = new Handler(Looper.getMainLooper());
                object = new Runnable(){

                    public final void run() {
                        Object[] arrobject = new Object[]{java.lang.Thread.currentThread().getId(), java.lang.Thread.currentThread().getName()};
                        if (IlIlllll.IIIIIIII == null) {
                            return;
                        }
                        IlIlllll.IIIIIIII(IlIlllll.IIIIIIII);
                    }
                };
            } else {
                handler = new Handler(Looper.getMainLooper());
                object = new Runnable(){

                    public final void run() {
                        Object[] arrobject = new Object[]{java.lang.Thread.currentThread().getId(), java.lang.Thread.currentThread().getName()};
                        if (IlIlllll.IIIIIIII == null) {
                            return;
                        }
                        lIIIllII.IIIIIIII((File)IlIlllll.IIIIIIII.IIIIIIll.IIIIIIII);
                    }
                };
            }
            handler.post(object);
            if (!this.IIIIIIll.IIIIlllI.IIIIllII || !this.IIIIIIll.IIIIlllI.IIIIIlIl) {
                IllllllI.IIIIIIIl();
            }
            if (this.IIIIIIll.IIIIlllI.IIIIlIlI) {
                Set<Integer> set = this.IIIIIIll.IIIIlllI.IIIIlIll;
                if (this.IIIIIIIl.get()) {
                    try {
                        IlIlllIl ilIlllIl = new IlIlllIl((ArrayList<Integer>)new ArrayList(set));
                        IlIlllII ilIlllII = this.IIIIIllI = new IlIlllII(this.IIIIIIII, ilIlllIl);
                        if (!ilIlllII.IIIIIIIl) {
                            ilIlllII.IIIIIIIl = true;
                            ilIlllII.IIIIIIII();
                        }
                    }
                    catch (Exception exception) {
                        IlIlllll.IIIIIIII(exception, 1);
                    }
                }
            }
            for (lIlIlIll lIlIlIll2 : this.IIIIIIll.IIIIlllI.IIIIlIIl) {
                if (lIlIlIll2.IIIIIlII()) {
                    lIlIlIll2.IIIIIIIl();
                    continue;
                }
                lIlIlIll2.IIIIIIlI();
            }
            if (this.IIIIIIll.IIIIlllI.IIIIIlIl) {
                IllIllII illIllII = this.IIIIIIll.IIIIlllI;
                if (this.IIIIIIIl.get()) {
                    try {
                        IIlIllII.IIIIIIII iIIIIIII = new IIlIllII.IIIIIIII();
                        IIlIIllI iIlIIllI = this.IIIIIIlI.IIIIIIIl;
                        int n2 = illIllII.IIIIIlll.IIIIIIII;
                        long l2 = 1024L * illIllII.IIIIIlll.IIIIIIIl;
                        iIIIIIII.IIIIIIII.IIIIIIII = iIlIIllI;
                        iIIIIIII.IIIIIIII.IIIIIIIl = n2;
                        iIIIIIII.IIIIIIII.IIIIIIlI = l2;
                        iIIIIIII.IIIIIIIl = true;
                        IIlIlIII iIlIlIII = this.IIIIIIlI.IIIIIIII;
                        Set<IIlIlIIl> set = illIllII.IIIIlIII;
                        iIIIIIII.IIIIIIII.IIIIIIll = iIlIlIII;
                        iIIIIIII.IIIIIIII.IIIIIlII = set;
                        iIIIIIII.IIIIIIlI = true;
                        IIlIIllI iIlIIllI2 = this.IIIIIIlI.IIIIIIlI;
                        String string2 = this.IIIIIIll.IIIIIIlI();
                        String string3 = this.IIIIIIll.IIIIIIll();
                        int n3 = this.IIIIIIll.IIIIIlIl();
                        String string4 = illIllII.IIIIIIIl;
                        iIIIIIII.IIIIIIII.IIIIIlIl = iIlIIllI2;
                        iIIIIIII.IIIIIIII.IIIIIllI = string2;
                        iIIIIIII.IIIIIIII.IIIIIlll = string3;
                        iIIIIIII.IIIIIIII.IIIIlIII = n3;
                        iIIIIIII.IIIIIIII.IIIIlIIl = string4;
                        iIIIIIII.IIIIIIll = true;
                        IIlIlIlI iIlIlIlI = this.IIIIIlll;
                        if (iIIIIIII.IIIIIIII.IIIIIIII == null) {
                            throw new IIlIlIll();
                        }
                        if (!iIIIIIII.IIIIIIIl || !iIIIIIII.IIIIIIlI || !iIIIIIII.IIIIIIll) throw new IIlIlIll();
                        if (iIIIIIII.IIIIIIII.IIIIIIll == null) {
                            throw new IIlIlIll();
                        }
                        if (iIIIIIII.IIIIIIII.IIIIIlII == null) {
                            throw new IIlIlIll();
                        }
                        if (iIIIIIII.IIIIIIII.IIIIIlIl == null) {
                            throw new IIlIlIll();
                        }
                        if (!iIIIIIII.IIIIIIII.IIIIIlII.isEmpty() && (iIIIIIII.IIIIIIII.IIIIlIIl == null || iIIIIIII.IIIIIIII.IIIIlIIl.isEmpty())) {
                            throw new IIlIlIll();
                        }
                        IIlIllII iIlIllII = iIIIIIII.IIIIIIII;
                        if (iIlIlIlI.IIIIIIIl) break block25;
                        iIlIlIlI.IIIIIIIl = true;
                        iIlIlIlI.IIIIIlII = iIlIllII;
                        try {
                            IlllIllI illlIllI;
                            iIlIlIlI.IIIIIlIl = illlIllI = new IlllIllI(iIlIlIlI.IIIIIIII, iIlIlIlI.IIIIIIlI, iIlIlIlI.IIIIIlII.IIIIIIIl, iIlIlIlI.IIIIIlII.IIIIIIlI);
                            iIlIlIlI.IIIIIlIl.IIIIIIII((IlllIlll.IIIIIIII)new IIlIlIlI.1(iIlIlIlI));
                        }
                        catch (IOException iOException) {
                            throw new IIlIlIll(iOException);
                        }
                        iIlIlIlI.IIIIIIII();
                        iIlIlIlI.IIIIIIII(iIlIlIlI.IIIIIlIl.IIIIIIII(true));
                    }
                    catch (Exception exception) {
                        IlIlllll.IIIIIIII(exception, 1);
                    }
                }
            } else {
                this.IIIIIIll();
            }
        }
        if (this.IIIIIIll.IIIIlllI.IIIIIIlI || this.IIIIIIll.IIIIlllI.IIIIllII || this.IIIIIIll.IIIIlllI.IIIIlIlI || this.IIIIIIll.IIIIlllI.IIIIIlIl && !this.IIIIIIll.IIIIlllI.IIIIlIII.isEmpty()) return;
        {
            this.IIIIIIIl();
            return;
        }
    }

    final void IIIIIIll() {
        try {
            IIlIlIlI iIlIlIlI = this.IIIIIlll;
            lIIIllII.IIIIIIII((File)iIlIlIlI.IIIIIIlI);
            IIlIlIIl.IIIIIIII(iIlIlIlI.IIIIIIII, iIlIlIlI.IIIIIIll);
            return;
        }
        catch (Exception exception) {
            IlIlllll.IIIIIIII(exception, 1);
            return;
        }
    }

    public static interface IIIIIIII {
        public void IIIIIIII();
    }

}

