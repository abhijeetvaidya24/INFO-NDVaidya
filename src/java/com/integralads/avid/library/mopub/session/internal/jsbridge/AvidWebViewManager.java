/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.webkit.WebView
 *  com.integralads.avid.library.mopub.weakreference.AvidWebView
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session.internal.jsbridge;

import android.webkit.WebView;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidBridgeManager;
import com.integralads.avid.library.mopub.session.internal.jsbridge.AvidJavascriptInterface;
import com.integralads.avid.library.mopub.weakreference.AvidWebView;

public class AvidWebViewManager
implements AvidJavascriptInterface.AvidJavascriptInterfaceCallback {
    private final InternalAvidAdSessionContext avidAdSessionContext;
    private final AvidBridgeManager avidBridgeManager;
    private final AvidWebView avidWebView = new AvidWebView(null);
    private AvidJavascriptInterface javascriptInterface;

    public AvidWebViewManager(InternalAvidAdSessionContext internalAvidAdSessionContext, AvidBridgeManager avidBridgeManager) {
        this.avidAdSessionContext = internalAvidAdSessionContext;
        this.avidBridgeManager = avidBridgeManager;
    }

    private void clearJavascriptInterface() {
        AvidJavascriptInterface avidJavascriptInterface = this.javascriptInterface;
        if (avidJavascriptInterface != null) {
            avidJavascriptInterface.setCallback(null);
            this.javascriptInterface = null;
        }
    }

    public void destroy() {
        this.setWebView(null);
    }

    @Override
    public void onAvidAdSessionContextInvoked() {
        this.avidBridgeManager.setWebView((WebView)this.avidWebView.get());
    }

    public void setWebView(WebView webView) {
        if (this.avidWebView.get() == webView) {
            return;
        }
        this.avidBridgeManager.setWebView(null);
        this.clearJavascriptInterface();
        this.avidWebView.set((Object)webView);
        if (webView != null) {
            this.javascriptInterface = new AvidJavascriptInterface(this.avidAdSessionContext);
            this.javascriptInterface.setCallback(this);
            webView.addJavascriptInterface((Object)this.javascriptInterface, "avid");
        }
    }
}

