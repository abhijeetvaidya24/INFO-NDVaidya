/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.LinkedHashMap
 *  java.util.Map
 *  java.util.Set
 */
package com.moat.analytics.mobile.aer;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.moat.analytics.mobile.aer.NativeDisplayTracker;
import com.moat.analytics.mobile.aer.al;
import com.moat.analytics.mobile.aer.ba;
import com.moat.analytics.mobile.aer.base.exception.a;
import com.moat.analytics.mobile.aer.bb;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class ab
implements NativeDisplayTracker {
    private WebView a;
    private ba b;
    private final String c;
    private final al d;
    private boolean e;

    public ab(View view, String string, com.moat.analytics.mobile.aer.a a2, al al2) {
        if (al2.b()) {
            Log.d((String)"MoatNativeDispTracker", (String)"Initializing.");
        }
        this.c = string;
        this.a = new WebView(view.getContext());
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
        this.d = al2;
        bb bb2 = new bb(view, this.a, true, a2, al2);
        this.b = bb2;
        this.e = false;
    }

    private static String a(int n2, int n3, String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n    <meta charset=\"UTF-8\">\n    <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n<div id=\"mianahwvc\" style=\"width:");
        stringBuilder.append(n2);
        stringBuilder.append("px;height:");
        stringBuilder.append(n3);
        stringBuilder.append("px;\">\n");
        stringBuilder.append("    <script src=\"https://z.moatads.com/");
        stringBuilder.append(string);
        stringBuilder.append("/moatad.js#");
        stringBuilder.append(string2);
        stringBuilder.append("\" type=\"text/javascript\"></script>\n");
        stringBuilder.append("</div>\n");
        stringBuilder.append("</body>\n");
        stringBuilder.append("</html>");
        return stringBuilder.toString();
    }

    private static String a(Map<String, String> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int n2 = 0;
        do {
            if (n2 >= 8) break;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moatClientLevel");
            stringBuilder.append(n2);
            String string = stringBuilder.toString();
            if (map.containsKey((Object)string)) {
                linkedHashMap.put((Object)string, map.get((Object)string));
            }
            ++n2;
        } while (true);
        for (int i2 = 0; i2 < 8; ++i2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("moatClientSlicer");
            stringBuilder.append(i2);
            String string = stringBuilder.toString();
            if (!map.containsKey((Object)string)) continue;
            linkedHashMap.put((Object)string, map.get((Object)string));
        }
        for (String string : map.keySet()) {
            if (linkedHashMap.containsKey((Object)string)) continue;
            linkedHashMap.put((Object)string, (Object)((String)map.get((Object)string)));
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : linkedHashMap.keySet()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append("&");
            }
            String string2 = (String)linkedHashMap.get((Object)string);
            stringBuilder.append(string);
            stringBuilder.append('=');
            stringBuilder.append(string2);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("");
        stringBuilder2.append((Object)stringBuilder);
        return stringBuilder2.toString();
    }

    private void a() {
        if (!this.e) {
            this.a("Shutting down.");
            this.a.destroy();
            this.a = null;
            this.b = null;
            this.e = true;
        }
    }

    private void a(String string) {
        if (this.d.b()) {
            Object[] arrobject = new Object[]{this.hashCode(), string};
            Log.d((String)"MoatNativeDispTracker", (String)String.format((String)"id = %s, message = %s", (Object[])arrobject));
        }
    }

    @Override
    public void stopTracking() {
        this.a("Called stopTracking.");
        this.a();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public boolean track(Map<String, String> var1_1) {
        block4 : {
            var2_2 = false;
            if (var1_1 == null) ** GOTO lbl18
            try {
                if (!var1_1.isEmpty()) {
                    var2_2 = this.b.b();
                    if (var2_2) {
                        var9_3 = this.b.c();
                        var10_4 = var9_3.width();
                        var11_5 = var9_3.height();
                        var12_6 = ab.a(var1_1);
                        var13_7 = new StringBuilder();
                        var13_7.append("Parsed ad ids = ");
                        var13_7.append(var12_6);
                        this.a(var13_7.toString());
                        var16_8 = ab.a(var10_4, var11_5, this.c, var12_6);
                        this.a.loadData(var16_8, "text/html", "utf-8");
                    }
                    break block4;
                }
lbl18: // 3 sources:
                this.a("adIdMap is null or empty. Shutting down.");
                this.a();
                return false;
            }
            catch (Exception var3_9) {
                a.a(var3_9);
            }
        }
        var4_10 = new StringBuilder();
        var4_10.append("Attempt to start tracking ad was ");
        var6_11 = var2_2 != false ? "" : "un";
        var4_10.append(var6_11);
        var4_10.append("successful.");
        this.a(var4_10.toString());
        return var2_2;
    }
}

