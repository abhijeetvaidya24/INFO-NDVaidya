/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.NumberFormatException
 *  java.lang.Object
 *  java.lang.String
 */
package com.yandex.metrica.impl.utils;

public class i {
    public static int a(String string2, int n2) {
        try {
            int n3 = Integer.parseInt((String)string2);
            return n3;
        }
        catch (NumberFormatException numberFormatException) {
            return n2;
        }
    }

    public static long a(String string2, long l2) {
        try {
            long l3 = Long.parseLong((String)string2);
            return l3;
        }
        catch (NumberFormatException numberFormatException) {
            return l2;
        }
    }

    public static Long a(String string2) {
        try {
            Long l2 = Long.parseLong((String)string2);
            return l2;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }

    public static Integer b(String string2) {
        try {
            Integer n2 = Integer.parseInt((String)string2);
            return n2;
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }
}

