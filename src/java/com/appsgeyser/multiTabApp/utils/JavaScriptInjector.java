/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.webkit.JavascriptInterface
 *  android.webkit.WebView
 *  android.widget.Toast
 *  com.appsgeyser.multiTabApp.controllers.WebContentController
 *  com.appsgeyser.multiTabApp.utils.JavaScriptInjector$1
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.appsgeyser.multiTabApp.utils;

import android.content.Context;
import android.os.Handler;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import com.appsgeyser.multiTabApp.controllers.WebContentController;
import com.appsgeyser.multiTabApp.utils.JavaScriptInjector;

public class JavaScriptInjector {
    private final long INJECT_TRIES_INTERVAL = 200L;
    public final String JS_INJECTION_PREFIX = "javascript:(function(){ ";
    public final String JS_INJECTION_SUFFIX = " })()";
    private Handler _handler = new Handler();
    private final WebContentController _webContentController;
    private final WebView _webView;
    private final StoppableRunnable injectContentRunnable = new 1(this);

    public JavaScriptInjector(WebView webView, WebContentController webContentController) {
        this._webView = webView;
        this._webContentController = webContentController;
        this._webView.addJavascriptInterface((Object)this, "AppsgeyserJSInjectorInterface");
    }

    static /* synthetic */ WebView access$100(JavaScriptInjector javaScriptInjector) {
        return javaScriptInjector._webView;
    }

    static /* synthetic */ WebContentController access$200(JavaScriptInjector javaScriptInjector) {
        return javaScriptInjector._webContentController;
    }

    static /* synthetic */ Handler access$300(JavaScriptInjector javaScriptInjector) {
        return javaScriptInjector._handler;
    }

    public void InjectJavaScript() {
    }

    @JavascriptInterface
    public void injectedSuccessfully() {
        this._handler.removeCallbacks((Runnable)this.injectContentRunnable);
        this.injectContentRunnable.stop = true;
    }

    @JavascriptInterface
    public void showToast(String string2) {
        Toast.makeText((Context)this._webView.getContext(), (CharSequence)string2, (int)0).show();
    }

    private abstract class StoppableRunnable
    implements Runnable {
        public boolean stop = false;

        private StoppableRunnable() {
        }
    }

}

