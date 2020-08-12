/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.net.Uri
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  java.io.ByteArrayInputStream
 *  java.io.InputStream
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.reflect.Method
 *  java.util.Arrays
 *  java.util.Locale
 *  java.util.Map
 */
package com.startapp.android.publish.adsCommon.g.a;

import android.annotation.TargetApi;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.startapp.android.publish.adsCommon.g.a.b;
import com.startapp.android.publish.adsCommon.g.d.a;
import com.startapp.common.a.g;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

public class e
extends WebViewClient {
    private b a;
    private boolean b = false;

    public e(b b2) {
        this.a = b2;
    }

    @TargetApi(value=11)
    private WebResourceResponse a() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javascript:");
        stringBuilder.append(a.a());
        return new WebResourceResponse("text/javascript", "UTF-8", (InputStream)new ByteArrayInputStream(stringBuilder.toString().getBytes()));
    }

    protected boolean a(String string) {
        return string != null && string.startsWith("mraid://");
    }

    public boolean b(String string) {
        try {
            boolean bl = "mraid.js".equals((Object)Uri.parse((String)string.toLowerCase(Locale.US)).getLastPathSegment());
            return bl;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("matchesInjectionUrl Exception: ");
            stringBuilder.append(exception.getMessage());
            g.a("MraidWebViewClient", 6, stringBuilder.toString());
            return false;
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public boolean c(String var1_1) {
        block14 : {
            var2_2 = new StringBuilder();
            var2_2.append("invokeMraidMethod ");
            var2_2.append(var1_1);
            g.a("MraidWebViewClient", 3, var2_2.toString());
            var5_3 = new String[]{"close", "resize"};
            var7_5 = "useCustomClose";
            var6_4 = new String[]{"createCalendarEvent", "expand", "open", "playVideo", "storePicture", var7_5};
            var8_6 = new String[]{"setOrientationProperties", "setResizeProperties"};
            try {
                var15_7 = com.startapp.android.publish.adsCommon.g.d.b.a(var1_1);
                var16_8 = (String)var15_7.get((Object)"command");
                if (Arrays.asList((Object[])var5_3).contains((Object)var16_8)) {
                    b.class.getDeclaredMethod(var16_8, new Class[0]).invoke((Object)this.a, new Object[0]);
                } else {
                    if (Arrays.asList((Object[])var6_4).contains((Object)var16_8)) {
                        var21_9 = b.class.getDeclaredMethod(var16_8, new Class[]{String.class});
                        var22_10 = -1;
                        var23_11 = var16_8.hashCode();
                        if (var23_11 != -733616544) {
                            if (var23_11 == 1614272768 && var16_8.equals((Object)var7_5)) {
                                var22_10 = 1;
                            }
                        } else if (var16_8.equals((Object)"createCalendarEvent")) {
                            var22_10 = 0;
                        }
                        break block14;
                    }
                    if (Arrays.asList((Object[])var8_6).contains((Object)var16_8)) {
                        b.class.getDeclaredMethod(var16_8, new Class[]{Map.class}).invoke((Object)this.a, new Object[]{var15_7});
                    }
                }
lbl28: // 5 sources:
                do {
                    var17_13 = new StringBuilder();
                    var17_13.append("successfully invoked ");
                    var17_13.append(var1_1);
                    g.a("MraidWebViewClient", 3, var17_13.toString());
                    return true;
                    break;
                } while (true);
            }
            catch (Exception var9_14) {
                var10_15 = new StringBuilder();
                var10_15.append("failed to invoke ");
                var10_15.append(var1_1);
                var10_15.append(". ");
                var10_15.append(var9_14.getMessage());
                g.a("MraidWebViewClient", 6, var10_15.toString());
                return false;
            }
        }
        if (var22_10 != 0) {
            if (var22_10 != 1) {
                var7_5 = "url";
            }
        } else {
            var7_5 = "eventJSON";
        }
        var24_12 = (String)var15_7.get((Object)var7_5);
        var21_9.invoke((Object)this.a, new Object[]{var24_12});
        ** while (true)
    }

    public void onReceivedError(WebView webView, int n2, String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onReceivedError: ");
        stringBuilder.append(string);
        g.a("MraidWebViewClient", 6, stringBuilder.toString());
        super.onReceivedError(webView, n2, string, string2);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("shouldInterceptRequest: ");
        stringBuilder.append(string);
        g.a("MraidWebViewClient", 3, stringBuilder.toString());
        if (!this.b && this.b(string)) {
            this.b = true;
            return this.a();
        }
        return super.shouldInterceptRequest(webView, string);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("shouldOverrideUrlLoading: ");
        stringBuilder.append(string);
        g.a("MraidWebViewClient", 3, stringBuilder.toString());
        if (this.a(string)) {
            return this.c(string);
        }
        return this.a.open(string);
    }
}

