/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.yandex.metrica.impl.ob.b
 *  java.io.IOException
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.ob.b;
import com.yandex.metrica.impl.ob.e;
import java.io.IOException;

public abstract class d {
    protected volatile int a = -1;

    public static final byte[] a(d d2) {
        byte[] arrby = new byte[d2.b()];
        int n2 = arrby.length;
        try {
            b b2 = b.a((byte[])arrby, (int)0, (int)n2);
            d2.a(b2);
            b2.b();
            return arrby;
        }
        catch (IOException iOException) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", (Throwable)iOException);
        }
    }

    public int a() {
        if (this.a < 0) {
            this.b();
        }
        return this.a;
    }

    public void a(b b2) throws IOException {
    }

    public int b() {
        int n2;
        this.a = n2 = this.c();
        return n2;
    }

    protected int c() {
        return 0;
    }

    public String toString() {
        return e.a(this);
    }
}

