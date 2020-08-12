/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  com.tapjoy.internal.au$a
 *  com.tapjoy.internal.av
 *  com.tapjoy.internal.aw
 *  com.tapjoy.internal.ax
 *  com.tapjoy.internal.bs
 *  com.tapjoy.internal.ha$1
 *  java.io.ByteArrayInputStream
 *  java.io.ByteArrayOutputStream
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.Object
 *  java.lang.String
 *  java.net.URL
 */
package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.internal.as;
import com.tapjoy.internal.au;
import com.tapjoy.internal.av;
import com.tapjoy.internal.aw;
import com.tapjoy.internal.ax;
import com.tapjoy.internal.bn;
import com.tapjoy.internal.bs;
import com.tapjoy.internal.bx;
import com.tapjoy.internal.da;
import com.tapjoy.internal.ha;
import com.tapjoy.internal.hh;
import com.tapjoy.internal.hi;
import com.tapjoy.internal.u;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

/*
 * Exception performing whole class analysis.
 */
public final class ha {
    public static final bn e;
    private static final as f;
    public URL a;
    public Bitmap b;
    public byte[] c;
    public hh d;

    static {
        aw aw2 = new aw();
        if (!(aw2 instanceof ax)) {
            aw2 = new /* Unavailable Anonymous Inner Class!! */;
        }
        f = aw2;
        e = new 1();
    }

    ha(bs bs2) {
        boolean bl2 = bs2.k() == bx.f;
        if (bl2) {
            this.a = bs2.e();
            return;
        }
        bs2.h();
        String string2 = bs2.l();
        while (bs2.j()) {
            if ("url".equals((Object)string2)) {
                this.a = bs2.e();
                continue;
            }
            bs2.s();
        }
        bs2.i();
    }

    public ha(URL uRL) {
        this.a = uRL;
    }

    private ByteArrayInputStream a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        da.a(inputStream, (OutputStream)byteArrayOutputStream);
        byteArrayOutputStream.close();
        byte[] arrby = byteArrayOutputStream.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrby);
        hi hi2 = new hi();
        hi2.a(arrby);
        hh hh2 = hi2.a();
        if (hh2.b == 0) {
            this.c = arrby;
            this.d = hh2;
            return byteArrayInputStream;
        }
        this.b = u.a((InputStream)byteArrayInputStream);
        byteArrayInputStream.reset();
        return byteArrayInputStream;
    }

    public final boolean a() {
        return this.b != null || this.c != null;
        {
        }
    }

    /*
     * Exception decompiling
     */
    public final void b() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl128.1 : LLOAD : trying to set 1 previously set to 0
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

