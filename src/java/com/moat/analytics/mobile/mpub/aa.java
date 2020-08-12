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
package com.moat.analytics.mobile.mpub;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.mpub.WebAdTracker;
import com.moat.analytics.mobile.mpub.ab;
import com.moat.analytics.mobile.mpub.b;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import java.lang.ref.WeakReference;

class aa
extends b
implements WebAdTracker {
    aa(ViewGroup viewGroup) {
        this(ab.a(viewGroup, false).c(null));
        if (viewGroup == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WebAdTracker initialization not successful, ");
            stringBuilder.append("Target ViewGroup is null");
            p.a("[ERROR] ", 3, "WebAdTracker", this, stringBuilder.toString());
            this.a = new m("Target ViewGroup is null");
        }
        if (this.b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WebAdTracker initialization not successful, ");
            stringBuilder.append("No WebView to track inside of ad container");
            p.a("[ERROR] ", 3, "WebAdTracker", this, stringBuilder.toString());
            this.a = new m("No WebView to track inside of ad container");
        }
    }

    aa(WebView webView) {
        super((View)webView, false, false);
        p.a(3, "WebAdTracker", this, "Initializing.");
        if (webView == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WebAdTracker initialization not successful, ");
            stringBuilder.append("WebView is null");
            p.a("[ERROR] ", 3, "WebAdTracker", this, stringBuilder.toString());
            this.a = new m("WebView is null");
            return;
        }
        try {
            super.a(webView);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a());
            stringBuilder.append(" created for ");
            stringBuilder.append(this.g());
            p.a("[SUCCESS] ", stringBuilder.toString());
            return;
        }
        catch (m m2) {
            this.a = m2;
            return;
        }
    }

    @Override
    String a() {
        return "WebAdTracker";
    }
}

