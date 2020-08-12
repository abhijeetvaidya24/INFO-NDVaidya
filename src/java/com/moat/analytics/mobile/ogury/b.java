/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.Window
 *  android.webkit.WebView
 *  com.moat.analytics.mobile.ogury.e
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 */
package com.moat.analytics.mobile.ogury;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.MoatFactory;
import com.moat.analytics.mobile.ogury.WebAdTracker;
import com.moat.analytics.mobile.ogury.base.functional.Optional;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.q;
import com.moat.analytics.mobile.ogury.u;
import java.lang.ref.WeakReference;

final class b {
    private static WeakReference<Activity> \u02ca = new WeakReference(null);
    private static WebAdTracker \u02cf;

    b() {
    }

    static void \u02cb(Activity activity) {
        block9 : {
            try {
                if (q.\u02ca().\u0971 == q.e.\u02ca) {
                    return;
                }
                String string2 = activity.getClass().getName();
                e.1.\u02cb(3, "GMAInterstitialHelper", (Object)activity, "Activity name: ".concat(String.valueOf((Object)string2)));
                if (string2.contains((CharSequence)"com.google.android.gms.ads.AdActivity")) {
                    if (\u02ca.get() == null || \u02ca.get() != activity) {
                        View view = activity.getWindow().getDecorView();
                        if (view instanceof ViewGroup) {
                            Optional<WebView> optional = u.\u02ce((ViewGroup)view, true);
                            if (optional.isPresent()) {
                                WebAdTracker webAdTracker;
                                \u02ca = new WeakReference((Object)activity);
                                WebView webView = optional.get();
                                e.1.\u02cb(3, "GMAInterstitialHelper", \u02ca.get(), "Starting to track GMA interstitial");
                                \u02cf = webAdTracker = MoatFactory.create().createWebAdTracker(webView);
                                webAdTracker.startTracking();
                                return;
                            }
                            e.1.\u02cb(3, "GMAInterstitialHelper", (Object)activity, "Sorry, no WebView in this activity");
                            return;
                        }
                        break block9;
                    }
                } else {
                    if (\u02cf != null) {
                        e.1.\u02cb(3, "GMAInterstitialHelper", \u02ca.get(), "Stopping to track GMA interstitial");
                        \u02cf.stopTracking();
                        \u02cf = null;
                    }
                    \u02ca = new WeakReference(null);
                }
                return;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                return;
            }
        }
    }
}

