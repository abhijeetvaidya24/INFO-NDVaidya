/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Rect
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
 *  android.widget.ListView
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.ArrayDeque
 *  java.util.ArrayList
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Comparator
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.iro;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.location.Location;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.ListView;
import com.moat.analytics.mobile.iro.k;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.p;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

final class y {
    private static int \u02ca\u0971 = 0;
    private static int \u02cf\u0971 = 1;
    private Location \u02bb;
    private Map<String, Object> \u02bc = new HashMap();
    private JSONObject \u02bd;
    private a \u02ca = new a();
    private Rect \u02cb;
    String \u02ce = "{}";
    private JSONObject \u02cf;
    private Rect \u0971;
    private JSONObject \u141d;

    y() {
    }

    private static float \u02ca(View view) {
        float f2 = view.getAlpha();
        do {
            int n2;
            int n3;
            if ((n3 = view != null ? 83 : 99) != 83) {
                return f2;
            }
            int n4 = view.getParent() != null ? 13 : 18;
            if (n4 == 18 || (n2 = (double)f2 != 0.0 ? 68 : 5) == 5) break;
            int n5 = 121 + \u02ca\u0971;
            \u02cf\u0971 = n5 % 128;
            n5 % 2;
            int n6 = view.getParent() instanceof View ? 72 : 1;
            if (n6 != 72) {
                return f2;
            }
            int n7 = 117 + \u02ca\u0971;
            \u02cf\u0971 = n7 % 128;
            n7 % 2;
            f2 *= ((View)view.getParent()).getAlpha();
            view = (View)view.getParent();
        } while (true);
        return f2;
    }

