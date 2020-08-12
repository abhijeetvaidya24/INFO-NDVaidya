/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.app.Application
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
package com.moat.analytics.mobile.iro;

import android.app.Application;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.iro.MoatAdEvent;
import com.moat.analytics.mobile.iro.MoatAdEventType;
import com.moat.analytics.mobile.iro.TrackerListener;
import com.moat.analytics.mobile.iro.VideoTrackerListener;
import com.moat.analytics.mobile.iro.a;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.c;
import com.moat.analytics.mobile.iro.d;
import com.moat.analytics.mobile.iro.f;
import com.moat.analytics.mobile.iro.o;
import com.moat.analytics.mobile.iro.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

abstract class d
extends c {
    static final MoatAdEventType[] \u02bd;
    final Map<MoatAdEventType, Integer> \u02bb;
    WeakReference<View> \u02bc;
    final Handler \u02ca\u0971;
    private Double \u02cb\u0971;
    private Map<String, String> \u02cf\u0971;
    private boolean \u037a;
    private VideoTrackerListener \u0971\u02ca;
    private final Set<MoatAdEventType> \u0971\u02cb;
    private final String \u0971\u02ce;
    private final b \u141d\u0971;

    static {
        MoatAdEventType[] arrmoatAdEventType = new MoatAdEventType[]{MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};
        \u02bd = arrmoatAdEventType;
    }

    d(String string) {
        super(null, false, true);
        b.\u02cf(3, "BaseVideoTracker", this, "Initializing.");
        this.\u0971\u02ce = string;
        this.\u141d\u0971 = new b(a.\u02ce(), b.a.\u02ce);
        this.\u02cf = this.\u141d\u0971.\u02cb;
        try {
            super.\u02cb(this.\u141d\u0971.\u02cf);
        }
        catch (o o2) {
            this.\u02cb = o2;
        }
        this.\u02bb = new HashMap();
        this.\u0971\u02cb = new HashSet();
        this.\u02ca\u0971 = new Handler();
        this.\u037a = false;
        this.\u02cb\u0971 = 1.0;
    }

    static /* synthetic */ VideoTrackerListener \u02cb(d d2) {
        d2.\u0971\u02ca = null;
        return null;
    }

    static boolean \u02cb(Integer n2, Integer n3) {
        int n4 = Math.abs((int)(n3 - n2));
        double d2 = n3.intValue();
        Double.isNaN((double)d2);
        double d3 = Math.min((double)750.0, (double)(d2 * 0.05));
        return (double)n4 <= d3;
    }

    static /* synthetic */ b \u02ce(d d2) {
        return d2.\u141d\u0971;
    }

    @Override
    public void changeTargetView(View view) {
        StringBuilder stringBuilder = new StringBuilder("changing view to ");
        stringBuilder.append(b.\u0971(view));
        b.\u02cf(3, "BaseVideoTracker", this, stringBuilder.toString());
        this.\u02bc = new WeakReference((Object)view);
        try {
            super.changeTargetView(view);
            return;
        }
        catch (Exception exception) {
            o.\u0971(exception);
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
                JSONObject jSONObject = this.\u02cb(moatAdEvent);
                Object[] arrobject = new Object[]{jSONObject.toString()};
                b.\u02cf(3, "BaseVideoTracker", this, String.format((String)"Received event: %s", (Object[])arrobject));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.\u02ca());
                Object[] arrobject2 = new Object[]{jSONObject.toString()};
                stringBuilder.append(String.format((String)" Received event: %s", (Object[])arrobject2));
                b.\u02ce("[SUCCESS] ", stringBuilder.toString());
                if (this.\u0971() && this.\u02cf != null) {
                    this.\u02cf.\u02ca(this.\u141d\u0971.\u02ca, jSONObject);
                    if (!this.\u0971\u02cb.contains((Object)moatAdEvent.\u0971)) {
                        this.\u0971\u02cb.add((Object)moatAdEvent.\u0971);
                        if (this.\u0971\u02ca != null) {
                            this.\u0971\u02ca.onVideoEventReported(moatAdEvent.\u0971);
                        }
                    }
                }
                if ((moatAdEventType = moatAdEvent.\u0971) != MoatAdEventType.AD_EVT_COMPLETE && moatAdEventType != MoatAdEventType.AD_EVT_STOPPED) {
                    MoatAdEventType moatAdEventType2 = MoatAdEventType.AD_EVT_SKIPPED;
                    bl2 = false;
                    if (moatAdEventType != moatAdEventType2) break block8;
                }
                bl2 = true;
            }
            catch (Exception exception) {
                o.\u0971(exception);
                return;
            }
        }
        if (!bl2) return;
        this.\u02bb.put((Object)moatAdEventType, (Object)1);
        if (this.\u02cf != null) {
            this.\u02cf.\u02cf(this);
        }
        this.\u0971\u02cb();
    }

    public void removeVideoListener() {
        this.\u0971\u02ca = null;
    }

    public void setPlayerVolume(Double d2) {
        Double d3 = this.\u02cb\u0971 * p.\u0971();
        if (!d2.equals((Object)this.\u02cb\u0971)) {
            b.\u02cf(3, "BaseVideoTracker", this, String.format((Locale)Locale.ROOT, (String)"player volume changed to %f ", (Object[])new Object[]{d2}));
            this.\u02cb\u0971 = d2;
            if (!d3.equals((Object)(this.\u02cb\u0971 * p.\u0971()))) {
                this.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.\u02cf, this.\u02cb\u0971));
            }
        }
    }

    public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        this.\u0971\u02ca = videoTrackerListener;
    }

    @Override
    public void stopTracking() {
        try {
            super.stopTracking();
            this.\u0971\u02cb();
            if (this.\u0971\u02ca != null) {
                this.\u0971\u02ca = null;
            }
            return;
        }
        catch (Exception exception) {
            o.\u0971(exception);
            return;
        }
    }

    abstract Map<String, Object> \u02ca\u0971() throws o;

    JSONObject \u02cb(MoatAdEvent moatAdEvent) {
        if (Double.isNaN((double)moatAdEvent.\u02ce)) {
            moatAdEvent.\u02ce = this.\u02cb\u0971;
        }
        return new JSONObject((Map)moatAdEvent.\u0971());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean \u02cb(Map<String, String> map, View view) {
        try {
            this.\u02cb();
            this.\u02cf();
            if (view == null) {
                b.\u02cf(3, "BaseVideoTracker", this, "trackVideoAd received null video view instance");
            }
            this.\u02cf\u0971 = map;
            this.\u02bc = new WeakReference((Object)view);
            this.\u02ce();
            Object[] arrobject = new Object[]{new JSONObject(map).toString(), b.\u0971(view)};
            String string = String.format((String)"trackVideoAd tracking ids: %s | view: %s", (Object[])arrobject);
            b.\u02cf(3, "BaseVideoTracker", this, string);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.\u02ca());
            stringBuilder.append(" ");
            stringBuilder.append(string);
            b.\u02ce("[SUCCESS] ", stringBuilder.toString());
            if (this.\u02ca != null) {
                this.\u02ca.onTrackingStarted(this.\u02bd());
            }
            return true;
        }
        catch (Exception exception) {
            this.\u0971("trackVideoAd", exception);
            return false;
        }
    }

    @Override
    final void \u02ce() throws o {
        super.changeTargetView((View)this.\u02bc.get());
        super.\u02ce();
        HashMap hashMap = this.\u02ca\u0971();
        Integer n2 = (Integer)hashMap.get((Object)"width");
        Integer n3 = (Integer)hashMap.get((Object)"height");
        Integer n4 = (Integer)hashMap.get((Object)"duration");
        b.\u02cf(3, "BaseVideoTracker", this, String.format((Locale)Locale.ROOT, (String)"Player metadata: height = %d, width = %d, duration = %d", (Object[])new Object[]{n3, n2, n4}));
        this.\u141d\u0971.\u02ce(this.\u0971\u02ce, this.\u02cf\u0971, n2, n3, n4);
    }

    @Override
    void \u02cf(List<String> list) throws o {
        if (this.\u02cf\u0971 == null) {
            list.add((Object)"Null adIds object");
        }
        if (list.isEmpty()) {
            super.\u02cf(list);
            return;
        }
        throw new o(TextUtils.join((CharSequence)" and ", list));
    }

    final Double \u02cf\u0971() {
        return this.\u02cb\u0971;
    }

    final boolean \u037a() {
        return this.\u02bb.containsKey((Object)((Object)MoatAdEventType.AD_EVT_COMPLETE)) || this.\u02bb.containsKey((Object)((Object)MoatAdEventType.AD_EVT_STOPPED)) || this.\u02bb.containsKey((Object)((Object)MoatAdEventType.AD_EVT_SKIPPED));
        {
        }
    }

    final void \u0971\u02cb() {
        if (!this.\u037a) {
            this.\u037a = true;
            Runnable runnable = new Runnable(this){
                private /* synthetic */ d \u02ca;
                {
                    this.\u02ca = d2;
                }

                public final void run() {
                    try {
                        b.\u02cf(3, "BaseVideoTracker", this, "Shutting down.");
                        b b2 = d.\u02ce(this.\u02ca);
                        b.\u02cf(3, "GlobalWebView", b2, "Cleaning up");
                        b2.\u02cb.\u02ca();
                        b2.\u02cb = null;
                        b2.\u02cf.destroy();
                        b2.\u02cf = null;
                        d.\u02cb(this.\u02ca);
                        return;
                    }
                    catch (Exception exception) {
                        o.\u0971(exception);
                        return;
                    }
                }
            };
            this.\u02ca\u0971.postDelayed(runnable, 500L);
        }
    }

    final Double \u141d() {
        return this.\u02cb\u0971 * p.\u0971();
    }
}

