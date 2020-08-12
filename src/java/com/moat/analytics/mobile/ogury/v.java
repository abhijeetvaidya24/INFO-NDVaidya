/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.location.Location
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  com.moat.analytics.mobile.ogury.e
 *  java.lang.Class
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.ogury;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

final class v {
    private static int \u02bc = 0;
    private static int \u02ca\u0971 = 1;
    private Map<String, Object> \u02bb = new HashMap();
    private Location \u02bd;
    private d \u02ca = new d();
    private Rect \u02cb;
    String \u02ce = "{}";
    private JSONObject \u02cf;
    private Rect \u0971;
    private JSONObject \u0971\u0971;
    private JSONObject \u141d;

    v() {
    }

    static /* synthetic */ Rect \u02ca(View view) {
        int n2 = 35 + \u02bc;
        \u02ca\u0971 = n2 % 128;
        boolean bl2 = n2 % 2 != 0;
        if (bl2) {
            return v.\u02ce(view);
        }
        return v.\u02ce(view);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void \u02ca(e var0, Rect var1_1, c var2_2) {
        block12 : {
            block11 : {
                var3_3 = var0.\u02cb;
                if (var3_3.isShown() == false) return;
                var4_4 = true;
                if (var4_4 == false) return;
                if (!((double)var3_3.getAlpha() > 0.0)) return;
                var5_5 = true;
                if (!var5_5) {
                    return;
                }
                if (var0.\u02cb instanceof ViewGroup) break block11;
                var6_13 = true;
                break block12;
            }
            var23_6 = ViewGroup.class.equals((Object)var0.\u02cb.getClass().getSuperclass());
            var24_7 = var0.\u02cb;
            if (Build.VERSION.SDK_INT < 19) ** GOTO lbl23
            var32_8 = var24_7.getBackground() == null;
            if (!var32_8 && (var35_9 = var24_7.getBackground().getAlpha() != 0)) {
                var25_10 = false;
            } else {
                var33_11 = 59 + v.\u02ca\u0971;
                v.\u02bc = var33_11 % 128;
                var33_11 % 2;
lbl23: // 2 sources:
                var25_10 = true;
            }
            var6_13 = !var23_6 || !(var31_12 = var25_10 != false);
            var26_14 = (ViewGroup)var0.\u02cb;
            var27_15 = var26_14.getChildCount();
            var28_16 = 0;
            while ((var29_17 = var28_16 < var27_15 ? 16 : 44) != 44) {
                var2_2.\u02ca = var30_18 = 1 + var2_2.\u02ca;
                if (var30_18 > 500) {
                    return;
                }
                v.\u02ca(new e(var26_14.getChildAt(var28_16), var0), var1_1, var2_2);
                if (var2_2.\u0971) {
                    return;
                }
                ++var28_16;
            }
        }
        if (var6_13 == false) return;
        var7_19 = 33 + v.\u02ca\u0971;
        v.\u02bc = var7_19 % 128;
        var7_19 % 2;
        var9_20 = var0.\u02ca;
        if (var9_20.setIntersect(var1_1, var9_20) == false) return;
        var10_21 = 89 + v.\u02bc;
        v.\u02ca\u0971 = var10_21 % 128;
        var10_21 % 2;
        if (Build.VERSION.SDK_INT >= 22) {
            var12_22 = new Rect(0, 0, 0, 0);
            if (v.\u0971(var0.\u02cb, var12_22) == false) return;
            var13_23 = 65;
            if (var13_23 != 65) {
                return;
            }
            var14_24 = 61 + v.\u02bc;
            v.\u02ca\u0971 = var14_24 % 128;
            var15_25 = var14_24 % 2 == 0;
            if (var15_25 != false ? (var16_26 = var0.\u02ca).setIntersect(var12_22, var16_26) == false : (var16_26 = var0.\u02ca).setIntersect(var12_22, var16_26) == false) {
                return;
            }
        } else {
            var16_26 = var9_20;
        }
        if (q.\u02ca().\u02ce) {
            var18_27 = 39 + v.\u02ca\u0971;
            v.\u02bc = var18_27 % 128;
            var18_27 % 2;
            var20_28 = var0.\u02cb;
            var21_29 = Locale.ROOT;
            var22_30 = new Object[]{var0.\u02cb.getClass().getName(), var16_26.toString(), Float.valueOf((float)var0.\u02cb.getAlpha())};
            e.1.\u02ce("VisibilityInfo", (Object)var20_28, String.format((Locale)var21_29, (String)"Covered by %s-%s alpha=%f", (Object[])var22_30));
        }
        var2_2.\u02cb.add((Object)var16_26);
        if (var16_26.contains(var1_1) == false) return;
        var2_2.\u0971 = true;
    }

    private static Rect \u02cb(Rect rect, DisplayMetrics displayMetrics) {
        float f2 = displayMetrics.density;
        boolean bl2 = f2 == 0.0f;
        if (!bl2) {
            int n2 = Math.round((float)((float)rect.left / f2));
            int n3 = Math.round((float)((float)rect.right / f2));
            return new Rect(n2, Math.round((float)((float)rect.top / f2)), n3, Math.round((float)((float)rect.bottom / f2)));
        }
        int n4 = 27 + \u02bc;
        \u02ca\u0971 = n4 % 128;
        n4 % 2;
        int n5 = 17 + \u02bc;
        \u02ca\u0971 = n5 % 128;
        int n6 = n5 % 2 == 0 ? 75 : 76;
        if (n6 != 75) {
            // empty if block
        }
        return rect;
    }

    private static Map<String, String> \u02cb(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"x", (Object)String.valueOf((int)rect.left));
        hashMap.put((Object)"y", (Object)String.valueOf((int)rect.top));
        hashMap.put((Object)"w", (Object)String.valueOf((int)(rect.right - rect.left)));
        hashMap.put((Object)"h", (Object)String.valueOf((int)(rect.bottom - rect.top)));
        int n2 = 107 + \u02ca\u0971;
        \u02bc = n2 % 128;
        boolean bl2 = n2 % 2 != 0;
        if (bl2) {
            // empty if block
        }
        return hashMap;
    }

