/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.ConsoleMessage
 *  android.webkit.JsResult
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.applovin.impl.adview;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;

class b
extends WebChromeClient {
    private final p a;

    public b(j j2) {
        this.a = j2.u();
    }

    public void onConsoleMessage(String string, int n2, String string2) {
        p p2 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("console.log[");
        stringBuilder.append(n2);
        stringBuilder.append("] :");
        stringBuilder.append(string);
        p2.c("AdWebView", stringBuilder.toString());
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(consoleMessage.sourceId());
        stringBuilder.append(": ");
        stringBuilder.append(consoleMessage.lineNumber());
        stringBuilder.append(": ");
        stringBuilder.append(consoleMessage.message());
        String string = stringBuilder.toString();
        this.a.a("AdWebView", string);
        return true;
    }

    public boolean onJsAlert(WebView webView, String string, String string2, JsResult jsResult) {
        p p2 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Alert attempted: ");
        stringBuilder.append(string2);
        p2.c("AdWebView", stringBuilder.toString());
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String string, String string2, JsResult jsResult) {
        p p2 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JS onBeforeUnload attempted: ");
        stringBuilder.append(string2);
        p2.c("AdWebView", stringBuilder.toString());
        return true;
    }

    public boolean onJsConfirm(WebView webView, String string, String string2, JsResult jsResult) {
        p p2 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JS confirm attempted: ");
        stringBuilder.append(string2);
        p2.c("AdWebView", stringBuilder.toString());
        return true;
    }
}

