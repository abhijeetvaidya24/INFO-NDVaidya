/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Class
 *  java.lang.Object
 */
package com.tapjoy.internal;

public final class fl {
    public static final fl a;
    public final long b;
    public final long c;
    public final double d;
    public long e;
    private final long f;

    static {
        fl fl2;
        a = fl2 = new fl(0L, 0L, 0L, 0.0);
    }

    public fl(long l2, long l3, long l4, double d2) {
        this.f = l2;
        this.b = l3;
        this.c = l4;
        this.d = d2;
        this.e = l2;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object != null) {
            if (this.getClass() != object.getClass()) {
                return false;
            }
            fl fl2 = (fl)object;
            if (this.f == fl2.f && this.b == fl2.b && this.c == fl2.c && this.d == fl2.d && this.e == fl2.e) {
                return true;
            }
        }
        return false;
    }
}

