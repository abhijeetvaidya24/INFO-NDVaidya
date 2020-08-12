/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.hu
 *  java.lang.AssertionError
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.Arrays
 */
package com.tapjoy.internal;

import com.tapjoy.internal.hu;
import com.tapjoy.internal.hx;
import com.tapjoy.internal.ib;
import com.tapjoy.internal.ih;
import java.util.Arrays;

final class id
extends hx {
    final transient byte[][] f;
    final transient int[] g;

    id(hu hu2, int n2) {
        super(null);
        ih.a(hu2.b, 0L, n2);
        ib ib2 = hu2.a;
        int n3 = 0;
        ib ib3 = ib2;
        int n4 = 0;
        int n5 = 0;
        while (n4 < n2) {
            if (ib3.c != ib3.b) {
                n4 += ib3.c - ib3.b;
                ++n5;
                ib3 = ib3.f;
                continue;
            }
            throw new AssertionError((Object)"s.limit == s.pos");
        }
        this.f = new byte[n5][];
        this.g = new int[n5 * 2];
        ib ib4 = hu2.a;
        int n6 = 0;
        while (n3 < n2) {
            this.f[n6] = ib4.a;
            if ((n3 += ib4.c - ib4.b) > n2) {
                n3 = n2;
            }
            int[] arrn = this.g;
            arrn[n6] = n3;
            arrn[n6 + this.f.length] = ib4.b;
            ib4.d = true;
            ++n6;
            ib4 = ib4.f;
        }
    }

    private int b(int n2) {
        int n3 = Arrays.binarySearch((int[])this.g, (int)0, (int)this.f.length, (int)(n2 + 1));
        if (n3 >= 0) {
            return n3;
        }
        return ~n3;
    }

    private hx e() {
        return new hx(this.d());
    }

    @Override
    public final byte a(int n2) {
        ih.a(this.g[-1 + this.f.length], n2, 1L);
        int n3 = this.b(n2);
        int n4 = n3 == 0 ? 0 : this.g[n3 - 1];
        int[] arrn = this.g;
        byte[][] arrby = this.f;
        int n5 = arrn[n3 + arrby.length];
        return arrby[n3][n5 + (n2 - n4)];
    }

    @Override
    public final hx a(int n2, int n3) {
        return this.e().a(n2, n3);
    }

    @Override
    public final String a() {
        return this.e().a();
    }

    @Override
    final void a(hu hu2) {
        int n2 = this.f.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int[] arrn = this.g;
            int n4 = arrn[n2 + i2];
            int n5 = arrn[i2];
            ib ib2 = new ib(this.f[i2], n4, n4 + n5 - n3);
            if (hu2.a == null) {
                ib2.g = ib2;
                ib2.f = ib2;
                hu2.a = ib2;
            } else {
                hu2.a.g.a(ib2);
            }
            n3 = n5;
        }
        hu2.b += (long)n3;
    }

    @Override
    public final boolean a(int n2, byte[] arrby, int n3, int n4) {
        if (n2 >= 0 && n2 <= this.c() - n4 && n3 >= 0) {
            if (n3 > arrby.length - n4) {
                return false;
            }
            int n5 = this.b(n2);
            while (n4 > 0) {
                int n6;
                byte[][] arrby2 = this.f;
                int[] arrn = this.g;
                int n7 = n5 == 0 ? 0 : this.g[n5 - 1];
                int n8 = arrn[n5 + arrby2.length] + (n2 - n7);
                if (!ih.a(arrby2[n5], n8, arrby, n3, n6 = Math.min((int)n4, (int)(n7 + (this.g[n5] - n7) - n2)))) {
                    return false;
                }
                n2 += n6;
                n3 += n6;
                n4 -= n6;
                ++n5;
            }
            return true;
        }
        return false;
    }

    @Override
    public final String b() {
        return this.e().b();
    }

    @Override
    public final int c() {
        return this.g[-1 + this.f.length];
    }

    @Override
    public final byte[] d() {
        int[] arrn = this.g;
        byte[][] arrby = this.f;
        byte[] arrby2 = new byte[arrn[-1 + arrby.length]];
        int n2 = arrby.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int[] arrn2 = this.g;
            int n4 = arrn2[n2 + i2];
            int n5 = arrn2[i2];
            System.arraycopy((Object)this.f[i2], (int)n4, (Object)arrby2, (int)n3, (int)(n5 - n3));
            n3 = n5;
        }
        return arrby2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public final boolean equals(Object var1_1) {
        block5 : {
            if (var1_1 == this) {
                return true;
            }
            if (var1_1 instanceof hx == false) return false;
            var2_2 = (hx)var1_1;
            if (var2_2.c() != this.c()) return false;
            if (this.c() - var3_3 >= 0) {
                var4_5 = this.b(0);
                var5_6 = 0;
                var6_7 = 0;
            } else {
                do {
                    var7_4 = false;
                    break block5;
                    break;
                } while (true);
            }
            for (var3_3 = this.c(); var3_3 > 0; var5_6 += var9_9, var6_7 += var9_9, var3_3 -= var9_9, ++var4_5) {
                if (!var2_2.a(var6_7, (var11_11 = this.f)[var4_5], var12_12 = (var10_10 = this.g)[var4_5 + var11_11.length] + (var5_6 - (var8_8 = var4_5 == 0 ? 0 : this.g[var4_5 - 1])), var9_9 = Math.min((int)var3_3, (int)(var8_8 + (this.g[var4_5] - var8_8) - var5_6)))) ** continue;
            }
            var7_4 = true;
        }
        if (var7_4 == false) return false;
        return true;
    }

    @Override
    public final int hashCode() {
        int n2 = this.d;
        if (n2 != 0) {
            return n2;
        }
        int n3 = this.f.length;
        int n4 = 1;
        int n5 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            int n6;
            byte[] arrby = this.f[i2];
            int[] arrn = this.g;
            int n7 = arrn[i2];
            int n8 = n6 + (n7 - n5);
            for (n6 = arrn[n3 + i2]; n6 < n8; ++n6) {
                n4 = n4 * 31 + arrby[n6];
            }
            n5 = n7;
        }
        this.d = n4;
        return n4;
    }

    @Override
    public final String toString() {
        return this.e().toString();
    }
}

