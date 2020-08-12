/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.io.UnsupportedEncodingException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.tappx.a.a.a.b.a;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public class d {
    private static final String e = "Content-Type";
    private static final String f = "ISO-8859-1";
    public final int a;
    public final Map<String, String> b;
    public final byte[] c;
    public final long d;

    public d(int n2, Map<String, String> map, byte[] arrby, long l2) {
        this.c = arrby;
        this.a = n2;
        this.b = map;
        this.d = l2;
    }

    public static String a(Map<String, String> map) {
        return d.a(map, f);
    }

    static String a(Map<String, String> map, String string2) {
        String string3 = (String)map.get((Object)e);
        if (string3 != null) {
            String[] arrstring = string3.split(";");
            for (int i2 = 1; i2 < arrstring.length; ++i2) {
                String[] arrstring2 = arrstring[i2].trim().split("=");
                if (arrstring2.length != 2 || !arrstring2[0].equals((Object)"charset")) continue;
                return arrstring2[1];
            }
        }
        return string2;
    }

    public String a() {
        byte[] arrby = this.c;
        if (arrby == null) {
            return null;
        }
        try {
            String string2 = new String(arrby, d.a(this.b));
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return new String(this.c);
        }
    }
}

