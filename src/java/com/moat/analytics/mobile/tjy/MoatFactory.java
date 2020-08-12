/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.tjy.ak
 *  com.moat.analytics.mobile.tjy.v
 *  java.lang.Deprecated
 *  java.lang.Object
 *  java.lang.String
 */
package com.moat.analytics.mobile.tjy;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.tjy.NativeDisplayTracker;
import com.moat.analytics.mobile.tjy.NativeVideoTracker;
import com.moat.analytics.mobile.tjy.WebAdTracker;
import com.moat.analytics.mobile.tjy.ac;
import com.moat.analytics.mobile.tjy.ak;
import com.moat.analytics.mobile.tjy.base.exception.a;
import com.moat.analytics.mobile.tjy.base.exception.b;
import com.moat.analytics.mobile.tjy.v;

public abstract class MoatFactory {
    public static MoatFactory create(Activity activity) {
        try {
            v v2 = new v(activity);
            return v2;
        }
        catch (b b2) {
            a.a(b2);
            return new ak();
        }
    }

    public abstract Object createCustomTracker(ac var1);

    public abstract NativeDisplayTracker createNativeDisplayTracker(View var1, String var2);

    public abstract NativeVideoTracker createNativeVideoTracker(String var1);

    public abstract WebAdTracker createWebAdTracker(ViewGroup var1);

    public abstract WebAdTracker createWebAdTracker(WebView var1);

    @Deprecated
    public abstract WebAdTracker createWebDisplayTracker(ViewGroup var1);

    @Deprecated
    public abstract WebAdTracker createWebDisplayTracker(WebView var1);
}

