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
package com.moat.analytics.mobile.mpub;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.webkit.WebView;
import com.moat.analytics.mobile.mpub.MoatFactory;
import com.moat.analytics.mobile.mpub.WebAdTracker;
import com.moat.analytics.mobile.mpub.a.b.a;
import com.moat.analytics.mobile.mpub.ab;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.w;
import java.lang.ref.WeakReference;

class f {
    private static WebAdTracker a;
    private static WeakReference<Activity> b;

    static {
        b = new WeakReference(null);
    }

    f() {
    }

    private static void a() {
        if (a != null) {
            p.a(3, "GMAInterstitialHelper", b.get(), "Stopping to track GMA interstitial");
            a.stopTracking();
            a = null;
        }
    }

    static void a(Activity activity) {
        block6 : {
            try {
                if (w.a().a == w.d.a) {
                    return;
                }
                if (f.b(activity)) {
                    View view;
                    if ((b.get() == null || b.get() != activity) && (view = activity.getWindow().getDecorView()) instanceof ViewGroup) {
                        a<WebView> a2 = ab.a((ViewGroup)view, true);
                        if (a2.c()) {
                            b = new WeakReference((Object)activity);
                            f.a(a2.b());
                            return;
                        }
                        p.a(3, "GMAInterstitialHelper", (Object)activity, "Sorry, no WebView in this activity");
                        return;
                    }
                    break block6;
                }
                f.a();
                b = new WeakReference(null);
                return;
            }
            catch (Exception exception) {
                m.a(exception);
            }
        }
    }

    private static void a(WebView webView) {
        p.a(3, "GMAInterstitialHelper", b.get(), "Starting to track GMA interstitial");
        a = MoatFactory.create().createWebAdTracker(webView);
        a.startTracking();
    }

    private static boolean b(Activity activity) {
        String string2 = activity.getClass().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Activity name: ");
        stringBuilder.append(string2);
        p.a(3, "GMAInterstitialHelper", (Object)activity, stringBuilder.toString());
        return string2.contains((CharSequence)"com.google.android.gms.ads.AdActivity");
    }
}

