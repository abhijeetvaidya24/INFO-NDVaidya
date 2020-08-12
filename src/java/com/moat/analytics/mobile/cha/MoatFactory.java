/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.cha.NoOp$MoatFactory
 *  com.moat.analytics.mobile.cha.k
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.util.Map
 */
package com.moat.analytics.mobile.cha;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.moat.analytics.mobile.cha.NativeDisplayTracker;
import com.moat.analytics.mobile.cha.NativeVideoTracker;
import com.moat.analytics.mobile.cha.NoOp;
import com.moat.analytics.mobile.cha.WebAdTracker;
import com.moat.analytics.mobile.cha.k;
import com.moat.analytics.mobile.cha.l;
import com.moat.analytics.mobile.cha.o;
import java.util.Map;

/*
 * Exception performing whole class analysis.
 */
public abstract class MoatFactory {
    public static MoatFactory create() {
        try {
            k k2 = new k();
            return k2;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return new /* Unavailable Anonymous Inner Class!! */;
        }
    }

    public abstract <T> T createCustomTracker(l<T> var1);

    public abstract NativeDisplayTracker createNativeDisplayTracker(View var1, Map<String, String> var2);

    public abstract NativeVideoTracker createNativeVideoTracker(String var1);

    public abstract WebAdTracker createWebAdTracker(ViewGroup var1);

    public abstract WebAdTracker createWebAdTracker(WebView var1);
}

