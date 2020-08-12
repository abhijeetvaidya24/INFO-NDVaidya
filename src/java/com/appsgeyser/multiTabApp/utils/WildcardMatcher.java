/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.utils;

public class WildcardMatcher {
    public static boolean match(String string2, String string3) {
        String[] arrstring = string3.split("\\*");
        int n2 = arrstring.length;
        String string4 = string2;
        for (int i2 = 0; i2 < n2; ++i2) {
            String string5 = arrstring[i2];
            int n3 = string4.indexOf(string5);
            if (n3 == -1) {
                return false;
            }
            string4 = string4.substring(n3 + string5.length());
        }
        return true;
    }
}

