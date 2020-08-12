/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.a.e
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.adincube.sdk.util;

public final class e {
    private static final char[] a = new char[64];
    private static final char[] b = new char[64];
    private static final byte[] c;
    private static final byte[] d;

    static {
        int n2 = 0;
        for (int n3 = 65; n3 <= 90; n3 = (int)((char)(n3 + 1))) {
            e.a[n2] = n3;
            e.b[n2] = n3;
            ++n2;
        }
        for (int n4 = 97; n4 <= 122; n4 = (int)((char)(n4 + 1))) {
            e.a[n2] = n4;
            e.b[n2] = n4;
            ++n2;
        }
        for (int n5 = 48; n5 <= 57; n5 = (int)((char)(n5 + 1))) {
            e.a[n2] = n5;
            e.b[n2] = n5;
            ++n2;
        }
        char[] arrc = a;
        arrc[n2] = 43;
        char[] arrc2 = b;
        arrc2[n2] = 45;
        int n6 = n2 + 1;
        arrc[n6] = 47;
        arrc2[n6] = 95;
        c = new byte[128];
        d = new byte[128];
        int n7 = 0;
        do {
            byte[] arrby = c;
            int n8 = arrby.length;
            if (n7 >= n8) break;
            arrby[n7] = -1;
            e.d[n7] = -1;
            ++n7;
        } while (true);
        for (int i2 = 0; i2 < 64; ++i2) {
            byte by;
            byte[] arrby = c;
            char c2 = a[i2];
            arrby[c2] = by = (byte)i2;
            e.d[e.b[i2]] = by;
        }
    }

    public static byte[] a(String string) {
        return e.a(string.toCharArray());
    }

    private static byte[] a(byte[] arrby, char[] arrc, int n2) {
        com.adincube.sdk.d.a.e e2;
        if (n2 % 4 == 0) {
            while (n2 > 0 && arrc[-1 + (n2 + 0)] == '=') {
                --n2;
            }
            int n3 = n2 * 3 / 4;
            byte[] arrby2 = new byte[n3];
            int n4 = 0;
            int n5 = n2 + 0;
            int n6 = 0;
            while (n4 < n5) {
                int n7;
                int n8;
                int n9 = n4 + 1;
                char c2 = arrc[n4];
                int n10 = n9 + 1;
                char c3 = arrc[n9];
                int n11 = 65;
                if (n10 < n5) {
                    n8 = n10 + 1;
                    n7 = arrc[n10];
                } else {
                    n8 = n10;
                    n7 = 65;
                }
                if (n8 < n5) {
                    int n12 = n8 + 1;
                    int n13 = arrc[n8];
                    n8 = n12;
                    n11 = n13;
                }
                if (c2 <= '' && c3 <= '' && n7 <= 127 && n11 <= 127) {
                    byte by = arrby[c2];
                    byte by2 = arrby[c3];
                    byte by3 = arrby[n7];
                    byte by4 = arrby[n11];
                    if (by >= 0 && by2 >= 0 && by3 >= 0 && by4 >= 0) {
                        int n14;
                        int n15 = by << 2 | by2 >>> 4;
                        int n16 = (by2 & 15) << 4 | by3 >>> 2;
                        int n17 = by4 | (by3 & 3) << 6;
                        int n18 = n6 + 1;
                        arrby2[n6] = (byte)n15;
                        if (n18 < n3) {
                            n14 = n18 + 1;
                            arrby2[n18] = (byte)n16;
                        } else {
                            n14 = n18;
                        }
                        if (n14 < n3) {
                            n6 = n14 + 1;
                            arrby2[n14] = (byte)n17;
                        } else {
                            n6 = n14;
                        }
                        n4 = n8;
                        continue;
                    }
                    throw new com.adincube.sdk.d.a.e();
                }
                throw new com.adincube.sdk.d.a.e();
            }
            return arrby2;
        }
        e2 = new com.adincube.sdk.d.a.e();
        throw e2;
    }

    public static byte[] a(char[] arrc) {
        return e.a(c, arrc, arrc.length);
    }

    public static char[] a(byte[] arrby) {
        char[] arrc = a;
        int n2 = arrby.length;
        int n3 = (2 + n2 * 4) / 3;
        char[] arrc2 = new char[4 * ((n2 + 2) / 3)];
        int n4 = n2 + 0;
        int n5 = 0;
        int n6 = 0;
        while (n5 < n4) {
            int n7;
            int n8;
            int n9;
            int n10;
            int n11 = n5 + 1;
            int n12 = 255 & arrby[n5];
            if (n11 < n4) {
                n7 = n11 + 1;
                n10 = 255 & arrby[n11];
            } else {
                n7 = n11;
                n10 = 0;
            }
            if (n7 < n4) {
                n9 = n7 + 1;
                n8 = 255 & arrby[n7];
            } else {
                n9 = n7;
                n8 = 0;
            }
            int n13 = n12 >>> 2;
            int n14 = (n12 & 3) << 4 | n10 >>> 4;
            int n15 = (n10 & 15) << 2 | n8 >>> 6;
            int n16 = n8 & 63;
            int n17 = n6 + 1;
            arrc2[n6] = arrc[n13];
            int n18 = n17 + 1;
            arrc2[n17] = arrc[n14];
            int n19 = 61;
            int n20 = n18 < n3 ? arrc[n15] : 61;
            arrc2[n18] = n20;
            int n21 = n18 + 1;
            if (n21 < n3) {
                n19 = arrc[n16];
            }
            arrc2[n21] = n19;
            n6 = n21 + 1;
            n5 = n9;
        }
        return arrc2;
    }

    public static byte[] b(String string) {
        if (string.length() % 4 != 0) {
            StringBuilder stringBuilder = new StringBuilder(string);
            for (int i2 = 0; i2 < 4 - string.length() % 4; ++i2) {
                stringBuilder.append('=');
            }
            string = stringBuilder.toString();
        }
        char[] arrc = string.toCharArray();
        return e.a(d, arrc, arrc.length);
    }

    public static String c(String string) {
        return new String(e.a(string));
    }

    public static String d(String string) {
        return new String(e.a(string.getBytes()));
    }
}

