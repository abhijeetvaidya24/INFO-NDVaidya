/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  com.moat.analytics.mobile.iro.p
 *  java.lang.Double
 *  java.lang.Integer
 *  java.lang.Long
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.System
 *  java.util.HashMap
 *  java.util.Map
 */
package com.moat.analytics.mobile.iro;

import com.moat.analytics.mobile.iro.MoatAdEventType;
import com.moat.analytics.mobile.iro.p;
import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED;
    public static final Double VOLUME_UNMUTED;
    private static final Double \u02cb;
    static final Integer \u02cf;
    private final Long \u02bc = System.currentTimeMillis();
    private final Double \u02bd;
    Integer \u02ca;
    Double \u02ce;
    MoatAdEventType \u0971;

    static {
        \u02cf = Integer.MIN_VALUE;
        \u02cb = Double.NaN;
        VOLUME_MUTED = 0.0;
        VOLUME_UNMUTED = 1.0;
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, \u02cf, \u02cb);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer n2) {
        this(moatAdEventType, n2, \u02cb);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer n2, Double d2) {
        this.\u0971 = moatAdEventType;
        this.\u02ce = d2;
        this.\u02ca = n2;
        this.\u02bd = p.\u0971();
    }

    final Map<String, Object> \u0971() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"adVolume", (Object)this.\u02ce);
        hashMap.put((Object)"playhead", (Object)this.\u02ca);
        hashMap.put((Object)"aTimeStamp", (Object)this.\u02bc);
        hashMap.put((Object)"type", (Object)this.\u0971.toString());
        hashMap.put((Object)"deviceVolume", (Object)this.\u02bd);
        return hashMap;
    }
}

