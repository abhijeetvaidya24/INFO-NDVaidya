/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.graphics.Rect
 *  android.net.Uri
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnLongClickListener
 *  android.view.View$OnTouchListener
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebSettings$PluginState
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.applovin.impl.a.a
 *  com.applovin.impl.sdk.ad.a
 *  com.applovin.impl.sdk.ad.g
 *  com.applovin.impl.sdk.ad.i
 *  com.applovin.impl.sdk.b.b
 *  com.applovin.impl.sdk.c.d
 *  com.applovin.impl.sdk.e.e
 *  com.applovin.impl.sdk.e.j
 *  com.applovin.impl.sdk.e.m
 *  com.applovin.impl.sdk.j
 *  com.applovin.impl.sdk.p
 *  com.applovin.sdk.AppLovinAd
 *  java.lang.Boolean
 *  java.lang.CharSequence
 *  java.lang.Exception
 *  java.lang.IllegalArgumentException
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.Throwable
 */
package com.applovin.impl.adview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.impl.a.a;
import com.applovin.impl.a.b;
import com.applovin.impl.a.e;
import com.applovin.impl.adview.d;
import com.applovin.impl.adview.u;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.ad.i;
import com.applovin.impl.sdk.e.j;
import com.applovin.impl.sdk.e.m;
import com.applovin.impl.sdk.p;
import com.applovin.sdk.AppLovinAd;

