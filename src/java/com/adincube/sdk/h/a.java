/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Date
 */
package com.adincube.sdk.h;

import java.util.Date;

public final class a {
    private static long c = 86400000L;
    public final String a;
    public final boolean b;
    private long d;

    public a(String string, boolean bl) {
        this(string, bl, new Date().getTime());
    }

    public a(String string, boolean bl, long l2) {
        this.a = string;
        this.b = bl;
        this.d = l2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean a() {
        if (this.a == null) {
            return false;
        }
        if (this.d <= 0L) return false;
        long l2 = new Date().getTime() - this.d;
        if (l2 >= 0L) {
            if (l2 <= c) return true;
        }
        return false;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            a a2 = (a)object;
            if (this.b != a2.b) {
                return false;
            }
            return this.a.equals((Object)a2.a);
        }
        return false;
    }

    public final int hashCode() {
        return 31 * this.a.hashCode() + this.b;
    }
}

