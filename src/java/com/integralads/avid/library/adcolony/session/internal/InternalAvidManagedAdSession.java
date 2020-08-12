/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.webkit.WebView
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.session.internal;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.integralads.avid.library.adcolony.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;
import com.integralads.avid.library.adcolony.session.internal.trackingwebview.AvidJavaScriptResourceInjector;
import com.integralads.avid.library.adcolony.session.internal.trackingwebview.AvidTrackingWebViewManager;

public abstract class InternalAvidManagedAdSession
extends InternalAvidAdSession<View> {
    private AvidTrackingWebViewManager a;
    private final WebView b;

    public InternalAvidManagedAdSession(Context context, String string, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        super(context, string, externalAvidAdSessionContext);
        this.b = new WebView(context.getApplicationContext());
        this.a = new AvidTrackingWebViewManager(this.b);
    }

    public AvidJavaScriptResourceInjector getJavaScriptResourceInjector() {
        return this.a;
    }

    @Override
    public WebView getWebView() {
        return this.b;
    }

    @Override
    public void onStart() {
        super.onStart();
        this.updateWebViewManager();
        this.a.loadHTML();
    }
}

