/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  java.lang.CharSequence
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.ArrayList
 *  java.util.Arrays
 *  java.util.Collection
 *  java.util.Collections
 *  java.util.Iterator
 *  java.util.List
 */
package com.applovin.impl.sdk.e;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class d {
    public static String a(Collection<String> collection, int n2) {
        return d.a(collection, ",", n2);
    }

    static String a(Collection<String> collection, String string2, int n2) {
        IllegalArgumentException illegalArgumentException;
        if (string2 != null) {
            if (collection != null && collection.size() >= 1) {
                StringBuilder stringBuilder = new StringBuilder();
                int n3 = 0;
                for (String string3 : collection) {
                    if (n3 >= n2) break;
                    ++n3;
                    stringBuilder.append(string3);
                    stringBuilder.append(string2);
                }
                if (stringBuilder.length() > string2.length()) {
                    stringBuilder.setLength(stringBuilder.length() - string2.length());
                }
                return stringBuilder.toString();
            }
            return "";
        }
        illegalArgumentException = new IllegalArgumentException("No glue specified");
        throw illegalArgumentException;
    }

    public static <T> List<T> a(int n2) {
        return Collections.synchronizedList((List)new ArrayList(n2));
    }

    public static List<String> a(String string2) {
        return d.a(string2, ",\\s*");
    }

    public static List<String> a(String string2, String string3) {
        if (TextUtils.isEmpty((CharSequence)string2)) {
            return Collections.emptyList();
        }
        return Arrays.asList((Object[])string2.split(string3));
    }

    public static List<String> a(List<String> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string2 = ((String)iterator.next()).trim();
            if (TextUtils.isEmpty((CharSequence)string2)) continue;
            arrayList.add((Object)string2);
        }
        return arrayList;
    }
}

