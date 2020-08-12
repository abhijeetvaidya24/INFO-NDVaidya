/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.applovin.impl.sdk.e.d
 *  com.applovin.impl.sdk.e.j
 *  com.applovin.impl.sdk.e.n
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.List
 *  java.util.Map
 *  java.util.concurrent.TimeUnit
 */
package com.applovin.impl.a;

import com.applovin.impl.a.c;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.n;
import com.applovin.impl.sdk.p;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class g {
    private String a;
    private String b;
    private String c;
    private long d = -1L;
    private int e = -1;

    private g() {
    }

    private static int a(String string, c c2) {
        if ("start".equalsIgnoreCase(string)) {
            return 0;
        }
        if ("firstQuartile".equalsIgnoreCase(string)) {
            return 25;
        }
        if ("midpoint".equalsIgnoreCase(string)) {
            return 50;
        }
        if ("thirdQuartile".equalsIgnoreCase(string)) {
            return 75;
        }
        if ("complete".equalsIgnoreCase(string)) {
            if (c2 != null) {
                return c2.i();
            }
            return 95;
        }
        return -1;
    }

    /*
     * Unable to fully structure code
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static g a(n var0, c var1_1, com.applovin.impl.sdk.j var2_2) {
        block15 : {
            block17 : {
                block18 : {
                    block12 : {
                        block14 : {
                            block13 : {
                                if (var0 == null) break block18;
                                if (var2_2 == null) throw new IllegalArgumentException("No sdk specified.");
                                var5_3 = var0.c();
                                if (!j.b((String)var5_3)) break block12;
                                var6_4 = new g();
                                var6_4.c = var5_3;
                                var6_4.a = (String)var0.b().get((Object)"id");
                                var6_4.b = (String)var0.b().get((Object)"event");
                                var6_4.e = g.a(var6_4.a(), var1_1);
                                var7_5 = (String)var0.b().get((Object)"offset");
                                if (!j.b((String)var7_5)) return var6_4;
                                var8_6 = var7_5.trim();
                                if (!var8_6.contains((CharSequence)"%")) break block13;
                                var6_4.e = j.a((String)var8_6.substring(0, -1 + var8_6.length()));
                                return var6_4;
                            }
                            if (!var8_6.contains((CharSequence)":")) break block14;
                            var13_7 = d.a((String)var8_6, (String)":");
                            var14_8 = var13_7.size();
                            if (var14_8 <= 0) return var6_4;
                            var15_9 = 0L;
                            var18_11 = var17_10 = var14_8 - 1;
lbl25: // 2 sources:
                            do {
                                block16 : {
                                    if (var18_11 < 0) ** GOTO lbl-1000
                                    var19_12 = (String)var13_7.get(var18_11);
                                    if (!j.d((String)var19_12)) break block15;
                                    var20_13 = Integer.parseInt((String)var19_12);
                                    if (var18_11 != var17_10) break block16;
                                    var22_15 = var20_13;
                                    break block17;
                                }
                                if (var18_11 == var14_8 - 2) {
                                    var21_14 = TimeUnit.MINUTES;
lbl38: // 2 sources:
                                    do {
                                        var22_15 = var21_14.toSeconds((long)var20_13);
                                        break block17;
                                        break;
                                    } while (true);
                                }
                                if (var18_11 == var14_8 - 3) {
                                    var21_14 = TimeUnit.HOURS;
                                    ** continue;
                                }
                                break block15;
lbl-1000: // 1 sources:
                                {
                                    var6_4.d = var15_9;
                                    var6_4.e = -1;
                                    return var6_4;
                                }
                                break;
                            } while (true);
                        }
                        var9_16 = var2_2.u();
                        var10_17 = new StringBuilder();
                        var10_17.append("Unable to parse time offset from rawOffsetString = ");
                        var10_17.append(var8_6);
                        var9_16.d("VastTracker", var10_17.toString());
                        return var6_4;
                    }
                    try {
                        var2_2.u().d("VastTracker", "Unable to create tracker. Could not find URL.");
                        return null;
                    }
                    catch (Throwable var4_18) {
                        var2_2.u().b("VastTracker", "Error occurred while initializing", var4_18);
                    }
                    return null;
                }
                var3_19 = new IllegalArgumentException("No node specified.");
                throw var3_19;
            }
            var15_9 += var22_15;
        }
        --var18_11;
        ** while (true)
    }

    public String a() {
        return this.b;
    }

    public boolean a(long l2, int n2) {
        long l3 = this.d;
        boolean bl = true;
        boolean bl2 = l3 >= 0L;
        boolean bl3 = l2 >= this.d;
        boolean bl4 = this.e >= 0;
        boolean bl5 = n2 >= this.e;
        if (!bl2 || !bl3) {
            if (bl4 && bl5) {
                return bl;
            }
            bl = false;
        }
        return bl;
    }

    public String b() {
        return this.c;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof g)) {
            return false;
        }
        g g2 = (g)object;
        if (this.d != g2.d) {
            return false;
        }
        if (this.e != g2.e) {
            return false;
        }
        String string = this.a;
        if (string != null ? !string.equals((Object)g2.a) : g2.a != null) {
            return false;
        }
        String string2 = this.b;
        if (string2 != null ? !string2.equals((Object)g2.b) : g2.b != null) {
            return false;
        }
        return this.c.equals((Object)g2.c);
    }

    public int hashCode() {
        String string = this.a;
        int n2 = string != null ? string.hashCode() : 0;
        int n3 = n2 * 31;
        String string2 = this.b;
        int n4 = 0;
        if (string2 != null) {
            n4 = string2.hashCode();
        }
        int n5 = 31 * (31 * (n3 + n4) + this.c.hashCode());
        long l2 = this.d;
        return 31 * (n5 + (int)(l2 ^ l2 >>> 32)) + this.e;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VastTracker{identifier='");
        stringBuilder.append(this.a);
        stringBuilder.append('\'');
        stringBuilder.append(", event='");
        stringBuilder.append(this.b);
        stringBuilder.append('\'');
        stringBuilder.append(", uriString='");
        stringBuilder.append(this.c);
        stringBuilder.append('\'');
        stringBuilder.append(", offsetSeconds=");
        stringBuilder.append(this.d);
        stringBuilder.append(", offsetPercent=");
        stringBuilder.append(this.e);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

