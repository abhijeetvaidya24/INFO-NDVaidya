/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.tapjoy.internal.hv
 *  java.lang.Object
 */
package com.tapjoy.internal;

import com.tapjoy.internal.dk;
import com.tapjoy.internal.hv;
import com.tapjoy.internal.hx;

public final class dp {
    final hv a;

    public dp(hv hv2) {
        this.a = hv2;
    }

    static int a(int n2) {
        if ((n2 & -128) == 0) {
            return 1;
        }
        if ((n2 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & n2) == 0) {
            return 3;
        }
        if ((n2 & -268435456) == 0) {
            return 4;
        }
        return 5;
    }

    static int a(int n2, dk dk2) {
        return n2 << 3 | dk2.e;
    }

    static int a(long l2) {
        if ((-128L & l2) == 0L) {
            return 1;
        }
        if ((-16384L & l2) == 0L) {
            return 2;
        }
        if ((-2097152L & l2) == 0L) {
            return 3;
        }
        if ((-268435456L & l2) == 0L) {
            return 4;
        }
        if ((-34359738368L & l2) == 0L) {
            return 5;
        }
        if ((-4398046511104L & l2) == 0L) {
            return 6;
        }
        if ((-562949953421312L & l2) == 0L) {
            return 7;
        }
        if ((-72057594037927936L & l2) == 0L) {
            return 8;
        }
        if ((l2 & Long.MIN_VALUE) == 0L) {
            return 9;
        }
        return 10;
    }

    static int b(int n2) {
        return n2 << 1 ^ n2 >> 31;
    }

    static long b(long l2) {
        return l2 << 1 ^ l2 >> 63;
    }

    public final void a(hx hx2) {
        this.a.b(hx2);
    }

    public final void c(int n2) {
        while ((n2 & -128) != 0) {
            this.a.e(128 | n2 & 127);
            n2 >>>= 7;
        }
        this.a.e(n2);
    }

    public final void c(long l2) {
        while ((-128L & l2) != 0L) {
            this.a.e(128 | 127 & (int)l2);
            l2 >>>= 7;
        }
        this.a.e((int)l2);
    }

    public final void d(int n2) {
        this.a.d(n2);
    }

    public final void d(long l2) {
        this.a.f(l2);
    }
}

