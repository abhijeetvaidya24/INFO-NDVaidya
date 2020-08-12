/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.webkit.ValueCallback
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.util.Locale
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.mpub;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.mpub.j;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

class g {
    WebView a;
    j b;
    final String c;
    private final a d;
    private boolean e;
    private Handler f;
    private Runnable g;

    @SuppressLint(value={"SetJavaScriptEnabled"})
    g(Context context, a a2) {
        this.d = a2;
        this.e = false;
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{(int)(1.0E8 * Math.random())};
        this.c = String.format((Locale)locale, (String)"_moatTracker%d", (Object[])arrobject);
        this.a = new WebView(context);
        WebSettings webSettings = this.a.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowContentAccess(false);
        webSettings.setAllowFileAccess(false);
        webSettings.setDatabaseEnabled(false);
        webSettings.setDomStorageEnabled(false);
        webSettings.setGeolocationEnabled(false);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(false);
        webSettings.setSaveFormData(false);
        if (Build.VERSION.SDK_INT >= 16) {
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(1);
        }
        j.a a3 = j.a.b;
        if (a2 == a.b) {
            a3 = j.a.c;
        }
        try {
            this.b = new j(this.a, a3);
            return;
        }
        catch (m m2) {
            m.a(m2);
            return;
        }
    }

    private static String a(String string2, String string3, Integer n2, Integer n3, JSONObject jSONObject, Integer n4) {
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{"mianahwvc", n2, n3, "mianahwvc", System.currentTimeMillis(), string2, string3, jSONObject.toString(), n4};
        return String.format((Locale)locale, (String)"<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", (Object[])arrobject);
    }

    private static String b(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/");
        stringBuilder.append(string2);
        stringBuilder.append("/moatad.js\" type=\"text/javascript\"></script>\n</body>\n</html>");
        return stringBuilder.toString();
    }

    void a() {
        p.a(3, "GlobalWebView", this, "Cleaning up");
        this.b.b();
        this.b = null;
        this.a.destroy();
        this.a = null;
    }

    void a(String string2) {
        if (this.d == a.a) {
            this.a.setWebViewClient(new WebViewClient(){

                public void onPageFinished(WebView webView, String string2) {
                    if (!g.this.e) {
                        try {
                            g.this.e = true;
                            g.this.b.a();
                            return;
                        }
                        catch (Exception exception) {
                            m.a(exception);
                        }
                    }
                }
            });
            this.a.loadData(g.b(string2), "text/html", "utf-8");
        }
    }

    void a(String string2, Map<String, String> map, Integer n2, Integer n3, Integer n4) {
        if (this.d == a.b) {
            if (Build.VERSION.SDK_INT >= 19) {
                p.a(3, "GlobalWebView", this, "Starting off polling interval to check for Video API instance presence");
                this.f = new Handler();
                this.g = new Runnable(){

                    public void run() {
                        try {
                            if (g.this.a != null && Build.VERSION.SDK_INT >= 19) {
                                WebView webView = g.this.a;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("typeof ");
                                stringBuilder.append(g.this.c);
                                stringBuilder.append(" !== 'undefined'");
                                webView.evaluateJavascript(stringBuilder.toString(), (ValueCallback)new ValueCallback<String>(){

                                    public void a(String string2) {
                                        if ("true".equals((Object)string2)) {
                                            Object[] arrobject = new Object[]{g.this.c};
                                            p.a(3, "GlobalWebView", this, String.format((String)"Video API instance %s detected. Flushing event queue", (Object[])arrobject));
                                            try {
                                                g.this.e = true;
                                                g.this.b.a();
                                                g.this.b.c(g.this.c);
                                                return;
                                            }
                                            catch (Exception exception) {
                                                m.a(exception);
                                                return;
                                            }
                                        }
                                        g.this.f.postDelayed(g.this.g, 200L);
                                    }

                                    public /* synthetic */ void onReceiveValue(Object object) {
                                        this.a((String)object);
                                    }
                                });
                                return;
                            }
                        }
                        catch (Exception exception) {
                            m.a(exception);
                        }
                    }

                };
                this.f.post(this.g);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Android API version is less than KitKat: ");
                stringBuilder.append(Build.VERSION.SDK_INT);
                p.a(3, "GlobalWebView", this, stringBuilder.toString());
                this.a.setWebViewClient(new WebViewClient(){

                    public void onPageFinished(WebView webView, String string2) {
                        if (!g.this.e) {
                            p.a(3, "GlobalWebView", (Object)this, "onPageFinished is called for the first time. Flushing event queue");
                            try {
                                g.this.e = true;
                                g.this.b.a();
                                g.this.b.c(g.this.c);
                                return;
                            }
                            catch (Exception exception) {
                                m.a(exception);
                            }
                        }
                    }
                });
            }
            JSONObject jSONObject = new JSONObject(map);
            this.a.loadData(g.a(this.c, string2, n2, n3, jSONObject, n4), "text/html", null);
        }
    }

    static final class a
    extends Enum<a> {
        public static final /* enum */ a a = new a();
        public static final /* enum */ a b = new a();
        private static final /* synthetic */ a[] c;

        static {
            a[] arra = new a[]{a, b};
            c = arra;
        }

        public static a valueOf(String string2) {
            return (a)Enum.valueOf(a.class, (String)string2);
        }

        public static a[] values() {
            return (a[])c.clone();
        }
    }

}

