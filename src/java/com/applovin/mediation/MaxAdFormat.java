/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.applovin.mediation;

public class MaxAdFormat {
    public static final MaxAdFormat BANNER = new MaxAdFormat("BANNER");
    public static final MaxAdFormat INTERSTITIAL;
    public static final MaxAdFormat LEADER;
    public static final MaxAdFormat MREC;
    public static final MaxAdFormat NATIVE;
    public static final MaxAdFormat REWARDED;
    private final String a;

    static {
        MREC = new MaxAdFormat("MREC");
        LEADER = new MaxAdFormat("LEADER");
        INTERSTITIAL = new MaxAdFormat("INTER");
        REWARDED = new MaxAdFormat("REWARDED");
        NATIVE = new MaxAdFormat("NATIVE");
    }

    private MaxAdFormat(String string2) {
        this.a = string2;
    }

    public String toString() {
        return this.a;
    }
}

