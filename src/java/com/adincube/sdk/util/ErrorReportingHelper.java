/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  com.adincube.sdk.b.a.a.g
 *  com.adincube.sdk.g.a
 *  com.adincube.sdk.h.a.b
 *  com.adincube.sdk.h.a.e
 *  com.adincube.sdk.h.b.b
 *  com.adincube.sdk.h.b.c
 *  com.adincube.sdk.h.c.a
 *  com.adincube.sdk.h.c.b
 *  com.adincube.sdk.h.c.c
 *  com.adincube.sdk.h.e
 *  com.adincube.sdk.j.a
 *  com.adincube.sdk.j.e
 *  com.adincube.sdk.j.k
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Throwable
 */
package com.adincube.sdk.util;

import android.net.Uri;
import com.adincube.sdk.b.a.a.g;
import com.adincube.sdk.h.a.e;
import com.adincube.sdk.h.b.c;
import com.adincube.sdk.h.c.b;
import com.adincube.sdk.j.k;
import com.adincube.sdk.util.a;
import com.adincube.sdk.util.m;
import com.adincube.sdk.util.v;

public class ErrorReportingHelper {
    private static com.adincube.sdk.g.a a = com.adincube.sdk.g.a.a();
    private static boolean b = false;

    private static void a(String string, String string2, b b2, com.adincube.sdk.h.c.a a2, Boolean bl, e e2, Throwable throwable) {
        if (b) {
            return;
        }
        try {
            v v2 = v.a();
            if (v2.a(a.a(true, true), com.adincube.sdk.h.e.c, c.a)) {
                com.adincube.sdk.j.e e3 = new com.adincube.sdk.j.e();
                e3.a = b2;
                e3.b = a2;
                e3.c = bl;
                e3.m = string2;
                e3.l = e2;
                e3.j = "UNKNOWN_EXCEPTION";
                e3.k = string;
                e3.n = m.a(throwable);
                e3.k();
            }
            v2.a(com.adincube.sdk.h.e.c, c.a);
            return;
        }
        catch (Throwable throwable2) {
            a.c("ErrorReportingHelper.report", new Object[]{throwable2});
            return;
        }
    }

    public static void report(g g2, Uri uri, b b2, com.adincube.sdk.h.c.a a2, Boolean bl) {
        if (b) {
            return;
        }
        try {
            v v2 = v.a();
            if (v2.a(a.a(true, true), com.adincube.sdk.h.e.d, c.a)) {
                k k2 = new k();
                k2.a = b2;
                k2.b = a2;
                k2.c = bl;
                k2.j = g2;
                k2.k = uri;
                k2.k();
            }
            v2.a(com.adincube.sdk.h.e.c, c.a);
            return;
        }
        catch (Throwable throwable) {
            a.c("ErrorReportingHelper.report", new Object[]{throwable});
            return;
        }
    }

    public static void report(String string, com.adincube.sdk.h.a.b b2, com.adincube.sdk.h.c.c c2, Throwable throwable) {
        ErrorReportingHelper.a(string, "RTB", b.b, c2.i, null, (e)b2, throwable);
    }

    public static void report(String string, e e2, Throwable throwable) {
        ErrorReportingHelper.a(string, "RTB", b.a, null, false, e2, throwable);
    }

    public static void report(String string, b b2, com.adincube.sdk.h.c.a a2, Boolean bl, Throwable throwable) {
        ErrorReportingHelper.a(string, null, b2, a2, bl, null, throwable);
    }

    public static void report(String string, b b2, com.adincube.sdk.h.c.a a2, Throwable throwable) {
        ErrorReportingHelper.report(string, null, b2, a2, null, throwable);
    }

    public static void report(String string, b b2, Throwable throwable) {
        ErrorReportingHelper.report(string, null, b2, null, null, throwable);
    }

    public static void report(String string, String string2, b b2, com.adincube.sdk.h.c.a a2, Boolean bl, Throwable throwable) {
        ErrorReportingHelper.a(string, string2, b2, a2, bl, null, throwable);
    }

    public static void report(String string, String string2, b b2, com.adincube.sdk.h.c.a a2, Throwable throwable) {
        ErrorReportingHelper.a(string, string2, b2, a2, null, null, throwable);
    }

    public static void report(String string, String string2, b b2, Throwable throwable) {
        ErrorReportingHelper.a(string, string2, b2, null, null, null, throwable);
    }

    public static void report(String string, Throwable throwable) {
        ErrorReportingHelper.report(string, null, throwable);
    }
}

