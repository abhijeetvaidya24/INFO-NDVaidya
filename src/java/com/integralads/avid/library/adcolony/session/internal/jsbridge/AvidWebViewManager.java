/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  com.integralads.avid.library.adcolony.weakreference.AvidWebView
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.session.internal.jsbridge;

import android.webkit.WebView;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.adcolony.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.adcolony.session.internal.jsbridge.AvidJavascriptInterface;
import com.integralads.avid.library.adcolony.weakreference.AvidWebView;

public class AvidWebViewManager
implements AvidJavascriptInterface.AvidJavascriptInterfaceCallback {
    private final InternalAvidAdSessionContext a;
    private final AvidWebView b = new AvidWebView(null);
    private final AvidBridgeManager c;
    private AvidJavascriptInterface d;

    public AvidWebViewManager(InternalAvidAdSessionContext internalAvidAdSessionContext, AvidBridgeManager avidBridgeManager) {
        this.a = internalAvidAdSessionContext;
        this.c = avidBridgeManager;
    }

    private void b() {
        AvidJavascriptInterface avidJavascriptInterface = this.d;
        if (avidJavascriptInterface != null) {
            avidJavascriptInterface.setCallback(null);
            this.d = null;
        }
    }

    public void destroy() {
        this.setWebView(null);
    }

    @Override
    public void onAvidAdSessionContextInvoked() {
        this.c.setWebView((WebView)this.b.get());
    }

    public void setWebView(WebView webView) {
        if (this.b.get() == webView) {
            return;
        }
        this.c.setWebView(null);
        this.b();
        this.b.set((Object)webView);
        if (webView != null) {
            this.d = new AvidJavascriptInterface(this.a);
            this.d.setCallback(this);
            webView.addJavascriptInterface((Object)this.d, "avid");
        }
    }
}

