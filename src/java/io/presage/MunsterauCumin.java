/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.net.Uri
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package io.presage;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.presage.cl;

public abstract class MunsterauCumin
extends WebViewClient {
    public WebResourceResponse a(WebView webView, String string2) {
        return null;
    }

    public void a(int n2, String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder("onReceivedError: ");
        stringBuilder.append(n2);
        stringBuilder.append(" description: ");
        stringBuilder.append(string2);
        stringBuilder.append(" failingUrl: ");
        stringBuilder.append(string3);
    }

    public boolean b(WebView webView, String string2) {
        return true;
    }

    public void onReceivedError(WebView webView, int n2, String string2, String string3) {
        this.a(n2, string2, string3);
    }

    @TargetApi(value=23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.a(webResourceError.getErrorCode(), webResourceError.getDescription().toString(), webResourceRequest.getUrl().toString());
    }

    @TargetApi(value=21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String string2 = webResourceRequest.getUrl().toString();
        cl.a((Object)string2, "request.url.toString()");
        return this.a(webView, string2);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String string2) {
        return this.a(webView, string2);
    }

    @TargetApi(value=21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        String string2 = webResourceRequest.getUrl().toString();
        cl.a((Object)string2, "request.url.toString()");
        return this.b(webView, string2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        return this.b(webView, string2);
    }
}

