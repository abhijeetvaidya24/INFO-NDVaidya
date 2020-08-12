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
package com.moat.analytics.mobile.tjy;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.tjy.MoatFactory;
import com.moat.analytics.mobile.tjy.NativeDisplayTracker;
import com.moat.analytics.mobile.tjy.NativeVideoTracker;
import com.moat.analytics.mobile.tjy.WebAdTracker;
import com.moat.analytics.mobile.tjy.ac;
import com.moat.analytics.mobile.tjy.al;
import com.moat.analytics.mobile.tjy.am;
import com.moat.analytics.mobile.tjy.ao;

public class ak
extends MoatFactory {
    @Override
    public Object createCustomTracker(ac ac2) {
        return null;
    }

    @Override
    public NativeDisplayTracker createNativeDisplayTracker(View view, String string) {
        return new al();
    }

    @Override
    public NativeVideoTracker createNativeVideoTracker(String string) {
        return new am();
    }

    @Override
    public WebAdTracker createWebAdTracker(ViewGroup viewGroup) {
        return new ao();
    }

    @Override
    public WebAdTracker createWebAdTracker(WebView webView) {
        return new ao();
    }

    @Override
    public WebAdTracker createWebDisplayTracker(ViewGroup viewGroup) {
        return new ao();
    }

    @Override
    public WebAdTracker createWebDisplayTracker(WebView webView) {
        return new ao();
    }
}

