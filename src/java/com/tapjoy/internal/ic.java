/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 */
package com.tapjoy.internal;

import com.tapjoy.internal.ib;

final class ic {
    static ib a;
    static long b;

    private ic() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static ib a() {
        Class<ic> class_ = ic.class;
        synchronized (ic.class) {
            if (a != null) {
                ib ib2 = a;
                a = ib2.f;
                ib2.f = null;
                b -= 8192L;
                // ** MonitorExit[var2] (shouldn't be in output)
                return ib2;
            }
            // ** MonitorExit[var2] (shouldn't be in output)
            return new ib();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static void a(ib ib2) {
        if (ib2.f == null && ib2.g == null) {
            if (ib2.d) {
                return;
            }
            Class<ic> class_ = ic.class;
            synchronized (ic.class) {
                if (8192L + b > 65536L) {
                    // ** MonitorExit[var2_1] (shouldn't be in output)
                    return;
                }
                b = 8192L + b;
                ib2.f = a;
                ib2.c = 0;
                ib2.b = 0;
                a = ib2;
                // ** MonitorExit[var2_1] (shouldn't be in output)
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}

