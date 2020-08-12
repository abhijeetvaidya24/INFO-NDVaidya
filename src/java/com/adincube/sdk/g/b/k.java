/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package com.adincube.sdk.g.b;

import com.adincube.sdk.h.g;

public class k {
    private static k a;
    private g b = null;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static k a() {
        if (a != null) return a;
        Class<k> class_ = k.class;
        synchronized (k.class) {
            if (a != null) return a;
            a = new k();
            // ** MonitorExit[var1] (shouldn't be in output)
            return a;
        }
    }

    public final boolean b() {
        return this.b != null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final g c() {
        if (this.b != null) return this.b;
        k k2 = this;
        synchronized (k2) {
            if (this.b != null) return this.b;
            this.b = new g();
            return this.b;
        }
    }
}

