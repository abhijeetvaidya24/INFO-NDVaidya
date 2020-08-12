/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.iro;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.WebAdTracker;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.c;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.v;
import java.lang.ref.WeakReference;

final class x
extends c
implements WebAdTracker {
    x(ViewGroup viewGroup) {
        this(v.\u02cb(viewGroup, false).orElse(null));
        if (viewGroup == null) {
            StringBuilder stringBuilder = new StringBuilder("WebAdTracker initialization not successful, ");
            stringBuilder.append("Target ViewGroup is null");
            String string = stringBuilder.toString();
            b.\u02cf(3, "WebAdTracker", this, string);
            b.\u02ce("[ERROR] ", string);
            this.\u02cb = new o("Target ViewGroup is null");
        }
        if (this.\u0971 == null) {
            StringBuilder stringBuilder = new StringBuilder("WebAdTracker initialization not successful, ");
            stringBuilder.append("No WebView to track inside of ad container");
            String string = stringBuilder.toString();
            b.\u02cf(3, "WebAdTracker", this, string);
            b.\u02ce("[ERROR] ", string);
            this.\u02cb = new o("No WebView to track inside of ad container");
        }
    }

    x(WebView webView) {
        super((View)webView, false, false);
        b.\u02cf(3, "WebAdTracker", this, "Initializing.");
        if (webView == null) {
            StringBuilder stringBuilder = new StringBuilder("WebAdTracker initialization not successful, ");
            stringBuilder.append("WebView is null");
            String string = stringBuilder.toString();
            b.\u02cf(3, "WebAdTracker", this, string);
            b.\u02ce("[ERROR] ", string);
            this.\u02cb = new o("WebView is null");
            return;
        }
        try {
            super.\u02cb(webView);
            StringBuilder stringBuilder = new StringBuilder("WebAdTracker created for ");
            stringBuilder.append(this.\u02bd());
            b.\u02ce("[SUCCESS] ", stringBuilder.toString());
            return;
        }
        catch (o o2) {
            this.\u02cb = o2;
            return;
        }
    }

    @Override
    final String \u02ca() {
        return "WebAdTracker";
    }
}

