/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.net.URL
 */
package com.adincube.sdk.util;

import java.net.URL;

public final class y {
    private static boolean a = true;

    public static boolean a() {
        return a;
    }

    public static void b() {
        a = false;
    }

    public static URL c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y.l());
        stringBuilder.append("next");
        return new URL(stringBuilder.toString());
    }

    public static URL d() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y.l());
        stringBuilder.append("impression");
        return new URL(stringBuilder.toString());
    }

    public static URL e() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y.l());
        stringBuilder.append("report/event");
        return new URL(stringBuilder.toString());
    }

    public static URL f() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y.l());
        stringBuilder.append("report/loading_status");
        return new URL(stringBuilder.toString());
    }

    public static URL g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y.l());
        stringBuilder.append("report/fill_rate");
        return new URL(stringBuilder.toString());
    }

    public static URL h() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y.l());
        stringBuilder.append("report/liar_network");
        return new URL(stringBuilder.toString());
    }

    public static URL i() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y.l());
        stringBuilder.append("click");
        return new URL(stringBuilder.toString());
    }

    public static URL j() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y.l());
        stringBuilder.append("report/player_error");
        return new URL(stringBuilder.toString());
    }

    public static URL k() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(y.l());
        stringBuilder.append("report/auto_redirect");
        return new URL(stringBuilder.toString());
    }

    private static String l() {
        StringBuilder stringBuilder = new StringBuilder();
        String string = a ? "https://" : "http://";
        stringBuilder.append(string);
        stringBuilder.append("sdk.adincube.com/sdk/android/1.0/");
        return stringBuilder.toString();
    }
}

