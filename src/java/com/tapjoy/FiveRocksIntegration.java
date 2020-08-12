/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.FiveRocksIntegration$1
 *  com.tapjoy.internal.be
 *  com.tapjoy.internal.fr
 *  com.tapjoy.internal.gc
 *  com.tapjoy.internal.gd
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy;

import com.tapjoy.FiveRocksIntegration;
import com.tapjoy.TJPlacement;
import com.tapjoy.internal.be;
import com.tapjoy.internal.fr;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gd;

public class FiveRocksIntegration {
    private static be a = new be();

    public static void a() {
        gc gc2 = gc.a();
        if (!gc2.c) {
            gc2.c = true;
        }
        1 var1_1 = new 1();
        gc.a().p = gd.a((fr)var1_1);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void addPlacementCallback(String string, TJPlacement tJPlacement) {
        be be2;
        be be3 = be2 = a;
        synchronized (be3) {
            a.put((Object)string, (Object)tJPlacement);
            return;
        }
    }

    static /* synthetic */ be b() {
        return a;
    }
}

