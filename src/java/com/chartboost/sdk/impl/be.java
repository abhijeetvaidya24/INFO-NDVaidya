/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.lang.String
 *  java.util.Map
 */
package com.chartboost.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.chartboost.sdk.impl.bd;
import java.util.Map;

public class be
extends WebView {
    private bd a;
    private boolean b = false;

    public be(Context context) {
        super(context);
    }

    private void a() {
        if (!this.b) {
            this.b = true;
        }
    }

    public void loadData(String string, String string2, String string3) {
        this.a();
        super.loadData(string, string2, string3);
    }

    public void loadDataWithBaseURL(String string, String string2, String string3, String string4, String string5) {
        this.a();
        super.loadDataWithBaseURL(string, string2, string3, string4, string5);
    }

    public void loadUrl(String string) {
        this.a();
        super.loadUrl(string);
    }

    public void loadUrl(String string, Map<String, String> map) {
        this.a();
        super.loadUrl(string, map);
    }

    @SuppressLint(value={"SetJavaScriptEnabled"})
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        WebSettings webSettings = this.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setAllowContentAccess(true);
        if (Build.VERSION.SDK_INT >= 17) {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
        webSettings.setBuiltInZoomControls(false);
        webSettings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT >= 19) {
            be.setWebContentsDebuggingEnabled((boolean)true);
        }
        if (webChromeClient instanceof bd) {
            this.a = (bd)webChromeClient;
        }
        super.setWebChromeClient(webChromeClient);
    }
}

