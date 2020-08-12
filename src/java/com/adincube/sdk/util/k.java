/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Activity
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.hardware.display.DisplayManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.Stack
 */
package com.adincube.sdk.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.adincube.sdk.util.ErrorReportingHelper;
import com.adincube.sdk.util.a;
import com.adincube.sdk.util.f;
import java.util.Stack;

@SuppressLint(value={"NewApi"})
public class k {
    public static void a(final Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            Runnable runnable = new Runnable(){

                public final void run() {
                    try {
                        Context context2 = context;
                        boolean bl = k.e(context);
                        SharedPreferences.Editor editor = context2.getSharedPreferences("AIC-prefs", 0).edit();
                        editor.putBoolean("im", bl);
                        editor.apply();
                        return;
                    }
                    catch (Throwable throwable) {
                        ErrorReportingHelper.report("DisplayHelper.updateImmersiveModeFlag", throwable);
                        a.c("DisplayHelper.updateImmersiveModeFlag", new Object[]{throwable});
                        return;
                    }
                }
            };
            if (!Looper.getMainLooper().equals((Object)Looper.myLooper())) {
                new Handler(Looper.getMainLooper()).post(runnable);
                return;
            }
            runnable.run();
        }
    }

    public static boolean b(Context context) {
        if (!(context instanceof Activity)) {
            return true;
        }
        return (1024 & ((Activity)context).getWindow().getAttributes().flags) != 0;
    }

    /*
     * Exception decompiling
     */
    public static boolean c(Context var0) {
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

    public static int d(Context context) {
        int n2;
        if (context instanceof Activity && Build.VERSION.SDK_INT >= 11) {
            Stack stack = new Stack();
            stack.add((Object)((Activity)context).getWindow().getDecorView());
            n2 = 0;
            while (!stack.isEmpty() && n2 == 0) {
                View view = (View)stack.pop();
                int n3 = view.getSystemUiVisibility();
                if (n3 == 0 && view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup)view;
                    for (int i2 = 0; i2 < viewGroup.getChildCount(); ++i2) {
                        stack.add((Object)viewGroup.getChildAt(i2));
                    }
                }
                n2 = n3;
            }
        } else {
            n2 = 0;
        }
        return n2;
    }

    /*
     * Exception decompiling
     */
    @SuppressLint(value={"InlinedApi"})
    public static boolean e(Context var0) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl22 : ILOAD_1 : trying to set 1 previously set to 0
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

    public static Integer f(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return ((Activity)context).getWindow().getStatusBarColor();
        }
        return null;
    }

    public static Integer g(Context context) {
        if (!(context instanceof Activity)) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            return ((Activity)context).getWindow().getNavigationBarColor();
        }
        return null;
    }

    public static Point h(Context context) {
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 19 && k.e(context)) {
            ((DisplayManager)f.a().getSystemService("display")).getDisplay(0).getRealSize(point);
            return point;
        }
        DisplayMetrics displayMetrics = f.a().getResources().getDisplayMetrics();
        point.x = displayMetrics.widthPixels;
        point.y = displayMetrics.heightPixels;
        return point;
    }

}

