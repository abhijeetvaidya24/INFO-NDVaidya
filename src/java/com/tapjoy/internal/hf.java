/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.tapjoy.internal.hk
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.lang.Throwable
 *  java.nio.Buffer
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.Iterator
 *  java.util.List
 */
package com.tapjoy.internal;

import android.graphics.Bitmap;
import android.os.Build;
import com.tapjoy.internal.hg;
import com.tapjoy.internal.hh;
import com.tapjoy.internal.hi;
import com.tapjoy.internal.hk;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.List;

public class hf {
    private static final String d = "hf";
    int a;
    int b;
    hh c;
    private int[] e;
    private final int[] f = new int[256];
    private ByteBuffer g;
    private byte[] h;
    private byte[] i;
    private int j = 0;
    private int k = 0;
    private hi l;
    private short[] m;
    private byte[] n;
    private byte[] o;
    private byte[] p;
    private int[] q;
    private a r;
    private Bitmap s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private int x;
    private boolean y;

    hf() {
        this((a)new hk());
    }

    private hf(a a2) {
        this.r = a2;
        this.c = new hh();
    }

    hf(a a2, hh hh2, ByteBuffer byteBuffer) {
        this(a2, hh2, byteBuffer, 0);
    }

    private hf(a a2, hh hh2, ByteBuffer byteBuffer, byte by2) {
        this(a2);
        this.b(hh2, byteBuffer);
    }

    private void a(hh hh2, ByteBuffer byteBuffer) {
        hf hf2 = this;
        synchronized (hf2) {
            this.b(hh2, byteBuffer);
            return;
        }
    }

    private void a(hh hh2, byte[] arrby) {
        hf hf2 = this;
        synchronized (hf2) {
            this.a(hh2, ByteBuffer.wrap((byte[])arrby));
            return;
        }
    }

    private void a(int[] arrn, hg hg2, int n2) {
        int n3;
        int n4 = hg2.d / this.v;
        int n5 = hg2.b / this.v;
        int n6 = hg2.c / this.v;
        int n7 = hg2.a / this.v;
        int n8 = this.x;
        int n9 = n3 + n4 * n8;
        for (n3 = n7 + n5 * n8; n3 < n9; n3 += this.x) {
            int n10 = n3 + n6;
            for (int i2 = n3; i2 < n10; ++i2) {
                arrn[i2] = n2;
            }
        }
    }

    private void b() {
        if (this.j > this.k) {
            return;
        }
        if (this.i == null) {
            this.i = this.r.a(16384);
        }
        this.k = 0;
        this.j = Math.min((int)this.g.remaining(), (int)16384);
        this.g.get(this.i, 0, this.j);
    }

    private void b(hh hh2, ByteBuffer byteBuffer) {
        hf hf2 = this;
        synchronized (hf2) {
            try {
                int n2 = Integer.highestOneBit((int)1);
                this.u = 0;
                this.c = hh2;
                this.y = false;
                this.a = -1;
                this.b = 0;
                this.g = byteBuffer.asReadOnlyBuffer();
                this.g.position(0);
                this.g.order(ByteOrder.LITTLE_ENDIAN);
                this.t = false;
                Iterator iterator = hh2.e.iterator();
                while (iterator.hasNext()) {
                    if (((hg)iterator.next()).g != 3) continue;
                    this.t = true;
                    break;
                }
                this.v = n2;
                this.x = hh2.f / n2;
                this.w = hh2.g / n2;
                this.p = this.r.a(hh2.f * hh2.g);
                this.q = this.r.b(this.x * this.w);
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private int c() {
        byte by2;
        try {
            this.b();
            byte[] arrby = this.i;
            int n2 = this.k;
            this.k = n2 + 1;
            by2 = arrby[n2];
        }
        catch (Exception exception) {
            this.u = 1;
            return 0;
        }
        return by2 & 255;
    }

    private int d() {
        int n2 = this.c();
        if (n2 > 0) {
            block9 : {
                int n3;
                block8 : {
                    if (this.h == null) {
                        this.h = this.r.a(255);
                    }
                    if ((n3 = this.j - this.k) < n2) break block8;
                    System.arraycopy((Object)this.i, (int)this.k, (Object)this.h, (int)0, (int)n2);
                    this.k = n2 + this.k;
                    return n2;
                }
                if (n3 + this.g.remaining() < n2) break block9;
                System.arraycopy((Object)this.i, (int)this.k, (Object)this.h, (int)0, (int)n3);
                this.k = this.j;
                this.b();
                int n4 = n2 - n3;
                System.arraycopy((Object)this.i, (int)0, (Object)this.h, (int)n3, (int)n4);
                this.k = n4 + this.k;
                return n2;
            }
            try {
                this.u = 1;
                return n2;
            }
            catch (Exception exception) {
                new Object[1][0] = exception;
                this.u = 1;
            }
        }
        return n2;
    }

    private Bitmap e() {
        Bitmap.Config config = this.y ? Bitmap.Config.ARGB_4444 : Bitmap.Config.RGB_565;
        Bitmap bitmap = this.r.a(this.x, this.w, config);
        if (Build.VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
        return bitmap;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    final int a(byte[] arrby) {
        hf hf2 = this;
        synchronized (hf2) {
            if (this.l == null) {
                this.l = new hi();
            }
            this.c = this.l.a(arrby).a();
            if (arrby == null) return this.u;
            this.a(this.c, arrby);
            return this.u;
        }
    }

    /*
     * Exception decompiling
     */
    final Bitmap a() {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[TRYBLOCK]], but top level block is 23[UNCONDITIONALDOLOOP]
        // org.benf.cfr.reader.b.a.a.j.a(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.b.a.a.i.a(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:692)
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

    static interface a {
        public Bitmap a(int var1, int var2, Bitmap.Config var3);

        public byte[] a(int var1);

        public int[] b(int var1);
    }

}

