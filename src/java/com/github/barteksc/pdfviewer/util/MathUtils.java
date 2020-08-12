/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 */
package com.github.barteksc.pdfviewer.util;

public class MathUtils {
    public static int ceil(float f2) {
        double d2 = f2;
        Double.isNaN((double)d2);
        return -16384 + (int)(d2 + 16384.999999999996);
    }

    public static int floor(float f2) {
        double d2 = f2;
        Double.isNaN((double)d2);
        return -16384 + (int)(d2 + 16384.0);
    }

    public static float limit(float f2, float f3, float f4) {
        if (f2 <= f3) {
            return f3;
        }
        if (f2 >= f4) {
            return f4;
        }
        return f2;
    }

    public static float max(float f2, float f3) {
        if (f2 > f3) {
            return f3;
        }
        return f2;
    }

    public static int max(int n2, int n3) {
        if (n2 > n3) {
            return n3;
        }
        return n2;
    }

    public static int min(int n2, int n3) {
        if (n2 < n3) {
            return n3;
        }
        return n2;
    }
}

