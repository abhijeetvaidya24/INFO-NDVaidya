/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.System
 */
package com.integralads.avid.library.adcolony.utils;

public class AvidTimestamp {
    private static double a = 1000000.0;

    public static double getCurrentTime() {
        double d2 = System.nanoTime();
        double d3 = a;
        Double.isNaN((double)d2);
        return d2 / d3;
    }
}

