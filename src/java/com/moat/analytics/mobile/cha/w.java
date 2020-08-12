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
package com.moat.analytics.mobile.cha;

import android.view.View;
import com.moat.analytics.mobile.cha.MoatAdEvent;
import com.moat.analytics.mobile.cha.MoatAdEventType;
import com.moat.analytics.mobile.cha.ReactiveVideoTracker;
import com.moat.analytics.mobile.cha.a;
import com.moat.analytics.mobile.cha.b;
import com.moat.analytics.mobile.cha.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

final class w
extends b
implements ReactiveVideoTracker {
    private Integer \u02cb\u0971;

    public w(String string) {
        super(string);
        a.\u02cf(3, "ReactiveVideoTracker", this, "Initializing.");
        a.\u02ca("[SUCCESS] ", "ReactiveVideoTracker created");
    }

    @Override
    public final boolean trackVideoAd(Map<String, String> map, Integer n2, View view) {
        try {
            this.\u02ce();
            this.\u0971();
            this.\u02cb\u0971 = n2;
            boolean bl = super.\u0971(map, view);
            return bl;
        }
        catch (Exception exception) {
            this.\u0971("trackVideoAd", exception);
            return false;
        }
    }

    @Override
    final String \u02cb() {
        return "ReactiveVideoTracker";
    }

    @Override
    final void \u02cb(List<String> list) throws o {
        if (this.\u02cb\u0971 >= 1000) {
            super.\u02cb(list);
            return;
        }
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{this.\u02cb\u0971};
        throw new o(String.format((Locale)locale, (String)"Invalid duration = %d. Please make sure duration is in milliseconds.", (Object[])arrobject));
    }

    @Override
    final JSONObject \u02ce(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.\u0971 == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.\u02cf.equals((Object)MoatAdEvent.\u02cb) && !w.\u02cb(moatAdEvent.\u02cf, this.\u02cb\u0971)) {
            moatAdEvent.\u0971 = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.\u02ce(moatAdEvent);
    }

    @Override
    final Map<String, Object> \u141d() throws o {
        Integer n2;
        HashMap hashMap = new HashMap();
        View view = (View)this.\u02ca\u0971.get();
        Integer n3 = 0;
        if (view != null) {
            n3 = view.getWidth();
            n2 = view.getHeight();
        } else {
            n2 = n3;
        }
        hashMap.put((Object)"duration", (Object)this.\u02cb\u0971);
        hashMap.put((Object)"width", (Object)n3);
        hashMap.put((Object)"height", (Object)n2);
        return hashMap;
    }
}