class c
extends WebView {
    private final p a;
    private final com.applovin.impl.sdk.j b;
    private com.applovin.impl.sdk.c.d c;
    private AppLovinAd d = null;
    private String e = null;
    private boolean f = false;

    c(d d2, com.applovin.impl.sdk.j j2, Context context) {
        super(context);
        if (j2 != null) {
            this.b = j2;
            this.a = j2.u();
            this.setBackgroundColor(0);
            WebSettings webSettings = this.getSettings();
            webSettings.setSupportMultipleWindows(false);
            webSettings.setJavaScriptEnabled(true);
            this.setWebViewClient((WebViewClient)d2);
            this.setWebChromeClient((WebChromeClient)new com.applovin.impl.adview.b(j2));
            this.setVerticalScrollBarEnabled(false);
            this.setHorizontalScrollBarEnabled(false);
            this.setScrollBarStyle(33554432);
            this.setOnTouchListener(new View.OnTouchListener(){

                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (!view.hasFocus()) {
                        view.requestFocus();
                    }
                    return false;
                }
            });
            this.setOnLongClickListener(new View.OnLongClickListener(){

                public boolean onLongClick(View view) {
                    c.this.a.a("AdWebView", "Received a LongClick event.");
                    return true;
                }
            });
            return;
        }
        throw new IllegalArgumentException("No sdk specified.");
    }

    private String a(String string, String string2, String string3) {
        if (j.b((String)string)) {
            return m.a((String)string3, (String)string).replace((CharSequence)"{SOURCE}", (CharSequence)string2);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(final g g2) {
        try {
            Boolean bl;
            Boolean bl2;
            Boolean bl3;
            u u2;
            Boolean bl4;
            Boolean bl5;
            Integer n2;
            Boolean bl6;
            Boolean bl7;
            Boolean bl8;
            Boolean bl9;
            if (((Boolean)this.b.a(com.applovin.impl.sdk.b.b.fd)).booleanValue() || g2.ao()) {
                this.a(new Runnable(){

                    public void run() {
                        c.this.loadUrl("about:blank");
                    }
                });
            }
            if (com.applovin.impl.sdk.e.e.d()) {
                this.a(new Runnable(){

                    @TargetApi(value=17)
                    public void run() {
                        boolean bl = g2.an();
                        c.this.getSettings().setMediaPlaybackRequiresUserGesture(bl);
                    }
                });
            }
            if (com.applovin.impl.sdk.e.e.e() && g2.aq()) {
                this.a(new Runnable(){

                    @TargetApi(value=19)
                    public void run() {
                        WebView.setWebContentsDebuggingEnabled((boolean)true);
                    }
                });
            }
            if ((u2 = g2.ar()) == null) return;
            final WebSettings webSettings = this.getSettings();
            final WebSettings.PluginState pluginState = u2.b();
            if (pluginState != null) {
                this.a(new Runnable(){

                    public void run() {
                        webSettings.setPluginState(pluginState);
                    }
                });
            }
            if ((bl2 = u2.c()) != null) {
                this.a(new Runnable(){

                    public void run() {
                        webSettings.setAllowFileAccess(bl2.booleanValue());
                    }
                });
            }
            if ((bl6 = u2.d()) != null) {
                this.a(new Runnable(){

                    public void run() {
                        webSettings.setLoadWithOverviewMode(bl6.booleanValue());
                    }
                });
            }
            if ((bl8 = u2.e()) != null) {
                this.a(new Runnable(){

                    public void run() {
                        webSettings.setUseWideViewPort(bl8.booleanValue());
                    }
                });
            }
            if ((bl3 = u2.f()) != null) {
                this.a(new Runnable(){

                    public void run() {
                        webSettings.setAllowContentAccess(bl3.booleanValue());
                    }
                });
            }
            if ((bl4 = u2.g()) != null) {
                this.a(new Runnable(){

                    public void run() {
                        webSettings.setBuiltInZoomControls(bl4.booleanValue());
                    }
                });
            }
            if ((bl = u2.h()) != null) {
                this.a(new Runnable(){

                    public void run() {
                        webSettings.setDisplayZoomControls(bl.booleanValue());
                    }
                });
            }
            if ((bl5 = u2.i()) != null) {
                this.a(new Runnable(){

                    public void run() {
                        webSettings.setSaveFormData(bl5.booleanValue());
                    }
                });
            }
            if ((bl7 = u2.j()) != null) {
                this.a(new Runnable(){

                    public void run() {
                        webSettings.setGeolocationEnabled(bl7.booleanValue());
                    }
                });
            }
            if ((bl9 = u2.k()) != null) {
                this.a(new Runnable(){

                    public void run() {
                        webSettings.setNeedInitialFocus(bl9.booleanValue());
                    }
                });
            }
            if (com.applovin.impl.sdk.e.e.c()) {
                Boolean bl10;
                final Boolean bl11 = u2.l();
                if (bl11 != null) {
                    this.a(new Runnable(){

                        @TargetApi(value=16)
                        public void run() {
                            webSettings.setAllowFileAccessFromFileURLs(bl11.booleanValue());
                        }
                    });
                }
                if ((bl10 = u2.m()) != null) {
                    this.a(new Runnable(){

                        @TargetApi(value=16)
                        public void run() {
                            webSettings.setAllowUniversalAccessFromFileURLs(bl10.booleanValue());
                        }
                    });
                }
            }
            if (com.applovin.impl.sdk.e.e.f() && (n2 = u2.a()) != null) {
                this.a(new Runnable(){

                    @TargetApi(value=21)
                    public void run() {
                        webSettings.setMixedContentMode(n2.intValue());
                    }
                });
            }
            if (!com.applovin.impl.sdk.e.e.g()) return;
            final Boolean bl12 = u2.n();
            if (bl12 == null) return;
            this.a(new Runnable(){

                @TargetApi(value=23)
                public void run() {
                    webSettings.setOffscreenPreRaster(bl12.booleanValue());
                }
            });
            return;
        }
        catch (Throwable throwable) {
            this.a.b("AdWebView", "Unable to apply WebView settings", throwable);
        }
    }

    private void a(Runnable runnable) {
        try {
            runnable.run();
            return;
        }
        catch (Throwable throwable) {
            this.a.b("AdWebView", "Unable to apply WebView setting", throwable);
            return;
        }
    }

    private void a(String string, String string2, String string3, String string4, com.applovin.impl.sdk.j j2) {
        String string5 = this.a(string3, string, string4);
        if (j.b((String)string5)) {
            p p2 = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Rendering webview for VAST ad with resourceContents : ");
            stringBuilder.append(string5);
            p2.a("AdWebView", stringBuilder.toString());
            this.loadDataWithBaseURL(string2, string5, "text/html", null, "");
            return;
        }
        String string6 = this.a((String)j2.a(com.applovin.impl.sdk.b.b.eM), string, string4);
        if (j.b((String)string6)) {
            p p3 = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Rendering webview for VAST ad with resourceContents : ");
            stringBuilder.append(string6);
            p3.a("AdWebView", stringBuilder.toString());
            this.loadDataWithBaseURL(string2, string6, "text/html", null, "");
            return;
        }
        p p4 = this.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Rendering webview for VAST ad with resourceURL : ");
        stringBuilder.append(string);
        p4.a("AdWebView", stringBuilder.toString());
        this.loadUrl(string);
    }

    AppLovinAd a() {
        return this.d;
    }

    public void a(com.applovin.impl.sdk.c.d d2) {
        this.c = d2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(AppLovinAd appLovinAd, String string) {
        block7 : {
            if (this.f) break block7;
            this.d = appLovinAd;
            this.e = string;
            try {
                String string2;
                p p2;
                block9 : {
                    block11 : {
                        p p3;
                        String string3;
                        block13 : {
                            block18 : {
                                String string4;
                                String string5;
                                String string6;
                                String string7;
                                block16 : {
                                    g g2;
                                    String string8;
                                    String string9;
                                    block19 : {
                                        String string10;
                                        String string11;
                                        com.applovin.impl.sdk.j j2;
                                        block17 : {
                                            e e2;
                                            block14 : {
                                                block15 : {
                                                    block12 : {
                                                        block10 : {
                                                            block8 : {
                                                                if (!(appLovinAd instanceof i)) break block8;
                                                                this.loadDataWithBaseURL("/", ((i)appLovinAd).a(), "text/html", null, "");
                                                                p2 = this.a;
                                                                string2 = "Empty ad rendered";
                                                                break block9;
                                                            }
                                                            g2 = (g)appLovinAd;
                                                            this.a(g2);
                                                            if (g2.Z()) {
                                                                this.setVisibility(0);
                                                            }
                                                            if (!(appLovinAd instanceof com.applovin.impl.sdk.ad.a)) break block10;
                                                            String string12 = m.a((String)string, (String)((com.applovin.impl.sdk.ad.a)appLovinAd).a());
                                                            this.loadDataWithBaseURL(g2.ap(), string12, "text/html", null, "");
                                                            p2 = this.a;
                                                            string2 = "AppLovinAd rendered";
                                                            break block9;
                                                        }
                                                        if (!(appLovinAd instanceof a)) return;
                                                        a a2 = (a)appLovinAd;
                                                        b b2 = a2.d();
                                                        if (b2 == null) break block11;
                                                        e2 = b2.b();
                                                        Uri uri = e2.b();
                                                        String string13 = uri != null ? uri.toString() : "";
                                                        string10 = string13;
                                                        string8 = e2.c();
                                                        string9 = a2.j();
                                                        if (j.b((String)string10) || j.b((String)string8)) break block12;
                                                        p3 = this.a;
                                                        string3 = "Unable to load companion ad. No resources provided.";
                                                        break block13;
                                                    }
                                                    if (e2.a() == e.a.b) {
                                                        this.a.a("AdWebView", "Rendering WebView for static VAST ad");
                                                        String string14 = this.a((String)this.b.a(com.applovin.impl.sdk.b.b.eL), string10, string);
                                                        this.loadDataWithBaseURL(g2.ap(), string14, "text/html", null, "");
                                                        return;
                                                    }
                                                    if (e2.a() != e.a.d) break block14;
                                                    if (!j.b((String)string8)) break block15;
                                                    String string15 = this.a(string9, string8, string);
                                                    string7 = j.b((String)string15) ? string15 : string8;
                                                    p p4 = this.a;
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    stringBuilder.append("Rendering WebView for HTML VAST ad with resourceContents: ");
                                                    stringBuilder.append(string7);
                                                    p4.a("AdWebView", stringBuilder.toString());
                                                    string4 = g2.ap();
                                                    string6 = "text/html";
                                                    string5 = "";
                                                    break block16;
                                                }
                                                if (!j.b((String)string10)) return;
                                                this.a.a("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                                string11 = g2.ap();
                                                j2 = this.b;
                                                break block17;
                                            }
                                            if (e2.a() != e.a.c) break block18;
                                            if (!j.b((String)string10)) break block19;
                                            this.a.a("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                                            string11 = g2.ap();
                                            j2 = this.b;
                                        }
                                        this.a(string10, string11, string9, string, j2);
                                        return;
                                    }
                                    if (!j.b((String)string8)) return;
                                    String string16 = this.a(string9, string8, string);
                                    string7 = j.b((String)string16) ? string16 : string8;
                                    p p5 = this.a;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("Rendering WebView for iFrame VAST ad with resourceContents: ");
                                    stringBuilder.append(string7);
                                    p5.a("AdWebView", stringBuilder.toString());
                                    string4 = g2.ap();
                                    string6 = "text/html";
                                    string5 = "";
                                }
                                this.loadDataWithBaseURL(string4, string7, string6, null, string5);
                                return;
                            }
                            p3 = this.a;
                            string3 = "Failed to render VAST companion ad of invalid type";
                        }
                        p3.d("AdWebView", string3);
                        return;
                    }
                    p2 = this.a;
                    string2 = "No companion ad provided.";
                }
                p2.a("AdWebView", string2);
                return;
            }
            catch (Throwable throwable) {
                p p6 = this.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unable to render AppLovinAd with placement = \"");
                stringBuilder.append(string);
                stringBuilder.append("\"");
                p6.b("AdWebView", stringBuilder.toString(), throwable);
                return;
            }
        }
        this.a.e("AdWebView", "Ad can not be loaded in a destroyed webview");
    }

    public void a(String string) {
        this.a(string, null);
    }

    public void a(String string, Runnable runnable) {
        try {
            p p2 = this.a;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Forwarding \"");
            stringBuilder.append(string);
            stringBuilder.append("\" to ad template");
            p2.a("AdWebView", stringBuilder.toString());
            this.loadUrl(string);
            return;
        }
        catch (Throwable throwable) {
            this.a.b("AdWebView", "Unable to forward to template", throwable);
            if (runnable != null) {
                runnable.run();
            }
            return;
        }
    }

    String b() {
        return this.e;
    }

    public com.applovin.impl.sdk.c.d c() {
        return this.c;
    }

    public void computeScroll() {
    }

    public void destroy() {
        this.f = true;
        try {
            super.destroy();
            this.a.a("AdWebView", "Web view destroyed");
            return;
        }
        catch (Throwable throwable) {
            p p2 = this.a;
            if (p2 != null) {
                p2.b("AdWebView", "destroy() threw exception", throwable);
            }
            return;
        }
    }

    protected void onFocusChanged(boolean bl, int n2, Rect rect) {
        try {
            super.onFocusChanged(bl, n2, rect);
            return;
        }
        catch (Exception exception) {
            this.a.b("AdWebView", "onFocusChanged() threw exception", (Throwable)exception);
            return;
        }
    }

    protected void onScrollChanged(int n2, int n3, int n4, int n5) {
    }

    public void onWindowFocusChanged(boolean bl) {
        try {
            super.onWindowFocusChanged(bl);
            return;
        }
        catch (Exception exception) {
            this.a.b("AdWebView", "onWindowFocusChanged() threw exception", (Throwable)exception);
            return;
        }
    }

    protected void onWindowVisibilityChanged(int n2) {
        try {
            super.onWindowVisibilityChanged(n2);
            return;
        }
        catch (Exception exception) {
            this.a.b("AdWebView", "onWindowVisibilityChanged() threw exception", (Throwable)exception);
            return;
        }
    }

    public boolean requestFocus(int n2, Rect rect) {
        try {
            boolean bl = super.requestFocus(n2, rect);
            return bl;
        }
        catch (Exception exception) {
            this.a.b("AdWebView", "requestFocus() threw exception", (Throwable)exception);
            return false;
        }
    }

    public void scrollTo(int n2, int n3) {
    }

}

