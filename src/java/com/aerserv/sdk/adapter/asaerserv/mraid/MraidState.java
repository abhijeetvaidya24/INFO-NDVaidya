/*
 * Decompiled with CFR 0.0.
 * 
 * Could not load the following classes:
 *  java.lang.Enum
 *  java.lang.Object
 *  java.lang.String
 */
package com.aerserv.sdk.adapter.asaerserv.mraid;

public final class MraidState
extends Enum<MraidState> {
    private static final /* synthetic */ MraidState[] $VALUES;
    public static final /* enum */ MraidState DEFAULT;
    public static final /* enum */ MraidState EXPANDED;
    public static final /* enum */ MraidState HIDDEN;
    public static final /* enum */ MraidState LOADING;
    public static final /* enum */ MraidState RESIZED;
    private String name;

    static {
        LOADING = new MraidState("loading");
        DEFAULT = new MraidState("default");
        EXPANDED = new MraidState("expanded");
        RESIZED = new MraidState("resized");
        HIDDEN = new MraidState("hidden");
        MraidState[] arrmraidState = new MraidState[]{LOADING, DEFAULT, EXPANDED, RESIZED, HIDDEN};
        $VALUES = arrmraidState;
    }

    private MraidState(String string2) {
        this.name = string2;
    }

    public static MraidState valueOf(String string) {
        return (MraidState)Enum.valueOf(MraidState.class, (String)string);
    }

    public static MraidState[] values() {
        return (MraidState[])$VALUES.clone();
    }

    public String getName() {
        return this.name;
    }
}

