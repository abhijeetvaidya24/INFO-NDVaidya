/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.webkit.WebView
 *  java.lang.Object
 */
package io.presage;

import android.app.Application;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.MoatAnalytics;
import com.moat.analytics.mobile.ogury.WebAdTracker;
import io.presage.PetitMorin;
import io.presage.cl;

public final class PersilledumontBlanc {
    private WebAdTracker a;
    private final PetitMorin b;

    public PersilledumontBlanc() {
        MoatAnalytics moatAnalytics = MoatAnalytics.getInstance();
        cl.a((Object)moatAnalytics, "MoatAnalytics.getInstance()");
        this(new PetitMorin(moatAnalytics));
    }

    private PersilledumontBlanc(PetitMorin petitMorin) {
        this.b = petitMorin;
    }

    public final void a() {
        WebAdTracker webAdTracker = this.a;
        if (webAdTracker != null) {
            webAdTracker.startTracking();
        }
    }

    public final void a(Application application) {
        this.b.a(application);
    }

    public final void a(WebView webView) {
        this.a = PetitMorin.a().createWebAdTracker(webView);
    }

    public final void b() {
        WebAdTracker webAdTracker = this.a;
        if (webAdTracker != null) {
            webAdTracker.stopTracking();
        }
    }
}

