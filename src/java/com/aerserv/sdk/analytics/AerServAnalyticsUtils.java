/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.aerserv.sdk.analytics;

public class AerServAnalyticsUtils {
    public static String findValueInUrl(String string, String string2) {
        if (string == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("=");
        int n2 = string.indexOf(stringBuilder.toString());
        if (n2 < 0) {
            return null;
        }
        String string3 = string.substring(n2);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string2);
        stringBuilder2.append("=");
        String string4 = string3.replaceFirst(stringBuilder2.toString(), "");
        int n3 = string4.indexOf(38);
        if (n3 < 0) {
            return string4;
        }
        return string4.substring(0, n3);
    }
}