    private static int \u02ca(Rect rect, Set<Rect> set) {
        if (!set.isEmpty()) {
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
                boolean bl2;
                if (!(bl2 = iterator.hasNext())) {
                    Collections.sort((List)arrayList2);
                    int n2 = 0;
                    int n3 = 0;
                    do {
                        boolean bl3;
                        if (bl3 = n2 >= arrayList2.size() - 1) {
                            return n3;
                        }
                        int n4 = 99 + \u02cf\u0971;
                        \u02ca\u0971 = n4 % 128;
                        n4 % 2;
                        Integer n5 = (Integer)arrayList2.get(n2);
                        int n6 = n2 + 1;
                        int n7 = !n5.equals(arrayList2.get(n6)) ? 97 : 49;
                        if (n7 != 49) {
                            int n8;
                            Rect rect2 = new Rect(((Integer)arrayList2.get(n2)).intValue(), rect.top, ((Integer)arrayList2.get(n6)).intValue(), rect.bottom);
                            int n9 = rect.top;
                            Iterator iterator2 = arrayList.iterator();
                            while ((n8 = iterator2.hasNext() ? 94 : 17) != 17) {
                                Rect rect3 = (Rect)iterator2.next();
                                boolean bl4 = Rect.intersects((Rect)rect3, (Rect)rect2);
                                if (!bl4) continue;
                                int n10 = rect3.bottom > n9 ? 3 : 47;
                                if (n10 == 3) {
                                    n3 += rect2.width() * (rect3.bottom - Math.max((int)n9, (int)rect3.top));
                                    n9 = rect3.bottom;
                                }
                                if (rect3.bottom != rect2.bottom) continue;
                            }
                        }
                        n2 = n6;
                    } while (true);
                }
                int n11 = 101 + \u02ca\u0971;
                \u02cf\u0971 = n11 % 128;
                n11 % 2;
                Rect rect4 = (Rect)iterator.next();
                arrayList2.add((Object)rect4.left);
                arrayList2.add((Object)rect4.right);
            } while (true);
        }
        return 0;
    }

    private static Rect \u02ce(Rect rect, DisplayMetrics displayMetrics) {
        float f2 = displayMetrics.density;
        boolean bl2 = f2 != 0.0f;
        if (!bl2) {
            return rect;
        }
        int n2 = Math.round((float)((float)rect.left / f2));
        int n3 = Math.round((float)((float)rect.right / f2));
        return new Rect(n2, Math.round((float)((float)rect.top / f2)), n3, Math.round((float)((float)rect.bottom / f2)));
    }

    static Rect \u02cf(View view) {
        int n2 = view != null ? 10 : 90;
        if (n2 != 90) {
            return y.\u0971(view);
        }
        return new Rect(0, 0, 0, 0);
    }

    private static void \u02cf(ArrayDeque<b> arrayDeque, b b2, boolean bl2) {
        int n2 = b2.\u02ca instanceof ViewGroup ? 63 : 47;
        if (n2 != 47) {
            int n3 = 107 + \u02cf\u0971;
            \u02ca\u0971 = n3 % 128;
            n3 % 2;
            boolean bl3 = !(b2.\u02ca instanceof ListView);
            if (!bl3) {
                return;
            }
            ViewGroup viewGroup = (ViewGroup)b2.\u02ca;
            for (int i2 = viewGroup.getChildCount() - 1; i2 >= 0; --i2) {
                arrayDeque.add((Object)new b(viewGroup.getChildAt(i2), 1 + b2.\u0971, bl2));
            }
        }
    }

    /*
     * Exception decompiling
     */
    private static boolean \u02cf(Rect var0, View var1_1, Set<Rect> var2_2) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[TRYBLOCK]], but top level block is 14[UNCONDITIONALDOLOOP]
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

    private static Rect \u0971(View view) {
        int[] arrn = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        view.getLocationInWindow(arrn);
        int n2 = arrn[0];
        int n3 = arrn[1];
        return new Rect(n2, n3, n2 + view.getWidth(), n3 + view.getHeight());
    }

    private static Map<String, String> \u0971(Rect rect) {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"x", (Object)String.valueOf((int)rect.left));
        hashMap.put((Object)"y", (Object)String.valueOf((int)rect.top));
        hashMap.put((Object)"w", (Object)String.valueOf((int)(rect.right - rect.left)));
        hashMap.put((Object)"h", (Object)String.valueOf((int)(rect.bottom - rect.top)));
        return hashMap;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    final void \u02ce(String var1_1, View var2_2) {
        block63 : {
            block62 : {
                block52 : {
                    block51 : {
                        block60 : {
                            block61 : {
                                block58 : {
                                    block59 : {
                                        block57 : {
                                            block56 : {
                                                block50 : {
                                                    block49 : {
                                                        block48 : {
                                                            block47 : {
                                                                block55 : {
                                                                    block54 : {
                                                                        block46 : {
                                                                            block45 : {
                                                                                block53 : {
                                                                                    var3_3 = new HashMap();
                                                                                    var4_4 = "{}";
                                                                                    if (var2_2 == null) return;
                                                                                    var5_5 = 78;
                                                                                    if (var5_5 != 78) {
                                                                                        return;
                                                                                    }
                                                                                    var6_6 = 31 + y.\u02cf\u0971;
                                                                                    y.\u02ca\u0971 = var6_6 % 128;
                                                                                    var6_6 % 2;
                                                                                    var10_7 = Build.VERSION.SDK_INT;
                                                                                    var11_8 = var10_7 < 17;
                                                                                    if (var11_8) ** GOTO lbl-1000
                                                                                    var12_9 = 93 + y.\u02ca\u0971;
                                                                                    y.\u02cf\u0971 = var12_9 % 128;
                                                                                    var12_9 % 2;
                                                                                    var14_10 = com.moat.analytics.mobile.iro.a.\u02ca;
                                                                                    var15_11 = var14_10 == null;
                                                                                    if (var15_11) ** GOTO lbl-1000
                                                                                    var158_12 = 85 + y.\u02cf\u0971;
                                                                                    y.\u02ca\u0971 = var158_12 % 128;
                                                                                    var159_13 = var158_12 % 2 != 0;
                                                                                    if (var159_13) ** GOTO lbl30
                                                                                    var160_14 = (Activity)com.moat.analytics.mobile.iro.a.\u02ca.get();
                                                                                    var162_15 = var160_14 != null ? 96 : 59;
                                                                                    if (var162_15 == 59) ** GOTO lbl-1000
                                                                                    ** GOTO lbl-1000
lbl30: // 1 sources:
                                                                                    var160_14 = (Activity)com.moat.analytics.mobile.iro.a.\u02ca.get();
                                                                                    var161_16 = var160_14 != null ? 86 : 91;
                                                                                    if (var161_16 == 86) lbl-1000: // 2 sources:
                                                                                    {
                                                                                        var16_17 = new DisplayMetrics();
                                                                                        var160_14.getWindowManager().getDefaultDisplay().getRealMetrics(var16_17);
                                                                                    } else lbl-1000: // 4 sources:
                                                                                    {
                                                                                        var16_17 = var2_2.getContext().getResources().getDisplayMetrics();
                                                                                    }
                                                                                    var17_18 = Build.VERSION.SDK_INT < 19;
                                                                                    if (!var17_18) break block53;
                                                                                    var156_19 = var2_2 != null ? 25 : 26;
                                                                                    if (var156_19 == 26 || (var157_20 = var2_2.getWindowToken() != null ? 66 : 38) == 38) ** GOTO lbl-1000
                                                                                    ** GOTO lbl-1000
                                                                                }
                                                                                var18_121 = var2_2 != null ? 12 : 43;
                                                                                if (var18_121 == 12 && (var19_21 = var2_2.isAttachedToWindow() != false ? 33 : 50) == 33) lbl-1000: // 2 sources:
                                                                                {
                                                                                    var20_22 = true;
                                                                                } else lbl-1000: // 2 sources:
                                                                                {
                                                                                    var20_22 = false;
                                                                                }
                                                                                var21_122 = var2_2 != null;
                                                                                var24_25 = var21_122 == true && (var23_24 = (var22_23 = var2_2.hasWindowFocus()) != false) == true;
                                                                                var25_26 = var2_2 == null;
                                                                                if (var25_26) break block45;
                                                                                var26_27 = 69 + y.\u02ca\u0971;
                                                                                y.\u02cf\u0971 = var26_27 % 128;
                                                                                var27_28 = var26_27 % 2 == 0 ? 66 : 46;
                                                                                if (var27_28 == 66) ** GOTO lbl58
                                                                                var155_29 = var2_2.isShown() == false ? 69 : 89;
lbl58: // 1 sources:
                                                                                var28_30 = var2_2.isShown();
                                                                                var29_31 = var28_30 == false ? 87 : 52;
                                                                                if (var29_31 == 52) break block46;
                                                                                break block45;
                                                                                if (var155_29 != 69) break block46;
                                                                            }
                                                                            var30_32 = true;
                                                                            break block54;
                                                                        }
                                                                        var30_32 = false;
                                                                    }
                                                                    var31_33 = var2_2 == null ? 48 : 37;
                                                                    if (var31_33 == 37) break block55;
                                                                    var153_34 = 67 + y.\u02cf\u0971;
                                                                    y.\u02ca\u0971 = var153_34 % 128;
                                                                    var153_34 % 2;
                                                                    var32_35 = 0.0f;
                                                                    ** GOTO lbl79
                                                                }
                                                                var32_35 = y.\u02ca(var2_2);
lbl79: // 2 sources:
                                                                var3_3.put((Object)"dr", (Object)Float.valueOf((float)var16_17.density));
                                                                var3_3.put((Object)"dv", (Object)p.\u0971());
                                                                var3_3.put((Object)"adKey", (Object)var1_1);
                                                                var36_36 = var20_22 != false;
                                                                if (var36_36) break block47;
                                                                var37_37 = 0;
                                                                break block48;
                                                            }
                                                            var151_38 = 77 + y.\u02ca\u0971;
                                                            y.\u02cf\u0971 = var151_38 % 128;
                                                            var151_38 % 2;
                                                            var37_37 = 1;
                                                        }
                                                        var3_3.put((Object)"isAttached", (Object)var37_37);
                                                        var39_39 = var24_25 != false;
                                                        var40_40 = var39_39 != true ? 0 : 1;
                                                        var3_3.put((Object)"inFocus", (Object)var40_40);
                                                        var42_41 = var30_32 != false;
                                                        var43_42 = var42_41 != true ? 0 : 1;
                                                        var3_3.put((Object)"isHidden", (Object)var43_42);
                                                        var3_3.put((Object)"opacity", (Object)Float.valueOf((float)var32_35));
                                                        var46_43 = new Rect(0, 0, var16_17.widthPixels, var16_17.heightPixels);
                                                        var47_44 = var2_2 == null;
                                                        var48_45 = var47_44 != true ? y.\u0971(var2_2) : new Rect(0, 0, 0, 0);
                                                        var49_46 = new a();
                                                        var50_47 = var48_45.width();
                                                        var51_48 = var48_45.height();
                                                        var52_49 = var50_47 * var51_48;
                                                        var53_50 = var2_2 != null ? 34 : 55;
                                                        if (var53_50 == 55) ** GOTO lbl176
                                                        var104_51 = 45 + y.\u02ca\u0971;
                                                        y.\u02cf\u0971 = var104_51 % 128;
                                                        var105_52 = var104_51 % 2 == 0;
                                                        if (!(var105_52 != false ? (var150_53 = var20_22 == false) != true : (var106_54 = var20_22 != false ? 72 : 90) != 90) || (var107_55 = var24_25 == false) || (var108_56 = var30_32 == false ? 18 : 91) == 91) ** GOTO lbl176
                                                        var109_57 = 17 + y.\u02cf\u0971;
                                                        y.\u02ca\u0971 = var109_57 % 128;
                                                        var109_57 % 2;
                                                        var111_58 = var52_49 <= 0;
                                                        if (var111_58) ** GOTO lbl176
                                                        var112_59 = 121 + y.\u02cf\u0971;
                                                        y.\u02ca\u0971 = var112_59 % 128;
                                                        var112_59 % 2;
                                                        var114_60 = new Rect(0, 0, 0, 0);
                                                        var115_61 = var2_2.getGlobalVisibleRect(var114_60) != false;
                                                        if (!var115_61) ** GOTO lbl176
                                                        var116_62 = var114_60.width();
                                                        var118_64 = var116_62 * (var117_63 = var114_60.height());
                                                        var119_65 = var118_64 >= var52_49;
                                                        if (var119_65) ** GOTO lbl135
                                                        var120_66 = 39 + y.\u02cf\u0971;
                                                        y.\u02ca\u0971 = var120_66 % 128;
                                                        var120_66 % 2;
                                                        com.moat.analytics.mobile.iro.b.\u02cf("VisibilityInfo", null, "Ad is clipped");
lbl135: // 2 sources:
                                                        var122_67 = new HashSet();
                                                        var123_68 = var2_2.getRootView() instanceof ViewGroup;
                                                        var124_69 = var123_68 != false ? 41 : 84;
                                                        if (var124_69 != 41) ** GOTO lbl176
                                                        var125_70 = 49 + y.\u02ca\u0971;
                                                        y.\u02cf\u0971 = var125_70 % 128;
                                                        var125_70 % 2;
                                                        var49_46.\u02ca = var114_60;
                                                        var127_71 = y.\u02cf((Rect)var114_60, (View)var2_2, (HashSet)var122_67);
                                                        var128_72 = var127_71 != false ? 89 : 92;
                                                        if (var128_72 != 92) {
                                                            var49_46.\u02ce = 1.0;
                                                        }
                                                        if ((var129_123 = var127_71 == false ? 21 : 18) != 21) ** GOTO lbl176
                                                        var130_73 = y.\u02ca((Rect)var114_60, (HashSet)var122_67);
                                                        var131_74 = var130_73 > 0 ? 93 : 26;
                                                        if (var131_74 == 93) break block49;
                                                        var9_75 = var4_4;
                                                        break block50;
                                                    }
                                                    var132_76 = 87 + y.\u02ca\u0971;
                                                    y.\u02cf\u0971 = var132_76 % 128;
                                                    var132_76 % 2;
                                                    var134_77 = var130_73;
                                                    var9_75 = var4_4;
                                                    var136_78 = var118_64;
                                                    Double.isNaN((double)var134_77);
                                                    Double.isNaN((double)var136_78);
                                                    var140_79 = var134_77 / var136_78;
                                                    try {
                                                        var49_46.\u02ce = var140_79;
                                                    }
                                                    catch (Exception var8_118) {}
                                                }
                                                var142_80 = var118_64 - var130_73;
                                                var144_81 = var52_49;
                                                Double.isNaN((double)var142_80);
                                                Double.isNaN((double)var144_81);
                                                var148_82 = var142_80 / var144_81;
                                                var49_46.\u02cb = var148_82;
                                                break block56;
lbl176: // 6 sources:
                                                var9_75 = var4_4;
                                            }
                                            var55_84 = (var54_83 = this.\u02cf) == null;
                                            if (var55_84) ** GOTO lbl-1000
                                            var56_85 = 99 + y.\u02ca\u0971;
                                            y.\u02cf\u0971 = var56_85 % 128;
                                            var57_86 = var56_85 % 2 == 0 ? 66 : 16;
                                            if (var57_86 == 66) ** GOTO lbl188
                                            var103_87 = var49_46.\u02cb == this.\u02ca.\u02cb;
                                            if (!var103_87) ** GOTO lbl-1000
                                            break block57;
lbl188: // 1 sources:
                                            var58_88 = var49_46.\u02cb == this.\u02ca.\u02cb ? 82 : 3;
                                            if (var58_88 != 82) ** GOTO lbl-1000
                                        }
                                        var59_89 = var49_46.\u02ca.equals((Object)this.\u02ca.\u02ca) != false ? 24 : 42;
                                        if (var59_89 == 42 || var49_46.\u02ce != this.\u02ca.\u02ce) lbl-1000: // 4 sources:
                                        {
                                            this.\u02ca = var49_46;
                                            this.\u02cf = new JSONObject((Map)y.\u0971((Rect)y.\u02ce(this.\u02ca.\u02ca, var16_17)));
                                            var60_90 = true;
                                        } else {
                                            var60_90 = false;
                                        }
                                        var3_3.put((Object)"coveredPercent", (Object)var49_46.\u02ce);
                                        var62_91 = this.\u02bd;
                                        var63_92 = var62_91 != null;
                                        if (!var63_92) ** GOTO lbl215
                                        var100_93 = 9 + y.\u02ca\u0971;
                                        y.\u02cf\u0971 = var100_93 % 128;
                                        if (var100_93 % 2 == 0) {
                                            var102_94 = 7;
                                            var101_95 = 89;
                                        } else {
                                            var101_95 = 89;
                                            var102_94 = 89;
                                        }
                                        if (var102_94 == var101_95) ** GOTO lbl214
                                        if (var46_43.equals((Object)this.\u0971)) break block58;
                                        break block59;
lbl214: // 1 sources:
                                        if (var46_43.equals((Object)this.\u0971)) break block58;
                                    }
                                    this.\u0971 = var46_43;
                                    this.\u02bd = new JSONObject((Map)y.\u0971((Rect)y.\u02ce(var46_43, var16_17)));
                                    var60_90 = true;
                                }
                                if ((var64_96 = this.\u141d == null) || !var48_45.equals((Object)this.\u02cb)) {
                                    this.\u02cb = var48_45;
                                    this.\u141d = new JSONObject((Map)y.\u0971((Rect)y.\u02ce(var48_45, var16_17)));
                                    var60_90 = true;
                                }
                                if (var66_98 = (var65_97 = this.\u02bc) == null) ** GOTO lbl238
                                var67_99 = 99 + y.\u02cf\u0971;
                                y.\u02ca\u0971 = var67_99 % 128;
                                if (var67_99 % 2 == 0) ** GOTO lbl231
                                if (var3_3.equals(this.\u02bc)) break block60;
                                break block61;
lbl231: // 1 sources:
                                if (!var3_3.equals(this.\u02bc)) {
                                    var68_100 = true;
                                    var69_101 = true;
                                } else {
                                    var68_100 = true;
                                    var69_101 = false;
                                }
                                if (var69_101 != var68_100) break block60;
                            }
                            this.\u02bc = var3_3;
                            var60_90 = true;
                        }
                        if (!(var72_104 = (var71_103 = k.\u02ce(var70_102 = k.\u02ce().\u0971(), this.\u02bb)) == false)) break block51;
                        var98_105 = 103 + y.\u02cf\u0971;
                        y.\u02ca\u0971 = var98_105 % 128;
                        var98_105 % 2;
                        this.\u02bb = var70_102;
                        var60_90 = true;
                    }
                    if (var60_90 == false) return;
                    var73_106 = false;
                    if (var73_106) {
                        return;
                    }
                    var74_107 = 57 + y.\u02ca\u0971;
                    y.\u02cf\u0971 = var74_107 % 128;
                    var74_107 % 2;
                    var76_108 = new JSONObject(this.\u02bc);
                    var76_108.accumulate("screen", (Object)this.\u02bd);
                    var76_108.accumulate("view", (Object)this.\u141d);
                    var76_108.accumulate("visible", (Object)this.\u02cf);
                    var76_108.accumulate("maybe", (Object)this.\u02cf);
                    var76_108.accumulate("visiblePercent", (Object)this.\u02ca.\u02cb);
                    if (var70_102 != null) {
                        var82_109 = true;
                        var83_110 = true;
                    } else {
                        var82_109 = true;
                        var83_110 = false;
                    }
                    if (var83_110 != var82_109) ** GOTO lbl302
                    var84_111 = var70_102 == null ? 66 : 88;
                    if (var84_111 == 88) break block52;
                    var96_112 = 95 + y.\u02cf\u0971;
                    y.\u02ca\u0971 = var96_112 % 128;
                    var96_112 % 2;
                    var85_113 = null;
                    break block62;
                }
                var85_113 = new HashMap();
                var85_113.put((Object)"latitude", (Object)Double.toString((double)var70_102.getLatitude()));
                var85_113.put((Object)"longitude", (Object)Double.toString((double)var70_102.getLongitude()));
                var85_113.put((Object)"timestamp", (Object)Long.toString((long)var70_102.getTime()));
                var85_113.put((Object)"horizontalAccuracy", (Object)Float.toString((float)var70_102.getAccuracy()));
            }
            if (var85_113 == null) {
                var90_114 = 1;
                var91_115 = false;
            } else {
                var90_114 = 1;
                var91_115 = true;
            }
            if (var91_115 == var90_114) break block63;
            var94_116 = var90_114 + y.\u02ca\u0971;
            y.\u02cf\u0971 = var94_116 % 128;
            var94_116 % 2;
            var92_117 = null;
            ** GOTO lbl301
        }
        var92_117 = new JSONObject((Map)var85_113);
lbl301: // 2 sources:
        var76_108.accumulate("location", (Object)var92_117);
lbl302: // 2 sources:
        var4_4 = var76_108.toString();
        try {
            this.\u02ce = var4_4;
            return;
        }
        catch (Exception var8_119) {
            var9_75 = var4_4;
        }
        o.\u0971((Exception)var8_120);
        this.\u02ce = var9_75;
    }

    static final class a {
        Rect \u02ca = new Rect(0, 0, 0, 0);
        double \u02cb = 0.0;
        double \u02ce = 0.0;

        a() {
        }
    }

    static final class b {
        final View \u02ca;
        final boolean \u02cb;
        final int \u0971;

        b(View view, int n2, boolean bl2) {
            this.\u02ca = view;
            this.\u0971 = n2;
            this.\u02cb = bl2;
        }
    }

}

