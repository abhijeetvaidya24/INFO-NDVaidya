/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.iro.o
 *  com.moat.analytics.mobile.iro.t
 *  com.moat.analytics.mobile.iro.t$c
 *  com.moat.analytics.mobile.iro.v
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.iro;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.MoatFactory;
import com.moat.analytics.mobile.iro.WebAdTracker;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.base.functional.Optional;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.t;
import com.moat.analytics.mobile.iro.v;
import java.lang.ref.WeakReference;

final class e {
    private static WeakReference<Activity> \u02ca = new WeakReference(null);
    private static WebAdTracker \u02cf;

    e() {
    }

    static void \u02ca(Activity activity) {
        block9 : {
            try {
                if (t.\u02cb().\u02cb == t.c.\u02ca) {
                    return;
                }
                String string = activity.getClass().getName();
                StringBuilder stringBuilder = new StringBuilder("Activity name: ");
                stringBuilder.append(string);
                b.\u02cf(3, "GMAInterstitialHelper", (Object)activity, stringBuilder.toString());
                if (string.contains((CharSequence)"com.google.android.gms.ads.AdActivity")) {
                    if (\u02ca.get() == null || \u02ca.get() != activity) {
                        View view = activity.getWindow().getDecorView();
                        if (view instanceof ViewGroup) {
                            Optional optional = v.\u02cb((ViewGroup)((ViewGroup)view), (boolean)true);
                            if (optional.isPresent()) {
                                WebAdTracker webAdTracker;
                                \u02ca = new WeakReference((Object)activity);
                                WebView webView = (WebView)optional.get();
                                b.\u02cf(3, "GMAInterstitialHelper", \u02ca.get(), "Starting to track GMA interstitial");
                                \u02cf = webAdTracker = MoatFactory.create().createWebAdTracker(webView);
                                webAdTracker.startTracking();
                                return;
                            }
                            b.\u02cf(3, "GMAInterstitialHelper", (Object)activity, "Sorry, no WebView in this activity");
                            return;
                        }
                        break block9;
                    }
                } else {
                    if (\u02cf != null) {
                        b.\u02cf(3, "GMAInterstitialHelper", \u02ca.get(), "Stopping to track GMA interstitial");
                        \u02cf.stopTracking();
                        \u02cf = null;
                    }
                    \u02ca = new WeakReference(null);
                }
                return;
            }
            catch (Exception exception) {
                o.\u0971((Exception)exception);
                return;
            }
        }
    }
}