    private static Rect \u02ce(View view) {
        int[] arrn = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationOnScreen(arrn);
        int n2 = arrn[0];
        int n3 = arrn[1];
        Rect rect = new Rect(n2, n3, n2 + view.getWidth(), n3 + view.getHeight());
        int n4 = 81 + \u02ca\u0971;
        \u02bc = n4 % 128;
        if (n4 % 2 != 0) {
            // empty if block
        }
        return rect;
    }

    private static float \u02cf(View view) {
        int n2;
        float f2 = view.getAlpha();
        int n3 = 73 + \u02ca\u0971;
        \u02bc = n3 % 128;
        if (n3 % 2 != 0) {
            // empty if block
        }
        while ((n2 = view != null ? 88 : 19) != 19) {
            int n4 = 85 + \u02ca\u0971;
            \u02bc = n4 % 128;
            n4 % 2;
            if (view.getParent() == null) break;
            int n5 = 51 + \u02ca\u0971;
            \u02bc = n5 % 128;
            n5 % 2;
            if ((double)f2 == 0.0) break;
            int n6 = 83 + \u02ca\u0971;
            \u02bc = n6 % 128;
            n6 % 2;
            if (!(view.getParent() instanceof View)) break;
            f2 *= ((View)view.getParent()).getAlpha();
            view = (View)view.getParent();
        }
        int n7 = 17 + \u02bc;
        \u02ca\u0971 = n7 % 128;
        if (n7 % 2 == 0) {
            // empty if block
        }
        return f2;
    }

