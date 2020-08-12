/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  java.lang.Object
 */
package com.startapp.android.publish.adsCommon.g.b;

import android.content.Context;
import android.webkit.WebView;
import com.startapp.android.publish.adsCommon.g.a.c;
import com.startapp.android.publish.adsCommon.g.b.b;

public final class a {
    public static void a(Context context, WebView webView, b b2) {
        if (b2 == null) {
            b2 = new b(context);
        }
        c.a(webView, "mraid.SUPPORTED_FEATURES.CALENDAR", b2.a());
        c.a(webView, "mraid.SUPPORTED_FEATURES.INLINEVIDEO", b2.b());
        c.a(webView, "mraid.SUPPORTED_FEATURES.SMS", b2.c());
        c.a(webView, "mraid.SUPPORTED_FEATURES.STOREPICTURE", b2.d());
        c.a(webView, "mraid.SUPPORTED_FEATURES.TEL", b2.e());
    }
}

