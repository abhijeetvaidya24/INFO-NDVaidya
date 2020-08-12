/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.session.internal.trackingwebview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AvidWebViewClient
extends WebViewClient {
    private AvidWebViewClientListener a;

    public void onPageFinished(WebView webView, String string) {
        super.onPageFinished(webView, string);
        AvidWebViewClientListener avidWebViewClientListener = this.a;
        if (avidWebViewClientListener != null) {
            avidWebViewClientListener.webViewDidLoadData();
        }
    }

    public void setListener(AvidWebViewClientListener avidWebViewClientListener) {
        this.a = avidWebViewClientListener;
    }

    public static interface AvidWebViewClientListener {
        public void webViewDidLoadData();
    }

}

