/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.adincube.sdk.util;

import java.util.Map;
import java.util.Set;

public final class x {
    public static String a(String string) {
        if (string == null) {
            return null;
        }
        if (string.length() <= 40) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string.substring(0, 39));
        stringBuilder.append("\u2026");
        return stringBuilder.toString();
    }

    public static String a(Map<?, ?> map, String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry : map.entrySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(string2);
            }
            stringBuilder.append(entry.getKey().toString());
            stringBuilder.append(string);
            stringBuilder.append(entry.getValue().toString());
        }
        return stringBuilder.toString();
    }

    public static boolean c(String string) {
        return string == null || string.isEmpty();
        {
        }
    }
}

