/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.util.g;

public final class a {
    private byte[] a;
    private int b = 0;

    public a(byte[] arrby) {
        this.a = arrby;
    }

    public final int a() {
        int n2 = this.b;
        byte[] arrby = this.a;
        if (n2 < 8 * arrby.length) {
            int n3 = n2 / 8;
            int n4 = 7 - n2 % 8;
            this.b = n2 + 1;
            return 1 & arrby[n3] >> n4;
        }
        throw new IndexOutOfBoundsException();
    }

    final long a(int n2) {
        long l2 = 0L;
        for (int i2 = 0; i2 < n2; ++i2) {
            l2 = l2 << 1 | (long)this.a();
        }
        return l2;
    }

    public final int b(int n2) {
        if (n2 < 32) {
            return (int)this.a(n2);
        }
        throw new IllegalArgumentException("nbBits must not exceed 32 to be compatible for the return type.");
    }
}

