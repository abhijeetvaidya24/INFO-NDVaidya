/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.animation.AlphaAnimation
 *  android.view.animation.Animation
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 */
package com.chartboost.sdk.impl;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.Model.c;
import com.chartboost.sdk.d;
import com.chartboost.sdk.impl.bc;

public class aw {
    private final Handler a;

    public aw(Handler handler) {
        this.a = handler;
    }

    public static Integer a(int n2) {
        if (n2 >= 1 && n2 <= 9) {
            return n2;
        }
        return null;
    }

    private void a(final int n2, final c c2, final Runnable runnable, final boolean bl, d d2) {
        if (n2 == 7) {
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
        if (c2 != null && c2.s != null) {
            final View view = c2.s.d();
            if (view == null) {
                d2.d(c2);
                CBLogging.a("AnimationManager", "Transition of impression canceled due to lack of view");
                return;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener(){

                    public void onGlobalLayout() {
                        view.getViewTreeObserver().removeGlobalOnLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
                        aw.this.a(n2, c2, runnable, bl);
                    }
                };
                viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            return;
        }
        CBLogging.a("AnimationManager", "Transition of impression canceled due to lack of container");
    }

    public void a(int n2, c c2, Runnable runnable) {
        this.a(n2, c2, runnable, false);
    }

    public void a(int n2, c c2, Runnable runnable, d d2) {
        this.a(n2, c2, runnable, true, d2);
    }

    /*
     * Exception decompiling
     */
    void a(int var1, c var2, Runnable var3, boolean var4) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // java.lang.IllegalStateException: Invisible function parameters on a non-constructor (or reads of uninitialised local variables).
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1560)
        // org.benf.cfr.reader.b.a.a.g.a(Op02WithProcessedDataAndRefs.java:1816)
        // org.benf.cfr.reader.b.f.a(CodeAnalyser.java:332)
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

    public void a(boolean bl, View view, long l2) {
        view.clearAnimation();
        if (bl) {
            view.setVisibility(0);
        }
        float f2 = bl ? 0.0f : 1.0f;
        float f3 = 0.0f;
        if (bl) {
            f3 = 1.0f;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f3);
        alphaAnimation.setDuration(l2);
        alphaAnimation.setFillBefore(true);
        view.startAnimation((Animation)alphaAnimation);
    }

    public void a(boolean bl, View view, a a2) {
        this.a(bl, view, 500L);
    }

}

