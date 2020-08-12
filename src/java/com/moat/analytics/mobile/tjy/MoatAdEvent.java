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
package com.moat.analytics.mobile.tjy;

import com.moat.analytics.mobile.tjy.MoatAdEventType;
import java.util.HashMap;
import java.util.Map;

public class MoatAdEvent {
    public static final String EVENT_AD_VOLUME = "adVolume";
    public static final String EVENT_PLAY_HEAD = "playhead";
    public static final String EVENT_TS = "aTimeStamp";
    public static final String EVENT_TYPE = "type";
    public static final Integer TIME_UNAVAILABLE = Integer.MIN_VALUE;
    public static final Double VOLUME_UNAVAILABLE = Double.NaN;
    private Long a = System.currentTimeMillis();
    public Integer adPlayhead;
    public Double adVolume;
    public MoatAdEventType eventType;

    public MoatAdEvent(MoatAdEventType moatAdEventType) {
        this(moatAdEventType, TIME_UNAVAILABLE, VOLUME_UNAVAILABLE);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer n2) {
        this(moatAdEventType, n2, VOLUME_UNAVAILABLE);
    }

    public MoatAdEvent(MoatAdEventType moatAdEventType, Integer n2, Double d2) {
        this.eventType = moatAdEventType;
        this.adVolume = d2;
        this.adPlayhead = n2;
    }

    public long getTimeStamp() {
        return this.a;
    }

    public Map toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put((Object)EVENT_AD_VOLUME, (Object)this.adVolume);
        hashMap.put((Object)EVENT_PLAY_HEAD, (Object)this.adPlayhead);
        hashMap.put((Object)EVENT_TS, (Object)this.a);
        hashMap.put((Object)EVENT_TYPE, (Object)this.eventType.toString());
        return hashMap;
    }
}

