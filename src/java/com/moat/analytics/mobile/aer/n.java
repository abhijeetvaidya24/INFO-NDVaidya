/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.util.Pair
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.aer;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.base.functional.a;
import com.moat.analytics.mobile.aer.be;
import com.moat.analytics.mobile.aer.bf;
import com.moat.analytics.mobile.aer.bg;
import com.moat.analytics.mobile.aer.l;
import com.moat.analytics.mobile.aer.m;
import com.moat.analytics.mobile.aer.o;
import com.moat.analytics.mobile.aer.p;
import com.moat.analytics.mobile.aer.q;

class n
implements l {
    private final be a;
    private final al b;

    n(Context context, al al2) {
        this.b = al2;
        this.a = new bg(context);
    }

    @Override
    public boolean a(String string, WebView webView, m m2) {
        boolean bl2 = this.b.b();
        if (!webView.getSettings().getJavaScriptEnabled()) {
            if (bl2) {
                Log.e((String)"MoatJavaScriptBridge", (String)"JavaScript is not enabled in the given WebView. Can't track.");
            }
            return false;
        }
        Pair<bf, a<WebViewClient>> pair = this.a.a(webView);
        bf bf2 = (bf)((Object)pair.first);
        a a2 = (a)pair.second;
        if (bf2 == bf.b) {
            if (bl2) {
                Log.e((String)"MoatJavaScriptBridge", (String)"Could not wrap existing WebViewClient transparently.");
            }
            return false;
        }
        p p2 = new p(string, m2, this.b, null);
        p.a(p2, webView);
        if (a2.c()) {
            webView.setWebViewClient((WebViewClient)new q((WebViewClient)a2.b(), p2, null));
        } else {
            webView.setWebViewClient((WebViewClient)p2);
        }
        return true;
    }
}

