/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.Exception
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.net.URLEncoder
 *  java.security.MessageDigest
 */
package com.startapp.common.a;

import android.util.Base64;
import com.startapp.common.a.g;
import java.net.URLEncoder;
import java.security.MessageDigest;

public class a {
    private static final byte[] a = new byte[]{10, 30, 84, 95, 101, 20, 0, 14, 15, 80, 36, 84, 64, 82, 84, 64, 80, 80, 65, 78, 84, 73, 70, 82, 65, 85, 68, 75, 69, 89, 1, 2, 3, 8, 15, 42, 10, 51, 44, 32};
    private static final String b = new String(new byte[]{116, 115});
    private static final String c = new String(new byte[]{116, 115, 104});
    private static final String d = new String(new byte[]{97, 102, 104});
    private static final String e = new String(new byte[]{77, 68, 53});
    private static final String f = new String(new byte[]{85, 84, 70, 45, 56});
    private static final byte[] g = new byte[]{12, 31, 86, 96, 103, 10, 28, 15, 17, 28, 36, 84, 64, 82, 84, 64, 80, 80, 69, 78, 67, 82, 89, 80, 84, 73, 79, 78, 75, 69, 89, 4, 32, 18, 16, 18, 11, 53, 45, 34};

    public static String a() {
        return b;
    }

    /*
     * Exception decompiling
     */
    public static String a(String var0) {
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

    public static byte[] a(byte[] arrby, int n2) {
        byte[] arrby2 = new byte[Math.min((int)arrby.length, (int)n2)];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n3 = i2 % n2;
            arrby2[n3] = (byte)(arrby2[n3] ^ arrby[i2]);
        }
        return arrby2;
    }

    public static byte[] a(byte[] arrby, byte[] arrby2) {
        byte[] arrby3 = new byte[arrby.length];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            arrby3[i2] = (byte)(arrby[i2] ^ arrby2[i2 % arrby2.length]);
        }
        return arrby3;
    }

    public static String b() {
        return c;
    }

    public static String b(String string) {
        byte[] arrby;
        byte[] arrby2 = string.getBytes();
        int n2 = arrby2.length < (arrby = a).length ? arrby2.length : arrby.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            arrby2[i2];
            arrby[i2];
        }
        byte[] arrby3 = a.a(string.getBytes(), a[5]);
        String string2 = new String(a);
        byte[] arrby4 = a;
        byte[] arrby5 = a.a(arrby3, string2.substring((int)arrby4[0], (int)arrby4[1]).getBytes());
        try {
            String string3 = URLEncoder.encode((String)Base64.encodeToString((byte[])MessageDigest.getInstance((String)e).digest(arrby5), (int)3), (String)f);
            return string3;
        }
        catch (Exception exception) {
            g.a(6, "error", exception);
            return "";
        }
    }

    public static String c() {
        return d;
    }

    public static String c(String string) {
        long l2;
        int n2 = g.hashCode();
        if ((long)n2 > (l2 = (long)string.getBytes().hashCode())) {
            long l3 = 0xFFFFFFL & 11L + l2 * 29509871405L;
            int n3 = (int)(l3 >>> 17);
            if (n2 < 1000) {
                (long)(n2 & -n2) LCMP l3;
            } else {
                n3 % n2;
            }
        }
        try {
            string = Base64.encodeToString((byte[])a.a(a.a(string.getBytes(), new String(g).substring((int)g[5], (int)g[33]).getBytes()), new String(g).substring((int)g[35], (int)g[1]).getBytes()), (int)0);
        }
        catch (Exception exception) {}
        return string;
    }

    public static String d() {
        int n2 = a.hashCode();
        long l2 = System.currentTimeMillis();
        if (n2 > 0) {
            int n3 = (int)((0xFFFFFFFFFFFFL & 11L + l2 * 25214903917L) >>> 17);
            if ((n2 & -n2) != n2) {
                n3 % n2;
            }
        }
        return new Long(System.currentTimeMillis()).toString();
    }
}

