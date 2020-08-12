/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  java.lang.Integer
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.ref.WeakReference
 *  java.util.HashMap
 *  java.util.Map
 *  org.json.JSONObject
 */
package com.moat.analytics.mobile.tjy;

import android.view.View;
import com.moat.analytics.mobile.tjy.MoatAdEvent;
import com.moat.analytics.mobile.tjy.MoatAdEventType;
import com.moat.analytics.mobile.tjy.ReactiveVideoTracker;
import com.moat.analytics.mobile.tjy.a;
import com.moat.analytics.mobile.tjy.ap;
import com.moat.analytics.mobile.tjy.f;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class bd
extends f
implements ReactiveVideoTracker {
    private Integer j;

    public bd(String string, a a2, ap ap2) {
        super(string, a2, ap2);
    }

    @Override
    protected Map a() {
        Integer n2;
        HashMap hashMap = new HashMap();
        View view = (View)this.g.get();
        Integer n3 = 0;
        if (view != null) {
            n3 = view.getWidth();
            n2 = view.getHeight();
        } else {
            n2 = n3;
        }
        hashMap.put((Object)"duration", (Object)this.j);
        hashMap.put((Object)"width", (Object)n3);
        hashMap.put((Object)"height", (Object)n2);
        return hashMap;
    }

    @Override
    protected JSONObject a(MoatAdEvent moatAdEvent) {
        if (moatAdEvent.eventType == MoatAdEventType.AD_EVT_COMPLETE && !this.a(moatAdEvent.adPlayhead, this.j)) {
            moatAdEvent.eventType = MoatAdEventType.AD_EVT_STOPPED;
        }
        return super.a(moatAdEvent);
    }

    @Override
    public boolean trackVideoAd(Map map, Integer n2, View view) {
        if (n2 < 1000) {
            this.a(String.format((String)"Invalid duration = %d. Please make sure duration is in milliseconds.", (Object[])new Object[]{n2}));
            return false;
        }
        this.j = n2;
        return super.a(map, new Object(), view);
    }
}

