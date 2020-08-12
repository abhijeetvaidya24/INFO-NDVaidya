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
package com.moat.analytics.mobile.tjy;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.moat.analytics.mobile.tjy.NativeDisplayTracker;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.base.exception.a;
import com.moat.analytics.mobile.tjy.bh;
import com.moat.analytics.mobile.tjy.bi;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class af
implements NativeDisplayTracker {
    private WebView a;
    private bh b;
    private final String c;
    private final ap d;
    private boolean e;

    public af(View view, String string, com.moat.analytics.mobile.tjy.a a2, ap ap2) {
        if (ap2.b()) {
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
        this.d = ap2;
        bi bi2 = new bi(view, this.a, true, a2, ap2);
        this.b = bi2;
        this.e = false;
    }

    private static String a(int n2, int n3, String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder("<!DOCTYPE html>\n<html>\n<head lang=\"en\">\n    <meta charset=\"UTF-8\">\n    <title></title>\n</head>\n<body style=\"margin:0;padding:0;\">\n<div id=\"mianahwvc\" style=\"width:");
        stringBuilder.append(n2);
        stringBuilder.append("px;height:");
        stringBuilder.append(n3);
        stringBuilder.append("px;\">\n    <script src=\"https://z.moatads.com/");
        stringBuilder.append(string);
        stringBuilder.append("/moatad.js#");
        stringBuilder.append(string2);
        stringBuilder.append("\" type=\"text/javascript\"></script>\n</div>\n</body>\n</html>");
        return stringBuilder.toString();
    }

    private static String a(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int n2 = 0;
        do {
            if (n2 >= 8) break;
            StringBuilder stringBuilder = new StringBuilder("moatClientLevel");
            stringBuilder.append(n2);
            String string = stringBuilder.toString();
            if (map.containsKey((Object)string)) {
                linkedHashMap.put((Object)string, map.get((Object)string));
            }
            ++n2;
        } while (true);
        for (int i2 = 0; i2 < 8; ++i2) {
            StringBuilder stringBuilder = new StringBuilder("moatClientSlicer");
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
        return String.valueOf((Object)stringBuilder);
    }

    private void a() {
        if (!this.e) {
            this.a("Shutting down.");
            this.b.d();
            this.a.loadUrl("about:blank");
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
    public boolean track(Map var1_1) {
        block4 : {
            var2_2 = false;
            if (var1_1 == null) ** GOTO lbl17
            try {
                if (!var1_1.isEmpty()) {
                    var2_2 = this.b.c();
                    if (var2_2) {
                        var8_3 = this.b.e();
                        var9_4 = var8_3.width();
                        var10_5 = var8_3.height();
                        var11_6 = af.a(var1_1);
                        var12_7 = new StringBuilder("Parsed ad ids = ");
                        var12_7.append(var11_6);
                        this.a(var12_7.toString());
                        var14_8 = af.a(var9_4, var10_5, this.c, var11_6);
                        this.a.loadData(var14_8, "text/html", "utf-8");
                    }
                    break block4;
                }
lbl17: // 3 sources:
                this.a("adIdMap is null or empty. Shutting down.");
                this.a();
                return false;
            }
            catch (Exception var3_9) {
                a.a(var3_9);
            }
        }
        var4_10 = new StringBuilder("Attempt to start tracking ad was ");
        var5_11 = var2_2 != false ? "" : "un";
        var4_10.append(var5_11);
        var4_10.append("successful.");
        this.a(var4_10.toString());
        return var2_2;
    }
}

