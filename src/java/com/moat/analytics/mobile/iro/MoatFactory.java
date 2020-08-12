/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.iro.NoOp$MoatFactory
 *  com.moat.analytics.mobile.iro.m
 *  com.moat.analytics.mobile.iro.n
 *  com.moat.analytics.mobile.iro.o
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.iro;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.NativeDisplayTracker;
import com.moat.analytics.mobile.iro.NativeVideoTracker;
import com.moat.analytics.mobile.iro.NoOp;
import com.moat.analytics.mobile.iro.WebAdTracker;
import com.moat.analytics.mobile.iro.m;
import com.moat.analytics.mobile.iro.n;
import com.moat.analytics.mobile.iro.o;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public abstract class MoatFactory {
    public static MoatFactory create() {
        try {
            n n2 = new n();
            return n2;
        }
        catch (Exception exception) {
            o.\u0971((Exception)exception);
            return new /* Unavailable Anonymous Inner Class!! */;
        }
    }

    public abstract <T> T createCustomTracker(m<T> var1);

    public abstract NativeDisplayTracker createNativeDisplayTracker(View var1, Map<String, String> var2);

    public abstract NativeVideoTracker createNativeVideoTracker(String var1);

    public abstract WebAdTracker createWebAdTracker(ViewGroup var1);

    public abstract WebAdTracker createWebAdTracker(WebView var1);
}

