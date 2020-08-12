/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  I
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Array
 *  java.util.ArrayList
 *  java.util.regex.Matcher
 *  java.util.regex.Pattern
 */
package com.b.a.a.a;

import com.b.a.a.a.e.e;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class d {
    private static final Pattern a = Pattern.compile((String)"<(head)( [^>]*)?>", (int)2);
    private static final Pattern b = Pattern.compile((String)"<(head)( [^>]*)?/>", (int)2);
    private static final Pattern c = Pattern.compile((String)"<(body)( [^>]*?)?>", (int)2);
    private static final Pattern d = Pattern.compile((String)"<(body)( [^>]*?)?/>", (int)2);
    private static final Pattern e = Pattern.compile((String)"<(html)( [^>]*?)?>", (int)2);
    private static final Pattern f = Pattern.compile((String)"<(html)( [^>]*?)?/>", (int)2);
    private static final Pattern g = Pattern.compile((String)"<!DOCTYPE [^>]*>", (int)2);

    static String a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<script type=\"text/javascript\">");
        stringBuilder.append(string2);
        stringBuilder.append("</script>");
        return d.b(string3, stringBuilder.toString());
    }

    private static boolean a(int n2, int[][] arrn) {
        if (arrn != null) {
            for (int[] arrn2 : arrn) {
                if (n2 < arrn2[0] || n2 > arrn2[1]) continue;
                return true;
            }
        }
        return false;
    }

    private static boolean a(String string2, StringBuilder stringBuilder, Pattern pattern, String string3, int[][] arrn) {
        Matcher matcher = pattern.matcher((CharSequence)string2);
        int n2 = 0;
        while (matcher.find(n2)) {
            int n3 = matcher.start();
            int n4 = matcher.end();
            if (!d.a(n3, arrn)) {
                stringBuilder.append(string2.substring(0, matcher.end()));
                stringBuilder.append(string3);
                stringBuilder.append(string2.substring(matcher.end()));
                return true;
            }
            n2 = n4;
        }
        return false;
    }

    private static int[][] a(String string2) {
        ArrayList arrayList = new ArrayList();
        int n2 = string2.length();
        int n3 = 0;
        while (n3 < n2) {
            int n4 = string2.indexOf("<!--", n3);
            if (n4 >= 0) {
                int n5 = string2.indexOf("-->", n4);
                if (n5 >= 0) {
                    arrayList.add((Object)new int[]{n4, n5});
                    n3 = n5 + 3;
                    continue;
                }
                arrayList.add((Object)new int[]{n4, n2});
            }
            n3 = n2;
        }
        return (int[][])arrayList.toArray((Object[])((int[][])Array.newInstance(I.class, (int[])new int[]{0, 2})));
    }

    static String b(String string2, String string3) {
        e.a(string2, "HTML is null or empty");
        int[][] arrn = d.a(string2);
        StringBuilder stringBuilder = new StringBuilder(16 + (string2.length() + string3.length()));
        if (d.b(string2, stringBuilder, b, string3, arrn)) {
            return stringBuilder.toString();
        }
        if (d.a(string2, stringBuilder, a, string3, arrn)) {
            return stringBuilder.toString();
        }
        if (d.b(string2, stringBuilder, d, string3, arrn)) {
            return stringBuilder.toString();
        }
        if (d.a(string2, stringBuilder, c, string3, arrn)) {
            return stringBuilder.toString();
        }
        if (d.b(string2, stringBuilder, f, string3, arrn)) {
            return stringBuilder.toString();
        }
        if (d.a(string2, stringBuilder, e, string3, arrn)) {
            return stringBuilder.toString();
        }
        if (d.a(string2, stringBuilder, g, string3, arrn)) {
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string3);
        stringBuilder2.append(string2);
        return stringBuilder2.toString();
    }

    private static boolean b(String string2, StringBuilder stringBuilder, Pattern pattern, String string3, int[][] arrn) {
        Matcher matcher = pattern.matcher((CharSequence)string2);
        int n2 = 0;
        while (matcher.find(n2)) {
            int n3 = matcher.start();
            int n4 = matcher.end();
            if (!d.a(n3, arrn)) {
                stringBuilder.append(string2.substring(0, -2 + matcher.end()));
                stringBuilder.append(">");
                stringBuilder.append(string3);
                stringBuilder.append("</");
                stringBuilder.append(matcher.group(1));
                stringBuilder.append(">");
                stringBuilder.append(string2.substring(matcher.end()));
                return true;
            }
            n2 = n4;
        }
        return false;
    }
}

