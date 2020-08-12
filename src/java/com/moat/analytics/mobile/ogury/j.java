/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  com.moat.analytics.mobile.ogury.i
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.NullPointerException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.ogury;

import android.os.Build;
import com.moat.analytics.mobile.ogury.MoatAnalytics;
import com.moat.analytics.mobile.ogury.i;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.q;
import com.moat.analytics.mobile.ogury.s;
import org.json.JSONArray;
import org.json.JSONObject;

final class j {
    private static int \u02bb = 0;
    private static byte[] \u02bc = new byte[]{-37, -77, 1, 1, 105, 52, 49, 56, 48, 58, 48, 60, 53, 2, 55, 103, 53, 46, 60, 45, 54, 60, 48, 50, 55, 52, 53, 58, 55, 4, 97, 4, 104, 5, 55, 95, 10, 49, 98, 60, 2, 101, 1, 119, 122, 113, 126, 113, 122, 67, -88, 120, 114, 69, -84, 109, 122, 123, 64, -92, 73, 122, 117, 115, -90, 74, -90, 110, 126, 113, 115, 123, 116, 72, -88, 71, -97, 126, 66, -87, 65, -92, -37, 54, -37, -115, -37, 93, -37, -105, -37, 44, -37, -26};
    private static int \u02bd = 0;
    private static int \u02ca\u0971 = 1;
    private static int \u0971\u0971 = -1675497915;
    private static int \u141d = 814200731;
    private boolean \u02ca = false;
    private boolean \u02cb = false;
    private int \u02ce = 10;
    private boolean \u02cf = false;
    private int \u0971 = 200;

