/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.System
 */
package com.tapjoy.internal;

final class ib {
    final byte[] a;
    int b;
    int c;
    boolean d;
    boolean e;
    ib f;
    ib g;

    ib() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    ib(ib ib2) {
        this(ib2.a, ib2.b, ib2.c);
        ib2.d = true;
    }

    ib(byte[] arrby, int n2, int n3) {
        this.a = arrby;
        this.b = n2;
        this.c = n3;
        this.e = false;
        this.d = true;
    }

    public final ib a() {
        ib ib2 = this.f;
        if (ib2 == this) {
            ib2 = null;
        }
        ib ib3 = this.g;
        ib3.f = this.f;
        this.f.g = ib3;
        this.f = null;
        this.g = null;
        return ib2;
    }

    public final ib a(ib ib2) {
        ib2.g = this;
        ib2.f = this.f;
        this.f.g = ib2;
        this.f = ib2;
        return ib2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void a(ib ib2, int n2) {
        if (!ib2.e) throw new IllegalArgumentException();
        int n3 = ib2.c;
        if (n3 + n2 > 8192) {
            if (ib2.d) throw new IllegalArgumentException();
            int n4 = n3 + n2;
            int n5 = ib2.b;
            if (n4 - n5 > 8192) throw new IllegalArgumentException();
            byte[] arrby = ib2.a;
            System.arraycopy((Object)arrby, (int)n5, (Object)arrby, (int)0, (int)(n3 - n5));
            ib2.c -= ib2.b;
            ib2.b = 0;
        }
        System.arraycopy((Object)this.a, (int)this.b, (Object)ib2.a, (int)ib2.c, (int)n2);
        ib2.c = n2 + ib2.c;
        this.b = n2 + this.b;
    }
}

