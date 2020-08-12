/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.moat.analytics.mobile.cha.f
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.cha;

import android.os.Build;
import com.moat.analytics.mobile.cha.MoatAnalytics;
import com.moat.analytics.mobile.cha.f;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.r;
import com.moat.analytics.mobile.cha.t;
import org.json.JSONArray;
import org.json.JSONObject;

final class g {
    private static int \u02bb = 0;
    private static int \u02bc = 565428102;
    private static int \u02bd = -1138247343;
    private static int \u02ca\u0971 = 117;
    private static int \u0971\u02cb;
    private static byte[] \u141d;
    private boolean \u02ca = false;
    private int \u02cb = 10;
    private boolean \u02ce = false;
    private boolean \u02cf = false;
    private int \u0971 = 200;

    static {
        \u141d = new byte[]{-73, 79, -77, 127, -123, -125, -126, 73, 125, -81, 81, -77, 81, 127, -83, -121, 73, -78, 127, 85, -82, -128, 77, -79, 77, -80, -126, 123, -124, 77, -125, -87, -123, 117, -123, 120, -122, 82, -83, -128, -69, -66, 65, -78, 65, -66, 119, -120, -72, 70, 117, -116, 77, -66, -65, 112, -108, 105, -66, 69, 71, -118, 110, -118, 66, -78, 65, 71, -65, 68, 104, -120, 107, -109, -78, 118, -119, 113, -108, -91, -81, -5, 80, -25, 10, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        \u02bb = 0;
        \u0971\u02cb = 1;
    }

    g(String string) {
        this.\u0971(string);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String \u02cb(int n2, int n3, byte by, int n4) {
        int n5;
        StringBuilder stringBuilder = new StringBuilder();
        int n6 = n2 + \u02ca\u0971;
        boolean bl2 = n6 != -1;
        boolean bl3 = !bl2;
        boolean bl4 = bl3;
        if (bl4) {
            boolean bl5 = \u141d == null;
            if (bl5) {
                n4 + \u02bc;
                throw new NullPointerException();
            }
            int n7 = 87 + \u0971\u02cb;
            \u02bb = n7 % 128;
            boolean bl6 = n7 % 2 == 0;
            byte by2 = !bl6 ? \u141d[n4 + \u02bc] : \u141d[n4 + \u02bc];
            n6 = (byte)(by2 + \u02ca\u0971);
        }
        if ((n5 = n6 > 0 ? 61 : 24) != 24) {
            int n8;
            int n9 = -2 + (n4 + n6) + \u02bc;
            int n10 = bl3 ? 81 : 86;
            int n11 = n10 != 81 ? 0 : 1;
            int n12 = n9 + n11;
            char c2 = (char)(n3 + \u02bd);
            stringBuilder.append(c2);
            char c3 = c2;
            int n13 = 1;
            while ((n8 = n13 < n6 ? 85 : 44) != 44) {
                int n14 = 1 + \u02bb;
                \u0971\u02cb = n14 % 128;
                n14 % 2;
                int n15 = \u141d != null ? 66 : 69;
                if (n15 != 66) {
                    n12 - 1;
                    throw new NullPointerException();
                }
                byte[] arrby = \u141d;
                int n16 = n12 - 1;
                c3 = (char)(c3 + (by ^ arrby[n12]));
                n12 = n16;
                stringBuilder.append(c3);
                ++n13;
            }
        }
        return stringBuilder.toString();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static boolean \u02cb(JSONObject var0) {
        var2_1 = var0.has(g.\u02cb(-115, 1138247440, (byte)-24, -565428019).intern());
        var3_2 = var2_1 != false ? 14 : 18;
        if (var3_2 == 18) return false;
        var4_3 = 113 + g.\u02bb;
        g.\u0971\u02cb = var4_3 % 128;
        var5_4 = var4_3 % 2 == 0;
        if (!var5_4) ** GOTO lbl13
        try {
            block7 : {
                var6_5 = r.\u02ca().\u02cb();
                var7_6 = var0.getJSONArray(g.\u02cb(-115, 1138247440, (byte)-24, -565428019).intern());
                break block7;
lbl13: // 1 sources:
                var6_5 = r.\u02ca().\u02cb();
                var7_6 = var0.getJSONArray(g.\u02cb(-115, 1138247440, (byte)-24, -565428019).intern());
            }
            var8_7 = var7_6.length();
            var9_8 = var7_6;
            var10_9 = 0;
            ** GOTO lbl34
        }
        catch (Exception var1_15) {
            o.\u02ce(var1_15);
        }
        return false;
lbl-1000: // 2 sources:
        {
            if (var11_10 == true) return false;
            var12_11 = var9_8.getString(var10_9).contentEquals((CharSequence)var6_5);
            var13_12 = var12_11 != false ? 23 : 88;
            if (var13_12 != 23) {
                ++var10_9;
            } else {
                var14_13 = 71 + g.\u0971\u02cb;
                g.\u02bb = var14_13 % 128;
                var15_14 = var14_13 % 2 != 0 ? 4 : 79;
                if (var15_14 == 79) return true;
                return true;
            }
lbl34: // 2 sources:
            if (var10_9 < var8_7) {
                var11_10 = false;
                continue;
            }
            var11_10 = true;
            ** while (true)
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static boolean \u02ce(JSONObject var0) {
        block8 : {
            block7 : {
                try {
                    var1_1 = Build.VERSION.SDK_INT;
                    var2_2 = 16 > var1_1 ? 58 : 36;
                    if (var2_2 == 36) break block7;
                }
                catch (Exception v0) {
                    return true;
                }
                var17_3 = 43 + g.\u0971\u02cb;
                g.\u02bb = var17_3 % 128;
                var17_3 % 2;
                return true;
            }
            var3_4 = var0.has(g.\u02cb(-115, 1138247454, (byte)-93, -565428020).intern());
            var4_5 = var3_4 == false;
            if (var4_5 == true) return false;
            var5_6 = 71 + g.\u02bb;
            g.\u0971\u02cb = var5_6 % 128;
            var6_7 = var5_6 % 2 == 0 ? 96 : 56;
            if (var6_7 == 96) ** GOTO lbl23
            var7_8 = var0.getJSONArray(g.\u02cb(-115, 1138247454, (byte)-93, -565428020).intern());
            break block8;
lbl23: // 1 sources:
            var7_8 = var0.getJSONArray(g.\u02cb(-115, 1138247454, (byte)-93, -565428020).intern());
        }
        var8_9 = var7_8.length();
        var9_10 = var7_8;
        var10_11 = 0;
        ** GOTO lbl38
lbl-1000: // 2 sources:
        {
            if (var11_12 == 24) return false;
            var12_13 = var9_10.getInt(var10_11);
            var14_15 = var12_13 != (var13_14 = Build.VERSION.SDK_INT);
            if (!var14_15) {
                var15_16 = 65 + g.\u02bb;
                g.\u0971\u02cb = var15_16 % 128;
                var15_16 % 2;
                return true;
            }
            ++var10_11;
lbl38: // 2 sources:
            if (var10_11 < var8_9) {
                var11_12 = 41;
                continue;
            }
            var11_12 = 24;
            ** while (true)
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void \u0971(String var1_1) {
        block15 : {
            block19 : {
                block17 : {
                    block18 : {
                        block16 : {
                            block14 : {
                                if (var1_1 == null) {
                                    return;
                                }
                                try {
                                    var2_2 = new JSONObject(var1_1);
                                    var4_3 = var2_2.getString(g.\u02cb(-115, 1138247458, (byte)89, -565428102).intern());
                                    var5_4 = var4_3.equals((Object)g.\u02cb(-77, 1138247394, (byte)-126, -565428101).intern());
                                    var6_5 = var4_3.equals((Object)g.\u02cb(-77, 1138247399, (byte)-70, -565428062).intern());
                                    var7_6 = var4_3.equals((Object)g.\u02cb(-115, 1138247454, (byte)90, -565428023).intern());
                                    var8_7 = var7_6 == false ? 66 : 2;
                                    if (var8_7 != 66 || (var9_8 = var5_4 != false)) break block14;
                                }
                                catch (Exception var3_36) {
                                    this.\u02cf = false;
                                    this.\u02ce = false;
                                    this.\u0971 = 200;
                                    o.\u02ce(var3_36);
                                    return;
                                }
                                var10_9 = 57 + g.\u0971\u02cb;
                                g.\u02bb = var10_9 % 128;
                                var10_9 % 2;
                                var12_10 = var6_5 == false;
                                if (var12_10) ** GOTO lbl50
                            }
                            var30_11 = g.\u02ce(var2_2);
                            var31_12 = var30_11 == false ? 43 : 56;
                            if (var31_12 != 43) ** GOTO lbl50
                            var32_13 = 95 + g.\u02bb;
                            g.\u0971\u02cb = var32_13 % 128;
                            var33_14 = var32_13 % 2 == 0 ? 80 : 6;
                            if (var33_14 == 6) ** GOTO lbl35
                            var38_15 = g.\u02cb(var2_2) == false ? 60 : 69;
                            if (var38_15 == 69) ** GOTO lbl50
                            break block16;
lbl35: // 1 sources:
                            var34_16 = g.\u02cb(var2_2) != false;
                            if (var34_16) ** GOTO lbl50
                        }
                        this.\u02cf = true;
                        this.\u02ce = var5_4;
                        this.\u02ca = var6_5;
                        var35_17 = this.\u02ca;
                        var36_18 = var35_17 != false;
                        if (!var36_18) ** GOTO lbl50
                        var37_19 = 81 + g.\u0971\u02cb;
                        g.\u02bb = var37_19 % 128;
                        if (var37_19 % 2 != 0) {
                            // empty if block
                        }
                        this.\u02ce = true;
lbl50: // 6 sources:
                        if ((var14_21 = (var13_20 = var2_2.has(g.\u02cb(-115, 1138247448, (byte)-86, -565428022).intern())) != false ? 27 : 75) == 75) ** GOTO lbl67
                        var24_22 = 77 + g.\u02bb;
                        g.\u0971\u02cb = var24_22 % 128;
                        var25_23 = var24_22 % 2 == 0;
                        if (var25_23) ** GOTO lbl60
                        var26_24 = var2_2.getInt(g.\u02cb(-115, 1138247448, (byte)-86, -565428022).intern());
                        var29_25 = var26_24 >= 100;
                        if (!var29_25) break block17;
                        break block18;
lbl60: // 1 sources:
                        var26_24 = var2_2.getInt(g.\u02cb(-115, 1138247448, (byte)-86, -565428022).intern());
                        var27_26 = var26_24 >= 100 ? 77 : 19;
                        if (var27_26 == 19) break block17;
                    }
                    var28_27 = var26_24 <= 1000;
                    if (var28_27) {
                        this.\u0971 = var26_24;
                    }
                }
                if (var16_29 = (var15_28 = var2_2.has(g.\u02cb(-115, 1138247444, (byte)-11, -565428021).intern())) == false) ** GOTO lbl79
                var21_30 = 53 + g.\u02bb;
                g.\u0971\u02cb = var21_30 % 128;
                var22_31 = var21_30 % 2 != 0;
                if (!var22_31) ** GOTO lbl76
                var23_32 = var2_2.getInt(g.\u02cb(-115, 1138247444, (byte)-11, -565428021).intern());
                break block19;
lbl76: // 1 sources:
                var23_32 = var2_2.getInt(g.\u02cb(-115, 1138247444, (byte)-11, -565428021).intern());
            }
            this.\u02cb = var23_32;
lbl79: // 2 sources:
            if ((var17_33 = g.\u0971(var2_2)) == false) return;
            var18_34 = 28;
            if (var18_34 == 28) break block15;
            return;
        }
        var19_35 = 23 + g.\u02bb;
        g.\u0971\u02cb = var19_35 % 128;
        var19_35 % 2;
        ((f)MoatAnalytics.getInstance()).\u02cb = true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static boolean \u0971(JSONObject var0) {
        block8 : {
            var2_1 = var0.has(g.\u02cb(-115, 1138247440, (byte)1, -565428018).intern());
            if (var2_1 == false) return false;
            var3_2 = 56;
            if (var3_2 == 56) break block8;
            return false;
        }
        var4_3 = 99 + g.\u02bb;
        g.\u0971\u02cb = var4_3 % 128;
        var4_3 % 2;
        var6_4 = r.\u02ca().\u02cb();
        var7_5 = var0.getJSONArray(g.\u02cb(-115, 1138247440, (byte)1, -565428018).intern());
        var8_6 = var7_5.length();
        var9_7 = 0;
        while (var9_7 < var8_6) {
            block10 : {
                block9 : {
                    var10_8 = false;
                    if (var10_8) {
                        return false;
                    }
                    var11_9 = 49 + g.\u02bb;
                    g.\u0971\u02cb = var11_9 % 128;
                    var12_10 = var11_9 % 2 == 0 ? 0 : 88;
                    if (var12_10 == 0) ** GOTO lbl28
                    try {
                        if (var7_5.getString(var9_7).contentEquals((CharSequence)var6_4)) {
                            return true;
                        }
                        break block9;
lbl28: // 1 sources:
                        var13_11 = var7_5.getString(var9_7).contentEquals((CharSequence)var6_4);
                        var14_12 = var13_11 != false ? 62 : 73;
                        if (var14_12 == 62) return true;
                        break block10;
                    }
                    catch (Exception var1_14) {
                        o.\u02ce(var1_14);
                        return false;
                    }
                }
                var15_13 = 75;
                if (var15_13 != 75) {
                    return true;
                }
            }
            ++var9_7;
        }
        return false;
    }

    final boolean \u02ca() {
        return this.\u02ce;
    }

    final int \u02cb() {
        if (this.\u02cf) {
            return t.a.\u02ce;
        }
        return t.a.\u0971;
    }

    final int \u02ce() {
        return this.\u02cb;
    }

    final int \u02cf() {
        return this.\u0971;
    }

    final boolean \u0971() {
        return this.\u02ca;
    }
}

