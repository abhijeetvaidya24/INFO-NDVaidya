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
package com.moat.analytics.mobile.cha;

import android.app.Application;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.cha.MoatAdEvent;
import com.moat.analytics.mobile.cha.MoatAdEventType;
import com.moat.analytics.mobile.cha.TrackerListener;
import com.moat.analytics.mobile.cha.VideoTrackerListener;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.b;
import com.moat.analytics.mobile.cha.c;
import com.moat.analytics.mobile.cha.d;
import com.moat.analytics.mobile.cha.j;
import com.moat.analytics.mobile.cha.o;
import com.moat.analytics.mobile.cha.r;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

abstract class b
extends d {
    static final MoatAdEventType[] \u02bb;
    final Map<MoatAdEventType, Integer> \u02bc;
    private final String \u02bc\u0971;
    WeakReference<View> \u02ca\u0971;
    private boolean \u02cb\u0971;
    private Map<String, String> \u02cf\u0971;
    private Double \u037a;
    private VideoTrackerListener \u0971\u02ca;
    private final Set<MoatAdEventType> \u0971\u02cb;
    private final a \u0971\u02ce;
    final Handler \u141d;

    static {
        MoatAdEventType[] arrmoatAdEventType = new MoatAdEventType[]{MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};
        \u02bb = arrmoatAdEventType;
    }

    b(String string) {
        super(null, false, true);
        a.\u02cf(3, "BaseVideoTracker", this, "Initializing.");
        this.\u02bc\u0971 = string;
        this.\u0971\u02ce = new a(c.\u02cf(), a.d.\u02cb);
        this.\u02ce = this.\u0971\u02ce.\u02cf;
        try {
            super.\u0971(this.\u0971\u02ce.\u02cb);
        }
        catch (o o2) {
            this.\u0971 = o2;
        }
        this.\u02bc = new HashMap();
        this.\u0971\u02cb = new HashSet();
        this.\u141d = new Handler();
        this.\u02cb\u0971 = false;
        this.\u037a = 1.0;
    }

    static /* synthetic */ a \u02ca(b b2) {
        return b2.\u0971\u02ce;
    }

    static boolean \u02cb(Integer n2, Integer n3) {
        int n4 = Math.abs((int)(n3 - n2));
        double d2 = n3.intValue();
        Double.isNaN((double)d2);
        double d3 = Math.min((double)750.0, (double)(d2 * 0.05));
        return (double)n4 <= d3;
    }

    static /* synthetic */ VideoTrackerListener \u02cf(b b2) {
        b2.\u0971\u02ca = null;
        return null;
    }

    @Override
    public void changeTargetView(View view) {
        StringBuilder stringBuilder = new StringBuilder("changing view to ");
        stringBuilder.append(a.\u02cf(view));
        a.\u02cf(3, "BaseVideoTracker", this, stringBuilder.toString());
        this.\u02ca\u0971 = new WeakReference((Object)view);
        try {
            super.changeTargetView(view);
            return;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
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
                JSONObject jSONObject = this.\u02ce(moatAdEvent);
                Object[] arrobject = new Object[]{jSONObject.toString()};
                a.\u02cf(3, "BaseVideoTracker", this, String.format((String)"Received event: %s", (Object[])arrobject));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.\u02cb());
                Object[] arrobject2 = new Object[]{jSONObject.toString()};
                stringBuilder.append(String.format((String)" Received event: %s", (Object[])arrobject2));
                a.\u02ca("[SUCCESS] ", stringBuilder.toString());
                if (this.\u02ca() && this.\u02ce != null) {
                    this.\u02ce.\u0971(this.\u0971\u02ce.\u02ca, jSONObject);
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
                o.\u02ce(exception);
                return;
            }
        }
        if (!bl2) return;
        this.\u02bc.put((Object)moatAdEventType, (Object)1);
        if (this.\u02ce != null) {
            this.\u02ce.\u02cb(this);
        }
        this.\u02cf\u0971();
    }

    public void removeVideoListener() {
        this.\u0971\u02ca = null;
    }

    public void setPlayerVolume(Double d2) {
        Double d3 = this.\u037a * r.\u0971();
        if (!d2.equals((Object)this.\u037a)) {
            a.\u02cf(3, "BaseVideoTracker", this, String.format((Locale)Locale.ROOT, (String)"player volume changed to %f ", (Object[])new Object[]{d2}));
            this.\u037a = d2;
            if (!d3.equals((Object)(this.\u037a * r.\u0971()))) {
                this.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.\u02cb, this.\u037a));
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
            this.\u02cf\u0971();
            if (this.\u0971\u02ca != null) {
                this.\u0971\u02ca = null;
            }
            return;
        }
        catch (Exception exception) {
            o.\u02ce(exception);
            return;
        }
    }

    final Double \u02ca\u0971() {
        return this.\u037a * r.\u0971();
    }

    @Override
    void \u02cb(List<String> list) throws o {
        if (this.\u02cf\u0971 == null) {
            list.add((Object)"Null adIds object");
        }
        if (list.isEmpty()) {
            super.\u02cb(list);
            return;
        }
        throw new o(TextUtils.join((CharSequence)" and ", list));
    }

    final boolean \u02cb\u0971() {
        return this.\u02bc.containsKey((Object)MoatAdEventType.AD_EVT_COMPLETE) || this.\u02bc.containsKey((Object)MoatAdEventType.AD_EVT_STOPPED) || this.\u02bc.containsKey((Object)MoatAdEventType.AD_EVT_SKIPPED);
        {
        }
    }

    JSONObject \u02ce(MoatAdEvent moatAdEvent) {
        if (Double.isNaN((double)moatAdEvent.\u02ca)) {
            moatAdEvent.\u02ca = this.\u037a;
        }
        return new JSONObject((Map)moatAdEvent.\u02cf());
    }

    @Override
    final void \u02cf() throws o {
        super.changeTargetView((View)this.\u02ca\u0971.get());
        super.\u02cf();
        HashMap hashMap = this.\u141d();
        Integer n2 = (Integer)hashMap.get((Object)"width");
        Integer n3 = (Integer)hashMap.get((Object)"height");
        Integer n4 = (Integer)hashMap.get((Object)"duration");
        a.\u02cf(3, "BaseVideoTracker", this, String.format((Locale)Locale.ROOT, (String)"Player metadata: height = %d, width = %d, duration = %d", (Object[])new Object[]{n3, n2, n4}));
        this.\u0971\u02ce.\u02ca(this.\u02bc\u0971, this.\u02cf\u0971, n2, n3, n4);
    }

    final void \u02cf\u0971() {
        if (!this.\u02cb\u0971) {
            this.\u02cb\u0971 = true;
            Runnable runnable = new Runnable(this){
                private /* synthetic */ b \u02ca;
                {
                    this.\u02ca = b2;
                }

                public final void run() {
                    try {
                        a.\u02cf(3, "BaseVideoTracker", this, "Shutting down.");
                        a a2 = b.\u02ca(this.\u02ca);
                        a.\u02cf(3, "GlobalWebView", a2, "Cleaning up");
                        a2.\u02cf.\u02ca();
                        a2.\u02cf = null;
                        a2.\u02cb.destroy();
                        a2.\u02cb = null;
                        b.\u02cf(this.\u02ca);
                        return;
                    }
                    catch (Exception exception) {
                        o.\u02ce(exception);
                        return;
                    }
                }
            };
            this.\u141d.postDelayed(runnable, 500L);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean \u0971(Map<String, String> map, View view) {
        try {
            this.\u02ce();
            this.\u0971();
            if (view == null) {
                a.\u02cf(3, "BaseVideoTracker", this, "trackVideoAd received null video view instance");
            }
            this.\u02cf\u0971 = map;
            this.\u02ca\u0971 = new WeakReference((Object)view);
            this.\u02cf();
            Object[] arrobject = new Object[]{new JSONObject(map).toString(), a.\u02cf(view)};
            String string = String.format((String)"trackVideoAd tracking ids: %s | view: %s", (Object[])arrobject);
            a.\u02cf(3, "BaseVideoTracker", this, string);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.\u02cb());
            stringBuilder.append(" ");
            stringBuilder.append(string);
            a.\u02ca("[SUCCESS] ", stringBuilder.toString());
            if (this.\u02ca != null) {
                this.\u02ca.onTrackingStarted(this.\u02bb());
            }
            return true;
        }
        catch (Exception exception) {
            this.\u0971("trackVideoAd", exception);
            return false;
        }
    }

    final Double \u0971\u02ca() {
        return this.\u037a;
    }

    abstract Map<String, Object> \u141d() throws o;
}

