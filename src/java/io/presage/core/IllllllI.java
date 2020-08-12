/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  io.presage.core.IIlIIIlI
 *  io.presage.core.IIlIIllI
 *  io.presage.core.IlIlIlll
 *  io.presage.core.IllIlIIl
 *  io.presage.core.IlllllIl
 *  io.presage.core.IllllllI$1
 *  io.presage.core.IllllllI$2
 *  io.presage.core.IllllllI$3
 *  io.presage.core.lIIIllII
 *  java.io.ByteArrayInputStream
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.lang.Void
 *  java.util.Iterator
 *  java.util.LinkedList
 *  java.util.Set
 */
package io.presage.core;

import android.content.Context;
import io.presage.core.IIIIIIIl;
import io.presage.core.IIIIIIlI;
import io.presage.core.IIIIIlIl;
import io.presage.core.IIlIIIlI;
import io.presage.core.IIlIIIll;
import io.presage.core.IIlIIllI;
import io.presage.core.IIlIIlll;
import io.presage.core.IlIlIlll;
import io.presage.core.IlIlllll;
import io.presage.core.IllIIIIl;
import io.presage.core.IllIIlIl;
import io.presage.core.IllIIlll;
import io.presage.core.IllIlIIl;
import io.presage.core.IllIllII;
import io.presage.core.IlllIlll;
import io.presage.core.IlllllIl;
import io.presage.core.IllllllI;
import io.presage.core.Illlllll;
import io.presage.core.lIIIIIlI;
import io.presage.core.lIIIllII;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class IllllllI {
    private static IllllllI IIIIIIIl;
    private static final String IIIIIIlI;
    private static final String IIIIIIll;
    private static final String IIIIIlII;
    private static LinkedList<IIlIIIlI> IIIIlIIl;
    private IIIIIIII IIIIIIII;
    private Context IIIIIlIl;
    private final IIIIIIlI IIIIIllI;
    private IlllllIl IIIIIlll;
    private int IIIIlIII;

    static {
        IIIIIIlI = lIIIIIlI.IIIIllIl.IIIIIIII;
        IIIIIIll = lIIIIIlI.IIIIllIl.IIIIIIIl;
        IIIIIlII = lIIIIIlI.IIIIllIl.IIIIIIlI;
        IIIIlIIl = new LinkedList();
    }

    private IllllllI(Context context, IIIIIIlI iIIIIIlI, File file) {
        if (iIIIIIlI != null) {
            this.IIIIIlIl = context;
            this.IIIIIllI = iIIIIIlI;
            try {
                this.IIIIIlll = new IlllllIl(context, file);
                this.IIIIIIlI();
                return;
            }
            catch (IOException iOException) {
                throw new IIIIIIIl(iOException);
            }
        }
        throw new IIIIIIIl();
    }

    public static void IIIIIIII(int n2, String string2) {
        IIlIIIlI iIlIIIlI = new IIlIIIlI(System.currentTimeMillis(), string2, n2);
        Object[] arrobject = new Object[]{iIlIIIlI.IIIIIIlI, iIlIIIlI.IIIIIIIl};
        IllllllI illllllI = IIIIIIIl;
        if (illllllI == null) {
            IIIIlIIl.add((Object)iIlIIIlI);
            return;
        }
        illllllI.IIIIIIII(iIlIIIlI);
    }

    /*
     * Exception decompiling
     */
    public static void IIIIIIII(Context var0, IIIIIIlI var1, File var2) {
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

    private void IIIIIIII(IIlIIIlI iIlIIIlI) {
        Illlllll illlllll2;
        block5 : {
            if (!this.IIIIIIll()) {
                return;
            }
            int n2 = iIlIIIlI.IIIIIIlI;
            for (Illlllll illlllll2 : this.IIIIIllI.IIIIlllI.IIIIlllI) {
                if (illlllll2.IIIIIIII != n2) continue;
                break block5;
            }
            illlllll2 = null;
        }
        if (illlllll2 == null) {
            new Object[1][0] = iIlIIIlI.IIIIIIlI;
            return;
        }
        try {
            IIlIIllI iIlIIllI = IIlIIlll.IIIIIIII().IIIIIIIl();
            new IlIlIlll(this.IIIIIlIl, (IIIIIlIl)iIlIIIlI, (IlIlIlll.IIIIIIII)new 1(this, illlllll2)).IIIIIIII(iIlIIllI, false, (Object[])new Void[0]);
            return;
        }
        catch (IIlIIIll iIlIIIll) {
            IlIlllll.IIIIIIII(iIlIIIll, 0);
            return;
        }
    }

    public static void IIIIIIII(IlllIlll.IIIIIIII iIIIIIII) {
        IllllllI illllllI = IIIIIIIl;
        if (illllllI == null) {
            return;
        }
        illllllI.IIIIIlll.IIIIIlII = iIIIIIII;
    }

    /*
     * Exception decompiling
     */
    public static void IIIIIIII(IIIIIIII var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl112 : IINC : trying to set 1 previously set to 0
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

    static /* synthetic */ void IIIIIIII(IllllllI illllllI) {
        illllllI.IIIIIlII();
    }

    static /* synthetic */ void IIIIIIII(IllllllI illllllI, byte[] arrby) {
        IllIIlll illIIlll = new IllIIlll(illllllI.IIIIIllI.IIIIlllI.IIIIllIl, IllIIlll.IIIIIIII, (IllIIlIl)new IllIlIIl(illllllI.IIIIIlIl, illllllI.IIIIIllI.IIIIIIlI(), illllllI.IIIIIllI.IIIIIIll(), illllllI.IIIIIllI.IIIIIlIl()), (InputStream)new ByteArrayInputStream(arrby));
        IllIIIIl.IIIIIIII(IIlIIlll.IIIIIIII().IIIIIIlI(), illIIlll, (IllIIIIl.IIIIIIII)new 2(illllllI, arrby));
    }

    public static boolean IIIIIIII() {
        IllllllI illllllI = IIIIIIIl;
        if (illllllI == null) {
            return false;
        }
        return illllllI.IIIIIlll.IIIIIIII(true).length > 0;
    }

    static /* synthetic */ int IIIIIIIl(IllllllI illllllI) {
        int n2 = illllllI.IIIIlIII;
        illllllI.IIIIlIII = n2 + 1;
        return n2;
    }

    public static void IIIIIIIl() {
        IllllllI illllllI = IIIIIIIl;
        if (illllllI == null) {
            return;
        }
        lIIIllII.IIIIIIII((File)illllllI.IIIIIlll.IIIIIIll);
    }

    static /* synthetic */ void IIIIIIIl(IllllllI illllllI, byte[] arrby) {
        IIlIIllI iIlIIllI = IIlIIlll.IIIIIIII().IIIIIIll();
        illllllI.IIIIIlll.IIIIIIII(iIlIIllI, arrby, (IlllIlll.IIIIIIlI)new 3(illllllI));
    }

    static /* synthetic */ int IIIIIIlI(IllllllI illllllI) {
        return illllllI.IIIIlIII;
    }

    private void IIIIIIlI() {
        Iterator iterator = IIIIlIIl.iterator();
        while (iterator.hasNext()) {
            this.IIIIIIII((IIlIIIlI)iterator.next());
        }
        IIIIlIIl.clear();
    }

    private boolean IIIIIIll() {
        return this.IIIIIllI.IIIIlllI != null && this.IIIIIllI.IIIIlllI.IIIIllII && this.IIIIIllI.IIIIlllI.IIIIIlIl;
    }

    private void IIIIIlII() {
        IIIIIIII iIIIIIII = this.IIIIIIII;
        if (iIIIIIII != null) {
            iIIIIIII.IIIIIIII();
        }
    }

    public static interface IIIIIIII {
        public void IIIIIIII();
    }

}

