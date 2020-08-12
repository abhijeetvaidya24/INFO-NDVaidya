/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.aer.ag
 *  com.moat.analytics.mobile.aer.r
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.aer;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.aer.NativeDisplayTracker;
import com.moat.analytics.mobile.aer.NativeVideoTracker;
import com.moat.analytics.mobile.aer.WebAdTracker;
import com.moat.analytics.mobile.aer.ag;
import com.moat.analytics.mobile.aer.base.exception.a;
import com.moat.analytics.mobile.aer.base.exception.b;
import com.moat.analytics.mobile.aer.r;
import com.moat.analytics.mobile.aer.y;

public abstract class MoatFactory {
    public static MoatFactory create(Activity activity) {
        try {
            r r2 = new r(activity);
            return r2;
        }
        catch (b b2) {
            a.a(b2);
            return new ag();
        }
    }

    public abstract <T> T createCustomTracker(y<T> var1);

    public abstract NativeDisplayTracker createNativeDisplayTracker(View var1, String var2);

    public abstract NativeVideoTracker createNativeVideoTracker(String var1);

    public abstract WebAdTracker createWebAdTracker(ViewGroup var1);

    public abstract WebAdTracker createWebAdTracker(WebView var1);

    @Deprecated
    public abstract WebAdTracker createWebDisplayTracker(ViewGroup var1);

    @Deprecated
    public abstract WebAdTracker createWebDisplayTracker(WebView var1);
}

