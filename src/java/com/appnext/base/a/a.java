/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.appnext.base.a.c.a
 *  com.appnext.base.a.c.b
 *  com.appnext.base.a.c.c
 *  java.lang.Class
 *  java.lang.Object
 */
package com.appnext.base.a;

import com.appnext.base.a.c.b;
import com.appnext.base.a.c.c;

public class a {
    private static volatile a dw;
    private com.appnext.base.a.c.a dt = new com.appnext.base.a.c.a();
    private b du = new b();
    private c dv = new c();

    private a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a X() {
        if (dw != null) return dw;
        Class<a> class_ = a.class;
        synchronized (a.class) {
            if (dw != null) return dw;
            dw = new a();
            // ** MonitorExit[var1] (shouldn't be in output)
            return dw;
        }
    }

    private void Y() {
        this.dt = new com.appnext.base.a.c.a();
        this.du = new b();
        this.dv = new c();
    }

    public final com.appnext.base.a.c.a Z() {
        return this.dt;
    }

    public final b aa() {
        return this.du;
    }

    public final c ab() {
        return this.dv;
    }
}

