/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package com.chartboost.sdk.impl;

import com.chartboost.sdk.impl.a;

public class b {
    private static void a(int[] arrn) {
        for (int i2 = 0; i2 < arrn.length / 2; ++i2) {
            int n2 = arrn[i2];
            arrn[i2] = arrn[-1 + (arrn.length - i2)];
            arrn[-1 + (arrn.length - i2)] = n2;
        }
    }

    public static int[] a(char[] arrc, int[] arrn, boolean bl) {
        int n2 = (arrc[0] << 16) + arrc[1];
        int n3 = (arrc[2] << 16) + arrc[3];
        if (!bl) {
            b.a(arrn);
        }
        int n4 = n3;
        int n5 = n2;
        for (int i2 = 0; i2 < 16; ++i2) {
            int n6 = n5 ^ arrn[i2];
            a a2 = a.b;
            int n7 = n6 >>> 24;
            int n8 = 255 & n6 >>> 16;
            int n9 = 255 & n6 >>> 8;
            int n10 = n6 & 255;
            int n11 = n4 ^ (a2.a[0][n7] + a2.a[1][n8] ^ a2.a[2][n9]) + a2.a[3][n10];
            n4 = n6;
            n5 = n11;
        }
        int n12 = n5 ^ arrn[16];
        int n13 = n4 ^ arrn[17];
        int[] arrn2 = new int[]{n13, n12};
        arrc[0] = (char)(n13 >>> 16);
        arrc[1] = (char)n13;
        arrc[2] = (char)(n12 >>> 16);
        arrc[3] = (char)n12;
        if (!bl) {
            b.a(arrn);
        }
        return arrn2;
    }
}

