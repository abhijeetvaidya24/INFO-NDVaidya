/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.presage;

public final class bq {
    public static final int a(int n2, int n3) {
        if (n2 >= n3) {
            return n3;
        }
        return n3 - bq.a(n3, n2, 1);
    }

    private static final int a(int n2, int n3, int n4) {
        return bq.b(bq.b(n2, 1) - bq.b(n3, 1), 1);
    }

    private static final int b(int n2, int n3) {
        int n4 = n2 % n3;
        if (n4 >= 0) {
            return n4;
        }
        return n4 + n3;
    }
}

