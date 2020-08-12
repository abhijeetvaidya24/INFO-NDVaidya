/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.tapjoy.TJAdUnitJSBridge
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.mraid.view.BasicWebView
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.HashSet
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.view.BasicWebView;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public class TJSplitWebView
extends RelativeLayout {
    private BasicWebView a;
    private double[] b = new double[]{0.0, 0.0, 0.0, 0.0};
    private double[] c = new double[]{0.0, 0.0, 0.0, 0.0};
    private String d;
    private String e;
    private HashSet f;
    private TJAdUnitJSBridge g;

    public TJSplitWebView(final Context context, JSONObject jSONObject, JSONArray jSONArray, TJAdUnitJSBridge tJAdUnitJSBridge) {
        super(context);
        this.g = tJAdUnitJSBridge;
        this.setLayoutOption(jSONObject);
        this.setExitHosts(jSONArray);
        this.a = new BasicWebView(context);
        this.a.setBackgroundColor(-1);
        WebSettings webSettings = this.a.getSettings();
        if (webSettings != null) {
            webSettings.setUseWideViewPort(true);
        }
        this.a.setWebViewClient(new WebViewClient(){

            public final void onReceivedError(WebView webView, int n2, String string, String string2) {
                StringBuilder stringBuilder = new StringBuilder("onReceivedError: ");
                stringBuilder.append(string2);
                stringBuilder.append(" firstUrl:");
                stringBuilder.append(TJSplitWebView.this.d);
                TapjoyLog.d((String)"TJSplitWebView", (String)stringBuilder.toString());
                if (string2.equals((Object)TJSplitWebView.this.d)) {
                    TJSplitWebView.this.a();
                }
            }

            public final boolean shouldOverrideUrlLoading(WebView webView, String string) {
                StringBuilder stringBuilder = new StringBuilder("shouldOverrideUrlLoading: ");
                stringBuilder.append(string);
                TapjoyLog.d((String)"TJSplitWebView", (String)stringBuilder.toString());
                Uri uri = Uri.parse((String)string);
                if (uri != null) {
                    String string2 = uri.getHost();
                    String string3 = uri.getScheme();
                    if (!(string3 == null || string2 == null || !string3.equals((Object)"http") && !string3.equals((Object)"https") || TJSplitWebView.this.f != null && TJSplitWebView.this.f.contains((Object)string2))) {
                        TJSplitWebView.this.e = string;
                        return false;
                    }
                }
                try {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    context.startActivity(intent);
                    TJSplitWebView.this.a();
                }
                catch (Exception exception) {
                    TapjoyLog.e((String)"TJSplitWebView", (String)exception.getMessage());
                }
                return true;
            }
        });
        this.addView((View)this.a);
    }

    private void a(int n2, int n3) {
        double[] arrd = n2 <= n3 ? this.b : this.c;
        double d2 = n2;
        double d3 = arrd[0];
        Double.isNaN((double)d2);
        int n4 = (int)(d3 * d2);
        double d4 = n3;
        double d5 = arrd[1];
        Double.isNaN((double)d4);
        int n5 = (int)(d5 * d4);
        double d6 = arrd[2];
        Double.isNaN((double)d2);
        int n6 = (int)(d2 * d6);
        double d7 = arrd[3];
        Double.isNaN((double)d4);
        int n7 = (int)(d4 * d7);
        int n8 = n2 - n4 - n6;
        int n9 = n3 - n5 - n7;
        if (n4 != 0 && n5 != 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(n4, n5);
            layoutParams.setMargins(n6, n7, n8, n9);
            this.a.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            this.a.setVisibility(0);
            return;
        }
        this.a.setVisibility(4);
    }

    protected final void a() {
        this.g.dismissSplitView(null, null);
    }

    public void applyLayoutOption(JSONObject jSONObject) {
        this.setLayoutOption(jSONObject);
        this.a(this.getWidth(), this.getHeight());
    }

    public String getLastUrl() {
        return this.e;
    }

    public void loadUrl(String string) {
        BasicWebView basicWebView = this.a;
        if (basicWebView != null) {
            this.d = string;
            this.e = string;
            basicWebView.loadUrl(string);
        }
    }

    protected void onMeasure(int n2, int n3) {
        this.a(View.MeasureSpec.getSize((int)n2), View.MeasureSpec.getSize((int)n3));
        super.onMeasure(n2, n3);
    }

    public void setExitHosts(JSONArray jSONArray) {
        if (jSONArray == null) {
            this.f = null;
            return;
        }
        this.f = new HashSet();
        for (int i2 = 0; i2 <= jSONArray.length(); ++i2) {
            String string = jSONArray.optString(i2);
            if (string == null) continue;
            this.f.add((Object)string);
        }
    }

    protected void setLayoutOption(JSONObject jSONObject) {
        if (jSONObject != null) {
            JSONObject jSONObject2;
            JSONObject jSONObject3 = jSONObject.optJSONObject("landscape");
            if (jSONObject3 != null) {
                this.c[0] = jSONObject3.optDouble("width", 0.0);
                this.c[1] = jSONObject3.optDouble("height", 0.0);
                this.c[2] = jSONObject3.optDouble("left", 0.0);
                this.c[3] = jSONObject3.optDouble("top", 0.0);
            }
            if ((jSONObject2 = jSONObject.optJSONObject("portrait")) != null) {
                this.b[0] = jSONObject2.optDouble("width", 0.0);
                this.b[1] = jSONObject2.optDouble("height", 0.0);
                this.b[2] = jSONObject2.optDouble("left", 0.0);
                this.b[3] = jSONObject2.optDouble("top", 0.0);
            }
        }
    }

}

