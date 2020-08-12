/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.EOFException
 *  java.lang.AssertionError
 *  java.lang.Cloneable
 *  java.lang.IllegalArgumentException
 *  java.lang.IllegalStateException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.charset.Charset
 */
package com.tapjoy.internal;

import com.tapjoy.internal.hv;
import com.tapjoy.internal.hw;
import com.tapjoy.internal.hx;
import com.tapjoy.internal.ib;
import com.tapjoy.internal.ic;
import com.tapjoy.internal.id;
import com.tapjoy.internal.ih;
import java.io.EOFException;
import java.nio.charset.Charset;

public final class hu
implements hv,
hw,
Cloneable {
    private static final byte[] c = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    ib a;
    long b;

    private void a(byte[] arrby) {
        int n2;
        for (int i2 = 0; i2 < arrby.length; i2 += n2) {
            int n3 = arrby.length - i2;
            ih.a(arrby.length, i2, n3);
            ib ib2 = this.a;
            if (ib2 == null) {
                n2 = -1;
            } else {
                n2 = Math.min((int)n3, (int)(ib2.c - ib2.b));
                System.arraycopy((Object)ib2.a, (int)ib2.b, (Object)arrby, (int)i2, (int)n2);
                ib2.b = n2 + ib2.b;
                this.b -= (long)n2;
                if (ib2.b == ib2.c) {
                    this.a = ib2.a();
                    ic.a(ib2);
                }
            }
            if (n2 != -1) {
                continue;
            }
            throw new EOFException();
        }
    }

    private byte[] g(long l2) {
        ih.a(this.b, 0L, l2);
        if (l2 <= Integer.MAX_VALUE) {
            byte[] arrby = new byte[(int)l2];
            this.a(arrby);
            return arrby;
        }
        StringBuilder stringBuilder = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public final hu a(int n2) {
        ib ib2 = this.c(1);
        byte[] arrby = ib2.a;
        int n3 = ib2.c;
        ib2.c = n3 + 1;
        arrby[n3] = (byte)n2;
        this.b = 1L + this.b;
        return this;
    }

    public final hu a(hx hx2) {
        if (hx2 != null) {
            hx2.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    /*
     * Enabled aggressive block sorting
     */
    public final hu a(String string) {
        int n2 = string.length();
        if (string == null) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("string == null");
            throw illegalArgumentException;
        }
        if (n2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("endIndex < beginIndex: ");
            stringBuilder.append(n2);
            stringBuilder.append(" < 0");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        if (n2 > string.length()) {
            StringBuilder stringBuilder = new StringBuilder("endIndex > string.length: ");
            stringBuilder.append(n2);
            stringBuilder.append(" > ");
            stringBuilder.append(string.length());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        int n3 = 0;
        while (n3 < n2) {
            char c2 = string.charAt(n3);
            if (c2 < '') {
                char c3;
                ib ib2 = this.c(1);
                byte[] arrby = ib2.a;
                int n4 = ib2.c - n3;
                int n5 = Math.min((int)n2, (int)(8192 - n4));
                int n6 = n3 + 1;
                arrby[n3 + n4] = (byte)c2;
                while ((n3 = n6) < n5 && (c3 = string.charAt(n3)) < '') {
                    n6 = n3 + 1;
                    arrby[n3 + n4] = (byte)c3;
                }
                int n7 = n4 + n3 - ib2.c;
                ib2.c = n7 + ib2.c;
                this.b += (long)n7;
                continue;
            }
            if (c2 < '\u0800') {
                this.a(192 | c2 >> 6);
                this.a(128 | c2 & 63);
            } else {
                if (c2 >= '\ud800' && c2 <= '\udfff') {
                    int n8 = n3 + 1;
                    char c4 = n8 < n2 ? string.charAt(n8) : (char)'\u0000';
                    if (c2 <= '\udbff' && c4 >= '\udc00' && c4 <= '\udfff') {
                        int n9 = 65536 + ((c2 & -55297) << 10 | -56321 & c4);
                        this.a(240 | n9 >> 18);
                        this.a(128 | 63 & n9 >> 12);
                        this.a(128 | 63 & n9 >> 6);
                        this.a(128 | n9 & 63);
                        n3 += 2;
                        continue;
                    }
                    this.a(63);
                    n3 = n8;
                    continue;
                }
                this.a(224 | c2 >> 12);
                this.a(128 | 63 & c2 >> 6);
                this.a(128 | c2 & 63);
            }
            ++n3;
        }
        return this;
    }

    public final hu a(byte[] arrby, int n2, int n3) {
        IllegalArgumentException illegalArgumentException;
        if (arrby != null) {
            long l2 = arrby.length;
            long l3 = n3;
            ih.a(l2, 0L, l3);
            int n4 = n3 + 0;
            while (n2 < n4) {
                ib ib2 = this.c(1);
                int n5 = Math.min((int)(n4 - n2), (int)(8192 - ib2.c));
                System.arraycopy((Object)arrby, (int)n2, (Object)ib2.a, (int)ib2.c, (int)n5);
                n2 += n5;
                ib2.c = n5 + ib2.c;
            }
            this.b = l3 + this.b;
            return this;
        }
        illegalArgumentException = new IllegalArgumentException("source == null");
        throw illegalArgumentException;
    }

    @Override
    public final hv a() {
        return this;
    }

    @Override
    public final void a(long l2) {
        if (this.b >= l2) {
            return;
        }
        throw new EOFException();
    }

    @Override
    public final void a(hu hu2, long l2) {
        IllegalArgumentException illegalArgumentException;
        block11 : {
            block12 : {
                if (hu2 == null) break block11;
                if (hu2 == this) break block12;
                ih.a(hu2.b, 0L, l2);
                while (l2 > 0L) {
                    block15 : {
                        long l3;
                        block14 : {
                            int n2;
                            int n3;
                            ib ib2;
                            ib ib3;
                            int n4;
                            block13 : {
                                ib ib4;
                                if (l2 < (long)(hu2.a.c - hu2.a.b)) {
                                    long l4;
                                    int n5;
                                    ib ib5 = this.a;
                                    ib ib6 = ib5 != null ? ib5.g : null;
                                    if (ib6 != null && ib6.e && (l4 = l2 + (long)ib6.c) - (long)(n5 = ib6.d ? 0 : ib6.b) <= 8192L) {
                                        hu2.a.a(ib6, (int)l2);
                                        hu2.b -= l2;
                                        this.b = l2 + this.b;
                                        return;
                                    }
                                    ib ib7 = hu2.a;
                                    int n6 = (int)l2;
                                    if (n6 > 0 && n6 <= ib7.c - ib7.b) {
                                        ib ib8;
                                        if (n6 >= 1024) {
                                            ib8 = new ib(ib7);
                                        } else {
                                            ib8 = ic.a();
                                            System.arraycopy((Object)ib7.a, (int)ib7.b, (Object)ib8.a, (int)0, (int)n6);
                                        }
                                        ib8.c = n6 + ib8.b;
                                        ib7.b = n6 + ib7.b;
                                        ib7.g.a(ib8);
                                        hu2.a = ib8;
                                    } else {
                                        throw new IllegalArgumentException();
                                    }
                                }
                                ib2 = hu2.a;
                                l3 = ib2.c - ib2.b;
                                hu2.a = ib2.a();
                                ib3 = this.a;
                                if (ib3 != null) break block13;
                                ib4.g = ib4 = (this.a = ib2);
                                ib4.f = ib4;
                                break block14;
                            }
                            ib ib9 = ib3.g.a(ib2);
                            if (ib9.g == ib9) break block15;
                            if (ib9.g.e && (n4 = ib9.c - ib9.b) <= (n3 = 8192 - ib9.g.c) + (n2 = ib9.g.d ? 0 : ib9.g.b)) {
                                ib9.a(ib9.g, n4);
                                ib9.a();
                                ic.a(ib9);
                            }
                        }
                        hu2.b -= l3;
                        this.b = l3 + this.b;
                        l2 -= l3;
                        continue;
                    }
                    throw new IllegalStateException();
                }
                return;
            }
            throw new IllegalArgumentException("source == this");
        }
        illegalArgumentException = new IllegalArgumentException("source == null");
        throw illegalArgumentException;
    }

    @Override
    public final long b(hu hu2, long l2) {
        if (hu2 != null) {
            if (l2 >= 0L) {
                long l3 = this.b;
                if (l3 == 0L) {
                    return -1L;
                }
                if (l2 > l3) {
                    l2 = l3;
                }
                hu2.a(this, l2);
                return l2;
            }
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("sink == null");
    }

    public final hu b(int n2) {
        int n3 = ih.a(n2);
        ib ib2 = this.c(4);
        byte[] arrby = ib2.a;
        int n4 = ib2.c;
        int n5 = n4 + 1;
        arrby[n4] = (byte)(255 & n3 >>> 24);
        int n6 = n5 + 1;
        arrby[n5] = (byte)(255 & n3 >>> 16);
        int n7 = n6 + 1;
        arrby[n6] = (byte)(255 & n3 >>> 8);
        int n8 = n7 + 1;
        arrby[n7] = (byte)(n3 & 255);
        ib2.c = n8;
        this.b = 4L + this.b;
        return this;
    }

    @Override
    public final /* synthetic */ hv b(hx hx2) {
        return this.a(hx2);
    }

    @Override
    public final /* synthetic */ hv b(String string) {
        return this.a(string);
    }

    @Override
    public final hx b(long l2) {
        return new hx(this.g(l2));
    }

    @Override
    public final boolean b() {
        return this.b == 0L;
    }

    @Override
    public final byte c() {
        if (this.b != 0L) {
            ib ib2 = this.a;
            int n2 = ib2.b;
            int n3 = ib2.c;
            byte[] arrby = ib2.a;
            int n4 = n2 + 1;
            byte by = arrby[n2];
            --this.b;
            if (n4 == n3) {
                this.a = ib2.a();
                ic.a(ib2);
                return by;
            }
            ib2.b = n4;
            return by;
        }
        throw new IllegalStateException("size == 0");
    }

    final ib c(int n2) {
        if (n2 > 0 && n2 <= 8192) {
            ib ib2 = this.a;
            if (ib2 == null) {
                ib ib3;
                ib3.g = ib3 = (this.a = ic.a());
                ib3.f = ib3;
                return ib3;
            }
            ib ib4 = ib2.g;
            if (n2 + ib4.c > 8192 || !ib4.e) {
                ib4 = ib4.a(ic.a());
            }
            return ib4;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public final String c(long l2) {
        Charset charset = ih.a;
        ih.a(this.b, 0L, l2);
        if (charset != null) {
            if (l2 <= Integer.MAX_VALUE) {
                if (l2 == 0L) {
                    return "";
                }
                ib ib2 = this.a;
                if (l2 + (long)ib2.b > (long)ib2.c) {
                    return new String(this.g(l2), charset);
                }
                String string = new String(ib2.a, ib2.b, (int)l2, charset);
                ib2.b = (int)(l2 + (long)ib2.b);
                this.b -= l2;
                if (ib2.b == ib2.c) {
                    this.a = ib2.a();
                    ic.a(ib2);
                }
                return string;
            }
            StringBuilder stringBuilder = new StringBuilder("byteCount > Integer.MAX_VALUE: ");
            stringBuilder.append(l2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("charset == null");
    }

    public final /* synthetic */ Object clone() {
        return this.h();
    }

    @Override
    public final void close() {
    }

    public final int d() {
        if (this.b >= 4L) {
            ib ib2 = this.a;
            int n2 = ib2.c;
            int n3 = ib2.b;
            if (n2 - n3 < 4) {
                return (255 & this.c()) << 24 | (255 & this.c()) << 16 | (255 & this.c()) << 8 | 255 & this.c();
            }
            byte[] arrby = ib2.a;
            int n4 = n3 + 1;
            int n5 = (255 & arrby[n3]) << 24;
            int n6 = n4 + 1;
            int n7 = n5 | (255 & arrby[n4]) << 16;
            int n8 = n6 + 1;
            int n9 = n7 | (255 & arrby[n6]) << 8;
            int n10 = n8 + 1;
            int n11 = n9 | 255 & arrby[n8];
            this.b -= 4L;
            if (n10 == n2) {
                this.a = ib2.a();
                ic.a(ib2);
                return n11;
            }
            ib2.b = n10;
            return n11;
        }
        StringBuilder stringBuilder = new StringBuilder("size < 4: ");
        stringBuilder.append(this.b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public final /* synthetic */ hv d(int n2) {
        return this.b(n2);
    }

    @Override
    public final void d(long l2) {
        while (l2 > 0L) {
            ib ib2 = this.a;
            if (ib2 != null) {
                int n2 = (int)Math.min((long)l2, (long)(ib2.c - this.a.b));
                long l3 = this.b;
                long l4 = n2;
                this.b = l3 - l4;
                l2 -= l4;
                ib ib3 = this.a;
                ib3.b = n2 + ib3.b;
                if (this.a.b != this.a.c) continue;
                ib ib4 = this.a;
                this.a = ib4.a();
                ic.a(ib4);
                continue;
            }
            throw new EOFException();
        }
    }

    @Override
    public final int e() {
        return ih.a(this.d());
    }

    public final hu e(long l2) {
        long l3 = ih.a(l2);
        ib ib2 = this.c(8);
        byte[] arrby = ib2.a;
        int n2 = ib2.c;
        int n3 = n2 + 1;
        arrby[n2] = (byte)(255L & l3 >>> 56);
        int n4 = n3 + 1;
        arrby[n3] = (byte)(255L & l3 >>> 48);
        int n5 = n4 + 1;
        arrby[n4] = (byte)(255L & l3 >>> 40);
        int n6 = n5 + 1;
        arrby[n5] = (byte)(255L & l3 >>> 32);
        int n7 = n6 + 1;
        arrby[n6] = (byte)(255L & l3 >>> 24);
        int n8 = n7 + 1;
        arrby[n7] = (byte)(255L & l3 >>> 16);
        int n9 = n8 + 1;
        arrby[n8] = (byte)(255L & l3 >>> 8);
        int n10 = n9 + 1;
        arrby[n9] = (byte)(l3 & 255L);
        ib2.c = n10;
        this.b = 8L + this.b;
        return this;
    }

    @Override
    public final /* synthetic */ hv e(int n2) {
        return this.a(n2);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof hu)) {
            return false;
        }
        hu hu2 = (hu)object;
        long l2 = this.b;
        if (l2 != hu2.b) {
            return false;
        }
        long l3 = 0L;
        if (l2 == l3) {
            return true;
        }
        ib ib2 = this.a;
        ib ib3 = hu2.a;
        int n2 = ib2.b;
        int n3 = ib3.b;
        while (l3 < this.b) {
            long l4 = Math.min((int)(ib2.c - n2), (int)(ib3.c - n3));
            int n4 = n3;
            int n5 = n2;
            int n6 = 0;
            while ((long)n6 < l4) {
                byte[] arrby = ib2.a;
                int n7 = n5 + 1;
                byte by = arrby[n5];
                byte[] arrby2 = ib3.a;
                int n8 = n4 + 1;
                if (by != arrby2[n4]) {
                    return false;
                }
                ++n6;
                n5 = n7;
                n4 = n8;
            }
            if (n5 == ib2.c) {
                ib2 = ib2.f;
                n2 = ib2.b;
            } else {
                n2 = n5;
            }
            if (n4 == ib3.c) {
                ib3 = ib3.f;
                n3 = ib3.b;
            } else {
                n3 = n4;
            }
            l3 += l4;
        }
        return true;
    }

    @Override
    public final long f() {
        if (this.b >= 8L) {
            long l2;
            ib ib2 = this.a;
            int n2 = ib2.c;
            int n3 = ib2.b;
            if (n2 - n3 < 8) {
                l2 = (0xFFFFFFFFL & (long)this.d()) << 32 | 0xFFFFFFFFL & (long)this.d();
            } else {
                byte[] arrby = ib2.a;
                int n4 = n3 + 1;
                long l3 = (255L & (long)arrby[n3]) << 56;
                int n5 = n4 + 1;
                long l4 = l3 | (255L & (long)arrby[n4]) << 48;
                int n6 = n5 + 1;
                long l5 = l4 | (255L & (long)arrby[n5]) << 40;
                int n7 = n6 + 1;
                long l6 = l5 | (255L & (long)arrby[n6]) << 32;
                int n8 = n7 + 1;
                long l7 = l6 | (255L & (long)arrby[n7]) << 24;
                int n9 = n8 + 1;
                long l8 = l7 | (255L & (long)arrby[n8]) << 16;
                int n10 = n9 + 1;
                long l9 = l8 | (255L & (long)arrby[n9]) << 8;
                int n11 = n10 + 1;
                long l10 = l9 | 255L & (long)arrby[n10];
                this.b -= 8L;
                if (n11 == n2) {
                    this.a = ib2.a();
                    ic.a(ib2);
                } else {
                    ib2.b = n11;
                }
                l2 = l10;
            }
            return ih.a(l2);
        }
        StringBuilder stringBuilder = new StringBuilder("size < 8: ");
        stringBuilder.append(this.b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public final /* synthetic */ hv f(long l2) {
        return this.e(l2);
    }

    @Override
    public final void flush() {
    }

    public final byte[] g() {
        try {
            byte[] arrby = this.g(this.b);
            return arrby;
        }
        catch (EOFException eOFException) {
            throw new AssertionError((Object)eOFException);
        }
    }

    public final hu h() {
        ib ib2;
        hu hu2 = new hu();
        if (this.b == 0L) {
            return hu2;
        }
        ib2.g = ib2 = (hu2.a = new ib(this.a));
        ib2.f = ib2;
        ib ib3 = this.a;
        while ((ib3 = ib3.f) != this.a) {
            hu2.a.g.a(new ib(ib3));
        }
        hu2.b = this.b;
        return hu2;
    }

    public final int hashCode() {
        ib ib2 = this.a;
        if (ib2 == null) {
            return 0;
        }
        int n2 = 1;
        do {
            int n3 = ib2.c;
            for (int i2 = ib2.b; i2 < n3; ++i2) {
                n2 = n2 * 31 + ib2.a[i2];
            }
        } while ((ib2 = ib2.f) != this.a);
        return n2;
    }

    public final String toString() {
        long l2 = this.b;
        if (l2 <= Integer.MAX_VALUE) {
            int n2 = (int)l2;
            hx hx2 = n2 == 0 ? hx.b : new id(this, n2);
            return hx2.toString();
        }
        StringBuilder stringBuilder = new StringBuilder("size > Integer.MAX_VALUE: ");
        stringBuilder.append(this.b);
        throw new IllegalArgumentException(stringBuilder.toString());
    }
}

