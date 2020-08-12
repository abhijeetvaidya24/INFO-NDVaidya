/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package com.appnext.core.result;

import com.appnext.core.result.c;

public final class d {
    private static d im;
    private c ih;

    private d() {
    }

    public static d bp() {
        Class<d> class_ = d.class;
        synchronized (d.class) {
            if (im == null) {
                im = new d();
            }
            d d2 = im;
            // ** MonitorExit[var2] (shouldn't be in output)
            return d2;
        }
    }

    public final void a(c c2) {
        this.ih = c2;
    }

    public final c bq() {
        return this.ih;
    }
}

