/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.internal;

import com.tapjoy.internal.fz;

public final class fx {
    public static String a(String string2) {
        if (string2 != null) {
            if (string2.length() == 0) {
                return null;
            }
            String string3 = string2.trim();
            if (string3 != null) {
                if (string3.length() == 0) {
                    return null;
                }
                return string3;
            }
        }
        return null;
    }

    public static String a(String string2, String string3, String string4) {
        if (string2 == null) {
            fz.a(string3, string4, "must not be null");
            return null;
        }
        if (string2.length() == 0) {
            fz.a(string3, string4, "must not be empty");
            return null;
        }
        String string5 = string2.trim();
        if (string5.length() == 0) {
            fz.a(string3, string4, "must not be blank");
            return null;
        }
        return string5;
    }

    public static String b(String string2) {
        if (string2 != null) {
            if (string2.length() == 0) {
                return null;
            }
            String string3 = string2.trim();
            if (string3.length() == 0) {
                return null;
            }
            return string3;
        }
        return null;
    }
}

