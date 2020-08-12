/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 */
package com.integralads.avid.library.adcolony.session.internal;

import android.content.Context;
import android.webkit.WebView;
import com.integralads.avid.library.adcolony.session.ExternalAvidAdSessionContext;
import com.integralads.avid.library.adcolony.session.internal.InternalAvidAdSession;

public abstract class InternalAvidHtmlAdSession
extends InternalAvidAdSession<WebView> {
    public InternalAvidHtmlAdSession(Context context, String string, ExternalAvidAdSessionContext externalAvidAdSessionContext) {
        super(context, string, externalAvidAdSessionContext);
    }

    @Override
    public WebView getWebView() {
        return (WebView)this.getView();
    }

    @Override
    protected void onViewRegistered() {
        super.onViewRegistered();
        this.updateWebViewManager();
    }
}

