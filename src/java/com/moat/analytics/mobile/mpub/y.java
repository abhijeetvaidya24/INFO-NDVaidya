/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.StringBuilder
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.mpub;

import android.view.View;
import com.moat.analytics.mobile.mpub.MoatAdEvent;
import com.moat.analytics.mobile.mpub.MoatAdEventType;
import com.moat.analytics.mobile.mpub.ReactiveVideoTracker;
import com.moat.analytics.mobile.mpub.c;
import com.moat.analytics.mobile.mpub.m;
import com.moat.analytics.mobile.mpub.p;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

class y
extends c
implements ReactiveVideoTracker {
    private Integer l;

    public y(String string) {
        super(string);
        p.a(3, "ReactiveVideoTracker", this, "Initializing.");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a());
        stringBuilder.append(" created");
        p.a("[SUCCESS] ", stringBuilder.toString());
    }

    @Override
    String a() {
        return "ReactiveVideoTracker";
    }

    @Override
    JSONObject a(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.d == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.b.equals((Object)MoatAdEvent.a) && !this.a(moatAdEvent.b, this.l)) {
            moatAdEvent.d = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.a(moatAdEvent);
    }

    @Override
    void a(List<String> list) {
        if (this.l >= 1000) {
            super.a(list);
            return;
        }
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{this.l};
        throw new m(String.format((Locale)locale, (String)"Invalid duration = %d. Please make sure duration is in milliseconds.", (Object[])arrobject));
    }

    @Override
    Map<String, Object> i() {
        Integer n2;
        HashMap hashMap = new HashMap();
        View view = (View)this.k.get();
        Integer n3 = 0;
        if (view != null) {
            n3 = view.getWidth();
            n2 = view.getHeight();
        } else {
            n2 = n3;
        }
        hashMap.put((Object)"duration", (Object)this.l);
        hashMap.put((Object)"width", (Object)n3);
        hashMap.put((Object)"height", (Object)n2);
        return hashMap;
    }

    @Override
    public boolean trackVideoAd(Map<String, String> map, Integer n2, View view) {
        try {
            this.c();
            this.d();
            this.l = n2;
            boolean bl = super.a(map, view);
            return bl;
        }
        catch (Exception exception) {
            this.a("trackVideoAd", exception);
            return false;
        }
    }
}

