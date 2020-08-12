/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.TargetApi
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.webkit.JsPromptResult
 *  android.webkit.JsResult
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 */
package com.tappx.a.a.b;

import android.annotation.TargetApi;
import android.os.Build;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.tappx.a.a.b.aj;

public class ao {
    @TargetApi(value=11)
    public static void a(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.onResume();
            return;
        }
        try {
            new aj.a((Object)webView, "onResume").a().b();
        }
        catch (Exception exception) {}
    }

    @TargetApi(value=11)
    public static void a(WebView webView, boolean bl) {
        if (bl) {
            webView.stopLoading();
            webView.loadUrl("");
        }
        if (Build.VERSION.SDK_INT >= 11) {
            webView.onPause();
            return;
        }
        try {
            new aj.a((Object)webView, "onPause").a().b();
        }
        catch (Exception exception) {}
    }

    public static void b(WebView webView) {
        webView.setWebChromeClient(new WebChromeClient(){

            public boolean onJsAlert(WebView webView, String string2, String string3, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            public boolean onJsBeforeUnload(WebView webView, String string2, String string3, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            public boolean onJsConfirm(WebView webView, String string2, String string3, JsResult jsResult) {
                jsResult.confirm();
                return true;
            }

            public boolean onJsPrompt(WebView webView, String string2, String string3, String string4, JsPromptResult jsPromptResult) {
                jsPromptResult.confirm();
                return true;
            }
        });
    }

}

