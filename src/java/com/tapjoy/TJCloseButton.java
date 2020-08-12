/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.view.ViewPropertyAnimator
 *  android.widget.ImageButton
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.tapjoy;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.ViewPropertyAnimator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class TJCloseButton
extends ImageButton {
    private static final String a = "TJCloseButton";
    private ClosePosition b;
    private boolean c;
    private boolean d;

    public TJCloseButton(Context context) {
        this(context, ClosePosition.TOP_RIGHT);
    }

    /*
     * Exception decompiling
     */
    public TJCloseButton(Context var1, ClosePosition var2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl33 : ALOAD_0 : trying to set 1 previously set to 0
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

    @TargetApi(value=11)
    protected void onAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 12) {
            this.setAlpha(0.0f);
            this.setVisibility(0);
            this.d = true;
            this.setClickable(false);
            new Handler().postDelayed(new Runnable(){

                @SuppressLint(value={"NewApi"})
                public final void run() {
                    TJCloseButton.this.animate().alpha(1.0f).setDuration(500L).setListener(new Animator.AnimatorListener(){

                        public final void onAnimationCancel(Animator animator) {
                            TJCloseButton.this.setClickable(TJCloseButton.this.c);
                            TJCloseButton.this.d = false;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            TJCloseButton.this.setClickable(TJCloseButton.this.c);
                            TJCloseButton.this.d = false;
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }

                        public final void onAnimationStart(Animator animator) {
                        }
                    });
                }

            }, 2000L);
        }
    }

    void setClickableRequested(boolean bl) {
        this.c = bl;
        if (!this.d) {
            this.setClickable(bl);
        }
    }

    public static final class ClosePosition
    extends Enum {
        public static final /* enum */ ClosePosition BOTTOM_CENTER;
        public static final /* enum */ ClosePosition BOTTOM_LEFT;
        public static final /* enum */ ClosePosition BOTTOM_RIGHT;
        public static final /* enum */ ClosePosition CENTER;
        public static final /* enum */ ClosePosition TOP_CENTER;
        public static final /* enum */ ClosePosition TOP_LEFT;
        public static final /* enum */ ClosePosition TOP_RIGHT;
        private static final /* synthetic */ ClosePosition[] b;
        final RelativeLayout.LayoutParams a;

        static {
            TOP_LEFT = new ClosePosition("TOP_LEFT", 0, new int[]{10, 9});
            TOP_CENTER = new ClosePosition("TOP_CENTER", 1, new int[]{10, 14});
            TOP_RIGHT = new ClosePosition("TOP_RIGHT", 2, new int[]{10, 11});
            CENTER = new ClosePosition("CENTER", 3, new int[]{13});
            BOTTOM_LEFT = new ClosePosition("BOTTOM_LEFT", 4, new int[]{12, 9});
            BOTTOM_CENTER = new ClosePosition("BOTTOM_CENTER", 5, new int[]{12, 14});
            BOTTOM_RIGHT = new ClosePosition("BOTTOM_RIGHT", 6, new int[]{12, 11});
            ClosePosition[] arrclosePosition = new ClosePosition[]{TOP_LEFT, TOP_CENTER, TOP_RIGHT, CENTER, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT};
            b = arrclosePosition;
        }

        /*
         * Exception decompiling
         */
        private ClosePosition() {
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

        public static ClosePosition valueOf(String string) {
            return (ClosePosition)Enum.valueOf(ClosePosition.class, (String)string);
        }

        public static ClosePosition[] values() {
            return (ClosePosition[])b.clone();
        }
    }

}

