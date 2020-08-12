/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.ironsource.mediationsdk.model;

public final class PlacementCappingType
extends Enum<PlacementCappingType> {
    private static final /* synthetic */ PlacementCappingType[] $VALUES;
    public static final /* enum */ PlacementCappingType PER_DAY = new PlacementCappingType("d");
    public static final /* enum */ PlacementCappingType PER_HOUR = new PlacementCappingType("h");
    public String value;

    static {
        PlacementCappingType[] arrplacementCappingType = new PlacementCappingType[]{PER_DAY, PER_HOUR};
        $VALUES = arrplacementCappingType;
    }

    private PlacementCappingType(String string2) {
        this.value = string2;
    }

    public static PlacementCappingType valueOf(String string) {
        return (PlacementCappingType)Enum.valueOf(PlacementCappingType.class, (String)string);
    }

    public static PlacementCappingType[] values() {
        return (PlacementCappingType[])$VALUES.clone();
    }

    public String toString() {
        return this.value;
    }
}

