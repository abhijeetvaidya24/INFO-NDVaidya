/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.JavascriptInterface
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 */
package com.appnext.core.webview;

import android.content.Context;
import android.webkit.JavascriptInterface;

public class WebAppInterface {
    Context context;

    public WebAppInterface() {
    }

    public WebAppInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void destroy() {
    }

    @JavascriptInterface
    public void destroy(String string2) {
        new StringBuilder("destroy with error code: ").append(string2);
    }

    @JavascriptInterface
    public String filterAds(String string2) {
        new StringBuilder("filterAds: ").append(string2);
        return string2;
    }

    @JavascriptInterface
    public String getAdAt(int n2) {
        new StringBuilder("getAdAt ").append(n2);
        return "";
    }

    @JavascriptInterface
    public int getAdCount() {
        return 0;
    }

    @JavascriptInterface
    public void gotoAppWall() {
    }

    @JavascriptInterface
    public String init() {
        return "";
    }

    @JavascriptInterface
    public void jsError(String string2) {
        new StringBuilder("jsError ").append(string2);
    }

    @JavascriptInterface
    public String loadAds() {
        return "";
    }

    @JavascriptInterface
    public void logSTP(String string2, String string3) {
        new StringBuilder("logSTP ").append(string2);
    }

    @JavascriptInterface
    public void notifyImpression(String string2) {
    }

    @JavascriptInterface
    public void openLink(String string2) {
        new StringBuilder("openLink ").append(string2);
    }

    @JavascriptInterface
    public void openResultPage(String string2) {
        new StringBuilder("openResultPage ").append(string2);
    }

    @JavascriptInterface
    public void openStore(String string2) {
        new StringBuilder("openStore: ").append(string2);
    }

    @JavascriptInterface
    public void play() {
    }

    @JavascriptInterface
    public void postView(String string2) {
        new StringBuilder("postView: ").append(string2);
    }

    @JavascriptInterface
    public void videoPlayed() {
    }
}

