/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Character
 *  java.lang.Object
 *  java.lang.String
 */
package com.startapp.a.a.e;

class c {
    private static final char[] a = "0123456789abcdef".toCharArray();

    c() {
    }

    private boolean b(String string2) {
        return string2.length() % 2 != 0;
    }

    String a(byte[] arrby) {
        char[] arrc = new char[2 * arrby.length];
        for (int i2 = 0; i2 < arrby.length; ++i2) {
            int n2 = i2 * 2;
            char[] arrc2 = a;
            arrc[n2] = arrc2[(240 & arrby[i2]) >>> 4];
            arrc[n2 + 1] = arrc2[15 & arrby[i2]];
        }
        return new String(arrc);
    }

    byte[] a(String string2) {
        if (this.b(string2)) {
            return null;
        }
        byte[] arrby = new byte[string2.length() / 2];
        int n2 = string2.length();
        for (int i2 = 0; i2 < n2; i2 += 2) {
            arrby[i2 / 2] = (byte)((Character.digit((char)string2.charAt(i2), (int)16) << 4) + Character.digit((char)string2.charAt(i2 + 1), (int)16));
        }
        return arrby;
    }
}

