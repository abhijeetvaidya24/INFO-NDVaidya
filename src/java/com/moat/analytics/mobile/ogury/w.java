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
package com.moat.analytics.mobile.ogury;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.WebAdTracker;
import com.moat.analytics.mobile.ogury.c;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.u;
import java.lang.ref.WeakReference;

final class w
extends c
implements WebAdTracker {
    w(ViewGroup viewGroup) {
        this(u.\u02ce(viewGroup, false).orElse(null));
        if (viewGroup == null) {
            String string = "WebAdTracker initialization not successful, ".concat("Target ViewGroup is null");
            e.1.\u02cb(3, "WebAdTracker", this, string);
            e.1.\u0971("[ERROR] ", string);
            this.\u02ce = new l("Target ViewGroup is null");
        }
        if (this.\u02ca == null) {
            String string = "WebAdTracker initialization not successful, ".concat("No WebView to track inside of ad container");
            e.1.\u02cb(3, "WebAdTracker", this, string);
            e.1.\u0971("[ERROR] ", string);
            this.\u02ce = new l("No WebView to track inside of ad container");
        }
    }

    w(WebView webView) {
        super((View)webView, false, false);
        e.1.\u02cb(3, "WebAdTracker", this, "Initializing.");
        if (webView == null) {
            String string = "WebAdTracker initialization not successful, ".concat("WebView is null");
            e.1.\u02cb(3, "WebAdTracker", this, string);
            e.1.\u0971("[ERROR] ", string);
            this.\u02ce = new l("WebView is null");
            return;
        }
        try {
            super.\u02cb(webView);
            StringBuilder stringBuilder = new StringBuilder("WebAdTracker created for ");
            stringBuilder.append(this.\u02bb());
            e.1.\u0971("[SUCCESS] ", stringBuilder.toString());
            return;
        }
        catch (l l2) {
            this.\u02ce = l2;
            return;
        }
    }

    @Override
    final String \u02cf() {
        return "WebAdTracker";
    }
}

