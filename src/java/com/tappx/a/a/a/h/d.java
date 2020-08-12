/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.Window
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  com.tappx.a.a.a.h.d$2
 *  com.tappx.a.a.b.g
 *  com.tappx.a.a.b.g$c
 *  com.tappx.sdk.android.PrivacyConsentActivity
 *  java.io.File
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.util.Locale
 *  java.util.concurrent.TimeUnit
 */
package com.tappx.a.a.a.h;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.tappx.a.a.a.h.d;
import com.tappx.a.a.a.h.e;
import com.tappx.a.a.a.h.g;
import com.tappx.a.a.a.h.h;
import com.tappx.a.a.b.g;
import com.tappx.sdk.android.PrivacyConsentActivity;
import java.io.File;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class d {
    private static final String a = "GR8QbFbIwPD6k5hAnMxS6Za9cNsNHXXZzG7GWfNC";
    private static final String b = "kuutYDJOjEGYmzrvCGMIZqwyDXtIZYWxcXzXexLx";
    private static final String c = "tappx://consent?yes";
    private static final String d = "tappx://consent?no";
    private static final String e = "tappx://close";
    private static final long f = 0L;
    private static final String g = "EN";
    private final g h;
    private com.tappx.a.a.b.g i;
    private final PrivacyConsentActivity j;
    private WebView k;
    private final e l;
    private g.c m = new 2(this);
    private final WebViewClient n = new WebViewClient(){

        public void onPageFinished(WebView webView, String string2) {
            super.onPageFinished(webView, string2);
        }

        public void onPageStarted(WebView webView, String string2, Bitmap bitmap) {
            super.onPageStarted(webView, string2, bitmap);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
            if (d.c.equals((Object)string2)) {
                d.this.h.c();
                return true;
            }
            if (d.d.equals((Object)string2)) {
                d.this.h.d();
                return true;
            }
            if (d.e.equals((Object)string2)) {
                d.this.j();
                return true;
            }
            if (!TextUtils.isEmpty((CharSequence)string2)) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse((String)string2));
                d.this.j.startActivity(intent);
            }
            return super.shouldOverrideUrlLoading(webView, string2);
        }
    };

    static {
        f = TimeUnit.SECONDS.toMillis(4L);
    }

    public d(PrivacyConsentActivity privacyConsentActivity) {
        this.j = privacyConsentActivity;
        h h2 = h.a((Context)privacyConsentActivity);
        this.h = h2.a();
        this.l = h2.c();
    }

    public static Intent a(Context context, String string2, String string3) {
        Intent intent = new Intent(context, PrivacyConsentActivity.class);
        intent.putExtra(a, string2);
        intent.putExtra(b, string3);
        return intent;
    }

    private void c() {
        String string2 = this.j.getIntent().getStringExtra(b);
        String string3 = this.d();
        if (string2 != null && !string2.isEmpty()) {
            this.k.loadDataWithBaseURL("https://tappx.com/", string2, "text/html", "UTF-8", null);
            return;
        }
        if (string3 != null) {
            this.k.loadUrl(string3);
            return;
        }
        this.j.finish();
    }

    private String d() {
        String string2 = this.j.getIntent().getStringExtra(a);
        if (string2 == null) {
            return null;
        }
        return Uri.parse((String)string2).buildUpon().appendQueryParameter(com.tappx.a.a.a.h.a("Atea2vjkWMaKJqXPDr3CPg"), this.e()).build().toString();
    }

    private String e() {
        String string2;
        Locale locale = Locale.getDefault();
        if (locale != null && (string2 = locale.getLanguage()) != null) {
            return string2.toUpperCase();
        }
        return g;
    }

    private void f() {
        this.j.requestWindowFeature(1);
        this.j.getWindow().addFlags(1024);
        View view = this.h();
        this.j.setContentView(view);
        this.g();
    }

    private void g() {
        this.i.setCloseEnabled(false);
        this.i.setCloseListener(this.m);
        this.i.postDelayed(new Runnable(){

            public void run() {
                d.this.i.setCloseEnabled(true);
            }
        }, f);
    }

    private View h() {
        this.i = new com.tappx.a.a.b.g((Context)this.j);
        this.k = this.i();
        this.i.addView((View)this.k, 0, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
        return this.i;
    }

    private WebView i() {
        WebView webView = new WebView((Context)this.j);
        webView.setVerticalScrollBarEnabled(false);
        webView.setHorizontalScrollBarEnabled(false);
        WebSettings webSettings = webView.getSettings();
        webSettings.setSupportZoom(false);
        webSettings.setBuiltInZoomControls(false);
        webSettings.setLoadsImagesAutomatically(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCachePath(this.j.getCacheDir().getAbsolutePath());
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowContentAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            webView.setId(View.generateViewId());
        }
        webView.setWebViewClient(this.n);
        return webView;
    }

    private void j() {
        this.j.finish();
    }

    public void a(Bundle bundle) {
        this.f();
        this.c();
    }

    public boolean a() {
        return true ^ this.i.b();
    }

    public void b() {
        this.l.c();
    }

}

