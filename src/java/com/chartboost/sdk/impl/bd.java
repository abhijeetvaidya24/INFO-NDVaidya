/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.ConsoleMessage
 *  android.webkit.JsPromptResult
 *  android.webkit.WebChromeClient
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.webkit.WebView
 *  android.widget.FrameLayout
 *  com.chartboost.sdk.impl.bf
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Iterator
 *  java.util.Map
 *  java.util.Map$Entry
 *  java.util.Set
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.chartboost.sdk.impl;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.e;
import com.chartboost.sdk.Model.b;
import com.chartboost.sdk.Model.c;
import com.chartboost.sdk.impl.be;
import com.chartboost.sdk.impl.bf;
import com.chartboost.sdk.impl.bg;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class bd
extends WebChromeClient {
    private View a;
    private ViewGroup b;
    private boolean c;
    private FrameLayout d;
    private WebChromeClient.CustomViewCallback e;
    private a f;
    private final bf g;
    private final Handler h;

    public bd(View view, ViewGroup viewGroup, View view2, be be2, bf bf2, Handler handler) {
        this.a = view;
        this.b = viewGroup;
        this.c = false;
        this.g = bf2;
        this.h = handler;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    public String a(JSONObject var1_1, String var2_2) {
        block48 : {
            var3_3 = var2_2.hashCode();
            var4_4 = 4;
            switch (var3_3) {
                default: {
                    break;
                }
                case 1880941391: {
                    if (!var2_2.equals((Object)"getMaxSize")) break;
                    var5_5 = 15;
                    break block48;
                }
                case 1270488759: {
                    if (!var2_2.equals((Object)"tracking")) break;
                    var5_5 = 13;
                    break block48;
                }
                case 1124446108: {
                    if (!var2_2.equals((Object)"warning")) break;
                    var5_5 = 11;
                    break block48;
                }
                case 1082777163: {
                    if (!var2_2.equals((Object)"totalVideoDuration")) break;
                    var5_5 = 8;
                    break block48;
                }
                case 1000390722: {
                    if (!var2_2.equals((Object)"videoReplay")) break;
                    var5_5 = 6;
                    break block48;
                }
                case 939594121: {
                    if (!var2_2.equals((Object)"videoPaused")) break;
                    var5_5 = 5;
                    break block48;
                }
                case 937504109: {
                    if (!var2_2.equals((Object)"getOrientationProperties")) break;
                    var5_5 = 19;
                    break block48;
                }
                case 160987616: {
                    if (!var2_2.equals((Object)"getParameters")) break;
                    var5_5 = 0;
                    break block48;
                }
                case 133423073: {
                    if (!var2_2.equals((Object)"setOrientationProperties")) break;
                    var5_5 = 20;
                    break block48;
                }
                case 96784904: {
                    if (!var2_2.equals((Object)"error")) break;
                    var5_5 = 10;
                    break block48;
                }
                case 95458899: {
                    if (!var2_2.equals((Object)"debug")) break;
                    var5_5 = 12;
                    break block48;
                }
                case 94756344: {
                    if (!var2_2.equals((Object)"close")) break;
                    var5_5 = 2;
                    break block48;
                }
                case 94750088: {
                    if (!var2_2.equals((Object)"click")) break;
                    var5_5 = 1;
                    break block48;
                }
                case 3529469: {
                    if (!var2_2.equals((Object)"show")) break;
                    var5_5 = 9;
                    break block48;
                }
                case -640720077: {
                    if (!var2_2.equals((Object)"videoPlaying")) break;
                    var5_5 = 4;
                    break block48;
                }
                case -715147645: {
                    if (!var2_2.equals((Object)"getScreenSize")) break;
                    var5_5 = 16;
                    break block48;
                }
                case -1086137328: {
                    if (!var2_2.equals((Object)"videoCompleted")) break;
                    var5_5 = 3;
                    break block48;
                }
                case -1263203643: {
                    if (!var2_2.equals((Object)"openUrl")) break;
                    var5_5 = 14;
                    break block48;
                }
                case -1554056650: {
                    if (!var2_2.equals((Object)"currentVideoDuration")) break;
                    var5_5 = 7;
                    break block48;
                }
                case -1757019252: {
                    if (!var2_2.equals((Object)"getCurrentPosition")) break;
                    var5_5 = 17;
                    break block48;
                }
                case -2012425132: {
                    if (!var2_2.equals((Object)"getDefaultPosition")) break;
                    var5_5 = 18;
                    break block48;
                }
            }
            var5_5 = -1;
        }
        switch (var5_5) {
            default: {
                var62_6 = new StringBuilder();
                var62_6.append("JavaScript to native ");
                var62_6.append(var2_2);
                var62_6.append(" callback not recognized.");
                Log.e((String)"CBWebChromeClient", (String)var62_6.toString());
                return "Function name not recognized.";
            }
            case 20: {
                var57_7 = new StringBuilder();
                var57_7.append("JavaScript to native ");
                var57_7.append(var2_2);
                var57_7.append(" callback triggered.");
                Log.d((String)"CBWebChromeClient", (String)var57_7.toString());
                var4_4 = 14;
                ** GOTO lbl185
            }
            case 19: {
                var52_8 = new StringBuilder();
                var52_8.append("JavaScript to native ");
                var52_8.append(var2_2);
                var52_8.append(" callback triggered.");
                Log.d((String)"CBWebChromeClient", (String)var52_8.toString());
                return this.g.p();
            }
            case 18: {
                var47_9 = new StringBuilder();
                var47_9.append("JavaScript to native ");
                var47_9.append(var2_2);
                var47_9.append(" callback triggered.");
                Log.d((String)"CBWebChromeClient", (String)var47_9.toString());
                return this.g.u();
            }
            case 17: {
                var42_10 = new StringBuilder();
                var42_10.append("JavaScript to native ");
                var42_10.append(var2_2);
                var42_10.append(" callback triggered.");
                Log.d((String)"CBWebChromeClient", (String)var42_10.toString());
                return this.g.v();
            }
            case 16: {
                var37_11 = new StringBuilder();
                var37_11.append("JavaScript to native ");
                var37_11.append(var2_2);
                var37_11.append(" callback triggered.");
                Log.d((String)"CBWebChromeClient", (String)var37_11.toString());
                return this.g.t();
            }
            case 15: {
                var32_12 = new StringBuilder();
                var32_12.append("JavaScript to native ");
                var32_12.append(var2_2);
                var32_12.append(" callback triggered.");
                Log.d((String)"CBWebChromeClient", (String)var32_12.toString());
                return this.g.s();
            }
            case 14: {
                var4_4 = 5;
                ** GOTO lbl185
            }
            case 13: {
                var4_4 = 8;
                ** GOTO lbl185
            }
            case 12: {
                var4_4 = 3;
                ** GOTO lbl185
            }
            case 11: {
                Log.d((String)be.class.getName(), (String)"Javascript warning occurred");
                var4_4 = 13;
                ** GOTO lbl185
            }
            case 10: {
                Log.d((String)be.class.getName(), (String)"Javascript Error occured");
                ** GOTO lbl185
            }
            case 9: {
                var4_4 = 6;
                ** GOTO lbl185
            }
            case 8: {
                var4_4 = 7;
                ** GOTO lbl185
            }
            case 7: {
                var4_4 = 2;
                ** GOTO lbl185
            }
            case 6: {
                var4_4 = 12;
                ** GOTO lbl185
            }
            case 5: {
                var4_4 = 10;
                ** GOTO lbl185
            }
            case 4: {
                var4_4 = 11;
                ** GOTO lbl185
            }
            case 3: {
                var4_4 = 9;
                ** GOTO lbl185
            }
            case 2: {
                var4_4 = 1;
                ** GOTO lbl185
            }
            case 1: {
                var4_4 = 0;
lbl185: // 15 sources:
                var23_13 = new StringBuilder();
                var23_13.append("JavaScript to native ");
                var23_13.append(var2_2);
                var23_13.append(" callback triggered.");
                Log.d((String)"CBWebChromeClient", (String)var23_13.toString());
                var28_14 = new bg(this, this.g, var4_4, var2_2, var1_1);
                this.h.post((Runnable)var28_14);
                return "Native function successfully called.";
            }
            case 0: 
        }
        var6_15 = new StringBuilder();
        var6_15.append("JavaScript to native ");
        var6_15.append(var2_2);
        var6_15.append(" callback triggered.");
        Log.d((String)"CBWebChromeClient", (String)var6_15.toString());
        if (this.g.e == null) return "{}";
        var11_16 = this.g.e.p;
        if (var11_16 == null) return "{}";
        var12_17 = e.a(new e.a[0]);
        for (Map.Entry var22_19 : var11_16.d.entrySet()) {
            e.a(var12_17, (String)var22_19.getKey(), var22_19.getValue());
        }
        var14_20 = var11_16.c.entrySet().iterator();
        while (var14_20.hasNext() != false) {
            var15_21 = (Map.Entry)var14_20.next();
            var16_22 = (b)var15_21.getValue();
            var17_23 = (String)var15_21.getKey();
            var18_24 = new StringBuilder();
            var18_24.append(var16_22.a);
            var18_24.append("/");
            var18_24.append(var16_22.b);
            e.a(var12_17, var17_23, (Object)var18_24.toString());
        }
        return var12_17.toString();
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String string = bd.class.getSimpleName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Chartboost Webview:");
        stringBuilder.append(consoleMessage.message());
        stringBuilder.append(" -- From line ");
        stringBuilder.append(consoleMessage.lineNumber());
        stringBuilder.append(" of ");
        stringBuilder.append(consoleMessage.sourceId());
        Log.d((String)string, (String)stringBuilder.toString());
        return true;
    }

    public void onHideCustomView() {
        if (this.c) {
            this.b.setVisibility(4);
            this.b.removeView((View)this.d);
            this.a.setVisibility(0);
            WebChromeClient.CustomViewCallback customViewCallback = this.e;
            if (customViewCallback != null && !customViewCallback.getClass().getName().contains((CharSequence)".chromium.")) {
                this.e.onCustomViewHidden();
            }
            this.c = false;
            this.d = null;
            this.e = null;
            a a2 = this.f;
            if (a2 != null) {
                a2.a(false);
            }
        }
    }

    public boolean onJsPrompt(WebView webView, String string, String string2, String string3, JsPromptResult jsPromptResult) {
        JSONObject jSONObject;
        String string4;
        try {
            JSONObject jSONObject2 = new JSONObject(string2);
            string4 = jSONObject2.getString("eventType");
            jSONObject = jSONObject2.getJSONObject("eventArgs");
        }
        catch (JSONException jSONException) {
            CBLogging.b("CBWebChromeClient", "Exception caught parsing the function name from js to native");
            return true;
        }
        jsPromptResult.confirm(this.a(jSONObject, string4));
        return true;
    }

    public void onShowCustomView(View view, int n2, WebChromeClient.CustomViewCallback customViewCallback) {
        this.onShowCustomView(view, customViewCallback);
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout)view;
            this.c = true;
            this.d = frameLayout;
            this.e = customViewCallback;
            this.a.setVisibility(4);
            this.b.addView((View)this.d, new ViewGroup.LayoutParams(-1, -1));
            this.b.setVisibility(0);
            a a2 = this.f;
            if (a2 != null) {
                a2.a(true);
            }
        }
    }

    public static interface a {
        public void a(boolean var1);
    }

}

