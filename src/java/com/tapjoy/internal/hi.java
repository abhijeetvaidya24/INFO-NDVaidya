/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.nio.Buffer
 *  java.nio.BufferUnderflowException
 *  java.nio.ByteBuffer
 *  java.nio.ByteOrder
 *  java.util.Arrays
 *  java.util.List
 */
package com.tapjoy.internal;

import com.tapjoy.internal.hg;
import com.tapjoy.internal.hh;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;

public final class hi {
    private final byte[] a = new byte[256];
    private ByteBuffer b;
    private hh c;
    private int d = 0;

    private int[] a(int n2) {
        byte[] arrby = new byte[n2 * 3];
        int[] arrn = null;
        this.b.get(arrby);
        arrn = new int[256];
        int n3 = 0;
        int n4 = 0;
        while (n3 < n2) {
            int n5 = n4 + 1;
            int n6 = 255 & arrby[n4];
            int n7 = n5 + 1;
            int n8 = 255 & arrby[n5];
            int n9 = n7 + 1;
            int n10 = 255 & arrby[n7];
            int n11 = n3 + 1;
            try {
                arrn[n3] = n10 | (-16777216 | n6 << 16 | n8 << 8);
                n4 = n9;
                n3 = n11;
            }
            catch (BufferUnderflowException bufferUnderflowException) {
                new Object[1][0] = bufferUnderflowException;
                this.c.b = 1;
                break;
            }
        }
        return arrn;
    }

    private void b() {
        boolean bl2 = false;
        while (!bl2 && !this.h() && this.c.c <= Integer.MAX_VALUE) {
            int n2 = this.g();
            if (n2 != 33) {
                if (n2 != 44) {
                    if (n2 != 59) {
                        this.c.b = 1;
                        continue;
                    }
                    bl2 = true;
                    continue;
                }
                if (this.c.d == null) {
                    this.c.d = new hg();
                }
                this.c.d.a = this.b.getShort();
                this.c.d.b = this.b.getShort();
                this.c.d.c = this.b.getShort();
                this.c.d.d = this.b.getShort();
                int n3 = this.g();
                boolean bl3 = (n3 & 128) != 0;
                int n4 = (int)Math.pow((double)2.0, (double)(1 + (n3 & 7)));
                hg hg2 = this.c.d;
                boolean bl4 = (n3 & 64) != 0;
                hg2.e = bl4;
                this.c.d.k = bl3 ? this.a(n4) : null;
                this.c.d.j = this.b.position();
                this.g();
                this.e();
                if (this.h()) continue;
                hh hh2 = this.c;
                hh2.c = 1 + hh2.c;
                this.c.e.add((Object)this.c.d);
                continue;
            }
            int n5 = this.g();
            if (n5 != 1) {
                if (n5 != 249) {
                    if (n5 != 254) {
                        if (n5 != 255) {
                            this.e();
                            continue;
                        }
                        this.f();
                        String string2 = "";
                        for (int i2 = 0; i2 < 11; ++i2) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(string2);
                            stringBuilder.append((char)this.a[i2]);
                            string2 = stringBuilder.toString();
                        }
                        if (string2.equals((Object)"NETSCAPE2.0")) {
                            this.c();
                            continue;
                        }
                        this.e();
                        continue;
                    }
                    this.e();
                    continue;
                }
                this.c.d = new hg();
                this.g();
                int n6 = this.g();
                this.c.d.g = (n6 & 28) >> 2;
                if (this.c.d.g == 0) {
                    this.c.d.g = 1;
                }
                hg hg3 = this.c.d;
                boolean bl5 = (n6 & 1) != 0;
                hg3.f = bl5;
                int n7 = this.b.getShort();
                if (n7 < 2) {
                    n7 = 10;
                }
                this.c.d.i = n7 * 10;
                this.c.d.h = this.g();
                this.g();
                continue;
            }
            this.e();
        }
    }

    private void c() {
        do {
            this.f();
            byte[] arrby = this.a;
            if (arrby[0] != 1) continue;
            int n2 = 255 & arrby[1];
            int n3 = 255 & arrby[2];
            hh hh2 = this.c;
            hh2.m = n2 | n3 << 8;
            if (hh2.m != 0) continue;
            this.c.m = -1;
        } while (this.d > 0 && !this.h());
    }

    private void d() {
        String string2 = "";
        for (int i2 = 0; i2 < 6; ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append((char)this.g());
            string2 = stringBuilder.toString();
        }
        if (!string2.startsWith("GIF")) {
            this.c.b = 1;
            return;
        }
        this.c.f = this.b.getShort();
        this.c.g = this.b.getShort();
        int n2 = this.g();
        hh hh2 = this.c;
        int n3 = n2 & 128;
        boolean bl2 = false;
        if (n3 != 0) {
            bl2 = true;
        }
        hh2.h = bl2;
        hh hh3 = this.c;
        hh3.i = 2 << (n2 & 7);
        hh3.j = this.g();
        this.c.k = this.g();
        if (this.c.h && !this.h()) {
            hh hh4 = this.c;
            hh4.a = this.a(hh4.i);
            hh hh5 = this.c;
            hh5.l = hh5.a[this.c.j];
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e() {
        try {
            int n2;
            do {
                n2 = this.g();
                this.b.position(n2 + this.b.position());
            } while (n2 > 0);
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {}
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int f() {
        this.d = this.g();
        if (this.d <= 0) return 0;
        int n2 = 0;
        int n3 = 0;
        try {
            while (n2 < this.d) {
                n3 = this.d - n2;
                this.b.get(this.a, n2, n3);
                n2 += n3;
            }
            return n2;
        }
        catch (Exception exception) {
            Object[] arrobject = new Object[]{n2, n3, this.d, exception};
            this.c.b = 1;
            return n2;
        }
    }

    private int g() {
        byte by2;
        try {
            by2 = this.b.get();
        }
        catch (Exception exception) {
            this.c.b = 1;
            return 0;
        }
        return by2 & 255;
    }

    private boolean h() {
        return this.c.b != 0;
    }

    public final hh a() {
        if (this.b != null) {
            if (this.h()) {
                return this.c;
            }
            this.d();
            if (!this.h()) {
                this.b();
                if (this.c.c < 0) {
                    this.c.b = 1;
                }
            }
            return this.c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public final hi a(byte[] arrby) {
        if (arrby != null) {
            ByteBuffer byteBuffer = ByteBuffer.wrap((byte[])arrby);
            this.b = null;
            Arrays.fill((byte[])this.a, (byte)0);
            this.c = new hh();
            this.d = 0;
            this.b = byteBuffer.asReadOnlyBuffer();
            this.b.position(0);
            this.b.order(ByteOrder.LITTLE_ENDIAN);
            return this;
        }
        this.b = null;
        this.c.b = 2;
        return this;
    }
}

