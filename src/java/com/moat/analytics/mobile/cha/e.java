/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.webkit.WebView
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.cha;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import com.moat.analytics.mobile.cha.MoatFactory;
import com.moat.analytics.mobile.cha.WebAdTracker;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.base.functional.Optional;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.t;
import com.moat.analytics.mobile.cha.x;
import java.lang.ref.WeakReference;

final class e {
    private static WeakReference<Activity> \u02ca = new WeakReference(null);
    private static WebAdTracker \u02cb;

    e() {
    }

    static void \u02ce(Activity activity) {
        block9 : {
            try {
                if (t.\u02cf().\u02ce == t.a.\u0971) {
                    return;
                }
                String string = activity.getClass().getName();
                StringBuilder stringBuilder = new StringBuilder("Activity name: ");
                stringBuilder.append(string);
                a.\u02cf(3, "GMAInterstitialHelper", (Object)activity, stringBuilder.toString());
                if (string.contains((CharSequence)"com.google.android.gms.ads.AdActivity")) {
                    if (\u02ca.get() == null || \u02ca.get() != activity) {
                        View view = activity.getWindow().getDecorView();
                        if (view instanceof ViewGroup) {
                            Optional<WebView> optional = x.\u02ca((ViewGroup)view, true);
                            if (optional.isPresent()) {
                                WebAdTracker webAdTracker;
                                \u02ca = new WeakReference((Object)activity);
                                WebView webView = optional.get();
                                a.\u02cf(3, "GMAInterstitialHelper", \u02ca.get(), "Starting to track GMA interstitial");
                                \u02cb = webAdTracker = MoatFactory.create().createWebAdTracker(webView);
                                webAdTracker.startTracking();
                                return;
                            }
                            a.\u02cf(3, "GMAInterstitialHelper", (Object)activity, "Sorry, no WebView in this activity");
                            return;
                        }
                        break block9;
                    }
                } else {
                    if (\u02cb != null) {
                        a.\u02cf(3, "GMAInterstitialHelper", \u02ca.get(), "Stopping to track GMA interstitial");
                        \u02cb.stopTracking();
                        \u02cb = null;
                    }
                    \u02ca = new WeakReference(null);
                }
                return;
            }
            catch (Exception exception) {
                o.\u02ce(exception);
                return;
            }
        }
    }
}

