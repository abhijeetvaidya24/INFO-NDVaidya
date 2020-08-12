/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.applovin.impl.adview;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.adview.s;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.p;
import java.lang.ref.WeakReference;

public class t
extends WebViewClient {
    private final p a;
    private WeakReference<a> b;

    public t(j j2) {
        this.a = j2.u();
    }

    private void a(WebView webView, String string) {
        p p2 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Processing click on ad URL \"");
        stringBuilder.append(string);
        stringBuilder.append("\"");
        p2.b("WebViewButtonClient", stringBuilder.toString());
        if (string != null && webView instanceof s) {
            s s2 = (s)webView;
            Uri uri = Uri.parse((String)string);
            String string2 = uri.getScheme();
            String string3 = uri.getHost();
            String string4 = uri.getPath();
            a a2 = (a)this.b.get();
            if ("applovin".equalsIgnoreCase(string2) && "com.applovin.sdk".equalsIgnoreCase(string3) && a2 != null) {
                if ("/track_click".equals((Object)string4)) {
                    a2.a(s2);
                    return;
                }
                if ("/close_ad".equals((Object)string4)) {
                    a2.b(s2);
                    return;
                }
                if ("/skip_ad".equals((Object)string4)) {
                    a2.c(s2);
                    return;
                }
                p p3 = this.a;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Unknown URL: ");
                stringBuilder2.append(string);
                p3.c("WebViewButtonClient", stringBuilder2.toString());
                p p4 = this.a;
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Path: ");
                stringBuilder3.append(string4);
                p4.c("WebViewButtonClient", stringBuilder3.toString());
            }
        }
    }

    public void a(WeakReference<a> weakReference) {
        this.b = weakReference;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
        this.a(webView, string);
        return true;
    }

    public static interface a {
        public void a(s var1);

        public void b(s var1);

        public void c(s var1);
    }

}

