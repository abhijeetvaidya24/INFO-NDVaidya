/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.aer;

public final class bf
extends Enum<bf> {
    public static final /* enum */ bf a = new bf();
    public static final /* enum */ bf b = new bf();
    private static final /* synthetic */ bf[] c;

    static {
        bf[] arrbf = new bf[]{a, b};
        c = arrbf;
    }

    public static bf valueOf(String string) {
        return (bf)Enum.valueOf(bf.class, (String)string);
    }

    public static bf[] values() {
        return (bf[])c.clone();
    }
}