    static {
        \u02bd = 39;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    j(String string2) {
        if (string2 != null) {
            try {
                int n2;
                JSONObject jSONObject = new JSONObject(string2);
                String string3 = jSONObject.getString(j.\u02ce(-40, (byte)0, -814200731, 1675498030, (short)59).intern());
                boolean bl2 = string3.equals((Object)j.\u02ce(-40, (byte)0, -814200729, 1675497968, (short)-53).intern());
                boolean bl3 = string3.equals((Object)j.\u02ce(-40, (byte)0, -814200689, 1675497971, (short)-118).intern());
                if ((string3.equals((Object)j.\u02ce(-40, (byte)0, -814200649, 1675498026, (short)-55).intern()) || bl2 || bl3) && !j.\u02ca(jSONObject) && !j.\u02cf(jSONObject)) {
                    this.\u02cf = true;
                    this.\u02cb = bl2;
                    this.\u02ca = bl3;
                    if (this.\u02ca) {
                        this.\u02cb = true;
                    }
                }
                if (jSONObject.has(j.\u02ce(-40, (byte)0, -814200647, 1675498020, (short)120).intern()) && (n2 = jSONObject.getInt(j.\u02ce(-40, (byte)0, -814200647, 1675498020, (short)120).intern())) >= 100 && n2 <= 1000) {
                    this.\u0971 = n2;
                }
                if (jSONObject.has(j.\u02ce(-40, (byte)0, -814200645, 1675498016, (short)-79).intern())) {
                    this.\u02ce = jSONObject.getInt(j.\u02ce(-40, (byte)0, -814200645, 1675498016, (short)-79).intern());
                }
                if (j.\u02cb(jSONObject)) {
                    ((i)MoatAnalytics.getInstance()).\u02cb = true;
                }
                return;
            }
            catch (Exception exception) {
                this.\u02cf = false;
                this.\u02cb = false;
                this.\u0971 = 200;
                l.\u0971(exception);
            }
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static boolean \u02ca(JSONObject var0) {
        block8 : {
            var1_1 = Build.VERSION.SDK_INT;
            if (16 <= var1_1) break block8;
            var13_2 = 111 + j.\u02bb;
            j.\u02ca\u0971 = var13_2 % 128;
            var13_2 % 2;
            var15_3 = 13 + j.\u02ca\u0971;
            j.\u02bb = var15_3 % 128;
            if (var15_3 % 2 == 0) return true;
            var16_4 = 19;
            if (var16_4 != 19) {
                return true;
            }
            super.hashCode();
            return true;
        }
        var2_5 = var0.has(j.\u02ce(-40, (byte)0, -814200643, 1675498026, (short)92).intern());
        if (var2_5 == false) return false;
        var3_6 = 109 + j.\u02bb;
        j.\u02ca\u0971 = var3_6 % 128;
        var3_6 % 2;
        var5_7 = var0.getJSONArray(j.\u02ce(-40, (byte)0, -814200643, 1675498026, (short)92).intern());
        var6_8 = var5_7.length();
        var7_9 = 0;
        while (var7_9 < var6_8) {
            block9 : {
                var8_10 = 55 + j.\u02bb;
                j.\u02ca\u0971 = var8_10 % 128;
                var9_11 = var8_10 % 2 == 0 ? 83 : 42;
                if (var9_11 == 83) ** GOTO lbl33
                try {
                    var12_14 = var5_7.getInt(var7_9) == Build.VERSION.SDK_INT ? 83 : 84;
lbl33: // 1 sources:
                    var10_12 = var5_7.getInt(var7_9);
                    if (var10_12 == (var11_13 = Build.VERSION.SDK_INT)) {
                        return true;
                    }
                    break block9;
                }
                catch (Exception v0) {
                    return true;
                }
                if (var12_14 == 83) return true;
            }
            ++var7_9;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static boolean \u02cb(JSONObject var0) {
        block6 : {
            var2_1 = var0.has(j.\u02ce(-40, (byte)0, -814200639, 1675498012, (short)37).intern());
            if (var2_1 == false) return false;
            var3_2 = 77 + j.\u02ca\u0971;
            j.\u02bb = var3_2 % 128;
            if (var3_2 % 2 == 0) ** GOTO lbl13
            var15_3 = s.\u02ce().\u02cf();
            var5_4 = var0.getJSONArray(j.\u02ce(-40, (byte)0, -814200639, 1675498012, (short)116).intern());
            var6_5 = var5_4.length();
            var4_6 = var15_3;
            break block6;
lbl13: // 1 sources:
            var4_6 = s.\u02ce().\u02cf();
            var5_4 = var0.getJSONArray(j.\u02ce(-40, (byte)0, -814200639, 1675498012, (short)37).intern());
            var6_5 = var5_4.length();
        }
        var7_7 = var5_4;
        var8_8 = 0;
        while (var8_8 < var6_5) {
            block5 : {
                var9_9 = 115 + j.\u02ca\u0971;
                j.\u02bb = var9_9 % 128;
                var10_10 = var9_9 % 2 != 0 ? 82 : 80;
                if (var10_10 == 82) ** GOTO lbl26
                try {
                    var14_13 = var7_7.getString(var8_8).contentEquals((CharSequence)var4_6) == false;
lbl26: // 1 sources:
                    var11_11 = var7_7.getString(var8_8).contentEquals((CharSequence)var4_6);
                    super.hashCode();
                    var13_12 = var11_11 == false;
                    if (var13_12 == false) return true;
                    break block5;
                }
                catch (Exception var1_14) {
                    l.\u0971(var1_14);
                }
                return false;
                if (var14_13 == false) return true;
            }
            ++var8_8;
        }
        return false;
    }

    private static String \u02ce(int n2, byte by, int n3, int n4, short s2) {
        int n5;
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        int n6 = n2 + \u02bd;
        int n7 = 1;
        if (n6 == -1) {
            int n8 = 99 + \u02ca\u0971;
            \u02bb = n8 % 128;
            n8 % 2;
            bl2 = true;
        } else {
            bl2 = false;
        }
        if (bl2) {
            byte[] arrby = \u02bc;
            if (arrby != null) {
                n6 = (byte)(arrby[n3 + \u141d] + \u02bd);
            } else {
                n3 + \u141d;
                throw new NullPointerException();
            }
        }
        if ((n5 = n6 <= 0) != n7) {
            int n9 = -2 + (n3 + n6) + \u141d;
            int n10 = 0;
            if (bl2) {
                int n11 = 113 + \u02bb;
                \u02ca\u0971 = n11 % 128;
                boolean bl3 = n11 % 2 == 0;
                n10 = bl3 ? 0 : 1;
            }
            int n12 = n9 + n10;
            char c2 = (char)(n4 + \u0971\u0971);
            stringBuilder.append(c2);
            while (n7 < n6) {
                int n13 = \u02bc != null ? 83 : 17;
                if (n13 == 17) {
                    n12 - 1;
                    throw new NullPointerException();
                }
                byte[] arrby = \u02bc;
                int n14 = n12 - 1;
                c2 = (char)(c2 + (by ^ (byte)(s2 + arrby[n12])));
                n12 = n14;
                stringBuilder.append(c2);
                ++n7;
            }
        }
        return stringBuilder.toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static boolean \u02cf(JSONObject jSONObject) {
        block4 : {
            int n2;
            String string2;
            JSONArray jSONArray;
            block5 : {
                boolean bl2 = jSONObject.has(j.\u02ce(-40, (byte)0, -814200641, 1675498012, (short)-29).intern());
                int n3 = bl2 ? 91 : 53;
                if (n3 != 91) break block4;
                int n4 = 63 + \u02bb;
                \u02ca\u0971 = n4 % 128;
                n4 % 2;
                try {
                    string2 = s.\u02ce().\u02cf();
                    jSONArray = jSONObject.getJSONArray(j.\u02ce(-40, (byte)0, -814200641, 1675498012, (short)-29).intern());
                    n2 = jSONArray.length();
                    break block5;
                }
                catch (Exception exception) {
                    l.\u0971(exception);
                }
                break block4;
            }
            for (int i2 = 0; i2 < n2; ++i2) {
                boolean bl3 = jSONArray.getString(i2).contentEquals((CharSequence)string2);
                if (!bl3) continue;
                int n5 = 97 + \u02ca\u0971;
                \u02bb = n5 % 128;
                if (n5 % 2 == 0) return true;
                return true;
            }
        }
        int n6 = 97 + \u02bb;
        \u02ca\u0971 = n6 % 128;
        if (n6 % 2 != 0) return false;
        boolean bl4 = false;
        if (bl4) return false;
        super.hashCode();
        return false;
    }

    final int \u02ca() {
        int n2 = 25 + \u02ca\u0971;
        \u02bb = n2 % 128;
        if (n2 % 2 != 0) {
            // empty if block
        }
        int n3 = this.\u0971;
        int n4 = 91 + \u02bb;
        \u02ca\u0971 = n4 % 128;
        int n5 = n4 % 2 == 0 ? 80 : 5;
        if (n5 != 5) {
            // empty if block
        }
        return n3;
    }

    final boolean \u02cb() {
        int n2 = 3 + \u02bb;
        \u02ca\u0971 = n2 % 128;
        n2 % 2;
        boolean bl2 = this.\u02cb;
        int n3 = 47 + \u02ca\u0971;
        \u02bb = n3 % 128;
        if (n3 % 2 != 0) {
            // empty if block
        }
        return bl2;
    }

    final int \u02ce() {
        int n2 = \u02ca\u0971;
        int n3 = 1;
        int n4 = n2 + n3;
        \u02bb = n4 % 128;
        n4 % 2;
        int n5 = this.\u02ce;
        int n6 = 89 + \u02ca\u0971;
        \u02bb = n6 % 128;
        if (n6 % 2 == 0) {
            n3 = 0;
        }
        if (n3 != 0) {
            // empty if block
        }
        return n5;
    }

    final boolean \u02cf() {
        int n2 = 65 + \u02bb;
        \u02ca\u0971 = n2 % 128;
        if (n2 % 2 == 0) {
            // empty if block
        }
        boolean bl2 = this.\u02ca;
        int n3 = 43 + \u02ca\u0971;
        \u02bb = n3 % 128;
        boolean bl3 = n3 % 2 == 0;
        if (bl3) {
            // empty if block
        }
        return bl2;
    }

    final int \u0971() {
        boolean bl2;
        int n2 = 51 + \u02bb;
        \u02ca\u0971 = n2 % 128;
        int n3 = n2 % 2 == 0 ? 24 : 37;
        if (n3 != 37 ? (bl2 = this.\u02cf) : this.\u02cf) {
            int n4 = q.e.\u02ce;
            int n5 = 83 + \u02bb;
            \u02ca\u0971 = n5 % 128;
            if (n5 % 2 == 0) {
                // empty if block
            }
            return n4;
        }
        return q.e.\u02ca;
    }
}

