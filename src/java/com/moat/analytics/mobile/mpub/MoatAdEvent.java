/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.Map
 */
package com.moat.analytics.mobile.mpub;

import com.moat.analytics.mobile.mpub.MoatAdEventType;
import com.moat.analytics.mobile.mpub.s;
import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED;
    public static final Double VOLUME_UNMUTED;
    static final Integer a;
    private static final Double e;
    Integer b;
    Double c;
    MoatAdEventType d;
    private final Double f;
    private final Long g = System.currentTimeMillis();

    static {
        a = Integer.MIN_VALUE;
        e = Double.NaN;
        VOLUME_MUTED = 0.0;
        VOLUME_UNMUTED = 1.0;
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, a, e);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer n2) {
        this(moatAdEventType, n2, e);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer n2, Double d2) {
        this.d = moatAdEventType;
        this.c = d2;
        this.b = n2;
        this.f = s.a();
    }

    Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"adVolume", (Object)this.c);
        hashMap.put((Object)"playhead", (Object)this.b);
        hashMap.put((Object)"aTimeStamp", (Object)this.g);
        hashMap.put((Object)"type", (Object)this.d.toString());
        hashMap.put((Object)"deviceVolume", (Object)this.f);
        return hashMap;
    }
}

