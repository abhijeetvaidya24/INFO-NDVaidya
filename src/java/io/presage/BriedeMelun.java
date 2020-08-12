/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  io.presage.du
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Arrays
 */
package io.presage;

import io.presage.ak;
import io.presage.cl;
import io.presage.du;
import java.util.Arrays;

public final class BriedeMelun {
    public static final BriedeMelun a = new BriedeMelun();
    private static String b = "https://%s-%s.presage.io/%s";

    private BriedeMelun() {
    }

    public static String a() {
        return BriedeMelun.a("ad_sync", "sy", "v1");
    }

    private static String a(String string2, String string3, String string4) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append('/');
        stringBuilder.append(string2);
        String string5 = String.format((String)stringBuilder.toString(), (Object[])Arrays.copyOf((Object[])new Object[]{string3, string4, string4}, (int)3));
        cl.a((Object)string5, "java.lang.String.format(format, *args)");
        return string5;
    }

    public static String a(boolean bl2) {
        String string2 = BriedeMelun.a("p", "pad", "v3");
        if (bl2) {
            int n2 = du.b((CharSequence)string2, (String)"s");
            StringBuilder stringBuilder = new StringBuilder();
            if (string2 != null) {
                String string3 = string2.substring(0, n2);
                cl.a((Object)string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                stringBuilder.append(string3);
                int n3 = n2 + 1;
                int n4 = string2.length();
                if (string2 != null) {
                    String string4 = string2.substring(n3, n4);
                    cl.a((Object)string4, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
                    stringBuilder.append(string4);
                    return stringBuilder.toString();
                }
                throw new ak("null cannot be cast to non-null type java.lang.String");
            }
            throw new ak("null cannot be cast to non-null type java.lang.String");
        }
        return string2;
    }

    public static String b() {
        return BriedeMelun.a("pl", "pl", "v2");
    }

    public static String c() {
        return BriedeMelun.a("track", "tr", "v1");
    }

    public static String d() {
        return BriedeMelun.a("ad_history", "ah", "v1");
    }
}

