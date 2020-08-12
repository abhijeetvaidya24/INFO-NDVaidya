/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Closeable
 *  java.io.File
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.io.PrintWriter
 *  java.io.Writer
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.bj;
import com.chartboost.sdk.impl.bk;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

public class bi {
    public static final char a = File.separatorChar;
    public static final String b;

    static {
        bk bk2 = new bk(4);
        PrintWriter printWriter = new PrintWriter((Writer)bk2);
        printWriter.println();
        b = bk2.toString();
        printWriter.close();
    }

    public static int a(InputStream inputStream, OutputStream outputStream) throws IOException {
        long l2 = bi.b(inputStream, outputStream);
        if (l2 > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)l2;
    }

    public static long a(InputStream inputStream, OutputStream outputStream, byte[] arrby) throws IOException {
        int n2;
        long l2 = 0L;
        while (-1 != (n2 = inputStream.read(arrby))) {
            outputStream.write(arrby, 0, n2);
            l2 += (long)n2;
        }
        return l2;
    }

    /*
     * Exception decompiling
     */
    public static void a(Closeable var0) {
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

    public static void a(InputStream inputStream) {
        bi.a((Closeable)inputStream);
    }

    public static byte[] a(InputStream inputStream, int n2) throws IOException {
        IllegalArgumentException illegalArgumentException;
        if (n2 >= 0) {
            int n3;
            int n4;
            if (n2 == 0) {
                return new byte[0];
            }
            byte[] arrby = new byte[n2];
            for (n4 = 0; n4 < n2 && (n3 = inputStream.read(arrby, n4, n2 - n4)) != -1; n4 += n3) {
            }
            if (n4 == n2) {
                return arrby;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected readed size. current: ");
            stringBuilder.append(n4);
            stringBuilder.append(", excepted: ");
            stringBuilder.append(n2);
            throw new IOException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size must be equal or greater than zero: ");
        stringBuilder.append(n2);
        illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    public static byte[] a(InputStream inputStream, long l2) throws IOException {
        if (l2 <= Integer.MAX_VALUE) {
            return bi.a(inputStream, (int)l2);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Size cannot be greater than Integer max value: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        return bi.a(inputStream, outputStream, new byte[4096]);
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        bj bj2 = new bj();
        bi.a(inputStream, bj2);
        return bj2.a();
    }
}

