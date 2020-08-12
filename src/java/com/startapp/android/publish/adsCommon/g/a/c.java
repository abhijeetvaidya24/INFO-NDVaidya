/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.startapp.android.publish.adsCommon.g.a;

import android.content.Context;
import android.webkit.WebView;
import com.startapp.android.publish.adsCommon.Utils.h;
import com.startapp.android.publish.adsCommon.Utils.i;
import com.startapp.android.publish.adsCommon.g.a.d;
import com.startapp.common.a.g;

public final class c {
    public static void a(Context context, int n2, int n3, int n4, int n5, WebView webView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setCurrentPosition [");
        stringBuilder.append(n2);
        stringBuilder.append(",");
        stringBuilder.append(n3);
        stringBuilder.append("] (");
        stringBuilder.append(n4);
        stringBuilder.append("x");
        stringBuilder.append(n5);
        stringBuilder.append(")");
        g.a("MraidJsFunctions", 3, stringBuilder.toString());
        Object[] arrobject = new Object[]{h.b(context, n2), h.b(context, n3), h.b(context, n4), h.b(context, n5)};
        i.a(webView, "mraid.setCurrentPosition", arrobject);
    }

    public static void a(Context context, int n2, int n3, WebView webView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setScreenSize ");
        stringBuilder.append(n2);
        stringBuilder.append("x");
        stringBuilder.append(n3);
        g.a("MraidJsFunctions", 3, stringBuilder.toString());
        Object[] arrobject = new Object[]{h.b(context, n2), h.b(context, n3)};
        i.a(webView, "mraid.setScreenSize", arrobject);
    }

    public static void a(WebView webView) {
        g.a("MraidJsFunctions", 3, "fireReadyEvent");
        i.a(webView, "mraid.fireReadyEvent", new Object[0]);
    }

    public static void a(WebView webView, String string, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setSupports feature: ");
        stringBuilder.append(string);
        stringBuilder.append(", isSupported:");
        stringBuilder.append(bl);
        g.a("MraidJsFunctions", 3, stringBuilder.toString());
        Object[] arrobject = new Object[]{string, bl};
        i.a(webView, false, "mraid.setSupports", arrobject);
    }

    public static void a(WebView webView, boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fireViewableChangeEvent ");
        stringBuilder.append(bl);
        g.a("MraidJsFunctions", 3, stringBuilder.toString());
        Object[] arrobject = new Object[]{bl};
        i.a(webView, "mraid.fireViewableChangeEvent", arrobject);
    }

    public static void a(d d2, WebView webView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fireStateChangeEvent: ");
        stringBuilder.append((Object)d2);
        g.a("MraidJsFunctions", 3, stringBuilder.toString());
        Object[] arrobject = new Object[]{d2.toString()};
        i.a(webView, "mraid.fireStateChangeEvent", arrobject);
    }

    public static void a(String string, WebView webView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setPlacementType: ");
        stringBuilder.append(string);
        g.a("MraidJsFunctions", 3, stringBuilder.toString());
        i.a(webView, "mraid.setPlacementType", string);
    }

    public static void b(Context context, int n2, int n3, int n4, int n5, WebView webView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setDefaultPosition [");
        stringBuilder.append(n2);
        stringBuilder.append(",");
        stringBuilder.append(n3);
        stringBuilder.append("] (");
        stringBuilder.append(n4);
        stringBuilder.append("x");
        stringBuilder.append(n5);
        stringBuilder.append(")");
        g.a("MraidJsFunctions", 3, stringBuilder.toString());
        Object[] arrobject = new Object[]{h.b(context, n2), h.b(context, n3), h.b(context, n4), h.b(context, n5)};
        i.a(webView, "mraid.setDefaultPosition", arrobject);
    }

    public static void b(Context context, int n2, int n3, WebView webView) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setMaxSize ");
        stringBuilder.append(n2);
        stringBuilder.append("x");
        stringBuilder.append(n3);
        g.a("MraidJsFunctions", 3, stringBuilder.toString());
        Object[] arrobject = new Object[]{h.b(context, n2), h.b(context, n3)};
        i.a(webView, "mraid.setMaxSize", arrobject);
    }
}

