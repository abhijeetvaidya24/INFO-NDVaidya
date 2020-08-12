/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.webkit.WebView
 *  com.ironsource.sdk.analytics.moat.MOATManager$1
 *  com.ironsource.sdk.analytics.moat.MOATManager$EventsListener
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  org.json.JSONObject
 */
package com.ironsource.sdk.analytics.moat;

import android.app.Application;
import android.webkit.WebView;
import com.ironsource.sdk.analytics.moat.MOATManager;
import com.moat.analytics.mobile.iro.MoatAnalytics;
import com.moat.analytics.mobile.iro.MoatFactory;
import com.moat.analytics.mobile.iro.MoatOptions;
import com.moat.analytics.mobile.iro.TrackerListener;
import com.moat.analytics.mobile.iro.WebAdTracker;
import org.json.JSONObject;

public class MOATManager {
    private static EventsListener mEventsListener;
    private static TrackerListener moatCallbacks;
    private static WebAdTracker webAdTracker;

    static {
        moatCallbacks = new 1();
    }

    static /* synthetic */ EventsListener access$000() {
        return mEventsListener;
    }

    public static void createAdTracker(WebView webView) throws Exception {
        webAdTracker = MoatFactory.create().createWebAdTracker(webView);
    }

    private static MoatOptions createMoatOptions(JSONObject jSONObject) {
        MoatOptions moatOptions = new MoatOptions();
        moatOptions.loggingEnabled = jSONObject.optBoolean("loggingEnabled");
        moatOptions.autoTrackGMAInterstitials = jSONObject.optBoolean("autoTrackGMAInterstitials");
        moatOptions.disableAdIdCollection = jSONObject.optBoolean("disableAdIdCollection");
        moatOptions.disableLocationServices = jSONObject.optBoolean("disableLocationServices");
        return moatOptions;
    }

    public static void initWithOptions(JSONObject jSONObject, Application application) throws Exception {
        MoatOptions moatOptions = jSONObject != null && jSONObject.length() > 0 ? MOATManager.createMoatOptions(jSONObject) : null;
        MoatAnalytics.getInstance().start(moatOptions, application);
    }

    public static void setEventListener(EventsListener eventsListener) {
        mEventsListener = eventsListener;
    }

    public static void startTracking() throws Exception {
        WebAdTracker webAdTracker = MOATManager.webAdTracker;
        if (webAdTracker != null) {
            webAdTracker.setListener(moatCallbacks);
            MOATManager.webAdTracker.startTracking();
        }
    }

    public static void stopTracking() throws Exception {
        WebAdTracker webAdTracker = MOATManager.webAdTracker;
        if (webAdTracker != null) {
            webAdTracker.stopTracking();
        }
    }
}

