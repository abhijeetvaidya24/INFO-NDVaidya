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
package com.moat.analytics.mobile.cha;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.cha.WebAdTracker;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.d;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.x;
import java.lang.ref.WeakReference;

final class v
extends d
implements WebAdTracker {
    v(ViewGroup viewGroup) {
        this(x.\u02ca(viewGroup, false).orElse(null));
        if (viewGroup == null) {
            StringBuilder stringBuilder = new StringBuilder("WebAdTracker initialization not successful, ");
            stringBuilder.append("Target ViewGroup is null");
            String string = stringBuilder.toString();
            a.\u02cf(3, "WebAdTracker", this, string);
            a.\u02ca("[ERROR] ", string);
            this.\u0971 = new o("Target ViewGroup is null");
        }
        if (this.\u02cf == null) {
            StringBuilder stringBuilder = new StringBuilder("WebAdTracker initialization not successful, ");
            stringBuilder.append("No WebView to track inside of ad container");
            String string = stringBuilder.toString();
            a.\u02cf(3, "WebAdTracker", this, string);
            a.\u02ca("[ERROR] ", string);
            this.\u0971 = new o("No WebView to track inside of ad container");
        }
    }

    v(WebView webView) {
        super((View)webView, false, false);
        a.\u02cf(3, "WebAdTracker", this, "Initializing.");
        if (webView == null) {
            StringBuilder stringBuilder = new StringBuilder("WebAdTracker initialization not successful, ");
            stringBuilder.append("WebView is null");
            String string = stringBuilder.toString();
            a.\u02cf(3, "WebAdTracker", this, string);
            a.\u02ca("[ERROR] ", string);
            this.\u0971 = new o("WebView is null");
            return;
        }
        try {
            super.\u0971(webView);
            StringBuilder stringBuilder = new StringBuilder("WebAdTracker created for ");
            stringBuilder.append(this.\u02bb());
            a.\u02ca("[SUCCESS] ", stringBuilder.toString());
            return;
        }
        catch (o o2) {
            this.\u0971 = o2;
            return;
        }
    }

    @Override
    final String \u02cb() {
        return "WebAdTracker";
    }
}

