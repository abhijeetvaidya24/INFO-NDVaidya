/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  java.lang.Object
 *  java.lang.String
 */
package com.adincube.sdk.util;

import android.content.Context;
import com.adincube.sdk.util.e.c;
import com.adincube.sdk.util.f;

public final class d {
    private static boolean a;
    private static String b;
    private static String c;

    public static void a() {
        Context context = f.a();
        c = null;
        c.b(context, "ak");
    }

    public static void a(String string) {
        b = string;
        a = true;
        c = null;
    }

    public static String b() {
        String string;
        String string2;
        Context context = f.a();
        if (c == null && a) {
            String string3;
            c = string3 = c.a(context, "ak");
            if (string3 == null || !c.equals((Object)b)) {
                Object[] arrobject = new Object[1];
                String string4 = b;
                arrobject[0] = string4;
                if (string4 != null) {
                    c.a(context, "ak", string4);
                    c = b;
                } else {
                    c.b(context, "ak");
                    c = null;
                }
            }
        }
        if ((string2 = b) != null) {
            return string2;
        }
        if (c == null) {
            c = c.a(context, "ak");
            new Object[1][0] = c;
        }
        if ((string = c) != null) {
            b = string;
            return string;
        }
        return null;
    }
}

