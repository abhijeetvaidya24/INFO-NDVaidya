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
 *  com.moat.analytics.mobile.ogury.e
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
package com.moat.analytics.mobile.ogury;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.f;
import com.moat.analytics.mobile.ogury.l;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

final class d
implements ValueCallback<String> {
    private Handler \u02bc;
    private Runnable \u02bd;
    private boolean \u02ca;
    f \u02cb;
    WebView \u02ce;
    private final int \u02cf;
    final String \u0971;

    @SuppressLint(value={"SetJavaScriptEnabled"})
    d(Context context, int n2) {
        this.\u02cf = n2;
        this.\u02ca = false;
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{(int)(1.0E8 * Math.random())};
        this.\u0971 = String.format((Locale)locale, (String)"_moatTracker%d", (Object[])arrobject);
        this.\u02ce = new WebView(context);
        WebSettings webSettings = this.\u02ce.getSettings();
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
        int n3 = f.a.\u02cf;
        if (n2 == b.\u0971) {
            n3 = f.a.\u02ce;
        }
        try {
            this.\u02cb = new f(this.\u02ce, n3);
            return;
        }
        catch (l l2) {
            l.\u0971(l2);
            return;
        }
    }

    public final /* synthetic */ void onReceiveValue(Object object) {
        if ("true".equals((Object)((String)object))) {
            Object[] arrobject = new Object[]{this.\u0971};
            e.1.\u02cb(3, "GlobalWebView", this, String.format((String)"Video API instance %s detected. Flushing event queue", (Object[])arrobject));
            try {
                this.\u02ca = true;
                this.\u02cb.\u02ca();
                this.\u02cb.\u02ca(this.\u0971);
                return;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                return;
            }
        }
        this.\u02bc.postDelayed(this.\u02bd, 200L);
    }

    public final void run() {
        try {
            if (this.\u02ce != null && Build.VERSION.SDK_INT >= 19) {
                WebView webView = this.\u02ce;
                StringBuilder stringBuilder = new StringBuilder("typeof ");
                stringBuilder.append(this.\u0971);
                stringBuilder.append(" !== 'undefined'");
                webView.evaluateJavascript(stringBuilder.toString(), (ValueCallback)this);
            }
            return;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
    }

    final void \u02cb(String string2) {
        if (this.\u02cf == b.\u02cf) {
            this.\u02ce.setWebViewClient(new WebViewClient(this){
                private /* synthetic */ d \u02ca;
                {
                    this.\u02ca = d2;
                }

                public final void onPageFinished(WebView webView, String string2) {
                    if (!this.\u02ca.\u02ca) {
                        try {
                            this.\u02ca.\u02ca = true;
                            this.\u02ca.\u02cb.\u02ca();
                            return;
                        }
                        catch (Exception exception) {
                            l.\u0971(exception);
                        }
                    }
                }
            });
            WebView webView = this.\u02ce;
            StringBuilder stringBuilder = new StringBuilder("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/");
            stringBuilder.append(string2);
            stringBuilder.append("/moatad.js\" type=\"text/javascript\"></script>\n</body>\n</html>");
            webView.loadData(stringBuilder.toString(), "text/html", "utf-8");
        }
    }

    final void \u02cf(String string2, Map<String, String> map, Integer n2, Integer n3, Integer n4) {
        if (this.\u02cf == b.\u0971) {
            if (Build.VERSION.SDK_INT >= 19) {
                e.1.\u02cb(3, "GlobalWebView", this, "Starting off polling interval to check for Video API instance presence");
                this.\u02bc = new Handler();
                this.\u02bd = this;
                this.\u02bc.post(this.\u02bd);
            } else {
                StringBuilder stringBuilder = new StringBuilder("Android API version is less than KitKat: ");
                stringBuilder.append(Build.VERSION.SDK_INT);
                e.1.\u02cb(3, "GlobalWebView", this, stringBuilder.toString());
                this.\u02ce.setWebViewClient(new WebViewClient(this){
                    private /* synthetic */ d \u02ca;
                    {
                        this.\u02ca = d2;
                    }

                    public final void onPageFinished(WebView webView, String string2) {
                        if (!this.\u02ca.\u02ca) {
                            e.1.\u02cb(3, "GlobalWebView", (Object)this, "onPageFinished is called for the first time. Flushing event queue");
                            try {
                                this.\u02ca.\u02ca = true;
                                this.\u02ca.\u02cb.\u02ca();
                                this.\u02ca.\u02cb.\u02ca(this.\u02ca.\u0971);
                                return;
                            }
                            catch (Exception exception) {
                                l.\u0971(exception);
                            }
                        }
                    }
                });
            }
            JSONObject jSONObject = new JSONObject(map);
            WebView webView = this.\u02ce;
            String string3 = this.\u0971;
            Locale locale = Locale.ROOT;
            Object[] arrobject = new Object[]{"mianahwvc", n2, n3, "mianahwvc", System.currentTimeMillis(), string3, string2, jSONObject.toString(), n4};
            webView.loadData(String.format((Locale)locale, (String)"<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", (Object[])arrobject), "text/html", null);
        }
    }

    static final class b
    extends Enum<b> {
        private static final /* synthetic */ int[] \u02ca;
        public static final int \u02cf = 1;
        public static final int \u0971 = 2;

        static {
            \u02ca = new int[]{1, 2};
        }

        public static int[] values$5b4351f2() {
            return (int[])\u02ca.clone();
        }
    }

}

