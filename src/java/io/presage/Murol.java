/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.ViewParent
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.io.File
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.ViewParent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import io.presage.an;
import io.presage.cc;
import io.presage.cl;
import java.io.File;

public final class Murol {
    @SuppressLint(value={"SetJavaScriptEnabled"})
    public static final void a(WebView webView) {
        webView.getSettings().setAppCacheEnabled(true);
        Context context = webView.getContext();
        cl.a((Object)context, "context");
        File file = context.getCacheDir();
        String string2 = file != null ? file.getAbsolutePath() : null;
        if (string2 != null) {
            webView.getSettings().setAppCachePath(string2);
        }
        WebSettings webSettings = webView.getSettings();
        cl.a((Object)webSettings, "settings");
        webSettings.setJavaScriptEnabled(true);
        WebSettings webSettings2 = webView.getSettings();
        cl.a((Object)webSettings2, "settings");
        webSettings2.setDomStorageEnabled(true);
    }

    public static final void a(WebView webView, final cc<an> cc2) {
        if (webView.getHeight() <= 0 && webView.getWidth() <= 0) {
            webView.post(new Runnable(){

                public final void run() {
                    cc2.a_();
                }
            });
            return;
        }
        cc2.a_();
    }

    public static final void b(WebView webView) {
        webView.setHorizontalScrollBarEnabled(false);
        webView.setVerticalScrollBarEnabled(false);
        webView.setScrollContainer(false);
    }

    public static final void c(WebView webView) {
        if (Build.VERSION.SDK_INT >= 17) {
            WebSettings webSettings = webView.getSettings();
            cl.a((Object)webSettings, "settings");
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        }
    }

    public static final void d(WebView webView) {
        if (!Murol.e(webView)) {
            webView.destroy();
        }
    }

    private static boolean e(WebView webView) {
        if (Build.VERSION.SDK_INT >= 19) {
            return webView.isAttachedToWindow();
        }
        return webView.getParent() != null;
    }

}

