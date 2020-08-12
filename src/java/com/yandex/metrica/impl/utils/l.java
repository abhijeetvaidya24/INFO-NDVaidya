/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.yandex.metrica.impl.bk
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashMap
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 */
package com.yandex.metrica.impl.utils;

import android.text.TextUtils;
import com.yandex.metrica.impl.bk;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class l {
    public static String a(Map<String, String> map) {
        if (!bk.a(map)) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry entry : map.entrySet()) {
                if (TextUtils.isEmpty((CharSequence)((CharSequence)entry.getKey()))) continue;
                stringBuilder.append((String)entry.getKey());
                stringBuilder.append(":");
                stringBuilder.append((String)entry.getValue());
                stringBuilder.append(",");
            }
            stringBuilder.setLength(-1 + stringBuilder.length());
            return stringBuilder.toString();
        }
        return "";
    }

    public static Map<String, String> a(String string2) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty((CharSequence)string2)) {
            for (String string3 : string2.split(",")) {
                String string4;
                int n2 = string3.indexOf(":");
                if (n2 == -1 || TextUtils.isEmpty((CharSequence)(string4 = string3.substring(0, n2)))) continue;
                hashMap.put((Object)string4, (Object)string3.substring(n2 + 1));
            }
        }
        return hashMap;
    }
}

