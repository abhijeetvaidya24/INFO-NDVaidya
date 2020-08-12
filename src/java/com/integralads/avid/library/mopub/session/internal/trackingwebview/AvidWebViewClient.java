/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session.internal.trackingwebview;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AvidWebViewClient
extends WebViewClient {
    private AvidWebViewClientListener listener;

    public AvidWebViewClientListener getListener() {
        return this.listener;
    }

    public void onPageFinished(WebView webView, String string) {
        super.onPageFinished(webView, string);
        AvidWebViewClientListener avidWebViewClientListener = this.listener;
        if (avidWebViewClientListener != null) {
            avidWebViewClientListener.webViewDidLoadData();
        }
    }

    public void setListener(AvidWebViewClientListener avidWebViewClientListener) {
        this.listener = avidWebViewClientListener;
    }

    public static interface AvidWebViewClientListener {
        public void webViewDidLoadData();
    }

}

