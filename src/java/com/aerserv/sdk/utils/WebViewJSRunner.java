/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.webkit.ValueCallback
 *  android.webkit.WebView
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.aerserv.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.aerserv.sdk.utils.AerServLog;

public class WebViewJSRunner {
    public static final String LOG_TAG = "com.aerserv.sdk.utils.WebViewJSRunner";

    public static void runIt(final WebView webView, final String string) {
        new Handler(webView.getContext().getMainLooper()).post(new Runnable(){

            public void run() {
                try {
                    if (Build.VERSION.SDK_INT < 19) {
                        WebView webView2 = webView;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("javascript: ");
                        stringBuilder.append(string);
                        webView2.loadUrl(stringBuilder.toString());
                        return;
                    }
                    webView.evaluateJavascript(string, null);
                    return;
                }
                catch (Exception exception) {
                    AerServLog.e(WebViewJSRunner.LOG_TAG, "Exception caught", exception);
                    return;
                }
            }
        });
    }

}

