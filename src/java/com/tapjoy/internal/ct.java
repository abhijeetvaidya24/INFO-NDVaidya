/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

public final class ct {
    public static String a(String string2) {
        if (string2 == null) {
            string2 = "";
        }
        return string2;
    }

    public static String b(String string2) {
        if (ct.c(string2)) {
            string2 = null;
        }
        return string2;
    }

    public static boolean c(String string2) {
        return string2 == null || string2.length() == 0;
        {
        }
    }
}

