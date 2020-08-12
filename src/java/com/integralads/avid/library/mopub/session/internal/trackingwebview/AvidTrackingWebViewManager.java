/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.integralads.avid.library.mopub.weakreference.AvidWebView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.integralads.avid.library.mopub.session.internal.trackingwebview;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.integralads.avid.library.mopub.session.internal.trackingwebview.AvidJavaScriptResourceInjector;
import com.integralads.avid.library.mopub.session.internal.trackingwebview.AvidWebViewClient;
import com.integralads.avid.library.mopub.weakreference.AvidWebView;
import java.util.ArrayList;
import java.util.Iterator;

public class AvidTrackingWebViewManager
implements AvidJavaScriptResourceInjector,
AvidWebViewClient.AvidWebViewClientListener {
    private final AvidWebView avidWebView;
    private final ArrayList<String> pendingJavaScriptResources = new ArrayList();
    private int state = 0;
    private final AvidWebViewClient webViewClient;

    public AvidTrackingWebViewManager(WebView webView) {
        this.avidWebView = new AvidWebView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        this.webViewClient = new AvidWebViewClient();
        this.webViewClient.setListener(this);
        webView.setWebViewClient((WebViewClient)this.webViewClient);
    }

    private void doInjectJavaScriptResource(String string) {
        String string2 = "(function () {\nvar script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);\n})();".replace((CharSequence)"%SCRIPT_SRC%", (CharSequence)string);
        this.avidWebView.injectJavaScript(string2);
    }

    @Override
    public void injectJavaScriptResource(String string) {
        if (this.state == 2) {
            this.doInjectJavaScriptResource(string);
            return;
        }
        this.pendingJavaScriptResources.add((Object)string);
    }

    public void loadHTML() {
        WebView webView = (WebView)this.avidWebView.get();
        if (webView != null && this.state == 0) {
            this.state = 1;
            webView.loadData("<html><body></body></html>", "text/html", null);
        }
    }

    @Override
    public void webViewDidLoadData() {
        this.state = 2;
        Iterator iterator = this.pendingJavaScriptResources.iterator();
        while (iterator.hasNext()) {
            this.doInjectJavaScriptResource((String)iterator.next());
        }
        this.pendingJavaScriptResources.clear();
    }
}

