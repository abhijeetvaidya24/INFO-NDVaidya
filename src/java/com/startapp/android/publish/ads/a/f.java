/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.startapp.android.publish.ads.a;

import android.os.Handler;
import android.webkit.WebView;
import com.startapp.android.publish.ads.a.c;
import com.startapp.android.publish.ads.a.f;

public class f
extends c {
    @Override
    public void a(WebView webView) {
        super.a(webView);
        if (this.g().equals((Object)"interstitial")) {
            webView.setBackgroundColor(0);
        }
    }

    @Override
    protected void c(WebView webView) {
        new Handler().postDelayed(new Runnable(this, webView){
            final /* synthetic */ WebView a;
            final /* synthetic */ f b;
            {
                this.b = f2;
                this.a = webView;
            }

            public void run() {
                try {
                    this.a.setBackgroundColor(0);
                }
                catch (java.lang.Exception exception) {}
            }
        }, 1000L);
    }
}

