/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.aer;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.aer.MoatFactory;
import com.moat.analytics.mobile.aer.NativeDisplayTracker;
import com.moat.analytics.mobile.aer.NativeVideoTracker;
import com.moat.analytics.mobile.aer.WebAdTracker;
import com.moat.analytics.mobile.aer.ah;
import com.moat.analytics.mobile.aer.ai;
import com.moat.analytics.mobile.aer.ak;
import com.moat.analytics.mobile.aer.y;

public class ag
extends MoatFactory {
    @Override
    public <T> T createCustomTracker(y<T> y2) {
        return null;
    }

    @Override
    public NativeDisplayTracker createNativeDisplayTracker(View view, String string) {
        return new ah();
    }

    @Override
    public NativeVideoTracker createNativeVideoTracker(String string) {
        return new ai();
    }

    @Override
    public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        return new ak();
    }

    @Override
    public WebAdTracker createWebAdTracker(WebView webView) {
        return new ak();
    }

    @Override
    public WebAdTracker createWebDisplayTracker(ViewGroup viewGroup) {
        return new ak();
    }

    @Override
    public WebAdTracker createWebDisplayTracker(WebView webView) {
        return new ak();
    }
}

