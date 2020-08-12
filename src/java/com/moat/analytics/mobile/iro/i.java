/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.c.c.b
 *  com.moat.analytics.mobile.iro.j
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.iro;

import android.os.Build;
import com.c.c.b;
import com.moat.analytics.mobile.iro.MoatAnalytics;
import com.moat.analytics.mobile.iro.j;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.p;
import com.moat.analytics.mobile.iro.t;
import org.json.JSONArray;
import org.json.JSONObject;

final class i {
    private static char[] \u02bb = new char[]{'s', 'a', '2', 'b', 'c', '3', '4', '1', '8', '9', 'f', '0', '6', 'd', 'e', '5', 'o', 'n', 'i', 'p', 'l', 't', 'u', 'v', 'w'};
    private static char \u02bd = '\u0005';
    private static int \u02ca\u0971;
    private static int \u141d;
    private boolean \u02ca = false;
    private int \u02cb = 10;
    private int \u02ce = 200;
    private boolean \u02cf = false;
    private boolean \u0971 = false;

    static {
        \u141d = 0;
        \u02ca\u0971 = 1;
    }

    i(String string2) {
        this.\u02ca(string2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void \u02ca(String var1_1) {
        block10 : {
            block9 : {
                if (var1_1 == null) {
                    return;
                }
                try {
                    var2_2 = new JSONObject(var1_1);
                    var4_3 = var2_2.getString(i.\u02ce(2, "\u0001\u0002", (byte)59).intern());
                    var5_4 = 66;
                    var6_5 = var4_3.equals((Object)i.\u02ce(40, "\u0003\u0004\u0000\t\u0007\b\r\b\u0005\u0006\u000b\f\f\u0011\u0007\r\u000e\u0000\b\u0012\t\f\u0004\r\u0004\u0000\u0001\u000e\u0007\u000b\u0005\u0007\n\u0011\b\t\u0007\f\u0004\u0003", (byte)var5_4).intern());
                    var7_6 = var4_3.equals((Object)i.\u02ce(40, "\u0005\r\b\f\r\u0006\u0002\u0003\u000e\r\u0007\u0005\u0011\f\u0005\b\u0000\u0010\r\u0004\u0004\u000b\u0005\r\n\u0010\u0006\u000e\u000f\u0014\b\u0006\f\u0004\u0011\f\u0005\u0007\t\u0005", (byte)43).intern());
                    var8_7 = var4_3.equals((Object)i.\u02ce(2, "\u0011\u0012", (byte)121).intern());
                    var9_8 = var8_7 != false;
                    if (var9_8) break block9;
                }
                catch (Exception var3_29) {
                    this.\u02ca = false;
                    this.\u02cf = false;
                    this.\u02ce = 200;
                    o.\u0971(var3_29);
                    return;
                }
                var10_9 = 91 + i.\u141d;
                i.\u02ca\u0971 = var10_9 % 128;
                var10_9 % 2;
                var12_10 = var6_5 == false;
                if (var12_10 && (var13_11 = var7_6 != false ? 34 : 20) == 20) ** GOTO lbl38
            }
            var29_12 = i.\u02ca(var2_2) == false;
            if (!var29_12 || (var30_13 = i.\u02cf(var2_2) == false ? 48 : 74) == 74) ** GOTO lbl38
            this.\u02ca = true;
            this.\u02cf = var6_5;
            this.\u0971 = var7_6;
            var31_14 = this.\u0971;
            var32_15 = var31_14 == false;
            if (var32_15) ** GOTO lbl38
            var33_16 = 51 + i.\u02ca\u0971;
            i.\u141d = var33_16 % 128;
            var33_16 % 2;
            this.\u02cf = true;
lbl38: // 4 sources:
            if (!(var14_17 = var2_2.has(i.\u02ce(2, "\u0013\u0012", (byte)25).intern()) != false)) ** GOTO lbl53
            var15_18 = var2_2.getInt(i.\u02ce(2, "\u0013\u0012", (byte)25).intern());
            if (var15_18 >= 100) {
                var5_4 = 56;
            }
            if (var5_4 != 56) ** GOTO lbl53
            var16_19 = 117 + i.\u141d;
            i.\u02ca\u0971 = var16_19 % 128;
            var16_19 % 2;
            var18_20 = var15_18 <= 1000 ? 75 : 52;
            if (var18_20 != 75) ** GOTO lbl53
            var19_21 = 59 + i.\u02ca\u0971;
            i.\u141d = var19_21 % 128;
            var19_21 % 2;
            this.\u02ce = var15_18;
lbl53: // 4 sources:
            if (var22_23 = (var21_22 = var2_2.has(i.\u02ce(2, "\n\u0004", (byte)24).intern())) == false) ** GOTO lbl59
            var27_24 = 55 + i.\u141d;
            i.\u02ca\u0971 = var27_24 % 128;
            var27_24 % 2;
            this.\u02cb = var2_2.getInt(i.\u02ce(2, "\n\u0004", (byte)24).intern());
lbl59: // 2 sources:
            if ((var23_25 = i.\u02ce(var2_2)) == false) return;
            var24_26 = 71;
            if (var24_26 == 71) break block10;
            return;
        }
        var25_27 = 69 + i.\u141d;
        i.\u02ca\u0971 = var25_27 % 128;
        var26_28 = var25_27 % 2 == 0;
        if (var26_28) ** GOTO lbl71
        ((j)MoatAnalytics.getInstance()).\u02cf = true;
        return;
lbl71: // 1 sources:
        ((j)MoatAnalytics.getInstance()).\u02cf = true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static boolean \u02ca(JSONObject var0) {
        block4 : {
            try {
                var1_1 = Build.VERSION.SDK_INT;
                var2_2 = 16 > var1_1;
                if (!var2_2) break block4;
            }
            catch (Exception v0) {
                return true;
            }
            var11_3 = 69 + i.\u141d;
            i.\u02ca\u0971 = var11_3 % 128;
            var12_4 = var11_3 % 2 == 0 ? 63 : 39;
            if (var12_4 == 63) return true;
            return true;
        }
        var3_5 = var0.has(i.\u02ce(2, "\u0012\u0001", (byte)62).intern()) != false ? 77 : 86;
        if (var3_5 == 86) return false;
        var4_6 = var0.getJSONArray(i.\u02ce(2, "\u0012\u0001", (byte)62).intern());
        var5_7 = var4_6.length();
        var6_8 = 0;
        ** GOTO lbl24
lbl-1000: // 1 sources:
        {
            var8_10 = var4_6.getInt(var6_8);
            var10_12 = var8_10 == (var9_11 = Build.VERSION.SDK_INT) ? 14 : 26;
            if (var10_12 == 14) return true;
            ++var6_8;
lbl24: // 2 sources:
            if (var6_8 >= var5_7) return false;
            var7_9 = 60;
            ** while (var7_9 == 60)
        }
lbl27: // 1 sources:
        return false;
    }

    private static String \u02ce(int n2, String string2, byte by) {
        boolean bl2;
        int n3 = n2;
        char[] arrc = string2.toCharArray();
        char[] arrc2 = \u02bb;
        char c2 = \u02bd;
        char[] arrc3 = new char[n3];
        boolean bl3 = n3 % 2 == 0;
        if (!bl3) {
            int n4 = 99 + \u02ca\u0971;
            \u141d = n4 % 128;
            n4 % 2;
            arrc3[--n3] = (char)(arrc[n3] - by);
        }
        if (!(bl2 = n3 <= 1)) {
            int n5;
            int n6 = 125 + \u02ca\u0971;
            \u141d = n6 % 128;
            if (n6 % 2 != 0) {
                // empty if block
            }
            int n7 = 0;
            while ((n5 = n7 < n3 ? 99 : 85) != 85) {
                char c3 = arrc[n7];
                int n8 = n7 + 1;
                char c4 = arrc[n8];
                int n9 = c3 == c4 ? 24 : 35;
                if (n9 != 35) {
                    arrc3[n7] = (char)(c3 - by);
                    arrc3[n8] = (char)(c4 - by);
                } else {
                    int n10 = b.\u02cb((int)c3, (int)c2);
                    int n11 = b.\u02ce((int)c3, (int)c2);
                    int n12 = b.\u02cb((int)c4, (int)c2);
                    int n13 = b.\u02ce((int)c4, (int)c2);
                    boolean bl4 = n11 != n13;
                    if (!bl4) {
                        int n14 = b.\u02ca((int)n10, (int)c2);
                        int n15 = b.\u02ca((int)n12, (int)c2);
                        int n16 = b.\u0971((int)n14, (int)n11, (int)c2);
                        int n17 = b.\u0971((int)n15, (int)n13, (int)c2);
                        arrc3[n7] = arrc2[n16];
                        arrc3[n8] = arrc2[n17];
                    } else {
                        int n18 = n10 == n12 ? 46 : 49;
                        if (n18 != 49) {
                            int n19 = b.\u02ca((int)n11, (int)c2);
                            int n20 = b.\u02ca((int)n13, (int)c2);
                            int n21 = b.\u0971((int)n10, (int)n19, (int)c2);
                            int n22 = b.\u0971((int)n12, (int)n20, (int)c2);
                            arrc3[n7] = arrc2[n21];
                            arrc3[n8] = arrc2[n22];
                        } else {
                            int n23 = b.\u0971((int)n10, (int)n13, (int)c2);
                            int n24 = b.\u0971((int)n12, (int)n11, (int)c2);
                            arrc3[n7] = arrc2[n23];
                            arrc3[n8] = arrc2[n24];
                        }
                    }
                }
                n7 += 2;
            }
        }
        return new String(arrc3);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static boolean \u02ce(JSONObject var0) {
        block5 : {
            var2_1 = var0.has(i.\u02ce(2, "\u0000\u0015", (byte)3).intern());
            if (var2_1 == false) return false;
            var3_2 = 23;
            if (var3_2 == 23) break block5;
            return false;
        }
        var4_3 = 73 + i.\u141d;
        i.\u02ca\u0971 = var4_3 % 128;
        var4_3 % 2;
        try {
            var6_4 = p.\u02ce().\u02cb();
            var7_5 = var0.getJSONArray(i.\u02ce(2, "\u0000\u0015", (byte)3).intern());
            var8_6 = var7_5.length();
            var9_7 = 0;
            ** GOTO lbl25
        }
        catch (Exception var1_11) {
            o.\u0971(var1_11);
        }
        return false;
lbl-1000: // 2 sources:
        {
            if (var10_8 == true) return false;
            var11_9 = var7_5.getString(var9_7).contentEquals((CharSequence)var6_4);
            var12_10 = var11_9 != false;
            if (var12_10 == true) return true;
            ++var9_7;
lbl25: // 2 sources:
            if (var9_7 < var8_6) {
                var10_8 = false;
                continue;
            }
            var10_8 = true;
            ** while (true)
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean \u02cf(JSONObject jSONObject) {
        int n2;
        int n3;
        JSONArray jSONArray;
        String string2;
        if (!jSONObject.has(i.\u02ce(2, "\u0004\u0010", (byte)47).intern())) return false;
        boolean bl2 = true;
        if (!bl2) return false;
        try {
            string2 = p.\u02ce().\u02cb();
            jSONArray = jSONObject.getJSONArray(i.\u02ce(2, "\u0004\u0010", (byte)47).intern());
            n3 = jSONArray.length();
            n2 = 0;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return false;
        }
        while (n2 < n3) {
            block6 : {
                int n4 = 34;
                if (n4 != 34) {
                    return false;
                }
                int n5 = 115 + \u02ca\u0971;
                \u141d = n5 % 128;
                n5 % 2;
                boolean bl3 = jSONArray.getString(n2).contentEquals((CharSequence)string2);
                boolean bl4 = bl3;
                if (!bl4) break block6;
                int n6 = 47 + \u02ca\u0971;
                \u141d = n6 % 128;
                n6 % 2;
                return true;
            }
            ++n2;
        }
        return false;
    }

    final boolean \u02ca() {
        return this.\u02cf;
    }

    final int \u02cb() {
        return this.\u02ce;
    }

    final boolean \u02ce() {
        return this.\u0971;
    }

    final int \u02cf() {
        if (this.\u02ca) {
            return t.c.\u0971;
        }
        return t.c.\u02ca;
    }

    final int \u0971() {
        return this.\u02cb;
    }
}

