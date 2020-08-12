/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 */
package com.amazon.device.ads;

class NumberUtils {
    private NumberUtils() {
    }

    public static final long convertToMillisecondsFromNanoseconds(long l2) {
        return l2 / 1000000L;
    }

    public static final long convertToMillisecondsFromSeconds(long l2) {
        return l2 * 1000L;
    }

    public static int parseInt(String string, int n) {
        try {
            n = Integer.parseInt((String)string);
        }
        catch (NumberFormatException numberFormatException) {}
        return n;
    }
}

