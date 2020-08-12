/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  co.ogury.crashreport.ii
 *  java.lang.CharSequence
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 */
package co.ogury.crashreport;

import co.ogury.crashreport.ii;
import co.ogury.crashreport.margl1440;
import co.ogury.crashreport.tx2160;
import co.ogury.crashreport.tx8640;

public final class tx2880 {
    public static final tx2160 a;

    /*
     * Exception decompiling
     */
    static {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl237 : ALOAD_1 : trying to set 1 previously set to 0
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

    private static final int a() {
        block7 : {
            block8 : {
                int n2;
                int n3;
                CharSequence charSequence;
                int n4;
                int n5;
                String string;
                block6 : {
                    int n6;
                    string = System.getProperty((String)"java.specification.version");
                    n3 = 65542;
                    if (string == null) {
                        return n3;
                    }
                    charSequence = string;
                    n5 = ii.a((CharSequence)charSequence, (char)'.', (int)0, (boolean)false, (int)6);
                    if (n5 >= 0) break block6;
                    try {
                        n6 = Integer.parseInt((String)string);
                    }
                    catch (NumberFormatException numberFormatException) {}
                    n3 = n6 << 16;
                    return n3;
                }
                int n7 = n5 + 1;
                int n8 = ii.a((CharSequence)charSequence, (char)'.', (int)n7, (boolean)false, (int)4);
                if (n8 < 0) {
                    n8 = string.length();
                }
                if (string == null) break block7;
                String string2 = string.substring(0, n5);
                tx8640.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                if (string == null) break block8;
                String string3 = string.substring(n7, n8);
                tx8640.a((Object)string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                try {
                    n4 = Integer.parseInt((String)string2) << 16;
                    n2 = Integer.parseInt((String)string3);
                }
                catch (NumberFormatException numberFormatException) {}
                n3 = n4 + n2;
                return n3;
            }
            throw new margl1440("null cannot be cast to non-null type java.lang.String");
        }
        throw new margl1440("null cannot be cast to non-null type java.lang.String");
    }
}

