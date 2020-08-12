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
package com.moat.analytics.mobile.cha;

import com.moat.analytics.mobile.cha.MoatAdEventType;
import com.moat.analytics.mobile.cha.r;
import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED;
    public static final Double VOLUME_UNMUTED;
    static final Integer \u02cb;
    private static final Double \u02ce;
    private final Long \u02bd = System.currentTimeMillis();
    Double \u02ca;
    Integer \u02cf;
    MoatAdEventType \u0971;
    private final Double \u141d;

    static {
        \u02cb = Integer.MIN_VALUE;
        \u02ce = Double.NaN;
        VOLUME_MUTED = 0.0;
        VOLUME_UNMUTED = 1.0;
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, \u02cb, \u02ce);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer n2) {
        this(moatAdEventType, n2, \u02ce);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer n2, Double d2) {
        this.\u0971 = moatAdEventType;
        this.\u02ca = d2;
        this.\u02cf = n2;
        this.\u141d = r.\u0971();
    }

    final Map<String, Object> \u02cf() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"adVolume", (Object)this.\u02ca);
        hashMap.put((Object)"playhead", (Object)this.\u02cf);
        hashMap.put((Object)"aTimeStamp", (Object)this.\u02bd);
        hashMap.put((Object)"type", (Object)this.\u0971.toString());
        hashMap.put((Object)"deviceVolume", (Object)this.\u141d);
        return hashMap;
    }
}

