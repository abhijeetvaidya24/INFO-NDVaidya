/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.dn$1
 *  com.tapjoy.internal.dn$10
 *  com.tapjoy.internal.dn$11
 *  com.tapjoy.internal.dn$12
 *  com.tapjoy.internal.dn$13
 *  com.tapjoy.internal.dn$14
 *  com.tapjoy.internal.dn$2
 *  com.tapjoy.internal.dn$3
 *  com.tapjoy.internal.dn$4
 *  com.tapjoy.internal.dn$5
 *  com.tapjoy.internal.dn$6
 *  com.tapjoy.internal.dn$7
 *  com.tapjoy.internal.dn$8
 *  com.tapjoy.internal.dn$9
 *  com.tapjoy.internal.hu
 *  com.tapjoy.internal.hv
 *  com.tapjoy.internal.hw
 *  java.io.IOException
 *  java.io.InputStream
 *  java.io.OutputStream
 *  java.lang.AssertionError
 *  java.lang.Boolean
 *  java.lang.Class
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.List
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dk;
import com.tapjoy.internal.dm;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.do;
import com.tapjoy.internal.dp;
import com.tapjoy.internal.hu;
import com.tapjoy.internal.hv;
import com.tapjoy.internal.hw;
import com.tapjoy.internal.hx;
import com.tapjoy.internal.hy;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public abstract class dn {
    public static final dn c = new 1(dk.a, Boolean.class);
    public static final dn d = new 7(dk.a, Integer.class);
    public static final dn e = new 8(dk.a, Integer.class);
    public static final dn f = new 9(dk.a, Integer.class);
    public static final dn g;
    public static final dn h;
    public static final dn i;
    public static final dn j;
    public static final dn k;
    public static final dn l;
    public static final dn m;
    public static final dn n;
    public static final dn o;
    public static final dn p;
    public static final dn q;
    final Class a;
    dn b;
    private final dk r;

    static {
        10 var0 = new 10(dk.d, Integer.class);
        g = var0;
        h = var0;
        i = new 11(dk.a, Long.class);
        j = new 12(dk.a, Long.class);
        k = new 13(dk.a, Long.class);
        14 var1_1 = new 14(dk.b, Long.class);
        l = var1_1;
        m = var1_1;
        n = new 2(dk.d, Float.class);
        o = new 3(dk.b, Double.class);
        p = new 4(dk.c, String.class);
        q = new 5(dk.c, hx.class);
    }

    public dn(dk dk2, Class class_) {
        this.r = dk2;
        this.a = class_;
    }

    private Object a(hw hw2) {
        dm.a((Object)hw2, "source == null");
        return this.a(new do(hw2));
    }

    private void a(hv hv2, Object object) {
        dm.a(object, "value == null");
        dm.a((Object)hv2, "sink == null");
        this.a(new dp(hv2), object);
    }

    public static String c(Object object) {
        return object.toString();
    }

    public int a(int n2, Object object) {
        int n3 = this.a(object);
        if (this.r == dk.c) {
            n3 += dp.a(n3);
        }
        return n3 + dp.a(dp.a(n2, dk.a));
    }

    public abstract int a(Object var1);

    public final dn a() {
        dn dn2 = this.b;
        if (dn2 != null) {
            return dn2;
        }
        6 var2_2 = new 6(this, this.r, List.class);
        this.b = var2_2;
        return var2_2;
    }

    public abstract Object a(do var1);

    public final Object a(InputStream inputStream) {
        dm.a((Object)inputStream, "stream == null");
        return this.a(hy.a(hy.a(inputStream)));
    }

    public final Object a(byte[] arrby) {
        dm.a(arrby, "bytes == null");
        hu hu2 = new hu();
        if (arrby != null) {
            return this.a((hw)hu2.a(arrby, 0, arrby.length));
        }
        throw new IllegalArgumentException("source == null");
    }

    public void a(dp dp2, int n2, Object object) {
        dp2.c(dp.a(n2, this.r));
        if (this.r == dk.c) {
            dp2.c(this.a(object));
        }
        this.a(dp2, object);
    }

    public abstract void a(dp var1, Object var2);

    public final void a(OutputStream outputStream, Object object) {
        dm.a(object, "value == null");
        dm.a((Object)outputStream, "stream == null");
        hv hv2 = hy.a(hy.a(outputStream));
        this.a(hv2, object);
        hv2.a();
    }

    public final byte[] b(Object object) {
        dm.a(object, "value == null");
        hu hu2 = new hu();
        try {
            this.a((hv)hu2, object);
        }
        catch (IOException iOException) {
            throw new AssertionError((Object)((Object)iOException));
        }
        return hu2.g();
    }

    public static final class a
    extends IllegalArgumentException {
        public final int a;

        a(int n2, Class class_) {
            StringBuilder stringBuilder = new StringBuilder("Unknown enum tag ");
            stringBuilder.append(n2);
            stringBuilder.append(" for ");
            stringBuilder.append(class_.getCanonicalName());
            super(stringBuilder.toString());
            this.a = n2;
        }
    }

}

