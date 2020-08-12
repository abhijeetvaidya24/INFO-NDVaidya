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
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.ogury;

import android.os.Handler;
import android.view.View;
import com.moat.analytics.mobile.ogury.MoatAdEvent;
import com.moat.analytics.mobile.ogury.MoatAdEventType;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.h;
import com.moat.analytics.mobile.ogury.l;
import java.util.Map;
import org.json.JSONObject;

abstract class h
extends e {
    private int \u02ca\u0971 = Integer.MIN_VALUE;
    private int \u02cb\u0971 = Integer.MIN_VALUE;
    private double \u02cf\u0971 = Double.NaN;
    private int \u037a = d.\u02cb;
    private int \u0971\u02ca = Integer.MIN_VALUE;
    private int \u0971\u02cb = 0;

    h(String string) {
        super(string);
    }

    @Override
    public void setPlayerVolume(Double d2) {
        super.setPlayerVolume(d2);
        this.\u02cf\u0971 = this.\u02bc();
    }

    @Override
    public void stopTracking() {
        try {
            this.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_COMPLETE));
            super.stopTracking();
            return;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
    }

    abstract Integer \u02bb\u0971();

    /*
     * Exception decompiling
     */
    @Override
    final JSONObject \u02ca(MoatAdEvent var1) {
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
            e.1.\u02cb(3, "IntervalVideoTracker", this, "Problem with video loop");
            this.\u02cb("trackVideoAd", exception);
            return false;
        }
        Runnable runnable = new Runnable(this){
            private /* synthetic */ h \u0971;
            {
                this.\u0971 = h2;
            }

            public final void run() {
                try {
                    if (this.\u0971.\u02cb\u0971() && !this.\u0971.\u0971\u02ca()) {
                        if (this.\u0971.\u0971\u141d()) {
                            this.\u0971.\u0971\u0971.postDelayed((Runnable)this, 200L);
                            return;
                        }
                        this.\u0971.\u02cf\u0971();
                        return;
                    }
                    this.\u0971.\u02cf\u0971();
                    return;
                }
                catch (Exception exception) {
                    this.\u0971.\u02cf\u0971();
                    l.\u0971(exception);
                    return;
                }
            }
        };
        this.\u0971\u0971.postDelayed(runnable, 200L);
        return bl;
    }

    abstract boolean \u02cb\u0971();

    abstract Integer \u037a();

    /*
     * Exception decompiling
     */
    final boolean \u0971\u141d() throws l {
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

    abstract boolean \u141d\u0971();

}

