/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Looper
 *  android.widget.ImageView
 *  com.tapjoy.internal.hk
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.Thread
 *  java.nio.ByteBuffer
 */
package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.tapjoy.internal.hf;
import com.tapjoy.internal.hh;
import com.tapjoy.internal.hk;
import java.nio.ByteBuffer;

public final class hj
extends ImageView
implements Runnable {
    private hf a;
    private Bitmap b;
    private final Handler c = new Handler(Looper.getMainLooper());
    private boolean d;
    private boolean e;
    private boolean f;
    private Thread g;
    private b h = null;
    private long i = -1L;
    private a j = null;
    private final Runnable k = new Runnable(){

        public final void run() {
            if (hj.this.b != null && !hj.this.b.isRecycled()) {
                hj hj2 = hj.this;
                hj2.setImageBitmap(hj2.b);
            }
        }
    };
    private final Runnable l = new Runnable(){

        public final void run() {
            hj.this.b = null;
            hj.this.a = null;
            hj.this.g = null;
            hj.this.f = false;
        }
    };

    public hj(Context context) {
        super(context);
    }

    private void d() {
        boolean bl2;
        if (this.a.a == 0) {
            return;
        }
        hf hf2 = this.a;
        if (-1 >= hf2.c.c) {
            bl2 = false;
        } else {
            hf2.a = -1;
            bl2 = true;
        }
        if (bl2 && !this.d) {
            this.e = true;
            this.e();
        }
    }

    private void e() {
        boolean bl2 = (this.d || this.e) && this.a != null && this.g == null;
        if (bl2) {
            this.g = new Thread((Runnable)this);
            this.g.start();
        }
    }

    public final void a() {
        this.d = true;
        this.e();
    }

    public final void a(hh hh2, byte[] arrby) {
        block2 : {
            try {
                this.a = new hf((hf.a)new hk(), hh2, ByteBuffer.wrap((byte[])arrby));
                if (!this.d) break block2;
            }
            catch (Exception exception) {
                this.a = null;
                new Object[1][0] = exception;
                return;
            }
            this.e();
            return;
        }
        this.d();
    }

    public final void b() {
        this.d = false;
        Thread thread = this.g;
        if (thread != null) {
            thread.interrupt();
            this.g = null;
        }
    }

    public final void c() {
        this.d = false;
        this.e = false;
        this.f = true;
        this.b();
        this.c.post(this.l);
    }

    public final long getFramesDisplayDuration() {
        return this.i;
    }

    public final int getGifHeight() {
        return this.a.c.g;
    }

    public final int getGifWidth() {
        return this.a.c.f;
    }

    public final a getOnAnimationStop() {
        return this.j;
    }

    public final b getOnFrameAvailable() {
        return this.h;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c();
    }

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

    public final void setBytes(byte[] arrby) {
        block2 : {
            this.a = new hf();
            try {
                this.a.a(arrby);
                if (!this.d) break block2;
            }
            catch (Exception exception) {
                this.a = null;
                new Object[1][0] = exception;
                return;
            }
            this.e();
            return;
        }
        this.d();
    }

    public final void setFramesDisplayDuration(long l2) {
        this.i = l2;
    }

    public final void setOnAnimationStop(a a2) {
        this.j = a2;
    }

    public final void setOnFrameAvailable(b b2) {
        this.h = b2;
    }

    public static interface a {
    }

    public static interface b {
        public Bitmap a();
    }

}

