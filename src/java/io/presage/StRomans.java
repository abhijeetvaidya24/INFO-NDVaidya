/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.webkit.CookieManager
 *  android.webkit.DownloadListener
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.io.File
 *  java.lang.Object
 *  java.lang.String
 */
package io.presage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import io.presage.TommeduJura;
import io.presage.cl;
import java.io.File;

public final class StRomans {
    @SuppressLint(value={"SetJavaScriptEnabled"})
    public static final void a(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        cl.a((Object)webSettings, "settings");
        webSettings.setJavaScriptEnabled(true);
        WebSettings webSettings2 = webView.getSettings();
        cl.a((Object)webSettings2, "settings");
        webSettings2.setBuiltInZoomControls(true);
        WebSettings webSettings3 = webView.getSettings();
        cl.a((Object)webSettings3, "settings");
        webSettings3.setDisplayZoomControls(false);
        WebSettings webSettings4 = webView.getSettings();
        cl.a((Object)webSettings4, "settings");
        webSettings4.setUseWideViewPort(true);
        WebSettings webSettings5 = webView.getSettings();
        cl.a((Object)webSettings5, "settings");
        webSettings5.setLoadWithOverviewMode(true);
        WebSettings webSettings6 = webView.getSettings();
        cl.a((Object)webSettings6, "settings");
        webSettings6.setDomStorageEnabled(true);
        WebSettings webSettings7 = webView.getSettings();
        cl.a((Object)webSettings7, "settings");
        webSettings7.setDatabaseEnabled(true);
        webView.getSettings().setSupportMultipleWindows(true);
        WebSettings webSettings8 = webView.getSettings();
        cl.a((Object)webSettings8, "settings");
        webSettings8.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
            WebSettings webSettings9 = webView.getSettings();
            cl.a((Object)webSettings9, "settings");
            webSettings9.setMixedContentMode(2);
        }
        if (Build.VERSION.SDK_INT <= 19) {
            WebSettings webSettings10 = webView.getSettings();
            cl.a((Object)webSettings10, "settings");
            File file = webView.getContext().getDir("webviewdatabase", 0);
            cl.a((Object)file, "context.getDir(WEB_DB_PATH, Context.MODE_PRIVATE)");
            webSettings10.setDatabasePath(file.getPath());
        }
        if (Build.VERSION.SDK_INT <= 18) {
            WebSettings webSettings11 = webView.getSettings();
            cl.a((Object)webSettings11, "settings");
            webSettings11.setSavePassword(true);
        }
        WebSettings webSettings12 = webView.getSettings();
        cl.a((Object)webSettings12, "settings");
        webSettings12.setLoadsImagesAutomatically(true);
        if (Build.VERSION.SDK_INT >= 17) {
            WebSettings webSettings13 = webView.getSettings();
            cl.a((Object)webSettings13, "settings");
            webSettings13.setMediaPlaybackRequiresUserGesture(false);
        }
        WebSettings webSettings14 = webView.getSettings();
        cl.a((Object)webSettings14, "settings");
        webSettings14.setSaveFormData(true);
        webView.getSettings().setSupportZoom(true);
        Context context = webView.getContext();
        cl.a((Object)context, "this.context");
        webView.setDownloadListener((DownloadListener)new TommeduJura(context));
    }

    public static final String b(WebView webView) {
        String string2;
        Object object = webView.getTag();
        if (!(object instanceof String)) {
            object = null;
        }
        if ((string2 = (String)object) == null) {
            string2 = "";
        }
        return string2;
    }
}

