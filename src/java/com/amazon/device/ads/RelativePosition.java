/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashMap
 */
package com.amazon.device.ads;

import java.util.HashMap;

final class RelativePosition
extends Enum<RelativePosition> {
    private static final /* synthetic */ RelativePosition[] $VALUES;
    public static final /* enum */ RelativePosition BOTTOM_CENTER;
    public static final /* enum */ RelativePosition BOTTOM_LEFT;
    public static final /* enum */ RelativePosition BOTTOM_RIGHT;
    public static final /* enum */ RelativePosition CENTER;
    private static final HashMap<String, RelativePosition> POSITIONS;
    public static final /* enum */ RelativePosition TOP_CENTER;
    public static final /* enum */ RelativePosition TOP_LEFT;
    public static final /* enum */ RelativePosition TOP_RIGHT;

    static {
        TOP_LEFT = new RelativePosition();
        TOP_RIGHT = new RelativePosition();
        CENTER = new RelativePosition();
        BOTTOM_LEFT = new RelativePosition();
        BOTTOM_RIGHT = new RelativePosition();
        TOP_CENTER = new RelativePosition();
        BOTTOM_CENTER = new RelativePosition();
        RelativePosition[] arrrelativePosition = new RelativePosition[]{TOP_LEFT, TOP_RIGHT, CENTER, BOTTOM_LEFT, BOTTOM_RIGHT, TOP_CENTER, BOTTOM_CENTER};
        $VALUES = arrrelativePosition;
        POSITIONS = new HashMap();
        POSITIONS.put((Object)"top-left", (Object)TOP_LEFT);
        POSITIONS.put((Object)"top-right", (Object)TOP_RIGHT);
        POSITIONS.put((Object)"top-center", (Object)TOP_CENTER);
        POSITIONS.put((Object)"bottom-left", (Object)BOTTOM_LEFT);
        POSITIONS.put((Object)"bottom-right", (Object)BOTTOM_RIGHT);
        POSITIONS.put((Object)"bottom-center", (Object)BOTTOM_CENTER);
        POSITIONS.put((Object)"center", (Object)CENTER);
    }

    public static RelativePosition fromString(String string) {
        return (RelativePosition)((Object)POSITIONS.get((Object)string));
    }

    public static RelativePosition valueOf(String string) {
        return (RelativePosition)Enum.valueOf(RelativePosition.class, (String)string);
    }

    public static RelativePosition[] values() {
        return (RelativePosition[])$VALUES.clone();
    }
}

