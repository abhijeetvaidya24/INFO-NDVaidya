/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Float
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Number
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.math.BigInteger
 */
package com.tapjoy.internal;

import java.math.BigInteger;

public final class cn
extends Number {
    private final String a;

    public cn(String string2) {
        this.a = string2;
    }

    public final double doubleValue() {
        return Double.parseDouble((String)this.a);
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Number) {
            Number number = (Number)object;
            if (number instanceof Integer) {
                return this.intValue() == number.intValue();
            }
            if (number instanceof Long) {
                return this.longValue() == number.longValue();
            }
            if (number instanceof Float) {
                return this.floatValue() == number.floatValue();
            }
            if (number instanceof Double) {
                return this.doubleValue() == number.doubleValue();
            }
            return this.a.equals((Object)number.toString());
        }
        return false;
    }

    public final float floatValue() {
        return Float.parseFloat((String)this.a);
    }

    public final int intValue() {
        try {
            int n2 = Integer.parseInt((String)this.a);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            long l2;
            try {
                l2 = Long.parseLong((String)this.a);
            }
            catch (NumberFormatException numberFormatException2) {
                return new BigInteger(this.a).intValue();
            }
            return (int)l2;
        }
    }

    public final long longValue() {
        try {
            long l2 = Long.parseLong((String)this.a);
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            return new BigInteger(this.a).longValue();
        }
    }

    public final String toString() {
        return this.a;
    }
}

