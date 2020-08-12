/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 */
package com.tapjoy.mraid.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class BasicWebView
extends WebView {
    @SuppressLint(value={"NewApi"})
    public BasicWebView(Context context) {
        super(context);
        this.setScrollContainer(false);
        this.setVerticalScrollBarEnabled(false);
        this.setHorizontalScrollBarEnabled(false);
        new GestureDetector((GestureDetector.OnGestureListener)new a());
        if (this.getSettings() != null) {
            this.getSettings().setJavaScriptEnabled(true);
            if (Build.VERSION.SDK_INT >= 17) {
                this.getSettings().setMediaPlaybackRequiresUserGesture(false);
            }
        }
        this.setBackgroundColor(0);
    }

    public BasicWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    final class a
    extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            return true;
        }
    }

}

