/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  java.lang.Enum
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.UUID
 *  java.util.zip.CRC32
 */
package com.tapjoy.internal;

import android.util.Base64;
import com.tapjoy.internal.ii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import java.util.zip.CRC32;

public final class er {
    public final a a;
    public final String b;
    public final String c;
    public final String d;
    private final String e;
    private final int f;

    public er(String string2) {
        int n2 = string2.length();
        if (string2.matches("[A-Za-z0-9\\-_]*") && n2 >= 60 && (n2 & 3) == 0) {
            byte[] arrby;
            try {
                arrby = Base64.decode((String)string2, (int)8);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                throw new IllegalArgumentException("The given API key was malformed.", (Throwable)illegalArgumentException);
            }
            int n3 = arrby.length;
            ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])arrby);
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
            int n4 = -4 + arrby.length;
            int n5 = byteBuffer.getInt(n4);
            CRC32 cRC32 = new CRC32();
            cRC32.update(arrby, 0, n4);
            if (n5 == (int)cRC32.getValue()) {
                this.e = string2;
                this.b = new UUID(byteBuffer.getLong(0), byteBuffer.getLong(8)).toString();
                this.f = byteBuffer.get(16);
                this.a = a.a(byteBuffer.get(17));
                this.c = string2.substring(24, 44);
                int n6 = this.f;
                if (n6 == 1) {
                    this.d = null;
                    return;
                }
                if (n6 == 2 && this.a == a.SDK_ANDROID) {
                    if (n3 >= 57) {
                        byte[] arrby2 = new byte[12];
                        System.arraycopy((Object)arrby, (int)33, (Object)arrby2, (int)0, (int)12);
                        this.d = new String(ii.a(arrby2));
                        return;
                    }
                    throw new IllegalArgumentException("The given API key was invalid.");
                }
                throw new IllegalArgumentException("The given API key was not supported.");
            }
            throw new IllegalArgumentException("The given API key was invalid.");
        }
        throw new IllegalArgumentException("The given API key was malformed.");
    }

    public final boolean equals(Object object) {
        if (object instanceof er) {
            return this.e.equals((Object)((er)object).e);
        }
        return false;
    }

    public final String toString() {
        return this.e;
    }

    public static final class a
    extends Enum {
        public static final /* enum */ a RPC_ANALYTICS;
        public static final /* enum */ a SDK_ANDROID;
        private static final /* synthetic */ a[] b;
        public byte a;

        static {
            SDK_ANDROID = new a("SDK_ANDROID", 0, 2);
            RPC_ANALYTICS = new a("RPC_ANALYTICS", 1, 49);
            a[] arra = new a[]{SDK_ANDROID, RPC_ANALYTICS};
            b = arra;
        }

        /*
         * Exception decompiling
         */
        private a() {
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

        public static a a(byte by2) {
            for (a a2 : a.values()) {
                if (a2.a != by2) continue;
                return a2;
            }
            return null;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])b.clone();
        }
    }

}

