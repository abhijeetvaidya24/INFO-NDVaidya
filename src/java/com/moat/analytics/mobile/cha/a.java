/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Application
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.moat.analytics.mobile.cha.f
 *  java.lang.Class
 *  java.lang.Enum
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.Throwable
 *  java.util.Locale
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.cha;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.cha.MoatAnalytics;
import com.moat.analytics.mobile.cha.f;
import com.moat.analytics.mobile.cha.j;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.t;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

final class a {
    final String \u02ca;
    WebView \u02cb;
    private boolean \u02ce;
    j \u02cf;
    private final int \u0971;

    a() {
    }

    @SuppressLint(value={"SetJavaScriptEnabled"})
    a(Application application, int n2) {
        this.\u0971 = n2;
        this.\u02ce = false;
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{(int)(1.0E8 * Math.random())};
        this.\u02ca = String.format((Locale)locale, (String)"_moatTracker%d", (Object[])arrobject);
        this.\u02cb = new WebView((Context)application);
        WebSettings webSettings = this.\u02cb.getSettings();
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
        int n3 = j.e.\u02ce;
        if (n2 == d.\u02cb) {
            n3 = j.e.\u02cb;
        }
        try {
            this.\u02cf = new j(this.\u02cb, n3);
            return;
        }
        catch (o o2) {
            o.\u02ce(o2);
            return;
        }
    }

    static void \u02ca(String string, String string2) {
        if (!t.\u02cf().\u02cf && ((f)MoatAnalytics.getInstance()).\u02ce) {
            int n2 = 2;
            if (string.equals((Object)"[ERROR] ")) {
                n2 = 6;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(string2);
            Log.println((int)n2, (String)"MoatAnalytics", (String)stringBuilder.toString());
        }
    }

    static String \u02cf(View view) {
        if (view != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(view.getClass().getSimpleName());
            stringBuilder.append("@");
            stringBuilder.append(view.hashCode());
            return stringBuilder.toString();
        }
        return "null";
    }

    static void \u02cf(int n2, String string, Object object, String string2) {
        if (t.\u02cf().\u02cf) {
            if (object == null) {
                StringBuilder stringBuilder = new StringBuilder("Moat");
                stringBuilder.append(string);
                Log.println((int)n2, (String)stringBuilder.toString(), (String)String.format((String)"message = %s", (Object[])new Object[]{string2}));
                return;
            }
            StringBuilder stringBuilder = new StringBuilder("Moat");
            stringBuilder.append(string);
            String string3 = stringBuilder.toString();
            Object[] arrobject = new Object[]{object.hashCode(), string2};
            Log.println((int)n2, (String)string3, (String)String.format((String)"id = %s, message = %s", (Object[])arrobject));
        }
    }

    static void \u02cf(String string, Object object, String string2) {
        if (t.\u02cf().\u02cb) {
            StringBuilder stringBuilder = new StringBuilder("Moat");
            stringBuilder.append(string);
            String string3 = stringBuilder.toString();
            Object[] arrobject = new Object[2];
            String string4 = object == null ? "null" : Integer.valueOf((int)object.hashCode());
            arrobject[0] = string4;
            arrobject[1] = string2;
            Log.println((int)2, (String)string3, (String)String.format((String)"id = %s, message = %s", (Object[])arrobject));
        }
    }

    static void \u0971(String string, Object object, String string2, Exception exception) {
        if (t.\u02cf().\u02cf) {
            StringBuilder stringBuilder = new StringBuilder("Moat");
            stringBuilder.append(string);
            String string3 = stringBuilder.toString();
            Object[] arrobject = new Object[]{object.hashCode(), string2};
            Log.e((String)string3, (String)String.format((String)"id = %s, message = %s", (Object[])arrobject), (Throwable)exception);
        }
    }

    final void \u02ca(String string) {
        if (this.\u0971 == d.\u02cf) {
            this.\u02cb.setWebViewClient(new WebViewClient(this){
                private /* synthetic */ a \u02cb;
                {
                    this.\u02cb = a2;
                }

                public final void onPageFinished(WebView webView, String string) {
                    if (!this.\u02cb.\u02ce) {
                        try {
                            this.\u02cb.\u02ce = true;
                            this.\u02cb.\u02cf.\u02cf();
                            return;
                        }
                        catch (Exception exception) {
                            o.\u02ce(exception);
                        }
                    }
                }
            });
            WebView webView = this.\u02cb;
            StringBuilder stringBuilder = new StringBuilder("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n   <meta charset=\"UTF-8\">\n   <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n    <script src=\"https://z.moatads.com/");
            stringBuilder.append(string);
            stringBuilder.append("/moatad.js\" type=\"text/javascript\"></script>\n</body>\n</html>");
            webView.loadData(stringBuilder.toString(), "text/html", "utf-8");
        }
    }

    final void \u02ca(String string, Map<String, String> map, Integer n2, Integer n3, Integer n4) {
        if (this.\u0971 == d.\u02cb) {
            this.\u02cb.setWebViewClient(new WebViewClient(this){
                private /* synthetic */ a \u02ca;
                {
                    this.\u02ca = a2;
                }

                public final void onPageFinished(WebView webView, String string) {
                    if (!this.\u02ca.\u02ce) {
                        try {
                            this.\u02ca.\u02ce = true;
                            this.\u02ca.\u02cf.\u02cf();
                            this.\u02ca.\u02cf.\u02ce(this.\u02ca.\u02ca);
                            return;
                        }
                        catch (Exception exception) {
                            o.\u02ce(exception);
                        }
                    }
                }
            });
            JSONObject jSONObject = new JSONObject(map);
            WebView webView = this.\u02cb;
            String string2 = this.\u02ca;
            Locale locale = Locale.ROOT;
            Object[] arrobject = new Object[]{"mianahwvc", n2, n3, "mianahwvc", System.currentTimeMillis(), string2, string, jSONObject.toString(), n4};
            webView.loadData(String.format((Locale)locale, (String)"<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", (Object[])arrobject), "text/html", null);
        }
    }

    static final class d
    extends Enum<d> {
        public static final int \u02cb = 2;
        public static final int \u02cf = 1;

        static {
            int[] arrn = new int[]{1, 2};
        }
    }

}

