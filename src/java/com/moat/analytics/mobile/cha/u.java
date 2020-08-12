/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.location.Location
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.util.DisplayMetrics
 *  android.view.Display
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.WindowManager
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
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
package com.moat.analytics.mobile.cha;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import com.moat.analytics.mobile.cha.n;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.r;
import com.moat.analytics.mobile.cha.t;
import java.lang.ref.WeakReference;
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

final class u {
    private static int \u02bc = 0;
    private static int \u02cb\u0971 = 1;
    private Location \u02bb;
    private JSONObject \u02bd;
    private Rect \u02ca;
    private JSONObject \u02ca\u0971;
    private JSONObject \u02cb;
    private Rect \u02ce;
    private c \u02cf = new c();
    String \u0971 = "{}";
    private Map<String, Object> \u141d = new HashMap();

    u() {
    }

    private static float \u02ca(View view) {
        float f2 = view.getAlpha();
        int n2;
        while ((n2 = view != null ? 25 : 69) == 25) {
            boolean bl2 = view.getParent() != null;
            if (!bl2) {
                return f2;
            }
            double d2 = (double)f2 DCMPL 0.0;
            boolean bl3 = false;
            if (d2 != false) {
                bl3 = true;
            }
            if (!bl3) {
                return f2;
            }
            int n3 = view.getParent() instanceof View ? 27 : 93;
            if (n3 != 27) {
                return f2;
            }
            f2 *= ((View)view.getParent()).getAlpha();
            view = (View)view.getParent();
        }
        return f2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int \u02cb(Rect rect, Set<Rect> set) {
        boolean bl2;
        boolean bl3 = set.isEmpty();
        int n2 = 0;
        if (bl3) return n2;
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
        while (bl2 = iterator.hasNext()) {
            int n3 = 59 + \u02bc;
            \u02cb\u0971 = n3 % 128;
            boolean bl4 = n3 % 2 == 0;
            Rect rect2 = !bl4 ? (Rect)iterator.next() : (Rect)iterator.next();
            arrayList2.add((Object)rect2.left);
            arrayList2.add((Object)rect2.right);
        }
        Collections.sort((List)arrayList2);
        int n4 = 0;
        int n5 = 0;
        do {
            int n6;
            int n7 = n4 < arrayList2.size() - 1 ? 38 : 85;
            if (n7 == 85) return n5;
            Integer n8 = (Integer)arrayList2.get(n4);
            boolean bl5 = n8.equals(arrayList2.get(n6 = n4 + 1));
            if (!bl5) {
                int n9;
                Rect rect3 = new Rect(((Integer)arrayList2.get(n4)).intValue(), rect.top, ((Integer)arrayList2.get(n6)).intValue(), rect.bottom);
                int n10 = rect.top;
                Iterator iterator2 = arrayList.iterator();
                while ((n9 = iterator2.hasNext() ? 25 : 9) != 9) {
                    int n11 = 23 + \u02cb\u0971;
                    \u02bc = n11 % 128;
                    n11 % 2;
                    Rect rect4 = (Rect)iterator2.next();
                    boolean bl6 = Rect.intersects((Rect)rect4, (Rect)rect3);
                    if (!bl6) continue;
                    int n12 = rect4.bottom > n10 ? 16 : 65;
                    if (n12 == 16) {
                        n5 += rect3.width() * (rect4.bottom - Math.max((int)n10, (int)rect4.top));
                        n10 = rect4.bottom;
                    }
                    if (rect4.bottom != rect3.bottom) continue;
                }
            }
            n4 = n6;
        } while (true);
    }

    private static Rect \u02cb(Rect rect, DisplayMetrics displayMetrics) {
        float f2 = displayMetrics.density;
        boolean bl2 = f2 != 0.0f;
        if (!bl2) {
            return rect;
        }
        int n2 = Math.round((float)((float)rect.left / f2));
        int n3 = Math.round((float)((float)rect.right / f2));
        return new Rect(n2, Math.round((float)((float)rect.top / f2)), n3, Math.round((float)((float)rect.bottom / f2)));
    }

    static Rect \u02cb(View view) {
        int n2 = view != null ? 43 : 62;
        if (n2 != 43) {
            return new Rect(0, 0, 0, 0);
        }
        int n3 = 39 + \u02cb\u0971;
        \u02bc = n3 % 128;
        boolean bl2 = n3 % 2 == 0;
        if (bl2) {
            return u.\u02cf(view);
        }
        return u.\u02cf(view);
    }

    /*
     * Exception decompiling
     */
    private static b \u02cb(Rect var0, View var1_1) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 9[UNCONDITIONALDOLOOP]
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

    private static boolean \u02cb(View view, Rect rect) {
        int n2 = view.getGlobalVisibleRect(rect) ? 90 : 1;
        if (n2 != 90) {
            return false;
        }
        int[] arrn = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationInWindow(arrn);
        int[] arrn2 = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationOnScreen(arrn2);
        rect.offset(arrn2[0] - arrn[0], arrn2[1] - arrn[1]);
        return true;
    }

    private static Map<String, String> \u02ce(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"x", (Object)String.valueOf((int)rect.left));
        hashMap.put((Object)"y", (Object)String.valueOf((int)rect.top));
        hashMap.put((Object)"w", (Object)String.valueOf((int)(rect.right - rect.left)));
        hashMap.put((Object)"h", (Object)String.valueOf((int)(rect.bottom - rect.top)));
        return hashMap;
    }

