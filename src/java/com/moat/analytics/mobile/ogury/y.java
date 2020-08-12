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
package com.moat.analytics.mobile.ogury;

import android.view.View;
import com.moat.analytics.mobile.ogury.MoatAdEvent;
import com.moat.analytics.mobile.ogury.MoatAdEventType;
import com.moat.analytics.mobile.ogury.ReactiveVideoTracker;
import com.moat.analytics.mobile.ogury.e;
import com.moat.analytics.mobile.ogury.l;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

final class y
extends e
implements ReactiveVideoTracker {
    private Integer \u02cb\u0971;

    public y(String string) {
        super(string);
        e.1.\u02cb(3, "ReactiveVideoTracker", this, "Initializing.");
        e.1.\u0971("[SUCCESS] ", "ReactiveVideoTracker created");
    }

    @Override
    public final boolean trackVideoAd(Map<String, String> map, Integer n2, View view) {
        try {
            this.\u0971();
            this.\u02cb();
            this.\u02cb\u0971 = n2;
            boolean bl = super.\u02cb(map, view);
            return bl;
        }
        catch (Exception exception) {
            this.\u02cb("trackVideoAd", exception);
            return false;
        }
    }

    @Override
    final JSONObject \u02ca(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.\u02ce == MoatAdEventType.AD_EVT_COMPLETE && !moatAdEvent.\u0971.equals((Object)MoatAdEvent.\u02cf) && !y.\u0971(moatAdEvent.\u0971, this.\u02cb\u0971)) {
            moatAdEvent.\u02ce = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.\u02ca(moatAdEvent);
    }

    @Override
    final void \u02ca(List<String> list) throws l {
        if (this.\u02cb\u0971 >= 1000) {
            super.\u02ca(list);
            return;
        }
        Locale locale = Locale.ROOT;
        Object[] arrobject = new Object[]{this.\u02cb\u0971};
        throw new l(String.format((Locale)locale, (String)"Invalid duration = %d. Please make sure duration is in milliseconds.", (Object[])arrobject));
    }

    @Override
    final String \u02cf() {
        return "ReactiveVideoTracker";
    }

    @Override
    final Map<String, Object> \u141d() throws l {
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
        hashMap.put((Object)"duration", (Object)this.\u02cb\u0971);
        hashMap.put((Object)"width", (Object)n3);
        hashMap.put((Object)"height", (Object)n2);
        return hashMap;
    }
}

