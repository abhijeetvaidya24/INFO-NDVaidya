/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.ogury.consent.manager.partightenfactor0
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 *  org.json.JSONObject
 */
package com.ogury.consent.manager;

import com.ogury.consent.manager.ConsentManager;
import com.ogury.consent.manager.green255;
import com.ogury.consent.manager.margl1440;
import com.ogury.consent.manager.margr1440;
import com.ogury.consent.manager.partightenfactor0;
import com.ogury.consent.manager.rtf1;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.tx8640;
import com.ogury.consent.manager.util.consent.ansi;
import java.util.Date;
import org.json.JSONObject;

/*
 * Exception performing whole class analysis ignored.
 */
public final class fs24 {
    public fs24() {
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        tx6480.b((Object)charSequence, "$receiver");
        boolean bl3 = charSequence instanceof String;
        if (!bl3) {
            char[] arrc = new char[]{'.'};
            tx6480.b((Object)charSequence, "$receiver");
            tx6480.b(arrc, "chars");
            if (bl3) {
                tx6480.b(arrc, "$receiver");
                char c3 = arrc[0];
                return ((String)charSequence).indexOf((int)c3, n2);
            }
            if (n2 < 0) {
                n2 = 0;
            }
            tx6480.b((Object)charSequence, "$receiver");
            int n4 = charSequence.length() - 1;
            if (n2 <= n4) {
                do {
                    boolean bl4;
                    block8 : {
                        char c4 = charSequence.charAt(n2);
                        for (int i2 = 0; i2 <= 0; ++i2) {
                            if (!fs24.a(arrc[i2], c4, false)) continue;
                            bl4 = true;
                            break block8;
                        }
                        bl4 = false;
                    }
                    if (bl4) {
                        return n2;
                    }
                    if (n2 == n4) break;
                    ++n2;
                } while (true);
            }
            return -1;
        }
        return ((String)charSequence).indexOf(46, n2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private static /* synthetic */ int a(CharSequence var0, CharSequence var1_1, int var2_2, int var3_3, boolean var4_4, boolean var5_5, int var6_6, Object var7_7) {
        var8_8 = var0.length();
        if (var3_3 > var8_8) {
            var3_3 = var8_8;
        }
        var9_9 = (tx8640)new partightenfactor0(0, var3_3);
        if (!(var0 instanceof String) || !(var1_1 instanceof String)) {
            var10_16 = var9_9.a();
            var11_17 = var9_9.b();
            var12_18 = var9_9.c();
            if (var12_18 > 0) {
                if (var10_16 > var11_17) return -1;
            } else if (var10_16 < var11_17) return -1;
        } else {
            var16_10 = var9_9.a();
            var17_11 = var9_9.b();
            var18_12 = var9_9.c();
            if (var18_12 > 0) {
                if (var16_10 > var17_11) return -1;
            } else if (var16_10 < var17_11) return -1;
            do {
                var19_13 = (String)var1_1;
                var20_14 = (String)var0;
                var21_15 = var1_1.length();
                tx6480.b(var19_13, "$receiver");
                tx6480.b(var20_14, "other");
                if (var19_13.regionMatches(0, var20_14, var16_10, var21_15)) {
                    return var16_10;
                }
                if (var16_10 == var17_11) return -1;
                var16_10 += var18_12;
            } while (true);
        }
        do {
            var13_19 = var1_1.length();
            tx6480.b((Object)var1_1, "$receiver");
            tx6480.b((Object)var0, "other");
            if (var10_16 >= 0 && var1_1.length() - var13_19 >= 0 && var10_16 <= var0.length() - var13_19) {
                for (var15_21 = 0; var15_21 < var13_19; ++var15_21) {
                    if (fs24.a(var1_1.charAt(var15_21 + 0), var0.charAt(var10_16 + var15_21), false)) {
                        continue;
                    }
                    ** break block15
                }
                var14_20 = true;
            } else lbl-1000: // 2 sources:
            {
                
                var14_20 = false;
            }
            if (var14_20) {
                return var10_16;
            }
            if (var10_16 == var11_17) return -1;
            var10_16 += var12_18;
        } while (true);
    }

    private static int a(CharSequence charSequence, String string2, int n2, boolean bl2) {
        tx6480.b((Object)charSequence, "$receiver");
        tx6480.b(string2, "string");
        if (!(charSequence instanceof String)) {
            return fs24.a(charSequence, string2, 0, charSequence.length(), false, false, 16, null);
        }
        return ((String)charSequence).indexOf(string2, 0);
    }

    public static String a(String string2) {
        tx6480.b(string2, "response");
        JSONObject jSONObject = rtf1.rtf1.a(string2);
        if (jSONObject == null) {
            return "parsing-error";
        }
        boolean bl2 = ((CharSequence)fs24.a(jSONObject)).length() == 0;
        if (bl2) {
            JSONObject jSONObject2 = jSONObject.optJSONObject("response");
            if (jSONObject2 == null) {
                return "parsing-error";
            }
            margr1440 margr14402 = ansi.b();
            String string3 = jSONObject.toString();
            tx6480.a((Object)string3, "json.toString()");
            margr14402.a(string3);
            margr1440 margr14403 = ansi.b();
            String string4 = jSONObject2.toString();
            tx6480.a((Object)string4, "responseObject.toString()");
            margr14403.b(string4);
            JSONObject jSONObject3 = jSONObject.optJSONObject("form");
            if (jSONObject3 == null) {
                return "parsing-error";
            }
            margr1440 margr14404 = ansi.b();
            String string5 = jSONObject3.optString("secureToken");
            if (string5 == null) {
                return "parsing-error";
            }
            margr14404.e(string5);
            margr1440 margr14405 = ansi.b();
            String string6 = jSONObject3.toString();
            tx6480.a((Object)string6, "formObject.toString()");
            margr14405.d(string6);
            JSONObject jSONObject4 = jSONObject2.optJSONObject("response");
            if (jSONObject4 == null) {
                return "parsing-error";
            }
            green255 green2552 = ansi.a();
            String string7 = jSONObject2.optString("lastOpt");
            tx6480.a((Object)string7, "responseObject.optString(\"lastOpt\")");
            green2552.a(rtf1.rtf1.b(string7));
            green255 green2553 = ansi.a();
            String string8 = jSONObject4.optString("iabString");
            if (string8 == null) {
                string8 = "";
            }
            green2553.c(string8);
            green255 green2554 = ansi.a();
            String string9 = jSONObject4.optString("acceptedVendors");
            if (string9 == null) {
                string9 = "";
            }
            green2554.a(string9);
            green255 green2555 = ansi.a();
            String string10 = jSONObject4.optString("purposes");
            if (string10 == null) {
                string10 = "";
            }
            green2555.d(string10);
            green255 green2556 = ansi.a();
            String string11 = jSONObject4.optString("refusedVendors");
            if (string11 == null) {
                string11 = "";
            }
            green2556.b(string11);
            JSONObject jSONObject5 = jSONObject.optJSONObject("sdk");
            if (jSONObject5 == null) {
                return "parsing-error";
            }
            margl1440 margl14402 = ansi.c();
            String string12 = jSONObject5.optString("crashReportUrl");
            tx6480.a((Object)string12, "sdkObject.optString(\"crashReportUrl\")");
            margl14402.c(string12);
            JSONObject jSONObject6 = jSONObject.optJSONObject("form");
            String string13 = jSONObject6 != null ? jSONObject6.optString("showFormat") : null;
            if (string13 != null && true ^ tx6480.a((Object)string13, (Object)"null")) {
                ansi.b().c(string13);
            }
            ansi.a(new Date().getTime() + 1000L * jSONObject5.optLong("cacheFor"));
            return "";
        }
        return fs24.a(jSONObject);
    }

    public static /* synthetic */ String a(String string2, String string3, String string4, int n2, Object object) {
        tx6480.b(string2, "$receiver");
        tx6480.b(string3, "delimiter");
        tx6480.b(string2, "missingDelimiterValue");
        int n3 = fs24.a(string2, string3, 0, false);
        if (n3 == -1) {
            return string2;
        }
        String string5 = string2.substring(n3 + string3.length(), string2.length());
        tx6480.a((Object)string5, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string5;
    }

    private static String a(JSONObject jSONObject) {
        if (jSONObject.has("error")) {
            String string2 = jSONObject.getString("error");
            tx6480.a((Object)string2, "jsonObject.getString(\"error\")");
            return string2;
        }
        return "";
    }

    private static boolean a(char c2, char c3, boolean bl2) {
        return c2 == c3;
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n2, Object object) {
        tx6480.b((Object)charSequence, "$receiver");
        tx6480.b((Object)charSequence2, "other");
        if (charSequence2 instanceof String) {
            return fs24.a(charSequence, (String)charSequence2, 0, false) >= 0;
        }
        return fs24.a(charSequence, charSequence2, 0, charSequence.length(), false, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean a(String string2, String string3, boolean bl2, int n2, Object object) {
        tx6480.b(string2, "$receiver");
        tx6480.b(string3, "prefix");
        return string2.startsWith(string3);
    }
}

