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
package com.moat.analytics.mobile.ogury;

import com.moat.analytics.mobile.ogury.MoatAdEventType;
import com.moat.analytics.mobile.ogury.s;
import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final Double VOLUME_MUTED;
    public static final Double VOLUME_UNMUTED;
    private static final Double \u02cb;
    static final Integer \u02cf;
    private final Double \u02bb;
    Double \u02ca;
    MoatAdEventType \u02ce;
    Integer \u0971;
    private final Long \u141d = System.currentTimeMillis();

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
        this.\u02ce = moatAdEventType;
        this.\u02ca = d2;
        this.\u0971 = n2;
        this.\u02bb = s.\u02cb();
    }

    final Map<String, Object> \u02cb() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)"adVolume", (Object)this.\u02ca);
        hashMap.put((Object)"playhead", (Object)this.\u0971);
        hashMap.put((Object)"aTimeStamp", (Object)this.\u141d);
        hashMap.put((Object)"type", (Object)this.\u02ce.toString());
        hashMap.put((Object)"deviceVolume", (Object)this.\u02bb);
        return hashMap;
    }
}

