/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.WindowManager
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.LinkedList
 *  java.util.ListIterator
 */
package com.adcolony.sdk;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

class ba {
    private static int a;
    private static int b;
    private static int c;
    private static int d;

    static float a(View view) {
        if (view == null) {
            return 0.0f;
        }
        if (ba.a() < 11) {
            return 1.0f;
        }
        return view.getAlpha();
    }

    /*
     * Exception decompiling
     */
    public static float a(View var0, Context var1, boolean var2, boolean var3, boolean var4) {
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

    /*
     * Exception decompiling
     */
    static float a(View var0, Rect var1, float var2, boolean var3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Invalid stack depths @ lbl191.1 : NEW : trying to set 1 previously set to 0
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

    public static int a() {
        return Build.VERSION.SDK_INT;
    }

    public static int a(Context context) {
        int n2;
        int n3;
        block7 : {
            int n4;
            int n5;
            n2 = context != null ? context.getResources().getConfiguration().orientation : -1;
            if (n2 == 2 && (n5 = a) > 0) {
                return n5;
            }
            if (n2 == 1 && (n4 = c) > 0) {
                return n4;
            }
            try {
                WindowManager windowManager = (WindowManager)context.getApplicationContext().getSystemService("window");
                n3 = ba.a() >= 13 ? a.a(windowManager) : windowManager.getDefaultDisplay().getHeight();
                if (n2 != 2) break block7;
            }
            catch (Exception exception) {
                return 0;
            }
            a = n3;
            return n3;
        }
        if (n2 == 1) {
            c = n3;
        }
        return n3;
    }

    static Rect a(Rect rect, Rect rect2, int n2) {
        Rect rect3 = new Rect();
        switch (n2) {
            default: {
                return rect3;
            }
            case 8: {
                rect3.set(rect.left, rect2.top, rect2.left, rect2.bottom);
                return rect3;
            }
            case 7: {
                rect3.set(rect.left, rect2.bottom, rect2.left, rect.bottom);
                return rect3;
            }
            case 6: {
                rect3.set(rect2.left, rect2.bottom, rect2.right, rect.bottom);
                return rect3;
            }
            case 5: {
                rect3.set(rect2.right, rect2.bottom, rect.right, rect.bottom);
                return rect3;
            }
            case 4: {
                rect3.set(rect2.right, rect2.top, rect.right, rect2.bottom);
                return rect3;
            }
            case 3: {
                rect3.set(rect2.right, rect.top, rect.right, rect2.top);
                return rect3;
            }
            case 2: {
                rect3.set(rect2.left, rect.top, rect2.right, rect2.top);
                return rect3;
            }
            case 1: 
        }
        rect3.set(rect.left, rect.top, rect2.left, rect2.top);
        return rect3;
    }

    public static int b(Context context) {
        int n2;
        int n3;
        block7 : {
            int n4;
            int n5;
            n2 = context != null ? context.getResources().getConfiguration().orientation : -1;
            if (n2 == 2 && (n5 = b) > 0) {
                return n5;
            }
            if (n2 == 1 && (n4 = d) > 0) {
                return n4;
            }
            try {
                WindowManager windowManager = (WindowManager)context.getApplicationContext().getSystemService("window");
                n3 = ba.a() >= 13 ? b.a(windowManager) : windowManager.getDefaultDisplay().getWidth();
                if (n2 != 2) break block7;
            }
            catch (Exception exception) {
                return 0;
            }
            b = n3;
            return n3;
        }
        if (n2 == 1) {
            d = n3;
        }
        return n3;
    }

    private static ArrayList<View> b(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view.getVisibility() == 0) {
            if (ba.a(view) == 0.0f) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            ArrayList arrayList = new ArrayList();
            linkedList.add((Object)((ViewGroup)view));
            ListIterator listIterator = linkedList.listIterator();
            while (listIterator.hasNext()) {
                ViewGroup viewGroup = (ViewGroup)listIterator.next();
                listIterator.remove();
                int n2 = viewGroup.getChildCount();
                for (int i2 = 0; i2 < n2; ++i2) {
                    View view2 = viewGroup.getChildAt(i2);
                    if (view2.getVisibility() != 0 || ba.a(view2) == 0.0f) continue;
                    if (view2 instanceof ViewGroup) {
                        if (ba.c(view2)) {
                            listIterator.add((Object)((ViewGroup)view2));
                            listIterator.previous();
                            continue;
                        }
                        arrayList.add((Object)view2);
                        continue;
                    }
                    if (ba.c(view2)) continue;
                    arrayList.add((Object)view2);
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
        }
        return null;
    }

    private static boolean c(View view) {
        boolean bl;
        block5 : {
            block4 : {
                if (view == null) {
                    return false;
                }
                if (view.getBackground() == null) break block4;
                int n2 = ba.a();
                bl = false;
                if (n2 <= 18) break block5;
                int n3 = view.getBackground().getAlpha();
                bl = false;
                if (n3 != 0) break block5;
            }
            bl = true;
        }
        return bl;
    }

    private static class a {
        public static int a(WindowManager windowManager) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            return point.y;
        }
    }

    private static class b {
        public static int a(WindowManager windowManager) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            return point.x;
        }
    }

}

