/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.tappx.a.a.b.a.f$1$1
 *  com.tappx.a.a.b.af
 *  com.tappx.a.a.b.ak
 *  com.tappx.a.a.b.c
 *  com.tappx.a.a.b.o
 *  com.tappx.a.a.b.o$b
 *  com.tappx.a.a.b.x
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b.a;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tappx.a.a.b.a.d;
import com.tappx.a.a.b.a.f;
import com.tappx.a.a.b.af;
import com.tappx.a.a.b.ak;
import com.tappx.a.a.b.c;
import com.tappx.a.a.b.o;
import com.tappx.a.a.b.x;

public class f {
    private WebView a;

    private void a(Context context, String string2, final d.a a2, boolean bl2) {
        this.b();
        c c2 = new c(context);
        final boolean bl3 = bl2 ^ true;
        this.a = c2;
        c2.a(false);
        c2.b();
        if (bl2) {
            x x2 = new x(context);
            x2.a((WebView)c2);
            string2 = x2.a(string2);
        }
        String string3 = string2;
        c2.setWebViewClient(new WebViewClient(){
            private final ak d = new ak();

            public void onPageFinished(WebView webView, String string2) {
                d.a a22;
                if (!bl3 && (a22 = a2) != null) {
                    a22.a();
                }
            }

            public void onReceivedError(WebView webView, int n2, String string2, String string3) {
                d.a a22;
                super.onReceivedError(webView, n2, string2, string3);
                if (!bl3 && (a22 = a2) != null) {
                    a22.b();
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
                if (bl3) {
                    this.d.a(string2, (o.b)new 1(this));
                }
                return true;
            }
        });
        c2.loadDataWithBaseURL(null, string3, "text/html", "UTF-8", null);
    }

    private void b() {
        WebView webView = this.a;
        if (webView != null) {
            webView.destroy();
            this.a = null;
        }
    }

    public void a() {
        this.b();
    }

    public void a(Context context, String string2, d.a a2) {
        if (af.a((String)string2)) {
            this.a(context, string2, null, true);
            a2.a();
            return;
        }
        this.a(context, string2, a2, false);
    }

}

