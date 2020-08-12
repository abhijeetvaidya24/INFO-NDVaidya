/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.System
 *  java.lang.ref.WeakReference
 *  java.util.LinkedList
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.tjy;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.moat.analytics.mobile.tjy.a;
import com.moat.analytics.mobile.tjy.ae;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.bh;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

class ad {
    protected final a a;
    protected final ap b;
    protected bh c;
    private final String d;
    private final String e;
    private WeakReference f;
    private WeakReference g;
    private WebView h;
    private boolean i;
    private boolean j;
    private final LinkedList k;

    ad(String string2, ap ap2, a a2) {
        this.d = string2;
        this.b = ap2;
        this.a = a2;
        Object[] arrobject = new Object[]{(int)(1.0E8 * Math.random())};
        this.e = String.format((String)"_moatTracker%d", (Object[])arrobject);
        this.k = new LinkedList();
        this.i = false;
        this.f = new WeakReference((Object)a2.c());
    }

    static /* synthetic */ boolean a(ad ad2) {
        return ad2.i;
    }

    static /* synthetic */ boolean a(ad ad2, boolean bl2) {
        ad2.i = bl2;
        return bl2;
    }

    static /* synthetic */ WeakReference b(ad ad2) {
        return ad2.g;
    }

    static /* synthetic */ WebView c(ad ad2) {
        return ad2.h;
    }

    void a() {
        if (this.k.size() >= 200) {
            LinkedList linkedList = new LinkedList();
            for (int i2 = 0; i2 < 10; ++i2) {
                linkedList.addFirst((Object)((String)this.k.removeFirst()));
            }
            int n2 = Math.min((int)(200 + Math.min((int)(this.k.size() / 200), (int)10)), (int)this.k.size());
            for (int i3 = 0; i3 < n2; ++i3) {
                this.k.removeFirst();
            }
            for (String string2 : linkedList) {
                this.k.addFirst((Object)string2);
            }
        }
        int n3 = 0;
        while (!this.k.isEmpty() && n3 < 200) {
            ++n3;
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl2 = true;
            while (!this.k.isEmpty() && n3 < 200) {
                ++n3;
                String string3 = (String)this.k.getFirst();
                if (stringBuilder.length() + string3.length() > 2000) break;
                this.k.removeFirst();
                if (bl2) {
                    bl2 = false;
                } else {
                    stringBuilder.append(",");
                }
                stringBuilder.append(string3);
            }
            Object[] arrobject = new Object[]{this.e, stringBuilder.toString()};
            this.a(String.format((String)"javascript:%s.dispatchMany([%s])", (Object[])arrobject));
        }
        this.k.clear();
    }

    public void a(View view) {
        this.g = new WeakReference((Object)view);
        bh bh2 = this.c;
        if (bh2 != null) {
            bh2.a(view);
        }
    }

    public void a(View view, Map map, Integer n2, Integer n3, Integer n4) {
        this.g = new WeakReference((Object)view);
        this.h = new WebView((Context)this.f.get());
        WebSettings webSettings = this.h.getSettings();
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
        this.h.setWebViewClient((WebViewClient)new ae(this));
        JSONObject jSONObject = new JSONObject(map);
        Object[] arrobject = new Object[]{"mianahwvc", n2, n3, "mianahwvc", System.currentTimeMillis(), this.e, this.d, jSONObject.toString(), n4};
        String string2 = String.format((String)"<html><head></head><body><div id=\"%s\" style=\"width: %dpx; height: %dpx;\"></div><script>(function initMoatTracking(apiname, pcode, ids, duration) {var events = [];window[pcode + '_moatElToTrack'] = document.getElementById('%s');var moatapi = {'dropTime':%d,'adData': {'ids': ids, 'duration': duration, 'url': 'n/a'},'dispatchEvent': function(ev) {if (this.sendEvent) {if (events) { events.push(ev); ev = events; events = false; }this.sendEvent(ev);} else {events.push(ev);}},'dispatchMany': function(evs){for (var i=0, l=evs.length; i<l; i++) {this.dispatchEvent(evs[i]);}}};Object.defineProperty(window, apiname, {'value': moatapi});var s = document.createElement('script');s.src = 'https://z.moatads.com/' + pcode + '/moatvideo.js?' + apiname + '#' + apiname;document.body.appendChild(s);})('%s', '%s', %s, %s);</script></body></html>", (Object[])arrobject);
        this.h.loadData(string2, "text/html", null);
    }

    void a(String string2) {
        this.h.loadUrl(string2);
    }

    public void a(JSONObject jSONObject) {
        String string2 = jSONObject.toString();
        if (this.i && this.h != null) {
            Object[] arrobject = new Object[]{this.e, string2};
            String string3 = String.format((String)"javascript:%s.dispatchEvent(%s);", (Object[])arrobject);
            this.h.loadUrl(string3);
            return;
        }
        this.k.add((Object)string2);
    }

    public void b() {
        if (!this.j) {
            WebView webView;
            bh bh2 = this.c;
            if (bh2 != null) {
                bh2.d();
                this.c = null;
            }
            if ((webView = this.h) != null) {
                webView.loadUrl("about:blank");
                this.h.destroy();
                this.h = null;
            }
            this.j = true;
        }
    }
}

