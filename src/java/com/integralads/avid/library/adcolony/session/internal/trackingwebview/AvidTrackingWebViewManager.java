/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.integralads.avid.library.adcolony.weakreference.AvidWebView
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 *  java.util.ArrayList
 *  java.util.Iterator
 */
package com.integralads.avid.library.adcolony.session.internal.trackingwebview;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.integralads.avid.library.adcolony.session.internal.trackingwebview.AvidJavaScriptResourceInjector;
import com.integralads.avid.library.adcolony.session.internal.trackingwebview.AvidWebViewClient;
import com.integralads.avid.library.adcolony.weakreference.AvidWebView;
import java.util.ArrayList;
import java.util.Iterator;

public class AvidTrackingWebViewManager
implements AvidJavaScriptResourceInjector,
AvidWebViewClient.AvidWebViewClientListener {
    private final AvidWebView h;
    private final AvidWebViewClient i;
    private int j = 0;
    private final ArrayList<String> k = new ArrayList();

    public AvidTrackingWebViewManager(WebView webView) {
        this.h = new AvidWebView(webView);
        webView.getSettings().setJavaScriptEnabled(true);
        this.i = new AvidWebViewClient();
        this.i.setListener(this);
        webView.setWebViewClient((WebViewClient)this.i);
    }

    private void a(String string) {
        String string2 = "(function () {\nvar script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);\n})();".replace((CharSequence)"%SCRIPT_SRC%", (CharSequence)string);
        this.h.injectJavaScript(string2);
    }

    @Override
    public void injectJavaScriptResource(String string) {
        if (this.j == 2) {
            this.a(string);
            return;
        }
        this.k.add((Object)string);
    }

    public void loadHTML() {
        WebView webView = (WebView)this.h.get();
        if (webView != null && this.j == 0) {
            this.j = 1;
            webView.loadData("<html><body></body></html>", "text/html", null);
        }
    }

    @Override
    public void webViewDidLoadData() {
        this.j = 2;
        Iterator iterator = this.k.iterator();
        while (iterator.hasNext()) {
            this.a((String)iterator.next());
        }
        this.k.clear();
    }
}

