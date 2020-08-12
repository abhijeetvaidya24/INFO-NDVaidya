/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.h.b.b
 *  com.adincube.sdk.h.b.c
 *  com.adincube.sdk.h.e
 *  java.lang.Class
 *  java.lang.Long
 *  java.lang.NoSuchFieldError
 *  java.lang.Object
 *  java.lang.System
 *  java.util.Arrays
 *  java.util.Collections
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Map
 */
package com.adincube.sdk.util;

import com.adincube.sdk.h.b.b;
import com.adincube.sdk.h.b.c;
import com.adincube.sdk.h.e;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class v {
    private static v b;
    private Map<e, Map<c, Long>> a = new HashMap();

    v() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static v a() {
        if (b != null) return b;
        Class<v> class_ = v.class;
        synchronized (v.class) {
            if (b != null) return b;
            b = new v();
            // ** MonitorExit[var1] (shouldn't be in output)
            return b;
        }
    }

    public final void a(e e2, c c2) {
        long l2 = System.currentTimeMillis();
        Map map = (Map)this.a.get((Object)e2);
        if (map == null) {
            map = new HashMap();
            this.a.put((Object)e2, (Object)map);
        }
        map.put((Object)c2, (Object)l2);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public final boolean a(b var1_1, e var2_2, c var3_3) {
        block14 : {
            block12 : {
                block13 : {
                    block11 : {
                        block8 : {
                            block9 : {
                                block10 : {
                                    if (var2_2 == e.c || var2_2 == e.d) break block8;
                                    if (var1_1 == null) ** GOTO lbl-1000
                                    var13_4 = 1.a[var2_2.ordinal()];
                                    if (var13_4 == 1) break block9;
                                    if (var13_4 == 2) break block10;
                                    if (var13_4 != 3) ** GOTO lbl-1000
                                    var4_5 = var1_1.p;
                                    break block11;
                                }
                                var4_5 = var1_1.n;
                                break block11;
                            }
                            if (var1_1.r) {
                                var4_5 = Arrays.asList((Object[])c.a());
                            } else lbl-1000: // 3 sources:
                            {
                                var4_5 = Collections.emptyList();
                            }
                            break block11;
                        }
                        var4_5 = Arrays.asList((Object[])c.a());
                    }
                    if (!var4_5.contains((Object)var3_3)) {
                        return false;
                    }
                    var5_6 = System.currentTimeMillis();
                    if (var1_1 == null || (var11_7 = var3_3 == c.a && var2_2 != e.c)) ** GOTO lbl-1000
                    if (var3_3 != c.b) break block12;
                    var12_8 = 1.a[var2_2.ordinal()];
                    if (var12_8 == 2) break block13;
                    if (var12_8 != 3) break block12;
                    var7_9 = var1_1.t;
                    break block14;
                }
                var7_9 = var1_1.s;
                break block14;
            }
            if (var2_2 == e.c || var2_2 == e.d) {
                var7_9 = var1_1.u;
            } else lbl-1000: // 2 sources:
            {
                var7_9 = 0L;
            }
        }
        var9_10 = (Map)this.a.get((Object)var2_2);
        if (var9_10 == null) {
            return true;
        }
        var10_11 = (Long)var9_10.get((Object)var3_3);
        if (var10_11 == null) {
            return true;
        }
        if (var10_11 > var5_6) {
            return false;
        }
        if (var5_6 - var10_11 <= var7_9) return false;
        return true;
    }

}

