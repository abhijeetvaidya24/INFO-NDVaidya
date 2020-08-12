/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.hu
 *  java.io.Serializable
 *  java.lang.CharSequence
 *  java.lang.Character
 *  java.lang.Comparable
 *  java.lang.IllegalArgumentException
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.nio.charset.Charset
 *  java.util.Arrays
 */
package com.tapjoy.internal;

import com.tapjoy.internal.hu;
import com.tapjoy.internal.ih;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

public class hx
implements Serializable,
Comparable {
    static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final hx b = new hx((byte[])new byte[0].clone());
    final byte[] c;
    transient int d;
    transient String e;

    public hx(byte[] arrby) {
        this.c = arrby;
    }

    public byte a(int n2) {
        return this.c[n2];
    }

    public hx a(int n2, int n3) {
        if (n2 >= 0) {
            byte[] arrby = this.c;
            if (n3 <= arrby.length) {
                int n4 = n3 - n2;
                if (n4 >= 0) {
                    if (n2 == 0 && n3 == arrby.length) {
                        return this;
                    }
                    byte[] arrby2 = new byte[n4];
                    System.arraycopy((Object)this.c, (int)n2, (Object)arrby2, (int)0, (int)n4);
                    return new hx(arrby2);
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            StringBuilder stringBuilder = new StringBuilder("endIndex > length(");
            stringBuilder.append(this.c.length);
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public String a() {
        String string2;
        String string3 = this.e;
        if (string3 != null) {
            return string3;
        }
        this.e = string2 = new String(this.c, ih.a);
        return string2;
    }

    void a(hu hu2) {
        byte[] arrby = this.c;
        hu2.a(arrby, 0, arrby.length);
    }

    public boolean a(int n2, byte[] arrby, int n3, int n4) {
        byte[] arrby2;
        return n2 >= 0 && n2 <= (arrby2 = this.c).length - n4 && n3 >= 0 && n3 <= arrby.length - n4 && ih.a(arrby2, n2, arrby, n3, n4);
    }

    public String b() {
        byte[] arrby = this.c;
        char[] arrc = new char[2 * arrby.length];
        int n2 = arrby.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by2 = arrby[i2];
            int n4 = n3 + 1;
            char[] arrc2 = a;
            arrc[n3] = arrc2[15 & by2 >> 4];
            n3 = n4 + 1;
            arrc[n4] = arrc2[by2 & 15];
        }
        return new String(arrc);
    }

    public int c() {
        return this.c.length;
    }

    public /* synthetic */ int compareTo(Object object) {
        hx hx2 = (hx)object;
        int n2 = this.c();
        int n3 = hx2.c();
        int n4 = Math.min((int)n2, (int)n3);
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5;
            int n6 = 255 & this.a(i2);
            if (n6 == (n5 = 255 & hx2.a(i2))) continue;
            if (n6 < n5) {
                return -1;
            }
            return 1;
        }
        if (n2 == n3) {
            return 0;
        }
        if (n2 < n3) {
            return -1;
        }
        return 1;
    }

    public byte[] d() {
        return (byte[])this.c.clone();
    }

    public boolean equals(Object object) {
        int n2;
        hx hx2;
        byte[] arrby;
        if (object == this) {
            return true;
        }
        return object instanceof hx && (n2 = (hx2 = (hx)object).c()) == (arrby = this.c).length && hx2.a(0, arrby, 0, arrby.length);
    }

    public int hashCode() {
        int n2;
        int n3 = this.d;
        if (n3 != 0) {
            return n3;
        }
        this.d = n2 = Arrays.hashCode((byte[])this.c);
        return n2;
    }

    public String toString() {
        int n2;
        String string2;
        block6 : {
            int n3;
            if (this.c.length == 0) {
                return "[size=0]";
            }
            string2 = this.a();
            int n4 = string2.length();
            int n5 = 0;
            for (n2 = 0; n2 < n4; n2 += Character.charCount((int)n3)) {
                if (n5 == 64) break block6;
                n3 = string2.codePointAt(n2);
                if (Character.isISOControl((int)n3) && n3 != 10 && n3 != 13 || n3 == 65533) {
                    n2 = -1;
                    break block6;
                }
                ++n5;
            }
            n2 = string2.length();
        }
        if (n2 == -1) {
            if (this.c.length <= 64) {
                StringBuilder stringBuilder = new StringBuilder("[hex=");
                stringBuilder.append(this.b());
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder = new StringBuilder("[size=");
            stringBuilder.append(this.c.length);
            stringBuilder.append(" hex=");
            stringBuilder.append(this.a(0, 64).b());
            stringBuilder.append("\u2026]");
            return stringBuilder.toString();
        }
        String string3 = string2.substring(0, n2).replace((CharSequence)"\\", (CharSequence)"\\\\").replace((CharSequence)"\n", (CharSequence)"\\n").replace((CharSequence)"\r", (CharSequence)"\\r");
        if (n2 < string2.length()) {
            StringBuilder stringBuilder = new StringBuilder("[size=");
            stringBuilder.append(this.c.length);
            stringBuilder.append(" text=");
            stringBuilder.append(string3);
            stringBuilder.append("\u2026]");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder("[text=");
        stringBuilder.append(string3);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

