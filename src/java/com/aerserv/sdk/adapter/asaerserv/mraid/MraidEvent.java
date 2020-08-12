/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 *  java.util.Map
 */
package com.aerserv.sdk.adapter.asaerserv.mraid;

import java.util.HashMap;
import java.util.Map;

public final class MraidEvent
extends Enum<MraidEvent> {
    private static final /* synthetic */ MraidEvent[] $VALUES;
    public static final /* enum */ MraidEvent ERROR = new MraidEvent("error");
    public static final /* enum */ MraidEvent READY = new MraidEvent("ready");
    public static final /* enum */ MraidEvent SIZE_CHANGE = new MraidEvent("sizeChange");
    public static final /* enum */ MraidEvent STATE_CHANGE = new MraidEvent("stateChange");
    public static final /* enum */ MraidEvent VIEWABLE_CHANGE = new MraidEvent("viewableChange");
    private static Map<String, MraidEvent> lookup;
    private String name;

    static {
        MraidEvent[] arrmraidEvent = new MraidEvent[]{ERROR, READY, SIZE_CHANGE, STATE_CHANGE, VIEWABLE_CHANGE};
        $VALUES = arrmraidEvent;
        lookup = new HashMap();
        for (MraidEvent mraidEvent : MraidEvent.values()) {
            lookup.put((Object)mraidEvent.getName(), (Object)mraidEvent);
        }
    }

    private MraidEvent(String string2) {
        this.name = string2;
    }

    public static MraidEvent fromName(String string) {
        return (MraidEvent)((Object)lookup.get((Object)string));
    }

    public static MraidEvent valueOf(String string) {
        return (MraidEvent)Enum.valueOf(MraidEvent.class, (String)string);
    }

    public static MraidEvent[] values() {
        return (MraidEvent[])$VALUES.clone();
    }

    public String getName() {
        return this.name;
    }
}

