/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.tapjoy;

public class TapjoyErrorMessage {
    private ErrorType a;
    private String b;

    public TapjoyErrorMessage(ErrorType errorType, String string2) {
        this.a = errorType;
        this.b = string2;
    }

    public ErrorType getType() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder("Type=");
        stringBuilder2.append(this.a.toString());
        stringBuilder.append(stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder(";Message=");
        stringBuilder3.append(this.b);
        stringBuilder.append(stringBuilder3.toString());
        return stringBuilder.toString();
    }

    public static final class ErrorType
    extends Enum {
        public static final /* enum */ ErrorType INTEGRATION_ERROR;
        public static final /* enum */ ErrorType INTERNAL_ERROR;
        public static final /* enum */ ErrorType NETWORK_ERROR;
        public static final /* enum */ ErrorType SDK_ERROR;
        public static final /* enum */ ErrorType SERVER_ERROR;
        private static final /* synthetic */ ErrorType[] a;

        static {
            INTERNAL_ERROR = new ErrorType("INTERNAL_ERROR", 0);
            SDK_ERROR = new ErrorType("SDK_ERROR", 1);
            SERVER_ERROR = new ErrorType("SERVER_ERROR", 2);
            INTEGRATION_ERROR = new ErrorType("INTEGRATION_ERROR", 3);
            NETWORK_ERROR = new ErrorType("NETWORK_ERROR", 4);
            ErrorType[] arrerrorType = new ErrorType[]{INTERNAL_ERROR, SDK_ERROR, SERVER_ERROR, INTEGRATION_ERROR, NETWORK_ERROR};
            a = arrerrorType;
        }

        /*
         * Exception decompiling
         */
        private ErrorType() {
            // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
            // java.lang.IllegalStateException
            // org.benf.cfr.reader.b.a.f.g.a(VariableFactory.java:53)
            // org.benf.cfr.reader.b.a.a.g.b(Op02WithProcessedDataAndRefs.java:911)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:959)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:56)
            // org.benf.cfr.reader.b.a.a.g$3.a(Op02WithProcessedDataAndRefs.java:2010)
            // org.benf.cfr.reader.b.a.a.g$3.a(Op02WithProcessedDataAndRefs.java:2007)
            // org.benf.cfr.reader.util.d.a.d(AbstractGraphVisitorFI.java:60)
            // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:2019)
            // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:340)
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

        public static ErrorType valueOf(String string2) {
            return (ErrorType)Enum.valueOf(ErrorType.class, (String)string2);
        }

        public static ErrorType[] values() {
            return (ErrorType[])a.clone();
        }
    }

}

