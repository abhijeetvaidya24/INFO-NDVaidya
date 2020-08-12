/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 */
package io.presage;

public final class CamembertauCalvados {
    public static char[] a(long l2, char[] arrc) {
        char[] arrc2 = new char[arrc.length];
        int n2 = 0;
        int n3 = 4;
        for (int i2 = 0; i2 < arrc.length; ++i2) {
            if (((1L & l2 >>> i2) != 1L || n2 >= 4) && n3 < arrc2.length) {
                arrc2[n3] = arrc[i2];
                ++n3;
                continue;
            }
            arrc2[n2] = arrc[i2];
            ++n2;
        }
        return arrc2;
    }
}

