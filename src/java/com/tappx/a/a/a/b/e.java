/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.a.b;

public class e {
    public static String a(String string2) {
        return e.a(string2, 256);
    }

    private static String a(String string2, int n2) {
        if (string2 != null && !string2.trim().isEmpty()) {
            if (string2.length() > n2) {
                string2 = string2.substring(0, n2);
            }
            return string2;
        }
        return null;
    }
}

