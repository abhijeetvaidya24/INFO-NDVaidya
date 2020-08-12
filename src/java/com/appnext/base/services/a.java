/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 */
package com.appnext.base.services;

import com.appnext.base.operations.b;

public final class a {
    private static volatile a eA;
    private String dP;

    private a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a aK() {
        if (eA != null) return eA;
        Class<b> class_ = b.class;
        synchronized (b.class) {
            if (eA != null) return eA;
            eA = new a();
            // ** MonitorExit[var1] (shouldn't be in output)
            return eA;
        }
    }

    public final String getKey() {
        a a2 = this;
        synchronized (a2) {
            String string2 = this.dP;
            return string2;
        }
    }

    public final void setKey(String string2) {
        a a2 = this;
        synchronized (a2) {
            this.dP = string2;
            return;
        }
    }
}

