/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.webkit.JavascriptInterface
 *  java.lang.Runnable
 *  java.lang.String
 */
package com.startapp.android.publish.ads.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.startapp.android.publish.adsCommon.d.b;
import com.startapp.android.publish.html.JsInterface;
import com.startapp.common.a.g;

public class VideoJsInterface
extends JsInterface {
    private static final String TAG = "VideoJsInterface";
    private Runnable replayCallback = null;
    private Runnable skipCallback = null;
    private Runnable toggleSoundCallback = null;

    public VideoJsInterface(Context context, Runnable runnable, Runnable runnable2, Runnable runnable3, Runnable runnable4, Runnable runnable5, b b2, boolean bl) {
        super(context, runnable, runnable2, b2);
        this.replayCallback = runnable3;
        this.skipCallback = runnable4;
        this.toggleSoundCallback = runnable5;
        this.inAppBrowserEnabled = bl;
    }

    @JavascriptInterface
    public void replayVideo() {
        g.a(TAG, 3, "replayVideo called");
        if (this.replayCallback != null) {
            new Handler(Looper.getMainLooper()).post(this.replayCallback);
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        g.a(TAG, 3, "skipVideo called");
        if (this.skipCallback != null) {
            new Handler(Looper.getMainLooper()).post(this.skipCallback);
        }
    }

    @JavascriptInterface
    public void toggleSound() {
        g.a(TAG, 3, "toggleSound called");
        if (this.toggleSoundCallback != null) {
            new Handler(Looper.getMainLooper()).post(this.toggleSoundCallback);
        }
    }
}

