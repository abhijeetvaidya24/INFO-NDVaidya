/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.content.Context
 *  android.webkit.ConsoleMessage
 *  android.webkit.WebChromeClient
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.tapjoy.TJAdUnitJSBridge
 *  com.tapjoy.TapjoyErrorMessage
 *  com.tapjoy.TapjoyErrorMessage$ErrorType
 *  com.tapjoy.TapjoyLog
 *  com.tapjoy.TapjoyUtil
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.util.Map
 *  java.util.concurrent.CountDownLatch
 */
package com.tapjoy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyErrorMessage;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

@SuppressLint(value={"SetJavaScriptEnabled"})
public class TJEventOptimizer
extends WebView {
    private static String a = "TJEventOptimizer";
    private static TJEventOptimizer b;
    private static CountDownLatch c;
    private Context d;
    private TJAdUnitJSBridge e;

    private TJEventOptimizer(Context context) {
        super(context);
        this.d = context;
        this.e = new TJAdUnitJSBridge(this.d, (WebView)this);
        this.getSettings().setJavaScriptEnabled(true);
        this.setWebViewClient((WebViewClient)new b(0));
        this.setWebChromeClient((WebChromeClient)new a(0));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TapjoyConnectCore.getHostURL());
        stringBuilder.append("events/proxy?");
        stringBuilder.append(TapjoyUtil.convertURLParams((Map)TapjoyConnectCore.getGenericURLParams(), (boolean)true));
        this.loadUrl(stringBuilder.toString());
    }

    /* synthetic */ TJEventOptimizer(Context context, byte by) {
        this(context);
    }

    public static TJEventOptimizer getInstance() {
        return b;
    }

    public static void init(final Context context) {
        TapjoyLog.d((String)a, (String)"Initializing event optimizer");
        c = new CountDownLatch(1);
        TapjoyUtil.runOnMainThread((Runnable)new Runnable(){

            public final void run() {
                try {
                    b = new TJEventOptimizer(context, 0);
                }
                catch (Exception exception) {
                    TapjoyLog.w((String)a, (String)exception.getMessage());
                }
                c.countDown();
            }
        });
        c.await();
        if (b != null) {
            return;
        }
        throw new RuntimeException("Failed to init TJEventOptimizer");
    }

    final class a
    extends WebChromeClient {
        private a() {
        }

        /* synthetic */ a(byte by) {
            this();
        }

        @TargetApi(value=8)
        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String string = a;
            StringBuilder stringBuilder = new StringBuilder("JS CONSOLE: ");
            stringBuilder.append(consoleMessage.message());
            stringBuilder.append(" -- From line ");
            stringBuilder.append(consoleMessage.lineNumber());
            stringBuilder.append(" of ");
            stringBuilder.append(consoleMessage.sourceId());
            TapjoyLog.d((String)string, (String)stringBuilder.toString());
            return true;
        }
    }

    final class b
    extends WebViewClient {
        private b() {
        }

        /* synthetic */ b(byte by) {
            this();
        }

        public final void onPageFinished(WebView webView, String string) {
            TapjoyLog.d((String)a, (String)"boostrap html loaded successfully");
        }

        public final void onReceivedError(WebView webView, int n2, String string, String string2) {
            super.onReceivedError(webView, n2, string, string2);
            TapjoyLog.e((String)a, (TapjoyErrorMessage)new TapjoyErrorMessage(TapjoyErrorMessage.ErrorType.SDK_ERROR, "Error encountered when instantiating a WebViewClient"));
        }
    }

}

