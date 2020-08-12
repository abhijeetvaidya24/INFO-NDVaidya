/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  java.util.Map
 *  java.util.Set
 */
package com.aerserv.sdk.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StringUtils {
    public static String findValueInUrl(String string, String string2) {
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

    public static String findValueInUrl(String string, String string2, String string3) {
        String string4 = StringUtils.findValueInUrl(string, string2);
        if (string4 == null) {
            string4 = string3;
        }
        return string4;
    }

    public static boolean isBlank(String string) {
        return string == null || "".equals((Object)string.trim());
        {
        }
    }

    public static boolean isNotBlank(String string) {
        return true ^ StringUtils.isBlank(string);
    }

    public static String makeString(List<String> list, String string) {
        String string2 = "";
        if (string == null) {
            string = string2;
        }
        if (list != null && !list.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                stringBuilder.append((String)iterator.next());
                stringBuilder.append(string);
            }
            string2 = stringBuilder.replace(stringBuilder.length() - string.length(), stringBuilder.length(), string2).toString();
        }
        return string2;
    }

    public static List<String> makeStringList(Map<String, String> map, String string) {
        ArrayList arrayList = new ArrayList();
        if (map != null) {
            if (string == null) {
                string = "";
            }
            for (String string2 : map.keySet()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append(string);
                stringBuilder.append((String)map.get((Object)string2));
                arrayList.add((Object)stringBuilder.toString());
            }
        }
        return arrayList;
    }
}

