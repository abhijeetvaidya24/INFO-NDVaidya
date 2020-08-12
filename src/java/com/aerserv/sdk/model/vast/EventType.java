/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.EnumSet
 *  java.util.HashMap
 */
package com.aerserv.sdk.model.vast;

import java.util.EnumSet;
import java.util.HashMap;

public final class EventType
extends Enum<EventType> {
    private static final /* synthetic */ EventType[] $VALUES;
    public static final /* enum */ EventType ACCEPT_INVITATION;
    public static final /* enum */ EventType CLOSE;
    public static final /* enum */ EventType COLLAPSE;
    public static final /* enum */ EventType COMPLETE;
    public static final /* enum */ EventType CREATIVE_VIEW;
    public static final /* enum */ EventType EXIT_FULLSCREEN;
    public static final /* enum */ EventType EXPAND;
    public static final /* enum */ EventType FIRST_QUARTILE;
    public static final /* enum */ EventType FULLSCREEN;
    public static final /* enum */ EventType MID_POINT;
    public static final /* enum */ EventType MUTE;
    public static final /* enum */ EventType PAUSE;
    public static final /* enum */ EventType PROGRESS;
    public static final /* enum */ EventType RESUME;
    public static final /* enum */ EventType REWIND;
    public static final /* enum */ EventType SKIP;
    public static final /* enum */ EventType START;
    public static final /* enum */ EventType THIRD_QUARTILE;
    public static final /* enum */ EventType UNMUTE;
    private static HashMap<String, EventType> eventTypeHashMap;
    private String eventString;

    static {
        CREATIVE_VIEW = new EventType("creativeView");
        START = new EventType("start");
        FIRST_QUARTILE = new EventType("firstQuartile");
        MID_POINT = new EventType("midpoint");
        THIRD_QUARTILE = new EventType("thirdQuartile");
        COMPLETE = new EventType("complete");
        MUTE = new EventType("mute");
        UNMUTE = new EventType("unmute");
        PAUSE = new EventType("pause");
        REWIND = new EventType("rewind");
        RESUME = new EventType("resume");
        FULLSCREEN = new EventType("fullscreen");
        EXIT_FULLSCREEN = new EventType("exitFullscreen");
        EXPAND = new EventType("expand");
        COLLAPSE = new EventType("collapse");
        ACCEPT_INVITATION = new EventType("acceptInvitation");
        CLOSE = new EventType("close");
        SKIP = new EventType("skip");
        PROGRESS = new EventType("progress");
        EventType[] arreventType = new EventType[]{CREATIVE_VIEW, START, FIRST_QUARTILE, MID_POINT, THIRD_QUARTILE, COMPLETE, MUTE, UNMUTE, PAUSE, REWIND, RESUME, FULLSCREEN, EXIT_FULLSCREEN, EXPAND, COLLAPSE, ACCEPT_INVITATION, CLOSE, SKIP, PROGRESS};
        $VALUES = arreventType;
        eventTypeHashMap = new HashMap();
        for (EventType eventType : EnumSet.allOf(EventType.class)) {
            eventTypeHashMap.put((Object)eventType.eventString, (Object)eventType);
        }
    }

    private EventType(String string2) {
        this.eventString = string2;
    }

    public static EventType get(String string) {
        return (EventType)((Object)eventTypeHashMap.get((Object)string));
    }

    public static EventType valueOf(String string) {
        return (EventType)Enum.valueOf(EventType.class, (String)string);
    }

    public static EventType[] values() {
        return (EventType[])$VALUES.clone();
    }

    public String getEventString() {
        return this.eventString;
    }
}

