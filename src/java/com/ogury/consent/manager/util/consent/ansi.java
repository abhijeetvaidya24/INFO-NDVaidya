/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.util.Date
 */
package com.ogury.consent.manager.util.consent;

import android.webkit.WebView;
import com.ogury.consent.manager.green255;
import com.ogury.consent.manager.margl1440;
import com.ogury.consent.manager.margr1440;
import com.ogury.consent.manager.tx6480;
import java.util.Date;

public final class ansi {
    public static final ansi a = new ansi();
    private static green255 b = new green255();
    private static margr1440 c = new margr1440();
    private static margl1440 d = new margl1440();
    private static Date e = new Date();
    private static WebView f;

    private ansi() {
    }

    public static green255 a() {
        return b;
    }

    public static void a(long l2) {
        e.setTime(l2);
    }

    public static void a(WebView webView) {
        f = webView;
    }

    public static void a(Date date) {
        tx6480.b((Object)date, "<set-?>");
        e = date;
    }

    public static margr1440 b() {
        return c;
    }

    public static margl1440 c() {
        return d;
    }

    public static Date d() {
        return e;
    }

    public static WebView e() {
        return f;
    }

    public static void f() {
        b = new green255();
        c = new margr1440();
    }
}