    private static Rect \u02cf(View view) {
        int[] arrn = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationOnScreen(arrn);
        int n2 = arrn[0];
        int n3 = arrn[1];
        return new Rect(n2, n3, n2 + view.getWidth(), n3 + view.getHeight());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static void \u02cf(a var0, Rect var1_1, b var2_2) {
        block17 : {
            block16 : {
                var3_3 = var0.\u02cf;
                if (var3_3.isShown() == false) return;
                var4_4 = 19;
                if (var4_4 == 74) return;
                if (!((double)var3_3.getAlpha() > 0.0)) return;
                var44_5 = false;
                if (var44_5) {
                    return;
                }
                var45_6 = 3 + u.\u02bc;
                u.\u02cb\u0971 = var45_6 % 128;
                var45_6 % 2;
                var5_7 = true;
                if (!var5_7) {
                    return;
                }
                var6_8 = var0.\u02cf instanceof ViewGroup == false;
                var7_9 = 91;
                var8_10 = 90;
                if (!var6_8) break block16;
                var23_11 = true;
                break block17;
            }
            var9_12 = 39 + u.\u02cb\u0971;
            u.\u02bc = var9_12 % 128;
            var9_12 % 2;
            var11_13 = ViewGroup.class.equals((Object)var0.\u02cf.getClass().getSuperclass());
            var12_14 = var0.\u02cf;
            var13_15 = Build.VERSION.SDK_INT >= 19 ? 4 : 1;
            if (var13_15 != 4) ** GOTO lbl-1000
            var14_17 = 113 + u.\u02cb\u0971;
            u.\u02bc = var14_17 % 128;
            var15_18 = var14_17 % 2 != 0;
            if (var15_18 == true ? (var16_19 = var12_14.getBackground() != null ? 61 : 6) == 6 : (var43_16 = var12_14.getBackground() != null ? 89 : 48) != 89) ** GOTO lbl-1000
            var17_20 = var12_14.getBackground().getAlpha() == 0 ? 31 : 13;
            if (var17_20 != 31) {
                var18_21 = false;
            } else lbl-1000: // 3 sources:
            {
                var18_21 = true;
            }
            var19_22 = var11_13 != false ? 70 : 91;
            if (var19_22 != 70) ** GOTO lbl-1000
            var20_23 = 75 + u.\u02cb\u0971;
            u.\u02bc = var20_23 % 128;
            var21_24 = var20_23 % 2 == 0;
            if (var21_24 != true ? (var42_25 = var18_21 != false) != false : (var22_26 = var18_21 != false ? 83 : 57) != 57) {
                var23_11 = false;
            } else lbl-1000: // 2 sources:
            {
                var23_11 = true;
            }
            var24_27 = (ViewGroup)var0.\u02cf;
            var25_28 = var24_27.getChildCount();
            var26_29 = 0;
            while ((var27_30 = var26_29 < var25_28 ? 90 : 99) != 99) {
                var2_2.\u02ce = var41_31 = 1 + var2_2.\u02ce;
                if (var41_31 > 500) {
                    return;
                }
                u.\u02cf(new a(var24_27.getChildAt(var26_29), var0), var1_1, var2_2);
                if (var2_2.\u02ca) {
                    return;
                }
                ++var26_29;
            }
        }
        if (var23_11 == false) return;
        var28_32 = 52;
        if (var28_32 != 52) {
            return;
        }
        var29_33 = var0.\u02ce;
        if (!var29_33.setIntersect(var1_1, var29_33)) {
            var8_10 = 48;
        }
        if (var8_10 == 48) return;
        var30_34 = Build.VERSION.SDK_INT < 22;
        if (!var30_34) {
            var31_35 = new Rect(0, 0, 0, 0);
            if (u.\u02cb(var0.\u02cf, var31_35) == false) return;
            var32_36 = false;
            if (var32_36) {
                return;
            }
            var33_37 = var0.\u02ce;
            if (!var33_37.setIntersect(var31_35, var33_37)) {
                return;
            }
            var29_33 = var33_37;
        }
        var34_38 = t.\u02cf().\u02cb != false;
        if (var34_38) {
            var38_39 = var0.\u02cf;
            var39_40 = Locale.ROOT;
            var40_41 = new Object[]{var0.\u02cf.getClass().getName(), var29_33.toString(), Float.valueOf((float)var0.\u02cf.getAlpha())};
            com.moat.analytics.mobile.cha.a.\u02cf("VisibilityInfo", (Object)var38_39, String.format((Locale)var39_40, (String)"Covered by %s-%s alpha=%f", (Object[])var40_41));
        }
        var2_2.\u02cb.add((Object)var29_33);
        if (!var29_33.contains(var1_1)) {
            var7_9 = 25;
        }
        if (var7_9 == 25) return;
        var36_42 = 39 + u.\u02cb\u0971;
        u.\u02bc = var36_42 % 128;
        var36_42 % 2;
        var2_2.\u02ca = true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    final void \u02cb(String var1_1, View var2_2) {
        block59 : {
            block63 : {
                block62 : {
                    block61 : {
                        block58 : {
                            block60 : {
                                block57 : {
                                    block56 : {
                                        block55 : {
                                            block54 : {
                                                block53 : {
                                                    block52 : {
                                                        block51 : {
                                                            var3_3 = new HashMap();
                                                            var4_4 = "{}";
                                                            var5_5 = var2_2 != null;
                                                            if (var5_5 == false) return;
                                                            var6_6 = 5 + u.\u02bc;
                                                            u.\u02cb\u0971 = var6_6 % 128;
                                                            var6_6 % 2;
                                                            var9_7 = Build.VERSION.SDK_INT;
                                                            var10_8 = var9_7 < 17;
                                                            if (var10_8) ** GOTO lbl-1000
                                                            var143_9 = 113 + u.\u02cb\u0971;
                                                            u.\u02bc = var143_9 % 128;
                                                            var143_9 % 2;
                                                            var145_10 = com.moat.analytics.mobile.cha.c.\u02cf;
                                                            var146_11 = var145_10 != null ? 57 : 25;
                                                            if (var146_11 == 25) ** GOTO lbl-1000
                                                            var147_12 = 57 + u.\u02bc;
                                                            u.\u02cb\u0971 = var147_12 % 128;
                                                            var148_13 = var147_12 % 2 == 0;
                                                            if (!var148_13) ** GOTO lbl28
                                                            var149_14 = (Activity)com.moat.analytics.mobile.cha.c.\u02cf.get();
                                                            var151_15 = var149_14 != null;
                                                            if (var151_15) ** GOTO lbl-1000
                                                            ** GOTO lbl-1000
lbl28: // 1 sources:
                                                            var149_14 = (Activity)com.moat.analytics.mobile.cha.c.\u02cf.get();
                                                            var150_16 = var149_14 != null ? 60 : 48;
                                                            if (var150_16 != 48) lbl-1000: // 2 sources:
                                                            {
                                                                var11_17 = new DisplayMetrics();
                                                                var149_14.getWindowManager().getDefaultDisplay().getRealMetrics(var11_17);
                                                            } else lbl-1000: // 4 sources:
                                                            {
                                                                var11_17 = var2_2.getContext().getResources().getDisplayMetrics();
                                                            }
                                                            var12_18 = Build.VERSION.SDK_INT;
                                                            var13_19 = var12_18 < 19;
                                                            if (!var13_19) break block51;
                                                            var137_20 = var2_2 != null ? 57 : 9;
                                                            if (var137_20 != 57) ** GOTO lbl-1000
                                                            var138_21 = 45 + u.\u02cb\u0971;
                                                            u.\u02bc = var138_21 % 128;
                                                            var139_22 = var138_21 % 2 != 0 ? 1 : 65;
                                                            if (var139_22 == 1) ** GOTO lbl46
                                                            var142_23 = var2_2.getWindowToken() != null ? 91 : 69;
lbl46: // 1 sources:
                                                            var140_24 = var2_2.getWindowToken();
                                                            var141_25 = var140_24 != null ? 90 : 20;
                                                            if (var141_25 == 90) ** GOTO lbl-1000
                                                            ** GOTO lbl-1000
                                                        }
                                                        var14_27 = 51 + u.\u02bc;
                                                        u.\u02cb\u0971 = var14_27 % 128;
                                                        var14_27 % 2;
                                                        var16_28 = var2_2 != null;
                                                        if (!var16_28) ** GOTO lbl-1000
                                                        var17_29 = var2_2.isAttachedToWindow();
                                                        var18_30 = var17_29 != false;
                                                        if (!var18_30) ** GOTO lbl-1000
                                                        var19_31 = 69 + u.\u02cb\u0971;
                                                        u.\u02bc = var19_31 % 128;
                                                        var19_31 % 2;
                                                        ** GOTO lbl-1000
                                                        if (var142_23 == 69) lbl-1000: // 5 sources:
                                                        {
                                                            var21_26 = false;
                                                        } else lbl-1000: // 3 sources:
                                                        {
                                                            var21_26 = true;
                                                        }
                                                        var22_32 = var2_2 != null ? 54 : 37;
                                                        if (var22_32 == 37) ** GOTO lbl-1000
                                                        var133_33 = 101 + u.\u02cb\u0971;
                                                        u.\u02bc = var133_33 % 128;
                                                        var134_34 = var133_33 % 2 != 0 ? 91 : 31;
                                                        if (var134_34 == 91) ** GOTO lbl78
                                                        var136_35 = var2_2.hasWindowFocus() != false ? 14 : 16;
                                                        if (var136_35 == 16) ** GOTO lbl-1000
                                                        ** GOTO lbl-1000
lbl78: // 1 sources:
                                                        var135_36 = var2_2.hasWindowFocus() != false;
                                                        if (var135_36) lbl-1000: // 2 sources:
                                                        {
                                                            var23_37 = true;
                                                        } else lbl-1000: // 3 sources:
                                                        {
                                                            var23_37 = false;
                                                        }
                                                        var24_38 = var2_2 != null ? 82 : 4;
                                                        var26_40 = var24_38 == 4 || (var25_39 = var2_2.isShown() == false ? 64 : 37) != 37;
                                                        var27_41 = var2_2 == null;
                                                        var28_42 = var27_41 != true ? u.\u02ca(var2_2) : 0.0f;
                                                        var3_3.put((Object)"dr", (Object)Float.valueOf((float)var11_17.density));
                                                        var3_3.put((Object)"dv", (Object)r.\u0971());
                                                        var3_3.put((Object)"adKey", (Object)var1_1);
                                                        var32_43 = var21_26 != false ? 23 : 30;
                                                        if (var32_43 == 23) break block52;
                                                        var33_44 = 0;
                                                        break block53;
                                                    }
                                                    var132_45 = 89 + u.\u02cb\u0971;
                                                    u.\u02bc = var132_45 % 128;
                                                    if (var132_45 % 2 != 0) {
                                                        // empty if block
                                                    }
                                                    var33_44 = 1;
                                                }
                                                var3_3.put((Object)"isAttached", (Object)var33_44);
                                                var35_46 = var23_37 != false ? 85 : 1;
                                                if (var35_46 == 85) break block54;
                                                var36_47 = 0;
                                                break block55;
                                            }
                                            var130_48 = 19 + u.\u02bc;
                                            u.\u02cb\u0971 = var130_48 % 128;
                                            var130_48 % 2;
                                            var36_47 = 1;
                                        }
                                        var3_3.put((Object)"inFocus", (Object)var36_47);
                                        var38_49 = var26_40 != false ? 48 : 42;
                                        if (var38_49 == 48) break block56;
                                        var39_50 = 0;
                                        break block57;
                                    }
                                    var129_51 = 27 + u.\u02cb\u0971;
                                    u.\u02bc = var129_51 % 128;
                                    if (var129_51 % 2 != 0) {
                                        // empty if block
                                    }
                                    var39_50 = 1;
                                }
                                var3_3.put((Object)"isHidden", (Object)var39_50);
                                var3_3.put((Object)"opacity", (Object)Float.valueOf((float)var28_42));
                                var42_52 = new Rect(0, 0, var11_17.widthPixels, var11_17.heightPixels);
                                var43_53 = var2_2 != null ? 88 : 57;
                                var44_54 = var43_53 != 88 ? new Rect(0, 0, 0, 0) : u.\u02cf(var2_2);
                                var45_55 = new c();
                                var46_56 = var44_54.width();
                                var47_57 = var44_54.height();
                                var48_58 = var46_56 * var47_57;
                                var49_59 = var2_2 != null ? 5 : 74;
                                if (var49_59 != 5) ** GOTO lbl196
                                var50_60 = 21 + u.\u02cb\u0971;
                                u.\u02bc = var50_60 % 128;
                                var50_60 % 2;
                                var52_61 = var21_26 != false ? 67 : 86;
                                if (var52_61 == 86 || (var93_62 = var23_37 != false ? 10 : 40) == 40) ** GOTO lbl196
                                var94_63 = 87 + u.\u02bc;
                                u.\u02cb\u0971 = var94_63 % 128;
                                var94_63 % 2;
                                var96_64 = var26_40 == false ? 41 : 78;
                                if (var96_64 == 78 || (var97_65 = var48_58 > 0 ? 1 : 13) != 1) ** GOTO lbl196
                                var98_66 = 101 + u.\u02cb\u0971;
                                u.\u02bc = var98_66 % 128;
                                var99_67 = var98_66 % 2 != 0 ? 38 : 57;
                                if (var99_67 == 38) ** GOTO lbl162
                                var100_68 = new Rect(0, 0, 0, 0);
                                if (u.\u02cb(var2_2, var100_68)) {
                                    var127_69 = 9;
                                    var128_70 = 9;
                                } else {
                                    var128_70 = 49;
                                    var127_69 = 9;
                                }
                                if (var128_70 == var127_69) break block60;
                                ** GOTO lbl196
lbl162: // 1 sources:
                                var100_68 = new Rect(0, 0, 0, 0);
                                var101_71 = u.\u02cb(var2_2, var100_68) != false;
                                if (!var101_71) ** GOTO lbl196
                            }
                            if (var103_73 = (var102_72 = var100_68.width() * var100_68.height()) < var48_58) {
                                com.moat.analytics.mobile.cha.a.\u02cf("VisibilityInfo", null, "Ad is clipped");
                            }
                            if (!(var104_74 = var2_2.getRootView() instanceof ViewGroup != false)) ** GOTO lbl196
                            var45_55.\u02cb = var100_68;
                            var105_75 = u.\u02cb(var100_68, var2_2);
                            var106_76 = var105_75.\u02ca != false;
                            if (var106_76) ** GOTO lbl195
                            var107_77 = u.\u02cb((Rect)var100_68, var105_75.\u02cb);
                            var108_78 = var107_77 > 0 ? 90 : 4;
                            if (var108_78 == 4) break block58;
                            var117_79 = 35 + u.\u02cb\u0971;
                            u.\u02bc = var117_79 % 128;
                            var117_79 % 2;
                            var119_80 = var107_77;
                            var121_81 = var102_72;
                            Double.isNaN((double)var119_80);
                            Double.isNaN((double)var121_81);
                            var125_82 = var119_80 / var121_81;
                            var45_55.\u0971 = var125_82;
                        }
                        var109_83 = var102_72 - var107_77;
                        var111_84 = var48_58;
                        Double.isNaN((double)var109_83);
                        Double.isNaN((double)var111_84);
                        var115_85 = var109_83 / var111_84;
                        var45_55.\u02ca = var115_85;
                        break block61;
lbl195: // 1 sources:
                        var45_55.\u0971 = 1.0;
                    }
                    var54_87 = (var53_86 = this.\u02cb) != null;
                    if (!var54_87) ** GOTO lbl-1000
                    var90_88 = 39 + u.\u02cb\u0971;
                    u.\u02bc = var90_88 % 128;
                    if (var90_88 % 2 == 0) ** GOTO lbl205
                    if (var45_55.\u02ca != this.\u02cf.\u02ca) ** GOTO lbl-1000
                    break block62;
lbl205: // 1 sources:
                    var91_89 = var45_55.\u02ca == this.\u02cf.\u02ca ? 38 : 71;
                    if (var91_89 == 71) ** GOTO lbl-1000
                }
                var92_90 = var45_55.\u02cb.equals((Object)this.\u02cf.\u02cb) != false;
                if (!var92_90 || var45_55.\u0971 != this.\u02cf.\u0971) lbl-1000: // 4 sources:
                {
                    this.\u02cf = var45_55;
                    this.\u02cb = new JSONObject((Map)u.\u02ce((Rect)u.\u02cb(this.\u02cf.\u02cb, var11_17)));
                    var55_91 = true;
                } else {
                    var55_91 = false;
                }
                var3_3.put((Object)"coveredPercent", (Object)var45_55.\u0971);
                var57_92 = this.\u02ca\u0971;
                var58_93 = var57_92 != null;
                if (!var58_93) ** GOTO lbl224
                var88_94 = 37 + u.\u02cb\u0971;
                u.\u02bc = var88_94 % 128;
                var88_94 % 2;
                if (var42_52.equals((Object)this.\u02ce)) break block63;
lbl224: // 2 sources:
                this.\u02ce = var42_52;
                this.\u02ca\u0971 = new JSONObject((Map)u.\u02ce((Rect)u.\u02cb(var42_52, var11_17)));
                var55_91 = true;
            }
            if ((var59_95 = this.\u02bd != null ? 18 : 71) == 71 || !var44_54.equals((Object)this.\u02ca)) {
                this.\u02ca = var44_54;
                this.\u02bd = new JSONObject((Map)u.\u02ce((Rect)u.\u02cb(var44_54, var11_17)));
                var55_91 = true;
            }
            if ((var60_96 = this.\u141d) != null) {
                var61_97 = true;
                var62_98 = false;
            } else {
                var61_97 = true;
                var62_98 = true;
            }
            if (var62_98 == var61_97) ** GOTO lbl250
            var85_99 = 113 + u.\u02bc;
            u.\u02cb\u0971 = var85_99 % 128;
            var85_99 % 2;
            try {
                block64 : {
                    if (!var3_3.equals(this.\u141d)) {
                        var61_97 = true;
                        var87_100 = false;
                    } else {
                        var61_97 = true;
                        var87_100 = true;
                    }
                    if (var87_100 == var61_97) break block64;
lbl250: // 2 sources:
                    this.\u141d = var3_3;
                    var55_91 = true;
                }
                ** if ((var65_103 = (var64_102 = n.\u02ce((Location)(var63_101 = n.\u02cf().\u02ca()), (Location)this.\u02bb)) == false ? 21 : 93) == 93) goto lbl-1000
            }
            catch (Exception var8_111) {
                o.\u02ce(var8_111);
                this.\u0971 = var4_4;
            }
lbl-1000: // 1 sources:
            {
                var83_104 = 81 + u.\u02cb\u0971;
                u.\u02bc = var83_104 % 128;
                var83_104 % 2;
                this.\u02bb = var63_101;
                var55_91 = true;
            }
lbl-1000: // 2 sources:
            {
                break block59;
            }
            return;
        }
        if (var55_91 == false) return;
        var66_112 = false;
        if (var66_112) {
            return;
        }
        var67_105 = new JSONObject(this.\u141d);
        var67_105.accumulate("screen", (Object)this.\u02ca\u0971);
        var67_105.accumulate("view", (Object)this.\u02bd);
        var67_105.accumulate("visible", (Object)this.\u02cb);
        var67_105.accumulate("maybe", (Object)this.\u02cb);
        var67_105.accumulate("visiblePercent", (Object)this.\u02cf.\u02ca);
        if (var63_101 != null) {
            var74_106 = 62;
            var73_107 = 60;
        } else {
            var73_107 = 60;
            var74_106 = 60;
        }
        if (var74_106 != var73_107) {
            if (var63_101 != null) {
                var61_97 = false;
            }
            if (var61_97) {
                var75_108 = null;
            } else {
                var75_108 = new HashMap();
                var75_108.put((Object)"latitude", (Object)Double.toString((double)var63_101.getLatitude()));
                var75_108.put((Object)"longitude", (Object)Double.toString((double)var63_101.getLongitude()));
                var75_108.put((Object)"timestamp", (Object)Long.toString((long)var63_101.getTime()));
                var75_108.put((Object)"horizontalAccuracy", (Object)Float.toString((float)var63_101.getAccuracy()));
            }
            var80_109 = var75_108 == null ? 14 : 85;
            var81_110 = var80_109 != 14 ? new JSONObject((Map)var75_108) : null;
            var67_105.accumulate("location", (Object)var81_110);
        }
        this.\u0971 = var4_4 = var67_105.toString();
    }

    static final class a {
        final Rect \u02ce;
        final View \u02cf;

        a(View view, a a2) {
            this.\u02cf = view;
            if (a2 != null) {
                int n2 = a2.\u02ce.left;
                int n3 = a2.\u02ce.top;
                int n4 = n2 + view.getLeft();
                int n5 = n3 + view.getTop();
                this.\u02ce = new Rect(n4, n5, n4 + view.getWidth(), n5 + view.getHeight());
                return;
            }
            this.\u02ce = u.\u02cf(view);
        }
    }

    static final class b {
        boolean \u02ca = false;
        final Set<Rect> \u02cb = new HashSet();
        int \u02ce = 0;

        b() {
        }
    }

    static final class c {
        double \u02ca = 0.0;
        Rect \u02cb = new Rect(0, 0, 0, 0);
        double \u0971 = 0.0;

        c() {
        }
    }

}

