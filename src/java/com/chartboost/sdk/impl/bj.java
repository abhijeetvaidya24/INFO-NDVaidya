/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.IOException
 *  java.io.OutputStream
 *  java.lang.IllegalArgumentException
 *  java.lang.IndexOutOfBoundsException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 */
package com.chartboost.sdk.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bj
extends OutputStream {
    private static final byte[] a = new byte[0];
    private final List<byte[]> b = new ArrayList();
    private int c;
    private int d;
    private byte[] e;
    private int f;

    public bj() {
        this(1024);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public bj(int n2) {
        if (n2 >= 0) {
            bj bj2 = this;
            synchronized (bj2) {
                this.a(n2);
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Negative initial size: ");
        stringBuilder.append(n2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    private void a(int n2) {
        if (this.c < -1 + this.b.size()) {
            this.d += this.e.length;
            this.c = 1 + this.c;
            this.e = (byte[])this.b.get(this.c);
            return;
        }
        byte[] arrby = this.e;
        if (arrby == null) {
            this.d = 0;
        } else {
            n2 = Math.max((int)(arrby.length << 1), (int)(n2 - this.d));
            this.d += this.e.length;
        }
        this.c = 1 + this.c;
        this.e = new byte[n2];
        this.b.add((Object)this.e);
    }

    public byte[] a() {
        bj bj2 = this;
        synchronized (bj2) {
            Iterator iterator;
            int n2;
            int n3;
            byte[] arrby;
            int n4;
            block7 : {
                n4 = this.f;
                if (n4 != 0) break block7;
                byte[] arrby2 = a;
                return arrby2;
            }
            try {
                arrby = new byte[n4];
                iterator = this.b.iterator();
                n3 = 0;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            do {
                if (!iterator.hasNext()) break;
                byte[] arrby3 = (byte[])iterator.next();
                n2 = Math.min((int)arrby3.length, (int)n4);
                System.arraycopy((Object)arrby3, (int)0, (Object)arrby, (int)n3, (int)n2);
                n3 += n2;
            } while ((n4 -= n2) != 0);
            return arrby;
        }
    }

    public void close() throws IOException {
    }

    public String toString() {
        return new String(this.a());
    }

    public void write(int n2) {
        bj bj2 = this;
        synchronized (bj2) {
            block4 : {
                int n3 = this.f - this.d;
                if (n3 != this.e.length) break block4;
                this.a(1 + this.f);
                n3 = 0;
            }
            this.e[n3] = (byte)n2;
            this.f = 1 + this.f;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void write(byte[] arrby, int n2, int n3) {
        int n4;
        if (n2 >= 0 && n2 <= arrby.length && n3 >= 0 && (n4 = n2 + n3) <= arrby.length && n4 >= 0) {
            if (n3 == 0) {
                return;
            }
            bj bj2 = this;
            synchronized (bj2) {
                int n5 = n3 + this.f;
                int n6 = this.f - this.d;
                do {
                    if (n3 <= 0) {
                        this.f = n5;
                        return;
                    }
                    int n7 = Math.min((int)n3, (int)(this.e.length - n6));
                    System.arraycopy((Object)arrby, (int)(n4 - n3), (Object)this.e, (int)n6, (int)n7);
                    if ((n3 -= n7) <= 0) continue;
                    this.a(n5);
                    n6 = 0;
                } while (true);
            }
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        throw indexOutOfBoundsException;
    }
}

