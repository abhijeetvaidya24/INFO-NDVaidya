/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Object
 *  java.lang.System
 */
package com.integralads.avid.library.mopub.utils;

public class AvidTimestamp {
    private static double NANOSEC_PER_MILLISEC = 1000000.0;

    public static double getCurrentTime() {
        double d2 = System.nanoTime();
        double d3 = NANOSEC_PER_MILLISEC;
        Double.isNaN((double)d2);
        return d2 / d3;
    }
}

