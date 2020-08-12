/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.ogury.NoOp$MoatFactory
 *  com.moat.analytics.mobile.ogury.o
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.ogury;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.NativeDisplayTracker;
import com.moat.analytics.mobile.ogury.NativeVideoTracker;
import com.moat.analytics.mobile.ogury.NoOp;
import com.moat.analytics.mobile.ogury.WebAdTracker;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.n;
import com.moat.analytics.mobile.ogury.o;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public abstract class MoatFactory {
    public static MoatFactory create() {
        try {
            o o2 = new o();
            return o2;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return new /* Unavailable Anonymous Inner Class!! */;
        }
    }

    public abstract <T> T createCustomTracker(n<T> var1);

    public abstract NativeDisplayTracker createNativeDisplayTracker(View var1, Map<String, String> var2);

    public abstract NativeVideoTracker createNativeVideoTracker(String var1);

    public abstract WebAdTracker createWebAdTracker(ViewGroup var1);

    public abstract WebAdTracker createWebAdTracker(WebView var1);
}

