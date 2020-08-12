/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.adincube.sdk.d.a
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.List
 *  java.util.Locale
 */
package com.adincube.sdk.d.a;

import com.adincube.sdk.d.a;
import com.adincube.sdk.util.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class c
extends a {
    public String a;

    public c(String string) {
        this(string, (List<String>)null);
    }

    public c(String string, String string2) {
        this(string, (List<String>)Arrays.asList((Object[])new String[]{string2}));
    }

    public c(String string, String string2, Throwable throwable) {
        this(string, (List<String>)Arrays.asList((Object[])new String[]{string2}), throwable);
    }

    public c(String string, List<String> list) {
        super(c.a(string, list), c.a(list));
        this.a = string;
    }

    private c(String string, List<String> list, Throwable throwable) {
        super(c.a(string, list), c.a(list), throwable);
        this.a = string;
    }

    private static String a(String string, List<String> list) {
        String string2 = String.format((Locale)Locale.US, (String)"Following error occurred: %s", (Object[])new Object[]{string});
        if (list != null && !list.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(": ");
            stringBuilder.append((String)list.get(0));
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    private static List<String> a(List<String> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 1; i2 < list.size(); ++i2) {
                arrayList.add(list.get(i2));
            }
            return arrayList;
        }
        return null;
    }

    public a.a b() {
        return a.a.c;
    }
}

