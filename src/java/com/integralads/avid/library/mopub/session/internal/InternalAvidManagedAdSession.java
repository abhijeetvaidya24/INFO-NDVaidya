/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.webkit.WebView
 *  java.lang.String
 */
package com.integralads.avid.library.mopub.session.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.mopub.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.mopub.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.mopub.session.internal.trackingwebview.AvidJavaScriptResourceInjector;
import com.integralads.avid.library.mopub.session.internal.trackingwebview.AvidTrackingWebViewManager;

public abstract class InternalAvidManagedAdSession
extends InternalAvidAdSession<View> {
    private AvidTrackingWebViewManager trackingWebViewManager;
    private final WebView webView;

    public InternalAvidManagedAdSession(Context context, String string, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        super(context, string, externalAvidAdSessionContext);
        this.webView = new WebView(context.getApplicationContext());
        this.trackingWebViewManager = new AvidTrackingWebViewManager(this.webView);
    }

    public AvidJavaScriptResourceInjector getJavaScriptResourceInjector() {
        return this.trackingWebViewManager;
    }

    @Override
    public WebView getWebView() {
        return this.webView;
    }

    @Override
    public void onStart() {
        super.onStart();
        this.updateWebViewManager();
        this.trackingWebViewManager.loadHTML();
    }
}

