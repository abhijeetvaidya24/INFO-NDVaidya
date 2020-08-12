/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.aer;

public final class an
extends Enum<an> {
    public static final /* enum */ an a = new an();
    public static final /* enum */ an b = new an();
    private static final /* synthetic */ an[] c;

    static {
        an[] arran = new an[]{a, b};
        c = arran;
    }

    public static an valueOf(String string) {
        return (an)Enum.valueOf(an.class, (String)string);
    }

    public static an[] values() {
        return (an[])c.clone();
    }
}

