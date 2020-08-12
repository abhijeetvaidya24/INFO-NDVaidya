/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.IllegalAccessException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuffer
 *  java.lang.StringBuilder
 *  java.lang.reflect.InvocationTargetException
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.d;
import java.lang.reflect.InvocationTargetException;

public final class e {
    public static <T extends d> String a(T t2) {
        if (t2 == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            e.a(null, t2, new StringBuffer(), stringBuffer);
        }
        catch (InvocationTargetException invocationTargetException) {
            StringBuilder stringBuilder = new StringBuilder("Error printing proto: ");
            stringBuilder.append(invocationTargetException.getMessage());
            return stringBuilder.toString();
        }
        catch (IllegalAccessException illegalAccessException) {
            StringBuilder stringBuilder = new StringBuilder("Error printing proto: ");
            stringBuilder.append(illegalAccessException.getMessage());
            return stringBuilder.toString();
        }
        return stringBuffer.toString();
    }

    private static String a(String string2) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            char c2 = string2.charAt(i2);
            if (i2 == 0) {
                stringBuffer.append(Character.toLowerCase((char)c2));
                continue;
            }
            if (Character.isUpperCase((char)c2)) {
                stringBuffer.append('_');
                stringBuffer.append(Character.toLowerCase((char)c2));
                continue;
            }
            stringBuffer.append(c2);
        }
        return stringBuffer.toString();
    }

    /*
     * Exception decompiling
     */
    private static void a(String var0, Object var1, StringBuffer var2, StringBuffer var3) throws IllegalAccessException, InvocationTargetException {
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

    private static void a(byte[] arrby, StringBuffer stringBuffer) {
        if (arrby == null) {
            stringBuffer.append("\"\"");
            return;
        }
        stringBuffer.append('\"');
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n2 = 255 & arrby[i2];
            if (n2 != 92 && n2 != 34) {
                if (n2 >= 32 && n2 < 127) {
                    stringBuffer.append((char)n2);
                    continue;
                }
                Object[] arrobject = new Object[]{n2};
                stringBuffer.append(String.format((String)"\\%03o", (Object[])arrobject));
                continue;
            }
            stringBuffer.append('\\');
            stringBuffer.append((char)n2);
        }
        stringBuffer.append('\"');
    }

    private static String b(String string2) {
        int n2 = string2.length();
        StringBuilder stringBuilder = new StringBuilder(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string2.charAt(i2);
            if (c2 >= ' ' && c2 <= '~' && c2 != '\"' && c2 != '\'') {
                stringBuilder.append(c2);
                continue;
            }
            Object[] arrobject = new Object[]{(int)c2};
            stringBuilder.append(String.format((String)"\\u%04x", (Object[])arrobject));
        }
        return stringBuilder.toString();
    }
}

