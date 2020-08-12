/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.ByteArrayOutputStream
 *  java.io.IOException
 *  java.io.InputStream
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Map
 *  org.apache.http.HttpEntity
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.fm;
import com.yandex.metrica.impl.ob.fr;
import com.yandex.metrica.impl.ob.ft;
import com.yandex.metrica.impl.ob.fu;
import com.yandex.metrica.impl.ob.fw;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import org.apache.http.HttpEntity;

public class fq {
    protected final fm a;

    public fq(fm fm2) {
        this.a = fm2;
    }

    public static String a(Map<String, String> map, String string2) {
        String string3 = (String)map.get((Object)"Content-Type");
        if (string3 != null) {
            String[] arrstring = string3.split(";");
            for (int i2 = 1; i2 < arrstring.length; ++i2) {
                String[] arrstring2 = arrstring[i2].trim().split("=");
                if (arrstring2.length != 2 || !arrstring2[0].equals((Object)"charset")) continue;
                return arrstring2[1];
            }
        }
        return string2;
    }

    private static void a(fu<?> fu2, fr fr2) throws fr {
        fw fw2 = fu2.o();
        fw2.a(fr2);
        return;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static byte[] a(HttpEntity httpEntity) throws IOException, fr {
        block8 : {
            byte[] arrby;
            ByteArrayOutputStream byteArrayOutputStream;
            byteArrayOutputStream = new ByteArrayOutputStream(Math.max((int)((int)httpEntity.getContentLength()), (int)256));
            try {
                int n2;
                InputStream inputStream = httpEntity.getContent();
                if (inputStream == null) break block8;
                byte[] arrby2 = new byte[1024];
                while ((n2 = inputStream.read(arrby2)) != -1) {
                    byteArrayOutputStream.write(arrby2, 0, n2);
                }
                arrby = byteArrayOutputStream.toByteArray();
            }
            catch (Throwable throwable) {
                try {
                    httpEntity.consumeContent();
                }
                catch (IOException iOException) {}
                byteArrayOutputStream.close();
                throw throwable;
            }
            try {
                httpEntity.consumeContent();
            }
            catch (IOException iOException) {}
            byteArrayOutputStream.close();
            return arrby;
        }
        throw new fr();
    }

    /*
     * Exception decompiling
     */
    public ft a(fu<?> var1) throws fr {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl1 : INVOKESTATIC : trying to set 1 previously set to 0
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
}

