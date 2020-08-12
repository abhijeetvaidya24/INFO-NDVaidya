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
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.iro;

import android.os.Handler;
import android.view.View;
import com.moat.analytics.mobile.iro.MoatAdEvent;
import com.moat.analytics.mobile.iro.MoatAdEventType;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.d;
import com.moat.analytics.mobile.iro.g;
import com.moat.analytics.mobile.iro.o;
import java.util.Map;
import org.json.JSONObject;

abstract class g
extends d {
    private int \u02cb\u0971 = Integer.MIN_VALUE;
    private double \u02cf\u0971 = Double.NaN;
    private int \u037a = Integer.MIN_VALUE;
    private int \u0971\u02ca = a.\u02ce;
    private int \u0971\u02cb = Integer.MIN_VALUE;
    private int \u0971\u02ce = 0;

    g(String string) {
        super(string);
    }

    @Override
    public void setPlayerVolume(Double d2) {
        super.setPlayerVolume(d2);
        this.\u02cf\u0971 = this.\u141d();
    }

    @Override
    public void stopTracking() {
        try {
            this.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
            super.stopTracking();
            return;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return;
        }
    }

    abstract Integer \u02bb\u0971();

    /*
     * Exception decompiling
     */
    final boolean \u02bc\u0971() throws o {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl199 : ICONST_0 : trying to set 0 previously set to 1
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
     * Exception decompiling
     */
    @Override
    final JSONObject \u02cb(MoatAdEvent var1) {
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
    public final boolean \u02cb(Map<String, String> map, View view) {
        boolean bl;
        try {
            bl = super.\u02cb(map, view);
            if (!bl) return bl;
        }
        catch (Exception exception) {
            b.\u02cf(3, "IntervalVideoTracker", this, "Problem with video loop");
            this.\u0971("trackVideoAd", exception);
            return false;
        }
        Runnable runnable = new Runnable(this){
            private /* synthetic */ g \u0971;
            {
                this.\u0971 = g2;
            }

            public final void run() {
                try {
                    if (this.\u0971.\u0971\u02ca() && !this.\u0971.\u037a()) {
                        if (java.lang.Boolean.valueOf((boolean)this.\u0971.\u02bc\u0971()).booleanValue()) {
                            this.\u0971.\u02ca\u0971.postDelayed((Runnable)this, 200L);
                            return;
                        }
                        this.\u0971.\u0971\u02cb();
                        return;
                    }
                    this.\u0971.\u0971\u02cb();
                    return;
                }
                catch (Exception exception) {
                    this.\u0971.\u0971\u02cb();
                    o.\u0971(exception);
                    return;
                }
            }
        };
        this.\u02ca\u0971.postDelayed(runnable, 200L);
        return bl;
    }

    abstract Integer \u02cb\u0971();

    abstract boolean \u0971\u02ca();

    abstract boolean \u0971\u02ce();

}

