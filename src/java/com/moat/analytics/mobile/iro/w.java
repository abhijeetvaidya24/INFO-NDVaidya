/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Exception
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.List
 *  java.util.Locale
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.iro;

import android.view.View;
import com.moat.analytics.mobile.iro.MoatAdEvent;
import com.moat.analytics.mobile.iro.MoatAdEventType;
import com.moat.analytics.mobile.iro.ReactiveVideoTracker;
import com.moat.analytics.mobile.iro.b;
import com.moat.analytics.mobile.iro.d;
import com.moat.analytics.mobile.iro.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

final class w
extends d
implements ReactiveVideoTracker {
    private Integer \u02cf\u0971;

    public w(String string) {
        super(string);
        b.\u02cf(3, "ReactiveVideoTracker", this, "Initializing.");
        b.\u02ce("[SUCCESS] ", "ReactiveVideoTracker created");
    }

    @Override
    public final boolean trackVideoAd(Map<String, String> map, Integer n2, View view) {
        try {
            this.\u02cb();
            this.\u02cf();
            this.\u02cf\u0971 = n2;
            boolean bl = super.\u02cb(map, view);
            return bl;
        }
        catch (Exception exception) {
            this.\u0971("trackVideoAd", exception);
            return false;
        }
    }

    @Override
    final String \u02ca() {
        return "ReactiveVideoTracker";
    }

    @Override
    final Map<String, Object> \u02ca\u0971() throws o {
        Integer n2;
        HashMap hashMap = new HashMap();
        View view = (View)this.\u02bc.get();
        Integer n3 = 0;
        if (view != null) {
            n3 = view.getWidth();
            n2 = view.getHeight();
        } else {
            n2 = n3;
        }
        hashMap.put((Object)"duration", (Object)this.\u02cf\u0971);
        hashMap.put((Object)"width", (Object)n3);
        hashMap.put((Object)"height", (Object)n2);
        return hashMap;
    }

    @Override
    final JSONObject \u02cb(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.\u0971 == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.\u02ca.equals((Object)MoatAdEvent.\u02cf) && !w.\u02cb(moatAdEvent.\u02ca, this.\u02cf\u0971)) {
            moatAdEvent.\u0971 = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.\u02cb(moatAdEvent);
    }

    @Override
    final void \u02cf(List<String> list) throws o {
        if (this.\u02cf\u0971 >= 1000) {
            super.\u02cf(list);
            return;
        }
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{this.\u02cf\u0971};
        throw new o(String.format((Locale)locale, (String)"Invalid duration = %d. Please make sure duration is in milliseconds.", (Object[])arrobject));
    }
}

