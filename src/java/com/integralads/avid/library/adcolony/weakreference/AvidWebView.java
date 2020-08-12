/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.weakreference;

import android.webkit.WebView;
import com.integralads.avid.library.adcolony.utils.AvidCommand;
import com.integralads.avid.library.adcolony.weakreference.AvidView;

public class AvidWebView
extends AvidView<WebView> {
    public AvidWebView(WebView webView) {
        super(webView);
    }

    public void injectFormattedJavaScript(String string) {
        WebView webView = (WebView)this.get();
        if (webView != null) {
            webView.loadUrl(string);
        }
    }

    public void injectJavaScript(String string) {
        this.injectFormattedJavaScript(AvidCommand.formatJavaScript(string));
    }
}

