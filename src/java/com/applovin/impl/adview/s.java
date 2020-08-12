/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.String
 */
package com.applovin.impl.adview;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.adview.t;

public class s
extends WebView {
    public s(t t2, Context context) {
        super(context);
        this.setBackgroundColor(0);
        WebSettings webSettings = this.getSettings();
        webSettings.setSupportMultipleWindows(false);
        webSettings.setJavaScriptEnabled(true);
        this.setWebViewClient((WebViewClient)t2);
        this.setWebChromeClient(new WebChromeClient());
        this.setVerticalScrollBarEnabled(false);
        this.setHorizontalScrollBarEnabled(false);
        this.setScrollBarStyle(33554432);
    }

    public void a(String string) {
        this.loadDataWithBaseURL("/", string, "text/html", null, "");
    }
}

