/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.moat.analytics.mobile.aer;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.an;
import com.moat.analytics.mobile.aer.az;
import com.moat.analytics.mobile.aer.base.exception.a;
import com.moat.analytics.mobile.aer.m;
import com.moat.analytics.mobile.aer.o;

class p
extends WebViewClient {
    private final String a;
    private final m b;
    private final al c;

    private p(String string, m m2, al al2) {
        this.c = al2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(":");
        this.a = stringBuilder.toString();
        this.b = m2;
    }

    /* synthetic */ p(String string, m m2, al al2, o o2) {
        this(string, m2, al2);
    }

    private void a(WebView webView) {
        try {
            if (this.c.a() == an.a) {
                return;
            }
            if (this.c.b()) {
                Log.d((String)"MoatJavaScriptBridge", (String)"Ready for communication (setting environment variables).");
            }
            Object[] arrobject = new Object[]{this.b.a()};
            webView.loadUrl(String.format((String)"javascript:(function() { window.__zMoatInit__ = window.__zMoatInit__ || true;window.MoatMAK = window.MoatMAK || %s; })()", (Object[])arrobject));
            return;
        }
        catch (Exception exception) {
            if (this.c.b()) {
                Log.e((String)"MoatJavaScriptBridge", (String)"Failed to initialize communication (did not set environment variables).", (Throwable)exception);
            }
            return;
        }
    }

    private void a(WebView webView, String string) {
        if (this.c.a() == an.a) {
            return;
        }
        String string2 = string.substring(this.a.length());
        az az2 = this.b.a(string2);
        if (!az2.a()) {
            String string3 = az2.b();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("javascript:");
            stringBuilder.append(string3);
            webView.loadUrl(stringBuilder.toString());
        }
    }

    static /* synthetic */ void a(p p2, WebView webView) {
        p2.a(webView);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
        if (string == null) {
            string = "";
        }
        try {
            if (!string.startsWith(this.a)) {
                return super.shouldOverrideUrlLoading(webView, string);
            }
            this.a(webView, string);
            return true;
        }
        catch (Exception exception) {
            a.a(exception);
            return false;
        }
    }
}

