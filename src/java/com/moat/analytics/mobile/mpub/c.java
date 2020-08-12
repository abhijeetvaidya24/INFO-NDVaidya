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
package com.moat.analytics.mobile.mpub;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.moat.analytics.mobile.mpub.MoatAdEvent;
import com.moat.analytics.mobile.mpub.MoatAdEventType;
import com.moat.analytics.mobile.mpub.TrackerListener;
import com.moat.analytics.mobile.mpub.VideoTrackerListener;
import com.moat.analytics.mobile.mpub.a;
import com.moat.analytics.mobile.mpub.b;
import com.moat.analytics.mobile.mpub.c;
import com.moat.analytics.mobile.mpub.g;
import com.moat.analytics.mobile.mpub.j;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import com.moat.analytics.mobile.mpub.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

abstract class c
extends b {
    static final MoatAdEventType[] g;
    final Map<MoatAdEventType, Integer> h;
    final Handler i;
    Map<String, String> j;
    WeakReference<View> k;
    private final Set<MoatAdEventType> l;
    private VideoTrackerListener m;
    private boolean n;
    private Double o;
    private final g p;
    private final String q;

    static {
        MoatAdEventType[] arrmoatAdEventType = new MoatAdEventType[]{MoatAdEventType.AD_EVT_FIRST_QUARTILE, MoatAdEventType.AD_EVT_MID_POINT, MoatAdEventType.AD_EVT_THIRD_QUARTILE};
        g = arrmoatAdEventType;
    }

    c(String string) {
        super(null, false, true);
        p.a(3, "BaseVideoTracker", this, "Initializing.");
        this.q = string;
        this.p = new g((Context)a.a(), g.a.b);
        super.a(this.p.b);
        try {
            super.a(this.p.a);
        }
        catch (m m2) {
            this.a = m2;
        }
        this.h = new HashMap();
        this.l = new HashSet();
        this.i = new Handler();
        this.n = false;
        this.o = 1.0;
    }

    static /* synthetic */ VideoTrackerListener a(c c2, VideoTrackerListener videoTrackerListener) {
        c2.m = videoTrackerListener;
        return videoTrackerListener;
    }

    static /* synthetic */ g a(c c2) {
        return c2.p;
    }

    private static boolean a(MoatAdEventType moatAdEventType) {
        return moatAdEventType == MoatAdEventType.AD_EVT_COMPLETE || moatAdEventType == MoatAdEventType.AD_EVT_STOPPED || moatAdEventType == MoatAdEventType.AD_EVT_SKIPPED;
        {
        }
    }

    private void b(MoatAdEvent moatAdEvent) {
        MoatAdEventType moatAdEventType;
        JSONObject jSONObject = this.a(moatAdEvent);
        Object[] arrobject = new Object[]{jSONObject.toString()};
        p.a(3, "BaseVideoTracker", this, String.format((String)"Received event: %s", (Object[])arrobject));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a());
        Object[] arrobject2 = new Object[]{jSONObject.toString()};
        stringBuilder.append(String.format((String)" Received event: %s", (Object[])arrobject2));
        p.a("[SUCCESS] ", stringBuilder.toString());
        if (this.e() && this.c != null) {
            this.c.a(this.p.c, jSONObject);
            if (!this.l.contains((Object)moatAdEvent.d)) {
                this.l.add((Object)moatAdEvent.d);
                VideoTrackerListener videoTrackerListener = this.m;
                if (videoTrackerListener != null) {
                    videoTrackerListener.onVideoEventReported(moatAdEvent.d);
                }
            }
        }
        if (c.a(moatAdEventType = moatAdEvent.d)) {
            this.h.put((Object)moatAdEventType, (Object)1);
            if (this.c != null) {
                this.c.c(this);
            }
            this.l();
        }
    }

    JSONObject a(MoatAdEvent moatAdEvent) {
        if (Double.isNaN((double)moatAdEvent.c)) {
            moatAdEvent.c = this.o;
        }
        return new JSONObject(moatAdEvent.a());
    }

    @Override
    void a(List<String> list) {
        if (this.j == null) {
            list.add((Object)"Null adIds object");
        }
        if (list.isEmpty()) {
            super.a(list);
            return;
        }
        throw new m(TextUtils.join((CharSequence)" and ", list));
    }

    boolean a(Integer n2, Integer n3) {
        int n4 = Math.abs((int)(n3 - n2));
        double d2 = n3.intValue();
        Double.isNaN((double)d2);
        double d3 = Math.min((double)750.0, (double)(d2 * 0.05));
        return (double)n4 <= d3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(Map<String, String> map, View view) {
        try {
            this.c();
            this.d();
            if (view == null) {
                p.a(3, "BaseVideoTracker", this, "trackVideoAd received null video view instance");
            }
            this.j = map;
            this.k = new WeakReference((Object)view);
            this.b();
            Object[] arrobject = new Object[]{new JSONObject(map).toString(), p.a(view)};
            String string = String.format((String)"trackVideoAd tracking ids: %s | view: %s", (Object[])arrobject);
            p.a(3, "BaseVideoTracker", this, string);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a());
            stringBuilder.append(" ");
            stringBuilder.append(string);
            p.a("[SUCCESS] ", stringBuilder.toString());
            if (this.d != null) {
                this.d.onTrackingStarted(this.g());
            }
            return true;
        }
        catch (Exception exception) {
            this.a("trackVideoAd", exception);
            return false;
        }
    }

    @Override
    void b() {
        super.changeTargetView((View)this.k.get());
        super.b();
        Map<String, Object> map = this.i();
        Integer n2 = (Integer)map.get((Object)"width");
        Integer n3 = (Integer)map.get((Object)"height");
        Integer n4 = (Integer)map.get((Object)"duration");
        p.a(3, "BaseVideoTracker", this, String.format((Locale)Locale.ROOT, (String)"Player metadata: height = %d, width = %d, duration = %d", (Object[])new Object[]{n3, n2, n4}));
        this.p.a(this.q, this.j, n2, n3, n4);
    }

    @Override
    public void changeTargetView(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("changing view to ");
        stringBuilder.append(p.a(view));
        p.a(3, "BaseVideoTracker", this, stringBuilder.toString());
        this.k = new WeakReference((Object)view);
        try {
            super.changeTargetView(view);
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }

    public void dispatchEvent(MoatAdEvent moatAdEvent) {
        try {
            this.b(moatAdEvent);
            return;
        }
        catch (Exception exception) {
            m.a(exception);
            return;
        }
    }

    abstract Map<String, Object> i();

    Double j() {
        return this.k() * s.a();
    }

    Double k() {
        return this.o;
    }

    void l() {
        if (!this.n) {
            this.n = true;
            Runnable runnable = new Runnable(this){
                final /* synthetic */ c a;
                {
                    this.a = c2;
                }

                public void run() {
                    try {
                        p.a(3, "BaseVideoTracker", this, "Shutting down.");
                        c.a(this.a).a();
                        c.a(this.a, null);
                        return;
                    }
                    catch (Exception exception) {
                        m.a(exception);
                        return;
                    }
                }
            };
            this.i.postDelayed(runnable, 500L);
        }
    }

    boolean m() {
        return this.h.containsKey((Object)((Object)MoatAdEventType.AD_EVT_COMPLETE)) || this.h.containsKey((Object)((Object)MoatAdEventType.AD_EVT_STOPPED)) || this.h.containsKey((Object)((Object)MoatAdEventType.AD_EVT_SKIPPED));
        {
        }
    }

    public void removeVideoListener() {
        this.m = null;
    }

    public void setPlayerVolume(Double d2) {
        Double d3 = this.j();
        if (!d2.equals((Object)this.o)) {
            p.a(3, "BaseVideoTracker", this, String.format((Locale)Locale.ROOT, (String)"player volume changed to %f ", (Object[])new Object[]{d2}));
            this.o = d2;
            if (!d3.equals((Object)this.j())) {
                this.dispatchEvent(new MoatAdEvent(MoatAdEventType.AD_EVT_VOLUME_CHANGE, MoatAdEvent.a, this.o));
            }
        }
    }

    public void setVideoListener(VideoTrackerListener videoTrackerListener) {
        this.m = videoTrackerListener;
    }

    @Override
    public void stopTracking() {
        try {
            super.stopTracking();
            this.l();
            if (this.m != null) {
                this.m = null;
                return;
            }
        }
        catch (Exception exception) {
            m.a(exception);
        }
    }
}

