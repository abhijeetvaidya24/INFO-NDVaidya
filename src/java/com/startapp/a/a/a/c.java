/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.Serializable
 *  java.lang.AssertionError
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.a.a.a;

import java.io.Serializable;

public class c
implements Serializable {
    static final /* synthetic */ boolean a;
    private final long[][] d;
    private int e;
    private final int f;

    static {
        a = true ^ c.class.desiredAssertionStatus();
    }

    public c(long l2) {
        RuntimeException runtimeException;
        int n2 = this.e = this.d(l2);
        int n3 = n2 % 4096;
        int n4 = n2 / 4096;
        int n5 = n3 == 0 ? 0 : 1;
        int n6 = this.f = n5 + n4;
        if (n6 <= 100) {
            this.d = new long[n6][];
            for (int i2 = 0; i2 < n4; ++i2) {
                this.d[i2] = new long[4096];
            }
            if (n3 != 0) {
                long[][] arrl = this.d;
                arrl[arrl.length - 1] = new long[n3];
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HighPageCountException pageCount = ");
        stringBuilder.append(this.f);
        runtimeException = new RuntimeException(stringBuilder.toString());
        throw runtimeException;
    }

    private int b(long l2) {
        int n2 = (int)(l2 >> 6);
        if (n2 >= this.e) {
            this.c(l2 + 1L);
            this.e = n2 + 1;
        }
        return n2;
    }

    private void b(int n2) {
        if (!a) {
            if (n2 <= this.e) {
                return;
            }
            throw new AssertionError((Object)"Growing of paged bitset is not supported");
        }
    }

    private void c(long l2) {
        this.b(this.d(l2));
    }

    private int d(long l2) {
        return (int)(1L + (l2 - 1L >>> 6));
    }

    long a() {
        return (long)this.e << 6;
    }

    void a(long l2) {
        int n2 = this.b(l2);
        long l3 = 1L << (63 & (int)l2);
        long[] arrl = this.d[n2 / 4096];
        int n3 = n2 % 4096;
        arrl[n3] = l3 | arrl[n3];
    }

    public long[] a(int n2) {
        return this.d[n2];
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }
}

