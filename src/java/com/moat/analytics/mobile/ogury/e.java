/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.text.TextUtils
 *  android.view.View
 *  android.webkit.WebView
 *  java.lang.CharSequence
 *  java.lang.Double
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Math
 *  java.lang.Object
 *  java.lang.Runnable
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.HashSet
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  java.util.Set
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.ogury;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.ogury.MoatAdEvent;
import com.moat.analytics.mobile.ogury.MoatAdEventType;
import com.moat.analytics.mobile.ogury.TrackerListener;
import com.moat.analytics.mobile.ogury.VideoTrackerListener;
import com.moat.analytics.mobile.ogury.a;
import com.moat.analytics.mobile.ogury.c;
import com.moat.analytics.mobile.ogury.d;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.f;
import com.moat.analytics.mobile.ogury.l;
import com.moat.analytics.mobile.ogury.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

abstract class e
extends c {
    static final MoatAdEventType[] \u02bd;
    final Map<MoatAdEventType, Integer> \u02bb;
    WeakReference<View> \u02bc;
    private Map<String, String> \u02ca\u0971;
    private final Set<MoatAdEventType> \u02cb\u0971;
    private VideoTrackerListener \u02cf\u0971;
    private Double \u037a;
    private boolean \u0971\u02ca;
    private final String \u0971\u02ce;
    final Handler \u0971\u0971;
    private final d \u0971\u141d;

    static {
        MoatAdEventType[] arrmoatAdEventType = new MoatAdEventType[]{MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};
        \u02bd = arrmoatAdEventType;
    }

    e(String string) {
        super(null, false, true);
        1.\u02cb(3, "BaseVideoTracker", this, "Initializing.");
        this.\u0971\u02ce = string;
        this.\u0971\u141d = new d((Context)a.\u02cf(), d.b.\u0971);
        this.\u02cb = this.\u0971\u141d.\u02cb;
        try {
            super.\u02cb(this.\u0971\u141d.\u02ce);
        }
        catch (l l2) {
            this.\u02ce = l2;
        }
        this.\u02bb = new HashMap();
        this.\u02cb\u0971 = new HashSet();
        this.\u0971\u0971 = new Handler();
        this.\u0971\u02ca = false;
        this.\u037a = 1.0;
    }

    static /* synthetic */ VideoTrackerListener \u02ca(e e2) {
        e2.\u02cf\u0971 = null;
        return null;
    }

    static /* synthetic */ d \u02ce(e e2) {
        return e2.\u0971\u141d;
    }

    static boolean \u0971(Integer n2, Integer n3) {
        int n4 = Math.abs((int)(n3 - n2));
        double d2 = n3.intValue();
        Double.isNaN((double)d2);
        double d3 = Math.min((double)750.0, (double)(d2 * 0.05));
        return (double)n4 <= d3;
    }

    @Override
    public void changeTargetView(View view) {
        StringBuilder stringBuilder = new StringBuilder("changing view to ");
        stringBuilder.append(1.\u02cf(view));
        1.\u02cb(3, "BaseVideoTracker", this, stringBuilder.toString());
        this.\u02bc = new WeakReference((Object)view);
        try {
            super.changeTargetView(view);
            return;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public void dispatchEvent(MoatAdEvent moatAdEvent) {
        boolean bl2;
        MoatAdEventType moatAdEventType;
        block8 : {
            try {
                JSONObject jSONObject = this.\u02ca(moatAdEvent);
                Object[] arrobject = new Object[]{jSONObject.toString()};
                1.\u02cb(3, "BaseVideoTracker", this, String.format((String)"Received event: %s", (Object[])arrobject));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.\u02cf());
                Object[] arrobject2 = new Object[]{jSONObject.toString()};
                stringBuilder.append(String.format((String)" Received event: %s", (Object[])arrobject2));
                1.\u0971("[SUCCESS] ", stringBuilder.toString());
                if (this.\u02ca() && this.\u02cb != null) {
                    this.\u02cb.\u0971(this.\u0971\u141d.\u0971, jSONObject);
                    if (!this.\u02cb\u0971.contains((Object)moatAdEvent.\u02ce)) {
                        this.\u02cb\u0971.add((Object)moatAdEvent.\u02ce);
                        if (this.\u02cf\u0971 != null) {
                            this.\u02cf\u0971.onVideoEventReported(moatAdEvent.\u02ce);
                        }
                    }
                }
                if ((moatAdEventType = moatAdEvent.\u02ce) != MoatAdEventType.AD_EVT_COMPLETE && moatAdEventType != MoatAdEventType.AD_EVT_STOPPED) {
                    MoatAdEventType moatAdEventType2 = MoatAdEventType.AD_EVT_SKIPPED;
                    bl2 = false;
                    if (moatAdEventType != moatAdEventType2) break block8;
                }
                bl2 = true;
            }
            catch (Exception exception) {
                l.\u0971(exception);
                return;
            }
        }
        if (!bl2) return;
        this.\u02bb.put((Object)moatAdEventType, (Object)1);
        if (this.\u02cb != null) {
            this.\u02cb.\u02cf(this);
        }
        this.\u02cf\u0971();
    }

    public void removeVideoListener() {
        this.\u02cf\u0971 = null;
    }

    public void setPlayerVolume(Double d2) {
        Double d3 = this.\u037a * s.\u02cb();
        if (!d2.equals((Object)this.\u037a)) {
            1.\u02cb(3, "BaseVideoTracker", this, String.format((Locale)Locale.ROOT, (String)"player volume changed to %f ", (Object[])new Object[]{d2}));
            this.\u037a = d2;
            if (!d3.equals((Object)(this.\u037a * s.\u02cb()))) {
                this.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.\u02cf, this.\u037a));
            }
        }
    }

    public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        this.\u02cf\u0971 = videoTrackerListener;
    }

    @Override
    public void stopTracking() {
        try {
            super.stopTracking();
            this.\u02cf\u0971();
            if (this.\u02cf\u0971 != null) {
                this.\u02cf\u0971 = null;
            }
            return;
        }
        catch (Exception exception) {
            l.\u0971(exception);
            return;
        }
    }

    final Double \u02bc() {
        return this.\u037a * s.\u02cb();
    }

    JSONObject \u02ca(MoatAdEvent moatAdEvent) {
        if (Double.isNaN((double)moatAdEvent.\u02ca)) {
            moatAdEvent.\u02ca = this.\u037a;
        }
        return new JSONObject(moatAdEvent.\u02cb());
    }

    @Override
    void \u02ca(List<String> list) throws l {
        if (this.\u02ca\u0971 == null) {
            list.add((Object)"Null adIds object");
        }
        if (list.isEmpty()) {
            super.\u02ca(list);
            return;
        }
        throw new l(TextUtils.join((CharSequence)" and ", list));
    }

    final Double \u02ca\u0971() {
        return this.\u037a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean \u02cb(Map<String, String> map, View view) {
        try {
            this.\u0971();
            this.\u02cb();
            if (view == null) {
                1.\u02cb(3, "BaseVideoTracker", this, "trackVideoAd received null video view instance");
            }
            this.\u02ca\u0971 = map;
            this.\u02bc = new WeakReference((Object)view);
            this.\u02ce();
            Object[] arrobject = new Object[]{new JSONObject(map).toString(), 1.\u02cf(view)};
            String string = String.format((String)"trackVideoAd tracking ids: %s | view: %s", (Object[])arrobject);
            1.\u02cb(3, "BaseVideoTracker", this, string);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.\u02cf());
            stringBuilder.append(" ");
            stringBuilder.append(string);
            1.\u0971("[SUCCESS] ", stringBuilder.toString());
            if (this.\u02cf != null) {
                this.\u02cf.onTrackingStarted(this.\u02bb());
            }
            return true;
        }
        catch (Exception exception) {
            this.\u02cb("trackVideoAd", exception);
            return false;
        }
    }

    @Override
    final void \u02ce() throws l {
        super.changeTargetView((View)this.\u02bc.get());
        super.\u02ce();
        Map<String, Object> map = this.\u141d();
        Integer n2 = (Integer)map.get((Object)"width");
        Integer n3 = (Integer)map.get((Object)"height");
        Integer n4 = (Integer)map.get((Object)"duration");
        1.\u02cb(3, "BaseVideoTracker", this, String.format((Locale)Locale.ROOT, (String)"Player metadata: height = %d, width = %d, duration = %d", (Object[])new Object[]{n3, n2, n4}));
        this.\u0971\u141d.\u02cf(this.\u0971\u02ce, this.\u02ca\u0971, n2, n3, n4);
    }

    final void \u02cf\u0971() {
        if (!this.\u0971\u02ca) {
            this.\u0971\u02ca = true;
            Runnable runnable = new Runnable(this){
                private /* synthetic */ e \u0971;
                {
                    this.\u0971 = e2;
                }

                static void \u02cb(int n2, String string, Object object, String string2) {
                    if (com.moat.analytics.mobile.ogury.q.\u02ca().\u02cf) {
                        if (object == null) {
                            android.util.Log.println((int)n2, (String)"Moat".concat(String.valueOf((Object)string)), (String)String.format((String)"message = %s", (Object[])new Object[]{string2}));
                            return;
                        }
                        String string3 = "Moat".concat(String.valueOf((Object)string));
                        Object[] arrobject = new Object[]{object.hashCode(), string2};
                        android.util.Log.println((int)n2, (String)string3, (String)String.format((String)"id = %s, message = %s", (Object[])arrobject));
                    }
                }

                static void \u02ce(String string, Object object, String string2) {
                    if (com.moat.analytics.mobile.ogury.q.\u02ca().\u02ce) {
                        String string3 = "Moat".concat(String.valueOf((Object)string));
                        Object[] arrobject = new Object[2];
                        String string4 = object == null ? "null" : Integer.valueOf((int)object.hashCode());
                        arrobject[0] = string4;
                        arrobject[1] = string2;
                        android.util.Log.println((int)2, (String)string3, (String)String.format((String)"id = %s, message = %s", (Object[])arrobject));
                    }
                }

                static String \u02cf(View view) {
                    if (view != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(view.getClass().getSimpleName());
                        stringBuilder.append("@");
                        stringBuilder.append(view.hashCode());
                        return stringBuilder.toString();
                    }
                    return "null";
                }

                static void \u02cf(String string, Object object, String string2, java.lang.Throwable throwable) {
                    if (com.moat.analytics.mobile.ogury.q.\u02ca().\u02cf) {
                        String string3 = "Moat".concat(String.valueOf((Object)string));
                        Object[] arrobject = new Object[]{object.hashCode(), string2};
                        android.util.Log.e((String)string3, (String)String.format((String)"id = %s, message = %s", (Object[])arrobject), (java.lang.Throwable)throwable);
                    }
                }

                static void \u0971(String string, String string2) {
                    if (!com.moat.analytics.mobile.ogury.q.\u02ca().\u02cf && ((com.moat.analytics.mobile.ogury.i)com.moat.analytics.mobile.ogury.MoatAnalytics.getInstance()).\u02ce) {
                        int n2 = 2;
                        if (string.equals((Object)"[ERROR] ")) {
                            n2 = 6;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(string);
                        stringBuilder.append(string2);
                        android.util.Log.println((int)n2, (String)"MoatAnalytics", (String)stringBuilder.toString());
                    }
                }

                public final void run() {
                    try {
                        1.\u02cb(3, "BaseVideoTracker", this, "Shutting down.");
                        d d2 = e.\u02ce(this.\u0971);
                        1.\u02cb(3, "GlobalWebView", d2, "Cleaning up");
                        d2.\u02cb.\u02cb();
                        d2.\u02cb = null;
                        d2.\u02ce.destroy();
                        d2.\u02ce = null;
                        e.\u02ca(this.\u0971);
                        return;
                    }
                    catch (Exception exception) {
                        l.\u0971(exception);
                        return;
                    }
                }
            };
            this.\u0971\u0971.postDelayed(runnable, 500L);
        }
    }

    final boolean \u0971\u02ca() {
        return this.\u02bb.containsKey((Object)MoatAdEventType.AD_EVT_COMPLETE) || this.\u02bb.containsKey((Object)MoatAdEventType.AD_EVT_STOPPED) || this.\u02bb.containsKey((Object)MoatAdEventType.AD_EVT_SKIPPED);
        {
        }
    }

    abstract Map<String, Object> \u141d() throws l;
}

