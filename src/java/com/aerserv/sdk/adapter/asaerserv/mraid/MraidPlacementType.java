/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.adapter.asaerserv.mraid;

public final class MraidPlacementType
extends Enum<MraidPlacementType> {
    private static final /* synthetic */ MraidPlacementType[] $VALUES;
    public static final /* enum */ MraidPlacementType INLINE = new MraidPlacementType("inline");
    public static final /* enum */ MraidPlacementType INTERSTITIAL = new MraidPlacementType("interstitial");
    private String name;

    static {
        MraidPlacementType[] arrmraidPlacementType = new MraidPlacementType[]{INLINE, INTERSTITIAL};
        $VALUES = arrmraidPlacementType;
    }

    private MraidPlacementType(String string2) {
        this.name = string2;
    }

    public static MraidPlacementType valueOf(String string) {
        return (MraidPlacementType)Enum.valueOf(MraidPlacementType.class, (String)string);
    }

    public static MraidPlacementType[] values() {
        return (MraidPlacementType[])$VALUES.clone();
    }

    public String getName() {
        return this.name;
    }
}

