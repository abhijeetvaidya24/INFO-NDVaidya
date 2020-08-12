/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.aer;

import android.os.Handler;
import com.moat.analytics.mobile.aer.MoatAdEvent;
import com.moat.analytics.mobile.aer.MoatAdEventType;
import com.moat.analytics.mobile.aer.a;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.f;
import com.moat.analytics.mobile.aer.j;
import com.moat.analytics.mobile.aer.k;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class i<PlayerOrIMAAd>
extends f<PlayerOrIMAAd> {
    protected k j = k.a;
    protected int k = Integer.MIN_VALUE;
    protected double l = Double.NaN;
    protected int m = Integer.MIN_VALUE;
    protected int n = Integer.MIN_VALUE;
    private int o = 0;

    public i(String string, a a2, al al2) {
        super(string, a2, al2);
    }

    /*
     * Exception decompiling
     */
    @Override
    protected JSONObject a(MoatAdEvent var1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl18 : ALOAD_1 : trying to set 1 previously set to 0
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

    @Override
    protected void b() {
        super.b();
        j j2 = new j(this);
        this.d.postDelayed((Runnable)j2, 200L);
    }

    protected abstract Integer f();

    protected abstract boolean g();

    protected abstract Integer h();

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    protected boolean i() {
        block19 : {
            if (this.f.get() == null) return false;
            if (this.e()) {
                return false;
            }
            try {
                this.k = var2_1 = this.f().intValue();
                if (var2_1 == 0) {
                    return true;
                }
                var3_2 = this.h();
                var4_3 = this.g();
            }
            catch (Exception v0) {
                var1_17 = this.o;
                this.o = var1_17 + 1;
                if (var1_17 >= 5) return false;
                return true;
            }
            var5_4 = var3_2;
            Double.isNaN((double)var5_4);
            var8_5 = var5_4 / 4.0;
            var10_6 = this.d();
            if (var2_1 > this.m) {
                this.m = var2_1;
            }
            if (this.n == Integer.MIN_VALUE) {
                this.n = var3_2;
            }
            if (!var4_3) ** GOTO lbl49
            if (this.j == k.a) {
                var18_7 = MoatAdEventType.AD_EVT_START;
                var23_8 = k.c;
            } else if (this.j == k.b) {
                var18_7 = MoatAdEventType.AD_EVT_PLAYING;
                var23_8 = k.c;
            } else {
                var12_9 = var2_1;
                Double.isNaN((double)var12_9);
                var15_10 = var12_9 / var8_5;
                var17_11 = (int)Math.floor((double)var15_10) - 1;
                var18_7 = null;
                if (var17_11 > -1) {
                    var18_7 = null;
                    if (var17_11 < 3) {
                        var19_12 = i.b[var17_11];
                        var20_13 = this.c.containsKey((Object)var19_12);
                        var18_7 = null;
                        if (!var20_13) {
                            this.c.put((Object)var19_12, (Object)1);
                            var18_7 = var19_12;
                        }
                    }
                }
                break block19;
lbl49: // 1 sources:
                var24_14 = this.j;
                var25_15 = k.b;
                var18_7 = null;
                if (var24_14 == var25_15) break block19;
                var18_7 = MoatAdEventType.AD_EVT_PAUSED;
                var23_8 = k.b;
            }
            this.j = var23_8;
            {
            }
        }
        var22_16 = var18_7 != null;
        if (!var22_16 && !Double.isNaN((double)this.l) && Math.abs((double)(this.l - var10_6)) > 0.05) {
            var18_7 = MoatAdEventType.AD_EVT_VOLUME_CHANGE;
            var22_16 = true;
        }
        if (var22_16) {
            this.dispatchEvent(new MoatAdEvent(var18_7, var2_1, var10_6));
        }
        this.l = var10_6;
        this.o = 0;
        return true;
    }
}

