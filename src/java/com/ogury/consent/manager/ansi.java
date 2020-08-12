/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.ogury.consent.manager;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ogury.consent.manager.fcharset0;
import com.ogury.consent.manager.tx6480;
import com.ogury.consent.manager.util.consent.ConsentException;
import com.ogury.consent.manager.util.consent.rtf1;

public final class ansi
extends WebViewClient {
    private final Context a;
    private final rtf1 b;

    public ansi(Context context, rtf1 rtf12) {
        tx6480.b((Object)context, "context");
        tx6480.b(rtf12, "consentCallback");
        this.a = context;
        this.b = rtf12;
    }

    private final void a(String string2) {
        rtf1 rtf12 = this.b;
        if (string2 == null) {
            string2 = "";
        }
        rtf12.a(new ConsentException("form-error", string2));
    }

    private final boolean a(String string2, WebView webView) {
        new fcharset0();
        fcharset0.a(string2, this.a, this.b, webView);
        return true;
    }

    public final void onReceivedError(WebView webView, int n2, String string2, String string3) {
        this.a(string2);
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        tx6480.b((Object)webView, "view");
        tx6480.b((Object)webResourceRequest, "request");
        tx6480.b((Object)webResourceError, "error");
        this.a(webResourceError.getDescription().toString());
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        tx6480.b((Object)webView, "view");
        tx6480.b((Object)webResourceRequest, "request");
        return null;
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String string2) {
        tx6480.b((Object)webView, "view");
        tx6480.b(string2, "url");
        return null;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        tx6480.b((Object)webView, "view");
        tx6480.b((Object)webResourceRequest, "request");
        String string2 = webResourceRequest.getUrl().toString();
        tx6480.a((Object)string2, "request.url.toString()");
        return this.a(string2, webView);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        tx6480.b((Object)webView, "view");
        tx6480.b(string2, "url");
        return this.a(string2, webView);
    }
}

