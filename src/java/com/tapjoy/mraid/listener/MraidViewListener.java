/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.webkit.ConsoleMessage
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 */
package com.tapjoy.mraid.listener;

import android.graphics.Bitmap;
import android.webkit.ConsoleMessage;
import android.webkit.WebView;

public interface MraidViewListener {
    public boolean onClose();

    public boolean onConsoleMessage(ConsoleMessage var1);

    public boolean onEventFired();

    public void onPageFinished(WebView var1, String var2);

    public void onPageStarted(WebView var1, String var2, Bitmap var3);

    public boolean onReady();

    public void onReceivedError(WebView var1, int var2, String var3, String var4);

    public boolean onResize();

    public boolean onResizeClose();

    public boolean shouldOverrideUrlLoading(WebView var1, String var2);
}

