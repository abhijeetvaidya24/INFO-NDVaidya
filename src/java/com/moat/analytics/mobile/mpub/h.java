/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.view.View
 *  java.lang.Double
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.mpub;

import android.os.Handler;
import android.view.View;
import com.moat.analytics.mobile.mpub.MoatAdEvent;
import com.moat.analytics.mobile.mpub.MoatAdEventType;
import com.moat.analytics.mobile.mpub.c;
import com.moat.analytics.mobile.mpub.h;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import java.util.Map;
import org.json.JSONObject;

abstract class h
extends c {
    int l = Integer.MIN_VALUE;
    private a m = a.a;
    private int n = Integer.MIN_VALUE;
    private double o = Double.NaN;
    private int p = Integer.MIN_VALUE;
    private int q = 0;

    h(String string) {
        super(string);
    }

    private void t() {
        Runnable runnable = new Runnable(this){
            final /* synthetic */ h a;
            {
                this.a = h2;
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public void run() {
                try {
                    h h2;
                    if (this.a.n() && !this.a.m()) {
                        if (java.lang.Boolean.valueOf((boolean)this.a.s()).booleanValue()) {
                            this.a.i.postDelayed((Runnable)this, 200L);
                            return;
                        }
                        h2 = this.a;
                    } else {
                        h2 = this.a;
                    }
                    h2.l();
                    return;
                }
                catch (Exception exception) {
                    this.a.l();
                    m.a(exception);
                    return;
                }
            }
        };
        this.i.postDelayed(runnable, 200L);
    }

    /*
     * Exception decompiling
     */
    @Override
    JSONObject a(MoatAdEvent var1) {
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public boolean a(Map<String, String> map, View view) {
        boolean bl;
        try {
            bl = super.a(map, view);
            if (!bl) return bl;
        }
        catch (Exception exception) {
            p.a(3, "IntervalVideoTracker", this, "Problem with video loop");
            this.a("trackVideoAd", exception);
            return false;
        }
        if (!this.p()) return bl;
        this.t();
        return bl;
    }

    abstract boolean n();

    abstract Integer o();

    protected boolean p() {
        return true;
    }

    abstract boolean q();

    abstract Integer r();

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    boolean s() {
        block20 : {
            if (this.n() == false) return false;
            if (this.m()) {
                return false;
            }
            try {
                var2_1 = this.o();
                if (this.n >= 0 && var2_1 < 0) {
                    return false;
                }
                this.n = var2_1;
                if (var2_1 == 0) {
                    return true;
                }
                var3_2 = this.r();
                var4_3 = this.q();
            }
            catch (Exception v0) {
                var1_17 = this.q;
                this.q = var1_17 + 1;
                if (var1_17 >= 5) return false;
                return true;
            }
            var5_4 = var3_2;
            Double.isNaN((double)var5_4);
            var8_5 = var5_4 / 4.0;
            var10_6 = this.j();
            if (var2_1 > this.p) {
                this.p = var2_1;
            }
            if (this.l == Integer.MIN_VALUE) {
                this.l = var3_2;
            }
            if (!var4_3) ** GOTO lbl52
            if (this.m == a.a) {
                var18_7 = MoatAdEventType.AD_EVT_START;
                var23_8 = a.c;
            } else if (this.m == a.b) {
                var18_7 = MoatAdEventType.AD_EVT_PLAYING;
                var23_8 = a.c;
            } else {
                var12_9 = var2_1;
                Double.isNaN((double)var12_9);
                var15_10 = var12_9 / var8_5;
                var17_11 = (int)Math.floor((double)var15_10) - 1;
                var18_7 = null;
                if (var17_11 > -1) {
                    var18_7 = null;
                    if (var17_11 < 3) {
                        var19_12 = h.g[var17_11];
                        var20_13 = this.h.containsKey((Object)var19_12);
                        var18_7 = null;
                        if (!var20_13) {
                            this.h.put((Object)var19_12, (Object)1);
                            var18_7 = var19_12;
                        }
                    }
                }
                break block20;
lbl52: // 1 sources:
                var24_14 = this.m;
                var25_15 = a.b;
                var18_7 = null;
                if (var24_14 == var25_15) break block20;
                var18_7 = MoatAdEventType.AD_EVT_PAUSED;
                var23_8 = a.b;
            }
            this.m = var23_8;
            {
            }
        }
        var22_16 = var18_7 != null;
        if (!var22_16 && !Double.isNaN((double)this.o) && Math.abs((double)(this.o - var10_6)) > 0.05) {
            var18_7 = MoatAdEventType.AD_EVT_VOLUME_CHANGE;
            var22_16 = true;
        }
        if (var22_16) {
            this.dispatchEvent(new MoatAdEvent(var18_7, var2_1, this.k()));
        }
        this.o = var10_6;
        this.q = 0;
        return true;
    }

    @Override
    public void setPlayerVolume(Double d2) {
        super.setPlayerVolume(d2);
        this.o = this.j();
    }

    @Override
    public void stopTracking() {
        try {
            this.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
            super.stopTracking();
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }

}

