/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.graphics.Bitmap
 *  android.net.http.SslError
 *  android.os.Message
 *  android.view.InputEvent
 *  android.view.KeyEvent
 *  android.webkit.ClientCertRequest
 *  android.webkit.HttpAuthHandler
 *  android.webkit.SslErrorHandler
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.String
 */
package com.moat.analytics.mobile.aer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.aer.o;
import com.moat.analytics.mobile.aer.p;

class q
extends WebViewClient {
    private final WebViewClient a;
    private final p b;

    private q(WebViewClient webViewClient, p p2) {
        this.a = webViewClient;
        this.b = p2;
    }

    /* synthetic */ q(WebViewClient webViewClient, p p2, o o2) {
        this(webViewClient, p2);
    }

    public void doUpdateVisitedHistory(WebView webView, String string, boolean bl2) {
        this.a.doUpdateVisitedHistory(webView, string, bl2);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.a.onFormResubmission(webView, message, message2);
    }

    public void onLoadResource(WebView webView, String string) {
        this.a.onLoadResource(webView, string);
    }

    public void onPageFinished(WebView webView, String string) {
        this.a.onPageFinished(webView, string);
        p.a(this.b, webView);
    }

    public void onPageStarted(WebView webView, String string, Bitmap bitmap) {
        this.a.onPageStarted(webView, string, bitmap);
    }

    @TargetApi(value=21)
    public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        this.a.onReceivedClientCertRequest(webView, clientCertRequest);
    }

    public void onReceivedError(WebView webView, int n2, String string, String string2) {
        this.a.onReceivedError(webView, n2, string, string2);
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String string, String string2) {
        this.a.onReceivedHttpAuthRequest(webView, httpAuthHandler, string, string2);
    }

    public void onReceivedLoginRequest(WebView webView, String string, String string2, String string3) {
        this.a.onReceivedLoginRequest(webView, string, string2, string3);
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.a.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public void onScaleChanged(WebView webView, float f2, float f3) {
        this.a.onScaleChanged(webView, f2, f3);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        this.a.onTooManyRedirects(webView, message, message2);
    }

    @TargetApi(value=21)
    public void onUnhandledInputEvent(WebView webView, InputEvent inputEvent) {
        this.a.onUnhandledInputEvent(webView, inputEvent);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.a.onUnhandledKeyEvent(webView, keyEvent);
    }

    @TargetApi(value=21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return this.a.shouldInterceptRequest(webView, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String string) {
        return this.a.shouldInterceptRequest(webView, string);
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return this.a.shouldOverrideKeyEvent(webView, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
        return this.b.shouldOverrideUrlLoading(webView, string) || this.a.shouldOverrideUrlLoading(webView, string);
        {
        }
    }
}

