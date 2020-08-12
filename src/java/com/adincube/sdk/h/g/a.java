/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.adincube.sdk.h.g;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    public long a;

    private a(long l2) {
        this.a = l2;
    }

    public static a a(String string, long l2) {
        if (string.contains((CharSequence)"%")) {
            return a.c(string, l2);
        }
        return a.b(string, l2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static a b(String string, long l2) {
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        Matcher matcher = Pattern.compile((String)"([0-9]{2}):([0-9]{2}):([0-9]{2})(\\.([0-9]{3}))?").matcher((CharSequence)string);
        if (!matcher.matches()) {
            return null;
        }
        try {
            l3 = Integer.parseInt((String)matcher.group(1));
            l7 = Integer.parseInt((String)matcher.group(2));
            l5 = Integer.parseInt((String)matcher.group(3));
            l6 = 0L;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
        if (matcher.groupCount() > 3 && matcher.group(5) != null) {
            l6 = Integer.parseInt((String)matcher.group(5));
        }
        if ((l4 = l6 + (l3 * 3600000L + l7 * 60000L + l5 * 1000L)) > l2) {
            do {
                return new a(l2);
                break;
            } while (true);
        }
        l2 = l4;
        return new a(l2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static a c(String string, long l2) {
        int n2;
        try {
            n2 = Integer.parseInt((String)string.substring(0, -1 + string.length()));
            if (n2 < 0 || n2 > 100) throw new IllegalArgumentException();
        }
        catch (Throwable throwable) {
            return null;
        }
        double d2 = n2;
        Double.isNaN((double)d2);
        double d3 = d2 / 100.0;
        double d4 = l2;
        Double.isNaN((double)d4);
        long l3 = (long)(d3 * d4);
        return new a(l3);
    }
}