    private static int \u02cf(Rect rect, Set<Rect> set) {
        int n2;
        block10 : {
            block12 : {
                int n3;
                block11 : {
                    block9 : {
                        int n4 = 41 + \u02bc;
                        \u02ca\u0971 = n4 % 128;
                        boolean bl2 = n4 % 2 == 0;
                        if (bl2) break block9;
                        boolean bl3 = set.isEmpty();
                        n2 = 0;
                        if (bl3) break block10;
                        n3 = 0;
                        break block11;
                    }
                    if (set.isEmpty()) break block12;
                    n3 = 1;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(set);
                Collections.sort((List)arrayList, (Comparator)new Comparator<Rect>(){

                    public final /* synthetic */ int compare(Object object, Object object2) {
                        Rect rect = (Rect)object;
                        Rect rect2 = (Rect)object2;
                        return Integer.valueOf((int)rect.top).compareTo(Integer.valueOf((int)rect2.top));
                    }
                });
                ArrayList arrayList2 = new ArrayList();
                Iterator iterator = arrayList.iterator();
                do {
                    int n5;
                    if ((n5 = iterator.hasNext() ? 3 : 21) != 3) {
                        boolean bl4;
                        Collections.sort((List)arrayList2);
                        int n6 = 29 + \u02bc;
                        \u02ca\u0971 = n6 % 128;
                        n6 % 2;
                        int n7 = n3;
                        int n8 = 0;
                        while (!(bl4 = n8 >= arrayList2.size() - 1)) {
                            int n9;
                            Integer n10 = (Integer)arrayList2.get(n8);
                            if (!n10.equals(arrayList2.get(n9 = n8 + 1))) {
                                Rect rect2 = new Rect(((Integer)arrayList2.get(n8)).intValue(), rect.top, ((Integer)arrayList2.get(n9)).intValue(), rect.bottom);
                                int n11 = rect.top;
                                for (Rect rect3 : arrayList) {
                                    if (!Rect.intersects((Rect)rect3, (Rect)rect2)) continue;
                                    boolean bl5 = rect3.bottom <= n11;
                                    if (!bl5) {
                                        n7 += rect2.width() * (rect3.bottom - Math.max((int)n11, (int)rect3.top));
                                        n11 = rect3.bottom;
                                    }
                                    if (rect3.bottom != rect2.bottom) continue;
                                }
                            }
                            n8 = n9;
                        }
                        return n7;
                    }
                    Rect rect4 = (Rect)iterator.next();
                    arrayList2.add((Object)rect4.left);
                    arrayList2.add((Object)rect4.right);
                } while (true);
            }
            n2 = 1;
        }
        return n2;
    }

    static Rect \u0971(View view) {
        block6 : {
            block7 : {
                block5 : {
                    boolean bl2;
                    int n2 = 17 + \u02ca\u0971;
                    \u02bc = n2 % 128;
                    int n3 = n2 % 2;
                    boolean bl3 = n3 == 0;
                    if (bl3 == (bl2 = true)) break block5;
                    if (view == null) {
                        bl2 = false;
                    }
                    if (!bl2) break block6;
                    break block7;
                }
                if (view == null) break block6;
            }
            return v.\u02ce(view);
        }
        Rect rect = new Rect(0, 0, 0, 0);
        int n4 = 105 + \u02bc;
        \u02ca\u0971 = n4 % 128;
        if (n4 % 2 == 0) {
            // empty if block
        }
        return rect;
    }

    /*
     * Exception decompiling
     */
    private static c \u0971(Rect var0, View var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 10[UNCONDITIONALDOLOOP]
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

    private static boolean \u0971(View view, Rect rect) {
        int n2 = 45 + \u02ca\u0971;
        \u02bc = n2 % 128;
        boolean bl2 = n2 % 2 == 0;
        if (!bl2 ? view.getGlobalVisibleRect(rect) : view.getGlobalVisibleRect(rect)) {
            int[] arrn = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            view.getLocationInWindow(arrn);
            int[] arrn2 = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
            view.getLocationOnScreen(arrn2);
            rect.offset(arrn2[0] - arrn[0], arrn2[1] - arrn[1]);
            return true;
        }
        int n3 = 73 + \u02bc;
        \u02ca\u0971 = n3 % 128;
        int n4 = n3 % 2 == 0 ? 68 : 4;
        if (n4 != 4) {
            // empty if block
        }
        return false;
    }

    /*
     * Exception decompiling
     */
    final void \u02ca(String var1_1, View var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
        // org.benf.cfr.reader.b.a.a.j.b(Op04StructuredStatement.java:409)
        // org.benf.cfr.reader.b.a.a.j.d(Op04StructuredStatement.java:487)
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

    static final class c {
        int \u02ca = 0;
        final Set<Rect> \u02cb = new HashSet();
        boolean \u0971 = false;

        c() {
        }
    }

    static final class d {
        double \u02cb = 0.0;
        Rect \u02cf = new Rect(0, 0, 0, 0);
        double \u0971 = 0.0;

        d() {
        }
    }

    static final class e {
        final Rect \u02ca;
        final View \u02cb;

        e(View view, e e2) {
            this.\u02cb = view;
            if (e2 != null) {
                int n2 = e2.\u02ca.left;
                int n3 = e2.\u02ca.top;
                int n4 = n2 + view.getLeft();
                int n5 = n3 + view.getTop();
                this.\u02ca = new Rect(n4, n5, n4 + view.getWidth(), n5 + view.getHeight());
                return;
            }
            this.\u02ca = v.\u02ca(view);
        }
    }

}

