/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  io.presage.core.IlllIlIl
 *  io.presage.core.lIIIlIlI
 *  io.presage.core.lIIIlIlI$IIlIIllI
 *  io.presage.core.lIIIllII
 *  java.io.File
 *  java.io.IOException
 *  java.io.PrintWriter
 *  java.io.StringWriter
 *  java.io.Writer
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Thread
 *  java.lang.Throwable
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package io.presage.core;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import io.presage.core.IIIIIIIl;
import io.presage.core.IIIIIIlI;
import io.presage.core.IIIlIIII;
import io.presage.core.IllIllII;
import io.presage.core.IlllIlIl;
import io.presage.core.IllllIIl;
import io.presage.core.lIIIIIII;
import io.presage.core.lIIIIIll;
import io.presage.core.lIIIlIlI;
import io.presage.core.lIIIllII;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class IlIlllll {
    static IlIlllll IIIIIIII;
    Context IIIIIIIl;
    final IIIIIIlI IIIIIIlI;
    IlllIlIl IIIIIIll;
    private boolean IIIIIlII;
    private int IIIIIlIl;
    private int IIIIIllI;

    private IlIlllll(Context context, IIIIIIlI iIIIIIlI, File file) {
        if (iIIIIIlI != null) {
            this.IIIIIIIl = context;
            this.IIIIIIlI = iIIIIIlI;
            this.IIIIIlII = false;
            this.IIIIIllI = 0;
            try {
                this.IIIIIIll = new IlllIlIl(file);
                return;
            }
            catch (IOException iOException) {
                throw new IIIIIIIl(iOException);
            }
        }
        throw new IIIIIIIl();
    }

    /* synthetic */ IlIlllll(Context context, IIIIIIlI iIIIIIlI, File file, byte by) {
        this(context, iIIIIIlI, file);
    }

    static /* synthetic */ void IIIIIIII(IlIlllll ilIlllll) {
        ilIlllll.IIIIIllI = 1 + ilIlllll.IIIIIllI;
        new Object[1][0] = ilIlllll.IIIIIllI;
        if (ilIlllll.IIIIIllI == 1) {
            ilIlllll.IIIIIIlI();
        }
    }

    public static void IIIIIIII(final Exception exception, int n2) {
        if (n2 == 1) {
            new Handler(Looper.getMainLooper()).post(new Runnable(){

                /*
                 * Exception decompiling
                 */
                public final void run() {
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
            });
        }
    }

    private void IIIIIIIl() {
        --this.IIIIIllI;
        new Object[1][0] = this.IIIIIllI;
        if (this.IIIIIllI > 0) {
            this.IIIIIIlI();
        }
    }

    /*
     * Exception decompiling
     */
    private void IIIIIIlI() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl122 : IINC : trying to set 1 previously set to 0
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

    final void IIIIIIII(File[] arrfile) {
        this.IIIIIlIl = 1 + this.IIIIIlIl;
        if (this.IIIIIlIl == arrfile.length) {
            this.IIIIIIIl();
        }
    }

    final boolean IIIIIIII() {
        return this.IIIIIIlI.IIIIlllI != null && this.IIIIIIlI.IIIIlllI.IIIIIIlI && this.IIIIIIlI.IIIIlllI.IIIIIlIl;
    }

    public static final class IIIIIIII {
        private static final String IIIIIIII = lIIIlIlI.IIlIIllI.IIIIIIII;
        private static final String IIIIIIIl = lIIIlIlI.IIlIIllI.IIIIIIIl;
        private static final String IIIIIIlI = lIIIlIlI.IIlIIllI.IIIIIIlI;
        private static final String IIIIIIll = lIIIlIlI.IIlIIllI.IIIIIIll;
        private static final String IIIIIlII = lIIIlIlI.IIlIIllI.IIIIIlII;
        private static final String IIIIIlIl = lIIIlIlI.IIlIIllI.IIIIIlIl;
        private static final String IIIIIllI = lIIIlIlI.IIlIIllI.IIIIIllI;
        private static final String IIIIIlll = lIIIlIlI.IIlIIllI.IIIIIlll;
        private static final String IIIIlIII = lIIIlIlI.IIlIIllI.IIIIlIII;
        private static final String IIIIlIIl = lIIIlIlI.IIlIIllI.IIIIlIIl;
        private static final String IIIIlIlI = lIIIlIlI.IIlIIllI.IIIIlIlI;

        public static String IIIIIIII(Context context, IIIIIIlI iIIIIIlI, Exception exception) {
            try {
                JSONArray jSONArray = new JSONArray();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(IIIIIIII, System.currentTimeMillis());
                jSONObject.put(IIIIIIIl, (Object)IIIIIIlI.IIIIIIIl());
                jSONObject.put(IIIIIIlI, (Object)iIIIIIlI.IIIIIIlI());
                jSONObject.put(IIIIIIll, (Object)iIIIIIlI.IIIIIIll());
                jSONObject.put(IIIIIlII, (Object)context.getPackageName());
                jSONObject.put(IIIIIlIl, (Object)lIIIIIII.IIIIIIII(context));
                jSONObject.put(IIIIIllI, (Object)lIIIIIll.IIIIIIII((Context)context).IIIIIIlI);
                jSONObject.put(IIIIIlll, (Object)Build.VERSION.RELEASE);
                jSONObject.put(IIIIlIII, (Object)exception.getClass().getName());
                String string2 = IIIIlIIl;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(exception.getClass().getName());
                stringBuilder.append(" : ");
                stringBuilder.append(exception.getMessage());
                jSONObject.put(string2, (Object)stringBuilder.toString());
                StringWriter stringWriter = new StringWriter();
                exception.printStackTrace(new PrintWriter((Writer)stringWriter));
                jSONObject.put(IIIIlIlI, (Object)stringWriter.getBuffer().toString());
                jSONArray.put((Object)jSONObject);
                String string3 = jSONArray.toString();
                return string3;
            }
            catch (JSONException jSONException) {
                return null;
            }
        }
    }

}

